package com.baidu.cyberplayer.sdk;

public class CyberRenderSizeHelper {
    public static final String TAG = "CyberRenderSizeHelper";
    private int mClientRotation = 0;
    private int mDisplayMode = 0;
    private float[] mDisplayScale;
    private float[] mDisplayTranslate;
    private int mDrawFrameRotation = 0;
    private int mRawFrameRotation = 0;
    private int mSurfaceHeight = 0;
    private int mSurfaceWidth = 0;
    private int mVideoHeight = 0;
    private int mVideoSarDen = 1;
    private int mVideoSarNum = 1;
    private int mVideoWidth = 0;

    public CyberRenderSizeHelper() {
        float[] fArr = new float[2];
        this.mDisplayScale = fArr;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        float[] fArr2 = new float[2];
        this.mDisplayTranslate = fArr2;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        this.mDisplayMode = 2;
    }

    public void reset() {
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mVideoSarNum = 1;
        this.mVideoSarDen = 1;
        this.mClientRotation = 0;
        this.mRawFrameRotation = 0;
        this.mDrawFrameRotation = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        float[] fArr = this.mDisplayScale;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        this.mDisplayMode = 2;
    }

    public void resetForSurfaceReuse() {
        this.mVideoSarNum = 1;
        this.mVideoSarDen = 1;
        this.mClientRotation = 0;
        this.mRawFrameRotation = 0;
        this.mDrawFrameRotation = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        float[] fArr = this.mDisplayScale;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        this.mDisplayMode = 2;
    }

    public boolean onRawFrameRotationChanged(int rotate) {
        if (this.mRawFrameRotation == rotate) {
            return false;
        }
        this.mRawFrameRotation = rotate;
        this.mDrawFrameRotation = ((this.mClientRotation + 360) - rotate) % 360;
        return true;
    }

    public boolean onClientRotationChanged(int rotate) {
        if (this.mClientRotation == rotate) {
            return false;
        }
        this.mClientRotation = rotate;
        this.mDrawFrameRotation = ((360 - this.mRawFrameRotation) + rotate) % 360;
        return true;
    }

    public boolean onDisplayModeChanged(int mode) {
        if (this.mDisplayMode == mode) {
            return false;
        }
        this.mDisplayMode = mode;
        return true;
    }

    public boolean onVideoSizeChanged(int width, int height, int videoSarNum, int videoSarDen) {
        if (this.mVideoWidth == width && height == this.mVideoHeight && this.mVideoSarNum == videoSarNum && this.mVideoSarDen == videoSarDen) {
            return false;
        }
        this.mVideoWidth = width;
        this.mVideoHeight = height;
        if (videoSarDen == 0 || videoSarNum == 0) {
            this.mVideoSarNum = 1;
            this.mVideoSarDen = 1;
        } else {
            this.mVideoSarNum = videoSarNum;
            this.mVideoSarDen = videoSarDen;
        }
        return true;
    }

    public boolean onSurfaceSizeChanged(int width, int height) {
        if (this.mSurfaceWidth == width && this.mSurfaceHeight == height) {
            return false;
        }
        this.mSurfaceWidth = width;
        this.mSurfaceHeight = height;
        return true;
    }

