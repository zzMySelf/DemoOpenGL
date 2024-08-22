package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

public class MutableInt extends Number implements Comparable<MutableInt>, Mutable<Number> {
    public static final long serialVersionUID = 512176391864L;
    public int value;

    public MutableInt() {
    }

    public void add(int i2) {
        this.value += i2;
    }

    public int addAndGet(int i2) {
        int i3 = this.value + i2;
        this.value = i3;
        return i3;
    }

    public void decrement() {
        this.value--;
    }

    public int decrementAndGet() {
        int i2 = this.value - 1;
        this.value = i2;
        return i2;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableInt) || this.value != ((MutableInt) obj).intValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public int getAndAdd(int i2) {
        int i3 = this.value;
        this.value = i2 + i3;
        return i3;
    }

    public int getAndDecrement() {
        int i2 = this.value;
        this.value = i2 - 1;
        return i2;
    }

    public int getAndIncrement() {
        int i2 = this.value;
        this.value = i2 + 1;
        return i2;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value++;
    }

    public int incrementAndGet() {
        int i2 = this.value + 1;
        this.value = i2;
        return i2;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void subtract(int i2) {
        this.value -= i2;
    }

    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableInt(int i2) {
        this.value = i2;
    }

    public void add(Number number) {
        this.value += number.intValue();
    }

    public int addAndGet(Number number) {
        int intValue = this.value + number.intValue();
        this.value = intValue;
        return intValue;
    }

    public int compareTo(MutableInt mutableInt) {
        return NumberUtils.compare(this.value, mutableInt.value);
    }

    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    public void setValue(int i2) {
        this.value = i2;
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    public int getAndAdd(Number number) {
        int i2 = this.value;
        this.value = number.intValue() + i2;
        return i2;
    }

    public void setValue(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(String str) throws NumberFormatException {
        this.value = Integer.parseInt(str);
    }
}
