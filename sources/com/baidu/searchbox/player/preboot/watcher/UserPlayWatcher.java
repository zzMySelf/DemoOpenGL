package com.baidu.searchbox.player.preboot.watcher;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.card.util.CardConstants;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.BasicVideoSeriesExt;
import com.baidu.searchbox.player.preboot.env.PrebootRuntimeKt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u00060\u0005j\u0002`\r2\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u000f2\u000e\u0010\u0010\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0011H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/player/preboot/watcher/UserPlayWatcher;", "", "()V", "playInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/searchbox/player/preboot/watcher/UserPlayInfo;", "getPlayInfoCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "playInfoCache$delegate", "Lkotlin/Lazy;", "getUseInfo", "from", "Lcom/baidu/searchbox/player/env/From;", "page", "Lcom/baidu/searchbox/player/env/Page;", "source", "Lcom/baidu/searchbox/player/env/Source;", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "preboot_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserPlayWatcher.kt */
public final class UserPlayWatcher {
    public static final UserPlayWatcher INSTANCE = new UserPlayWatcher();
    private static final Lazy playInfoCache$delegate = LazyKt.lazy(UserPlayWatcher$playInfoCache$2.INSTANCE);

    private UserPlayWatcher() {
    }

    private final ConcurrentHashMap<String, UserPlayInfo> getPlayInfoCache() {
        return (ConcurrentHashMap) playInfoCache$delegate.getValue();
    }

    @StableApi
    public final UserPlayInfo getUseInfo(BasicVideoSeries series) {
        Intrinsics.checkNotNullParameter(series, CardConstants.CARD_ITEM_FOLLOW_SERIES);
        return getUseInfo(BasicVideoSeriesExt.component1(series), BasicVideoSeriesExt.component2(series), BasicVideoSeriesExt.component3(series));
    }

    @StableApi
    public final UserPlayInfo getUseInfo(String from, String page, String source) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(page, "page");
        String key = PrebootRuntimeKt.getSceneKey(from, page, source);
        UserPlayInfo playInfo = getPlayInfoCache().get(key);
        if (playInfo != null) {
            return playInfo;
        }
        UserPlayInfo playInfo2 = new UserPlayInfo();
        getPlayInfoCache().put(key, playInfo2);
        return playInfo2;
    }
}
