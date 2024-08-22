package com.baidu.wallet.base.audio;

import com.baidu.pass.permissions.PermissionsHelperActivity;
import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;

public class AudioVolume {
    public static final String a = "AudioVolume";
    public int b;
    public int c = PermissionsHelperActivity.e;
    public long d;
    public double e;

    public AudioVolume(int i2) {
        a(i2);
    }

    private void a(int i2) {
        this.b = 0;
        this.d = (long) 0;
        if (512 < i2) {
            this.c = i2;
        } else {
            this.c = PermissionsHelperActivity.e;
        }
    }

    public void calAccumulatedVolume(ByteBuffer byteBuffer, boolean z) {
        int i2;
        int i3;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (z) {
            position >>= 1;
            limit >>= 1;
            i3 = this.c >> 1;
            i2 = this.b;
        } else {
            i3 = this.c;
            i2 = this.b;
        }
        int i4 = i3 - i2;
        int i5 = limit - position;
        if (i4 >= i5) {
            while (position < limit) {
                this.d = (long) (((double) this.d) + Math.pow((double) (z ? byteBuffer.getShort(position) : (short) byteBuffer.get(position)), 2.0d));
                position++;
            }
            this.b += i5;
            return;
        }
        int i6 = i4 + position;
        while (position < i6) {
            short s = z ? byteBuffer.getShort(position) : (short) byteBuffer.get(position);
            LogUtil.d(a, "value: " + s);
            this.d = (long) (((double) this.d) + Math.pow((double) s, 2.0d));
            position++;
        }
        this.e = Math.log10((double) ((int) (this.d / ((long) this.c)))) * 10.0d;
        LogUtil.i(a, "calAccumulatedVolume: " + this.e + "|" + i6 + "|" + this.d);
        this.d = 0;
        this.b = 0;
        for (int i7 = i6; i7 < limit; i7++) {
            this.d = (long) (((double) this.d) + Math.pow((double) (z ? byteBuffer.getShort(i7) : byteBuffer.get(i7)), 2.0d));
        }
        this.b += limit - i6;
    }

    public double getVolume() {
        return this.e;
    }
}
