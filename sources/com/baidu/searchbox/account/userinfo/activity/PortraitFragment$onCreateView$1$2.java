package com.baidu.searchbox.account.userinfo.activity;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/PortraitFragment$onCreateView$1$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitSettingActivity.kt */
public final class PortraitFragment$onCreateView$1$2 extends RecyclerView.ItemDecoration {
    final /* synthetic */ PortraitFragment this$0;

    PortraitFragment$onCreateView$1$2(PortraitFragment $receiver) {
        this.this$0 = $receiver;
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(state, "state");
        outRect.set(outRect.left, this.this$0.getItemSpace(), outRect.right, this.this$0.getItemSpace());
    }
}
