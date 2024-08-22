package com.yy.transvod.p2p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.yy.transvod.p2p.subprocess.P2pManagerClient;
import com.yy.transvod.player.core.TransVodManager;
import com.yy.transvod.player.log.TLog;

public class P2pManager {
    private static final int MSG_SHARE_JSON_CONTENT = 2;
    private static final int MSG_SHARE_PCDN_UPDATE_RESULT = 3;
    private static final int MSG_SHARE_STATS = 1;
    private static final String TAG = "P2pManager";
    private static boolean mLoadLibSuccess;
    private static P2pManager sInstance = null;
    private long mHandle = 0;
    private Handler mLooperHandler = null;
    /* access modifiers changed from: private */
    public OnP2pShareStatsListener mP2pShareStatsListener = null;

    private static native void nativeClassInit();

    private native boolean nativeIsInited();

    private native void nativeSetAppId(long j2, String str);

    private native void nativeSetParameter(long j2, String str);

    private native void nativeSetShareStatsEnable(boolean z);

    private native void nativeSetup();

    private native void nativeUpdateAccountInfo(long j2, AccountInfo accountInfo);

    static {
        mLoadLibSuccess = false;
        if (TransVodManager.getLoadLibSuccess()) {
            try {
                Log.i(TAG, "loadLibrary: transvod_p2p");
                nativeClassInit();
                AccountInfo.nativeClassInit();
                mLoadLibSuccess = true;
            } catch (UnsatisfiedLinkError e2) {
                TLog.error(TAG, "LoadLibrary failed, UnsatisfiedLinkError " + e2.getMessage());
                mLoadLibSuccess = false;
            }
        }
    }

    public static boolean getLoadLibSuccess() {
        return mLoadLibSuccess;
    }

    public static P2pManager instance() {
        if (sInstance == null) {
            synchronized (P2pManager.class) {
                if (sInstance == null) {
                    sInstance = new P2pManager();
                }
            }
        }
        return sInstance;
    }

    public static boolean isInitialized() {
        if (sInstance == null) {
            return false;
        }
        return instance().nativeIsInited();
    }

    public static void setAppId(String appid) {
        if (mLoadLibSuccess) {
            instance().nativeSetAppId(instance().mHandle, appid);
        }
        P2pManagerClient.getInstance().setAppId(appid);
    }

    public static void updateAccountInfo(AccountInfo accountInfo) {
        if (mLoadLibSuccess) {
            instance().nativeUpdateAccountInfo(instance().mHandle, accountInfo);
        }
        P2pManagerClient.getInstance().updateAccountInfo(accountInfo);
    }

    public static void setParameter(String options) {
        if (mLoadLibSuccess) {
            instance().nativeSetParameter(instance().mHandle, options);
        }
        P2pManagerClient.getInstance().setParameter(options);
    }

    public static void setOnP2pShareStatsListener(OnP2pShareStatsListener listener, Looper looper) {
        instance().setOnP2pShareStatsListenerImpl(listener, looper);
        P2pManagerClient.getInstance().setOnP2pShareStatsListener(listener, looper);
    }

    public static void setShareStatsEnable(boolean enable) {
        if (mLoadLibSuccess) {
            instance().nativeSetShareStatsEnable(enable);
        }
        P2pManagerClient.getInstance().setShareStatsEnable(enable);
    }

    public static void subProcServerSetAppId(String appid) {
        if (mLoadLibSuccess) {
            instance().nativeSetAppId(instance().mHandle, appid);
        }
    }

    public static void subProcServerUpdateAccountInfo(AccountInfo accountInfo) {
        if (mLoadLibSuccess) {
            instance().nativeUpdateAccountInfo(instance().mHandle, accountInfo);
        }
    }

    public static void subProcServerSetParameter(String options) {
        if (mLoadLibSuccess) {
            instance().nativeSetParameter(instance().mHandle, options);
        }
    }

    public static void subProcServerSetOnP2pShareStatsListener(OnP2pShareStatsListener listener, Looper looper) {
        instance().setOnP2pShareStatsListenerImpl(listener, looper);
    }

    public static void subProcServerSetShareStatsEnable(boolean enable) {
        if (mLoadLibSuccess) {
            instance().nativeSetShareStatsEnable(enable);
        }
    }

    private P2pManager() {
        nativeSetup();
        TLog.info(TAG, "P2pManager begin");
    }

    private void setOnP2pShareStatsListenerImpl(OnP2pShareStatsListener listener, Looper looper) {
        synchronized (this) {
            Handler handler = this.mLooperHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                this.mLooperHandler = null;
            }
            this.mP2pShareStatsListener = listener;
            if (listener != null) {
                Looper myLooper = looper;
                if (myLooper == null) {
                    myLooper = Looper.getMainLooper();
                }
                this.mLooperHandler = new Handler(myLooper) {
                    public void handleMessage(Message msg) {
                        OnP2pShareStatsListener listener = P2pManager.this.mP2pShareStatsListener;
                        if (listener != null) {
                            switch (msg.what) {
                                case 1:
                                    ShareStats stats = (ShareStats) msg.obj;
                                    listener.onShareStats(stats.mPlayTaskId, stats.mShareUpStreamFlow, stats.mShareDownStreamFlow, stats.mServerDownStreamFlow);
                                    return;
                                case 2:
                                    listener.onJsonContent(msg.arg1, msg.arg2, (String) msg.obj);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                };
            }
        }
    }

    private void onP2pShareStats(int playTaskId, int shareUpStreamFlow, int shareDownStreamFlow, int serverDownStreamFlow) {
        OnP2pShareStatsListener listener;
        Handler handler;
        synchronized (this) {
            listener = this.mP2pShareStatsListener;
            handler = this.mLooperHandler;
        }
        if (listener != null && handler != null) {
            handler.sendMessage(Message.obtain(handler, 1, new ShareStats(playTaskId, shareUpStreamFlow, shareDownStreamFlow, serverDownStreamFlow)));
        }
    }

    private void onJsonContent(int playTaskId, int cbKey, String json) {
        OnP2pShareStatsListener listener;
        Handler handler;
        synchronized (this) {
            listener = this.mP2pShareStatsListener;
            handler = this.mLooperHandler;
        }
        if (listener != null && handler != null) {
            handler.sendMessage(Message.obtain(handler, 2, playTaskId, cbKey, json));
        }
    }

    private void onUpdatePcdnResult(int playTaskId, int result, String pcdnUrl) {
        OnP2pShareStatsListener listener;
        Handler handler;
        synchronized (this) {
            listener = this.mP2pShareStatsListener;
            handler = this.mLooperHandler;
        }
        if (listener != null && handler != null) {
            handler.sendMessage(Message.obtain(handler, 3, playTaskId, result, pcdnUrl));
        }
    }

    public void debug() {
        TLog.info(TAG, "P2pModule debug");
    }
}
