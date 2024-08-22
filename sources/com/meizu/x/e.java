package com.meizu.x;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;

public class e implements Serializable, Comparable<e> {

    /* renamed from: d  reason: collision with root package name */
    static final char[] f5367d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e  reason: collision with root package name */
    public static final e f5368e = a(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    final byte[] f5369a;

    /* renamed from: b  reason: collision with root package name */
    transient int f5370b;

    /* renamed from: c  reason: collision with root package name */
    transient String f5371c;

    e(byte[] bArr) {
        this.f5369a = bArr;
    }

    public static e a(InputStream inputStream, int i2) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i2 >= 0) {
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, i3, i2 - i3);
                if (read != -1) {
                    i3 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new e(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i2);
        }
    }

    private e a(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f5369a));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static e a(byte... bArr) {
        if (bArr != null) {
            return new e((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static e b(String str) {
        if (str != null) {
            e eVar = new e(str.getBytes(o.f5397a));
            eVar.f5371c = str;
            return eVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        e a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = e.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.f5369a);
        } catch (NoSuchFieldException e2) {
            throw new AssertionError();
        } catch (IllegalAccessException e3) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f5369a.length);
        objectOutputStream.write(this.f5369a);
    }

    public byte a(int i2) {
        return this.f5369a[i2];
    }

    /* renamed from: a */
    public int compareTo(e eVar) {
        int c2 = c();
        int c3 = eVar.c();
        int min = Math.min(c2, c3);
        for (int i2 = 0; i2 < min; i2++) {
            byte a2 = a(i2) & UByte.MAX_VALUE;
            byte a3 = eVar.a(i2) & UByte.MAX_VALUE;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (c2 == c3) {
            return 0;
        }
        return c2 < c3 ? -1 : 1;
    }

    public String a() {
        byte[] bArr = this.f5369a;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f5367d;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        byte[] bArr = this.f5369a;
        bVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        byte[] bArr2 = this.f5369a;
        return i2 <= bArr2.length - i4 && i3 <= bArr.length - i4 && o.a(bArr2, i2, bArr, i3, i4);
    }

    public e b() {
        return a("MD5");
    }

    public int c() {
        return this.f5369a.length;
    }

    public String d() {
        String str = this.f5371c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f5369a, o.f5397a);
        this.f5371c = str2;
        return str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            int c2 = eVar.c();
            byte[] bArr = this.f5369a;
            if (c2 == bArr.length && eVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f5370b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.f5369a);
        this.f5370b = hashCode;
        return hashCode;
    }

    public String toString() {
        byte[] bArr = this.f5369a;
        if (bArr.length == 0) {
            return "ByteString[size=0]";
        }
        if (bArr.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(bArr.length), a()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(bArr.length), b().a()});
    }
}
