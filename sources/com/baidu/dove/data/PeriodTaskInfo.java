package com.baidu.dove.data;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class PeriodTaskInfo {
    public long endPeriodTime;
    public String pageInfo = "";
    public long startPeriodTime;
    public HashMap<String, Integer> viewSys2HitchesTimeMap = new HashMap<>();
    public HashMap<String, Integer> viewSys2LongTaskCountMap = new HashMap<>();
    public ConcurrentHashMap<String, CopyOnWriteArrayList<StackTraceData>> viewSys2LongTaskTraceMap = new ConcurrentHashMap<>();

    public String toString() {
        return "PeriodTaskInfo{pageInfo='" + this.pageInfo + '\'' + ", startPeriodTime=" + this.startPeriodTime + ", endPeriodTime=" + this.endPeriodTime + ", viewSys2HitchesTimeMap=" + this.viewSys2HitchesTimeMap + ", viewSys2LongTaskCountMap=" + this.viewSys2LongTaskCountMap + ", viewSys2LongTaskTraceMap=" + this.viewSys2LongTaskTraceMap + AbstractJsonLexerKt.END_OBJ;
    }
}
