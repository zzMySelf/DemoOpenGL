package com.baidu.searchbox.config;

import android.annotation.SuppressLint;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.o.qw;

@SuppressLint({"BDOfflineUrl"})
public final class HostConfig {

    public interface ConfigInterceptor {
    }

    public static boolean ad() {
        boolean z = true;
        if (!qw.qw().getBoolean("key_box_use_https", true) || AppConfig.qw.qw()) {
            z = false;
        }
        return AppConfig.qw("SERACHBOX_USE_HTTPS", z);
    }

    public static String qw() {
        return AppConfig.ad("SEARCH_BOX_HOST", ad() ? "https://mbd.baidu.com" : "http://mbd.baidu.com");
    }
}
