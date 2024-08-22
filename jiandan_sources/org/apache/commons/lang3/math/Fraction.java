package org.apache.commons.lang3.math;

import java.math.BigInteger;

public final class Fraction extends Number implements Comparable<Fraction> {
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final long serialVersionUID = 65382027393090L;
    public final int denominator;
    public transient int hashCode = 0;
    public final int numerator;
    public transient String toProperString = null;
    public transient String toString = null;

    public Fraction(int i2, int i3) {
        this.numerator = i2;
        this.denominator = i3;
    }

    public static int addAndCheck(int i2, int i3) {
        long j = ((long) i2) + ((long) i3);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    private Fraction addSub(Fraction fraction, boolean z) {
        int i2;
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (this.numerator == 0) {
            return z ? fraction : fraction.negate();
        } else {
            if (fraction.numerator == 0) {
                return this;
            }
            int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
            if (greatestCommonDivisor == 1) {
                int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
                int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
                return new Fraction(z ? addAndCheck(mulAndCheck, mulAndCheck2) : subAndCheck(mulAndCheck, mulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
            }
            BigInteger multiply = BigInteger.valueOf((long) this.numerator).multiply(BigInteger.valueOf((long) (fraction.denominator / greatestCommonDivisor)));
            BigInteger multiply2 = BigInteger.valueOf((long) fraction.numerator).multiply(BigInteger.valueOf((long) (this.denominator / greatestCommonDivisor)));
            BigInteger add = z ? multiply.add(multiply2) : multiply.subtract(multiply2);
            int intValue = add.mod(BigInteger.valueOf((long) greatestCommonDivisor)).intValue();
            if (intValue == 0) {
                i2 = greatestCommonDivisor;
            } else {
                i2 = greatestCommonDivisor(intValue, greatestCommonDivisor);
            }
            BigInteger divide = add.divide(BigInteger.valueOf((long) i2));
            if (divide.bitLength() <= 31) {
                return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / i2));
            }
            throw new ArithmeticException("overflow: numerator too large after multiply");
        }
    }

    public static Fraction getFraction(int i2, int i3) {
        if (i3 != 0) {
            if (i3 < 0) {
                if (i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i2 = -i2;
                i3 = -i3;
            }
            return new Fraction(i2, i3);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int i2, int i3) {
        if (i3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i2 == 0) {
            return ZERO;
        } else {
            if (i3 == Integer.MIN_VALUE && (i2 & 1) == 0) {
                i2 /= 2;
                i3 /= 2;
            }
            if (i3 < 0) {
                if (i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i2 = -i2;
                i3 = -i3;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i2, i3);
            return new Fraction(i2 / greatestCommonDivisor, i3 / greatestCommonDivisor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int greatestCommonDivisor(int r6, int r7) {
        /*
            java.lang.String r0 = "overflow: gcd is 2^31"
            if (r6 == 0) goto L_0x0057
            if (r7 != 0) goto L_0x0007
            goto L_0x0057
        L_0x0007:
            int r1 = java.lang.Math.abs(r6)
            r2 = 1
            if (r1 == r2) goto L_0x0056
            int r1 = java.lang.Math.abs(r7)
            if (r1 != r2) goto L_0x0015
            goto L_0x0056
        L_0x0015:
            if (r6 <= 0) goto L_0x0018
            int r6 = -r6
        L_0x0018:
            if (r7 <= 0) goto L_0x001b
            int r7 = -r7
        L_0x001b:
            r1 = 0
        L_0x001c:
            r3 = r6 & 1
            r4 = 31
            if (r3 != 0) goto L_0x002f
            r5 = r7 & 1
            if (r5 != 0) goto L_0x002f
            if (r1 >= r4) goto L_0x002f
            int r6 = r6 / 2
            int r7 = r7 / 2
            int r1 = r1 + 1
            goto L_0x001c
        L_0x002f:
            if (r1 == r4) goto L_0x0050
            if (r3 != r2) goto L_0x0035
            r0 = r7
            goto L_0x0038
        L_0x0035:
            int r0 = r6 / 2
            int r0 = -r0
        L_0x0038:
            r3 = r0 & 1
            if (r3 != 0) goto L_0x003f
            int r0 = r0 / 2
            goto L_0x0038
        L_0x003f:
            if (r0 <= 0) goto L_0x0043
            int r6 = -r0
            goto L_0x0044
        L_0x0043:
            r7 = r0
        L_0x0044:
            int r0 = r7 - r6
            int r0 = r0 / 2
            if (r0 != 0) goto L_0x0038
            int r6 = -r6
            int r7 = r2 << r1
            int r6 = r6 * r7
            return r6
        L_0x0050:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        L_0x0056:
            return r2
        L_0x0057:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 == r1) goto L_0x0067
            if (r7 == r1) goto L_0x0067
            int r6 = java.lang.Math.abs(r6)
            int r7 = java.lang.Math.abs(r7)
            int r6 = r6 + r7
            return r6
        L_0x0067:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.Fraction.greatestCommonDivisor(int, int):int");
    }

    public static int mulAndCheck(int i2, int i3) {
        long j = ((long) i2) * ((long) i3);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mul");
    }

    public static int mulPosAndCheck(int i2, int i3) {
        long j = ((long) i2) * ((long) i3);
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    public static int subAndCheck(int i2, int i3) {
        long j = ((long) i2) - ((long) i3);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    public Fraction abs() {
        if (this.numerator >= 0) {
            return this;
        }
        return negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        } else {
            throw new ArithmeticException("The fraction to divide by must not be zero");
        }
    }

    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator()) {
            return true;
        }
        return false;
    }

    public float floatValue() {
        return ((float) this.numerator) / ((float) this.denominator);
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((getNumerator() + 629) * 37) + getDenominator();
        }
        return this.hashCode;
    }

    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i2 = this.numerator;
        if (i2 == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        } else if (i2 == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        } else if (i2 < 0) {
            return new Fraction(-this.denominator, -i2);
        } else {
            return new Fraction(this.denominator, i2);
        }
    }

    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction != null) {
            int i2 = this.numerator;
            if (i2 == 0 || fraction.numerator == 0) {
                return ZERO;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i2, fraction.denominator);
            int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
            return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public Fraction negate() {
        int i2 = this.numerator;
        if (i2 != Integer.MIN_VALUE) {
            return new Fraction(-i2, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i2) {
        if (i2 == 1) {
            return this;
        }
        if (i2 == 0) {
            return ONE;
        }
        if (i2 >= 0) {
            Fraction multiplyBy = multiplyBy(this);
            if (i2 % 2 == 0) {
                return multiplyBy.pow(i2 / 2);
            }
            return multiplyBy.pow(i2 / 2).multiplyBy(this);
        } else if (i2 == Integer.MIN_VALUE) {
            return invert().pow(2).pow(-(i2 / 2));
        } else {
            return invert().pow(-i2);
        }
    }

    public Fraction reduce() {
        int i2 = this.numerator;
        if (i2 == 0) {
            return equals(ZERO) ? this : ZERO;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i2), this.denominator);
        if (greatestCommonDivisor == 1) {
            return this;
        }
        return getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i2 = this.numerator;
            if (i2 == 0) {
                this.toProperString = "0";
            } else {
                int i3 = this.denominator;
                if (i2 == i3) {
                    this.toProperString = "1";
                } else if (i2 == i3 * -1) {
                    this.toProperString = "-1";
                } else {
                    if (i2 > 0) {
                        i2 = -i2;
                    }
                    if (i2 < (-this.denominator)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            this.toProperString = getProperWhole() + " " + properNumerator + "/" + getDenominator();
                        }
                    } else {
                        this.toProperString = getNumerator() + "/" + getDenominator();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = getNumerator() + "/" + getDenominator();
        }
        return this.toString;
    }

    public int compareTo(Fraction fraction) {
        int i2;
        if (this == fraction) {
            return 0;
        }
        if ((this.numerator == fraction.numerator && this.denominator == fraction.denominator) || ((long) this.numerator) * ((long) fraction.denominator) == ((long) fraction.numerator) * ((long) this.denominator)) {
            return 0;
        }
        return i2 < 0 ? -1 : 1;
    }

    public static Fraction getFraction(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i4 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        } else if (i3 >= 0) {
            long j = i2 < 0 ? (((long) i2) * ((long) i4)) - ((long) i3) : (((long) i2) * ((long) i4)) + ((long) i3);
            if (j >= -2147483648L && j <= 2147483647L) {
                return new Fraction((int) j, i4);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        } else {
            throw new ArithmeticException("The numerator must not be negative");
        }
    }

    public static Fraction getFraction(double d) {
        int i2;
        int i3;
        int i4 = d < 0.0d ? -1 : 1;
        double abs = Math.abs(d);
        if (abs > 2.147483647E9d || Double.isNaN(abs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i5 = (int) abs;
        double d2 = abs - ((double) i5);
        int i6 = (int) d2;
        double d3 = 1.0d;
        double d4 = d2 - ((double) i6);
        double d5 = Double.MAX_VALUE;
        int i7 = i4;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            int i13 = (int) (d3 / d4);
            double d6 = d5;
            double d7 = d3 - (((double) i13) * d4);
            int i14 = (i6 * i8) + i9;
            int i15 = (i6 * i10) + i11;
            int i16 = i13;
            int i17 = i14;
            d5 = Math.abs(d2 - (((double) i14) / ((double) i15)));
            i2 = i12 + 1;
            if (d6 <= d5 || i15 > 10000 || i15 <= 0) {
                i3 = 25;
            } else {
                i3 = 25;
                if (i2 >= 25) {
                    break;
                }
                i12 = i2;
                int i18 = i10;
                i10 = i15;
                i6 = i16;
                i9 = i8;
                i8 = i17;
                i11 = i18;
                double d8 = d7;
                d3 = d4;
                d4 = d8;
            }
        }
        if (i2 != i3) {
            return getReducedFraction((i8 + (i5 * i10)) * i7, i10);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The string must not be null");
        } else if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        } else {
            int indexOf = str.indexOf(32);
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(str.substring(0, indexOf));
                String substring = str.substring(indexOf + 1);
                int indexOf2 = substring.indexOf(47);
                if (indexOf2 >= 0) {
                    return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
                }
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 < 0) {
                return getFraction(Integer.parseInt(str), 1);
            }
            return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
        }
    }
}
