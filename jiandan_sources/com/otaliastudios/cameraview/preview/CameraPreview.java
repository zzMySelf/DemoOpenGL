package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;
import fe.vvv.qw.xxx.ad;

public abstract class CameraPreview<T extends View, Output> {

    /* renamed from: o  reason: collision with root package name */
    public static final CameraLogger f6770o = CameraLogger.qw(CameraPreview.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public SurfaceCallback f6771ad;

    /* renamed from: de  reason: collision with root package name */
    public T f6772de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f6773fe;

    /* renamed from: i  reason: collision with root package name */
    public int f6774i;
    @VisibleForTesting
    public CropCallback qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f6775rg;

    /* renamed from: th  reason: collision with root package name */
    public int f6776th;

    /* renamed from: uk  reason: collision with root package name */
    public int f6777uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f6778yj;

    public interface CropCallback {
        void qw();
    }

    public interface SurfaceCallback {
        void fe();

        void th();

        void when();
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f6779ad;

        public qw(TaskCompletionSource taskCompletionSource) {
            this.f6779ad = taskCompletionSource;
        }

        public void run() {
            CameraPreview.this.xxx();
            this.f6779ad.setResult(null);
        }
    }

    public CameraPreview(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        this.f6772de = ggg(context, viewGroup);
    }

    public void aaa(int i2, int i3) {
        f6770o.de("setStreamSize:", "desiredW=", Integer.valueOf(i2), "desiredH=", Integer.valueOf(i3));
        this.f6778yj = i2;
        this.f6777uk = i3;
        if (i2 > 0 && i3 > 0) {
            rg(this.qw);
        }
    }

    public void ddd() {
    }

    public boolean eee() {
        return false;
    }

    @NonNull
    public abstract T ggg(@NonNull Context context, @NonNull ViewGroup viewGroup);

    @NonNull
    public abstract Output i();

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public final ad m716if() {
        return new ad(this.f6775rg, this.f6776th);
    }

    public void mmm(int i2) {
        this.f6774i = i2;
    }

    public void nn() {
    }

    @NonNull
    public abstract Class<Output> o();

    @NonNull
    public abstract View pf();

    public boolean ppp() {
        return this.f6773fe;
    }

    public void qqq(@Nullable SurfaceCallback surfaceCallback) {
        SurfaceCallback surfaceCallback2;
        SurfaceCallback surfaceCallback3;
        if (when() && (surfaceCallback3 = this.f6771ad) != null) {
            surfaceCallback3.th();
        }
        this.f6771ad = surfaceCallback;
        if (when() && (surfaceCallback2 = this.f6771ad) != null) {
            surfaceCallback2.fe();
        }
    }

    public void rg(@Nullable CropCallback cropCallback) {
        if (cropCallback != null) {
            cropCallback.qw();
        }
    }

    @NonNull
    /* renamed from: switch  reason: not valid java name */
    public final T m717switch() {
        return this.f6772de;
    }

    public final void th(int i2, int i3) {
        f6770o.de("dispatchOnSurfaceAvailable:", "w=", Integer.valueOf(i2), "h=", Integer.valueOf(i3));
        this.f6775rg = i2;
        this.f6776th = i3;
        if (i2 > 0 && i3 > 0) {
            rg(this.qw);
        }
        SurfaceCallback surfaceCallback = this.f6771ad;
        if (surfaceCallback != null) {
            surfaceCallback.fe();
        }
    }

    public final void uk(int i2, int i3) {
        f6770o.de("dispatchOnSurfaceSizeChanged:", "w=", Integer.valueOf(i2), "h=", Integer.valueOf(i3));
        if (i2 != this.f6775rg || i3 != this.f6776th) {
            this.f6775rg = i2;
            this.f6776th = i3;
            if (i2 > 0 && i3 > 0) {
                rg(this.qw);
            }
            SurfaceCallback surfaceCallback = this.f6771ad;
            if (surfaceCallback != null) {
                surfaceCallback.when();
            }
        }
    }

    @CallSuper
    public void vvv() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            xxx();
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        handler.post(new qw(taskCompletionSource));
        try {
            Tasks.await(taskCompletionSource.getTask());
        } catch (Exception unused) {
        }
    }

    public final boolean when() {
        return this.f6775rg > 0 && this.f6776th > 0;
    }

    @UiThread
    public void xxx() {
        View pf2 = pf();
        ViewParent parent = pf2.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(pf2);
        }
    }

    public final void yj() {
        this.f6775rg = 0;
        this.f6776th = 0;
        SurfaceCallback surfaceCallback = this.f6771ad;
        if (surfaceCallback != null) {
            surfaceCallback.th();
        }
    }
}
