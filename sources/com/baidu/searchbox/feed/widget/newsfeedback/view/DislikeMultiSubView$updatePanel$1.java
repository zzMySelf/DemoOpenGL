package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.view.View;
import com.baidu.searchbox.feed.widget.newsfeedback.OnClickDislikeListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/widget/newsfeedback/view/DislikeMultiSubView$updatePanel$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DislikeMultiSubView.kt */
public final class DislikeMultiSubView$updatePanel$1 implements View.OnClickListener {
    final /* synthetic */ DislikeMultiSubView this$0;

    DislikeMultiSubView$updatePanel$1(DislikeMultiSubView $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(View v) {
        OnClickDislikeListener access$getOnClickDislikeListener$p = this.this$0.onClickDislikeListener;
        if (access$getOnClickDislikeListener$p != null) {
            access$getOnClickDislikeListener$p.onClickBackEvent(this.this$0.tagInfo);
        }
    }
}
