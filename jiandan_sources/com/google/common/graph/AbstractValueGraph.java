package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {
    public static <N, V> Map<EndpointPair<N>, V> edgeValueMap(final ValueGraph<N, V> valueGraph) {
        return Maps.asMap(valueGraph.edges(), new Function<EndpointPair<N>, V>() {
            public V apply(EndpointPair<N> endpointPair) {
                return valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            }
        });
    }

    public Graph<N> asGraph() {
        return new AbstractGraph<N>() {
            public Set<N> adjacentNodes(N n) {
                return AbstractValueGraph.this.adjacentNodes(n);
            }

            public boolean allowsSelfLoops() {
                return AbstractValueGraph.this.allowsSelfLoops();
            }

            public int degree(N n) {
                return AbstractValueGraph.this.degree(n);
            }

            public Set<EndpointPair<N>> edges() {
                return AbstractValueGraph.this.edges();
            }

            public int inDegree(N n) {
                return AbstractValueGraph.this.inDegree(n);
            }

            public boolean isDirected() {
                return AbstractValueGraph.this.isDirected();
            }

            public ElementOrder<N> nodeOrder() {
                return AbstractValueGraph.this.nodeOrder();
            }

            public Set<N> nodes() {
                return AbstractValueGraph.this.nodes();
            }

            public int outDegree(N n) {
                return AbstractValueGraph.this.outDegree(n);
            }

            public Set<N> predecessors(N n) {
                return AbstractValueGraph.this.predecessors(n);
            }

            public Set<N> successors(N n) {
                return AbstractValueGraph.this.successors(n);
            }
        };
    }

    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        if (isDirected() != valueGraph.isDirected() || !nodes().equals(valueGraph.nodes()) || !edgeValueMap(this).equals(edgeValueMap(valueGraph))) {
            return false;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    public final int hashCode() {
        return edgeValueMap(this).hashCode();
    }

    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeValueMap(this);
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }
}
