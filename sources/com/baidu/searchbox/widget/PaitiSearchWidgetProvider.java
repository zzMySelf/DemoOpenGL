package com.baidu.searchbox.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.oem.widget.R;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.searchbox.widget.base.BaseWidgetProvider;
import com.baidu.searchbox.widget.ext.WidgetStatisticExtKt;
import com.baidu.searchbox.widget.utils.WidgetPushUtilsKt;
import com.baidu.searchbox.widget.utils.WidgetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/widget/PaitiSearchWidgetProvider;", "Lcom/baidu/searchbox/widget/base/BaseWidgetProvider;", "()V", "onDeleted", "", "context", "Landroid/content/Context;", "appWidgetIds", "", "onReceive", "intent", "Landroid/content/Intent;", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "setupWidget", "views", "Landroid/widget/RemoteViews;", "appWidgetId", "", "startPushServiceByWidgetAction", "widgetAddStatistic", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaitiSearchWidgetProvider.kt */
public final class PaitiSearchWidgetProvider extends BaseWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews views;
        if (context != null && appWidgetIds != null && appWidgetManager != null) {
            super.onUpdate(context, appWidgetManager, appWidgetIds);
            for (int appWidgetId : appWidgetIds) {
                if (WidgetUtils.isMiuiWidgetSupported(context)) {
                    views = new RemoteViews(context.getPackageName(), R.layout.paiti_search_widget_miui);
                } else {
                    views = new RemoteViews(context.getPackageName(), R.layout.paiti_search_widget_common);
                }
                setupWidget(context, appWidgetManager, views, appWidgetId);
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
            widgetAddStatistic(context, appWidgetIds);
        }
    }

    private final void setupWidget(Context context, AppWidgetManager appWidgetManager, RemoteViews views, int appWidgetId) {
        int i2 = R.id.paiti_search_bg_img;
        Intent paitiSearchClickIntent = WidgetActionUtils.getPaitiSearchClickIntent(appWidgetId);
        Intrinsics.checkNotNullExpressionValue(paitiSearchClickIntent, "getPaitiSearchClickIntent(appWidgetId)");
        views.setOnClickPendingIntent(i2, WidgetUtils.getPendingIntentFromBroadcast(context, 104, paitiSearchClickIntent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
    }

    private final void widgetAddStatistic(Context context, int[] appWidgetIds) {
        WidgetStatisticExtKt.widgetAddStatisticExt$default(context, appWidgetIds, 8, (String) null, (String) null, (String) null, (JSONObject) null, 120, (Object) null);
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (SecurityUtils.checkIntentRefuseService(intent) || intent == null) {
                return;
            }
            if (context != null) {
                super.onReceive(context, intent);
                if (PaitiSearchWidgetProviderKt.DEBUG) {
                    Log.d("PaitiSearchWidget", " onReceive: action=" + intent.getAction());
                }
                int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, getClass()));
                if (appWidgetIds != null) {
                    if (!(appWidgetIds.length == 0)) {
                        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) WidgetActionUtils.ACTION_PAITI_SEARCH_CLICK)) {
                            WidgetActionUtils.invokeScheme(intent, context);
                            WidgetDataStatisticUtils.addWidgetClickStatistic(8, 19);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (PaitiSearchWidgetProviderKt.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        WidgetDataStatisticUtils.deleteWidgetPutStatistic(8);
    }

    public void startPushServiceByWidgetAction(Context context, Intent intent) {
        super.startPushServiceByWidgetAction(context, intent);
        if (intent != null) {
            String action = intent.getAction();
            if (Intrinsics.areEqual((Object) action, (Object) WidgetActionUtils.ACTION_PAITI_SEARCH_CLICK)) {
                WidgetPushUtilsKt.startPushServiceByWidget(getClass(), action);
            }
        }
    }
}
