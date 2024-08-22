package com.baidu.searchbox.video.feedflow.view.carousepic.gesture.abs;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/carousepic/gesture/abs/IOnTapListener;", "", "onDoubleTap", "", "view", "Landroid/view/View;", "isEnlarge", "", "onTap", "x", "", "y", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IOnTapListener.kt */
public interface IOnTapListener {
    void onDoubleTap(View view2, boolean z);

    void onTap(View view2, float f2, float f3);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IOnTapListener.kt */
    public static final class DefaultImpls {
        public static void onTap(IOnTapListener iOnTapListener, View view2, float x, float y) {
        }

        public static void onDoubleTap(IOnTapListener iOnTapListener, View view2, boolean isEnlarge) {
        }
    }
}
