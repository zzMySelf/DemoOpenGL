package com.airbnb.lottie.parser.moshi;

import fe.qw.qw.ppp.l.ad;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

public abstract class JsonReader implements Closeable {

    /* renamed from: pf  reason: collision with root package name */
    public static final String[] f626pf = new String[128];

    /* renamed from: ad  reason: collision with root package name */
    public int f627ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f628i;

    /* renamed from: o  reason: collision with root package name */
    public boolean f629o;

    /* renamed from: th  reason: collision with root package name */
    public int[] f630th = new int[32];

    /* renamed from: uk  reason: collision with root package name */
    public int[] f631uk = new int[32];

    /* renamed from: yj  reason: collision with root package name */
    public String[] f632yj = new String[32];

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final Options f633ad;
        public final String[] qw;

        public qw(String[] strArr, Options options) {
            this.qw = strArr;
            this.f633ad = options;
        }

        public static qw qw(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    JsonReader.aaa(buffer, strArr[i2]);
                    buffer.readByte();
                    byteStringArr[i2] = buffer.readByteString();
                }
                return new qw((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f626pf[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = f626pf;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static void aaa(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = f626pf;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                bufferedSink.writeUtf8(str, i2, i3);
            }
            bufferedSink.writeUtf8(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            bufferedSink.writeUtf8(str, i2, length);
        }
        bufferedSink.writeByte(34);
    }

    public static JsonReader ggg(BufferedSource bufferedSource) {
        return new ad(bufferedSource);
    }

    public abstract int ddd(qw qwVar) throws IOException;

    public abstract void de() throws IOException;

    public abstract void fe() throws IOException;

    public final String getPath() {
        return fe.qw.qw.ppp.l.qw.qw(this.f627ad, this.f630th, this.f632yj, this.f631uk);
    }

    public abstract void mmm() throws IOException;

    public abstract void nn() throws IOException;

    public abstract double pf() throws IOException;

    public abstract String ppp() throws IOException;

    public final JsonEncodingException qqq(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void rg() throws IOException;

    /* renamed from: switch  reason: not valid java name */
    public abstract int m4switch() throws IOException;

    public abstract void th() throws IOException;

    public abstract boolean uk() throws IOException;

    public abstract Token vvv() throws IOException;

    public abstract String when() throws IOException;

    public final void xxx(int i2) {
        int i3 = this.f627ad;
        int[] iArr = this.f630th;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.f630th = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f632yj;
                this.f632yj = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f631uk;
                this.f631uk = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f630th;
        int i4 = this.f627ad;
        this.f627ad = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract boolean yj() throws IOException;
}
