package com.baidu.live.feedplayer;

import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.feedplayer.base.MediaSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/live/feedplayer/LiveFeedPlayerPool;", "", "()V", "MAX_PLAYER_COUNT", "", "TAG", "", "playerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/live/feedplayer/LiveFeedPlayer;", "obtainPlayer", "roomId", "pageId", "release", "", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFeedPlayerPool.kt */
public final class LiveFeedPlayerPool {
    public static final LiveFeedPlayerPool INSTANCE = new LiveFeedPlayerPool();
    private static final int MAX_PLAYER_COUNT = 2;
    private static final String TAG = "LiveFeedPlayerPool";
    private static final ConcurrentHashMap<String, List<LiveFeedPlayer>> playerMap = new ConcurrentHashMap<>();

    @JvmStatic
    public static final LiveFeedPlayer obtainPlayer(String str) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        return obtainPlayer$default((String) null, str, 1, (Object) null);
    }

    private LiveFeedPlayerPool() {
    }

    public static /* synthetic */ LiveFeedPlayer obtainPlayer$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return obtainPlayer(str, str2);
    }

    @JvmStatic
    public static final LiveFeedPlayer obtainPlayer(String roomId, String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        StringBuilder append = new StringBuilder().append("getPlayer pageId= ").append(pageId).append(' ');
        ConcurrentHashMap<String, List<LiveFeedPlayer>> concurrentHashMap = playerMap;
        LiveFeedPageSdk.liveLog(TAG, append.append(concurrentHashMap.size()).toString());
        Object playerList = concurrentHashMap.get(pageId);
        if (playerList == null) {
            playerList = (List) new ArrayList();
        }
        if (((List) playerList).isEmpty() || ((List) playerList).size() < 2) {
            LiveFeedPlayer it = new LiveFeedPlayer(new MediaSource(roomId, 0, (HashMap) null, (HashMap) null, 14, (DefaultConstructorMarker) null));
            ((List) playerList).add(it);
            concurrentHashMap.put(pageId, playerList);
            return it;
        }
        LiveFeedPlayer player = (LiveFeedPlayer) ((List) playerList).get(0);
        Collections.swap((List) playerList, 0, 1);
        if (player.isPlaying()) {
            player.detachFromContainer();
            player.stop();
        }
        LiveFeedPageSdk.liveLog(TAG, "getPlayer " + player);
        return player;
    }

    @JvmStatic
    public static final void release(String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        StringBuilder append = new StringBuilder().append("release playerMap= ");
        ConcurrentHashMap<String, List<LiveFeedPlayer>> concurrentHashMap = playerMap;
        LiveFeedPageSdk.liveLog(TAG, append.append(concurrentHashMap.size()).toString());
        List<LiveFeedPlayer> playerList = concurrentHashMap.get(pageId);
        Collection collection = playerList;
        if (!(collection == null || collection.isEmpty())) {
            for (LiveFeedPlayer player : playerList) {
                player.detachFromContainer();
                player.release();
            }
            playerList.clear();
            playerMap.remove(pageId);
        }
    }
}
