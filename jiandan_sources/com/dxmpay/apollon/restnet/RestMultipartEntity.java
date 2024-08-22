package com.dxmpay.apollon.restnet;

import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class RestMultipartEntity {

    /* renamed from: yj  reason: collision with root package name */
    public static final char[] f4011yj = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: ad  reason: collision with root package name */
    public String f4012ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f4013de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4014fe;
    public ByteArrayOutputStream qw = new ByteArrayOutputStream();

    /* renamed from: rg  reason: collision with root package name */
    public byte[] f4015rg;

    /* renamed from: th  reason: collision with root package name */
    public ProgressListener f4016th;

    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    public RestMultipartEntity() {
        this.f4013de = false;
        this.f4014fe = false;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = f4011yj;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f4012ad = sb.toString();
        this.f4015rg = ("\r\n--" + this.f4012ad + "\r\n").getBytes();
    }

    public void ad(OutputStream outputStream) throws IOException {
        th();
        qw qwVar = new qw(fe(), outputStream, this.f4016th);
        qwVar.write(this.qw.toByteArray());
        qwVar.close();
    }

    public void addPart(String str, String str2) {
        de(str, str2, false);
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream = this.qw;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void de(String str, String str2, boolean z) {
        try {
            rg();
            ByteArrayOutputStream byteArrayOutputStream = this.qw;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.qw.write(str2.getBytes());
            if (z) {
                th();
            }
        } catch (IOException e) {
            LogUtil.e("RestMultipartEntity", e.getMessage(), e);
        }
    }

    public long fe() {
        th();
        return (long) this.qw.toByteArray().length;
    }

    public String qw() {
        return this.f4012ad;
    }

    public final void rg() throws IOException {
        if (!this.f4013de) {
            this.f4013de = true;
            ByteArrayOutputStream byteArrayOutputStream = this.qw;
            byteArrayOutputStream.write(("--" + this.f4012ad + "\r\n").getBytes());
            return;
        }
        this.qw.write(this.f4015rg);
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.f4016th = progressListener;
    }

    public final void th() {
        if (!this.f4014fe) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = this.qw;
                byteArrayOutputStream.write(("\r\n--" + this.f4012ad + "--\r\n").getBytes());
            } catch (IOException e) {
                LogUtil.e("RestMultipartEntity", e.getMessage(), e);
            }
            this.f4014fe = true;
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        try {
            rg();
            ByteArrayOutputStream byteArrayOutputStream = this.qw;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
            if (str3 != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = this.qw;
                byteArrayOutputStream2.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
            } else {
                this.qw.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                this.qw.write(bArr, 0, read);
            }
            if (z) {
                th();
            }
            this.qw.flush();
            try {
                inputStream.close();
            } catch (IOException e) {
                LogUtil.e("RestMultipartEntity", e.getMessage(), e);
            }
        } catch (IOException e2) {
            LogUtil.e("RestMultipartEntity", e2.getMessage(), e2);
            inputStream.close();
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                LogUtil.e("RestMultipartEntity", e3.getMessage(), e3);
            }
            throw th2;
        }
    }

    public static class qw extends FilterOutputStream {

        /* renamed from: ad  reason: collision with root package name */
        public final ProgressListener f4017ad;

        /* renamed from: th  reason: collision with root package name */
        public final long f4018th;

        /* renamed from: yj  reason: collision with root package name */
        public long f4019yj = 0;

        public qw(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            this.f4018th = j;
            this.f4017ad = progressListener;
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.out.write(bArr, i2, i3);
            long j = this.f4019yj + ((long) i3);
            this.f4019yj = j;
            ProgressListener progressListener = this.f4017ad;
            if (progressListener != null) {
                progressListener.transferred(j, this.f4018th);
            }
        }

        public void write(int i2) throws IOException {
            this.out.write(i2);
            long j = this.f4019yj + 1;
            this.f4019yj = j;
            ProgressListener progressListener = this.f4017ad;
            if (progressListener != null) {
                progressListener.transferred(j, this.f4018th);
            }
        }
    }
}
