package com.baidu.searchbox.liveshow.config;

import com.baidu.searchbox.config.HostConfig;

public class LiveShowConfig {
    public static String getPageDataUrl() {
        return String.format("%s/searchbox?action=liveshow&cmd=251", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }
}
