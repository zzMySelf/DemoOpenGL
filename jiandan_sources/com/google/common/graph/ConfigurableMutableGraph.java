package com.google.common.graph;

import com.google.common.graph.GraphConstants;

public final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    public final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    public ConfigurableMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new ConfigurableMutableValueGraph(abstractGraphBuilder);
    }

    public boolean addNode(N n) {
        return this.backingValueGraph.addNode(n);
    }

    public BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    public boolean putEdge(N n, N n2) {
        return this.backingValueGraph.putEdgeValue(n, n2, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    public boolean removeEdge(N n, N n2) {
        return this.backingValueGraph.removeEdge(n, n2) != null;
    }

    public boolean removeNode(N n) {
        return this.backingValueGraph.removeNode(n);
    }

    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
