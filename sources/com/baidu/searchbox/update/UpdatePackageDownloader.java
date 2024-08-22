package com.baidu.searchbox.update;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.callback.DownloadListener;
import com.baidu.searchbox.download.constants.MigrateStatisticConstants;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.settings.R;
import com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo;
import com.baidu.searchbox.settings.ioc.ISettingsApp;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class UpdatePackageDownloader {
    protected static final boolean DEBUG = UpdateChecker.DEBUG;
    private static final String KEY_FULL_UDPATE_DOWNLOAD_INFO = "key_full_update_download_info";
    private static final String KEY_UPDATE_DELAY = "key_update_delay";
    private static final String KEY_UPDATE_DOWNLOAD_INFO = "key_update_download_info";
    protected static final String TAG = "UpdateChecker";
    private static UpdatePackageDownloader sDownloader = null;
    /* access modifiers changed from: private */
    public boolean isPatching = false;
    private boolean isUpdateAfterExit = false;
    /* access modifiers changed from: private */
    public Context mAppContext = null;
    private String mFullUrlForUpdateAfterExit;
    private String mPatchMd5ForUpdateAfterExit;
    private String mPatchUrlForUpdateAfterExit;
    /* access modifiers changed from: private */
    public Uri mUri;

    private UpdatePackageDownloader(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static UpdatePackageDownloader getInstance(Context context) {
        if (sDownloader == null) {
            synchronized (UpdatePackageDownloader.class) {
                if (sDownloader == null) {
                    sDownloader = new UpdatePackageDownloader(context);
                }
            }
        }
        return sDownloader;
    }

    public void updateImmediately(String url, DownloadListener listener, UpdateInfo info, String md5) {
        long downloadTaskId = checkDownloadIdBeforeUpdateImmediately(info);
        if (downloadTaskId == -1 || !resumeDownLoadTask(downloadTaskId, url)) {
            UniversalToast.makeText(this.mAppContext, R.string.update_unfinish_title).setDuration(3).showToast();
            Uri doDownloadPackage = doDownloadPackage(url, listener);
            this.mUri = doDownloadPackage;
            long downloadId = ContentUris.parseId(doDownloadPackage);
            setFullUpdateDownloadInfo(this.mUri, url, md5);
            UpdateUtils.setClientUpdateDownloadId(this.mAppContext, downloadId);
            UpdateUtils.setUpdateDownloadInfo(downloadId, info.getUpdateVersionCode());
        }
    }

    public void updateImmediately(String fullUrl, String patchUrl, String patchMd5, UpdateInfo info) {
        long downloadTaskId = checkDownloadIdBeforeUpdateImmediately(info);
        if (downloadTaskId == -1 || (!resumeDownLoadTask(downloadTaskId, patchUrl) && !resumeDownLoadTask(downloadTaskId, fullUrl))) {
            UniversalToast.makeText(this.mAppContext, R.string.update_unfinish_title).setDuration(3).showToast();
            Uri doDownloadPatch = doDownloadPatch(patchUrl);
            this.mUri = doDownloadPatch;
            setUpdateDownloadInfo(doDownloadPatch, fullUrl, patchUrl, patchMd5);
            UpdateUtils.setClientUpdateDownloadId(this.mAppContext, ContentUris.parseId(this.mUri));
        }
    }

    private long checkDownloadIdBeforeUpdateImmediately(UpdateInfo info) {
        if (info == null) {
            return -1;
        }
        int newVersionCode = info.getUpdateVersionCode();
        int oldVersionCode = UpdateUtils.getClientUpdateVcode(this.mAppContext);
        UpdateUtils.setClientUpdateApkVcode(this.mAppContext, newVersionCode);
        if (newVersionCode == oldVersionCode) {
            return UpdateUtils.getClientUpdateDownloadId(this.mAppContext);
        }
        return -1;
    }

    public Uri updateSilent(String url, DownloadListener listener) {
        DownloadManagerExt downloader = DownloadManagerExt.getInstance();
        Uri doDownload = downloader.doDownload(url, (String) null, (String) null, false, false, false, false, (ContentValues) null);
        this.mUri = doDownload;
        if (listener != null) {
            downloader.registerObserver(this.mAppContext, doDownload, listener);
        }
        return this.mUri;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void updateAfterExit(String fullUrl, String patchUrl, String patchMd5) {
        this.isUpdateAfterExit = true;
        this.mFullUrlForUpdateAfterExit = fullUrl;
        this.mPatchUrlForUpdateAfterExit = patchUrl;
        this.mPatchMd5ForUpdateAfterExit = patchMd5;
    }

    public void execUpdateAfterExit() {
        if (this.isUpdateAfterExit) {
            if (!UpdatePreDownloadUtils.hasPreDownloadApk(this.mPatchMd5ForUpdateAfterExit)) {
                if (TextUtils.isEmpty(this.mPatchUrlForUpdateAfterExit) || TextUtils.isEmpty(this.mPatchMd5ForUpdateAfterExit)) {
                    Uri doDownloadPackage = doDownloadPackage(this.mFullUrlForUpdateAfterExit, (DownloadListener) null);
                    this.mUri = doDownloadPackage;
                    setFullUpdateDownloadInfo(doDownloadPackage, this.mFullUrlForUpdateAfterExit, this.mPatchMd5ForUpdateAfterExit);
                } else {
                    Uri doDownloadPackage2 = doDownloadPackage(this.mPatchUrlForUpdateAfterExit, (DownloadListener) null);
                    this.mUri = doDownloadPackage2;
                    setUpdateDownloadInfo(doDownloadPackage2, this.mFullUrlForUpdateAfterExit, this.mPatchUrlForUpdateAfterExit, this.mPatchMd5ForUpdateAfterExit);
                }
            }
            this.isUpdateAfterExit = false;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setFullUpdateDownloadInfo(android.net.Uri r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x0044
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0044
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0010
            goto L_0x0044
        L_0x0010:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0041 }
            r0.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "uri_string"
            java.lang.String r2 = r5.toString()     // Catch:{ JSONException -> 0x0037 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0037 }
            java.lang.String r1 = "full_url"
            r0.put(r1, r6)     // Catch:{ JSONException -> 0x0037 }
            java.lang.String r1 = "patch_md5"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x0037 }
            com.baidu.searchbox.update.UpdateSpUtil r1 = com.baidu.searchbox.update.UpdateSpUtil.getInstance()     // Catch:{ JSONException -> 0x0037 }
            java.lang.String r2 = "key_full_update_download_info"
            java.lang.String r3 = r0.toString()     // Catch:{ JSONException -> 0x0037 }
            r1.putString(r2, r3)     // Catch:{ JSONException -> 0x0037 }
            goto L_0x003f
        L_0x0037:
            r1 = move-exception
            boolean r2 = DEBUG     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x003f
            r1.printStackTrace()     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r4)
            return
        L_0x0041:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0044:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.UpdatePackageDownloader.setFullUpdateDownloadInfo(android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public synchronized void clearFullUpdateDownloadInfo() {
        UpdateSpUtil.getInstance().putString(KEY_FULL_UDPATE_DOWNLOAD_INFO, "");
    }

    public UpdatePackageDownloadInfo getFullUpdateDownloadInfo() {
        try {
            JSONObject jObject = new JSONObject(UpdateSpUtil.getInstance().getString(KEY_FULL_UDPATE_DOWNLOAD_INFO, ""));
            String uriStr = jObject.optString(UpdatePackageDownloadInfo.JSON_KEY_URI_STRING);
            String fullUrl = jObject.optString(UpdatePackageDownloadInfo.JSON_KEY_FULL_URL);
            String patchUrl = jObject.optString("patch_url");
            String fullMd5 = jObject.optString("patch_md5");
            if (TextUtils.isEmpty(uriStr) || TextUtils.isEmpty(fullUrl)) {
                return null;
            }
            return new UpdatePackageDownloadInfo(uriStr, fullUrl, patchUrl, fullMd5);
        } catch (JSONException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setUpdateDownloadInfo(android.net.Uri r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x004f
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x004f
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x004f
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0016
            goto L_0x004f
        L_0x0016:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x004c }
            r0.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "uri_string"
            java.lang.String r2 = r5.toString()     // Catch:{ JSONException -> 0x0042 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0042 }
            java.lang.String r1 = "full_url"
            r0.put(r1, r6)     // Catch:{ JSONException -> 0x0042 }
            java.lang.String r1 = "patch_url"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x0042 }
            java.lang.String r1 = "patch_md5"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x0042 }
            com.baidu.searchbox.update.UpdateSpUtil r1 = com.baidu.searchbox.update.UpdateSpUtil.getInstance()     // Catch:{ JSONException -> 0x0042 }
            java.lang.String r2 = "key_update_download_info"
            java.lang.String r3 = r0.toString()     // Catch:{ JSONException -> 0x0042 }
            r1.putString(r2, r3)     // Catch:{ JSONException -> 0x0042 }
            goto L_0x004a
        L_0x0042:
            r1 = move-exception
            boolean r2 = DEBUG     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004a
            r1.printStackTrace()     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r4)
            return
        L_0x004c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x004f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.UpdatePackageDownloader.setUpdateDownloadInfo(android.net.Uri, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public synchronized void clearUpdateDownloadInfo() {
        UpdateSpUtil.getInstance().putString(KEY_UPDATE_DOWNLOAD_INFO, "");
    }

    public UpdatePackageDownloadInfo getUpdateDownloadInfo() {
        try {
            JSONObject jObject = new JSONObject(UpdateSpUtil.getInstance().getString(KEY_UPDATE_DOWNLOAD_INFO, ""));
            String uriStr = jObject.optString(UpdatePackageDownloadInfo.JSON_KEY_URI_STRING);
            String fullUrl = jObject.optString(UpdatePackageDownloadInfo.JSON_KEY_FULL_URL);
            String patchUrl = jObject.optString("patch_url");
            String patchMd5 = jObject.optString("patch_md5");
            if (TextUtils.isEmpty(uriStr) || TextUtils.isEmpty(fullUrl) || TextUtils.isEmpty(patchUrl) || TextUtils.isEmpty(patchMd5)) {
                return null;
            }
            return new UpdatePackageDownloadInfo(uriStr, fullUrl, patchUrl, patchMd5);
        } catch (JSONException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public void updateDelay() {
        UpdateSpUtil.getInstance().putLong(KEY_UPDATE_DELAY, System.currentTimeMillis());
        UpdateChecker.getInstance(this.mAppContext).setUserDelay(true);
    }

    public long getLastUpdadeDelay() {
        return UpdateSpUtil.getInstance().getLong(KEY_UPDATE_DELAY, 0);
    }

    /* access modifiers changed from: private */
    public Uri doDownloadPackage(String url, DownloadListener listener) {
        String name;
        DownloadListener downloadListener = listener;
        DownloadManagerExt downloader = DownloadManagerExt.getInstance();
        if (AppConfig.AppInfo.isDaily()) {
            name = "daily.apk";
        } else if (AppConfig.AppInfo.isWeekly()) {
            name = "weekly.apk";
        } else if (AppConfig.AppInfo.isPreview()) {
            name = "preview.apk";
        } else if (AppConfig.AppInfo.isSmartPreview()) {
            name = "smartapp.apk";
        } else {
            name = null;
        }
        ContentValues cv = new ContentValues();
        cv.put("source", "appUpdate");
        JSONObject extJson = new JSONObject();
        try {
            extJson.put("source", "upload");
        } catch (JSONException e2) {
        }
        cv.put("extra_info", String.valueOf(extJson));
        Uri uri = downloader.doDownload(url, (String) null, name, ISettingsApp.Impl.get().getDownloadInstallReceiverCanonicalName(), true, true, false, false, cv);
        if (downloadListener != null) {
            downloader.registerObserver(this.mAppContext, uri, downloadListener);
        }
        return uri;
    }

    private Uri doDownloadPatch(String url) {
        return DownloadManagerExt.getInstance().doDownload(url, (String) null, "searchbox_update.apk", ISettingsApp.Impl.get().getDownloadInstallReceiverCanonicalName(), true, true, false, false, (ContentValues) null);
    }

    public void pause() {
        if (this.mUri != null) {
            DownloadManagerExt.getInstance().pauseDownload(this.mUri);
        }
    }

    public void resume() {
        if (this.mUri != null) {
            DownloadManagerExt.getInstance().resumeDownload(this.mUri);
        }
    }

    public void cancel(DownloadListener listener) {
        if (this.mUri != null) {
            DownloadManagerExt downloader = DownloadManagerExt.getInstance();
            if (listener != null) {
                downloader.unregisterObserver(this.mAppContext, this.mUri, listener);
            }
            downloader.cancelDownload(this.mUri);
        }
    }

    private boolean resumeDownLoadTask(long downloadTaskId, String newUrl) {
        long j2 = downloadTaskId;
        ContentResolver cr = this.mAppContext.getContentResolver();
        Cursor cursor = null;
        String filePath = null;
        String oldUrl = null;
        int status = 0;
        boolean isFinished = false;
        String[] arrString = {"_id", "_data", "uri", "status"};
        try {
            Uri uri = DownloadManagerExt.getInstance().getDownloadUri(j2);
            ContentResolver contentResolver = cr;
            String str = "status";
            String str2 = "uri";
            ContentResolver contentResolver2 = cr;
            String str3 = "_data";
            try {
                cursor = contentResolver.query(uri, arrString, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    String str4 = newUrl;
                    Uri uri2 = uri;
                    Closeables.closeSafely(cursor);
                    return isFinished;
                }
                int dataColumnIndex = cursor.getColumnIndex(str3);
                if (dataColumnIndex >= 0) {
                    filePath = cursor.getString(dataColumnIndex);
                }
                int statusColumnIndex = cursor.getColumnIndex(str);
                if (statusColumnIndex >= 0) {
                    status = cursor.getInt(statusColumnIndex);
                }
                int urlColumnIndex = cursor.getColumnIndex(str2);
                if (urlColumnIndex >= 0) {
                    oldUrl = cursor.getString(urlColumnIndex);
                }
                try {
                    if (!TextUtils.equals(newUrl, oldUrl)) {
                    } else if (this.isPatching) {
                        isFinished = true;
                    } else if (!Downloads.isStatusCompleted(status) || !Downloads.isStatusSuccess(status)) {
                        if (status == 192) {
                            isFinished = true;
                        } else {
                            DownloadManagerExt.getInstance().pauseDownload(j2);
                            DownloadManagerExt.getInstance().restartDownload(j2);
                            isFinished = true;
                        }
                    } else {
                        MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_DOWNLOAD_COMPLETE_TYPE, MigrateStatisticUtils.build(""));
                        if (!TextUtils.isEmpty(filePath)) {
                            File file = new File(filePath);
                            if (file.exists()) {
                                UpdatePackageDownloadInfo updInfo = getUpdateDownloadInfo();
                                if (needPatch(uri, updInfo)) {
                                    asyncInstallPatchPackage(j2, file, updInfo);
                                    Uri uri3 = uri;
                                } else {
                                    Uri uri4 = uri;
                                    UpdateUtils.installClientUpdateApk(this.mAppContext, filePath);
                                    UpdateUBCStatistic.doInstallStatistic("normal");
                                }
                                isFinished = true;
                            }
                        }
                    }
                } catch (Exception e2) {
                    isFinished = false;
                    Closeables.closeSafely(cursor);
                    return isFinished;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
                Closeables.closeSafely(cursor);
                return isFinished;
            } catch (Exception e3) {
                String str5 = newUrl;
                isFinished = false;
                Closeables.closeSafely(cursor);
                return isFinished;
            } catch (Throwable th3) {
                th = th3;
                String str6 = newUrl;
                Closeables.closeSafely(cursor);
                throw th;
            }
        } catch (Exception e4) {
            String str7 = newUrl;
            ContentResolver contentResolver3 = cr;
            isFinished = false;
            Closeables.closeSafely(cursor);
            return isFinished;
        } catch (Throwable th4) {
            th = th4;
            String str8 = newUrl;
            ContentResolver contentResolver4 = cr;
            Closeables.closeSafely(cursor);
            throw th;
        }
    }

    public boolean needPatch(Uri uri, UpdatePackageDownloadInfo info) {
        if (uri == null || info == null || TextUtils.isEmpty(info.getFullUrl()) || TextUtils.isEmpty(info.getPatchUrl()) || TextUtils.isEmpty(info.getPatchMd5()) || !TextUtils.equals(info.getUriString(), uri.toString())) {
            return false;
        }
        return true;
    }

    public void asyncInstallPatchPackage(long downloadId, File patchFile, UpdatePackageDownloadInfo info) {
        this.isPatching = true;
        String fullUrl = info.getFullUrl();
        String patchUrl = info.getPatchUrl();
        String patchMd5 = info.getPatchMd5();
        if (DEBUG) {
            Log.d("UpdateChecker", "asyncInstallPatchPackage fullUrl: " + fullUrl);
            Log.d("UpdateChecker", "asyncInstallPatchPackage patchUrl: " + patchUrl);
            Log.d("UpdateChecker", "asyncInstallPatchPackage patchMd5: " + patchMd5);
        }
        final File file = patchFile;
        final String str = patchMd5;
        final String str2 = patchUrl;
        final long j2 = downloadId;
        final String str3 = fullUrl;
        final UpdatePackageDownloadInfo updatePackageDownloadInfo = info;
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:13:0x0047 A[Catch:{ GenerateSaveFileError -> 0x0111 }] */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0069 A[SYNTHETIC, Splitter:B:17:0x0069] */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00af A[Catch:{ GenerateSaveFileError -> 0x0111 }] */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00cf A[Catch:{ GenerateSaveFileError -> 0x0111 }] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x011d  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0144  */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x0188  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r23 = this;
                    r1 = r23
                    java.lang.String r2 = "UpdateChecker"
                    r3 = 0
                    r4 = 0
                    r5 = 0
                    java.io.File r0 = r3     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r6.<init>()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r6 = r6.append(r0)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r7 = ".patch"
                    java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r6 = r6.toString()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    boolean r7 = com.baidu.android.util.io.FileUtils.isGzipFile(r0)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    if (r7 == 0) goto L_0x0042
                    boolean r7 = com.baidu.searchbox.update.UpdatePackageDownloader.DEBUG     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    if (r7 == 0) goto L_0x002f
                    java.lang.String r7 = "patch File is Gzip"
                    android.util.Log.d(r2, r7)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                L_0x002f:
                    java.io.File r7 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r7.<init>(r0)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.io.File r8 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r8.<init>(r6)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    boolean r7 = com.baidu.android.util.io.FileUtils.unGzipFile(r7, r8)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    if (r7 != 0) goto L_0x0042
                    r6 = 0
                    r14 = r6
                    goto L_0x0043
                L_0x0042:
                    r14 = r6
                L_0x0043:
                    boolean r6 = com.baidu.searchbox.update.UpdatePackageDownloader.DEBUG     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    if (r6 == 0) goto L_0x005d
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r6.<init>()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r7 = "asyncInstallPatchPackage unGzipPatchFilePath: "
                    java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r6 = r6.append(r14)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r6 = r6.toString()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    android.util.Log.d(r2, r6)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                L_0x005d:
                    java.io.File r6 = r3     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    boolean r6 = r6.delete()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r15 = " File Failed!"
                    java.lang.String r13 = "Delete "
                    if (r6 != 0) goto L_0x0087
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r6.<init>()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r6 = r6.append(r13)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.io.File r7 = r3     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r6 = r6.toString()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    android.util.Log.i(r2, r6)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                L_0x0087:
                    com.baidu.searchbox.update.UpdatePackageDownloader r6 = com.baidu.searchbox.update.UpdatePackageDownloader.this     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    android.content.Context r6 = r6.mAppContext     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    java.lang.String r12 = "application/vnd.android.package-archive"
                    r16 = 0
                    r17 = 0
                    r19 = 0
                    r7 = r0
                    r20 = r13
                    r13 = r16
                    r21 = r14
                    r22 = r15
                    r14 = r17
                    r16 = r19
                    java.lang.String r6 = com.baidu.searchbox.download.util.DownloadHelper.generateSaveFile(r6, r7, r8, r9, r10, r11, r12, r13, r14, r16)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r3 = r6
                    boolean r6 = com.baidu.searchbox.update.UpdatePackageDownloader.DEBUG     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    if (r6 == 0) goto L_0x00c5
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r6.<init>()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r7 = "asyncInstallPatchPackage installApkFilePath: "
                    java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r6 = r6.append(r3)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r6 = r6.toString()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    android.util.Log.d(r2, r6)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                L_0x00c5:
                    java.io.File r6 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r6.<init>(r3)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r4 = r6
                    r6 = r21
                    if (r6 == 0) goto L_0x0110
                    java.io.File r7 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r7.<init>(r6)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    com.baidu.searchbox.update.UpdatePackageDownloader r8 = com.baidu.searchbox.update.UpdatePackageDownloader.this     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    android.content.Context r8 = r8.mAppContext     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r8 = com.baidu.android.util.android.PkgUtils.getPackageSourcePath(r8)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    if (r8 == 0) goto L_0x00ea
                    java.io.File r9 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r9.<init>(r8)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    boolean r10 = com.baidu.searchbox.update.UpdateUtils.patchFile(r9, r7, r4)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r5 = r10
                L_0x00ea:
                    boolean r9 = r7.delete()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    if (r9 != 0) goto L_0x0110
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r9.<init>()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r10 = r20
                    java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r10 = r7.getAbsolutePath()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    r10 = r22
                    java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    java.lang.String r9 = r9.toString()     // Catch:{ GenerateSaveFileError -> 0x0111 }
                    android.util.Log.i(r2, r9)     // Catch:{ GenerateSaveFileError -> 0x0111 }
                L_0x0110:
                    goto L_0x0119
                L_0x0111:
                    r0 = move-exception
                    boolean r6 = com.baidu.searchbox.update.UpdatePackageDownloader.DEBUG
                    if (r6 == 0) goto L_0x0119
                    r0.printStackTrace()
                L_0x0119:
                    boolean r0 = com.baidu.searchbox.update.UpdatePackageDownloader.DEBUG
                    if (r0 == 0) goto L_0x0133
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r6 = "asyncInstallPatchPackage patchSuccess: "
                    java.lang.StringBuilder r0 = r0.append(r6)
                    java.lang.StringBuilder r0 = r0.append(r5)
                    java.lang.String r0 = r0.toString()
                    android.util.Log.d(r2, r0)
                L_0x0133:
                    r0 = 0
                    if (r5 == 0) goto L_0x01a1
                    boolean r6 = r4.exists()
                    if (r6 == 0) goto L_0x01a1
                    java.lang.String r6 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((java.io.File) r4, (boolean) r0)
                    boolean r7 = com.baidu.searchbox.update.UpdatePackageDownloader.DEBUG
                    if (r7 == 0) goto L_0x015a
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "asyncInstallPatchPackage md5: "
                    java.lang.StringBuilder r7 = r7.append(r8)
                    java.lang.StringBuilder r7 = r7.append(r6)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.d(r2, r7)
                L_0x015a:
                    java.lang.String r2 = r4
                    boolean r2 = android.text.TextUtils.isEmpty(r2)
                    if (r2 != 0) goto L_0x01a1
                    java.lang.String r2 = r5
                    boolean r2 = android.text.TextUtils.isEmpty(r2)
                    if (r2 != 0) goto L_0x01a1
                    java.lang.String r2 = r4
                    java.util.Locale r7 = java.util.Locale.getDefault()
                    java.lang.String r2 = r2.toLowerCase(r7)
                    boolean r2 = android.text.TextUtils.equals(r6, r2)
                    if (r2 == 0) goto L_0x01a1
                    com.baidu.searchbox.update.UpdatePackageDownloader r2 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    android.content.Context r7 = r2.mAppContext
                    long r8 = r6
                    boolean r2 = r2.updatePatchedPackage(r7, r8, r3)
                    if (r2 == 0) goto L_0x01a1
                    com.baidu.searchbox.update.UpdatePackageDownloader r2 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    boolean unused = r2.isPatching = r0
                    com.baidu.searchbox.update.UpdatePackageDownloader r0 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    r0.clearUpdateDownloadInfo()
                    com.baidu.searchbox.update.UpdatePackageDownloader r0 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    android.content.Context r0 = r0.mAppContext
                    com.baidu.searchbox.update.UpdateUtils.installClientUpdateApk(r0, r3)
                    java.lang.String r0 = "normal"
                    com.baidu.searchbox.update.UpdateUBCStatistic.doInstallStatistic(r0)
                    return
                L_0x01a1:
                    com.baidu.searchbox.update.UpdatePackageDownloader r2 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    boolean unused = r2.isPatching = r0
                    com.baidu.searchbox.update.UpdatePackageDownloader r0 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    java.lang.String r2 = r8
                    r6 = 0
                    android.net.Uri r2 = r0.doDownloadPackage(r2, r6)
                    android.net.Uri unused = r0.mUri = r2
                    com.baidu.searchbox.update.UpdatePackageDownloader r0 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    android.net.Uri r0 = r0.mUri
                    long r6 = android.content.ContentUris.parseId(r0)
                    com.baidu.searchbox.update.UpdatePackageDownloader r0 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo r2 = r9
                    java.lang.String r2 = r2.getUriString()
                    android.net.Uri r2 = android.net.Uri.parse(r2)
                    com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo r8 = r9
                    java.lang.String r8 = r8.getFullUrl()
                    com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo r9 = r9
                    java.lang.String r9 = r9.getPatchMd5()
                    r0.setFullUpdateDownloadInfo(r2, r8, r9)
                    com.baidu.searchbox.update.UpdatePackageDownloader r0 = com.baidu.searchbox.update.UpdatePackageDownloader.this
                    android.content.Context r0 = r0.mAppContext
                    com.baidu.searchbox.update.UpdateUtils.setClientUpdateDownloadId(r0, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.UpdatePackageDownloader.AnonymousClass1.run():void");
            }
        }, "installPatchPackage", 2);
    }

    public boolean updatePatchedPackage(Context context, long downloadId, String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }
        ContentValues values = new ContentValues();
        values.put("title", file.getName());
        values.put("_data", filePath);
        values.put("total_bytes", Long.valueOf(file.length()));
        values.put("mimetype", "application/vnd.android.package-archive");
        values.put("lastmod", Long.valueOf(file.lastModified()));
        if (context.getContentResolver().update(Downloads.Impl.CONTENT_URI, values, "_id = ?", new String[]{String.valueOf(downloadId)}) > 0) {
            return true;
        }
        return false;
    }
}
