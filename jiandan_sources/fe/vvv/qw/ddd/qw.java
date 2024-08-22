package fe.vvv.qw.ddd;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import androidx.annotation.NonNull;
import fe.vvv.qw.rg;
import fe.vvv.qw.xxx.ad;

public class qw extends ad {

    /* renamed from: if  reason: not valid java name */
    public final Camera f369if;

    /* renamed from: pf  reason: collision with root package name */
    public final fe.vvv.qw.yj.qw f8941pf;

    /* renamed from: switch  reason: not valid java name */
    public final int f370switch;

    public qw(@NonNull fe.vvv.qw.yj.qw qwVar, @NonNull Camera camera, int i2) {
        super(qwVar);
        this.f369if = camera;
        this.f8941pf = qwVar;
        this.f370switch = i2;
    }

    public void ggg(@NonNull rg.qw qwVar, @NonNull MediaRecorder mediaRecorder) {
        mediaRecorder.setCamera(this.f369if);
        mediaRecorder.setVideoSource(1);
    }

    public void pf() {
        this.f369if.setPreviewCallbackWithBuffer(this.f8941pf);
        super.pf();
    }

    @NonNull
    public CamcorderProfile vvv(@NonNull rg.qw qwVar) {
        int i2 = qwVar.f9078de % 180;
        ad adVar = qwVar.f9079fe;
        if (i2 != 0) {
            adVar = adVar.ad();
        }
        return fe.vvv.qw.p037if.qw.qw(this.f370switch, adVar);
    }
}
