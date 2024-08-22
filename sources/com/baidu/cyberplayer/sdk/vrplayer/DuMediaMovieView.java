package com.baidu.cyberplayer.sdk.vrplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.DuMediaNet;
import com.baidu.cyberplayer.sdk.DuMediaPlayConstants;
import com.baidu.cyberplayer.sdk.DuMediaPlayStatus;
import com.baidu.cyberplayer.sdk.DuMediaPlayer;
import com.baidu.cyberplayer.sdk.IVideoView;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.filter.FilterConfig;
import com.baidu.cyberplayer.sdk.mediainfo.DuMediaInfo;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.talos.core.deploy.data.BundlePackageVersionInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuMediaMovieView extends FrameLayout implements IVideoView {
    protected static final boolean ENABLE_DEBUG = false;
    protected static final String TAG = "VrMovieView";
    protected Context appContext;
    protected boolean b2DVideo = false;
    protected String cacheDir;
    protected PlayerState curPlayerState = PlayerState.IDLE;
    protected RenderState curRenderState = RenderState.PAUSED;
    private int curScaleType = 0;
    protected int displayMode;
    protected boolean enableDetachedSurfaceTextureView = true;
    protected boolean enableMediaCodec = true;
    protected Map<String, String> headers;
    protected String httpProxy;
    protected int interactiveMode;
    protected boolean isRestart = false;
    protected Uri lastUri = null;
    protected String lastVideoName;
    protected boolean looping = false;
    private String mCoreLoadInfo = BundlePackageVersionInfo.DEFAULT_MIN_VERSION;
    private int mDecodeMode = 0;
    private DuMediaNet.HttpDNS mHttpDns;
    private boolean mIsAudioMuted = false;
    private HashMap<String, String> mOptions = new HashMap<>();
    private boolean mRemote = true;
    private float mSpeed = 1.0f;
    /* access modifiers changed from: private */
    public int mVideoHeight = 0;
    /* access modifiers changed from: private */
    public int mVideoWidth = 0;
    /* access modifiers changed from: protected */
    public DuMediaPlayer mediaPlayer;
    protected OnBufferingEndListener onBufferingEndListener;
    protected OnBufferingStartListener onBufferingStartListener;
    protected DuMediaPlayStatus.OnBufferingUpdateListener onBufferingUpdateListener;
    protected OnClickListener onClickListener;
    protected DuMediaPlayStatus.OnCompletionListener onCompletionListener;
    protected DuMediaPlayStatus.OnErrorListener onErrorListener;
    /* access modifiers changed from: protected */
    public DuMediaPlayStatus.OnInfoListener onInfoListener;
    protected OnPitchYawRollListener onPitchYawRoll;
    protected DuMediaPlayStatus.OnPreparedListener onPreparedListener;
    protected OnRenderStartListener onRenderStartListener;
    protected DuMediaPlayStatus.OnSeekCompleteListener onSeekCompleteListener;
    protected OnSeekStartListener onSeekStartListener;
    /* access modifiers changed from: protected */
    public OnSurfaceReadyListener onSurfaceReadyListener;
    protected View.OnTouchListener onTouchListener;
    protected DuMediaPlayStatus.OnVideoSizeChangedListener onVideoSizeChangeListener;
    protected boolean pauseBufferingWhenPrepared;
    protected int playerType = 0;
    protected int projectionMode;
    protected View renderView;
    protected int seekModeWhenPrepared;
    protected int seekWhenPrepared;
    protected int sourceType;
    protected int srcHeight;
    protected int srcWidth;
    /* access modifiers changed from: protected */
    public Surface surface;
    protected PlayerState tarPlayerState = PlayerState.IDLE;
    protected Uri uri = null;
    protected String videoName;
    protected int viewType;

    public interface OnBufferingEndListener {
        void onBufferingEnd();
    }

    public interface OnBufferingStartListener {
        void onBufferingStart();
    }

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i2);
    }

    public interface OnClickListener {
        void onClick(MotionEvent motionEvent);
    }

    public interface OnCompletionListener {
        void onCompletion();
    }

    public interface OnErrorListener {
        void onError(int i2, int i3);
    }

    public interface OnInfoListener {
        void onInfo(int i2, int i3);
    }

    public interface OnPitchYawRollListener {
        void onPitchYawRoll(float f2, float f3, float f4);
    }

    public interface OnPreparedListener {
        void onPrepared();
    }

    public interface OnRenderStartListener {
        void onRenderStart();
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    public interface OnSeekStartListener {
        void onSeekStart();
    }

    public interface OnSurfaceReadyListener {
        void onSurfaceReady();
    }

    public interface OnVideoSizeChangeListener {
        void onVideoSizeChange(int i2, int i3);
    }

    protected enum PlayerState {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        PLAYBACK_COMPLETED
    }

    protected enum RenderState {
        PAUSED,
        RESUMED
    }

    public DuMediaMovieView(Context context) {
        super(context);
        if (!isInEditMode()) {
            checkContext(context);
        }
    }

    public DuMediaMovieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        checkContext(context);
    }

    public DuMediaMovieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        checkContext(context);
    }

    /* access modifiers changed from: protected */
    public void checkContext(Context context) {
        if (context != null) {
            this.appContext = context.getApplicationContext();
        } else {
            CyberLog.e(TAG, "Context not be null");
        }
    }

    public View getView() {
        return this;
    }

    public DuMediaPlayer getDuMediaPlayer() {
        return this.mediaPlayer;
    }

    public DuMediaInfo getMediaInfo() {
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer == null) {
            return null;
        }
        return duMediaPlayer.getMediaInfo();
    }

    public void getMediaRuntimeInfo(DuMediaPlayStatus.OnMediaRuntimeInfoListener listener) {
        getMediaRuntimeInfo(100, listener);
    }

    public void getMediaRuntimeInfo(int type, DuMediaPlayStatus.OnMediaRuntimeInfoListener listener) {
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.getMediaRuntimeInfo(type, listener);
        }
    }

    public boolean init2D() {
        this.b2DVideo = true;
        if (this.playerType == 0) {
            this.playerType = 1;
        }
        if (this.viewType == 0) {
            this.viewType = 1;
        }
        printCommonLog(1, String.format("playerType:" + this.playerType + " interactiveMode:" + this.interactiveMode + " displayMode:" + this.displayMode + " sourceType:" + this.sourceType + " viewType:" + this.viewType, new Object[0]));
        initView(this.viewType);
        return true;
    }

    public void setOption(String name, String value) {
        if (this.curPlayerState == PlayerState.IDLE) {
            HashMap<String, String> hashMap = this.mOptions;
            if (hashMap != null) {
                hashMap.put(name, value);
            }
            if (this.mediaPlayer == null) {
                return;
            }
            if (name == null || !name.equals("http_proxy") || TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
                this.mediaPlayer.setOption(name, value);
                return;
            }
            return;
        }
        printCommonLog(1, "Do not set option when the video player playing");
    }

    public void changeProxyDynamic(String httpProxy2) {
        if (this.mediaPlayer != null && TextUtils.isEmpty(Utils.getSystemHttpProxy())) {
            String oldProxy = null;
            HashMap<String, String> hashMap = this.mOptions;
            if (hashMap != null) {
                oldProxy = hashMap.get("http_proxy");
            }
            if (!TextUtils.isEmpty(httpProxy2)) {
                if (!httpProxy2.equals(oldProxy)) {
                    this.mediaPlayer.changeProxyDynamic(httpProxy2, true);
                } else {
                    return;
                }
            } else if (!TextUtils.isEmpty(oldProxy)) {
                this.mediaPlayer.changeProxyDynamic((String) null, false);
            } else {
                return;
            }
            this.mediaPlayer.seekTo((long) (getCurrentPosition() - 500));
            HashMap<String, String> hashMap2 = this.mOptions;
            if (hashMap2 != null) {
                hashMap2.put("http_proxy", httpProxy2);
            }
        }
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    /* access modifiers changed from: protected */
    public boolean createView(int viewType2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void initView(int viewType2) {
        destroyView();
        createView(viewType2);
        Object[] objArr = new Object[1];
        View view2 = this.renderView;
        objArr[0] = Integer.valueOf(view2 == null ? 0 : view2.hashCode());
        printCommonLog(1, String.format("rendView hashCode = %d", objArr));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setViewType(int viewType2) {
        this.viewType = viewType2;
    }

    public int getPlayerType() {
        return this.playerType;
    }

    public void setPlayerType(int playerType2) {
        this.playerType = playerType2;
    }

    public boolean isEnableMediaCodec() {
        return this.enableMediaCodec;
    }

    public void setEnableMediaCodec(boolean enableMediaCodec2) {
        this.enableMediaCodec = enableMediaCodec2;
    }

    /* access modifiers changed from: protected */
    public void on23DVideoSizeChange(int width, int height, int sarNum, int sarDen) {
        if (width != 0 && height != 0 && this.renderView != null) {
            printCommonLog(1, "on23DVideoSizeChanged w:" + width + " h:" + height);
        }
    }

    /* access modifiers changed from: protected */
    public void initPlayer(int playerType2) {
        destroyPlayer(this.lastUri != null, false);
        ((AudioManager) this.appContext.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        this.mediaPlayer = createPlayer(playerType2);
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            for (String key : hashMap.keySet()) {
                this.mediaPlayer.setOption(key, this.mOptions.get(key));
            }
        }
        Surface surface2 = this.surface;
        if (surface2 != null) {
            this.mediaPlayer.setSurface(surface2);
        }
        this.mediaPlayer.setOnPreparedListener(new DuMediaPlayStatus.OnPreparedListener() {
            public void onPrepared() {
                DuMediaMovieView.this.printCommonLog(1, "onPrepared");
                DuMediaMovieView.this.setCurPlayerState(PlayerState.PREPARED);
                DuMediaMovieView.this.mediaPlayer.setLooping(DuMediaMovieView.this.looping);
                if (DuMediaMovieView.this.onPreparedListener != null) {
                    DuMediaMovieView.this.onPreparedListener.onPrepared();
                }
                if (DuMediaMovieView.this.seekWhenPrepared != 0) {
                    DuMediaMovieView duMediaMovieView = DuMediaMovieView.this;
                    duMediaMovieView.seekTo(duMediaMovieView.seekWhenPrepared, DuMediaMovieView.this.seekModeWhenPrepared);
                }
                if (DuMediaMovieView.this.tarPlayerState == PlayerState.PLAYING) {
                    DuMediaMovieView.this.start();
                } else if (DuMediaMovieView.this.pauseBufferingWhenPrepared) {
                    DuMediaMovieView.this.pauseBuffering();
                }
            }
        });
        this.mediaPlayer.setOnVideoSizeChangedListener(new DuMediaPlayStatus.OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(int width, int height, int sarNum, int sarDen) {
                DuMediaMovieView.this.printCommonLog(1, String.format("onVideoSizeChanged,w=%d,h=%d", new Object[]{Integer.valueOf(width), Integer.valueOf(height)}));
                if (width != 0 && height != 0) {
                    DuMediaMovieView.this.on23DVideoSizeChange(width, height, sarNum, sarDen);
                    DuMediaMovieView.this.requestLayout();
                    int unused = DuMediaMovieView.this.mVideoWidth = width;
                    int unused2 = DuMediaMovieView.this.mVideoHeight = height;
                    if (DuMediaMovieView.this.onVideoSizeChangeListener != null) {
                        DuMediaMovieView.this.onVideoSizeChangeListener.onVideoSizeChanged(width, height, sarNum, sarDen);
                    }
                }
            }
        });
        this.mediaPlayer.setOnCompletionListener(new DuMediaPlayStatus.OnCompletionListener() {
            public void onCompletion() {
                DuMediaMovieView.this.printCommonLog(1, "onCompletion");
                DuMediaMovieView.this.setCurPlayerState(PlayerState.PLAYBACK_COMPLETED);
                DuMediaMovieView.this.tarPlayerState = PlayerState.PLAYBACK_COMPLETED;
                if (DuMediaMovieView.this.onCompletionListener != null) {
                    DuMediaMovieView.this.onCompletionListener.onCompletion();
                }
            }
        });
        this.mediaPlayer.setOnErrorListener(new DuMediaPlayStatus.OnErrorListener() {
            public boolean onError(int what, int extra, Object obj) {
                DuMediaMovieView.this.printCommonLog(1, String.format("onError:err=%d,detail=%d", new Object[]{Integer.valueOf(what), Integer.valueOf(extra)}));
                if (what == -10000 && (extra == 11 || extra == 101 || extra == -110 || extra == -5)) {
                    extra = 300;
                }
                DuMediaMovieView.this.handleError(what, extra);
                return true;
            }
        });
        this.mediaPlayer.setOnInfoListener(new DuMediaPlayStatus.OnInfoListener() {
            public boolean onInfo(int what, int extra, Object obj) {
                DuMediaMovieView.this.printCommonLog(1, String.format("onInfo:what=%d,extra=%d", new Object[]{Integer.valueOf(what), Integer.valueOf(extra)}));
                if (DuMediaMovieView.this.onInfoListener != null) {
                    DuMediaMovieView.this.onInfoListener.onInfo(what, extra, (Object) null);
                }
                if (what == 701) {
                    DuMediaMovieView.this.printCommonLog(2, "onBufferingStart");
                    if (DuMediaMovieView.this.onBufferingStartListener != null) {
                        DuMediaMovieView.this.onBufferingStartListener.onBufferingStart();
                    }
                } else if (what == 702) {
                    DuMediaMovieView.this.printCommonLog(2, "onBufferingEnd");
                    if (DuMediaMovieView.this.onBufferingEndListener != null) {
                        DuMediaMovieView.this.onBufferingEndListener.onBufferingEnd();
                    }
                } else if (what == 3) {
                    DuMediaMovieView.this.printCommonLog(1, "onRenderStart");
                    if (DuMediaMovieView.this.onRenderStartListener != null) {
                        DuMediaMovieView.this.onRenderStartListener.onRenderStart();
                    }
                }
                return true;
            }
        });
        this.mediaPlayer.setOnBufferingUpdateListener(new DuMediaPlayStatus.OnBufferingUpdateListener() {
            public void onBufferingUpdate(int percent) {
                DuMediaMovieView.this.printCommonLog(2, String.format("onBufferingUpdate:percent=%d", new Object[]{Integer.valueOf(percent)}));
                if (DuMediaMovieView.this.onBufferingUpdateListener != null) {
                    DuMediaMovieView.this.onBufferingUpdateListener.onBufferingUpdate(percent);
                }
            }
        });
        this.mediaPlayer.setOnSeekCompleteListener(new DuMediaPlayStatus.OnSeekCompleteListener() {
            public void onSeekComplete() {
                DuMediaMovieView.this.printCommonLog(1, PluginInvokerConstants.METHOD_STATICS_SEEK_COMPLETE);
                if (DuMediaMovieView.this.onSeekCompleteListener != null) {
                    DuMediaMovieView.this.onSeekCompleteListener.onSeekComplete();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initVariable() {
        this.seekWhenPrepared = 0;
        this.seekModeWhenPrepared = 3;
        this.pauseBufferingWhenPrepared = false;
    }

    public void enableCache(String cacheDir2) {
        this.cacheDir = cacheDir2;
    }

    public void setScaleType(int type) {
        this.curScaleType = type;
    }

    public void setSpeed(float speed) {
        printCommonLog(1, "setSpeed()");
        this.mSpeed = speed;
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.setSpeed(speed);
        } else {
            printCommonLog(1, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    /* access modifiers changed from: protected */
    public DuMediaPlayer createPlayer(int playerType2) {
        int i2 = this.mDecodeMode;
        if (i2 == 3 || i2 < 0 || i2 > 4) {
            this.mDecodeMode = 0;
        }
        printCommonLog(1, "createplayer : " + playerType2);
        return new DuMediaPlayer(this.mDecodeMode, (DuMediaNet.HttpDNS) null);
    }

    public void setExternalInfo(String whatStr, Object obj) {
        DuMediaPlayer duMediaPlayer;
        if (!TextUtils.isEmpty(whatStr) && (duMediaPlayer = this.mediaPlayer) != null) {
            duMediaPlayer.setExternalInfo(whatStr, obj);
        }
    }

    public long getPlayedTime() {
        if (this.mediaPlayer == null || this.curPlayerState == PlayerState.IDLE || this.curPlayerState == PlayerState.PREPARING) {
            return -1;
        }
        return this.mediaPlayer.getPlayedTime();
    }

    public void setClarityInfo(String info) {
    }

    public void switchMediaSource(int id) {
    }

    public void switchMediaSource(int id, DuMediaPlayConstants.DuMediaSourceSwitchMode mode) {
    }

    public boolean takeSnapshotAsync(IVideoView.OnSnapShotCompleteListener l) {
        return true;
    }

    public boolean takeSnapshotAsync(IVideoView.OnSnapShotCompleteListener l, float scale, int x, int y) {
        return true;
    }

    public void setVideoRotation(int rotate) {
    }

    public void setVideoScalingMode(int mode) {
    }

    public void muteOrUnmuteAudio(boolean muted) {
        this.mIsAudioMuted = muted;
        printCommonLog(1, "muteOrUnmuteAudio flag:" + muted);
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.muteOrUnmuteAudio(muted);
        } else {
            printCommonLog(1, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    public boolean isEnableDetachedSurfaceTextureView() {
        return this.enableDetachedSurfaceTextureView;
    }

    public void setEnableDetachedSurfaceTextureView(boolean enableDetachedSurfaceTextureView2) {
        this.enableDetachedSurfaceTextureView = enableDetachedSurfaceTextureView2;
    }

    public void setHttpProxy(String httpProxy2) {
        this.httpProxy = httpProxy2;
    }

    private boolean isMp4WebVideo(String path) {
        if (!path.startsWith("http://") && !path.startsWith("https://")) {
            return false;
        }
        int idxDot = path.lastIndexOf(".");
        int idxMp4 = path.lastIndexOf(".mp4");
        if (idxDot == -1 || idxMp4 == -1 || idxDot != idxMp4) {
            return false;
        }
        return true;
    }

    public void setVideoPath(String path) {
        setVideoURI(Uri.parse(path));
    }

    public void setVideoName(String videoName2) {
        printCommonLog(1, "videoName:" + videoName2);
        this.lastVideoName = this.videoName;
        this.videoName = videoName2;
    }

    public void setVideoURI(Uri uri2) {
        setVideoURI(uri2, (Map<String, String>) null);
    }

    public void setVideoURI(Uri uri2, Map<String, String> headers2) {
        setVideoURI(uri2, headers2, (Map<String, String>) null);
    }

    public void setVideoURI(Uri uri2, Map<String, String> headers2, Map<String, String> options) {
        printCommonLog(1, "videoURI:" + uri2.toString());
        if (options != null) {
            this.mOptions.putAll(options);
        }
        this.lastUri = this.uri;
        this.uri = uri2;
        this.headers = headers2;
        openVideo();
    }

    public Uri getVideoUri() {
        return this.uri;
    }

    /* access modifiers changed from: protected */
    public boolean isSurfaceReady() {
        return !this.b2DVideo && this.surface != null;
    }

    /* access modifiers changed from: protected */
    public void openVideo() {
        if (this.uri != null && isSurfaceReady()) {
            printCommonLog(1, String.format("uri:%s ", new Object[]{this.uri}));
            initPlayer(this.playerType);
            initVariable();
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    this.mediaPlayer.setDataSource(this.appContext, this.uri, this.headers);
                } else {
                    this.mediaPlayer.setDataSource(this.uri.toString());
                }
                if (this.b2DVideo) {
                    printCommonLog(1, "video is 2d");
                } else {
                    this.mediaPlayer.setSurface(this.surface);
                }
                this.mediaPlayer.prepareAsync();
                boolean z = this.mIsAudioMuted;
                if (z) {
                    muteOrUnmuteAudio(z);
                }
                setCurPlayerState(PlayerState.PREPARING);
            } catch (Exception e2) {
                handleError(1, 0);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setLooping(boolean looping2) {
        if (!(this.mediaPlayer == null || this.curPlayerState == PlayerState.ERROR)) {
            this.mediaPlayer.setLooping(looping2);
        }
        this.looping = looping2;
    }

    public boolean isLooping() {
        return this.looping;
    }

    /* access modifiers changed from: protected */
    public void handleError(int errorCode, int detailedErrorCode) {
        setCurPlayerState(PlayerState.ERROR);
        this.tarPlayerState = PlayerState.ERROR;
        DuMediaPlayStatus.OnErrorListener onErrorListener2 = this.onErrorListener;
        if (onErrorListener2 != null) {
            onErrorListener2.onError(errorCode, detailedErrorCode, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public boolean is23DReady() {
        return this.b2DVideo;
    }

    /* access modifiers changed from: protected */
    public void pauseRender() {
    }

    /* access modifiers changed from: protected */
    public void resumeRender() {
    }

    /* access modifiers changed from: protected */
    public void destroyRender() {
    }

    public boolean isAllReady() {
        return (this.renderView == null || this.mediaPlayer == null || !is23DReady()) ? false : true;
    }

    public void start() {
        printCommonLog(1, "start");
        startPlayer();
        resumeRender();
    }

    public void pause() {
        printCommonLog(1, "pause");
        pausePlayer();
    }

    public void stepToNextFrame() {
    }

    public void pauseBuffering() {
        printCommonLog(1, "pauseBuffering");
        if (isInPlaybackState()) {
            printCommonLog(1, "current state is in playback state ");
        } else {
            this.pauseBufferingWhenPrepared = true;
        }
    }

    public void stopPlayback() {
        stop();
    }

    public void stop() {
        printCommonLog(1, "stop");
        destroyPlayer(false);
        pauseRender();
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void reStart() {
        this.isRestart = true;
        setVideoName(this.videoName);
        setVideoURI(this.uri);
        start();
    }

    public void destroy() {
        printCommonLog(1, "destroy");
        HashMap<String, String> hashMap = this.mOptions;
        if (hashMap != null) {
            hashMap.clear();
        }
        destroyPlayer(false);
        destroyView();
        destroyRender();
        this.surface = null;
        this.onCompletionListener = null;
        this.onPreparedListener = null;
        this.onBufferingUpdateListener = null;
        this.onSeekStartListener = null;
        this.onSeekCompleteListener = null;
        this.onInfoListener = null;
        this.onBufferingStartListener = null;
        this.onBufferingEndListener = null;
        this.onRenderStartListener = null;
        this.onSurfaceReadyListener = null;
        this.onVideoSizeChangeListener = null;
        this.onErrorListener = null;
        this.onClickListener = null;
    }

    /* access modifiers changed from: protected */
    public void destroyView() {
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.setDisplay((SurfaceHolder) null);
        }
        View view2 = this.renderView;
        if (view2 != null) {
            removeView(view2);
            this.renderView = null;
        }
    }

    public void setDecodeMode(int mode) {
        this.mDecodeMode = mode;
    }

    public int getDecodeMode() {
        return this.mDecodeMode;
    }

    public void setRemote(boolean remote) {
        this.mRemote = remote;
    }

    public boolean isInPlaybackState() {
        return (this.mediaPlayer == null || this.curPlayerState == PlayerState.ERROR || this.curPlayerState == PlayerState.IDLE || this.curPlayerState == PlayerState.PREPARING) ? false : true;
    }

    public boolean isPlayerIdle() {
        return this.mediaPlayer != null && this.curPlayerState == PlayerState.IDLE;
    }

    public void startPlayer() {
        if (isInPlaybackState()) {
            this.mediaPlayer.start();
            setCurPlayerState(PlayerState.PLAYING);
        }
        this.tarPlayerState = PlayerState.PLAYING;
        printCommonLog(1, "startPlayer");
    }

    /* access modifiers changed from: protected */
    public void pausePlayer() {
        if (isInPlaybackState() && (this.mediaPlayer.isPlaying() || this.curPlayerState == PlayerState.PREPARED)) {
            printCommonLog(1, "pausePlayer");
            this.mediaPlayer.pause();
            setCurPlayerState(PlayerState.PAUSED);
        }
        this.tarPlayerState = PlayerState.PAUSED;
    }

    public void reset() {
        this.mIsAudioMuted = false;
        this.mSpeed = 1.0f;
        resetPlayer();
    }

    public void resetPlayer() {
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.reset();
            this.mediaPlayer.setSurface(this.surface);
        }
        setCurPlayerState(PlayerState.IDLE);
        this.tarPlayerState = PlayerState.IDLE;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    /* access modifiers changed from: protected */
    public void destroyPlayer(boolean last) {
        destroyPlayer(last, true);
    }

    /* access modifiers changed from: protected */
    public void destroyPlayer(boolean last, boolean clearTarPlayerState) {
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.setDisplay((SurfaceHolder) null);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        setCurPlayerState(PlayerState.IDLE);
        if (clearTarPlayerState) {
            this.tarPlayerState = PlayerState.IDLE;
        }
        ((AudioManager) this.appContext.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mediaPlayer.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int msec) {
        if (msec >= 0 && getDuration() != 0) {
            printCommonLog(1, "seekTo");
            OnSeekStartListener onSeekStartListener2 = this.onSeekStartListener;
            if (onSeekStartListener2 != null) {
                onSeekStartListener2.onSeekStart();
            }
            seekToInternal(msec);
        }
    }

    public void seekTo(int msec, int seekmode) {
        if (msec >= 0 && getDuration() != 0) {
            printCommonLog(1, "seekTo");
            OnSeekStartListener onSeekStartListener2 = this.onSeekStartListener;
            if (onSeekStartListener2 != null) {
                onSeekStartListener2.onSeekStart();
            }
            seekToInternal(msec, seekmode);
        }
    }

    /* access modifiers changed from: protected */
    public void seekToInternal(int msec) {
        if (isInPlaybackState()) {
            this.mediaPlayer.seekTo((long) msec);
            this.seekWhenPrepared = 0;
            return;
        }
        this.seekWhenPrepared = msec;
    }

    /* access modifiers changed from: protected */
    public void seekToInternal(int msec, int seekmode) {
        if (isInPlaybackState()) {
            this.mediaPlayer.seekTo((long) msec, seekmode);
            this.seekWhenPrepared = 0;
            this.seekModeWhenPrepared = 3;
            return;
        }
        this.seekWhenPrepared = msec;
        this.seekModeWhenPrepared = seekmode;
    }

    public void setVolume(float percent) {
        DuMediaPlayer duMediaPlayer = this.mediaPlayer;
        if (duMediaPlayer != null) {
            duMediaPlayer.setVolume(percent, percent);
        }
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mediaPlayer.isPlaying();
    }

    public void setOnPreparedListener(DuMediaPlayStatus.OnPreparedListener listener) {
        this.onPreparedListener = listener;
    }

    public void setOnCompletionListener(DuMediaPlayStatus.OnCompletionListener listener) {
        this.onCompletionListener = listener;
    }

    public void setOnSeekStartListener(OnSeekStartListener listener) {
        this.onSeekStartListener = listener;
    }

    public void setOnSeekCompleteListener(DuMediaPlayStatus.OnSeekCompleteListener listener) {
        this.onSeekCompleteListener = listener;
    }

    public void setOnBufferingUpdateListener(DuMediaPlayStatus.OnBufferingUpdateListener listener) {
        this.onBufferingUpdateListener = listener;
    }

    public void setOnBufferingStartListener(OnBufferingStartListener listener) {
        this.onBufferingStartListener = listener;
    }

    public void setOnBufferingEndListener(OnBufferingEndListener listener) {
        this.onBufferingEndListener = listener;
    }

    public void setOnRenderStartListener(OnRenderStartListener listener) {
        this.onRenderStartListener = listener;
    }

    public void setOnSurfaceReadyListener(OnSurfaceReadyListener listener) {
        this.onSurfaceReadyListener = listener;
    }

    public void setOnVideoSizeChangedListener(DuMediaPlayStatus.OnVideoSizeChangedListener onVideoSizeChangeListener2) {
        this.onVideoSizeChangeListener = onVideoSizeChangeListener2;
    }

    public void setOnInfoListener(DuMediaPlayStatus.OnInfoListener listener) {
        this.onInfoListener = listener;
    }

    public void setOnMediaSourceChangedListener(DuMediaPlayStatus.OnMediaSourceChangedListener listener) {
    }

    public void setOnTouchListener(View.OnTouchListener l) {
        super.setOnTouchListener(l);
        this.onTouchListener = l;
    }

    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = listener;
    }

    public void setOnErrorListener(DuMediaPlayStatus.OnErrorListener listener) {
        this.onErrorListener = listener;
    }

    public void setOnPitchYawRollListener(OnPitchYawRollListener listener) {
        this.onPitchYawRoll = listener;
    }

    public boolean setFilterRegion(float left, float right, float top, float bottom) {
        return false;
    }

    public boolean setFilterEnable(DuMediaPlayConstants.DuMediaEffectFilter type, boolean enable) {
        return false;
    }

    public boolean setAllFilterEnable(boolean enable) {
        return false;
    }

    public boolean updateFilterConfig(List<FilterConfig> list) {
        return false;
    }

    public void setExternalSurface(Surface s) {
    }

    public void showDebugModeLayer(View anchor) {
    }

    public void debugShowOptions(View anchor) {
    }

    /* access modifiers changed from: protected */
    public void setCurPlayerState(PlayerState state) {
        this.curPlayerState = state;
    }

    /* access modifiers changed from: protected */
    public void printCommonLog(int level, String suffix) {
    }
}
