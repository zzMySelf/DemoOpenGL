package com.baidu.android.util;

public interface IKVStorageControl {
    public static final IKVStorageControl EMPTY = new IKVStorageControl() {
        public String getKVStoragePath() {
            return null;
        }

        public int getKVStorageType() {
            return 0;
        }
    };
    public static final int KV_STORAGE_TYPE_BOTH = 2;
    public static final int KV_STORAGE_TYPE_OPT = 1;
    public static final int KV_STORAGE_TYPE_ORIGIN = 0;

    String getKVStoragePath();

    int getKVStorageType();
}
