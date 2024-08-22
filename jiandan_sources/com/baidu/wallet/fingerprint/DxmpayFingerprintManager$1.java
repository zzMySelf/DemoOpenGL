package com.baidu.wallet.fingerprint;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.fingerprint.FingerprintGetOtpTokenCallback;
import com.dxmpay.apollon.utils.LogUtil;

public class DxmpayFingerprintManager$1 implements FingerprintGetOtpTokenCallback {
    public final /* synthetic */ a this$0;
    public final /* synthetic */ IPayBiometricCallback val$callback;
    public final /* synthetic */ Context val$context;

    public DxmpayFingerprintManager$1(a aVar, Context context, IPayBiometricCallback iPayBiometricCallback) {
        this.this$0 = aVar;
        this.val$context = context;
        this.val$callback = iPayBiometricCallback;
    }

    public void getOtpToken(String str) {
        LogUtil.d("DxmpayFingerprintManage", "getOtpToken==" + str);
        if (TextUtils.isEmpty(str)) {
            int unused = this.this$0.a = 0;
        } else {
            int unused2 = this.this$0.a = 1;
        }
        this.this$0.a(this.val$context, this.val$callback);
    }
}
