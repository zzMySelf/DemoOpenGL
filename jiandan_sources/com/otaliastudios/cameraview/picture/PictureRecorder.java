package com.otaliastudios.cameraview.picture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import fe.vvv.qw.fe;

public abstract class PictureRecorder {
    @VisibleForTesting(otherwise = 4)

    /* renamed from: ad  reason: collision with root package name */
    public fe.qw f6767ad;
    @VisibleForTesting

    /* renamed from: th  reason: collision with root package name */
    public PictureResultListener f6768th;

    /* renamed from: yj  reason: collision with root package name */
    public Exception f6769yj;

    public interface PictureResultListener {
        /* renamed from: switch  reason: not valid java name */
        void m715switch(boolean z);

        void yj(@Nullable fe.qw qwVar, @Nullable Exception exc);
    }

    public PictureRecorder(@NonNull fe.qw qwVar, @Nullable PictureResultListener pictureResultListener) {
        this.f6767ad = qwVar;
        this.f6768th = pictureResultListener;
    }

    public void ad() {
        PictureResultListener pictureResultListener = this.f6768th;
        if (pictureResultListener != null) {
            pictureResultListener.yj(this.f6767ad, this.f6769yj);
            this.f6768th = null;
            this.f6767ad = null;
        }
    }

    public abstract void de();

    public void qw(boolean z) {
        PictureResultListener pictureResultListener = this.f6768th;
        if (pictureResultListener != null) {
            pictureResultListener.m715switch(z);
        }
    }
}
