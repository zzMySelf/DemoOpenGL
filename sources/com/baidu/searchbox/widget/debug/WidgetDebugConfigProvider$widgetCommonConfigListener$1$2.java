package com.baidu.searchbox.widget.debug;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.android.common.menu.bottomlist.BottomListMenu;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.oem.widget.R;
import com.baidu.searchbox.widget.config.WidgetCommonConfigKt;
import com.baidu.searchbox.widget.guide.WidgetGuideConfigKt;
import com.baidu.searchbox.widget.guide.dialog.WidgetCustomGuideDialog;
import com.baidu.searchbox.widget.receiver.WidgetScreenActionReceiver;
import com.baidu.searchbox.widget.rights.WidgetRightsFreqMgr;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/widget/debug/WidgetDebugConfigProvider$widgetCommonConfigListener$1$2", "Lcom/baidu/android/common/menu/bottomlist/BottomListMenu$ItemClickListener;", "onItemClick", "", "id", "", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetDebugConfigProvider.kt */
public final class WidgetDebugConfigProvider$widgetCommonConfigListener$1$2 implements BottomListMenu.ItemClickListener {
    final /* synthetic */ Activity $realTopActivity;

    WidgetDebugConfigProvider$widgetCommonConfigListener$1$2(Activity $realTopActivity2) {
        this.$realTopActivity = $realTopActivity2;
    }

    public void onItemClick(int id) {
        String str;
        switch (id) {
            case 1:
                WidgetGuideConfigKt.resetRecordWidgetGuideTime();
                return;
            case 2:
                AppRuntime.getAppContext().registerReceiver(new WidgetScreenActionReceiver(), new IntentFilter("android.intent.action.SCREEN_ON"));
                return;
            case 3:
                boolean tempValue = !WidgetCommonConfigKt.getWidgetOptimizeUpSwitch();
                WidgetDebugKt.printLog("当前存储的开关值=" + tempValue);
                WidgetCommonConfigKt.setWidgetOptimizeUpSwitch(tempValue);
                Context appContext = AppRuntime.getAppContext();
                if (tempValue) {
                    str = "调起优化开关打开";
                } else {
                    str = "调起优化开关关闭";
                }
                UniversalToast.makeText(appContext, (CharSequence) str).show();
                return;
            case 4:
                WidgetCustomGuideDialog.Companion companion = WidgetCustomGuideDialog.Companion;
                Activity context$iv = this.$realTopActivity;
                Intrinsics.checkNotNullExpressionValue(context$iv, "realTopActivity");
                WidgetCustomGuideDialog.Builder builder = new WidgetCustomGuideDialog.Builder(context$iv);
                WidgetCustomGuideDialog.Builder $this$onItemClick_u24lambda_u2d0 = builder;
                $this$onItemClick_u24lambda_u2d0.setTitle("添加桌面组件");
                $this$onItemClick_u24lambda_u2d0.setSubTitle("常用搜索，一键直达");
                $this$onItemClick_u24lambda_u2d0.setPreViewResId(Integer.valueOf(R.drawable.widget_custom_guide_preview));
                $this$onItemClick_u24lambda_u2d0.setDialogPosition(80);
                $this$onItemClick_u24lambda_u2d0.setOnConfirmAction(WidgetDebugConfigProvider$widgetCommonConfigListener$1$2$onItemClick$1$1.INSTANCE);
                $this$onItemClick_u24lambda_u2d0.setOnCloseAction(WidgetDebugConfigProvider$widgetCommonConfigListener$1$2$onItemClick$1$2.INSTANCE);
                builder.build().show();
                return;
            case 5:
                WidgetRightsFreqMgr.Companion.getInstance().recordWidgetRightsFreqTime("home", "123", "show");
                return;
            case 6:
                WidgetRightsFreqMgr.Companion.getInstance().recordWidgetRightsFreqTime("home", "123", "exit");
                return;
            case 7:
                WidgetDebugKt.printLog(WidgetDebugKt.TAG_WIDGET_RIGHTS, (Function0<String>) new WidgetDebugConfigProvider$widgetCommonConfigListener$1$2$onItemClick$2(WidgetRightsFreqMgr.Companion.getInstance().getWidgetRightsFreqTimeList$lib_widget_release("home", "123")));
                return;
            default:
                return;
        }
    }
}
