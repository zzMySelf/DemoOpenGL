package com.baidu.searchbox.sport.page.live.event;

import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.page.live.model.PicTextLiveMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/sport/page/live/event/MsgImageClickEvent;", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "msg", "Lcom/baidu/searchbox/sport/page/live/model/PicTextLiveMessage;", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;Lcom/baidu/searchbox/sport/page/live/model/PicTextLiveMessage;)V", "getMsg", "()Lcom/baidu/searchbox/sport/page/live/model/PicTextLiveMessage;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MsgImageClickEvent.kt */
public final class MsgImageClickEvent {
    private final PicTextLiveMessage msg;
    private final UniqueId token;

    public MsgImageClickEvent(UniqueId token2, PicTextLiveMessage msg2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.token = token2;
        this.msg = msg2;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public final PicTextLiveMessage getMsg() {
        return this.msg;
    }
}
