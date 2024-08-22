package com.baidu.chatsearch.status;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/chatsearch/status/ChatSearchStatus;", "", "()V", "jumpFromGraph", "", "getJumpFromGraph", "()Z", "setJumpFromGraph", "(Z)V", "lib-chatsearch-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchStatus.kt */
public final class ChatSearchStatus {
    public static final ChatSearchStatus INSTANCE = new ChatSearchStatus();
    private static boolean jumpFromGraph;

    private ChatSearchStatus() {
    }

    public final boolean getJumpFromGraph() {
        return jumpFromGraph;
    }

    public final void setJumpFromGraph(boolean z) {
        jumpFromGraph = z;
    }
}
