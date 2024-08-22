package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;

public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    public enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    public enum MessageType {
        PROTO1,
        PROTO2
    }

    public abstract Object fromReflectionType(Object obj);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    public abstract ExtensionType getExtensionType();

    public abstract Message getMessageDefaultInstance();

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }

    public final boolean isLite() {
        return false;
    }

    public abstract Object singularFromReflectionType(Object obj);

    public abstract Object singularToReflectionType(Object obj);

    public abstract Object toReflectionType(Object obj);
}
