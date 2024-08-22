package com.yy.mediaframework;

import android.graphics.Bitmap;
import android.view.SurfaceView;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.utils.YMFLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class UploadStreamStateParams {
    public static int mCameraPosition = 0;
    public static Constant.CaptureFpsMode mCaptureFpsMode = Constant.CaptureFpsMode.AlignEncoder;
    public static Constant.CaptureMode mCaptureMode = Constant.CaptureMode.TextureMode;
    public static long mDeltaPtsDts = 0;
    public static boolean mDisableBeauty = false;
    public static AtomicBoolean mDisableHardEncoder = new AtomicBoolean(false);
    public static Constant.EncoderInputMode mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
    public static boolean mEncoderMirror = false;
    public static boolean mNetWorkStrategy = false;
    public static int mOffsetX;
    public static int mOffsetY;
    public static int mOriginEncodeHeight = 0;
    public static int mOriginEncodeWidth = 0;
    public static boolean mPreviewMirror = true;
    public static Constant.PreviewMode mPreviewMode = Constant.PreviewMode.TextureMode;
    public static SurfaceView mPreviewView;
    public static Constant.ScaleMode mScaleMode = Constant.ScaleMode.AspectFit;
    public static Bitmap mWaterMarkBitmap;
    public static boolean mWaterMarkEffect = false;
    public static boolean mYuvTextureMode = true;

    public static void reset() {
        mOriginEncodeHeight = 0;
        mOriginEncodeWidth = 0;
        mPreviewView = null;
        mScaleMode = Constant.ScaleMode.AspectFit;
        try {
            Bitmap bitmap = mWaterMarkBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                mWaterMarkBitmap.recycle();
            }
            mWaterMarkBitmap = null;
        } catch (Exception e2) {
            YMFLog.info((Object) null, "[Procedur]", "UploadStreamStateParams mWaterMarkBitmap recycle exception:" + e2.toString());
        }
        mOffsetX = 0;
        mOffsetY = 0;
        mWaterMarkEffect = false;
        mPreviewMirror = true;
        mEncoderMirror = false;
        mCameraPosition = 0;
        mDeltaPtsDts = 0;
        mNetWorkStrategy = false;
        mCaptureMode = Constant.CaptureMode.TextureMode;
        mPreviewMode = Constant.PreviewMode.TextureMode;
        mDisableBeauty = false;
        mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
        mCaptureFpsMode = Constant.CaptureFpsMode.AlignEncoder;
        mYuvTextureMode = true;
    }
}
