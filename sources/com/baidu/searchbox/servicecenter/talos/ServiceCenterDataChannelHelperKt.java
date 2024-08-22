package com.baidu.searchbox.servicecenter.talos;

import android.content.Context;
import android.util.Log;
import com.baidu.map.poipage.module.MessageChannel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.Registry;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.download.center.ui.fusion.manager.decoder.ParseJsonKey;
import com.baidu.searchbox.imsdk.ImNotificationManager;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.location.RequestConfig;
import com.baidu.searchbox.location.data.LocationConstants;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.searchbox.servicecenter.utils.ServiceCenterHistoryHelperKt;
import com.baidu.searchbox.servicecenter.utils.ServiceCenterLocationManager;
import com.baidu.searchbox.servicecenter.utils.ServiceCenterPerformance;
import com.baidu.searchbox.servicecenter.utils.ServiceCenterPerformanceKt;
import com.baidu.searchbox.servicecenter.utils.ServiceCenterPreference;
import com.baidu.voice.event.VoicePanelVisibleChangeEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0012H\u0002\u001a\u0012\u0010%\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002\u001a\b\u0010&\u001a\u00020\u0018H\u0002\u001a\u0010\u0010'\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0012H\u0002\u001a\u0006\u0010(\u001a\u00020\u0018\u001a\u0006\u0010)\u001a\u00020\u0018\u001a\b\u0010*\u001a\u00020\u0018H\u0002\u001a\u001a\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010.\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0012H\u0002\u001a\u0010\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u000201H\u0002\u001a\u0012\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010\u0012H\u0002\u001a\u0012\u00104\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u000101H\u0002\u001a\u0006\u00106\u001a\u00020\u0018\u001a\u0006\u00107\u001a\u00020\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000\"\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00068"}, d2 = {"ACTION", "", "ACTION_KEY_VIEW_MESSAGE", "DATA", "DATA_CHANNEL_ACTION", "DATA_CHANNEL_HOST", "DATA_CHANNEL_PAGE", "DATA_CNAHHEL_TO_NA_ACTION_QUERY_MESSAGE", "DATA_CNAHHEL_TO_TALOS_ACTION_MESSAGE_RESULT", "DEBUG", "", "KEY_IS_SHOW", "KEY_TYPE", "LOCATION_SOURCE", "SP_KEY_HAD_SHOW_LOCATION", "TAG", "VALUE_VOICE", "homeBroadcastDataTemp", "Lorg/json/JSONObject;", "instanceCount", "", "isTalosReady", "loadingDismissListener", "Lkotlin/Function0;", "", "getLoadingDismissListener", "()Lkotlin/jvm/functions/Function0;", "setLoadingDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "performance", "Lcom/baidu/searchbox/servicecenter/utils/ServiceCenterPerformance;", "getPerformance", "()Lcom/baidu/searchbox/servicecenter/utils/ServiceCenterPerformance;", "setPerformance", "(Lcom/baidu/searchbox/servicecenter/utils/ServiceCenterPerformance;)V", "getMessage", "data", "onReceiveCityData", "onReceiveDismissLoading", "parseData", "registerDataChannelObserver", "registerVoicePanelEvent", "requestLocation", "saveCity", "cityCode", "cityName", "sendBroadcast", "sendHistoryData", "historyArray", "Lorg/json/JSONArray;", "sendLocationInfo", "locInfo", "sendMessageResult", "array", "unRegisterDataChannelObserver", "unRegisterVoicePanelEvent", "lib-service-center_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ServiceCenterDataChannelHelper.kt */
public final class ServiceCenterDataChannelHelperKt {
    private static final String ACTION = "action";
    private static final String ACTION_KEY_VIEW_MESSAGE = "customViewMessage";
    private static final String DATA = "data";
    private static final String DATA_CHANNEL_ACTION = "com.baidu.channel.servicecenter";
    private static final String DATA_CHANNEL_HOST = "secondFloor";
    private static final String DATA_CHANNEL_PAGE = "serviceCenter";
    private static final String DATA_CNAHHEL_TO_NA_ACTION_QUERY_MESSAGE = "queryMessage";
    private static final String DATA_CNAHHEL_TO_TALOS_ACTION_MESSAGE_RESULT = "messageResult";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_IS_SHOW = "isShow";
    private static final String KEY_TYPE = "type";
    private static final String LOCATION_SOURCE = "service_center";
    private static final String SP_KEY_HAD_SHOW_LOCATION = "service_center_location_permission";
    private static final String TAG = "ServiceCenterDCH";
    private static final String VALUE_VOICE = "voice";
    private static volatile JSONObject homeBroadcastDataTemp;
    private static int instanceCount;
    private static volatile boolean isTalosReady;
    private static Function0<Unit> loadingDismissListener;
    private static ServiceCenterPerformance performance;

