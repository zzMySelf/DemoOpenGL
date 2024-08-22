package com.baidu.searchbox.homepage.ioc;

import android.content.Intent;
import android.util.Log;

public interface IHomeApp {
    public static final IHomeApp EMPTY = new IHomeApp() {
        public boolean isMainActivityInitialUIReady() {
            return false;
        }

        public void clearPreloadResourcesIfReady() {
        }

        public void goHome(boolean anim, String params) {
        }

        public void goHomeForExitRetention(boolean anim, String params) {
        }

        public Intent getGoHomeIntent(boolean anim, String params) {
            return null;
        }

        public boolean enterSugAnimRunning() {
            return false;
        }

        public boolean isTipsShowing() {
            return false;
        }
    };
    public static final String LOG_TAG = "IHomeApp";

    void clearPreloadResourcesIfReady();

    boolean enterSugAnimRunning();

    Intent getGoHomeIntent(boolean z, String str);

    void goHome(boolean z, String str);

    void goHomeForExitRetention(boolean z, String str);

    boolean isMainActivityInitialUIReady();

    boolean isTipsShowing();

    public static final class Impl {
        private static IHomeApp sHomeApp = HomePageRuntime.getHomeOther();

        private Impl() {
        }

        public static IHomeApp get() {
            if (sHomeApp == null) {
                Log.w(IHomeApp.LOG_TAG, "Fetch IHomeApp implementation failed, IHomeApp.EMPTY applied");
                sHomeApp = IHomeApp.EMPTY;
            }
            return sHomeApp;
        }
    }
}
