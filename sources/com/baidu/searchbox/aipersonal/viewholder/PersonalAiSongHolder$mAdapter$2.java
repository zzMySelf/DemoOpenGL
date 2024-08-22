package com.baidu.searchbox.aipersonal.viewholder;

import android.content.Context;
import com.baidu.searchbox.aipersonal.adapters.PersonalAiSongCardAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/aipersonal/adapters/PersonalAiSongCardAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiSongHolder.kt */
final class PersonalAiSongHolder$mAdapter$2 extends Lambda implements Function0<PersonalAiSongCardAdapter> {
    final /* synthetic */ PersonalAiSongHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalAiSongHolder$mAdapter$2(PersonalAiSongHolder personalAiSongHolder) {
        super(0);
        this.this$0 = personalAiSongHolder;
    }

    public final PersonalAiSongCardAdapter invoke() {
        Context access$getContext = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(access$getContext, "context");
        return new PersonalAiSongCardAdapter(access$getContext, this.this$0.getListener());
    }
}
