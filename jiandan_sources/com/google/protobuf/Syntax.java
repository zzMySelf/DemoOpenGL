package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;

public enum Syntax implements ProtocolMessageEnum {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final Syntax[] VALUES = null;
    public static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    public final int value;

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<Syntax>() {
            public Syntax findValueByNumber(int i2) {
                return Syntax.forNumber(i2);
            }
        };
        VALUES = values();
    }

    /* access modifiers changed from: public */
    Syntax(int i2) {
        this.value = i2;
    }

    public static Syntax forNumber(int i2) {
        if (i2 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i2 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return TypeProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    @Deprecated
    public static Syntax valueOf(int i2) {
        return forNumber(i2);
    }

    public static Syntax valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        } else {
            return VALUES[enumValueDescriptor.getIndex()];
        }
    }
}
