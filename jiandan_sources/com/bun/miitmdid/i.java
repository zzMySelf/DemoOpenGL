package com.bun.miitmdid;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;

@Keep
public class i extends m implements IDIDBinderStatusListener {
    @Keep
    public final SupplementaryDIDManager n;

    public i(Context context) {
        this.n = new SupplementaryDIDManager(context);
    }

    @Keep
    public native IBinder asBinder();

    @Keep
    public native void doStart();

    @Keep
    public native boolean isSync();

    @Keep
    public native void onError();

    @Keep
    public native void onSuccess(IDidAidlInterface iDidAidlInterface);

    @Keep
    public native void shutDown();
}
