package com.baidu.swan.apps.impl.inlinewidget.video.widget;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import com.baidu.cyberplayer.sdk.DuMediaCache;
import com.baidu.cyberplayer.sdk.DuMediaNet;
import com.baidu.cyberplayer.sdk.DuMediaPlayStatus;
import com.baidu.cyberplayer.sdk.DuMediaPlayer;
import com.baidu.searchbox.player.utils.SimpleCyberInstallListener;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.SwanAppPrefetchManager;
import com.baidu.swan.apps.feature.SwanFeatureCollectorManager;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.framework.SwanActivityFrame;
import com.baidu.swan.apps.impl.inlinewidget.PlayerKernelUtils;
import com.baidu.swan.apps.impl.inlinewidget.video.InlineVideoHttpDns;
import com.baidu.swan.apps.impl.inlinewidget.video.InlineVideoStatisticManager;
import com.baidu.swan.apps.impl.media.live.event.LiveStatusCodeAdapter;
import com.baidu.swan.apps.impl.media.live.model.LiveNetworkStatus;
import com.baidu.swan.apps.impl.statistic.SwanAppImplUBCStatistic;
import com.baidu.swan.apps.inlinewidget.IInlineWidget;
import com.baidu.swan.apps.inlinewidget.util.InlineVideoUtils;
import com.baidu.swan.apps.inlinewidget.video.IInlineVideoStatisticProcessor;
import com.baidu.swan.apps.inlinewidget.video.pictureinpicture.SwanAppPictureInPictureManager;
import com.baidu.swan.apps.inlinewidget.video.statistic.VideoStaticConstant;
import com.baidu.swan.apps.inlinewidget.video.statistic.VideoStatisticManager;
import com.baidu.swan.apps.inlinewidget.video.widget.IInlineVideo;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.event.SwanAppUBCBaseEvent;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.util.SwanAppRefererUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.HashMap;
import java.util.Map;

