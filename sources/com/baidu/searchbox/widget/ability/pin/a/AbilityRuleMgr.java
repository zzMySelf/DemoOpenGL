package com.baidu.searchbox.widget.ability.pin.a;

import android.os.Build;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.widget.ability.debug.WidgetAbilityDebugProviderKt;
import com.baidu.searchbox.widget.ability.pin.a.model.DeviceAbilityRule;
import com.baidu.searchbox.widget.ability.pin.a.model.LauncherInfo;
import com.baidu.searchbox.widget.ability.pin.a.model.WidgetAbilityDeviceRuleListener;
import com.baidu.searchbox.widget.ability.pin.utils.DebugUtilsKt;
import com.baidu.searchbox.widget.ability.pin.utils.LauncherHelpersKt;
import com.baidu.searchbox.widget.ability.pin.utils.PermissionHelpersKt;
import com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0011\u001a\u0004\u0018\u00010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/widget/ability/pin/a/AbilityRuleMgr;", "", "()V", "checkDeviceAbilityRule", "", "launcher", "Lcom/baidu/searchbox/widget/ability/pin/a/model/LauncherInfo;", "rule", "Lcom/baidu/searchbox/widget/ability/pin/a/model/DeviceAbilityRule;", "getAbilitySwitch", "getCloudAbilityVersion", "", "getLaunchSilentFlowSwitch", "getLocationValid", "getRules", "", "getUserSilentFlowSwitch", "getValidRule", "lib-widget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbilityRuleMgr.kt */
public final class AbilityRuleMgr {
    public static final AbilityRuleMgr INSTANCE = new AbilityRuleMgr();

    private AbilityRuleMgr() {
    }

