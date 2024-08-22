package com.baidu.searchbox.bigimage.comp.relatedsearch;

import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedSearchComp.kt */
final class RelatedSearchComp$onRegisterDelegates$1 extends Lambda implements Function0<UniqueId> {
    final /* synthetic */ RelatedSearchComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RelatedSearchComp$onRegisterDelegates$1(RelatedSearchComp relatedSearchComp) {
        super(0);
        this.this$0 = relatedSearchComp;
    }

    public final UniqueId invoke() {
        return this.this$0.token;
    }
}
