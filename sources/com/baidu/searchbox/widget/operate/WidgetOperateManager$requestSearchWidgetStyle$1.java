package com.baidu.searchbox.widget.operate;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.WidgetActionUtils;
import com.baidu.searchbox.widget.guide.config.SearchWidgetGuideExperimentKt;
import com.baidu.searchbox.widget.guide.config.SearchWidgetGuideManagerKt;
import com.baidu.searchbox.widget.guide.config.searchWidgetPrefsMain;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "style", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetOperateManager.kt */
final class WidgetOperateManager$requestSearchWidgetStyle$1 extends Lambda implements Function1<String, Unit> {
    public static final WidgetOperateManager$requestSearchWidgetStyle$1 INSTANCE = new WidgetOperateManager$requestSearchWidgetStyle$1();

    WidgetOperateManager$requestSearchWidgetStyle$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        String oldStyle = searchWidgetPrefsMain.INSTANCE.getString(SearchWidgetGuideManagerKt.KEY_SEARCH_WIDGET_STYLE_TYPE, (String) null);
        if (oldStyle == null) {
            Intent intent = new Intent(WidgetActionUtils.ACTION_SEARCH_WIDGET_STYLE_REFRESH);
            Context context = AppRuntime.getAppContext();
            if (context != null) {
                intent.setPackage(context.getPackageName());
                intent.putExtra(SearchWidgetGuideExperimentKt.SEARCH_WIDGET_STYLE, style);
                context.sendBroadcast(intent);
            }
        } else if (!Intrinsics.areEqual((Object) oldStyle, (Object) style)) {
            Intent intent2 = new Intent(WidgetActionUtils.ACTION_SEARCH_WIDGET_STYLE_REFRESH);
            Context context2 = AppRuntime.getAppContext();
            if (context2 != null) {
                intent2.setPackage(context2.getPackageName());
                intent2.putExtra(SearchWidgetGuideExperimentKt.SEARCH_WIDGET_STYLE, style);
                context2.sendBroadcast(intent2);
            }
        }
    }
}
