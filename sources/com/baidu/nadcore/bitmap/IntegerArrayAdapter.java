package com.baidu.nadcore.bitmap;

final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {
    private static final String TAG = "IntegerArrayPool";

    IntegerArrayAdapter() {
    }

    public String getTag() {
        return TAG;
    }

    public int getArrayLength(int[] array) {
        return array.length;
    }

    public int[] newArray(int length) {
        return new int[length];
    }

    public int getElementSizeInBytes() {
        return 4;
    }
}
