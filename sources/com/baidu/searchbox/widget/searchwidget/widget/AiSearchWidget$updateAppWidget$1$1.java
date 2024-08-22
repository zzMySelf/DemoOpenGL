package com.baidu.searchbox.widget.searchwidget.widget;

import com.baidu.searchbox.widget.utils.RefreshType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiSearchWidget.kt */
final class AiSearchWidget$updateAppWidget$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ int $appWidgetId;
    final /* synthetic */ int $it;
    final /* synthetic */ RefreshType $refreshType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiSearchWidget$updateAppWidget$1$1(int i2, int i3, RefreshType refreshType) {
        super(0);
        this.$appWidgetId = i2;
        this.$it = i3;
        this.$refreshType = refreshType;
    }

    public final String invoke() {
        return "AiSearchWidget.updateAppWidget: current updating appWidgetId = " + this.$appWidgetId + ", type = " + this.$it + ", refreshType = " + this.$refreshType;
    }
}
