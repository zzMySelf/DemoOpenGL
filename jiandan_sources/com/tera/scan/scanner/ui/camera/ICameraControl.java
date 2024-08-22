package com.tera.scan.scanner.ui.camera;

import android.graphics.Rect;
import android.view.View;

public interface ICameraControl {

    public interface OnTakePictureCallback {
        void qw(byte[] bArr);
    }

    void ad(int i2);

    void de(PermissionCallback permissionCallback);

    View fe();

    Rect i();

    void pause();

    void qw();

    void rg(int i2);

    void start();

    void stop();

    void th();

    int uk();

    void yj(OnTakePictureCallback onTakePictureCallback);
}
