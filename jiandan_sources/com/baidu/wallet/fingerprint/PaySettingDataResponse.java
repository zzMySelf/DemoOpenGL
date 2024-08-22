package com.baidu.wallet.fingerprint;

import com.dxmpay.wallet.core.NoProguard;

public class PaySettingDataResponse implements NoProguard {
    public ContentDTO content;
    public String msg;
    public String ret;

    public static class ContentDTO implements NoProguard {
        public FingerprintDTO fingerprint;

        public static class FingerprintDTO implements NoProguard {
            public String device_support;
            public String is_otp;
            public String user_reg;
        }
    }
}
