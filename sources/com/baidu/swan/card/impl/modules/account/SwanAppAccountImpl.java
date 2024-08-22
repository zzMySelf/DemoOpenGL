package com.baidu.swan.card.impl.modules.account;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.swan.card.account.OnSwanAppLoginResultListener;
import com.baidu.swan.card.account.SwanAppAccountStatusChangedListener;
import com.baidu.swan.card.account.interfaces.ISwanAppAccount;
import com.baidu.swan.card.api.network.net.WebSafeWhiteListMgr;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.launch.cookies.SwanCookieParser;
import com.baidu.swan.card.settings.oauth.ScopeInfo;
import com.baidu.swan.card.utils.SwanAppUrlUtils;
import java.util.Set;

public class SwanAppAccountImpl implements ISwanAppAccount {
    private static final String STATUS_LOGIN = "1";
    private static final String STATUS_NOT_LOGIN = "0";
    private String mBduss;
    private String mLoginStatus;

    public void login(Activity activity, Bundle loginParams, OnSwanAppLoginResultListener listener) {
        AccountUtils.loginAnyProcess(activity, "aiapps", false, loginParams, listener);
    }

    public boolean isLoggedIn(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return AccountUtils.isLogin(context);
        }
        return AccountUtils.isLoginWithDelegation(context);
    }

    public String getUserIdentity(Context context) {
        return AccountUtils.getUidAnyProcess(context);
    }

    public void addLoginStatusChangedListener(final SwanAppAccountStatusChangedListener listener) {
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).addLoginStatusChangedListener(new IAccountStatusChangedListener() {
            public void onLoginStatusChanged(boolean oldStatus, boolean newStatus) {
                listener.onLoginStatusChanged(newStatus && (oldStatus ^ newStatus));
            }
        });
    }

    public void loginAndGetMobile(OnSwanAppLoginResultListener listener) {
    }

    public void checkPhoneNumberStatus(ISwanAppAccount.CheckPhoneNumberStatusCallback callback) {
        AccountUtils.checkPhoneNumberStatus(callback);
    }

    public void bindPhoneNumber(Activity activity, ISwanAppAccount.BindPhoneNumberCallback callback) {
        AccountUtils.bindPhoneNumber(activity, callback);
    }

    public String getDeviceIdentity(Context context) {
        BaiduIdentityManager baiduIdentityManager = BaiduIdentityManager.getInstance(context);
        if (baiduIdentityManager != null) {
            return baiduIdentityManager.getUid();
        }
        return "";
    }

    public String getEncryptionDeviceIdentity(Context context) {
        return BaiduIdentityManager.getInstance().getEnUid();
    }

    public String getAccountIdentity(Context context) {
        return AccountUtils.getBdussAnyProcess(context);
    }

    public boolean isGuestLogin(Context context) {
        return AccountUtils.isGuestLoginAnyProcess(context);
    }

    public String setBdussInCookieIfNeed(SwanCard swanCard, String url, String defaultCookie, ISwanAppAccount.InvokeScene scene) {
        if (TextUtils.isEmpty(getCacheLoginStatus())) {
            cacheLoginStatus();
        }
        if (TextUtils.equals(getCacheLoginStatus(), "0")) {
            return defaultCookie;
        }
        boolean baidu = swanCard.isQualificationBaiDu();
        boolean hostInWhiteList = true;
        ScopeInfo scopeInfo = swanCard.getUpdateManager().getAccreditNode().getAccreditListData(true).get("mapp_i_get_bduss");
        boolean scope = scopeInfo != null && scopeInfo.authorized();
        boolean isBaiduDomainUrl = SwanAppUrlUtils.isBaiduDomain(url);
        boolean hasBduss = SwanCookieParser.isContainsKey(defaultCookie, "bduss");
        boolean safeUrl = !TextUtils.isEmpty(url) && url.startsWith("https");
        if ((!baidu && !scope) || hasBduss || !safeUrl) {
            return defaultCookie;
        }
        if (!isBaiduDomainUrl) {
            if (scene != ISwanAppAccount.InvokeScene.SCENE_REQUEST) {
                return defaultCookie;
            }
            String host = TextUtils.isEmpty(url) ? null : Uri.parse(url).getHost();
            Set<String> whiteList = WebSafeWhiteListMgr.getBdussDomains(swanCard.getAppId());
            if (whiteList == null || TextUtils.isEmpty(host) || !whiteList.contains(host)) {
                hostInWhiteList = false;
            }
            if (!hostInWhiteList) {
                return defaultCookie;
            }
        }
        String bduss = getCacheBduss();
        if (TextUtils.isEmpty(bduss)) {
            bduss = getAccountIdentity(AppRuntime.getAppContext());
            this.mBduss = bduss;
        }
        if (TextUtils.isEmpty(bduss)) {
            return defaultCookie;
        }
        if (TextUtils.isEmpty(defaultCookie)) {
            return "BDUSS=" + bduss;
        }
        if (defaultCookie.endsWith(";")) {
            return defaultCookie + " BDUSS=" + bduss;
        }
        if (defaultCookie.endsWith("; ")) {
            return defaultCookie + "BDUSS=" + bduss;
        }
        return defaultCookie + "; BDUSS=" + bduss;
    }

    public String getCacheBduss() {
        return this.mBduss;
    }

    public void cacheBduss() {
        this.mBduss = getAccountIdentity(AppRuntime.getAppContext());
    }

    public void onAppBackGround(boolean isBackGround) {
        if (isBackGround) {
            this.mLoginStatus = null;
            this.mBduss = null;
            return;
        }
        cacheLoginStatus();
        cacheBduss();
    }

    private String getCacheLoginStatus() {
        return this.mLoginStatus;
    }

    private void cacheLoginStatus() {
        this.mLoginStatus = isLoggedIn(AppRuntime.getAppContext()) ? "1" : "0";
    }
}
