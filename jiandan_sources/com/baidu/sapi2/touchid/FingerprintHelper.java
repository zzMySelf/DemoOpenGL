package com.baidu.sapi2.touchid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.view.View;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
import java.util.Map;

public class FingerprintHelper extends FingerprintManager.AuthenticationCallback {
    public static final int AUTH_CANCLE = -2;
    public static final int AUTH_CHAGE_LOGIN_TYPE = -3;
    public static final int AUTH_MIS_MATCH_LIMIE = -8;
    public static final int AUTH_SUCCESS = 0;
    public static final int FINGERPRINT_VERIFY_MAX_ERROR_COUNT = 5;
    public static final String TAG = FingerprintHelper.class.getSimpleName();
    public int authType;
    public CancellationSignal cancellationSignal = null;
    public Context context;
    public FingerprintManager.CryptoObject cryptoObject = null;
    public FingerprintCallback fingerprintCallback;
    public FingerprintDialogInterface fingerprintDialog;
    public FingerprintManager fingerprintManager;
    public char maxErrorCount = 5;

    public FingerprintHelper(Context context2, FingerprintDialogInterface fingerprintDialogInterface) {
        this.context = context2;
        this.fingerprintDialog = fingerprintDialogInterface;
        this.fingerprintManager = (FingerprintManager) context2.getSystemService(FingerprintManager.class);
        this.cryptoObject = null;
        if (Build.VERSION.SDK_INT >= 16) {
            this.cancellationSignal = new CancellationSignal();
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        } else if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                Log.e(e);
            }
        }
    }

    private void showFirstVerifyDialog() {
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        this.fingerprintDialog.setTitle("百度账号 触控ID", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn("取消", new View.OnClickListener() {
            public void onClick(View view) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-2);
            }
        }).showDialog();
    }

    private void showTryAgainLoginDialog() {
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        StatService.onEvent("fingerprint_try_again_dialog_show", (Map<String, String>) null);
        this.fingerprintDialog.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(2).setNegativeBtn("取消", new View.OnClickListener() {
            public void onClick(View view) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-2);
            }
        }).setPositiveBtn("换个登录方式", new View.OnClickListener() {
            public void onClick(View view) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-3);
            }
        }).showDialog();
    }

    private void showTryAgainVerifyDialog() {
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        this.fingerprintDialog.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn("取消", new View.OnClickListener() {
            public void onClick(View view) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-2);
            }
        }).showDialog();
    }

    public void onAuthenticationError(int i2, CharSequence charSequence) {
        super.onAuthenticationError(i2, charSequence);
        String str = TAG;
        Log.i(str, "Authentication error:" + i2 + charSequence);
        stopAuthenticate();
        this.maxErrorCount = 5;
        if (i2 == 7) {
            FingerprintCallback fingerprintCallback2 = this.fingerprintCallback;
            if (fingerprintCallback2 != null) {
                fingerprintCallback2.onCall(-8);
                return;
            }
            return;
        }
        FingerprintCallback fingerprintCallback3 = this.fingerprintCallback;
        if (fingerprintCallback3 != null) {
            fingerprintCallback3.onCall(i2);
        }
    }

    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Log.i(TAG, "Authentication failed ");
        char c = (char) (this.maxErrorCount - 1);
        this.maxErrorCount = c;
        if (c <= 0) {
            stopAuthenticate();
            this.maxErrorCount = 5;
        } else if (this.authType == 3) {
            showTryAgainLoginDialog();
        } else {
            showTryAgainVerifyDialog();
        }
    }

    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        super.onAuthenticationHelp(i2, charSequence);
        String str = TAG;
        Log.i(str, "Authentication help:" + i2 + charSequence);
    }

    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        super.onAuthenticationSucceeded(authenticationResult);
        Log.i(TAG, "Authentication Succeeded ");
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        FingerprintCallback fingerprintCallback2 = this.fingerprintCallback;
        if (fingerprintCallback2 != null) {
            fingerprintCallback2.onCall(0);
        }
    }

    public void startAuthenticate(int i2, FingerprintCallback fingerprintCallback2) {
        Log.i(TAG, "startAuthenticate");
        this.authType = i2;
        this.fingerprintCallback = fingerprintCallback2;
        if (Build.VERSION.SDK_INT >= 16 && this.cancellationSignal.isCanceled()) {
            this.cancellationSignal = new CancellationSignal();
        }
        this.fingerprintManager.authenticate(this.cryptoObject, this.cancellationSignal, 0, this, (Handler) null);
        showFirstVerifyDialog();
    }

    public void stopAuthenticate() {
        Log.i(TAG, "stopAuthenticate");
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        if (Build.VERSION.SDK_INT >= 16) {
            this.cancellationSignal.cancel();
            this.fingerprintManager.authenticate(this.cryptoObject, this.cancellationSignal, 0, this, (Handler) null);
        }
    }
}
