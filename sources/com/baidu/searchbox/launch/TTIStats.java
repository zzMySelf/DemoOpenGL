package com.baidu.searchbox.launch;

import android.os.Looper;
import android.util.Log;
import com.baidu.launch.stats.ApplicationStatsHelper;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import java.util.Map;

public class TTIStats {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "TTIStats";
    private static final String UBC_DEVICE_SCORE_KEY = "device_score";
    private static final String UBC_FIRST_AVAILABLE_TIME = "first_available_time";
    private static final String UBC_LAUNCH_TYPE_KEY = "launch_type";
    private static final String UBC_PROCESS_AVAILABLE_TIME_KEY = "process_available_time";
    private static final String UBC_STAGE_KEY = "stage";
    private static final String UBC_STARTTS_KEY = "startts";
    private static final String UBC_START_LAUNCH_ID = "3112";
    private static Map<String, TTIData> mRecordMap = new HashMap();
    private static long sAppCreateTimeStamp = -1;
    private static boolean sHasStat = false;

    public static class TTIData {
        public long duration;
        public long startTs;

        public TTIData(long duration2, long startTs2) {
            this.duration = duration2;
            this.startTs = startTs2;
        }
    }

    public static Map<String, TTIData> getRecordMap() {
        return mRecordMap;
    }

    public static void record(String tag, long time) {
        if (SmartLaunchStats.getIdleTaskStartTime() <= 0) {
            if (sAppCreateTimeStamp < 0) {
                sAppCreateTimeStamp = ApplicationStatsHelper.sStartTime;
            }
            boolean async = false;
            if (Looper.getMainLooper() != Looper.myLooper()) {
                tag = tag + "_async";
                async = true;
            }
            TTIData data = mRecordMap.get(tag);
            if (data != null) {
                data.duration += time;
            } else {
                data = new TTIData(time, SmartLaunchStats.getFixedStartts(System.currentTimeMillis() - time, sAppCreateTimeStamp, async));
                mRecordMap.put(tag, data);
            }
            if (DEBUG) {
                Log.d(TAG, "name:" + tag + " time:" + time + " startTs:" + data.startTs);
            }
        }
    }
}
