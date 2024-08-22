package com.baidu.searchbox.sport.utils;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.lang.ref.WeakReference;

public class LoginUtils {

    public interface OnAllowFuncListener {
        void allowFunc();

        void onLoginFail(int i2);
    }

    private static void login(ILoginResultListener loginResultListener) {
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).combineLogin(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "others")).setNeedUserSettingForLogin(false).setLoginMode(1).build(), 2, loginResultListener);
    }

    public static boolean isLogin() {
        return ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2);
    }

    public static BoxAccount getAccount() {
        BoxAccountManager bam = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (bam != null) {
            return bam.getBoxAccount();
        }
        return null;
    }

    public static void funcWithLogin(OnAllowFuncListener onAllowFuncListener) {
        if (isLogin()) {
            onAllowFuncListener.allowFunc();
            return;
        }
        final WeakReference<OnAllowFuncListener> weakCallback = new WeakReference<>(onAllowFuncListener);
        login(new ILoginResultListener() {
            public void onResult(int resultCode) {
                OnAllowFuncListener listener = (OnAllowFuncListener) weakCallback.get();
                if (listener != null) {
                    if (resultCode == 0) {
                        listener.allowFunc();
                    } else {
                        listener.onLoginFail(resultCode);
                    }
                }
            }
        });
    }
}
