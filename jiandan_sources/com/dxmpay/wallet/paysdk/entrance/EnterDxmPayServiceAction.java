package com.dxmpay.wallet.paysdk.entrance;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.AESUtil;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.StatusCode;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.lollipop.json.JSONArray;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import fe.i.ad.rg.ad.qw.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnterDxmPayServiceAction implements RouterAction {
    public static final String CHECK_PWD_FOR_H5 = "checkPwdForH5";
    public static final String DXMPAY_WEBVIEW_CLOSE = "closeDxmpayWebview";
    public static final String DXMPAY_WEBVIEW_OPEN = "openDxmpayWebview";
    public static final String DXM_ACS_IS_SUCCEED = "dxmPayACSIsSucceed";
    public static final String DXM_ACS_OPEN = "dxmPayACSOpen";
    public static final String DXM_ACS_SUPPORTED = "dxmPayACSSupported";
    public static final String DXM_BALANCE = "dxmBalance";
    public static final String DXM_BANK_CARD = "dxmBankCard";
    public static final String DXM_BIG_WORD_STATUS = "bigWordStatus";
    public static final String DXM_CHANGE_PAY_METHOD = "changePayMethod";
    public static final String DXM_CHECK_BIOMETRICS = "checkBiometrics";
    public static final String DXM_CHECK_PWD = "dxmCheckPwd";
    public static final String DXM_CLEAR_RN_AUTH = "clearRnAuthResult";
    public static final String DXM_CLOSE_BIOMETRICS = "closeBiometrics";
    public static final String DXM_DELETE_PERSONAL_SM = "dxmDeletePersonalSM";
    public static final String DXM_DETECT_BANK_CARD = "detectBankCard";
    public static final String DXM_DO_BIND_CARD = "doBindCard";
    public static final String DXM_DO_PAY = "dxmDoPay";
    public static final String DXM_DO_REMOTE_PAY = "doRemotePay";
    public static final String DXM_DO_RN_AUTH = "doRnAuth";
    public static final String DXM_DO_SCAN_CODE = "doScanCode";
    public static final String DXM_GET_BIOMETRICS_STATUS = "getBiometricsStatus";
    public static final String DXM_GET_FUND_METHOD = "getFundMethod";
    public static final String DXM_GET_PAY_METHOD = "getPayMethod";
    public static final String DXM_GET_PAY_SETTING_DATA = "getPaySettingData";
    public static final String DXM_GET_SECURITY_CENTER_DATA = "getSecurityCenterData";
    public static final String DXM_IDCARD_DETECTION = "dxmIdcardDetection";
    public static final String DXM_LIVENESS_DETECT = "livenessDetect";
    public static final String DXM_LIVENESS_IDENTIFY = "livenessIdentifyAut";
    public static final String DXM_OPEN_BIOMETRICS = "openBiometrics";
    public static final String DXM_PAY_DECRYPT = "dxmPayDecrypt";
    public static final String DXM_PAY_DOPAY = "dopay";
    public static final String DXM_PAY_ENCRYPT = "dxmPayEncrypt";
    public static final String DXM_PAY_SET = "dxmPaySet";
    public static final String DXM_POST_EVENT = "postEvent";
    public static final String DXM_PRE_ORDER_PAY = "preOrderPay";
    public static final String DXM_PWD_SET = "dxmPwdSet";
    public static final String DXM_SECURITY_CENTER = "securityCenter";
    public static final String DXM_SERVICE_EXTRA = "serviceExtra";
    public static final String DXM_SERVICE_NAME = "serviceName";
    public static final String DXM_SET_BIG_WORD = "setBigWord";
    public static final String DXM_SET_RN_AUTH = "setRnAuthResult";
    public static final String DXM_SM_CERTIFICATE_CHECK_STATUS = "dxmSMCertificateCheckStatus";
    public static final String DXM_SM_CERTIFICATE_MANAGE = "dxmSMCertificateManage";
    public static final String DXM_SM_DECRYPT = "dxmSMDecrypt";
    public static final String DXM_SM_ENCRYPT = "dxmSMEncrypt";
    public static final String DXM_TRANS_RECORDS = "transRecords";
    public static final int ERROR_CODE_BACK = -203;
    public static final int ERROR_CODE_PARAMS = -105;
    public static final int ERROR_CODE_PERMISSION = -305;
    public static final String ERROR_MSG_BACK = "用户主动退出";
    public static final String ERROR_MSG_INSIDE = "内部错误";
    public static final String ERROR_MSG_PERMISSION = "没有相机权限";
    public static final int ERROR_WHITELIST_CANCEL = 10005;
    public static final String ERROR_WHITELIST_CANCELMSG = "取消访问页面";
    public static final String ERR_ANALYSIS_MSG = "解析失败";
    public static final String ERR_ANALYSIS_PICTURE = "图片数据解析失败";
    public static final String ERR_METHOD_BLACK_LIST_MEG = "不支持该能力";
    public static final String ERR_MSG = "参数非法";
    public static final String ERR_NOT_HAS_FUNCTION_MSG = "没有端能力";
    public static final String ERR_NOT_SUPPORT_MSG = "不支持该端能力";
    public static final String ERR_NOT_WRITE_PERMISSION = "没有写权限";
    public static final String ERR_SAVE_PICTURE = "图片保存失败";
    public static final String FLOATINGWINDOW_GO2SETTING = "dxmPayPopSetting";
    public static final String FLOATINGWINDOW_SHOW = "dxmPayPopShow";
    public static final String FLOATINGWINDOW_SUPPORTED = "dxmPayPopState";
    public static final String FLOATINGWINDOW_UPDATE_STATE = "dxmPayPopUpdateState";
    public static final String GET_DXM_OAID = "getDxmOaid";
    public static final String GET_DXM_PAY_ALL_SUPPORT_SERVICE_LIST = "getDxmPayAllSupportServiceList";
    public static final String GET_DXM_PAY_SUPPORT_SERVICE_LIST = "getDxmPaySupportServiceList";
    public static final String GET_DXM_PAY_USER_AGENT = "getDxmPayUserAgent";
    public static final String MODULE_CALL_DXM_CAMERA = "callDxmCamera";
    public static final String MODULE_DXM_ACS_TRANSFER = "dxmACSTransfer";
    public static final String MODULE_DXM_JUHE_APP_FUNCTION = "juheAppCommonBridge";
    public static final String MODULE_DXM_SCAN_CODE = "dxmScanCode";
    public static final String MODULE_FLOATINGWINDOW = "floatingWindow";
    public static final String MODULE_NFCKYC = "nfcKyc";
    public static final String MODULE_SAVE_PICTURE = "savePhoto";
    public static final String NFCKYC_GO2NFCSETTING = "goToNfcSetting";
    public static final String NFCKYC_NFC_ENABLED = "isNfcEnabled";
    public static final String NFCKYC_NFC_SUPPORTED = "isNfcSupported";
    public static final String NFCKYC_SETCFGVAL = "nfcSetCfgValue";
    public static final String NFCKYC_VERIFYIDCARD = "nfcVerifyIdCard";
    public static final String OCR_IDCARD_INIT = "ocr_idcard_init";
    public static final String OCR_IDCARD_KEY = "ocr_idcard_key";
    public static final int RET_1 = 1;
    public static final String SERVICE_CNT = "cnt";
    public static final String SERVICE_DATA = "data";
    public static final String SERVICE_DES = "des";
    public static final String SERVICE_RESULT = "result";
    public static final String SERVICE_STATUS_CODE = "statusCode";
    public static final String SP_PARAMS = "spParams";
    public static final long SVC_ID_H5_CHECKPWD = 10013;
    public static List<String> a;

    public class qw implements RouterCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ RouterCallback f4349ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f4350th;

        public qw(EnterDxmPayServiceAction enterDxmPayServiceAction, RouterCallback routerCallback, String str) {
            this.f4349ad = routerCallback;
            this.f4350th = str;
        }

        public void onResult(int i2, HashMap hashMap) {
            RouterCallback routerCallback = this.f4349ad;
            if (routerCallback != null) {
                routerCallback.onResult(i2, hashMap);
            }
            try {
                JSONObject jSONObject = new JSONObject((String) hashMap.get("result"));
                int optInt = jSONObject.optInt("result", 0);
                if (optInt == 0) {
                    NaMethodStatUtils.statResult(this.f4350th, optInt, "");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(new String(Base64Utils.decode(jSONObject.optJSONObject("cnt").optString("data", ""))));
                NaMethodStatUtils.statResult(this.f4350th, jSONObject2.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, 0), jSONObject2.optString("des", ""));
            } catch (JSONException e) {
                LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(MODULE_SAVE_PICTURE);
        a.add(DXM_PAY_ENCRYPT);
        a.add(DXM_PAY_DECRYPT);
        a.add(DXM_DO_PAY);
        a.add(DXM_SM_ENCRYPT);
        a.add(DXM_SM_DECRYPT);
        a.add(DXM_GET_FUND_METHOD);
        a.add(DXM_SM_CERTIFICATE_MANAGE);
    }

    public EnterDxmPayServiceAction() {
        BdWalletUtils.putFunctionNameList(GET_DXM_PAY_USER_AGENT);
        BdWalletUtils.putFunctionNameList(DXM_PAY_ENCRYPT);
        BdWalletUtils.putFunctionNameList(DXM_PAY_DECRYPT);
        BdWalletUtils.putFunctionNameList(GET_DXM_OAID);
        ad.rg().qw();
        fe.i.ad.ad.qw.ad.qw.qw().ad();
    }

    private void a(Context context, String str, RouterCallback routerCallback) {
        Context context2 = context;
        RouterCallback routerCallback2 = routerCallback;
        if (context2 == null || routerCallback2 == null || TextUtils.isEmpty(str)) {
            errorCallback("", 10001, ERR_MSG, routerCallback2);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("serviceName");
            String optString2 = jSONObject.optString("serviceExtra");
            String optString3 = jSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, (String) null);
            if (a(optString)) {
                NaMethodStatUtils.statEnter(optString, "");
            } else if (!"callDXMIDCardOCR".equals(optString)) {
                NaMethodStatUtils.statEnter(optString, optString2);
            } else if (!NaMethodStatUtils.isFastDoubleClick(optString)) {
                NaMethodStatUtils.statEnter(optString, optString2);
            }
            String[] sdkMethodBlackList = SdkInitResponse.getInstance().getSdkMethodBlackList();
            if (sdkMethodBlackList != null && sdkMethodBlackList.length > 0) {
                int i2 = 0;
                while (i2 < sdkMethodBlackList.length) {
                    if (TextUtils.isEmpty(optString) || !optString.equals(sdkMethodBlackList[i2])) {
                        i2++;
                    } else {
                        b(optString, routerCallback2);
                        return;
                    }
                }
            }
            if (!TextUtils.isEmpty(optString3) && 10013 == Long.parseLong(optString3)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("serviceName", (Object) CHECK_PWD_FOR_H5);
                jSONObject2.put("serviceExtra", (Object) optString2);
                a(context2, (Object) jSONObject2.toString(), routerCallback2);
            } else if (TextUtils.isEmpty(optString)) {
                errorCallback(optString, 10001, ERR_MSG, routerCallback2);
            } else if ("callDXMIDCardOCR".equals(optString)) {
                errorCallback(optString, 5, "没有OCR身份证识别模块", routerCallback2);
            } else {
                if (!NFCKYC_NFC_SUPPORTED.equals(optString) && !NFCKYC_NFC_ENABLED.equals(optString) && !NFCKYC_GO2NFCSETTING.equals(optString)) {
                    if (!NFCKYC_VERIFYIDCARD.equals(optString)) {
                        if (GET_DXM_PAY_USER_AGENT.equals(optString)) {
                            successCallback(optString, 0, BussinessUtils.getUA(context), routerCallback2);
                            return;
                        } else if (GET_DXM_PAY_SUPPORT_SERVICE_LIST.equals(optString)) {
                            a(optString2, routerCallback2);
                            return;
                        } else if (GET_DXM_PAY_ALL_SUPPORT_SERVICE_LIST.equals(optString)) {
                            a(routerCallback2);
                            return;
                        } else {
                            if (!FLOATINGWINDOW_SUPPORTED.equals(optString) && !FLOATINGWINDOW_UPDATE_STATE.equals(optString) && !FLOATINGWINDOW_SHOW.equals(optString)) {
                                if (!FLOATINGWINDOW_GO2SETTING.equals(optString)) {
                                    if (!DXM_PAY_ENCRYPT.equals(optString)) {
                                        if (!DXM_PAY_DECRYPT.equals(optString)) {
                                            if (MODULE_SAVE_PICTURE.equals(optString)) {
                                                errorCallback(optString, StatusCode.ERROR_NOT_IMPLEMENTED, ERR_NOT_HAS_FUNCTION_MSG, routerCallback2);
                                                return;
                                            } else if (MODULE_CALL_DXM_CAMERA.equals(optString)) {
                                                errorCallback(optString, StatusCode.ERROR_NOT_IMPLEMENTED, ERR_NOT_HAS_FUNCTION_MSG, routerCallback2);
                                                return;
                                            } else if (MODULE_DXM_SCAN_CODE.equals(optString)) {
                                                errorCallback(optString, StatusCode.ERROR_NOT_IMPLEMENTED, ERR_NOT_HAS_FUNCTION_MSG, routerCallback2);
                                                return;
                                            } else if (MODULE_DXM_JUHE_APP_FUNCTION.equals(optString)) {
                                                if (!TextUtils.isEmpty(optString2)) {
                                                    String optString4 = new JSONObject(optString2).optString("function_name", "");
                                                    if (sdkMethodBlackList != null && sdkMethodBlackList.length > 0) {
                                                        int i3 = 0;
                                                        while (i3 < sdkMethodBlackList.length) {
                                                            if (TextUtils.isEmpty(optString4) || !optString4.equals(sdkMethodBlackList[i3])) {
                                                                i3++;
                                                            } else {
                                                                b(optString4, routerCallback2);
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                                LocalRouter.getInstance(context).route(context2, new RouterRequest().provider(MODULE_DXM_JUHE_APP_FUNCTION).action(MODULE_DXM_JUHE_APP_FUNCTION).data(optString, optString2), routerCallback2);
                                                return;
                                            } else if (GET_DXM_OAID.equals(optString)) {
                                                String dxmOaid = PayUtils.getDxmOaid();
                                                NaMethodStatUtils.statResult(optString, 0, dxmOaid);
                                                if (routerCallback2 != null) {
                                                    HashMap hashMap = new HashMap();
                                                    if (TextUtils.isEmpty(dxmOaid)) {
                                                        hashMap.put("data", "");
                                                    } else {
                                                        hashMap.put("data", Base64Utils.encodeToString(dxmOaid.getBytes()));
                                                    }
                                                    String assembleResult = assembleResult(hashMap, true);
                                                    HashMap hashMap2 = new HashMap();
                                                    hashMap2.put("result", assembleResult);
                                                    routerCallback2.onResult(0, hashMap2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                if (!DXM_SM_ENCRYPT.equals(optString) && !DXM_SM_DECRYPT.equals(optString) && !DXM_SM_CERTIFICATE_MANAGE.equals(optString) && !DXM_SM_CERTIFICATE_CHECK_STATUS.equals(optString)) {
                                                    if (!DXM_DELETE_PERSONAL_SM.equals(optString)) {
                                                        if (!DXMPAY_WEBVIEW_OPEN.equals(optString)) {
                                                            if (!DXMPAY_WEBVIEW_CLOSE.equals(optString)) {
                                                                if (!DXM_ACS_IS_SUCCEED.equals(optString) && !DXM_ACS_SUPPORTED.equals(optString)) {
                                                                    if (!DXM_ACS_OPEN.equals(optString)) {
                                                                        a(context, (Object) str, routerCallback);
                                                                        return;
                                                                    }
                                                                }
                                                                errorCallback(optString, StatusCode.ERROR_NOT_IMPLEMENTED, ERR_NOT_HAS_FUNCTION_MSG, routerCallback2);
                                                                return;
                                                            }
                                                        }
                                                        ad.rg().de(context2, optString, optString2, new qw(this, routerCallback2, optString));
                                                        return;
                                                    }
                                                }
                                                errorCallback(optString, StatusCode.ERROR_NOT_IMPLEMENTED, ERR_NOT_HAS_FUNCTION_MSG, routerCallback2);
                                                return;
                                            }
                                        }
                                    }
                                    a(optString, optString2, routerCallback2);
                                    return;
                                }
                            }
                            errorCallback(optString, 5, "没有悬浮窗模块", routerCallback2);
                            return;
                        }
                    }
                }
                errorCallback(optString, 5, "没有令牌云模块", routerCallback2);
            }
        } catch (JSONException e) {
            LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
            errorCallback("", 10001, e.toString(), routerCallback2);
        }
    }

    public static String assembleResult(Map<String, Object> map, boolean z) {
        if (map == null) {
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("cnt", new org.json.JSONObject(map));
        } catch (org.json.JSONException e) {
            LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
        }
        return jSONObject.toString();
    }

    private void b(String str, RouterCallback routerCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add("10012");
        arrayList.add(ERR_METHOD_BLACK_LIST_MEG);
        StatisticManager.onEventWithValues(StatServiceEvent.HIT_METHOD_BLACK_LIST, arrayList);
        hasDesDataSuccessCallback(str, StatusCode.ERROR_METHOD_BLACK_LIST, ERR_METHOD_BLACK_LIST_MEG, routerCallback);
    }

    public static void errorCallback(String str, int i2, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, i2, str2);
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SERVICE_STATUS_CODE, i2);
                jSONObject.put("des", (Object) str2);
            } catch (JSONException e) {
                LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = assembleResult(hashMap, false);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(1, hashMap2);
        }
    }

    public static void errorNotBase64Callback(String str, int i2, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, i2, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("des", str2);
        String assembleResult = assembleResult(hashMap, false);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", assembleResult);
        if (routerCallback != null) {
            routerCallback.onResult(1, hashMap2);
        }
    }

    public static void failCallback(String str, int i2, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, i2, str2);
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i2);
                jSONObject.put("des", (Object) str2);
            } catch (JSONException e) {
                LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = assembleResult(hashMap, false);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(1, hashMap2);
        }
    }

    public static void hasDesDataSuccessCallback(String str, int i2, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, i2, str2);
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SERVICE_STATUS_CODE, i2);
                jSONObject.put("des", (Object) str2);
            } catch (JSONException e) {
                LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        }
    }

    public static void successCallback(String str, int i2, String str2, RouterCallback routerCallback) {
        if (DXM_GET_FUND_METHOD.equals(str)) {
            NaMethodStatUtils.statResult(str, i2, "");
        } else {
            NaMethodStatUtils.statResult(str, i2, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
        String assembleResult = assembleResult(hashMap, true);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", assembleResult);
        routerCallback.onResult(0, hashMap2);
    }

    public void hasDataCallback(String str, int i2, int i3, String str2, RouterCallback routerCallback) {
        NaMethodStatUtils.statResult(str, i3, "");
        if (routerCallback != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", i2 == 0 ? 0 : 1);
                jSONObject.put(SERVICE_STATUS_CODE, i3);
                jSONObject.put("data", (Object) str2);
                jSONObject2.put("cnt", (Object) jSONObject);
            } catch (JSONException e) {
                LogUtil.d(e.toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("result", jSONObject2.toString());
            routerCallback.onResult(0, hashMap);
        }
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context == null || hashMap == null || !hashMap.containsKey("options") || !(hashMap.get("options") instanceof String)) {
            errorCallback("", 10001, ERR_MSG, routerCallback);
        } else {
            a(context, (String) hashMap.get("options"), routerCallback);
        }
    }

    private boolean a(String str) {
        return a.contains(str);
    }

    private void a(Context context, Object obj, RouterCallback routerCallback) {
        if (context == null || routerCallback == null || obj == null) {
            errorCallback("", 10001, ERR_MSG, routerCallback);
        } else {
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action(BeanConstants.SDK_ENTER_WALLET_DXM_PAY_SERVICE).data("options", obj), routerCallback);
        }
    }

    private void a(String str, RouterCallback routerCallback) {
        RouterCallback routerCallback2 = routerCallback;
        if (TextUtils.isEmpty(str)) {
            errorCallback(GET_DXM_PAY_SUPPORT_SERVICE_LIST, 10001, ERR_MSG, routerCallback2);
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("serviceNameList");
            if (optJSONArray != null) {
                if (optJSONArray.length() != 0) {
                    List<String> a2 = a();
                    if (a2 != null) {
                        if (a2.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("[");
                            boolean z = false;
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                String string = optJSONArray.getString(i2);
                                int i3 = 0;
                                while (true) {
                                    if (i3 < a2.size()) {
                                        if (!TextUtils.isEmpty(string) && string.equals(a2.get(i3))) {
                                            sb.append("\"");
                                            sb.append(string);
                                            sb.append("\"");
                                            sb.append(",");
                                            z = true;
                                            break;
                                        }
                                        i3++;
                                    } else {
                                        break;
                                    }
                                }
                            }
                            if (z) {
                                sb.deleteCharAt(sb.length() - 1);
                                sb.append("]");
                                hasDesDataSuccessCallback(GET_DXM_PAY_SUPPORT_SERVICE_LIST, 0, sb.toString(), routerCallback2);
                                return;
                            }
                            hasDesDataSuccessCallback(GET_DXM_PAY_SUPPORT_SERVICE_LIST, StatusCode.ERROR_NOT_SUPPORT, ERR_NOT_SUPPORT_MSG, routerCallback2);
                            return;
                        }
                    }
                    errorCallback(GET_DXM_PAY_SUPPORT_SERVICE_LIST, StatusCode.ERROR_NOT_SUPPORT, ERR_NOT_SUPPORT_MSG, routerCallback2);
                    return;
                }
            }
            errorCallback(GET_DXM_PAY_SUPPORT_SERVICE_LIST, 10001, ERR_MSG, routerCallback2);
        } catch (JSONException e) {
            LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
            errorCallback(GET_DXM_PAY_SUPPORT_SERVICE_LIST, 10001, e.getMessage(), routerCallback2);
        }
    }

    private void a(RouterCallback routerCallback) {
        List<String> a2 = a();
        if (a2 == null || a2.size() <= 0) {
            errorCallback(GET_DXM_PAY_ALL_SUPPORT_SERVICE_LIST, StatusCode.ERROR_NOT_SUPPORT, ERR_NOT_SUPPORT_MSG, routerCallback);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i2 = 0; i2 < a2.size(); i2++) {
            sb.append("\"");
            sb.append(a2.get(i2));
            sb.append("\"");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        hasDesDataSuccessCallback(GET_DXM_PAY_ALL_SUPPORT_SERVICE_LIST, 0, sb.toString(), routerCallback);
    }

    private List<String> a() {
        List<String> functionNameList = BdWalletUtils.getFunctionNameList();
        String[] sdkMethodBlackList = SdkInitResponse.getInstance().getSdkMethodBlackList();
        if (functionNameList != null && functionNameList.size() > 0) {
            if (sdkMethodBlackList != null && sdkMethodBlackList.length > 0) {
                for (String remove : sdkMethodBlackList) {
                    functionNameList.remove(remove);
                }
            }
            new SMManagerDelegate();
        }
        return functionNameList;
    }

    private void a(String str, String str2, RouterCallback routerCallback) {
        if (TextUtils.isEmpty(str2)) {
            hasDataCallback(str, 1, 10001, ERR_MSG, routerCallback);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!AESUtil.ALGORITHM_NAME.equals(jSONObject.optString("algorithmType", (String) null))) {
                hasDataCallback(str, 0, StatusCode.ERROR_ENCRYPT_OR_DECRYPR, "加密/解密方式不存在", routerCallback);
            } else if (DXM_PAY_ENCRYPT.equals(str)) {
                String optString = jSONObject.optString("encryptData", (String) null);
                if (!TextUtils.isEmpty(optString)) {
                    String localEncryptProxy = SecurePay.getInstance().localEncryptProxy(optString);
                    if (!TextUtils.isEmpty(localEncryptProxy)) {
                        hasDataCallback(str, 0, 0, localEncryptProxy, routerCallback);
                    } else {
                        hasDataCallback(str, 0, 2301, "加密失败", routerCallback);
                    }
                } else {
                    hasDataCallback(str, 0, 10001, ERR_MSG, routerCallback);
                }
            } else {
                String optString2 = jSONObject.optString("decryptData", (String) null);
                if (!TextUtils.isEmpty(optString2)) {
                    String localDecryptProxy = SecurePay.getInstance().localDecryptProxy(optString2);
                    if (!TextUtils.isEmpty(localDecryptProxy)) {
                        hasDataCallback(str, 0, 0, localDecryptProxy, routerCallback);
                    } else {
                        hasDataCallback(str, 0, StatusCode.ERROR_DECRYPR, "解密失败", routerCallback);
                    }
                } else {
                    hasDataCallback(str, 0, 10001, ERR_MSG, routerCallback);
                }
            }
        } catch (JSONException e) {
            LogUtil.e("EnterDxmPayServiceAction", e.getMessage(), e);
            hasDataCallback(str, 1, 10001, e.getMessage(), routerCallback);
        }
    }
}
