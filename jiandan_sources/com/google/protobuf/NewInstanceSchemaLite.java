package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;

public final class NewInstanceSchemaLite implements NewInstanceSchema {
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}
