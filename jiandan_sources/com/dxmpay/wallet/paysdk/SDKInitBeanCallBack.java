package com.dxmpay.wallet.paysdk;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.DebugConfig;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import fe.i.ad.rg.qw.qw;
import org.json.JSONException;
import org.json.JSONObject;

public class SDKInitBeanCallBack implements IBeanResponseCallback {

    /* renamed from: th  reason: collision with root package name */
    public static volatile boolean f4345th = true;

    /* renamed from: yj  reason: collision with root package name */
    public static volatile boolean f4346yj = true;

    /* renamed from: ad  reason: collision with root package name */
    public Context f4347ad;

    public SDKInitBeanCallBack(Context context) {
        this.f4347ad = context;
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        if (f4346yj) {
            f4346yj = false;
            qw qwVar = new qw(this.f4347ad.getApplicationContext());
            qwVar.setResponseCallback(this);
            qwVar.execBean();
            EventBus instance = EventBus.getInstance();
            EventBus instance2 = EventBus.getInstance();
            instance2.getClass();
            instance.postStickyEvent(new EventBus.Event(BeanConstants.SDKINIT_FAIL_EVENTBUS_EVENTKEY, (Object) null));
            EventBus instance3 = EventBus.getInstance();
            EventBus instance4 = EventBus.getInstance();
            instance4.getClass();
            instance3.postStickyEvent(new EventBus.Event(BeanConstants.SDKINIT_EVENTBUS_EVENTKEY, this.f4347ad.getApplicationContext()));
        }
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        boolean z;
        if (f4345th) {
            f4345th = false;
            if (obj instanceof SdkInitResponse) {
                SdkInitResponse sdkInitResponse = (SdkInitResponse) obj;
                if (!TextUtils.isEmpty(sdkInitResponse.domainConfig)) {
                    try {
                        new JSONObject(sdkInitResponse.domainConfig);
                        z = true;
                    } catch (JSONException e) {
                        LogUtil.e("SDKInitBeanCallBack", e.getMessage(), e);
                        z = false;
                    }
                    if (z) {
                        if (DebugConfig.getInstance().isOnline()) {
                            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, sdkInitResponse.domainConfig);
                            SharedPreferencesUtils.setParam(this.f4347ad.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                        } else {
                            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, sdkInitResponse.domainConfig);
                            SharedPreferencesUtils.setParam(this.f4347ad.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                        }
                    }
                }
                if (!TextUtils.isEmpty(sdkInitResponse.domainSwitch)) {
                    if (TextUtils.equals("1", sdkInitResponse.domainSwitch)) {
                        if (DebugConfig.getInstance().isOnline()) {
                            SharedPreferencesUtils.setParam(this.f4347ad.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                        } else {
                            SharedPreferencesUtils.setParam(this.f4347ad.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                        }
                        fe.i.qw.de.qw.i().uk(true);
                    } else {
                        if (DebugConfig.getInstance().isOnline()) {
                            SharedPreferencesUtils.setParam(this.f4347ad.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                        } else {
                            SharedPreferencesUtils.setParam(this.f4347ad.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                        }
                        fe.i.qw.de.qw.i().uk(false);
                    }
                }
                EventBus instance = EventBus.getInstance();
                EventBus instance2 = EventBus.getInstance();
                instance2.getClass();
                instance.postStickyEvent(new EventBus.Event(BeanConstants.SDKINIT_EVENTBUS_EVENTKEY, this.f4347ad.getApplicationContext()));
            }
        }
    }
}
