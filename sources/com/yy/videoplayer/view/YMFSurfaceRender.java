package com.yy.videoplayer.view;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.yy.videoplayer.Constant;
import com.yy.videoplayer.YMFEventManager;
import com.yy.videoplayer.YMFStreamManager;
import com.yy.videoplayer.decoder.HardDecodeWayBuffer;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.render.IRender;
import com.yy.videoplayer.render.YMFRender;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import com.yy.videoplayer.utils.GLUtil;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.YMFLog;
import com.yy.videoplayer.view.GlSurfaceRender;
import com.yy.videoplayer.view.VsyncSource;
import com.yy.videoplayer.view.YMFPlayerController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class YMFSurfaceRender extends GlSurfaceRender implements GlSurfaceRender.Renderer, VsyncSource.VsyncNotifier {
    private static final String TAG = "YMFSurfaceRender:";
    private static final String THREAD = "YMFSurfaceRender_GLThread";
    private String hash = Integer.toHexString(System.identityHashCode(this));
    private Bitmap mBackgroundBitmap = null;
    private IRender mBackgroundRender = null;
    private boolean mCurrentDrawBlack = true;
    private int mCurrentDrawBlackTime = 0;
    private int mDrawTime = 0;
    private boolean mFirstFrameRendered = false;
    private AtomicBoolean mGlThreadReady = new AtomicBoolean(false);
    private boolean mHasRegisterVsync = false;
    private HashMap<Long, Boolean> mIgnoreStatistic = new HashMap<>();
    private HashMap<Long, Long> mIgnoreStatisticPtsMap = new HashMap<>();
    private long mLastRenderRequestTime = 0;
    private int mNoRenderFrameNum = 0;
    private WeakReference<YMFPlayerController.YMFPlayerControlProxy> mPlayerViewControllerProxy = null;
    private int mRenderMode = 0;
    private AtomicBoolean mRenderReady = new AtomicBoolean(false);
    private HashMap<Long, Boolean> mStreamFirstFrameRenderedMap = new HashMap<>();
    private boolean mSurfaceCreated = false;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private IRender mVideoRender = null;
    private int mViewState = 1;
    private VsyncSource mVsync = null;
    private long mVsyncCnt = 0;
    private long mVsyncT = 0;

    public YMFSurfaceRender(YMFPlayerController.YMFPlayerControlProxy controller) {
        initEgl();
        this.mPlayerViewControllerProxy = new WeakReference<>(controller);
        try {
            this.mVsync = new VsyncSource();
        } catch (Exception e2) {
            YMFLog.error((Object) TAG, Constant.MEDIACODE_PLAYVIEW, "VsyncSource:" + e2);
        }
    }

    private void initEgl() {
        YMFPlayerUsrBehaviorStat.getInstance().notifyVideoPlayerViewState(0, true);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(5, 6, 5, 0, 0, 0);
        setDebugFlags(1);
        setRenderer(this);
        setRenderMode(0);
        this.mGlThreadReady.set(true);
        YMFPlayerUsrBehaviorStat.getInstance().notifyGlManagerState(0, true);
        YMFLog.info(TAG, Constant.MEDIACODE_PLAYVIEW, "initEgl finish");
    }

    public void setRenderControlByChoreographer(boolean isMultiMode) {
        VsyncSource vsyncSource = this.mVsync;
        if (vsyncSource != null && this.mSurfaceCreated) {
            if (isMultiMode) {
                vsyncSource.registerVsyncNotifier(this);
            } else {
                vsyncSource.unRegisterVsyncNotifier(this);
            }
            this.mHasRegisterVsync = isMultiMode;
        }
    }

    private void notifyViewStateChange(int viewState) {
        if (this.mViewState != viewState) {
            this.mViewState = viewState;
            renderLock();
            WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
            if (!(weakReference == null || weakReference.get() == null)) {
                for (YMFRenderImage img : ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).getRenderImageMap().values()) {
                    if (!(img == null || img.mStreamId == 0)) {
                        if (this.mViewState == 0) {
                            this.mIgnoreStatistic.put(Long.valueOf(img.mStreamId), true);
                        }
                        YYVideoLibMgr.instance().onViewStateNotify(img.mStreamId, this.mViewState);
                        HardDecodeWayBuffer decodeWayBuffer = YMFStreamManager.instance().getDecoderWithStreamId(img.mStreamId);
                        if (decodeWayBuffer != null) {
                            decodeWayBuffer.setVideoPlayRender(true);
                        }
                    }
                }
            }
            renderUnlock();
        }
    }

    public void setIgnoreStatistic(long streamId) {
        this.mIgnoreStatistic.put(Long.valueOf(streamId), true);
    }

    public void onSurfaceCreated(Surface surface) {
        YMFLog.info(TAG, Constant.MEDIACODE_PLAYVIEW, "onSurfaceCreated:" + surface);
        super.surfaceCreated(surface);
    }

    public void onSurfaceDestroyed(Surface surface) {
        surfaceDestroyed(surface);
        super.surfaceDestroyed(surface);
    }

    public void onSurfaceChanged(Surface surface, int format, int w, int h2) {
        super.surfaceCreated(surface);
        super.surfaceChanged(surface, format, w, h2);
    }

    public void surfaceDestroyed(Surface surface) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "surfaceDestroyed start.");
        YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerViewOnSurface(0, false);
        YMFPlayerStatisticManager.getInstance().reset();
        notifyViewStateChange(1);
        renderLock();
        this.mSurfaceCreated = false;
        VsyncSource vsyncSource = this.mVsync;
        if (vsyncSource != null && this.mHasRegisterVsync) {
            vsyncSource.unRegisterVsyncNotifier(this);
        }
        renderUnlock();
        postToGlThread(new Runnable() {
            public void run() {
                YMFSurfaceRender.this.releaseRender();
            }
        });
        super.surfaceDestroyed(surface);
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "surfaceDestroyed end. not detach");
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "onSurfaceCreated .");
        YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerViewOnSurface(0, true);
        Thread.currentThread().setName("yrtcVSurRender");
        notifyViewStateChange(0);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        notifyViewStateChange(0);
        VsyncSource vsyncSource = this.mVsync;
        if (vsyncSource != null && this.mHasRegisterVsync) {
            vsyncSource.registerVsyncNotifier(this);
        }
        renderLock();
        this.mSurfaceCreated = true;
        if (!(this.mSurfaceWidth == width && this.mSurfaceHeight == height)) {
            this.mSurfaceWidth = width;
            this.mSurfaceHeight = height;
        }
        renderUnlock();
        WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).updateVideoLayout(this.mSurfaceWidth, this.mSurfaceHeight);
        }
        forceReDraw();
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "onSurfaceChanged width:" + width + " height:" + height + " now:" + TimeUtil.getTickCountLong());
    }

    public void forceReDraw() {
        if (this.mFirstFrameRendered) {
            this.mDrawTime = 0;
            setDataReDraw();
        }
        requestRender();
        requestRender();
    }

    public void release() {
        YMFPlayerUsrBehaviorStat.getInstance().notifyVideoPlayerViewState(0, false);
        YMFPlayerUsrBehaviorStat.getInstance().notifyGlManagerState(0, false);
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "release finish.");
        this.mIgnoreStatistic.clear();
        this.mIgnoreStatisticPtsMap.clear();
        if (this.mBackgroundBitmap != null) {
            this.mBackgroundBitmap = null;
        }
        requestExitAndWait();
    }

    /* access modifiers changed from: private */
    public void releaseRender() {
        IRender iRender = this.mVideoRender;
        if (iRender != null) {
            iRender.release();
            this.mVideoRender = null;
        }
        IRender iRender2 = this.mBackgroundRender;
        if (iRender2 != null) {
            iRender2.release();
            this.mBackgroundRender = null;
        }
        this.mBackgroundBitmap = null;
        this.mRenderReady.set(false);
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "releaseRender .");
    }

    public void postToGlThread(Runnable runable) {
        if (this.mGlThreadReady.get()) {
            queueEvent(runable);
        }
    }

    private void notifyRenderInfo(long streamId, long pts, long dts, int width, int height, int rct, boolean ignoreStat) {
        YMFEventManager.instance().notifyRenderEvnet(streamId, pts, dts, width, height, TimeUtil.getTickCountLong(), rct, 0, ignoreStat);
    }

    private void notifyRenderException(String msg) {
        YMFLog.error((Object) this, Constant.MEDIACODE_PLAYVIEW, "onDrawFrame Error ! " + msg);
    }

    public void requestGlRender() {
        VsyncSource vsyncSource = this.mVsync;
        if (vsyncSource != null && this.mHasRegisterVsync) {
            vsyncSource.unRegisterVsyncNotifier(this);
            this.mHasRegisterVsync = false;
        }
        requestRender();
    }

    public void onVsyncArrived(long frameTimeNanos) {
        if (frameTimeNanos - this.mLastRenderRequestTime > 24000000 && this.mSurfaceCreated) {
            this.mVsyncCnt++;
            long t1 = System.currentTimeMillis();
            if (t1 - this.mVsyncT > 6000) {
                this.mVsyncT = t1;
                YMFLog.info(this, "[Render  ]", "  in 6 seconds " + this.mVsyncCnt);
                this.mVsyncCnt = 0;
            }
            requestRender();
            this.mLastRenderRequestTime = frameTimeNanos;
        }
    }

    public void onDrawFrame(GL10 gl) {
        ConcurrentHashMap<Integer, YMFRenderImage> map;
        GLUtil.checkGlError("onDrawFrame enter ");
        WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
        if (weakReference != null && weakReference.get() != null && (map = ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).getRenderImageMap()) != null && map.size() > 0) {
            try {
                renderLock();
                if (this.mSurfaceCreated) {
                    if (!this.mRenderReady.get() && this.mSurfaceCreated && this.mVideoRender == null) {
                        this.mVideoRender = new YMFRender(2);
                        this.mRenderReady.set(true);
                    }
                    gl.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
                    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    gl.glClear(16384);
                    drawBackground(map.get(0));
                    if (this.mRenderReady.get() && this.mSurfaceCreated) {
                        for (Map.Entry<Integer, YMFRenderImage> entry : map.entrySet()) {
                            YMFRenderImage renderImage = (YMFRenderImage) entry.getValue();
                            if (!(renderImage == null || !renderImage.mRenderPrepared || renderImage.mDecodeImage == null || renderImage.mDecodeImage.mData == null)) {
                                drawVideo(gl, renderImage);
                            }
                        }
                    }
                }
                renderUnlock();
            } catch (Throwable t) {
                renderUnlock();
                notifyRenderException(t.getMessage() + " " + t.toString());
            }
        }
    }

    private void drawBackground(YMFRenderImage renderImageDefault) {
        WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
        if (weakReference != null && weakReference.get() != null && renderImageDefault != null) {
            if (((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).getBackgroundBitmap() != this.mBackgroundBitmap) {
                IRender iRender = this.mBackgroundRender;
                if (iRender != null) {
                    iRender.release();
                    this.mBackgroundRender = null;
                }
                Bitmap backgroundBitmap = ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).getBackgroundBitmap();
                this.mBackgroundBitmap = backgroundBitmap;
                if (backgroundBitmap != null) {
                    if (this.mBackgroundRender == null) {
                        this.mBackgroundRender = new YMFRender(0);
                    }
                    this.mBackgroundRender.prepareInputBackgroundTexture(this.mBackgroundBitmap, renderImageDefault.mBackGroundPosition.mWidth, renderImageDefault.mBackGroundPosition.mHeight);
                }
            }
            if (this.mBackgroundBitmap != null && this.mBackgroundRender != null) {
                GLES20.glViewport(renderImageDefault.mBackGroundPosition.mX, renderImageDefault.mBackGroundPosition.mY, renderImageDefault.mBackGroundPosition.mWidth, renderImageDefault.mBackGroundPosition.mHeight);
                this.mBackgroundRender.render();
            }
        }
    }

    private void drawVideo(GL10 gl, YMFRenderImage renderImage) {
        if (renderImage != null && renderImage.mDecodeImage != null) {
            if (renderImage.mVideoMode == VideoConstant.VideoViewMode.SingeMode) {
                drawNormal(gl, renderImage);
            } else {
                drawMulti(gl, renderImage);
            }
            this.mCurrentDrawBlack = false;
            this.mCurrentDrawBlackTime = 0;
            this.mNoRenderFrameNum = 0;
            GLUtil.checkGlError(this + " onDrawFrame out ");
        }
    }

    private void notifyRenderInfo(YMFRenderImage renderImage, int renderCostTime) {
        boolean ignoreStatistic;
        YMFRenderImage yMFRenderImage = renderImage;
        if (yMFRenderImage != null && yMFRenderImage.mDecodeImage.mNotifyRenderInfo && yMFRenderImage.mDecodeImage.mLastNotifyRenderInfoPts != yMFRenderImage.mDecodeImage.mPts && yMFRenderImage.mDecodeImage.mNeedRendered) {
            if (yMFRenderImage.mDecodeImage.mMultiIgnoreState) {
                this.mIgnoreStatistic.put(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId), true);
            }
            if (this.mIgnoreStatistic.containsKey(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId))) {
                boolean ignoreStatistic2 = this.mIgnoreStatistic.get(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId)).booleanValue();
                this.mIgnoreStatisticPtsMap.put(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId), Long.valueOf(yMFRenderImage.mDecodeImage.mPts));
                ignoreStatistic = ignoreStatistic2;
            } else {
                if (this.mIgnoreStatisticPtsMap.containsKey(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId))) {
                    if (this.mIgnoreStatisticPtsMap.get(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId)).longValue() == yMFRenderImage.mDecodeImage.mPts) {
                        ignoreStatistic = true;
                    } else {
                        this.mIgnoreStatisticPtsMap.remove(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId));
                    }
                }
                ignoreStatistic = false;
            }
            notifyRenderInfo(yMFRenderImage.mDecodeImage.mStreamId, yMFRenderImage.mDecodeImage.mPts, yMFRenderImage.mDecodeImage.mDts, (yMFRenderImage.mDecodeImage.mCropRight - yMFRenderImage.mDecodeImage.mCropLeft) + 1, (yMFRenderImage.mDecodeImage.mCropBottom - yMFRenderImage.mDecodeImage.mCropTop) + 1, renderCostTime, !ignoreStatistic ? yMFRenderImage.mDecodeImage.mIgnore : ignoreStatistic);
            yMFRenderImage.mDecodeImage.mLastNotifyRenderInfoPts = yMFRenderImage.mDecodeImage.mPts;
            yMFRenderImage.mDecodeImage.mMultiIgnoreState = false;
            if (ignoreStatistic) {
                YMFLog.info(this, "[Decoder ]", "IgnoreStat mStreamId:" + yMFRenderImage.mDecodeImage.mStreamId + " pts:" + yMFRenderImage.mDecodeImage.mPts);
                this.mIgnoreStatistic.put(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId), false);
            }
        }
    }

    private void drawBlack(GL10 gl, YMFRenderImage renderImage) {
        if (!this.mCurrentDrawBlack) {
            if (renderImage.mVideoSize.width > 0 && renderImage.mVideoSize.height > 0) {
                gl.glViewport(renderImage.mVideoSize.x, renderImage.mVideoSize.y, renderImage.mVideoSize.width, renderImage.mVideoSize.height);
            }
            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            gl.glClear(16384);
            int i2 = this.mCurrentDrawBlackTime;
            this.mCurrentDrawBlackTime = i2 + 1;
            if (i2 > 2) {
                this.mCurrentDrawBlack = true;
            }
            this.mFirstFrameRendered = false;
            YMFLog.warn(this, Constant.MEDIACODE_PLAYVIEW, "onDrawFrame mCurrentDrawBlack ");
        }
    }

    private void drawNormal(GL10 gl, YMFRenderImage renderImage) {
        if (!this.mRenderReady.get() || renderImage.mDecodeImage == null || this.mVideoRender == null || !getDataArriveFlag().get()) {
            notifyNoFrameRenderStatistic(renderImage);
            return;
        }
        long startRenderTime = System.currentTimeMillis();
        if (renderImage.mVideoSize.width <= 0 || renderImage.mVideoSize.height <= 0) {
            YMFLog.error((Object) this, Constant.MEDIACODE_PLAYVIEW, " glViewport error, width:" + renderImage.mVideoSize.width + " height:" + renderImage.mVideoSize.height);
        } else {
            gl.glViewport(renderImage.mVideoSize.x, renderImage.mVideoSize.y, renderImage.mVideoSize.width, renderImage.mVideoSize.height);
        }
        if (renderImage.mScaleMode.compareTo(VideoConstant.ScaleMode.AspectFit) == 0 || renderImage.mScaleMode.compareTo(VideoConstant.ScaleMode.Original) == 0) {
            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            gl.glClear(16384);
        }
        if (this.mVideoRender.prepareInputImageData(renderImage.mDecodeImage)) {
            if (!(renderImage.mDecodeImage.mWidth == (renderImage.mDecodeImage.mCropRight - renderImage.mDecodeImage.mCropLeft) + 1 && renderImage.mDecodeImage.mHeight == (renderImage.mDecodeImage.mCropBottom - renderImage.mDecodeImage.mCropTop) + 1 && !renderImage.mDecodeImage.mChangeRenderMode)) {
                this.mVideoRender.clip(renderImage.mDecodeImage.mWidth, renderImage.mDecodeImage.mHeight, renderImage.mDecodeImage.mCropLeft, renderImage.mDecodeImage.mCropRight, renderImage.mDecodeImage.mCropBottom, renderImage.mDecodeImage.mCropTop, renderImage.mDecodeImage.mClipWindow);
            }
            if (this.mVideoRender.checkUpdateMirrorMode(renderImage.mMirrorMode.compareTo(VideoConstant.MirrorMode.Enabled) == 0)) {
                this.mVideoRender.flipHorizontal();
            }
            this.mVideoRender.render();
        }
        notifyRenderInfo(renderImage, (int) (System.currentTimeMillis() - startRenderTime));
        getDataArriveFlag().set(false);
        this.mFirstFrameRendered = true;
        int i2 = this.mDrawTime;
        this.mDrawTime = i2 + 1;
        if (i2 <= 1) {
            setDataReDraw();
        }
    }

    private void drawMulti(GL10 gl, YMFRenderImage renderImage) {
        if (!this.mRenderReady.get() || renderImage.mDecodeImage == null || this.mVideoRender == null) {
            notifyNoFrameRenderStatistic(renderImage);
            return;
        }
        if (renderImage.mVideoSize.width > 0 && renderImage.mVideoSize.height > 0) {
            gl.glViewport(renderImage.mVideoSize.x, renderImage.mVideoSize.y, renderImage.mVideoSize.width, renderImage.mVideoSize.height);
        }
        long startRenderTime = System.currentTimeMillis();
        if (this.mVideoRender.prepareInputImageData(renderImage.mDecodeImage)) {
            if (!(renderImage.mDecodeImage.mWidth == (renderImage.mDecodeImage.mCropRight - renderImage.mDecodeImage.mCropLeft) + 1 && renderImage.mDecodeImage.mHeight == (renderImage.mDecodeImage.mCropBottom - renderImage.mDecodeImage.mCropTop) + 1 && !renderImage.mDecodeImage.mChangeRenderMode)) {
                this.mVideoRender.clip(renderImage.mDecodeImage.mWidth, renderImage.mDecodeImage.mHeight, renderImage.mDecodeImage.mCropLeft, renderImage.mDecodeImage.mCropRight, renderImage.mDecodeImage.mCropBottom, renderImage.mDecodeImage.mCropTop, renderImage.mDecodeImage.mClipWindow);
            }
            if (!((renderImage.mDecodeImage.mCropRight - renderImage.mDecodeImage.mCropLeft) + 1 == renderImage.mDrawPosition.mWidth && (renderImage.mDecodeImage.mCropBottom - renderImage.mDecodeImage.mCropTop) + 1 == renderImage.mDrawPosition.mHeight)) {
                this.mVideoRender.clip((renderImage.mDecodeImage.mCropRight - renderImage.mDecodeImage.mCropLeft) + 1, (renderImage.mDecodeImage.mCropBottom - renderImage.mDecodeImage.mCropTop) + 1, renderImage.mDrawPosition.mWidth, renderImage.mDrawPosition.mHeight, renderImage.mScaleMode);
            }
            if (this.mVideoRender.checkUpdateMirrorMode(renderImage.mMirrorMode.compareTo(VideoConstant.MirrorMode.Enabled) == 0)) {
                this.mVideoRender.flipHorizontal();
            }
            this.mVideoRender.render();
            this.mDrawTime++;
        }
        notifyRenderInfo(renderImage, (int) (System.currentTimeMillis() - startRenderTime));
    }

    private void notifyNoFrameRenderStatistic(YMFRenderImage renderImage) {
        if (renderImage != null) {
            int i2 = this.mNoRenderFrameNum;
            this.mNoRenderFrameNum = i2 + 1;
            if (i2 % 100 == 0) {
                YMFLog.warn(this, "onDrawFrame ", renderImage.mStreamId + "," + this.mRenderReady.get() + "," + getDataArriveFlag().get() + "," + this.mSurfaceCreated + "," + renderImage.mDecodeImage.mStreamStart + ",,pts:" + (renderImage.mDecodeImage == null ? 0 : renderImage.mDecodeImage.mPts) + ",  now:" + TimeUtil.getTickCountLong());
            }
        }
    }

    public void renderLock() {
        WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
        if (weakReference != null && weakReference.get() != null) {
            ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).getRenderLock().lock();
        }
    }

    public void renderUnlock() {
        WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
        if (weakReference != null && weakReference.get() != null) {
            ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).getRenderLock().unlock();
        }
    }

    public void setDataReDraw() {
        WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
        if (weakReference != null && weakReference.get() != null) {
            ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).setDataArriveFlag();
        }
    }

    public AtomicBoolean getDataArriveFlag() {
        WeakReference<YMFPlayerController.YMFPlayerControlProxy> weakReference = this.mPlayerViewControllerProxy;
        if (weakReference == null || weakReference.get() == null) {
            return new AtomicBoolean(false);
        }
        return ((YMFPlayerController.YMFPlayerControlProxy) this.mPlayerViewControllerProxy.get()).getDataArriveFlag();
    }

    private static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        private static final int EGL_OPENGL_ES2_BIT = 4;
        private int mAlphaSize;
        private int mBlueSize;
        private int[] mConfigAttr = {MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344};
        private int[] mDefaultValue = new int[1];
        private int mDepthSize;
        private int mGreenSize;
        private int mRedSize;
        private int mStencilSize;

        public ConfigChooser(int r, int g2, int b2, int a2, int d2, int s) {
            this.mRedSize = r;
            this.mGreenSize = g2;
            this.mBlueSize = b2;
            this.mAlphaSize = a2;
            this.mDepthSize = d2;
            this.mStencilSize = s;
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            int[] numConfig = new int[1];
            egl.eglChooseConfig(display, this.mConfigAttr, (EGLConfig[]) null, 0, numConfig);
            int num = numConfig[0];
            if (num <= 0) {
                return null;
            }
            EGLConfig[] configs = new EGLConfig[num];
            egl.eglChooseConfig(display, this.mConfigAttr, configs, num, numConfig);
            return chooseConfig(egl, display, configs);
        }

        private EGLConfig chooseConfig(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            for (EGLConfig config : configs) {
                EGL10 egl10 = egl;
                EGLDisplay eGLDisplay = display;
                EGLConfig eGLConfig = config;
                int d2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int s = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (d2 >= this.mDepthSize && s >= this.mStencilSize) {
                    EGL10 egl102 = egl;
                    EGLDisplay eGLDisplay2 = display;
                    EGLConfig eGLConfig2 = config;
                    int r = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                    int g2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                    int b2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12322, 0);
                    int a2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12321, 0);
                    if (r == this.mRedSize && g2 == this.mGreenSize && b2 == this.mBlueSize && a2 == this.mAlphaSize) {
                        return config;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
            if (egl.eglGetConfigAttrib(display, config, attribute, this.mDefaultValue)) {
                return this.mDefaultValue[0];
            }
            return defaultValue;
        }
    }
}
