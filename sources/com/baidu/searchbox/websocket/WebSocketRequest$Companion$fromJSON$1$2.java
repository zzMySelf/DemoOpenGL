package com.baidu.searchbox.websocket;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: WebSocketRequest.kt */
final class WebSocketRequest$Companion$fromJSON$1$2 extends Lambda implements Function1<Integer, String> {
    final /* synthetic */ Ref.ObjectRef $protocolsArray;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebSocketRequest$Companion$fromJSON$1$2(Ref.ObjectRef objectRef) {
        super(1);
        this.$protocolsArray = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final String invoke(int it) {
        return ((JSONArray) this.$protocolsArray.element).getString(it);
    }
}
