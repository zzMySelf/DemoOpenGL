package com.baidu.searchbox.feed.template.poly;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.resources.util.CtxResEasyUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/feed/template/poly/FeedPolyItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedPolyItemDecoration.kt */
public final class FeedPolyItemDecoration extends RecyclerView.ItemDecoration {
    private final Context context;

    public FeedPolyItemDecoration(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        int i2;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        int i3 = 0;
        int count = adapter != null ? adapter.getItemCount() : 0;
        int currentPos = parent.getChildAdapterPosition(view2);
        if (count >= 0 && currentPos >= 0 && currentPos < count) {
            boolean hasFooter = false;
            if (parent.getAdapter() instanceof FeedPolyScrollItemAdapter) {
                RecyclerView.Adapter adapter2 = parent.getAdapter();
                if (adapter2 != null) {
                    hasFooter = ((FeedPolyScrollItemAdapter) adapter2).hasFooter();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.template.poly.FeedPolyScrollItemAdapter");
                }
            }
            Resources $this$getItemOffsets_u24lambda_u2d0 = CtxResEasyUtils.getAppContext().getResources();
            if ($this$getItemOffsets_u24lambda_u2d0 == null) {
                return;
            }
            if (currentPos == 0) {
                if (!FeedUtil.isPadHomeBasic(this.context)) {
                    i3 = $this$getItemOffsets_u24lambda_u2d0.getDimensionPixelSize(R.dimen.F_M_W_X505);
                }
                outRect.left = i3;
            } else if (currentPos == count - 1) {
                outRect.left = $this$getItemOffsets_u24lambda_u2d0.getDimensionPixelSize(R.dimen.F_M_W_X062);
                if (hasFooter) {
                    i2 = $this$getItemOffsets_u24lambda_u2d0.getDimensionPixelSize(R.dimen.F_M_W_X045);
                } else {
                    i2 = $this$getItemOffsets_u24lambda_u2d0.getDimensionPixelSize(R.dimen.F_M_W_X505);
                }
                outRect.right = i2;
            } else {
                outRect.left = $this$getItemOffsets_u24lambda_u2d0.getDimensionPixelSize(R.dimen.F_M_W_X062);
            }
        }
    }
}
