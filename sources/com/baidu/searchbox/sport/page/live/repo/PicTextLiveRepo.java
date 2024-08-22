package com.baidu.searchbox.sport.page.live.repo;

import android.util.Log;
import androidx.collection.LruCache;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.page.chatroom.model.WenBaiduMessage;
import com.baidu.searchbox.sport.page.live.model.PicTextLiveMessage;
import com.baidu.searchbox.sport.page.live.model.PicTextLiveModel;
import com.baidu.searchbox.sport.page.live.repo.bim.BimLiveService;
import com.baidu.searchbox.sport.page.live.repo.restful.RestfulLiveService;
import com.baidu.searchbox.sport.utils.TokenOwner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;

public final class PicTextLiveRepo {
    private static final LruCache<String, PicTextLiveRepo> CACHED_REPOS = new LruCache<>(3);
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final Map<String, PicTextLiveRepo> PRE_CREATED = new HashMap();
    private static final String TAG = "PicTextLiveRepo";
    private boolean isReleased = false;
    private final ILiveService liveService;

    public static PicTextLiveRepo of(String matchId, long liveId, boolean isOlympic, boolean liveBimFinish) {
        String key = makeCacheKey(matchId, liveId, isOlympic, liveBimFinish);
        Map<String, PicTextLiveRepo> map = PRE_CREATED;
        PicTextLiveRepo repo = map.remove(key);
        map.clear();
        if (repo == null) {
            repo = CACHED_REPOS.get(key);
        } else {
            LruCache<String, PicTextLiveRepo> lruCache = CACHED_REPOS;
            if (lruCache.get(key) == null) {
                lruCache.put(key, repo);
            }
        }
        if (repo == null) {
            PicTextLiveRepo repo2 = new PicTextLiveRepo(matchId, liveId, isOlympic, liveBimFinish);
            CACHED_REPOS.put(key, repo2);
            return repo2;
        } else if (!DEBUG) {
            return repo;
        } else {
            UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "预加载成功，图文直播").show();
            return repo;
        }
    }

    public static PicTextLiveRepo preCreate(String matchId, long liveId, boolean isOlympic) {
        String key = makeCacheKey(matchId, liveId, isOlympic, false);
        Map<String, PicTextLiveRepo> map = PRE_CREATED;
        map.remove(key);
        PicTextLiveRepo repo = new PicTextLiveRepo(matchId, liveId, isOlympic, false);
        map.put(key, repo);
        return repo;
    }

    private static String makeCacheKey(String matchId, long liveId, boolean isOlympic, boolean liveBimFinish) {
        StringBuilder builder = new StringBuilder().append(matchId).append("___").append(liveId).append("___").append(isOlympic);
        if (liveId != -1) {
            builder.append("___").append(liveBimFinish);
        }
        return builder.toString();
    }

    private PicTextLiveRepo(String matchId, long liveId, boolean isOlympic, boolean liveBimFinish) {
        boolean useBim = false;
        if (liveId != -1 ? true : useBim) {
            this.liveService = new BimLiveService(AppRuntime.getAppContext(), liveId, isOlympic, liveBimFinish);
        } else {
            this.liveService = new RestfulLiveService(matchId, isOlympic);
        }
    }

    public void setToken(UniqueId token) {
        ILiveService iLiveService = this.liveService;
        if (iLiveService instanceof TokenOwner) {
            ((TokenOwner) iLiveService).setToken(token);
        }
    }

    public Observable<List<PicTextLiveMessage>> onNewMessageReceived() {
        return this.liveService.getOnNewMessageReceived();
    }

    public Observable<List<Long>> onMessageDeleted() {
        return this.liveService.getOnMessageDeleted();
    }

    public Observable<List<PicTextLiveMessage>> onStickMessageChanged() {
        return this.liveService.getOnStickMessageChanged();
    }

    public Single<PicTextLiveModel> getHistoryMessages(PicTextLiveMessage eldest) {
        if (eldest == null) {
            return this.liveService.getInitialMessages();
        }
        return this.liveService.getHistoryMessages(eldest);
    }

    public Single<PicTextLiveModel> getMessagesAfter(PicTextLiveMessage anchor) {
        if (anchor == null) {
            return this.liveService.getInitialMessages();
        }
        return this.liveService.getNewMessages(anchor);
    }

    public Observable<List<WenBaiduMessage>> onWenBaiduMessageReceived() {
        ILiveService iLiveService = this.liveService;
        if (iLiveService instanceof BimLiveService) {
            return ((BimLiveService) iLiveService).getOnWenBaiduMessageReceived();
        }
        return null;
    }

    public Single<List<WenBaiduMessage>> getWenBaiduHistoryMessage() {
        ILiveService iLiveService = this.liveService;
        if (iLiveService instanceof BimLiveService) {
            return ((BimLiveService) iLiveService).getWenBaiduHistoryMessage();
        }
        return null;
    }

    public void preloadPicText(SingleSubscriber<PicTextLiveModel> subscriber) {
        ILiveService iLiveService = this.liveService;
        if (iLiveService instanceof PicTextLivePreloadable) {
            ((PicTextLivePreloadable) iLiveService).preloadPicTextLive(subscriber);
        } else {
            subscriber.onError(new Throwable("preload unsupported"));
        }
    }

    public void release() {
        if (!this.isReleased) {
            this.liveService.release();
            removeFromCache();
            this.isReleased = true;
        }
    }

    private void removeFromCache() {
        for (String key : CACHED_REPOS.snapshot().keySet()) {
            LruCache<String, PicTextLiveRepo> lruCache = CACHED_REPOS;
            if (lruCache.get(key) == this) {
                lruCache.remove(key);
                if (DEBUG) {
                    Log.d(TAG, "remove repo from cache:" + key);
                    return;
                }
                return;
            }
        }
    }
}
