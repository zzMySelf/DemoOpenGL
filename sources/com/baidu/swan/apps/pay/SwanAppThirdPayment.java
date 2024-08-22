package com.baidu.swan.apps.pay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.payment.PaymentManager;
import com.baidu.payment.PaymentRuntime;
import com.baidu.payment.callback.PayResultDetailCallback;
import com.baidu.payment.callback.PolyActionCallback;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.account.OnSwanAppLoginResultListener;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.filemanage.FileErrorMsg;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppThirdPayment {
    private static final Map<String, String> CHANNEL_MAPPING_SOURCE;
    private static final String CHOSEN_CHANNEL_VALUE_ALIPAY = "Alipay";
    private static final String CHOSEN_CHANNEL_VALUE_WECHAT = "WeChat";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String[] NON_EMPTY_KEYS = {"dealId", "appKey", "totalAmount", ORDER_INFO_KEY_TP_ORDER_ID, ORDER_INFO_KEY_RSA_SIGN, ORDER_INFO_KEY_DEAL_TITLE, "chosenChannel", "payInfo", ORDER_INFO_KEY_TRADE_NO, ORDER_INFO_KEY_MCHIDMD5};
    private static final String ORDER_INFO_KEY_APP_KEY = "appKey";
    private static final String ORDER_INFO_KEY_CHOSEN_CHANNEL = "chosenChannel";
    private static final String ORDER_INFO_KEY_DEAL_ID = "dealId";
    private static final String ORDER_INFO_KEY_DEAL_TITLE = "dealTitle";
    private static final String ORDER_INFO_KEY_MCHIDMD5 = "mchIdMd5";
    private static final String ORDER_INFO_KEY_PANEL_TYPE = "panelType";
    private static final String ORDER_INFO_KEY_PAY_INFO = "payInfo";
    private static final String ORDER_INFO_KEY_RETURN_DATA = "returnData";
    private static final String ORDER_INFO_KEY_RSA_SIGN = "rsaSign";
    private static final String ORDER_INFO_KEY_TOTAL_AMOUNT = "totalAmount";
    private static final String ORDER_INFO_KEY_TP_ORDER_ID = "tpOrderId";
    private static final String ORDER_INFO_KEY_TRADE_NO = "tradeNo";
    private static final String ORDER_INFO_KEY_TRADE_TYPE = "tradeType";
    private static final String PANEL_TYPE_VALUE_NONE = "NONE";
    private static final String PAY_RESULT_JSON_STRING_KEY_MSG = "msg";
    private static final String PAY_RESULT_JSON_STRING_KEY_STATUS_CODE = "statusCode";
    public static final String TAG = "SwanAppThirdPayment";
    private static final String TRADE_TYPE_VALUE_DIRECT_PAY = "DIRECTPAY";
    /* access modifiers changed from: private */
    public String mPayChannel;
    private PaymentManager mPaymentManager;
    /* access modifiers changed from: private */
    public String mStatisticSource = "thirdPayUnknown";
    private SwanApp mSwanApp;
    /* access modifiers changed from: private */
    public Activity mSwanAppActivity;
    private ThirdPayCallBack mThirdPayCallBack;

    public interface ThirdPayCallBack {
        void onPayResult(SwanApiResult swanApiResult);
    }

    static {
        HashMap hashMap = new HashMap();
        CHANNEL_MAPPING_SOURCE = hashMap;
        hashMap.put(CHOSEN_CHANNEL_VALUE_WECHAT, "thirdPayWechatH5");
        hashMap.put(CHOSEN_CHANNEL_VALUE_ALIPAY, "thirdPayAlipay");
    }

    public SwanAppThirdPayment(SwanApp swanApp, Activity swanAppActivity, ThirdPayCallBack thirdPayCallBack) {
        this.mSwanApp = swanApp;
        this.mSwanAppActivity = swanAppActivity;
        this.mThirdPayCallBack = thirdPayCallBack;
        this.mPaymentManager = new PaymentManager();
    }

    public void pay(JSONObject orderInfo, String invokeFrom) {
        SwanAppUBCStatistic.onPayProcess(this.mStatisticSource, "create", 0);
        SwanApiResult checkResult = paramsCheck(orderInfo);
        if (checkResult != null) {
            String msg = "orderInfo param error: " + checkResult;
            SwanAppStabilityMonitor.onPaySceneMonitor(getScene(), 1001, msg, "orderInfo invalid, please check orderInfo", (Map<String, String>) null);
            SwanAppLog.i(TAG, msg);
            SwanAppUBCStatistic.onPay(false, this.mStatisticSource, SwanAppUBCStatistic.getPayReportInfo("", "orderInfo param error"));
            doPayCallback(checkResult);
            return;
        }
        String optString = orderInfo.optString("chosenChannel");
        this.mPayChannel = optString;
        String str = CHANNEL_MAPPING_SOURCE.get(optString);
        this.mStatisticSource = str;
        if (TextUtils.isEmpty(str)) {
            SwanAppStabilityMonitor.onPaySceneMonitor(getScene(), 1001, "orderInfo param error: chosen channel error", "orderInfo invalid, please check orderInfo", (Map<String, String>) null);
            SwanAppLog.i(TAG, "orderInfo param error: chosen channel error");
            SwanAppUBCStatistic.onPay(false, "thirdPayUnknown", SwanAppUBCStatistic.getPayReportInfo("", "orderInfo param error: chosen channel error"));
            doPayCallback(new SwanApiResult(202, "chosenChannel error"));
            return;
        }
        payWithAuthorityCheck(orderInfo, invokeFrom);
    }

    private void payWithAuthorityCheck(final JSONObject orderInfo, final String invokeFrom) {
        this.mSwanApp.getSetting().checkOrAuthorize(this.mSwanAppActivity, "scope_request_thirdpayment", new TypedCallback<TaskResult<Authorize.Result>>() {
            public void onCallback(TaskResult<Authorize.Result> result) {
                if (!OAuthUtils.isAuthorizeOk(result)) {
                    SwanAppStabilityMonitor.onPaySceneMonitor(SwanAppThirdPayment.this.getScene(), 1005, "authorize fail", "please call this api after apply for permission", (Map<String, String>) null);
                    SwanAppLog.i(SwanAppThirdPayment.TAG, "authorize fail");
                    SwanAppUBCStatistic.onPay(false, SwanAppThirdPayment.this.mStatisticSource, SwanAppUBCStatistic.getPayReportInfo("", "authorize fail"));
                    SwanAppThirdPayment.this.doPayCallback(new SwanApiResult(result.getErrorCode(), OAuthUtils.getErrorMessage(result.getErrorCode())));
                    return;
                }
                SwanAppThirdPayment.this.payWithLoginCheck(orderInfo, invokeFrom);
            }
        });
    }

    /* access modifiers changed from: private */
    public void payWithLoginCheck(final JSONObject orderInfo, final String invokeFrom) {
        if (!TextUtils.equals(this.mPayChannel, CHOSEN_CHANNEL_VALUE_WECHAT) || PaymentRuntime.getPaymentRuntime().isWxAppInstalledAndSupported(this.mSwanAppActivity)) {
            SwanAppUBCStatistic.onPayProcess(this.mStatisticSource, "login", 0);
            if (this.mSwanApp.getAccount().isLogin(this.mSwanAppActivity)) {
                SwanAppUBCStatistic.onPayLogin(this.mStatisticSource, true, true);
                handleThirdPay(orderInfo);
                return;
            }
            SwanAppUBCStatistic.onSwanAppLoginDataStatistic("show", 13, invokeFrom);
            this.mSwanApp.getAccount().login(this.mSwanAppActivity, (Bundle) null, new OnSwanAppLoginResultListener() {
                public void onResult(int resultCode) {
                    if (resultCode == 0) {
                        SwanAppUBCStatistic.onPayLogin(SwanAppThirdPayment.this.mStatisticSource, true, false);
                        SwanAppUBCStatistic.onSwanAppLoginDataStatistic("success", 13, invokeFrom);
                        SwanAppThirdPayment.this.handleThirdPay(orderInfo);
                        return;
                    }
                    SwanAppLog.i(SwanAppThirdPayment.TAG, "login error");
                    SwanAppStabilityMonitor.onPaySceneMonitor(SwanAppThirdPayment.this.getScene(), 5000, "login error", (String) null, (Map<String, String>) null);
                    SwanAppUBCStatistic.onPay(false, SwanAppThirdPayment.this.mStatisticSource, SwanAppUBCStatistic.getPayReportInfo("", "login error"));
                    SwanAppUBCStatistic.onSwanAppLoginDataStatistic("fail", 13, invokeFrom);
                    SwanAppUBCStatistic.onPayLogin(SwanAppThirdPayment.this.mStatisticSource, false, false);
                    SwanAppThirdPayment.this.doPayCallback(new SwanApiResult(5, "login error"));
                }
            });
            return;
        }
        Activity activity = this.mSwanAppActivity;
        UniversalToast.makeText((Context) activity, activity.getText(R.string.aiapps_wx_not_install_toast_msg)).showToast();
        SwanAppStabilityMonitor.onPaySceneMonitor(getScene(), 5000, "Error: wechat not install. ", "Error: wechat not install. ", (Map<String, String>) null);
        SwanAppUBCStatistic.onPay(false, "wechatH5Action", SwanAppUBCStatistic.getPayReportInfo("", "Error: wechat not install. "));
        doPayCallback(new SwanApiResult(1002, SwanAppPayLaunchMsg.NOT_INSTALLED_WECHAT_MSG));
    }

    /* access modifiers changed from: private */
    public void handleThirdPay(final JSONObject orderInfo) {
        SwanAppUBCStatistic.onPayProcess(this.mStatisticSource, "intoPayment", 0);
        try {
            SwanAppPaymentManager.appendExtInfo(this.mSwanApp, orderInfo);
            orderInfo.put("tradeType", "DIRECTPAY");
            orderInfo.put("panelType", "NONE");
        } catch (JSONException e2) {
            SwanAppStabilityMonitor.onPaySceneMonitor(getScene(), 2009, "exception: " + Log.getStackTraceString(e2), (String) null, (Map<String, String>) null);
            if (DEBUG) {
                Log.e(TAG, Log.getStackTraceString(e2));
            }
        }
        SwanAppLog.d(TAG, "orderInfo to nuomi: " + orderInfo);
        this.mPaymentManager.polymerPay(this.mSwanAppActivity, orderInfo, (String[]) null, new PayResultDetailCallback() {
            public void onPayResult(int statusCode, String result) {
                int statusCode2;
                int i2 = statusCode;
                String str = result;
                SwanAppLog.d(SwanAppThirdPayment.TAG, "pay result from nuomi: code:" + i2 + ", result: " + str);
                JSONObject resultJson = new JSONObject();
                Object returnDataObj = null;
                String resultMsg = "";
                try {
                    resultJson = new JSONObject(str);
                    returnDataObj = resultJson.remove(SwanAppThirdPayment.ORDER_INFO_KEY_RETURN_DATA);
                    resultMsg = String.valueOf(resultJson.remove("msg"));
                    resultJson.remove("statusCode");
                } catch (JSONException e2) {
                    SwanAppStabilityMonitor.onPaySceneMonitor(SwanAppThirdPayment.this.getScene(), 2009, "exception: " + Log.getStackTraceString(e2), (String) null, (Map<String, String>) null);
                    if (SwanAppThirdPayment.DEBUG) {
                        Log.e(SwanAppThirdPayment.TAG, Log.getStackTraceString(e2));
                    }
                }
                if (returnDataObj != null) {
                    try {
                        resultJson.put(SwanAppThirdPayment.ORDER_INFO_KEY_RETURN_DATA, new JSONObject(String.valueOf(returnDataObj)));
                    } catch (JSONException e3) {
                        JSONException e4 = e3;
                        SwanAppStabilityMonitor.onPaySceneMonitor(SwanAppThirdPayment.this.getScene(), 2009, "exception: " + Log.getStackTraceString(e4), (String) null, (Map<String, String>) null);
                        if (SwanAppThirdPayment.DEBUG) {
                            Log.e(SwanAppThirdPayment.TAG, Log.getStackTraceString(e4));
                        }
                        try {
                            resultJson.put(SwanAppThirdPayment.ORDER_INFO_KEY_RETURN_DATA, returnDataObj);
                        } catch (JSONException e5) {
                            JSONException jsonException = e5;
                            SwanAppStabilityMonitor.onPaySceneMonitor(SwanAppThirdPayment.this.getScene(), 2009, "exception: " + Log.getStackTraceString(e4), (String) null, (Map<String, String>) null);
                            if (SwanAppThirdPayment.DEBUG) {
                                Log.e(SwanAppThirdPayment.TAG, Log.getStackTraceString(jsonException));
                            }
                        }
                    }
                }
                switch (i2) {
                    case 0:
                        SwanAppUBCStatistic.onPay(true, SwanAppThirdPayment.this.mStatisticSource, SwanAppThirdPayment.this.getStatisticResult(str, orderInfo));
                        break;
                    case 1:
                        if (!TextUtils.equals(SwanAppThirdPayment.CHOSEN_CHANNEL_VALUE_WECHAT, SwanAppThirdPayment.this.mPayChannel)) {
                            break;
                        } else {
                            SwanAppUBCStatistic.onPay(true, SwanAppThirdPayment.this.mStatisticSource, SwanAppThirdPayment.this.getStatisticResult(str, orderInfo));
                            break;
                        }
                    default:
                        Map<String, String> pair = new HashMap<>();
                        pair.put(SwanAppUBCStatistic.EXT_ORDERID, String.valueOf(orderInfo.opt(SwanAppThirdPayment.ORDER_INFO_KEY_TP_ORDER_ID)));
                        pair.put("code", String.valueOf(statusCode));
                        SwanAppStabilityMonitor.onPaySceneMonitor(SwanAppThirdPayment.this.getScene(), 4000, SwanAppThirdPayment.this.getStatisticResult(str, orderInfo) + ". pay not success: code:" + i2 + ", result: " + str, (String) null, pair);
                        SwanAppLog.i(SwanAppThirdPayment.TAG, "pay not success: code:" + i2 + ", result: " + str);
                        SwanAppUBCStatistic.onPay(false, SwanAppThirdPayment.this.mStatisticSource, SwanAppThirdPayment.this.getStatisticResult(str, orderInfo));
                        break;
                }
                if (i2 != 1) {
                    SwanAppUBCStatistic.onPayProcess(SwanAppThirdPayment.this.mStatisticSource, "result", i2);
                }
                String payResultMsg = SwanAppThirdPayment.getPayResultMsg(i2, SwanAppThirdPayment.this.mSwanAppActivity, resultMsg);
                if (!TextUtils.equals(SwanAppThirdPayment.CHOSEN_CHANNEL_VALUE_WECHAT, SwanAppThirdPayment.this.mPayChannel) || i2 != 1) {
                    statusCode2 = i2;
                } else {
                    statusCode2 = 0;
                }
                SwanAppThirdPayment.this.doPayCallback(new SwanApiResult(statusCode2, payResultMsg, resultJson));
            }
        }, new PolyActionCallback() {
            public void onResult(int code, int subCode, JSONObject extraInfo) {
                SwanAppUBCStatistic.polyActionUBC(SwanAppThirdPayment.this.getScene(), code, subCode, extraInfo, String.valueOf(orderInfo.opt(SwanAppThirdPayment.ORDER_INFO_KEY_TP_ORDER_ID)));
            }
        });
    }

    public static String getPayResultMsg(int statusCode, Context context, String resultMsg) {
        switch (statusCode) {
            case 0:
                return context.getString(R.string.swan_app_pay_result_success);
            case 1:
                return context.getString(R.string.swan_app_pay_result_paying);
            case 2:
                return context.getString(R.string.swan_app_pay_result_cancel);
            default:
                return context.getString(R.string.swan_app_pay_result_fail) + ": " + resultMsg;
        }
    }

    /* access modifiers changed from: private */
    public String getStatisticResult(String result, JSONObject orderInfo) {
        JSONObject statisticResult = new JSONObject();
        try {
            JSONObject resultJson = new JSONObject(result);
            statisticResult.put(SwanAppUBCStatistic.EXT_ORDERID, orderInfo.opt(ORDER_INFO_KEY_TP_ORDER_ID));
            statisticResult.put("msg", resultJson.opt("msg"));
        } catch (JSONException e2) {
            SwanAppLog.d(TAG, Log.getStackTraceString(e2));
            try {
                statisticResult.put(SwanAppUBCStatistic.EXT_ORDERID, orderInfo.opt(ORDER_INFO_KEY_TP_ORDER_ID));
                statisticResult.put("msg", result);
            } catch (JSONException ex) {
                SwanAppLog.d(TAG, Log.getStackTraceString(ex));
            }
        }
        return statisticResult.toString();
    }

    private SwanApiResult paramsCheck(JSONObject orderInfo) {
        if (orderInfo == null) {
            return new SwanApiResult(202, "parse orderInfo fail");
        }
        for (String key : NON_EMPTY_KEYS) {
            Object obj = orderInfo.opt(key);
            if (obj == null) {
                return new SwanApiResult(202, key + " is necessary");
            }
            if (!(obj instanceof String)) {
                return new SwanApiResult(202, key + FileErrorMsg.PATH_MUST_BE_STRING);
            }
            if (TextUtils.isEmpty((String) obj)) {
                return new SwanApiResult(202, key + " is empty");
            }
        }
        if (!SwanAppUtils.isNumber(orderInfo.optString("totalAmount"))) {
            return new SwanApiResult(202, this.mSwanAppActivity.getString(R.string.swan_app_total_number_fail));
        }
        Object obj2 = orderInfo.opt(ORDER_INFO_KEY_RETURN_DATA);
        if (obj2 == null || (obj2 instanceof JSONObject)) {
            return null;
        }
        return new SwanApiResult(202, "returnData must be a object");
    }

    /* access modifiers changed from: private */
    public void doPayCallback(SwanApiResult payResult) {
        this.mThirdPayCallBack.onPayResult(payResult);
        SwanAppLog.d(TAG, "pay result to js: " + payResult);
    }

    public String getScene() {
        if (TextUtils.isEmpty(this.mPayChannel)) {
            return "thirdPayUnknown";
        }
        return TextUtils.equals(CHOSEN_CHANNEL_VALUE_WECHAT, this.mPayChannel) ? "thirdPayWechatH5" : "thirdPayAlipay";
    }
}
