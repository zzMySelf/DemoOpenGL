package com.otaliastudios.cameraview.video;

import android.hardware.camera2.CaptureRequest;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import fe.vvv.qw.rg;
import fe.vvv.qw.yj.fe.de;
import fe.vvv.qw.yj.fe.fe;

@RequiresApi(21)
public class Full2VideoRecorder extends fe.vvv.qw.ddd.ad {

    /* renamed from: if  reason: not valid java name */
    public final String f278if;

    /* renamed from: pf  reason: collision with root package name */
    public ActionHolder f6782pf;

    /* renamed from: switch  reason: not valid java name */
    public Surface f279switch;

    public class PrepareException extends Exception {
        public /* synthetic */ PrepareException(Full2VideoRecorder full2VideoRecorder, Throwable th2, qw qwVar) {
            this(th2);
        }

        public PrepareException(Throwable th2) {
            super(th2);
        }
    }

    public class ad extends fe {
        public ad() {
        }

        public void ad(@NonNull Action action) {
            Full2VideoRecorder.super.m1026if();
        }
    }

    public class qw extends de {
        public qw(Full2VideoRecorder full2VideoRecorder) {
        }

        public void de(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
            super.de(actionHolder, captureRequest);
            Object tag = actionHolder.rg(this).build().getTag();
            Object tag2 = captureRequest.getTag();
            if (tag == null) {
                if (tag2 != null) {
                    return;
                }
            } else if (!tag.equals(tag2)) {
                return;
            }
            ppp(Integer.MAX_VALUE);
        }
    }

    public Full2VideoRecorder(@NonNull fe.vvv.qw.yj.ad adVar, @NonNull String str) {
        super(adVar);
        this.f6782pf = adVar;
        this.f278if = str;
    }

    @Nullable
    public Surface aaa() {
        return this.f279switch;
    }

    public void ggg(@NonNull rg.qw qwVar, @NonNull MediaRecorder mediaRecorder) {
        mediaRecorder.setVideoSource(2);
    }

    /* renamed from: if  reason: not valid java name */
    public void m719if() {
        qw qwVar = new qw(this);
        qwVar.fe(new ad());
        qwVar.yj(this.f6782pf);
    }

    @NonNull
    public Surface mmm(@NonNull rg.qw qwVar) throws PrepareException {
        if (xxx(qwVar)) {
            Surface surface = this.f8878yj.getSurface();
            this.f279switch = surface;
            return surface;
        }
        throw new PrepareException(this, this.f6785de, (qw) null);
    }

    @NonNull
    public CamcorderProfile vvv(@NonNull rg.qw qwVar) {
        int i2 = qwVar.f9078de % 180;
        fe.vvv.qw.xxx.ad adVar = qwVar.f9079fe;
        if (i2 != 0) {
            adVar = adVar.ad();
        }
        return fe.vvv.qw.p037if.qw.ad(this.f278if, adVar);
    }
}
