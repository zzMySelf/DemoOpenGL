package com.baidu.searchbox.clearcache.filewatcher;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.file.watcher.time.FileTimeHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExpiredFileWatcherManager {
    private static final String TAG = "ExpiredWatcherManager";
    private static ExpiredFileWatcherManager mFileWatcherManager;
    private List<ExpiredFileWatcher> mExpiredFileWatchers = new ArrayList();
    /* access modifiers changed from: private */
    public HashMap<String, List<String>> mExpiredWatcherDirs;
    private HashMap<String, List<String>> mExpiredWhiteListDirs;

    public static ExpiredFileWatcherManager getInstance() {
        if (mFileWatcherManager == null) {
            synchronized (ExpiredFileWatcherManager.class) {
                if (mFileWatcherManager == null) {
                    mFileWatcherManager = new ExpiredFileWatcherManager();
                }
            }
        }
        return mFileWatcherManager;
    }

    /* Debug info: failed to restart local var, previous not found, register: 9 */
    public synchronized void startWatcher() {
        boolean enable = ExpiredFileDataHelper.isWatcherEnable();
        if (AppConfig.isDebug()) {
            Log.d(TAG, "DiskClearCache startWatcher: enable " + enable);
        }
        if (enable) {
            if (this.mExpiredWatcherDirs == null) {
                this.mExpiredWatcherDirs = ExpiredFileDataHelper.getExpiredWatcherDirs();
            }
            if (this.mExpiredWhiteListDirs == null) {
                this.mExpiredWhiteListDirs = ExpiredFileDataHelper.getExpiredWhiteListMap();
            }
            List<File> watcherDirList = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : this.mExpiredWatcherDirs.entrySet()) {
                List<String> watchDirs = entry.getValue();
                if (watchDirs != null && watchDirs.size() > 0) {
                    for (String path : watchDirs) {
                        File file = new File(path);
                        if (file.exists()) {
                            watcherDirList.add(file);
                        }
                    }
                }
            }
            if (watcherDirList.size() != 0) {
                if (AppConfig.isDebug()) {
                    for (File file2 : watcherDirList) {
                        Log.d(TAG, "DiskClearCache start watcher file : " + file2.getAbsolutePath());
                    }
                }
                for (File dir : watcherDirList) {
                    if (dir.exists()) {
                        ExpiredFileWatcher fileWatcher = new ExpiredFileWatcher(dir);
                        fileWatcher.startWatching();
                        if (!this.mExpiredFileWatchers.contains(fileWatcher)) {
                            this.mExpiredFileWatchers.add(fileWatcher);
                        }
                        if (ExpiredFileDataHelper.getDirStartWatchTime(dir) == 0) {
                            ExpiredFileDataHelper.saveExpiredWatchStartTime(dir);
                        }
                    }
                }
                checkAndResetWatchDirTime();
            }
        }
    }

    public void stopWatching() {
        for (ExpiredFileWatcher fileWatcher : this.mExpiredFileWatchers) {
            if (fileWatcher != null) {
                fileWatcher.stopWatching();
            }
        }
    }

    public synchronized HashMap<String, List<ExpiredFile>> getExpireFilesByDiskLevel(String diskLevel) {
        return getExpireFilesByDays(ExpiredFileDataHelper.getExpireDayByDiskLevel(diskLevel));
    }

    /* Debug info: failed to restart local var, previous not found, register: 38 */
    public synchronized HashMap<String, List<ExpiredFile>> getExpireFilesByDays(int expiredLevelDay) {
        Iterator<Map.Entry<String, List<String>>> it;
        long expiredLevelTime;
        Iterator<Map.Entry<String, List<String>>> it2;
        List<ExpiredFile> bizWatchDirs;
        List<String> expiredWhiteList;
        long expiredLevelTime2;
        Map.Entry<String, List<String>> entry;
        List<String> bizWatchDirs2;
        Iterator<String> it3;
        List<String> bizExpiredWhiteList;
        Iterator<Map.Entry<String, List<String>>> it4;
        List<ExpiredFile> bizWatchDirs3;
        long currentTime;
        List<String> expiredWhiteList2;
        long expiredLevelTime3;
        int i2;
        boolean aTimeEnable;
        long startWatchTime;
        File file;
        List<ExpiredFile> bizExpiredFileList;
        List<ExpiredFile> bizExpiredFileList2;
        long checkTime;
        ExpiredFileWatcherManager expiredFileWatcherManager = this;
        int i3 = expiredLevelDay;
        synchronized (this) {
            HashMap<String, List<ExpiredFile>> expiredFileMap = new HashMap<>();
            if (i3 <= 0) {
                return expiredFileMap;
            }
            if (expiredFileWatcherManager.mExpiredWatcherDirs == null) {
                return expiredFileMap;
            }
            long expiredLevelTime4 = TimeUnit.DAYS.toMillis((long) i3);
            Iterator<Map.Entry<String, List<String>>> it5 = expiredFileWatcherManager.mExpiredWatcherDirs.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<String>> entry2 = it.next();
                String bizName = entry2.getKey();
                List<String> bizWatchDirs4 = entry2.getValue();
                List<ExpiredFile> bizExpiredFileList3 = new ArrayList<>();
                List<String> expiredWhiteList3 = new ArrayList<>();
                List<String> bizExpiredWhiteList2 = expiredFileWatcherManager.mExpiredWhiteListDirs.get(bizName);
                if (bizExpiredWhiteList2 != null) {
                    expiredWhiteList3.addAll(bizExpiredWhiteList2);
                }
                if (bizWatchDirs4 == null || bizWatchDirs4.size() <= 0) {
                    expiredLevelTime = expiredLevelTime4;
                    it2 = it;
                    Map.Entry<String, List<String>> entry3 = entry2;
                    List<String> list = bizWatchDirs4;
                    bizWatchDirs = bizExpiredFileList3;
                    List<String> list2 = expiredWhiteList3;
                    List<String> list3 = bizExpiredWhiteList2;
                } else {
                    Iterator<String> it6 = bizWatchDirs4.iterator();
                    while (it6.hasNext()) {
                        String dir = it6.next();
                        File watchDir = new File(dir);
                        if (watchDir.exists()) {
                            long startWatchTime2 = ExpiredFileDataHelper.getDirStartWatchTime(watchDir);
                            long currentTime2 = System.currentTimeMillis();
                            boolean aTimeEnable2 = false;
                            it4 = it;
                            entry = entry2;
                            long startWatchTime3 = startWatchTime2;
                            if (startWatchTime3 > 0) {
                                bizExpiredWhiteList = bizExpiredWhiteList2;
                                it3 = it6;
                                currentTime = currentTime2;
                                if (currentTime - startWatchTime3 > expiredLevelTime4) {
                                    aTimeEnable2 = true;
                                }
                            } else {
                                bizExpiredWhiteList = bizExpiredWhiteList2;
                                it3 = it6;
                                currentTime = currentTime2;
                            }
                            if (AppConfig.isDebug()) {
                                bizWatchDirs2 = bizWatchDirs4;
                                String str = dir;
                                Log.d(TAG, "DiskClearCache start check watchDir's expired file : " + watchDir + " startWatchTime " + startWatchTime3 + " currentTime " + currentTime + " expiredLevelTime " + expiredLevelTime4 + " aTimeEnable " + aTimeEnable2);
                            } else {
                                bizWatchDirs2 = bizWatchDirs4;
                                String str2 = dir;
                            }
                            if (!aTimeEnable2) {
                                int i4 = expiredLevelDay;
                                it = it4;
                                bizExpiredWhiteList2 = bizExpiredWhiteList;
                                it6 = it3;
                                bizWatchDirs4 = bizWatchDirs2;
                                entry2 = entry;
                            } else {
                                File[] files = watchDir.listFiles();
                                if (files != null) {
                                    int length = files.length;
                                    int i5 = 0;
                                    while (i5 < length) {
                                        File file2 = files[i5];
                                        File[] files2 = files;
                                        if (expiredWhiteList3.contains(file2.getAbsolutePath())) {
                                            expiredLevelTime3 = expiredLevelTime4;
                                            startWatchTime = startWatchTime3;
                                            i2 = length;
                                            bizExpiredFileList = bizExpiredFileList3;
                                            expiredWhiteList2 = expiredWhiteList3;
                                            file = watchDir;
                                            aTimeEnable = aTimeEnable2;
                                        } else {
                                            startWatchTime = startWatchTime3;
                                            File file3 = file2;
                                            file = watchDir;
                                            boolean aTimeEnable3 = aTimeEnable2;
                                            long lastAccessTime = FileTimeHelper.getInstance().getFileLastAccessTime(file3);
                                            long lastModifyTime = file3.lastModified();
                                            long checkTime2 = Math.max(lastAccessTime, lastModifyTime);
                                            if (AppConfig.isDebug()) {
                                                aTimeEnable = aTimeEnable3;
                                                i2 = length;
                                                expiredWhiteList2 = expiredWhiteList3;
                                                bizExpiredFileList2 = bizExpiredFileList3;
                                                checkTime = checkTime2;
                                                Log.d(TAG, "DiskClearCache start check expired file  " + file3.getAbsolutePath() + " lastAccessTime  : " + lastAccessTime + " lastModifyTime " + lastModifyTime + " checkTime " + checkTime);
                                            } else {
                                                aTimeEnable = aTimeEnable3;
                                                i2 = length;
                                                bizExpiredFileList2 = bizExpiredFileList3;
                                                expiredWhiteList2 = expiredWhiteList3;
                                                checkTime = checkTime2;
                                            }
                                            if (currentTime - checkTime > expiredLevelTime4) {
                                                ExpiredFile expiredFile = new ExpiredFile(lastAccessTime, lastModifyTime, file3.getAbsolutePath());
                                                bizExpiredFileList = bizExpiredFileList2;
                                                bizExpiredFileList.add(expiredFile);
                                                if (AppConfig.isDebug()) {
                                                    long j2 = lastModifyTime;
                                                    expiredLevelTime3 = expiredLevelTime4;
                                                    Log.d(TAG, "DiskClearCache the file is expired : " + expiredFile.toString());
                                                } else {
                                                    expiredLevelTime3 = expiredLevelTime4;
                                                }
                                            } else {
                                                expiredLevelTime3 = expiredLevelTime4;
                                                bizExpiredFileList = bizExpiredFileList2;
                                            }
                                        }
                                        i5++;
                                        bizExpiredFileList3 = bizExpiredFileList;
                                        files = files2;
                                        watchDir = file;
                                        startWatchTime3 = startWatchTime;
                                        aTimeEnable2 = aTimeEnable;
                                        length = i2;
                                        expiredLevelTime4 = expiredLevelTime3;
                                        expiredWhiteList3 = expiredWhiteList2;
                                    }
                                    expiredLevelTime2 = expiredLevelTime4;
                                    long j3 = startWatchTime3;
                                    bizWatchDirs3 = bizExpiredFileList3;
                                    expiredWhiteList = expiredWhiteList3;
                                    File file4 = watchDir;
                                    boolean z = aTimeEnable2;
                                } else {
                                    expiredLevelTime2 = expiredLevelTime4;
                                    long j4 = startWatchTime3;
                                    bizWatchDirs3 = bizExpiredFileList3;
                                    expiredWhiteList = expiredWhiteList3;
                                    File file5 = watchDir;
                                    boolean z2 = aTimeEnable2;
                                }
                            }
                        } else {
                            expiredLevelTime2 = expiredLevelTime4;
                            it4 = it;
                            entry = entry2;
                            bizWatchDirs2 = bizWatchDirs4;
                            bizWatchDirs3 = bizExpiredFileList3;
                            expiredWhiteList = expiredWhiteList3;
                            bizExpiredWhiteList = bizExpiredWhiteList2;
                            it3 = it6;
                            String str3 = dir;
                            File file6 = watchDir;
                        }
                        int i6 = expiredLevelDay;
                        bizExpiredFileList3 = bizWatchDirs3;
                        it = it4;
                        bizExpiredWhiteList2 = bizExpiredWhiteList;
                        it6 = it3;
                        bizWatchDirs4 = bizWatchDirs2;
                        entry2 = entry;
                        expiredLevelTime4 = expiredLevelTime2;
                        expiredWhiteList3 = expiredWhiteList;
                    }
                    expiredLevelTime = expiredLevelTime4;
                    it2 = it;
                    Map.Entry<String, List<String>> entry4 = entry2;
                    List<String> list4 = bizWatchDirs4;
                    bizWatchDirs = bizExpiredFileList3;
                    List<String> list5 = expiredWhiteList3;
                    List<String> list6 = bizExpiredWhiteList2;
                }
                if (AppConfig.isDebug()) {
                    for (ExpiredFile file7 : bizWatchDirs) {
                        Log.d(TAG, "DiskClearCache expireFile  : " + file7.toString());
                    }
                }
                if (bizWatchDirs.size() > 0) {
                    expiredFileMap.put(bizName, bizWatchDirs);
                }
                expiredFileWatcherManager = this;
                int i7 = expiredLevelDay;
                it5 = it2;
                expiredLevelTime4 = expiredLevelTime;
            }
            return expiredFileMap;
        }
    }

    private void checkAndResetWatchDirTime() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (ExpiredFileDataHelper.isAppUpgrade()) {
                    if (ExpiredFileWatcherManager.this.mExpiredWatcherDirs == null) {
                        HashMap unused = ExpiredFileWatcherManager.this.mExpiredWatcherDirs = ExpiredFileDataHelper.getExpiredWatcherDirs();
                    }
                    List<String> watcherDirList = new ArrayList<>();
                    for (Map.Entry<String, List<String>> entry : ExpiredFileWatcherManager.this.mExpiredWatcherDirs.entrySet()) {
                        List<String> watchDirs = entry.getValue();
                        if (watchDirs != null && watchDirs.size() > 0) {
                            for (String path : watchDirs) {
                                watcherDirList.add(path);
                            }
                        }
                    }
                    List<String> localWatchDirs = ExpiredFileDataHelper.getLocalAllWatchDirs();
                    if (localWatchDirs != null) {
                        for (String watchDir : localWatchDirs) {
                            if (!watcherDirList.contains(watchDir)) {
                                if (AppConfig.isDebug()) {
                                    Log.d(ExpiredFileWatcherManager.TAG, "DiskClearCache checkWatchDirTime  clear " + watchDir);
                                }
                                ExpiredFileDataHelper.clearDirStartWatchTime(new File(watchDir));
                            }
                        }
                    }
                }
            }
        }, "checkAndResetWatchTime", 3);
    }
}
