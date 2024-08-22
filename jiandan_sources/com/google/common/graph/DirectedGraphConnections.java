package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    public static final Object PRED = new Object();
    public final Map<N, Object> adjacentNodeValues;
    public int predecessorCount;
    public int successorCount;

    public static final class PredAndSucc {
        public final Object successorValue;

        public PredAndSucc(Object obj) {
            this.successorValue = obj;
        }
    }

    public DirectedGraphConnections(Map<N, Object> map, int i2, int i3) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
        this.predecessorCount = Graphs.checkNonNegative(i2);
        this.successorCount = Graphs.checkNonNegative(i3);
        Preconditions.checkState(i2 <= map.size() && i3 <= map.size());
    }

    public static boolean isPredecessor(@NullableDecl Object obj) {
        return obj == PRED || (obj instanceof PredAndSucc);
    }

    public static boolean isSuccessor(@NullableDecl Object obj) {
        return (obj == PRED || obj == null) ? false : true;
    }

    public static <N, V> DirectedGraphConnections<N, V> of() {
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), 0, 0);
    }

    public static <N, V> DirectedGraphConnections<N, V> ofImmutable(Set<N> set, Map<N, V> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        for (N next : set) {
            Object put = hashMap.put(next, PRED);
            if (put != null) {
                hashMap.put(next, new PredAndSucc(put));
            }
        }
        return new DirectedGraphConnections<>(ImmutableMap.copyOf(hashMap), set.size(), map.size());
    }

    public void addPredecessor(N n, V v) {
        Object put = this.adjacentNodeValues.put(n, PRED);
        if (put == null) {
            int i2 = this.predecessorCount + 1;
            this.predecessorCount = i2;
            Graphs.checkPositive(i2);
        } else if (put instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n, put);
        } else if (put != PRED) {
            this.adjacentNodeValues.put(n, new PredAndSucc(put));
            int i3 = this.predecessorCount + 1;
            this.predecessorCount = i3;
            Graphs.checkPositive(i3);
        }
    }

    public V addSuccessor(N n, V v) {
        V put = this.adjacentNodeValues.put(n, v);
        if (put == null) {
            int i2 = this.successorCount + 1;
            this.successorCount = i2;
            Graphs.checkPositive(i2);
            return null;
        } else if (put instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n, new PredAndSucc(v));
            return ((PredAndSucc) put).successorValue;
        } else if (put != PRED) {
            return put;
        } else {
            this.adjacentNodeValues.put(n, new PredAndSucc(v));
            int i3 = this.successorCount + 1;
            this.successorCount = i3;
            Graphs.checkPositive(i3);
            return null;
        }
    }

    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    public Set<N> predecessors() {
        return new AbstractSet<N>() {
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            public int size() {
                return DirectedGraphConnections.this.predecessorCount;
            }

            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() {
                    public N computeNext() {
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                                return entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public void removePredecessor(N n) {
        Object obj = this.adjacentNodeValues.get(n);
        if (obj == PRED) {
            this.adjacentNodeValues.remove(n);
            int i2 = this.predecessorCount - 1;
            this.predecessorCount = i2;
            Graphs.checkNonNegative(i2);
        } else if (obj instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n, ((PredAndSucc) obj).successorValue);
            int i3 = this.predecessorCount - 1;
            this.predecessorCount = i3;
            Graphs.checkNonNegative(i3);
        }
    }

    public V removeSuccessor(Object obj) {
        V v;
        V v2 = this.adjacentNodeValues.get(obj);
        if (v2 == null || v2 == (v = PRED)) {
            return null;
        }
        if (v2 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, v);
            int i2 = this.successorCount - 1;
            this.successorCount = i2;
            Graphs.checkNonNegative(i2);
            return ((PredAndSucc) v2).successorValue;
        }
        this.adjacentNodeValues.remove(obj);
        int i3 = this.successorCount - 1;
        this.successorCount = i3;
        Graphs.checkNonNegative(i3);
        return v2;
    }

    public Set<N> successors() {
        return new AbstractSet<N>() {
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            public int size() {
                return DirectedGraphConnections.this.successorCount;
            }

            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() {
                    public N computeNext() {
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                                return entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public V value(N n) {
        V v = this.adjacentNodeValues.get(n);
        if (v == PRED) {
            return null;
        }
        return v instanceof PredAndSucc ? ((PredAndSucc) v).successorValue : v;
    }
}
