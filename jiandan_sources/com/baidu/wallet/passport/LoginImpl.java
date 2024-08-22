package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.NoProguard;
import java.util.Map;

public class LoginImpl implements IWalletLoginListener, NoProguard {
    public static String TAG = "LoginImpl";
    public Context mContext;

    public LoginImpl(Context context) {
        if (context != null) {
            this.mContext = DxmApplicationContextImpl.getApplicationContext(context);
        }
    }

    private void loginBaidu(ILoginBackListener iLoginBackListener, String str) {
        PassLoginUtil.getInstance().loginBaidu(this.mContext, iLoginBackListener, str);
    }

    public Map<String, String> getLoginData(String str) {
        return PassLoginUtil.getInstance().getLoginData(this.mContext, str);
    }

    public String getLoginStoken(String str) {
        return PassLoginUtil.getInstance().getLoginStoken(str);
    }

    public int getLoginType() {
        return 0;
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener, i2);
    }

    public String getOpenLoginToken() {
        return PassLoginUtil.getInstance().getLoginOpenToken();
    }

    public void handlerWalletError(int i2) {
        if (i2 == 5003) {
            PassLoginUtil.getInstance().logout();
            AccountManager.getInstance(this.mContext).logout();
        }
    }

    public boolean isLogin() {
        return PassLoginUtil.getInstance().isLogin();
    }

    public boolean isPassLogin() {
        return PassLoginUtil.getInstance().isPassLogin();
    }

    public void login(ILoginBackListener iLoginBackListener) {
        loginBaidu(iLoginBackListener, (String) null);
    }

    public void onLoginChanaged(Context context, Map map) {
        if (map == null) {
            PassLoginUtil.getInstance().logout();
            AccountManager.getInstance(this.mContext).logout();
        }
    }

    public boolean startPage(String str) {
        BaiduWalletDelegate.getInstance().openH5Module(this.mContext, str, true);
        return true;
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        getOpenBduss(z, iLoginBackListener, 0);
    }

    public void login(ILoginBackListener iLoginBackListener, String str) {
        loginBaidu(iLoginBackListener, str);
    }
}
