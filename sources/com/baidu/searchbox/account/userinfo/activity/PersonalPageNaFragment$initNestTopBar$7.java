package com.baidu.searchbox.account.userinfo.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
final class PersonalPageNaFragment$initNestTopBar$7 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PersonalPageNaFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageNaFragment$initNestTopBar$7(PersonalPageNaFragment personalPageNaFragment) {
        super(0);
        this.this$0 = personalPageNaFragment;
    }

    public final void invoke() {
        this.this$0.onBackPressed();
        Function0<Boolean> backPressedInterceptor = this.this$0.getBackPressedInterceptor();
        if (backPressedInterceptor != null) {
            Boolean invoke = backPressedInterceptor.invoke();
        }
    }
}
