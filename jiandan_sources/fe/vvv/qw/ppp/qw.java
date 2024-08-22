package fe.vvv.qw.ppp;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.overlay.Overlay;
import fe.vvv.qw.p037if.fe;
import fe.vvv.qw.p037if.rg;
import fe.vvv.qw.xxx.ad;

public class qw {

    /* renamed from: yj  reason: collision with root package name */
    public static final CameraLogger f9071yj = CameraLogger.qw(qw.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public SurfaceTexture f9072ad;

    /* renamed from: de  reason: collision with root package name */
    public Surface f9073de;
    @VisibleForTesting

    /* renamed from: fe  reason: collision with root package name */
    public fe f9074fe;
    public Overlay qw;

    /* renamed from: rg  reason: collision with root package name */
    public rg f9075rg;

    /* renamed from: th  reason: collision with root package name */
    public final Object f9076th = new Object();

    public qw(@NonNull Overlay overlay, @NonNull ad adVar) {
        this.qw = overlay;
        this.f9074fe = new fe();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f9074fe.ad().rg());
        this.f9072ad = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(adVar.rg(), adVar.fe());
        this.f9073de = new Surface(this.f9072ad);
        this.f9075rg = new rg(this.f9074fe.ad().rg());
    }

    public float[] ad() {
        return this.f9074fe.de();
    }

    public void de() {
        rg rgVar = this.f9075rg;
        if (rgVar != null) {
            rgVar.de();
            this.f9075rg = null;
        }
        SurfaceTexture surfaceTexture = this.f9072ad;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f9072ad = null;
        }
        Surface surface = this.f9073de;
        if (surface != null) {
            surface.release();
            this.f9073de = null;
        }
        fe feVar = this.f9074fe;
        if (feVar != null) {
            feVar.fe();
            this.f9074fe = null;
        }
    }

    public void fe(long j) {
        GLES20.glDisable(2884);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
        synchronized (this.f9076th) {
            this.f9074fe.qw(j);
        }
    }

    public void qw(@NonNull Overlay.Target target) {
        try {
            Canvas lockCanvas = this.f9073de.lockCanvas((Rect) null);
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.qw.drawOn(target, lockCanvas);
            this.f9073de.unlockCanvasAndPost(lockCanvas);
        } catch (Surface.OutOfResourcesException e) {
            f9071yj.i("Got Surface.OutOfResourcesException while drawing video overlays", e);
        }
        synchronized (this.f9076th) {
            this.f9075rg.qw();
            this.f9072ad.updateTexImage();
        }
        this.f9072ad.getTransformMatrix(this.f9074fe.de());
    }
}
