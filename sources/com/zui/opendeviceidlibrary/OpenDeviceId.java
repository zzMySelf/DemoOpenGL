package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.zui.deviceidservice.IDeviceidInterface;

public class OpenDeviceId {
    private static boolean DBG = false;
    private static String TAG = "OpenDeviceId library";
    /* access modifiers changed from: private */
    public CallBack mCallerCallBack = null;
    private ServiceConnection mConnection;
    private Context mContext = null;
    /* access modifiers changed from: private */
    public IDeviceidInterface mDeviceidInterface;

    public interface CallBack<T> {
        void serviceConnected(T t, OpenDeviceId openDeviceId);
    }

    private native void logPrintE(String str);

    /* access modifiers changed from: private */
    public native void logPrintI(String str);

    public native String getAAID();

    public native String getOAID();

    public native String getUDID();

    public native String getVAID();

    public int init(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.mContext = context;
            this.mCallerCallBack = callBack;
            this.mConnection = new ServiceConnection() {
                public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

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

    public native boolean isSupported();

    public native void setLogEnable(boolean z);

    public native void shutdown();
}
