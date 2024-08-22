package com.baidu.wallet.core.beans.a;

import com.baidu.apollon.restnet.RestMultipartEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class b extends RestMultipartEntity {
    public b() {
        this.b = new ByteArrayOutputStream();
        this.d = false;
        this.e = false;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = RestMultipartEntity.a;
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.e = true;
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        try {
            e();
            ByteArrayOutputStream byteArrayOutputStream = this.b;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; fileName=\"" + str2 + "\"\r\n").getBytes());
            if (str3 != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = this.b;
                byteArrayOutputStream2.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
                ByteArrayOutputStream byteArrayOutputStream3 = this.b;
                StringBuilder sb = new StringBuilder();
                sb.append("file: ");
                byteArrayOutputStream3.write(sb.toString().getBytes());
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            inputStream.close();
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th2;
        }
    }
}
