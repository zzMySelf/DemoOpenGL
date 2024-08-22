package com.baidu.swan.apps.pay;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.payment.PaymentRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppWebViewFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.toast.UniversalToast;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppWxWebViewPayment {
    private static final boolean DEBUG = false;
    private static final String TAG = "WxWebViewPayment";

    public static boolean openWebView(Context context, CallbackHandler handler, UnitedSchemeEntity entity) {
        String url = parseUrlFromEntityParams(entity);
        if (TextUtils.isEmpty(url)) {
            SwanAppLog.i(TAG, "wxPay: url is empty");
            SwanAppStabilityMonitor.onPaySceneMonitor("wechatH5Action", 1001, "src invalid, src is empty", "src invalid, src is empty", (Map<String, String>) null);
            SwanAppLog.logToFile(TAG, "param check error - src" + url);
            SwanAppUBCStatistic.onPay(false, "wechatH5Action", SwanAppUBCStatistic.getPayReportInfo(url, "param check error - src"));
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "src invalid, src is empty");
            return false;
        } else if (!PaymentRuntime.getPaymentRuntime().isWxAppInstalledAndSupported(context)) {
            UniversalToast.makeText(context, context.getText(R.string.aiapps_wx_not_install_toast_msg)).showToast();
            SwanAppLog.logToFile(TAG, "Error: wechat not install. " + url);
            SwanAppStabilityMonitor.onPaySceneMonitor("wechatH5Action", 5000, "Error: wechat not install. ", (String) null, (Map<String, String>) null);
            SwanAppUBCStatistic.onPay(false, "wechatH5Action", SwanAppUBCStatistic.getPayReportInfo(url, "Error: wechat not install. "));
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1002, SwanAppPayLaunchMsg.NOT_INSTALLED_WECHAT_MSG);
            return false;
        } else {
            SwanAppPageParam pageParam = SwanAppPageParam.createObject(url, url);
            SwanAppLog.logToFile(TAG, "Info: open wechat pay webview, pageParam =" + pageParam);
            if (!SwanAppWebViewFragment.open(ISwanPageManager.WXPAY, pageParam)) {
                SwanAppStabilityMonitor.onPaySceneMonitor("wechatH5Action", 2001, "Error: webview fragment not opened.", (String) null, (Map<String, String>) null);
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Error: webview fragment not opened.");
                SwanAppLog.logToFile(TAG, "Error: webview fragment not opened.");
                return false;
            }
            SwanAppLog.logToFile(TAG, "Success:open wxPay page success");
            SwanAppLog.logToFile(TAG, "Info: end WeChat H5 redirect " + url);
            UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(SwanAppPayLaunchMsg.getWechatH5FinalJsonObject(url), 0));
            return true;
        }
    }

    private static String parseUrlFromEntityParams(UnitedSchemeEntity entity) {
        String paramsString = entity.getParams().get("params");
        if (TextUtils.isEmpty(paramsString)) {
            return null;
        }
        try {
            return new JSONObject(paramsString).optString("src");
        } catch (JSONException e2) {
            return null;
        }
    }
}
