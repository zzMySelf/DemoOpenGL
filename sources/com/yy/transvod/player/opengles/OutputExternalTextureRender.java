package com.yy.transvod.player.opengles;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.yy.transvod.player.core.QualityMonitor;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediafilter.MsgConst;

public class OutputExternalTextureRender extends OpenGLRender implements TextureView.SurfaceTextureListener {
    private static final String TAG = "OutputExternalTextureRender";
    private int mSizeChangedCnt = 0;
    private Surface mSurface = null;

    public OutputExternalTextureRender(Context context, ExternalTextureView surfaceView, int playerUID, int samplerFilter, QualityMonitor qMonitor) {
        init(context, surfaceView, playerUID, samplerFilter, qMonitor);
    }

    public void init(Context context, Object obj, int playerUID, int samplerFilter, QualityMonitor qMonitor) {
        super.init(context, obj, playerUID, samplerFilter, qMonitor);
        if (obj != null && (obj instanceof ExternalTextureView)) {
            ((ExternalTextureView) obj).setSurfaceTextureListener(this);
        }
    }

    public View getView() {
        return null;
    }

    public void createWindow(SurfaceTexture surface) {
        this.mSurface = new Surface(surface);
    }

    public Object getWindow() {
        return this.mSurface;
    }

    public void destroyWindow() {
        if (this.mSurfaceTexture != null) {
            TLog.warn(TAG, this, " playerUID:" + this.mPlayerUID + "destroyWindow");
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        TLog.warn(TAG, this, " playerUID:" + this.mPlayerUID + " onSurfaceTextureAvailable() width:" + width + ", height:" + height);
        this.mSurfaceCreated.set(true);
        innerSurfaceTextureAvailable(surface);
        if (width > 0 && height > 0) {
            innerSurfaceTextureSizeChanged(surface, width, height);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        if (this.mSizeChangedCnt % 100 == 0) {
            TLog.info(TAG, (Object) this, " playerUID:" + this.mPlayerUID + " onSurfaceTextureSizeChanged() width:" + width + ", height:" + height);
        }
        this.mSizeChangedCnt++;
        lockSurface();
        this.mSurfaceCreated.set(true);
        unLockSurface();
        innerSurfaceTextureSizeChanged(surface, width, height);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        TLog.info(TAG, (Object) this, "onSurfaceTextureDestroyed playerUID:" + this.mPlayerUID);
        lockSurface();
        this.mSurfaceCreated.set(false);
        unLockSurface();
        innerSurfaceDestroyed();
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        if (this.mGLThread != null && this.mEglCore.available()) {
            this.mGLThread.removeMessages(MsgConst.OPENGL_RENDER_TEXTURE_CHANGED);
            this.mGLThread.sendEmptyMessage(MsgConst.OPENGL_RENDER_TEXTURE_CHANGED);
        }
    }

    private void innerSurfaceTextureAvailable(SurfaceTexture surface) {
        updateRenderAvailable(true);
        if (this.mGLThread != null) {
            if (this.mEglCore.available()) {
                this.mGLThread.removeMessages(MsgConst.OPENGL_RENDER_DESTROY_SURFACE);
                this.mGLThread.sendEmptyMessage(MsgConst.OPENGL_RENDER_DESTROY_SURFACE);
            }
            TLog.warn(TAG, this, "do send surfaceCreated, playerUID:" + this.mPlayerUID);
            this.mGLThread.removeMessages(MsgConst.OPENGL_RENDER_CREATE_SURFACE);
            this.mGLThread.sendMessage(Message.obtain((Handler) null, MsgConst.OPENGL_RENDER_CREATE_SURFACE, surface));
        }
    }

    private void innerSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        if (this.mGLThread != null) {
            this.mGLThread.removeMessages(MsgConst.OPENGL_RENDER_SURFACE_CHANGED);
            this.mGLThread.sendMessage(Message.obtain((Handler) null, MsgConst.OPENGL_RENDER_SURFACE_CHANGED, width, height, surface));
            TLog.warn(TAG, this, " playerUID:" + this.mPlayerUID + " innerSurfaceTextureSizeChanged width " + width + ", height " + height);
        }
    }

    private void innerSurfaceDestroyed() {
        updateRenderAvailable(false);
        if (this.mGLThread != null && this.mEglCore.available()) {
            this.mGLThread.removeMessages(MsgConst.OPENGL_RENDER_DESTROY_SURFACE);
            this.mGLThread.sendEmptyMessage(MsgConst.OPENGL_RENDER_DESTROY_SURFACE);
        }
    }
}
