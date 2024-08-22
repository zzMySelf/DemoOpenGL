package com.baidu.nadcore.lp.reward.view;

import android.widget.LinearLayout;
import com.baidu.nadcore.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardFullTailView.kt */
final class NadRewardFullTailView$replayButton$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ NadRewardFullTailView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadRewardFullTailView$replayButton$2(NadRewardFullTailView nadRewardFullTailView) {
        super(0);
        this.this$0 = nadRewardFullTailView;
    }

    public final LinearLayout invoke() {
        return (LinearLayout) this.this$0.findViewById(R.id.replay_btn);
    }
}
