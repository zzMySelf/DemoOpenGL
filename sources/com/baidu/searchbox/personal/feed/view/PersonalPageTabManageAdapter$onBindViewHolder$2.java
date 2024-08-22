package com.baidu.searchbox.personal.feed.view;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageTabManageAdapter.kt */
final class PersonalPageTabManageAdapter$onBindViewHolder$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Ref.ObjectRef<Pair<String, String>> $tabPair;
    final /* synthetic */ PersonalPageTabManageAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageTabManageAdapter$onBindViewHolder$2(PersonalPageTabManageAdapter personalPageTabManageAdapter, Ref.ObjectRef<Pair<String, String>> objectRef) {
        super(1);
        this.this$0 = personalPageTabManageAdapter;
        this.$tabPair = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int it) {
        this.this$0.addTabToAdded(it);
        UbcCallback access$getUbcCallback$p = this.this$0.ubcCallback;
        StringBuilder append = new StringBuilder().append("edit_show_");
        Pair pair = (Pair) this.$tabPair.element;
        access$getUbcCallback$p.doUbc(append.append(pair != null ? (String) pair.getFirst() : null).toString());
    }
}
