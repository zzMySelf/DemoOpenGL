package com.baidu.wallet.base.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdCheckActivity;
import com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public final class PasswordController {
    public static PasswordController a;
    public IPwdListener b;
    public IPwdListener c;
    public IPwdListener d;
    public IPwdListener e;
    public BaiduPay.IBindCardCallback f;
    public LoginBackListenerProxy g;

    public interface IPwdListener {
        void onFail(int i2, String str);

        void onSucceed(String str);
    }

    public static PasswordController getPassWordInstance() {
        if (a == null) {
            a = new PasswordController();
        }
        return a;
    }

    public static String getSeed() {
        return new BigInteger(64, new Random()).toString();
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwd(String str, String str2) {
        String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SecurePay.getInstance().localDecrypt1(str);
        if (TextUtils.isEmpty(localDecrypt1)) {
            return null;
        }
        String a2 = a(a(localDecrypt1));
        "handlePwd. pwd1 = " + a2;
        String a3 = a(a2 + str2);
        "handlePwd. pwd2 = " + a3;
        return SecurePay.getInstance().encryptProxy(a3);
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdForPassport(String str) {
        String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SecurePay.getInstance().localDecrypt1(str);
        if (TextUtils.isEmpty(localDecrypt1)) {
            return null;
        }
        return SecurePay.getInstance().encryptProxy(Md5Utils.toMD5(Md5Utils.toMD5(localDecrypt1)));
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdSimple(String str) {
        String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SecurePay.getInstance().localDecrypt1(str);
        if (TextUtils.isEmpty(localDecrypt1)) {
            return null;
        }
        return a(a(localDecrypt1));
    }

    public void checkPwd(Context context, IPwdListener iPwdListener) {
        checkPwd(context, (String) null, iPwdListener);
    }

    public void checkPwdFail(int i2, String str) {
        IPwdListener iPwdListener = this.b;
        if (iPwdListener != null) {
            iPwdListener.onFail(i2, str);
        }
    }

    public void checkPwdForSp(Context context, Map<String, String> map, IPwdListener iPwdListener) {
        this.b = iPwdListener;
        PwdRequest pwdRequest = new PwdRequest();
        pwdRequest.mFrom = 1;
        pwdRequest.mRequestType = 2;
        pwdRequest.mExtData = map;
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        Intent intent = new Intent(context, PwdCheckActivity.class);
        intent.putExtra(DxmPayBeanConstants.CHECK_PWD_FROM_TYPE_KEY, DxmPayBeanConstants.FROM_CHECK_FOR_SP);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        BaiduWalletUtils.startActivityAnim(context);
    }

    public void checkPwdFromH5(Context context, String str, String str2, IPwdListener iPwdListener) {
        checkPwdFromH5(context, str, str2, iPwdListener, "");
    }

    public void checkPwdSucceed(String str) {
        IPwdListener iPwdListener = this.b;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.b = null;
        }
    }

    public void clearBindCardCallback() {
        this.f = null;
    }

    public void clearCheckPwdListener() {
        this.b = null;
    }

    public void clearEditPwdCallBack() {
        this.d = null;
    }

    public void clearForgetPasswdCallback() {
        this.e = null;
    }

    public void clearSetPwdListener() {
        this.c = null;
    }

    public void editPwd(Context context, IPwdListener iPwdListener) {
        this.d = iPwdListener;
        PwdRequest pwdRequest = new PwdRequest();
        pwdRequest.mFrom = 2;
        pwdRequest.mRequestType = 1;
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        Intent intent = new Intent(context, PwdCheckActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void editPwdFail(int i2, String str) {
        IPwdListener iPwdListener = this.d;
        if (iPwdListener != null) {
            iPwdListener.onFail(i2, str);
        }
    }

    public void editPwdSucceed(String str) {
        IPwdListener iPwdListener = this.d;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.d = null;
        }
    }

    public void forgetPasswdFailed() {
        IPwdListener iPwdListener = this.e;
        if (iPwdListener != null) {
            iPwdListener.onFail(-1, "");
        }
    }

    public void forgetPasswdSucceed(String str) {
        IPwdListener iPwdListener = this.e;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.e = null;
        }
    }

    public void setPassByUserFail(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback = this.f;
        if (iBindCardCallback != null) {
            iBindCardCallback.onChangeFailed(str);
        }
    }

    public void setPassByUserSucceed(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback = this.f;
        if (iBindCardCallback != null) {
            iBindCardCallback.onChangeSucceed((String) null);
            this.f = null;
        }
    }

    public void setPwd(Context context, boolean z, IPwdListener iPwdListener, PayRequestCache.BindCategory bindCategory) {
        PwdRequest pwdRequest;
        if (iPwdListener != null) {
            this.c = iPwdListener;
        }
        BeanRequestBase beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        if (!z || !(beanRequestFromCache instanceof PwdRequest)) {
            pwdRequest = new PwdRequest();
            pwdRequest.mFrom = 0;
        } else {
            pwdRequest = (PwdRequest) beanRequestFromCache;
        }
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        Intent intent = new Intent(context, PwdSetAndConfirmActivity.class);
        if (bindCategory == null) {
            bindCategory = PayRequestCache.BindCategory.Other;
        }
        intent.putExtra("baidu.wallet.bindcard.category", bindCategory.getScenario());
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void setPwdFail(int i2, String str) {
        IPwdListener iPwdListener = this.c;
        if (iPwdListener != null) {
            iPwdListener.onFail(i2, str);
        }
    }

    public void setPwdSucceed(String str) {
        IPwdListener iPwdListener = this.c;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.c = null;
        }
    }

    public void checkPwd(Context context, String str, IPwdListener iPwdListener) {
        checkPwd(context, str, iPwdListener, "");
    }

    public void checkPwdFromH5(Context context, String str, String str2, IPwdListener iPwdListener, String str3) {
        this.b = iPwdListener;
        PwdRequest pwdRequest = new PwdRequest();
        pwdRequest.serviceType = str3;
        pwdRequest.mFrom = 1;
        pwdRequest.mRequestType = 2;
        pwdRequest.fromType = str2;
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        Intent intent = new Intent(context, PwdCheckActivity.class);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(DxmPayBeanConstants.CHECK_PWD_FROM_TYPE_KEY, str2);
        }
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("half_screen_pwd_verify", str);
        context.startActivity(intent);
        BaiduWalletUtils.startActivityAnim(context);
    }

    public void checkPwd(Context context, String str, IPwdListener iPwdListener, String str2) {
        final Context context2 = context;
        final String str3 = str;
        final IPwdListener iPwdListener2 = iPwdListener;
        final String str4 = str2;
        this.g = new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(PasswordController.this.g);
                    return;
                }
                PasswordController.this.checkPwdFail(i2, str);
                LoginBackListenerProxy unused = PasswordController.this.g = null;
            }

            public void onSuccess(int i2, String str) {
                if (PasswordController.this.g.getContext() != null) {
                    PasswordController.this.a(context2, str3, iPwdListener2, str4);
                }
            }
        });
        WalletLoginHelper.getInstance().login(this.g);
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, IPwdListener iPwdListener, String str2) {
        this.b = iPwdListener;
        PwdRequest pwdRequest = new PwdRequest();
        pwdRequest.serviceType = str2;
        pwdRequest.mFrom = 1;
        pwdRequest.mRequestType = 2;
        pwdRequest.fromType = str;
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        Intent intent = new Intent(context, PwdCheckActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(DxmPayBeanConstants.CHECK_PWD_FROM_TYPE_KEY, str);
        }
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        BaiduWalletUtils.startActivityAnim(context);
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(String str) {
        String md5 = Md5Utils.toMD5(str);
        return md5 != null ? md5.toUpperCase() : md5;
    }
}
