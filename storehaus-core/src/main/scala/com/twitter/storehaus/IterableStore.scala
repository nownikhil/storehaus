/*
 * Copyright 2013 Twitter Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twitter.storehaus

import com.twitter.util.{ Future, Promise, Return }
import com.twitter.concurrent.Spool
import com.twitter.concurrent.Spool.*::

object IterableStore {
  /** Factory method to create a IterableStore from a Map. */
  def fromMap[K, V](m: Map[K, V]): IterableStore[K, V] = new MapStore(m)

  /** Helper method to convert Iterator to Spool. */
  def iteratorToSpool[K, V](it: Iterator[(K, V)]): Future[Spool[(K, V)]] = {
    val s = new Promise[Spool[(K, V)]]
    fillSpool(it, s)
    s
  }

  protected def fillSpool[K, V](it: Iterator[(K, V)], s: Promise[Spool[(K, V)]]): Unit = {
    if (it.isEmpty) {
      s() = Return(Spool.empty[(K, V)])
    } else {
      val next = new Promise[Spool[(K, V)]]
      // *:: for lazy/deferred tail
      s() = Return(it.next *:: next)
      fillSpool(it, next)
    }
  }
}
import IterableStore._

/**
 * Trait for stores that allow iterating over their key-value pairs.
 */
trait IterableStore[+K, +V] {

  /** Returns a lazy Spool that wraps the store's keyspace. */
  def getAll: Future[Spool[(K, V)]] =
    multiGetAll.flatMap { batchSpool =>
      batchSpool.flatMap { seq =>
        iteratorToSpool(seq.iterator)
      }
    }

  /** Batched version of getAll. Useful for paging stores. */
  def multiGetAll: Future[Spool[Seq[(K, V)]]] =
    getAll.map { spool =>
      spool.map(Seq(_))
    }
}

