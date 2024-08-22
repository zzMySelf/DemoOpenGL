package com.baidu.searchbox.ad;

import android.content.Context;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;

public interface IDpSchemeProxy {
    public static final IDpSchemeProxy EMPTY = new Impl();

    boolean canInvoke(String str, Context context);

    public static class Impl implements IDpSchemeProxy {
        private static IDpSchemeProxy sDpSchemeProxy = AdRuntimeHolder.getDpSchemeProxy();

        public static IDpSchemeProxy get() {
            return sDpSchemeProxy;
        }

        public boolean canInvoke(String scheme, Context context) {
            return false;
        }
    }
}
