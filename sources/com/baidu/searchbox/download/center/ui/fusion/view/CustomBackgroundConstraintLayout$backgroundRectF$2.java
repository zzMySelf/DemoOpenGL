package com.baidu.searchbox.download.center.ui.fusion.view;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomBackgroundConstraintLayout.kt */
final class CustomBackgroundConstraintLayout$backgroundRectF$2 extends Lambda implements Function0<RectF> {
    final /* synthetic */ CustomBackgroundConstraintLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomBackgroundConstraintLayout$backgroundRectF$2(CustomBackgroundConstraintLayout customBackgroundConstraintLayout) {
        super(0);
        this.this$0 = customBackgroundConstraintLayout;
    }

    public final RectF invoke() {
        return new RectF(0.0f, 0.0f, (float) this.this$0.getWidth(), (float) this.this$0.getHeight());
    }
}
