package com.baidu.chatsearch.aisearch.resultpage.graph.intercept;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchBlockImageUtils.kt */
final class ChatSearchBlockImageUtils$shouldInterceptRequest$8$2$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $urlStr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatSearchBlockImageUtils$shouldInterceptRequest$8$2$1(String str) {
        super(0);
        this.$urlStr = str;
    }

    public final String invoke() {
        return "CHATSEARCH 图片拦截成功，返回真实图片 " + this.$urlStr;
    }
}
