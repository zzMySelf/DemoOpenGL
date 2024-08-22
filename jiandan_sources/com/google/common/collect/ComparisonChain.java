package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public abstract class ComparisonChain {
    public static final ComparisonChain ACTIVE = new ComparisonChain() {
        public ComparisonChain classify(int i2) {
            if (i2 < 0) {
                return ComparisonChain.LESS;
            }
            return i2 > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }

        public ComparisonChain compare(Comparable comparable, Comparable comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        public ComparisonChain compareFalseFirst(boolean z, boolean z2) {
            return classify(Booleans.compare(z, z2));
        }

        public ComparisonChain compareTrueFirst(boolean z, boolean z2) {
            return classify(Booleans.compare(z2, z));
        }

        public int result() {
            return 0;
        }

        public <T> ComparisonChain compare(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
            return classify(comparator.compare(t, t2));
        }

        public ComparisonChain compare(int i2, int i3) {
            return classify(Ints.compare(i2, i3));
        }

        public ComparisonChain compare(long j, long j2) {
            return classify(Longs.compare(j, j2));
        }

        public ComparisonChain compare(float f, float f2) {
            return classify(Float.compare(f, f2));
        }

        public ComparisonChain compare(double d, double d2) {
            return classify(Double.compare(d, d2));
        }
    };
    public static final ComparisonChain GREATER = new InactiveComparisonChain(1);
    public static final ComparisonChain LESS = new InactiveComparisonChain(-1);

    public static final class InactiveComparisonChain extends ComparisonChain {
        public final int result;

        public InactiveComparisonChain(int i2) {
            super();
            this.result = i2;
        }

        public ComparisonChain compare(double d, double d2) {
            return this;
        }

        public ComparisonChain compare(float f, float f2) {
            return this;
        }

        public ComparisonChain compare(int i2, int i3) {
            return this;
        }

        public ComparisonChain compare(long j, long j2) {
            return this;
        }

        public ComparisonChain compare(@NullableDecl Comparable comparable, @NullableDecl Comparable comparable2) {
            return this;
        }

        public <T> ComparisonChain compare(@NullableDecl T t, @NullableDecl T t2, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        public ComparisonChain compareFalseFirst(boolean z, boolean z2) {
            return this;
        }

        public ComparisonChain compareTrueFirst(boolean z, boolean z2) {
            return this;
        }

        public int result() {
            return this.result;
        }
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double d, double d2);

    public abstract ComparisonChain compare(float f, float f2);

    public abstract ComparisonChain compare(int i2, int i3);

    public abstract ComparisonChain compare(long j, long j2);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z, boolean z2);

    public abstract ComparisonChain compareTrueFirst(boolean z, boolean z2);

    public abstract int result();

    public ComparisonChain() {
    }
}
