package com.baidu.searchbox.widget.feedwidget;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.oem.widget.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/widget/feedwidget/HotWidgetItemData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotWidgetItemData.kt */
final class HotWidgetItemData$Companion$LAST_ITEM$2 extends Lambda implements Function0<HotWidgetItemData> {
    public static final HotWidgetItemData$Companion$LAST_ITEM$2 INSTANCE = new HotWidgetItemData$Companion$LAST_ITEM$2();

    HotWidgetItemData$Companion$LAST_ITEM$2() {
        super(0);
    }

    public final HotWidgetItemData invoke() {
        HotWidgetItemData hotWidgetItemData = new HotWidgetItemData();
        HotWidgetItemData $this$invoke_u24lambda_u2d0 = hotWidgetItemData;
        String string = AppRuntime.getAppContext().getString(R.string.hot_widget_middle_full_hot_list_title);
        Intrinsics.checkNotNullExpressionValue(string, "getAppContext().getStrin…ddle_full_hot_list_title)");
        $this$invoke_u24lambda_u2d0.title = string;
        $this$invoke_u24lambda_u2d0.pageUrl = FeedWidgetKt.SCHEMA_TO_FEED_HOT_TAB;
        return hotWidgetItemData;
    }
}
