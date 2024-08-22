package com.baidu.wallet.paysdk.fingerprint;

import android.app.Activity;
import android.content.Context;
import java.io.Serializable;

public interface IFingerprintPay extends Serializable {

    public enum Action {
        OPEN,
        CLOSE,
        VERIFY
    }

    void close(Activity activity, FingerprintCallback fingerprintCallback);

    void closeFingerprint(Context context);

    void destory();

    void open(Activity activity, FingerprintCallback fingerprintCallback, boolean z);

    void verify(Activity activity, FingerprintCallback fingerprintCallback);
}
