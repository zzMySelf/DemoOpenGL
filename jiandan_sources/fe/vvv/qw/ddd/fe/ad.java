package fe.vvv.qw.ddd.fe;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

@RequiresApi(api = 18)
public class ad extends i {
    public static final CameraLogger a = CameraLogger.qw(ad.class.getSimpleName());
    public final fe aaa;
    public C0307ad ddd;
    public yj eee = new yj();
    public rg mmm;
    public de nn;
    public qw qqq;
    public final LinkedBlockingQueue<th> rrr = new LinkedBlockingQueue<>();
    public de tt;
    public boolean xxx = false;

    /* renamed from: fe.vvv.qw.ddd.fe.ad$ad  reason: collision with other inner class name */
    public class C0307ad extends Thread {
        public final void qw(@NonNull th thVar) {
            long nanoTime = System.nanoTime() / 1000000;
            ad.a.uk("encoding thread - performing pending operation for timestamp:", Long.valueOf(thVar.f8931rg), "- encoding.");
            thVar.qw.put(thVar.f8928ad);
            ad.this.mmm.th(thVar.f8928ad);
            ad.this.rrr.remove(thVar);
            ad.this.yj(thVar);
            boolean z = thVar.f8932th;
            ad.this.eee.th(thVar);
            ad.a.uk("encoding thread - performing pending operation for timestamp:", Long.valueOf(thVar.f8931rg), "- draining.");
            ad.this.th(z);
        }

        public void run() {
            while (true) {
                if (!ad.this.rrr.isEmpty()) {
                    ad.a.uk("encoding thread - performing", Integer.valueOf(ad.this.rrr.size()), "pending operations.");
                    while (true) {
                        th thVar = (th) ad.this.rrr.peek();
                        if (thVar == null) {
                            continue;
                            break;
                        } else if (thVar.f8932th) {
                            ad.this.rg(thVar);
                            qw(thVar);
                            ad.this.eee.ad();
                            return;
                        } else if (ad.this.tt(thVar)) {
                            qw(thVar);
                        } else {
                            ad.this.k(3);
                        }
                    }
                } else {
                    ad.this.k(3);
                }
            }
        }

        public C0307ad() {
        }
    }

    public class de extends Thread {

        /* renamed from: ad  reason: collision with root package name */
        public AudioRecord f8886ad;

        /* renamed from: i  reason: collision with root package name */
        public long f8887i;

        /* renamed from: th  reason: collision with root package name */
        public ByteBuffer f8889th;

        /* renamed from: uk  reason: collision with root package name */
        public long f8890uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f8891yj;

        public final void ad(int i2, boolean z) {
            long rg2 = ad.this.aaa.rg(i2);
            this.f8890uk = rg2;
            if (this.f8887i == Long.MIN_VALUE) {
                this.f8887i = rg2;
                ad.this.m1031switch(System.currentTimeMillis() - fe.qw((long) i2, ad.this.qqq.fe()));
            }
            if (!ad.this.pf()) {
                if ((this.f8890uk - this.f8887i > ad.this.i()) && !z) {
                    ad.a.i("read thread - this frame reached the maxLength! deltaUs:", Long.valueOf(this.f8890uk - this.f8887i));
                    ad.this.when();
                }
            }
            de();
        }

        public final void de() {
            int de2 = ad.this.aaa.de(ad.this.qqq.th());
            if (de2 > 0) {
                long fe2 = ad.this.aaa.fe(this.f8890uk);
                long ad2 = fe.ad((long) ad.this.qqq.th(), ad.this.qqq.fe());
                ad.a.i("read thread - GAPS: trying to add", Integer.valueOf(de2), "noise buffers. PERFORMANCE_MAX_GAPS:", 8);
                for (int i2 = 0; i2 < Math.min(de2, 8); i2++) {
                    ByteBuffer byteBuffer = (ByteBuffer) ad.this.mmm.fe();
                    if (byteBuffer == null) {
                        ad.a.ad("read thread - GAPS: aborting because we have no free buffer.");
                        return;
                    }
                    byteBuffer.clear();
                    ad.this.tt.qw(byteBuffer);
                    byteBuffer.rewind();
                    qw(byteBuffer, fe2, false);
                    fe2 += ad2;
                }
            }
        }

