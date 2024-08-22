package com.baidu.searchbox.http.statistics;

public interface NetworkStat<T> {
    void ad(T t, int i2);

    void de(T t, long j);

    void fe(T t, Exception exc);

    void qw(T t, long j);

    void rg(T t, long j);
}
