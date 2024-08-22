package com.baidu.searchbox.video.feedflow.cache.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/cache/model/OfflineCacheForbidFlag;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NOT_WIFI", "FORBID_PERIOD", "FORBID_PAGE", "EXCEED_CAPACITY", "DISK_CRITICAL", "CLEAN_LIMIT", "MEDIA_UN_SUPPORT", "DEFAULT", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OfflineCacheRunTimeStatus.kt */
public enum OfflineCacheForbidFlag {
    NOT_WIFI("notWifi"),
    FORBID_PERIOD("forbidPeriod"),
    FORBID_PAGE("forbidPage"),
    EXCEED_CAPACITY("exceedCapacity"),
    DISK_CRITICAL("diskCritical"),
    CLEAN_LIMIT("cleanLimit"),
    MEDIA_UN_SUPPORT("duMediaNotSupport"),
    DEFAULT("");
    
    private final String value;

    private OfflineCacheForbidFlag(String value2) {
        this.value = value2;
    }

    public final String getValue() {
        return this.value;
    }
}
