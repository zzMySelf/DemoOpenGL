package com.baidu.searchbox.personal.sidebar;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.base.utils.UIUtils;
import com.baidu.searchbox.favor.data.FavorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/personal/sidebar/SidebarWindowLayout$initViews$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SidebarWindowLayout.kt */
public final class SidebarWindowLayout$initViews$1 extends RecyclerView.ItemDecoration {
    final /* synthetic */ SidebarWindowLayout this$0;

    SidebarWindowLayout$initViews$1(SidebarWindowLayout $receiver) {
        this.this$0 = $receiver;
    }

    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        if (itemPosition == 0) {
            outRect.top = UIUtils.dp2px(this.this$0.mRecyclerview.getContext(), 26);
        } else {
            outRect.top = 0;
        }
        outRect.bottom = UIUtils.dp2px(this.this$0.mRecyclerview.getContext(), 10);
    }
}
