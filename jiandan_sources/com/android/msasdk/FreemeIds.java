package com.android.msasdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.android.creator.IdsSupplier;

@Keep
public class FreemeIds implements FreemeIdsSupplier {
    @Keep
    public static final String TAG = "FreemeIds";
    @Keep
    public Context context;
    @Keep
    public IConnect iConnect;
    @Keep
    public IdsSupplier idsSupplier;
    @Keep
    public ServiceConnection mServiceConnection = new ServiceConnection() {
        @Keep
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Keep
        public native void onServiceDisconnected(ComponentName componentName);
    };

    public FreemeIds(Context context2) {
        this.context = context2;
    }

    @Keep
    public native void connect(IConnect iConnect2);

    @Keep
    public native String getAAID(String str);

    @Keep
    public native String getOAID();

    @Keep
    public native String getUDID(String str);

    @Keep
    public native String getVAID(String str);

    @Keep
    public native boolean isSupported();

    @Keep
    public native void shutDown();
}
