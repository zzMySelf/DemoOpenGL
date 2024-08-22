package com.sdk.h;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public abstract class d {
    public abstract void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i2);

    public byte[] a(String str) {
        int i2;
        byte[] bArr = new byte[str.length()];
        str.getBytes(0, str.length(), bArr, 0);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
        while (true) {
            try {
                a aVar = (a) this;
                int i3 = 0;
                while (true) {
                    a aVar2 = (a) this;
                    i2 = i3 + 4;
                    if (i2 >= 72) {
                        break;
                    }
                    a aVar3 = (a) this;
                    a(pushbackInputStream, byteArrayOutputStream, 4);
                    a aVar4 = (a) this;
                    a aVar5 = (a) this;
                    i3 = i2;
                }
                a aVar6 = (a) this;
                if (i2 == 72) {
                    a aVar7 = (a) this;
                    a(pushbackInputStream, byteArrayOutputStream, 4);
                    a aVar8 = (a) this;
                } else {
                    a(pushbackInputStream, byteArrayOutputStream, 72 - i3);
                }
            } catch (c unused) {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
