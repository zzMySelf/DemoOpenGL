package com.baidu.searchbox.sport.scheme.olympic.match;

import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.ioc.ISportRenderStat;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatModel;
import com.baidu.searchbox.sport.statistic.SportStats;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/sport/scheme/olympic/match/MatchSchemeAction$preloadTabChatRoom$1", "Lrx/SingleSubscriber;", "Lcom/baidu/searchbox/sport/page/chatroom/model/SportChatModel;", "onError", "", "throwable", "", "onSuccess", "model", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MatchSchemeAction.kt */
public final class MatchSchemeAction$preloadTabChatRoom$1 extends SingleSubscriber<SportChatModel> {
    final /* synthetic */ UniqueId $token;

    MatchSchemeAction$preloadTabChatRoom$1(UniqueId $token2) {
        this.$token = $token2;
    }

    public void onSuccess(SportChatModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        SportStats.of(this.$token).setNaTabPrefetchEndTime(ISportRenderStat.Companion.getImpl().getTime());
    }

    public void onError(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }
}
