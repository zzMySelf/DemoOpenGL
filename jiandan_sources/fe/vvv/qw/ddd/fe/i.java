package fe.vvv.qw.ddd.fe;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import fe.vvv.qw.p037if.yj;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequiresApi(api = 18)
public abstract class i {
    public static final CameraLogger vvv = CameraLogger.qw(i.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public final String f8896ad;

    /* renamed from: de  reason: collision with root package name */
    public MediaCodec f8897de;

    /* renamed from: fe  reason: collision with root package name */
    public yj f8898fe;
    public long ggg = Long.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public uk f8899i;

    /* renamed from: if  reason: not valid java name */
    public boolean f365if;

    /* renamed from: o  reason: collision with root package name */
    public final Map<String, AtomicInteger> f8900o = new HashMap();

    /* renamed from: pf  reason: collision with root package name */
    public long f8901pf;
    public long ppp = 0;
    public int qw = 0;

    /* renamed from: rg  reason: collision with root package name */
    public MediaEncoderEngine.qw f8902rg;

    /* renamed from: switch  reason: not valid java name */
    public long f366switch = 0;

    /* renamed from: th  reason: collision with root package name */
    public int f8903th;

    /* renamed from: uk  reason: collision with root package name */
    public MediaCodec.BufferInfo f8904uk;
    public long when = Long.MIN_VALUE;

    /* renamed from: yj  reason: collision with root package name */
    public pf f8905yj;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            if (i.this.qw < 2 || i.this.qw >= 3) {
                i.vvv.ad(i.this.f8896ad, "Wrong state while starting. Aborting.", Integer.valueOf(i.this.qw));
                return;
            }
            i.this.qqq(3);
            i.vvv.i(i.this.f8896ad, "Start was called. Executing.");
            i.this.xxx();
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f8907ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f8908th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Object f8910yj;

        public de(AtomicInteger atomicInteger, String str, Object obj) {
            this.f8907ad = atomicInteger;
            this.f8908th = str;
            this.f8910yj = obj;
        }

        public void run() {
            i.vvv.uk(i.this.f8896ad, "Notify was called. Executing. pendingEvents:", Integer.valueOf(this.f8907ad.intValue()));
            i.this.ppp(this.f8908th, this.f8910yj);
            this.f8907ad.decrementAndGet();
        }
    }

    public class fe implements Runnable {
        public fe() {
        }

        public void run() {
            i.vvv.i(i.this.f8896ad, "Stop was called. Executing.");
            i.this.ddd();
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MediaEncoderEngine.qw f8912ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f8913th;

        public qw(MediaEncoderEngine.qw qwVar, long j) {
            this.f8912ad = qwVar;
            this.f8913th = j;
        }

        public void run() {
            i.vvv.de(i.this.f8896ad, "Prepare was called. Executing.");
            i.this.qqq(1);
            i.this.vvv(this.f8912ad, this.f8913th);
            i.this.qqq(2);
        }
    }

    public i(@NonNull String str) {
        this.f8896ad = str;
    }

    public final void aaa(@NonNull MediaEncoderEngine.qw qwVar, long j) {
        int i2 = this.qw;
        if (i2 >= 1) {
            vvv.ad(this.f8896ad, "Wrong state while preparing. Aborting.", Integer.valueOf(i2));
            return;
        }
        this.f8902rg = qwVar;
        this.f8904uk = new MediaCodec.BufferInfo();
        this.f8901pf = j;
        yj fe2 = yj.fe(this.f8896ad);
        this.f8898fe = fe2;
        fe2.yj().setPriority(10);
        vvv.de(this.f8896ad, "Prepare was called. Posting.");
        this.f8898fe.i(new qw(qwVar, j));
    }

    public abstract void ddd();

    public final void eee() {
        vvv.i(this.f8896ad, "Start was called. Posting.");
        this.f8898fe.i(new ad());
    }

