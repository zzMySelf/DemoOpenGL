package com.baidu.wallet.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.WalletInterfaceResponse;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.FingerprintGetOtpTokenCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.c;
import com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback;
import com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierBeanFactory;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierDefaultPayTypeBean;
import com.baidu.wallet.paysdk.securitycenter.bean.PaySetListBean;
import com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterBean;
import com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterFactory;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.BaiduWalletServiceController;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.StatusCode;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.JsonUtil;
import com.dxmpay.wallet.utils.StatHelper;
import com.dxmpay.wallet.utils.realtimeevent.RealTimeEventHelper;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduPayDelegate implements IWalletPayFacade {
    public static final int RNAUTH_HIGH_GRADE = 3;
    public static final int RNAUTH_LOW_GRADE = 1;
    public static final int RNAUTH_MEDIUM_GRADE = 2;
    public static final String b = "BaiduPayDelegate";
    public static final String c = (b + ".getPayMethod");
    public static final String d = (b + ".getSecurityCenter");
    public static String e = "wallet_interface_unlogindata";
    public boolean a;
    public HandlePassLoginResult f;
    public LoginBackListenerProxy g;
    public LoginBackListenerProxy h;

    /* renamed from: i  reason: collision with root package name */
    public LoginBackListenerProxy f1131i;
    public LoginBackListenerProxy j;
    public LoginBackListenerProxy k;
    public LoginBackListenerProxy l;
    public LoginBackListenerProxy m;
    public LoginBackListenerProxy n;

    /* renamed from: o  reason: collision with root package name */
    public PayCallBack f1132o;
    public long p;

    public class HandlePassLoginResult extends LoginBackListenerProxy {
        public boolean b;

        public HandlePassLoginResult(Context context, boolean z, ILoginBackListener iLoginBackListener) {
            super(context, iLoginBackListener);
            this.b = z;
        }

        public void onFail(int i2, String str) {
            if (this.b) {
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), "0");
                HashMap hashMap = new HashMap();
                hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PASS_RESULT, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            } else if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "0"));
            } else {
                StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_PASS_RESULT, "0");
            }
            StatHelper.cachePassLoginStatus("0");
            super.onFail(i2, str);
        }

        public void onSuccess(int i2, String str) {
            if (StatHelper.getPassLoginStatus().equals("0")) {
                if (this.b) {
                    List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), "1");
                    HashMap hashMap = new HashMap();
                    hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
                    hashMap.put("pay_amount", StatHelper.getPayAmount());
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PASS_RESULT, (Collection<String>) collectData, (Map<String, Object>) hashMap);
                } else if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "1"));
                } else {
                    StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_PASS_RESULT, "1");
                }
            }
            super.onSuccess(i2, str);
        }
    }

    public static class a implements IBeanResponseCallback {
        public com.baidu.wallet.paysdk.securitycenter.a a;

        public a(com.baidu.wallet.paysdk.securitycenter.a aVar) {
            this.a = aVar;
        }

        public void onBeanExecFailure(int i2, int i3, String str) {
            com.baidu.wallet.paysdk.securitycenter.a aVar = this.a;
            if (aVar != null) {
                aVar.a(i3, str);
            }
        }

        public void onBeanExecSuccess(int i2, Object obj, String str) {
            String str2;
            if (this.a != null) {
                int i3 = StatusCode.ERROR_RESPONSE;
                if (obj == null || !(obj instanceof String)) {
                    str2 = EnterDxmPayServiceAction.ERR_MSG;
                } else {
                    str2 = (String) obj;
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.optInt("ret");
                        if (optInt != 0) {
                            str2 = jSONObject.optString("msg");
                        }
                        i3 = optInt;
                    } catch (JSONException e) {
                        str2 = e.toString();
                    }
                }
                this.a.a(i3, str2);
            }
        }
    }

    public static class b {
        public static final BaiduPayDelegate a = new BaiduPayDelegate();
    }

    public static BaiduPayDelegate getInstance() {
        return b.a;
    }

    public void accessWalletEntry(Context context, String str) {
        WalletInterfaceResponse.WalletModuleData walletModuleData;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                walletModuleData = (WalletInterfaceResponse.WalletModuleData) JsonUtils.fromJson(str, WalletInterfaceResponse.WalletModuleData.class);
            } catch (JSONException e2) {
                LogUtil.e(b, e2.getMessage(), e2);
                walletModuleData = null;
            }
            if (walletModuleData != null && walletModuleData.link_addr != null) {
                StatisticManager.onEventWithValues("accessWalletEntryEvent", a(walletModuleData));
                int i2 = walletModuleData.type;
                if (i2 == 1) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", walletModuleData.link_addr).data("title", (Object) null).data("with_anim", Boolean.valueOf(walletModuleData.needAnim())).data("show_share", Boolean.TRUE), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                        }
                    });
                } else if (i2 == 2) {
                    WalletLoginHelper.getInstance().startPage(walletModuleData.link_addr);
                } else if (i2 == 3) {
                    BaiduWalletServiceController.getInstance().gotoWalletService(context, walletModuleData.link_addr, "", walletModuleData.needAnim());
                }
            }
        }
    }

    public String assembleResult(Map<String, Object> map, boolean z) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("cnt", new JSONObject(map));
        } catch (JSONException e2) {
            LogUtil.e(b, SapiUtils.KEY_QR_LOGIN_ERROR, e2);
        }
        return jSONObject.toString();
    }

    public void cashierEnterSensor(String str, String str2) {
        double d2;
        String str3;
        String str4;
        if (!TextUtils.isEmpty(str2)) {
            String orderNo = StatHelper.getOrderNo(str2);
            StatHelper.cacheOrderNo(orderNo);
            String spNo = StatHelper.getSpNo(str2);
            StatHelper.cacheSpNo(spNo);
            if (TextUtils.isEmpty(StatHelper.getPayAmount(str2))) {
                d2 = 0.0d;
            } else {
                d2 = StatHelper.fen2YuanBigDecimal(StatHelper.getPayAmount(str2));
            }
            StatHelper.cachePayAmount(d2);
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.SP_NO, spNo);
            hashMap.put("pay_amount", Double.valueOf(d2));
            if (PayStatServiceEvent.PERCASHIER_PAY_ENTER.equals(str)) {
                StatHelper.setPrecashierMark(orderNo);
            } else if (PayStatServiceEvent.STD_PAY_ENTER.equals(str) && StatHelper.isPrecashierPay(orderNo)) {
                hashMap.put(StatHelper.PAY_CATEGORY, "1");
                StatHelper.setDowngrade(true);
            }
            hashMap.put("pay_from", StatHelper.getPayFrom());
            if (!TextUtils.isEmpty(StatHelper.getSignPay())) {
                hashMap.put(StatHelper.SIGN_PAY, StatHelper.getSignPay());
            }
            hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
            hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
            hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
            if (PayStatServiceEvent.PERCASHIER_PAY_ENTER.equals(str)) {
                str4 = "前置收银台入口";
                str3 = "paySDKPercashierPayEnter";
            } else {
                str4 = "标准收银台入口";
                str3 = "paySDKStdPayEnter";
            }
            hashMap.put(StatHelper.HASH_NAME, str4);
            hashMap.put("hash", str3);
            hashMap.put(StatHelper.EVENT_TAG, "进入");
            hashMap.put(StatHelper.EVENT_PATH, StatHelper.PAY_SDK_EVENT_PATH + str);
            StatisticManager.onEventWithValues(str, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        }
    }

    public void changePayMethod(final Activity activity, final Map map, IModifyPayTypeCallback iModifyPayTypeCallback) {
        if (c()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_CHANGE_PAY_METHOD);
            return;
        }
        StatisticManager.onEvent("changePayMethod");
        PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                PrecashierModifyPayTypeManager.getInstance().getModifyPayType(activity, map);
            }

            public void onSuccess(int i2, String str) {
                PrecashierModifyPayTypeManager.getInstance().getModifyPayType(activity, map);
            }
        }));
    }

    public void checkPwd(Context context, final CheckCallBack checkCallBack) {
        this.k = new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.k);
                    return;
                }
                CheckCallBack checkCallBack = checkCallBack;
                if (checkCallBack != null) {
                    checkCallBack.onCheckResult(2, "cancle");
                }
                LoginBackListenerProxy unused = BaiduPayDelegate.this.k = null;
            }

            public void onSuccess(int i2, String str) {
                if (BaiduPayDelegate.this.k == null || BaiduPayDelegate.this.k.getContext() == null) {
                    CheckCallBack checkCallBack = checkCallBack;
                    if (checkCallBack != null) {
                        checkCallBack.onCheckResult(2, "cancle");
                    }
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.k = null;
                    return;
                }
                BaiduPay.getInstance().checkPwd(BaiduPayDelegate.this.k.getContext(), checkCallBack);
                LoginBackListenerProxy unused2 = BaiduPayDelegate.this.k = null;
            }
        });
        WalletLoginHelper.getInstance().login(this.k);
    }

    public void checkPwdFromH5(Context context, final String str, final CheckCallBack checkCallBack) {
        this.l = new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.l);
                    return;
                }
                CheckCallBack checkCallBack = checkCallBack;
                if (checkCallBack != null) {
                    checkCallBack.onCheckResult(2, QueryResponse.Options.CANCEL);
                }
                LoginBackListenerProxy unused = BaiduPayDelegate.this.l = null;
            }

            public void onSuccess(int i2, String str) {
                if (BaiduPayDelegate.this.l == null || BaiduPayDelegate.this.l.getContext() == null) {
                    CheckCallBack checkCallBack = checkCallBack;
                    if (checkCallBack != null) {
                        checkCallBack.onCheckResult(2, QueryResponse.Options.CANCEL);
                    }
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.l = null;
                    return;
                }
                BaiduPay.getInstance().checkPwdFromH5(BaiduPayDelegate.this.l.getContext(), str, checkCallBack);
                LoginBackListenerProxy unused2 = BaiduPayDelegate.this.l = null;
            }
        });
        WalletLoginHelper.getInstance().login(this.l);
    }

    public void closeFingerprintPay(Activity activity, final c cVar) {
        final IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(activity).getFingerprintPay(WalletFingerprint.FpType.SYSTEM_FINGERPRINT);
        if (fingerprintPay != null) {
            fingerprintPay.close(activity, new FingerprintCallback() {
                public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                    if (i2 == 0) {
                        StatisticManager.onEvent("fp_paysetting_close_success");
                        BaiduPayDelegate.this.d();
                        cVar.a(2200, "关闭成功");
                    } else {
                        StatisticManager.onEvent("fp_paysetting_close_failed");
                        cVar.a(2201, "关闭失败");
                    }
                    fingerprintPay.destory();
                }
            });
        } else {
            cVar.a(2112, "手机不支持指纹支付");
        }
    }

    public void doBind(Context context, BindBack bindBack, Map<String, String> map) {
        StatisticManager.onEvent(PayStatServiceEvent.DO_BIND_CARD_ENTER);
        if (context == null || map == null) {
            StatisticManager.onEvent("#onBindResult");
            bindBack.onBindResult(-10, (String) null);
            return;
        }
        doInnerBind(context, bindBack, map, "");
    }

    public void doBindCardIndependent(Context context, BindBack bindBack, String str) {
        if (context != null) {
            StatisticManager.onEvent(PayStatServiceEvent.DO_BIND_CARD_INDEPENDENT_ENTER);
            doInnerBind(context, bindBack, new HashMap(), str);
        } else if (bindBack != null) {
            bindBack.onBindResult(2, (String) null);
        }
    }

    public void doCheckPwd(Context context, final Map<String, String> map, final CheckCallBack checkCallBack) {
        this.j = new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.j);
                    return;
                }
                CheckCallBack checkCallBack = checkCallBack;
                if (checkCallBack != null) {
                    checkCallBack.onCheckResult(2, "");
                }
                LoginBackListenerProxy unused = BaiduPayDelegate.this.j = null;
            }

            public void onSuccess(int i2, String str) {
                if (BaiduPayDelegate.this.j == null || BaiduPayDelegate.this.j.getContext() == null) {
                    CheckCallBack checkCallBack = checkCallBack;
                    if (checkCallBack != null) {
                        checkCallBack.onCheckResult(2, "");
                    }
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.j = null;
                    return;
                }
                BaiduPay.getInstance().doCheckPwd(BaiduPayDelegate.this.j.getContext(), map, checkCallBack);
                LoginBackListenerProxy unused2 = BaiduPayDelegate.this.j = null;
            }
        });
        WalletLoginHelper.getInstance().login(this.j);
    }

    public void doInnerBind(Context context, BindBack bindBack, Map<String, String> map, String str) {
        final BindBack bindBack2 = bindBack;
        final Context context2 = context;
        final Map<String, String> map2 = map;
        final String str2 = str;
        this.m = new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.m);
                    return;
                }
                if (bindBack2 != null) {
                    StatisticManager.onEvent("#onBindResult");
                    bindBack2.onBindResult(-5, (String) null);
                }
                LoginBackListenerProxy unused = BaiduPayDelegate.this.m = null;
            }

            public void onSuccess(int i2, String str) {
                if (BaiduPayDelegate.this.m == null || BaiduPayDelegate.this.m.getContext() == null) {
                    BindBack bindBack = bindBack2;
                    if (bindBack != null) {
                        bindBack.onBindResult(-5, (String) null);
                    }
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.m = null;
                    return;
                }
                BaiduPay.getInstance().doBindCardExt(context2, bindBack2, map2, str2);
                LoginBackListenerProxy unused2 = BaiduPayDelegate.this.m = null;
            }
        });
        WalletLoginHelper.getInstance().login(this.m);
    }

    public void doPay(Context context, String str, PayCallBack payCallBack) {
        doPay(context, str, payCallBack, new HashMap());
    }

    public void doPayRNAuth(Context context, final String str, final RNAuthCallBack rNAuthCallBack) {
        if (context != null && !TextUtils.isEmpty(str)) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_RNAUTH_ENTER, StatHelper.getOrderNo());
            this.f1131i = new LoginBackListenerProxy(context, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    if (i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f1131i);
                        return;
                    }
                    RNAuthCallBack rNAuthCallBack = rNAuthCallBack;
                    if (rNAuthCallBack != null) {
                        rNAuthCallBack.onRNAuthResult(-5, (String) null);
                    }
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.f1131i = null;
                }

                public void onSuccess(int i2, String str) {
                    if (BaiduPayDelegate.this.f1131i == null || BaiduPayDelegate.this.f1131i.getContext() == null) {
                        RNAuthCallBack rNAuthCallBack = rNAuthCallBack;
                        if (rNAuthCallBack != null) {
                            rNAuthCallBack.onRNAuthResult(-5, (String) null);
                        }
                        LoginBackListenerProxy unused = BaiduPayDelegate.this.f1131i = null;
                        return;
                    }
                    BaiduPay.getInstance().doPayRNAuth(BaiduPayDelegate.this.f1131i.getContext(), str, rNAuthCallBack);
                    LoginBackListenerProxy unused2 = BaiduPayDelegate.this.f1131i = null;
                }
            });
            WalletLoginHelper.getInstance().login(this.f1131i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: com.baidu.wallet.api.BaiduPayDelegate$16} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: com.baidu.wallet.api.BaiduPayDelegate$16} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.baidu.wallet.api.BaiduPayDelegate$16} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doPrecashierPay(android.content.Context r9, java.lang.String r10, com.baidu.android.pay.PayCallBack r11, java.util.Map<java.lang.String, java.lang.String> r12, com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse r13, com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback r14) {
        /*
            r8 = this;
            java.lang.String r0 = com.dxmpay.wallet.utils.StatHelper.getPayFrom()
            java.lang.String r1 = "2"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x000f
            com.dxmpay.wallet.utils.StatHelper.clearSensor()
        L_0x000f:
            java.lang.String r0 = "doPreCashierPay"
            com.dxmpay.wallet.statistics.api.StatisticManager.onEvent(r0)
            if (r14 != 0) goto L_0x0021
            com.baidu.wallet.api.BaiduPayDelegate$16 r14 = new com.baidu.wallet.api.BaiduPayDelegate$16
            r1 = r14
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r1.<init>(r3, r4, r5, r6)
        L_0x0021:
            com.baidu.wallet.base.controllers.PayController r0 = com.baidu.wallet.base.controllers.PayController.getInstance()
            r0.setModifyPayTypeCallback(r14)
            com.baidu.wallet.paysdk.storage.PayDataCache r14 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            r0 = 0
            r14.setIsRemotePay(r0)
            com.baidu.wallet.paysdk.storage.PayDataCache r14 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            r14.setFromPreCashier()
            java.lang.String r14 = "1"
            com.dxmpay.wallet.utils.StatHelper.cachePayFrom(r14)
            java.lang.String r14 = "pay_duration"
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventStart(r14)
            java.lang.String r14 = "percashier_pay_enter"
            r8.cashierEnterSensor(r14, r10)
            com.dxmpay.wallet.passport.LoginBackListenerProxy r14 = new com.dxmpay.wallet.passport.LoginBackListenerProxy
            com.baidu.wallet.api.BaiduPayDelegate$17 r7 = new com.baidu.wallet.api.BaiduPayDelegate$17
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r2, r3, r4, r5, r6)
            r14.<init>(r9, r7)
            r8.g = r14
            com.dxmpay.wallet.api.WalletLoginHelper r9 = com.dxmpay.wallet.api.WalletLoginHelper.getInstance()
            com.dxmpay.wallet.passport.LoginBackListenerProxy r10 = r8.g
            r9.login(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.api.BaiduPayDelegate.doPrecashierPay(android.content.Context, java.lang.String, com.baidu.android.pay.PayCallBack, java.util.Map, com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse, com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback):void");
    }

    public void doRNAuth(Context context, final Map<String, String> map, final RNAuthCallBack rNAuthCallBack) {
        if (context != null && map != null) {
            this.h = new LoginBackListenerProxy(context, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    if (i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.h);
                        return;
                    }
                    RNAuthCallBack rNAuthCallBack = rNAuthCallBack;
                    if (rNAuthCallBack != null) {
                        rNAuthCallBack.onRNAuthResult(-5, (String) null);
                    }
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.h = null;
                }

                public void onSuccess(int i2, String str) {
                    if (BaiduPayDelegate.this.h == null || BaiduPayDelegate.this.h.getContext() == null) {
                        RNAuthCallBack rNAuthCallBack = rNAuthCallBack;
                        if (rNAuthCallBack != null) {
                            rNAuthCallBack.onRNAuthResult(-5, (String) null);
                        }
                        LoginBackListenerProxy unused = BaiduPayDelegate.this.h = null;
                        return;
                    }
                    BaiduPay.getInstance().doRNAuth(BaiduPayDelegate.this.h.getContext(), map, rNAuthCallBack);
                    LoginBackListenerProxy unused2 = BaiduPayDelegate.this.h = null;
                }
            });
            WalletLoginHelper.getInstance().login(this.h);
        }
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!this.a) {
                StatHelper.clearSensor();
            }
            this.a = false;
            StatHelper.cachePayFrom("3");
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            ArrayList<String> a2 = a(str, (Map) map, context);
            StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PAY_ACCEPT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg()));
            cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
            StatisticManager.onEventWithValues("schemePayEnter", a2);
            if (WalletLoginHelper.getInstance().isLogin() && map == null) {
                map = new HashMap<>();
            }
            PayDataCache.getInstance().setIsRemotePay(true);
            PayDataCache.getInstance().resetFromPrecashier();
            com.baidu.wallet.paysdk.c.a.a().j();
            b(context, str, payCallBack, map);
        }
    }

    public void getBiometricsStatus(Context context, c cVar) {
        boolean isDevicesSupport = WalletFingerprint.getInstance(context).isDevicesSupport();
        boolean hasEnrollFingerprint = WalletFingerprint.getInstance(context).hasEnrollFingerprint();
        WalletFingerprint instance = WalletFingerprint.getInstance(context);
        final Context context2 = context;
        final c cVar2 = cVar;
        final int i2 = isDevicesSupport ? 1 : 0;
        final int i3 = hasEnrollFingerprint ? 1 : 0;
        instance.getOTPToken(new FingerprintGetOtpTokenCallback() {
            public void getOtpToken(String str) {
                boolean z = !TextUtils.isEmpty(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ifDeviceSupport", i2);
                    jSONObject.put("ifBiometricsAvailable", i3);
                    jSONObject.put("ifBiometricPayInfoExist", z ? 1 : 0);
                    jSONObject.put("ifDeviceSupportFaceID", 0);
                    jSONObject.put("cuid_1", PhoneUtils.getCUID(context2));
                    jSONObject.put("cuid_2", PhoneUtils.getCUID2(context2));
                    jSONObject.put("ua_from_na", BussinessUtils.getUA(context2));
                } catch (JSONException e) {
                    LogUtil.e(BaiduPayDelegate.b, e.getMessage(), e);
                }
                cVar2.a(0, jSONObject.toString());
            }
        });
    }

    public void getPayMethod(final Context context, final String str, final IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        if (c()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_GET_PAY_METHOD);
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                BaiduPayDelegate.this.a(context, str, iDefaultPayMethodCallback);
            }

            public void onSuccess(int i2, String str) {
                BaiduPayDelegate.this.a(context, str, iDefaultPayMethodCallback);
            }
        }));
    }

    public void getSecurityCenterOrPaySettingData(final String str, final Context context, final com.baidu.wallet.paysdk.securitycenter.a aVar) {
        if (EnterDxmPayServiceAction.DXM_GET_SECURITY_CENTER_DATA.equals(str) || EnterDxmPayServiceAction.DXM_GET_PAY_SETTING_DATA.equals(str)) {
            this.n = new LoginBackListenerProxy(context, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    if (i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.n);
                        return;
                    }
                    com.baidu.wallet.paysdk.securitycenter.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(-5, "未登录");
                    }
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.n = null;
                }

                public void onSuccess(int i2, String str) {
                    BaiduPayDelegate.this.a(str, context, aVar);
                    LoginBackListenerProxy unused = BaiduPayDelegate.this.n = null;
                }
            });
            WalletLoginHelper.getInstance().login(this.n);
            return;
        }
        aVar.a(StatusCode.ERROR_NOT_IMPLEMENTED, "功能未实现");
    }

    public String getWalletOuterInterface(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        return "";
    }

    public void openFingerprintPay(Activity activity, final c cVar) {
        if (activity != null && cVar != null) {
            final IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(activity).getFingerprintPay();
            if (fingerprintPay == null) {
                cVar.a(2112, "手机不支持指纹支付");
            } else if (!WalletFingerprint.getInstance(activity).hasEnrollFingerprint()) {
                cVar.a(2111, "手机没有录入指纹");
            } else {
                PayDataCache.getInstance().setPaySettingOpenFingerprintPay(true);
                fingerprintPay.open(activity, new FingerprintCallback() {
                    public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                        if (i2 == 0) {
                            StatisticManager.onEvent("fp_paysetting_open_success");
                            BaiduPayDelegate.this.d();
                            cVar.a(2100, "开通成功");
                        } else if (i2 == 1) {
                            StatisticManager.onEvent("fp_paysetting_open_cancle");
                            cVar.a(2102, "开通失败");
                        } else if (i2 == 2) {
                            StatisticManager.onEvent("fp_paysetting_open_failed");
                            cVar.a(2102, "开通失败");
                        } else {
                            cVar.a(2102, "开通失败");
                        }
                        fingerprintPay.destory();
                    }
                }, true);
            }
        }
    }

    public void preOrderPay(Context context, String str, final IPrecashierCallback iPrecashierCallback) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("orderInfo") || jSONObject.get("orderInfo") == null) {
                    throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
                }
                String str3 = (String) jSONObject.get("orderInfo");
                if (jSONObject.has("orderInfoExtra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("orderInfoExtra");
                    com.baidu.wallet.paysdk.c.a.a().a(str3);
                    if (jSONObject2 != null) {
                        str2 = JsonUtil.jsonToURLParams(jSONObject2, true);
                        String str4 = str2;
                        final AnonymousClass12 r7 = new PayCallBack() {
                            public boolean isHideLoadingDialog() {
                                return false;
                            }

                            public void onPayResult(int i2, String str) {
                                if (i2 == 0 || i2 == 1 || i2 == 4) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("data", Base64Utils.encodeToString(str.getBytes()));
                                    iPrecashierCallback.onResult(BaiduPayDelegate.this.assembleResult(hashMap, true));
                                    return;
                                }
                                iPrecashierCallback.onResult(BaiduPayDelegate.this.a(String.valueOf(i2), str));
                            }
                        };
                        getInstance().preOrderPay(context, str3, str4, r7, new IModifyPayTypeCallback() {
                            public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                                r7.onPayResult(10000, "默认支付方式变更");
                            }

                            public void onPayTypeModifiedFailed(int i2, String str) {
                            }

                            public void onPayTypeSetted() {
                            }
                        });
                    }
                }
                str2 = "";
                String str42 = str2;
                final AnonymousClass12 r72 = new PayCallBack() {
                    public boolean isHideLoadingDialog() {
                        return false;
                    }

                    public void onPayResult(int i2, String str) {
                        if (i2 == 0 || i2 == 1 || i2 == 4) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("data", Base64Utils.encodeToString(str.getBytes()));
                            iPrecashierCallback.onResult(BaiduPayDelegate.this.assembleResult(hashMap, true));
                            return;
                        }
                        iPrecashierCallback.onResult(BaiduPayDelegate.this.a(String.valueOf(i2), str));
                    }
                };
                getInstance().preOrderPay(context, str3, str42, r72, new IModifyPayTypeCallback() {
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        r72.onPayResult(10000, "默认支付方式变更");
                    }

                    public void onPayTypeModifiedFailed(int i2, String str) {
                    }

                    public void onPayTypeSetted() {
                    }
                });
            } catch (Exception e2) {
                LogUtil.e(b, e2.getMessage(), e2);
                String a2 = a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage());
                if (iPrecashierCallback != null) {
                    iPrecashierCallback.onResult(a2);
                }
            }
        }
    }

    public void reOrderPay(Context context) {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        String str = "";
        String str2 = payRequest != null ? payRequest.mParams : str;
        if (payRequest != null) {
            str = payRequest.getPayFrom();
        }
        PayCallBack payBack = BaiduPay.getInstance().getPayBack();
        PayRequestCache.getInstance().clearPaySdkRequestCache();
        PayBaseBeanActivity.exitEbpay();
        this.a = true;
        "orderinfo=" + str2 + " ==============callback=" + payBack;
        HashMap hashMap = new HashMap();
        hashMap.put("pay_from", str);
        StatisticManager.onEventWithValue(StatServiceEvent.EVENT_PAY_TYPE_SETTED_REORDE, str2);
        if (PayDataCache.getInstance().isRemotePay()) {
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_REORDER);
            if (payRequest != null) {
                hashMap.put("key_remote_app_name", payRequest.mRemotePayHostName);
                hashMap.put("key_remote_pkg_name", payRequest.mRemotePkg);
                hashMap.put("key_remote_where_to_back", payRequest.mRemoteWhereToBackAct);
            }
            getInstance().doRemotePay(context, str2, payBack, hashMap);
        } else if (!PayDataCache.getInstance().isFromPreCashier()) {
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_REORDER);
            getInstance().doPay(context, str2, payBack, hashMap);
        } else if (!BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(str)) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_REORDER);
            BaiduPay.getInstance().preOrderPay(context, str2, PayDataCache.getInstance().getOrderExtraInfo(), payBack, hashMap);
        }
    }

    public BaiduPayDelegate() {
        this.a = false;
        this.f1132o = null;
    }

    public void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map) {
        String str2 = "2";
        if (!str2.equals(StatHelper.getPayFrom())) {
            if (!this.a) {
                StatHelper.clearSensor();
            }
            this.a = false;
            String orderNo = StatHelper.getOrderNo(str);
            String pureSign = StatHelper.getPureSign(str);
            String a2 = com.baidu.wallet.paysdk.setting.a.a().a(context);
            if (!TextUtils.isEmpty(pureSign)) {
                if (SdkInitResponse.getInstance().openAuthSign == 1) {
                    a(context, str, payCallBack, map);
                    return;
                }
                StatHelper.cachePayFrom("4");
                if ("0".equals(pureSign)) {
                    str2 = "1";
                }
                StatHelper.cacheSignPay(str2);
            } else if (StatHelper.isPrecashierPay(orderNo) || !"1".equals(a2) || str.contains("cashdesk_code")) {
                StatHelper.cachePayFrom("0");
            } else {
                a(context, str, payCallBack, map);
                return;
            }
        }
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
        cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
        if (c()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_DO_PAY);
            StatHelper.cacheBankCode("-1");
            StatHelper.cacheCardType("-1");
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.STD_PAY_FAILED, PayCallBackManager.STD_HASH_NAME, PayCallBackManager.STD_HASH_ID, PayCallBackManager.PAY_FAIL_MSG, new String[0]);
        } else if (BeanConstants.CHANNEL_ID.equals(DxmPayBeanConstants.CHANNEL_ID_CHE_LIAN_WANG)) {
            this.f1132o = payCallBack;
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.baidu.wallet.remotepay.RemotePayEnterActivity");
            intent.putExtra("caller", a(str, (Map<String, String>) null, map));
            intent.putExtra("service", false);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } else {
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().resetFromPrecashier();
            com.baidu.wallet.paysdk.c.a.a().j();
            b(context, str, payCallBack, map);
        }
    }

    private IRemoteServiceCallback b() {
        return new IRemoteServiceCallback.Stub() {
            public boolean isHideLoadingDialog() {
                return false;
            }

            public void onPayEnd(final int i2, final String str) throws RemoteException {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (BaiduPayDelegate.this.f1132o != null) {
                            BaiduPayDelegate.this.f1132o.onPayResult(i2, str);
                            PayCallBack unused = BaiduPayDelegate.this.f1132o = null;
                        }
                    }
                });
            }

            public void startActivity(String str, String str2, int i2, Bundle bundle) throws RemoteException {
            }
        };
    }

    /* access modifiers changed from: private */
    public void c(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        if (PayDataCache.getInstance().isRemotePay()) {
            String[] strArr = new String[3];
            strArr[0] = BaiduWalletDelegate.getInstance().getAppContext().getPackageName();
            strArr[1] = (map == null || map.isEmpty()) ? "" : map.get("key_remote_pkg_name");
            strArr[2] = "doRemotePay";
            StatisticManager.onEventWithValues("doRemotePay", RealTimeEventHelper.genEventValue(str, strArr));
            BaiduPay.getInstance().doRemotePay(context, str, payCallBack, map);
            return;
        }
        BaiduPay.getInstance().doPay(context, str, payCallBack, map);
    }

    private void d(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        String str2;
        String str3;
        String str4 = "1";
        if (PayDataCache.getInstance().isRemotePay()) {
            String orderNo = StatHelper.getOrderNo();
            String[] strArr = new String[3];
            strArr[0] = StatHelper.getSpNo();
            strArr[1] = StatHelper.getFromPkg();
            if (WalletLoginHelper.getInstance().isPassLogin()) {
                str3 = str4;
            } else {
                str3 = "0";
            }
            strArr[2] = str3;
            StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_LOGIN_ENTER, StatHelper.collectData(orderNo, strArr));
        } else {
            String[] strArr2 = new String[1];
            if (WalletLoginHelper.getInstance().isPassLogin()) {
                str2 = str4;
            } else {
                str2 = "0";
            }
            strArr2[0] = str2;
            StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_LOGIN_ENTER, strArr2);
        }
        if (!WalletLoginHelper.getInstance().isPassLogin()) {
            str4 = "0";
        }
        StatHelper.cachePassLoginStatus(str4);
        final PayCallBack payCallBack2 = payCallBack;
        final Context context2 = context;
        final Map<String, String> map2 = map;
        final String str5 = str;
        this.f = new HandlePassLoginResult(context, false, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f);
                    return;
                }
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                HashMap hashMap = new HashMap();
                hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_NOT_LOGIN, (Collection<String>) collectData, (Map<String, Object>) hashMap);
                if (StatHelper.getPassLoginStatus().equals("1")) {
                    if (PayDataCache.getInstance().isRemotePay()) {
                        StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "0"));
                    } else {
                        StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_OPENBDUSS_RESULT, "0");
                    }
                }
                if (payCallBack2 != null) {
                    PayDataCache.getInstance().isRemotePay();
                    payCallBack2.onPayResult(2, "");
                    if (PayDataCache.getInstance().isRemotePay()) {
                        try {
                            BaiduPayDelegate.this.a(context2, (Map<String, String>) map2);
                        } catch (ActivityNotFoundException e2) {
                            LogUtil.e(BaiduPayDelegate.b, e2.getMessage(), e2);
                        }
                    }
                    HandlePassLoginResult unused = BaiduPayDelegate.this.f = null;
                }
            }

            public void onSuccess(int i2, String str) {
                if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "1"));
                } else {
                    StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_OPENBDUSS_RESULT, "1");
                }
                if (BaiduPayDelegate.this.f.getContext() != null) {
                    BaiduPayDelegate baiduPayDelegate = BaiduPayDelegate.this;
                    baiduPayDelegate.c(baiduPayDelegate.f.getContext(), str5, payCallBack2, map2);
                    return;
                }
                StatHelper.cacheBankCode("-1");
                StatHelper.cacheCardType("-1");
                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                PayCallBack payCallBack = payCallBack2;
                if (payCallBack != null) {
                    payCallBack.onPayResult(2, "");
                }
            }
        });
        WalletLoginHelper.getInstance().login(this.f);
    }

    private void b(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        if (!PayDataCache.getInstance().isRemotePay()) {
            StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_PAY_ENTER, new String[0]);
        }
        d(context, str, payCallBack, map);
    }

    public void getPayMethod(Context context, String str, @NonNull final IPrecashierCallback iPrecashierCallback) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("requestInfo") || jSONObject.get("requestInfo") == null) {
                throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
            }
            getInstance().getPayMethod(context, jSONObject.getString("requestInfo"), (IDefaultPayMethodCallback) new IDefaultPayMethodCallback() {
                public void onReceived(int i2, String str) {
                    String str2;
                    if (i2 == 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("data", Base64Utils.encodeToString(str.getBytes()));
                        str2 = BaiduPayDelegate.this.assembleResult(hashMap, true);
                    } else {
                        str2 = BaiduPayDelegate.this.a(String.valueOf(i2), str);
                    }
                    iPrecashierCallback.onResult(str2);
                }
            });
        } catch (Exception e2) {
            LogUtil.e(b, e2.getMessage(), e2);
            String a2 = a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage());
            if (iPrecashierCallback != null) {
                iPrecashierCallback.onResult(a2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void changePayMethod(android.app.Activity r6, java.lang.String r7, final com.baidu.wallet.api.IPrecashierCallback r8) {
        /*
            r5 = this;
            java.lang.String r0 = "version"
            java.lang.String r1 = "requestInfoExtra"
            java.lang.String r2 = "requestInfo"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0076 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x0076 }
            boolean r7 = r4.has(r2)     // Catch:{ Exception -> 0x0076 }
            if (r7 == 0) goto L_0x006e
            java.lang.Object r7 = r4.get(r2)     // Catch:{ Exception -> 0x0076 }
            if (r7 == 0) goto L_0x006e
            boolean r7 = r4.has(r2)     // Catch:{ Exception -> 0x0076 }
            if (r7 == 0) goto L_0x0037
            java.lang.Object r7 = r4.get(r2)     // Catch:{ Exception -> 0x0076 }
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ Exception -> 0x0076 }
            if (r7 == 0) goto L_0x0037
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0076 }
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            java.lang.Object r7 = com.dxmpay.apollon.utils.JsonUtils.fromJson(r7, r2)     // Catch:{ Exception -> 0x0076 }
            r3 = r7
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x0076 }
        L_0x0037:
            boolean r7 = r4.has(r1)     // Catch:{ Exception -> 0x0076 }
            if (r7 == 0) goto L_0x0052
            org.json.JSONObject r7 = r4.getJSONObject(r1)     // Catch:{ Exception -> 0x0076 }
            if (r7 == 0) goto L_0x0052
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0076 }
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.Object r7 = com.dxmpay.apollon.utils.JsonUtils.fromJson(r7, r1)     // Catch:{ Exception -> 0x0076 }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x0076 }
            r3.putAll(r7)     // Catch:{ Exception -> 0x0076 }
        L_0x0052:
            boolean r7 = r3.containsKey(r0)     // Catch:{ Exception -> 0x0076 }
            if (r7 == 0) goto L_0x005f
            java.lang.Object r7 = r3.get(r0)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0076 }
            goto L_0x0061
        L_0x005f:
            java.lang.String r7 = "0"
        L_0x0061:
            com.baidu.wallet.api.BaiduPayDelegate r0 = getInstance()     // Catch:{ Exception -> 0x0076 }
            com.baidu.wallet.api.BaiduPayDelegate$19 r1 = new com.baidu.wallet.api.BaiduPayDelegate$19     // Catch:{ Exception -> 0x0076 }
            r1.<init>(r7, r8)     // Catch:{ Exception -> 0x0076 }
            r0.changePayMethod((android.app.Activity) r6, (java.util.Map) r3, (com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback) r1)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0084
        L_0x006e:
            java.security.InvalidParameterException r6 = new java.security.InvalidParameterException     // Catch:{ Exception -> 0x0076 }
            java.lang.String r7 = "参数非法"
            r6.<init>(r7)     // Catch:{ Exception -> 0x0076 }
            throw r6     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            r6 = move-exception
            java.lang.String r6 = r6.getLocalizedMessage()
            java.lang.String r7 = "10001"
            java.lang.String r6 = r5.a((java.lang.String) r7, (java.lang.String) r6)
            r8.onResult(r6)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.api.BaiduPayDelegate.changePayMethod(android.app.Activity, java.lang.String, com.baidu.wallet.api.IPrecashierCallback):void");
    }

    private boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.p;
        com.dxmpay.apollon.utils.LogUtil.logd("timeD=" + j2);
        if (0 < j2 && j2 < 800) {
            return true;
        }
        this.p = currentTimeMillis;
        return false;
    }

    private Bundle a(String str, Map<String, String> map, Map<String, String> map2) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT < 18) {
            try {
                bundle.getClass().getDeclaredMethod("putIBinder", new Class[]{String.class, IBinder.class}).invoke(bundle, new Object[]{"callback", b()});
            } catch (Exception e2) {
                LogUtil.e(b, e2.getMessage(), e2);
            }
        } else {
            bundle.putBinder("callback", (IBinder) b());
        }
        bundle.putString("order_info", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        arrayList.add(map2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        bundle.putParcelableArrayList("map_params", arrayList2);
        return bundle;
    }

    /* access modifiers changed from: private */
    public void d() {
        if (PayRequestCache.getInstance().isPaying()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pay_sort_change", 1);
                EventBus instance = EventBus.getInstance();
                instance.getClass();
                EventBus.getInstance().post(new EventBus.Event(DxmPayBeanConstants.EVENT_PAY_SORT_SETTING, jSONObject.toString()));
            } catch (Exception e2) {
                LogUtil.e(b, e2.getMessage(), e2);
            }
        }
    }

    public void preOrderPay(Context context, String str, String str2, PayCallBack payCallBack, IModifyPayTypeCallback iModifyPayTypeCallback) {
        StatisticManager.onEvent("preOrderPay");
        if (c()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_PRE_ORDER_PAY);
            return;
        }
        StatHelper.clearSensor();
        String str3 = "1";
        StatHelper.cachePayFrom(str3);
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
        cashierEnterSensor(PayStatServiceEvent.PERCASHIER_PAY_ENTER, str);
        final HashMap hashMap = new HashMap();
        hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
        hashMap.put("pay_amount", StatHelper.getPayAmount());
        PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(TextUtils.isEmpty(str2) ? "order_from=pre_cashdesk" : !str2.contains("order_from") ? "&order_from=pre_cashdesk" : "");
        final String sb2 = sb.toString();
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().setFromPreCashier();
        String orderNo = StatHelper.getOrderNo();
        String[] strArr = new String[1];
        strArr[0] = WalletLoginHelper.getInstance().isPassLogin() ? str3 : "0";
        StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_LOGIN, (Collection<String>) StatHelper.collectData(orderNo, strArr), (Map<String, Object>) hashMap);
        if (!WalletLoginHelper.getInstance().isPassLogin()) {
            str3 = "0";
        }
        StatHelper.cachePassLoginStatus(str3);
        final PayCallBack payCallBack2 = payCallBack;
        final Context context2 = context;
        final String str4 = str;
        this.f = new HandlePassLoginResult(context, true, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f);
                    return;
                }
                if (StatHelper.getPassLoginStatus().equals("1")) {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, (Collection<String>) StatHelper.collectData(StatHelper.getOrderNo(), "0"), (Map<String, Object>) hashMap);
                }
                PayCallBack payCallBack = payCallBack2;
                if (payCallBack != null) {
                    payCallBack.onPayResult(2, "");
                }
            }

            public void onSuccess(int i2, String str) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, (Collection<String>) StatHelper.collectData(StatHelper.getOrderNo(), "1"), (Map<String, Object>) hashMap);
                BaiduPay.getInstance().preOrderPay(context2, str4, sb2, payCallBack2, new HashMap());
            }
        });
        WalletLoginHelper.getInstance().login(this.f);
    }

    private void a(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        new com.baidu.wallet.paysdk.setting.a.a(context, str, payCallBack, map).a();
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, final IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        BeanManager.getInstance().removeAllBeans(c);
        new Handler(context.getMainLooper()).removeCallbacksAndMessages((Object) null);
        PrecashierDefaultPayTypeBean precashierDefaultPayTypeBean = (PrecashierDefaultPayTypeBean) PrecashierBeanFactory.getInstance().getBean(context, 1, c);
        precashierDefaultPayTypeBean.setParams(str);
        precashierDefaultPayTypeBean.setResponseCallback(new IBeanResponseCallback() {
            public void onBeanExecFailure(int i2, int i3, String str) {
                IDefaultPayMethodCallback iDefaultPayMethodCallback = iDefaultPayMethodCallback;
                if (iDefaultPayMethodCallback != null) {
                    iDefaultPayMethodCallback.onReceived(i3, str);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:22:0x0038 A[SYNTHETIC, Splitter:B:22:0x0038] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onBeanExecSuccess(int r3, java.lang.Object r4, java.lang.String r5) {
                /*
                    r2 = this;
                    com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback r3 = r6
                    if (r3 != 0) goto L_0x0005
                    return
                L_0x0005:
                    r3 = 0
                    java.lang.String r5 = "ret"
                    if (r4 == 0) goto L_0x0033
                    boolean r0 = r4 instanceof java.lang.String
                    if (r0 == 0) goto L_0x0033
                    java.lang.String r4 = (java.lang.String) r4
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0024 }
                    r0.<init>(r4)     // Catch:{ JSONException -> 0x0024 }
                    int r3 = r0.getInt(r5)     // Catch:{ JSONException -> 0x0022 }
                    if (r3 != 0) goto L_0x0032
                    com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback r3 = r6     // Catch:{ JSONException -> 0x0022 }
                    r1 = 0
                    r3.onReceived(r1, r4)     // Catch:{ JSONException -> 0x0022 }
                    return
                L_0x0022:
                    r3 = move-exception
                    goto L_0x0027
                L_0x0024:
                    r4 = move-exception
                    r0 = r3
                    r3 = r4
                L_0x0027:
                    java.lang.String r4 = com.baidu.wallet.api.BaiduPayDelegate.b
                    java.lang.String r1 = r3.getMessage()
                    com.dxmpay.wallet.core.utils.LogUtil.e(r4, r1, r3)
                L_0x0032:
                    r3 = r0
                L_0x0033:
                    r4 = -1
                    java.lang.String r0 = ""
                    if (r3 == 0) goto L_0x0050
                    int r4 = r3.getInt(r5)     // Catch:{ Exception -> 0x0044 }
                    java.lang.String r5 = "msg"
                    java.lang.String r3 = r3.getString(r5)     // Catch:{ Exception -> 0x0044 }
                    r0 = r3
                    goto L_0x0050
                L_0x0044:
                    r3 = move-exception
                    java.lang.String r5 = com.baidu.wallet.api.BaiduPayDelegate.b
                    java.lang.String r1 = r3.getMessage()
                    com.dxmpay.wallet.core.utils.LogUtil.e(r5, r1, r3)
                L_0x0050:
                    com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback r3 = r6
                    r3.onReceived(r4, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.api.BaiduPayDelegate.AnonymousClass4.onBeanExecSuccess(int, java.lang.Object, java.lang.String):void");
            }
        });
        precashierDefaultPayTypeBean.execBean();
    }

    /* access modifiers changed from: private */
    public void a(Context context, Map<String, String> map) {
        if (context != null && map != null) {
            String str = map.get("key_remote_pkg_name");
            String str2 = map.get("key_remote_where_to_back");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent = new Intent();
                intent.setComponent(componentName);
                if (!BaiduWalletUtils.isActivity(context)) {
                    intent.addFlags(268435456);
                }
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                context.startActivity(intent);
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(0, 0);
                }
            }
        }
    }

    private ArrayList<String> a(String str, Map map, Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str) && map == null) {
            return arrayList;
        }
        try {
            String spNo = StatHelper.getSpNo(str);
            StatHelper.cacheSpNo(spNo);
            arrayList.add(spNo);
            String orderNo = StatHelper.getOrderNo(str);
            StatHelper.cacheOrderNo(orderNo);
            arrayList.add(orderNo);
            arrayList.add(context.getPackageName());
            if (map.containsKey("key_remote_pkg_name")) {
                String str2 = (String) map.get("key_remote_pkg_name");
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                StatHelper.cacheFromPkg(str2);
                arrayList.add(str2);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private ArrayList<String> a(WalletInterfaceResponse.WalletModuleData walletModuleData) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (walletModuleData == null) {
            return arrayList;
        }
        arrayList.add("" + walletModuleData.type);
        arrayList.add(walletModuleData.link_addr);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public String a(String str, String str2) {
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", str);
                jSONObject.put("des", str2);
            } catch (JSONException e2) {
                LogUtil.e(b, e2.getMessage(), e2);
            }
        } else {
            jSONObject = null;
        }
        hashMap.put("data", Base64Utils.encodeToString(jSONObject != null ? jSONObject.toString().getBytes() : str2.getBytes()));
        return assembleResult(hashMap, false);
    }

    /* access modifiers changed from: private */
    public void a(String str, Context context, com.baidu.wallet.paysdk.securitycenter.a aVar) {
        BeanManager.getInstance().removeAllBeans(d);
        new Handler(context.getMainLooper()).removeCallbacksAndMessages((Object) null);
        if (EnterDxmPayServiceAction.DXM_GET_SECURITY_CENTER_DATA.equals(str)) {
            SecurityCenterBean securityCenterBean = (SecurityCenterBean) SecurityCenterFactory.getInstance().getBean(context, 0, d);
            securityCenterBean.setResponseCallback(new a(aVar));
            securityCenterBean.execBean();
        } else if (EnterDxmPayServiceAction.DXM_GET_PAY_SETTING_DATA.equals(str)) {
            PaySetListBean paySetListBean = (PaySetListBean) SecurityCenterFactory.getInstance().getBean(context, 1, d);
            paySetListBean.setResponseCallback(new a(aVar));
            paySetListBean.execBean();
        } else {
            aVar.a(StatusCode.ERROR_NOT_IMPLEMENTED, "功能未实现");
        }
    }
}
