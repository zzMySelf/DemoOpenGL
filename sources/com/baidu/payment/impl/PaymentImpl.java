package com.baidu.payment.impl;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.payment.PaymentManager;
import com.baidu.payment.QuickPayHelper;
import com.baidu.payment.callback.PayCallback;
import com.baidu.payment.impl.process.ALiAuthActivityDelegation;
import com.baidu.payment.ioc.IPayment;
import com.baidu.poly.http.Callback;
import com.baidu.poly.util.OpenApp;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.api.SwanAppApi;
import com.baidu.swan.apps.pay.SwanAppPayLaunchMsg;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import org.json.JSONObject;

public class PaymentImpl implements IPayment {
    private static final String ALIPAY_AGREEMENT_KEY = "alipay_user_agreement_page_sign_response";
    private static final String ALIPAY_EXECUTE_COMMAND = "com_baidu_poly_cashier_for_ali_pay_result_activity";
    private static final String ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do?";
    private static final String ALIPAY_KEY_SIGN_PARAMS = "sign_params";
    private static final String CASHIER_FLAG = "cashierSDK";
    private static final boolean DEBUG = false;
    private static final String DECP_PAY_SCHEME = "dcep://uniwallet/unipay";
    private static final String KEY_FLAG = "flag";
    private static final String KEY_RESULT = "result";
    private static final String KEY_SCHEME = "scheme";
    private static final String KEY_STATUS_CODE = "statusCode";
    private static final String KEY_SWAN_APPKEY = "appKey";
    private static final String KEY_SWAN_URL = "redirectUrl";
    private static final String PRE_ENTRUSTWEB_ID = "pre_entrustweb_id";
    private static final String SWAN_PREFIX = (SchemeConfig.getSchemeHead() + "://swan/");
    private static final String TAG = PaymentImpl.class.getSimpleName();
    public static final String WXPAY_CALLBACK_SWAN_GAME_SCHEME = (SchemeConfig.getSchemeHead() + "://swangame/");
    public static final String WXPAY_CALLBACK_SWAN_SCHEME = (SchemeConfig.getSchemeHead() + "://swan/");

    public void baiduPay(Activity activity, String orderInfo, PayCallback callback) {
        SwanAppApi.getPaymentRuntime().baiduPay(activity, orderInfo, callback);
    }

    public void aliPay(Activity activity, String orderInfo, PayCallback callback) {
        SwanAppApi.getPaymentRuntime().aliPay(activity, orderInfo, callback);
    }

    public void weChatPay(Context context, JSONObject payInfo, PayCallback callback) {
        SwanAppApi.getPaymentRuntime().weChatPay(context, payInfo, callback);
    }

    public void quickPassPay(Context context, JSONObject payInfo) {
        if (payInfo == null) {
            PaymentManager.onQuickPayResult(3, "支付信息不能为空");
            return;
        }
        String appKey = payInfo.optString("appKey");
        String path = payInfo.optString(KEY_SWAN_URL);
        if (TextUtils.isEmpty(appKey) || TextUtils.isEmpty(path)) {
            PaymentManager.onQuickPayResult(3, "支付信息不能为空");
        } else {
            SchemeRouter.invoke(context, SWAN_PREFIX + appKey + path);
        }
    }

    public void chinaPay(Activity activity, JSONObject payInfo, PayCallback callback) {
        ChinaPayAgentActivityKt.startPay(activity, payInfo, callback);
    }

    public void doWechatMiniProgramPay(Activity activity, JSONObject payInfo, PayCallback callback) {
        SwanAppApi.getPaymentRuntime().weChatMiniProgramPay(activity, payInfo, callback);
    }

    public void doBocDrmbPay(Activity activity, JSONObject payInfo, PayCallback callback) {
        if (payInfo != null) {
            OpenApp.openSchema(activity, "dcep://uniwallet/unipay?" + payInfo.optString("scheme", ""));
            SwanAppApi.getPaymentRuntime().decpPay(activity, payInfo, callback);
        }
    }

    public void doAliZhiMaPay(Activity activity, JSONObject payInfo, PayCallback callback) {
        if (payInfo != null) {
            OpenApp.openSchema(activity, payInfo.optString("scheme", ""));
            SwanAppApi.getPaymentRuntime().aliZhiMaPay(activity, payInfo, callback);
        }
    }

