package com.baidu.cyberplayer.sdk.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.DuMediaNetBase;
import com.baidu.cyberplayer.sdk.DuMediaPlayConstants;
import com.baidu.cyberplayer.sdk.DuMediaPlayStatus;
import com.baidu.cyberplayer.sdk.InstallBase;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.context.ICyberMsgHandler;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayer;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import com.baidu.cyberplayer.sdk.statistics.DuMediaStatConstants;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemotePlayerClient extends PlayerProvider implements RemotePlayerFactory.RemoteServerListener {
    private static final int ASYNC_MESSAGE_ON_BUFFERING_UPDATE = 2;
    private static final int ASYNC_MESSAGE_ON_COMPLETION = 1;
    private static final int ASYNC_MESSAGE_ON_ERROR = 5;
    private static final int ASYNC_MESSAGE_ON_INFO = 6;
    private static final int ASYNC_MESSAGE_ON_MEDIASOURCE_CHANED = 7;
    private static final int ASYNC_MESSAGE_ON_MEDIA_RUNTIME_INFO = 8;
    private static final int ASYNC_MESSAGE_ON_PREPARED = 0;
    private static final int ASYNC_MESSAGE_ON_SEEK_COMPLETE = 3;
    private static final int ASYNC_MESSAGE_ON_VIDEO_SIZE_CHANGED = 4;
    private static final String TAG = "RemotePlayerClient";
    private PrivateHandler mAsyncMessageHandler;
    /* access modifiers changed from: private */
    public int mCurrentPosition = -1;
    /* access modifiers changed from: private */
    public int mDecodeMode;
    /* access modifiers changed from: private */
    public int mDuration = -1;
    /* access modifiers changed from: private */
    public boolean mEnableFirstDispSubThreadNotify = false;
    private DuMediaNetBase.HttpDNS mHttpDNS;
    private ICyberMsgHandler mInjectedHandler;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnMediaSourceChangedListener mMediaSourceChangedListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnBufferingUpdateListener mOnBufferingUpdateListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnCompletionListener mOnCompletionListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnErrorListener mOnErrorListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnInfoListener mOnInfoListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnMediaRuntimeInfoListener mOnMediaRuntimeInfoListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnPreparedListener mOnPreparedListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnSeekCompleteListener mOnSeekCompleteListener;
    /* access modifiers changed from: private */
    public DuMediaPlayStatus.OnVideoSizeChangedListener mOnVideoSizeChangeListener;
    private IRemotePlayer mRemotePlayer;
    private PrivateRemotePlayerCallback mRemotePlayerCallback;
    /* access modifiers changed from: private */
    public long mSeekToPosition = -1;
    private Surface mSurface;
    /* access modifiers changed from: private */
    public int mVideoHeight = 0;
    /* access modifiers changed from: private */
    public int mVideoWidth = 0;

    public static PlayerProvider create(int mode, DuMediaNetBase.HttpDNS dns) {
        IRemotePlayer remotePlayer;
        CyberLog.i(TAG, "create 1 remotePlayer begin thread:" + Thread.currentThread().getName() + " mainProcess:" + Utils.isMainProcess());
        IBinder binder = RemotePlayerFactory.getInstance().createPlayer(mode);
        if (binder == null || (remotePlayer = IRemotePlayer.Stub.asInterface(binder)) == null) {
            return null;
        }
        RemotePlayerClient client = null;
        if (remotePlayer != null) {
            client = new RemotePlayerClient(remotePlayer, mode, dns);
            if (client.mRemotePlayer == null) {
                client = null;
            }
        }
        CyberLog.i(TAG, "RemotePlayerClient createPlayer end,  client:" + client + " mainProcess:" + Utils.isMainProcess());
        return client;
    }

    private RemotePlayerClient(IRemotePlayer remotePlayer, int mode, DuMediaNetBase.HttpDNS dns) {
        this.mDecodeMode = mode;
        this.mHttpDNS = dns;
        this.mRemotePlayer = remotePlayer;
        this.mAsyncMessageHandler = new PrivateHandler(this, Looper.getMainLooper());
        if (InstallBase.getCyberMediaContext() != null) {
            this.mInjectedHandler = InstallBase.getCyberMediaContext().getCyberMsgHandler();
        }
        PrivateRemotePlayerCallback privateRemotePlayerCallback = new PrivateRemotePlayerCallback(this.mAsyncMessageHandler, this.mInjectedHandler, dns);
        this.mRemotePlayerCallback = privateRemotePlayerCallback;
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.addListener(privateRemotePlayerCallback);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                this.mRemotePlayer = null;
            }
        }
        if (this.mRemotePlayer != null) {
            RemotePlayerFactory.getInstance().addListener(this);
        }
    }

    public int getDecodeMode() {
        return this.mDecodeMode;
    }

    public void setDisplay(SurfaceHolder sh) {
        setSurface(sh != null ? sh.getSurface() : null);
    }

    public void setSurface(Surface surface) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            Surface surface2 = this.mSurface;
            if (surface2 != surface || surface2 == null) {
                try {
                    iRemotePlayer.setSurface(surface);
                    this.mSurface = surface;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError(-30000, -30000, "setSurface()");
                    }
                    this.mSurface = null;
                }
            }
        }
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
    }

    public void setDataSource(Uri uri, Map<String, String> headers) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setDataSource(new DuMediaRemoteDataSource(uri, headers));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setDataSource(Uri, Map)");
                }
            }
        }
    }

    public void prepareAsync() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.prepareAsync();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "prepareAsync()");
                }
            }
        }
    }

    public void start() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.start();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "start()");
                }
            }
        }
    }

    public void stop() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.stop();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void pause() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.pause();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "pause()");
                }
            }
        }
    }

    public void stepToNextFrame() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.stepToNextFrame();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setWakeMode(Context context, int mode) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setWakeMode(mode);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setWakeMode()");
                }
            }
        }
    }

    public void setScreenOnWhilePlaying(boolean screenOn) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setScreenOnWhilePlaying(screenOn);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setScreenOnWhilePlaying(boolean)");
                }
            }
        }
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public boolean isPlaying() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return false;
        }
        try {
            return iRemotePlayer.isPlaying();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean isRemotePlayer() {
        return true;
    }

    public void seekTo(long msec) {
        seekTo(msec, 3);
    }

    public void seekTo(long msec, int seekmode) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            this.mSeekToPosition = msec;
            try {
                iRemotePlayer.seekTo(msec, seekmode);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "seekTo(long)");
                }
            }
        }
    }

    public String getPlayerConfigOptions() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return "";
        }
        try {
            return iRemotePlayer.getPlayerConfigOptions();
        } catch (RemoteException e2) {
            return "";
        }
    }

    public String getDebugModeInfo() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return "";
        }
        try {
            return iRemotePlayer.getDebugModeInfo();
        } catch (RemoteException e2) {
            return "";
        }
    }

    public int getCurrentPosition() {
        long j2 = this.mSeekToPosition;
        if (j2 > -1) {
            return (int) j2;
        }
        if (this.mCurrentPosition > -1) {
            return this.mCurrentPosition;
        }
        return 0;
    }

    public int getCurrentPositionSync() {
        int ret = 0;
        long j2 = this.mSeekToPosition;
        if (j2 > -1) {
            return (int) j2;
        }
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return 0;
        }
        try {
            ret = iRemotePlayer.getCurrentPositionSync();
            this.mCurrentPosition = ret;
            return ret;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return ret;
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setClarityInfo(String info) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setClarityInfo(info);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void switchMediaSource(int id, DuMediaPlayConstants.DuMediaSourceSwitchMode mode) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.switchMediaSource(id, mode.ordinal());
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public long getPlayedTime() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return 0;
        }
        try {
            return iRemotePlayer.getPlayedTime();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public long getDownloadSpeed() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return 0;
        }
        try {
            return iRemotePlayer.getDownloadSpeed();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void resetPlayerValues() {
        this.mDuration = -1;
        this.mCurrentPosition = -1;
        this.mSeekToPosition = -1;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0088, code lost:
        if (r0 == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c5, code lost:
        if (r0 == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (r0 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r0.removeCallbacksAndMessages();
        r5.mInjectedHandler = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        r5.mHttpDNS = null;
        r5.mOnPreparedListener = null;
        r5.mOnCompletionListener = null;
        r5.mOnBufferingUpdateListener = null;
        r5.mOnSeekCompleteListener = null;
        r5.mOnVideoSizeChangeListener = null;
        r5.mOnInfoListener = null;
        r5.mMediaSourceChangedListener = null;
        r5.mOnErrorListener = null;
        resetPlayerValues();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r5 = this;
            java.lang.String r0 = "RemotePlayerClient"
            com.baidu.cyberplayer.sdk.remote.IRemotePlayer r1 = r5.mRemotePlayer
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            r2 = 0
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateRemotePlayerCallback r3 = r5.mRemotePlayerCallback     // Catch:{ IllegalStateException -> 0x008b, RemoteException -> 0x004e }
            r1.removeListener(r3)     // Catch:{ IllegalStateException -> 0x008b, RemoteException -> 0x004e }
            com.baidu.cyberplayer.sdk.remote.IRemotePlayer r1 = r5.mRemotePlayer     // Catch:{ IllegalStateException -> 0x008b, RemoteException -> 0x004e }
            r1.release()     // Catch:{ IllegalStateException -> 0x008b, RemoteException -> 0x004e }
            com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory r0 = com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.getInstance()
            r0.removeListener(r5)
            r5.mRemotePlayer = r2
            r5.mSurface = r2
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateHandler r0 = r5.mAsyncMessageHandler
            r0.removeCallbacksAndMessages(r2)
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateRemotePlayerCallback r0 = r5.mRemotePlayerCallback
            r0.release()
            r5.mRemotePlayerCallback = r2
            r5.mAsyncMessageHandler = r2
            com.baidu.cyberplayer.sdk.context.ICyberMsgHandler r0 = r5.mInjectedHandler
            if (r0 == 0) goto L_0x0034
        L_0x002f:
            r0.removeCallbacksAndMessages()
            r5.mInjectedHandler = r2
        L_0x0034:
            r5.mHttpDNS = r2
            r5.mOnPreparedListener = r2
            r5.mOnCompletionListener = r2
            r5.mOnBufferingUpdateListener = r2
            r5.mOnSeekCompleteListener = r2
            r5.mOnVideoSizeChangeListener = r2
            r5.mOnInfoListener = r2
            r5.mMediaSourceChangedListener = r2
            r5.mOnErrorListener = r2
            r5.resetPlayerValues()
            goto L_0x00c9
        L_0x004b:
            r0 = move-exception
            goto L_0x00ca
        L_0x004e:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x004b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r3.<init>()     // Catch:{ all -> 0x004b }
            java.lang.String r4 = "release() RemoteException!"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x004b }
            java.lang.String r4 = android.util.Log.getStackTraceString(r1)     // Catch:{ all -> 0x004b }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x004b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004b }
            com.baidu.cyberplayer.sdk.CyberLog.e(r0, r3)     // Catch:{ all -> 0x004b }
            com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory r0 = com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.getInstance()
            r0.removeListener(r5)
            r5.mRemotePlayer = r2
            r5.mSurface = r2
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateHandler r0 = r5.mAsyncMessageHandler
            r0.removeCallbacksAndMessages(r2)
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateRemotePlayerCallback r0 = r5.mRemotePlayerCallback
            r0.release()
            r5.mRemotePlayerCallback = r2
            r5.mAsyncMessageHandler = r2
            com.baidu.cyberplayer.sdk.context.ICyberMsgHandler r0 = r5.mInjectedHandler
            if (r0 == 0) goto L_0x0034
            goto L_0x002f
        L_0x008b:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x004b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r3.<init>()     // Catch:{ all -> 0x004b }
            java.lang.String r4 = "release() IllegalStateException! "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x004b }
            java.lang.String r4 = android.util.Log.getStackTraceString(r1)     // Catch:{ all -> 0x004b }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x004b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004b }
            com.baidu.cyberplayer.sdk.CyberLog.e(r0, r3)     // Catch:{ all -> 0x004b }
            com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory r0 = com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.getInstance()
            r0.removeListener(r5)
            r5.mRemotePlayer = r2
            r5.mSurface = r2
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateHandler r0 = r5.mAsyncMessageHandler
            r0.removeCallbacksAndMessages(r2)
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateRemotePlayerCallback r0 = r5.mRemotePlayerCallback
            r0.release()
            r5.mRemotePlayerCallback = r2
            r5.mAsyncMessageHandler = r2
            com.baidu.cyberplayer.sdk.context.ICyberMsgHandler r0 = r5.mInjectedHandler
            if (r0 == 0) goto L_0x0034
            goto L_0x002f
        L_0x00c9:
            return
        L_0x00ca:
            com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory r1 = com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.getInstance()
            r1.removeListener(r5)
            r5.mRemotePlayer = r2
            r5.mSurface = r2
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateHandler r1 = r5.mAsyncMessageHandler
            r1.removeCallbacksAndMessages(r2)
            com.baidu.cyberplayer.sdk.remote.RemotePlayerClient$PrivateRemotePlayerCallback r1 = r5.mRemotePlayerCallback
            r1.release()
            r5.mRemotePlayerCallback = r2
            r5.mAsyncMessageHandler = r2
            com.baidu.cyberplayer.sdk.context.ICyberMsgHandler r1 = r5.mInjectedHandler
            if (r1 == 0) goto L_0x00ec
            r1.removeCallbacksAndMessages()
            r5.mInjectedHandler = r2
        L_0x00ec:
            r5.mHttpDNS = r2
            r5.mOnPreparedListener = r2
            r5.mOnCompletionListener = r2
            r5.mOnBufferingUpdateListener = r2
            r5.mOnSeekCompleteListener = r2
            r5.mOnVideoSizeChangeListener = r2
            r5.mOnInfoListener = r2
            r5.mMediaSourceChangedListener = r2
            r5.mOnErrorListener = r2
            r5.resetPlayerValues()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.cyberplayer.sdk.remote.RemotePlayerClient.release():void");
    }

    public void reset() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.reset();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "reset()");
                }
            }
            resetPlayerValues();
        }
    }

    public void setLooping(boolean looping) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setLooping(looping);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setLooping(boolean)");
                }
            }
        }
    }

    public boolean isLooping() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return false;
        }
        try {
            return iRemotePlayer.isLooping();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setVolume(float leftVolume, float rightVolume) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setVolume(leftVolume, rightVolume);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setVolume(float, float)");
                }
            }
        }
    }

    public void changeProxyDynamic(String httpProxy, boolean enableAuth) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.changeProxyDynamic(httpProxy, enableAuth);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "changeProxyDynamic(String, boolean)");
                }
            }
        }
    }

    public void muteOrUnmuteAudio(boolean flag) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.muteOrUnmuteAudio(flag);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "muteOrUnmuteAudio(" + flag + ") binderState=" + RemotePlayerFactory.getInstance().getBinderState());
                }
            }
        }
    }

    public void setSpeed(float speed) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setSpeed(speed);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setSpeed(float)");
                }
            }
        }
    }

    public void setOption(String key, String value) {
        if (this.mRemotePlayer != null) {
            if (TextUtils.equals(key, DuMediaPlayConstants.DuMediaDataSourceOption.OPT_FIRST_DISP_NOTIFY_SUB_T)) {
                this.mEnableFirstDispSubThreadNotify = TextUtils.equals(value, "1");
            }
            try {
                this.mRemotePlayer.setOption(key, value);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setOption(String, String)");
                }
            }
        }
    }

    public void setOption(String key, long value) {
        setOption(key, String.valueOf(value));
    }

    public void setOptions(Map<String, String> options) {
        if (this.mRemotePlayer != null) {
            if (options != null && options.containsKey(DuMediaPlayConstants.DuMediaDataSourceOption.OPT_FIRST_DISP_NOTIFY_SUB_T)) {
                this.mEnableFirstDispSubThreadNotify = TextUtils.equals(options.get(DuMediaPlayConstants.DuMediaDataSourceOption.OPT_FIRST_DISP_NOTIFY_SUB_T), "1");
            }
            try {
                this.mRemotePlayer.setOptions(options);
            } catch (RemoteException e2) {
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setOptions(Map)");
                }
            }
        }
    }

    public void sendCommand(int what, int arg1, long arg2, String json) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.sendCommand(what, arg1, arg2, json);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "sendCommand what=" + what + " arg1=" + arg1 + " arg2=" + arg2 + " binderState=" + RemotePlayerFactory.getInstance().getBinderState());
                }
            }
        }
    }

    public void setEnableDumediaUA(boolean enable) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setEnableDumediaUA(enable);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                DuMediaPlayStatus.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(-30000, -30000, "setEnableDumediaUA(boolean)");
                }
            }
        }
    }

    public void updateDisplaySize(int width, int height) {
        try {
            IRemotePlayer iRemotePlayer = this.mRemotePlayer;
            if (iRemotePlayer != null) {
                iRemotePlayer.updateDisplaySize(width, height);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public boolean setFilterEnable(String filterName, boolean enable) {
        try {
            IRemotePlayer iRemotePlayer = this.mRemotePlayer;
            if (iRemotePlayer != null) {
                return iRemotePlayer.setFilterEnable(filterName, enable);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean updateFilterConfig(String filterName, String extraJson) {
        try {
            IRemotePlayer iRemotePlayer = this.mRemotePlayer;
            if (iRemotePlayer != null) {
                return iRemotePlayer.updateFilterConfig(filterName, extraJson);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
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

    public void getMediaRuntimeInfo(int type, DuMediaPlayStatus.OnMediaRuntimeInfoListener listener) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            this.mOnMediaRuntimeInfoListener = listener;
            try {
                iRemotePlayer.getMediaRuntimeInfo(type);
            } catch (Exception e2) {
            }
        }
    }

    public void binderDied() {
        PrivateHandler privateHandler = this.mAsyncMessageHandler;
        if (privateHandler != null) {
            Message msg = Message.obtain(privateHandler, 5);
            msg.arg1 = -30001;
            msg.arg2 = -30001;
            msg.obj = "binderState=" + RemotePlayerFactory.getInstance().getBinderState();
            ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
            if (iCyberMsgHandler != null) {
                iCyberMsgHandler.sendMessage(msg);
            } else {
                this.mAsyncMessageHandler.sendMessage(msg);
            }
        }
    }

    private static class PrivateHandler extends Handler {
        private final WeakReference<RemotePlayerClient> mWeakPlayer;

        private static void saveFirstDisplayInfoSendMessageCost(RemotePlayerClient player, String firstDispString) {
            Object notifyTimeStr;
            try {
                if (!TextUtils.isEmpty(firstDispString) && (notifyTimeStr = new JSONObject(firstDispString).get("first_disp_notify_time")) != null && (notifyTimeStr instanceof String)) {
                    long notifyTime = Long.parseLong((String) notifyTimeStr);
                    if (notifyTime > 0) {
                        long costTime = System.currentTimeMillis() - notifyTime;
                        CyberLog.i(RemotePlayerClient.TAG, "first screen msg notify costTime:" + costTime);
                        JSONObject notifyCostJsonObj = new JSONObject();
                        notifyCostJsonObj.put("notify_fsp_thread_cost", costTime);
                        player.sendCommand(1003, DuMediaStatConstants.SESSION_TYPE_FIRST_SCREEN, 0, notifyCostJsonObj.toString());
                    }
                }
            } catch (JSONException e2) {
            }
        }

        public PrivateHandler(RemotePlayerClient clientPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(clientPlayer);
        }

        public RemotePlayerClient getPlayer() {
            WeakReference<RemotePlayerClient> weakReference = this.mWeakPlayer;
            if (weakReference != null) {
                return (RemotePlayerClient) weakReference.get();
            }
            return null;
        }

        public void handleMessage(Message msg) {
            RemotePlayerClient player = (RemotePlayerClient) this.mWeakPlayer.get();
            if (player != null) {
                switch (msg.what) {
                    case 0:
                        if (player.mOnPreparedListener != null) {
                            player.mOnPreparedListener.onPrepared();
                            return;
                        }
                        return;
                    case 1:
                        if (player.mOnCompletionListener != null) {
                            player.mOnCompletionListener.onCompletion();
                            return;
                        }
                        return;
                    case 2:
                        if (player.mOnBufferingUpdateListener != null) {
                            player.mOnBufferingUpdateListener.onBufferingUpdate(msg.arg1);
                            return;
                        }
                        return;
                    case 3:
                        if (player.mOnSeekCompleteListener != null) {
                            player.mOnSeekCompleteListener.onSeekComplete();
                            return;
                        }
                        return;
                    case 4:
                        if (player.mOnVideoSizeChangeListener != null) {
                            int[] size = (int[]) msg.obj;
                            int unused = player.mVideoWidth = size[0];
                            int unused2 = player.mVideoHeight = size[1];
                            player.mOnVideoSizeChangeListener.onVideoSizeChanged(size[0], size[1], size[2], size[3]);
                            return;
                        }
                        return;
                    case 5:
                        if (player.mOnErrorListener != null) {
                            player.mOnErrorListener.onError(msg.arg1, msg.arg2, msg.obj);
                            return;
                        }
                        return;
                    case 6:
                        if (player.mOnInfoListener != null) {
                            player.mOnInfoListener.onInfo(msg.arg1, msg.arg2, msg.obj);
                        }
                        if (904 == msg.arg1) {
                            saveFirstDisplayInfoSendMessageCost(player, (String) msg.obj);
                            return;
                        } else if (910 == msg.arg1) {
                            int unused3 = player.mCurrentPosition = msg.arg2;
                            return;
                        } else {
                            return;
                        }
                    case 7:
                        if (player.mMediaSourceChangedListener != null) {
                            player.mMediaSourceChangedListener.onMediaSourceChanged(msg.arg1, msg.arg2, msg.obj);
                            return;
                        }
                        return;
                    case 8:
                        if (player.mOnMediaRuntimeInfoListener != null) {
                            player.mOnMediaRuntimeInfoListener.onRuntimeInfo((String) msg.obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private static class PrivateRemotePlayerCallback extends IRemotePlayerListener.Stub {
        private PrivateHandler mHandler;
        private DuMediaNetBase.HttpDNS mHttpDNS;
        private ICyberMsgHandler mInjectedHandler;

        public PrivateRemotePlayerCallback(PrivateHandler handler, ICyberMsgHandler injectedHandler, DuMediaNetBase.HttpDNS httpDNS) {
            this.mHandler = handler;
            this.mHttpDNS = httpDNS;
            this.mInjectedHandler = injectedHandler;
        }

        public void release() {
            this.mHandler = null;
            this.mHttpDNS = null;
        }

        public void onPrepared() {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendEmptyMessage(privateHandler, 0);
                } else {
                    privateHandler.sendEmptyMessage(0);
                }
            }
        }

        public synchronized void onCompletion() {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendEmptyMessage(privateHandler, 1);
                } else {
                    privateHandler.sendEmptyMessage(1);
                }
            }
        }

        public void onBufferingUpdate(int percent) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message msg = Message.obtain(privateHandler, 2);
                msg.arg1 = percent;
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(msg);
                } else {
                    this.mHandler.sendMessage(msg);
                }
            }
        }

        public void onSeekComplete() {
            RemotePlayerClient player = this.mHandler.getPlayer();
            if (player != null) {
                long unused = player.mSeekToPosition = -1;
            }
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendEmptyMessage(privateHandler, 3);
                } else {
                    privateHandler.sendEmptyMessage(3);
                }
            }
        }

        public void onVideoSizeChanged(int width, int height, int num, int den) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message msg = Message.obtain(privateHandler, 4);
                msg.obj = new int[]{width, height, num, den};
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(msg);
                } else {
                    this.mHandler.sendMessage(msg);
                }
            }
        }

        public boolean onError(int what, int extra, String detail) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler == null) {
                return true;
            }
            Message msg = Message.obtain(privateHandler, 5);
            msg.arg1 = what;
            msg.arg2 = extra;
            msg.obj = detail;
            ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
            if (iCyberMsgHandler != null) {
                iCyberMsgHandler.sendMessage(msg);
                return true;
            }
            this.mHandler.sendMessage(msg);
            return true;
        }

        public boolean onInfo(int what, int extra, String detail) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler == null) {
                return true;
            }
            RemotePlayerClient player = privateHandler.getPlayer();
            if (player != null) {
                switch (what) {
                    case 904:
                        if (player.mOnInfoListener != null && player.mEnableFirstDispSubThreadNotify) {
                            player.mOnInfoListener.onInfo(905, extra, detail);
                            break;
                        }
                    case 910:
                        int unused = player.mCurrentPosition = extra;
                        break;
                    case 10102:
                        int unused2 = player.mDecodeMode = extra;
                        break;
                    case DuMediaPlayConstants.DuMediaInfo.MEDIA_INFO_DURATION_CHANGED:
                        int unused3 = player.mDuration = extra;
                        return false;
                }
            }
            Message msg = Message.obtain(this.mHandler, 6);
            msg.arg1 = what;
            msg.arg2 = extra;
            msg.obj = detail;
            ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
            if (iCyberMsgHandler != null) {
                iCyberMsgHandler.sendMessage(msg);
                return true;
            }
            this.mHandler.sendMessage(msg);
            return true;
        }

        public boolean onMediaSourceChanged(int what, int extra, String detail) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler == null) {
                return true;
            }
            Message msg = Message.obtain(privateHandler, 7);
            msg.arg1 = what;
            msg.arg2 = extra;
            msg.obj = detail;
            ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
            if (iCyberMsgHandler != null) {
                iCyberMsgHandler.sendMessage(msg);
                return true;
            }
            this.mHandler.sendMessage(msg);
            return true;
        }

        public void onMediaRuntimeInfo(String info) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message msg = Message.obtain(privateHandler, 8);
                msg.obj = info;
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(msg);
                } else {
                    this.mHandler.sendMessage(msg);
                }
            }
        }

        public void onCallback(String what, List<String> values) {
            if (!"onHttpDNS".equals(what)) {
                return;
            }
            if (this.mHttpDNS != null && values != null && values.size() > 0) {
                values.clear();
                List<String> ipList = this.mHttpDNS.getIpList(values.get(0));
                if (ipList != null) {
                    values.addAll(ipList);
                }
            } else if (values != null) {
                values.clear();
            }
        }
    }
}