public abstract class SwanInlineBaseVideoWidget implements IInlineVideo, IInlineVideoStatisticProcessor {
    private static final String CYBER_CALLBACK_TAG = "【CyberCallback】";
    protected static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final int DEFAULT_VIDEO_SAR = 1;
    private static final String INLINE_VIDEO_STAGE_INFO = "51";
    private static final String TAG = "SwanInlineCyberWidget";
    private static final String VIDEO_FROM = "video_from";
    private static final String VIDEO_FROM_SWAN = "swan";
    private static final int WIDGET_VISIBILITY_BACKGROUND = 0;
    private static final int WIDGET_VISIBILITY_FOREGROUND = 1;
    private static final int WIDGET_VISIBILITY_NOT_SET = -1;
    /* access modifiers changed from: private */
    public static boolean sNeedInstallPlayerKernel = true;
    private final AudioManager.OnAudioFocusChangeListener mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.i(SwanInlineBaseVideoWidget.TAG, "onAudioFocusChange: focusChange " + focusChange);
            }
            if (!SwanInlineBaseVideoWidget.this.mIsSilentPlay && focusChange == -1) {
                SwanAppUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        SwanInlineBaseVideoWidget.this.pause();
                    }
                });
            }
        }
    };
    private AudioManager mAudioManger;
    protected Context mContext;
    protected String mCurrentUrl;
    private int mCurrentVisibility = -1;
    /* access modifiers changed from: private */
    public final InlineVideoStatisticManager mDurationStatistic = new InlineVideoStatisticManager();
    private final SwanFeatureCollectorManager.TimerHandler mHandler = SwanFeatureCollectorManager.getInstance().getTimerHandler();
    private ZeusPluginFactory.Invoker mInvoker;
    private boolean mIsDataSourceSet = false;
    /* access modifiers changed from: private */
    public boolean mIsSilentPlay = false;
    private boolean mNeedResume = false;
    /* access modifiers changed from: private */
    public LiveNetworkStatus mNetStatus = new LiveNetworkStatus();
    private final DuMediaPlayStatus.OnBufferingUpdateListener mOnBufferingUpdateListener = new DuMediaPlayStatus.OnBufferingUpdateListener() {
        public void onBufferingUpdate(int i2) {
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.d(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer" + SwanInlineBaseVideoWidget.this.hashCode() + " - onBufferingUpdate(" + i2 + ")");
            }
        }
    };
    private final DuMediaPlayStatus.OnCompletionListener mOnCompletionListener = new DuMediaPlayStatus.OnCompletionListener() {
        public void onCompletion() {
            boolean isEnd = SwanInlineBaseVideoWidget.this.getDuration() != 0 && SwanInlineBaseVideoWidget.this.getCurrentPosition() >= SwanInlineBaseVideoWidget.this.getDuration();
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.d(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer" + SwanInlineBaseVideoWidget.this.hashCode() + " - onCompletion:(" + isEnd + ")");
            }
            SwanInlineBaseVideoWidget.this.abandonAudioFocus();
            if (SwanInlineBaseVideoWidget.this.mPlayerListener != null) {
                if (isEnd) {
                    SwanInlineBaseVideoWidget.this.mPlayerListener.onEnded();
                } else {
                    SwanInlineBaseVideoWidget.this.mPlayerListener.onPaused(SwanInlineBaseVideoWidget.this.getPlayerId());
                }
            }
            SwanInlineBaseVideoWidget.this.mDurationStatistic.stopDurationStatistic(SwanInlineBaseVideoWidget.this.mSlaveId, SwanInlineBaseVideoWidget.this.mCurrentUrl);
        }
    };
    private final DuMediaPlayStatus.OnErrorListener mOnErrorListener = new DuMediaPlayStatus.OnErrorListener() {
        public boolean onError(int what, int extra, Object obj) {
            String objStr = obj != null ? obj.toString() : "null";
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.d(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer" + SwanInlineBaseVideoWidget.this.hashCode() + " - onError(" + what + ", " + extra + ", " + objStr + ")");
            }
            SwanInlineBaseVideoWidget.this.abandonAudioFocus();
            SwanInlineBaseVideoWidget.this.onStateChange(what);
            int realError = what;
            if (what == -10000) {
                what = 0;
            }
            if (SwanInlineBaseVideoWidget.this.mPlayerListener != null) {
                SwanInlineBaseVideoWidget.this.mPlayerListener.onError(what);
            }
            SwanInlineBaseVideoWidget.this.mDurationStatistic.cancelDurationStatistic();
            SwanAppStabilityMonitor.onStabilityMonitor("video", 4000, "video on errorListener, url: " + SwanInlineBaseVideoWidget.this.mCurrentUrl, SwanAppStabilityMonitor.genMediaCode(what, extra), objStr);
            VideoStatisticManager.getStrategy().onVideoPlayFail(SwanInlineBaseVideoWidget.this.getPlayerId(), extra, objStr);
            SwanInlineBaseVideoWidget.this.reportPlayFail(realError, extra, objStr);
            return false;
        }
    };
    private final DuMediaPlayStatus.OnInfoListener mOnInfoListener = new DuMediaPlayStatus.OnInfoListener() {
        public boolean onInfo(int what, int extra, Object obj) {
            String objStr = obj != null ? obj.toString() : "null";
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.d(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer" + SwanInlineBaseVideoWidget.this.hashCode() + " - onInfo(" + what + ", " + extra + ", " + objStr + ")");
            }
            switch (what) {
                case 938:
                    SwanInlineBaseVideoWidget.this.mNetStatus.mAudioBitrate = extra;
                    break;
                case 939:
                    SwanInlineBaseVideoWidget.this.mNetStatus.mVideoBitrate = extra;
                    break;
                case 940:
                    SwanInlineBaseVideoWidget.this.mNetStatus.mVideoFPS = extra;
                    break;
            }
            SwanInlineBaseVideoWidget.this.onStateChange(what);
            SwanInlineBaseVideoWidget.this.mPlayerListener.onInfo(what);
            if (what == 904) {
                SwanInlineBaseVideoWidget.this.reportPlaySuccess();
            }
            switch (what) {
                case 701:
                    VideoStatisticManager.getStrategy().onVideoBufferingStart(SwanInlineBaseVideoWidget.this.getPlayerId());
                    return false;
                case 702:
                    VideoStatisticManager.getStrategy().onVideoBufferingEnd(SwanInlineBaseVideoWidget.this.getPlayerId());
                    return false;
                case 904:
                    SwanAppLog.i(SwanInlineBaseVideoWidget.TAG, "onInfo: inline video display metrics: " + objStr);
                    VideoStatisticManager.getStrategy().onVideoPlaySuccess(SwanInlineBaseVideoWidget.this.getPlayerId(), objStr);
                    SwanInlineBaseVideoWidget.this.statisticVideoPlaySuccess();
                    return false;
                default:
                    return false;
            }
        }
    };
    private final DuMediaPlayStatus.OnPreparedListener mOnPreparedListener = new DuMediaPlayStatus.OnPreparedListener() {
        public void onPrepared() {
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.d(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer" + SwanInlineBaseVideoWidget.this.hashCode() + " - onPrepared()");
            }
            SwanInlineBaseVideoWidget.this.mNetStatus.mVideoWidth = SwanInlineBaseVideoWidget.this.getVideoWidth();
            SwanInlineBaseVideoWidget.this.mNetStatus.mVideoHeight = SwanInlineBaseVideoWidget.this.getVideoHeight();
            SwanFeatureCollectorManager.getInstance().setVideoDuration(SwanInlineBaseVideoWidget.this.getDuration());
            if (SwanInlineBaseVideoWidget.this.mPlayerListener != null) {
                SwanInlineBaseVideoWidget.this.mPlayerListener.onPrepared();
            }
        }
    };
    private final DuMediaPlayStatus.OnSeekCompleteListener mOnSeekCompleteListener = new DuMediaPlayStatus.OnSeekCompleteListener() {
        public void onSeekComplete() {
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.d(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer" + SwanInlineBaseVideoWidget.this.hashCode() + " - onSeekComplete()");
            }
            if (SwanInlineBaseVideoWidget.this.mPlayerListener != null) {
                SwanInlineBaseVideoWidget.this.mPlayerListener.onSeekComplete(SwanInlineBaseVideoWidget.this.getPlayerId());
            }
        }
    };
    private final DuMediaPlayStatus.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new DuMediaPlayStatus.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(int i2, int i1, int i22, int i3) {
            if (SwanInlineBaseVideoWidget.DEBUG) {
                Log.d(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer" + SwanInlineBaseVideoWidget.this.hashCode() + " - onVideoSizeChanged(" + i2 + ", " + i1 + ", " + i22 + ", " + i3 + ")");
            }
            SwanInlineBaseVideoWidget.this.mNetStatus.mVideoWidth = i2;
            SwanInlineBaseVideoWidget.this.mNetStatus.mVideoHeight = i1;
            if (i22 == 0 || i3 == 0) {
                int unused = SwanInlineBaseVideoWidget.this.mVideoSarNum = 1;
                int unused2 = SwanInlineBaseVideoWidget.this.mVideoSarDen = 1;
            } else {
                int unused3 = SwanInlineBaseVideoWidget.this.mVideoSarNum = i22;
                int unused4 = SwanInlineBaseVideoWidget.this.mVideoSarDen = i3;
            }
            if (SwanInlineBaseVideoWidget.this.mPlayerListener != null) {
                SwanInlineBaseVideoWidget.this.mPlayerListener.onVideoSizeChanged();
            }
        }
    };
    private DuMediaPlayer mPlayer;
    protected String mPlayerId;
    protected IInlineVideo.IInlineVideoListener mPlayerListener;
    protected String mPlayerUniqueId;
    /* access modifiers changed from: private */
    public String mSlaveId;
    /* access modifiers changed from: private */
    public int mVideoSarDen = 1;
    /* access modifiers changed from: private */
    public int mVideoSarNum = 1;

    public interface IKernelInstallListener {
        void onFinished(boolean z);
    }

    protected interface UbcConstants {
        public static final String BASE_KEY_EXT = "ext";
        public static final String BASE_KEY_FROM = "from";
        public static final String BASE_KEY_NETWORK = "network";
        public static final String BASE_KEY_TYPE = "type";
        public static final String BASE_VALUE_FROM_VIDEO = "video";
        public static final String BASE_VALUE_TYPE_FIRST_FRAME = "first_frame";
        public static final String EXT_KEY_APP_ID = "appid";
        public static final String EXT_KEY_APP_START = "ext_start";
        public static final String EXT_KEY_ERROR_INFO = "errorInfo";
        public static final String EXT_KEY_ERROR_NO = "errorNo";
        public static final String EXT_KEY_FROM = "ext_from";
        public static final String EXT_KEY_PAGE = "ext_page";
        public static final String EXT_KEY_SUB_ERROR = "sub_errorNo";
        public static final String EXT_KEY_URL = "url";
        public static final String EXT_KEY_VID = "vid";
        public static final String EXT_VALUE_FROM_SWAN_APP = "aiapp";
        public static final String EXT_VALUE_IS_INLINE = "isInline";
        public static final String EXT_VALUE_PAGE_APP = "swan";
        public static final String EXT_VALUE_PAGE_GAME = "swangame";
    }

    public abstract void reportPlayFail(int i2, int i3, String str);

    public abstract void reportPlaySuccess();

    public SwanInlineBaseVideoWidget(ZeusPluginFactory.Invoker invoker, String slaveId) {
        this.mInvoker = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.mPlayerId = (String) obj;
            }
        }
        this.mContext = SwanAppRuntime.getAppContext();
        this.mSlaveId = slaveId;
        this.mPlayerUniqueId = this.mPlayerId + "-" + hashCode();
    }

    public void startInit(final IInlineWidget.IWidgetInitListener initListener) {
        IInlineVideo.IInlineVideoListener iInlineVideoListener = this.mPlayerListener;
        if (iInlineVideoListener != null) {
            iInlineVideoListener.onStartInitStart(this.mPlayerId);
        }
        tryInstallPlayerKernel(new IKernelInstallListener() {
            public void onFinished(boolean isSuccess) {
                initListener.onInitFinish(isSuccess);
                if (SwanInlineBaseVideoWidget.this.mPlayerListener != null) {
                    SwanInlineBaseVideoWidget.this.mPlayerListener.onStartInitEnd(SwanInlineBaseVideoWidget.this.mPlayerId);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized DuMediaPlayer getPlayer() {
        if (this.mPlayer == null) {
            boolean z = DEBUG;
            if (z) {
                Log.i(TAG, "getPlayer:");
            }
            if (SwanAppRuntime.getSwanAppAbTestRuntime().isInlinePlayerSameProcess()) {
                if (z) {
                    Log.d(TAG, "getPlayer: same process");
                }
                this.mPlayer = new DuMediaPlayer(0, (DuMediaNet.HttpDNS) new InlineVideoHttpDns(this.mContext), false);
            } else {
                if (z) {
                    Log.d(TAG, "getPlayer: self process");
                }
                this.mPlayer = new DuMediaPlayer(0, (DuMediaNet.HttpDNS) new InlineVideoHttpDns(this.mContext));
            }
            this.mPlayer.setOnPreparedListener(this.mOnPreparedListener);
            this.mPlayer.setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mPlayer.setOnInfoListener(this.mOnInfoListener);
            this.mPlayer.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
            this.mPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
            HashMap<String, String> stageInfo = getStageInfo();
            if (stageInfo != null) {
                this.mPlayer.setExternalInfo("stage_info", stageInfo);
            }
            if (z) {
                Log.d(TAG, "create " + this.mPlayer.hashCode() + " player");
            }
        }
        return this.mPlayer;
    }

    private HashMap<String, String> getStageInfo() {
        if (this.mInvoker == null) {
            return null;
        }
        HashMap<String, String> stageInfo = new HashMap<>();
        stageInfo.put("stage_type", "51");
        stageInfo.put("stage_source", SwanInlineVideoUtils.getStageSource());
        stageInfo.put("stage_title", String.valueOf(this.mInvoker.get("PageTitle")));
        stageInfo.put("video_from", "swan");
        return stageInfo;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean setDataSource(String url, String cookies, String userAgent, boolean hideUrlLog) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "setDataSource: " + url + " ;userAgent: " + userAgent + " ;cookies: " + cookies);
        }
        this.mIsDataSourceSet = true;
        this.mCurrentUrl = url;
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        String url2 = InlineVideoUtils.parseVideoSrc(url);
        ZeusPluginFactory.Invoker invoker = this.mInvoker;
        if (invoker != null) {
            String proxy = (String) invoker.get("Proxy");
            if (!TextUtils.isEmpty(proxy)) {
                getPlayer().setOption("http_proxy", proxy);
                getPlayer().setOption("need-t5-auth", "true");
            } else {
                getPlayer().setOption("http_proxy", "");
                getPlayer().setOption("need-t5-auth", "false");
            }
        }
        HashMap<String, String> headers = new HashMap<>();
        if (!TextUtils.isEmpty(cookies)) {
            headers.put("Cookie", cookies);
        }
        if (hideUrlLog) {
            headers.put("x-hide-urls-from-log", "true");
        }
        if (!TextUtils.isEmpty(userAgent)) {
            headers.put("User-Agent", userAgent);
        }
        String referer = SwanAppRefererUtils.getFixedReferer();
        if (!TextUtils.isEmpty(referer) && SwanAppRefererUtils.isHttpsUrl(url2)) {
            if (z) {
                Log.d(TAG, "set referer for InlineVideo; referer is " + referer);
            }
            headers.put("Referer", referer);
        }
        if (StorageUtil.getPathType(url2) == PathType.CLOUD) {
            setCloudDataSource(url2, headers);
        } else {
            getPlayer().setDataSource(this.mContext, Uri.parse(url2), headers);
        }
        onVideoOpenStatistic();
        return true;
    }

    private void setCloudDataSource(String url, final HashMap<String, String> headers) {
        SwanAppRuntime.getCloudUrl().getCloudUrl(getContext(), url, new TypedCallback<String>() {
            public void onCallback(String videoUrl) {
                if (!TextUtils.isEmpty(videoUrl)) {
                    SwanInlineBaseVideoWidget.this.getPlayer().setDataSource(SwanInlineBaseVideoWidget.this.mContext, Uri.parse(videoUrl), headers);
                }
            }
        });
    }

    public void setSurface(Surface surface) {
        getPlayer().setSurface(surface);
    }

    public boolean prepareAsync() {
        if (!SwanAppPictureInPictureManager.INSTANCE.isShowing()) {
            requestAudioFocus();
        }
        getPlayer().prepareAsync();
        return true;
    }

    public void start() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, this.mPlayerId + "-" + hashCode() + " start()");
        }
        if (isBackground()) {
            if (z) {
                Log.e(TAG, this.mPlayerId + "-" + hashCode() + " start ignored, widget is in background");
            }
            setNeedResume(true);
            IInlineVideo.IInlineVideoListener iInlineVideoListener = this.mPlayerListener;
            if (iInlineVideoListener != null) {
                iInlineVideoListener.onPaused(getPlayerId());
            }
            this.mDurationStatistic.stopDurationStatistic(this.mSlaveId, this.mCurrentUrl);
            return;
        }
        requestAudioFocus();
        getPlayer().start();
        setKeepScreenOn(true);
        IInlineVideo.IInlineVideoListener iInlineVideoListener2 = this.mPlayerListener;
        if (iInlineVideoListener2 != null) {
            iInlineVideoListener2.onPlayed(getPlayerId());
        }
        this.mDurationStatistic.startDurationStatistic();
        SwanFeatureCollectorManager.TimerHandler timerHandler = this.mHandler;
        if (timerHandler != null) {
            timerHandler.sendEmptyMessage(1);
        }
        VideoStatisticManager.getStrategy().onVideoStartPlay(getPlayerId(), this.mCurrentUrl, DuMediaCache.hasCacheFile(this.mCurrentUrl) ? "1" : "0");
    }

    public String getPlayerId() {
        return this.mPlayerUniqueId;
    }

    public void pause() {
        if (DEBUG) {
            Log.d(TAG, this.mPlayerId + "-" + hashCode() + " pause()");
        }
        getPlayer().pause();
        setKeepScreenOn(false);
        setNeedResume(false);
        IInlineVideo.IInlineVideoListener iInlineVideoListener = this.mPlayerListener;
        if (iInlineVideoListener != null) {
            iInlineVideoListener.onPaused(getPlayerId());
        }
        SwanFeatureCollectorManager.TimerHandler timerHandler = this.mHandler;
        if (timerHandler != null) {
            timerHandler.removeMessages(1);
        }
        this.mDurationStatistic.stopDurationStatistic(this.mSlaveId, this.mCurrentUrl);
        VideoStatisticManager.getStrategy().onVideoPause(getPlayerId());
    }

    public boolean isMuteVideo() {
        return this.mIsSilentPlay;
    }

    public void mute(boolean isMuted) {
        getPlayer().muteOrUnmuteAudio(isMuted);
    }

    public void seekTo(int mSec) {
        getPlayer().seekTo((long) mSec);
    }

    public void setSpeed(float speed) {
        getPlayer().setSpeed(speed);
    }

    public void release() {
        if (DEBUG) {
            Log.d(TAG, this.mPlayerId + " release()");
        }
        IInlineVideo.IInlineVideoListener iInlineVideoListener = this.mPlayerListener;
        if (iInlineVideoListener != null) {
            iInlineVideoListener.onRelease(getPlayerId());
        }
        this.mDurationStatistic.stopDurationStatistic(this.mSlaveId, this.mCurrentUrl);
        abandonAudioFocus();
        getPlayer().release();
    }

    public int getDuration() {
        return getPlayer().getDuration();
    }

    public int getCurrentPosition() {
        return getPlayer().getCurrentPosition();
    }

    public boolean isPlaying() {
        return getPlayer().isPlaying();
    }

    public int getVideoWidth() {
        return getPlayer().getVideoWidth();
    }

    public int getVideoHeight() {
        return getPlayer().getVideoHeight();
    }

    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    public void setUseFreeFlow(boolean flag) {
        if (flag) {
            ZeusPluginFactory.Invoker invoker = this.mInvoker;
            if (invoker != null) {
                getPlayer().changeProxyDynamic((String) invoker.get("Proxy"), true);
                return;
            }
            return;
        }
        getPlayer().changeProxyDynamic((String) null, false);
    }

    public void goBackground() {
        this.mCurrentVisibility = 0;
        if (isPlaying()) {
            pause();
            setNeedResume(true);
        }
    }

    public void setMaxCache(int cacheSecond) {
        if (DEBUG) {
            Log.d(TAG, "setMaxCache (ignore) : " + cacheSecond);
        }
    }

    public void setMinCache(int cacheSecond) {
        if (DEBUG) {
            Log.d(TAG, "setMinCache (ignore) : " + cacheSecond);
        }
    }

    public int getAuthorizeType() {
        return 0;
    }

    public void setFirstPlayStatus(String status) {
        VideoStatisticManager.getStrategy().onFirstPlayStatusReceived(getPlayerId(), status);
    }

    public void setStageInfoType(Map stageInfo) {
        getPlayer().setExternalInfo("stage_info", stageInfo);
    }

    public void setInvoker(ZeusPluginFactory.Invoker invoker) {
        this.mInvoker = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.mPlayerId = (String) obj;
            }
        }
        DuMediaPlayer duMediaPlayer = this.mPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.setExternalInfo("stage_info", getStageInfo());
        }
    }

    public ZeusPluginFactory.Invoker getInvoker() {
        return this.mInvoker;
    }

    public void preOpenVideo() {
        if (DEBUG) {
            Log.i(TAG, "preOpen init Player Cache: ");
        }
        getPlayer();
    }

    public void goForeground() {
        this.mCurrentVisibility = 1;
        if (!isPlaying() && getNeedResume() && !SwanAppPictureInPictureManager.INSTANCE.isShowing()) {
            onVideoResumePlay();
            setNeedResume(false);
            start();
        }
    }

    public void setMuted(boolean isMuted) {
        if (DEBUG) {
            Log.i(TAG, "setMuted: " + isMuted);
        }
        this.mIsSilentPlay = isMuted;
        if (isMuted) {
            abandonAudioFocus();
        } else {
            requestAudioFocus();
        }
        getPlayer().muteOrUnmuteAudio(isMuted);
    }

    public void updateRect(int x, int y, int width, int height) {
    }

    public void setInlineVideoListener(IInlineVideo.IInlineVideoListener listener) {
        this.mPlayerListener = listener;
    }

    public IInlineVideo.IInlineVideoListener getInlineVideoListener() {
        return this.mPlayerListener;
    }

    public String getElementId() {
        return this.mPlayerId;
    }

    public String getSlaveId() {
        return this.mSlaveId;
    }

    public boolean isDataSourceSet() {
        return this.mIsDataSourceSet;
    }

    /* access modifiers changed from: protected */
    public void onVideoResumePlay() {
    }

    private boolean getNeedResume() {
        return this.mNeedResume;
    }

    private void setNeedResume(boolean needResume) {
        this.mNeedResume = needResume;
    }

    private void requestAudioFocus() {
        if (!this.mIsSilentPlay) {
            if (this.mAudioManger == null) {
                this.mAudioManger = (AudioManager) this.mContext.getSystemService("audio");
            }
            AudioManager audioManager = this.mAudioManger;
            if (audioManager != null) {
                try {
                    audioManager.requestAudioFocus(this.mAudioFocusListener, 3, 1);
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        } else if (DEBUG) {
            Log.i(TAG, "requestAudioFocus: abandon request audio focus. Muted video.");
        }
    }

    public static void tryInstallPlayerKernel(final IKernelInstallListener listener) {
        if (sNeedInstallPlayerKernel) {
            PlayerKernelUtils.install(7, new SimpleCyberInstallListener() {
                public void onInstallError(int i2, int i1, String s) {
                    SwanAppStabilityMonitor.onStabilityMonitor("video", 4009, "CyberPlayer install fail", -999, "");
                    if (SwanInlineBaseVideoWidget.DEBUG) {
                        Log.i(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer播放内核安装失败");
                    }
                    boolean unused = SwanInlineBaseVideoWidget.sNeedInstallPlayerKernel = false;
                    IKernelInstallListener iKernelInstallListener = IKernelInstallListener.this;
                    if (iKernelInstallListener != null) {
                        iKernelInstallListener.onFinished(false);
                    }
                }

                public void onInstallSuccess(int i2, String s) {
                    if (SwanInlineBaseVideoWidget.DEBUG) {
                        Log.i(SwanInlineBaseVideoWidget.CYBER_CALLBACK_TAG, "CyberPlayer播放内核安装成功");
                    }
                    boolean unused = SwanInlineBaseVideoWidget.sNeedInstallPlayerKernel = false;
                    IKernelInstallListener iKernelInstallListener = IKernelInstallListener.this;
                    if (iKernelInstallListener != null) {
                        iKernelInstallListener.onFinished(true);
                    }
                }

                public void onInstallProgress(int i2, int i1) {
                }
            });
            return;
        }
        if (DEBUG) {
            Log.v(CYBER_CALLBACK_TAG, "CyberPlayer播放内核已安装，无需重复安装");
        }
        if (listener != null) {
            listener.onFinished(true);
        }
    }

    /* access modifiers changed from: private */
    public void abandonAudioFocus() {
        if (this.mAudioManger == null) {
            this.mAudioManger = (AudioManager) this.mContext.getSystemService("audio");
        }
        AudioManager audioManager = this.mAudioManger;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.mAudioFocusListener);
        }
    }

    private void setKeepScreenOn(final boolean isOn) {
        SwanAppUtils.postOnUi(new Runnable() {
            public void run() {
                Activity activity;
                Window window;
                if (SwanApp.get() != null && (activity = Swan.get().getActivity()) != null && (window = activity.getWindow()) != null) {
                    try {
                        if (isOn) {
                            window.addFlags(128);
                        } else {
                            window.clearFlags(128);
                        }
                    } catch (Exception e2) {
                        if (SwanInlineBaseVideoWidget.DEBUG) {
                            throw new RuntimeException("inline video set screenOn/Off in wrong thread", e2);
                        }
                    }
                    if (SwanInlineBaseVideoWidget.DEBUG) {
                        Log.d(SwanInlineBaseVideoWidget.TAG, "setKeepScreenOn: " + isOn);
                    }
                }
            }
        });
    }

    private boolean isBackground() {
        if (this.mCurrentVisibility == -1) {
            ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
            if (frameContainer == null) {
                if (DEBUG) {
                    Log.v(TAG, "check background by activity null, background ? true");
                }
                return true;
            }
            SwanActivityFrame frame = frameContainer.getFrame();
            if (frame == null) {
                if (DEBUG) {
                    Log.v(TAG, "check background by frame null, background ? true");
                }
                return true;
            }
            if (DEBUG) {
                Log.v(TAG, "check background by frame lifeState, background ? " + (!frame.getLifeState().hasStarted()));
            }
            return !frame.getLifeState().hasStarted();
        }
        if (DEBUG) {
            Log.v(TAG, "check background by kernel state, background ? " + (this.mCurrentVisibility == 0));
        }
        if (this.mCurrentVisibility == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void onStateChange(int what) {
        IInlineVideo.IInlineVideoListener iInlineVideoListener;
        int liveStatusCode = LiveStatusCodeAdapter.convertStatusCode(what);
        if (DEBUG) {
            Log.d(CYBER_CALLBACK_TAG, "CyberPlayer" + hashCode() + " - send onStateChange(what " + what + ", statusCode " + liveStatusCode + ")");
        }
        if (liveStatusCode != 100) {
            if (liveStatusCode == 2101 && (iInlineVideoListener = this.mPlayerListener) != null) {
                iInlineVideoListener.onStateChange(2102);
            }
            IInlineVideo.IInlineVideoListener iInlineVideoListener2 = this.mPlayerListener;
            if (iInlineVideoListener2 != null) {
                iInlineVideoListener2.onStateChange(liveStatusCode);
            }
        }
    }

    public void onVideoOpenStatistic() {
        VideoStatisticManager.getStrategy().onVideoOpen(getPlayerId());
    }

    public void onVideoPreCreateStart() {
        VideoStatisticManager.getStrategy().onVideoPreStartStart(getPlayerId());
    }

    public void onVideoPreCreateEnd() {
        VideoStatisticManager.getStrategy().onVideoPreStartEnd(getPlayerId());
    }

    public void onVideoCreateStart() {
        VideoStatisticManager.getStrategy().onVideoCreateStart(getPlayerId());
    }

    public void onVideoCreateEnd() {
        VideoStatisticManager.getStrategy().onVideoCreateEnd(getPlayerId());
    }

    /* access modifiers changed from: private */
    public void statisticVideoPlaySuccess() {
        if (DuMediaCache.hasCacheFile(this.mCurrentUrl)) {
            SwanAppUBCBaseEvent event = new SwanAppUBCBaseEvent();
            event.mFrom = "swan";
            event.mType = "video";
            event.mSource = "prefetch";
            String appKey = Swan.get().getApp().getAppKey();
            event.addExt("app_key", appKey);
            event.addExt(VideoStaticConstant.PREFETCH_CACHE_HIT, "1");
            SwanAppFragment fragment = SwanAppController.getInstance().getTopSwanAppFragment();
            if (fragment != null) {
                event.addExt(VideoStaticConstant.PREFETCH_CURRENT_PAGE, SwanAppPageParam.buildPageWithParams(fragment.getCurSwanAppPageParams()));
            }
            PrefetchEvent prefetchEvent = SwanAppPrefetchManager.getInstance().removePrefetchEvent(appKey);
            if (prefetchEvent != null && !TextUtils.isEmpty(prefetchEvent.pageUrl)) {
                event.addExt(VideoStaticConstant.PREFETCH_REFER_PAGE, prefetchEvent.pageUrl);
            }
            SwanAppImplUBCStatistic.onEvent(VideoStaticConstant.UBC_ID_VIDEO_PREFETCH, event);
        }
    }

    /* access modifiers changed from: package-private */
    public void onNetStatus() {
        String statusData = this.mNetStatus.toJSONString();
        if (!TextUtils.isEmpty(statusData)) {
            if (DEBUG) {
                Log.d(CYBER_CALLBACK_TAG, "CyberPlayer" + hashCode() + " - send onNetStatus(" + statusData + ")");
            }
            IInlineVideo.IInlineVideoListener iInlineVideoListener = this.mPlayerListener;
            if (iInlineVideoListener != null) {
                iInlineVideoListener.onNetStatus(statusData);
            }
        }
    }
}
