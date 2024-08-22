package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
public abstract class Traverser<N> {

    public enum Order {
        PREORDER,
        POSTORDER
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new GraphTraverser(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new TreeTraverser(successorsFunction);
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n);

    public static final class GraphTraverser<N> extends Traverser<N> {
        public final SuccessorsFunction<N> graph;

        public final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            public final Queue<N> queue = new ArrayDeque();
            public final Set<N> visited = new HashSet();

            public BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (Object next : iterable) {
                    if (this.visited.add(next)) {
                        this.queue.add(next);
                    }
                }
            }

            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            public N next() {
                N remove = this.queue.remove();
                for (Object next : GraphTraverser.this.graph.successors(remove)) {
                    if (this.visited.add(next)) {
                        this.queue.add(next);
                    }
                }
                return remove;
            }
        }

        public final class DepthFirstIterator extends AbstractIterator<N> {
            public final Order order;
            public final Deque<GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> stack = new ArrayDeque();
            public final Set<N> visited = new HashSet();

            public final class NodeAndSuccessors {
                @NullableDecl
                public final N node;
                public final Iterator<? extends N> successorIterator;

                public NodeAndSuccessors(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.successorIterator = iterable.iterator();
                }
            }

            public DepthFirstIterator(Iterable<? extends N> iterable, Order order2) {
                this.stack.push(new NodeAndSuccessors(null, iterable));
                this.order = order2;
            }

            public N computeNext() {
                N n;
                while (!this.stack.isEmpty()) {
                    NodeAndSuccessors first = this.stack.getFirst();
                    boolean add = this.visited.add(first.node);
                    boolean z = true;
                    boolean z2 = !first.successorIterator.hasNext();
                    if ((!add || this.order != Order.PREORDER) && (!z2 || this.order != Order.POSTORDER)) {
                        z = false;
                    }
                    if (z2) {
                        this.stack.pop();
                    } else {
                        Object next = first.successorIterator.next();
                        if (!this.visited.contains(next)) {
                            this.stack.push(withSuccessors(next));
                        }
                    }
                    if (z && (n = first.node) != null) {
                        return n;
                    }
                }
                return endOfData();
            }

            public GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors withSuccessors(N n) {
                return new NodeAndSuccessors(n, GraphTraverser.this.graph.successors(n));
            }
        }

        public GraphTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        private void checkThatNodeIsInGraph(N n) {
            this.graph.successors(n);
        }

        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst(ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder(ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder(ImmutableSet.of(n));
        }

        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.POSTORDER);
                }
            };
        }

        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.PREORDER);
                }
            };
        }
    }

    public static final class TreeTraverser<N> extends Traverser<N> {
        public final SuccessorsFunction<N> tree;

        public final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            public final Queue<N> queue = new ArrayDeque();

            public BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (Object add : iterable) {
                    this.queue.add(add);
                }
            }

            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            public N next() {
                N remove = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.this.tree.successors(remove));
                return remove;
            }
        }

        public final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            public final ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> stack;

            public final class NodeAndChildren {
                public final Iterator<? extends N> childIterator;
                @NullableDecl
                public final N node;

                public NodeAndChildren(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.childIterator = iterable.iterator();
                }
            }

            public DepthFirstPostOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> arrayDeque = new ArrayDeque<>();
                this.stack = arrayDeque;
                arrayDeque.addLast(new NodeAndChildren(null, iterable));
            }

            public N computeNext() {
                while (!this.stack.isEmpty()) {
                    NodeAndChildren last = this.stack.getLast();
                    if (last.childIterator.hasNext()) {
                        this.stack.addLast(withChildren(last.childIterator.next()));
                    } else {
                        this.stack.removeLast();
                        N n = last.node;
                        if (n != null) {
                            return n;
                        }
                    }
                }
                return endOfData();
            }

            public TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren withChildren(N n) {
                return new NodeAndChildren(n, TreeTraverser.this.tree.successors(n));
            }
        }

        public final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            public final Deque<Iterator<? extends N>> stack;

            public DepthFirstPreOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            public boolean hasNext() {
                return !this.stack.isEmpty();
            }

            public N next() {
                Iterator last = this.stack.getLast();
                N checkNotNull = Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.stack.removeLast();
                }
                Iterator it = TreeTraverser.this.tree.successors(checkNotNull).iterator();
                if (it.hasNext()) {
                    this.stack.addLast(it);
                }
                return checkNotNull;
            }
        }

        public TreeTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        private void checkThatNodeIsInTree(N n) {
            this.tree.successors(n);
        }

        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst(ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder(ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder(ImmutableSet.of(n));
        }

        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstPostOrderIterator(iterable);
                }
            };
        }

        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstPreOrderIterator(iterable);
                }
            };
        }
    }

    public Traverser() {
    }
}
