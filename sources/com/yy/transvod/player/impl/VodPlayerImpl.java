package com.yy.transvod.player.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.yy.transvod.common.LibraryLoad;
import com.yy.transvod.player.DataSource;
import com.yy.transvod.player.OnAudioFocusListener;
import com.yy.transvod.player.OnPlayerAVExtraInfoListener;
import com.yy.transvod.player.OnPlayerCachePositionUpdateListener;
import com.yy.transvod.player.OnPlayerCrashListener;
import com.yy.transvod.player.OnPlayerErrorListener;
import com.yy.transvod.player.OnPlayerExtraInfoListener;
import com.yy.transvod.player.OnPlayerFirstVideoFrameShowListener;
import com.yy.transvod.player.OnPlayerInfoListener;
import com.yy.transvod.player.OnPlayerLoadingUpdateListener;
import com.yy.transvod.player.OnPlayerNetRequestStatusListener;
import com.yy.transvod.player.OnPlayerPlayCompletionListener;
import com.yy.transvod.player.OnPlayerPlayPositionUpdateListener;
import com.yy.transvod.player.OnPlayerQualityMonitorListener;
import com.yy.transvod.player.OnPlayerStateUpdateListener;
import com.yy.transvod.player.OnPlayerStatisticsListener;
import com.yy.transvod.player.OnPlayerSwitchUrlResultListener;
import com.yy.transvod.player.OnPlayerTextureListener;
import com.yy.transvod.player.OnPlayerUpdatePcdnUrlResultListener;
import com.yy.transvod.player.OnPlayerUpdateRtsTokenStatusListener;
import com.yy.transvod.player.OnPlayerVideoPlayStatChangedListener;
import com.yy.transvod.player.PlayerOptions;
import com.yy.transvod.player.UserProfile;
import com.yy.transvod.player.VodPlayer;
import com.yy.transvod.player.common.JoyPkPipParameter;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.NetRequestStatusInfo;
import com.yy.transvod.player.common.VodConst;
import com.yy.transvod.player.common.effectmp4.EffectResources;
import com.yy.transvod.player.core.AudioFocusListener;
import com.yy.transvod.player.core.MediaPlaySession;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class VodPlayerImpl extends VodPlayerBase {
    private static final int MSG_CALLBACK_MAIN_LOOPER = 1;
    private static final String TAG = "impl";
    private static long durationCount = 0;
    /* access modifiers changed from: private */
    public AtomicInteger mCacheTime = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public String mCurUrl = null;
    /* access modifiers changed from: private */
    public AtomicInteger mCurrentPosition = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public AtomicInteger mDuration = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public Handler mHandler = null;
    /* access modifiers changed from: private */
    public Object mLock = new Object();
    /* access modifiers changed from: private */
    public MediaPlaySession mMediaPlaySession = null;
    private MediaPlaySession.OnMediaSessionMessageListener mOnMediaSessionMessageListener = new MediaPlaySession.OnMediaSessionMessageListener() {
        public void onMediaSessionMessage(final Message msg) {
            MsgParamsEventArgs params = new MsgParamsEventArgs();
            boolean needNotify = true;
            boolean bFrontQueue = false;
            if (msg.obj instanceof String) {
                params.param3 = (String) msg.obj;
            }
            params.type = msg.what;
            switch (msg.what) {
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                    VodPlayer.OnPlayerAudioExtraInfoListener cb = (VodPlayer.OnPlayerAudioExtraInfoListener) VodPlayerImpl.this.mOnPlayerAudioExtraInfoListener.get();
                    if (cb != null) {
                        if (msg.what == 67) {
                            ArrayList<Long> uids = (ArrayList) msg.obj;
                            ArrayList<MixAudioExtraInfo> extraInfos = new ArrayList<>();
                            for (int i2 = 0; i2 < uids.size(); i2++) {
                                extraInfos.add(new MixAudioExtraInfo(uids.get(i2).toString(), -1));
                            }
                            cb.onDSEMixAudioExtraInfo(VodPlayerImpl.this.mVodPlayer, extraInfos);
                        }
                        if (msg.what == 65) {
                            cb.onDSEMixAudioExtraInfo(VodPlayerImpl.this.mVodPlayer, (ArrayList) msg.obj);
                        }
                    }
                    if (VodPlayerImpl.this.mSeiExecutor != null) {
                        try {
                            VodPlayerImpl.this.mSeiExecutor.execute(new Runnable() {
                                public void run() {
                                    OnPlayerAVExtraInfoListener listener = (OnPlayerAVExtraInfoListener) VodPlayerImpl.this.mOnPlayerAVExtraInfoListener.get();
                                    if (listener != null) {
                                        if (msg.what == 69) {
                                            listener.onSEIAudioOriginalData(VodPlayerImpl.this.mVodPlayer, (byte[]) msg.obj, msg.arg1);
                                        }
                                        if (msg.what == 68) {
                                            listener.onSEIVideoOriginalData(VodPlayerImpl.this.mVodPlayer, (byte[]) msg.obj, msg.arg1);
                                        }
                                        if (msg.what == 67) {
                                            listener.onSEIAudioExtraInfoV0(VodPlayerImpl.this.mVodPlayer, (ArrayList) msg.obj);
                                        }
                                        if (msg.what == 63) {
                                            listener.onSEIVideoExtraInfo(VodPlayerImpl.this.mVodPlayer, msg.arg1, (ArrayList) msg.obj);
                                        }
                                        if (msg.what == 64) {
                                            try {
                                                listener.onSEIMixVideoExtraInfo(VodPlayerImpl.this.mVodPlayer, msg.arg1, (ArrayList) msg.obj);
                                            } catch (RuntimeException e2) {
                                                TLog.error(VodPlayerImpl.TAG, this, "sei mix error: " + e2.getMessage());
                                            }
                                        }
                                        if (msg.what == 66) {
                                            listener.onSEIAlphaChannelInfo(VodPlayerImpl.this.mVodPlayer, msg.arg1, (ArrayList) msg.obj);
                                        }
                                        if (msg.what == 65) {
                                            listener.onDSEMixAudioExtraInfoV1(VodPlayerImpl.this.mVodPlayer, (ArrayList) msg.obj);
                                        }
                                    }
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 5000:
                    params.param2 = (long) msg.arg2;
                    VodPlayerImpl.this.innerPlayerStateChange(msg.arg1, params);
                    break;
                case 5001:
                    params.param1 = (long) msg.arg1;
                    break;
                case 5002:
                    params.param1 = (long) msg.arg1;
                    VodPlayerImpl.this.mDuration.set(msg.arg1);
                    break;
                case 5003:
                    if (VodPlayerImpl.this.mDuration.get() > 0) {
                        VodPlayerImpl.this.mCurrentPosition.set(msg.arg1);
                        params.param1 = (long) msg.arg1;
                        break;
                    }
                    break;
                case 5004:
                    if (VodPlayerImpl.this.mDuration.get() > 0) {
                        VodPlayerImpl.this.mCacheTime.set(msg.arg1);
                        params.param1 = (long) msg.arg1;
                        break;
                    }
                    break;
                case 5005:
                    params.param1 = (long) msg.arg1;
                    VodPlayerImpl.this.mTotalSize.set(msg.arg1);
                    break;
                case 5009:
                    if (msg.obj instanceof String) {
                        params.param1 = (long) msg.arg1;
                        params.param3 = (String) msg.obj;
                        break;
                    }
                    break;
                case 5010:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    params.paramObj = msg.obj;
                    break;
                case 5013:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    params.paramObj = msg.obj;
                    break;
                case 5014:
                    params.paramObj = msg.obj;
                    break;
                case 5015:
                    if (VodPlayerImpl.this.mVideoWidth.get() != msg.arg1 || VodPlayerImpl.this.mVideoHeight.get() != msg.arg2) {
                        params.param1 = (long) msg.arg1;
                        params.param2 = (long) msg.arg2;
                        VodPlayerImpl.this.mVideoWidth.set(msg.arg1);
                        VodPlayerImpl.this.mVideoHeight.set(msg.arg2);
                        break;
                    } else {
                        needNotify = false;
                        break;
                    }
                    break;
                case 5017:
                    synchronized (VodPlayerImpl.this.mLock) {
                        if (VodPlayerImpl.this.mMediaPlaySession != null) {
                            VodPlayerImpl.this.mMediaPlaySession.resetSeekTime();
                        }
                    }
                    params.param1 = (long) VodPlayerImpl.this.mCurrentPosition.get();
                    params.param2 = (long) VodPlayerImpl.this.mDuration.get();
                    VodPlayerImpl.this.mCurrentPosition.set(0);
                    VodPlayerImpl.this.mCacheTime.set(0);
                    break;
                case 5019:
                    params.param1 = (long) msg.arg1;
                    params.paramObj = msg.obj;
                    break;
                case VodConst.MET_CALLBACK_PLAYER_UPDATE_PCDN_URL_RES:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    params.param3 = (String) msg.obj;
                    break;
                case VodConst.MET_CALLBACK_PLAYER_SWITCH_LEVEL_RES:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    params.paramObj = msg.obj;
                    break;
                case VodConst.MET_CALLBACK_PLAYER_PLAY_DURATION:
                    params.param1 = (long) msg.arg1;
                    break;
                case VodConst.MET_CALLBACK_PLAYER_RTS_TOKEN_STATUS:
                    params.param1 = (long) msg.arg1;
                    break;
                case VodConst.MET_CALLBACK_PLAYER_RTS_DEBUG_INFO:
                    params.param1 = (long) msg.arg1;
                    break;
                case 5102:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    params.paramObj = msg.obj;
                    params.param4 = System.currentTimeMillis();
                    bFrontQueue = true;
                    TLog.warn(VodPlayerImpl.TAG, this, "first frame show, going to transmit to mainloop");
                    OnPlayerFirstVideoFrameShowListener listener = (OnPlayerFirstVideoFrameShowListener) VodPlayerImpl.this.mOnPlayerFirstVideoFrameShowByPlayerThreadListener.get();
                    if (listener == null) {
                        TLog.info(VodPlayerImpl.TAG, (Object) this, "player thread first frame show : listener is null");
                        break;
                    } else {
                        TLog.info(VodPlayerImpl.TAG, (Object) this, "player thread first frame show");
                        listener.onPlayerFirstVideoFrameShow(VodPlayerImpl.this.mVodPlayer, (int) params.param1, (int) params.param2, ((Long) params.paramObj).intValue());
                        break;
                    }
                case VodConst.MET_CALLBACK_PLAYER_SURFACE_CREATED:
                case 7000:
                    params.param1 = System.currentTimeMillis();
                    break;
                case VodConst.MET_CALLBACK_PLAYER_SURFACE_CHANGED:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    params.param4 = System.currentTimeMillis();
                    break;
                case VodConst.MET_CALLBACK_PLAYER_AGAIN_RENDERING_FIRST_VIDEO_FRAME:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    params.paramObj = msg.obj;
                    params.param4 = System.currentTimeMillis();
                    bFrontQueue = true;
                    TLog.warn(VodPlayerImpl.TAG, this, "first frame again show, going to transmit to mainloop");
                    break;
                case 6000:
                case 6001:
                case 6002:
                case 6004:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    break;
                case 6003:
                    params.param1 = (long) msg.arg1;
                    params.param2 = (long) msg.arg2;
                    bFrontQueue = true;
                    break;
            }
            if (VodPlayerImpl.this.mHandler != null && needNotify) {
                synchronized (VodPlayerImpl.this.mLock) {
                    if (VodPlayerImpl.this.mHandler != null) {
                        if (bFrontQueue) {
                            VodPlayerImpl.this.mHandler.sendMessageAtFrontOfQueue(Message.obtain(VodPlayerImpl.this.mHandler, 1, params));
                        } else {
                            VodPlayerImpl.this.mHandler.sendMessage(Message.obtain(VodPlayerImpl.this.mHandler, 1, params));
                        }
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerAVExtraInfoListener> mOnPlayerAVExtraInfoListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<VodPlayer.OnPlayerAudioExtraInfoListener> mOnPlayerAudioExtraInfoListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerCachePositionUpdateListener> mOnPlayerCachePositionUpdateListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerErrorListener> mOnPlayerErrorListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerExtraInfoListener> mOnPlayerExtraInfoListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerFirstVideoFrameShowListener> mOnPlayerFirstVideoFrameShowByPlayerThreadListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerFirstVideoFrameShowListener> mOnPlayerFirstVideoFrameShowListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerInfoListener> mOnPlayerInfoListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerLoadingUpdateListener> mOnPlayerLoadingUpdateListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerNetRequestStatusListener> mOnPlayerNetRequestStatusListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerPlayCompletionListener> mOnPlayerPlayCompletionListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerPlayPositionUpdateListener> mOnPlayerPlayPositionUpdateListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerQualityMonitorListener> mOnPlayerQualityMonitorListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerStateUpdateListener> mOnPlayerStateUpdateListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerStatisticsListener> mOnPlayerStatisListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerSwitchUrlResultListener> mOnPlayerSwitchLevelResultListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerUpdatePcdnUrlResultListener> mOnPlayerUpdatePcdnUrlResultListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerUpdateRtsTokenStatusListener> mOnPlayerUpdateRtsTokenStatusListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<OnPlayerVideoPlayStatChangedListener> mOnPlayerVideoPlayStatChangedListener = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public AtomicInteger mPlayerEngineState = new AtomicInteger(0);
    private PlayerOptions mPlayerOptions = null;
    /* access modifiers changed from: private */
    public int mPlayerUID = 0;
    private Object mPlayerView = null;
    /* access modifiers changed from: private */
    public Executor mSeiExecutor = null;
    /* access modifiers changed from: private */
    public AtomicInteger mTotalSize = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public AtomicInteger mVideoHeight = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public AtomicInteger mVideoWidth = new AtomicInteger(0);
    private boolean mbLiveMode = false;

    static /* synthetic */ long access$508() {
        long j2 = durationCount;
        durationCount = 1 + j2;
        return j2;
    }

    private VodPlayerImpl() {
    }

    public VodPlayerImpl(Context context, PlayerOptions options, UserProfile profile, VodPlayer vodplayer) {
        long start = System.currentTimeMillis();
        this.mVodPlayer = vodplayer;
        this.mPlayerOptions = options;
        doInit(context.getApplicationContext(), options, profile);
        TLog.warn(TAG, this, "create VodPlayer cost: " + (System.currentTimeMillis() - start) + " sdkversion: " + getVersion() + " isSubProcess:" + options.isSubProcess);
    }

    private void doInit(Context context, PlayerOptions options, UserProfile profile) {
        TLog.setLevel(Preference.getLogLevel());
        LibraryLoad.loadAllLibrary(context, true);
        if (options.externalTexture != null) {
            this.mPlayerView = options.externalTexture;
        } else if (options.externalSurface != null) {
            this.mPlayerView = options.externalSurface;
        } else if (options.usingSurfaceView) {
            this.mPlayerView = new SurfaceView(context);
        } else {
            this.mPlayerView = new TextureView(context);
        }
        MediaPlaySession mediaPlaySession = new MediaPlaySession(options, profile);
        this.mMediaPlaySession = mediaPlaySession;
        mediaPlaySession.setOnMediaSessionMessageListener(this.mOnMediaSessionMessageListener);
        this.mMediaPlaySession.setup(context, this.mPlayerView);
        this.mPlayerUID = this.mMediaPlaySession.getUid();
        TLog.warn(TAG, this, " player " + this.mPlayerUID + " doInit " + options.toString());
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                String debugInfo;
                Message message = msg;
                boolean z = true;
                if (message.what == 1) {
                    MsgParamsEventArgs params = (MsgParamsEventArgs) message.obj;
                    switch (params.type) {
                        case 1:
                            TLog.warn(VodPlayerImpl.TAG, this, "player state stopped " + VodPlayerImpl.this.mPlayerUID);
                            VodPlayerImpl.this.mPlayerEngineState.set(1);
                            OnPlayerStateUpdateListener listener = (OnPlayerStateUpdateListener) VodPlayerImpl.this.mOnPlayerStateUpdateListener.get();
                            if (listener != null) {
                                listener.onPlayerStateUpdate(VodPlayerImpl.this.mVodPlayer, 1, 0);
                                return;
                            }
                            return;
                        case 4:
                            TLog.warn(VodPlayerImpl.TAG, this, "player state ready " + VodPlayerImpl.this.mPlayerUID);
                            VodPlayerImpl.this.mPlayerEngineState.set(4);
                            OnPlayerStateUpdateListener listener2 = (OnPlayerStateUpdateListener) VodPlayerImpl.this.mOnPlayerStateUpdateListener.get();
                            if (listener2 != null) {
                                listener2.onPlayerStateUpdate(VodPlayerImpl.this.mVodPlayer, 4, 0);
                                return;
                            }
                            return;
                        case 5:
                            TLog.warn(VodPlayerImpl.TAG, this, "player state loading " + VodPlayerImpl.this.mPlayerUID);
                            VodPlayerImpl.this.mPlayerEngineState.set(5);
                            OnPlayerStateUpdateListener listener3 = (OnPlayerStateUpdateListener) VodPlayerImpl.this.mOnPlayerStateUpdateListener.get();
                            if (listener3 != null) {
                                listener3.onPlayerStateUpdate(VodPlayerImpl.this.mVodPlayer, 5, (int) params.param2);
                                return;
                            }
                            return;
                        case 6:
                            TLog.warn(VodPlayerImpl.TAG, this, "player state playing " + VodPlayerImpl.this.mPlayerUID);
                            VodPlayerImpl.this.mPlayerEngineState.set(6);
                            OnPlayerStateUpdateListener listener4 = (OnPlayerStateUpdateListener) VodPlayerImpl.this.mOnPlayerStateUpdateListener.get();
                            if (listener4 != null) {
                                listener4.onPlayerStateUpdate(VodPlayerImpl.this.mVodPlayer, 6, 0);
                                return;
                            }
                            return;
                        case 7:
                            TLog.warn(VodPlayerImpl.TAG, this, "player state paused " + VodPlayerImpl.this.mPlayerUID);
                            VodPlayerImpl.this.mPlayerEngineState.set(7);
                            OnPlayerStateUpdateListener listener5 = (OnPlayerStateUpdateListener) VodPlayerImpl.this.mOnPlayerStateUpdateListener.get();
                            if (listener5 != null) {
                                listener5.onPlayerStateUpdate(VodPlayerImpl.this.mVodPlayer, 7, 0);
                                return;
                            }
                            return;
                        case 8:
                            TLog.warn(VodPlayerImpl.TAG, this, "player play end" + VodPlayerImpl.this.mPlayerUID);
                            OnPlayerPlayCompletionListener listener6 = (OnPlayerPlayCompletionListener) VodPlayerImpl.this.mOnPlayerPlayCompletionListener.get();
                            if (listener6 != null) {
                                listener6.onPlayerPlayCompletion(VodPlayerImpl.this.mVodPlayer);
                            }
                            VodPlayerImpl.this.mPlayerEngineState.set(8);
                            OnPlayerStateUpdateListener stateListener = (OnPlayerStateUpdateListener) VodPlayerImpl.this.mOnPlayerStateUpdateListener.get();
                            if (stateListener != null) {
                                stateListener.onPlayerStateUpdate(VodPlayerImpl.this.mVodPlayer, 8, 0);
                                return;
                            }
                            return;
                        case 9:
                            TLog.warn(VodPlayerImpl.TAG, this, "player state invalid " + VodPlayerImpl.this.mPlayerUID);
                            OnPlayerStateUpdateListener listener7 = (OnPlayerStateUpdateListener) VodPlayerImpl.this.mOnPlayerStateUpdateListener.get();
                            if (listener7 != null) {
                                listener7.onPlayerStateUpdate(VodPlayerImpl.this.mVodPlayer, 9, 0);
                                return;
                            }
                            return;
                        case 5001:
                            TLog.debug("callback", this, String.format(Locale.getDefault(), "player loading (%d)", new Object[]{Long.valueOf(params.param1)}));
                            OnPlayerLoadingUpdateListener listener8 = (OnPlayerLoadingUpdateListener) VodPlayerImpl.this.mOnPlayerLoadingUpdateListener.get();
                            if (listener8 != null) {
                                listener8.onLoadingUpdate(VodPlayerImpl.this.mVodPlayer, (int) params.param1);
                                return;
                            }
                            return;
                        case 5002:
                            TLog.warn(VodPlayerImpl.TAG, this, VodPlayerImpl.this.mPlayerUID + " player resource duration:" + params.param1);
                            OnPlayerInfoListener listener9 = (OnPlayerInfoListener) VodPlayerImpl.this.mOnPlayerInfoListener.get();
                            if (listener9 != null) {
                                listener9.onPlayerInfo(VodPlayerImpl.this.mVodPlayer, 3, params.param1);
                                return;
                            }
                            return;
                        case 5003:
                            OnPlayerPlayPositionUpdateListener listener10 = (OnPlayerPlayPositionUpdateListener) VodPlayerImpl.this.mOnPlayerPlayPositionUpdateListener.get();
                            if (listener10 != null) {
                                listener10.onPlayerPlayPositionUpdate(VodPlayerImpl.this.mVodPlayer, params.param1);
                                return;
                            }
                            return;
                        case 5004:
                            TLog.warn(VodPlayerImpl.TAG, this, "player cache " + params.param1);
                            OnPlayerCachePositionUpdateListener listener11 = (OnPlayerCachePositionUpdateListener) VodPlayerImpl.this.mOnPlayerCachePositionUpdateListener.get();
                            if (listener11 != null) {
                                listener11.onPlayerCachePositionUpdate(VodPlayerImpl.this.mVodPlayer, params.param1);
                                return;
                            }
                            return;
                        case 5005:
                            TLog.warn(VodPlayerImpl.TAG, this, VodPlayerImpl.this.mPlayerUID + " player resource total size: " + params.param1);
                            OnPlayerInfoListener listener12 = (OnPlayerInfoListener) VodPlayerImpl.this.mOnPlayerInfoListener.get();
                            if (listener12 != null) {
                                listener12.onPlayerInfo(VodPlayerImpl.this.mVodPlayer, 2, params.param1);
                                return;
                            }
                            return;
                        case 5009:
                            OnPlayerStatisticsListener listener13 = (OnPlayerStatisticsListener) VodPlayerImpl.this.mOnPlayerStatisListener.get();
                            if (listener13 != null) {
                                listener13.onPlayerStatistics(VodPlayerImpl.this.mVodPlayer, (int) params.param1, params.param3);
                                return;
                            }
                            return;
                        case 5010:
                            VodPlayerImpl.this.mPlaying = false;
                            TLog.error(VodPlayerImpl.TAG, this, String.format(Locale.getDefault(), "player error code : %d", new Object[]{Long.valueOf(params.param1)}));
                            OnPlayerErrorListener listener14 = (OnPlayerErrorListener) VodPlayerImpl.this.mOnPlayerErrorListener.get();
                            if (listener14 != null) {
                                listener14.onPlayerError(VodPlayerImpl.this.mVodPlayer, (String) params.paramObj, (int) params.param1, (int) params.param2);
                                return;
                            }
                            return;
                        case 5013:
                            OnPlayerInfoListener listener15 = (OnPlayerInfoListener) VodPlayerImpl.this.mOnPlayerInfoListener.get();
                            if (listener15 != null) {
                                listener15.onPlayerInfo(VodPlayerImpl.this.mVodPlayer, 0, params.param1);
                                return;
                            }
                            return;
                        case 5014:
                            int[] times = (int[]) params.paramObj;
                            OnPlayerInfoListener listener16 = (OnPlayerInfoListener) VodPlayerImpl.this.mOnPlayerInfoListener.get();
                            if (listener16 != null) {
                                listener16.onPlayerInfo(VodPlayerImpl.this.mVodPlayer, 1, (long) times.length);
                                return;
                            }
                            return;
                        case 5015:
                            TLog.warn(VodPlayerImpl.TAG, this, "player resolution  w:" + params.param1 + " h:" + params.param2 + " " + VodPlayerImpl.this.mPlayerUID);
                            OnPlayerInfoListener listener17 = (OnPlayerInfoListener) VodPlayerImpl.this.mOnPlayerInfoListener.get();
                            if (listener17 != null) {
                                listener17.onPlayerVideoSizeUpdate(VodPlayerImpl.this.mVodPlayer, (int) params.param1, (int) params.param2);
                                return;
                            }
                            return;
                        case 5017:
                            TLog.warn(VodPlayerImpl.TAG, this, "player one loop end " + VodPlayerImpl.this.mPlayerUID);
                            OnPlayerPlayCompletionListener listener18 = (OnPlayerPlayCompletionListener) VodPlayerImpl.this.mOnPlayerPlayCompletionListener.get();
                            if (listener18 != null) {
                                listener18.onPlayerPlayCompletionOneLoop(VodPlayerImpl.this.mVodPlayer);
                                return;
                            }
                            return;
                        case 5018:
                            OnPlayerCachePositionUpdateListener listener19 = (OnPlayerCachePositionUpdateListener) VodPlayerImpl.this.mOnPlayerCachePositionUpdateListener.get();
                            if (listener19 != null) {
                                listener19.onPlayerCacheWriteToDiskCompleted(VodPlayerImpl.this.mVodPlayer, params.param3);
                                return;
                            }
                            return;
                        case 5019:
                            OnPlayerNetRequestStatusListener listener20 = (OnPlayerNetRequestStatusListener) VodPlayerImpl.this.mOnPlayerNetRequestStatusListener.get();
                            if (listener20 != null) {
                                listener20.onPlayerNetRequestStatus(VodPlayerImpl.this.mVodPlayer, (int) params.param1, (NetRequestStatusInfo) params.paramObj);
                                return;
                            }
                            TLog.error(VodPlayerImpl.TAG, this, "OnPlayerNetRequestStatusListener is null");
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_UPDATE_PCDN_URL_RES:
                            OnPlayerUpdatePcdnUrlResultListener listener21 = (OnPlayerUpdatePcdnUrlResultListener) VodPlayerImpl.this.mOnPlayerUpdatePcdnUrlResultListener.get();
                            if (listener21 != null) {
                                listener21.onUpdatePcdnUrlResult(VodPlayerImpl.this.mVodPlayer, (int) params.param1, params.param3, (int) params.param2);
                                return;
                            }
                            TLog.error(VodPlayerImpl.TAG, this, "OnPlayerUpdatePcdnUrlResultListener is null");
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_SWITCH_LEVEL_RES:
                            OnPlayerSwitchUrlResultListener listener22 = (OnPlayerSwitchUrlResultListener) VodPlayerImpl.this.mOnPlayerSwitchLevelResultListener.get();
                            if (listener22 != null) {
                                listener22.onSwitchUrlResult(VodPlayerImpl.this.mVodPlayer, (String) params.paramObj, (int) params.param1, (int) params.param2);
                                return;
                            }
                            TLog.error(VodPlayerImpl.TAG, this, "OnPlayerSwitchLevelResultListener is null");
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_PLAY_DURATION:
                            if (VodPlayerImpl.access$508() % 10 == 0) {
                                TLog.info(VodPlayerImpl.TAG, (Object) this, VodPlayerImpl.this.mPlayerUID + " player play duration:" + params.param1);
                            }
                            OnPlayerInfoListener listener23 = (OnPlayerInfoListener) VodPlayerImpl.this.mOnPlayerInfoListener.get();
                            if (listener23 != null) {
                                listener23.onPlayerInfo(VodPlayerImpl.this.mVodPlayer, 4, params.param1);
                                return;
                            }
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_RTS_TOKEN_STATUS:
                            OnPlayerUpdateRtsTokenStatusListener listener24 = (OnPlayerUpdateRtsTokenStatusListener) VodPlayerImpl.this.mOnPlayerUpdateRtsTokenStatusListener.get();
                            if (listener24 != null) {
                                listener24.onUpdateRtsTokenStatus(VodPlayerImpl.this.mVodPlayer, (int) params.param1);
                                return;
                            }
                            TLog.error(VodPlayerImpl.TAG, this, "OnPlayerUpdateRtsTokenStatusListener is null");
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_RTS_DEBUG_INFO:
                            OnPlayerExtraInfoListener listener25 = (OnPlayerExtraInfoListener) VodPlayerImpl.this.mOnPlayerExtraInfoListener.get();
                            if (listener25 != null && (debugInfo = params.param3) != null) {
                                listener25.onPlayerExtraInfo(105, 0, 0, 0, debugInfo, (Object) null);
                                return;
                            }
                            return;
                        case 5102:
                            VodPlayerImpl.this.mPlaying = true;
                            TLog.warn(VodPlayerImpl.TAG, this, String.format(Locale.getDefault(), "player first frame show(%d)", new Object[]{Integer.valueOf(((Long) params.paramObj).intValue())}));
                            OnPlayerFirstVideoFrameShowListener listener26 = (OnPlayerFirstVideoFrameShowListener) VodPlayerImpl.this.mOnPlayerFirstVideoFrameShowListener.get();
                            if (listener26 != null) {
                                listener26.onPlayerFirstVideoFrameShow(VodPlayerImpl.this.mVodPlayer, (int) params.param1, (int) params.param2, ((Long) params.paramObj).intValue());
                                TLog.warn(VodPlayerImpl.TAG, this, "player first frame show end");
                            } else {
                                TLog.error(VodPlayerImpl.TAG, this, "player first frame show : listener is null");
                            }
                            OnPlayerExtraInfoListener extraInfoListener = (OnPlayerExtraInfoListener) VodPlayerImpl.this.mOnPlayerExtraInfoListener.get();
                            if (extraInfoListener != null) {
                                extraInfoListener.onPlayerExtraInfo(103, params.param4, 0, 0, (String) null, (Object) null);
                                return;
                            }
                            return;
                        case 5200:
                            TLog.error(VodPlayerImpl.TAG, this, "egl setup failed");
                            OnPlayerErrorListener listener27 = (OnPlayerErrorListener) VodPlayerImpl.this.mOnPlayerErrorListener.get();
                            VodPlayerImpl.this.mPlaying = false;
                            if (listener27 != null) {
                                listener27.onPlayerError(VodPlayerImpl.this.mVodPlayer, VodPlayerImpl.this.mCurUrl, 5200, 0);
                                return;
                            }
                            return;
                        case 5201:
                            OnPlayerVideoPlayStatChangedListener listener28 = (OnPlayerVideoPlayStatChangedListener) VodPlayerImpl.this.mOnPlayerVideoPlayStatChangedListener.get();
                            if (listener28 != null) {
                                listener28.onPlayerVideoPlayPaused(true);
                                return;
                            }
                            return;
                        case 5202:
                            OnPlayerVideoPlayStatChangedListener listener29 = (OnPlayerVideoPlayStatChangedListener) VodPlayerImpl.this.mOnPlayerVideoPlayStatChangedListener.get();
                            if (listener29 != null) {
                                listener29.onPlayerVideoPlayPaused(false);
                                return;
                            }
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_SURFACE_CREATED:
                            OnPlayerExtraInfoListener listener30 = (OnPlayerExtraInfoListener) VodPlayerImpl.this.mOnPlayerExtraInfoListener.get();
                            TLog.warn(VodPlayerImpl.TAG, this, "onSurfaceStatus create");
                            if (listener30 != null) {
                                listener30.onPlayerExtraInfo(100, params.param1, 0, 0, (String) null, (Object) null);
                                return;
                            }
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_SURFACE_CHANGED:
                            OnPlayerExtraInfoListener listener31 = (OnPlayerExtraInfoListener) VodPlayerImpl.this.mOnPlayerExtraInfoListener.get();
                            TLog.warn(VodPlayerImpl.TAG, this, "onSurfaceStatus changed");
                            if (listener31 != null) {
                                listener31.onPlayerExtraInfo(101, params.param1, params.param2, params.param4, (String) null, (Object) null);
                                return;
                            }
                            return;
                        case VodConst.MET_CALLBACK_PLAYER_AGAIN_RENDERING_FIRST_VIDEO_FRAME:
                            TLog.warn(VodPlayerImpl.TAG, this, String.format(Locale.getDefault(), "player first frame again show(%d)", new Object[]{Integer.valueOf(((Long) params.paramObj).intValue())}));
                            OnPlayerExtraInfoListener extraInfoListener2 = (OnPlayerExtraInfoListener) VodPlayerImpl.this.mOnPlayerExtraInfoListener.get();
                            if (extraInfoListener2 != null) {
                                TLog.warn(VodPlayerImpl.TAG, this, String.format(Locale.getDefault(), "OnPlayerExtraInfoListener:(%d)", new Object[]{104}));
                                extraInfoListener2.onPlayerExtraInfo(104, params.param1, params.param2, params.param4, (String) null, (Object) null);
                                return;
                            }
                            return;
                        case 6000:
                            OnPlayerQualityMonitorListener listener32 = (OnPlayerQualityMonitorListener) VodPlayerImpl.this.mOnPlayerQualityMonitorListener.get();
                            if (listener32 != null) {
                                listener32.onPlayerReceiveToRenderDelay(VodPlayerImpl.this.mVodPlayer, (int) params.param1);
                                return;
                            }
                            return;
                        case 6001:
                            Log.i("hello", "rendering frameRate " + ((int) params.param1));
                            OnPlayerQualityMonitorListener listener33 = (OnPlayerQualityMonitorListener) VodPlayerImpl.this.mOnPlayerQualityMonitorListener.get();
                            if (listener33 != null) {
                                listener33.onPlayerRenderFramerate(VodPlayerImpl.this.mVodPlayer, (int) params.param1);
                                return;
                            }
                            return;
                        case 6002:
                            OnPlayerQualityMonitorListener listener34 = (OnPlayerQualityMonitorListener) VodPlayerImpl.this.mOnPlayerQualityMonitorListener.get();
                            if (listener34 != null) {
                                listener34.onPlayerDecodeType(VodPlayerImpl.this.mVodPlayer, (int) params.param1);
                                return;
                            }
                            return;
                        case 6003:
                            OnPlayerQualityMonitorListener listener35 = (OnPlayerQualityMonitorListener) VodPlayerImpl.this.mOnPlayerQualityMonitorListener.get();
                            if (listener35 != null) {
                                TLog.warn(VodPlayerImpl.TAG, this, "decoder output size:" + ((int) params.param1) + "*" + ((int) params.param2));
                                listener35.onPlayerDecodeOuputSize(VodPlayerImpl.this.mVodPlayer, (int) params.param1, (int) params.param2);
                                return;
                            }
                            TLog.error(VodPlayerImpl.TAG, this, "OnPlayerQualityMonitorListener is null");
                            return;
                        case 6004:
                            OnPlayerQualityMonitorListener listener36 = (OnPlayerQualityMonitorListener) VodPlayerImpl.this.mOnPlayerQualityMonitorListener.get();
                            if (listener36 != null) {
                                listener36.onPlayerDecodeBitrate(VodPlayerImpl.this.mVodPlayer, (int) params.param1, (int) params.param2);
                                Log.i("hello", "videoBitrate " + ((int) params.param1) + " audioBitrate " + ((int) params.param2));
                                return;
                            }
                            return;
                        case 6005:
                            OnPlayerQualityMonitorListener listener37 = (OnPlayerQualityMonitorListener) VodPlayerImpl.this.mOnPlayerQualityMonitorListener.get();
                            if (listener37 != null) {
                                VodPlayer vodPlayer = VodPlayerImpl.this.mVodPlayer;
                                if (((int) params.param1) != 1) {
                                    z = false;
                                }
                                listener37.onPlayerVideoStalls(vodPlayer, z, (int) params.param2);
                                return;
                            }
                            return;
                        case 6006:
                            OnPlayerQualityMonitorListener listener38 = (OnPlayerQualityMonitorListener) VodPlayerImpl.this.mOnPlayerQualityMonitorListener.get();
                            if (listener38 != null) {
                                VodPlayer vodPlayer2 = VodPlayerImpl.this.mVodPlayer;
                                if (((int) params.param1) != 1) {
                                    z = false;
                                }
                                listener38.onPlayerAudioStalls(vodPlayer2, z, (int) params.param2);
                                return;
                            }
                            return;
                        case 7000:
                            OnPlayerExtraInfoListener listener39 = (OnPlayerExtraInfoListener) VodPlayerImpl.this.mOnPlayerExtraInfoListener.get();
                            TLog.warn(VodPlayerImpl.TAG, this, "on demuxer read header end");
                            if (listener39 != null) {
                                listener39.onPlayerExtraInfo(102, params.param1, 0, 0, (String) null, (Object) null);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public void setDataSource(DataSource source) {
        synchronized (this.mLock) {
            if (this.mMediaPlaySession != null) {
                this.mCurUrl = source.getUrl();
                this.mbLiveMode = source.getLiveMode();
                this.mMediaPlaySession.setDataSource(source);
            }
        }
    }

    public void setDataSourceAndPrepare(DataSource source) {
        synchronized (this) {
            if (this.mMediaPlaySession != null) {
                this.mCurUrl = source.getUrl();
                this.mbLiveMode = source.getLiveMode();
                this.mMediaPlaySession.setDataSourceAndPrepare(source);
            }
        }
    }

    public int updatePcdnDataSource(int taskKId, DataSource source) {
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession == null) {
                return -1;
            }
            mediaPlaySession.updatePcdnDataSource(taskKId, source);
            return 0;
        }
    }

    public void switchPlayingUrl(String url, int protocol) {
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.switchPlayingUrl(url, protocol);
            }
        }
    }

    public void switchPlayingUrl(String url, int protocol, int srcLevel, int dstLevel) {
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.switchPlayingUrl(url, protocol, srcLevel, dstLevel);
            }
        }
    }

    public void start(int taskId, long apiStartTimeMs) {
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay.start enter, isSubProcess:" + this.mPlayerOptions.isSubProcess);
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.start(taskId, apiStartTimeMs);
            }
        }
    }

    public void pause() {
        this.mPlaying = false;
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay.pause enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.pause();
            }
        }
    }

    public void resume() {
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay.resume enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.resume();
            }
        }
    }

    public void seekTo(long time) {
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay.seekTo enter.  seekToTime: " + time);
        synchronized (this.mLock) {
            if (time > ((long) this.mDuration.get())) {
                time = (long) this.mDuration.get();
            }
            if (time < 0) {
                time = 0;
            }
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.seekTo(time);
            }
        }
    }

    public void appInFrontground() {
        TLog.warn(TAG, this, this.mPlayerUID + " appInFrontground");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.onAppInfront();
            }
        }
    }

    public void appInBackground() {
        TLog.warn(TAG, this, this.mPlayerUID + " appInBackground");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.onAppInbackground();
            }
        }
    }

    public void setEnableRevDecodeOutputSize(boolean enable) {
        MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
        if (mediaPlaySession != null) {
            mediaPlaySession.setEnableRevDecodeOutputSize(enable);
        }
    }

    public void setEnableFirstVideoFrameShow(boolean enable) {
        MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
        if (mediaPlaySession != null) {
            mediaPlaySession.setEnableFirstVideoFrameShow(enable);
        }
    }

    public String getRedirectUrl() {
        MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
        if (mediaPlaySession != null) {
            return mediaPlaySession.getRedirectUrl();
        }
        return null;
    }

    public boolean isPlaying() {
        TLog.warn(TAG, this, "impl " + this.mPlayerUID + " isPlaying mPlayerState:" + this.mPlaying);
        return this.mPlaying;
    }

    public void enableJoyPkPipMode(JoyPkPipParameter param) {
        TLog.warn(TAG, this, this.mPlayerUID + " enableJoyPkPipMode:" + (param != null ? FileViewerActivity.LEFT_BRACKET + param.bottomLeftX + "," + param.bottomLeftY + "), (" + param.upperRightX + ", " + param.upperRightY + "), force: " + param.forceEnable : "null"));
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.enableJoyPkPipMode(param);
            }
        }
    }

    public void disableJoyPkPipMode() {
        TLog.warn(TAG, this, this.mPlayerUID + " disableJoyPkPipMode.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.disableJoyPkPipMode();
            }
        }
    }

    public void setEffectResources(EffectResources res) {
        TLog.warn(TAG, this, this.mPlayerUID + " setEffectResources " + EffectResources.toJson(res));
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setEffectResources(res);
            }
        }
    }

    public void stop() {
        this.mPlaying = false;
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay.stop enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.stop();
            }
            this.mTotalSize.set(0);
            this.mCacheTime.set(0);
            this.mDuration.set(0);
            this.mCurrentPosition.set(0);
            this.mVideoWidth.set(0);
            this.mVideoHeight.set(0);
        }
    }

    public void release() {
        TLog.warn(TAG, this, this.mPlayerUID + " release enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.release();
                this.mMediaPlaySession = null;
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                this.mHandler = null;
            }
        }
    }

    public void setNumberOfLoops(int numberOfLoops) {
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay enter.  setNumberOfLoops: " + numberOfLoops);
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setNumberOfLoops(numberOfLoops);
            }
        }
    }

    public void pausePlayWithAudio() {
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay.pausePlayWithAudio enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.pausePlayWithAudio();
            }
        }
    }

    public void resumePlayWithAudio() {
        TLog.warn(TAG, this, this.mPlayerUID + " VodPlay.resumePlayWithAudio enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.resumePlayWithAudio();
            }
        }
    }

    public void pausePlayWithVideo() {
        TLog.warn(TAG, this, this.mPlayerUID + " pause play with video");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.pausePlayWithVideo();
            }
        }
    }

    public void resumePlayWithVideo() {
        TLog.warn(TAG, this, this.mPlayerUID + " resume play with video");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.resumePlayWithVideo();
            }
        }
    }

    public void setVideoExtrasInfoEnable(boolean enable) {
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setVideoExtrasInfoEnable(enable);
            }
        }
    }

    public void setOnPlayerLoadingUpdateListener(OnPlayerLoadingUpdateListener listener) {
        this.mOnPlayerLoadingUpdateListener = new WeakReference<>(listener);
    }

    public void setOnPlayerPlayPositionUpdateListener(OnPlayerPlayPositionUpdateListener listener) {
        this.mOnPlayerPlayPositionUpdateListener = new WeakReference<>(listener);
    }

    public void setOnPlayerFirstVideoFrameShowListener(OnPlayerFirstVideoFrameShowListener listener) {
        this.mOnPlayerFirstVideoFrameShowListener = new WeakReference<>(listener);
    }

    public void setOnPlayerFirstVideoFrameShowByPlayerThreadListener(OnPlayerFirstVideoFrameShowListener listener) {
        this.mOnPlayerFirstVideoFrameShowByPlayerThreadListener = new WeakReference<>(listener);
    }

    public void setOnPlayerCachePositionUpdateListener(OnPlayerCachePositionUpdateListener listener) {
        this.mOnPlayerCachePositionUpdateListener = new WeakReference<>(listener);
    }

    public void setOnPlayerStateUpdateListener(OnPlayerStateUpdateListener listener) {
        this.mOnPlayerStateUpdateListener = new WeakReference<>(listener);
    }

    public void setOnPlayerInfoListener(OnPlayerInfoListener listener) {
        this.mOnPlayerInfoListener = new WeakReference<>(listener);
    }

    public void setOnPlayerStatisticsListener(OnPlayerStatisticsListener listener) {
        this.mOnPlayerStatisListener = new WeakReference<>(listener);
    }

    public void setOnPlayerErrorListener(OnPlayerErrorListener listener) {
        this.mOnPlayerErrorListener = new WeakReference<>(listener);
    }

    public void setOnPlayerPlayCompletionListener(OnPlayerPlayCompletionListener listener) {
        this.mOnPlayerPlayCompletionListener = new WeakReference<>(listener);
    }

    public void setOnPlayerAVExtraInfoListener(Executor executor, OnPlayerAVExtraInfoListener listener) {
        this.mOnPlayerAVExtraInfoListener = new WeakReference<>(listener);
        this.mSeiExecutor = executor;
    }

    public void setPlayerAudioExtraInfoListener(VodPlayer.OnPlayerAudioExtraInfoListener listener) {
        this.mOnPlayerAudioExtraInfoListener = new WeakReference<>(listener);
    }

    public void setOnPlayerNetRequestStatusListener(OnPlayerNetRequestStatusListener listener) {
        this.mOnPlayerNetRequestStatusListener = new WeakReference<>(listener);
    }

    public void setOnPlayerQualityMonitorListener(OnPlayerQualityMonitorListener listener) {
        this.mOnPlayerQualityMonitorListener = new WeakReference<>(listener);
    }

    public void setOnPlayerVideoPlayStatChangedListener(OnPlayerVideoPlayStatChangedListener listener) {
        this.mOnPlayerVideoPlayStatChangedListener = new WeakReference<>(listener);
    }

    public void setOnPlayerCrashListener(OnPlayerCrashListener listener) {
    }

    public void setOnPlayerExtraInfoListener(OnPlayerExtraInfoListener listener) {
        this.mOnPlayerExtraInfoListener = new WeakReference<>(listener);
    }

    public void setOnPlayerUpdatePcdnUrlResultListener(OnPlayerUpdatePcdnUrlResultListener listener) {
        this.mOnPlayerUpdatePcdnUrlResultListener = new WeakReference<>(listener);
    }

    public void setOnPlayerSwitchUrlResultListener(OnPlayerSwitchUrlResultListener listener) {
        this.mOnPlayerSwitchLevelResultListener = new WeakReference<>(listener);
    }

    public void setOnAudioFocusListener(OnAudioFocusListener listener) {
        AudioFocusListener.setFocusChangeExtraListener(listener);
    }

    public void setOnPlayerTextureListener(boolean enable, OnPlayerTextureListener listener) {
        this.mMediaPlaySession.setOnPlayerTextureListener(enable, listener);
    }

    public void setOnPlayerUpdateRtsTokenStatusListener(OnPlayerUpdateRtsTokenStatusListener listener) {
        this.mOnPlayerUpdateRtsTokenStatusListener = new WeakReference<>(listener);
    }

    public void setVolume(int volume) {
        TLog.warn(TAG, this, this.mPlayerUID + " volume:" + volume + " enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setVolume(volume);
            }
        }
    }

    public void updateToken(String token) {
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.updateToken(token);
            }
        }
    }

    public void setDisplayMode(int displayMode) {
        TLog.warn(TAG, this, this.mPlayerUID + " displayMode: " + displayMode + " enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setDisplayMode(displayMode);
            }
        }
    }

    public void setIsSpecialMp4WithAlpha(boolean isSpecialMp4WithAlpha) {
        TLog.warn(TAG, this, this.mPlayerUID + " isSpecialMp4WithAlpha: " + isSpecialMp4WithAlpha + " enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setIsSpecialMp4WithAlpha(isSpecialMp4WithAlpha);
            }
        }
    }

    public void setRotateMode(int rotateMode) {
        TLog.warn(TAG, this, this.mPlayerUID + " rotateMode: " + rotateMode + " enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setRotateMode(rotateMode);
            }
        }
    }

    public void setOrientateMode(int orientateMode) {
        TLog.warn(TAG, this, this.mPlayerUID + " orientateMode: " + orientateMode + " enter.");
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setOrientationMode(orientateMode);
            }
        }
    }

    public Object getPlayerView() {
        return this.mPlayerView;
    }

    public long getCurrentPosition() {
        return (long) this.mCurrentPosition.get();
    }

    public int getPlayerUID() {
        return this.mPlayerUID;
    }

    public long getDuration() {
        return (long) this.mDuration.get();
    }

    public int getVideoWidth() {
        return this.mVideoWidth.get();
    }

    public int getVideoHeight() {
        return this.mVideoHeight.get();
    }

    public boolean isH264HwDecodeEnabled() {
        return this.mPlayerOptions.avcCodec == 1;
    }

    public boolean isH265HwDecodeEnabled() {
        return this.mPlayerOptions.hevcCodec == 1;
    }

    public void screenShot(Executor executor, VodPlayer.VodPlayerScreenShotCallback callback) {
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.screenShot(executor, callback);
            }
        }
    }

    public void screenShotOrigin(Executor executor, VodPlayer.VodPlayerScreenShotCallback callback) {
        synchronized (this.mLock) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.screenShotOrigin(executor, callback);
            }
        }
    }

    public void setPlayBackRate(float rate) {
        synchronized (this) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setPlayBackRate(rate);
            }
        }
    }

    public void setVideoEnhanceType(int type) {
        synchronized (this) {
            MediaPlaySession mediaPlaySession = this.mMediaPlaySession;
            if (mediaPlaySession != null) {
                mediaPlaySession.setVideoEnhanceType(type);
            }
        }
    }

    /* access modifiers changed from: private */
    public void innerPlayerStateChange(int playerState, MsgParamsEventArgs params) {
        TLog.warn(TAG, this, this.mPlayerUID + " MET_CALLBACK_PLAYER_STATE_CHANGE state =" + playerState);
        switch (playerState) {
            case 1:
                params.type = 1;
                return;
            case 4:
                params.type = 4;
                return;
            case 5:
                params.type = 5;
                return;
            case 6:
                params.type = 6;
                return;
            case 7:
                params.type = 7;
                return;
            case 8:
                params.type = 8;
                params.param1 = (long) this.mCurrentPosition.get();
                params.param2 = (long) this.mDuration.get();
                this.mCurrentPosition.set(0);
                this.mCacheTime.set(0);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
    }

    private class MsgParamsEventArgs {
        public Bundle bundle = null;
        public long param1 = 0;
        public long param2 = 0;
        public String param3 = null;
        public long param4 = 0;
        public Object paramObj = null;
        public int type = 0;

        public MsgParamsEventArgs() {
        }
    }
}
