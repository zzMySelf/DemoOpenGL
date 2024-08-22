package com.baidu.searchbox.feed.payment.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.io.JSONUtils;
import com.baidu.poly.Cashier;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.payment.DismissCallback;
import com.baidu.searchbox.feed.payment.FeedPayManagerEx;
import com.baidu.searchbox.feed.payment.IColumnAccountListener;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.SpColumnAccountOption;
import com.baidu.searchbox.feed.payment.core.FeedPaymentManager;
import com.baidu.searchbox.feed.payment.core.datachannel.FeedAssistMsgSender;
import com.baidu.searchbox.feed.payment.core.model.FeedPaymentConfig;
import com.baidu.searchbox.feed.payment.core.model.PayInfo;
import com.baidu.searchbox.feed.payment.core.model.PaymentOrderInfo;
import com.baidu.searchbox.feed.payment.model.PaidSubIntroductionParam;
import com.baidu.searchbox.feed.payment.payui.CouponFrontendKt;
import com.baidu.searchbox.feed.payment.payui.IntroductionManager;
import com.baidu.searchbox.feed.payment.payui.PaySuccessCommonDialogManager;
import com.baidu.searchbox.feed.payment.payui.PayUiFacade;
import com.baidu.searchbox.launch.restore.data.ColdLaunchRestoreTypeKt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.wallet.data.WalletConstants;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UnitedSchemeFeedPaymentDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String ACTION_GET_CASHIER_VERSION = "getCashierSDKVersion";
    public static final String ACTION_OPEN_LANDPAGE = "openLandpage";
    public static final String ACTION_PAY = "pay";
    public static final String ACTION_PAY_ORDER = "payOrder";
    public static final String ACTION_SHOW_AUTHORIZE_DIALOG = "authorizePhone";
    public static final String ACTION_SHOW_COUPON_DIALOG = "coupon";
    public static final String ACTION_SHOW_INTRODUCTION = "showIntroduction";
    public static final String ACTION_SHOW_PS_INTRODUCTION = "showPaidSubIntroduction";
    private static final String KEY_CASHIER_VERSION = "cashiersdk";
    private static final String KEY_COLUMN_TYPE = "columnType";
    private static final String KEY_EXT = "ext";
    private static final String KEY_IS_FREE = "isFree";
    private static final String KEY_IS_PRESENT = "isPresent";
    private static final String KEY_IS_SHOW_REBUY = "isShowRebuy";
    private static final String KEY_ITEM_ID = "itemId";
    private static final String KEY_OPEN_COMPONENT = "openComponent";
    private static final String KEY_ORIGIN_SCHEME = "originScheme";
    private static final String KEY_PARAMS = "params";
    private static final String KEY_PAY_EXT = "pay_ext";
    private static final String KEY_PAY_RESULT = "pay_result";
    private static final String KEY_PRESENT_BUY = "presentBuy";
    private static final String KEY_RECEIVE = "receive";
    private static final String KEY_RESTORED_FLAG = "restoredFlag";
    private static final String KEY_RES_ID = "resId";
    private static final String KEY_SELECT_TAB_ID = "selectTabId";
    private static final String KEY_SERVER_EXT = "sExt";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_SPLIT_PAY_TYPE = "splitPayType";
    private static final String KEY_TYPE = "type";
    private static final String KEY_UNSHOW_ANIM = "unshowAnim";
    public static final String TAG = "FeedPaymentScheme";
    private static final String VALUE_COLUMN_TYPE = "1";
    private static final String VALUE_PAY_SUCCESS = "1";
    private static final String VALUE_REBUY_DIALOG = "1";
    private static final String VALUE_SP_COLUMN = "spColumn";
    private final Map<String, ActionHandler> actionHandlerMap = new HashMap();
    private final byte[] actionHandlerMapLock = new byte[0];

    public interface ActionHandler {
        String getActionName();

        void handleAction(Context context, String str, CallbackHandler callbackHandler);
    }

    public void addActionHandler(ActionHandler actionHandler) {
        if (actionHandler != null) {
            synchronized (this.actionHandlerMapLock) {
                this.actionHandlerMap.put(actionHandler.getActionName(), actionHandler);
            }
        }
    }

    private ActionHandler getActionHandler(String actionName) {
        ActionHandler actionHandler;
        if (actionName == null) {
            return null;
        }
        synchronized (this.actionHandlerMapLock) {
            actionHandler = this.actionHandlerMap.get(actionName);
        }
        return actionHandler;
    }

    public UnitedSchemeFeedPaymentDispatcher() {
        try {
            addActionHandler((ActionHandler) Class.forName("com.baidu.searchbox.feed.payment.utils.schemes.PopupSchemeActionHandler").newInstance());
        } catch (Exception e2) {
            OnLineLog.get("FeedPay").w("FeedPaymentScheme addActionHandler failed when create PopupSchemeActionHandler: " + e2.getLocalizedMessage());
        }
    }

    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    public boolean invoke(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        OnLineLog.get("FeedPay").d("FeedPaymentScheme UnitedSchemeFeedPaymentDispatcher invoke action=" + entity.getPath(false));
        if (!checkSchemeValid(context, entity)) {
            return false;
        }
        if (entity.isOnlyVerify() || needRedirect(context, entity, handler)) {
            return true;
        }
        handleAction(context, parsePayParam(entity), entity, handler);
        return true;
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String s) {
        return null;
    }

    private boolean needRedirect(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        String value;
        String action = entity.getPath(false);
        Map<String, String> params = entity.getParams();
        String paramsJson = "{}";
        if (!(params == null || (value = params.get("params")) == null || value.isEmpty())) {
            paramsJson = value;
        }
        ActionHandler actionHandler = getActionHandler(action);
        if (actionHandler == null) {
            return false;
        }
        actionHandler.handleAction(context, paramsJson, handler);
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private boolean checkSchemeValid(Context context, UnitedSchemeEntity entity) {
        if (context == null) {
            OnLineLog.get("FeedPay").d("FeedPaymentScheme context is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String action = entity.getPath(false);
        if (TextUtils.isEmpty(action)) {
            if (!entity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "no action");
            }
            OnLineLog.get("FeedPay").w("FeedPaymentScheme Uri action is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (isActionValid(action)) {
            return true;
        } else {
            if (!entity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "unknown action");
            }
            OnLineLog.get("FeedPay").d("FeedPaymentScheme Uri action is unknown");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
    }

    private PayParam parsePayParam(UnitedSchemeEntity entity) {
        HashMap<String, String> params = entity.getParams();
        JSONObject paramJson = JSONUtils.parseString(params != null ? params.get("params") : null);
        OnLineLog.get("FeedPay").d("FeedPaymentScheme param = " + (params != null ? params.toString() : "null"));
        PayParam payParam = new PayParam();
        payParam.fromJson(paramJson);
        return payParam;
    }

    private IntroductionParam parseIntroductionParam(UnitedSchemeEntity entity) {
        HashMap<String, String> params = entity.getParams();
        JSONObject paramJson = JSONUtils.parseString(params != null ? params.get("params") : null);
        OnLineLog.get("FeedPay").d("FeedPaymentScheme param = " + (params != null ? params.toString() : "null"));
        IntroductionParam presentParam = new IntroductionParam();
        presentParam.fromJson(paramJson);
        return presentParam;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r1.equals("pay") != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleAction(android.content.Context r5, com.baidu.searchbox.feed.payment.core.UnitedSchemeFeedPaymentDispatcher.PayParam r6, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r7, com.baidu.searchbox.unitedscheme.CallbackHandler r8) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r7.getPath(r0)
            if (r1 == 0) goto L_0x008e
            if (r6 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case -1354573786: goto L_0x005e;
                case -995910229: goto L_0x0054;
                case 110760: goto L_0x004a;
                case 78237445: goto L_0x0040;
                case 155972535: goto L_0x0035;
                case 546142161: goto L_0x002a;
                case 871802724: goto L_0x001f;
                case 1355353990: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0068
        L_0x0014:
            java.lang.String r0 = "payOrder"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 7
            goto L_0x0069
        L_0x001f:
            java.lang.String r0 = "openLandpage"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0069
        L_0x002a:
            java.lang.String r0 = "showPaidSubIntroduction"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 5
            goto L_0x0069
        L_0x0035:
            java.lang.String r0 = "showIntroduction"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 2
            goto L_0x0069
        L_0x0040:
            java.lang.String r0 = "authorizePhone"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 4
            goto L_0x0069
        L_0x004a:
            java.lang.String r3 = "pay"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0013
            goto L_0x0069
        L_0x0054:
            java.lang.String r0 = "getCashierSDKVersion"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 6
            goto L_0x0069
        L_0x005e:
            java.lang.String r0 = "coupon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 3
            goto L_0x0069
        L_0x0068:
            r0 = r2
        L_0x0069:
            switch(r0) {
                case 0: goto L_0x0089;
                case 1: goto L_0x0085;
                case 2: goto L_0x0081;
                case 3: goto L_0x007d;
                case 4: goto L_0x0079;
                case 5: goto L_0x0075;
                case 6: goto L_0x0071;
                case 7: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x008d
        L_0x006d:
            r4.handlePayOrder(r5, r7, r8)
            goto L_0x008d
        L_0x0071:
            r4.handleCashierVersion(r7, r8)
            goto L_0x008d
        L_0x0075:
            r4.handlePaidSubIntroductionAction(r5, r7, r8)
            goto L_0x008d
        L_0x0079:
            r4.handleAuthorizeAction(r5, r6, r7, r8)
            goto L_0x008d
        L_0x007d:
            r4.handleCouponAction(r5, r6, r7, r8)
            goto L_0x008d
        L_0x0081:
            r4.handleShowIntroductionAction(r5, r7, r8)
            goto L_0x008d
        L_0x0085:
            r4.handleOpenLandpageAction(r5, r6, r7, r8)
            goto L_0x008d
        L_0x0089:
            r4.handlePayAction(r5, r6, r7, r8)
        L_0x008d:
            return
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.core.UnitedSchemeFeedPaymentDispatcher.handleAction(android.content.Context, com.baidu.searchbox.feed.payment.core.UnitedSchemeFeedPaymentDispatcher$PayParam, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler):void");
    }

    private void handleCashierVersion(UnitedSchemeEntity entity, CallbackHandler handler) {
        JSONObject data = new JSONObject();
        try {
            data.put("cashiersdk", Cashier.SDK_VERSION);
        } catch (JSONException e2) {
        }
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(data, 0));
    }

    private void handlePayOrder(final Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        JSONObject paramsJson = UnitedSchemeUtility.optParamsAsJo(entity);
        if (paramsJson == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param is null");
            return;
        }
        final PayInfo payInfo = new PayInfo();
        FeedPaymentManager paymentManager = new FeedPaymentManager((FeedPaymentConfig) null);
        payInfo.columnId = paramsJson.optString("id");
        payInfo.psExtNid = paramsJson.optString("nid");
        payInfo.source = paramsJson.optString("source");
        payInfo.from = paramsJson.optString("type");
        payInfo.payPrice = paramsJson.optInt("payPrice");
        payInfo.psPayChannel = paramsJson.optString(WalletConstants.KEY_WALLET_PAY_CHANNEL);
        payInfo.currentChannelType = paramsJson.optString(WalletConstants.KEY_WALLET_PAY_CHANNEL);
        payInfo.psTradeType = paramsJson.optString(PolyActivity.TRADE_TYPE);
        payInfo.psProductId = paramsJson.optString("productId");
        payInfo.mPassThrough = paramsJson.optString("passThrough");
        payInfo.ext = paramsJson.optString("ext");
        payInfo.payType = PayInfo.Type.StoryMember;
        paymentManager.pay((Activity) context, payInfo, new FeedPaymentManager.FeedPayCallback() {
            public void onPayResult(int statusCode, String resultMsg) {
                if (statusCode != 0) {
                    FeedAssistMsgSender.sendStatusMessage(context, payInfo.columnId, payInfo.getId(), "pay_result", "0");
                }
            }

            public void onPayStateChanged(int statusCode, String resultMsg) {
            }

            public void onOrderCreated(PaymentOrderInfo orderInfo, PayInfo payInfo) {
            }

            public void closePanel() {
            }
        });
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private boolean isActionValid(String action) {
        return TextUtils.equals(action, "pay") || TextUtils.equals(action, "openLandpage") || TextUtils.equals(action, ACTION_SHOW_INTRODUCTION) || TextUtils.equals(action, "coupon") || TextUtils.equals(action, ACTION_SHOW_AUTHORIZE_DIALOG) || TextUtils.equals(action, ACTION_SHOW_PS_INTRODUCTION) || TextUtils.equals(action, ACTION_GET_CASHIER_VERSION) || TextUtils.equals(action, ACTION_PAY_ORDER) || getActionHandler(action) != null;
    }

    private void handlePayAction(Context context, PayParam payParam, UnitedSchemeEntity entity, CallbackHandler handler) {
        if (payParam == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        String resId = payParam.resId;
        if (!(context instanceof Activity)) {
            OnLineLog.get("FeedPay").d("FeedPaymentScheme context is not activity");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        } else if (TextUtils.isEmpty(resId)) {
            OnLineLog.get("FeedPay").d("FeedPaymentScheme resId is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        } else {
            OnLineLog.get("FeedPay").d("FeedPaymentScheme payParam: " + payParam.toJsonString());
            PayUiFacade.INSTANCE.startPayment(context, buildPayInfo(payParam, "feed"), (FeedPaymentConfig) null);
            JSONObject param = new JSONObject();
            try {
                param.put("pay_result", "1");
            } catch (JSONException e2) {
                Log.w(TAG, e2);
            }
            entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(param, 0));
        }
    }

    private void handleOpenLandpageAction(Context context, PayParam payParam, UnitedSchemeEntity entity, CallbackHandler handler) {
        JSONObject extObject;
        Context context2 = context;
        PayParam payParam2 = payParam;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        if (payParam2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        String resId = payParam2.resId;
        String source = payParam2.source;
        String ext = payParam2.serverExt;
        if (TextUtils.isEmpty(resId)) {
            OnLineLog.get("FeedPay").d("FeedPaymentScheme resId is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context2, "com.baidu.searchbox.feed.payment.column.SpColumnActivity"));
        intent.putExtra("resId", resId);
        String str = "";
        intent.putExtra("source", source != null ? source : str);
        if (ext != null) {
            str = ext;
        }
        intent.putExtra("sExt", str);
        intent.putExtra(KEY_OPEN_COMPONENT, payParam2.componentName);
        HashMap<String, String> infoMap = entity.getInvokeInfo();
        if (infoMap != null && infoMap.containsKey(ColdLaunchRestoreTypeKt.KEY_RESTORE_TYPE)) {
            intent.putExtra(KEY_RESTORED_FLAG, true);
        }
        Uri originUri = entity.getUri();
        if (originUri != null) {
            intent.putExtra(KEY_ORIGIN_SCHEME, originUri.toString());
        }
        try {
            String params = entity.getParams().get("params");
            if (!(params == null || (extObject = new JSONObject(params).optJSONObject("ext")) == null)) {
                intent.putExtra("receive", extObject.optString("receive"));
                intent.putExtra("unshowAnim", extObject.optString("unshowAnim"));
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(payParam2.selectTabId)) {
            intent.putExtra(KEY_SELECT_TAB_ID, payParam2.selectTabId);
        }
        ActivityUtils.startActivitySafely(context2, intent);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), 0));
    }

    private void handlePaidSubIntroductionAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        HashMap<String, String> params = entity.getParams();
        JSONObject paramJson = JSONUtils.parseString(params != null ? params.get("params") : null);
        OnLineLog.get("FeedPay").d("FeedPaymentScheme param = " + (params != null ? params.toString() : "null"));
        PaidSubIntroductionParam param = PaidSubIntroductionParam.Companion.fromJson(paramJson);
        IntroductionManager.Companion.openPaidSubDialog(context, param.getBizType(), param.toMap(), (DismissCallback) null);
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void handleShowIntroductionAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        IntroductionParam param = parseIntroductionParam(unitedSchemeEntity);
        if (TextUtils.equals(param.presentBuy, VALUE_SP_COLUMN)) {
            if (TextUtils.equals(param.needShowRebuy, "1")) {
                PaySuccessCommonDialogManager.Companion.openDialog(context, "text", 3, -1, (DismissCallback) null, false);
            } else {
                IntroductionManager.Companion.openDialog(context, "text", 3, -1, (DismissCallback) null);
            }
        } else if (!TextUtils.isEmpty(param.columnType)) {
            int style = TextUtils.equals(param.columnType, "1") ? 1 : 0;
            if (TextUtils.equals(param.needShowRebuy, "1")) {
                PaySuccessCommonDialogManager.Companion.openDialog(context, "text", 1, style, (DismissCallback) null, false);
            } else {
                IntroductionManager.Companion.openDialog(context, "text", 1, style, (DismissCallback) null);
            }
        } else if (TextUtils.equals(param.needShowRebuy, "1")) {
            PaySuccessCommonDialogManager.Companion.openDialog(context, "text", 0, -1, (DismissCallback) null, false);
        } else {
            IntroductionManager.Companion.openDialog(context, "text", 0, -1, (DismissCallback) null);
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void handleCouponAction(Context context, PayParam payParam, UnitedSchemeEntity entity, CallbackHandler handler) {
        if (payParam == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        String resId = payParam.resId;
        String source = payParam.source;
        String serverExt = payParam.serverExt;
        if (TextUtils.isEmpty(resId)) {
            OnLineLog.get("FeedPay").d("FeedPaymentScheme resId is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        CouponFrontendKt.showReceiveDialog(context, resId, source, "feed", serverExt);
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void handleAuthorizeAction(Context context, PayParam payParam, UnitedSchemeEntity entity, CallbackHandler handler) {
        Context context2 = context;
        PayParam payParam2 = payParam;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        if (payParam2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        String resId = payParam2.resId;
        String source = payParam2.source;
        String serverExt = payParam2.serverExt;
        String str = payParam2.type;
        if (TextUtils.isEmpty(resId)) {
            OnLineLog.get("FeedPay").d("FeedPaymentScheme open authorize resId is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        FeedPayManagerEx.startColumnAccount(context2, resId, new SpColumnAccountOption(source, "text", serverExt, context2.getString(R.string.feed_spcolumn_account_pay_success_toast), payParam2.payExt), (IColumnAccountListener) null);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void doPaySuccessCallback(Context context) {
        IntroductionManager.Companion.openDialog(context, "text", 1, -1, (DismissCallback) null);
    }

    private PayInfo buildPayInfo(PayParam payParam, String from) {
        PayInfo payInfo = new PayInfo();
        if (payParam == null) {
            return payInfo;
        }
        boolean isFree = TextUtils.equals(payParam.freeFlag, "1");
        boolean isPresent = TextUtils.equals(payParam.presentFlag, "1");
        if (TextUtils.isEmpty(payParam.splitPayType) || TextUtils.isEmpty(payParam.itemId)) {
            return PayInfo.with(payParam.resId, isFree, payParam.source, from, payParam.serverExt, isPresent);
        }
        return PayInfo.simpleItemPayInfo(payParam.resId, payParam.source, from, payParam.serverExt, payParam.splitPayType, payParam.itemId);
    }

    static class PayParam {
        String componentName;
        String freeFlag;
        public String itemId;
        public String payExt;
        String presentFlag;
        String resId;
        String selectTabId;
        String serverExt;
        String source;
        public String splitPayType;
        String type;

        PayParam() {
        }

        /* access modifiers changed from: package-private */
        public void fromJson(JSONObject jsonObject) {
            if (jsonObject != null) {
                this.resId = jsonObject.optString("resId");
                this.freeFlag = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_IS_FREE);
                this.componentName = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_OPEN_COMPONENT);
                JSONObject extJson = jsonObject.optJSONObject("ext");
                String str = "";
                this.source = extJson != null ? extJson.optString("source") : str;
                this.serverExt = extJson != null ? extJson.optString("sExt") : str;
                this.payExt = extJson != null ? extJson.optString("pay_ext") : str;
                if (jsonObject != null) {
                    str = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_IS_PRESENT);
                }
                this.presentFlag = str;
                this.type = jsonObject.optString("type", "feed");
                this.selectTabId = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_SELECT_TAB_ID);
                this.splitPayType = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_SPLIT_PAY_TYPE);
                this.itemId = jsonObject.optString("itemId");
            }
        }

        public String toJsonString() {
            return new Gson().toJson((Object) this);
        }
    }

    static class IntroductionParam {
        String columnType;
        String needShowRebuy;
        String presentBuy;

        IntroductionParam() {
        }

        /* access modifiers changed from: package-private */
        public void fromJson(JSONObject jsonObject) {
            if (jsonObject != null) {
                this.presentBuy = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_PRESENT_BUY);
                this.columnType = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_COLUMN_TYPE);
                this.needShowRebuy = jsonObject.optString(UnitedSchemeFeedPaymentDispatcher.KEY_IS_SHOW_REBUY);
            }
        }
    }
}