    public final void ggg() {
        if (this.f365if) {
            vvv.i(this.f8896ad, "onMaxLengthReached: Called twice.");
            return;
        }
        this.f365if = true;
        int i2 = this.qw;
        if (i2 >= 5) {
            vvv.i(this.f8896ad, "onMaxLengthReached: Reached in wrong state. Aborting.", Integer.valueOf(i2));
            return;
        }
        vvv.i(this.f8896ad, "onMaxLengthReached: Requesting a stop.");
        qqq(5);
        this.f8902rg.fe(this.f8903th);
    }

    public long i() {
        return this.f8901pf;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m1030if(@NonNull String str, @Nullable Object obj) {
        if (!this.f8900o.containsKey(str)) {
            this.f8900o.put(str, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.f8900o.get(str);
        atomicInteger.incrementAndGet();
        vvv.uk(this.f8896ad, "Notify was called. Posting. pendingEvents:", Integer.valueOf(atomicInteger.intValue()));
        this.f8898fe.i(new de(atomicInteger, str, obj));
    }

    @CallSuper
    public void mmm(@NonNull pf pfVar, @NonNull o oVar) {
        this.f8902rg.rg(pfVar, oVar);
    }

    @CallSuper
    public void nn() {
        vvv.i(this.f8896ad, "is being released. Notifying controller and releasing codecs.");
        this.f8902rg.de(this.f8903th);
        this.f8897de.stop();
        this.f8897de.release();
        this.f8897de = null;
        this.f8905yj.ad();
        this.f8905yj = null;
        this.f8899i = null;
        qqq(7);
        this.f8898fe.qw();
    }

    public final int o(@NonNull String str) {
        return this.f8900o.get(str).intValue();
    }

    public boolean pf() {
        return this.f365if;
    }

    public void ppp(@NonNull String str, @Nullable Object obj) {
    }

    public final void qqq(int i2) {
        if (this.ggg == Long.MIN_VALUE) {
            this.ggg = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.ggg;
        this.ggg = System.currentTimeMillis();
        String str = null;
        switch (i2) {
            case 0:
                str = "NONE";
                break;
            case 1:
                str = "PREPARING";
                break;
            case 2:
                str = "PREPARED";
                break;
            case 3:
                str = "STARTING";
                break;
            case 4:
                str = "STARTED";
                break;
            case 5:
                str = "LIMIT_REACHED";
                break;
            case 6:
                str = "STOPPING";
                break;
            case 7:
                str = "STOPPED";
                break;
        }
        vvv.i(this.f8896ad, "setState:", str, "millisSinceLastState:", Long.valueOf(currentTimeMillis));
        this.qw = i2;
    }

    public void rg(@NonNull th thVar) {
        do {
        } while (!tt(thVar));
    }

    public final void rrr() {
        int i2 = this.qw;
        if (i2 >= 6) {
            vvv.ad(this.f8896ad, "Wrong state while stopping. Aborting.", Integer.valueOf(i2));
            return;
        }
        qqq(6);
        vvv.i(this.f8896ad, "Stop was called. Posting.");
        this.f8898fe.i(new fe());
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m1031switch(long j) {
        this.f366switch = j;
    }

    @SuppressLint({"LogNotTimber"})
    public final void th(boolean z) {
        vvv.de(this.f8896ad, "DRAINING - EOS:", Boolean.valueOf(z));
        MediaCodec mediaCodec = this.f8897de;
        if (mediaCodec == null) {
            vvv.ad("drain() was called before prepare() or after releasing.");
            return;
        }
        if (this.f8899i == null) {
            this.f8899i = new uk(mediaCodec);
        }
        while (true) {
            int dequeueOutputBuffer = this.f8897de.dequeueOutputBuffer(this.f8904uk, 0);
            vvv.de(this.f8896ad, "DRAINING - Got status:", Integer.valueOf(dequeueOutputBuffer));
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                this.f8899i.de();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f8902rg.qw()) {
                    this.f8903th = this.f8902rg.ad(this.f8897de.getOutputFormat());
                    qqq(4);
                    this.f8905yj = new pf(this.f8903th);
                } else {
                    throw new RuntimeException("MediaFormat changed twice.");
                }
            } else if (dequeueOutputBuffer < 0) {
                CameraLogger cameraLogger = vvv;
                cameraLogger.ad("Unexpected result from dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer ad2 = this.f8899i.ad(dequeueOutputBuffer);
                if (!((this.f8904uk.flags & 2) != 0) && this.f8902rg.qw()) {
                    MediaCodec.BufferInfo bufferInfo = this.f8904uk;
                    if (bufferInfo.size != 0) {
                        ad2.position(bufferInfo.offset);
                        MediaCodec.BufferInfo bufferInfo2 = this.f8904uk;
                        ad2.limit(bufferInfo2.offset + bufferInfo2.size);
                        if (this.when == Long.MIN_VALUE) {
                            long j = this.f8904uk.presentationTimeUs;
                            this.when = j;
                            vvv.i(this.f8896ad, "DRAINING - Got the first presentation time:", Long.valueOf(j));
                        }
                        MediaCodec.BufferInfo bufferInfo3 = this.f8904uk;
                        long j2 = bufferInfo3.presentationTimeUs;
                        this.ppp = j2;
                        long j3 = ((this.f366switch * 1000) + j2) - this.when;
                        bufferInfo3.presentationTimeUs = j3;
                        vvv.uk(this.f8896ad, "DRAINING - About to write(). Adjusted presentation:", Long.valueOf(j3));
                        o oVar = (o) this.f8905yj.fe();
                        oVar.qw = this.f8904uk;
                        oVar.f8919ad = this.f8903th;
                        oVar.f8920de = ad2;
                        mmm(this.f8905yj, oVar);
                    }
                }
                this.f8897de.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (!z && !this.f365if) {
                    long j4 = this.when;
                    if (j4 != Long.MIN_VALUE) {
                        long j5 = this.ppp;
                        if (j5 - j4 > this.f8901pf) {
                            vvv.i(this.f8896ad, "DRAINING - Reached maxLength! mLastTimeUs:", Long.valueOf(j5), "mStartTimeUs:", Long.valueOf(this.when), "mDeltaUs:", Long.valueOf(this.ppp - this.when), "mMaxLengthUs:", Long.valueOf(this.f8901pf));
                            ggg();
                            return;
                        }
                    }
                }
                if ((this.f8904uk.flags & 4) != 0) {
                    vvv.i(this.f8896ad, "DRAINING - Got EOS. Releasing the codec.");
                    nn();
                    return;
                }
            }
        }
    }

    public boolean tt(@NonNull th thVar) {
        if (this.f8899i == null) {
            this.f8899i = new uk(this.f8897de);
        }
        int dequeueInputBuffer = this.f8897de.dequeueInputBuffer(0);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        thVar.f8929de = dequeueInputBuffer;
        thVar.qw = this.f8899i.qw(dequeueInputBuffer);
        return true;
    }

    public abstract int uk();

    public abstract void vvv(@NonNull MediaEncoderEngine.qw qwVar, long j);

    public void when() {
        ggg();
    }

    public abstract void xxx();

    public void yj(th thVar) {
        th thVar2 = thVar;
        vvv.uk(this.f8896ad, "ENCODING - Buffer:", Integer.valueOf(thVar2.f8929de), "Bytes:", Integer.valueOf(thVar2.f8930fe), "Presentation:", Long.valueOf(thVar2.f8931rg));
        if (thVar2.f8932th) {
            this.f8897de.queueInputBuffer(thVar2.f8929de, 0, 0, thVar2.f8931rg, 4);
        } else {
            this.f8897de.queueInputBuffer(thVar2.f8929de, 0, thVar2.f8930fe, thVar2.f8931rg, 0);
        }
    }
}
