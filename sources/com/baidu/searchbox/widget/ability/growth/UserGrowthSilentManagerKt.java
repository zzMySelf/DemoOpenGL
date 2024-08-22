package com.baidu.searchbox.widget.ability.growth;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.growth.attribute.GrowthAttributeModel;
import com.baidu.searchbox.growth.attribute.IGrowthAttributeApi;
import com.baidu.searchbox.widget.ability.pin.utils.DebugUtilsKt;
import com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH\u0000\u001a\b\u0010\u001b\u001a\u00020\fH\u0002\u001a\u001e\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8@@@X\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"$\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\"$\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8@@@X\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011¨\u0006\u001f"}, d2 = {"COLLECT_COUNT_MAX_LIMIT", "", "EXP_KEY_WIDGET_DSP_ADD", "", "EXP_VALUE_1", "PARAM_PACKAGE_ID", "PARAM_USER_TYPE", "SP_KEY_WIDGET_SILENT_GCP_ISSUED", "SP_KEY_WIDGET_SILENT_GROWTH_ATTRIBUTE_COLLECT_COUNT", "SP_KEY_WIDGET_SILENT_NEED_COLLECT_USER_ATTRIBUTE", "TAG", "value", "", "canUseGrowthAttribute", "getCanUseGrowthAttribute", "()Z", "setCanUseGrowthAttribute", "(Z)V", "collectCount", "getCollectCount", "()I", "setCollectCount", "(I)V", "isWidgetSilentGcpIssued", "setWidgetSilentGcpIssued", "collectGrowthAttribute", "", "hitDspSilentAddExt", "tryMarkGrowthAttributeUsed", "", "request", "lib-widget-ability-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserGrowthSilentManager.kt */
public final class UserGrowthSilentManagerKt {
    private static final int COLLECT_COUNT_MAX_LIMIT = 20;
    private static final String EXP_KEY_WIDGET_DSP_ADD = "widget_dsp_add";
    private static final int EXP_VALUE_1 = 1;
    private static final String PARAM_PACKAGE_ID = "packageId";
    private static final String PARAM_USER_TYPE = "userType";
    private static final String SP_KEY_WIDGET_SILENT_GCP_ISSUED = "widget_silent_gcp_issued";
    private static final String SP_KEY_WIDGET_SILENT_GROWTH_ATTRIBUTE_COLLECT_COUNT = "widget_silent_growth_attribute_collect_count";
    private static final String SP_KEY_WIDGET_SILENT_NEED_COLLECT_USER_ATTRIBUTE = "widget_silent_need_collect_user_attribute";
    private static final String TAG = "UserGrowthSilentMgr";

    public static final boolean getCanUseGrowthAttribute() {
        boolean needCollect = WidgetAbilitySPUtils.Companion.getInstance().getBoolean(SP_KEY_WIDGET_SILENT_NEED_COLLECT_USER_ATTRIBUTE, true);
        DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$canUseGrowthAttribute$1(needCollect));
        return needCollect;
    }

    public static final void setCanUseGrowthAttribute(boolean value) {
        DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$canUseGrowthAttribute$2(value));
        WidgetAbilitySPUtils.Companion.getInstance().putBoolean(SP_KEY_WIDGET_SILENT_NEED_COLLECT_USER_ATTRIBUTE, value);
    }

    public static final boolean isWidgetSilentGcpIssued() {
        boolean issued = WidgetAbilitySPUtils.Companion.getInstance().getBoolean(SP_KEY_WIDGET_SILENT_GCP_ISSUED, false);
        DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$isWidgetSilentGcpIssued$1(issued));
        return issued;
    }

    public static final void setWidgetSilentGcpIssued(boolean value) {
        DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$isWidgetSilentGcpIssued$2(value));
        WidgetAbilitySPUtils.Companion.getInstance().putBoolean(SP_KEY_WIDGET_SILENT_GCP_ISSUED, value);
    }

    private static final int getCollectCount() {
        return WidgetAbilitySPUtils.Companion.getInstance().getInt(SP_KEY_WIDGET_SILENT_GROWTH_ATTRIBUTE_COLLECT_COUNT, 0);
    }

    private static final void setCollectCount(int value) {
        WidgetAbilitySPUtils.Companion.getInstance().putInt(SP_KEY_WIDGET_SILENT_GROWTH_ATTRIBUTE_COLLECT_COUNT, value);
    }

    private static final boolean hitDspSilentAddExt() {
        boolean z = false;
        if (AbTestManager.getInstance().getSwitch(EXP_KEY_WIDGET_DSP_ADD, 0) == 1) {
            z = true;
        }
        boolean hit = z;
        DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$hitDspSilentAddExt$1(hit));
        return hit;
    }

    public static final Map<String, String> collectGrowthAttribute() {
        GrowthAttributeModel growthAttributeMode = null;
        if (!hitDspSilentAddExt() || !getCanUseGrowthAttribute() || getCollectCount() >= 20) {
            DebugUtilsKt.printLog(TAG, UserGrowthSilentManagerKt$collectGrowthAttribute$3.INSTANCE);
            Map map = null;
            return null;
        }
        Map result = new LinkedHashMap();
        IGrowthAttributeApi growthAttributeApi = (IGrowthAttributeApi) ServiceManager.getService(IGrowthAttributeApi.Companion.getSERVICE_REFERENCE());
        if (growthAttributeApi != null) {
            growthAttributeMode = growthAttributeApi.getGrowthAttribute();
        }
        if (growthAttributeMode != null) {
            GrowthAttributeModel it = growthAttributeMode;
            String userType = it.getUserType();
            if (userType != null) {
                DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$collectGrowthAttribute$1$1$1(userType));
                String put = result.put("userType", userType);
            }
            String packageId = it.getPackageId();
            if (packageId != null) {
                DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$collectGrowthAttribute$1$2$1(packageId));
                String put2 = result.put(PARAM_PACKAGE_ID, packageId);
            }
            setCollectCount(getCollectCount() + 1);
        }
        DebugUtilsKt.printLog(TAG, new UserGrowthSilentManagerKt$collectGrowthAttribute$2(growthAttributeMode));
        return result;
    }

    public static final void tryMarkGrowthAttributeUsed(Map<String, String> request) {
        DebugUtilsKt.printLog(TAG, UserGrowthSilentManagerKt$tryMarkGrowthAttributeUsed$1.INSTANCE);
        String str = null;
        CharSequence charSequence = request != null ? request.get("userType") : null;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            if (request != null) {
                str = request.get(PARAM_PACKAGE_ID);
            }
            CharSequence charSequence2 = str;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        DebugUtilsKt.printLog(TAG, UserGrowthSilentManagerKt$tryMarkGrowthAttributeUsed$2.INSTANCE);
        setCanUseGrowthAttribute(false);
    }
}
