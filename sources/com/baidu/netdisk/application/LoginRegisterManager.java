package com.baidu.netdisk.application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.account.IAccountChangeCallback;
import com.baidu.netdisk.account.external.AccountChangeCallback;
import com.baidu.netdisk.account.model.AuthBean;
import com.baidu.netdisk.account.provider.LoginRegisterCallBack;
import com.baidu.netdisk.account.provider.VipChangeCallBack;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.params.AccountLoginParams;
import com.baidu.netdisk.util.WeakRefResultReceiver;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.List;

public class LoginRegisterManager implements LoginRegisterCallBack {
    private static final String TAG = "LoginRegisterManager";
    private static LoginRegisterManager mInstance;
    private List<LoginRegisterCallBack> backList = new ArrayList();
    private List<AccountChangeCallback> mAccountChangeCallback = new ArrayList();
    private VipChangeCallBack mVipchange;

    public static synchronized LoginRegisterManager getInstance() {
        LoginRegisterManager loginRegisterManager;
        synchronized (LoginRegisterManager.class) {
            if (mInstance == null) {
                mInstance = new LoginRegisterManager();
            }
            loginRegisterManager = mInstance;
        }
        return loginRegisterManager;
    }

    public void addLoginCallBack(LoginRegisterCallBack callBack) {
        NetDiskLog.d(TAG, "setLoginRegisterActivityCallback = " + (callBack == null ? "null" : "not null"));
        this.backList.add(callBack);
    }

    public void removeLoginCallBack(LoginRegisterCallBack callBack) {
        NetDiskLog.d(TAG, "setLoginRegisterActivityCallback = " + (callBack == null ? "null" : "not null"));
        if (this.backList.contains(callBack)) {
            this.backList.remove(callBack);
        }
    }

    public void login(String username, Integer state) {
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.login(username, state);
            }
        }
    }

    public void onSuccess() {
        AccountLoginParams params = new AccountLoginParams();
        params.bduss = SapiAccountManager.getInstance().getSession("bduss");
        params.bduid = SapiAccountManager.getInstance().getSession("uid");
        params.osUsername = SapiAccountManager.getInstance().getSession("displayname");
        params.passportUname = SapiAccountManager.getInstance().getSession("displayname");
        SapiAccount account = SapiAccountManager.getInstance().getSession();
        if (account != null && account.isSocialAccount()) {
            SocialType socialType = SapiAccountManager.getInstance().getSession().getSocialType();
            if (socialType != null) {
                params.osType = String.valueOf(socialType.getType());
            }
            params.osHeadurl = SapiAccountManager.getInstance().getSession().getSocialPortrait();
        }
        onSuccess(params);
    }

    public void onSuccess(AccountLoginParams params) {
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.onSuccess(params);
            }
        }
    }

    public void onSuccess(AuthBean authBean, Activity activity) {
        AuthBean authBean2 = saveAuthBean(authBean);
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.onSuccess(authBean2, activity);
            }
        }
    }

    public void onFailed(int errorNo, String errorMsg) {
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.onFailed(errorNo, errorMsg);
            }
        }
    }

    public boolean onForgetPwd() {
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.onForgetPwd();
            }
        }
        return true;
    }

    public void isNewDevice() {
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.isNewDevice();
            }
        }
    }

    public void showPrivacyPolicy(Context context, boolean privacy) {
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.showPrivacyPolicy(context, privacy);
            }
        }
    }

    public void logoutBdussInvalid() {
        for (LoginRegisterCallBack callBack : this.backList) {
            if (callBack != null) {
                callBack.logoutBdussInvalid();
            }
        }
    }

    public void setVipCallback(VipChangeCallBack callback) {
        this.mVipchange = callback;
    }

    public VipChangeCallBack getVipCallback() {
        return this.mVipchange;
    }

    public List<AccountChangeCallback> getAccountChangeCallback() {
        return this.mAccountChangeCallback;
    }

    public AuthBean saveAuthBean(AuthBean authBean) {
        return saveAuthBean(authBean, (IAccountChangeCallback) null);
    }

    public AuthBean saveAuthBean(AuthBean authBean, IAccountChangeCallback callback) {
        if (authBean == null) {
            authBean = new AuthBean();
            String bduss = SapiAccountManager.getInstance().getSession("bduss");
            String uid = SapiAccountManager.getInstance().getSession("uid");
            String username = SapiAccountManager.getInstance().getSession("displayname");
            SapiAccount account = SapiAccountManager.getInstance().getSession();
            if (account != null) {
                authBean.pToken = account.getPtoken();
            }
            if (account != null && account.isSocialAccount()) {
                SocialType socialType = SapiAccountManager.getInstance().getSession().getSocialType();
                if (socialType != null) {
                    authBean.osType = String.valueOf(socialType.getType());
                }
                authBean.osHeadurl = SapiAccountManager.getInstance().getSession().getSocialPortrait();
            }
            authBean.passportUname = username;
            authBean.bduid = uid;
            authBean.bduss = bduss;
        }
        if (TextUtils.isEmpty(authBean.bduss) || TextUtils.isEmpty(authBean.bduid)) {
            return authBean;
        }
        if (AccountUtils.getInstance().isAnonymous()) {
            AccountUtils.getInstance().logout(AccountApplicationLike.mContext);
        }
        NetDiskLog.d(TAG, "【Upload-SDK】 登录初始化 authBean " + authBean.toString());
        AccountUtils.getInstance().login(authBean, new PullVipResultReceiver(this, callback));
        return authBean;
    }

    public void addAccountChangeCallback(AccountChangeCallback callBack) {
        NetDiskLog.d(TAG, "AccountChangeCallback = " + (callBack == null ? "null" : "not null"));
        if (!this.mAccountChangeCallback.contains(callBack)) {
            this.mAccountChangeCallback.add(callBack);
        }
    }

    public void removeAccountChangeCallback(AccountChangeCallback callBack) {
        NetDiskLog.d(TAG, "AccountChangeCallback = " + (callBack == null ? "null" : "not null"));
        if (this.mAccountChangeCallback.contains(callBack)) {
            this.mAccountChangeCallback.remove(callBack);
        }
    }

    private static class PullVipResultReceiver extends WeakRefResultReceiver<LoginRegisterManager> {
        private IAccountChangeCallback mCallback;

        PullVipResultReceiver(LoginRegisterManager reference, IAccountChangeCallback callback) {
            super(reference, new Handler(Looper.getMainLooper()));
            this.mCallback = callback;
        }

        /* access modifiers changed from: protected */
        public void onHandlerSuccessResult(LoginRegisterManager reference, Bundle resultData) {
            super.onHandlerSuccessResult(reference, resultData);
            IAccountChangeCallback iAccountChangeCallback = this.mCallback;
            if (iAccountChangeCallback != null) {
                iAccountChangeCallback.onResult(true);
            }
        }

        /* access modifiers changed from: protected */
        public void onHandlerFailedResult(LoginRegisterManager reference, Bundle resultData) {
            super.onHandlerFailedResult(reference, resultData);
            IAccountChangeCallback iAccountChangeCallback = this.mCallback;
            if (iAccountChangeCallback != null) {
                iAccountChangeCallback.onResult(false);
            }
        }
    }
}
