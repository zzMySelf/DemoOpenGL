package com.baidu.searchbox.clearcache.filewatcher;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.clearcache.interfaces.abtest.ClearCacheTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.DiskUtilKt;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpiredFileDataHelper {
    private static final String ABTEST_KEY_EXPIRED_WATCH_ENABLE = "expire_file_watch_enable";
    private static final String KEY_DIRS = "dirs";
    private static final String KEY_ENABLE = "enable";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_WATCHER = "watcher_";
    private static final String KEY_WHITE_LIST = "whitelist";
    private static final String SP_DISK_APP_VERSION_KEY = "disk_app_version_key";
    private static final String SP_KEY_EXPIRED_LEVEL_DATA = "disk_expired_level_data";
    private static final String SP_KEY_EXPIRED_WATCHER_DIR_DATA = "disk_expired_watcher_data";
    private static final String SP_KEY_EXPIRED_WATCHER_ENABLE = "disk_expired_watcher_enable";
    private static final String SP_KEY_EXPIRED_WHITE_LIST_DATA = "disk_expired_white_list_data";
    private static final String TAG = "ExpiredFileDataUtil";

    public static void saveExpiredData(JSONObject data) {
        if (data != null) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "DiskClearCache saveExpiredData data: " + data);
            }
            ExpireFileSharedPrefsUtils.INSTANCE.putBoolean(SP_KEY_EXPIRED_WATCHER_ENABLE, data.optBoolean("enable", false));
            JSONObject expiredLevelJson = data.optJSONObject("level");
            if (expiredLevelJson != null) {
                ExpireFileSharedPrefsUtils.INSTANCE.putString(SP_KEY_EXPIRED_LEVEL_DATA, expiredLevelJson.toString());
            }
            JSONObject watchDirJson = data.optJSONObject("dirs");
            if (watchDirJson != null) {
                ExpireFileSharedPrefsUtils.INSTANCE.putString(SP_KEY_EXPIRED_WATCHER_DIR_DATA, watchDirJson.toString());
            }
            JSONObject whiteListJson = data.optJSONObject(KEY_WHITE_LIST);
            if (whiteListJson != null) {
                ExpireFileSharedPrefsUtils.INSTANCE.putString(SP_KEY_EXPIRED_WHITE_LIST_DATA, whiteListJson.toString());
            } else {
                ExpireFileSharedPrefsUtils.INSTANCE.putString(SP_KEY_EXPIRED_WHITE_LIST_DATA, "");
            }
        }
    }

    public static boolean isWatcherEnable() {
        if (AppConfig.isDebug()) {
            return true;
        }
        boolean abSwitch = ClearCacheTestManager.getApi().getAbSwitch(ABTEST_KEY_EXPIRED_WATCH_ENABLE) == 1;
        boolean remoteSwitch = ExpireFileSharedPrefsUtils.INSTANCE.getBoolean(SP_KEY_EXPIRED_WATCHER_ENABLE, false);
        if (!abSwitch || !remoteSwitch) {
            return false;
        }
        return true;
    }

    public static int getExpireDayByDiskLevel(String level) {
        String levelData = ExpireFileSharedPrefsUtils.INSTANCE.getString(SP_KEY_EXPIRED_LEVEL_DATA, (String) null);
        if (TextUtils.isEmpty(levelData)) {
            return -1;
        }
        try {
            int levelDay = new JSONObject(levelData).optInt(level, 0);
            if (levelDay > 0) {
                return levelDay;
            }
            if (!AppConfig.isDebug()) {
                return -1;
            }
            Log.d(TAG, "DiskClearCache getExpireLevelTime levelDay: " + levelDay);
            return -1;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static HashMap<String, List<String>> getExpiredWatcherDirs() {
        String expiredWatchData = ExpireFileSharedPrefsUtils.INSTANCE.getString(SP_KEY_EXPIRED_WATCHER_DIR_DATA, (String) null);
        HashMap<String, List<String>> watchDirMap = new HashMap<>();
        if (!TextUtils.isEmpty(expiredWatchData)) {
            try {
                JSONObject expiredWatchJson = new JSONObject(expiredWatchData);
                Iterator<String> bizKeys = expiredWatchJson.keys();
                Pattern pattern = Pattern.compile("\\/\\*\\*");
                while (bizKeys.hasNext()) {
                    String bizKey = bizKeys.next();
                    JSONArray bizExpiredWatchArray = expiredWatchJson.getJSONArray(bizKey);
                    List<String> bizExpiredWatchDirs = new ArrayList<>();
                    if (bizExpiredWatchArray != null) {
                        for (int i2 = 0; i2 < bizExpiredWatchArray.length(); i2++) {
                            String watchDir = bizExpiredWatchArray.getString(i2);
                            if (!TextUtils.isEmpty(watchDir)) {
                                String watchDir2 = DiskUtilKt.restoreFilePath(watchDir);
                                Matcher matcher = pattern.matcher(watchDir2);
                                if (matcher.find()) {
                                    String rootDir = watchDir2.substring(0, matcher.start());
                                    bizExpiredWatchDirs.add(rootDir);
                                    int maxDepth = 1;
                                    matcher.lookingAt();
                                    while (matcher.find()) {
                                        maxDepth++;
                                    }
                                    scanSubDir(rootDir, bizExpiredWatchDirs, 0, maxDepth);
                                } else {
                                    bizExpiredWatchDirs.add(watchDir2);
                                }
                            }
                        }
                        watchDirMap.put(bizKey, bizExpiredWatchDirs);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return watchDirMap;
    }

    public static HashMap<String, List<String>> getExpiredWhiteListMap() {
        String expiredWhiteListData = ExpireFileSharedPrefsUtils.INSTANCE.getString(SP_KEY_EXPIRED_WHITE_LIST_DATA, (String) null);
        HashMap<String, List<String>> expireWhiteListMap = new HashMap<>();
        if (!TextUtils.isEmpty(expiredWhiteListData)) {
            try {
                JSONObject whiteListJson = new JSONObject(expiredWhiteListData);
                Iterator<String> bizKeys = whiteListJson.keys();
                Pattern pattern = Pattern.compile("\\/\\*\\*");
                while (bizKeys.hasNext()) {
                    String bizKey = bizKeys.next();
                    JSONArray bizWhiteListArray = whiteListJson.getJSONArray(bizKey);
                    List<String> bizWhiteListDirs = new ArrayList<>();
                    if (bizWhiteListArray != null) {
                        for (int i2 = 0; i2 < bizWhiteListArray.length(); i2++) {
                            String filePath = bizWhiteListArray.getString(i2);
                            if (!TextUtils.isEmpty(filePath)) {
                                String filePath2 = DiskUtilKt.restoreFilePath(filePath);
                                Matcher matcher = pattern.matcher(filePath2);
                                if (matcher.find()) {
                                    String rootDir = filePath2.substring(0, matcher.start());
                                    int maxDepth = 1;
                                    matcher.lookingAt();
                                    while (matcher.find()) {
                                        maxDepth++;
                                    }
                                    scanSubDir(rootDir, bizWhiteListDirs, 0, maxDepth);
                                } else {
                                    bizWhiteListDirs.add(filePath2);
                                }
                            }
                        }
                        expireWhiteListMap.put(bizKey, bizWhiteListDirs);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return expireWhiteListMap;
    }

    public static void scanSubDir(String rootDir, List<String> fileList, int depth, int maxDepth) {
        String[] list;
        int depth2 = depth + 1;
        File baseDir = new File(rootDir);
        if (baseDir.exists() && baseDir.isDirectory() && (list = baseDir.list()) != null) {
            for (int i2 = 0; i2 < list.length; i2++) {
                File file = new File(rootDir + "/" + list[i2]);
                if (file.isDirectory() && depth2 < maxDepth) {
                    fileList.add(file.getAbsolutePath());
                    scanSubDir(rootDir + "/" + list[i2], fileList, depth2, maxDepth);
                }
            }
        }
    }

    public static void saveExpiredWatchStartTime(File file) {
        if (file != null) {
            ExpireFileSharedPrefsUtils.INSTANCE.putLong(KEY_WATCHER + file.getAbsolutePath(), System.currentTimeMillis());
        }
    }

    public static long getDirStartWatchTime(File file) {
        return ExpireFileSharedPrefsUtils.INSTANCE.getLong(KEY_WATCHER + file.getAbsolutePath(), 0);
    }

    public static void clearDirStartWatchTime(File file) {
        String filePath = file.getAbsolutePath();
        if (AppConfig.isDebug()) {
            Log.d(TAG, "DiskClearCache clearDirStartWatchTime  " + filePath);
        }
        ExpireFileSharedPrefsUtils.INSTANCE.remove(KEY_WATCHER + filePath);
    }

    public static List<String> getLocalAllWatchDirs() {
        Map<String, ?> expiredLocalKVValue = ExpireFileSharedPrefsUtils.INSTANCE.getAll();
        if (expiredLocalKVValue == null) {
            return null;
        }
        try {
            List<String> watchDirList = new ArrayList<>();
            for (String key : expiredLocalKVValue.keySet()) {
                if (!TextUtils.isEmpty(key) && key.startsWith(KEY_WATCHER)) {
                    watchDirList.add(key.substring(KEY_WATCHER.length()));
                }
            }
            return watchDirList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isAppUpgrade() {
        boolean upgrade = false;
        String currentVersion = ClearCacheUtils.getAppVersionName(AppRuntime.getAppContext());
        String lastVersion = ExpireFileSharedPrefsUtils.INSTANCE.getString(SP_DISK_APP_VERSION_KEY, "");
        if (!TextUtils.isEmpty(lastVersion) && !TextUtils.isEmpty(currentVersion) && !TextUtils.equals(lastVersion, currentVersion)) {
            upgrade = true;
        }
        ExpireFileSharedPrefsUtils.INSTANCE.putString(SP_DISK_APP_VERSION_KEY, currentVersion);
        return upgrade;
    }
}
