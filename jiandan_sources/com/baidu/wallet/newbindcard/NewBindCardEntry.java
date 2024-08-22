package com.baidu.wallet.newbindcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;

public class NewBindCardEntry {
    public static final String BING_CARD_SUCCESS_MSG = "ok";
    public static final String BING_CARD_SUCCESS_STATUS = "0";
    public static final String TAG = "NewBindCardEntry";
    public String mBindCardNo;
    public PayRequestCache.BindCategory mBindCategory;
    public BindFastRequest mBindReq;
    public String mExtraParam;
    public boolean mH5BindCardSuccess;
    public BeanResponseBase.Session mSession;

    public static class SingletonHolder {
        public static final NewBindCardEntry INSTANCE = new NewBindCardEntry();
    }

    public static NewBindCardEntry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public PayRequestCache.BindCategory getBindCategory() {
        return this.mBindCategory;
    }

    public BindFastRequest getBindReq() {
        return this.mBindReq;
    }

    public String getExtraParam() {
        return this.mExtraParam;
    }

    public BeanResponseBase.Session getSession() {
        return this.mSession;
    }

    public void newBindCardCallback(String str, String str2, boolean z) {
        if (!z) {
            a.a(PayStatServiceEvent.NEW_BIND_CARD_RESULT, "结果页面", "paySDKInitiativeBindCardResultPage", "绑卡结果", a.a(), a.b(), a.c(), a.d(), str, str2, a.e(), "0", a.f());
        }
        BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
        if (bindCallback != null) {
            if ("0".equals(str)) {
                bindCallback.onChangeSucceed(str2);
            } else {
                bindCallback.onChangeFailed("");
            }
        }
        if (this.mBindCategory != null) {
            PayRequestCache.getInstance().removeBeanRequestFromCache(this.mBindCategory.name());
        }
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null) {
            bindFastRequest.setmBankInfo((GetCardInfoResponse) null);
        }
        this.mBindReq = null;
        this.mExtraParam = null;
        this.mBindCardNo = null;
        this.mSession = null;
        a.g();
        BaiduPay.getInstance().clearBindCallback();
        BaiduPay.getInstance().clearBindCallbackExt();
        PayBaseBeanActivity.exitActiveBindCard();
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null) {
            if ((DxmPayBeanConstants.EVENT_H5_QUICK_BIND_CARD.equals(event.mEventKey) || DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE.equals(event.mEventKey)) && event.mEventObj != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has("bind_card_result")) {
                        if (1 == jSONObject.getInt("bind_card_result")) {
                            this.mH5BindCardSuccess = true;
                            this.mBindCardNo = jSONObject.optString("card_no", "");
                            a.a(PayStatServiceEvent.NEW_H5_BIND_CARD_SUCCESS, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "H5主动绑卡成功", "1");
                            return;
                        }
                    }
                    if (jSONObject.has("type") && 1 == jSONObject.getInt("type")) {
                        this.mH5BindCardSuccess = true;
                        this.mBindCardNo = jSONObject.optString("card_no", "");
                        a.a(PayStatServiceEvent.NEW_H5_BIND_CARD_SUCCESS, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "H5主动绑卡成功", "0");
                    }
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage(), e);
                }
            }
        }
    }

    public void setExtrParam(String str) {
        this.mExtraParam = str;
    }

    public void setSession(BeanResponseBase.Session session) {
        this.mSession = session;
    }

    public void startH5BindCard(Context context, BaiduPay.IBindCardCallback iBindCardCallback, String str) {
        if (iBindCardCallback != null) {
            if (context == null) {
                iBindCardCallback.onChangeFailed("context is null");
                return;
            }
            a.a(PayStatServiceEvent.NEW_ENTER_H5_BIND_CARD, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "进入H5主动绑卡", new String[0]);
            BaiduPay.getInstance().setBindCallback(iBindCardCallback);
            String h5BindCardUrl = SdkInitResponse.getInstance().getH5BindCardUrl(context);
            if (TextUtils.isEmpty(h5BindCardUrl)) {
                h5BindCardUrl = DxmPayBeanConstants.API_H5_BIND_CARD_URL;
            }
            AnonymousClass1 r1 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    EventBus.getInstance().unregister((Object) NewBindCardEntry.this, DxmPayBeanConstants.EVENT_H5_QUICK_BIND_CARD);
                    EventBus.getInstance().unregister((Object) NewBindCardEntry.this, DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE);
                    pop();
                    BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
                    if (bindCallback != null) {
                        if (NewBindCardEntry.this.mH5BindCardSuccess) {
                            bindCallback.onChangeSucceed(NewBindCardEntry.this.mBindCardNo);
                        } else {
                            bindCallback.onChangeFailed("");
                        }
                    }
                    boolean unused = NewBindCardEntry.this.mH5BindCardSuccess = false;
                    a.g();
                    BaiduPay.getInstance().clearBindCallback();
                    PayBaseBeanActivity.exitActiveBindCard();
                }
            };
            Bundle bundle = new Bundle();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(h5BindCardUrl);
            if (TextUtils.isEmpty(str)) {
                stringBuffer.append("0");
            } else {
                stringBuffer.append(str);
            }
            stringBuffer.append("&is_from_sdk=1");
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", stringBuffer.toString());
            bundle.putParcelable("lifecycleLsnr", r1);
            stringBuffer.toString();
            r1.push();
            EventBus.getInstance().register((Object) this, DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE, 0, EventBus.ThreadMode.MainThread);
            EventBus.getInstance().register((Object) this, DxmPayBeanConstants.EVENT_H5_QUICK_BIND_CARD, 0, EventBus.ThreadMode.MainThread);
            BaiduWalletDelegate.getInstance().openH5Module(context, bundle);
        }
    }

    public void startNewBindCard(Context context, BaiduPay.IBindCardCallback iBindCardCallback, PayRequestCache.BindCategory bindCategory, BindFastRequest bindFastRequest) {
        if (iBindCardCallback != null) {
            if (context == null || bindCategory == null) {
                iBindCardCallback.onChangeFailed("context is null");
                return;
            }
            BaiduPay.getInstance().setBindCallback(iBindCardCallback);
            this.mBindReq = bindFastRequest;
            this.mBindCategory = bindCategory;
            PayRequestCache.getInstance().addBeanRequestToCache(this.mBindCategory.name(), this.mBindReq);
            startWelcomeActivity(context);
        }
    }

    public void startWelcomeActivity(Context context) {
        Activity activity;
        Intent intent = new Intent(context, WelcomeActivity.class);
        intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 5);
        if (BaiduWalletUtils.isActivity(context)) {
            if (context instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) context;
                baseActivity.startActivityWithoutAnim(intent);
                activity = baseActivity.getActivity();
            } else {
                context.startActivity(intent);
                activity = (Activity) context;
            }
            BaiduWalletUtils.overridePendingTransitionNoAnim(activity);
            return;
        }
        intent.addFlags(268435456);
        context.getApplicationContext().startActivity(intent);
    }

    public NewBindCardEntry() {
        this.mH5BindCardSuccess = false;
    }
}
