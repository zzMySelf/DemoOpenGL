package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.CheckCallBack;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierBeanFactory;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierFundDisplayBean;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class BaiduPayServiceController {
    public ILightappInvokerCallback a;

    public static class a {
        public static BaiduPayServiceController a = new BaiduPayServiceController();
    }

    private void b(Context context, String str, boolean z) {
        if (!SdkInitResponse.getInstance().jumpSwanApp || !c(context, SdkInitResponse.getInstance().transactionSchemeUrl)) {
            String transactionRecordsUrl = SdkInitResponse.getInstance().getTransactionRecordsUrl(context);
            if (TextUtils.isEmpty(transactionRecordsUrl)) {
                transactionRecordsUrl = DxmPayBeanConstants.TRANSACTION_RECORDS_URL;
            }
            StringBuilder sb = new StringBuilder(transactionRecordsUrl);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int i2 = new JSONObject(str).getInt("order_type");
                    sb.append("?");
                    sb.append("order_type");
                    sb.append("=");
                    sb.append(i2);
                } catch (Exception e) {
                    LogUtil.e("BaiduPayServiceController", e.getMessage(), e);
                }
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, sb.toString(), false);
        }
    }

    private void c(Context context) {
        String paySecurityCenterUrl = SdkInitResponse.getInstance().getPaySecurityCenterUrl(context);
        if (TextUtils.isEmpty(paySecurityCenterUrl)) {
            paySecurityCenterUrl = DxmPayBeanConstants.API_PAY_SECURITY_CENTER_URL;
        }
        BaiduWalletDelegate.getInstance().openH5Module(context, paySecurityCenterUrl, false);
    }

    public static BaiduPayServiceController getInstance() {
        return a.a;
    }

    public void doScanCode(Context context) {
        doScanCode(context, false, (String) null, (String) null);
    }

    public void getFundMethod(Context context, String str, RouterCallback routerCallback) {
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        final long currentTimeMillis = System.currentTimeMillis();
        final Context context2 = context;
        final String str2 = str;
        final RouterCallback routerCallback2 = routerCallback;
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                BaiduPayServiceController.this.a(context2, str2, currentTimeMillis, routerCallback2);
            }

            public void onSuccess(int i2, String str) {
                BaiduPayServiceController.this.a(context2, str2, currentTimeMillis, routerCallback2);
            }
        }));
    }

    public void gotoCheckPwdFromH5(Context context, String str, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().checkPwdFromH5(context, str, new CheckCallBack() {
            public void onCheckResult(int i2, String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("errorCode", Integer.valueOf(i2));
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_CHECK_PWD_FROM_H5_RESULT, (Collection<String>) new ArrayList(), (Map<String, Object>) hashMap);
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    HashMap hashMap3 = new HashMap();
                    if (i2 == 0) {
                        hashMap3.put("content", str);
                    } else {
                        hashMap3.put("errCode", Integer.valueOf(i2));
                        hashMap3.put("des", str);
                    }
                    int i3 = 1;
                    hashMap2.put("result", BaiduPayDelegate.getInstance().assembleResult(hashMap3, i2 == 0));
                    RouterCallback routerCallback = routerCallback;
                    if (i2 == 0) {
                        i3 = 0;
                    }
                    routerCallback.onResult(i3, hashMap2);
                }
            }
        });
    }

    public void gotoPaySetActivity(Context context) {
        String paySettingUrl = SdkInitResponse.getInstance().getPaySettingUrl(context);
        if (TextUtils.isEmpty(paySettingUrl)) {
            paySettingUrl = DxmPayBeanConstants.API_PAY_SETTING_URL;
        }
        if (com.baidu.wallet.paysdk.setting.a.a().b()) {
            paySettingUrl = paySettingUrl + "&in_pay_process=1";
        }
        BaiduWalletDelegate.getInstance().openH5Module(context, paySettingUrl, false);
    }

    public void gotoWalletService(Context context, String str, String str2) {
        gotoWalletService(context, str, str2, true);
    }

    public BaiduPayServiceController() {
        this.a = null;
    }

    public void doScanCode(Context context, boolean z, String str) {
        doScanCode(context, z, (String) null, str);
    }

    public void gotoWalletService(Context context, long j, String str) {
        gotoWalletService(context, j, str, true);
    }

    public void doScanCode(Context context, boolean z, String str, String str2) {
        String payCodeUrl = SdkInitResponse.getInstance().getPayCodeUrl(context);
        if (TextUtils.isEmpty(payCodeUrl)) {
            payCodeUrl = DxmPayBeanConstants.API_WALLET_SCANCODE;
        }
        BaiduWalletDelegate.getInstance().openH5Module(context, payCodeUrl, false);
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        if (iLightappInvokerCallback != null) {
            this.a = iLightappInvokerCallback;
            gotoWalletService(context, str, str2, true);
        }
    }

    private void a(Context context, String str, boolean z) {
        if (!SdkInitResponse.getInstance().jumpSwanApp || !c(context, SdkInitResponse.getInstance().balanceSchemeUrl)) {
            String balanceHomeUrl = SdkInitResponse.getInstance().getBalanceHomeUrl(context);
            if (TextUtils.isEmpty(balanceHomeUrl)) {
                balanceHomeUrl = DxmPayBeanConstants.API_WALLET_BALANCE_HOME_PATH;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    StringBuilder sb = new StringBuilder(balanceHomeUrl);
                    sb.append("?");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = jSONObject.optString(next);
                        sb.append(next);
                        sb.append("=");
                        sb.append(optString);
                        sb.append(com.alipay.sdk.m.s.a.n);
                    }
                    if (sb.length() > 0) {
                        balanceHomeUrl = sb.substring(0, sb.length() - 1);
                    }
                } catch (Exception e) {
                    LogUtil.e("BaiduPayServiceController", e.getMessage(), e);
                }
            }
            BaiduWalletDelegate instance = BaiduWalletDelegate.getInstance();
            instance.openH5Module(context, balanceHomeUrl + Bank.HOT_BANK_LETTER, "", z, false);
        }
    }

    private boolean c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }

    public void gotoWalletService(Context context, String str, String str2, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                gotoWalletService(context, Long.parseLong(str), str2, z);
            } catch (Exception e) {
                LogUtil.e("BaiduPayServiceController", e.getMessage(), e);
            }
        }
    }

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        if (context != null && j >= 0) {
            if (j == 4) {
                StatisticManager.onEvent("#myBankInfo");
                a(context);
            } else if (j == 16) {
                StatisticManager.onEvent("#transRecord");
                b(context, str, z);
            } else if (j == 8) {
                StatisticManager.onEvent("#securityCenter");
                c(context);
            } else if (j == 128) {
                StatisticManager.onEvent("#o2oParser");
                a(context, str);
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PAY_SET) {
                StatisticManager.onEvent("#paySet");
                com.baidu.wallet.paysdk.setting.a.a().a(false);
                gotoPaySetActivity(context);
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_SET) {
                StatisticManager.onEvent("#pwdSet");
                b(context);
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK) {
                StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_CHECK_PWD_FROM_H5_ENTER, str);
                b(context, str);
            } else if (j == 512) {
                StatisticManager.onEvent("#scanQrCode");
                doScanCode(context, false, str);
            } else if (j == 32) {
                StatisticManager.onEvent("#balanceInfo");
                a(context, str, z);
            } else if (j == 8192) {
                StatisticManager.onEvent("#cashBack");
                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_service_offline_tips"));
            } else {
                GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_not_include_tips"));
            }
        }
    }

    private void b(Context context, String str) {
        BaiduPayDelegate.getInstance().checkPwdFromH5(context, str, new CheckCallBack() {
            public void onCheckResult(int i2, String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("errorCode", Integer.valueOf(i2));
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_CHECK_PWD_FROM_H5_RESULT, (Collection<String>) new ArrayList(), (Map<String, Object>) hashMap);
                if (BaiduPayServiceController.this.a != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("{\"result\":");
                    int i3 = 0;
                    sb.append(i2 == 0 ? 0 : 1);
                    sb.append(",\"cnt\":{");
                    if (i2 == 0) {
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("\"content\":\"");
                            sb.append(str);
                            sb.append("\"");
                        }
                        sb.append("}}");
                    } else {
                        sb.append("\"errCode\":");
                        sb.append(i2);
                        sb.append(",\"des\":\"");
                        sb.append(str);
                        sb.append("\"}}");
                    }
                    ILightappInvokerCallback a2 = BaiduPayServiceController.this.a;
                    if (i2 != 0) {
                        i3 = 1;
                    }
                    a2.onResult(i3, sb.toString());
                    ILightappInvokerCallback unused = BaiduPayServiceController.this.a = null;
                }
            }
        });
    }

    private void b(Context context) {
        String payPwdSettingUrl = SdkInitResponse.getInstance().getPayPwdSettingUrl(context);
        if (TextUtils.isEmpty(payPwdSettingUrl)) {
            payPwdSettingUrl = DxmPayBeanConstants.API_PAY_PWD_SETTING_URL;
        }
        BaiduWalletDelegate.getInstance().openH5Module(context, payPwdSettingUrl, false);
    }

    private void a(Context context) {
        if (!SdkInitResponse.getInstance().jumpSwanApp || !c(context, SdkInitResponse.getInstance().bankCardSchemeUrl)) {
            String bankCardListUrl = SdkInitResponse.getInstance().getBankCardListUrl(context);
            if (TextUtils.isEmpty(bankCardListUrl)) {
                bankCardListUrl = DxmPayBeanConstants.API_BANK_CARD_LIST_URL;
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, bankCardListUrl, false);
        }
    }

    private void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, com.baidu.apollon.heartbeat.a.h);
            } catch (UnsupportedEncodingException e) {
                LogUtil.e("BaiduPayServiceController", e.getMessage(), e);
            }
            BaiduWalletUtils.invokeHostLightapp(context, str);
            return;
        }
        GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_error"));
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, long j, final RouterCallback routerCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(StatHelper.getProcesssId());
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - j));
        StatisticManager.onEventWithValues(PayStatServiceEvent.GET_FUND_METHOD_OPENBDUSS, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        if (routerCallback == null) {
            throw new IllegalArgumentException(BaiduPayServiceController.class.getSimpleName() + " please check params");
        } else if (context == null || TextUtils.isEmpty(str)) {
            EnterDxmPayServiceAction.failCallback(EnterDxmPayServiceAction.DXM_GET_FUND_METHOD, 10001, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
        } else {
            PrecashierFundDisplayBean precashierFundDisplayBean = (PrecashierFundDisplayBean) PrecashierBeanFactory.getInstance().getBean(context, 4, "");
            precashierFundDisplayBean.setParams(str);
            precashierFundDisplayBean.setResponseCallback(new IBeanResponseCallback() {
                public void onBeanExecFailure(int i2, int i3, String str) {
                    EnterDxmPayServiceAction.failCallback(EnterDxmPayServiceAction.DXM_GET_FUND_METHOD, i3, str, routerCallback);
                }

                /* JADX WARNING: Removed duplicated region for block: B:19:0x0033 A[SYNTHETIC, Splitter:B:19:0x0033] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onBeanExecSuccess(int r5, java.lang.Object r6, java.lang.String r7) {
                    /*
                        r4 = this;
                        java.lang.String r5 = "BaiduPayServiceController"
                        java.lang.String r7 = "getFundMethod"
                        java.lang.String r0 = "ret"
                        r1 = 0
                        if (r6 == 0) goto L_0x002e
                        boolean r2 = r6 instanceof java.lang.String
                        if (r2 == 0) goto L_0x002e
                        java.lang.String r6 = (java.lang.String) r6
                        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0026 }
                        r2.<init>(r6)     // Catch:{ JSONException -> 0x0026 }
                        int r1 = r2.getInt(r0)     // Catch:{ JSONException -> 0x0023 }
                        if (r1 != 0) goto L_0x0021
                        r1 = 0
                        com.baidu.wallet.router.RouterCallback r3 = r9     // Catch:{ JSONException -> 0x0023 }
                        com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction.successCallback(r7, r1, r6, r3)     // Catch:{ JSONException -> 0x0023 }
                        return
                    L_0x0021:
                        r1 = r2
                        goto L_0x002e
                    L_0x0023:
                        r6 = move-exception
                        r1 = r2
                        goto L_0x0027
                    L_0x0026:
                        r6 = move-exception
                    L_0x0027:
                        java.lang.String r2 = r6.getMessage()
                        com.dxmpay.wallet.core.utils.LogUtil.e(r5, r2, r6)
                    L_0x002e:
                        r6 = -1
                        java.lang.String r2 = ""
                        if (r1 == 0) goto L_0x0047
                        int r6 = r1.getInt(r0)     // Catch:{ Exception -> 0x003f }
                        java.lang.String r0 = "msg"
                        java.lang.String r5 = r1.getString(r0)     // Catch:{ Exception -> 0x003f }
                        r2 = r5
                        goto L_0x0047
                    L_0x003f:
                        r0 = move-exception
                        java.lang.String r1 = r0.getMessage()
                        com.dxmpay.wallet.core.utils.LogUtil.e(r5, r1, r0)
                    L_0x0047:
                        com.baidu.wallet.router.RouterCallback r5 = r9
                        com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction.failCallback(r7, r6, r2, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.BaiduPayServiceController.AnonymousClass4.onBeanExecSuccess(int, java.lang.Object, java.lang.String):void");
                }
            });
            precashierFundDisplayBean.execBean();
        }
    }
}
