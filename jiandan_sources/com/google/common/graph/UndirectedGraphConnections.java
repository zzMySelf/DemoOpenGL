package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    public final Map<N, V> adjacentNodeValues;

    public UndirectedGraphConnections(Map<N, V> map) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
    }

    public static <N, V> UndirectedGraphConnections<N, V> of() {
        return new UndirectedGraphConnections<>(new HashMap(2, 1.0f));
    }

    public static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> map) {
        return new UndirectedGraphConnections<>(ImmutableMap.copyOf(map));
    }

    public void addPredecessor(N n, V v) {
        addSuccessor(n, v);
    }

    public V addSuccessor(N n, V v) {
        return this.adjacentNodeValues.put(n, v);
    }

    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    public void removePredecessor(N n) {
        removeSuccessor(n);
    }

    public V removeSuccessor(N n) {
        return this.adjacentNodeValues.remove(n);
    }

    public Set<N> successors() {
        return adjacentNodes();
    }

    public V value(N n) {
        return this.adjacentNodeValues.get(n);
    }
}