    public final boolean getAbilitySwitch() {
        Object obj;
        if (AbilityRuleMgrKt.DEBUG && WidgetAbilitySPUtils.Companion.getInstance().getBoolean(WidgetAbilityDebugProviderKt.KEY_SP_DEBUG_SILENT_ABILITY_ON, false)) {
            return true;
        }
        String it = WidgetAbilitySPUtils.Companion.getInstance().getString(WidgetAbilityDeviceRuleListener.KEY_SP_WIDGET_ABILITY_RULES_DATA, "");
        if (it == null) {
            return false;
        }
        AbilityRuleMgr abilityRuleMgr = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(new JSONObject(it).optString("abilityOn"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        String it2 = (String) obj;
        if (it2 != null) {
            return Intrinsics.areEqual((Object) it2, (Object) "1");
        }
        return false;
    }

    public final boolean getLaunchSilentFlowSwitch() {
        Object obj;
        if (AbilityRuleMgrKt.DEBUG && WidgetAbilitySPUtils.Companion.getInstance().getBoolean(WidgetAbilityDebugProviderKt.KEY_SP_DEBUG_SILENT_LAUNCH_FLOW_ON, false)) {
            return true;
        }
        String it = WidgetAbilitySPUtils.Companion.getInstance().getString(WidgetAbilityDeviceRuleListener.KEY_SP_WIDGET_ABILITY_RULES_DATA, "");
        if (it == null) {
            return false;
        }
        AbilityRuleMgr abilityRuleMgr = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(new JSONObject(it).optString("launchSilentFlowOn"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        String it2 = (String) obj;
        if (it2 != null) {
            return Intrinsics.areEqual((Object) it2, (Object) "1");
        }
        return false;
    }

    public final boolean getUserSilentFlowSwitch() {
        Object obj;
        if (AbilityRuleMgrKt.DEBUG && WidgetAbilitySPUtils.Companion.getInstance().getBoolean(WidgetAbilityDebugProviderKt.KEY_SP_DEBUG_SILENT_USER_FLOW_ON, false)) {
            return true;
        }
        String it = WidgetAbilitySPUtils.Companion.getInstance().getString(WidgetAbilityDeviceRuleListener.KEY_SP_WIDGET_ABILITY_RULES_DATA, "");
        if (it == null) {
            return false;
        }
        AbilityRuleMgr abilityRuleMgr = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(new JSONObject(it).optString("userSilentFlowOn"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        String it2 = (String) obj;
        if (it2 != null) {
            return Intrinsics.areEqual((Object) it2, (Object) "1");
        }
        return false;
    }

    public final String getCloudAbilityVersion() {
        String it = WidgetAbilitySPUtils.Companion.getInstance().getString(WidgetAbilityDeviceRuleListener.KEY_SP_WIDGET_ABILITY_RULES_DATA, "");
        if (it == null) {
            return null;
        }
        try {
            return new JSONObject(it).optString("abilityVersion");
        } catch (JSONException e2) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b6 A[SYNTHETIC, Splitter:B:37:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getLocationValid() {
        /*
            r21 = this;
            java.lang.String r0 = "location.city"
            boolean r1 = com.baidu.searchbox.widget.ability.pin.a.AbilityRuleMgrKt.DEBUG
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001c
            com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils$Companion r1 = com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils.Companion
            com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils r1 = r1.getInstance()
            java.lang.String r4 = "key_sp_debug_silent_location_control_on"
            boolean r1 = r1.getBoolean(r4, r3)
            if (r1 == 0) goto L_0x001c
            return r2
        L_0x001c:
            com.baidu.pyramid.runtime.service.ServiceReference r1 = com.baidu.searchbox.location.BoxLocationManager.SERVICE_REFERENCE
            java.lang.Object r1 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r1)
            com.baidu.searchbox.location.BoxLocationManager r1 = (com.baidu.searchbox.location.BoxLocationManager) r1
            if (r1 == 0) goto L_0x0030
            com.baidu.searchbox.location.RequestConfig$LocationConfig r5 = new com.baidu.searchbox.location.RequestConfig$LocationConfig
            r5.<init>()
            com.baidu.searchbox.location.LocationInfo r5 = r1.getLocationInfoExpiration(r5)
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            if (r5 == 0) goto L_0x011f
            java.lang.String r6 = r5.city
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0042
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r6 = r3
            goto L_0x0043
        L_0x0042:
            r6 = r2
        L_0x0043:
            if (r6 == 0) goto L_0x0049
            r18 = r1
            goto L_0x0121
        L_0x0049:
            com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils$Companion r6 = com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils.Companion
            com.baidu.searchbox.widget.ability.pin.utils.WidgetAbilitySPUtils r6 = r6.getInstance()
            java.lang.String r7 = "key_sp_widget_ability_rules_data"
            java.lang.String r8 = ""
            java.lang.String r6 = r6.getString(r7, r8)
            if (r6 == 0) goto L_0x011b
            r7 = 0
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0112 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r9 = "disableCity"
            org.json.JSONArray r8 = r8.optJSONArray(r9)     // Catch:{ Exception -> 0x0112 }
            if (r8 == 0) goto L_0x010e
            java.lang.String r9 = "optJSONArray(\"disableCity\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ Exception -> 0x0112 }
            r9 = 0
            int r10 = r8.length()     // Catch:{ Exception -> 0x0112 }
            kotlin.ranges.IntRange r10 = kotlin.ranges.RangesKt.until((int) r3, (int) r10)     // Catch:{ Exception -> 0x0112 }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ Exception -> 0x0112 }
            r11 = 0
            java.util.Iterator r12 = r10.iterator()     // Catch:{ Exception -> 0x0112 }
        L_0x0082:
            boolean r13 = r12.hasNext()     // Catch:{ Exception -> 0x0112 }
            if (r13 == 0) goto L_0x010a
            r13 = r12
            kotlin.collections.IntIterator r13 = (kotlin.collections.IntIterator) r13     // Catch:{ Exception -> 0x0112 }
            int r13 = r13.nextInt()     // Catch:{ Exception -> 0x0112 }
            r14 = r13
            r15 = 0
            java.lang.String r16 = r8.optString(r14)     // Catch:{ Exception -> 0x0112 }
            r17 = r16
            r2 = r17
            r17 = r2
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17     // Catch:{ Exception -> 0x0112 }
            if (r17 == 0) goto L_0x00b2
            int r17 = r17.length()     // Catch:{ Exception -> 0x00a9 }
            if (r17 != 0) goto L_0x00a6
            goto L_0x00b2
        L_0x00a6:
            r17 = r3
            goto L_0x00b4
        L_0x00a9:
            r0 = move-exception
            r18 = r1
            r19 = r6
            r20 = r7
            goto L_0x0119
        L_0x00b2:
            r17 = 1
        L_0x00b4:
            if (r17 != 0) goto L_0x00f9
            java.lang.String r3 = r5.city     // Catch:{ Exception -> 0x0112 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0112 }
            if (r3 != 0) goto L_0x00f1
            java.lang.String r3 = r5.city     // Catch:{ Exception -> 0x0112 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch:{ Exception -> 0x0112 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0112 }
            java.lang.String r4 = "city"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0112 }
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0112 }
            r18 = r1
            r1 = 2
            r19 = r6
            r20 = r7
            r6 = 0
            r7 = 0
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (boolean) r7, (int) r1, (java.lang.Object) r6)     // Catch:{ Exception -> 0x00ef }
            if (r3 != 0) goto L_0x00f7
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = r5.city     // Catch:{ Exception -> 0x00ef }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ Exception -> 0x00ef }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x00ef }
            r6 = 0
            r7 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (boolean) r7, (int) r1, (java.lang.Object) r6)     // Catch:{ Exception -> 0x00ef }
            if (r1 == 0) goto L_0x0100
            goto L_0x00f7
        L_0x00ef:
            r0 = move-exception
            goto L_0x0119
        L_0x00f1:
            r18 = r1
            r19 = r6
            r20 = r7
        L_0x00f7:
            r0 = 0
            return r0
        L_0x00f9:
            r18 = r1
            r19 = r6
            r20 = r7
            r6 = 0
        L_0x0100:
            r1 = r18
            r6 = r19
            r7 = r20
            r2 = 1
            r3 = 0
            goto L_0x0082
        L_0x010a:
            r18 = r1
            r1 = 1
            return r1
        L_0x010e:
            r18 = r1
            r1 = 1
            return r1
        L_0x0112:
            r0 = move-exception
            r18 = r1
            r19 = r6
            r20 = r7
        L_0x0119:
            r1 = 1
            return r1
        L_0x011b:
            r18 = r1
            r1 = r2
            return r1
        L_0x011f:
            r18 = r1
        L_0x0121:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.widget.ability.pin.a.AbilityRuleMgr.getLocationValid():boolean");
    }

    public final DeviceAbilityRule getValidRule() {
        Object element$iv;
        boolean z;
        LauncherInfo launcher = LauncherHelpersKt.getLauncherInfo();
        if (!DeviceUtils.OSInfo.hasOreo()) {
            DeviceAbilityRule deviceAbilityRule = null;
            return null;
        }
        Iterator it = getRules().iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            DeviceAbilityRule it2 = (DeviceAbilityRule) element$iv;
            String oem = it2.getOem();
            String str = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (!Intrinsics.areEqual((Object) oem, (Object) lowerCase) || !Intrinsics.areEqual((Object) it2.getPkg(), (Object) launcher.getPackageName()) || !INSTANCE.checkDeviceAbilityRule(launcher, it2)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        DeviceAbilityRule $this$getValidRule_u24lambda_u2d14 = (DeviceAbilityRule) element$iv;
        if ($this$getValidRule_u24lambda_u2d14 == null) {
            return null;
        }
        DebugUtilsKt.printLog$default((String) null, new AbilityRuleMgr$getValidRule$2$1($this$getValidRule_u24lambda_u2d14), 1, (Object) null);
        return $this$getValidRule_u24lambda_u2d14;
    }

    private final List<DeviceAbilityRule> getRules() {
        List rules = new ArrayList();
        String json = WidgetAbilitySPUtils.Companion.getInstance().getString(WidgetAbilityDeviceRuleListener.KEY_SP_WIDGET_ABILITY_RULES_DATA, "");
        CharSequence charSequence = json;
        if (charSequence == null || charSequence.length() == 0) {
            return CollectionsKt.emptyList();
        }
        try {
            JSONArray $this$getRules_u24lambda_u2d16 = new JSONObject(json).getJSONArray("rules");
            int length = $this$getRules_u24lambda_u2d16.length();
            for (int i2 = 0; i2 < length; i2++) {
                DeviceAbilityRule $this$getRules_u24lambda_u2d16_u24lambda_u2d15 = DeviceAbilityRule.CREATOR.createFromJson($this$getRules_u24lambda_u2d16.getJSONObject(i2));
                if ($this$getRules_u24lambda_u2d16_u24lambda_u2d15 != null) {
                    rules.add($this$getRules_u24lambda_u2d16_u24lambda_u2d15);
                }
            }
        } catch (JSONException e2) {
            DebugUtilsKt.printLog$default((String) null, new AbilityRuleMgr$getRules$2(e2), 1, (Object) null);
        }
        return rules;
    }

    private final boolean checkDeviceAbilityRule(LauncherInfo launcher, DeviceAbilityRule rule) {
        Iterable $this$all$iv;
        int it;
        boolean inRange = (rule.getMinVersion() == -1 || launcher.getVersionCode() >= rule.getMinVersion()) && (rule.getMaxVersion() == -1 || launcher.getVersionCode() <= rule.getMaxVersion());
        boolean matchInclude = rule.getIncludeVersionSet().contains(Long.valueOf(launcher.getVersionCode()));
        boolean matchExclude = rule.getExcludeVersionSet().contains(Long.valueOf(launcher.getVersionCode()));
        Iterable $this$all$iv2 = rule.getPermissionSet();
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator it2 = $this$all$iv2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    $this$all$iv = 1;
                    break;
                }
                if (PermissionHelpersKt.checkOpPermission(((Number) it2.next()).intValue()) == 0) {
                    it = 1;
                    continue;
                } else {
                    it = 0;
                    continue;
                }
                if (it == 0) {
                    $this$all$iv = null;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        if (!Intrinsics.areEqual((Object) rule.getPkg(), (Object) launcher.getPackageName()) || matchExclude) {
            return false;
        }
        if ((inRange || matchInclude) && $this$all$iv != null) {
            return true;
        }
        return false;
    }
}
