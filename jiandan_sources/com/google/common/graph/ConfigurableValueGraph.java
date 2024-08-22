package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
    public final boolean allowsSelfLoops;
    public long edgeCount;
    public final boolean isDirected;
    public final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    public final ElementOrder<N> nodeOrder;

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or(10).intValue()), 0);
    }

    public Set<N> adjacentNodes(N n) {
        return checkedConnections(n).adjacentNodes();
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final GraphConnections<N, V> checkedConnections(N n) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n);
        throw new IllegalArgumentException("Node " + n + " is not an element of this graph.");
    }

    public final boolean containsNode(@NullableDecl N n) {
        return this.nodeConnections.containsKey(n);
    }

    public long edgeCount() {
        return this.edgeCount;
    }

    @NullableDecl
    public V edgeValueOrDefault(N n, N n2, @NullableDecl V v) {
        return edgeValueOrDefault_internal(Preconditions.checkNotNull(n), Preconditions.checkNotNull(n2), v);
    }

    public final V edgeValueOrDefault_internal(N n, N n2, V v) {
        V v2;
        GraphConnections graphConnections = this.nodeConnections.get(n);
        if (graphConnections == null) {
            v2 = null;
        } else {
            v2 = graphConnections.value(n2);
        }
        return v2 == null ? v : v2;
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        return hasEdgeConnecting_internal(Preconditions.checkNotNull(n), Preconditions.checkNotNull(n2));
    }

    public final boolean hasEdgeConnecting_internal(N n, N n2) {
        GraphConnections graphConnections = this.nodeConnections.get(n);
        return graphConnections != null && graphConnections.successors().contains(n2);
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefault_internal(endpointPair.nodeU(), endpointPair.nodeV(), v);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnecting_internal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public Set<N> predecessors(N n) {
        return checkedConnections(n).predecessors();
    }

    public Set<N> successors(N n) {
        return checkedConnections(n).successors();
    }

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j) {
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = abstractGraphBuilder.nodeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeCount = Graphs.checkNonNegative(j);
    }
}
