package com.baidu.swan.gamecenter.appmanager.download;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.gamecenter.appmanager.install.GameCenterApkUtil;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class AppDownloadStrategy {
    private static final long DAY_TIME = 86400000;
    private static final long DOWNLOAD_DAY_LIMIT = 30;
    private static final String HUAWEI_HIJACK = ".huawei";
    public static final String KEY_DOWNLOAD_TIME = "download_time";
    private static final int MAX_INSTALLED_DOWNLOAD_LIMIT = 30;
    private static final int MAX_UNINSTALLED_DOWNLOAD_LIMIT = 20;
    private static final String MI_HIJACK = ".mi";
    private static final String OPPO_HIJACK = ".nearme.gamecenter";
    private static final String TAG = "AppDownloadStrategy";
    private static final String VIVO_HIJACK = ".vivo";
    private DownloadManager mDownloadManager;

    public AppDownloadStrategy(DownloadManager downloadManager) {
        this.mDownloadManager = downloadManager;
    }

    public Collection<Download> queryAllDownloads() {
        return this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && !AppDownloadStrategy.this.isInvalidDownload(download);
            }
        });
    }

    public Download queryOneDownloadByUrl(String url) {
        Collection<Download> downloads = queryDownloadByUrl(url);
        if (downloads == null) {
            return null;
        }
        Download download = null;
        for (Download item : downloads) {
            if (item != null) {
                download = item;
            }
        }
        return download;
    }

    public Download queryOneDownload(String url, String packageName) {
        Download download = queryOneDownloadByUrl(url);
        if (download == null) {
            return queryDownloadByPackageName(packageName);
        }
        return download;
    }

    public Download queryDownloadByPackageName(final String packageName) {
        Collection<Download> downloads;
        if (TextUtils.isEmpty(packageName) || (downloads = this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getKeyByUser(), packageName);
            }
        })) == null) {
            return null;
        }
        Download download = null;
        for (Download item : downloads) {
            if (item != null) {
                download = item;
            }
        }
        return download;
    }

    public Download queryOneDownloadFinishByName(String pkgName) {
        Collection<Download> downloads = queryDownloadFinishByName(pkgName);
        if (downloads == null || downloads.size() == 0) {
            return null;
        }
        Download download = null;
        Iterator<Download> it = downloads.iterator();
        while (it.hasNext()) {
            download = it.next();
        }
        return download;
    }

    public Collection<Download> queryDownloadFinishByName(final String pkgName) {
        if (TextUtils.isEmpty(pkgName)) {
            return null;
        }
        return this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getKeyByUser(), pkgName) && download.getState() == Download.DownloadState.FINISH;
            }
        });
    }

    public synchronized Collection<Download> queryDownloadByPkgName(final String pkgName) {
        return this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getKeyByUser(), pkgName) && download.getState() == Download.DownloadState.FINISH;
            }
        });
    }

    public synchronized Collection<Download> queryDownloadByUrl(final String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getUrl(), url) && !AppDownloadStrategy.this.isInvalidDownload(download);
            }
        });
    }

    public synchronized boolean checkDownloadByPkgName(final String pkgName) {
        Collection<Download> list;
        list = this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getKeyByUser(), pkgName);
            }
        });
        return list != null && list.size() > 0;
    }

    public synchronized boolean checkInstallHijack(final String pkgName) {
        Collection<Download> list;
        list = this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && download.getState() == Download.DownloadState.FINISH && download.getKeyByUser().contains(pkgName);
            }
        });
        return list != null && list.size() > 0;
    }

    public synchronized String getHijackPackage(String packageName) {
        if (packageName.endsWith(HUAWEI_HIJACK)) {
            return packageName.replace(HUAWEI_HIJACK, "");
        } else if (packageName.endsWith(MI_HIJACK)) {
            return packageName.replace(MI_HIJACK, "");
        } else if (packageName.endsWith(OPPO_HIJACK)) {
            return packageName.replace(OPPO_HIJACK, "");
        } else if (!packageName.endsWith(VIVO_HIJACK)) {
            return null;
        } else {
            return packageName.replace(VIVO_HIJACK, "");
        }
    }

    public synchronized Collection<Download> queryDownloadByUrlWithInvalid(final String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getUrl(), url);
            }
        });
    }

    public synchronized Download queryOneDownloadByUrlWithInvalid(String url) {
        Collection<Download> downloads = queryDownloadByUrlWithInvalid(url);
        if (downloads != null) {
            if (!downloads.isEmpty()) {
                Download download = null;
                Iterator<Download> it = downloads.iterator();
                while (it.hasNext()) {
                    download = it.next();
                }
                return download;
            }
        }
        return null;
    }

    public void pauseAllDownloading() {
        Collection<Download> downloads = queryAllDownloads();
        if (downloads != null && !downloads.isEmpty()) {
            for (Download item : downloads) {
                if (item != null && (item.getState() == Download.DownloadState.WAITING || item.getState() == Download.DownloadState.DOWNLOADING)) {
                    this.mDownloadManager.pause(item.getId().longValue());
                }
            }
        }
    }

    public synchronized Collection<Download> queryDownloadNotInstalled() {
        final Context context;
        context = AppRuntime.getAppContext();
        return this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && download.getState() == Download.DownloadState.FINISH && !GameCenterApkUtil.hasInstalled(context, download.getKeyByUser());
            }
        });
    }

    public Collection<Download> resumeAllDownload() {
        Collection<Download> downloads = queryAllDownloads();
        if (downloads == null || downloads.isEmpty()) {
            return null;
        }
        for (Download item : downloads) {
            if (item != null && (item.getState() == Download.DownloadState.WAITING || item.getState() == Download.DownloadState.PAUSE)) {
                this.mDownloadManager.resume(item.getId().longValue());
            }
        }
        return downloads;
    }

    public synchronized void clearUninstalledHistoryByLimit() {
        Collection<Download> list = this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && download.getState() == Download.DownloadState.FINISH && AppDownloadStrategy.isDownloadFileExist(download) && !GameCenterApkUtil.hasInstalled(AppRuntime.getAppContext(), download.getKeyByUser());
            }
        });
        if (list != null) {
            int deleteNumber = list.size() - 20;
            if (deleteNumber > 0) {
                int num = 0;
                for (Download item : list) {
                    if (num != deleteNumber) {
                        if (item != null) {
                            this.mDownloadManager.cancel(item.getId().longValue());
                        }
                        num++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public synchronized void clearInstalledHistoryByLimit() {
        Collection<Download> list = this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return download != null && download.getState() == Download.DownloadState.FINISH && GameCenterApkUtil.hasInstalled(AppRuntime.getAppContext(), download.getKeyByUser());
            }
        });
        if (list != null) {
            int deleteNumber = list.size() - 30;
            if (deleteNumber > 0) {
                int num = 0;
                for (Download item : list) {
                    if (num != deleteNumber) {
                        if (item != null) {
                            this.mDownloadManager.cancel(item.getId().longValue());
                        }
                        num++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public synchronized void clearInvalidHistory() {
        deleteDownloadHistory(this.mDownloadManager.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() {
            public boolean filter(Download download) {
                return AppDownloadStrategy.this.isInvalidDownload(download);
            }
        }));
    }

    public void deleteDownloadByUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            deleteDownloadHistory(queryDownloadByUrlWithInvalid(url));
        }
    }

    public boolean deleteExceedTimeDownloadByUrl(String url) {
        Collection<Download> downloads;
        if (TextUtils.isEmpty(url) || (downloads = queryDownloadByUrlWithInvalid(url)) == null) {
            return true;
        }
        boolean isExceed = true;
        for (Download item : downloads) {
            if (item != null) {
                String fromParam = item.getFromParam();
                if (!TextUtils.isEmpty(fromParam)) {
                    try {
                        long downloadTime = new JSONObject(fromParam).optLong("download_time");
                        isExceed = ((double) (System.currentTimeMillis() - downloadTime)) > 1500.0d;
                        if (isExceed) {
                            try {
                                this.mDownloadManager.cancel(item.getId().longValue());
                            } catch (JSONException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        }
                        if (SwanAppLibConfig.DEBUG) {
                            Log.d(TAG, "downloadTime is " + downloadTime);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            }
        }
        if (SwanAppLibConfig.DEBUG) {
            Log.d(TAG, "Is time exceed " + isExceed);
        }
        return isExceed;
    }

    public void deleteDownloadByPackageName(String packageName) {
        Download download;
        if (!TextUtils.isEmpty(packageName) && (download = queryDownloadByPackageName(packageName)) != null) {
            this.mDownloadManager.cancel(download.getId().longValue());
        }
    }

    public void deleteDownloadHistory(Collection<Download> downloads) {
        if (downloads != null) {
            for (Download item : downloads) {
                if (item != null) {
                    this.mDownloadManager.cancel(item.getId().longValue());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isInvalidDownload(Download download) {
        if (download == null) {
            return false;
        }
        boolean isInvalid = download.getState() == Download.DownloadState.FINISH && !isDownloadFileExist(download);
        if ((isOneMonthAgo(download) || isInvalid) && !GameCenterApkUtil.hasInstalled(AppRuntime.getAppContext(), download.getKeyByUser())) {
            return true;
        }
        return false;
    }

    public static boolean isDownloadFileExist(Download download) {
        if (download == null) {
            return false;
        }
        String fileDir = download.getRealDownloadDir();
        String fileName = download.getFileName();
        if (TextUtils.isEmpty(fileDir) || TextUtils.isEmpty(fileName)) {
            return false;
        }
        File file = new File(fileDir + File.separator + fileName);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return true;
    }

    private boolean isOneMonthAgo(Download download) {
        if (download != null && (System.currentTimeMillis() - new AppDownloadBuilder(download).getDownloadTime()) / 86400000 >= 30) {
            return true;
        }
        return false;
    }
}
