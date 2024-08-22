package com.baidu.searchbox.player.menu.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.videoplayer.vulcan.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/player/menu/view/MenuItemDecorationNew;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "ceil", "", "num", "den", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MenuItemDecorationNew.kt */
public final class MenuItemDecorationNew extends RecyclerView.ItemDecoration {
    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view2, parent, state);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager != null) {
            int childPosition = parent.getChildAdapterPosition(view2);
            int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
            if (spanCount > 0) {
                Context context = view2.getContext();
                int row = childPosition / spanCount;
                RecyclerView.Adapter adapter = parent.getAdapter();
                int itemCount = RangesKt.coerceAtMost(adapter != null ? adapter.getItemCount() : 0, 6);
                if (row + 1 == ceil(itemCount, spanCount)) {
                    outRect.bottom = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_21);
                } else {
                    outRect.bottom = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_12);
                }
                if (itemCount != 2) {
                    outRect.left = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_6);
                    outRect.right = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_6);
                } else if (childPosition == 0) {
                    outRect.right = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_17);
                    outRect.left = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_0);
                } else {
                    outRect.left = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_17);
                    outRect.right = context.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_0);
                }
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        }
    }

    private final int ceil(int num, int den) {
        if (num % den == 0) {
            return num / den;
        }
        return (num / den) + 1;
    }
}
