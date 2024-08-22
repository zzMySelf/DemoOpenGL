package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a)\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\bH\bø\u0001\u0000¢\u0006\u0002\b\t\u001a)\u0010\u0005\u001a\u00020\n*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\bH\bø\u0001\u0000¢\u0006\u0002\b\u000b\u001a\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020\u0002\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"elementAt", "", "", "index", "", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    @InlineOnly
    public static final char elementAt(CharSequence charSequence, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.charAt(i2);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(CharSequence charSequence, Function1<? super Character, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Character.valueOf(charSequence.charAt(i2))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(CharSequence charSequence, Function1<? super Character, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Character.valueOf(charSequence.charAt(i2))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (SortedSet) StringsKt___StringsKt.toCollection(charSequence, new TreeSet());
    }
}
