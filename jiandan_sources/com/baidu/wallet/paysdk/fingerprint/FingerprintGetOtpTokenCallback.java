package com.baidu.wallet.paysdk.fingerprint;

import java.io.Serializable;

public interface FingerprintGetOtpTokenCallback extends Serializable {
    void getOtpToken(String str);
}
