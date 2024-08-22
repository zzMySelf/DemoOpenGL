package com.otaliastudios.cameraview.frame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.vvv.qw.o.ad;
import fe.vvv.qw.yj.i.qw;
import java.util.concurrent.LinkedBlockingQueue;

public class ByteBufferFrameManager extends ad<byte[]> {

    /* renamed from: i  reason: collision with root package name */
    public LinkedBlockingQueue<byte[]> f6744i;

    /* renamed from: o  reason: collision with root package name */
    public BufferCallback f6745o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f6746pf;

    public interface BufferCallback {
        void ad(@NonNull byte[] bArr);
    }

    public ByteBufferFrameManager(int i2, @Nullable BufferCallback bufferCallback) {
        super(i2, byte[].class);
        if (bufferCallback != null) {
            this.f6745o = bufferCallback;
            this.f6746pf = 0;
            return;
        }
        this.f6744i = new LinkedBlockingQueue<>(i2);
        this.f6746pf = 1;
    }

    public void i(int i2, @NonNull fe.vvv.qw.xxx.ad adVar, @NonNull qw qwVar) {
        super.i(i2, adVar, qwVar);
        int ad2 = ad();
        for (int i3 = 0; i3 < fe(); i3++) {
            if (this.f6746pf == 0) {
                this.f6745o.ad(new byte[ad2]);
            } else {
                this.f6744i.offer(new byte[ad2]);
            }
        }
    }

    /* renamed from: o */
    public void th(@NonNull byte[] bArr, boolean z) {
        if (z && bArr.length == ad()) {
            if (this.f6746pf == 0) {
                this.f6745o.ad(bArr);
            } else {
                this.f6744i.offer(bArr);
            }
        }
    }

    public void uk() {
        super.uk();
        if (this.f6746pf == 1) {
            this.f6744i.clear();
        }
    }
}
