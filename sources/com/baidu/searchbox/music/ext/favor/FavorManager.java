package com.baidu.searchbox.music.ext.favor;

import android.util.Log;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.music.ext.album.repo.MusicFavorApiService;
import com.baidu.searchbox.music.ext.debug.MusicExtDebugProviderKt;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.utils.MusicPreferences;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0007J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0007J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0007J\u0006\u0010 \u001a\u00020\bJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0003J\u0016\u0010\"\u001a\u00020\u00162\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\u0010\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0016J(\u0010)\u001a\u00020\u00162\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\bH\u0002J\"\u0010-\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\bH\u0007J(\u0010-\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR.\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\b0\u00100\u000f0\u000e0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/searchbox/music/ext/favor/FavorManager;", "", "()V", "favorApi", "Lcom/baidu/searchbox/music/ext/album/repo/MusicFavorApiService;", "favorCache", "", "", "", "favorChangeSubject", "Lrx/subjects/PublishSubject;", "getFavorChangeSubject", "()Lrx/subjects/PublishSubject;", "fetchingUris", "", "Ljava/lang/ref/WeakReference;", "Lrx/SingleSubscriber;", "subscription", "Lrx/subscriptions/CompositeSubscription;", "syncManager", "Lcom/baidu/searchbox/music/ext/favor/FavorSyncManager;", "clearCache", "", "fetchFavorOfNotCacheSongs", "songs", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "getFavorInfo", "Lrx/Single;", "Lcom/baidu/searchbox/music/ext/favor/SongFavorInfo;", "song", "isFavor", "isShowedPersonalCenterNav", "isSingleSongFavor", "onRemoveAllBut", "excludes", "showPersonalCenterNav", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "subscribeSyncChange", "unsubscribeSyncChange", "updateCacheByUri", "songUris", "isFavored", "notifySync", "updateFavorCache", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorManager.kt */
public final class FavorManager {
    public static final FavorManager INSTANCE = new FavorManager();
    private static final MusicFavorApiService favorApi = new MusicFavorApiService();
    private static final Map<String, Boolean> favorCache = new LinkedHashMap();
    private static final PublishSubject<Boolean> favorChangeSubject;
    private static final Map<String, List<WeakReference<SingleSubscriber<? super Boolean>>>> fetchingUris = new LinkedHashMap();
    private static final CompositeSubscription subscription = new CompositeSubscription();
    private static final FavorSyncManager syncManager = new FavorSyncManager();

    private FavorManager() {
    }

    static {
        PublishSubject<Boolean> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Boolean>()");
        favorChangeSubject = create;
    }

    public final PublishSubject<Boolean> getFavorChangeSubject() {
        return favorChangeSubject;
    }

    public final Single<Boolean> isFavor(ISong song) {
        Intrinsics.checkNotNullParameter(song, "song");
        return isSingleSongFavor(song);
    }

    public final Single<SongFavorInfo> getFavorInfo(ISong song) {
        Intrinsics.checkNotNullParameter(song, "song");
        return favorApi.getFavorInfo(song);
    }

