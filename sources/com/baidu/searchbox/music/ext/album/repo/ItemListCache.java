package com.baidu.searchbox.music.ext.album.repo;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH&J%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH&J\u0018\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH&¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/repo/ItemListCache;", "T", "", "addAfter", "", "anchor", "item", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "addFirst", "(Ljava/lang/Object;)Z", "addItems", "", "items", "", "getItemsFrom", "", "count", "", "(Ljava/lang/Object;I)Ljava/util/List;", "remove", "(Ljava/lang/Object;)V", "removeAll", "removeAllBut", "excludes", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemListCache.kt */
public interface ItemListCache<T> extends Iterable<T>, KMappedMarker {
    boolean addAfter(T t, T t2);

    boolean addFirst(T t);

    void addItems(Collection<? extends T> collection);

    List<T> getItemsFrom(T t, int i2);

    void remove(T t);

    void removeAll(Collection<? extends T> collection);

    void removeAllBut(Collection<? extends T> collection);
}
