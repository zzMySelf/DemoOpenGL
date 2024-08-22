package com.baidu.searchbox.sport.page.olympic.schedule.filter.event;

import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/event/PageTabSelectedEvent;", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "isSchedule", "", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;Z)V", "()Z", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageTabSelectedEvent.kt */
public final class PageTabSelectedEvent {
    private final boolean isSchedule;
    private final UniqueId token;

    public PageTabSelectedEvent(UniqueId token2, boolean isSchedule2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
        this.isSchedule = isSchedule2;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public final boolean isSchedule() {
        return this.isSchedule;
    }
}
