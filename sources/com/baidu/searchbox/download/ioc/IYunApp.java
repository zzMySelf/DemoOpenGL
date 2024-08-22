package com.baidu.searchbox.download.ioc;

import android.content.Context;
import android.util.Log;

public interface IYunApp {
    public static final IYunApp EMPTY = new IYunApp() {
        public String getHashedString(String url) {
            return null;
        }

        public String encodeUrl(String url) {
            return null;
        }

        public void openNetDiskHomePage(String url) {
        }

        public void openNetDiskBySwan(String schema) {
        }

        public void loadUrl(Context context, String url, boolean fromHome, boolean openInNewWindow) {
        }
    };
    public static final String LOG_TAG = "IYunApp";

    String encodeUrl(String str);

    String getHashedString(String str);

    void loadUrl(Context context, String str, boolean z, boolean z2);

    void openNetDiskBySwan(String str);

    void openNetDiskHomePage(String str);

    public static final class Impl {
        private static IYunApp sIYunApp = DownloadRuntime.getYunApp();

        private Impl() {
        }

        public static IYunApp get() {
            if (sIYunApp == null) {
                Log.w(IYunApp.LOG_TAG, "Fetch IYunApp implementation failed, IYunApp.EMPTY applied");
                sIYunApp = IYunApp.EMPTY;
            }
            return sIYunApp;
        }
    }
}
