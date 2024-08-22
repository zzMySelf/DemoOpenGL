package com.baidu.searchbox.widget.ability.debug;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.common.menu.bottomlist.BottomCommonMenuItem;
import com.baidu.android.common.menu.bottomlist.BottomCustomMenuItem;
import com.baidu.android.common.menu.bottomlist.BottomListMenu;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.widget.ability.IWidgetAbilityService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/widget/ability/debug/WidgetAbilityDebugProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "()V", "launchSilentAddFlowListener", "Landroid/view/View$OnClickListener;", "silentAbilitySwitchListener", "silentAddStrategyEnvironmentListener", "getChildItemList", "", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "getDebugConfigList", "getGroupName", "", "lib-widget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetAbilityDebugProvider.kt */
public final class WidgetAbilityDebugProvider extends DebugDataGroupProvider {
    private final View.OnClickListener launchSilentAddFlowListener = new WidgetAbilityDebugProvider$$ExternalSyntheticLambda0();
    private final View.OnClickListener silentAbilitySwitchListener = new WidgetAbilityDebugProvider$$ExternalSyntheticLambda2();
    private final View.OnClickListener silentAddStrategyEnvironmentListener = new WidgetAbilityDebugProvider$$ExternalSyntheticLambda1();

    public List<DebugItemInfo> getChildItemList() {
        return getDebugConfigList();
    }

    public String getGroupName() {
        return "WidgetAbility";
    }

    private final List<DebugItemInfo> getDebugConfigList() {
        List list = new ArrayList();
        list.add(new TextItemInfo("LaunchSilentAddFlow", "一键添加流程", this.launchSilentAddFlowListener));
        list.add(new TextItemInfo("SilentStrategyEnvironment", "一键添加策略接口环境选择", this.silentAddStrategyEnvironmentListener));
        list.add(new TextItemInfo("SilentAbilitySwitch", "静默添加能力开关", this.silentAbilitySwitchListener));
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: launchSilentAddFlowListener$lambda-0  reason: not valid java name */
    public static final void m7600launchSilentAddFlowListener$lambda0(View it) {
        IWidgetAbilityService orNull = IWidgetAbilityService.Companion.getOrNull();
        if (orNull != null) {
            orNull.startFullSilentPinFlow();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: silentAddStrategyEnvironmentListener$lambda-3  reason: not valid java name */
    public static final void m7602silentAddStrategyEnvironmentListener$lambda3(View it) {
        Context context = it.getContext();
        if (context != null) {
            Context context2 = context;
            ArrayList commonMenuItems = new ArrayList();
            ArrayList $this$silentAddStrategyEnvironmentListener_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = commonMenuItems;
            $this$silentAddStrategyEnvironmentListener_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.add(new BottomCommonMenuItem(1, "线上环境", false, 4, (DefaultConstructorMarker) null));
            $this$silentAddStrategyEnvironmentListener_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.add(new BottomCommonMenuItem(2, "测试环境", false, 4, (DefaultConstructorMarker) null));
            $this$silentAddStrategyEnvironmentListener_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.add(new BottomCommonMenuItem(3, "开发环境", false, 4, (DefaultConstructorMarker) null));
            Activity realTopActivity = BdBoxActivityManager.getRealTopActivity();
            if (!ActivityUtils.isDestroyed(realTopActivity)) {
                View findViewById = realTopActivity.findViewById(16908290);
                Intrinsics.checkNotNullExpressionValue(findViewById, "realTopActivity.findViewById(android.R.id.content)");
                new BottomListMenu(findViewById, "一键添加策略接口环境选择", commonMenuItems, (List<? extends BottomCustomMenuItem>) null, new WidgetAbilityDebugProvider$silentAddStrategyEnvironmentListener$1$1$2(1, 2, 3)).showView();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: silentAbilitySwitchListener$lambda-6  reason: not valid java name */
    public static final void m7601silentAbilitySwitchListener$lambda6(View it) {
        Context context = it.getContext();
        if (context != null) {
            Context context2 = context;
            ArrayList commonMenuItems = new ArrayList();
            ArrayList $this$silentAbilitySwitchListener_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4 = commonMenuItems;
            $this$silentAbilitySwitchListener_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4.add(new BottomCommonMenuItem(1, "静默添加能力开关打开", false, 4, (DefaultConstructorMarker) null));
            $this$silentAbilitySwitchListener_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4.add(new BottomCommonMenuItem(2, "冷启静默添加流程开关打开", false, 4, (DefaultConstructorMarker) null));
            $this$silentAbilitySwitchListener_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4.add(new BottomCommonMenuItem(3, "用户静默添加流程开关打开", false, 4, (DefaultConstructorMarker) null));
            $this$silentAbilitySwitchListener_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4.add(new BottomCommonMenuItem(4, "静默添加地域控制忽略", false, 4, (DefaultConstructorMarker) null));
            Activity realTopActivity = BdBoxActivityManager.getRealTopActivity();
            if (!ActivityUtils.isDestroyed(realTopActivity)) {
                View findViewById = realTopActivity.findViewById(16908290);
                Intrinsics.checkNotNullExpressionValue(findViewById, "realTopActivity.findViewById(android.R.id.content)");
                new BottomListMenu(findViewById, "静默添加能力开关", commonMenuItems, (List<? extends BottomCustomMenuItem>) null, new WidgetAbilityDebugProvider$silentAbilitySwitchListener$1$1$2(1, 2, 3, 4)).showView();
            }
        }
    }
}
