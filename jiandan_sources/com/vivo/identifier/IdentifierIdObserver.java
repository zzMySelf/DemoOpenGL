package com.vivo.identifier;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.Keep;

@Keep
public class IdentifierIdObserver extends ContentObserver {
    @Keep
    public static final String TAG = "VMS_SDK_Observer";
    @Keep
    public String mAppId;
    @Keep
    public IdentifierIdClient mIdentifierIdClient;
    @Keep
    public int mType;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i2, String str) {
        super((Handler) null);
        this.mIdentifierIdClient = identifierIdClient;
        this.mType = i2;
        this.mAppId = str;
    }

    @Keep
    public native void onChange(boolean z);
}
