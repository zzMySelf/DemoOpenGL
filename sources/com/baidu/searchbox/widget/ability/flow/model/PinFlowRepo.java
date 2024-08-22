package com.baidu.searchbox.widget.ability.flow.model;

import android.content.ComponentName;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.widget.IWidgetService;
import com.baidu.searchbox.widget.ability.flow.NetHelpersKt;
import com.baidu.searchbox.widget.ability.flow.PinFlowHelpersKt;
import com.baidu.searchbox.widget.ability.growth.UserGrowthSilentManagerKt;
import com.baidu.searchbox.widget.ability.pin.utils.DebugUtilsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\n0\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/widget/ability/flow/model/PinFlowRepo;", "", "()V", "buildRequestParams", "", "", "parsePinFlowModel", "Lcom/baidu/searchbox/widget/ability/flow/model/PinFlowModel;", "response", "requestLaunchPinModel", "", "onResult", "Lkotlin/Function1;", "lib-widget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinFlowRepo.kt */
public final class PinFlowRepo {
    public static final PinFlowRepo INSTANCE = new PinFlowRepo();

    private PinFlowRepo() {
    }

    public final void requestLaunchPinModel(Function1<? super PinFlowModel, Unit> onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Map params = buildRequestParams();
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(BaiduIdentityManager.getInstance().appendParam(NetHelpersKt.getLaunchPinFlowUrl(), 1))).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, false))).params(params)).build().executeAsync(new PinFlowRepo$requestLaunchPinModel$1(onResult, params));
    }

    /* access modifiers changed from: private */
    public final PinFlowModel parsePinFlowModel(String response) {
        Object obj;
        Object obj2;
        CharSequence charSequence = response;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            DebugUtilsKt.printLog$default((String) null, PinFlowRepo$parsePinFlowModel$1.INSTANCE, 1, (Object) null);
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            PinFlowRepo pinFlowRepo = this;
            JSONObject jsonObject = new JSONObject(response);
            int errno = jsonObject.optInt("errno", -1);
            if (errno != 0) {
                DebugUtilsKt.printLog("LaunchPinFlowRepo", new PinFlowRepo$parsePinFlowModel$dataJson$1$1(errno));
                return null;
            }
            obj = Result.m8971constructorimpl(jsonObject.optJSONObject("data"));
            if (Result.m8977isFailureimpl(obj)) {
                obj = null;
            }
            JSONObject dataJson = (JSONObject) obj;
            if (dataJson == null) {
                PinFlowRepo pinFlowRepo2 = this;
                DebugUtilsKt.printLog("LaunchPinFlowRepo", PinFlowRepo$parsePinFlowModel$dataJson$2$1.INSTANCE);
                return null;
            }
            String widgetType = dataJson.optString("widgetType");
            CharSequence charSequence2 = widgetType;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (z) {
                DebugUtilsKt.printLog("LaunchPinFlowRepo", PinFlowRepo$parsePinFlowModel$2.INSTANCE);
                return null;
            }
            try {
                Result.Companion companion2 = Result.Companion;
                String optString = dataJson.optString("id", "");
                Intrinsics.checkNotNullExpressionValue(optString, "dataJson.optString(KEY_ID, \"\")");
                obj2 = Result.m8971constructorimpl(Long.valueOf(Long.parseLong(optString)));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj2 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable it = Result.m8974exceptionOrNullimpl(obj2);
            if (it != null) {
                DebugUtilsKt.printLog("LaunchPinFlowRepo", new PinFlowRepo$parsePinFlowModel$id$2$1(it));
            }
            if (Result.m8977isFailureimpl(obj2)) {
                obj2 = null;
            }
            Long l = (Long) obj2;
            if (l != null) {
                return new PinFlowModel(widgetType, l.longValue());
            }
            return null;
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th3));
        }
    }

    private final Map<String, String> buildRequestParams() {
        Object obj;
        Object obj2;
        Class provider;
        IDeviceScore it = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
        String str = "-1";
        if (it != null) {
            switch (it.getScoreLevel(AppRuntime.getAppContext())) {
                case 1:
                    str = "1";
                    break;
                case 2:
                    str = "2";
                    break;
                case 3:
                    str = "3";
                    break;
            }
        }
        String deviceLevel = str;
        JSONObject widgetObject = new JSONObject();
        IWidgetService getOrNull = IWidgetService.Companion.getGetOrNull();
        if (getOrNull != null) {
            boolean z = true;
            List<Integer> widgetTypeList = getOrNull.getWidgetTypeList(true);
            if (widgetTypeList != null) {
                Iterable<Number> $this$forEach$iv = widgetTypeList;
                for (Number intValue : $this$forEach$iv) {
                    int widgetId = intValue.intValue();
                    IWidgetService getOrNull2 = IWidgetService.Companion.getGetOrNull();
                    boolean isSilentAdd = false;
                    boolean isExist = getOrNull2 != null ? getOrNull2.isWidgetExist(widgetId) : false;
                    IWidgetService getOrNull3 = IWidgetService.Companion.getGetOrNull();
                    if (!(getOrNull3 == null || (provider = getOrNull3.getWidgetProviderClass(widgetId, z)) == null)) {
                        isSilentAdd = PinFlowHelpersKt.isWidgetPinBySilent(new ComponentName(AppRuntime.getAppContext(), provider));
                    }
                    if (isExist || isSilentAdd) {
                        String key = "1-" + widgetId;
                        JSONObject jSONObject = new JSONObject();
                        JSONObject $this$buildRequestParams_u24lambda_u2d8_u24lambda_u2d7 = jSONObject;
                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                        $this$buildRequestParams_u24lambda_u2d8_u24lambda_u2d7.put("id", String.valueOf(widgetId));
                        if (isSilentAdd) {
                            obj = "1";
                        } else {
                            obj = "0";
                        }
                        Object obj3 = "0";
                        $this$buildRequestParams_u24lambda_u2d8_u24lambda_u2d7.put("addType", obj);
                        $this$buildRequestParams_u24lambda_u2d8_u24lambda_u2d7.put("widgetType", "1");
                        if (isExist) {
                            obj2 = obj3;
                        } else {
                            obj2 = "1";
                        }
                        $this$buildRequestParams_u24lambda_u2d8_u24lambda_u2d7.put("delete", obj2);
                        Unit unit = Unit.INSTANCE;
                        widgetObject.put(key, jSONObject);
                        $this$forEach$iv = $this$forEach$iv2;
                        z = true;
                    }
                }
            }
        }
        Map linkedHashMap = new LinkedHashMap();
        Map $this$buildRequestParams_u24lambda_u2d9 = linkedHashMap;
        $this$buildRequestParams_u24lambda_u2d9.put("deviceLevel", deviceLevel);
        String jSONObject2 = widgetObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "widgetObject.toString()");
        $this$buildRequestParams_u24lambda_u2d9.put("addedWidget", jSONObject2);
        Map it2 = UserGrowthSilentManagerKt.collectGrowthAttribute();
        if (it2 != null) {
            linkedHashMap.putAll(it2);
        }
        return linkedHashMap;
    }
}
