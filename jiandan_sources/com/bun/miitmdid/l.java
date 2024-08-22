package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.android.msasdk.FreemeIdsSupplier;
import com.android.msasdk.IConnect;

@Keep
public class l extends m implements IConnect {
    @Keep
    public Context n;
    @Keep

    /* renamed from: o  reason: collision with root package name */
    public String f3768o;
    @Keep
    public FreemeIdsSupplier p;

    public l(Context context) {
        this.n = context;
    }

    @Keep
    public native void connectSuccess(boolean z);

    @Keep
    public native void doStart();

    @Keep
    public native void shutDown();
}
