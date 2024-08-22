package com.baidu.searchbox.log.core.dao;

import java.util.HashMap;

public class BIZPreset {
    public static final String PERF_BLOCK = "1157";
    public static final String PERF_CRASH = "1156";
    public static final String PERF_FETCH_FILE = "1332";
    public static final String PERF_FETCH_RECORD = "1289";
    public static final String PERF_FETCH_TEST = "666666";
    public static final String PERF_HOT_DISCUSSION_STABILITY = "1253";
    public static final String PERF_NATIVE_CRASH = "1156_1";
    public static final String PERF_START_UP = "691";
    public static final String PERF_UPDATE = "1272";
    public static final String PERF_UPLOAD_FILE = "1314";
    public static final long TTL = 2592000000L;
    static HashMap<String, BIZ> presetBIZMap = new HashMap<>();

    static {
        BIZ blockBiz = new BIZ("1156", "1", "1", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ blockBiz2 = new BIZ("1157", "1", "0", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ discussionBiz = new BIZ(PERF_HOT_DISCUSSION_STABILITY, "1", "1", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ updateBiz = new BIZ(PERF_UPDATE, "1", "1", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ fetchBiz = new BIZ("1289", "1", "1", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ fetchTestBiz = new BIZ(PERF_FETCH_TEST, "1", "0", "0", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ fetchFileBiz = new BIZ("1332", "1", "1", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ uploadFileBiz = new BIZ(PERF_UPLOAD_FILE, "1", "1", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        BIZ startUpBiz = new BIZ("691", "1", "1", "1", "1", "0", "1", 2, 5242880, 52428800, 2592000000L, -1, -1);
        presetBIZMap.put("1156", blockBiz);
        presetBIZMap.put("1157", blockBiz2);
        presetBIZMap.put(PERF_HOT_DISCUSSION_STABILITY, discussionBiz);
        presetBIZMap.put(PERF_UPDATE, updateBiz);
        presetBIZMap.put("1289", fetchBiz);
        presetBIZMap.put(PERF_FETCH_TEST, fetchTestBiz);
        presetBIZMap.put("1332", fetchFileBiz);
        presetBIZMap.put(PERF_UPLOAD_FILE, uploadFileBiz);
        presetBIZMap.put("691", startUpBiz);
    }

    public static BIZ getPresetBIZ(String bizID) {
        return presetBIZMap.get(bizID);
    }
}
