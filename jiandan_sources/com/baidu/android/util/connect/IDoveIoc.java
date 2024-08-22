package com.baidu.android.util.connect;

import fe.fe.ad.qw.qw.qw;

public interface IDoveIoc {
    public static final IDoveIoc EMPTY = new IDoveIoc() {
        public int getNetworkOptType() {
            return 0;
        }

        @Deprecated
        public /* synthetic */ boolean getPropOptEnable() {
            return qw.$default$getPropOptEnable(this);
        }
    };

    int getNetworkOptType();

    @Deprecated
    boolean getPropOptEnable();
}
