package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {
    public final Map<E, ?> outEdgeToNode;
    public final Object targetNode;

    public MultiEdgesConnecting(Map<E, ?> map, Object obj) {
        this.outEdgeToNode = (Map) Preconditions.checkNotNull(map);
        this.targetNode = Preconditions.checkNotNull(obj);
    }

    public boolean contains(@NullableDecl Object obj) {
        return this.targetNode.equals(this.outEdgeToNode.get(obj));
    }

    public UnmodifiableIterator<E> iterator() {
        final Iterator<Map.Entry<E, ?>> it = this.outEdgeToNode.entrySet().iterator();
        return new AbstractIterator<E>() {
            public E computeNext() {
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (MultiEdgesConnecting.this.targetNode.equals(entry.getValue())) {
                        return entry.getKey();
                    }
                }
                return endOfData();
            }
        };
    }
}
