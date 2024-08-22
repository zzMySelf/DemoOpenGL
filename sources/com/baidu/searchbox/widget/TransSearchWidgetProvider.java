package com.baidu.searchbox.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.widget.base.AbExpWidgetProvider;
import com.baidu.searchbox.widget.ext.WidgetStatisticExtKt;
import com.baidu.searchbox.widget.lifecycle.IWidgetLifecycle;
import com.baidu.searchbox.widget.searchwidget.SearchWidgetManagerKt;
import java.util.Arrays;
import org.json.JSONObject;

public class TransSearchWidgetProvider extends AbExpWidgetProvider {
    public static final String CATEGORY_TRANS_SEARCH = "com.baidu.searchbox.category.TRANS_SEARCH";
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "TransWidgetProvider";

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        if (context != null && appWidgetManager != null && appWidgetIds != null) {
            if (DEBUG) {
                Log.d(TAG, "TransSearchWidgetProvider.onUpdate: appWidgetIds" + Arrays.toString(appWidgetIds));
            }
            super.onUpdate(context, appWidgetManager, appWidgetIds);
            WidgetStatisticExtKt.widgetAddStatisticExt(context, appWidgetIds, 2, "", (String) null, (String) null, (JSONObject) null);
        }
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        if (context != null && appWidgetIds != null) {
            if (DEBUG) {
                Log.d(TAG, "TransSearchWidgetProvider.onDeleted: appWidgetIds" + Arrays.toString(appWidgetIds));
            }
            super.onDeleted(context, appWidgetIds);
            WidgetStatisticExtKt.widgetDeleteStatisticExt(context, appWidgetIds, 2, (String) null, (String) null, (String) null, (JSONObject) null);
        }
    }

    /* access modifiers changed from: protected */
    public IWidgetLifecycle getAbExpWidget() {
        if (DEBUG) {
            Log.d(TAG, " getAbExpWidget: ");
        }
        return SearchWidgetManagerKt.getTransSearchWidget();
    }
}
