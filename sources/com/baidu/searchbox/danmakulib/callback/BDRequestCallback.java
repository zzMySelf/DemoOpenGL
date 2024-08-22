package com.baidu.searchbox.danmakulib.callback;

public interface BDRequestCallback<T> {
    public static final int FAILURE = -2;
    public static final int NET_FAILURE = -1;
    public static final int SUCCESS = 0;

    void onCompleted(int i2, T t, String str);
}
