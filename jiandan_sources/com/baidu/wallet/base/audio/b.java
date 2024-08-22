package com.baidu.wallet.base.audio;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class b {
    public static final String e = "RIFF";
    public static final String f = "WAVE";
    public static final String g = "fmt ";
    public static final String h = "data";
    public short a;
    public int b;
    public short c;
    public int d;

    /* renamed from: i  reason: collision with root package name */
    public final ByteBuffer f1134i = ByteBuffer.allocate(44);
    public int j;
    public int k;

    public static b a(InputStream inputStream) {
        b bVar = new b();
        try {
            bVar.f1134i.order(ByteOrder.LITTLE_ENDIAN);
            inputStream.read(bVar.f1134i.array());
            bVar.j = bVar.f1134i.getInt(4);
            bVar.a = bVar.f1134i.getShort(22);
            bVar.b = bVar.f1134i.getInt(24);
            bVar.c = bVar.f1134i.getShort(34);
            int b2 = bVar.b(inputStream);
            bVar.k = b2;
            if (-1 == b2) {
                return bVar;
            }
            bVar.d = bVar.f1134i.getInt(40);
            return bVar;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private int b(InputStream inputStream) {
        byte[] bArr = new byte[4];
        int i2 = 36;
        do {
            try {
                this.f1134i.position(36);
                this.f1134i.get(bArr);
                int i3 = this.f1134i.getInt(40);
                if (Arrays.equals("data".getBytes(), bArr)) {
                    return i2 + 8;
                }
                inputStream.skip((long) i3);
                i2 += i3 + 8;
            } catch (IOException e2) {
                e2.printStackTrace();
                return -1;
            }
        } while (8 == inputStream.read(this.f1134i.array(), 36, 8));
        return -1;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        b bVar = new b();
        bVar.f1134i.order(ByteOrder.LITTLE_ENDIAN);
        bVar.f1134i.put(e.getBytes());
        int i6 = (i5 + 44) - 8;
        bVar.j = i6;
        bVar.f1134i.putInt(i6);
        bVar.f1134i.put(f.getBytes());
        bVar.f1134i.put(g.getBytes());
        bVar.f1134i.putInt(16);
        bVar.f1134i.putShort(1);
        short s = (short) i2;
        bVar.a = s;
        bVar.f1134i.putShort(s);
        bVar.b = i4;
        bVar.f1134i.putInt(i4);
        short s2 = (short) ((i2 * i3) / 8);
        bVar.f1134i.putInt(i4 * s2);
        bVar.f1134i.putShort(s2);
        short s3 = (short) i3;
        bVar.c = s3;
        bVar.f1134i.putShort(s3);
        bVar.f1134i.put("data".getBytes());
        bVar.k = 44;
        bVar.d = i5;
        bVar.f1134i.putInt(i5);
        return bVar;
    }

    public void a(OutputStream outputStream) {
        try {
            outputStream.write(this.f1134i.array());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(DataOutput dataOutput) {
        try {
            dataOutput.write(this.f1134i.array());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        System.out.println("--Wave Header--" + "\nfile length:" + this.j + "\nchannels:" + this.a + "\nsample rate:" + this.b + "\nbit depth:" + this.c + "\npcm length:" + this.d + "\ndata offset:" + this.k + StringUtils.LF);
    }
}
