package com.baidu.searchbox.ioc;

import com.baidu.searchbox.SimcardRuntime;

public interface ISimcardContext {
    public static final ISimcardContext EMPTY = new ISimcardContext() {
        public void saveDataToCache(String verison, String content) {
        }

        public boolean homeFragmentIsOnResume() {
            return false;
        }

        public boolean isShowingIntroduction() {
            return false;
        }
    };

    boolean homeFragmentIsOnResume();

    boolean isShowingIntroduction();

    void saveDataToCache(String str, String str2);

    public static final class Impl {
        private static ISimcardContext sUtilsJS = SimcardRuntime.getSimcardContext();

        private Impl() {
        }

        public static ISimcardContext get() {
            if (sUtilsJS == null) {
                sUtilsJS = ISimcardContext.EMPTY;
            }
            return sUtilsJS;
        }
    }
}
