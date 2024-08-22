package com.otaliastudios.cameraview.video.encoding;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import fe.vvv.qw.ddd.fe.ad;
import fe.vvv.qw.ddd.fe.i;
import fe.vvv.qw.ddd.fe.o;
import fe.vvv.qw.ddd.fe.pf;
import fe.vvv.qw.ddd.fe.ppp;
import fe.vvv.qw.p037if.yj;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(api = 18)
public class MediaEncoderEngine {

    /* renamed from: if  reason: not valid java name */
    public static final CameraLogger f280if = CameraLogger.qw(MediaEncoderEngine.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public MediaMuxer f6788ad;

    /* renamed from: de  reason: collision with root package name */
    public int f6789de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public int f6790fe = 0;

    /* renamed from: i  reason: collision with root package name */
    public Listener f6791i;

    /* renamed from: o  reason: collision with root package name */
    public int f6792o = 0;

    /* renamed from: pf  reason: collision with root package name */
    public int f6793pf;
    public final List<i> qw = new ArrayList();

    /* renamed from: rg  reason: collision with root package name */
    public boolean f6794rg = false;

    /* renamed from: th  reason: collision with root package name */
    public final qw f6795th = new qw();

    /* renamed from: uk  reason: collision with root package name */
    public final Object f6796uk = new Object();

    /* renamed from: yj  reason: collision with root package name */
    public final yj f6797yj = yj.fe("EncoderEngine");

    public interface Listener {
        void ad();

        void de(int i2, @Nullable Exception exc);

        void rg();
    }

    public class qw {
        @SuppressLint({"UseSparseArrays"})
        public Map<Integer, Integer> qw = new HashMap();

        public class ad implements Runnable {
            public ad() {
            }

            public void run() {
                MediaEncoderEngine.this.ddd();
            }
        }

        public class de implements Runnable {
            public de() {
            }

            public void run() {
                MediaEncoderEngine.this.ppp();
            }
        }

        /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine$qw$qw  reason: collision with other inner class name */
        public class C0260qw implements Runnable {
            public C0260qw() {
            }

            public void run() {
                MediaEncoderEngine.this.f6788ad.start();
                boolean unused = MediaEncoderEngine.this.f6794rg = true;
                if (MediaEncoderEngine.this.f6791i != null) {
                    MediaEncoderEngine.this.f6791i.ad();
                }
            }
        }

        public qw() {
        }

        public int ad(@NonNull MediaFormat mediaFormat) {
            int addTrack;
            synchronized (MediaEncoderEngine.this.f6796uk) {
                if (!MediaEncoderEngine.this.f6794rg) {
                    addTrack = MediaEncoderEngine.this.f6788ad.addTrack(mediaFormat);
                    MediaEncoderEngine.f280if.i("notifyStarted:", "Assigned track", Integer.valueOf(addTrack), "to format", mediaFormat.getString("mime"));
                    if (MediaEncoderEngine.uk(MediaEncoderEngine.this) == MediaEncoderEngine.this.qw.size()) {
                        MediaEncoderEngine.f280if.i("notifyStarted:", "All encoders have started.", "Starting muxer and dispatching onEncodingStart().");
                        MediaEncoderEngine.this.f6797yj.pf(new C0260qw());
                    }
                } else {
                    throw new IllegalStateException("Trying to start but muxer started already");
                }
            }
            return addTrack;
        }

        public void de(int i2) {
            synchronized (MediaEncoderEngine.this.f6796uk) {
                MediaEncoderEngine.f280if.i("notifyStopped:", "Called for track", Integer.valueOf(i2));
                if (MediaEncoderEngine.de(MediaEncoderEngine.this) == MediaEncoderEngine.this.qw.size()) {
                    MediaEncoderEngine.f280if.i("requestStop:", "All encoders have been stopped.", "Stopping the muxer.");
                    MediaEncoderEngine.this.f6797yj.pf(new de());
                }
            }
        }

        public void fe(int i2) {
            synchronized (MediaEncoderEngine.this.f6796uk) {
                MediaEncoderEngine.f280if.i("requestStop:", "Called for track", Integer.valueOf(i2));
                if (MediaEncoderEngine.i(MediaEncoderEngine.this) == 0) {
                    MediaEncoderEngine.f280if.i("requestStop:", "All encoders have requested a stop.", "Stopping them.");
                    int unused = MediaEncoderEngine.this.f6792o = MediaEncoderEngine.this.f6793pf;
                    MediaEncoderEngine.this.f6797yj.pf(new ad());
                }
            }
        }

        public boolean qw() {
            boolean ad2;
            synchronized (MediaEncoderEngine.this.f6796uk) {
                ad2 = MediaEncoderEngine.this.f6794rg;
            }
            return ad2;
        }

        public void rg(@NonNull pf pfVar, @NonNull o oVar) {
            int i2;
            Integer num = this.qw.get(Integer.valueOf(oVar.f8919ad));
            Map<Integer, Integer> map = this.qw;
            Integer valueOf = Integer.valueOf(oVar.f8919ad);
            if (num == null) {
                i2 = 1;
            } else {
                num = Integer.valueOf(num.intValue() + 1);
                i2 = num.intValue();
            }
            map.put(valueOf, Integer.valueOf(i2));
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(oVar.qw.presentationTimeUs / 1000);
            CameraLogger yj2 = MediaEncoderEngine.f280if;
            yj2.uk("write:", "Writing into muxer -", "track:", Integer.valueOf(oVar.f8919ad), "presentation:", Long.valueOf(oVar.qw.presentationTimeUs), "readable:", instance.get(13) + ":" + instance.get(14), "count:", num);
            MediaEncoderEngine.this.f6788ad.writeSampleData(oVar.f8919ad, oVar.f8920de, oVar.qw);
            pfVar.th(oVar);
        }
    }

    public MediaEncoderEngine(@NonNull File file, @NonNull ppp ppp, @Nullable ad adVar, int i2, long j, @Nullable Listener listener) {
        this.f6791i = listener;
        this.qw.add(ppp);
        if (adVar != null) {
            this.qw.add(adVar);
        }
        try {
            this.f6788ad = new MediaMuxer(file.toString(), 0);
            int i3 = 0;
            for (i uk2 : this.qw) {
                i3 += uk2.uk();
            }
            long j2 = (j / ((long) (i3 / 8))) * 1000 * 1000;
            long j3 = ((long) i2) * 1000;
            int i4 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i4 > 0 && i2 > 0) {
                this.f6793pf = j2 < j3 ? 2 : 1;
                j2 = Math.min(j2, j3);
            } else if (i4 > 0) {
                this.f6793pf = 2;
            } else if (i2 > 0) {
                this.f6793pf = 1;
                j2 = j3;
            } else {
                j2 = Long.MAX_VALUE;
            }
            f280if.i("Computed a max duration of", Float.valueOf(((float) j2) / 1000000.0f));
            for (i aaa : this.qw) {
                aaa.aaa(this.f6795th, j2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static /* synthetic */ int de(MediaEncoderEngine mediaEncoderEngine) {
        int i2 = mediaEncoderEngine.f6790fe + 1;
        mediaEncoderEngine.f6790fe = i2;
        return i2;
    }

    public static /* synthetic */ int i(MediaEncoderEngine mediaEncoderEngine) {
        int i2 = mediaEncoderEngine.f6789de - 1;
        mediaEncoderEngine.f6789de = i2;
        return i2;
    }

    public static /* synthetic */ int uk(MediaEncoderEngine mediaEncoderEngine) {
        int i2 = mediaEncoderEngine.f6789de + 1;
        mediaEncoderEngine.f6789de = i2;
        return i2;
    }

    public final void ddd() {
        f280if.de("Passing event to encoders:", "STOP");
        for (i rrr : this.qw) {
            rrr.rrr();
        }
        Listener listener = this.f6791i;
        if (listener != null) {
            listener.rg();
        }
    }

    @NonNull
    public ppp ggg() {
        return (ppp) this.qw.get(0);
    }

    public final void ppp() {
        f280if.de("end:", "Releasing muxer after all encoders have been released.");
        MediaMuxer mediaMuxer = this.f6788ad;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                e = null;
            } catch (Exception e) {
                e = e;
            }
            try {
                this.f6788ad.release();
            } catch (Exception e2) {
                if (e == null) {
                    e = e2;
                }
            }
            this.f6788ad = null;
        } else {
            e = null;
        }
        f280if.i("end:", "Dispatching end to listener - reason:", Integer.valueOf(this.f6792o), "error:", e);
        Listener listener = this.f6791i;
        if (listener != null) {
            listener.de(this.f6792o, e);
            this.f6791i = null;
        }
        this.f6792o = 0;
        this.f6789de = 0;
        this.f6790fe = 0;
        this.f6794rg = false;
        this.f6797yj.qw();
        f280if.de("end:", "Completed.");
    }

    public final void vvv(String str, Object obj) {
        f280if.uk("Passing event to encoders:", str);
        for (i iVar : this.qw) {
            iVar.m1030if(str, obj);
        }
    }

    public final void xxx() {
        f280if.de("Passing event to encoders:", "START");
        for (i eee : this.qw) {
            eee.eee();
        }
    }
}
