package com.baidu.searchbox.feed.payment.payui.payPanel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import com.baidu.searchbox.feed.payment.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayProPanelPriceDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "size", "", "(I)V", "isHasSingle", "", "getSize", "()I", "space", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "pxOf", "id", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayProPanelPriceView.kt */
final class PayProPanelPriceDecoration extends RecyclerView.ItemDecoration {
    private boolean isHasSingle;
    private final int size;
    private final int space = pxOf(R.dimen.feed_short_video_panel_item_margin);

    public PayProPanelPriceDecoration(int size2) {
        this.size = size2;
        this.isHasSingle = size2 % 2 != 0;
    }

    public final int getSize() {
        return this.size;
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(state, "state");
        int position = parent.getChildAdapterPosition(view2);
        boolean z = this.isHasSingle;
        if ((z && position != 0) || !z) {
            int column = position % 2;
            if ((column != 0 || !z) && (column != 1 || z)) {
                outRect.right = this.space / 2;
            } else {
                outRect.left = this.space / 2;
            }
            boolean z2 = this.isHasSingle;
            if ((z2 && position >= 1) || (!z2 && position >= 2)) {
                outRect.top = this.space / 2;
            }
        }
    }

    private final int pxOf(int id) {
        return FeedpayKt.appContext().getResources().getDimensionPixelSize(id);
    }
}
