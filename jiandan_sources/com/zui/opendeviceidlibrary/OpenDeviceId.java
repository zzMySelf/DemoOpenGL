package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.zui.deviceidservice.IDeviceidInterface;

@Keep
public class OpenDeviceId {
    @Keep
    public static boolean DBG = false;
    @Keep
    public static String TAG = "OpenDeviceId library";
    @Keep
    public CallBack mCallerCallBack = null;
    @Keep
    public ServiceConnection mConnection;
    @Keep
    public Context mContext = null;
    @Keep
    public IDeviceidInterface mDeviceidInterface;

    @Keep
    public interface CallBack<T> {
        @Keep
        void serviceConnected(T t, OpenDeviceId openDeviceId);
    }

    @Keep
    private native void logPrintE(String str);

    /* access modifiers changed from: private */
    @Keep
    public native void logPrintI(String str);

    @Keep
    public native String getAAID();

    @Keep
    public native String getOAID();

    @Keep
    public native String getUDID();

    @Keep
    public native String getVAID();

    public int init(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.mContext = context;
            this.mCallerCallBack = callBack;
            this.mConnection = new ServiceConnection() {
                @Keep
                public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

                @Keep
                public native void onServiceDisconnected(ComponentName componentName);
            };
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.mContext.bindService(intent, this.mConnection, 1)) {
                logPrintI("bindService Successful!");
                return 1;
            }
            logPrintI("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    @Keep
    public native boolean isSupported();

    @Keep
    public native void setLogEnable(boolean z);

    @Keep
    public native void shutdown();
}
