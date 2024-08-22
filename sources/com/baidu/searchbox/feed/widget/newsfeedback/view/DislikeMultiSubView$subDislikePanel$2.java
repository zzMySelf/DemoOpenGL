package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.widget.LinearLayout;
import com.baidu.searchbox.feed.core.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DislikeMultiSubView.kt */
final class DislikeMultiSubView$subDislikePanel$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ DislikeMultiSubView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DislikeMultiSubView$subDislikePanel$2(DislikeMultiSubView dislikeMultiSubView) {
        super(0);
        this.this$0 = dislikeMultiSubView;
    }

    public final LinearLayout invoke() {
        return (LinearLayout) this.this$0.findViewById(R.id.feed_dislike_sub_option_panel);
    }
}
