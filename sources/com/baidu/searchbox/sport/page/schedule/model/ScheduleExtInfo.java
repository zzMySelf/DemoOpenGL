package com.baidu.searchbox.sport.page.schedule.model;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ScheduleExtInfo implements Serializable {
    long refreshInterval;

    public long getRefreshInterval() {
        return this.refreshInterval;
    }

    public String toString() {
        return "ScheduleExtInfo{refreshInterval=" + this.refreshInterval + AbstractJsonLexerKt.END_OBJ;
    }
}
