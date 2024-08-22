package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

@Keep
public class SupplementaryDIDManager {
    @Keep
    public static boolean DEBUG = false;
    @Keep
    public static final String TAG = "SupplementaryDIDManager";
    @Keep
    public boolean isBinded = false;
    @Keep
    public Context mContext;
    @Keep
    public IDidAidlInterface mDidService;
    @Keep
    public IDIDBinderStatusListener mListener;
    @Keep
    public ServiceConnection mServiceConnection = new ServiceConnection() {
        @Keep
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Keep
        public native void onServiceDisconnected(ComponentName componentName);
    };

    public SupplementaryDIDManager(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    @Keep
    public native void notifyAllListeners(boolean z);

    @Keep
    public native void deInit();

    @Keep
    public native void init(IDIDBinderStatusListener iDIDBinderStatusListener);

    @Keep
    public native void showLog(boolean z);
}
