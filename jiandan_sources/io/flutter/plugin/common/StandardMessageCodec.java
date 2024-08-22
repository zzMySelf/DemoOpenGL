package io.flutter.plugin.common;

import com.google.zxing.common.StringUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class StandardMessageCodec implements MessageCodec<Object> {
    public static final byte BIGINT = 5;
    public static final byte BYTE_ARRAY = 8;
    public static final byte DOUBLE = 6;
    public static final byte DOUBLE_ARRAY = 11;
    public static final byte FALSE = 2;
    public static final byte FLOAT_ARRAY = 14;
    public static final StandardMessageCodec INSTANCE = new StandardMessageCodec();
    public static final byte INT = 3;
    public static final byte INT_ARRAY = 9;
    public static final byte LIST = 12;
    public static final boolean LITTLE_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);
    public static final byte LONG = 4;
    public static final byte LONG_ARRAY = 10;
    public static final byte MAP = 13;
    public static final byte NULL = 0;
    public static final byte STRING = 7;
    public static final String TAG = "StandardMessageCodec#";
    public static final byte TRUE = 1;
    public static final Charset UTF8 = Charset.forName(StringUtils.UTF8);

    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] buffer() {
            return this.buf;
        }
    }

    public static final void readAlignment(ByteBuffer byteBuffer, int i2) {
        int position = byteBuffer.position() % i2;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i2) - position);
        }
    }

    public static final byte[] readBytes(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[readSize(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static final int readSize(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get() & 255;
            if (b < 254) {
                return b;
            }
            if (b == 254) {
                return byteBuffer.getChar();
            }
            return byteBuffer.getInt();
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public static final void writeAlignment(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        int size = byteArrayOutputStream.size() % i2;
        if (size != 0) {
            for (int i3 = 0; i3 < i2 - size; i3++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    public static final void writeBytes(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        writeSize(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    public static final void writeChar(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(i2 >>> 8);
            return;
        }
        byteArrayOutputStream.write(i2 >>> 8);
        byteArrayOutputStream.write(i2);
    }

    public static final void writeDouble(ByteArrayOutputStream byteArrayOutputStream, double d) {
        writeLong(byteArrayOutputStream, Double.doubleToLongBits(d));
    }

    public static final void writeFloat(ByteArrayOutputStream byteArrayOutputStream, float f) {
        writeInt(byteArrayOutputStream, Float.floatToIntBits(f));
    }

    public static final void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(i2 >>> 8);
            byteArrayOutputStream.write(i2 >>> 16);
            byteArrayOutputStream.write(i2 >>> 24);
            return;
        }
        byteArrayOutputStream.write(i2 >>> 24);
        byteArrayOutputStream.write(i2 >>> 16);
        byteArrayOutputStream.write(i2 >>> 8);
        byteArrayOutputStream.write(i2);
    }

    public static final void writeLong(ByteArrayOutputStream byteArrayOutputStream, long j) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write((byte) ((int) j));
            byteArrayOutputStream.write((byte) ((int) (j >>> 8)));
            byteArrayOutputStream.write((byte) ((int) (j >>> 16)));
            byteArrayOutputStream.write((byte) ((int) (j >>> 24)));
            byteArrayOutputStream.write((byte) ((int) (j >>> 32)));
            byteArrayOutputStream.write((byte) ((int) (j >>> 40)));
            byteArrayOutputStream.write((byte) ((int) (j >>> 48)));
            byteArrayOutputStream.write((byte) ((int) (j >>> 56)));
            return;
        }
        byteArrayOutputStream.write((byte) ((int) (j >>> 56)));
        byteArrayOutputStream.write((byte) ((int) (j >>> 48)));
        byteArrayOutputStream.write((byte) ((int) (j >>> 40)));
        byteArrayOutputStream.write((byte) ((int) (j >>> 32)));
        byteArrayOutputStream.write((byte) ((int) (j >>> 24)));
        byteArrayOutputStream.write((byte) ((int) (j >>> 16)));
        byteArrayOutputStream.write((byte) ((int) (j >>> 8)));
        byteArrayOutputStream.write((byte) ((int) j));
    }

    public static final void writeSize(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        if (i2 < 254) {
            byteArrayOutputStream.write(i2);
        } else if (i2 <= 65535) {
            byteArrayOutputStream.write(254);
            writeChar(byteArrayOutputStream, i2);
        } else {
            byteArrayOutputStream.write(255);
            writeInt(byteArrayOutputStream, i2);
        }
    }

    public Object decodeMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object readValue = readValue(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return readValue;
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public ByteBuffer encodeMessage(Object obj) {
        if (obj == null) {
            return null;
        }
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = new ExposedByteArrayOutputStream();
        writeValue(exposedByteArrayOutputStream, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    public final Object readValue(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return readValueOfType(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX WARNING: type inference failed for: r1v10, types: [java.util.Map, java.util.HashMap] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object readValueOfType(byte r5, java.nio.ByteBuffer r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 4
            r2 = 8
            switch(r5) {
                case 0: goto L_0x00f6;
                case 1: goto L_0x00f3;
                case 2: goto L_0x00f0;
                case 3: goto L_0x00e7;
                case 4: goto L_0x00de;
                case 5: goto L_0x00cb;
                case 6: goto L_0x00bf;
                case 7: goto L_0x00b3;
                case 8: goto L_0x00ae;
                case 9: goto L_0x0093;
                case 10: goto L_0x0078;
                case 11: goto L_0x005c;
                case 12: goto L_0x0044;
                case 13: goto L_0x002b;
                case 14: goto L_0x000f;
                default: goto L_0x0007;
            }
        L_0x0007:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Message corrupted"
            r5.<init>(r6)
            throw r5
        L_0x000f:
            int r5 = readSize(r6)
            float[] r0 = new float[r5]
            readAlignment(r6, r1)
            java.nio.FloatBuffer r2 = r6.asFloatBuffer()
            r2.get(r0)
            int r2 = r6.position()
            int r5 = r5 * 4
            int r2 = r2 + r5
            r6.position(r2)
            goto L_0x00f7
        L_0x002b:
            int r5 = readSize(r6)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L_0x0034:
            if (r0 >= r5) goto L_0x0059
            java.lang.Object r2 = r4.readValue(r6)
            java.lang.Object r3 = r4.readValue(r6)
            r1.put(r2, r3)
            int r0 = r0 + 1
            goto L_0x0034
        L_0x0044:
            int r5 = readSize(r6)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r5)
        L_0x004d:
            if (r0 >= r5) goto L_0x0059
            java.lang.Object r2 = r4.readValue(r6)
            r1.add(r2)
            int r0 = r0 + 1
            goto L_0x004d
        L_0x0059:
            r0 = r1
            goto L_0x00f7
        L_0x005c:
            int r5 = readSize(r6)
            double[] r0 = new double[r5]
            readAlignment(r6, r2)
            java.nio.DoubleBuffer r1 = r6.asDoubleBuffer()
            r1.get(r0)
            int r1 = r6.position()
            int r5 = r5 * 8
            int r1 = r1 + r5
            r6.position(r1)
            goto L_0x00f7
        L_0x0078:
            int r5 = readSize(r6)
            long[] r0 = new long[r5]
            readAlignment(r6, r2)
            java.nio.LongBuffer r1 = r6.asLongBuffer()
            r1.get(r0)
            int r1 = r6.position()
            int r5 = r5 * 8
            int r1 = r1 + r5
            r6.position(r1)
            goto L_0x00f7
        L_0x0093:
            int r5 = readSize(r6)
            int[] r0 = new int[r5]
            readAlignment(r6, r1)
            java.nio.IntBuffer r2 = r6.asIntBuffer()
            r2.get(r0)
            int r2 = r6.position()
            int r5 = r5 * 4
            int r2 = r2 + r5
            r6.position(r2)
            goto L_0x00f7
        L_0x00ae:
            byte[] r0 = readBytes(r6)
            goto L_0x00f7
        L_0x00b3:
            byte[] r5 = readBytes(r6)
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r6 = UTF8
            r0.<init>(r5, r6)
            goto L_0x00f7
        L_0x00bf:
            readAlignment(r6, r2)
            double r5 = r6.getDouble()
            java.lang.Double r0 = java.lang.Double.valueOf(r5)
            goto L_0x00f7
        L_0x00cb:
            byte[] r5 = readBytes(r6)
            java.math.BigInteger r0 = new java.math.BigInteger
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r1 = UTF8
            r6.<init>(r5, r1)
            r5 = 16
            r0.<init>(r6, r5)
            goto L_0x00f7
        L_0x00de:
            long r5 = r6.getLong()
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            goto L_0x00f7
        L_0x00e7:
            int r5 = r6.getInt()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            goto L_0x00f7
        L_0x00f0:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x00f7
        L_0x00f3:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x00f7
        L_0x00f6:
            r0 = 0
        L_0x00f7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.common.StandardMessageCodec.readValueOfType(byte, java.nio.ByteBuffer):java.lang.Object");
    }

    public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i2 = 0;
        if (obj == null || obj.equals((Object) null)) {
            byteArrayOutputStream.write(0);
        } else if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
        } else if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                writeInt(byteArrayOutputStream, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                writeLong(byteArrayOutputStream, ((Long) obj).longValue());
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                writeAlignment(byteArrayOutputStream, 8);
                writeDouble(byteArrayOutputStream, ((Number) obj).doubleValue());
            } else if (obj instanceof BigInteger) {
                byteArrayOutputStream.write(5);
                writeBytes(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(UTF8));
            } else {
                throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
            }
        } else if (obj instanceof CharSequence) {
            byteArrayOutputStream.write(7);
            writeBytes(byteArrayOutputStream, obj.toString().getBytes(UTF8));
        } else if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            writeBytes(byteArrayOutputStream, (byte[]) obj);
        } else if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            writeSize(byteArrayOutputStream, iArr.length);
            writeAlignment(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i2 < length) {
                writeInt(byteArrayOutputStream, iArr[i2]);
                i2++;
            }
        } else if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            writeSize(byteArrayOutputStream, jArr.length);
            writeAlignment(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i2 < length2) {
                writeLong(byteArrayOutputStream, jArr[i2]);
                i2++;
            }
        } else if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            writeSize(byteArrayOutputStream, dArr.length);
            writeAlignment(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i2 < length3) {
                writeDouble(byteArrayOutputStream, dArr[i2]);
                i2++;
            }
        } else if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List<Object> list = (List) obj;
            writeSize(byteArrayOutputStream, list.size());
            for (Object writeValue : list) {
                writeValue(byteArrayOutputStream, writeValue);
            }
        } else if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            writeSize(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                writeValue(byteArrayOutputStream, entry.getKey());
                writeValue(byteArrayOutputStream, entry.getValue());
            }
        } else if (obj instanceof float[]) {
            byteArrayOutputStream.write(14);
            float[] fArr = (float[]) obj;
            writeSize(byteArrayOutputStream, fArr.length);
            writeAlignment(byteArrayOutputStream, 4);
            int length4 = fArr.length;
            while (i2 < length4) {
                writeFloat(byteArrayOutputStream, fArr[i2]);
                i2++;
            }
        } else {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
    }
}
