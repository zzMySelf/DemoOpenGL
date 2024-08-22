package com.google.protobuf;

import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

public class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {
    public final boolean proto3;

    public UnknownFieldSetSchema(boolean z) {
        this.proto3 = z;
    }

    public void makeImmutable(Object obj) {
    }

    public boolean shouldDiscardUnknownFields(Reader reader) {
        return reader.shouldDiscardUnknownFields();
    }

    public void addFixed32(UnknownFieldSet.Builder builder, int i2, int i3) {
        builder.mergeField(i2, UnknownFieldSet.Field.newBuilder().addFixed32(i3).build());
    }

    public void addFixed64(UnknownFieldSet.Builder builder, int i2, long j) {
        builder.mergeField(i2, UnknownFieldSet.Field.newBuilder().addFixed64(j).build());
    }

    public void addGroup(UnknownFieldSet.Builder builder, int i2, UnknownFieldSet unknownFieldSet) {
        builder.mergeField(i2, UnknownFieldSet.Field.newBuilder().addGroup(unknownFieldSet).build());
    }

    public void addLengthDelimited(UnknownFieldSet.Builder builder, int i2, ByteString byteString) {
        builder.mergeField(i2, UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build());
    }

    public void addVarint(UnknownFieldSet.Builder builder, int i2, long j) {
        builder.mergeField(i2, UnknownFieldSet.Field.newBuilder().addVarint(j).build());
    }

    public UnknownFieldSet.Builder getBuilderFromMessage(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields.toBuilder();
    }

    public UnknownFieldSet getFromMessage(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields;
    }

    public int getSerializedSize(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSize();
    }

    public int getSerializedSizeAsMessageSet(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSizeAsMessageSet();
    }

    public UnknownFieldSet merge(UnknownFieldSet unknownFieldSet, UnknownFieldSet unknownFieldSet2) {
        return unknownFieldSet.toBuilder().mergeFrom(unknownFieldSet2).build();
    }

    public UnknownFieldSet.Builder newBuilder() {
        return UnknownFieldSet.newBuilder();
    }

    public void setBuilderToMessage(Object obj, UnknownFieldSet.Builder builder) {
        ((GeneratedMessageV3) obj).unknownFields = builder.build();
    }

    public void setToMessage(Object obj, UnknownFieldSet unknownFieldSet) {
        ((GeneratedMessageV3) obj).unknownFields = unknownFieldSet;
    }

    public UnknownFieldSet toImmutable(UnknownFieldSet.Builder builder) {
        return builder.build();
    }

    public void writeAsMessageSetTo(UnknownFieldSet unknownFieldSet, Writer writer) throws IOException {
        unknownFieldSet.writeAsMessageSetTo(writer);
    }

    public void writeTo(UnknownFieldSet unknownFieldSet, Writer writer) throws IOException {
        unknownFieldSet.writeTo(writer);
    }
}
