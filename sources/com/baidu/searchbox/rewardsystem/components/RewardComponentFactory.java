package com.baidu.searchbox.rewardsystem.components;

import android.content.Context;
import com.baidu.searchbox.rewardsystem.components.status.OPTaskConfig;
import com.baidu.searchbox.rewardsystem.newtimer.utils.NewTimerViewEdgeConfig;
import com.baidu.searchbox.rewardsystem.newtimer.view.NormalTimerView;
import com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager;
import com.baidu.searchbox.taskapi.core.config.TaskConfig;
import com.baidu.searchbox.taskapi.core.intput.BusinessType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007JZ\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/rewardsystem/components/RewardComponentFactory;", "", "()V", "createNormalComponent", "Lcom/baidu/searchbox/rewardsystem/components/IRewardOPStatusComponent;", "pageType", "Lcom/baidu/searchbox/taskapi/core/intput/BusinessType;", "context", "Landroid/content/Context;", "config", "Lcom/baidu/searchbox/rewardsystem/newtimer/utils/NewTimerViewEdgeConfig;", "autoNext", "", "loginToastText", "", "bubble", "Lcom/baidu/searchbox/taskapi/core/config/TaskConfig$IBubble;", "taskConfig", "Lcom/baidu/searchbox/taskapi/core/config/TaskConfig;", "createTimeOutComponent", "autoDismiss", "timeOut", "", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardComponentFactory.kt */
public final class RewardComponentFactory {
    public static final RewardComponentFactory INSTANCE = new RewardComponentFactory();

    @JvmStatic
    public static final IRewardOPStatusComponent createNormalComponent(BusinessType businessType, Context context, NewTimerViewEdgeConfig newTimerViewEdgeConfig, String str, TaskConfig.IBubble iBubble, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(businessType, "pageType");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newTimerViewEdgeConfig, "config");
        Intrinsics.checkNotNullParameter(str, "loginToastText");
        return createNormalComponent$default(businessType, context, newTimerViewEdgeConfig, false, str, iBubble, taskConfig, 8, (Object) null);
    }

    @JvmStatic
    public static final IRewardOPStatusComponent createTimeOutComponent(BusinessType businessType, Context context, NewTimerViewEdgeConfig newTimerViewEdgeConfig, String str, TaskConfig.IBubble iBubble, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(businessType, "pageType");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newTimerViewEdgeConfig, "config");
        Intrinsics.checkNotNullParameter(str, "loginToastText");
        return createTimeOutComponent$default(businessType, context, false, false, newTimerViewEdgeConfig, 0, str, iBubble, taskConfig, 44, (Object) null);
    }

    @JvmStatic
    public static final IRewardOPStatusComponent createTimeOutComponent(BusinessType businessType, Context context, boolean z, NewTimerViewEdgeConfig newTimerViewEdgeConfig, String str, TaskConfig.IBubble iBubble, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(businessType, "pageType");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newTimerViewEdgeConfig, "config");
        Intrinsics.checkNotNullParameter(str, "loginToastText");
        return createTimeOutComponent$default(businessType, context, z, false, newTimerViewEdgeConfig, 0, str, iBubble, taskConfig, 40, (Object) null);
    }

    @JvmStatic
    public static final IRewardOPStatusComponent createTimeOutComponent(BusinessType businessType, Context context, boolean z, boolean z2, NewTimerViewEdgeConfig newTimerViewEdgeConfig, String str, TaskConfig.IBubble iBubble, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(businessType, "pageType");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newTimerViewEdgeConfig, "config");
        Intrinsics.checkNotNullParameter(str, "loginToastText");
        return createTimeOutComponent$default(businessType, context, z, z2, newTimerViewEdgeConfig, 0, str, iBubble, taskConfig, 32, (Object) null);
    }

    private RewardComponentFactory() {
    }

    @JvmStatic
    public static final IRewardOPStatusComponent createNormalComponent(BusinessType pageType, Context context, NewTimerViewEdgeConfig config, boolean autoNext, String loginToastText, TaskConfig.IBubble bubble, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(loginToastText, "loginToastText");
        OPTaskConfig createTimerTaskConfigWithPageType = OPTaskConfig.Companion.createTimerTaskConfigWithPageType(pageType, loginToastText);
        NormalTimerView normalTimerView = new NormalTimerView(context, pageType);
        NormalTimerView $this$createNormalComponent_u24lambda_u2d0 = normalTimerView;
        $this$createNormalComponent_u24lambda_u2d0.createTimerViewConfig(config);
        $this$createNormalComponent_u24lambda_u2d0.createTaskConfig(taskConfig);
        return new RewardOPStatusComponent(createTimerTaskConfigWithPageType, normalTimerView, RewardTaskStatusManager.Companion.getInstance().getCurStatus(), autoNext, bubble, taskConfig);
    }

    public static /* synthetic */ IRewardOPStatusComponent createNormalComponent$default(BusinessType businessType, Context context, NewTimerViewEdgeConfig newTimerViewEdgeConfig, boolean z, String str, TaskConfig.IBubble iBubble, TaskConfig taskConfig, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        return createNormalComponent(businessType, context, newTimerViewEdgeConfig, z, str, iBubble, taskConfig);
    }

    @JvmStatic
    public static final IRewardOPStatusComponent createTimeOutComponent(BusinessType pageType, Context context, boolean autoDismiss, boolean autoNext, NewTimerViewEdgeConfig config, long timeOut, String loginToastText, TaskConfig.IBubble bubble, TaskConfig taskConfig) {
        BusinessType businessType = pageType;
        Context context2 = context;
        NewTimerViewEdgeConfig newTimerViewEdgeConfig = config;
        String str = loginToastText;
        Intrinsics.checkNotNullParameter(businessType, "pageType");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(newTimerViewEdgeConfig, "config");
        Intrinsics.checkNotNullParameter(str, "loginToastText");
        OPTaskConfig createTimerTaskConfigWithPageType = OPTaskConfig.Companion.createTimerTaskConfigWithPageType(businessType, str);
        NormalTimerView normalTimerView = new NormalTimerView(context2, businessType);
        NormalTimerView $this$createTimeOutComponent_u24lambda_u2d1 = normalTimerView;
        $this$createTimeOutComponent_u24lambda_u2d1.createTimerViewConfig(newTimerViewEdgeConfig);
        $this$createTimeOutComponent_u24lambda_u2d1.createTaskConfig(taskConfig);
        return new NormalRewardOPStatusComponent(createTimerTaskConfigWithPageType, normalTimerView, RewardTaskStatusManager.Companion.getInstance().getCurStatus(), autoNext, timeOut, autoDismiss, bubble, taskConfig);
    }

    public static /* synthetic */ IRewardOPStatusComponent createTimeOutComponent$default(BusinessType businessType, Context context, boolean z, boolean z2, NewTimerViewEdgeConfig newTimerViewEdgeConfig, long j2, String str, TaskConfig.IBubble iBubble, TaskConfig taskConfig, int i2, Object obj) {
        return createTimeOutComponent(businessType, context, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? true : z2, newTimerViewEdgeConfig, (i2 & 32) != 0 ? -1 : j2, str, iBubble, taskConfig);
    }
}
