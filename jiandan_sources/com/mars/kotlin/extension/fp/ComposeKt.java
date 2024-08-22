package com.mars.kotlin.extension.fp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001ad\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0007*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\t\u001av\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\n*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\f\u001a\u0001\u0010\u0005\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\n\"\u0004\b\u0005\u0010\r* \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u000f\u001a\u0001\u0010\u0005\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00060\u0011\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\n\"\u0004\b\u0005\u0010\r\"\u0004\b\u0006\u0010\u0010*&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00112\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0012\u001a¬\u0001\u0010\u0005\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00070\u0014\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\n\"\u0004\b\u0005\u0010\r\"\u0004\b\u0006\u0010\u0010\"\u0004\b\u0007\u0010\u0013*,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u00142\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0015\u001a¾\u0001\u0010\u0005\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\b0\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\n\"\u0004\b\u0005\u0010\r\"\u0004\b\u0006\u0010\u0010\"\u0004\b\u0007\u0010\u0013\"\u0004\b\b\u0010\u0016*2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u00172\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0018¨\u0006\u0019"}, d2 = {"A", "B", "C", "Lkotlin/Function1;", "block", "plus", "(Lkotlin/Function1;Lkotlin/Function1;)Lkotlin/Function1;", "D", "Lkotlin/Function2;", "(Lkotlin/Function2;Lkotlin/Function1;)Lkotlin/Function2;", "E", "Lkotlin/Function3;", "(Lkotlin/Function3;Lkotlin/Function1;)Lkotlin/Function3;", "F", "Lkotlin/Function4;", "(Lkotlin/Function4;Lkotlin/Function1;)Lkotlin/Function4;", "G", "Lkotlin/Function5;", "(Lkotlin/Function5;Lkotlin/Function1;)Lkotlin/Function5;", "H", "Lkotlin/Function6;", "(Lkotlin/Function6;Lkotlin/Function1;)Lkotlin/Function6;", "I", "Lkotlin/Function7;", "(Lkotlin/Function7;Lkotlin/Function1;)Lkotlin/Function7;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ComposeKt {
    @NotNull
    public static final <A, B, C> Function1<A, C> plus(@NotNull Function1<? super A, ? extends B> function1, @NotNull Function1<? super B, ? extends C> function12) {
        Intrinsics.checkNotNullParameter(function1, "$this$plus");
        Intrinsics.checkNotNullParameter(function12, "block");
        return new ComposeKt$plus$1(function1, function12);
    }

    @NotNull
    public static final <A, B, C, D> Function2<A, B, D> plus(@NotNull Function2<? super A, ? super B, ? extends C> function2, @NotNull Function1<? super C, ? extends D> function1) {
        Intrinsics.checkNotNullParameter(function2, "$this$plus");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new ComposeKt$plus$2(function2, function1);
    }

    @NotNull
    public static final <A, B, C, D, E> Function3<A, B, C, E> plus(@NotNull Function3<? super A, ? super B, ? super C, ? extends D> function3, @NotNull Function1<? super D, ? extends E> function1) {
        Intrinsics.checkNotNullParameter(function3, "$this$plus");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new ComposeKt$plus$3(function3, function1);
    }

    @NotNull
    public static final <A, B, C, D, E, F> Function4<A, B, C, D, F> plus(@NotNull Function4<? super A, ? super B, ? super C, ? super D, ? extends E> function4, @NotNull Function1<? super E, ? extends F> function1) {
        Intrinsics.checkNotNullParameter(function4, "$this$plus");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new ComposeKt$plus$4(function4, function1);
    }

    @NotNull
    public static final <A, B, C, D, E, F, G> Function5<A, B, C, D, E, G> plus(@NotNull Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends F> function5, @NotNull Function1<? super F, ? extends G> function1) {
        Intrinsics.checkNotNullParameter(function5, "$this$plus");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new ComposeKt$plus$5(function5, function1);
    }

    @NotNull
    public static final <A, B, C, D, E, F, G, H> Function6<A, B, C, D, E, F, H> plus(@NotNull Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? extends G> function6, @NotNull Function1<? super G, ? extends H> function1) {
        Intrinsics.checkNotNullParameter(function6, "$this$plus");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new ComposeKt$plus$6(function6, function1);
    }

    @NotNull
    public static final <A, B, C, D, E, F, G, H, I> Function7<A, B, C, D, E, F, G, I> plus(@NotNull Function7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends H> function7, @NotNull Function1<? super H, ? extends I> function1) {
        Intrinsics.checkNotNullParameter(function7, "$this$plus");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new ComposeKt$plus$7(function7, function1);
    }
}