    private final Single<Boolean> isSingleSongFavor(ISong song) {
        String songUri = song.getUri();
        Intrinsics.checkNotNullExpressionValue(songUri, "song.uri");
        Boolean cache = favorCache.get(songUri);
        Map<String, List<WeakReference<SingleSubscriber<? super Boolean>>>> map = fetchingUris;
        List subscribers = map.get(songUri);
        if (cache != null) {
            Single<Boolean> just = Single.just(cache);
            Intrinsics.checkNotNullExpressionValue(just, "just(cache)");
            return just;
        } else if (subscribers != null) {
            Single<Boolean> create = Single.create(new FavorManager$$ExternalSyntheticLambda0(subscribers));
            Intrinsics.checkNotNullExpressionValue(create, "create<Boolean> { subscr….add(WeakReference(it)) }");
            return create;
        } else {
            map.put(songUri, new ArrayList(1));
            Single<R> map2 = favorApi.isFavored(song).doOnError(new FavorManager$$ExternalSyntheticLambda1(songUri)).map(new FavorManager$$ExternalSyntheticLambda2(songUri));
            Intrinsics.checkNotNullExpressionValue(map2, "{\n                fetchi…          }\n            }");
            return map2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: isSingleSongFavor$lambda-0  reason: not valid java name */
    public static final void m1027isSingleSongFavor$lambda0(List $subscribers, SingleSubscriber it) {
        $subscribers.add(new WeakReference(it));
    }

    /* access modifiers changed from: private */
    /* renamed from: isSingleSongFavor$lambda-2  reason: not valid java name */
    public static final void m1028isSingleSongFavor$lambda2(String $songUri, Throwable throwable) {
        Intrinsics.checkNotNullParameter($songUri, "$songUri");
        List<WeakReference> $this$forEach$iv = fetchingUris.remove($songUri);
        if ($this$forEach$iv != null) {
            for (WeakReference it : $this$forEach$iv) {
                SingleSubscriber singleSubscriber = (SingleSubscriber) it.get();
                if (singleSubscriber != null) {
                    singleSubscriber.onError(throwable);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: isSingleSongFavor$lambda-4  reason: not valid java name */
    public static final Boolean m1029isSingleSongFavor$lambda4(String $songUri, Boolean result) {
        Intrinsics.checkNotNullParameter($songUri, "$songUri");
        Map<String, Boolean> map = favorCache;
        Intrinsics.checkNotNullExpressionValue(result, "result");
        map.put($songUri, result);
        List<WeakReference> $this$forEach$iv = fetchingUris.remove($songUri);
        if ($this$forEach$iv != null) {
            for (WeakReference it : $this$forEach$iv) {
                SingleSubscriber singleSubscriber = (SingleSubscriber) it.get();
                if (singleSubscriber != null) {
                    singleSubscriber.onSuccess(result);
                }
            }
        }
        return result;
    }

    public final void fetchFavorOfNotCacheSongs(List<? extends ISong> songs) {
        Intrinsics.checkNotNullParameter(songs, "songs");
        List<ISong> notInCache = new ArrayList<>();
        for (ISong it : songs) {
            if (favorCache.get(it.getUri()) == null) {
                notInCache.add(it);
            }
        }
        if (!notInCache.isEmpty()) {
            for (ISong it2 : notInCache) {
                Map<String, List<WeakReference<SingleSubscriber<? super Boolean>>>> map = fetchingUris;
                if (map.get(it2.getUri()) == null) {
                    String uri = it2.getUri();
                    Intrinsics.checkNotNullExpressionValue(uri, "it.uri");
                    map.put(uri, new ArrayList(1));
                }
            }
            favorApi.isFavored((List<? extends ISong>) notInCache).map(new FavorManager$$ExternalSyntheticLambda5(notInCache)).subscribe(new FavorManager$$ExternalSyntheticLambda6(), new FavorManager$$ExternalSyntheticLambda7());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchFavorOfNotCacheSongs$lambda-9  reason: not valid java name */
    public static final Map m1026fetchFavorOfNotCacheSongs$lambda9(List $notInCache, Map result) {
        List<ISong> $this$forEach$iv = $notInCache;
        Map map = result;
        Intrinsics.checkNotNullParameter($this$forEach$iv, "$notInCache");
        Map<String, Boolean> map2 = favorCache;
        Intrinsics.checkNotNullExpressionValue(map, "result");
        map2.putAll(map);
        for (ISong song : $this$forEach$iv) {
            List<WeakReference> $this$forEach$iv2 = fetchingUris.remove(song.getUri());
            if ($this$forEach$iv2 != null) {
                for (WeakReference it : $this$forEach$iv2) {
                    SingleSubscriber singleSubscriber = (SingleSubscriber) it.get();
                    if (singleSubscriber != null) {
                        Boolean bool = favorCache.get(song.getUri());
                        singleSubscriber.onSuccess(Boolean.valueOf(bool != null ? bool.booleanValue() : false));
                    }
                    List list = $notInCache;
                }
            }
            List list2 = $notInCache;
        }
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchFavorOfNotCacheSongs$lambda-10  reason: not valid java name */
    public static final void m1024fetchFavorOfNotCacheSongs$lambda10(Map it) {
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchFavorOfNotCacheSongs$lambda-11  reason: not valid java name */
    public static final void m1025fetchFavorOfNotCacheSongs$lambda11(Throwable it) {
    }

    public final void subscribeSyncChange() {
        CompositeSubscription compositeSubscription = subscription;
        compositeSubscription.clear();
        compositeSubscription.add(syncManager.getFavorChangeObserver().subscribe(new FavorManager$$ExternalSyntheticLambda3(), (Action1<Throwable>) new FavorManager$$ExternalSyntheticLambda4()));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSyncChange$lambda-12  reason: not valid java name */
    public static final void m1030subscribeSyncChange$lambda12(FavorChannelData data) {
        INSTANCE.updateCacheByUri(CollectionsKt.listOf(data.getUri()), data.isFavored(), false);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSyncChange$lambda-13  reason: not valid java name */
    public static final void m1031subscribeSyncChange$lambda13(Throwable e2) {
        if (MusicExtDebugProviderKt.getDEBUG()) {
            Log.e("MusicFavorManager", "FavorSyncManager.favorChangeObserver error: " + e2);
        }
    }

    public final void unsubscribeSyncChange() {
        subscription.clear();
    }

    public static /* synthetic */ void updateFavorCache$default(FavorManager favorManager, ISong iSong, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        favorManager.updateFavorCache(iSong, z, z2);
    }

    public final void updateFavorCache(ISong song, boolean isFavored, boolean notifySync) {
        Intrinsics.checkNotNullParameter(song, "song");
        updateCacheByUri(CollectionsKt.listOf(song.getUri()), isFavored, notifySync);
    }

    public static /* synthetic */ void updateFavorCache$default(FavorManager favorManager, List list, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        favorManager.updateFavorCache((List<? extends ISong>) list, z, z2);
    }

    public final void updateFavorCache(List<? extends ISong> songs, boolean isFavored, boolean notifySync) {
        Intrinsics.checkNotNullParameter(songs, "songs");
        Iterable<ISong> $this$map$iv = songs;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (ISong it : $this$map$iv) {
            String uri = it.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "it.uri");
            destination$iv$iv.add(uri);
        }
        updateCacheByUri((List) destination$iv$iv, isFavored, notifySync);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        if (r0 == null) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onRemoveAllBut(java.util.List<? extends com.baidu.searchbox.music.ext.model.ISong> r16) {
        /*
            r15 = this;
            if (r16 == 0) goto L_0x003c
            r0 = r16
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            r3 = r0
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
        L_0x001a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0030
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.baidu.searchbox.music.ext.model.ISong r7 = (com.baidu.searchbox.music.ext.model.ISong) r7
            r8 = 0
            java.lang.String r7 = r7.getUri()
            r2.add(r7)
            goto L_0x001a
        L_0x0030:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r2)
            if (r0 != 0) goto L_0x0040
        L_0x003c:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x0040:
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = favorCache
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = r1
            r5 = 0
            r6 = r4
            r7 = 0
            java.util.Set r8 = r6.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0056:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0081
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            r10 = r9
            r11 = 0
            r12 = r10
            r13 = 0
            java.lang.Object r14 = r12.getKey()
            boolean r14 = r0.contains(r14)
            if (r14 == 0) goto L_0x0072
            r14 = 0
            goto L_0x0078
        L_0x0072:
            java.lang.Object r14 = r12.getKey()
            java.lang.String r14 = (java.lang.String) r14
        L_0x0078:
            if (r14 == 0) goto L_0x0080
            r12 = r14
            r13 = 0
            r3.add(r12)
            goto L_0x0056
        L_0x0080:
            goto L_0x0056
        L_0x0081:
            java.util.List r3 = (java.util.List) r3
            r1 = r3
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            r3 = 0
            r4 = 1
            r5 = r15
            r15.updateCacheByUri(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.music.ext.favor.FavorManager.onRemoveAllBut(java.util.List):void");
    }

    static /* synthetic */ void updateCacheByUri$default(FavorManager favorManager, List list, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        favorManager.updateCacheByUri(list, z, z2);
    }

    private final void updateCacheByUri(List<String> songUris, boolean isFavored, boolean notifySync) {
        boolean hasChange = false;
        for (String it : songUris) {
            Map<String, Boolean> map = favorCache;
            map.put(it, Boolean.valueOf(isFavored));
            if (!Intrinsics.areEqual((Object) map.get(it), (Object) Boolean.valueOf(isFavored))) {
                hasChange = true;
            }
        }
        if (notifySync) {
            syncManager.notifyFavorChanged(songUris, isFavored);
        }
        if (hasChange) {
            favorChangeSubject.onNext(true);
        }
    }

    public final void clearCache() {
        favorCache.clear();
        favorChangeSubject.onNext(true);
    }

    public final boolean isShowedPersonalCenterNav() {
        return MusicPreferences.INSTANCE.getBoolean(FavorManagerKt.PERSONAL_CENTER_FAVOR_NAV_KEY, false);
    }

    public final void showPersonalCenterNav(UniqueId token) {
        if (token != null) {
            BdEventBus.Companion.getDefault().post(new PersonalCenterFavorNavEvent(token));
        }
    }
}
