package com.baidu.swan.apps.scheme;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.pay.SwanAppPaymentManager;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppUnitedSchemeWalletDispatcher extends UnitedSchemeBaseDispatcher {
    private static final String ACTION_REQUEST_ALI_PAYMENT = "requestAliPayment";
    private static final String ACTION_REQUEST_PAYMENT = "requestPayment";
    private static final String ACTION_REQUEST_POLYMER_PAYMENT = "requestPolymerPayment";
    private static final String ACTION_REQUEST_WECHAT_PAYMENT = "requestWeChatPayment";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String MODULE_WALLET = "BDWallet";
    private static final String ORDER_INFO = "orderInfo";
    private static final String PARAM_ADD_CALLBACK = "cb";
    private static final String PARAM_VERSION = "version";
    private static final String TAG = "SwanWalletDispatcher";

    public String getDispatcherName() {
        return MODULE_WALLET;
    }

    public boolean invoke(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        String invokeFrom;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        SwanAppLog.d(TAG, "entity uri = ", entity.getUri());
        SwanAppLog.i(TAG, "start UnitedSchemeWalletDispatcher");
        String action = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(action)) {
            if (!entity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "no action");
            }
            SwanAppLog.logToFile(TAG, "Error: uri action is null.");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
            return false;
        }
        CallbackHandler callbackHandler = handler;
        if (entity.isOnlyVerify()) {
            SwanAppLog.logToFile(TAG, "Error: is only verify.");
            return true;
        }
        JSONObject paramsJson = UnitedSchemeUtility.optParamsAsJo(entity);
        if (paramsJson == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.logToFile(TAG, "Error: params is null.");
            return false;
        }
        String orderInfo = paramsJson.optString(ORDER_INFO);
        String version = paramsJson.optString("version");
        String cb = paramsJson.optString("cb");
        SwanApp swanApp = SwanApp.get();
        if (swanApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.logToFile(TAG, "Error: swan app is null.");
            return false;
        } else if (Swan.get().getSwanFrameContainer() == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.logToFile(TAG, "Error: swan activity is null.");
            return false;
        } else {
            String invokeFrom2 = paramsJson.optString("from");
            if (TextUtils.isEmpty(invokeFrom2)) {
                invokeFrom = "api";
            } else {
                invokeFrom = invokeFrom2;
            }
            String invokeFrom3 = invokeFrom;
            SwanAppPaymentManager swanAppPaymentManager = new SwanAppPaymentManager(swanApp, entity, handler, version, swanApp.getAppKey(), cb);
            if (ACTION_REQUEST_PAYMENT.equals(action)) {
                SwanAppLog.i(TAG, "start PAYMENT");
                SwanAppUBCStatistic.onPayProcess("baiduqianbao", "create", 0);
                return swanAppPaymentManager.checkAuthorize("mapp_request_duxiaoman", orderInfo, invokeFrom3);
            } else if (ACTION_REQUEST_ALI_PAYMENT.equals(action)) {
                SwanAppLog.i(TAG, "start ALI PAYMENT");
                SwanAppUBCStatistic.onPayProcess("alipay", "create", 0);
                return swanAppPaymentManager.checkAuthorize("mapp_request_alipayment", orderInfo, invokeFrom3);
            } else if (ACTION_REQUEST_POLYMER_PAYMENT.equals(action)) {
                SwanAppLog.i(TAG, "start POLYMER PAYMENT");
                checkCashierType(orderInfo);
                SwanAppUBCStatistic.onPayProcess("nuomi", "create", 0);
                return swanAppPaymentManager.polymerPay(orderInfo, paramsJson);
            } else {
                if (TextUtils.equals(ACTION_REQUEST_WECHAT_PAYMENT, action)) {
                    SwanAppLog.i(TAG, "start WECHAT HTML5 PAYMENT");
                    SwanAppUBCStatistic.onPayProcess("wechatH5Action", "create", 0);
                    return swanAppPaymentManager.checkAuthorize("mapp_request_wechatpayment", orderInfo, invokeFrom3);
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String path) {
        return null;
    }

    private void checkCashierType(String orderInfo) {
        if (!TextUtils.isEmpty(orderInfo)) {
            try {
                String inlinePaySign = new JSONObject(orderInfo).optString(SwanAppPaymentManager.KEY_INLINE_PAY_SIGN);
                if (!TextUtils.isEmpty(inlinePaySign) && PaymentPanelManager.getInstance().checkInlinePaySign(inlinePaySign)) {
                    PaymentPanelManager.getInstance().isInlinePaymentPanel = true;
                    return;
                }
            } catch (JSONException e2) {
                if (SwanAppLibConfig.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        PaymentPanelManager.getInstance().isInlinePaymentPanel = false;
    }
}
