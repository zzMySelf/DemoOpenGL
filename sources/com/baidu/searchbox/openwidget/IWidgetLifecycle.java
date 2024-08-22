package com.baidu.searchbox.openwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J*\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/openwidget/IWidgetLifecycle;", "", "onDeleted", "", "context", "Landroid/content/Context;", "widgetId", "", "onOptionsChanged", "widgetManager", "Landroid/appwidget/AppWidgetManager;", "newOptions", "Landroid/os/Bundle;", "onUpdate", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWidgetLifecycle.kt */
public interface IWidgetLifecycle {
    void onDeleted(Context context, int i2);

    void onOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i2, Bundle bundle);

    void onUpdate(Context context, AppWidgetManager appWidgetManager, int i2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWidgetLifecycle.kt */
    public static final class DefaultImpls {
        public static void onUpdate(IWidgetLifecycle iWidgetLifecycle, Context context, AppWidgetManager widgetManager, int widgetId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(widgetManager, "widgetManager");
        }

        public static void onDeleted(IWidgetLifecycle iWidgetLifecycle, Context context, int widgetId) {
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public static void onOptionsChanged(IWidgetLifecycle iWidgetLifecycle, Context context, AppWidgetManager widgetManager, int widgetId, Bundle newOptions) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(widgetManager, "widgetManager");
        }
    }
}
