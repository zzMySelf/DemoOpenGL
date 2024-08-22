package com.baidu.wallet.paysdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.e;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BindCardEntry implements IBeanResponseCallback {
    public Handler a;
    public PayRequestCache.BindCategory b;
    public String c;
    public WeakReference<? extends Context> d;
    public e e;
    public OnReturn f;
    public WelcomeActivity g;
    public boolean h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3594i;

    public interface OnReturn {
        void onFailed(int i2, String str);

        void onResponse(CardAddResponse cardAddResponse);
    }

    public static class SingletonHolder {
        public static BindCardEntry sInstance = new BindCardEntry();
    }

    public static BindFastRequest createBindRequest(PayRequestCache.BindCategory bindCategory) {
        BindFastRequest bindFastRequest = new BindFastRequest();
        if (bindCategory == null || PayRequestCache.BindCategory.Other == bindCategory) {
            throw new IllegalStateException("not support bind card for Paying");
        }
        SingletonHolder.sInstance.b = bindCategory;
        PayRequestCache.getInstance().addBeanRequestToCache(bindCategory.name(), bindFastRequest);
        SingletonHolder.sInstance.e.a(bindFastRequest);
        return bindFastRequest;
    }

    public static OnReturn createCb4CheckPwdAndBind(Context context, BaiduPay.IBindCardCallback iBindCardCallback, Bundle bundle, boolean z, String str) {
        final boolean z2 = z;
        final String str2 = str;
        final Context context2 = context;
        final BaiduPay.IBindCardCallback iBindCardCallback2 = iBindCardCallback;
        final Bundle bundle2 = bundle;
        return new OnReturn() {
            public void onFailed(int i2, String str) {
                BaiduPay.IBindCardCallback iBindCardCallback = iBindCardCallback2;
                if (iBindCardCallback != null) {
                    iBindCardCallback.onChangeFailed(str);
                }
                BaiduPay.getInstance().clearBindCallbackExt();
            }

            public void onResponse(CardAddResponse cardAddResponse) {
                UserData.UserModel userModel;
                Activity loadingUi = BindCardEntry.getLoadingUi();
                if (loadingUi == null) {
                    return;
                }
                if (!z2 || (userModel = cardAddResponse.user) == null || !userModel.hasMobilePwd()) {
                    Context loadingUi2 = BindCardEntry.getLoadingUi();
                    if (loadingUi2 == null) {
                        loadingUi2 = context2;
                    }
                    BaiduPay.getInstance().launchBindCardActivity(loadingUi2, iBindCardCallback2, bundle2);
                    return;
                }
                PasswordController.getPassWordInstance().checkPwd(loadingUi, str2, new PasswordController.IPwdListener() {
                    public void onFail(int i2, String str) {
                        String sessionId = StatHelper.getSessionId();
                        List<String> collectData = StatHelper.collectData(sessionId, i2 + "", str);
                        HashMap hashMap = new HashMap();
                        hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
                        StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, (Collection<String>) collectData, (Map<String, Object>) hashMap);
                        BaiduPay.IBindCardCallback iBindCardCallback = iBindCardCallback2;
                        if (iBindCardCallback != null) {
                            iBindCardCallback.onChangeFailed(str);
                        }
                        PasswordController.getPassWordInstance().clearCheckPwdListener();
                        BaiduPay.getInstance().clearBindCallbackExt();
                    }

                    public void onSucceed(String str) {
                        PasswordController.getPassWordInstance().clearCheckPwdListener();
                        Context loadingUi = BindCardEntry.getLoadingUi();
                        if (loadingUi == null) {
                            loadingUi = context2;
                        }
                        BaiduPay instance = BaiduPay.getInstance();
                        AnonymousClass3 r1 = AnonymousClass3.this;
                        instance.launchBindCardActivity(loadingUi, iBindCardCallback2, bundle2);
                    }
                });
            }
        };
    }

    public static PayRequestCache.BindCategory getBindScenario() {
        return SingletonHolder.sInstance.b;
    }

    public static Activity getLoadingUi() {
        if (SingletonHolder.sInstance.g == null) {
            return null;
        }
        return SingletonHolder.sInstance.g.getActivity();
    }

    public static void init(Context context) {
        if (context instanceof Activity) {
            SingletonHolder.sInstance.d = new WeakReference<>(context);
        } else if (context instanceof BaseActivity) {
            Activity activity = ((BaseActivity) context).getActivity();
            SingletonHolder.sInstance.d = new WeakReference<>(activity);
        } else {
            SingletonHolder.sInstance.d = null;
        }
        EventBus.getInstance().register((Object) SingletonHolder.sInstance, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        SingletonHolder.sInstance.e.setResponseCallback(SingletonHolder.sInstance);
    }

    public static void innerRun() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(SingletonHolder.sInstance.c)) {
            sb.append(SingletonHolder.sInstance.c);
            sb.setCharAt(sb.length() - 1, ',');
        } else {
            sb.append(StringUtil.ARRAY_START);
        }
        sb.append("request_type:");
        if (SingletonHolder.sInstance.b == null) {
            sb.append(PayRequestCache.BindCategory.Initiative.getScenario());
        } else {
            sb.append(SingletonHolder.sInstance.b.getScenario());
        }
        sb.append("}");
        SingletonHolder.sInstance.e.a(sb.toString());
        SingletonHolder.sInstance.e.execBean();
    }

    public static void newBindCardEventEndWithValues(String str, String str2) {
        a.a(str, "Pass强授权页", "paySDKInitiativeBindCardH5PassPage", str2, new String[0]);
    }

    public static void run() {
        Activity activity;
        Context context = SingletonHolder.sInstance.d != null ? (Context) SingletonHolder.sInstance.d.get() : null;
        if (context != null) {
            if (SingletonHolder.sInstance.e.a() != null) {
                Intent intent = new Intent(context, WelcomeActivity.class);
                intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 4);
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
                return;
            }
            throw new RuntimeException("should call createBindRequest() before running");
        }
    }

    public static void setCallback(OnReturn onReturn) {
        SingletonHolder.sInstance.f = onReturn;
    }

    public static void setExtrParam(String str) {
        SingletonHolder.sInstance.c = str;
    }

    public static void setLoadingUi(WelcomeActivity welcomeActivity) {
        SingletonHolder.sInstance.g = welcomeActivity;
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        CardAddResponse.updateContent((Object) null);
        StatHelper.clearSensor();
        if (SingletonHolder.sInstance.b == PayRequestCache.BindCategory.Initiative) {
            String b2 = b();
            List<String> collectData = StatHelper.collectData(b2, "cardAdd is failed");
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.BIND_CARD_USER_TYPE, "-1");
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, (Collection<String>) StatHelper.collectData(b2, i3 + "", str), (Map<String, Object>) hashMap);
        }
        if (this.f != null) {
            this.a.obtainMessage(2, i3, 0, str).sendToTarget();
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        CardAddResponse.updateContent((Object) null);
        if (i3 != 16254 || obj == null || !(obj instanceof CardAddErrorContent) || SingletonHolder.sInstance.g == null) {
            SingletonHolder.sInstance.a.obtainMessage(2, i3, 0, str).sendToTarget();
            return;
        }
        CardAddErrorContent cardAddErrorContent = (CardAddErrorContent) obj;
        if (!TextUtils.isEmpty(cardAddErrorContent.goto_url)) {
            newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_ENTER, "进入");
            AnonymousClass2 r6 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    pop();
                    if (!SingletonHolder.sInstance.h) {
                        BindCardEntry.newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_FAILED, "用户取消授权");
                        boolean unused = BindCardEntry.this.f3594i = false;
                        SingletonHolder.sInstance.a.obtainMessage(2, -1, 0, "").sendToTarget();
                    }
                    boolean unused2 = SingletonHolder.sInstance.h = false;
                }
            };
            r6.push();
            EventBus.getInstance().register((Object) SingletonHolder.sInstance, DxmPayBeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT, 0, EventBus.ThreadMode.MainThread);
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", cardAddErrorContent.goto_url + "?is_from_sdk=1");
            bundle.putParcelable("lifecycleLsnr", r6);
            BaiduWalletDelegate.getInstance().openH5Module((Context) SingletonHolder.sInstance.g, bundle);
            SingletonHolder.sInstance.g.finishWithoutAnim();
            SingletonHolder.sInstance.g = null;
            return;
        }
        SingletonHolder.sInstance.a.obtainMessage(2, i3, 0, str).sendToTarget();
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        UserData.UserModel userModel;
        CardAddResponse.updateContent(obj);
        StatHelper.clearSensor();
        if (SingletonHolder.sInstance.b == PayRequestCache.BindCategory.Initiative) {
            String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(NetworkBean.BizType.BindCard);
            StatHelper.cacheSessionId(sessionId);
            CardAddResponse cardAddResponse = (CardAddResponse) obj;
            if (cardAddResponse == null || (userModel = cardAddResponse.user) == null || 1 != userModel.has_mobile_password) {
                StatHelper.cacheBindCardUserType("0");
            } else {
                StatHelper.cacheBindCardUserType("1");
            }
            List<String> collectData = StatHelper.collectData(sessionId, new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        }
        if (this.f != null) {
            this.a.sendEmptyMessage(0);
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null) {
            if (event.mEventKey.equals("ev_bean_execut_err_content")) {
                Object obj = event.mEventObj;
                if (obj instanceof BeanErrorContent) {
                    BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                    onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                    EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
                    return;
                }
            }
            if (DxmPayBeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT.equals(event.mEventKey) && SingletonHolder.sInstance.d != null && SingletonHolder.sInstance.d.get() != null) {
                if (event.mEventObj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                        if (!jSONObject.has("confirm_result") || 1 != jSONObject.getInt("confirm_result")) {
                            newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_FAILED, "用户取消授权");
                            this.f3594i = false;
                            SingletonHolder.sInstance.a.obtainMessage(2, -1, 0, "").sendToTarget();
                            return;
                        }
                        newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_AGREE, "用户同意授权");
                        SingletonHolder.sInstance.h = true;
                        init((Context) SingletonHolder.sInstance.d.get());
                        run();
                    } catch (Exception e2) {
                        LogUtil.e("BindCardEntry", e2.getMessage(), e2);
                    }
                } else {
                    newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_FAILED, "用户取消授权");
                    this.f3594i = false;
                    SingletonHolder.sInstance.a.obtainMessage(2, -1, 0, "").sendToTarget();
                }
            }
        }
    }

    public BindCardEntry() {
        this.b = null;
        this.h = false;
        this.f3594i = true;
        e eVar = new e(BaiduWalletDelegate.getInstance().getAppContext());
        this.e = eVar;
        eVar.setResponseCallback(this);
        this.a = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (1 == i2) {
                    if (BindCardEntry.this.f != null) {
                        BindCardEntry.this.f.onResponse(CardAddResponse.getInstance());
                    }
                    if (BindCardEntry.this.g != null) {
                        BindCardEntry.this.g.finishWithoutAnim();
                        WelcomeActivity unused = BindCardEntry.this.g = null;
                    }
                    BindCardEntry.this.a();
                } else if (i2 == 0) {
                    boolean z = false;
                    CardAddResponse.ConfirmWindow confirmWindow = CardAddResponse.getInstance().confirm_window;
                    if (!(confirmWindow == null || BindCardEntry.this.g == null || TextUtils.isEmpty(confirmWindow.content))) {
                        PromptTipDialog promptTipDialog = new PromptTipDialog(BindCardEntry.this.g);
                        promptTipDialog.setTitleMessage(confirmWindow.title);
                        promptTipDialog.setMessage(confirmWindow.content);
                        promptTipDialog.setButtonMessage(TextUtils.isEmpty(confirmWindow.btn_name) ? "确认" : confirmWindow.btn_name);
                        promptTipDialog.setDefaultBtnListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                AnonymousClass1.this.sendEmptyMessage(1);
                            }
                        });
                        promptTipDialog.show();
                        z = true;
                    }
                    if (!z) {
                        sendEmptyMessage(1);
                    }
                } else if (2 == i2) {
                    if (BindCardEntry.this.f3594i) {
                        BindCardEntry.this.a(message.arg1, (String) message.obj);
                    }
                    if (BindCardEntry.this.f != null) {
                        BindCardEntry.this.f.onFailed(message.arg1, (String) message.obj);
                    }
                    if (BindCardEntry.this.g != null) {
                        BindCardEntry.this.g.finishWithoutAnim();
                        WelcomeActivity unused2 = BindCardEntry.this.g = null;
                    }
                    BindCardEntry.this.a();
                }
            }
        };
    }

    private String b() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f = null;
        this.d = null;
        this.c = null;
        this.b = null;
        this.e.a((BindFastRequest) null);
        this.h = false;
        this.f3594i = true;
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
        EventBus.getInstance().unregister((Object) this, DxmPayBeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        Context appContext = BaiduWalletDelegate.getInstance().getAppContext();
        if (i2 == 5003) {
            GlobalUtils.toast(appContext, ResUtils.getString(appContext, "dxm_wallet_base_please_login"));
            AccountManager.getInstance(appContext).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (-2 == i2 || -3 == i2) {
            GlobalUtils.toast(appContext, ResUtils.getString(appContext, "dxm_fp_get_data_fail"));
        } else if (-8 == i2) {
            GlobalUtils.toast(appContext, ResUtils.getString(appContext, "dxm_ebpay_no_network"));
        } else {
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(appContext, "dxm_fp_get_data_fail");
            }
            GlobalUtils.toast(appContext, str);
        }
    }
}
