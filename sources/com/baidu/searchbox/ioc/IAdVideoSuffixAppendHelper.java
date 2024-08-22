package com.baidu.searchbox.ioc;

public interface IAdVideoSuffixAppendHelper {
    public static final IAdVideoSuffixAppendHelper EMPTY = new IAdVideoSuffixAppendHelper() {
        public boolean needAppendLocalAd(boolean isEmptyOrder) {
            return false;
        }

        public void updateDbInfo() {
        }

        public Object createATFData() {
            return null;
        }

        public boolean getAppendStatus() {
            return false;
        }
    };

    Object createATFData();

    boolean getAppendStatus();

    boolean needAppendLocalAd(boolean z);

    void updateDbInfo();

    public static class Impl {
        private Impl() {
        }

        public static IAdVideoSuffixAppendHelper getAdVideoSuffixAppendHelper() {
            return AdSuffixVideoAppendHelperProxy_Factory.get();
        }
    }
}
