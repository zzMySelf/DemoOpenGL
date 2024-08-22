package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.b.a;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.nopassauth.OtpTokenUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.SecurityUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.storage.PayPreferenceManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.security.KeyStoreException;

public class WalletFingerprint implements NoProguard {
    public static int SUPPORT_API_LEVEL = 23;
    public static WalletFingerprint a;
    public IFingerprintPay b;
    public a c;
    public Context d;
    public PhoneSupportStatus e = PhoneSupportStatus.UNSUPPORT;

    public enum FpType {
        SYSTEM_FINGERPRINT,
        FIDO_FINGERPRINT
    }

    public enum PhoneSupportStatus {
        UNSUPPORT,
        SUPPORT_SYS
    }

    public WalletFingerprint(Context context) {
        this.d = context.getApplicationContext();
    }

    private void a() {
        if (SecurityUtils.isRoot()) {
            this.e = PhoneSupportStatus.UNSUPPORT;
        } else if (b()) {
            this.e = PhoneSupportStatus.SUPPORT_SYS;
        } else {
            this.e = PhoneSupportStatus.UNSUPPORT;
        }
    }

    @TargetApi(23)
    private boolean b() {
        if (PermissionManager.checkCallingPermission(this.d, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= SUPPORT_API_LEVEL) {
            FingerprintManager fingerprintManager = (FingerprintManager) this.d.getSystemService(FingerprintManager.class);
            try {
                a a2 = a.a(this.d);
                if (a2 != null && a2.a() && fingerprintManager != null && fingerprintManager.isHardwareDetected()) {
                    return true;
                }
                return false;
            } catch (KeyStoreException e2) {
                LogUtil.e("WalletFingerprint", e2.getMessage(), e2);
            }
        }
        return false;
    }

    public static WalletFingerprint getInstance(Context context) {
        if (a == null) {
            synchronized (WalletFingerprint.class) {
                if (a == null) {
                    a = new WalletFingerprint(context);
                }
            }
        }
        return a;
    }

    public static String getKeyStoreNewAlise(Context context) {
        String newPpKey = PayPreferenceManager.getNewPpKey(context.getApplicationContext());
        return a.b + "_" + newPpKey + "_" + BeanConstants.CHANNEL_ID;
    }

    @TargetApi(23)
    public void cancleListening() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
            this.c.d();
            this.c = null;
        }
    }

    public void clearOTPToken() {
        SharedPreferencesUtils.setParam(this.d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.d), "");
        String dxmDidToMd5 = PayPreferenceManager.getDxmDidToMd5(this.d);
        if (!TextUtils.isEmpty(dxmDidToMd5)) {
            SharedPreferencesUtils.setParam(this.d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, dxmDidToMd5, "");
        }
    }

    public void close(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
        this.b = fingerprintPay;
        if (fingerprintPay == null) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 2, "");
        } else {
            fingerprintPay.close(activity, fingerprintCallback);
        }
    }

    public String generateOTPKey(String str) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_TOKEN_ENTER);
        if (TextUtils.isEmpty(str)) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_TOKENINFO_IS_NULL);
            return null;
        }
        String safeSavedDataByUnionId = OtpTokenUtils.getSafeSavedDataByUnionId(str, this.d);
        "generateDynamickey tokeninfo=" + safeSavedDataByUnionId;
        String[] split = safeSavedDataByUnionId.split("\\|");
        if (split.length == 9) {
            int i2 = 6;
            int i3 = 1;
            try {
                i2 = Integer.valueOf(split[5].substring(split[5].length() - 1, split[5].length())).intValue();
                i3 = Integer.valueOf(split[7]).intValue();
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_KEYLEN_TIMESTEP);
            } catch (Exception e2) {
                StatisticManager.onEventEndWithValue(StatServiceEvent.EVENT_FP_GET_DECRYPT_TOKEN_EXCEPTION, e2.toString());
            }
            "generateDynamicKey() key.length=" + i2 + "&& timeStep=" + i3;
            return OtpTokenUtils.getEncryptTOtpCode(this.d, i3, safeSavedDataByUnionId.split("\\|")[3], i2);
        }
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_DECRYPT_TOKEN_FAIL);
        return null;
    }

    public String getEncryptFingerprintData() {
        String str = (String) SharedPreferencesUtils.getParam(this.d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.d), "");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return (String) SharedPreferencesUtils.getParam(this.d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getDxmDidToMd5(this.d), "");
    }

    public IFingerprintPay getFingerprintPay() {
        a();
        if (this.e == PhoneSupportStatus.SUPPORT_SYS) {
            return new SysFingerprintPay();
        }
        return null;
    }

    public void getOTPToken(final FingerprintGetOtpTokenCallback fingerprintGetOtpTokenCallback) {
        if (fingerprintGetOtpTokenCallback != null && this.d != null) {
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(this.d, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    fingerprintGetOtpTokenCallback.getOtpToken("");
                }

                public void onSuccess(int i2, String str) {
                    fingerprintGetOtpTokenCallback.getOtpToken(WalletFingerprint.this.getEncryptFingerprintData());
                }
            }));
        }
    }

    public String getSN() {
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_ENTER);
        String[] split = new String(Base64.decode(getEncryptFingerprintData(), 0)).split("\\|");
        if (split.length == 3) {
            String localDecrypt1 = SecurePay.getInstance().localDecrypt1(split[2]);
            if (TextUtils.isEmpty(localDecrypt1)) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_IS_NULL);
                return localDecrypt1;
            }
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_SUCCESS);
            return localDecrypt1;
        }
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_FAIL);
        return null;
    }

    public boolean hasEnrollFingerprint() {
        if (PermissionManager.checkCallingPermission(this.d, "android.permission.USE_FINGERPRINT") && isDevicesSupport()) {
            return a(this.d);
        }
        return false;
    }

    public boolean hasOTPToken() {
        return !TextUtils.isEmpty(getEncryptFingerprintData());
    }

    public boolean isDevicesSupport() {
        if (!PermissionManager.checkCallingPermission(this.d, "android.permission.USE_FINGERPRINT")) {
            return false;
        }
        a();
        if (this.e != PhoneSupportStatus.UNSUPPORT) {
            return true;
        }
        return false;
    }

    public void open(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
        this.b = fingerprintPay;
        if (fingerprintPay == null) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, "");
        } else {
            fingerprintPay.open(activity, fingerprintCallback, true);
        }
    }

    @TargetApi(23)
    public void startListening(b bVar) {
        this.b = getFingerprintPay(FpType.SYSTEM_FINGERPRINT);
        try {
            this.c = new a(this.d);
        } catch (KeyStoreException e2) {
            LogUtil.e("WalletFingerprint", e2.getMessage(), e2);
        }
        a aVar = this.c;
        if (aVar == null || this.b == null) {
            bVar.a(-1, "");
            return;
        }
        aVar.a(bVar);
        this.c.a(2);
    }

    public void verify(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
        this.b = fingerprintPay;
        if (fingerprintPay == null) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, "");
        } else {
            fingerprintPay.verify(activity, fingerprintCallback);
        }
    }

    public IFingerprintPay getFingerprintPay(FpType fpType) {
        a();
        PhoneSupportStatus phoneSupportStatus = this.e;
        if (phoneSupportStatus != PhoneSupportStatus.UNSUPPORT && fpType == FpType.SYSTEM_FINGERPRINT && phoneSupportStatus == PhoneSupportStatus.SUPPORT_SYS) {
            return new SysFingerprintPay();
        }
        return null;
    }

    @TargetApi(23)
    private boolean a(Context context) {
        FingerprintManager fingerprintManager;
        if (PermissionManager.checkCallingPermission(context, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= 23 && (fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class)) != null && fingerprintManager.hasEnrolledFingerprints()) {
            return true;
        }
        return false;
    }
}
