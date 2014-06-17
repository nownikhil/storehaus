/*
 * Copyright 2014 Twitter inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package kafka;
@SuppressWarnings("all")
public class DataTuple extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DataTuple\",\"namespace\":\"kafka\",\"fields\":[{\"name\":\"value\",\"type\":\"long\"},{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":\"long\"}]}");
    @Deprecated public long value;
    @Deprecated public CharSequence key;
    @Deprecated public long timestamp;

    /**
     * Default constructor.
     */
    public DataTuple() {}

    /**
     * All-args constructor.
     */
    public DataTuple(Long value, CharSequence key, Long timestamp) {
        this.value = value;
        this.key = key;
        this.timestamp = timestamp;
    }

    public org.apache.avro.Schema getSchema() { return SCHEMA$; }
    // Used by DatumWriter.  Applications should not call.
    public Object get(int field$) {
        switch (field$) {
            case 0: return value;
            case 1: return key;
            case 2: return timestamp;
            default: throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }
    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value="unchecked")
    public void put(int field$, Object value$) {
        switch (field$) {
            case 0: value = (Long)value$; break;
            case 1: key = (CharSequence)value$; break;
            case 2: timestamp = (Long)value$; break;
            default: throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    /**
     * Gets the value of the 'value' field.
     */
    public Long getValue() {
        return value;
    }

    /**
     * Sets the value of the 'value' field.
     * @param value the value to set.
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * Gets the value of the 'key' field.
     */
    public CharSequence getKey() {
        return key;
    }

    /**
     * Sets the value of the 'key' field.
     * @param value the value to set.
     */
    public void setKey(CharSequence value) {
        this.key = value;
    }

    /**
     * Gets the value of the 'timestamp' field.
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the 'timestamp' field.
     * @param value the value to set.
     */
    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    /** Creates a new DataTuple RecordBuilder */
    public static Builder newBuilder() {
        return new Builder();
    }

    /** Creates a new DataTuple RecordBuilder by copying an existing Builder */
    public static Builder newBuilder(Builder other) {
        return new Builder(other);
    }

    /** Creates a new DataTuple RecordBuilder by copying an existing DataTuple instance */
    public static Builder newBuilder(DataTuple other) {
        return new Builder(other);
    }

    /**
     * RecordBuilder for DataTuple instances.
     */
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DataTuple>
            implements org.apache.avro.data.RecordBuilder<DataTuple> {

        private long value;
        private CharSequence key;
        private long timestamp;

        /** Creates a new Builder */
        private Builder() {
            super(DataTuple.SCHEMA$);
        }

        /** Creates a Builder by copying an existing Builder */
        private Builder(Builder other) {
            super(other);
        }

        /** Creates a Builder by copying an existing DataTuple instance */
        private Builder(DataTuple other) {
            super(DataTuple.SCHEMA$);
            if (isValidValue(fields()[0], other.value)) {
                this.value = (Long) data().deepCopy(fields()[0].schema(), other.value);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.key)) {
                this.key = (CharSequence) data().deepCopy(fields()[1].schema(), other.key);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.timestamp)) {
                this.timestamp = (Long) data().deepCopy(fields()[2].schema(), other.timestamp);
                fieldSetFlags()[2] = true;
            }
        }

        /** Gets the value of the 'value' field */
        public Long getValue() {
            return value;
        }

        /** Sets the value of the 'value' field */
        public Builder setValue(long value) {
            validate(fields()[0], value);
            this.value = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /** Checks whether the 'value' field has been set */
        public boolean hasValue() {
            return fieldSetFlags()[0];
        }

        /** Clears the value of the 'value' field */
        public Builder clearValue() {
            fieldSetFlags()[0] = false;
            return this;
        }

        /** Gets the value of the 'key' field */
        public CharSequence getKey() {
            return key;
        }

        /** Sets the value of the 'key' field */
        public Builder setKey(CharSequence value) {
            validate(fields()[1], value);
            this.key = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /** Checks whether the 'key' field has been set */
        public boolean hasKey() {
            return fieldSetFlags()[1];
        }

        /** Clears the value of the 'key' field */
        public Builder clearKey() {
            key = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        /** Gets the value of the 'timestamp' field */
        public Long getTimestamp() {
            return timestamp;
        }

        /** Sets the value of the 'timestamp' field */
        public Builder setTimestamp(long value) {
            validate(fields()[2], value);
            this.timestamp = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /** Checks whether the 'timestamp' field has been set */
        public boolean hasTimestamp() {
            return fieldSetFlags()[2];
        }

        /** Clears the value of the 'timestamp' field */
        public Builder clearTimestamp() {
            fieldSetFlags()[2] = false;
            return this;
        }

        @Override
        public DataTuple build() {
            try {
                DataTuple record = new DataTuple();
                record.value = fieldSetFlags()[0] ? this.value : (Long) defaultValue(fields()[0]);
                record.key = fieldSetFlags()[1] ? this.key : (CharSequence) defaultValue(fields()[1]);
                record.timestamp = fieldSetFlags()[2] ? this.timestamp : (Long) defaultValue(fields()[2]);
                return record;
            } catch (Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }
}