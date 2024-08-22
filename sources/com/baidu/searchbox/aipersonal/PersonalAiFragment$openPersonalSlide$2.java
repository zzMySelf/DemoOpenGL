package com.baidu.searchbox.aipersonal;

import com.baidu.searchbox.aipersonal.header.PersonAiCenterHeaderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiFragment.kt */
final class PersonalAiFragment$openPersonalSlide$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PersonalAiFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalAiFragment$openPersonalSlide$2(PersonalAiFragment personalAiFragment) {
        super(0);
        this.this$0 = personalAiFragment;
    }

    public final void invoke() {
        PersonAiCenterHeaderView access$getMCenterHeaderView$p = this.this$0.mCenterHeaderView;
        if (access$getMCenterHeaderView$p != null) {
            access$getMCenterHeaderView$p.checkShowSideDataTips();
        }
    }
}
