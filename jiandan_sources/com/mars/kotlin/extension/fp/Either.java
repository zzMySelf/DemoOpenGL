package com.mars.kotlin.extension.fp;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001:\u0002\u000b\fB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ9\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0004H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u0001\u0002\r\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"Lcom/mars/kotlin/extension/fp/Either;", "A", "B", "C", "Lkotlin/Function1;", "transform", "map", "(Lkotlin/Function1;)Lcom/mars/kotlin/extension/fp/Either;", "mapLeft", "<init>", "()V", "Left", "Right", "Lcom/mars/kotlin/extension/fp/Either$Left;", "Lcom/mars/kotlin/extension/fp/Either$Right;", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public abstract class Either<A, B> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/mars/kotlin/extension/fp/Either$Left;", "A", "Lcom/mars/kotlin/extension/fp/Either;", "component1", "()Ljava/lang/Object;", "value", "copy", "(Ljava/lang/Object;)Lcom/mars/kotlin/extension/fp/Either$Left;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class Left<A> extends Either {
        public final A value;

        public Left(A a) {
            super((DefaultConstructorMarker) null);
            this.value = a;
        }

        public static /* synthetic */ Left copy$default(Left left, A a, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                a = left.value;
            }
            return left.copy(a);
        }

        public final A component1() {
            return this.value;
        }

        @NotNull
        public final Left<A> copy(A a) {
            return new Left<>(a);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Left) && Intrinsics.areEqual((Object) this.value, (Object) ((Left) obj).value);
            }
            return true;
        }

        public final A getValue() {
            return this.value;
        }

        public int hashCode() {
            A a = this.value;
            if (a != null) {
                return a.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Left(" + this.value + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/mars/kotlin/extension/fp/Either$Right;", "B", "Lcom/mars/kotlin/extension/fp/Either;", "component1", "()Ljava/lang/Object;", "value", "copy", "(Ljava/lang/Object;)Lcom/mars/kotlin/extension/fp/Either$Right;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class Right<B> extends Either {
        public final B value;

        public Right(B b) {
            super((DefaultConstructorMarker) null);
            this.value = b;
        }

        public static /* synthetic */ Right copy$default(Right right, B b, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                b = right.value;
            }
            return right.copy(b);
        }

        public final B component1() {
            return this.value;
        }

        @NotNull
        public final Right<B> copy(B b) {
            return new Right<>(b);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Right) && Intrinsics.areEqual((Object) this.value, (Object) ((Right) obj).value);
            }
            return true;
        }

        public final B getValue() {
            return this.value;
        }

        public int hashCode() {
            B b = this.value;
            if (b != null) {
                return b.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Right(" + this.value + ')';
        }
    }

    public Either() {
    }

    @NotNull
    public final <C> Either<A, C> map(@NotNull Function1<? super B, ? extends C> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (this instanceof Left) {
            return this;
        }
        if (this instanceof Right) {
            return new Right(function1.invoke(((Right) this).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final <C> Either<C, B> mapLeft(@NotNull Function1<? super A, ? extends C> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (this instanceof Left) {
            return new Left(function1.invoke(((Left) this).getValue()));
        }
        if (this instanceof Right) {
            return this;
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
