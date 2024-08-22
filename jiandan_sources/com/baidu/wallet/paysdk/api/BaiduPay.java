package com.baidu.wallet.paysdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.android.pay.ScanCodeCallBack;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.CheckCallBack;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.beans.VerifyPayPasswordBean;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.UserInfoContentResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyPayPasswordResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.baidu.wallet.remotepay.RemotePaySplashActivity;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class BaiduPay {
    public static final String AMOUNT = "pay_amount";
    public static final String PAY_FROM = "pay_from";
    public static final String PAY_FROM_AUTHORIZE = "pay_from_authorize";
    public static final String PAY_FROM_BIND_CARD = "pay_from_bind_card";
    public static final String PAY_FROM_HUA_FEI = "pay_from_huafei";
    public static final String PAY_FROM_HUA_ZHUAN_ZHANG = "pay_from_zhuanzhang";
    public static final String PAY_TYPE_KEY = "type";
    public static final String PRECASHIER_PAY_RESPONSE = "precashier_pay_response";
    public static final int TYPE_FASE_PAY = 4;
    public static final int TYPE_PAY_ALL = 0;
    public static final int TYPE_SURPLUS = 1;
    public PayCallBack a;
    public IBindCardCallback b;
    public RNAuthCallBack c;
    public boolean d;
    public a e;
    public ScanCodeCallBack f;
    public Context g;

    public interface IBindCardCallback {
        void onChangeFailed(String str);

        void onChangeSucceed(String str);
    }

    public static class a implements BindBack {
        public final BindBack a;
        public boolean b;

        public boolean isHideLoadingDialog() {
            return false;
        }

        public void onBindResult(int i2, String str) {
            BindBack bindBack = this.a;
            if (bindBack != null) {
                bindBack.onBindResult(i2, str);
            }
            this.b = false;
        }

        public a(BindBack bindBack) {
            this.b = true;
            this.a = bindBack;
        }
    }

    public static class b {
        public static BaiduPay a = new BaiduPay();
    }

    private void b(Context context) {
        boolean isRemotePay = PayDataCache.getInstance().isRemotePay();
        Context remotePayContext = getInstance().getRemotePayContext();
        boolean isFromPreCashier = PayDataCache.getInstance().isFromPreCashier();
        if (!isRemotePay) {
            clearPayBack();
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().3");
        } else {
            PayCallBackManager.callBackClientClear(context, "BaiduPay.innerPay().4");
            clearPayBack();
            PayDataCache.getInstance().setIsRemotePay(true);
            getInstance().setRemotePayContext(remotePayContext);
        }
        if (isFromPreCashier) {
            PayDataCache.getInstance().setFromPreCashier();
        }
    }

    public static BaiduPay getInstance() {
        return b.a;
    }

    public void bindCard(Context context, IBindCardCallback iBindCardCallback, PayRequestCache.BindCategory bindCategory, int i2, String str, String str2, Bundle bundle, String str3, boolean z, String str4) {
        if (bindCategory == null || PayRequestCache.BindCategory.Other == bindCategory) {
            throw new IllegalStateException("not support bind card for Paying");
        } else if (context != null) {
            com.baidu.wallet.newbindcard.c.a.g();
            com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_BIND_CARD_ENTER, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "进入", new String[0]);
            if ("1".equals(SdkInitResponse.getInstance().getUseH5BindCard(context))) {
                NewBindCardEntry.getInstance().startH5BindCard(context, iBindCardCallback, str);
                return;
            }
            BindFastRequest bindFastRequest = new BindFastRequest();
            bindFastRequest.mBindFrom = i2;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str2)) {
                bindFastRequest.setSp_no(str2);
                sb.append("sp_no:\"");
                sb.append(str2);
                sb.append("\",");
            }
            if (!TextUtils.isEmpty(str)) {
                bindFastRequest.serviceType = str;
                sb.append("service_type:\"");
                sb.append(str);
                sb.append("\"}");
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("baidu.wallet.from", bindCategory.name());
            if (!TextUtils.isEmpty(str3)) {
                if (sb.length() > 0) {
                    sb.insert(0, str3);
                    sb.setCharAt(str3.length() - 1, ',');
                    sb.setCharAt(sb.length() - 1, ExtendedMessageFormat.END_FE);
                } else {
                    sb.append(str3);
                }
            } else if (sb.length() > 0) {
                sb.insert(0, StringUtil.ARRAY_START).setCharAt(sb.length() - 1, ExtendedMessageFormat.END_FE);
            }
            if (sb.length() > 0) {
                NewBindCardEntry.getInstance().setExtrParam(sb.toString());
            }
            NewBindCardEntry.getInstance().startNewBindCard(context, iBindCardCallback, bindCategory, bindFastRequest);
        } else if (iBindCardCallback != null) {
            iBindCardCallback.onChangeFailed("");
        }
    }

    public void bindCardAuth(Context context, boolean z) {
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBindFrom = 6;
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, BindCardImplActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, z);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void bindCardOnCardaddReturn(Context context, BindCardEntry.OnReturn onReturn, PayRequestCache.BindCategory bindCategory, int i2, String str, String str2) {
        if (onReturn != null) {
            if (context == null) {
                onReturn.onFailed(-1, "context null");
                return;
            }
            BindCardEntry.init(context);
            BindCardEntry.setCallback(onReturn);
            BindCardEntry.setExtrParam(str2);
            BindFastRequest createBindRequest = BindCardEntry.createBindRequest(bindCategory);
            createBindRequest.mBindFrom = i2;
            if (!TextUtils.isEmpty(str)) {
                createBindRequest.serviceType = str;
            }
            BindCardEntry.run();
        }
    }

    public void checkPwd(final Context context, final CheckCallBack checkCallBack) {
        UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean(context, 6, "userinfo");
        userInfoBean.setResponseCallback(new IBeanResponseCallback() {
            public final Handler a = new Handler(context.getMainLooper());

            public void onBeanExecFailure(int i2, int i3, final String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.a.post(new Runnable() {
                    public void run() {
                        checkCallBack.onCheckResult(3, str);
                    }
                });
            }

            public void onBeanExecSuccess(int i2, final Object obj, String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.a.post(new Runnable() {
                    public void run() {
                        UserInfoContentResponse.UserBean userBean;
                        UserInfoContentResponse userInfoContentResponse = (UserInfoContentResponse) obj;
                        if (userInfoContentResponse == null || (userBean = userInfoContentResponse.user_info) == null || !userBean.hasMobilePwd()) {
                            checkCallBack.onCheckResult(1, "当前未设置手机支付密码");
                        } else {
                            PasswordController.getPassWordInstance().checkPwd(context, DxmPayBeanConstants.FROM_COMMON_CHECK_PWD, new PasswordController.IPwdListener() {
                                public void onFail(int i2, String str) {
                                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                                    checkCallBack.onCheckResult(2, QueryResponse.Options.CANCEL);
                                }

                                public void onSucceed(String str) {
                                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                                    checkCallBack.onCheckResult(0, "Success");
                                }
                            });
                        }
                    }
                });
            }
        });
        userInfoBean.execBean();
        if (context != null && (context instanceof Activity)) {
            WalletGlobalUtils.showLoadingDialog(context);
        }
    }

    public void checkPwdFromH5(final Context context, final String str, final CheckCallBack checkCallBack) {
        VerifyPayPasswordBean verifyPayPasswordBean = (VerifyPayPasswordBean) PayBeanFactory.getInstance().getBean(context, 600, "userHasPayPassword");
        verifyPayPasswordBean.setResponseCallback(new IBeanResponseCallback() {
            public final Handler a = new Handler(context.getMainLooper());

            public void onBeanExecFailure(int i2, int i3, final String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.a.post(new Runnable() {
                    public void run() {
                        checkCallBack.onCheckResult(3, str);
                    }
                });
            }

            public void onBeanExecSuccess(int i2, final Object obj, String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.a.post(new Runnable() {
                    public void run() {
                        VerifyPayPasswordResponse verifyPayPasswordResponse = (VerifyPayPasswordResponse) obj;
                        if (verifyPayPasswordResponse == null || verifyPayPasswordResponse.has_pwd != 1) {
                            checkCallBack.onCheckResult(1, "当前未设置手机支付密码");
                            return;
                        }
                        PasswordController passWordInstance = PasswordController.getPassWordInstance();
                        AnonymousClass4 r1 = AnonymousClass4.this;
                        passWordInstance.checkPwdFromH5(context, str, DxmPayBeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5, new PasswordController.IPwdListener() {
                            public void onFail(int i2, String str) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                checkCallBack.onCheckResult(2, QueryResponse.Options.CANCEL);
                            }

                            public void onSucceed(String str) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                checkCallBack.onCheckResult(0, str);
                            }
                        });
                    }
                });
            }
        });
        verifyPayPasswordBean.execBean();
        if (context != null && (context instanceof Activity)) {
            WalletGlobalUtils.showLoadingDialog(context);
        }
    }

    public void clearBindCallback() {
        this.b = null;
    }

    public void clearBindCallbackExt() {
        this.e = null;
    }

    public void clearPayBack() {
        this.a = null;
    }

    public void clearRNAuthBack() {
        this.c = null;
    }

    public void completeCardAuth(Context context, CardData.BondCard bondCard) {
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBindFrom = 7;
        bindFastRequest.mBondCard = bondCard;
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, BindCardImplActivity.class);
        int a2 = i.a().a(context, bondCard, false);
        if (a2 > 0) {
            intent.putExtra("halfScreen", a2);
        }
        intent.putExtra("reasonForChangeCardItem", 1);
        context.startActivity(intent);
    }

    public void directAuth(Context context, CardData.BondCard bondCard) {
        CardData.BondCard bondCard2;
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBondCard = bondCard;
        bindFastRequest.mBindFrom = 8;
        bindFastRequest.setmBankInfo((GetCardInfoResponse) null);
        bindFastRequest.setmPhone(bondCard.mobile);
        bindFastRequest.setSendSmsphone(bondCard.mobile);
        bindFastRequest.setmBankCard(bondCard.account_no);
        bindFastRequest.setSubBankCode(bondCard.account_bank_code);
        a(bindFastRequest, bondCard);
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, WalletSmsActivity.class);
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null && (bondCard2 = payRequest.mBondCard) != null && bondCard2.hideSMSDialog && PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom)) {
            intent.putExtra("showSMSDialog", false);
        }
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).startActivityWithoutAnim(intent);
        } else {
            context.startActivity(intent);
        }
    }

    public void doBindCardExt(Context context, final BindBack bindBack, Map<String, String> map, String str) {
        String str2;
        String str3;
        Context context2 = context;
        BindBack bindBack2 = bindBack;
        if (map == null || context2 == null) {
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.doBindCardExt().1");
        } else if (!WalletLoginHelper.getInstance().isLogin()) {
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.doBindCardExt().2");
        } else {
            setBindCardbackExt(bindBack);
            if (!map.isEmpty() || !TextUtils.isEmpty(str)) {
                PayDataCache.getInstance().setIsRemotePay(false);
                PayDataCache.getInstance().resetFromPrecashier();
                PayRequest payRequest = new PayRequest();
                payRequest.setPayFrom(PAY_FROM_BIND_CARD);
                if (!TextUtils.isEmpty(str)) {
                    str3 = str;
                    payRequest.initBindCardOrder(str3);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry next : map.entrySet()) {
                        if (sb.length() > 1) {
                            sb.append(com.alipay.sdk.m.s.a.n);
                        }
                        sb.append((String) next.getKey());
                        sb.append("=");
                        sb.append((String) next.getValue());
                    }
                    str3 = sb.toString();
                }
                if (TextUtils.isEmpty(payRequest.mSpNO)) {
                    payRequest.mSpNO = map.get(StatHelper.SP_NO);
                }
                if (TextUtils.isEmpty(payRequest.mOrderNo)) {
                    payRequest.mOrderNo = map.get("order_no");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(payRequest.mSpNO);
                arrayList.add(payRequest.mOrderNo);
                StatisticManager.onEventWithValues(PayStatServiceEvent.DO_BIND_CARD_HAS_ORDERINFO, arrayList);
                payRequest.mParams = str3;
                PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                str2 = com.dxmpay.wallet.utils.StringUtil.urlParam2JsonStr(str3);
            } else {
                str2 = null;
            }
            getInstance().bindCard(context, new IBindCardCallback() {
                public void onChangeFailed(String str) {
                    BindBack bindBack = bindBack;
                    if (bindBack != null) {
                        bindBack.onBindResult(-1, "");
                        StatHelper.clearSensor();
                        return;
                    }
                    BaiduPay.this.setBindCardbackExt((BindBack) null);
                }

                public void onChangeSucceed(String str) {
                    BindBack bindBack = bindBack;
                    if (bindBack != null) {
                        bindBack.onBindResult(0, "");
                        StatHelper.clearSensor();
                        return;
                    }
                    BaiduPay.this.setBindCardbackExt((BindBack) null);
                }
            }, PayRequestCache.BindCategory.Initiative, 1, "", (String) null, (Bundle) null, str2, true, DxmPayBeanConstants.FROM_BIND);
        }
    }

    public void doCheckPwd(Context context, Map<String, String> map, final CheckCallBack checkCallBack) {
        PasswordController.getPassWordInstance().checkPwdForSp(context, map, new PasswordController.IPwdListener() {
            public void onFail(int i2, String str) {
                PasswordController.getPassWordInstance().clearCheckPwdListener();
                checkCallBack.onCheckResult(i2, str);
            }

            public void onSucceed(String str) {
                PasswordController.getPassWordInstance().clearCheckPwdListener();
                checkCallBack.onCheckResult(0, "");
            }
        });
    }

    public void doPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().resetFromPrecashier();
        String orderNo = StatHelper.getOrderNo(str);
        if (orderNo != null && !orderNo.equals(StatHelper.getOrderNo())) {
            StatHelper.clearSensor();
            StatHelper.cachePayFrom("0");
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            BaiduPayDelegate.getInstance().cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
        }
        a(context, str, payCallBack, map, (PrecashierCreateOrderResponse) null);
    }

    public void doPayRNAuth(final Context context, String str, final RNAuthCallBack rNAuthCallBack) {
        if (WalletLoginHelper.getInstance().isLogin() && context != null && !TextUtils.isEmpty(str) && rNAuthCallBack != null) {
            this.g = context;
            this.c = rNAuthCallBack;
            this.d = false;
            AnonymousClass1 r1 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    int i2;
                    String str;
                    pop();
                    EventBus.getInstance().unregister((Object) context, DxmPayBeanConstants.EVENT_H5_RN_AUTH_RESULT);
                    if (BaiduPay.this.d) {
                        str = "RnAuthSuccess";
                        i2 = 0;
                    } else {
                        i2 = -1;
                        str = "RnAuthFail";
                    }
                    String orderNo = StatHelper.getOrderNo();
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_RNAUTH_RESULT, StatHelper.collectData(orderNo, i2 + "", str));
                    rNAuthCallBack.onRNAuthResult(i2, str);
                }
            };
            r1.push();
            EventBus.getInstance().register((Object) context, DxmPayBeanConstants.EVENT_H5_RN_AUTH_RESULT, 0, EventBus.ThreadMode.MainThread);
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", str);
            bundle.putParcelable("lifecycleLsnr", r1);
            BaiduWalletDelegate.getInstance().openH5Module(context, bundle);
        }
    }

    public void doPrecashierPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().setFromPreCashier();
        a(context, str, payCallBack, map, precashierCreateOrderResponse);
    }

    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        if (WalletLoginHelper.getInstance().isLogin() && map != null) {
            this.c = rNAuthCallBack;
            StringBuilder sb = new StringBuilder();
            if (!map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    sb.append((String) next.getKey());
                    sb.append("=");
                    sb.append((String) next.getValue());
                    sb.append(com.alipay.sdk.m.s.a.n);
                }
            }
            sb.append("is_from_sdk=1");
            StringBuilder sb2 = new StringBuilder(DomainConfig.getInstance().getAppPayHost() + "/static/wap/auth/");
            if (sb.length() > 0) {
                sb2.append("?");
                sb2.append(sb.toString());
            }
            String sb3 = sb2.toString();
            Bundle bundle = new Bundle();
            bundle.putInt("baidu.wallet.lightapp.biztype", 12);
            BaiduWalletDelegate.getInstance().openH5Module(context, sb3, false, bundle);
        }
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        this.g = context;
        PayDataCache.getInstance().setIsRemotePay(true);
        PayDataCache.getInstance().resetFromPrecashier();
        a(context, str, payCallBack, map, (PrecashierCreateOrderResponse) null);
    }

    public void finish() {
        clearPayBack();
    }

    public IBindCardCallback getBindCallback() {
        return this.b;
    }

    public BindBack getBindCallbackExt() {
        return this.e;
    }

    public PayCallBack getPayBack() {
        return this.a;
    }

    public RNAuthCallBack getRNAuthBack() {
        return this.c;
    }

    public Context getRemotePayContext() {
        return this.g;
    }

    public ScanCodeCallBack getScanCallback() {
        return this.f;
    }

    public boolean isBindCardProcessing() {
        a aVar = this.e;
        return aVar != null && aVar.b;
    }

    public void jumpWapCashier(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(context, str2);
        intent.putExtra("jump_url", str);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void launchBindCardActivity(Context context, IBindCardCallback iBindCardCallback, Bundle bundle) {
        if (context != null) {
            this.b = iBindCardCallback;
            Intent intent = new Intent(context, BindCardImplActivity.class);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } else if (iBindCardCallback != null) {
            iBindCardCallback.onChangeFailed("");
        }
    }

    public void payRnAuthOnModuleEvent(EventBus.Event event) {
        if (event == null) {
            this.d = false;
        } else if (!DxmPayBeanConstants.EVENT_H5_RN_AUTH_RESULT.equals(event.mEventKey)) {
        } else {
            if (event.mEventObj != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has(DxmPayBeanConstants.EVENT_AUTH_RESULT) && 1 == jSONObject.getInt(DxmPayBeanConstants.EVENT_AUTH_RESULT)) {
                        this.d = true;
                    }
                } catch (Exception unused) {
                    this.d = false;
                }
            } else {
                this.d = false;
            }
        }
    }

    public void preOrderPay(Context context, String str, String str2, PayCallBack payCallBack, Map<String, String> map) {
        Intent intent;
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().setFromPreCashier();
        PayDataCache.getInstance().setOrderExtraInfo(str2);
        BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (!WalletLoginHelper.getInstance().isLogin()) {
            a(context);
            return;
        }
        if (PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY) != null || PayDataCache.getInstance().isRemotePay()) {
            b(context);
        }
        this.a = payCallBack;
        if (map == null) {
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().2");
            return;
        }
        a(str, map);
        if (PayDataCache.getInstance().isRemotePay()) {
            intent = new Intent(context, RemotePaySplashActivity.class);
        } else {
            intent = new Intent(context, WelcomeActivity.class);
        }
        intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 3);
        intent.putExtra("orderExtraInfo", str2);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, DxmPayBeanConstants.REQUEST_CODE_PAY_ACTIVITY);
            activity.overridePendingTransition(0, 0);
            return;
        }
        intent.addFlags(268435456);
        if (PayDataCache.getInstance().isRemotePay()) {
            intent.addFlags(67108864);
        }
        context.getApplicationContext().startActivity(intent);
    }

    public void resetRemotePayContext() {
        this.g = null;
    }

    public void setBindCallback(IBindCardCallback iBindCardCallback) {
        this.b = iBindCardCallback;
    }

    public void setBindCardbackExt(BindBack bindBack) {
        a aVar = null;
        if (bindBack != null) {
            aVar = new a(bindBack);
        }
        this.e = aVar;
    }

    public void setRemotePayContext(Context context) {
        this.g = context;
    }

    public void setScanCallback(ScanCodeCallBack scanCodeCallBack) {
        this.f = scanCodeCallBack;
    }

    public BaiduPay() {
        this.d = false;
    }

    private void a(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (!WalletLoginHelper.getInstance().isLogin()) {
            a(context);
            if (!PayDataCache.getInstance().isFromPreCashier()) {
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                HashMap hashMap = new HashMap();
                hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_NOT_LOGIN, (Collection<String>) collectData, (Map<String, Object>) hashMap);
                return;
            }
            return;
        }
        if (PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY) != null || PayDataCache.getInstance().isRemotePay()) {
            b(context);
        }
        this.a = payCallBack;
        if (map == null) {
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().2");
            return;
        }
        a(str, map);
        a(context, precashierCreateOrderResponse);
    }

    private void a(String str, Map<String, String> map) {
        PayRequest a2 = a(str, map, map.get("pay_from"));
        PayRequestCache.getInstance().addBeanRequestToCache(a2.getRequestId(), a2);
    }

    private void a(Context context) {
        PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().1");
        AccountManager.getInstance(context).logout();
        WalletLoginHelper.getInstance().handlerWalletError(5003);
        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_please_login"));
    }

    private void a(Context context, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Intent intent;
        if (PayDataCache.getInstance().isRemotePay()) {
            intent = new Intent(context, RemotePaySplashActivity.class);
        } else {
            intent = new Intent(context, WelcomeActivity.class);
        }
        intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 1);
        if (precashierCreateOrderResponse != null) {
            intent.putExtra(PRECASHIER_PAY_RESPONSE, precashierCreateOrderResponse);
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, DxmPayBeanConstants.REQUEST_CODE_PAY_ACTIVITY);
            activity.overridePendingTransition(0, 0);
            return;
        }
        intent.addFlags(268435456);
        if (PayDataCache.getInstance().isRemotePay()) {
            intent.addFlags(67108864);
        }
        context.getApplicationContext().startActivity(intent);
    }

    private PayRequest a(String str, Map<String, String> map, String str2) {
        PayRequest payRequest = new PayRequest();
        payRequest.setPayFrom(str2);
        if (PayDataCache.getInstance().isRemotePay()) {
            payRequest.mRemotePayUserId = WalletLoginHelper.getInstance().getPassUid();
            payRequest.mRemotePayUserAccountName = WalletLoginHelper.getInstance().getPassUserName();
            payRequest.mRemotePayHostName = map.get("key_remote_app_name");
            payRequest.mRemotePkg = map.get("key_remote_pkg_name");
            payRequest.mRemoteWhereToBackAct = map.get("key_remote_where_to_back");
            PayDataCache.getInstance().setRemotePayHostName(map.get("key_remote_app_name"));
            PayDataCache.getInstance().setRemotePkg(map.get("key_remote_pkg_name"));
            PayDataCache.getInstance().setRemoteWhereToBackAct(map.get("key_remote_where_to_back"));
        }
        payRequest.initOrder(str);
        "doPay. order info = " + str;
        return payRequest;
    }

    private void a(BindFastRequest bindFastRequest, CardData.BondCard bondCard) {
        if (bindFastRequest != null) {
            bindFastRequest.setmBankCard(bondCard.account_no);
            bindFastRequest.mBankNo = bondCard.bank_code;
            bindFastRequest.setChannelNo(bondCard.account_bank_code);
            bindFastRequest.setBankType(bondCard.card_type);
            if (bondCard.card_type == 1) {
                bindFastRequest.setmCvv(bondCard.verify_code);
                bindFastRequest.setValidDateFromServer(bondCard.valid_date);
            }
            bindFastRequest.setmName(bondCard.true_name);
            bindFastRequest.setmPhone(bondCard.mobile);
            bindFastRequest.setSendSmsphone(bondCard.mobile);
            bindFastRequest.setmIdCard(bondCard.certificate_code);
            bindFastRequest.setCertificateType(bondCard.certificate_type);
        }
    }
}
