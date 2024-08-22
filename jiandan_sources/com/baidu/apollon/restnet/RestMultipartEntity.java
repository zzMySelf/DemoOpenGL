package com.baidu.apollon.restnet;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class RestMultipartEntity {
    public static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public ByteArrayOutputStream b = new ByteArrayOutputStream();
    public String c;
    public boolean d;
    public boolean e;
    public byte[] f;
    public ProgressListener g;

    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    public RestMultipartEntity() {
        this.d = false;
        this.e = false;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = a;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.c = sb.toString();
        this.f = ("\r\n--" + this.c + "\r\n").getBytes();
    }

    private void e() throws IOException {
        if (!this.d) {
            this.d = true;
            ByteArrayOutputStream byteArrayOutputStream = this.b;
            byteArrayOutputStream.write(("--" + this.c + "\r\n").getBytes());
            return;
        }
        this.b.write(this.f);
    }

    private void f() {
        if (!this.e) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = this.b;
                byteArrayOutputStream.write(("\r\n--" + this.c + "--\r\n").getBytes());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.e = true;
        }
    }

    public String a() {
        return this.c;
    }

    public void addPart(String str, String str2) {
        a(str, str2, false);
    }

    public OutputStream b() {
        return this.b;
    }

    public ProgressListener c() {
        return this.g;
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream = this.b;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public long d() {
        f();
        return (long) this.b.toByteArray().length;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.g = progressListener;
    }

    public void a(String str, String str2, boolean z) {
        try {
            e();
            ByteArrayOutputStream byteArrayOutputStream = this.b;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.b.write(str2.getBytes());
            if (z) {
                f();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        try {
            e();
            ByteArrayOutputStream byteArrayOutputStream = this.b;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
            if (str3 != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = this.b;
                byteArrayOutputStream2.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
            } else {
                this.b.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                this.b.write(bArr, 0, read);
            }
            if (z) {
                f();
            }
            this.b.flush();
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            inputStream.close();
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
    }

    public static class a extends FilterOutputStream {
        public final ProgressListener a;
        public final long b;
        public long c = 0;

        public a(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            this.b = j;
            this.a = progressListener;
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.out.write(bArr, i2, i3);
            long j = this.c + ((long) i3);
            this.c = j;
            ProgressListener progressListener = this.a;
            if (progressListener != null) {
                progressListener.transferred(j, this.b);
            }
        }

        public void write(int i2) throws IOException {
            this.out.write(i2);
            long j = this.c + 1;
            this.c = j;
            ProgressListener progressListener = this.a;
            if (progressListener != null) {
                progressListener.transferred(j, this.b);
            }
        }
    }

    public void a(String str, String str2, InputStream inputStream, String str3) {
        addPart(str, str2, inputStream, str3, false);
    }

    public void a(OutputStream outputStream) throws IOException {
        f();
        a aVar = new a(d(), outputStream, this.g);
        aVar.write(this.b.toByteArray());
        aVar.close();
    }
}
