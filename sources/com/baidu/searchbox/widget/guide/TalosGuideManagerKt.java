package com.baidu.searchbox.widget.guide;

import android.app.Activity;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.datachannel.DataChannel;
import com.baidu.searchbox.schemedispatch.united.module.UnitedSchemeTalosPopUpFrameAdapter;
import com.baidu.searchbox.schemedispatch.united.module.pyramid.TalosPopupInterface;
import com.baidu.searchbox.schemedispatch.united.module.pyramid.TalosPopupInterfaceKt;
import com.baidu.searchbox.widget.WidgetDataStatisticUtils;
import com.baidu.searchbox.widget.ability.utils.ActivityLifecycleUtilsKt;
import com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils;
import com.baidu.searchbox.widget.debug.WidgetDebugKt;
import com.baidu.searchbox.widget.guide.statistic.GuideStatisticKt;
import com.baidu.talos.IPackageManager;
import com.baidu.talos.TalosManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001aO\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u00162\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"DATA_CHANNEL_ACTION_OPERATE", "", "DATA_CHANNEL_ACTION_WIDGET_GUIDE_BUNDLE_INFO", "GUIDE_TALOW_WINDOW_MOUDLE_NAME", "GUIDE_TALOW_WINDOW_PACKAGE_NAME", "OPERATE_TALOS_GUIDE_AUTO_DISMISS", "OPERATE_TALOS_GUIDE_CHECK_BUNDLE_EXIST", "OPERATE_TALOS_GUIDE_CLICK_ADD", "OPERATE_TALOS_GUIDE_CLICK_DISMISS", "OPERATE_TALOS_GUIDE_SHOW_FAIL", "OPERATE_TALOS_GUIDE_SHOW_SUCCESS", "PARAM_TALOS_WIDGET_GUIDE", "SP_KEY_TALOS_WIDGET_GUIDE_MATERIALS", "TAG", "getTalosWidgetGuideMaterial", "Lorg/json/JSONObject;", "scene", "widgetType", "", "tryShowTalosWidgetGuide", "", "confirmAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "guideStyle", "", "showFailAction", "Lkotlin/Function0;", "ubcStatistic", "lib-widget_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosGuideManager.kt */
public final class TalosGuideManagerKt {
    private static final String DATA_CHANNEL_ACTION_OPERATE = "com.baidu.datachannel.addWidgetTalosGuideOperate";
    private static final String DATA_CHANNEL_ACTION_WIDGET_GUIDE_BUNDLE_INFO = "com.baidu.datachannel.widgetGuideBundleInfo";
    private static final String GUIDE_TALOW_WINDOW_MOUDLE_NAME = "panelCollection";
    private static final String GUIDE_TALOW_WINDOW_PACKAGE_NAME = "box.rnplugin.panelCollection";
    private static final String OPERATE_TALOS_GUIDE_AUTO_DISMISS = "3";
    private static final String OPERATE_TALOS_GUIDE_CHECK_BUNDLE_EXIST = "6";
    private static final String OPERATE_TALOS_GUIDE_CLICK_ADD = "1";
    private static final String OPERATE_TALOS_GUIDE_CLICK_DISMISS = "2";
    private static final String OPERATE_TALOS_GUIDE_SHOW_FAIL = "5";
    private static final String OPERATE_TALOS_GUIDE_SHOW_SUCCESS = "4";
    private static String PARAM_TALOS_WIDGET_GUIDE = "{\"naParams\":{\"action\":{\"verticalDrag\":0,\"draggable\":0},\"position\":{\"x\":0,\"y\":50,\"corner\":\"bm\"}},\"bizParams\":{\"popupParams\":%1s,\"popupName\":\"BridgePopUp\"},\"bundle\":{\"mainBizName\":\"box.rnplugin.panelCollection\",\"bundleName\":\"panelCollection\",\"version\":\"1.0.0.0\",\"initialProps\":{\"bizID\":\"BridgePopUp\"}}}";
    public static final String SP_KEY_TALOS_WIDGET_GUIDE_MATERIALS = "sp_key_talos_widget_guide_materials";
    private static final String TAG = "TalosGuideMgr";

    public static /* synthetic */ boolean tryShowTalosWidgetGuide$default(String str, int i2, Function1 function1, Function0 function0, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        return tryShowTalosWidgetGuide(str, i2, function1, function0);
    }

