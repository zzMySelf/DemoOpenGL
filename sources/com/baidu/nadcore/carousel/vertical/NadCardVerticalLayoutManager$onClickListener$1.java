package com.baidu.nadcore.carousel.vertical;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/nadcore/carousel/vertical/NadCardVerticalLayoutManager$onClickListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCardVerticalLayoutManager.kt */
public final class NadCardVerticalLayoutManager$onClickListener$1 implements View.OnClickListener {
    final /* synthetic */ NadCardVerticalLayoutManager this$0;

    NadCardVerticalLayoutManager$onClickListener$1(NadCardVerticalLayoutManager $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(View v) {
        View viewForPosition;
        RecyclerView.Recycler access$getRecycler$p = this.this$0.recycler;
        if (access$getRecycler$p != null && (viewForPosition = access$getRecycler$p.getViewForPosition(0)) != null) {
            viewForPosition.performClick();
        }
    }
}
