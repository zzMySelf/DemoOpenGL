package com.baidu.searchbox.video.feedflow.detail.listpanel;

import android.graphics.Paint;
import com.baidu.searchbox.video.feedflow.detail.listpanel.ListPopupPanel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListPopupPanel.kt */
final class ListPopupPanel$ListItemDecoration$paint$2 extends Lambda implements Function0<Paint> {
    final /* synthetic */ ListPopupPanel.ListItemDecoration this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListPopupPanel$ListItemDecoration$paint$2(ListPopupPanel.ListItemDecoration listItemDecoration) {
        super(0);
        this.this$0 = listItemDecoration;
    }

    public final Paint invoke() {
        return this.this$0.initPaint();
    }
}
