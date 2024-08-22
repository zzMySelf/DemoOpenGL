package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/widget/newsfeedback/view/DislikeMultiSubView$createSubOptionView$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DislikeMultiSubView.kt */
public final class DislikeMultiSubView$createSubOptionView$1 implements View.OnClickListener {
    final /* synthetic */ SubTagItem $subInfo;
    final /* synthetic */ ImageView $subOptionState;
    final /* synthetic */ DislikeMultiSubView this$0;

    DislikeMultiSubView$createSubOptionView$1(DislikeMultiSubView $receiver, SubTagItem $subInfo2, ImageView $subOptionState2) {
        this.this$0 = $receiver;
        this.$subInfo = $subInfo2;
        this.$subOptionState = $subOptionState2;
    }

    public void onClick(View v) {
        if (this.this$0.selectList.contains(this.$subInfo)) {
            this.$subOptionState.setImageDrawable(ContextCompat.getDrawable(this.this$0.getContext(), R.drawable.feed_dislike_multi_sub_not_select));
            this.this$0.selectList.remove(this.$subInfo);
        } else {
            this.$subOptionState.setImageDrawable(ContextCompat.getDrawable(this.this$0.getContext(), R.drawable.feed_dislike_multi_sub_select));
            this.this$0.selectList.add(this.$subInfo);
        }
        if (this.this$0.selectList.size() > 0) {
            this.this$0.getSubmitTv().setAlpha(1.0f);
            this.this$0.getSubmitTv().setClickable(true);
            return;
        }
        this.this$0.getSubmitTv().setAlpha(0.4f);
        this.this$0.getSubmitTv().setClickable(false);
    }
}
