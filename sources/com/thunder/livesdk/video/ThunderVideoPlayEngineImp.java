package com.thunder.livesdk.video;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.thunder.livesdk.ThunderExternalSurface;
import com.thunder.livesdk.ThunderMultiVideoViewParam;
import com.thunder.livesdk.ThunderRtcConstant;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.videoplayer.VideoDecodeEventNotify;
import com.yy.videoplayer.VideoPlayer;
import com.yy.videoplayer.VideoRenderNotify;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.stat.IYMFBehaviorEventListener;
import com.yy.videoplayer.stat.YMFBehaviorEvent;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThunderVideoPlayEngineImp implements IThunderVideoPlay, IYMFBehaviorEventListener {
    private static final String TAG = "ThunderVideoPlayEngineImp";
    private static final int VIDEO_STATE_DECODER_TYPE = 3;
    private static final int VIDEO_STATE_RESOLUTION = 2;
    private static final int VIDEO_STAT_BITRATE = 1;
    private static final int VIDEO_STAT_FPS = 0;
    private static long mCallBackPtr = 0;
    private static ReentrantReadWriteLock s_observerLock = null;
    public final int INVALID_VALUE = -1;
    private Map<Long, Long> mC2JavaUidMap = new HashMap();
    /* access modifiers changed from: private */
    public int mLastFrameMode = 0;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Long> mMultiStreamKeyIdMap;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Integer> mMultiVideoMirrorModeMap;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Integer> mMultiVideoScaleModeMap;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, String> mStreamKeyStrUidMap = new ConcurrentHashMap<>();
    private HashMap<Surface, ThunderPlayerMultiViewProxy> mSurfacePlayerProxyMap = new HashMap<>();
    /* access modifiers changed from: private */
    public AtomicBoolean mThunderPlayerMultiViewMode = new AtomicBoolean(false);
    private HashMap<Integer, ThunderPlayerMultiViewProxy> mThunderPlayerMultiViewProxyMap = new HashMap<>(10);
    private Handler mThunderVideoHandler = null;
    private HandlerThread mThunderVideoHandlerThread = null;
    private ThunderVideoPlayListener mThunderVideoPlayListener = null;
    private ConcurrentHashMap<Long, Long> mUidToVideoIdCallBackInDualStreamMap;
    private ConcurrentHashMap<Long, StrUidVideoDecodeObserver> mVideoDecodeObserverMap;
    /* access modifiers changed from: private */
    public HashMap<String, ThunderPlayerMultiViewProxy> mVideoMultiViewMap = new HashMap<>();
    private HashMap<String, ThunderPlayerMultiViewProxy> mVideoMultiViewRecoverMap = new HashMap<>();
    private ThunderVideoHiidoUtil mVideoPlayHiidoUtil;
    private ConcurrentHashMap<String, VideoStreamInfo> mVideoStreamInfoMap;

    private native void onFirstFrameDecodeNotify(long j2, long j3, long j4, long j5);

    private native void onFirstFrameRender(long j2, long j3, int i2, int i3, long j4);

    private native void onHardwareDecodeError(long j2, long j3, long j4, int i2);

    private native void onMultiViewSeatInfoNotify(long j2, long j3, int i2);

    private native void onVideoDecodedFrames(long j2, VideoDecodeEventNotify videoDecodeEventNotify);

    private native void onVideoRenderedFrames(long j2, ArrayList<VideoRenderNotify> arrayList);

    private native void onViewStateNotify(long j2, long j3, int i2);

    public void onViewStateNotify(long streamId, int viewState) {
        long j2 = mCallBackPtr;
        if (j2 != 0) {
            onViewStateNotify(j2, streamId, viewState);
        }
    }

    public void onVideoRenderNotify(ArrayList<VideoRenderNotify> notifys) {
        long j2 = mCallBackPtr;
        if (j2 != 0) {
            onVideoRenderedFrames(j2, notifys);
        }
    }

    public void onVideoDecodeNotify(VideoDecodeEventNotify notifys) {
        long j2 = mCallBackPtr;
        if (j2 != 0) {
            onVideoDecodedFrames(j2, notifys);
        }
    }

    public void onFirstFrameRenderNotify(long streamId, int width, int height, long pts) {
        long j2 = mCallBackPtr;
        if (j2 != 0) {
            onFirstFrameRender(j2, streamId, width, height, pts);
        }
    }

    public void onMultiViewSeatInfoChangedNotify(long streamId, int seatId) {
    }

    public void onHardwareDecodeErrorNotify(long userGroupId, long streamId, int errorType) {
        long j2 = mCallBackPtr;
        if (j2 != 0) {
            onHardwareDecodeError(j2, userGroupId, streamId, errorType);
        }
    }

    public void onDecodedFrameData(long streamId, int w, int h2, byte[] data, int dataLen, long renderTimeMs) {
        boolean bCalllBack;
        try {
            s_observerLock.readLock().lock();
            long javaUid = streamId >> 32;
            long uid = this.mC2JavaUidMap.get(Long.valueOf(javaUid)) == null ? (long) ((int) javaUid) : this.mC2JavaUidMap.get(Long.valueOf(javaUid)).longValue();
            ConcurrentHashMap<Long, StrUidVideoDecodeObserver> concurrentHashMap = this.mVideoDecodeObserverMap;
            if (concurrentHashMap != null) {
                if (!concurrentHashMap.isEmpty()) {
                    StrUidVideoDecodeObserver strUidObserver = this.mVideoDecodeObserverMap.get(Long.valueOf(uid));
                    if (strUidObserver != null) {
                        IVideoDecodeObserver observer = strUidObserver.getObserver();
                        if (observer != null) {
                            if (this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(uid)) != null) {
                                long dualStreamId = this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(uid)).longValue();
                                if (dualStreamId != streamId) {
                                    long j2 = dualStreamId;
                                    bCalllBack = false;
                                } else {
                                    long j3 = dualStreamId;
                                    bCalllBack = true;
                                }
                            } else {
                                bCalllBack = true;
                            }
                            if (bCalllBack) {
                                observer.onVideoDecodeFrame(strUidObserver.getStrUid(), w, h2, data, dataLen, renderTimeMs);
                            }
                        } else if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(TAG, "onVideoDecodedFrame not found observer uid %d:", Long.valueOf(uid));
                        }
                    } else if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(TAG, "onVideoDecodedFrame not found decoder uid %d", Long.valueOf(uid));
                    }
                    s_observerLock.readLock().unlock();
                }
            }
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "onDecodedFrameData empty observer map");
            }
        } catch (Exception e2) {
            ThunderLog.error(TAG, "onDecodedFrameData err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.readLock().unlock();
            throw th2;
        }
        s_observerLock.readLock().unlock();
    }

    public void onFirstFrameDecodeNotify(long streamId, long pts, long happenTime) {
        long j2 = mCallBackPtr;
        if (j2 != 0) {
            onFirstFrameDecodeNotify(j2, streamId, pts, happenTime);
            if (this.mThunderVideoHandler != null) {
                final long f_streamId = streamId;
                if (Thread.currentThread().getId() != this.mThunderVideoHandler.getLooper().getThread().getId()) {
                    this.mThunderVideoHandler.post(new Runnable() {
                        public void run() {
                            if (ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                                int unused = ThunderVideoPlayEngineImp.this.relinkStreamId(f_streamId);
                            }
                        }
                    });
                } else if (this.mThunderPlayerMultiViewMode.get()) {
                    relinkStreamId(streamId);
                }
            }
        }
    }

    public void playInit() {
        this.mThunderVideoPlayListener = new ThunderVideoPlayListener(YYVideoLibMgr.instance().getAppContext(), this);
        YYVideoLibMgr.instance().setVideoInfoListener("Thunder", this.mThunderVideoPlayListener);
        ThunderVideoHiidoUtil thunderVideoHiidoUtil = new ThunderVideoHiidoUtil(YYVideoLibMgr.instance().getAppContext());
        this.mVideoPlayHiidoUtil = thunderVideoHiidoUtil;
        thunderVideoHiidoUtil.register();
        if (s_observerLock == null) {
            s_observerLock = new ReentrantReadWriteLock();
        }
        this.mVideoDecodeObserverMap = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread("yrtcPlayEngine");
        this.mThunderVideoHandlerThread = handlerThread;
        handlerThread.setPriority(10);
        this.mThunderVideoHandlerThread.start();
        this.mThunderVideoHandler = new Handler(this.mThunderVideoHandlerThread.getLooper());
        this.mVideoStreamInfoMap = new ConcurrentHashMap<>();
        this.mMultiVideoScaleModeMap = new ConcurrentHashMap<>();
        this.mMultiVideoMirrorModeMap = new ConcurrentHashMap<>();
        this.mMultiStreamKeyIdMap = new ConcurrentHashMap<>();
        this.mUidToVideoIdCallBackInDualStreamMap = new ConcurrentHashMap<>();
        YMFPlayerUsrBehaviorStat.getInstance().setYMFBehaviorEventListener(this);
        setRemotePlayType(1);
        new ThunderVideoConfig().AsyncLoad();
    }

    public int startPlayVideoStream(String streamKey, Object toView, int scaleMode, int mirrorMode, int encodeType, boolean bSupportHdwDecode) {
        String str = streamKey;
        if (str == null || streamKey.isEmpty()) {
            ThunderLog.error(TAG, "ERROR startPlayVideoStream without right key:%s, scaleMode:%d, mirrorMode:%d, bSupportHdwDecode:%b", streamKey, Integer.valueOf(scaleMode), Integer.valueOf(mirrorMode), Boolean.valueOf(bSupportHdwDecode));
            return -1;
        }
        ThunderLog.release(TAG, "startPlayVideoStream streamKey:" + str + " toView:" + toView + " scaleMode:" + scaleMode + " mirrorMode:" + mirrorMode + " encodeType:" + encodeType + " bSupportHdwDecode:" + bSupportHdwDecode);
        if (this.mThunderVideoHandler != null) {
            String f_streamKey = streamKey;
            Object f_toView = toView;
            int f_scaleMode = scaleMode;
            int f_mirrorMode = mirrorMode;
            int f_encodeType = encodeType;
            boolean f_bSupportHdwDecode = bSupportHdwDecode;
            if (Thread.currentThread().getId() != this.mThunderVideoHandler.getLooper().getThread().getId()) {
                int f_mirrorMode2 = f_mirrorMode;
                final String str2 = f_streamKey;
                final Object obj = f_toView;
                final int i2 = f_scaleMode;
                final int i3 = f_mirrorMode2;
                final int i4 = f_encodeType;
                final boolean z = f_bSupportHdwDecode;
                this.mThunderVideoHandler.post(new Runnable() {
                    public void run() {
                        if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            int unused = ThunderVideoPlayEngineImp.this.startPlayNormalVideoStream(str2, obj, i2, i3);
                        } else {
                            int unused2 = ThunderVideoPlayEngineImp.this.startPlayMultiVideoStream(str2, obj, i2, i3, i4, z);
                        }
                    }
                });
            } else if (!this.mThunderPlayerMultiViewMode.get()) {
                startPlayNormalVideoStream(f_streamKey, f_toView, f_scaleMode, f_mirrorMode);
            } else {
                int i5 = f_scaleMode;
                startPlayMultiVideoStream(f_streamKey, f_toView, f_scaleMode, f_mirrorMode, f_encodeType, f_bSupportHdwDecode);
            }
        }
        return 0;
    }

    public boolean switchDualVideoView(String dstStreamKey, String srcStreamKey, int dstEncodeType) {
        if (dstStreamKey == null || dstStreamKey.isEmpty() || srcStreamKey == null || srcStreamKey.isEmpty()) {
            ThunderLog.error(TAG, "ERROR switchDualVideoView without right dstkey:%s, srcKey:%s", dstStreamKey, srcStreamKey);
            return false;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "switchDualVideoView dstStreamKey:%s srcStreamKey:%s dstEncodeType:%d", dstStreamKey, srcStreamKey, Integer.valueOf(dstEncodeType));
        }
        if (this.mThunderVideoHandler != null) {
            final String f_srcStreamKey = srcStreamKey;
            final String f_dstStreamKey = dstStreamKey;
            final int f_dstEncodeType = dstEncodeType;
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                switchDualVideoViewUI(f_dstStreamKey, f_srcStreamKey, f_dstEncodeType);
            } else {
                this.mThunderVideoHandler.post(new Runnable() {
                    public void run() {
                        boolean unused = ThunderVideoPlayEngineImp.this.switchDualVideoViewUI(f_dstStreamKey, f_srcStreamKey, f_dstEncodeType);
                    }
                });
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void stopPlayMultiVideoStream(String streamKey) {
        ThunderPlayerMultiViewProxy proxy = this.mVideoMultiViewMap.get(streamKey);
        if (proxy != null) {
            proxy.unlink(streamKey);
            this.mVideoMultiViewMap.remove(streamKey);
            this.mMultiStreamKeyIdMap.remove(streamKey);
        }
    }

    public int stopPlayVideoStream(String streamKey) {
        ThunderLog.release(TAG, "stopPlayVideoStream streamKey:" + streamKey);
        final String f_streamKey = streamKey;
        if (this.mThunderVideoHandler == null) {
            return 0;
        }
        if (Thread.currentThread().getId() != this.mThunderVideoHandler.getLooper().getThread().getId()) {
            this.mThunderVideoHandler.post(new Runnable() {
                public void run() {
                    if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                        int unused = ThunderVideoPlayEngineImp.this.stopPlayNormalVideoStream(f_streamKey);
                    } else {
                        ThunderVideoPlayEngineImp.this.stopPlayMultiVideoStream(f_streamKey);
                    }
                }
            });
            return 0;
        } else if (!this.mThunderPlayerMultiViewMode.get()) {
            stopPlayNormalVideoStream(f_streamKey);
            return 0;
        } else {
            stopPlayMultiVideoStream(f_streamKey);
            return 0;
        }
    }

    public Object getPlayVideoScreenshot(String streamKey) {
        if (this.mThunderVideoHandler == null) {
            return null;
        }
        if (!this.mThunderPlayerMultiViewMode.get()) {
            VideoStreamInfo info = this.mVideoStreamInfoMap.get(streamKey);
            if (info == null) {
                ThunderLog.warn(TAG, "getPlayVideoScreenshot key:%s unexisted", streamKey);
                return null;
            }
            ThunderPlayerView view2 = info.getThunderPlayerView();
            if (view2 != null) {
                return view2.getVideoScreenshot(-1);
            }
            ThunderLog.warn(TAG, "getPlayVideoScreenshot: cann't find video view for stream:%s", streamKey);
            return null;
        } else if (this.mVideoMultiViewMap.get(streamKey) != null) {
            return this.mVideoMultiViewMap.get(streamKey).getVideoScreenshot(streamKey);
        } else {
            ThunderLog.warn(TAG, "getPlayVideoScreenshot key:%s unexisted", streamKey);
            return null;
        }
    }

    public int setRemoteVideoStreamLastFrameMode(int lastFrameMode) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "setRemoteVideoStreamLastFrameMode:%d", Integer.valueOf(lastFrameMode));
        }
        this.mLastFrameMode = lastFrameMode;
        if (this.mThunderVideoHandler != null) {
            if (!this.mThunderPlayerMultiViewMode.get()) {
                for (VideoStreamInfo info : this.mVideoStreamInfoMap.values()) {
                    ThunderPlayerView view2 = info.getThunderPlayerView();
                    if (view2 == null) {
                        ThunderLog.warn(TAG, "setRemoteVideoStreamLastFrameMode: cann't find video view");
                        return -1;
                    }
                    view2.setRemoteVideoStreamLastFrameMode(lastFrameMode);
                }
            } else {
                for (ThunderPlayerMultiViewProxy viewProxy : this.mVideoMultiViewMap.values()) {
                    viewProxy.setRemoteVideoStreamLastFrameMode(lastFrameMode);
                }
            }
            return 0;
        }
        ThunderLog.warn(TAG, "setRemoteVideoStreamLastFrameMode failed ThunderVideoHandler is null");
        return -1;
    }

    public void addVideoFrameObserver(long uid, String strUid, Object observer) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "addVideoFrameObserver %s, uid: %d, strUid: %s", observer.toString(), Long.valueOf(uid), strUid);
        }
        try {
            s_observerLock.writeLock().lock();
            if (this.mVideoDecodeObserverMap.get(Long.valueOf(uid)) == null) {
                this.mVideoDecodeObserverMap.put(Long.valueOf(uid), new StrUidVideoDecodeObserver());
            }
            this.mVideoDecodeObserverMap.get(Long.valueOf(uid)).setStrUid(strUid);
            this.mVideoDecodeObserverMap.get(Long.valueOf(uid)).setObserver((IVideoDecodeObserver) observer);
        } catch (Exception e2) {
            ThunderLog.error(TAG, "addVideoFrameObserver err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.writeLock().unlock();
            throw th2;
        }
        s_observerLock.writeLock().unlock();
    }

    public void removeVideoFrameObserver(long uid, String strUid) {
        ThunderLog.release(TAG, "removeVideoFrameObserver uid: %d, strUid %s", Long.valueOf(uid), strUid);
        try {
            s_observerLock.writeLock().lock();
            if (this.mVideoDecodeObserverMap.get(Long.valueOf(uid)) != null) {
                this.mVideoDecodeObserverMap.get(Long.valueOf(uid)).removeObserver();
            }
            if (this.mC2JavaUidMap.containsValue(Long.valueOf(uid))) {
                Iterator<Long> iter = this.mC2JavaUidMap.keySet().iterator();
                while (true) {
                    if (!iter.hasNext()) {
                        break;
                    }
                    Long key = iter.next();
                    if (this.mC2JavaUidMap.get(key).longValue() == uid) {
                        this.mC2JavaUidMap.remove(key);
                        break;
                    }
                }
            }
            if (this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(uid)) != null) {
                this.mUidToVideoIdCallBackInDualStreamMap.remove(Long.valueOf(uid));
            }
        } catch (Exception e2) {
            ThunderLog.error(TAG, "removeVideoFrameObserver err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.writeLock().unlock();
            throw th2;
        }
        s_observerLock.writeLock().unlock();
    }

    public void addVideoFrameObserverInDualStream(long uid32, long streamId, Object observer) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "addVideoFrameObserverInDualStream uid: %d, streamId: %d", Long.valueOf(uid32), Long.valueOf(streamId));
        }
        try {
            s_observerLock.writeLock().lock();
            this.mUidToVideoIdCallBackInDualStreamMap.put(Long.valueOf(uid32), Long.valueOf(streamId));
        } catch (Exception e2) {
            ThunderLog.error(TAG, "addVideoFrameObserverInDualStream err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.writeLock().unlock();
            throw th2;
        }
        s_observerLock.writeLock().unlock();
    }

    public boolean updatePlayVideoView(String streamKey, Object toView, int scaleMode, int mirrorMode) {
        String str = streamKey;
        if (str == null) {
            Object obj = toView;
            int i2 = scaleMode;
            int i3 = mirrorMode;
        } else if (streamKey.isEmpty()) {
            Object obj2 = toView;
            int i4 = scaleMode;
            int i5 = mirrorMode;
        } else {
            String f_streamKey = streamKey;
            Object f_toView = toView;
            int f_scaleMode = scaleMode;
            int f_mirrorMode = mirrorMode;
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "updatePlayVideoView streamKey:" + str + " toView:" + toView + " scaleMode:" + scaleMode + " mirrorMode:" + mirrorMode);
            } else {
                Object obj3 = toView;
                int i6 = scaleMode;
                int i7 = mirrorMode;
            }
            if (this.mThunderVideoHandler == null) {
                return true;
            }
            if (Thread.currentThread().getId() != this.mThunderVideoHandler.getLooper().getThread().getId()) {
                Handler handler = this.mThunderVideoHandler;
                final String str2 = f_streamKey;
                final Object obj4 = f_toView;
                final int i8 = f_scaleMode;
                AnonymousClass5 r6 = r0;
                final int i9 = f_mirrorMode;
                AnonymousClass5 r0 = new Runnable() {
                    public void run() {
                        if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            boolean unused = ThunderVideoPlayEngineImp.this.updateNormalPlayVideoView(str2, obj4, i8, i9);
                        } else if (obj4 != null && ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str2) != null) {
                            if (((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str2)).getVideoPlayerView() == null || ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str2)).getVideoPlayerView().equals(obj4)) {
                                ThunderVideoPlayEngineImp.this.mMultiVideoMirrorModeMap.put(str2, Integer.valueOf(i9));
                                ThunderVideoPlayEngineImp.this.mMultiVideoScaleModeMap.put(str2, Integer.valueOf(i8));
                                ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str2)).setMirrorMode(str2, i9);
                                ((ThunderPlayerMultiViewProxy) ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.get(str2)).setScaleMode(str2, i8);
                                for (ThunderPlayerMultiViewProxy viewProxy : ThunderVideoPlayEngineImp.this.mVideoMultiViewMap.values()) {
                                    viewProxy.setRemoteVideoStreamLastFrameMode(ThunderVideoPlayEngineImp.this.mLastFrameMode);
                                }
                                return;
                            }
                            ThunderLog.warn(ThunderVideoPlayEngineImp.TAG, "may toView is change!");
                        }
                    }
                };
                handler.post(r6);
                return true;
            } else if (!this.mThunderPlayerMultiViewMode.get()) {
                updateNormalPlayVideoView(f_streamKey, f_toView, f_scaleMode, f_mirrorMode);
                return true;
            } else if (f_toView == null || this.mVideoMultiViewMap.get(f_streamKey) == null) {
                return false;
            } else {
                if (this.mVideoMultiViewMap.get(f_streamKey).getVideoPlayerView() == null || this.mVideoMultiViewMap.get(f_streamKey).getVideoPlayerView().equals(f_toView)) {
                    this.mMultiVideoMirrorModeMap.put(f_streamKey, Integer.valueOf(f_mirrorMode));
                    this.mMultiVideoScaleModeMap.put(f_streamKey, Integer.valueOf(f_scaleMode));
                    this.mVideoMultiViewMap.get(f_streamKey).setMirrorMode(f_streamKey, f_mirrorMode);
                    this.mVideoMultiViewMap.get(f_streamKey).setScaleMode(f_streamKey, f_scaleMode);
                    for (ThunderPlayerMultiViewProxy viewProxy : this.mVideoMultiViewMap.values()) {
                        viewProxy.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
                    }
                    return true;
                }
                ThunderLog.warn(TAG, "may toView is change!");
                return false;
            }
        }
        return false;
    }

    public int onVideoStreamArrive(String streamKey, long streamId, String strUid) {
        long j2 = streamId;
        String str = strUid;
        VideoDecodeRuntimeInfo.instance().addVideoStream(j2, str);
        ThunderLog.release(TAG, "onVideoStreamArrive:%s-%d strUid:%s", streamKey, Long.valueOf(streamId), str);
        if (this.mThunderVideoHandler != null) {
            String f_streamKey = streamKey;
            long f_streamId = streamId;
            String f_strUid = strUid;
            if (Thread.currentThread().getId() != this.mThunderVideoHandler.getLooper().getThread().getId()) {
                final String str2 = f_streamKey;
                AnonymousClass6 r11 = r1;
                final String str3 = f_strUid;
                String str4 = f_strUid;
                final long j3 = f_streamId;
                AnonymousClass6 r1 = new Runnable() {
                    public void run() {
                        if (!ThunderVideoPlayEngineImp.this.mThunderPlayerMultiViewMode.get()) {
                            ThunderVideoPlayEngineImp.this.mStreamKeyStrUidMap.put(str2, str3);
                            int unused = ThunderVideoPlayEngineImp.this.updatePlayNormalVideoStream(str2, j3);
                            return;
                        }
                        ThunderVideoPlayEngineImp.this.mMultiStreamKeyIdMap.put(str2, Long.valueOf(j3));
                        ThunderVideoPlayEngineImp.this.mStreamKeyStrUidMap.put(str2, str3);
                        int unused2 = ThunderVideoPlayEngineImp.this.startPlayVideoStreamArrive(str2, j3);
                    }
                };
                this.mThunderVideoHandler.post(r11);
            } else if (!this.mThunderPlayerMultiViewMode.get()) {
                this.mStreamKeyStrUidMap.put(f_streamKey, f_strUid);
                updatePlayNormalVideoStream(f_streamKey, f_streamId);
            } else {
                this.mMultiStreamKeyIdMap.put(f_streamKey, Long.valueOf(f_streamId));
                this.mStreamKeyStrUidMap.put(f_streamKey, f_strUid);
                startPlayVideoStreamArrive(f_streamKey, f_streamId);
            }
        }
        try {
            s_observerLock.writeLock().lock();
            if (this.mC2JavaUidMap.get(Long.valueOf(j2 >> 32)) != null) {
                long uid32 = this.mC2JavaUidMap.get(Long.valueOf(j2 >> 32)).longValue();
                if (this.mVideoDecodeObserverMap.get(Long.valueOf(uid32)) == null) {
                    this.mVideoDecodeObserverMap.put(Long.valueOf(uid32), new StrUidVideoDecodeObserver());
                }
                this.mVideoDecodeObserverMap.get(Long.valueOf(uid32)).setbObserverEnable(true);
            }
        } catch (Exception e2) {
            ThunderLog.error(TAG, "onVideoStreamArrive err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.writeLock().unlock();
            throw th2;
        }
        s_observerLock.writeLock().unlock();
        return 0;
    }

    public int onVideoStreamStop(String streamKey, long streamId) {
        ThunderLog.release(TAG, "onVideoStreamStop streamKey:" + streamKey + " streamId:" + streamId);
        try {
            s_observerLock.readLock().lock();
            if (this.mC2JavaUidMap.get(Long.valueOf(streamId >> 32)) != null) {
                long uid32 = this.mC2JavaUidMap.get(Long.valueOf(streamId >> 32)).longValue();
                StrUidVideoDecodeObserver observer = this.mVideoDecodeObserverMap.get(Long.valueOf(uid32));
                if (observer != null) {
                    observer.setbObserverEnable(false);
                }
                if (this.mUidToVideoIdCallBackInDualStreamMap.get(Long.valueOf(uid32)) != null) {
                    this.mUidToVideoIdCallBackInDualStreamMap.remove(Long.valueOf(uid32));
                }
            }
        } catch (Exception e2) {
            ThunderLog.error(TAG, "onVideoStreamStop err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.readLock().unlock();
            throw th2;
        }
        s_observerLock.readLock().unlock();
        VideoDecodeRuntimeInfo.instance().removeVideoStream(streamId);
        return 0;
    }

    public void setVideoPlayEngineCallBack(long ptr) {
        mCallBackPtr = ptr;
    }

    public static String getVideoPlayLibVersion() {
        return "200.4.4.2";
    }

    public String getAudienceHiidoStatInfo(long streamId) {
        if (this.mVideoPlayHiidoUtil != null) {
            return ThunderVideoHiidoUtil.getAudienceStatInfo();
        }
        return "";
    }

    public long getPlayRuntimeInfo(long streamId, int type) {
        switch (type) {
            case 0:
                return VideoPlayer.getInstance().getPlayerInfo(streamId, VideoPlayer.VideoPlayerInfoEnum.FRAME);
            case 1:
                return VideoPlayer.getInstance().getPlayerInfo(streamId, VideoPlayer.VideoPlayerInfoEnum.BITRATE);
            case 2:
                return VideoPlayer.getInstance().getPlayerInfo(streamId, VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
            case 3:
                return VideoPlayer.getInstance().getPlayerInfo(streamId, VideoPlayer.VideoPlayerInfoEnum.DECODERTYPE);
            default:
                return 0;
        }
    }

    public boolean queryOnlyDecoded(long streamId, long uid) {
        boolean result = false;
        try {
            s_observerLock.readLock().lock();
            this.mC2JavaUidMap.put(Long.valueOf(streamId >> 32), Long.valueOf(uid));
            StrUidVideoDecodeObserver strUidObserver = null;
            IVideoDecodeObserver observer = null;
            ConcurrentHashMap<Long, StrUidVideoDecodeObserver> concurrentHashMap = this.mVideoDecodeObserverMap;
            if (!(concurrentHashMap == null || concurrentHashMap.isEmpty() || (strUidObserver = this.mVideoDecodeObserverMap.get(Long.valueOf(uid))) == null)) {
                observer = strUidObserver.getObserver();
            }
            if (strUidObserver == null || observer == null) {
                result = false;
            } else {
                result = true;
            }
        } catch (Exception e2) {
            ThunderLog.error(TAG, "queryOnlyDecoded err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.readLock().unlock();
            throw th2;
        }
        s_observerLock.readLock().unlock();
        return result;
    }

    public void initMultiPlayerViewLayout(Object params) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "initMultiPlayerViewLayout params:" + params);
        }
        if (this.mThunderVideoHandler != null && params != null) {
            final ThunderMultiVideoViewParam f_params = (ThunderMultiVideoViewParam) params;
            if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
                initMultiLayout(f_params, this);
            } else {
                this.mThunderVideoHandler.post(new Runnable() {
                    public void run() {
                        ThunderVideoPlayEngineImp.this.initMultiLayout(f_params, this);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void initMultiLayout(ThunderMultiVideoViewParam layoutParam, ThunderVideoPlayEngineImp engine) {
        if (layoutParam == null) {
            ThunderLog.error(TAG, "initMultiPlayerViewLayout params null");
        } else if (this.mThunderPlayerMultiViewMode.get()) {
            int viewId = layoutParam.mViewId;
            Object multiView = layoutParam.mView;
            ThunderLog.error(TAG, "initMultiPlayerViewLayout params:" + layoutParam + "  mView:" + multiView + " viewId:" + viewId);
            if (viewId >= 0) {
                if (multiView == null || !checkMultiViewExist(multiView, viewId)) {
                    if (this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId)) == null) {
                        this.mThunderPlayerMultiViewProxyMap.put(Integer.valueOf(viewId), new ThunderPlayerMultiViewProxy(YYVideoLibMgr.instance().getAppContext(), engine));
                    }
                    this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId)).initMultiPlayerViewLayout(layoutParam);
                    this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId)).updateMultiPlayerView(multiView);
                } else {
                    ThunderLog.error(TAG, "repeated view, already exist，" + multiView);
                    int oldViewId = getMultiViewId(multiView);
                    if (oldViewId < 0 && oldViewId != -4001) {
                        this.mThunderPlayerMultiViewProxyMap.put(Integer.valueOf(viewId), this.mThunderPlayerMultiViewProxyMap.remove(Integer.valueOf(oldViewId)));
                    }
                    if (this.mThunderPlayerMultiViewProxyMap.containsKey(Integer.valueOf(viewId))) {
                        this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId)).initMultiPlayerViewLayout(layoutParam);
                        return;
                    }
                    return;
                }
            }
            if (viewId < 0) {
                if (this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId)) == null) {
                    this.mThunderPlayerMultiViewProxyMap.put(Integer.valueOf(viewId), new ThunderPlayerMultiViewProxy(YYVideoLibMgr.instance().getAppContext(), engine));
                }
                this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId)).initMultiPlayerViewLayout(layoutParam);
            }
            if (multiView == null && viewId >= 0 && this.mThunderPlayerMultiViewProxyMap.containsKey(Integer.valueOf(viewId))) {
                this.mThunderPlayerMultiViewProxyMap.remove(Integer.valueOf(viewId));
            }
        }
    }

    /* access modifiers changed from: private */
    public void clearProxy() {
        clearLastFrame();
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            ThunderPlayerMultiViewProxy proxy = entry.getValue();
            if (proxy != null) {
                proxy.quitRoom();
            }
        }
        Iterator<Integer> iter = this.mThunderPlayerMultiViewProxyMap.keySet().iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            if (key.intValue() < 0 && this.mThunderPlayerMultiViewProxyMap.get(key) != null && !(this.mThunderPlayerMultiViewProxyMap.get(key).getPlayerView() instanceof ThunderExternalSurfaceView)) {
                iter.remove();
            }
        }
        this.mVideoMultiViewMap.clear();
        this.mVideoMultiViewRecoverMap.clear();
        this.mStreamKeyStrUidMap.clear();
    }

    public void onPlayEngineLeaveRoom() {
        if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
            clearProxy();
        } else {
            this.mThunderVideoHandler.post(new Runnable() {
                public void run() {
                    ThunderVideoPlayEngineImp.this.clearProxy();
                }
            });
        }
    }

    public void setVideoPlayType(int playType) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "setVideoPlayType playType:" + playType);
        }
        final int f_playType = playType;
        if (this.mThunderVideoHandler == null) {
            return;
        }
        if (Thread.currentThread().getId() == this.mThunderVideoHandler.getLooper().getThread().getId()) {
            setRemotePlayType(f_playType);
        } else {
            this.mThunderVideoHandler.post(new Runnable() {
                public void run() {
                    ThunderVideoPlayEngineImp.this.setRemotePlayType(f_playType);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setRemotePlayType(int playType) {
        if (playType == 1) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "multiLianMai mode " + playType);
            }
            this.mThunderPlayerMultiViewMode.set(true);
            return;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "non-multiLianMai mode " + playType);
        }
        clearMultiView();
        this.mThunderPlayerMultiViewProxyMap.clear();
        this.mVideoMultiViewMap.clear();
        this.mVideoMultiViewRecoverMap.clear();
        this.mStreamKeyStrUidMap.clear();
        this.mThunderPlayerMultiViewMode.set(false);
    }

    private void initDefaultMultiViewParam(int viewId) {
        ThunderMultiVideoViewParam param = new ThunderMultiVideoViewParam();
        ThunderMultiVideoViewCoordinate coordinate = new ThunderMultiVideoViewCoordinate();
        coordinate.mIndex = 0;
        coordinate.mHeight = -2;
        coordinate.mWidth = -2;
        coordinate.mX = 0;
        coordinate.mY = 0;
        param.mVideoViewPositions = new ArrayList<>(1);
        param.mVideoViewPositions.add(coordinate);
        param.mViewId = viewId;
        initMultiPlayerViewLayout(param);
    }

    /* access modifiers changed from: private */
    public boolean updateSeat(String streamKey, Object toView, int seat) {
        Object view2 = toView;
        if (view2 == null) {
            ThunderLog.error(TAG, "updateUserSeat toView null");
            return false;
        }
        if (!(this.mVideoMultiViewMap.get(streamKey) == null || findMultiViewProxy(view2) == null)) {
            boolean result = this.mVideoMultiViewMap.get(streamKey).updateSeat(streamKey, seat) >= 0;
            this.mVideoMultiViewMap.get(streamKey).setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
            if (!result) {
                return false;
            }
            int scaleMode = this.mMultiVideoScaleModeMap.get(streamKey) == null ? -1 : this.mMultiVideoScaleModeMap.get(streamKey).intValue();
            if (scaleMode != -1) {
                this.mVideoMultiViewMap.get(streamKey).setScaleMode(streamKey, scaleMode);
            }
            int mirrorMode = this.mMultiVideoMirrorModeMap.get(streamKey) == null ? -1 : this.mMultiVideoMirrorModeMap.get(streamKey).intValue();
            if (mirrorMode != -1) {
                this.mVideoMultiViewMap.get(streamKey).setMirrorMode(streamKey, mirrorMode);
            }
            for (ThunderPlayerMultiViewProxy viewProxy : this.mVideoMultiViewMap.values()) {
                viewProxy.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
            }
        }
        return true;
    }

    public boolean updateUserSeat(String streamKey, Object toView, int seat) {
        ThunderLog.release(TAG, "updateUserSeat streamKey:" + streamKey + " toView:" + toView + " seat:" + seat);
        if (this.mThunderVideoHandler == null) {
            return true;
        }
        final String f_streamKey = streamKey;
        final Object f_toView = toView;
        final int f_seat = seat;
        if (Thread.currentThread().getId() != this.mThunderVideoHandler.getLooper().getThread().getId()) {
            this.mThunderVideoHandler.post(new Runnable() {
                public void run() {
                    boolean unused = ThunderVideoPlayEngineImp.this.updateSeat(f_streamKey, f_toView, f_seat);
                }
            });
            return true;
        } else if (!this.mThunderPlayerMultiViewMode.get()) {
            return true;
        } else {
            updateSeat(f_streamKey, f_toView, f_seat);
            return true;
        }
    }

    public ThunderPlayerMultiViewProxy findMultiViewProxy(Object view2) {
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            ThunderPlayerMultiViewProxy proxy = entry.getValue();
            if (proxy.getVideoPlayerView() == view2) {
                return proxy;
            }
        }
        return null;
    }

    public boolean checkMultiViewExist(Object view2, int viewId) {
        if (view2 == null || viewId < 0) {
            return false;
        }
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            if (entry.getValue().getVideoPlayerView() == view2 && entry.getKey().intValue() != viewId) {
                ThunderLog.error(TAG, "view " + view2 + "already locate in viewId:" + entry.getKey());
                return true;
            }
        }
        return false;
    }

    private int getMultiViewId(Object view2) {
        if (view2 == null) {
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            if (entry.getValue().getVideoPlayerView() == view2) {
                return entry.getKey().intValue();
            }
        }
        return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
    }

    public void clearMultiView() {
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            ThunderPlayerMultiViewProxy proxy = entry.getValue();
            if (proxy != null) {
                proxy.destroyVideoPlayerView();
            }
        }
    }

    public void clearLastFrame() {
        for (Map.Entry<Integer, ThunderPlayerMultiViewProxy> entry : this.mThunderPlayerMultiViewProxyMap.entrySet()) {
            ThunderPlayerMultiViewProxy proxy = entry.getValue();
            if (proxy != null) {
                proxy.clearLastFrame();
            }
        }
    }

    public void destroyPlayEngine() {
        YMFPlayerUsrBehaviorStat.getInstance().setYMFBehaviorEventListener((IYMFBehaviorEventListener) null);
        ThunderVideoHiidoUtil thunderVideoHiidoUtil = this.mVideoPlayHiidoUtil;
        if (thunderVideoHiidoUtil != null) {
            thunderVideoHiidoUtil.unRegister();
        }
        try {
            if (this.mThunderVideoHandler != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mThunderVideoHandlerThread.quitSafely();
                } else {
                    this.mThunderVideoHandlerThread.quit();
                }
                this.mThunderVideoHandler = null;
                this.mThunderVideoHandlerThread = null;
            }
            s_observerLock.writeLock().lock();
            this.mVideoDecodeObserverMap.clear();
            this.mUidToVideoIdCallBackInDualStreamMap.clear();
            clearMultiView();
            this.mThunderPlayerMultiViewProxyMap.clear();
            this.mSurfacePlayerProxyMap.clear();
            this.mLastFrameMode = 0;
        } catch (Exception e2) {
            ThunderLog.error(TAG, "destroyPlayEngine err=%s", e2.toString());
        } catch (Throwable th2) {
            s_observerLock.writeLock().unlock();
            throw th2;
        }
        s_observerLock.writeLock().unlock();
    }

    /* access modifiers changed from: private */
    public boolean updateNormalPlayVideoView(String streamKey, Object toView, int scaleMode, int mirrorMode) {
        VideoStreamInfo info = this.mVideoStreamInfoMap.get(streamKey);
        if (info == null) {
            ThunderLog.error(TAG, "updatePlayVideoView unexist info key:" + streamKey);
            return false;
        } else if (toView == null || (toView instanceof ThunderPlayerView)) {
            long streamId = info.getStreamId();
            ThunderPlayerView newView = (ThunderPlayerView) toView;
            ThunderPlayerView oldView = info.getThunderPlayerView();
            ThunderLog.release(TAG, "updateNormalPlayVideoView key " + streamKey + " toView " + toView + " oldView " + oldView + " scaleMode " + scaleMode + " mirrorMode " + mirrorMode);
            if (oldView == null && newView == null) {
                return false;
            }
            if (oldView == null && newView != null) {
                info.setThunderPlayerView(newView);
                newView.unLinkFromStream();
                if (-1 != streamId) {
                    newView.linkToStream(streamId);
                    newView.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
                    newView.setScaleMode(scaleMode);
                    newView.setMirrorMode(-1, mirrorMode);
                    info.setScaleMode(scaleMode);
                    info.setMirrorMode(mirrorMode);
                }
                return true;
            } else if (oldView != null && newView == null) {
                if (-1 != streamId) {
                    oldView.unLinkFromStream();
                }
                info.setThunderPlayerView((ThunderPlayerView) null);
                return true;
            } else if (!(toView instanceof ThunderPlayerView) || oldView.equals(toView)) {
                info.setScaleMode(scaleMode);
                info.setMirrorMode(mirrorMode);
                oldView.setScaleMode(scaleMode);
                oldView.setMirrorMode(-1, mirrorMode);
                return true;
            } else {
                ThunderLog.warn(TAG, "may toView is change!");
                return false;
            }
        } else {
            ThunderLog.error(TAG, "updateNormalPlayVideoView toView error:" + toView);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public int startPlayNormalVideoStream(String streamKey, Object toView, int scaleMode, int mirrorMode) {
        ThunderLog.release(TAG, "startPlayNormalVideoStream key:%s, scaleMode:%d, mirrorMode:%d", streamKey, Integer.valueOf(scaleMode), Integer.valueOf(mirrorMode));
        checkStartPlayDualStream(streamKey);
        VideoStreamInfo streamInfo = getStreamInfo(streamKey);
        ThunderPlayerView existedView = streamInfo.getThunderPlayerView();
        if (toView != null && (toView instanceof ThunderPlayerView)) {
            ThunderPlayerView view2 = (ThunderPlayerView) toView;
            if (existedView != null) {
                if (!view2.equals(existedView)) {
                    existedView.unLinkFromStream();
                    ThunderLog.release(TAG, "startPlayNormalVideoStream changed view old:" + existedView + " new:" + view2);
                } else if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(TAG, "startPlayNormalVideoStream the same view old:" + existedView + " new:" + view2);
                }
            }
            view2.setScaleMode(scaleMode);
            view2.setMirrorMode(-1, mirrorMode);
            streamInfo.setThunderPlayerView(view2);
        }
        ThunderPlayerView existedView2 = streamInfo.getThunderPlayerView();
        if (existedView2 != null) {
            if (!streamInfo.isViewPrepared()) {
                existedView2.unLinkFromStream();
                if (streamInfo.getStreamId() != -1) {
                    existedView2.linkToStream(streamInfo.getStreamId());
                    existedView2.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
                }
            }
            if (streamInfo.isLinkedToStream()) {
                ThunderLog.warn(TAG, "startPlayNormalVideoStream has linkedToStream %d", Long.valueOf(streamInfo.getStreamId()));
            } else if (streamInfo.getStreamId() != -1) {
                existedView2.linkToStream(streamInfo.getStreamId());
                existedView2.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
                ThunderLog.release(TAG, "startPlayNormalVideoStream linkToStream %d", Long.valueOf(streamInfo.getStreamId()));
            }
        } else {
            ThunderLog.warn(TAG, "ERROR startPlayNormalVideoStream view is null");
        }
        streamInfo.setScaleMode(scaleMode);
        streamInfo.setMirrorMode(mirrorMode);
        return 0;
    }

    /* access modifiers changed from: private */
    public int stopPlayNormalVideoStream(String streamKey) {
        VideoStreamInfo info = this.mVideoStreamInfoMap.get(streamKey);
        if (info == null) {
            ThunderLog.release(TAG, "ERROR stopPlayNormalVideoStream unexsited key:%s", streamKey);
            return -1;
        }
        ThunderLog.release(TAG, "stopPlayNormalVideoStream %s", streamKey);
        ThunderPlayerView view2 = info.getThunderPlayerView();
        if (view2 != null) {
            view2.unLinkFromStream();
        } else {
            ThunderLog.release(TAG, "ERROR stopPlayNormalVideoStream unexsited view");
        }
        this.mVideoStreamInfoMap.remove(streamKey);
        return 0;
    }

    private int onNormalVideoStreamStop(String streamKey, long streamId) {
        VideoStreamInfo info = this.mVideoStreamInfoMap.get(streamKey);
        if (info == null) {
            ThunderLog.release(TAG, "onVideoStreamStop key:%s unexisted", streamKey);
            return -1;
        }
        ThunderPlayerView view2 = info.getThunderPlayerView();
        if (view2 == null) {
            ThunderLog.warn(TAG, "onVideoStreamStop: cann't find video view for stream:%s", streamKey);
            return -1;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "unlink stream:%s-%d", streamKey, Long.valueOf(streamId));
        }
        view2.unLinkFromStream(streamId);
        return 0;
    }

    /* access modifiers changed from: private */
    public int startPlayMultiVideoStream(String streamKey, Object toView, int scaleMode, int mirrorMode, int encodeType, boolean bSupportHdwDecode) {
        Object view2 = toView;
        if (view2 != null) {
            ThunderPlayerMultiViewProxy proxy = findMultiViewProxy(view2);
            if (proxy != null) {
                if (this.mVideoMultiViewMap.get(streamKey) != null) {
                    ThunderPlayerMultiViewProxy old = this.mVideoMultiViewMap.get(streamKey);
                    if (!(old == null || old == proxy)) {
                        old.unlink(streamKey);
                    }
                    this.mVideoMultiViewRecoverMap.put(streamKey, old);
                }
                proxy.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
                this.mVideoMultiViewMap.put(streamKey, proxy);
                checkStartPlayDualStream(streamKey);
            } else {
                ThunderLog.warn(TAG, "initMultiPlayerViewLayout not called " + toView);
                if (view2 == null || !(view2 instanceof Surface)) {
                    ThunderPlayerMultiViewProxy old2 = this.mVideoMultiViewMap.get(streamKey);
                    if (old2 != null) {
                        old2.unlink(streamKey);
                    }
                    initDefaultPlayerProxy(streamKey, view2);
                } else {
                    ThunderPlayerMultiViewProxy old3 = this.mVideoMultiViewMap.get(streamKey);
                    if (old3 != null) {
                        old3.unlink(streamKey);
                    }
                    initDefaultSurfacePlayerProxy(streamKey, view2);
                }
            }
        }
        if (this.mVideoMultiViewMap.get(streamKey) == null || this.mVideoMultiViewMap.get(streamKey).getVideoPlayerView() == null || view2 != null) {
            this.mMultiVideoScaleModeMap.put(streamKey, Integer.valueOf(scaleMode));
            this.mMultiVideoMirrorModeMap.put(streamKey, Integer.valueOf(mirrorMode));
            updatePlayMultiVideoStream(streamKey, this.mMultiStreamKeyIdMap.get(streamKey) == null ? -1 : this.mMultiStreamKeyIdMap.get(streamKey).longValue());
            ThunderLog.release(TAG, "startPlayMultiVideoStream key:%s, streamType:%d, scaleMode:%d, mirrorMode:%d, bSupportHdwDecode:%b", streamKey, Integer.valueOf(encodeType), Integer.valueOf(scaleMode), Integer.valueOf(mirrorMode), Boolean.valueOf(bSupportHdwDecode));
            return 0;
        }
        this.mVideoMultiViewMap.get(streamKey).unlink(streamKey);
        ThunderLog.release(TAG, "startPlayMultiVideoStream unlink key" + streamKey + " view " + view2);
        return 0;
    }

    private void initDefaultPlayerProxy(String streamKey, Object view2) {
        int viewId = getDefaultViewId();
        initDefaultMultiViewParam(viewId);
        ThunderPlayerMultiViewProxy defaultProxy = this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId));
        if (defaultProxy != null) {
            defaultProxy.updateMultiPlayerView(view2);
        }
        defaultProxy.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
        this.mVideoMultiViewMap.put(streamKey, defaultProxy);
        checkStartPlayDualStream(streamKey);
    }

    private void initDefaultSurfacePlayerProxy(String streamKey, Object surface) {
        if (this.mSurfacePlayerProxyMap.containsKey(surface)) {
            this.mSurfacePlayerProxyMap.get(surface).setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
            this.mVideoMultiViewMap.put(streamKey, this.mSurfacePlayerProxyMap.get(surface));
            checkStartPlayDualStream(streamKey);
            return;
        }
        int viewId = getDefaultViewId();
        initDefaultMultiViewParam(viewId);
        ThunderPlayerMultiViewProxy defaultProxy = this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId));
        if (defaultProxy != null) {
            defaultProxy.updateMultiPlayerView(surface);
        }
        defaultProxy.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
        this.mVideoMultiViewMap.put(streamKey, defaultProxy);
        checkStartPlayDualStream(streamKey);
        this.mSurfacePlayerProxyMap.put((Surface) surface, defaultProxy);
    }

    private int getDefaultViewId() {
        int viewId = -1;
        while (viewId > Integer.MIN_VALUE && this.mThunderPlayerMultiViewProxyMap.containsKey(Integer.valueOf(viewId))) {
            viewId--;
        }
        return viewId;
    }

    private VideoStreamInfo getStreamInfo(String streamKey) {
        if (this.mVideoStreamInfoMap.containsKey(streamKey)) {
            return this.mVideoStreamInfoMap.get(streamKey);
        }
        VideoStreamInfo streamInfo = new VideoStreamInfo();
        this.mVideoStreamInfoMap.put(streamKey, streamInfo);
        return streamInfo;
    }

    private int updatePlayMultiVideoStream(String streamKey, long streamId) {
        ThunderLog.release(TAG, "updatePlayVideoStream streamKey:" + streamKey + " streamId " + streamId);
        if (streamKey == null) {
            ThunderLog.error(TAG, "updatePlayMultiVideoStream, streamKey null");
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        } else if (this.mVideoMultiViewMap.get(streamKey) == null) {
            return 0;
        } else {
            ThunderLog.release(TAG, "updatePlayVideoStream, bindStreamToSeat streamKey " + streamKey + " streamId " + streamId);
            this.mVideoMultiViewMap.get(streamKey).prepareStreamSeat(streamKey, streamId);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public int startPlayVideoStreamArrive(String streamKey, long streamId) {
        ThunderLog.release(TAG, "startPlayVideoStreamArrive streamKey:" + streamKey + " streamId " + streamId);
        if (streamKey == null) {
            ThunderLog.error(TAG, "updatePlayMultiVideoStream, streamKey null");
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        if (this.mVideoMultiViewMap.get(streamKey) != null) {
            ThunderLog.release(TAG, "startPlayVideoStreamArrive, bindStreamToSeat streamKey " + streamKey + " streamId " + streamId);
            this.mVideoMultiViewMap.get(streamKey).bindStreamToSeat(streamKey, streamId, false);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public int relinkStreamId(long streamId) {
        ThunderLog.release(TAG, "relinkStreamId streamId " + streamId);
        for (Map.Entry<String, Long> next : this.mMultiStreamKeyIdMap.entrySet()) {
            if (next.getValue().compareTo(Long.valueOf(streamId)) == 0) {
                String streamKey = next.getKey();
                ThunderLog.release(TAG, "relinkStreamId found streamKey" + streamKey + " streamId: " + streamId);
                if (this.mVideoMultiViewMap.get(streamKey) == null) {
                    return 0;
                }
                ThunderLog.release(TAG, "relinkStreamId, bindStreamToSeat streamKey " + streamKey + " streamId " + streamId);
                this.mVideoMultiViewMap.get(streamKey).bindStreamToSeat(streamKey, streamId, true);
                return 0;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public int updatePlayNormalVideoStream(String streamKey, long streamId) {
        VideoStreamInfo streamInfo = getStreamInfo(streamKey);
        ThunderPlayerView view2 = streamInfo.getThunderPlayerView();
        if (view2 != null) {
            long oldStreamId = streamInfo.getStreamId();
            if (!(oldStreamId == -1 || oldStreamId == streamId || !streamInfo.isLinkedToStream())) {
                view2.unLinkFromStream(oldStreamId);
            }
            if (!streamInfo.isViewPrepared()) {
                view2.unLinkFromStream();
            }
            if (!streamInfo.isLinkedToStream()) {
                view2.linkToStream(streamId);
            }
            view2.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
            view2.setScaleMode(streamInfo.getScaleMode());
            view2.setMirrorMode(-1, streamInfo.getMirrorMode());
        } else {
            ThunderLog.warn(TAG, "updatePlayNormalVideoStream: cannot find video view for stream:%s", streamKey);
        }
        streamInfo.setStreamId(streamId);
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "updatePlayNormalVideoStream key:%s,id:%d,isPrepared:%b,isLinked:%b", streamKey, Long.valueOf(streamId), Boolean.valueOf(streamInfo.isViewPrepared()), Boolean.valueOf(streamInfo.isLinkedToStream()));
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public boolean switchDualVideoViewUI(String dstStreamKey, String srcStreamKey, int dstEncodeType) {
        String str = dstStreamKey;
        String str2 = srcStreamKey;
        long dstStreamId = -1;
        if (!this.mThunderPlayerMultiViewMode.get()) {
            VideoStreamInfo srcStreamInfo = getStreamInfo(str2);
            VideoStreamInfo dstStreamInfo = getStreamInfo(dstStreamKey);
            dstStreamInfo.setEncodeType(dstEncodeType);
            dstStreamInfo.setScaleMode(srcStreamInfo.getScaleMode());
            dstStreamInfo.setMirrorMode(srcStreamInfo.getMirrorMode());
            ThunderPlayerView srcStreamView = srcStreamInfo.getThunderPlayerView();
            if (srcStreamView != null) {
                srcStreamView.unLinkFromStream();
                dstStreamInfo.setThunderPlayerView(srcStreamView);
            }
            ThunderPlayerView dstStreamView = dstStreamInfo.getThunderPlayerView();
            if (dstStreamView != null) {
                if (!dstStreamView.isViewPrepared()) {
                    dstStreamView.unLinkFromStream();
                    if (dstStreamInfo.getStreamId() != -1) {
                        dstStreamView.linkToStream(dstStreamInfo.getStreamId());
                        dstStreamView.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
                    }
                    ThunderLog.release(TAG, "switchDualVideoViewUI dstStreamView unPrepared, dstkey:%s, streamId %d", str, Long.valueOf(dstStreamInfo.getStreamId()));
                }
                if (dstStreamInfo.isLinkedToStream()) {
                    ThunderLog.release(TAG, "switchDualVideoViewUI has linkToStream dstkey:%s, streamId %d", str, Long.valueOf(dstStreamInfo.getStreamId()));
                } else if (dstStreamInfo.getStreamId() != -1) {
                    dstStreamView.linkToStream(dstStreamInfo.getStreamId());
                    dstStreamView.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
                    ThunderLog.release(TAG, "switchDualVideoViewUI linkToStream dstkey:%s, streamId %d", str, Long.valueOf(dstStreamInfo.getStreamId()));
                }
                this.mVideoStreamInfoMap.remove(str2);
            } else {
                ThunderLog.release(TAG, "switchDualVideoViewUI normal view is null dstKey:%s, srcKey:%s", str, str2);
            }
        } else {
            int i2 = dstEncodeType;
            ThunderPlayerMultiViewProxy srcProxy = this.mVideoMultiViewMap.get(str2);
            if (this.mMultiStreamKeyIdMap.get(str) != null) {
                dstStreamId = this.mMultiStreamKeyIdMap.get(str).longValue();
            }
            if (srcProxy != null && srcProxy.switchDualVideoView(str2, str, dstStreamId) >= 0) {
                this.mVideoMultiViewMap.remove(str2);
                this.mVideoMultiViewMap.put(str, srcProxy);
            }
            for (ThunderPlayerMultiViewProxy viewProxy : this.mVideoMultiViewMap.values()) {
                viewProxy.setRemoteVideoStreamLastFrameMode(this.mLastFrameMode);
            }
            ThunderLog.release(TAG, "switchDualVideoViewUI multiView linkToStream dstkey:%s, srcKey:%s dstStreamId %d", str, str2, Long.valueOf(dstStreamId));
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkStartPlayDualStream(java.lang.String r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = r8.mStreamKeyStrUidMap
            boolean r0 = r0.containsKey(r9)
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = r8.mStreamKeyStrUidMap
            java.lang.Object r1 = r1.get(r9)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "ThunderVideoPlayEngineImp"
            if (r1 == 0) goto L_0x0087
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L_0x0087
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r3 = r8.mStreamKeyStrUidMap
            if (r3 == 0) goto L_0x0087
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0087
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r3 = r8.mStreamKeyStrUidMap
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0033:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0087
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = r1.equals(r5)
            if (r6 == 0) goto L_0x0086
            java.lang.Object r6 = r4.getKey()
            boolean r6 = r9.equals(r6)
            if (r6 != 0) goto L_0x0086
            java.lang.Object r6 = r4.getKey()
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "find dualStream duplicate streamKey:"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r7 = " cur:"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r9)
            java.lang.String r7 = " uid:"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r6 = r6.toString()
            com.thunder.livesdk.log.ThunderLog.warn(r2, r6)
        L_0x0086:
            goto L_0x0033
        L_0x0087:
            if (r0 == 0) goto L_0x011a
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x011a
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.mThunderPlayerMultiViewMode
            boolean r3 = r3.get()
            java.lang.String r4 = "remove dup streamKey:"
            if (r3 == 0) goto L_0x00c6
            java.util.HashMap<java.lang.String, com.thunder.livesdk.video.ThunderPlayerMultiViewProxy> r3 = r8.mVideoMultiViewMap
            boolean r3 = r3.containsKey(r0)
            if (r3 == 0) goto L_0x00c6
            java.util.HashMap<java.lang.String, com.thunder.livesdk.video.ThunderPlayerMultiViewProxy> r3 = r8.mVideoMultiViewMap
            java.lang.Object r3 = r3.get(r0)
            com.thunder.livesdk.video.ThunderPlayerMultiViewProxy r3 = (com.thunder.livesdk.video.ThunderPlayerMultiViewProxy) r3
            r3.unlink((java.lang.String) r0)
            java.util.HashMap<java.lang.String, com.thunder.livesdk.video.ThunderPlayerMultiViewProxy> r3 = r8.mVideoMultiViewMap
            r3.remove(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.thunder.livesdk.log.ThunderLog.warn(r2, r3)
        L_0x00c6:
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.mThunderPlayerMultiViewMode
            boolean r3 = r3.get()
            if (r3 != 0) goto L_0x011a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo> r3 = r8.mVideoStreamInfoMap
            boolean r3 = r3.containsKey(r0)
            if (r3 == 0) goto L_0x011a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo> r3 = r8.mVideoStreamInfoMap
            java.lang.Object r3 = r3.get(r0)
            com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo r3 = (com.thunder.livesdk.video.ThunderVideoPlayEngineImp.VideoStreamInfo) r3
            com.thunder.livesdk.video.ThunderPlayerView r3 = r3.getThunderPlayerView()
            if (r3 == 0) goto L_0x0101
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo> r3 = r8.mVideoStreamInfoMap
            java.lang.Object r3 = r3.get(r0)
            com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo r3 = (com.thunder.livesdk.video.ThunderVideoPlayEngineImp.VideoStreamInfo) r3
            boolean r3 = r3.isLinkedToStream()
            if (r3 == 0) goto L_0x0101
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo> r3 = r8.mVideoStreamInfoMap
            java.lang.Object r3 = r3.get(r0)
            com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo r3 = (com.thunder.livesdk.video.ThunderVideoPlayEngineImp.VideoStreamInfo) r3
            com.thunder.livesdk.video.ThunderPlayerView r3 = r3.getThunderPlayerView()
            r3.unLinkFromStream()
        L_0x0101:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.thunder.livesdk.video.ThunderVideoPlayEngineImp$VideoStreamInfo> r3 = r8.mVideoStreamInfoMap
            r3.remove(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.thunder.livesdk.log.ThunderLog.warn(r2, r3)
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thunder.livesdk.video.ThunderVideoPlayEngineImp.checkStartPlayDualStream(java.lang.String):void");
    }

    public int setRemoteExternalSurfaceChanged(Object _externalSurface) {
        if (_externalSurface != null) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "setRemoteExternalSurfaceChanged");
            }
            ThunderExternalSurface externalSurface = (ThunderExternalSurface) _externalSurface;
            if (this.mThunderVideoHandler == null || _externalSurface == null) {
                return 0;
            }
            final ThunderExternalSurface f_externalSurface = externalSurface;
            final CountDownLatch barrier = new CountDownLatch(1);
            this.mThunderVideoHandler.post(new Runnable() {
                public void run() {
                    ThunderVideoPlayEngineImp.this.setExternalSurface(f_externalSurface);
                    barrier.countDown();
                }
            });
            try {
                barrier.await(500, TimeUnit.MILLISECONDS);
                return 0;
            } catch (InterruptedException e2) {
                ThunderLog.error(TAG, "setExternalSurface exception:" + e2.toString());
                return 0;
            }
        } else if (!ThunderLog.isInfoValid()) {
            return -1;
        } else {
            ThunderLog.info(TAG, "setRemoteExternalSurfaceChanged _externalSurface null");
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public void setExternalSurface(ThunderExternalSurface externalSurface) {
        if (externalSurface == null) {
            return;
        }
        if (!this.mSurfacePlayerProxyMap.containsKey(externalSurface.mSurface)) {
            int viewId = getDefaultViewId();
            initDefaultMultiViewParam(viewId);
            ThunderPlayerMultiViewProxy defaultProxy = this.mThunderPlayerMultiViewProxyMap.get(Integer.valueOf(viewId));
            if (defaultProxy != null) {
                defaultProxy.setExternalSurfaceChanged(externalSurface);
                defaultProxy.initDefaultLayout();
            }
            this.mSurfacePlayerProxyMap.put(externalSurface.mSurface, defaultProxy);
            ThunderLog.release(TAG, "setRemoteExternalSurfaceChanged map event:" + externalSurface.event + " surface:" + externalSurface.mSurface + " to " + defaultProxy);
            return;
        }
        this.mSurfacePlayerProxyMap.get(externalSurface.mSurface).setExternalSurfaceChanged(externalSurface);
        ThunderLog.release(TAG, "setRemoteExternalSurfaceChanged event:" + externalSurface.event + " surface:" + externalSurface.mSurface + " to " + this.mSurfacePlayerProxyMap.get(externalSurface.mSurface));
    }

    public void onBehaviorEvent(YMFBehaviorEvent behaviorEvent) {
        ThunderNative.makeBehaviorEvent(behaviorEvent.mEventId, behaviorEvent.mOval);
    }

    public class StrUidVideoDecodeObserver {
        private boolean bObserverEnable = false;
        private IVideoDecodeObserver observer;
        private String strUid;

        public StrUidVideoDecodeObserver() {
        }

        public void setStrUid(String strUid2) {
            this.strUid = strUid2;
        }

        public String getStrUid() {
            return this.strUid;
        }

        public void setObserver(IVideoDecodeObserver observer2) {
            this.observer = observer2;
        }

        public IVideoDecodeObserver getObserver() {
            return this.observer;
        }

        public void removeObserver() {
            this.observer = null;
        }

        public void setbObserverEnable(boolean bObserverEnable2) {
            this.bObserverEnable = bObserverEnable2;
        }

        public boolean isbObserverEnable() {
            return this.bObserverEnable;
        }
    }

    private class VideoStreamInfo {
        private int mEncodeType = 1;
        private int mIsSoftDecodeFlag = -1;
        private int mMirrorMode;
        private int mScaleMode = -1;
        private long mStreamId = -1;
        private ThunderPlayerView mThunderPlayerView = null;

        public VideoStreamInfo() {
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo: " + this + " construct streamId:%d", Long.valueOf(this.mStreamId));
        }

        public long getStreamId() {
            return this.mStreamId;
        }

        public void setStreamId(long streamId) {
            this.mStreamId = streamId;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo setStreamId " + streamId);
        }

        public ThunderPlayerView getThunderPlayerView() {
            return this.mThunderPlayerView;
        }

        public void setThunderPlayerView(ThunderPlayerView thunderPlayerView) {
            this.mThunderPlayerView = thunderPlayerView;
            if (thunderPlayerView != null) {
                ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo setThunderPlayerView streamId:" + this.mStreamId + " view:" + thunderPlayerView);
            } else {
                ThunderLog.error(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo setThunderPlayerView null");
            }
        }

        public int getIsSoftDecodeFlag() {
            return this.mIsSoftDecodeFlag;
        }

        public void setIsSoftDecodeFlag(int isSoftDecodeFlag) {
            this.mIsSoftDecodeFlag = isSoftDecodeFlag;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setIsSoftDecodeFlag " + isSoftDecodeFlag);
        }

        public int getEncodeType() {
            return this.mEncodeType;
        }

        public void setEncodeType(int encodeType) {
            this.mEncodeType = encodeType;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setEncodeType " + this.mEncodeType);
        }

        public int getScaleMode() {
            return this.mScaleMode;
        }

        public void setScaleMode(int scaleMode) {
            this.mScaleMode = scaleMode;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setScaleMode " + scaleMode);
        }

        public void setMirrorMode(int mirrorMode) {
            this.mMirrorMode = mirrorMode;
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " setMirrorMode " + mirrorMode);
        }

        public int getMirrorMode() {
            return this.mMirrorMode;
        }

        public boolean isLinkedToStream() {
            boolean result = false;
            ThunderPlayerView thunderPlayerView = this.mThunderPlayerView;
            if (thunderPlayerView != null) {
                result = thunderPlayerView.isViewLinkedToStream();
            }
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo streamId:" + this.mStreamId + " isLinkedToStream " + result);
            return result;
        }

        public boolean isViewPrepared() {
            boolean result = false;
            ThunderPlayerView thunderPlayerView = this.mThunderPlayerView;
            if (thunderPlayerView != null) {
                result = thunderPlayerView.isViewPrepared();
            }
            ThunderLog.release(ThunderVideoPlayEngineImp.TAG, "VideoStreamInfo: " + this + "  streamId:" + this.mStreamId + " isViewPrepared " + result);
            return result;
        }
    }

    public String getVideoDecodeBaseStatics(int sendSeq) {
        return YMFPlayerStatisticManager.getInstance().getVideoDecodeBaseStatistics(sendSeq);
    }

    public String getVideoDecodeStatics(boolean bKeyStat, long streamId) {
        String audienceStat = "";
        if (this.mVideoPlayHiidoUtil != null) {
            audienceStat = ThunderVideoHiidoUtil.getAudienceStatInfo();
        }
        return YMFPlayerStatisticManager.getInstance().getVideoDecodeStatistics(bKeyStat, streamId) + audienceStat;
    }
}
