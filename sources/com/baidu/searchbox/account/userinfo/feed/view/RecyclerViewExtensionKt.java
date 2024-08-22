package com.baidu.searchbox.account.userinfo.feed.view;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"smoothScrollToPositionWithOffset", "", "Landroidx/recyclerview/widget/RecyclerView;", "position", "", "offset", "lib-userinfo_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecyclerViewExtension.kt */
public final class RecyclerViewExtensionKt {
    public static final void smoothScrollToPositionWithOffset(RecyclerView $this$smoothScrollToPositionWithOffset, int position, int offset) {
        Intrinsics.checkNotNullParameter($this$smoothScrollToPositionWithOffset, "<this>");
        RecyclerViewExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1 linearSmoothScroller = new RecyclerViewExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1(offset, $this$smoothScrollToPositionWithOffset.getContext());
        linearSmoothScroller.setTargetPosition(position);
        RecyclerView.LayoutManager layoutManager = $this$smoothScrollToPositionWithOffset.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.startSmoothScroll(linearSmoothScroller);
        }
    }
}
