package com.baidu.wallet.fingerprint;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import org.json.JSONException;

public class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;

    /* access modifiers changed from: private */
    public void a(final Context context, final IPayBiometricCallback iPayBiometricCallback) {
        BaiduPayDelegate.getInstance().getSecurityCenterOrPaySettingData(EnterDxmPayServiceAction.DXM_GET_PAY_SETTING_DATA, context, new com.baidu.wallet.paysdk.securitycenter.a() {
            public void a(int i2, String str) {
                LogUtil.d("DxmpayFingerprintManage", "state=" + i2 + "data==" + str);
                if (i2 == 0) {
                    try {
                        PaySettingDataResponse paySettingDataResponse = (PaySettingDataResponse) JsonUtils.fromJson(str, PaySettingDataResponse.class);
                        String str2 = paySettingDataResponse.content.fingerprint.user_reg;
                        if (!TextUtils.isEmpty(str2)) {
                            int unused = a.this.b = Integer.parseInt(str2);
                        }
                        String str3 = paySettingDataResponse.content.fingerprint.device_support;
                        if (!TextUtils.isEmpty(str3)) {
                            int unused2 = a.this.c = Integer.parseInt(str3);
                        }
                        String str4 = paySettingDataResponse.content.fingerprint.is_otp;
                        if (!TextUtils.isEmpty(str4)) {
                            int unused3 = a.this.d = Integer.parseInt(str4);
                        }
                    } catch (JSONException e) {
                        LogUtil.d("DxmpayFingerprintManage", "JSONException=" + e.getMessage());
                    }
                } else {
                    boolean unused4 = a.this.e = true;
                }
                LogUtil.d("DxmpayFingerprintManage", "state=" + i2 + "//user_reg_result=" + a.this.b + "//is_otp_result=" + a.this.d);
                boolean hasEnrollFingerprint = WalletFingerprint.getInstance(context).hasEnrollFingerprint();
                if (a.this.a == 1 && a.this.b == 1 && a.this.d == 1) {
                    a.this.a(iPayBiometricCallback, 0);
                } else if (a.this.c == 0) {
                    a.this.a(iPayBiometricCallback, 4);
                } else if (!hasEnrollFingerprint) {
                    a.this.a(iPayBiometricCallback, 2);
                } else if (a.this.e) {
                    a.this.a(iPayBiometricCallback, 5);
                } else {
                    a.this.a(iPayBiometricCallback, 3);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(IPayBiometricCallback iPayBiometricCallback, int i2) {
        a(i2);
        if (iPayBiometricCallback != null) {
            iPayBiometricCallback.payBiometric(i2);
        }
    }

    private void a(int i2) {
        StatisticManager.onEventWithValue(StatServiceEvent.DXMPAY_BIOMETRIC_STATUS, String.valueOf(i2));
    }
}
