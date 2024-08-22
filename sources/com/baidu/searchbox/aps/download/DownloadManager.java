package com.baidu.searchbox.aps.download;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.aps.base.Plugin;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DownloadManager {
    private static final String TAG = "DownloadManager";
    private static DownloadDBHelper sDbHelper;
    private static DownloadManager sInstance;
    private List<DownloadTask> downloadTasks = new CopyOnWriteArrayList();
    private Map<String, State> finishUrlToState = new ConcurrentHashMap();

    private DownloadManager(Context context) {
        sDbHelper = DownloadDBHelper.getInstance(context);
    }

    public static DownloadManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DownloadManager.class) {
                if (sInstance == null) {
                    sInstance = new DownloadManager(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    public State getDownloadState(String url) {
        for (DownloadTask downloadTask : this.downloadTasks) {
            if (downloadTask.getDownloadUrl().equals(url)) {
                return downloadTask.getCurState();
            }
        }
        for (String finishUrl : this.finishUrlToState.keySet()) {
            if (finishUrl.equals(url)) {
                return this.finishUrlToState.get(finishUrl);
            }
        }
        return State.NONE;
    }

    public DownloadTask getDownloadTask(String url) {
        for (DownloadTask downloadTask : this.downloadTasks) {
            if (downloadTask.getDownloadUrl().equals(url)) {
                return downloadTask;
            }
        }
        return null;
    }

    public List<DownloadTask> getDownloadTasks(String url, String filePath) {
        List<DownloadTask> list = new ArrayList<>();
        for (DownloadTask downloadTask : this.downloadTasks) {
            if (downloadTask.getDownloadUrl().equals(url) || downloadTask.getDownloadPath().equals(filePath)) {
                list.add(downloadTask);
            }
        }
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    public DownloadTask startDownload(Plugin plugin, String url, String host, File target, DownloadCallback callback) {
        if (target != null && !target.exists()) {
            target.getParentFile().mkdirs();
        }
        for (DownloadTask downloadTask : this.downloadTasks) {
            if (downloadTask.getTargetFile().equals(target)) {
                return null;
            }
        }
        DownloadTask downloadTask2 = new DownloadTask(this, plugin, sDbHelper, url, host, target, callback);
        this.downloadTasks.add(downloadTask2);
        downloadTask2.execute();
        return downloadTask2;
    }

    public void clearDownloadByTargetFile(File file) {
        List<DownloadTask> toClearTasks = new ArrayList<>();
        for (DownloadTask downloadTask : this.downloadTasks) {
            if (downloadTask.getTargetFile().equals(file)) {
                toClearTasks.add(downloadTask);
            }
        }
        this.downloadTasks.removeAll(toClearTasks);
    }

    public void clearDownload(String url, String filePath) {
        List<DownloadTask> taskList = getDownloadTasks(url, filePath);
        if (taskList != null) {
            for (DownloadTask task : taskList) {
                if (task != null) {
                    this.downloadTasks.remove(task);
                    task.clear();
                }
            }
        }
    }

    public void cancelDownload(String url) {
        DownloadTask task = getDownloadTask(url);
        if (task != null) {
            task.cancel();
        }
    }

    public void pauseDownload(String url) {
        DownloadTask task = getDownloadTask(url);
        if (task != null) {
            task.pause();
        }
    }

    public void resumeDownload(String url, DownloadCallback callback) {
        DownloadTask task = getDownloadTask(url);
        if (task != null) {
            task.resume(callback);
        }
    }

    public void pauseAll() {
        for (DownloadTask task : this.downloadTasks) {
            task.pause();
        }
    }

    public void cancelAll() {
        for (DownloadTask task : this.downloadTasks) {
            task.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void finish(DownloadTask task) {
        this.downloadTasks.remove(task);
        sDbHelper.deleteInfo(task.getDownloadUrl());
        this.finishUrlToState.put(task.getDownloadUrl(), task.getCurState());
    }

    public enum State {
        DOWNLOADING,
        SUCCESS,
        FAILED,
        NOT_START_YET,
        NONE,
        CANCEL,
        PAUSE;

        public static State fromString(String name) {
            if (!TextUtils.isEmpty(name)) {
                try {
                    return (State) Enum.valueOf(State.class, name.trim().toUpperCase());
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            }
            return NONE;
        }
    }
}
