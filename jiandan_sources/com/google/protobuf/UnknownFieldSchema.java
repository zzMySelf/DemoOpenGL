package com.google.protobuf;

import java.io.IOException;

public abstract class UnknownFieldSchema<T, B> {
    public abstract void addFixed32(B b, int i2, int i3);

    public abstract void addFixed64(B b, int i2, long j);

    public abstract void addGroup(B b, int i2, T t);

    public abstract void addLengthDelimited(B b, int i2, ByteString byteString);

    public abstract void addVarint(B b, int i2, long j);

    public abstract B getBuilderFromMessage(Object obj);

    public abstract T getFromMessage(Object obj);

    public abstract int getSerializedSize(T t);

    public abstract int getSerializedSizeAsMessageSet(T t);

    public abstract void makeImmutable(Object obj);

    public abstract T merge(T t, T t2);

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mergeFrom(B r3, com.google.protobuf.Reader r4) throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.getFieldNumber()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.mergeOneFieldFrom(r3, r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnknownFieldSchema.mergeFrom(java.lang.Object, com.google.protobuf.Reader):void");
    }

    public final boolean mergeOneFieldFrom(B b, Reader reader) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b, tagFieldNumber, reader.readInt64());
            return true;
        } else if (tagWireType == 1) {
            addFixed64(b, tagFieldNumber, reader.readFixed64());
            return true;
        } else if (tagWireType == 2) {
            addLengthDelimited(b, tagFieldNumber, reader.readBytes());
            return true;
        } else if (tagWireType == 3) {
            Object newBuilder = newBuilder();
            int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
            mergeFrom(newBuilder, reader);
            if (makeTag == reader.getTag()) {
                addGroup(b, tagFieldNumber, toImmutable(newBuilder));
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                addFixed32(b, tagFieldNumber, reader.readFixed32());
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b);

    public abstract void setToMessage(Object obj, T t);

    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    public abstract T toImmutable(B b);

    public abstract void writeAsMessageSetTo(T t, Writer writer) throws IOException;

    public abstract void writeTo(T t, Writer writer) throws IOException;
}
