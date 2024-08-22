package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    public final Map<E, N> inEdgeMap;
    public final Map<E, N> outEdgeMap;
    public int selfLoopCount;

    public AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i2) {
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i2);
        Preconditions.checkState(i2 <= map.size() && i2 <= map2.size());
    }

    public void addInEdge(E e, N n, boolean z) {
        boolean z2 = true;
        if (z) {
            int i2 = this.selfLoopCount + 1;
            this.selfLoopCount = i2;
            Graphs.checkPositive(i2);
        }
        if (this.inEdgeMap.put(e, n) != null) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }

    public void addOutEdge(E e, N n) {
        Preconditions.checkState(this.outEdgeMap.put(e, n) == null);
    }

    public N adjacentNode(E e) {
        return Preconditions.checkNotNull(this.outEdgeMap.get(e));
    }

    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    public Set<E> incidentEdges() {
        return new AbstractSet<E>() {
            public boolean contains(@NullableDecl Object obj) {
                return AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj);
            }

            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }

            public UnmodifiableIterator<E> iterator() {
                Iterable<T> iterable;
                if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
                    iterable = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                } else {
                    iterable = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                }
                return Iterators.unmodifiableIterator(iterable.iterator());
            }
        };
    }

    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    public N removeInEdge(E e, boolean z) {
        if (z) {
            int i2 = this.selfLoopCount - 1;
            this.selfLoopCount = i2;
            Graphs.checkNonNegative(i2);
        }
        return Preconditions.checkNotNull(this.inEdgeMap.remove(e));
    }

    public N removeOutEdge(E e) {
        return Preconditions.checkNotNull(this.outEdgeMap.remove(e));
    }
}
