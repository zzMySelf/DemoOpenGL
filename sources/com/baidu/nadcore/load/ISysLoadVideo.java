package com.baidu.nadcore.load;

import com.baidu.pyramid.runtime.service.ServiceReference;

public interface ISysLoadVideo {
    public static final ISysLoadVideo EMPTY = new ISysLoadVideo() {
        public void prefetch(String url, int size) {
        }
    };
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("nad.core", "sysLoadVideo");

    void prefetch(String str, int i2);
}
