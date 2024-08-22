package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

@GwtCompatible(serializable = true)
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final NaturalOrdering INSTANCE = new NaturalOrdering();
    public static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Ordering<Comparable> nullsFirst;
    @MonotonicNonNullDecl
    public transient Ordering<Comparable> nullsLast;

    private Object readResolve() {
        return INSTANCE;
    }

    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<Comparable> ordering = this.nullsFirst;
        if (ordering != null) {
            return ordering;
        }
        Ordering<Comparable> nullsFirst2 = super.nullsFirst();
        this.nullsFirst = nullsFirst2;
        return nullsFirst2;
    }

    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<Comparable> ordering = this.nullsLast;
        if (ordering != null) {
            return ordering;
        }
        Ordering<Comparable> nullsLast2 = super.nullsLast();
        this.nullsLast = nullsLast2;
        return nullsLast2;
    }

    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }
}
