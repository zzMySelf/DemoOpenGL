package com.baidu.searchbox.music.ext.album.repo.collectstate;

import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import com.baidu.searchbox.music.ext.model.ISong;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u00130\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H\u0007J\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H\u0003J\u001e\u0010\u0018\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010\u0019\u001a\u00020\nH\u0007J\u0016\u0010\u001a\u001a\u00020\u00102\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016J\u001e\u0010\u001c\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0019\u001a\u00020\nH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R.\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\n0\u000e0\r0\f0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/repo/collectstate/CollectStateBySingleAlbum;", "", "album", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "(Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;)V", "api", "Lcom/baidu/searchbox/music/ext/album/repo/collectstate/CollectStateApi;", "cache", "", "", "", "fetchingUris", "", "Ljava/lang/ref/WeakReference;", "Lrx/SingleSubscriber;", "clearCache", "", "getCollectState", "Lrx/Single;", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "songs", "", "getCollectStateFromCache", "setCollectState", "isCollected", "setNotCollectedExcept", "excludes", "syncCollectStateByUri", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectStateManager.kt */
final class CollectStateBySingleAlbum {
    private final MusicAlbum album;
    private final CollectStateApi api = new CollectStateApi();
    private final Map<String, Boolean> cache = new LinkedHashMap();
    private final Map<String, List<WeakReference<SingleSubscriber<? super Boolean>>>> fetchingUris = new LinkedHashMap();

    public CollectStateBySingleAlbum(MusicAlbum album2) {
        Intrinsics.checkNotNullParameter(album2, "album");
        this.album = album2;
    }

    public final Single<Map<ISong, Boolean>> getCollectState(List<? extends ISong> songs) {
        Intrinsics.checkNotNullParameter(songs, "songs");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : songs) {
            if (true ^ this.cache.containsKey(((ISong) element$iv$iv).getUri())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List<ISong> notCached = (List) destination$iv$iv;
        if (!notCached.isEmpty()) {
            for (ISong it : notCached) {
                Map $this$getOrPut$iv = this.fetchingUris;
                Object key$iv = it.getUri();
                Intrinsics.checkNotNullExpressionValue(key$iv, "it.uri");
                if ($this$getOrPut$iv.get(key$iv) == null) {
                    $this$getOrPut$iv.put(key$iv, (List) new ArrayList(1));
                }
            }
            Single<R> map = this.api.getCollectState(notCached, this.album).map(new CollectStateBySingleAlbum$$ExternalSyntheticLambda0(this, notCached, songs));
            Intrinsics.checkNotNullExpressionValue(map, "{\n            notCached.…)\n            }\n        }");
            return map;
        }
        Single<Map<ISong, Boolean>> just = Single.just(getCollectStateFromCache(songs));
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Single.jus…omCache(songs))\n        }");
        return just;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCollectState$lambda-5  reason: not valid java name */
    public static final Map m981getCollectState$lambda5(CollectStateBySingleAlbum this$0, List $notCached, List $songs, Map result) {
        CollectStateBySingleAlbum collectStateBySingleAlbum = this$0;
        List list = $notCached;
        List list2 = $songs;
        Map map = result;
        Intrinsics.checkNotNullParameter(collectStateBySingleAlbum, "this$0");
        Intrinsics.checkNotNullParameter(list, "$notCached");
        Intrinsics.checkNotNullParameter(list2, "$songs");
        Map<String, Boolean> map2 = collectStateBySingleAlbum.cache;
        Intrinsics.checkNotNullExpressionValue(map, "result");
        map2.putAll(map);
        Iterable<ISong> $this$forEach$iv = list;
        for (ISong song : $this$forEach$iv) {
            List<WeakReference> $this$forEach$iv2 = collectStateBySingleAlbum.fetchingUris.remove(song.getUri());
            if ($this$forEach$iv2 != null) {
                for (WeakReference it : $this$forEach$iv2) {
                    SingleSubscriber singleSubscriber = (SingleSubscriber) it.get();
                    if (singleSubscriber != null) {
                        Iterable $this$forEach$iv3 = $this$forEach$iv;
                        Boolean bool = collectStateBySingleAlbum.cache.get(song.getUri());
                        singleSubscriber.onSuccess(Boolean.valueOf(bool != null ? bool.booleanValue() : false));
                        List list3 = $notCached;
                        Map map3 = result;
                        $this$forEach$iv = $this$forEach$iv3;
                    } else {
                        List list4 = $notCached;
                        Map map4 = result;
                    }
                }
            }
            List list5 = $notCached;
            Map map5 = result;
            $this$forEach$iv = $this$forEach$iv;
        }
        return collectStateBySingleAlbum.getCollectStateFromCache(list2);
    }

    private final Map<ISong, Boolean> getCollectStateFromCache(List<? extends ISong> songs) {
        Map linkedHashMap = new LinkedHashMap();
        Map $this$getCollectStateFromCache_u24lambda_u2d7 = linkedHashMap;
        for (ISong song : songs) {
            Boolean bool = this.cache.get(song.getUri());
            $this$getCollectStateFromCache_u24lambda_u2d7.put(song, Boolean.valueOf(bool != null ? bool.booleanValue() : false));
        }
        return linkedHashMap;
    }

    public final void setCollectState(List<? extends ISong> songs, boolean isCollected) {
        Intrinsics.checkNotNullParameter(songs, "songs");
        for (ISong it : songs) {
            Map<String, Boolean> map = this.cache;
            String uri = it.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "it.uri");
            map.put(uri, Boolean.valueOf(isCollected));
        }
    }

    private final void syncCollectStateByUri(List<String> songs, boolean isCollected) {
        for (String it : songs) {
            Boolean valueOf = Boolean.valueOf(isCollected);
            this.cache.put(it, valueOf);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0039, code lost:
        if (r0 == null) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setNotCollectedExcept(java.util.List<? extends com.baidu.searchbox.music.ext.model.ISong> r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x003b
            r0 = r10
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
        L_0x0019:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x002f
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.baidu.searchbox.music.ext.model.ISong r7 = (com.baidu.searchbox.music.ext.model.ISong) r7
            r8 = 0
            java.lang.String r7 = r7.getUri()
            r2.add(r7)
            goto L_0x0019
        L_0x002f:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r2)
            if (r0 != 0) goto L_0x003f
        L_0x003b:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x003f:
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = r9.cache
            java.util.Set r1 = r1.keySet()
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r1 = kotlin.collections.SetsKt.minus(r1, r2)
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            r3 = 0
            r9.syncCollectStateByUri(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.music.ext.album.repo.collectstate.CollectStateBySingleAlbum.setNotCollectedExcept(java.util.List):void");
    }

    public final void clearCache() {
        this.cache.clear();
    }
}
