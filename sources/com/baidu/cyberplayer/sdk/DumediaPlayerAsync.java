package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.DuMediaNetBase;
import com.baidu.cyberplayer.sdk.DuMediaPlayConstants;
import com.baidu.cyberplayer.sdk.DuMediaPlayStatus;
import com.baidu.cyberplayer.sdk.config.DuMediaCfgConstants;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DumediaPlayerAsync extends PlayerProvider implements DuMediaPlayStatus.OnPreparedListener, DuMediaPlayStatus.OnCompletionListener, DuMediaPlayStatus.OnBufferingUpdateListener, DuMediaPlayStatus.OnSeekCompleteListener, DuMediaPlayStatus.OnVideoSizeChangedListener, DuMediaPlayStatus.OnErrorListener, DuMediaPlayStatus.OnInfoListener, DuMediaPlayStatus.OnMediaSourceChangedListener, DuMediaPlayStatus.OnMediaRuntimeInfoListener, DuMediaNetBase.HttpDNS {
    private static final int REQ_CHANGE_HTTTP_PROXY = 21;
    private static final int REQ_GET_MEDIA_RUNTIME_INFO_ASYNC = 38;
    private static final int REQ_MUTE_OR_UMMUTE = 20;
    private static final int REQ_PAUSE = 6;
    private static final int REQ_PREPARE_ASYNC = 10;
    private static final int REQ_RELEASE = 2;
    private static final int REQ_RESET = 3;
    private static final int REQ_SEEK_TO = 11;
    private static final int REQ_SEND_COMMAND = 36;
    private static final int REQ_SET_CLARITY_INFO = 27;
    private static final int REQ_SET_DATA_SOURCE_CONTENT_URI = 24;
    private static final int REQ_SET_DISPLAY_SIZE = 28;
    private static final int REQ_SET_ENABLE_DUMEDIA_UA = 37;
    private static final int REQ_SET_FILTER_ENABLE = 39;
    private static final int REQ_SET_LOOPING = 16;
    private static final int REQ_SET_OPTIONS_MAP = 34;
    private static final int REQ_SET_OPTION_STRING = 17;
    private static final int REQ_SET_SCREEN_ON = 32;
    private static final int REQ_SET_SPEED = 33;
    private static final int REQ_SET_UP = 12;
    private static final int REQ_SET_VIDEO_SURFACE = 14;
    private static final int REQ_SET_VOLUME = 22;
    private static final int REQ_SET_WAKE_MODE = 31;
    private static final int REQ_START = 7;
    private static final int REQ_STEP_PLAY = 30;
    private static final int REQ_STOP = 1;
    private static final int REQ_SWITCH_MEDIASOURCE = 29;
    private static final int REQ_UPDATE_FILTER = 40;
    private static final String TAG = "DumediaPlayerAsync";
    private int mDecodeMode;
    private boolean mEnableAdjustThreadPriority;
    private boolean mEnableRemote;
    private DuplayerHandlerThread mHandlerThread;
    private DuMediaNetBase.HttpDNS mHttpDNS;
    private boolean mIsLooping;
    private boolean mIsNeedCheckThread;
    private volatile boolean mIsRequestHandlerAlive = false;
    private DuMediaPlayStatus.OnMediaSourceChangedListener mMediaSourceChangedListener;
    private DuMediaPlayStatus.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private DuMediaPlayStatus.OnCompletionListener mOnCompletionListener;
    private DuMediaPlayStatus.OnErrorListener mOnErrorListener;
    private DuMediaPlayStatus.OnInfoListener mOnInfoListener;
    private DuMediaPlayStatus.OnMediaRuntimeInfoListener mOnMediaRuntimeInfoListener;
    private DuMediaPlayStatus.OnPreparedListener mOnPreparedListener;
    private DuMediaPlayStatus.OnSeekCompleteListener mOnSeekCompleteListener;
    private DuMediaPlayStatus.OnVideoSizeChangedListener mOnVideoSizeChangeListener;
    private volatile PlayerProvider mPlayer = null;
    private RequestHandler mRequestHandler;
    private long mSeekToPosition = -1;
    private Handler mUiThreadHandler;

    public static DumediaPlayerAsync create(int mode, DuMediaNetBase.HttpDNS dns, boolean remote) {
        CyberLog.i(TAG, "create player begin thread:" + Thread.currentThread().getName() + " isMainProcess:" + Utils.isMainProcess());
        if (Thread.currentThread() != Looper.getMainLooper().getThread() || !Utils.isMainProcess()) {
            return null;
        }
        DumediaPlayerAsync asyncPlayer = new DumediaPlayerAsync(mode, dns, remote);
        if (!asyncPlayer.isUsedHandlerThread()) {
            if (asyncPlayer.mHandlerThread != null) {
                DuplayerHandlerThreadPool.getInstance().recycle(asyncPlayer.mHandlerThread);
            }
            CyberLog.i(TAG, "create fail, checkRequestHandler");
            return null;
        } else if (!asyncPlayer.sendMessage(12, mode, 0, (Object) null)) {
            CyberLog.i(TAG, "create sendMessage REQ_SET_UP failed");
            return null;
        } else {
            CyberLog.i(TAG, "create Async Player success! asyncPlayer:" + asyncPlayer);
            return asyncPlayer;
        }
    }

    private DumediaPlayerAsync(int mode, DuMediaNetBase.HttpDNS httpDNS, boolean remote) {
        this.mDecodeMode = mode;
        this.mHttpDNS = httpDNS;
        this.mEnableRemote = remote;
        this.mEnableAdjustThreadPriority = PlayerConfigManager.getFast(DuMediaCfgConstants.KEY_ENABLE_ADJUST_REMOTE_THREAD_PRORITY, true);
        this.mIsNeedCheckThread = PlayerConfigManager.getFast(DuMediaCfgConstants.KEY_ENABLE_ASYNC_PLAYER_THREAD_CHECK, true);
        DuplayerHandlerThread obtain = DuplayerHandlerThreadPool.getInstance().obtain();
        this.mHandlerThread = obtain;
        if (obtain.getLooper() != null) {
            this.mRequestHandler = new RequestHandler(this, this.mHandlerThread.getLooper());
            CyberLog.i(TAG, "create player in main thread, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.mHandlerThread.getName() + " mRequestHandler:" + this.mRequestHandler);
            this.mIsRequestHandlerAlive = true;
        }
        this.mUiThreadHandler = new Handler(Looper.getMainLooper());
    }

    private boolean isUsedHandlerThread() {
        return (this.mHandlerThread == null || this.mRequestHandler == null || !this.mIsRequestHandlerAlive) ? false : true;
    }

    /* access modifiers changed from: private */
    public boolean isEnableAdjustThreadPriority() {
        return this.mEnableAdjustThreadPriority;
    }

    /* access modifiers changed from: private */
    public PlayerProvider createSyncPlayer(int decodeMode) {
        PlayerProvider player = PlayerProviderFactory.getInstance().create(decodeMode, this, this.mEnableRemote, false, (Looper) null);
        CyberLog.i(TAG, "createSyncPlayer player:" + player);
        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnBufferingUpdateListener(this);
        player.setOnSeekCompleteListener(this);
        player.setOnVideoSizeChangedListener(this);
        player.setOnErrorListener(this);
        player.setOnInfoListener(this);
        player.setOnMediaSourceChangedListener(this);
        return player;
    }

    /* access modifiers changed from: private */
    public void setPlayer(PlayerProvider player) {
        this.mPlayer = player;
    }

    public PlayerProvider getPlayer() {
        return this.mPlayer;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        RequestHandler requestHandler;
        super.finalize();
        if (this.mIsRequestHandlerAlive && (requestHandler = this.mRequestHandler) != null) {
            requestHandler.removeCallbacksAndMessages((Object) null);
        }
        if (!sendEmptyMessage(2)) {
            quitRequestHandlerThread();
        }
    }

    private boolean sendEmptyMessage(int msg) {
        RequestHandler requestHandler;
        if (!this.mIsRequestHandlerAlive || (requestHandler = this.mRequestHandler) == null) {
            return false;
        }
        requestHandler.sendEmptyMessage(msg);
        return true;
    }

    private boolean sendMessage(int what, int arg1, int arg2, Object obj) {
        RequestHandler requestHandler;
        if (!this.mIsRequestHandlerAlive || (requestHandler = this.mRequestHandler) == null) {
            return false;
        }
        this.mRequestHandler.sendMessage(requestHandler.obtainMessage(what, arg1, arg2, obj));
        return true;
    }

    private boolean checkMainThread() {
        if (!this.mIsNeedCheckThread || Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public synchronized void quitRequestHandlerThread() {
        CyberLog.i(TAG, "quitRequestHandlerThread called mIsRequestHandlerAlive:" + this.mIsRequestHandlerAlive);
        if (this.mIsRequestHandlerAlive) {
            RequestHandler requestHandler = this.mRequestHandler;
            if (requestHandler != null) {
                requestHandler.removeCallbacksAndMessages((Object) null);
            }
            DuplayerHandlerThreadPool.getInstance().recycle(this.mHandlerThread);
            this.mHandlerThread = null;
            this.mIsRequestHandlerAlive = false;
        }
    }

    public int getDecodeMode() {
        if (this.mPlayer != null) {
            this.mDecodeMode = this.mPlayer.getDecodeMode();
        }
        return this.mDecodeMode;
    }

    public void setDisplay(SurfaceHolder sh) {
        setSurface(sh != null ? sh.getSurface() : null);
    }

    public void setSurface(Surface surface) {
        sendMessage(14, 0, 0, surface);
    }

    public void setDataSource(Context context, Uri uri) {
        setDataSource(uri, (Map<String, String>) null);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> headers) {
        setDataSource(uri, headers);
    }

    public void setDataSource(String path) {
        setDataSource(Uri.parse(path), (Map<String, String>) null);
    }

    public void setDataSource(String path, Map<String, String> headers) {
        setDataSource(Uri.parse(path), headers);
    }

    public void setDataSource(FileDescriptor fd) {
        DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(-30000, -30000, "setDataSource(FileDescriptor)");
        }
        CyberLog.e(TAG, "setDataSource(FileDescriptor) failed. not implement!");
    }

    private void setDataSource(Uri uri, Map<String, String> headers) {
        sendMessage(24, -1, -1, getArrayListParams(uri, headers));
        CyberLog.i(TAG, "setDataSource called. uri:" + uri.toString() + " headers:" + headers);
    }

    public void prepareAsync() {
        sendEmptyMessage(10);
    }

    public void start() {
        sendEmptyMessage(7);
    }

    public void stop() {
        sendEmptyMessage(1);
    }

    public void pause() {
        sendEmptyMessage(6);
    }

    public void stepToNextFrame() {
        sendEmptyMessage(30);
    }

    public void setWakeMode(Context context, int mode) {
        sendMessage(31, mode, 0, context);
    }

    public void setScreenOnWhilePlaying(boolean screenOn) {
        sendMessage(32, screenOn, 0, (Object) null);
    }

    public int getVideoWidth() {
        if (this.mPlayer != null) {
            return this.mPlayer.getVideoWidth();
        }
        return 0;
    }

    public int getVideoHeight() {
        if (this.mPlayer != null) {
            return this.mPlayer.getVideoHeight();
        }
        return 0;
    }

    public boolean isPlaying() {
        if (this.mPlayer != null) {
            return this.mPlayer.isPlaying();
        }
        return false;
    }

    public boolean isRemotePlayer() {
        if (this.mPlayer != null) {
            return this.mPlayer.isRemotePlayer();
        }
        return true;
    }

    public void seekTo(long msec) {
        seekTo(msec, 3);
    }

    public void seekTo(long msec, int seekmode) {
        this.mSeekToPosition = msec;
        sendMessage(11, seekmode, 0, Long.valueOf(msec));
    }

    public String getPlayerConfigOptions() {
        if (this.mPlayer != null) {
            return this.mPlayer.getPlayerConfigOptions();
        }
        return "";
    }

    public String getDebugModeInfo() {
        if (this.mPlayer != null) {
            return this.mPlayer.getDebugModeInfo();
        }
        return "";
    }

    public int getCurrentPosition() {
        if (this.mPlayer != null) {
            return this.mPlayer.getCurrentPosition();
        }
        long j2 = this.mSeekToPosition;
        if (j2 > -1) {
            return (int) j2;
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        if (this.mPlayer != null) {
            return this.mPlayer.getCurrentPositionSync();
        }
        long j2 = this.mSeekToPosition;
        if (j2 > -1) {
            return (int) j2;
        }
        return 0;
    }

    public int getDuration() {
        if (this.mPlayer != null) {
            return this.mPlayer.getDuration();
        }
        return -1;
    }

    public void setClarityInfo(String info) {
        sendMessage(27, 0, 0, info);
    }

    public void switchMediaSource(int id, DuMediaPlayConstants.DuMediaSourceSwitchMode mode) {
        sendMessage(29, id, mode.ordinal(), (Object) null);
    }

    public long getPlayedTime() {
        if (this.mPlayer != null) {
            return this.mPlayer.getPlayedTime();
        }
        return 0;
    }

    public long getDownloadSpeed() {
        if (this.mPlayer != null) {
            return this.mPlayer.getDownloadSpeed();
        }
        return 0;
    }

    public boolean setFilterEnable(String filterName, boolean enable) {
        sendMessage(39, (int) enable, 0, filterName);
        return true;
    }

    public boolean updateFilterConfig(String filterName, String extraJson) {
        ArrayList<String> params = new ArrayList<>();
        params.add(filterName);
        params.add(extraJson);
        sendMessage(40, 0, 0, params);
        return true;
    }

    public void release() {
        RequestHandler requestHandler;
        this.mOnPreparedListener = null;
        this.mOnCompletionListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangeListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mMediaSourceChangedListener = null;
        this.mOnMediaRuntimeInfoListener = null;
        this.mHttpDNS = null;
        if (this.mIsRequestHandlerAlive && (requestHandler = this.mRequestHandler) != null) {
            requestHandler.removeCallbacksAndMessages((Object) null);
        }
        sendEmptyMessage(2);
    }

    private void resetPlayerValues() {
        this.mSeekToPosition = -1;
        this.mIsLooping = false;
    }

    public void reset() {
        RequestHandler requestHandler;
        RequestHandler requestHandler2;
        if (this.mPlayer != null) {
            if (this.mIsRequestHandlerAlive && (requestHandler2 = this.mRequestHandler) != null) {
                requestHandler2.removeCallbacksAndMessages((Object) null);
            }
        } else if (this.mIsRequestHandlerAlive && (requestHandler = this.mRequestHandler) != null) {
            requestHandler.removeMessages(10);
            this.mRequestHandler.removeMessages(11);
            this.mRequestHandler.removeMessages(24);
        }
        resetPlayerValues();
        sendEmptyMessage(3);
    }

    public void setLooping(boolean looping) {
        this.mIsLooping = looping;
        sendMessage(16, looping, 0, (Object) null);
        CyberLog.i(TAG, "setLooping: " + looping);
    }

    public boolean isLooping() {
        boolean ret;
        if (this.mPlayer != null) {
            ret = this.mPlayer.isLooping();
        } else {
            ret = this.mIsLooping;
        }
        CyberLog.i(TAG, "isLooping: " + ret);
        return ret;
    }

    public void setVolume(float leftVolume, float rightVolume) {
        Bundle bundle = new Bundle();
        bundle.putFloat("left", leftVolume);
        bundle.putFloat("right", rightVolume);
        sendMessage(22, 0, 0, bundle);
    }

    public void changeProxyDynamic(String httpProxy, boolean enableAuth) {
        sendMessage(21, enableAuth, 0, httpProxy);
    }

    public void muteOrUnmuteAudio(boolean flag) {
        sendMessage(20, flag, 0, (Object) null);
    }

    public void setSpeed(float speed) {
        sendMessage(33, 0, 0, Float.valueOf(speed));
    }

    public void setOption(String key, String value) {
        sendMessage(17, 0, 0, getArrayListParams(key, value));
    }

    public void setOption(String key, long value) {
        setOption(key, String.valueOf(value));
    }

    public void setOptions(Map<String, String> options) {
        sendMessage(34, 0, 0, options);
        CyberLog.i(TAG, "setOptions options: " + options);
    }

    public void sendCommand(int what, int arg1, long arg2, String json) {
        sendMessage(36, what, arg1, getArrayListParams(Long.valueOf(arg2), json));
    }

    public void setEnableDumediaUA(boolean enable) {
        sendMessage(37, enable, 0, (Object) null);
    }

    public void getMediaRuntimeInfo(int type, DuMediaPlayStatus.OnMediaRuntimeInfoListener listener) {
        this.mOnMediaRuntimeInfoListener = listener;
        sendMessage(38, type, 0, (Object) null);
    }

    public void updateDisplaySize(int width, int height) {
        sendMessage(28, width, height, (Object) null);
        CyberLog.i(TAG, "updateDisplaySize width: " + width + " height:" + height);
    }

    public void setOnPreparedListener(DuMediaPlayStatus.OnPreparedListener listener) {
        this.mOnPreparedListener = listener;
    }

    public void setOnCompletionListener(DuMediaPlayStatus.OnCompletionListener listener) {
        this.mOnCompletionListener = listener;
    }

    public void setOnBufferingUpdateListener(DuMediaPlayStatus.OnBufferingUpdateListener listener) {
        this.mOnBufferingUpdateListener = listener;
    }

    public void setOnSeekCompleteListener(DuMediaPlayStatus.OnSeekCompleteListener listener) {
        this.mOnSeekCompleteListener = listener;
    }

    public void setOnVideoSizeChangedListener(DuMediaPlayStatus.OnVideoSizeChangedListener listener) {
        this.mOnVideoSizeChangeListener = listener;
    }

    public void setOnErrorListener(DuMediaPlayStatus.OnErrorListener listener) {
        this.mOnErrorListener = listener;
    }

    public void setOnInfoListener(DuMediaPlayStatus.OnInfoListener listener) {
        this.mOnInfoListener = listener;
    }

    public void setOnMediaSourceChangedListener(DuMediaPlayStatus.OnMediaSourceChangedListener listener) {
        this.mMediaSourceChangedListener = listener;
    }

    private void runOnMainThread(Runnable runnable) {
        Handler handler;
        if (runnable != null && (handler = this.mUiThreadHandler) != null) {
            handler.post(runnable);
        }
    }

    public void onPrepared() {
        if (checkMainThread()) {
            DuMediaPlayStatus.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
                return;
            }
            return;
        }
        final DuMediaPlayStatus.OnPreparedListener listener = this.mOnPreparedListener;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnPreparedListener onPreparedListener = listener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared();
                }
            }
        });
    }

    public void onCompletion() {
        if (checkMainThread()) {
            DuMediaPlayStatus.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion();
                return;
            }
            return;
        }
        final DuMediaPlayStatus.OnCompletionListener listener = this.mOnCompletionListener;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnCompletionListener onCompletionListener = listener;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion();
                }
            }
        });
    }

    public void onVideoSizeChanged(int width, int height, int num, int den) {
        if (checkMainThread()) {
            DuMediaPlayStatus.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangeListener;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(width, height, num, den);
                return;
            }
            return;
        }
        final DuMediaPlayStatus.OnVideoSizeChangedListener onVideoSizeChangedListener2 = this.mOnVideoSizeChangeListener;
        final int i2 = width;
        final int i3 = height;
        final int i4 = num;
        final int i5 = den;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnVideoSizeChangedListener onVideoSizeChangedListener = onVideoSizeChangedListener2;
                if (onVideoSizeChangedListener != null) {
                    onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
                }
            }
        });
    }

    public void onSeekComplete() {
        this.mSeekToPosition = -1;
        if (checkMainThread()) {
            DuMediaPlayStatus.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete();
                return;
            }
            return;
        }
        final DuMediaPlayStatus.OnSeekCompleteListener listener = this.mOnSeekCompleteListener;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnSeekCompleteListener onSeekCompleteListener = listener;
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete();
                }
            }
        });
    }

    public void onBufferingUpdate(final int percent) {
        if (checkMainThread()) {
            DuMediaPlayStatus.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener.onBufferingUpdate(percent);
                return;
            }
            return;
        }
        final DuMediaPlayStatus.OnBufferingUpdateListener listener = this.mOnBufferingUpdateListener;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnBufferingUpdateListener onBufferingUpdateListener = listener;
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(percent);
                }
            }
        });
    }

    public boolean onError(int what, int extra, Object obj) {
        if (checkMainThread()) {
            DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                return onErrorListener.onError(what, extra, obj);
            }
            return false;
        }
        final DuMediaPlayStatus.OnErrorListener onErrorListener2 = this.mOnErrorListener;
        final int i2 = what;
        final int i3 = extra;
        final Object obj2 = obj;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnErrorListener onErrorListener = onErrorListener2;
                if (onErrorListener != null) {
                    onErrorListener.onError(i2, i3, obj2);
                }
            }
        });
        return false;
    }

    public boolean onInfo(int what, int extra, Object obj) {
        if (checkMainThread() || what == 905) {
            DuMediaPlayStatus.OnInfoListener listener = this.mOnInfoListener;
            if (listener != null) {
                return listener.onInfo(what, extra, obj);
            }
            return false;
        }
        final DuMediaPlayStatus.OnInfoListener onInfoListener = this.mOnInfoListener;
        final int i2 = what;
        final int i3 = extra;
        final Object obj2 = obj;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnInfoListener onInfoListener = onInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(i2, i3, obj2);
                }
            }
        });
        return false;
    }

    public boolean onMediaSourceChanged(int result, int rank, Object obj) {
        if (checkMainThread()) {
            DuMediaPlayStatus.OnMediaSourceChangedListener onMediaSourceChangedListener = this.mMediaSourceChangedListener;
            if (onMediaSourceChangedListener != null) {
                return onMediaSourceChangedListener.onMediaSourceChanged(result, rank, obj);
            }
            return false;
        }
        final DuMediaPlayStatus.OnMediaSourceChangedListener onMediaSourceChangedListener2 = this.mMediaSourceChangedListener;
        final int i2 = result;
        final int i3 = rank;
        final Object obj2 = obj;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnMediaSourceChangedListener onMediaSourceChangedListener = onMediaSourceChangedListener2;
                if (onMediaSourceChangedListener != null) {
                    onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj2);
                }
            }
        });
        return false;
    }

    public void onRuntimeInfo(final String info) {
        if (checkMainThread()) {
            DuMediaPlayStatus.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener = this.mOnMediaRuntimeInfoListener;
            if (onMediaRuntimeInfoListener != null) {
                onMediaRuntimeInfoListener.onRuntimeInfo(info);
                return;
            }
            return;
        }
        final DuMediaPlayStatus.OnMediaRuntimeInfoListener listener = this.mOnMediaRuntimeInfoListener;
        runOnMainThread(new Runnable() {
            public void run() {
                DuMediaPlayStatus.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener = listener;
                if (onMediaRuntimeInfoListener != null) {
                    onMediaRuntimeInfoListener.onRuntimeInfo(info);
                }
            }
        });
    }

    public List<String> getIpList(String hostname) {
        DuMediaNetBase.HttpDNS httpDNS = this.mHttpDNS;
        if (httpDNS != null) {
            return httpDNS.getIpList(hostname);
        }
        return null;
    }

    private ArrayList<Object> getArrayListParams(Object... objects) {
        ArrayList<Object> params = new ArrayList<>();
        for (Object object : objects) {
            params.add(object);
        }
        return params;
    }

    private static class RequestHandler extends Handler {
        private PlayerProvider mHandlePlayer;
        private final WeakReference<DumediaPlayerAsync> mWeakPlayer;

        public RequestHandler(DumediaPlayerAsync mp, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(mp);
        }

        public void handleMessage(Message msg) {
            DumediaPlayerAsync asyncPlayer = (DumediaPlayerAsync) this.mWeakPlayer.get();
            if (asyncPlayer == null || (this.mHandlePlayer == null && msg.what != 12)) {
                CyberLog.e(DumediaPlayerAsync.TAG, "IjkMediaPlayer went away with unhandled events msg.what:" + msg.what);
                return;
            }
            boolean z = false;
            switch (msg.what) {
                case 1:
                    this.mHandlePlayer.stop();
                    return;
                case 2:
                    asyncPlayer.setPlayer((PlayerProvider) null);
                    this.mHandlePlayer.release();
                    this.mHandlePlayer = null;
                    CyberLog.i(DumediaPlayerAsync.TAG, "REQ_RELEASE 1 current Thread:" + Thread.currentThread().getName());
                    if (asyncPlayer.isEnableAdjustThreadPriority()) {
                        Thread.currentThread().setPriority(5);
                    }
                    CyberLog.i(DumediaPlayerAsync.TAG, "REQ_RELEASE 2 current Thread:" + Thread.currentThread().getName());
                    asyncPlayer.quitRequestHandlerThread();
                    return;
                case 3:
                    this.mHandlePlayer.reset();
                    return;
                case 6:
                    this.mHandlePlayer.pause();
                    return;
                case 7:
                    this.mHandlePlayer.start();
                    return;
                case 10:
                    this.mHandlePlayer.prepareAsync();
                    return;
                case 11:
                    if (msg.obj == null || !(msg.obj instanceof Long)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SEEK_TO: msg is Invalid Parameters:" + msg.obj);
                        return;
                    } else {
                        this.mHandlePlayer.seekTo(((Long) msg.obj).longValue(), msg.arg1);
                        return;
                    }
                case 12:
                    CyberLog.i(DumediaPlayerAsync.TAG, "REQ_SET_UP current Thread:" + Thread.currentThread().getName());
                    if (asyncPlayer.isEnableAdjustThreadPriority()) {
                        Thread.currentThread().setPriority(10);
                    }
                    if (this.mHandlePlayer == null) {
                        this.mHandlePlayer = asyncPlayer.createSyncPlayer(msg.arg1);
                    }
                    asyncPlayer.setPlayer(this.mHandlePlayer);
                    return;
                case 14:
                    this.mHandlePlayer.setSurface((Surface) msg.obj);
                    return;
                case 16:
                    PlayerProvider playerProvider = this.mHandlePlayer;
                    if (msg.arg1 == 1) {
                        z = true;
                    }
                    playerProvider.setLooping(z);
                    return;
                case 17:
                    if (msg.obj == null || !(msg.obj instanceof ArrayList)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SET_OPTION_STRING: msg is Invalid Parameters:" + msg.obj);
                        return;
                    }
                    ArrayList<String> params = (ArrayList) msg.obj;
                    this.mHandlePlayer.setOption(params.get(0), params.get(1));
                    return;
                case 20:
                    PlayerProvider playerProvider2 = this.mHandlePlayer;
                    if (msg.arg1 == 1) {
                        z = true;
                    }
                    playerProvider2.muteOrUnmuteAudio(z);
                    return;
                case 21:
                    if (msg.obj == null || !(msg.obj instanceof String)) {
                        PlayerProvider playerProvider3 = this.mHandlePlayer;
                        if (msg.arg1 == 1) {
                            z = true;
                        }
                        playerProvider3.changeProxyDynamic((String) null, z);
                        return;
                    }
                    PlayerProvider playerProvider4 = this.mHandlePlayer;
                    String str = (String) msg.obj;
                    if (msg.arg1 == 1) {
                        z = true;
                    }
                    playerProvider4.changeProxyDynamic(str, z);
                    return;
                case 22:
                    if (msg.obj == null || !(msg.obj instanceof Bundle)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SET_VOLUME: msg is Invalid Parameters:" + msg.obj);
                        return;
                    }
                    Bundle data = (Bundle) msg.obj;
                    this.mHandlePlayer.setVolume(data.getFloat("left"), data.getFloat("right"));
                    return;
                case 24:
                    if (msg.obj == null || !(msg.obj instanceof ArrayList)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SET_DATA_SOURCE_CONTENT_URI: msg is Invalid Parameters:" + msg.obj);
                        return;
                    }
                    ArrayList<Object> params2 = (ArrayList) msg.obj;
                    this.mHandlePlayer.setDataSource(InstallBase.getApplicationContext(), (Uri) params2.get(0), (Map) params2.get(1));
                    return;
                case 27:
                    if (msg.obj == null || !(msg.obj instanceof String)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SET_CLARITY_INFO: msg is Invalid Parameters:" + msg.obj);
                        return;
                    } else {
                        this.mHandlePlayer.setClarityInfo((String) msg.obj);
                        return;
                    }
                case 28:
                    this.mHandlePlayer.updateDisplaySize(msg.arg1, msg.arg2);
                    return;
                case 29:
                    CyberLog.i(DumediaPlayerAsync.TAG, "REQ_SWITCH_MEDIASOURCE id: " + msg.arg1 + ", mode:" + msg.arg2);
                    int index = msg.arg2;
                    DuMediaPlayConstants.DuMediaSourceSwitchMode mode = DuMediaPlayConstants.DuMediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE;
                    DuMediaPlayConstants.DuMediaSourceSwitchMode[] modes = DuMediaPlayConstants.DuMediaSourceSwitchMode.values();
                    if (index >= 0 && index < modes.length) {
                        mode = modes[index];
                    }
                    this.mHandlePlayer.switchMediaSource(msg.arg1, mode);
                    return;
                case 30:
                    this.mHandlePlayer.stepToNextFrame();
                    return;
                case 31:
                    this.mHandlePlayer.setWakeMode((Context) msg.obj, msg.arg1);
                    return;
                case 32:
                    PlayerProvider playerProvider5 = this.mHandlePlayer;
                    if (msg.arg1 == 1) {
                        z = true;
                    }
                    playerProvider5.setScreenOnWhilePlaying(z);
                    return;
                case 33:
                    if (msg.obj == null || !(msg.obj instanceof Float)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SET_SPEED: msg is Invalid Parameters:" + msg.obj);
                        return;
                    } else {
                        this.mHandlePlayer.setSpeed(((Float) msg.obj).floatValue());
                        return;
                    }
                case 34:
                    if (msg.obj == null || !(msg.obj instanceof Map)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SET_OPTIONS_MAP: msg is Invalid Parameters:" + msg.obj);
                        return;
                    }
                    this.mHandlePlayer.setOptions((Map) msg.obj);
                    return;
                case 36:
                    if (msg.obj == null || !(msg.obj instanceof ArrayList)) {
                        CyberLog.e(DumediaPlayerAsync.TAG, "REQ_SEND_COMMAND: msg obj is Invalid Parameters:" + msg.obj);
                        return;
                    }
                    ArrayList<Object> params3 = (ArrayList) msg.obj;
                    this.mHandlePlayer.sendCommand(msg.arg1, msg.arg2, ((Long) params3.get(0)).longValue(), (String) params3.get(1));
                    return;
                case 37:
                    PlayerProvider playerProvider6 = this.mHandlePlayer;
                    if (msg.arg1 == 1) {
                        z = true;
                    }
                    playerProvider6.setEnableDumediaUA(z);
                    return;
                case 38:
                    this.mHandlePlayer.getMediaRuntimeInfo(msg.arg1, asyncPlayer);
                    return;
                case 39:
                    CyberLog.i(DumediaPlayerAsync.TAG, "set filter " + ((String) msg.obj) + ", enable:" + msg.arg1);
                    PlayerProvider playerProvider7 = this.mHandlePlayer;
                    String str2 = (String) msg.obj;
                    if (msg.arg1 == 1) {
                        z = true;
                    }
                    playerProvider7.setFilterEnable(str2, z);
                    return;
                case 40:
                    if (msg.obj != null && (msg.obj instanceof ArrayList)) {
                        ArrayList<String> params4 = (ArrayList) msg.obj;
                        this.mHandlePlayer.updateFilterConfig(params4.get(0), params4.get(1));
                        return;
                    }
                    return;
                default:
                    CyberLog.e(DumediaPlayerAsync.TAG, "Unknown message type " + msg.what);
                    return;
            }
        }
    }
}
