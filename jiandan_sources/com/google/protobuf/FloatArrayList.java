package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    public static final FloatArrayList EMPTY_LIST;
    public float[] array;
    public int size;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        EMPTY_LIST = floatArrayList;
        floatArrayList.makeImmutable();
    }

    public FloatArrayList() {
        this(new float[10], 0);
    }

    public static FloatArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i2) {
        return "Index:" + i2 + ", Size:" + this.size;
    }

    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i2 = floatArrayList.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.array;
            if (i4 > fArr.length) {
                this.array = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
            this.size = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addFloat(float f) {
        ensureIsMutable();
        int i2 = this.size;
        float[] fArr = this.array;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        fArr3[i3] = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Float.floatToIntBits(this.array[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public float getFloat(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.array[i3]);
        }
        return i2;
    }

    public void removeRange(int i2, int i3) {
        ensureIsMutable();
        if (i3 >= i2) {
            float[] fArr = this.array;
            System.arraycopy(fArr, i3, fArr, i2, this.size - i3);
            this.size -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float setFloat(int i2, float f) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        float[] fArr = this.array;
        float f2 = fArr[i2];
        fArr[i2] = f;
        return f2;
    }

    public int size() {
        return this.size;
    }

    public FloatArrayList(float[] fArr, int i2) {
        this.array = fArr;
        this.size = i2;
    }

    public Float get(int i2) {
        return Float.valueOf(getFloat(i2));
    }

    public Internal.FloatList mutableCopyWithCapacity(int i2) {
        if (i2 >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Float.valueOf(this.array[i2]))) {
                float[] fArr = this.array;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.size - i2) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public Float set(int i2, Float f) {
        return Float.valueOf(setFloat(i2, f.floatValue()));
    }

    public boolean add(Float f) {
        addFloat(f.floatValue());
        return true;
    }

    public void add(int i2, Float f) {
        addFloat(i2, f.floatValue());
    }

    private void addFloat(int i2, float f) {
        int i3;
        ensureIsMutable();
        if (i2 < 0 || i2 > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
        float[] fArr = this.array;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.array, i2, fArr2, i2 + 1, this.size - i2);
            this.array = fArr2;
        }
        this.array[i2] = f;
        this.size++;
        this.modCount++;
    }

    public Float remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        float[] fArr = this.array;
        float f = fArr[i2];
        int i3 = this.size;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }
}
