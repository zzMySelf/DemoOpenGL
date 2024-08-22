package com.baidu.searchbox.sport.olympic.team;

import com.baidu.searchbox.sport.page.base.AbsRetainPolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/sport/olympic/team/TeamComp$onCreateRetainPolicy$1", "Lcom/baidu/searchbox/sport/page/base/AbsRetainPolicy;", "isRetainable", "", "index", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeamComp.kt */
public final class TeamComp$onCreateRetainPolicy$1 extends AbsRetainPolicy {
    final /* synthetic */ TeamComp this$0;

    TeamComp$onCreateRetainPolicy$1(TeamComp $receiver) {
        this.this$0 = $receiver;
    }

    public boolean isRetainable(int index) {
        return ((TeamViewModel) this.this$0.getViewModel()).isNaTab(index);
    }
}
