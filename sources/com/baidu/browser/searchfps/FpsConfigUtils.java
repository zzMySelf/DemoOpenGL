package com.baidu.browser.searchfps;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import java.io.File;
import java.util.HashMap;

public class FpsConfigUtils {
    private static final Object FPS_FORCE_ENABLE_LOCK = new Object();
    private static final String LONG_TASK_FRAME_THRESHOLD_TIME = "LONG_TASK_FRAME_THRESHOLD_TIME";
    private static final String LONG_TASK_SAMPLE_TIME = "SAMPLE_TIME";
    private static final String LONG_TASK_STACK_FORCE_ENABLE = "LONG_TASK_STACK_FORCE_ENABLE";
    private static final String LONG_TASK_STACK_TIME = "LONG_TASK_STACK_TIME";
    private static final String SEARCH_FPS_FORCE_ENABLE_FILE_NAME = "search_browser_config";
    public static final int SEARCH_FPS_TEST_DEFAULT = 0;
    public static final int SEARCH_FPS_TEST_OPEN = 2;
    public static final int SEARCH_FPS_UPLOAD_STACK_OPEN = 1;
    public static final int SEARCH_LONG_TASK_FRAME_THRESHOLD_TIME_DEFAULT = 30;
    public static final int SEARCH_LONG_TASK_TIME_DEFAULT = 200;
    private static final int STATE_FALSE = 2;
    private static final int STATE_TRUE = 1;
    private static final int STATE_UNDEFINED = 0;
    private static HashMap<String, Integer> sForceLongTaskConfig;
    private static int sIsEnableSearchBrowserConfigState = 0;
    private static int sIsEnableSearchFPSState = 0;
    private static int sIsEnableSearchFPSUploadState = 0;
    private static int sSearchFPSTestValue = 0;

    public static boolean isSearchFrameFPSEnable() {
        if (!NgWebViewUtils.isEngineAvailable()) {
            return false;
        }
        if (sIsEnableSearchFPSState == 0) {
            syncSearchFrameTestState();
        }
        if (1 == sIsEnableSearchFPSState) {
            return true;
        }
        return false;
    }

    public static boolean isSearchFrameUploadStackEnable() {
        if (sIsEnableSearchFPSUploadState == 0) {
            syncSearchFrameTestState();
        }
        return 1 == sIsEnableSearchFPSUploadState;
    }