    public static final Function0<Unit> getLoadingDismissListener() {
        return loadingDismissListener;
    }

    public static final void setLoadingDismissListener(Function0<Unit> function0) {
        loadingDismissListener = function0;
    }

    public static final ServiceCenterPerformance getPerformance() {
        return performance;
    }

    public static final void setPerformance(ServiceCenterPerformance serviceCenterPerformance) {
        performance = serviceCenterPerformance;
    }

    public static final void registerDataChannelObserver() {
        int i2 = instanceCount;
        instanceCount = i2 + 1;
        if (i2 <= 0) {
            Registry.registerNAReceiver("secondFloor", "serviceCenter", DATA_CHANNEL_ACTION, new ServiceCenterDataChannelHelperKt$registerDataChannelObserver$1());
            if (DEBUG) {
                Log.i(TAG, "registerDataChannelObserver ");
            }
            performance = new ServiceCenterPerformance("rn");
        }
    }

    public static final void unRegisterDataChannelObserver() {
        int i2 = instanceCount - 1;
        instanceCount = i2;
        if (i2 <= 0) {
            Registry.unregisterReceiver("secondFloor", "serviceCenter", DATA_CHANNEL_ACTION);
            loadingDismissListener = null;
            isTalosReady = false;
            if (DEBUG) {
                Log.i(TAG, "unRegisterDataChannelObserver ");
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void parseData(JSONObject data) {
        String action = data.optString("action");
        if (action != null) {
            switch (action.hashCode()) {
                case -1924566356:
                    if (action.equals("queryHistory")) {
                        ServiceCenterHistoryHelperKt.queryHistoryForTalos(ServiceCenterDataChannelHelperKt$parseData$1.INSTANCE);
                        ServiceCenterPerformanceKt.ubcReceiveAction(action);
                        return;
                    }
                    return;
                case -1896575457:
                    if (action.equals(DATA_CNAHHEL_TO_NA_ACTION_QUERY_MESSAGE)) {
                        getMessage(data);
                        return;
                    }
                    return;
                case -690243758:
                    if (action.equals(MessageChannel.DISMISS_LOADING)) {
                        onReceiveDismissLoading();
                        ServiceCenterPerformanceKt.ubcReceiveAction(action);
                        return;
                    }
                    return;
                case -322933043:
                    if (action.equals("selectCityFromRN")) {
                        onReceiveCityData(data.optJSONObject("data"));
                        return;
                    }
                    return;
                case 195098468:
                    if (action.equals("requestLocation")) {
                        requestLocation();
                        ServiceCenterPerformanceKt.ubcReceiveAction(action);
                        return;
                    }
                    return;
                case 460935522:
                    if (action.equals("broadcastReady")) {
                        isTalosReady = true;
                        JSONObject it = homeBroadcastDataTemp;
                        if (it != null) {
                            sendBroadcast(it);
                            homeBroadcastDataTemp = null;
                        }
                        ServiceCenterPerformanceKt.ubcReceiveAction(action);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static final void onReceiveCityData(JSONObject data) {
        String cityCode = null;
        String cityName = data != null ? data.optString("cityName") : null;
        if (data != null) {
            cityCode = data.optString("cityCode");
        }
        CharSequence charSequence = cityName;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = cityCode;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                saveCity(cityCode, cityName);
            }
        }
    }

    public static final void saveCity(String cityCode, String cityName) {
        ServiceCenterLocationManager.INSTANCE.changeSelectCity(cityCode, cityName);
    }

    /* access modifiers changed from: private */
    public static final void sendHistoryData(JSONArray historyArray) {
        try {
            JSONObject data = new JSONObject();
            data.put("action", "historyResult");
            data.put("data", historyArray);
            sendBroadcast(data);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    private static final void requestLocation() {
        boolean showPermissionDialog = false;
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), LocationConstants.LOCATION_PERMISSION) && !ServiceCenterPreference.Companion.getInstance().getBoolean(SP_KEY_HAD_SHOW_LOCATION, false)) {
            showPermissionDialog = true;
        }
        if (showPermissionDialog) {
            ServiceCenterPreference.Companion.getInstance().putBoolean(SP_KEY_HAD_SHOW_LOCATION, true);
        }
        BoxLocationManager locationManager = (BoxLocationManager) ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE);
        RequestConfig requestConfig = new RequestConfig.Builder().setSource("service_center").setShowPermissionDialog(showPermissionDialog).build();
        locationManager.addLocationListener(new ServiceCenterDataChannelHelperKt$requestLocation$1(locationManager));
        locationManager.requestLocation((Context) BdBoxActivityManager.getTopActivity(), requestConfig);
    }

    /* access modifiers changed from: private */
    public static final void sendLocationInfo(JSONObject locInfo) {
        if (locInfo != null) {
            try {
                JSONObject broadcastData = new JSONObject();
                broadcastData.put("action", "locationInfo");
                broadcastData.put("data", locInfo);
                sendBroadcast(broadcastData);
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private static final void onReceiveDismissLoading() {
        Function0<Unit> function0 = loadingDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
        loadingDismissListener = null;
        ServiceCenterPerformance serviceCenterPerformance = performance;
        if (serviceCenterPerformance != null) {
            serviceCenterPerformance.onPageShow();
        }
        performance = null;
    }

    private static final void getMessage(JSONObject data) {
        JSONArray tabList = data.optJSONArray(ParseJsonKey.GROUP_TAB_LIST);
        if (tabList != null && tabList.length() > 0) {
            List tabMuList = new ArrayList();
            int length = tabList.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString = tabList.optString(i2);
                Intrinsics.checkNotNullExpressionValue(optString, "tabList.optString(i)");
                tabMuList.add(optString);
            }
            int count = data.optInt("count");
            if (count <= 0) {
                count = 20;
            }
            ImNotificationManager.getNotificationMsgDataList(AppRuntime.getAppContext(), tabMuList, count, new ServiceCenterDataChannelHelperKt$$ExternalSyntheticLambda1());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getMessage$lambda-1  reason: not valid java name */
    public static final void m3111getMessage$lambda1(JSONArray array) {
        sendMessageResult(array);
    }

    private static final void sendMessageResult(JSONArray array) {
        JSONObject resultJson = new JSONObject();
        try {
            resultJson.put("action", DATA_CNAHHEL_TO_TALOS_ACTION_MESSAGE_RESULT);
            resultJson.put("data", array);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        sendBroadcast(resultJson);
    }

    private static final void sendBroadcast(JSONObject data) {
        Sender.sendBroadcast(AppRuntime.getAppContext(), DATA_CHANNEL_ACTION, data.toString());
        if (DEBUG) {
            Log.i(TAG, "sendBroadcast: " + data);
        }
    }

    public static final void registerVoicePanelEvent() {
        BdEventBus.Companion.getDefault().register(TAG, VoicePanelVisibleChangeEvent.class, new ServiceCenterDataChannelHelperKt$$ExternalSyntheticLambda0());
    }

    /* access modifiers changed from: private */
    /* renamed from: registerVoicePanelEvent$lambda-3  reason: not valid java name */
    public static final void m3112registerVoicePanelEvent$lambda3(VoicePanelVisibleChangeEvent type) {
        String isShow;
        Intrinsics.checkNotNullParameter(type, "type");
        if (type.isVisible()) {
            isShow = "1";
        } else {
            isShow = "0";
        }
        try {
            Result.Companion companion = Result.Companion;
            JSONObject broadcastData = new JSONObject();
            broadcastData.put("action", ACTION_KEY_VIEW_MESSAGE);
            JSONObject data = new JSONObject();
            data.put("type", "voice");
            data.put("isShow", isShow);
            broadcastData.put("data", data);
            sendBroadcast(broadcastData);
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public static final void unRegisterVoicePanelEvent() {
        BdEventBus.Companion.getDefault().unregister(TAG);
    }
}
