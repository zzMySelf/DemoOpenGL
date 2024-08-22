package com.baidu.searchbox.video.feedflow.ad.dynamic.carouselpic;

import android.view.GestureDetector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/GestureDetector$OnGestureListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GestureFrameLayout.kt */
final class GestureFrameLayout$gestureListener$2 extends Lambda implements Function0<GestureDetector.OnGestureListener> {
    final /* synthetic */ GestureFrameLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GestureFrameLayout$gestureListener$2(GestureFrameLayout gestureFrameLayout) {
        super(0);
        this.this$0 = gestureFrameLayout;
    }

    public final GestureDetector.OnGestureListener invoke() {
        return this.this$0.createGestureListener();
    }
}
