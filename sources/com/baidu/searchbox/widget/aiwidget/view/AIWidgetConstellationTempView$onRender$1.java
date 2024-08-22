package com.baidu.searchbox.widget.aiwidget.view;

import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import com.baidu.searchbox.oem.widget.R;
import com.baidu.searchbox.widget.utils.OnImageLoadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/widget/aiwidget/view/AIWidgetConstellationTempView$onRender$1", "Lcom/baidu/searchbox/widget/utils/OnImageLoadListener;", "onLoadFail", "", "onLoadSuccess", "bitmap", "Landroid/graphics/Bitmap;", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIWidgetConstellationTempView.kt */
public final class AIWidgetConstellationTempView$onRender$1 implements OnImageLoadListener {
    final /* synthetic */ AIWidgetConstellationTempView this$0;

    AIWidgetConstellationTempView$onRender$1(AIWidgetConstellationTempView $receiver) {
        this.this$0 = $receiver;
    }

    public void onLoadSuccess(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.this$0.setImageViewBitmap(R.id.iv_ai_widget_constellation_image, bitmap);
        AppWidgetManager appWidgetManager = this.this$0.getAppWidgetManager();
        if (appWidgetManager != null) {
            appWidgetManager.updateAppWidget(this.this$0.getAppWidgetId(), this.this$0.getViews());
        }
    }

    public void onLoadFail() {
    }
}
