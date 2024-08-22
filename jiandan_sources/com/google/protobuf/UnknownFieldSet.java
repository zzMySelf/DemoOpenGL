package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public final class UnknownFieldSet implements MessageLite {
    public static final Parser PARSER = new Parser();
    public static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap(), Collections.emptyMap());
    public final Map<Integer, Field> fields;
    public final Map<Integer, Field> fieldsDescending;

    public static final class Builder implements MessageLite.Builder {
        public Map<Integer, Field> fields;
        public Field.Builder lastField;
        public int lastFieldNumber;

        public static Builder create() {
            Builder builder = new Builder();
            builder.reinitialize();
            return builder;
        }

        private Field.Builder getFieldBuilder(int i2) {
            Field.Builder builder = this.lastField;
            if (builder != null) {
                int i3 = this.lastFieldNumber;
                if (i2 == i3) {
                    return builder;
                }
                addField(i3, builder.build());
            }
            if (i2 == 0) {
                return null;
            }
            Field field = this.fields.get(Integer.valueOf(i2));
            this.lastFieldNumber = i2;
            Field.Builder newBuilder = Field.newBuilder();
            this.lastField = newBuilder;
            if (field != null) {
                newBuilder.mergeFrom(field);
            }
            return this.lastField;
        }

        private void reinitialize() {
            this.fields = Collections.emptyMap();
            this.lastFieldNumber = 0;
            this.lastField = null;
        }

        public Builder addField(int i2, Field field) {
            if (i2 != 0) {
                if (this.lastField != null && this.lastFieldNumber == i2) {
                    this.lastField = null;
                    this.lastFieldNumber = 0;
                }
                if (this.fields.isEmpty()) {
                    this.fields = new TreeMap();
                }
                this.fields.put(Integer.valueOf(i2), field);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public Map<Integer, Field> asMap() {
            getFieldBuilder(0);
            return Collections.unmodifiableMap(this.fields);
        }

        public Builder clearField(int i2) {
            if (i2 != 0) {
                if (this.lastField != null && this.lastFieldNumber == i2) {
                    this.lastField = null;
                    this.lastFieldNumber = 0;
                }
                if (this.fields.containsKey(Integer.valueOf(i2))) {
                    this.fields.remove(Integer.valueOf(i2));
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean hasField(int i2) {
            if (i2 != 0) {
                return i2 == this.lastFieldNumber || this.fields.containsKey(Integer.valueOf(i2));
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean isInitialized() {
            return true;
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            return true;
        }

        public Builder mergeField(int i2, Field field) {
            if (i2 != 0) {
                if (hasField(i2)) {
                    getFieldBuilder(i2).mergeFrom(field);
                } else {
                    addField(i2, field);
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean mergeFieldFrom(int i2, CodedInputStream codedInputStream) throws IOException {
            int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                getFieldBuilder(tagFieldNumber).addVarint(codedInputStream.readInt64());
                return true;
            } else if (tagWireType == 1) {
                getFieldBuilder(tagFieldNumber).addFixed64(codedInputStream.readFixed64());
                return true;
            } else if (tagWireType == 2) {
                getFieldBuilder(tagFieldNumber).addLengthDelimited(codedInputStream.readBytes());
                return true;
            } else if (tagWireType == 3) {
                Builder newBuilder = UnknownFieldSet.newBuilder();
                codedInputStream.readGroup(tagFieldNumber, (MessageLite.Builder) newBuilder, (ExtensionRegistryLite) ExtensionRegistry.getEmptyRegistry());
                getFieldBuilder(tagFieldNumber).addGroup(newBuilder.build());
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    getFieldBuilder(tagFieldNumber).addFixed32(codedInputStream.readFixed32());
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public Builder mergeLengthDelimitedField(int i2, ByteString byteString) {
            if (i2 != 0) {
                getFieldBuilder(i2).addLengthDelimited(byteString);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public Builder mergeVarintField(int i2, int i3) {
            if (i2 != 0) {
                getFieldBuilder(i2).addVarint((long) i3);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public UnknownFieldSet build() {
            UnknownFieldSet unknownFieldSet;
            getFieldBuilder(0);
            if (this.fields.isEmpty()) {
                unknownFieldSet = UnknownFieldSet.getDefaultInstance();
            } else {
                unknownFieldSet = new UnknownFieldSet(Collections.unmodifiableMap(this.fields), Collections.unmodifiableMap(((TreeMap) this.fields).descendingMap()));
            }
            this.fields = null;
            return unknownFieldSet;
        }

        public UnknownFieldSet buildPartial() {
            return build();
        }

        public Builder clear() {
            reinitialize();
            return this;
        }

        public UnknownFieldSet getDefaultInstanceForType() {
            return UnknownFieldSet.getDefaultInstance();
        }

        public Builder clone() {
            getFieldBuilder(0);
            return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, Collections.unmodifiableMap(((TreeMap) this.fields).descendingMap())));
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeDelimitedFrom(inputStream);
        }

        public Builder mergeFrom(UnknownFieldSet unknownFieldSet) {
            if (unknownFieldSet != UnknownFieldSet.getDefaultInstance()) {
                for (Map.Entry entry : unknownFieldSet.fields.entrySet()) {
                    mergeField(((Integer) entry.getKey()).intValue(), (Field) entry.getValue());
                }
            }
            return this;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.CodedInputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r2.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.mergeFieldFrom(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnknownFieldSet.Builder.mergeFrom(com.google.protobuf.CodedInputStream):com.google.protobuf.UnknownFieldSet$Builder");
        }

        public Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput);
                newCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
            }
        }

        public Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        public Builder mergeFrom(InputStream inputStream) throws IOException {
            CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
            mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream);
        }

        public Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(byteString);
        }

        public Builder mergeFrom(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i2, i3);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        public Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(bArr);
        }

        public Builder mergeFrom(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i2, i3);
        }

        public Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(inputStream);
        }

        public Builder mergeFrom(MessageLite messageLite) {
            if (messageLite instanceof UnknownFieldSet) {
                return mergeFrom((UnknownFieldSet) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static final class Field {
        public static final Field fieldDefaultInstance = newBuilder().build();
        public List<Integer> fixed32;
        public List<Long> fixed64;
        public List<UnknownFieldSet> group;
        public List<ByteString> lengthDelimited;
        public List<Long> varint;

        public static final class Builder {
            public Field result;

            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new Field();
                return builder;
            }

            public Builder addFixed32(int i2) {
                if (this.result.fixed32 == null) {
                    List unused = this.result.fixed32 = new ArrayList();
                }
                this.result.fixed32.add(Integer.valueOf(i2));
                return this;
            }

            public Builder addFixed64(long j) {
                if (this.result.fixed64 == null) {
                    List unused = this.result.fixed64 = new ArrayList();
                }
                this.result.fixed64.add(Long.valueOf(j));
                return this;
            }

            public Builder addGroup(UnknownFieldSet unknownFieldSet) {
                if (this.result.group == null) {
                    List unused = this.result.group = new ArrayList();
                }
                this.result.group.add(unknownFieldSet);
                return this;
            }

            public Builder addLengthDelimited(ByteString byteString) {
                if (this.result.lengthDelimited == null) {
                    List unused = this.result.lengthDelimited = new ArrayList();
                }
                this.result.lengthDelimited.add(byteString);
                return this;
            }

            public Builder addVarint(long j) {
                if (this.result.varint == null) {
                    List unused = this.result.varint = new ArrayList();
                }
                this.result.varint.add(Long.valueOf(j));
                return this;
            }

            public Field build() {
                if (this.result.varint == null) {
                    List unused = this.result.varint = Collections.emptyList();
                } else {
                    Field field = this.result;
                    List unused2 = field.varint = Collections.unmodifiableList(field.varint);
                }
                if (this.result.fixed32 == null) {
                    List unused3 = this.result.fixed32 = Collections.emptyList();
                } else {
                    Field field2 = this.result;
                    List unused4 = field2.fixed32 = Collections.unmodifiableList(field2.fixed32);
                }
                if (this.result.fixed64 == null) {
                    List unused5 = this.result.fixed64 = Collections.emptyList();
                } else {
                    Field field3 = this.result;
                    List unused6 = field3.fixed64 = Collections.unmodifiableList(field3.fixed64);
                }
                if (this.result.lengthDelimited == null) {
                    List unused7 = this.result.lengthDelimited = Collections.emptyList();
                } else {
                    Field field4 = this.result;
                    List unused8 = field4.lengthDelimited = Collections.unmodifiableList(field4.lengthDelimited);
                }
                if (this.result.group == null) {
                    List unused9 = this.result.group = Collections.emptyList();
                } else {
                    Field field5 = this.result;
                    List unused10 = field5.group = Collections.unmodifiableList(field5.group);
                }
                Field field6 = this.result;
                this.result = null;
                return field6;
            }

            public Builder clear() {
                this.result = new Field();
                return this;
            }

            public Builder mergeFrom(Field field) {
                if (!field.varint.isEmpty()) {
                    if (this.result.varint == null) {
                        List unused = this.result.varint = new ArrayList();
                    }
                    this.result.varint.addAll(field.varint);
                }
                if (!field.fixed32.isEmpty()) {
                    if (this.result.fixed32 == null) {
                        List unused2 = this.result.fixed32 = new ArrayList();
                    }
                    this.result.fixed32.addAll(field.fixed32);
                }
                if (!field.fixed64.isEmpty()) {
                    if (this.result.fixed64 == null) {
                        List unused3 = this.result.fixed64 = new ArrayList();
                    }
                    this.result.fixed64.addAll(field.fixed64);
                }
                if (!field.lengthDelimited.isEmpty()) {
                    if (this.result.lengthDelimited == null) {
                        List unused4 = this.result.lengthDelimited = new ArrayList();
                    }
                    this.result.lengthDelimited.addAll(field.lengthDelimited);
                }
                if (!field.group.isEmpty()) {
                    if (this.result.group == null) {
                        List unused5 = this.result.group = new ArrayList();
                    }
                    this.result.group.addAll(field.group);
                }
                return this;
            }
        }

        public static Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        private Object[] getIdentityArray() {
            return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            return Arrays.equals(getIdentityArray(), ((Field) obj).getIdentityArray());
        }

        public List<Integer> getFixed32List() {
            return this.fixed32;
        }

        public List<Long> getFixed64List() {
            return this.fixed64;
        }

        public List<UnknownFieldSet> getGroupList() {
            return this.group;
        }

        public List<ByteString> getLengthDelimitedList() {
            return this.lengthDelimited;
        }

        public int getSerializedSize(int i2) {
            int i3 = 0;
            for (Long longValue : this.varint) {
                i3 += CodedOutputStream.computeUInt64Size(i2, longValue.longValue());
            }
            for (Integer intValue : this.fixed32) {
                i3 += CodedOutputStream.computeFixed32Size(i2, intValue.intValue());
            }
            for (Long longValue2 : this.fixed64) {
                i3 += CodedOutputStream.computeFixed64Size(i2, longValue2.longValue());
            }
            for (ByteString computeBytesSize : this.lengthDelimited) {
                i3 += CodedOutputStream.computeBytesSize(i2, computeBytesSize);
            }
            for (UnknownFieldSet computeGroupSize : this.group) {
                i3 += CodedOutputStream.computeGroupSize(i2, computeGroupSize);
            }
            return i3;
        }

        public int getSerializedSizeAsMessageSetExtension(int i2) {
            int i3 = 0;
            for (ByteString computeRawMessageSetExtensionSize : this.lengthDelimited) {
                i3 += CodedOutputStream.computeRawMessageSetExtensionSize(i2, computeRawMessageSetExtensionSize);
            }
            return i3;
        }

        public List<Long> getVarintList() {
            return this.varint;
        }

        public int hashCode() {
            return Arrays.hashCode(getIdentityArray());
        }

        public ByteString toByteString(int i2) {
            try {
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize(i2));
                writeTo(i2, newCodedBuilder.getCodedOutput());
                return newCodedBuilder.build();
            } catch (IOException e) {
                throw new RuntimeException("Serializing to a ByteString should never fail with an IOException", e);
            }
        }

        public void writeAsMessageSetExtensionTo(int i2, CodedOutputStream codedOutputStream) throws IOException {
            for (ByteString writeRawMessageSetExtension : this.lengthDelimited) {
                codedOutputStream.writeRawMessageSetExtension(i2, writeRawMessageSetExtension);
            }
        }

        public void writeTo(int i2, CodedOutputStream codedOutputStream) throws IOException {
            for (Long longValue : this.varint) {
                codedOutputStream.writeUInt64(i2, longValue.longValue());
            }
            for (Integer intValue : this.fixed32) {
                codedOutputStream.writeFixed32(i2, intValue.intValue());
            }
            for (Long longValue2 : this.fixed64) {
                codedOutputStream.writeFixed64(i2, longValue2.longValue());
            }
            for (ByteString writeBytes : this.lengthDelimited) {
                codedOutputStream.writeBytes(i2, writeBytes);
            }
            for (UnknownFieldSet writeGroup : this.group) {
                codedOutputStream.writeGroup(i2, writeGroup);
            }
        }

        public Field() {
        }

        public static Builder newBuilder(Field field) {
            return newBuilder().mergeFrom(field);
        }

        /* access modifiers changed from: private */
        public void writeAsMessageSetExtensionTo(int i2, Writer writer) throws IOException {
            if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
                List<ByteString> list = this.lengthDelimited;
                ListIterator<ByteString> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    writer.writeMessageSetItem(i2, listIterator.previous());
                }
                return;
            }
            for (ByteString writeMessageSetItem : this.lengthDelimited) {
                writer.writeMessageSetItem(i2, writeMessageSetItem);
            }
        }

        public void writeTo(int i2, Writer writer) throws IOException {
            writer.writeInt64List(i2, this.varint, false);
            writer.writeFixed32List(i2, this.fixed32, false);
            writer.writeFixed64List(i2, this.fixed64, false);
            writer.writeBytesList(i2, this.lengthDelimited);
            if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                for (int i3 = 0; i3 < this.group.size(); i3++) {
                    writer.writeStartGroup(i2);
                    this.group.get(i3).writeTo(writer);
                    writer.writeEndGroup(i2);
                }
                return;
            }
            for (int size = this.group.size() - 1; size >= 0; size--) {
                writer.writeEndGroup(i2);
                this.group.get(size).writeTo(writer);
                writer.writeStartGroup(i2);
            }
        }
    }

    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        public UnknownFieldSet parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder newBuilder = UnknownFieldSet.newBuilder();
            try {
                newBuilder.mergeFrom(codedInputStream);
                return newBuilder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(newBuilder.buildPartial());
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(newBuilder.buildPartial());
            }
        }
    }

    public UnknownFieldSet() {
        this.fields = null;
        this.fieldsDescending = null;
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static UnknownFieldSet parseFrom(CodedInputStream codedInputStream) throws IOException {
        return newBuilder().mergeFrom(codedInputStream).build();
    }

    public Map<Integer, Field> asMap() {
        return this.fields;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UnknownFieldSet) && this.fields.equals(((UnknownFieldSet) obj).fields);
    }

    public Field getField(int i2) {
        Field field = this.fields.get(Integer.valueOf(i2));
        return field == null ? Field.getDefaultInstance() : field;
    }

    public int getSerializedSize() {
        int i2 = 0;
        for (Map.Entry next : this.fields.entrySet()) {
            i2 += ((Field) next.getValue()).getSerializedSize(((Integer) next.getKey()).intValue());
        }
        return i2;
    }

    public int getSerializedSizeAsMessageSet() {
        int i2 = 0;
        for (Map.Entry next : this.fields.entrySet()) {
            i2 += ((Field) next.getValue()).getSerializedSizeAsMessageSetExtension(((Integer) next.getKey()).intValue());
        }
        return i2;
    }

    public boolean hasField(int i2) {
        return this.fields.containsKey(Integer.valueOf(i2));
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isInitialized() {
        return true;
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public ByteString toByteString() {
        try {
            ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.getCodedOutput());
            return newCodedBuilder.build();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return TextFormat.printer().printToString(this);
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry next : this.fields.entrySet()) {
            ((Field) next.getValue()).writeAsMessageSetExtensionTo(((Integer) next.getKey()).intValue(), codedOutputStream);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream);
        newInstance.writeRawVarint32(getSerializedSize());
        writeTo(newInstance);
        newInstance.flush();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry next : this.fields.entrySet()) {
            ((Field) next.getValue()).writeTo(((Integer) next.getKey()).intValue(), codedOutputStream);
        }
    }

    public static Builder newBuilder(UnknownFieldSet unknownFieldSet) {
        return newBuilder().mergeFrom(unknownFieldSet);
    }

    public static UnknownFieldSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(byteString).build();
    }

    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    public final Parser getParserForType() {
        return PARSER;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    public static UnknownFieldSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(bArr).build();
    }

    public void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry next : this.fieldsDescending.entrySet()) {
                ((Field) next.getValue()).writeAsMessageSetExtensionTo(((Integer) next.getKey()).intValue(), writer);
            }
            return;
        }
        for (Map.Entry next2 : this.fields.entrySet()) {
            ((Field) next2.getValue()).writeAsMessageSetExtensionTo(((Integer) next2.getKey()).intValue(), writer);
        }
    }

    public UnknownFieldSet(Map<Integer, Field> map, Map<Integer, Field> map2) {
        this.fields = map;
        this.fieldsDescending = map2;
    }

    public static UnknownFieldSet parseFrom(InputStream inputStream) throws IOException {
        return newBuilder().mergeFrom(inputStream).build();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream);
        writeTo(newInstance);
        newInstance.flush();
    }

    public void writeTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry next : this.fieldsDescending.entrySet()) {
                ((Field) next.getValue()).writeTo(((Integer) next.getKey()).intValue(), writer);
            }
            return;
        }
        for (Map.Entry next2 : this.fields.entrySet()) {
            ((Field) next2.getValue()).writeTo(((Integer) next2.getKey()).intValue(), writer);
        }
    }
}
