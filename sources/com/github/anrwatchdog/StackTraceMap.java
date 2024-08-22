package com.github.anrwatchdog;

import android.os.Looper;
import java.util.LinkedHashMap;

public class StackTraceMap {
    private int mMaxEntryCount = 100;
    private final LinkedHashMap<Long, StackTraceElement[]> mStackMap = new LinkedHashMap<>();

    public void collectMainStackTrace() {
        int size = this.mStackMap.size();
        int i2 = this.mMaxEntryCount;
        if (size == i2 && i2 > 0) {
            LinkedHashMap<Long, StackTraceElement[]> linkedHashMap = this.mStackMap;
            linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
        }
        this.mStackMap.put(Long.valueOf(System.currentTimeMillis()), Looper.getMainLooper().getThread().getStackTrace());
    }

    public LinkedHashMap<Long, StackTraceElement[]> getmStackMap() {
        return this.mStackMap;
    }
}
