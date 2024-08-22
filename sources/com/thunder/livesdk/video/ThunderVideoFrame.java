package com.thunder.livesdk.video;

import com.yy.mediaframework.camera.Camera2;
import com.yy.mediaframework.gpuimage.custom.RoiRect;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThunderVideoFrame {
    public boolean isCameraFrame = false;
    public int mImageFormat = 17;
    public long mIndex = 0;
    public boolean mIsCamera2CaptureFrame = false;
    public RoiRect mRoiRect;
    public int mRotation = 0;
    public FloatBuffer mTextureCoord = null;
    public int mTextureHeight = 0;
    public int mTextureId = 0;
    public int mTextureTarget = 0;
    public int mTextureWidth = 0;
    public AtomicBoolean mWillBeRendered = null;
    public byte[] mYUVCaptureBuffer = null;
    public int mYuvHeight = 0;
    public int mYuvWidth = 0;

    public void setVideoFrame(YMFVideoFrame ymfVideoFrame) {
        boolean z = false;
        if (ymfVideoFrame != null) {
            this.mIndex = ymfVideoFrame.mIndex;
            this.mWillBeRendered = ymfVideoFrame.mWillBeRendered;
            this.mTextureTarget = ymfVideoFrame.mTextureTarget;
            this.mTextureId = ymfVideoFrame.mTextureId;
            this.mTextureWidth = ymfVideoFrame.mTextureWidth;
            this.mTextureHeight = ymfVideoFrame.mTextureHeight;
            this.mTextureCoord = ymfVideoFrame.mTextureCoord;
            this.mYUVCaptureBuffer = ymfVideoFrame.mYUVCaptureBuffer;
            this.mImageFormat = ymfVideoFrame.mImageFormat;
            this.mYuvWidth = ymfVideoFrame.mYuvWidth;
            this.mYuvHeight = ymfVideoFrame.mYuvHeight;
            this.mRotation = ymfVideoFrame.mRotation;
            this.mRoiRect = ymfVideoFrame.mRoiRect;
            boolean z2 = ymfVideoFrame.mCameraInstance != null;
            this.isCameraFrame = z2;
            if (z2) {
                z = ymfVideoFrame.mCameraInstance instanceof Camera2;
            }
            this.mIsCamera2CaptureFrame = z;
            return;
        }
        this.mIndex = 0;
        this.mWillBeRendered = null;
        this.mTextureTarget = 0;
        this.mTextureId = 0;
        this.mTextureWidth = 0;
        this.mTextureHeight = 0;
        this.mTextureCoord = null;
        this.mYUVCaptureBuffer = null;
        this.mImageFormat = 17;
        this.mYuvWidth = 0;
        this.mYuvHeight = 0;
        this.mRotation = 0;
        this.mRoiRect = null;
        this.isCameraFrame = false;
        this.mIsCamera2CaptureFrame = false;
    }
}
