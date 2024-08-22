package com.baidu.growthsystem.wealth.video.component;

import android.util.Log;
import com.baidu.growthsystem.framework.utils.GrowthLogUtilsKt;
import com.baidu.growthsystem.wealth.common.util.WealthVideoYalogUtilKt;
import com.baidu.growthsystem.wealth.video.data.WealthVideoBadge;
import com.baidu.growthsystem.wealth.video.data.WealthVideoTaskData;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/growthsystem/wealth/video/component/WealthCompTimerView$setWealthVideoCompClickListener$1", "Lcom/baidu/growthsystem/wealth/video/component/WealthWidgetClickListener;", "onClick", "", "type", "Lcom/baidu/growthsystem/wealth/video/component/ClickType;", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthCompTimerView.kt */
public final class WealthCompTimerView$setWealthVideoCompClickListener$1 implements WealthWidgetClickListener {
    final /* synthetic */ WealthWidgetClickListener $listener;
    final /* synthetic */ WealthCompTimerView this$0;

    WealthCompTimerView$setWealthVideoCompClickListener$1(WealthCompTimerView $receiver, WealthWidgetClickListener $listener2) {
        this.this$0 = $receiver;
        this.$listener = $listener2;
    }

    public void onClick(ClickType type) {
        WealthVideoTaskData data;
        WealthVideoBadge badge;
        Intrinsics.checkNotNullParameter(type, "type");
        this.this$0.updateVideoStatistics("click", "1");
        if (!this.this$0.isClickAble) {
            if (AppConfig.isDebug()) {
                Log.d(GrowthLogUtilsKt.TAG, "WealthCompTimerView can not be click!!");
            }
            WealthVideoYalogUtilKt.doWealthVideoYalog("WealthCompTimerView can not be click!!");
        } else if (type == ClickType.TYPE_REWARD && this.this$0.mWealthWidgetSideManager.isShowingPreventCheatFloatTip()) {
        } else {
            if (type != ClickType.TYPE_REWARD || !this.this$0.mWealthWidgetSideManager.isShowingLiveTplNoTimingTip()) {
                long tempTime = System.currentTimeMillis();
                if (tempTime - this.this$0.curClickTime > 2000) {
                    this.this$0.curClickTime = tempTime;
                    WealthCompViewData access$getCurStatusData$p = this.this$0.curStatusData;
                    boolean z = true;
                    if (access$getCurStatusData$p == null || (data = access$getCurStatusData$p.getData()) == null || (badge = data.getBadge()) == null || !badge.isHitIconOptExp()) {
                        z = false;
                    }
                    if (!z) {
                        if (this.this$0.widgetView.isShowingRedDot()) {
                            this.this$0.wealthCompTimerViewUbc.doClickTimerWidgetRedDotUbc();
                        }
                        this.this$0.widgetView.hideRedDot();
                    } else if (this.this$0.widgetView.isShowingBadgeIcon()) {
                        this.this$0.wealthCompTimerViewUbc.doClickTimerWidgetBadgeIconUbc$wealth_task_business_release();
                    }
                    this.$listener.onClick(type);
                    if (type == ClickType.TYPE_REWARD) {
                        this.this$0.wealthCompTimerViewUbc.doClickFloatWidgetActionUbc();
                    } else {
                        this.this$0.wealthCompTimerViewUbc.doClickTimerWidgetUbc();
                    }
                }
            }
        }
    }
}
