package com.baidu.searchbox.debug.smooth.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SMLogEntry {
    private static SimpleDateFormat saveFormatter = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
    public String activityName;
    public long id;
    public int skip;

    public SMLogEntry(String act, long id2, int skip2) {
        this.activityName = act;
        this.id = id2;
        this.skip = skip2;
    }

    public String toString() {
        String dateString = getSaveTime(this.id);
        StringBuffer sb = new StringBuffer();
        sb.append(dateString);
        sb.append(",").append(this.activityName);
        sb.append(",").append(this.id);
        sb.append(",").append(this.skip);
        return sb.toString();
    }

    private String getSaveTime(long data) {
        return saveFormatter.format(new Date(data));
    }
}
