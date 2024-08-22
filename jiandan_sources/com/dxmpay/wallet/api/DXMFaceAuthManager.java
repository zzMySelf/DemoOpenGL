package com.dxmpay.wallet.api;

import android.content.Context;
import android.text.TextUtils;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.ChannelUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.DebugConfig;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.statistics.impl.SensorsSyncHttpImpl;
import com.dxmpay.wallet.statistics.impl.StatConfig;
import com.dxmpay.wallet.utils.BdWalletUtils;
import fe.i.qw.de.qw;

public class DXMFaceAuthManager implements IFaceAuthAPI {

    public static class SingletonHolder {
        public static final DXMFaceAuthManager instance = new DXMFaceAuthManager();
    }

    public static DXMFaceAuthManager getInstance() {
        return SingletonHolder.instance;
    }

    private void initDomain(Context context) {
        if (DebugConfig.getInstance().isOnline()) {
            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", ""));
            if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                qw.i().uk(true);
                return;
            }
            return;
        }
        DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", ""));
        if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
            qw.i().uk(true);
        }
    }

    private void initStatAndLoadFp(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                if (SecurePay.getInstance().prepareCompleted()) {
                    StatApi.init(context.getApplicationContext(), StatConfig.getInstance(context.getApplicationContext()));
                    StatApi.setSyncHttpImpl(new SensorsSyncHttpImpl());
                    BdWalletUtils.loadDeviceFP(context.getApplicationContext());
                }
            }
        }, "DxmPaySDK").start();
    }

    private void initUA(String str) {
        BeanConstants.CHANNEL_ID = str;
        String str2 = "BaiduWallet-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
        BeanConstants.SDK_VERSION = str2;
        ChannelUtils.initBussinessParams(str2, false);
    }

    public void initFaceAuth(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The channel ID can not be empty.");
        } else if (context != null) {
            initUA(str);
            initDomain(context);
            initStatAndLoadFp(context);
        } else {
            throw new IllegalArgumentException("The context can not be empty.");
        }
    }

    public void setDebugOn(Context context, boolean z) {
        if (z) {
            DebugConfig.getInstance(context).changeQA();
        } else {
            DebugConfig.getInstance(context).changeOnline();
        }
    }

    public DXMFaceAuthManager() {
    }
}
