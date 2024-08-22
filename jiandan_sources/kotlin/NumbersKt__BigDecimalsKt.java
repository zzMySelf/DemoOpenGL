package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\nH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\rH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000eH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000fH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\n¨\u0006\u0011"}, d2 = {"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/NumbersKt")
public class NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal dec(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    public static final BigDecimal div(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(bigDecimal2, "other");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal inc(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    public static final BigDecimal minus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(bigDecimal2, "other");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    @InlineOnly
    public static final BigDecimal plus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(bigDecimal2, "other");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    public static final BigDecimal rem(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(bigDecimal2, "other");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    public static final BigDecimal times(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(bigDecimal2, "other");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(int i2) {
        BigDecimal valueOf = BigDecimal.valueOf((long) i2);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    @InlineOnly
    public static final BigDecimal unaryMinus(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal negate = bigDecimal.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(int i2, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(i2, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(long j, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(j, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(float f, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(double d, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d), mathContext);
    }
}