        public final boolean fe(boolean z) {
            ByteBuffer byteBuffer = (ByteBuffer) ad.this.mmm.fe();
            this.f8889th = byteBuffer;
            if (byteBuffer == null) {
                if (z) {
                    ad.a.uk("read thread - eos: true - No buffer, retrying.");
                } else {
                    ad.a.i("read thread - eos: false - Skipping audio frame,", "encoding is too slow.");
                    ad.this.k(6);
                }
                return false;
            }
            byteBuffer.clear();
            this.f8891yj = this.f8886ad.read(this.f8889th, ad.this.qqq.th());
            ad.a.uk("read thread - eos:", Boolean.valueOf(z), "- Read new audio frame. Bytes:", Integer.valueOf(this.f8891yj));
            int i2 = this.f8891yj;
            if (i2 > 0) {
                ad(i2, z);
                ad.a.uk("read thread - eos:", Boolean.valueOf(z), "- mLastTimeUs:", Long.valueOf(this.f8890uk));
                this.f8889th.limit(this.f8891yj);
                qw(this.f8889th, this.f8890uk, z);
            } else if (i2 == -3) {
                ad.a.ad("read thread - eos:", Boolean.valueOf(z), "- Got AudioRecord.ERROR_INVALID_OPERATION");
            } else if (i2 == -2) {
                ad.a.ad("read thread - eos:", Boolean.valueOf(z), "- Got AudioRecord.ERROR_BAD_VALUE");
            }
            return true;
        }

        public final void qw(@NonNull ByteBuffer byteBuffer, long j, boolean z) {
            int remaining = byteBuffer.remaining();
            th thVar = (th) ad.this.eee.fe();
            thVar.f8928ad = byteBuffer;
            thVar.f8931rg = j;
            thVar.f8930fe = remaining;
            thVar.f8932th = z;
            ad.this.rrr.add(thVar);
        }

        public void run() {
            boolean z;
            this.f8886ad.startRecording();
            while (true) {
                z = false;
                if (ad.this.xxx) {
                    break;
                } else if (!ad.this.pf()) {
                    fe(false);
                }
            }
            ad.a.i("Stop was requested. We're out of the loop. Will post an endOfStream.");
            while (!z) {
                z = fe(true);
            }
            this.f8886ad.stop();
            this.f8886ad.release();
            this.f8886ad = null;
        }

        public de() {
            this.f8887i = Long.MIN_VALUE;
            setPriority(10);
            int i2 = ad.this.qqq.f8924rg;
            int qw = ad.this.qqq.qw();
            Objects.requireNonNull(ad.this.qqq);
            int minBufferSize = AudioRecord.getMinBufferSize(i2, qw, 2);
            int th2 = ad.this.qqq.th() * ad.this.qqq.ad();
            while (th2 < minBufferSize) {
                th2 += ad.this.qqq.th();
            }
            int i3 = ad.this.qqq.f8924rg;
            int qw2 = ad.this.qqq.qw();
            Objects.requireNonNull(ad.this.qqq);
            this.f8886ad = new AudioRecord(5, i3, qw2, 2, th2);
        }
    }

    public ad(@NonNull qw qwVar) {
        super("AudioEncoder");
        new HashMap();
        qw rg2 = qwVar.rg();
        this.qqq = rg2;
        this.aaa = new fe(rg2.fe());
        this.ddd = new C0307ad();
        this.nn = new de();
    }

    public void ddd() {
        this.xxx = true;
    }

    public final void k(int i2) {
        try {
            Thread.sleep(fe.qw((long) (this.qqq.th() * i2), this.qqq.fe()));
        } catch (InterruptedException unused) {
        }
    }

    public void nn() {
        super.nn();
        this.xxx = false;
        this.ddd = null;
        this.nn = null;
        rg rgVar = this.mmm;
        if (rgVar != null) {
            rgVar.ad();
            this.mmm = null;
        }
    }

    public int uk() {
        return this.qqq.qw;
    }

    public void vvv(@NonNull MediaEncoderEngine.qw qwVar, long j) {
        qw qwVar2 = this.qqq;
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(qwVar2.f8923fe, qwVar2.f8924rg, qwVar2.f8921ad);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", this.qqq.qw());
        createAudioFormat.setInteger("bitrate", this.qqq.qw);
        try {
            if (this.qqq.f8922de != null) {
                this.f8897de = MediaCodec.createByCodecName(this.qqq.f8922de);
            } else {
                this.f8897de = MediaCodec.createEncoderByType(this.qqq.f8923fe);
            }
            this.f8897de.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f8897de.start();
            this.mmm = new rg(this.qqq.th(), this.qqq.de());
            this.tt = new de(this.qqq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void xxx() {
        this.xxx = false;
        this.nn.start();
        this.ddd.start();
    }
}
