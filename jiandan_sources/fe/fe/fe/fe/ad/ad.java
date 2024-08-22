package fe.fe.fe.fe.ad;

import com.baidu.cesium.c.b.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;

public class ad implements d {

    /* renamed from: ad  reason: collision with root package name */
    public static final int[] f1832ad = when(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    public final int qw;

    public ad(int i2) {
        this.qw = i2;
    }

    public static int ad(int i2, int i3) {
        return (i2 >>> (-i3)) | (i2 << i3);
    }

    public static void th(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i2 = 0; i2 < 10; i2++) {
            yj(iArr2, 0, 4, 8, 12);
            yj(iArr2, 1, 5, 9, 13);
            yj(iArr2, 2, 6, 10, 14);
            yj(iArr2, 3, 7, 11, 15);
            yj(iArr2, 0, 5, 10, 15);
            yj(iArr2, 1, 6, 11, 12);
            yj(iArr2, 2, 7, 8, 13);
            yj(iArr2, 3, 4, 9, 14);
        }
    }

    public static void uk(int[] iArr, int[] iArr2) {
        int[] iArr3 = f1832ad;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, f1832ad.length, 8);
    }

    public static int[] when(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public static void yj(int[] iArr, int i2, int i3, int i4, int i5) {
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = ad(iArr[i5] ^ iArr[i2], 16);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = ad(iArr[i3] ^ iArr[i4], 12);
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = ad(iArr[i2] ^ iArr[i5], 8);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = ad(iArr[i3] ^ iArr[i4], 7);
    }

    public ByteBuffer de(byte[] bArr, byte[] bArr2, int i2) {
        int[] iArr = m103if(when(bArr), when(bArr2), i2);
        int[] iArr2 = (int[]) iArr.clone();
        th(iArr2);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = iArr[i3] + iArr2[i3];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(iArr, 0, 16);
        return order;
    }

    public void fe(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() - qw() >= bArr.length) {
            if (bArr2 == null) {
                bArr2 = new byte[qw()];
                new Random().nextBytes(bArr2);
            }
            byteBuffer.put(bArr2);
            rg(bArr2, fe.fe.fe.fe.de.ad.qw(), byteBuffer, ByteBuffer.wrap(bArr));
            return;
        }
        throw new IllegalArgumentException("data output is too small");
    }

    public byte[] i(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= qw()) {
            byte[] bArr = new byte[qw()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            rg(bArr, fe.fe.fe.fe.de.ad.ad(), allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too short");
    }

    /* renamed from: if  reason: not valid java name */
    public int[] m103if(int[] iArr, int[] iArr2, int i2) {
        if (iArr.length == qw() / 4) {
            int[] iArr3 = new int[16];
            uk(iArr3, iArr2);
            iArr3[12] = i2;
            System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
            return iArr3;
        }
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", new Object[]{Integer.valueOf(iArr.length * 32)}));
    }

    public byte[] o(byte[] bArr) {
        return pf(bArr, (byte[]) null);
    }

    public byte[] pf(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= Integer.MAX_VALUE - qw()) {
            ByteBuffer allocate = ByteBuffer.allocate(qw() + bArr.length);
            fe(allocate, bArr, bArr2);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too long");
    }

    public int qw() {
        return 12;
    }

    public final void rg(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer2.remaining();
        int i2 = (remaining / 64) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer de2 = de(bArr, bArr2, this.qw + i3);
            if (i3 == i2 - 1) {
                qw.qw(byteBuffer, byteBuffer2, de2, remaining % 64);
            } else {
                qw.qw(byteBuffer, byteBuffer2, de2, 64);
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public byte[] m104switch(byte[] bArr) {
        return i(ByteBuffer.wrap(bArr));
    }
}
