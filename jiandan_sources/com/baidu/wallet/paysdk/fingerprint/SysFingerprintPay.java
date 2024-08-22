package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.bean.a;
import com.baidu.wallet.paysdk.fingerprint.bean.b;
import com.baidu.wallet.paysdk.fingerprint.datamodel.OpenFingerprintResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.nopassauth.OtpTokenUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
import java.security.KeyStoreException;

@TargetApi(23)
public class SysFingerprintPay implements IFingerprintPay {
    public static final int MSG_DISMISS_LOADING_DIALOG = 4097;
    public static final int MSG_SHOW_LOADING_DIALOG = 4096;
    public static final String TAG = SysFingerprintPay.class.getSimpleName();
    public FingerprintHandler mSysFpHander = new FingerprintHandler(Looper.getMainLooper());

    public class FingerprintHandler extends Handler implements Serializable {
        public FingerprintHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 4096) {
                WalletGlobalUtils.showLoadingDialog((Activity) message.obj);
            } else if (i2 == 4097) {
                WalletGlobalUtils.DismissLoadingDialog();
            } else {
                super.handleMessage(message);
            }
        }
    }

    private boolean checkFingerprintAvailable(Context context) {
        if (!PermissionManager.checkCallingPermission(context, "android.permission.USE_FINGERPRINT")) {
            return false;
        }
        a aVar = null;
        FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class);
        try {
            aVar = a.a(context);
        } catch (KeyStoreException e) {
            LogUtil.e(TAG, e.getMessage(), e);
        }
        if (aVar != null && aVar.a() && fingerprintManager != null && fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void fetchCloseSysFingerprint(final Activity activity, final FingerprintCallback fingerprintCallback) {
        String sn = WalletFingerprint.getInstance(activity.getApplicationContext()).getSN();
        a aVar = (a) FingerprintBeanFactory.getInstance().getBean((Context) activity, (int) FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, TAG);
        WalletGlobalUtils.showLoadingDialog(activity);
        aVar.a(sn);
        aVar.setResponseCallback(new IBeanResponseCallback() {
            public void onBeanExecFailure(int i2, int i3, final String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                SysFingerprintPay.this.mSysFpHander.post(new Runnable() {
                    public void run() {
                        fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 2, str);
                    }
                });
            }

            public void onBeanExecSuccess(int i2, Object obj, String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                WalletFingerprint.getInstance(activity).clearOTPToken();
                SysFingerprintPay.this.mSysFpHander.post(new Runnable() {
                    public void run() {
                        fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 0, "");
                    }
                });
            }
        });
        aVar.execBean();
    }

    /* access modifiers changed from: private */
    public void saveOTPTokenByFingerprint(Activity activity, String str, FingerprintCallback fingerprintCallback) {
        try {
            com.baidu.wallet.paysdk.fingerprint.ui.a a = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 1, str, fingerprintCallback);
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            beginTransaction.add(a, "FingerprintPayDialog");
            beginTransaction.commitAllowingStateLoss();
        } catch (KeyStoreException unused) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
        }
    }

    public void close(final Activity activity, final FingerprintCallback fingerprintCallback) {
        WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(activity, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                SysFingerprintPay.this.fetchCloseSysFingerprint(activity, fingerprintCallback);
            }

            public void onSuccess(int i2, String str) {
                SysFingerprintPay.this.fetchCloseSysFingerprint(activity, fingerprintCallback);
            }
        }));
    }

    public void closeFingerprint(final Context context) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_CLOSE_FINGERPRINT);
        String sn = WalletFingerprint.getInstance(context).getSN();
        final a aVar = (a) FingerprintBeanFactory.getInstance().getBean(context, (int) FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, TAG);
        aVar.a(sn);
        aVar.setResponseCallback(new IBeanResponseCallback() {
            public void onBeanExecFailure(int i2, int i3, String str) {
                aVar.destroyBean();
            }

            public void onBeanExecSuccess(int i2, Object obj, String str) {
                aVar.destroyBean();
                WalletFingerprint.getInstance(context).clearOTPToken();
            }
        });
        aVar.execBean();
    }

    public void destory() {
        FingerprintHandler fingerprintHandler = this.mSysFpHander;
        if (fingerprintHandler != null) {
            fingerprintHandler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void open(final Activity activity, final FingerprintCallback fingerprintCallback, boolean z) {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (z || payRequest == null || payRequest.FP_Guide_Strategy <= 0) {
            PasswordController.getPassWordInstance().checkPwd(activity, DxmPayBeanConstants.FROM_FINGERPRINT_PAY, new PasswordController.IPwdListener() {
                public void onFail(int i2, String str) {
                    fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, str);
                }

                public void onSucceed(String str) {
                    ((PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD)).mPayPass = str;
                    SysFingerprintPay.this.register(activity, fingerprintCallback);
                }
            });
        } else {
            register(activity, fingerprintCallback);
        }
    }

    public void register(final Activity activity, final FingerprintCallback fingerprintCallback) {
        Context applicationContext = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_sys_too_low"));
        } else if (!checkFingerprintAvailable(activity)) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_unsupport_cancle_open"));
        } else {
            try {
                try {
                    a.a((Context) activity).a(WalletFingerprint.getKeyStoreNewAlise(activity));
                    Message.obtain(this.mSysFpHander, 4096, activity).sendToTarget();
                    final b bVar = (b) FingerprintBeanFactory.getInstance().getBean(applicationContext, (int) FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, TAG);
                    bVar.setResponseCallback(new IBeanResponseCallback() {
                        public void onBeanExecFailure(int i2, int i3, String str) {
                            bVar.destroyBean();
                            SysFingerprintPay.this.mSysFpHander.sendEmptyMessage(4097);
                            SysFingerprintPay.this.mSysFpHander.post(new Runnable() {
                                public void run() {
                                    AnonymousClass5 r0 = AnonymousClass5.this;
                                    fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(activity, "wallet_fp_open_failed"));
                                }
                            });
                        }

                        public void onBeanExecSuccess(int i2, Object obj, String str) {
                            bVar.destroyBean();
                            SysFingerprintPay.this.mSysFpHander.sendEmptyMessage(4097);
                            OpenFingerprintResponse openFingerprintResponse = (obj == null || !(obj instanceof OpenFingerprintResponse)) ? null : (OpenFingerprintResponse) obj;
                            if (openFingerprintResponse == null || TextUtils.isEmpty(openFingerprintResponse.token_info)) {
                                SysFingerprintPay.this.mSysFpHander.post(new Runnable() {
                                    public void run() {
                                        AnonymousClass5 r0 = AnonymousClass5.this;
                                        fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(activity, "wallet_fp_open_failed"));
                                    }
                                });
                                return;
                            }
                            String safeSavedDataByUnionId = OtpTokenUtils.toSafeSavedDataByUnionId(SecurePay.getInstance().decryptProxy(openFingerprintResponse.token_info), activity.getApplicationContext());
                            String localEncrypt1 = SecurePay.getInstance().localEncrypt1(OtpTokenUtils.getSN(openFingerprintResponse.token_info));
                            SysFingerprintPay.this.saveOTPTokenByFingerprint(activity, localEncrypt1 + "|" + safeSavedDataByUnionId, fingerprintCallback);
                        }
                    });
                    bVar.execBean();
                } catch (Exception unused) {
                    StatisticManager.onEvent("fprd_generateKey_failed");
                    fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
                }
            } catch (KeyStoreException e) {
                LogUtil.e(TAG, e.getMessage(), e);
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
            }
        }
    }

    public void verify(Activity activity, FingerprintCallback fingerprintCallback) {
        try {
            com.baidu.wallet.paysdk.fingerprint.ui.a a = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 2, (String) null, fingerprintCallback);
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            beginTransaction.add(a, "FingerprintPayDialog");
            beginTransaction.commitAllowingStateLoss();
        } catch (KeyStoreException unused) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
        }
    }
}
