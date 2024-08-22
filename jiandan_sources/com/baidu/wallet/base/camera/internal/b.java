package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.List;

public final class b {
    public volatile Camera a;

    public static class a {
        public static final b a = new b();
    }

    public static final b a() {
        return a.a;
    }

    public Camera b() {
        if (this.a == null) {
            synchronized (b.class) {
                if (this.a == null) {
                    this.a = Camera.open();
                }
            }
        }
        return this.a;
    }

    public void c() {
        if (this.a != null) {
            this.a.stopPreview();
        }
    }

    public Camera.Parameters d() {
        if (this.a != null) {
            return this.a.getParameters();
        }
        return null;
    }

    public void e() {
        if (this.a != null) {
            this.a.startPreview();
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.release();
            this.a = null;
        }
    }

    public void g() {
        if (this.a != null) {
            this.a.cancelAutoFocus();
        }
    }

    public b() {
    }

    public void a(Camera.Parameters parameters) {
        if (parameters != null) {
            parameters.setRotation(0);
        }
        if (this.a != null) {
            this.a.setParameters(parameters);
        }
    }

    public void a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.a != null) {
            this.a.setPreviewDisplay(surfaceHolder);
        }
    }

    public void a(byte[] bArr) {
        if (this.a != null) {
            this.a.addCallbackBuffer(bArr);
        }
    }

    public void a(Camera.PreviewCallback previewCallback) {
        if (this.a != null) {
            this.a.setPreviewCallbackWithBuffer(previewCallback);
        }
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback) {
        if (this.a != null) {
            this.a.autoFocus(autoFocusCallback);
        }
    }

    public void a(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3) {
        if (this.a != null) {
            this.a.takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
        }
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback, String str) {
        g();
        Camera.Parameters d = d();
        List<String> supportedFocusModes = d.getSupportedFocusModes();
        if (supportedFocusModes != null && supportedFocusModes.contains(str)) {
            d.setFocusMode(str);
            a(d);
            a(autoFocusCallback);
        }
    }
}
