package com.baidu.android.lbspay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.baidu.android.lbspay.activity.LBSTransActivity;
import com.baidu.android.lbspay.activity.LBSTransCashierActivity;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.presenter.LBSTransPresenterFactory;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.pay.BindBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.EncodeUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LBSPayInner {
    public static final int STATE_CODE_CANCEL = 2;
    public static final int STATE_CODE_FAILD = 3;
    public static final int STATE_CODE_PAYING = 1;
    public static final int STATE_CODE_SUCCEED = 0;
    public static final String Tag = "LBSPayInner";
    public AliPayCallback mAliPayCallback;
    public Handler mHandler;
    public LBSPayBack mLbsPayBack;
    public String mOrderNo;

    public interface AliPayCallback {
        void onResult(String str);
    }

    public static class a {
        public static LBSPayInner a = new LBSPayInner();
    }

    private void LBSCashierEnterSensor(Map<String, String> map) {
        double d;
        if (map != null) {
            StatHelper.clearSensor();
            StatHelper.cachePayFrom("2");
            StatHelper.cacheOrderId(this.mOrderNo);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            if (TextUtils.isEmpty(map.get("payAmount"))) {
                d = 0.0d;
            } else {
                d = StatHelper.fen2YuanBigDecimal(map.get("payAmount"));
            }
            StatHelper.cachePayAmount(d);
            List<String> collectData = StatHelper.collectData(this.mOrderNo, new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("pay_amount", Double.valueOf(d));
            StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_ENTER, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    public void directCallThirdPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        PayChannelController payChannelController = new PayChannelController(activity);
        this.mOrderNo = map.get("orderId");
        LBSCashierEnterSensor(map);
        CashierDataNew cashierDataNew = new CashierDataNew();
        cashierDataNew.setData(map);
        this.mLbsPayBack = lBSPayBack;
        payChannelController.doDirectCallThirdPay(getPayOrderListener, cashierDataNew, str);
    }

    public static LBSPayInner getInstance() {
        return a.a;
    }

    /* access modifiers changed from: private */
    public void polymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map) {
        this.mLbsPayBack = lBSPayBack;
        AuthorizeData authorizeData = new AuthorizeData();
        authorizeData.setData(map);
        if (map != null) {
            try {
                StatHelper.clearSensor();
                StatHelper.cacheOrderId(map.get("orderId"));
                String str = map.get("reqData");
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    String str2 = (String) jSONObject.opt("signChannel");
                    if (!TextUtils.isEmpty(str2)) {
                        StatHelper.cacheSignChannel(str2);
                        if (!TextUtils.isEmpty(str2) && str2.equals("wechat")) {
                            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_AUTHORIZE_SIGN_ENTER, new String[0]);
                            String str3 = (String) jSONObject.opt("wechat_appid");
                            if (!TextUtils.isEmpty(str3)) {
                                PayDataCache.getInstance().setmWxAppId(str3);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                LogUtil.e(Tag, e.getMessage(), e);
            }
        }
        Intent intent = new Intent(activity, LBSTransActivity.class);
        intent.putExtra(AuthorizeData.DELIVERY_AUTHORIZE_DATA, authorizeData);
        intent.putExtra(LBSTransActivity.PRESENTER_TYPE, LBSTransPresenterFactory.TRANS_AUTH_PRESENTER);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void polymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map, Map<String, String[]> map2) {
        double d;
        if (map != null) {
            StatHelper.clearSensor();
            StatHelper.cachePayFrom("2");
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            this.mLbsPayBack = lBSPayBack;
            String str = map.get("orderId");
            this.mOrderNo = str;
            StatHelper.cacheOrderId(str);
            if (TextUtils.isEmpty(map.get("payAmount"))) {
                d = 0.0d;
            } else {
                d = StatHelper.fen2YuanBigDecimal(map.get("payAmount"));
            }
            StatHelper.cachePayAmount(d);
            List<String> collectData = StatHelper.collectData(this.mOrderNo, new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("pay_amount", Double.valueOf(d));
            StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_ENTER, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            CashierDataNew cashierDataNew = new CashierDataNew();
            cashierDataNew.setData(map);
            if (map2 != null) {
                cashierDataNew.setExtraData(map2);
            }
            Intent intent = new Intent(context, LBSTransCashierActivity.class);
            intent.putExtra(CashierDataNew.DELIVERY_CASHIER_DATA, cashierDataNew);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                activity.startActivity(intent);
                activity.overridePendingTransition(0, 0);
                return;
            }
            intent.addFlags(268435456);
            context.getApplicationContext().startActivity(intent);
        }
    }

    public void clearLbsPayBack() {
        this.mLbsPayBack = null;
        LBSPayAli.getInstance().clearChannelPay();
    }

    public void doAliPay(final Activity activity, final String str, final boolean z, AliPayCallback aliPayCallback) {
        this.mAliPayCallback = aliPayCallback;
        AnonymousClass6 r4 = new Runnable() {
            public void run() {
                JSONObject jSONObject = new JSONObject(new PayTask(activity).payV2(str, z));
                Message message = new Message();
                message.what = 101;
                message.obj = jSONObject.toString();
                StatisticManager.onEventWithValue(PayStatServiceEvent.LBS_ALIPAY_RESULT, jSONObject.toString());
                LBSPayInner.this.mHandler.sendMessage(message);
            }
        };
        StatisticManager.onEventWithValue(PayStatServiceEvent.LBS_ALIPAY_ENTER, str);
        new Thread(r4).start();
    }

    public void doBindCard(Context context, BindBack bindBack, Map<String, String> map) {
        StatisticManager.onEvent("#doBindCard");
        BaiduPayDelegate.getInstance().doBind(context, bindBack, map);
    }

    public void doCallFrontCashierPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        if (map != null) {
            StatisticManager.onEvent("#doFrontCashierPay");
            this.mOrderNo = map.get("orderId");
            doDirectCallThirdPay(activity, getPayOrderListener, lBSPayBack, map, str);
        }
    }

    public void doDirectCallThirdPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        StatisticManager.onEvent("#doThirdPay");
        if (TextUtils.isEmpty(str) || map == null) {
            if (lBSPayBack != null) {
                lBSPayBack.onPayResult(2, "invalid parameter");
            }
        } else if (!CheckUtils.isFastDoubleClick()) {
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            final Activity activity2 = activity;
            final GetPayOrderListener getPayOrderListener2 = getPayOrderListener;
            final LBSPayBack lBSPayBack2 = lBSPayBack;
            final Map<String, String> map2 = map;
            final String str2 = str;
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    LBSPayInner.this.directCallThirdPay(activity2, getPayOrderListener2, lBSPayBack2, map2, str2);
                }

                public void onSuccess(int i2, String str) {
                    LBSPayInner.this.directCallThirdPay(activity2, getPayOrderListener2, lBSPayBack2, map2, str2);
                }
            }));
        }
    }

    public void doPolymerAuthorizeSign(final Activity activity, final LBSPayBack lBSPayBack, final Map<String, String> map) {
        if (activity != null && map != null && !CheckUtils.isFastDoubleClick()) {
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    LBSPayInner.this.polymerAuthorizeSign(activity, lBSPayBack, map);
                }

                public void onSuccess(int i2, String str) {
                    LBSPayInner.this.polymerAuthorizeSign(activity, lBSPayBack, map);
                }
            }));
        }
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map) {
        doPolymerPay(context, lBSPayBack, map, (Map<String, String[]>) null);
    }

    public LBSPayBack getCallBack() {
        return this.mLbsPayBack;
    }

    public String getOrderNo() {
        return this.mOrderNo;
    }

    public String getReqData(Context context) {
        WalletLoginHelper.getInstance().clearOpenBduss();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", BussinessUtils.getUA(context));
            jSONObject.put("cuid_1", EncodeUtils.encodeCommParms(PhoneUtils.getCUID(context)));
            jSONObject.put("supportList", String.valueOf(343));
            jSONObject.put("wcp", PhoneUtils.getWCPParams(context));
            jSONObject.put("key", SecurePay.getInstance().getpwProxy());
            String cookie = PayUtils.getCookie(context);
            if (!TextUtils.isEmpty(cookie)) {
                jSONObject.put(NetworkBean.PARAM_COOKIE, SecurePay.getInstance().encryptProxy(cookie));
            } else {
                jSONObject.put(NetworkBean.PARAM_COOKIE, "");
            }
            String newCookie = PayUtils.getNewCookie(context);
            if (!TextUtils.isEmpty(newCookie)) {
                jSONObject.put("natbc", SecurePay.getInstance().encryptProxy(newCookie));
            } else {
                jSONObject.put("natbc", "");
            }
            if (WalletLoginHelper.getInstance().isLogin()) {
                jSONObject.put("preOrder", "1");
            } else {
                jSONObject.put("preOrder", "0");
            }
            if (WalletFingerprint.getInstance(context).hasEnrollFingerprint()) {
                jSONObject.put("enroll_fingerprint", "1");
            }
        } catch (Exception e) {
            "getReqData error:" + e.toString();
            StatisticManager.onEventEndWithValue(LbsStatistics.LBS_GET_REQDATA_ERR, e.toString());
        }
        return jSONObject.toString();
    }

    public LBSPayInner() {
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 101) {
                    Object obj = message.obj;
                    String str = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
                    if (LBSPayInner.this.mAliPayCallback != null) {
                        LBSPayInner.this.mAliPayCallback.onResult(str);
                    }
                    AliPayCallback unused = LBSPayInner.this.mAliPayCallback = null;
                }
            }
        };
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map, Map<String, String[]> map2) {
        if (context != null) {
            if (CheckUtils.isFastDoubleClick()) {
                StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_DO_POLYMER_PAY);
                return;
            }
            StatisticManager.onEvent("#doPolymerPay");
            if (map != null) {
                WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
                final Context context2 = context;
                final LBSPayBack lBSPayBack2 = lBSPayBack;
                final Map<String, String> map3 = map;
                final Map<String, String[]> map4 = map2;
                WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener() {
                    public void onFail(int i2, String str) {
                        LBSPayInner.this.polymerPay(context2, lBSPayBack2, map3, map4);
                    }

                    public void onSuccess(int i2, String str) {
                        LBSPayInner.this.polymerPay(context2, lBSPayBack2, map3, map4);
                    }
                }));
            }
        }
    }

    public void doDirectCallThirdPay(Activity activity, Activity activity2, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        StatisticManager.onEvent("#doThirdPay");
        if (!TextUtils.isEmpty(str) && map != null && !CheckUtils.isFastDoubleClick()) {
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            final Activity activity3 = activity;
            final Activity activity4 = activity2;
            final GetPayOrderListener getPayOrderListener2 = getPayOrderListener;
            final LBSPayBack lBSPayBack2 = lBSPayBack;
            final Map<String, String> map2 = map;
            final String str2 = str;
            Activity activity5 = activity;
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    LBSPayInner.this.directCallThirdPay(activity3, activity4, getPayOrderListener2, lBSPayBack2, map2, str2);
                }

                public void onSuccess(int i2, String str) {
                    LBSPayInner.this.directCallThirdPay(activity3, activity4, getPayOrderListener2, lBSPayBack2, map2, str2);
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    public void directCallThirdPay(Activity activity, Activity activity2, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        PayChannelController payChannelController = new PayChannelController(activity, activity2);
        this.mOrderNo = map.get("orderId");
        LBSCashierEnterSensor(map);
        CashierDataNew cashierDataNew = new CashierDataNew();
        cashierDataNew.setData(map);
        this.mLbsPayBack = lBSPayBack;
        payChannelController.doDirectCallThirdPay(getPayOrderListener, cashierDataNew, str);
    }
}
