package com.google.protobuf;

public interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> cls);
}
