package com.baidu.searchbox.bookmark;

public class CacheLoginStatus {
    public static final int LOGIN_CLOSE = 2;
    public static final int LOGIN_SHOW = 1;
    private int mLoginStatus = 1;

    private static class Holder {
        /* access modifiers changed from: private */
        public static final CacheLoginStatus INSTANCE = new CacheLoginStatus();

        private Holder() {
        }
    }

    public static CacheLoginStatus getInstance() {
        return Holder.INSTANCE;
    }

    public void markClose() {
        this.mLoginStatus = 2;
    }

    public int getLoginBarStatus() {
        return this.mLoginStatus;
    }
}
