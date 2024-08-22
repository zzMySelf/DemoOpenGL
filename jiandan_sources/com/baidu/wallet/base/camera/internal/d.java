package com.baidu.wallet.base.camera.internal;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import com.baidu.wallet.core.utils.LogUtil;
import com.tera.scan.ui.widget.RotateProgress;

public class d implements Camera.PreviewCallback {
    public static final String a = d.class.getSimpleName();
    public static d b = null;
    public static final byte[] c = new byte[0];
    public static final CameraCtrl d = CameraCtrl.getInstance();
    public volatile c e = null;
    public final int f;
    public final int g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public int f1135i;
    public final int j;
    public final int k;
    public final int l;
    public final long m;
    public final int n;

    /* renamed from: o  reason: collision with root package name */
    public long f1136o = 0;

    public d(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f = i3;
        this.g = i4;
        this.j = i6;
        this.k = i7;
        this.m = (long) (1000 / i7);
        this.e = cVar;
        if (i5 % 90 == 0) {
            this.n = (i5 + RotateProgress.FULL_DEGREE) % RotateProgress.FULL_DEGREE;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        synchronized (c) {
            d dVar = new d(i2, i3, i4, i5, i6, i7, cVar);
            if (b != null) {
                if (dVar.equals(b)) {
                    LogUtil.i(a, "a TPreviewCallback object is already created");
                    d dVar2 = b;
                    return dVar2;
                }
                d.destroy();
                b.e.destroyCamera();
            }
            try {
                if (!d.init(i2, i3, i4, dVar.n, i6, i7)) {
                    LogUtil.errord(a, "can not initialize camera");
                    b = null;
                    return null;
                }
                dVar.h = d.getPreviewWidht();
                dVar.f1135i = d.getPreviewHeight();
                b = dVar;
                dVar.a(cVar);
                d dVar3 = b;
                return dVar3;
            } catch (Exception e2) {
                e2.printStackTrace();
                b = null;
                return null;
            }
        }
    }

    public synchronized int b() {
        return this.h;
    }

    public void c() {
        d.pause();
    }

    public b d() {
        return d.camera();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        c cVar = dVar.e;
        if ((cVar == null || this.e != null) && dVar.l == this.l && dVar.g == this.g && dVar.f == this.f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append(this.g);
        sb.append(this.f);
        sb.append(this.n);
        sb.append(this.j);
        sb.append(this.k);
        sb.append(this.e.hashCode());
        return sb.hashCode();
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f1136o;
        if (0 == j2) {
            this.f1136o = currentTimeMillis;
        } else if (currentTimeMillis - j2 > this.m) {
            this.f1136o = currentTimeMillis;
            if (this.e != null) {
                try {
                    this.e.processImage(bArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        camera.addCallbackBuffer(bArr);
    }

    public void b(SurfaceHolder surfaceHolder) {
        d.setPreviewDisplay(surfaceHolder);
    }

    public synchronized int a() {
        return this.f1135i;
    }

    public void a(c cVar) {
        synchronized (c) {
            if (cVar != null) {
                if (!(this.e == null || cVar == this.e)) {
                    LogUtil.w(a, "VideoRequestor new ImageHandler is to add.");
                    this.e.destroyCamera();
                }
                cVar.initCamera(this.h, this.f1135i, this.j, this.k);
                this.e = cVar;
            } else {
                if (this.e != null) {
                    this.e.destroyCamera();
                }
                this.e = null;
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            LogUtil.errord(a, "The camera preview surface is null");
            return false;
        }
        d.start(this, surfaceHolder);
        return true;
    }

    public void a(boolean z) {
        synchronized (c) {
            d.destroy();
            if (!z && this.e != null) {
                this.e.destroyCamera();
            }
            this.e = null;
            b = null;
        }
    }

    public static int a(Activity activity, int i2) {
        try {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (i2 == 1) {
                return ((-defaultDisplay.getRotation()) * 90) - cameraInfo.orientation;
            }
            return ((-defaultDisplay.getRotation()) * 90) + cameraInfo.orientation;
        } catch (Throwable unused) {
            return a(activity);
        }
    }

    public static int a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            rotation = 1;
        } else if (rotation == 1) {
            rotation = 0;
        } else if (rotation == 2) {
            rotation = 3;
        } else if (rotation == 3) {
            rotation = 2;
        }
        return rotation * 90;
    }
}
