package com.baidu.searchbox.ad;

import com.baidu.searchbox.feed.ad.AdRuntimeHolder;

public interface IAdCriusRuntime {
    public static final IAdCriusRuntime EMPTY = new Impl();

    int getFontLevel();

    boolean getNightMode();

    void prefetchImage(String str);

    public static class Impl implements IAdCriusRuntime {
        private static IAdCriusRuntime sCriusRuntime = AdRuntimeHolder.getCriusRuntime();

        public static IAdCriusRuntime get() {
            return sCriusRuntime;
        }

        public boolean getNightMode() {
            return false;
        }

        public int getFontLevel() {
            return 0;
        }

        public void prefetchImage(String imageUrl) {
        }
    }
}