    public void updateDisplaySize() {
        int i2;
        int i3;
        int i4;
        int i5 = this.mSurfaceWidth;
        if (i5 != 0 && (i2 = this.mSurfaceHeight) != 0 && (i3 = this.mVideoWidth) != 0 && (i4 = this.mVideoHeight) != 0) {
            boolean useSampleAspectRatio = false;
            int i6 = this.mDisplayMode;
            if (i6 == 0 || i6 == 2) {
                useSampleAspectRatio = true;
            }
            float vr = (((float) i2) * 1.0f) / ((float) i5);
            float dr = (((float) i4) * 1.0f) / ((float) i3);
            float sx = 1.0f;
            float sy = 1.0f;
            float translateX = 0.0f;
            float translateY = 0.0f;
            int i7 = this.mDrawFrameRotation;
            if ((i7 == 90 || i7 == 270) && i4 != 0) {
                dr = (((float) i3) * 1.0f) / ((float) i4);
                if (useSampleAspectRatio) {
                    dr *= (((float) this.mVideoSarNum) * 1.0f) / ((float) this.mVideoSarDen);
                }
            } else if (useSampleAspectRatio) {
                dr *= (((float) this.mVideoSarDen) * 1.0f) / ((float) this.mVideoSarNum);
            }
            CyberLog.d(TAG, "updateDisplaySize called mVideoWidth:" + this.mVideoWidth + " mVideoHeight:" + this.mVideoHeight + " mVideoSarNum:" + this.mVideoSarNum + " mVideoSarDen:" + this.mVideoSarDen + " mSurfaceWidth:" + this.mSurfaceWidth + " mSurfaceHeight:" + this.mSurfaceHeight + " mDisplayMode:" + this.mDisplayMode);
            switch (this.mDisplayMode) {
                case 0:
                    if (dr <= vr) {
                        sx = vr / dr;
                        break;
                    } else {
                        sy = dr / vr;
                        break;
                    }
                case 1:
                    break;
                case 2:
                    if (dr <= vr) {
                        sy = dr / vr;
                        break;
                    } else {
                        sx = vr / dr;
                        break;
                    }
                case 3:
                    if (0.8f <= vr) {
                        sy = 0.8f / vr;
                        break;
                    } else {
                        sx = vr / 0.8f;
                        break;
                    }
                case 4:
                    if (0.75f <= vr) {
                        sy = 0.75f / vr;
                        break;
                    } else {
                        sx = vr / 0.75f;
                        break;
                    }
                case 5:
                    if (0.5625f <= vr) {
                        sy = 0.5625f / vr;
                        break;
                    } else {
                        sx = vr / 0.5625f;
                        break;
                    }
                case 6:
                    sx = (((float) this.mVideoWidth) * 1.0f) / ((float) this.mSurfaceWidth);
                    sy = (((float) this.mVideoHeight) * 1.0f) / ((float) this.mSurfaceHeight);
                    break;
                case 7:
                    if (dr <= vr) {
                        sx = vr / dr;
                        translateX = 1.0f - sx;
                        break;
                    } else {
                        sy = dr / vr;
                        break;
                    }
                case 8:
                    if (dr <= vr) {
                        sx = vr / dr;
                        translateX = sx - 1.0f;
                        break;
                    } else {
                        sy = dr / vr;
                        break;
                    }
                case 9:
                    if (dr <= vr) {
                        sx = vr / dr;
                        break;
                    } else {
                        sy = dr / vr;
                        translateY = sy - 1.0f;
                        break;
                    }
                case 10:
                    if (dr <= vr) {
                        sx = vr / dr;
                        break;
                    } else {
                        sy = dr / vr;
                        translateY = 1.0f - sy;
                        break;
                    }
                default:
                    if (dr <= vr) {
                        sy = dr / vr;
                        break;
                    } else {
                        sx = vr / dr;
                        break;
                    }
            }
            float[] fArr = this.mDisplayScale;
            fArr[0] = sx;
            fArr[1] = sy;
            float[] fArr2 = this.mDisplayTranslate;
            fArr2[0] = translateX;
            fArr2[1] = translateY;
            CyberLog.d(TAG, "updateDisplaySize called sx:" + sx + " sy:" + sy + " translateX:" + translateX + " translateY:" + translateY);
        }
    }

    public float[] getDisplayScale() {
        return this.mDisplayScale;
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public float[] getDisplayTranslate() {
        return this.mDisplayTranslate;
    }

    public boolean isNeedTranslate() {
        int i2 = this.mDisplayMode;
        return i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10;
    }

    public int getDrawFrameRotation() {
        return this.mDrawFrameRotation;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    public int getSurfaceHeight() {
        return this.mSurfaceHeight;
    }
}
