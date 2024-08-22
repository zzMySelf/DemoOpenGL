package com.otaliastudios.cameraview.internal;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

public class OrientationHelper {

    /* renamed from: ad  reason: collision with root package name */
    public final Context f6755ad;

    /* renamed from: de  reason: collision with root package name */
    public final Callback f6756de;
    @VisibleForTesting

    /* renamed from: fe  reason: collision with root package name */
    public final OrientationEventListener f6757fe;
    public final Handler qw = new Handler(Looper.getMainLooper());

    /* renamed from: rg  reason: collision with root package name */
    public int f6758rg = -1;
    @VisibleForTesting

    /* renamed from: th  reason: collision with root package name */
    public final DisplayManager.DisplayListener f6759th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f6760uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f6761yj = -1;

    public interface Callback {
        void de(int i2, boolean z);

        void when(int i2);
    }

    public class ad implements DisplayManager.DisplayListener {
        public ad() {
        }

        public void onDisplayAdded(int i2) {
        }

        public void onDisplayChanged(int i2) {
            int fe2 = OrientationHelper.this.f6761yj;
            int th2 = OrientationHelper.this.i();
            if (th2 != fe2) {
                int unused = OrientationHelper.this.f6761yj = th2;
                OrientationHelper.this.f6756de.de(th2, Math.abs(th2 - fe2) != 180);
            }
        }

        public void onDisplayRemoved(int i2) {
        }
    }

    public class qw extends OrientationEventListener {
        public qw(Context context, int i2) {
            super(context, i2);
        }

        public void onOrientationChanged(int i2) {
            int i3 = 0;
            if (i2 == -1) {
                if (OrientationHelper.this.f6758rg != -1) {
                    i3 = OrientationHelper.this.f6758rg;
                }
            } else if (i2 < 315 && i2 >= 45) {
                if (i2 >= 45 && i2 < 135) {
                    i3 = 90;
                } else if (i2 >= 135 && i2 < 225) {
                    i3 = 180;
                } else if (i2 >= 225 && i2 < 315) {
                    i3 = 270;
                }
            }
            if (i3 != OrientationHelper.this.f6758rg) {
                int unused = OrientationHelper.this.f6758rg = i3;
                OrientationHelper.this.f6756de.when(OrientationHelper.this.f6758rg);
            }
        }
    }

    public OrientationHelper(@NonNull Context context, @NonNull Callback callback) {
        this.f6755ad = context;
        this.f6756de = callback;
        this.f6757fe = new qw(context.getApplicationContext(), 3);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f6759th = new ad();
        } else {
            this.f6759th = null;
        }
    }

    public final int i() {
        int rotation = ((WindowManager) this.f6755ad.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public int o() {
        return this.f6761yj;
    }

    public void uk() {
        if (!this.f6760uk) {
            this.f6760uk = true;
            this.f6761yj = i();
            if (Build.VERSION.SDK_INT >= 17) {
                ((DisplayManager) this.f6755ad.getSystemService("display")).registerDisplayListener(this.f6759th, this.qw);
            }
            this.f6757fe.enable();
        }
    }

    public void yj() {
        if (this.f6760uk) {
            this.f6760uk = false;
            this.f6757fe.disable();
            if (Build.VERSION.SDK_INT >= 17) {
                ((DisplayManager) this.f6755ad.getSystemService("display")).unregisterDisplayListener(this.f6759th);
            }
            this.f6761yj = -1;
            this.f6758rg = -1;
        }
    }
}
