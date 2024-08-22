package com.baidu.swan.support.v4.util;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int initialCapacity) {
        this.mGarbage = false;
        if (initialCapacity == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int initialCapacity2 = ContainerHelpers.idealIntArraySize(initialCapacity);
            this.mKeys = new int[initialCapacity2];
            this.mValues = new Object[initialCapacity2];
        }
        this.mSize = 0;
    }

    public SparseArrayCompat<E> clone() {
        SparseArrayCompat<E> clone = null;
        try {
            clone = (SparseArrayCompat) super.clone();
            clone.mKeys = (int[]) this.mKeys.clone();
            clone.mValues = (Object[]) this.mValues.clone();
            return clone;
        } catch (CloneNotSupportedException e2) {
            return clone;
        }
    }

    public E get(int key) {
        return get(key, (Object) null);
    }

    public E get(int key, E valueIfKeyNotFound) {
        E e2;
        int i2 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, key);
        if (i2 < 0 || (e2 = this.mValues[i2]) == DELETED) {
            return valueIfKeyNotFound;
        }
        return e2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r4.mValues;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void delete(int r5) {
        /*
            r4 = this;
            int[] r0 = r4.mKeys
            int r1 = r4.mSize
            int r0 = com.baidu.swan.support.v4.util.ContainerHelpers.binarySearch((int[]) r0, (int) r1, (int) r5)
            if (r0 < 0) goto L_0x0017
            java.lang.Object[] r1 = r4.mValues
            r2 = r1[r0]
            java.lang.Object r3 = DELETED
            if (r2 == r3) goto L_0x0017
            r1[r0] = r3
            r1 = 1
            r4.mGarbage = r1
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.support.v4.util.SparseArrayCompat.delete(int):void");
    }

    public void remove(int key) {
        delete(key);
    }

    public void removeAt(int index) {
        Object[] objArr = this.mValues;
        Object obj = objArr[index];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[index] = obj2;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int index, int size) {
        int end = Math.min(this.mSize, index + size);
        for (int i2 = index; i2 < end; i2++) {
            removeAt(i2);
        }
    }

    private void gc() {
        int n = this.mSize;
        int o = 0;
        int[] keys = this.mKeys;
        Object[] values = this.mValues;
        for (int i2 = 0; i2 < n; i2++) {
            Object val = values[i2];
            if (val != DELETED) {
                if (i2 != o) {
                    keys[o] = keys[i2];
                    values[o] = val;
                    values[i2] = null;
                }
                o++;
            }
        }
        this.mGarbage = false;
        this.mSize = o;
    }

    public void put(int key, E value) {
        int i2 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, key);
        if (i2 >= 0) {
            this.mValues[i2] = value;
            return;
        }
        int i3 = ~i2;
        int i4 = this.mSize;
        if (i3 < i4) {
            Object[] objArr = this.mValues;
            if (objArr[i3] == DELETED) {
                this.mKeys[i3] = key;
                objArr[i3] = value;
                return;
            }
        }
        if (this.mGarbage && i4 >= this.mKeys.length) {
            gc();
            i3 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, key);
        }
        int i5 = this.mSize;
        if (i5 >= this.mKeys.length) {
            int n = ContainerHelpers.idealIntArraySize(i5 + 1);
            int[] nkeys = new int[n];
            Object[] nvalues = new Object[n];
            int[] iArr = this.mKeys;
            System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, nvalues, 0, objArr2.length);
            this.mKeys = nkeys;
            this.mValues = nvalues;
        }
        int n2 = this.mSize;
        if (n2 - i3 != 0) {
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, i3, iArr2, i3 + 1, n2 - i3);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, i3, objArr3, i3 + 1, this.mSize - i3);
        }
        this.mKeys[i3] = key;
        this.mValues[i3] = value;
        this.mSize++;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public int keyAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[index];
    }

    public E valueAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[index];
    }

    public void setValueAt(int index, E value) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[index] = value;
    }

    public int indexOfKey(int key) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, key);
    }

    public int indexOfValue(E value) {
        if (this.mGarbage) {
            gc();
        }
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (this.mValues[i2] == value) {
                return i2;
            }
        }
        return -1;
    }

    public void clear() {
        int n = this.mSize;
        Object[] values = this.mValues;
        for (int i2 = 0; i2 < n; i2++) {
            values[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(int key, E value) {
        int i2 = this.mSize;
        if (i2 == 0 || key > this.mKeys[i2 - 1]) {
            if (this.mGarbage && i2 >= this.mKeys.length) {
                gc();
            }
            int pos = this.mSize;
            if (pos >= this.mKeys.length) {
                int n = ContainerHelpers.idealIntArraySize(pos + 1);
                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];
                int[] iArr = this.mKeys;
                System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
                Object[] objArr = this.mValues;
                System.arraycopy(objArr, 0, nvalues, 0, objArr.length);
                this.mKeys = nkeys;
                this.mValues = nvalues;
            }
            this.mKeys[pos] = key;
            this.mValues[pos] = value;
            this.mSize = pos + 1;
            return;
        }
        put(key, value);
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.mSize * 28);
        buffer.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                buffer.append(", ");
            }
            buffer.append(keyAt(i2));
            buffer.append('=');
            Object value = valueAt(i2);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append(AbstractJsonLexerKt.END_OBJ);
        return buffer.toString();
    }
}
