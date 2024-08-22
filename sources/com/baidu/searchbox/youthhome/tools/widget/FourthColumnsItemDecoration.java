package com.baidu.searchbox.youthhome.tools.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.youthhome.tools.R;
import com.baidu.searchbox.youthhome.tools.adapter.YouthHomeV1ToolBaseViewHolderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/youthhome/tools/widget/FourthColumnsItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "youth-home-tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FourthColumnsItemDecoration.kt */
public final class FourthColumnsItemDecoration extends RecyclerView.ItemDecoration {
    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        int spanCount;
        int position;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null && (spanCount = adapter.getItemCount()) >= 2 && (position = parent.getChildAdapterPosition(view2)) < spanCount && position >= 0) {
            int parentWidth = parent.getWidth();
            float itemWidthInside = FontSizeHelper.getScaledSizeRes(YouthHomeV1ToolBaseViewHolderKt.getTOOL_FOURTH_COLUMNS_TEXT_SCALE(), R.dimen.dimens_66dp);
            float padding = ((float) (parentWidth / 4)) - itemWidthInside;
            float space = (((float) parentWidth) - (((float) spanCount) * itemWidthInside)) / ((float) (spanCount - 1));
            switch (position % spanCount) {
                case 0:
                    outRect.left = 0;
                    outRect.right = (int) padding;
                    return;
                case 1:
                    outRect.left = (int) (space - padding);
                    outRect.right = (int) ((((float) 2) * padding) - space);
                    return;
                case 2:
                    float f2 = (float) 2;
                    outRect.left = (int) ((space * f2) - (padding * f2));
                    outRect.right = (int) ((((float) 3) * padding) - (f2 * space));
                    return;
                case 3:
                    outRect.left = (int) padding;
                    outRect.right = 0;
                    return;
                default:
                    return;
            }
        }
    }
}
