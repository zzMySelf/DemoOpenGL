package com.baidu.searchbox.bigimage.transition;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/bigimage/transition/TransitionContext;", "", "toScreenRect", "Landroid/graphics/Rect;", "rect", "Companion", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransitionContext.kt */
public interface TransitionContext {
    public static final Companion Companion = Companion.$$INSTANCE;

    Rect toScreenRect(Rect rect);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/bigimage/transition/TransitionContext$Companion;", "", "()V", "fromTalos", "Lcom/baidu/searchbox/bigimage/transition/TransitionContext;", "view", "Landroid/view/View;", "fromWebView", "webView", "webViewScale", "", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransitionContext.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ TransitionContext fromWebView$default(Companion companion, View view2, float f2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f2 = 1.0f;
            }
            return companion.fromWebView(view2, f2);
        }

        public final TransitionContext fromWebView(View webView, float webViewScale) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            int[] location = new int[2];
            webView.getLocationOnScreen(location);
            return new WebViewTransitionContext(new Point(location[0], location[1]), webViewScale);
        }

        public final TransitionContext fromTalos(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            int[] location = new int[2];
            view2.getLocationOnScreen(location);
            return new TalosTransitionContext(new Point(location[0], location[1]));
        }
    }
}
