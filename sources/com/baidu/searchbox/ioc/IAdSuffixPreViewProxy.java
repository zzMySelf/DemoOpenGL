package com.baidu.searchbox.ioc;

import android.content.Context;
import com.baidu.searchbox.interfaces.IAdSuffixModel;

public interface IAdSuffixPreViewProxy {
    public static final IAdSuffixPreViewProxy EMPTY = new IAdSuffixPreViewProxy() {
        public void preRender(IAdSuffixModel videoAdItemModel) {
        }

        public void preLoad(IAdSuffixModel videoAdItemModel) {
        }

        public void prefetchSource(IAdSuffixModel videoAdItemModel) {
        }

        public void prefetchSwanAd(Context context, IAdSuffixModel data) {
        }

        public void releaseRender() {
        }

        public void releaseLoad() {
        }
    };

    void preLoad(IAdSuffixModel iAdSuffixModel);

    void preRender(IAdSuffixModel iAdSuffixModel);

    void prefetchSource(IAdSuffixModel iAdSuffixModel);

    void prefetchSwanAd(Context context, IAdSuffixModel iAdSuffixModel);

    void releaseLoad();

    void releaseRender();

    public static class Impl {
        private Impl() {
        }

        public static IAdSuffixPreViewProxy getAdSuffixPreReadyProxy() {
            return AdSuffixPreViewProxy_Factory.get();
        }
    }
}