    public boolean isWxAppInstalledAndSupported(Context context) {
        return ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isWxAppInstalledAndSupported();
    }

    public void setTargetAppId(String appId) {
        SwanAppPayLaunchMsg.getInstance().appId = appId;
    }

    public void onQuickPayResult(Bundle params) {
        String appId = SwanAppPayLaunchMsg.getInstance().appId;
        if (TextUtils.isEmpty(appId)) {
            QuickPayHelper.handleQuickPayResult(params);
        } else {
            SwanAppApi.getMessageSender().sendQuickPayResult(params, appId);
        }
    }

    public String getZid(Context context) {
        return SwanAppApi.getFrameworkRuntime().getZidAnyProcess(context);
    }

    public void signWechatAutoRenew(Activity activity, String appId, String preEntrustWebId) {
        WXOpenBusinessWebview.Req req = new WXOpenBusinessWebview.Req();
        req.businessType = 12;
        HashMap queryInfo = new HashMap();
        queryInfo.put(PRE_ENTRUSTWEB_ID, preEntrustWebId);
        req.queryInfo = queryInfo;
        IWXAPI wxApi = WXAPIFactory.createWXAPI(AppRuntime.getAppContext(), (String) null);
        wxApi.registerApp(appId);
        wxApi.sendReq(req);
    }

    public void aLiAuth(Activity activity, String signUrl, Callback<JSONObject> callback) {
        if (ProcessUtils.isMainProcess()) {
            ALiAuthActivityDelegation.aLiAuth(activity, signUrl, callback);
        } else {
            ALiAuthActivityDelegation.aLiAuthPayWithDelegation(activity, signUrl, callback);
        }
    }

    public void handleWxMiniProgramResult(Object wxResp) {
        if (wxResp != null && (wxResp instanceof WXLaunchMiniProgram.Resp) && 19 == ((WXLaunchMiniProgram.Resp) wxResp).getType()) {
            try {
                JSONObject respJson = new JSONObject(((WXLaunchMiniProgram.Resp) wxResp).extMsg);
                String flag = respJson.optString("flag", "");
                int statusCode = respJson.optInt("statusCode", -1);
                String result = respJson.optString("result", "");
                if (TextUtils.equals(CASHIER_FLAG, flag)) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("statusCode", statusCode);
                    bundle.putString("result", result);
                    SwanAppPayLaunchMsg instance = SwanAppPayLaunchMsg.getInstance();
                    if (!TextUtils.isEmpty(instance.appId)) {
                        sendWxMiniProgramCallbackMsgToSwanAppClient(instance.appId, bundle);
                        StringBuilder data = new StringBuilder();
                        int type = 0;
                        if (TextUtils.isEmpty(instance.wxAppType)) {
                            type = Integer.valueOf(instance.wxAppType).intValue();
                        }
                        if (type == 0) {
                            data.append(WXPAY_CALLBACK_SWAN_SCHEME);
                        } else if (type == 1) {
                            data.append(WXPAY_CALLBACK_SWAN_GAME_SCHEME);
                        }
                        data.append(instance.appId);
                        data.append("?_baiduboxapp=");
                        data.append(instance.wxExt);
                        invokeSchemeOrCmd(AppRuntime.getAppContext(), data.toString(), "inside");
                        return;
                    }
                    PayCallback callback = instance.weChatPayCallback;
                    if (callback != null) {
                        SwanAppPayLaunchMsg.dispatchWxMiniProgramPayResult(bundle, callback);
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    private void sendWxMiniProgramCallbackMsgToSwanAppClient(String appId, Bundle params) {
        if (!TextUtils.isEmpty(appId) && params != null) {
            SwanAppApi.getMessageSender().sendWxMiniProgramPayCallback(params, appId);
        }
    }

    public static boolean invokeSchemeOrCmd(Context context, String cmd, String source) {
        if (TextUtils.isEmpty(cmd)) {
            return false;
        }
        if (cmd.trim().startsWith(UnitedSchemeConstants.UNITED_SCHEME)) {
            Uri uri = Uri.parse(cmd);
            if (Router.isSchemeAvailable(context, uri, source)) {
                return Router.invokeScheme(context, uri, source);
            }
        }
        if (CommandUtils.isCommandAvailable(context, cmd)) {
            return CommandUtils.invokeCommand(context, cmd, (Bundle) null);
        }
        return false;
    }
}
