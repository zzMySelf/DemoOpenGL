package com.temp.searchbox.v8engine;

public class JsObject extends JsReleaser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int JARRAY = 6;
    public static final int JARRAYBUFFER = 10;
    public static final int JBOOLEAN = 1;
    public static final int JDOUBLE = 5;
    public static final int JFUNCTION = 8;
    public static final int JINTEGER = 2;
    public static final int JLONG = 3;
    public static final int JNONSUPPORT = 0;
    public static final int JNULL = 11;
    public static final int JOBJECT = 9;
    public static final int JSTRING = 7;
    public static final int JUNDEFINED = 12;
    static final String TAG = "JsObject";
    private int mSize;

    private native JsSerializeValue nativeAsSerializeValue(long j2);

    private native int nativeGetPropertyIndex(long j2, String str);

    private native String nativeGetPropertyName(long j2, int i2);

    private native int nativePropertyType(long j2, int i2);

    private native boolean nativeStrictEquals(long j2, long j3);

    private native boolean nativeToBoolean(long j2, int i2);

    private native double nativeToDouble(long j2, int i2);

    private native double[] nativeToDoubleArray(long j2, int i2);

    private native int nativeToInteger(long j2, int i2);

    private native int[] nativeToIntegerArray(long j2, int i2);

    private native JsArrayBuffer nativeToJsArrayBuffer(long j2, int i2);

    private native JsFunction nativeToJsFunction(long j2, long j3, int i2);

    private native JsObject nativeToJsObject(long j2, int i2);

    private native long nativeToLong(long j2, int i2);

    private native JsObject[] nativeToObjectArray(long j2, int i2);

    private native JsSerializeValue nativeToSerializeValue(long j2, int i2);

    private native String nativeToString(long j2, int i2);

    private native String[] nativeToStringArray(long j2, int i2);

    private native int nativeType(long j2);

    public JsObject() {
        super(0, 0, 0);
        this.mSize = 0;
        this.mSize = 0;
    }

    public JsObject(long nativeObject, long ownedEngine, long ownedThread, int size) {
        super(nativeObject, ownedEngine, ownedThread);
        this.mSize = 0;
        this.mSize = size;
    }

    public int length() {
        return this.mSize;
    }

    private boolean checkValid(int index) {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return this.mNativeObject.get() != 0 && index >= 0 && index < this.mSize;
    }

    public static String typeToString(int type) {
        switch (type) {
            case 0:
                return "Jnonsupport";
            case 1:
                return "Jboolean";
            case 2:
                return "Jinteger";
            case 3:
                return "Jlong";
            case 5:
                return "Jdouble";
            case 6:
                return "Jarray";
            case 7:
                return "Jstring";
            case 8:
                return "Jfunction";
            case 9:
                return "Jobject";
            case 10:
                return "Jarraybuffer";
            default:
                return "Junknown";
        }
    }

    public String getPropertyName(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return "undefined";
            }
            return nativeGetPropertyName(naPtr, index);
        }
        throw new AssertionError();
    }

    public int getPropertyIndex(String propertyName) {
        long naPtr = this.mNativeObject.get();
        if (naPtr == 0) {
            return 0;
        }
        return nativeGetPropertyIndex(naPtr, propertyName);
    }

    public int getPropertyType(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return 0;
            }
            return nativePropertyType(naPtr, index);
        }
        throw new AssertionError();
    }

    public int getType() {
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        long naPtr = this.mNativeObject.get();
        if (naPtr == 0) {
            return 0;
        }
        return nativeType(naPtr);
    }

    public boolean toBoolean(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return false;
            }
            return nativeToBoolean(naPtr, index);
        }
        throw new AssertionError();
    }

    public int toInteger(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return 0;
            }
            return nativeToInteger(naPtr, index);
        }
        throw new AssertionError();
    }

    public long toLong(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return 0;
            }
            return nativeToLong(naPtr, index);
        }
        throw new AssertionError();
    }

    public JsSerializeValue toSerializeValue(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToSerializeValue(naPtr, index);
        }
        throw new AssertionError();
    }

    public JsSerializeValue asSerializeValue() {
        long naPtr = this.mNativeObject.getAndSet(0);
        if (naPtr == 0) {
            return null;
        }
        this.mSize = 0;
        return nativeAsSerializeValue(naPtr);
    }

    public double toDouble(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return 0.0d;
            }
            return nativeToDouble(naPtr, index);
        }
        throw new AssertionError();
    }

    public String toString(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return "null";
            }
            return nativeToString(naPtr, index);
        }
        throw new AssertionError();
    }

    public JsFunction toJsFunction(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToJsFunction(this.mOwnedNativeEngine, naPtr, index);
        }
        throw new AssertionError();
    }

    public JsObject toJsObject(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToJsObject(naPtr, index);
        }
        throw new AssertionError();
    }

    public JsArrayBuffer toJsArrayBuffer(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToJsArrayBuffer(naPtr, index);
        }
        throw new AssertionError();
    }

    public boolean isBoolean(int index) {
        return getPropertyType(index) == 1;
    }

    public boolean isInteger(int index) {
        return getPropertyType(index) == 2;
    }

    public boolean isLong(int index) {
        return getPropertyType(index) == 3;
    }

    public boolean isDouble(int index) {
        return getPropertyType(index) == 5;
    }

    public boolean isString(int index) {
        return getPropertyType(index) == 7;
    }

    public boolean isJsFunction(int index) {
        return getPropertyType(index) == 8;
    }

    public boolean isJsObject(int index) {
        return getPropertyType(index) == 9;
    }

    public boolean isJsArrayBuffer(int index) {
        return getPropertyType(index) == 10;
    }

    public boolean isArray(int index) {
        return getPropertyType(index) == 6;
    }

    public String[] toStringArray(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToStringArray(naPtr, index);
        }
        throw new AssertionError();
    }

    public double[] toDoubleArray(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToDoubleArray(naPtr, index);
        }
        throw new AssertionError();
    }

    public int[] toIntegerArray(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToIntegerArray(naPtr, index);
        }
        throw new AssertionError();
    }

    public JsObject[] toObjectArray(int index) {
        if (checkValid(index)) {
            long naPtr = this.mNativeObject.get();
            if (naPtr == 0) {
                return null;
            }
            return nativeToObjectArray(naPtr, index);
        }
        throw new AssertionError();
    }

    public boolean strictEquals(JsObject other) {
        if (this.mNativeObject.get() == 0 || other == null) {
            return false;
        }
        if (this == other || this.mNativeObject.get() == other.mNativeObject.get()) {
            return true;
        }
        V8Engine.checkValid(this.mOwnedNativeEngine, this.mOwnedThreadId);
        return nativeStrictEquals(this.mNativeObject.get(), other.mNativeObject.get());
    }
}
