package com.dxmpay.wallet.passport;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.dxmpay.wallet.utils.JsonUtil;
import java.util.HashMap;
import java.util.Map;

public class LoginImpl implements IWalletLoginListener, NoProguard {
    public static String TAG = "LoginImpl";
    public Context mContext;

    public class ad extends WebAuthListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4309ad;

        public ad(LoginImpl loginImpl, ILoginBackListener iLoginBackListener) {
            this.f4309ad = iLoginBackListener;
        }

        /* renamed from: a */
        public void onSuccess(WebAuthResult webAuthResult) {
            ILoginBackListener iLoginBackListener = this.f4309ad;
            if (iLoginBackListener != null) {
                iLoginBackListener.onSuccess(0, "");
            }
        }

        /* renamed from: b */
        public void onFailure(WebAuthResult webAuthResult) {
            ILoginBackListener iLoginBackListener = this.f4309ad;
            if (iLoginBackListener != null) {
                iLoginBackListener.onFail(webAuthResult.getResultCode(), webAuthResult.getResultMsg());
            }
        }

        public void beforeSuccess(SapiAccount sapiAccount) {
        }
    }

    public class qw implements RouterCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4310ad;

        public qw(LoginImpl loginImpl, ILoginBackListener iLoginBackListener) {
            this.f4310ad = iLoginBackListener;
        }

        public void onResult(int i2, HashMap hashMap) {
            if (i2 == 0) {
                this.f4310ad.onSuccess(0, "");
            } else if (i2 == 1 && hashMap != null && !hashMap.isEmpty()) {
                this.f4310ad.onFail(((Integer) hashMap.get("resultCode")).intValue(), (String) hashMap.get(DxmPassManagerDelegate.DXM_KEY_RESULT_MSG));
            }
        }
    }

    public LoginImpl(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    private void loginBaidu(ILoginBackListener iLoginBackListener, String str) {
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
            DxmPassManagerDelegate.getInstance().dxmStartLogin(this.mContext, webLoginDTO, "", new qw(this, iLoginBackListener));
            return;
        }
        PassportSDK instance = PassportSDK.getInstance();
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonStringToNameValuePairList(str, webLoginDTO.extraParams);
        }
        instance.startLogin(this.mContext, new ad(this, iLoginBackListener), webLoginDTO);
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

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener);
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
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

    public void login(ILoginBackListener iLoginBackListener, String str) {
        loginBaidu(iLoginBackListener, str);
    }
}
