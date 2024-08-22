package com.baidu.searchbox.aipersonal.activity;

import com.baidu.searchbox.newpersonalcenter.adapter.PersonalAiMoreFunctionAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/newpersonalcenter/adapter/PersonalAiMoreFunctionAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiCommonManagerForPadActivity.kt */
final class PersonalAiCommonManagerForPadActivity$mAddAdapter$2 extends Lambda implements Function0<PersonalAiMoreFunctionAdapter> {
    final /* synthetic */ PersonalAiCommonManagerForPadActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalAiCommonManagerForPadActivity$mAddAdapter$2(PersonalAiCommonManagerForPadActivity personalAiCommonManagerForPadActivity) {
        super(0);
        this.this$0 = personalAiCommonManagerForPadActivity;
    }

    public final PersonalAiMoreFunctionAdapter invoke() {
        PersonalAiCommonManagerForPadActivity personalAiCommonManagerForPadActivity = this.this$0;
        return new PersonalAiMoreFunctionAdapter(personalAiCommonManagerForPadActivity, personalAiCommonManagerForPadActivity.getItemsShownHistorySet());
    }
}
