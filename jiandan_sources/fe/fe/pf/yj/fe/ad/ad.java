package fe.fe.pf.yj.fe.ad;

import com.baidu.helios.common.internal.crypto.IndCpaCipher;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;

public class ad implements IndCpaCipher {

    /* renamed from: ad  reason: collision with root package name */
    public static final int[] f2963ad = when(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    public final int qw;

    public ad(int i2) {
        this.qw = i2;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m205if(int[] iArr, int[] iArr2) {
        int[] iArr3 = f2963ad;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, f2963ad.length, 8);
    }

    public static void o(int[] iArr, int i2, int i3, int i4, int i5) {
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = pf(iArr[i5] ^ iArr[i2], 16);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = pf(iArr[i3] ^ iArr[i4], 12);
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = pf(iArr[i2] ^ iArr[i5], 8);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = pf(iArr[i3] ^ iArr[i4], 7);
    }

    public static int pf(int i2, int i3) {
        return (i2 >>> (-i3)) | (i2 << i3);
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m206switch(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i2 = 0; i2 < 10; i2++) {
            o(iArr2, 0, 4, 8, 12);
            o(iArr2, 1, 5, 9, 13);
            o(iArr2, 2, 6, 10, 14);
            o(iArr2, 3, 7, 11, 15);
            o(iArr2, 0, 5, 10, 15);
            o(iArr2, 1, 6, 11, 12);
            o(iArr2, 2, 7, 8, 13);
            o(iArr2, 3, 4, 9, 14);
        }
    }

    public static int[] when(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public int[] ad(int[] iArr, int[] iArr2, int i2) {
        if (iArr.length == uk() / 4) {
            int[] iArr3 = new int[16];
            m205if(iArr3, iArr2);
            iArr3[12] = i2;
            System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
            return iArr3;
        }
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", new Object[]{Integer.valueOf(iArr.length * 32)}));
    }

    public byte[] de(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= uk()) {
            byte[] bArr = new byte[uk()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            i(bArr, fe.qw(), allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too short");
    }

    public byte[] fe(byte[] bArr) throws GeneralSecurityException {
        return de(ByteBuffer.wrap(bArr));
    }

    public final void i(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int remaining = byteBuffer2.remaining();
        int i2 = (remaining / 64) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer qw2 = qw(bArr, bArr2, this.qw + i3);
            if (i3 == i2 - 1) {
                qw.qw(byteBuffer, byteBuffer2, qw2, remaining % 64);
            } else {
                qw.qw(byteBuffer, byteBuffer2, qw2, 64);
            }
        }
    }

    public ByteBuffer qw(byte[] bArr, byte[] bArr2, int i2) {
        int[] ad2 = ad(when(bArr), when(bArr2), i2);
        int[] iArr = (int[]) ad2.clone();
        m206switch(iArr);
        for (int i3 = 0; i3 < ad2.length; i3++) {
            ad2[i3] = ad2[i3] + iArr[i3];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(ad2, 0, 16);
        return order;
    }

    public void rg(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() - uk() >= bArr.length) {
            if (bArr2 == null) {
                bArr2 = new byte[uk()];
                new Random().nextBytes(bArr2);
            }
            byteBuffer.put(bArr2);
            i(bArr2, fe.ad(), byteBuffer, ByteBuffer.wrap(bArr));
            return;
        }
        throw new IllegalArgumentException("data output is too small");
    }

    public byte[] th(byte[] bArr) throws GeneralSecurityException {
        return yj(bArr, (byte[]) null);
    }

    public int uk() {
        return 12;
    }

    public byte[] yj(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= Integer.MAX_VALUE - uk()) {
            ByteBuffer allocate = ByteBuffer.allocate(uk() + bArr.length);
            rg(allocate, bArr, bArr2);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too long");
    }
}
