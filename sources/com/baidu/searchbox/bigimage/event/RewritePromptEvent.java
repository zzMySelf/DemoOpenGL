package com.baidu.searchbox.bigimage.event;

import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/bigimage/event/RewritePromptEvent;", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "action", "", "prompt", "", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;ILjava/lang/String;)V", "getAction", "()I", "getPrompt", "()Ljava/lang/String;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewritePromptEvent.kt */
public final class RewritePromptEvent {
    private final int action;
    private final String prompt;
    private final UniqueId token;

    public RewritePromptEvent(UniqueId token2, int action2, String prompt2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(prompt2, "prompt");
        this.token = token2;
        this.action = action2;
        this.prompt = prompt2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewritePromptEvent(UniqueId uniqueId, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(uniqueId, (i3 & 2) != 0 ? 4728 : i2, (i3 & 4) != 0 ? "" : str);
    }

    public final int getAction() {
        return this.action;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final UniqueId getToken() {
        return this.token;
    }
}
