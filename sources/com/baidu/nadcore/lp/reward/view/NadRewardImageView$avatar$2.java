package com.baidu.nadcore.lp.reward.view;

import com.baidu.nadcore.business.R;
import com.baidu.nadcore.widget.AdImageView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/nadcore/widget/AdImageView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardImageView.kt */
final class NadRewardImageView$avatar$2 extends Lambda implements Function0<AdImageView> {
    final /* synthetic */ NadRewardImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadRewardImageView$avatar$2(NadRewardImageView nadRewardImageView) {
        super(0);
        this.this$0 = nadRewardImageView;
    }

    public final AdImageView invoke() {
        return (AdImageView) this.this$0.findViewById(R.id.avatar);
    }
}
