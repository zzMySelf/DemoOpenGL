package com.baidu.swan.apps.setting.actions;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.statistic.IStat;
import com.baidu.swan.apps.statistic.StatRouter;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppUBCBaseEvent;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;

public class MultiAuthorizeStatisticManager {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String EXT_IS_AUTHORIZED = "isAuthorized";
    public static final String EXT_IS_AUTHORIZE_BTN_CONFIRM = "isAuthorizeBtnConfirm";
    public static final String EXT_IS_COMPLETE_CERTIFICATED = "isCompleteCertificated";
    public static final String EXT_IS_COMPLETE_LOGIN = "isCompleteLogin";
    public static final String EXT_IS_USER_CERTIFICATED = "isUserCertificated";
    public static final String EXT_IS_USER_LOGIN = "isUserLogin";
    private static final String PAGE_MULTIAUTHORIZE = "multiAuthorize";
    private static final String TAG = "MultiAuthorizeStatisticManager";
    private static final String TYPE_TRIGGER = "trigger";
    private static MultiAuthorizeEvent sMultiAuthorizeEvent;

    public static synchronized MultiAuthorizeEvent getMultiAuthorizeEvent() {
        MultiAuthorizeEvent multiAuthorizeEvent;
        synchronized (MultiAuthorizeStatisticManager.class) {
            if (sMultiAuthorizeEvent == null) {
                sMultiAuthorizeEvent = new MultiAuthorizeEvent();
                if (DEBUG) {
                    Log.i(TAG, "MultiAuthorizeInfo-new instance.");
                }
            }
            multiAuthorizeEvent = sMultiAuthorizeEvent;
        }
        return multiAuthorizeEvent;
    }

    public static synchronized void release() {
        synchronized (MultiAuthorizeStatisticManager.class) {
            sMultiAuthorizeEvent = null;
        }
    }

    /* access modifiers changed from: private */
    public static void addStatisticCommonParam(MultiAuthorizeEvent event) {
        event.mFrom = SwanAppUBCStatistic.getUBCFrom(Swan.get().getApp().getInfo().getAppFrameType());
        event.mType = "trigger";
        event.mPage = PAGE_MULTIAUTHORIZE;
    }

    /* access modifiers changed from: private */
    public static void submitMultiAuthorizeEvent(final SwanAppUBCBaseEvent ubcEvent) {
        SwanAppExecutorUtils.postOnComputation(new Runnable() {
            public void run() {
                StatRouter.onEvent(IStat.UBC_CERES_ID_SWAN_MULTIAUTHORIZE, SwanAppUBCBaseEvent.this.toJSONObject());
            }
        }, "SwanAppUBCOnEvent");
    }

    public static class MultiAuthorizeEvent extends SwanAppUBCBaseEvent {
        private String mIsAuthorizeBtnConfirm;
        private String mIsAuthorized;
        private String mIsCompleteCertificated;
        private String mIsCompleteLogin;
        private String mIsUserCertificated;
        private String mIsUserLogin;
        private String mSuccessCall;

        private MultiAuthorizeEvent() {
        }

        public MultiAuthorizeEvent setValue(boolean value) {
            this.mSuccessCall = String.valueOf(value);
            return this;
        }

        public MultiAuthorizeEvent setAuthorized(boolean isAuthorized) {
            this.mIsAuthorized = String.valueOf(isAuthorized);
            return this;
        }

        public MultiAuthorizeEvent setAuthorizeBtnConfirm(boolean isAuthorizeBtnConfirm) {
            this.mIsAuthorizeBtnConfirm = String.valueOf(isAuthorizeBtnConfirm);
            return this;
        }

        public MultiAuthorizeEvent setUserLogin(boolean isUserLogin) {
            this.mIsUserLogin = String.valueOf(isUserLogin);
            return this;
        }

        public MultiAuthorizeEvent setCompleteLogin(boolean isCompleteLogin) {
            this.mIsCompleteLogin = String.valueOf(isCompleteLogin);
            return this;
        }

        public MultiAuthorizeEvent setUserCertificated(boolean isUserCertificated) {
            this.mIsUserCertificated = String.valueOf(isUserCertificated);
            return this;
        }

        public MultiAuthorizeEvent setCompleteCertificated(boolean isCompleteCertificated) {
            this.mIsCompleteCertificated = String.valueOf(isCompleteCertificated);
            return this;
        }

        public void submit() {
            MultiAuthorizeStatisticManager.release();
            buildMultiAuthorizeEvent();
            MultiAuthorizeStatisticManager.submitMultiAuthorizeEvent(this);
        }

        private void buildMultiAuthorizeEvent() {
            this.mValue = this.mSuccessCall;
            addExt("isAuthorized", this.mIsAuthorized);
            addExt(MultiAuthorizeStatisticManager.EXT_IS_USER_LOGIN, this.mIsUserLogin);
            addExt(MultiAuthorizeStatisticManager.EXT_IS_COMPLETE_LOGIN, this.mIsCompleteLogin);
            addExt(MultiAuthorizeStatisticManager.EXT_IS_USER_CERTIFICATED, this.mIsUserCertificated);
            addExt(MultiAuthorizeStatisticManager.EXT_IS_AUTHORIZE_BTN_CONFIRM, this.mIsAuthorizeBtnConfirm);
            addExt(MultiAuthorizeStatisticManager.EXT_IS_COMPLETE_CERTIFICATED, this.mIsCompleteCertificated);
            MultiAuthorizeStatisticManager.addStatisticCommonParam(this);
        }
    }
}
