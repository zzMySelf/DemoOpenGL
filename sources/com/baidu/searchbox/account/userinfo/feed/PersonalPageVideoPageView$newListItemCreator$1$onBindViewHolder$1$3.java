package com.baidu.searchbox.account.userinfo.feed;

import com.baidu.searchbox.account.userinfo.data.PPVideoEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageVideoPageView.kt */
final class PersonalPageVideoPageView$newListItemCreator$1$onBindViewHolder$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PPVideoEntity $data;
    final /* synthetic */ PersonalPageVideoPageView this$0;
    final /* synthetic */ PersonalPageVideoPageView$newListItemCreator$1 this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageVideoPageView$newListItemCreator$1$onBindViewHolder$1$3(PersonalPageVideoPageView personalPageVideoPageView, PersonalPageVideoPageView$newListItemCreator$1 personalPageVideoPageView$newListItemCreator$1, PPVideoEntity pPVideoEntity) {
        super(0);
        this.this$0 = personalPageVideoPageView;
        this.this$1 = personalPageVideoPageView$newListItemCreator$1;
        this.$data = pPVideoEntity;
    }

    public final void invoke() {
        PersonalPageVideoPageView personalPageVideoPageView = this.this$0;
        final PersonalPageVideoPageView$newListItemCreator$1 personalPageVideoPageView$newListItemCreator$1 = this.this$1;
        final PPVideoEntity pPVideoEntity = this.$data;
        personalPageVideoPageView.showDeleteVideoDialog(new Function0<Unit>() {
            public final void invoke() {
                personalPageVideoPageView$newListItemCreator$1.onDeleteVideo(pPVideoEntity);
            }
        });
    }
}