    public static boolean isSearchFPSUploadForceEnable() {
        HashMap<String, Integer> hashMap;
        if (!isSearchFrameFPSForceEnable() || (hashMap = sForceLongTaskConfig) == null || !hashMap.containsKey(LONG_TASK_STACK_FORCE_ENABLE)) {
            return false;
        }
        return sForceLongTaskConfig.get(LONG_TASK_STACK_FORCE_ENABLE).intValue() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void syncSearchFrameTestState() {
        /*
            java.lang.Class<com.baidu.browser.searchfps.FpsConfigUtils> r0 = com.baidu.browser.searchfps.FpsConfigUtils.class
            monitor-enter(r0)
            int r1 = sIsEnableSearchFPSState     // Catch:{ all -> 0x0068 }
            if (r1 != 0) goto L_0x0066
            int r1 = sIsEnableSearchFPSUploadState     // Catch:{ all -> 0x0068 }
            if (r1 != 0) goto L_0x0066
            r1 = 2
            sSearchFPSTestValue = r1     // Catch:{ all -> 0x0068 }
            r2 = r1 & r1
            r3 = 1
            if (r2 > 0) goto L_0x001c
            boolean r2 = isSearchFrameFPSForceEnable()     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = r1
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            sIsEnableSearchFPSState = r2     // Catch:{ all -> 0x0068 }
            int r2 = sSearchFPSTestValue     // Catch:{ all -> 0x0068 }
            r2 = r2 & r3
            if (r2 > 0) goto L_0x002a
            boolean r2 = isSearchFPSUploadForceEnable()     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x002b
        L_0x002a:
            r1 = r3
        L_0x002b:
            sIsEnableSearchFPSUploadState = r1     // Catch:{ all -> 0x0068 }
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0066
            java.lang.String r1 = "SearchPerformance"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r2.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "sSearchFPSTestValue="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0068 }
            int r3 = sSearchFPSTestValue     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = ", sIsEnableSearchFPSState="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0068 }
            int r3 = sIsEnableSearchFPSState     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = ", sIsEnableSearchFPSUploadState="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0068 }
            int r3 = sIsEnableSearchFPSUploadState     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0068 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0068 }
        L_0x0066:
            monitor-exit(r0)
            return
        L_0x0068:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.searchfps.FpsConfigUtils.syncSearchFrameTestState():void");
    }

    public static boolean isSearchFrameFPSForceEnable() {
        boolean z;
        synchronized (FPS_FORCE_ENABLE_LOCK) {
            z = false;
            if (sIsEnableSearchBrowserConfigState == 0) {
                String forceEnableFilePath = AppRuntime.getAppContext().getExternalFilesDir((String) null) + File.separator + SEARCH_FPS_FORCE_ENABLE_FILE_NAME;
                if (AppConfig.isDebug()) {
                    Log.d("SearchPerformance", "forceEnableFilePath=" + forceEnableFilePath);
                }
                File forceEnableFile = new File(forceEnableFilePath);
                int i2 = forceEnableFile.exists() ? 1 : 2;
                sIsEnableSearchBrowserConfigState = i2;
                if (i2 == 1) {
                    String data = FileUtils.readFileData(forceEnableFile);
                    if (!TextUtils.isEmpty(data)) {
                        if (AppConfig.isDebug()) {
                            Log.d("SearchPerformance", "forceEnableFilePath data=" + data);
                        }
                        String[] commands = data.split(";");
                        if (sForceLongTaskConfig == null) {
                            sForceLongTaskConfig = new HashMap<>();
                        }
                        for (String command : commands) {
                            String[] commandKeyValue = command.split("=");
                            if (commandKeyValue != null && commandKeyValue.length == 2) {
                                if (AppConfig.isDebug()) {
                                    Log.d("SearchPerformance", "forceEnableFilePath key=" + commandKeyValue[0] + ", value=" + commandKeyValue[1]);
                                }
                                if (TextUtils.equals(commandKeyValue[0], LONG_TASK_SAMPLE_TIME)) {
                                    sForceLongTaskConfig.put(LONG_TASK_SAMPLE_TIME, Integer.valueOf(commandKeyValue[1]));
                                } else if (TextUtils.equals(commandKeyValue[0], LONG_TASK_STACK_TIME)) {
                                    sForceLongTaskConfig.put(LONG_TASK_STACK_TIME, Integer.valueOf(commandKeyValue[1]));
                                } else if (TextUtils.equals(commandKeyValue[0], LONG_TASK_FRAME_THRESHOLD_TIME)) {
                                    sForceLongTaskConfig.put(LONG_TASK_FRAME_THRESHOLD_TIME, Integer.valueOf(commandKeyValue[1]));
                                } else if (TextUtils.equals(commandKeyValue[0], LONG_TASK_STACK_FORCE_ENABLE)) {
                                    sForceLongTaskConfig.put(LONG_TASK_STACK_FORCE_ENABLE, Integer.valueOf(commandKeyValue[1]));
                                }
                            }
                        }
                    }
                }
            }
            if (1 == sIsEnableSearchBrowserConfigState) {
                z = true;
            }
        }
        return z;
    }

    public static int getSearchFrameLongTaskTime() {
        HashMap<String, Integer> hashMap;
        if (!isSearchFrameFPSForceEnable() || (hashMap = sForceLongTaskConfig) == null || !hashMap.containsKey(LONG_TASK_STACK_TIME)) {
            return 200;
        }
        return sForceLongTaskConfig.get(LONG_TASK_STACK_TIME).intValue();
    }

    public static int getLongTaskFrameThreshold() {
        HashMap<String, Integer> hashMap;
        if (!isSearchFrameFPSForceEnable() || (hashMap = sForceLongTaskConfig) == null || !hashMap.containsKey(LONG_TASK_FRAME_THRESHOLD_TIME)) {
            return 30;
        }
        return sForceLongTaskConfig.get(LONG_TASK_FRAME_THRESHOLD_TIME).intValue();
    }

    public static int getSearchFrameSampleCollectTime() {
        HashMap<String, Integer> hashMap;
        if (!isSearchFrameFPSForceEnable() || (hashMap = sForceLongTaskConfig) == null || !hashMap.containsKey(LONG_TASK_SAMPLE_TIME)) {
            return 200;
        }
        return sForceLongTaskConfig.get(LONG_TASK_SAMPLE_TIME).intValue();
    }
}
