package com.baidu.searchbox.video.feedflow.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/utils/OnAlphaAnimateListener;", "", "onAnimEnd", "", "targetView", "Landroid/view/View;", "visible", "", "isShowAnim", "", "onAnimStart", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShowAndHideAnimHelper.kt */
public interface OnAlphaAnimateListener {
    void onAnimEnd(View view2, int i2, boolean z);

    void onAnimStart(View view2, int i2, boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShowAndHideAnimHelper.kt */
    public static final class DefaultImpls {
        public static void onAnimStart(OnAlphaAnimateListener onAlphaAnimateListener, View targetView, int visible, boolean isShowAnim) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
        }

        public static void onAnimEnd(OnAlphaAnimateListener onAlphaAnimateListener, View targetView, int visible, boolean isShowAnim) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
        }
    }
}
