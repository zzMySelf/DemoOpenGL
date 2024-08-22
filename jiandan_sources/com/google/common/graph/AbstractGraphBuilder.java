package com.google.common.graph;

import com.google.common.base.Optional;

public abstract class AbstractGraphBuilder<N> {
    public boolean allowsSelfLoops = false;
    public final boolean directed;
    public Optional<Integer> expectedNodeCount = Optional.absent();
    public ElementOrder<N> nodeOrder = ElementOrder.insertion();

    public AbstractGraphBuilder(boolean z) {
        this.directed = z;
    }
}
