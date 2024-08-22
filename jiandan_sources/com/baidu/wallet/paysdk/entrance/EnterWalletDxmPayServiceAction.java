package com.baidu.wallet.paysdk.entrance;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.BaiduPayServiceController;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.fingerprint.c;
import com.baidu.wallet.paysdk.fingerprint.entrance.DxmCheckFingerprint;
import com.baidu.wallet.paysdk.setting.a;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.wallet.core.StatusCode;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletDxmPayServiceAction implements RouterAction {
    public EnterWalletDxmPayServiceAction() {
        BdWalletUtils.putFunctionNameList(EnterDxmPayServiceAction.DXM_GET_SECURITY_CENTER_DATA, EnterDxmPayServiceAction.DXM_GET_PAY_SETTING_DATA, EnterDxmPayServiceAction.DXM_OPEN_BIOMETRICS, EnterDxmPayServiceAction.DXM_CLOSE_BIOMETRICS, EnterDxmPayServiceAction.DXM_GET_BIOMETRICS_STATUS, EnterDxmPayServiceAction.DXM_CHECK_BIOMETRICS, EnterDxmPayServiceAction.DXM_SET_BIG_WORD, EnterDxmPayServiceAction.DXM_BIG_WORD_STATUS, EnterDxmPayServiceAction.DXM_DO_PAY, EnterDxmPayServiceAction.DXM_GET_FUND_METHOD);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context == null || hashMap == null || !hashMap.containsKey("options") || !(hashMap.get("options") instanceof String)) {
            b("", 10001, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
        } else {
            a(context, (String) hashMap.get("options"), routerCallback);
        }
    }

    private void b(String str, String str2, RouterCallback routerCallback) {
        String str3 = !"1".equals(str) ? "大字版关闭" : "大字版开启";
        NaMethodStatUtils.statResult(str2, "0", str3);
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, (Object) str);
                jSONObject.put("des", (Object) str3);
            } catch (JSONException e) {
                LogUtil.e("EnterWalletDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str, int i2, String str2, RouterCallback routerCallback) {
        if (routerCallback == null) {
            return;
        }
        if (i2 == 0) {
            d(str, i2, str2, routerCallback);
        } else if (i2 == 10011 || i2 == 10001 || i2 == 10004) {
            b(str, i2, str2, routerCallback);
        } else {
            NaMethodStatUtils.statResult(str, i2, str2);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("ret", i2);
                jSONObject.put("msg", (Object) str2);
                jSONObject.put("content", (Object) jSONObject2);
            } catch (JSONException e) {
                LogUtil.e("EnterWalletDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        }
    }

    /* access modifiers changed from: private */
    public void d(String str, int i2, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, i2, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
        String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", assembleResult);
        routerCallback.onResult(0, hashMap2);
    }

    private void a(Context context, String str, final RouterCallback routerCallback) {
        if (routerCallback == null || TextUtils.isEmpty(str)) {
            b("", 10001, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("serviceName");
            String optString2 = jSONObject.optString("serviceExtra");
            if (!TextUtils.isEmpty(optString)) {
                if (!EnterDxmPayServiceAction.DXM_GET_SECURITY_CENTER_DATA.equals(optString)) {
                    if (!EnterDxmPayServiceAction.DXM_GET_PAY_SETTING_DATA.equals(optString)) {
                        if (EnterDxmPayServiceAction.DXM_OPEN_BIOMETRICS.equals(optString)) {
                            BaiduPayDelegate.getInstance().openFingerprintPay((Activity) context, new c() {
                                public void a(int i2, String str) {
                                    EnterWalletDxmPayServiceAction.this.a(optString, i2, str, routerCallback);
                                }
                            });
                            return;
                        } else if (EnterDxmPayServiceAction.DXM_CLOSE_BIOMETRICS.equals(optString)) {
                            BaiduPayDelegate.getInstance().closeFingerprintPay((Activity) context, new c() {
                                public void a(int i2, String str) {
                                    EnterWalletDxmPayServiceAction.this.a(optString, i2, str, routerCallback);
                                }
                            });
                            return;
                        } else if (EnterDxmPayServiceAction.DXM_GET_BIOMETRICS_STATUS.equals(optString)) {
                            BaiduPayDelegate.getInstance().getBiometricsStatus(context, new c() {
                                public void a(int i2, String str) {
                                    if (i2 == 0) {
                                        EnterWalletDxmPayServiceAction.this.d(optString, i2, str, routerCallback);
                                    } else {
                                        EnterWalletDxmPayServiceAction.this.b(optString, i2, str, routerCallback);
                                    }
                                }
                            });
                            return;
                        } else if (EnterDxmPayServiceAction.CHECK_PWD_FOR_H5.equals(optString)) {
                            BaiduPayServiceController.getInstance().gotoCheckPwdFromH5(context, optString2, routerCallback);
                            return;
                        } else if (EnterDxmPayServiceAction.DXM_CHECK_BIOMETRICS.equals(optString)) {
                            DxmCheckFingerprint.getInstance().startCherkFingerprint(context, optString2, new RouterCallback() {
                                public void onResult(int i2, HashMap hashMap) {
                                    RouterCallback routerCallback = routerCallback;
                                    if (routerCallback != null) {
                                        routerCallback.onResult(i2, hashMap);
                                    }
                                    try {
                                        JSONObject jSONObject = new JSONObject(new String(Base64Utils.decode(new JSONObject((String) hashMap.get("result")).optJSONObject("cnt").optString("data", ""))));
                                        NaMethodStatUtils.statResult(EnterDxmPayServiceAction.DXM_CHECK_BIOMETRICS, jSONObject.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, 0), jSONObject.optString("des", ""));
                                    } catch (Exception e) {
                                        LogUtil.e("EnterWalletDxmPayServiceAction", e.getMessage(), e);
                                    }
                                }
                            });
                            return;
                        } else if (EnterDxmPayServiceAction.DXM_SET_BIG_WORD.equals(optString)) {
                            a.a().a(context, optString2, new a.C0168a() {
                                public void a(Boolean bool, String str) {
                                    if (bool.booleanValue()) {
                                        EnterWalletDxmPayServiceAction.this.a(str, optString, routerCallback);
                                    } else {
                                        EnterWalletDxmPayServiceAction.this.b(optString, -1, "设置失败", routerCallback);
                                    }
                                }
                            });
                            return;
                        } else if (EnterDxmPayServiceAction.DXM_BIG_WORD_STATUS.equals(optString)) {
                            b(a.a().a(context), optString, routerCallback);
                            return;
                        } else if (EnterDxmPayServiceAction.DXM_DO_PAY.equals(optString)) {
                            a.a().a(context, optString2, routerCallback);
                            return;
                        } else if (EnterDxmPayServiceAction.DXM_GET_FUND_METHOD.equals(optString)) {
                            BaiduPayServiceController.getInstance().getFundMethod(context, optString2, routerCallback);
                            return;
                        } else {
                            b(optString, StatusCode.ERROR_NOT_IMPLEMENTED, optString + "功能未实现", routerCallback);
                            return;
                        }
                    }
                }
                BaiduPayDelegate.getInstance().getSecurityCenterOrPaySettingData(optString, context, new com.baidu.wallet.paysdk.securitycenter.a() {
                    public void a(int i2, String str) {
                        EnterWalletDxmPayServiceAction.this.c(optString, i2, str, routerCallback);
                    }
                });
                return;
            }
            b(optString, 10001, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
        } catch (JSONException e) {
            LogUtil.e("EnterWalletDxmPayServiceAction", e.getMessage(), e);
            b("", 10001, e.toString(), routerCallback);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, int i2, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, i2, str2);
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                jSONObject.put("des", (Object) str2);
            } catch (JSONException e) {
                LogUtil.e("EnterWalletDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, false);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(1, hashMap2);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, RouterCallback routerCallback) {
        String str3 = !"1".equals(str) ? "大字版关闭" : "大字版开启";
        NaMethodStatUtils.statResult(str2, "0", str3);
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, (Object) str);
                jSONObject.put("des", (Object) str3);
            } catch (JSONException e) {
                LogUtil.e("EnterWalletDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, (i2 == 2100 || i2 == 2200) ? 0 : i2, str2);
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                jSONObject.put("des", (Object) str2);
            } catch (JSONException e) {
                LogUtil.e("EnterWalletDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        }
    }
}
