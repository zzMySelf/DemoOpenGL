package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f¨\u0006\u0019"}, d2 = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/NumbersKt")
public class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger and(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger and = bigInteger.and(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
        return and;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger dec(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    @InlineOnly
    public static final BigInteger div(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger divide = bigInteger.divide(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger inc(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigInteger.ONE)");
        return add;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger inv(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger not = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(not, "this.not()");
        return not;
    }

    @InlineOnly
    public static final BigInteger minus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger or(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger or = bigInteger.or(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
        return or;
    }

    @InlineOnly
    public static final BigInteger plus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger add = bigInteger.add(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final BigInteger rem(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger remainder = bigInteger.remainder(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger shl(BigInteger bigInteger, int i2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger shiftLeft = bigInteger.shiftLeft(i2);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger shr(BigInteger bigInteger, int i2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger shiftRight = bigInteger.shiftRight(i2);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    @InlineOnly
    public static final BigInteger times(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    public static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext, "UNLIMITED");
        }
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger toBigInteger(int i2) {
        BigInteger valueOf = BigInteger.valueOf((long) i2);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    @InlineOnly
    public static final BigInteger unaryMinus(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger negate = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger xor(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(bigInteger2, "other");
        BigInteger xor = bigInteger.xor(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
        return xor;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(BigInteger bigInteger, int i2, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger toBigInteger(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
        return valueOf;
    }
}
