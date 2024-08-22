package com.baidu.searchbox.kmm.foundation.concurrent.collections;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0005R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/kmm/foundation/concurrent/collections/MutableSetWrapper;", "E", "Lcom/baidu/searchbox/kmm/foundation/concurrent/collections/MutableCollectionWrapper;", "", "set", "(Ljava/util/Set;)V", "getSet$com_baidu_searchbox_kmm_foundation_concurrent", "()Ljava/util/Set;", "setSet$com_baidu_searchbox_kmm_foundation_concurrent", "com.baidu.searchbox.kmm.foundation.concurrent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConcurrentMutableSet.kt */
public final class MutableSetWrapper<E> extends MutableCollectionWrapper<E> implements Set<E>, KMutableSet {
    private Set<E> set;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableSetWrapper(Set<E> set2) {
        super(set2);
        Intrinsics.checkNotNullParameter(set2, "set");
        this.set = set2;
    }

    public final Set<E> getSet$com_baidu_searchbox_kmm_foundation_concurrent() {
        return this.set;
    }

    public final void setSet$com_baidu_searchbox_kmm_foundation_concurrent(Set<E> set2) {
        Intrinsics.checkNotNullParameter(set2, "<set-?>");
        this.set = set2;
    }
}
