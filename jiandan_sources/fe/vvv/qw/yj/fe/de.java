package fe.vvv.qw.yj.fe;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionCallback;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
public abstract class de implements Action {

    /* renamed from: ad  reason: collision with root package name */
    public int f9200ad;

    /* renamed from: de  reason: collision with root package name */
    public ActionHolder f9201de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f9202fe;
    public final List<ActionCallback> qw = new ArrayList();

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
    }

    @CallSuper
    public void de(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.f9202fe) {
            m1047switch(actionHolder);
            this.f9202fe = false;
        }
    }

    public void fe(@NonNull ActionCallback actionCallback) {
        if (!this.qw.contains(actionCallback)) {
            this.qw.add(actionCallback);
            actionCallback.qw(this, i());
        }
    }

    public final int i() {
        return this.f9200ad;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1046if(@NonNull ActionHolder actionHolder) {
    }

    public boolean o() {
        return this.f9200ad == Integer.MAX_VALUE;
    }

    public void pf(@NonNull ActionHolder actionHolder) {
    }

    public final void ppp(int i2) {
        if (i2 != this.f9200ad) {
            this.f9200ad = i2;
            for (ActionCallback qw2 : this.qw) {
                qw2.qw(this, this.f9200ad);
            }
            if (this.f9200ad == Integer.MAX_VALUE) {
                this.f9201de.ggg(this);
                m1046if(this.f9201de);
            }
        }
    }

    public final void qw(@NonNull ActionHolder actionHolder) {
        actionHolder.ggg(this);
        if (!o()) {
            pf(actionHolder);
            ppp(Integer.MAX_VALUE);
        }
        this.f9202fe = false;
    }

    public void rg(@NonNull ActionCallback actionCallback) {
        this.qw.remove(actionCallback);
    }

    @CallSuper
    /* renamed from: switch  reason: not valid java name */
    public void m1047switch(@NonNull ActionHolder actionHolder) {
        this.f9201de = actionHolder;
    }

    public void th(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
    }

    @NonNull
    public ActionHolder uk() {
        return this.f9201de;
    }

    @NonNull
    public <T> T when(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = this.f9201de.uk(this).get(key);
        return t2 == null ? t : t2;
    }

    public final void yj(@NonNull ActionHolder actionHolder) {
        this.f9201de = actionHolder;
        actionHolder.i(this);
        if (actionHolder.m714if(this) != null) {
            m1047switch(actionHolder);
        } else {
            this.f9202fe = true;
        }
    }
}