    public static final boolean tryShowTalosWidgetGuide(String scene, int widgetType, Function1<? super String, Unit> confirmAction, Function0<Unit> showFailAction) {
        String str = scene;
        Intrinsics.checkNotNullParameter(confirmAction, "confirmAction");
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "invalid")) {
            WidgetDebugKt.printLog(TAG, (Function0<String>) TalosGuideManagerKt$tryShowTalosWidgetGuide$1.INSTANCE);
            return false;
        }
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        if (activity == null || ActivityUtils.isDestroyed(activity)) {
            WidgetDebugKt.printLog(TAG, (Function0<String>) TalosGuideManagerKt$tryShowTalosWidgetGuide$2.INSTANCE);
            return false;
        }
        JSONObject rawMaterial = getTalosWidgetGuideMaterial(scene, widgetType);
        String guideStyle = rawMaterial != null ? rawMaterial.optString("style") : null;
        String material = rawMaterial != null ? rawMaterial.toString() : null;
        CharSequence charSequence2 = material;
        if (charSequence2 == null || charSequence2.length() == 0) {
            WidgetDebugKt.printLog(TAG, (Function0<String>) TalosGuideManagerKt$tryShowTalosWidgetGuide$3.INSTANCE);
            return false;
        }
        IPackageManager packageManager = TalosManager.getPackageManager();
        Boolean isTalosBundleExist = packageManager != null ? Boolean.valueOf(packageManager.isMoudleExist(GUIDE_TALOW_WINDOW_PACKAGE_NAME, GUIDE_TALOW_WINDOW_MOUDLE_NAME)) : null;
        if (isTalosBundleExist == null) {
        } else if (!isTalosBundleExist.booleanValue()) {
            IPackageManager iPackageManager = packageManager;
        } else {
            IPackageManager iPackageManager2 = packageManager;
            DataChannel.Registry.registerNAReceiver(TAG, TAG, DATA_CHANNEL_ACTION_OPERATE, new TalosGuideManagerKt$tryShowTalosWidgetGuide$5(scene, widgetType, confirmAction, guideStyle, showFailAction, packageManager));
            ActivityLifecycleUtilsKt.runOnDestroy(activity, TalosGuideManagerKt$tryShowTalosWidgetGuide$6.INSTANCE);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String params = String.format(PARAM_TALOS_WIDGET_GUIDE, Arrays.copyOf(new Object[]{material}, 1));
            Intrinsics.checkNotNullExpressionValue(params, "format(format, *args)");
            WidgetDebugKt.printLog(TAG, (Function0<String>) new TalosGuideManagerKt$tryShowTalosWidgetGuide$7(params));
            ((TalosPopupInterface) ServiceManager.getService(TalosPopupInterfaceKt.getSERVICE_REFERENCE())).showTalosPopup(TalosPopupInterfaceKt.ACTION_SHOW_BALL, params, activity, (UnitedSchemeTalosPopUpFrameAdapter) null);
            return true;
        }
        WidgetDebugKt.printLog(TAG, (Function0<String>) TalosGuideManagerKt$tryShowTalosWidgetGuide$4.INSTANCE);
        ubcStatistic(scene, widgetType);
        return false;
    }

    private static final void ubcStatistic(String scene, int widgetType) {
        if (scene != null && !Intrinsics.areEqual((Object) scene, (Object) "invalid")) {
            String widgetStatisticSource = WidgetDataStatisticUtils.getWidgetStatisticSource(widgetType);
            Intrinsics.checkNotNullExpressionValue(widgetStatisticSource, "getWidgetStatisticSource(widgetType)");
            String widgetStatisticSource2 = WidgetDataStatisticUtils.getWidgetStatisticSource(widgetType);
            Intrinsics.checkNotNullExpressionValue(widgetStatisticSource2, "getWidgetStatisticSource(widgetType)");
            GuideStatisticKt.onWidgetCustomWidgetUBC(widgetStatisticSource, "add", GuideStatisticKt.GUIDE_SHOW_TYPE_1PX_SHOW_FAIL, widgetStatisticSource2, scene);
        }
    }

    public static final JSONObject getTalosWidgetGuideMaterial(String scene, int widgetType) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        WidgetDebugKt.printLog(TAG, (Function0<String>) new TalosGuideManagerKt$getTalosWidgetGuideMaterial$1(scene, widgetType));
        String materials = WidgetSharePreferenceUtils.Companion.getInstance().getString(SP_KEY_TALOS_WIDGET_GUIDE_MATERIALS, "");
        CharSequence charSequence = materials;
        if (charSequence == null || charSequence.length() == 0) {
            WidgetDebugKt.printLog(TAG, (Function0<String>) TalosGuideManagerKt$getTalosWidgetGuideMaterial$2.INSTANCE);
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            JSONArray jsonMaterials = new JSONArray(materials);
            int i2 = 0;
            int length = jsonMaterials.length();
            while (i2 < length) {
                JSONObject jsonMaterial = jsonMaterials.optJSONObject(i2);
                if (!Intrinsics.areEqual((Object) jsonMaterial.optString("scene"), (Object) scene) || jsonMaterial.optInt("widgetID") != widgetType) {
                    i2++;
                } else {
                    WidgetDebugKt.printLog(TAG, (Function0<String>) new TalosGuideManagerKt$getTalosWidgetGuideMaterial$3$1(jsonMaterial));
                    return jsonMaterial;
                }
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        WidgetDebugKt.printLog(TAG, (Function0<String>) TalosGuideManagerKt$getTalosWidgetGuideMaterial$4.INSTANCE);
        return null;
    }
}
