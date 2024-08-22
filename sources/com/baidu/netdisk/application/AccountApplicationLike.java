package com.baidu.netdisk.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.account.broadcast.BroadcastParams;
import com.baidu.netdisk.base.NetdiskCommonConfig;
import com.baidu.netdisk.base.network.ServerURL;
import com.baidu.netdisk.component.base.applicationlike.IApplicationLike;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;

public class AccountApplicationLike implements IApplicationLike {
    public static final String ACTION_SILENT_SHARE = "com.baidu.intent.action.SILENT_SHARE";
    private static final String CUSTOM_THEME_URL = "file:///android_asset/sapi_theme/style.css";
    private static final String MOBILE_APPID = "300011878593";
    private static final String MOBILE_APPKEY = "CF289DA2ED0AE28D16CD665FC1CC2BC8";
    public static final String QQ_APP_ID = "101455621";
    public static final String QQ_APP_KEY = "a7c4dc6a017f9c2df8e14a0ba3e024c4";
    public static final String SINA_APP_ID = "1003443695";
    private static boolean isInited = false;
    public static Context mContext;
    public static boolean mIsLogin = false;
    private BroadcastReceiver mLoginReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (BroadcastParams.ACTION_LOGIN.equals(intent.getAction())) {
                    AccountApplicationLike.mIsLogin = true;
                } else if (BroadcastParams.ACTION_LOGOUT.equals(intent.getAction())) {
                    AccountApplicationLike.mIsLogin = false;
                    LoginRegisterManager.getInstance().logoutBdussInvalid();
                }
            }
        }
    };

    public void onAttachContext(Context context) {
    }

    public void onPreSyncInit(Context context) {
        mContext = context;
        if (!isInited) {
            AccountUtils.init(NetdiskCommonConfig.TPL, NetdiskCommonConfig.APPID, NetdiskCommonConfig.KEY);
            isInited = true;
        }
        initSapi();
    }

    public void onPostSyncInit(Context context) {
    }

    public void onAsyncInit(Context context) {
    }

    public void onAsyncDelayedInit(Context context) {
    }

    public void onFirstActivityCreated(Context context) {
    }

    public void onDestroy(Context context) {
    }

    private void initSapi() {
        NetDiskLog.d("AccountApplicationLike", "initSapi");
        SapiConfiguration.Builder builder = new SapiConfiguration.Builder(mContext).setProductLineInfo(ServerURL.getPassportTPL(), ServerURL.getPassportAppId(), ServerURL.getPassportKey()).sofireSdkConfig(AccountUtils.SDK_APP_KEY, AccountUtils.SDK_SECRET_KEY, AccountUtils.SDK_WHO).setRuntimeEnvironment(ServerURL.getRunningEnv()).initialShareStrategy(LoginShareStrategy.CHOICE).customActionBar(true).fastLoginSupport(FastLoginFeature.SINA_WEIBO_SSO).sinaAppID(SINA_APP_ID).bdOauthAppId("Q6jUhhFRI1qFXto3S2fU3enc").smsLoginConfig(new SapiConfiguration.SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF)).skin(CUSTOM_THEME_URL).chinaTelecomOauthConfig("8238411023", "SQ4c5RX970xhxL9R5X9wig438nltbhxP").debug(false);
        if (!isWXInstalled()) {
            builder.fastLoginSupport(FastLoginFeature.TX_QQ_SSO).qqAppID(QQ_APP_ID);
        }
        SapiAccountManager.getInstance().init(builder.chinaMobileOauthConfig(MOBILE_APPID, MOBILE_APPKEY).build());
    }

    public boolean isWXInstalled() {
        return true;
    }
}
