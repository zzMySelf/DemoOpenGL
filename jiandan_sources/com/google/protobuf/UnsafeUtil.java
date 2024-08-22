package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class UnsafeUtil {
    public static final long BOOLEAN_ARRAY_BASE_OFFSET;
    public static final long BOOLEAN_ARRAY_INDEX_SCALE;
    public static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    public static final int BYTE_ARRAY_ALIGNMENT = ((int) (BYTE_ARRAY_BASE_OFFSET & 7));
    public static final long BYTE_ARRAY_BASE_OFFSET = ((long) arrayBaseOffset(byte[].class));
    public static final long DOUBLE_ARRAY_BASE_OFFSET;
    public static final long DOUBLE_ARRAY_INDEX_SCALE;
    public static final long FLOAT_ARRAY_BASE_OFFSET;
    public static final long FLOAT_ARRAY_INDEX_SCALE;
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    public static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    public static final long INT_ARRAY_BASE_OFFSET;
    public static final long INT_ARRAY_INDEX_SCALE;
    public static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    public static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    public static final boolean IS_BIG_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    public static final long LONG_ARRAY_BASE_OFFSET;
    public static final long LONG_ARRAY_INDEX_SCALE;
    public static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    public static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    public static final long OBJECT_ARRAY_BASE_OFFSET;
    public static final long OBJECT_ARRAY_INDEX_SCALE;
    public static final int STRIDE = 8;
    public static final int STRIDE_ALIGNMENT_MASK = 7;
    public static final Unsafe UNSAFE = getUnsafe();
    public static final Logger logger = Logger.getLogger(UnsafeUtil.class.getName());

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        public static final long SMALL_ADDRESS_MASK = -1;

        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public static int smallAddress(long j) {
            return (int) (j & -1);
        }

        public void copyMemory(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j);
        }

        public byte getByte(long j) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(Object obj, long j) {
            return Double.longBitsToDouble(getLong(obj, j));
        }

        public float getFloat(Object obj, long j) {
            return Float.intBitsToFloat(getInt(obj, j));
        }

        public int getInt(long j) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j, z);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j, z);
            }
        }

        public void putByte(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        public void putDouble(Object obj, long j, double d) {
            putLong(obj, j, Double.doubleToLongBits(d));
        }

        public void putFloat(Object obj, long j, float f) {
            putInt(obj, j, Float.floatToIntBits(f));
        }

        public void putInt(long j, int i2) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j, long j2) {
            throw new UnsupportedOperationException();
        }

        public void copyMemory(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(Object obj, long j) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j);
        }

        public void putByte(Object obj, long j, byte b) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, b);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, b);
            }
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j);
        }

        public byte getByte(long j) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(Object obj, long j) {
            return Double.longBitsToDouble(getLong(obj, j));
        }

        public float getFloat(Object obj, long j) {
            return Float.intBitsToFloat(getInt(obj, j));
        }

        public int getInt(long j) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j, z);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j, z);
            }
        }

        public void putByte(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        public void putDouble(Object obj, long j, double d) {
            putLong(obj, j, Double.doubleToLongBits(d));
        }

        public void putFloat(Object obj, long j, float f) {
            putInt(obj, j, Float.floatToIntBits(f));
        }

        public void putInt(long j, int i2) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j, long j2) {
            throw new UnsupportedOperationException();
        }

        public void copyMemory(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(Object obj, long j) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j);
        }

        public void putByte(Object obj, long j, byte b) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, b);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, b);
            }
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j, byte[] bArr, long j2, long j3) {
            this.unsafe.copyMemory((Object) null, j, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j2, j3);
        }

        public boolean getBoolean(Object obj, long j) {
            return this.unsafe.getBoolean(obj, j);
        }

        public byte getByte(long j) {
            return this.unsafe.getByte(j);
        }

        public double getDouble(Object obj, long j) {
            return this.unsafe.getDouble(obj, j);
        }

        public float getFloat(Object obj, long j) {
            return this.unsafe.getFloat(obj, j);
        }

        public int getInt(long j) {
            return this.unsafe.getInt(j);
        }

        public long getLong(long j) {
            return this.unsafe.getLong(j);
        }

        public Object getStaticObject(Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        public void putBoolean(Object obj, long j, boolean z) {
            this.unsafe.putBoolean(obj, j, z);
        }

        public void putByte(long j, byte b) {
            this.unsafe.putByte(j, b);
        }

        public void putDouble(Object obj, long j, double d) {
            this.unsafe.putDouble(obj, j, d);
        }

        public void putFloat(Object obj, long j, float f) {
            this.unsafe.putFloat(obj, j, f);
        }

        public void putInt(long j, int i2) {
            this.unsafe.putInt(j, i2);
        }

        public void putLong(long j, long j2) {
            this.unsafe.putLong(j, j2);
        }

        public void copyMemory(byte[] bArr, long j, long j2, long j3) {
            this.unsafe.copyMemory(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j, (Object) null, j2, j3);
        }

        public byte getByte(Object obj, long j) {
            return this.unsafe.getByte(obj, j);
        }

        public void putByte(Object obj, long j, byte b) {
            this.unsafe.putByte(obj, j, b);
        }
    }

    public static abstract class MemoryAccessor {
        public Unsafe unsafe;

        public MemoryAccessor(Unsafe unsafe2) {
            this.unsafe = unsafe2;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j, byte[] bArr, long j2, long j3);

        public abstract void copyMemory(byte[] bArr, long j, long j2, long j3);

        public abstract boolean getBoolean(Object obj, long j);

        public abstract byte getByte(long j);

        public abstract byte getByte(Object obj, long j);

        public abstract double getDouble(Object obj, long j);

        public abstract float getFloat(Object obj, long j);

        public abstract int getInt(long j);

        public final int getInt(Object obj, long j) {
            return this.unsafe.getInt(obj, j);
        }

        public abstract long getLong(long j);

        public final long getLong(Object obj, long j) {
            return this.unsafe.getLong(obj, j);
        }

        public final Object getObject(Object obj, long j) {
            return this.unsafe.getObject(obj, j);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j, boolean z);

        public abstract void putByte(long j, byte b);

        public abstract void putByte(Object obj, long j, byte b);

        public abstract void putDouble(Object obj, long j, double d);

        public abstract void putFloat(Object obj, long j, float f);

        public abstract void putInt(long j, int i2);

        public final void putInt(Object obj, long j, int i2) {
            this.unsafe.putInt(obj, j, i2);
        }

        public abstract void putLong(long j, long j2);

        public final void putLong(Object obj, long j, long j2) {
            this.unsafe.putLong(obj, j, j2);
        }

        public final void putObject(Object obj, long j, Object obj2) {
            this.unsafe.putObject(obj, j, obj2);
        }
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        BOOLEAN_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls6);
        BOOLEAN_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls6);
        INT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls5);
        INT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls5);
        LONG_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls4);
        LONG_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls4);
        FLOAT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls3);
        FLOAT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls3);
        DOUBLE_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls2);
        DOUBLE_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls2);
        OBJECT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls);
        OBJECT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls);
    }

    public static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Field bufferAddressField() {
        Field field;
        if (Android.isOnAndroidDevice() && (field = field(Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(Buffer.class, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    public static void copyMemory(byte[] bArr, long j, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(bArr, j, j2, j3);
    }

    public static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls3 = MEMORY_CLASS;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long fieldOffset(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    public static int firstDifferingByteIndexNativeEndian(long j, long j2) {
        int i2;
        if (IS_BIG_ENDIAN) {
            i2 = Long.numberOfLeadingZeros(j ^ j2);
        } else {
            i2 = Long.numberOfTrailingZeros(j ^ j2);
        }
        return i2 >> 3;
    }

    public static boolean getBoolean(Object obj, long j) {
        return MEMORY_ACCESSOR.getBoolean(obj, j);
    }

    public static boolean getBooleanBigEndian(Object obj, long j) {
        return getByteBigEndian(obj, j) != 0;
    }

    public static boolean getBooleanLittleEndian(Object obj, long j) {
        return getByteLittleEndian(obj, j) != 0;
    }

    public static byte getByte(Object obj, long j) {
        return MEMORY_ACCESSOR.getByte(obj, j);
    }

    public static byte getByteBigEndian(Object obj, long j) {
        return (byte) ((getInt(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static byte getByteLittleEndian(Object obj, long j) {
        return (byte) ((getInt(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    public static double getDouble(Object obj, long j) {
        return MEMORY_ACCESSOR.getDouble(obj, j);
    }

    public static float getFloat(Object obj, long j) {
        return MEMORY_ACCESSOR.getFloat(obj, j);
    }

    public static int getInt(Object obj, long j) {
        return MEMORY_ACCESSOR.getInt(obj, j);
    }

    public static long getLong(Object obj, long j) {
        return MEMORY_ACCESSOR.getLong(obj, j);
    }

    public static MemoryAccessor getMemoryAccessor() {
        if (UNSAFE == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(UNSAFE);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(UNSAFE);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(UNSAFE);
        }
        return null;
    }

    public static Object getObject(Object obj, long j) {
        return MEMORY_ACCESSOR.getObject(obj, j);
    }

    public static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    public static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    public static int mismatch(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (i2 < 0 || i3 < 0 || i4 < 0 || i2 + i4 > bArr.length || i3 + i4 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            int i6 = (BYTE_ARRAY_ALIGNMENT + i2) & 7;
            while (i5 < i4 && (i6 & 7) != 0) {
                if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                    return i5;
                }
                i5++;
                i6++;
            }
            int i7 = ((i4 - i5) & -8) + i5;
            while (i5 < i7) {
                long j = (long) i5;
                long j2 = getLong((Object) bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i2) + j);
                long j3 = getLong((Object) bArr2, BYTE_ARRAY_BASE_OFFSET + ((long) i3) + j);
                if (j2 != j3) {
                    return i5 + firstDifferingByteIndexNativeEndian(j2, j3);
                }
                i5 += 8;
            }
        }
        while (i5 < i4) {
            if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    public static void putBoolean(Object obj, long j, boolean z) {
        MEMORY_ACCESSOR.putBoolean(obj, j, z);
    }

    public static void putBooleanBigEndian(Object obj, long j, boolean z) {
        putByteBigEndian(obj, j, z ? (byte) 1 : 0);
    }

    public static void putBooleanLittleEndian(Object obj, long j, boolean z) {
        putByteLittleEndian(obj, j, z ? (byte) 1 : 0);
    }

    public static void putByte(Object obj, long j, byte b) {
        MEMORY_ACCESSOR.putByte(obj, j, b);
    }

    public static void putByteBigEndian(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i2 = getInt(obj, j2);
        int i3 = ((~((int) j)) & 3) << 3;
        putInt(obj, j2, ((255 & b) << i3) | (i2 & (~(255 << i3))));
    }

    public static void putByteLittleEndian(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i2 = (((int) j) & 3) << 3;
        putInt(obj, j2, ((255 & b) << i2) | (getInt(obj, j2) & (~(255 << i2))));
    }

    public static void putDouble(Object obj, long j, double d) {
        MEMORY_ACCESSOR.putDouble(obj, j, d);
    }

    public static void putFloat(Object obj, long j, float f) {
        MEMORY_ACCESSOR.putFloat(obj, j, f);
    }

    public static void putInt(Object obj, long j, int i2) {
        MEMORY_ACCESSOR.putInt(obj, j, i2);
    }

    public static void putLong(Object obj, long j, long j2) {
        MEMORY_ACCESSOR.putLong(obj, j, j2);
    }

    public static void putObject(Object obj, long j, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j, obj2);
    }

    public static boolean supportsUnsafeArrayOperations() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls2.getMethod("getInt", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putInt", new Class[]{cls, Long.TYPE, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putLong", new Class[]{cls, Long.TYPE, Long.TYPE});
            cls2.getMethod("getObject", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putObject", new Class[]{cls, Long.TYPE, cls});
            if (Android.isOnAndroidDevice()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putByte", new Class[]{cls, Long.TYPE, Byte.TYPE});
            cls2.getMethod("getBoolean", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putBoolean", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("getFloat", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putFloat", new Class[]{cls, Long.TYPE, Float.TYPE});
            cls2.getMethod("getDouble", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putDouble", new Class[]{cls, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th2) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            logger2.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    public static boolean supportsUnsafeByteBufferOperations() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            if (bufferAddressField() == null) {
                return false;
            }
            if (Android.isOnAndroidDevice()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{Long.TYPE});
            cls2.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{Long.TYPE});
            cls2.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{Long.TYPE});
            cls2.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls2.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls2.getMethod("copyMemory", new Class[]{cls, Long.TYPE, cls, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th2) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            logger2.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    public static void copyMemory(long j, byte[] bArr, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(j, bArr, j2, j3);
    }

    public static boolean getBoolean(boolean[] zArr, long j) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    public static byte getByte(byte[] bArr, long j) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j);
    }

    public static double getDouble(double[] dArr, long j) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j * DOUBLE_ARRAY_INDEX_SCALE));
    }

    public static float getFloat(float[] fArr, long j) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j * FLOAT_ARRAY_INDEX_SCALE));
    }

    public static int getInt(int[] iArr, long j) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j * INT_ARRAY_INDEX_SCALE));
    }

    public static long getLong(long[] jArr, long j) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j * LONG_ARRAY_INDEX_SCALE));
    }

    public static Object getObject(Object[] objArr, long j) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j * OBJECT_ARRAY_INDEX_SCALE));
    }

    public static void putBoolean(boolean[] zArr, long j, boolean z) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j * BOOLEAN_ARRAY_INDEX_SCALE), z);
    }

    public static void putByte(byte[] bArr, long j, byte b) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j, b);
    }

    public static void putDouble(double[] dArr, long j, double d) {
        MEMORY_ACCESSOR.putDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j * DOUBLE_ARRAY_INDEX_SCALE), d);
    }

    public static void putFloat(float[] fArr, long j, float f) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j * FLOAT_ARRAY_INDEX_SCALE), f);
    }

    public static void putInt(int[] iArr, long j, int i2) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j * INT_ARRAY_INDEX_SCALE), i2);
    }

    public static void putLong(long[] jArr, long j, long j2) {
        MEMORY_ACCESSOR.putLong(jArr, LONG_ARRAY_BASE_OFFSET + (j * LONG_ARRAY_INDEX_SCALE), j2);
    }

    public static void putObject(Object[] objArr, long j, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    public static void copyMemory(byte[] bArr, long j, byte[] bArr2, long j2, long j3) {
        System.arraycopy(bArr, (int) j, bArr2, (int) j2, (int) j3);
    }

    public static byte getByte(long j) {
        return MEMORY_ACCESSOR.getByte(j);
    }

    public static int getInt(long j) {
        return MEMORY_ACCESSOR.getInt(j);
    }

    public static long getLong(long j) {
        return MEMORY_ACCESSOR.getLong(j);
    }

    public static void putByte(long j, byte b) {
        MEMORY_ACCESSOR.putByte(j, b);
    }

    public static void putInt(long j, int i2) {
        MEMORY_ACCESSOR.putInt(j, i2);
    }

    public static void putLong(long j, long j2) {
        MEMORY_ACCESSOR.putLong(j, j2);
    }
}
