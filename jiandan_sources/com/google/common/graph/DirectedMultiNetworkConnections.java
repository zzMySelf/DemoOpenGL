package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    @LazyInit
    public transient Reference<Multiset<N>> predecessorsReference;
    @LazyInit
    public transient Reference<Multiset<N>> successorsReference;

    public DirectedMultiNetworkConnections(Map<E, N> map, Map<E, N> map2, int i2) {
        super(map, map2, i2);
    }

    @NullableDecl
    public static <T> T getReference(@NullableDecl Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> DirectedMultiNetworkConnections<N, E> of() {
        return new DirectedMultiNetworkConnections<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    public static <N, E> DirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> map, Map<E, N> map2, int i2) {
        return new DirectedMultiNetworkConnections<>(ImmutableMap.copyOf(map), ImmutableMap.copyOf(map2), i2);
    }

    private Multiset<N> predecessorsMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset<N> create = HashMultiset.create(this.inEdgeMap.values());
        this.predecessorsReference = new SoftReference(create);
        return create;
    }

    /* access modifiers changed from: private */
    public Multiset<N> successorsMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset<N> create = HashMultiset.create(this.outEdgeMap.values());
        this.successorsReference = new SoftReference(create);
        return create;
    }

    public void addInEdge(E e, N n, boolean z) {
        super.addInEdge(e, n, z);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n));
        }
    }

    public void addOutEdge(E e, N n) {
        super.addOutEdge(e, n);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n));
        }
    }

    public Set<E> edgesConnecting(final N n) {
        return new MultiEdgesConnecting<E>(this.outEdgeMap, n) {
            public int size() {
                return DirectedMultiNetworkConnections.this.successorsMultiset().count(n);
            }
        };
    }

    public Set<N> predecessors() {
        return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
    }

    public N removeInEdge(E e, boolean z) {
        N removeInEdge = super.removeInEdge(e, z);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeInEdge));
        }
        return removeInEdge;
    }

    public N removeOutEdge(E e) {
        N removeOutEdge = super.removeOutEdge(e);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeOutEdge));
        }
        return removeOutEdge;
    }

    public Set<N> successors() {
        return Collections.unmodifiableSet(successorsMultiset().elementSet());
    }
}
