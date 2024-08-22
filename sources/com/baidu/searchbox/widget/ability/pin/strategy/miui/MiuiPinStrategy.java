package com.baidu.searchbox.widget.ability.pin.strategy.miui;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.widget.ability.pin.IWidgetPinCallback;
import com.baidu.searchbox.widget.ability.pin.WidgetPinResponse;
import com.baidu.searchbox.widget.ability.pin.WidgetPinSession;
import com.baidu.searchbox.widget.ability.pin.strategy.DefaultPinStrategy;
import com.baidu.searchbox.widget.ability.pin.utils.PermissionHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/widget/ability/pin/strategy/miui/MiuiPinStrategy;", "Lcom/baidu/searchbox/widget/ability/pin/strategy/DefaultPinStrategy;", "()V", "apply", "", "activity", "Landroid/app/Activity;", "session", "Lcom/baidu/searchbox/widget/ability/pin/WidgetPinSession;", "manager", "Landroid/appwidget/AppWidgetManager;", "pendingIntent", "Landroid/app/PendingIntent;", "lib-widget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiuiPinStrategy.kt */
public final class MiuiPinStrategy extends DefaultPinStrategy {
    public void apply(Activity activity, WidgetPinSession session, AppWidgetManager manager, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        if (PermissionHelpersKt.checkOpPermission(10017) == 0) {
            super.apply(activity, session, manager, pendingIntent);
        } else if (!MiuiPermGuideActivity.Companion.startSafely(activity, session)) {
            WidgetPinSession $this$apply_u24lambda_u2d1 = session;
            IWidgetPinCallback callback = $this$apply_u24lambda_u2d1.getCallback();
            WidgetPinResponse $this$apply_u24lambda_u2d1_u24lambda_u2d0 = $this$apply_u24lambda_u2d1.getResponse();
            $this$apply_u24lambda_u2d1_u24lambda_u2d0.setStatusCode(5002);
            callback.onFailure($this$apply_u24lambda_u2d1_u24lambda_u2d0);
        }
    }
}
