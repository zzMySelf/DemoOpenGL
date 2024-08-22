package com.baidu.searchbox.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.netdisk.cloudfile.storage.db.CloudFileContract;
import com.baidu.searchbox.AboutBaiduSettingsActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.searchbox.widget.preference.PreferenceManager;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class UpdatePreDownloadUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "UpdatePreDownloadUtils";
    public static final String UBC_INSTALL_PREDOWN_APK = "34";
    public static final String UBC_NODIALOG_FOR_PREDWNING = "35";
    public static final String UBC_START_PREDWN_KEY = "33";
    private static final String UPDATE_PREDOWNLOAD_FILENAME = "predown_file";
    public static final String UPDATE_PREDOWNLOAD_PREFER_KEY = "update_predownload_key";

    public static class UpdateDownloadInfo {
        public String mFullUrl = null;
        public boolean mIsValid = false;
        public String mMd5 = null;
        public String mPatchUrl = null;
    }

    public static class UpdatePreDown {
        public long mDownloadId;
        public boolean mIsPatch;
        public String mMd5;
        public String mUrl;
        public int mVersionCode;

        public static JSONObject parseToJSON(UpdatePreDown preDown) {
            if (preDown == null) {
                return null;
            }
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("versioncode", preDown.mVersionCode);
                jsonObject.put("url", preDown.mUrl);
                jsonObject.put("downloadid", preDown.mDownloadId);
                jsonObject.put("ispatch", preDown.mIsPatch);
                jsonObject.put("md5", preDown.mMd5);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jsonObject;
        }

        public static UpdatePreDown parseFromJSON(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            UpdatePreDown preDown = new UpdatePreDown();
            preDown.mVersionCode = jsonObject.optInt("versioncode");
            preDown.mUrl = jsonObject.optString("url");
            preDown.mDownloadId = jsonObject.optLong("downloadid");
            preDown.mIsPatch = jsonObject.optBoolean("ispatch");
            preDown.mMd5 = jsonObject.optString("md5");
            return preDown;
        }

        public String toString() {
            return "mVersionCode=" + this.mVersionCode + ", mUrl=" + this.mUrl + ", mDownloadId=" + this.mDownloadId + ", ispatch=" + this.mIsPatch + ", md5=" + this.mMd5;
        }
    }

    public static UpdatePreDown getPreDownloadInfo() {
        try {
            return UpdatePreDown.parseFromJSON(new JSONObject(UpdateSpUtil.getInstance().getString(UPDATE_PREDOWNLOAD_PREFER_KEY, "")));
        } catch (JSONException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static void savePreDownloadInfo(int versioncode, String url, String md5, boolean isPatch, long downloadId) {
        UpdatePreDown updatePreDown = new UpdatePreDown();
        updatePreDown.mVersionCode = versioncode;
        updatePreDown.mUrl = url;
        updatePreDown.mMd5 = md5;
        updatePreDown.mIsPatch = isPatch;
        updatePreDown.mDownloadId = downloadId;
        JSONObject jsonObject = UpdatePreDown.parseToJSON(updatePreDown);
        String jsonStr = "";
        if (jsonObject != null) {
            jsonStr = jsonObject.toString();
        }
        UpdateSpUtil.getInstance().putString(UPDATE_PREDOWNLOAD_PREFER_KEY, jsonStr);
    }

    public static void clearPreDownloadInfo() {
        UpdatePreDown updatePreDown = getPreDownloadInfo();
        if (updatePreDown != null) {
            long downloadId = updatePreDown.mDownloadId;
            DownloadManagerExt.getInstance().deleteDownload(true, downloadId);
        }
        UpdateSpUtil.getInstance().putString(UPDATE_PREDOWNLOAD_PREFER_KEY, "");
    }

    public static boolean satisfyNetworkCondition(String preDownCon) {
        if (preDownCon == null) {
            return false;
        }
        String netType = NetWorkUtils.getNetworkClass(AppRuntime.getAppContext());
        if (TextUtils.isEmpty(netType)) {
            return false;
        }
        return preDownCon.toLowerCase(Locale.getDefault()).contains(netType);
    }

    public static boolean getLocalPreDownloadSwitch() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(AboutBaiduSettingsActivity.AboutBaiduSettingsFragment.KEY_PRE_DOWNLOAD, true);
    }

    public static UpdateDownloadInfo checkUpdateDownloadInfo(UpdateInfo updateInfo) {
        UpdateDownloadInfo dwnInfo = new UpdateDownloadInfo();
        if (updateInfo == null) {
            dwnInfo.mIsValid = false;
            return dwnInfo;
        }
        String fullUrl = null;
        String patchUrl = null;
        String fileMd5 = null;
        boolean dataVaild = false;
        try {
            JSONObject jsData = new JSONObject(updateInfo.getJsData());
            if (UpdateSignUtil.checkSignVaild(jsData, updateInfo.getRn())) {
                JSONObject dataJson = new JSONObject(new String(Base64.decode(jsData.getString("data"), 0), "utf-8"));
                fullUrl = dataJson.getString("file_url");
                fileMd5 = dataJson.getString(CloudFileContract.FilesColumns.FILE_SERVER_MD5);
                patchUrl = dataJson.optString("patch_url");
                if (!TextUtils.isEmpty(fullUrl) && !TextUtils.isEmpty(fileMd5)) {
                    dataVaild = true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        dwnInfo.mIsValid = dataVaild;
        dwnInfo.mFullUrl = fullUrl;
        dwnInfo.mPatchUrl = patchUrl;
        dwnInfo.mMd5 = fileMd5;
        return dwnInfo;
    }

    public static void startPreDownload(final UpdateInfo updateInfo) {
        if (updateInfo == null || TextUtils.isEmpty(updateInfo.getPreDownloadCon())) {
            if (DEBUG) {
                Log.d(TAG, "updateinfo is null or predowncon is null; updateInfo=" + updateInfo);
            }
            clearPreDownloadInfo();
        } else if (!getLocalPreDownloadSwitch()) {
            if (DEBUG) {
                Log.d(TAG, "loacl pre download switch is off");
            }
            clearPreDownloadInfo();
        } else if (!satisfyNetworkCondition(updateInfo.getPreDownloadCon())) {
            BroadcastReceiver netChangeReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (UpdatePreDownloadUtils.satisfyNetworkCondition(UpdateInfo.this.getPreDownloadCon()) && UpdatePreDownloadUtils.getLocalPreDownloadSwitch()) {
                        AppRuntime.getAppContext().unregisterReceiver(this);
                        UpdatePreDownloadUtils.startPreDownloadTask(UpdateInfo.this);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
            AppRuntime.getAppContext().registerReceiver(netChangeReceiver, intentFilter);
        } else {
            doPreDownload(updateInfo);
        }
    }

    /* access modifiers changed from: private */
    public static void startPreDownloadTask(final UpdateInfo updateInfo) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (UpdatePreDownloadUtils.DEBUG) {
                    Log.d(UpdatePreDownloadUtils.TAG, "startPreDownloadTask");
                }
                UpdatePreDownloadUtils.doPreDownload(UpdateInfo.this);
            }
        }, "UpdatePreDownload", 3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void doPreDownload(com.baidu.searchbox.update.UpdateInfo r20) {
        /*
            java.lang.Class<com.baidu.searchbox.update.UpdatePreDownloadUtils> r1 = com.baidu.searchbox.update.UpdatePreDownloadUtils.class
            monitor-enter(r1)
            com.baidu.searchbox.update.UpdatePreDownloadUtils$UpdateDownloadInfo r0 = checkUpdateDownloadInfo(r20)     // Catch:{ all -> 0x00cd }
            boolean r2 = r0.mIsValid     // Catch:{ all -> 0x00cd }
            if (r2 != 0) goto L_0x002f
            boolean r2 = DEBUG     // Catch:{ all -> 0x00cd }
            if (r2 == 0) goto L_0x002b
            java.lang.String r2 = "UpdatePreDownloadUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r3.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "update download info is not valid, UpdateInfo="
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00cd }
            r4 = r20
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00cd }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00cd }
            com.baidu.android.common.logging.Log.d(r2, r3)     // Catch:{ all -> 0x00cd }
            goto L_0x002d
        L_0x002b:
            r4 = r20
        L_0x002d:
            monitor-exit(r1)
            return
        L_0x002f:
            r4 = r20
            r2 = 0
            r3 = 0
            com.baidu.searchbox.update.UpdatePreDownloadUtils$UpdatePreDown r5 = getPreDownloadInfo()     // Catch:{ all -> 0x00cd }
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0067
            int r8 = r20.getUpdateVersionCode()     // Catch:{ all -> 0x00cd }
            int r9 = r5.mVersionCode     // Catch:{ all -> 0x00cd }
            if (r8 != r9) goto L_0x0067
            java.lang.String r8 = r0.mMd5     // Catch:{ all -> 0x00cd }
            java.lang.String r9 = r5.mMd5     // Catch:{ all -> 0x00cd }
            boolean r8 = android.text.TextUtils.equals(r8, r9)     // Catch:{ all -> 0x00cd }
            if (r8 == 0) goto L_0x0067
            boolean r8 = r5.mIsPatch     // Catch:{ all -> 0x00cd }
            if (r8 == 0) goto L_0x005b
            long r8 = r5.mDownloadId     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r0.mMd5     // Catch:{ all -> 0x00cd }
            boolean r8 = resumePreDownloadTask(r8, r6, r10)     // Catch:{ all -> 0x00cd }
            r2 = r8
            goto L_0x0064
        L_0x005b:
            long r8 = r5.mDownloadId     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r0.mMd5     // Catch:{ all -> 0x00cd }
            boolean r8 = resumePreDownloadTask(r8, r7, r10)     // Catch:{ all -> 0x00cd }
            r2 = r8
        L_0x0064:
            if (r2 != 0) goto L_0x0067
            r3 = 1
        L_0x0067:
            if (r2 == 0) goto L_0x006b
            monitor-exit(r1)
            return
        L_0x006b:
            clearPreDownloadInfo()     // Catch:{ all -> 0x00cd }
            java.lang.String r8 = r0.mFullUrl     // Catch:{ all -> 0x00cd }
            java.lang.String r9 = r0.mPatchUrl     // Catch:{ all -> 0x00cd }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x00cd }
            if (r9 != 0) goto L_0x0080
            if (r3 != 0) goto L_0x0080
            java.lang.String r9 = r0.mPatchUrl     // Catch:{ all -> 0x00cd }
            r8 = r9
            r18 = r8
            goto L_0x0083
        L_0x0080:
            r3 = 1
            r18 = r8
        L_0x0083:
            com.baidu.searchbox.download.manager.DownloadManagerExt r8 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ all -> 0x00cd }
            r15 = r8
            r10 = 0
            java.lang.String r11 = "predown_file"
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 1
            r17 = 1
            r19 = 0
            r8 = r15
            r9 = r18
            r6 = r15
            r15 = r16
            r16 = r17
            r17 = r19
            android.net.Uri r8 = r8.doDownload(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x00cd }
            r14 = r8
            android.content.Context r8 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x00cd }
            com.baidu.searchbox.update.UpdatePreDownloadUtils$3 r9 = new com.baidu.searchbox.update.UpdatePreDownloadUtils$3     // Catch:{ all -> 0x00cd }
            r9.<init>()     // Catch:{ all -> 0x00cd }
            r6.registerObserver(r8, r14, r9)     // Catch:{ all -> 0x00cd }
            long r12 = android.content.ContentUris.parseId(r14)     // Catch:{ all -> 0x00cd }
            int r8 = r20.getUpdateVersionCode()     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r0.mMd5     // Catch:{ all -> 0x00cd }
            if (r3 != 0) goto L_0x00be
            r11 = 1
            goto L_0x00bf
        L_0x00be:
            r11 = r7
        L_0x00bf:
            r9 = r18
            savePreDownloadInfo(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00cd }
            java.lang.String r7 = "33"
            java.lang.String r8 = "create task"
            com.baidu.ubc.UBC.onEvent((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ all -> 0x00cd }
            monitor-exit(r1)
            return
        L_0x00cd:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.UpdatePreDownloadUtils.doPreDownload(com.baidu.searchbox.update.UpdateInfo):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0170, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean checkCanShowUpdateDialog(com.baidu.searchbox.update.UpdateInfo r17) {
        /*
            java.lang.Class<com.baidu.searchbox.update.UpdatePreDownloadUtils> r1 = com.baidu.searchbox.update.UpdatePreDownloadUtils.class
            monitor-enter(r1)
            r0 = 0
            if (r17 != 0) goto L_0x0008
            monitor-exit(r1)
            return r0
        L_0x0008:
            java.lang.String r2 = r17.getPreDownloadCon()     // Catch:{ all -> 0x0171 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0171 }
            r4 = 1
            if (r3 == 0) goto L_0x0015
            monitor-exit(r1)
            return r4
        L_0x0015:
            boolean r3 = getLocalPreDownloadSwitch()     // Catch:{ all -> 0x0171 }
            if (r3 == 0) goto L_0x016f
            java.lang.String r3 = r17.getPreDownloadCon()     // Catch:{ all -> 0x0171 }
            boolean r3 = satisfyNetworkCondition(r3)     // Catch:{ all -> 0x0171 }
            if (r3 != 0) goto L_0x0027
            goto L_0x016f
        L_0x0027:
            com.baidu.searchbox.update.UpdatePreDownloadUtils$UpdateDownloadInfo r3 = checkUpdateDownloadInfo(r17)     // Catch:{ all -> 0x0171 }
            boolean r5 = r3.mIsValid     // Catch:{ all -> 0x0171 }
            if (r5 != 0) goto L_0x0038
            java.lang.String r4 = "35"
            java.lang.String r5 = "download info not valid"
            com.baidu.ubc.UBC.onEvent((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0171 }
            monitor-exit(r1)
            return r0
        L_0x0038:
            com.baidu.searchbox.update.UpdatePreDownloadUtils$UpdatePreDown r0 = getPreDownloadInfo()     // Catch:{ all -> 0x0171 }
            r5 = r0
            if (r5 != 0) goto L_0x0041
            monitor-exit(r1)
            return r4
        L_0x0041:
            r4 = 1
            int r0 = r17.getUpdateVersionCode()     // Catch:{ all -> 0x0171 }
            int r6 = r5.mVersionCode     // Catch:{ all -> 0x0171 }
            if (r0 != r6) goto L_0x00cd
            java.lang.String r0 = r5.mMd5     // Catch:{ all -> 0x0171 }
            java.lang.String r6 = r3.mMd5     // Catch:{ all -> 0x0171 }
            boolean r0 = android.text.TextUtils.equals(r0, r6)     // Catch:{ all -> 0x0171 }
            if (r0 == 0) goto L_0x00cd
            r6 = 0
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x00c1 }
            long r7 = r5.mDownloadId     // Catch:{ Exception -> 0x00c1 }
            android.net.Uri r10 = r0.getDownloadUri(r7)     // Catch:{ Exception -> 0x00c1 }
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x00c1 }
            android.content.ContentResolver r9 = r0.getContentResolver()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = "_id"
            java.lang.String r7 = "_data"
            java.lang.String r8 = "uri"
            java.lang.String r11 = "status"
            java.lang.String[] r11 = new java.lang.String[]{r0, r7, r8, r11}     // Catch:{ Exception -> 0x00c1 }
            r12 = 0
            r13 = 0
            r14 = 0
            android.database.Cursor r0 = r9.query(r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00c1 }
            r6 = r0
            if (r6 == 0) goto L_0x00bb
            boolean r0 = r6.moveToFirst()     // Catch:{ Exception -> 0x00c1 }
            if (r0 == 0) goto L_0x00bb
            java.lang.String r0 = "status"
            int r0 = r6.getColumnIndex(r0)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r7 = "_data"
            int r7 = r6.getColumnIndex(r7)     // Catch:{ Exception -> 0x00c1 }
            r8 = 0
            if (r7 < 0) goto L_0x009e
            java.lang.String r9 = r6.getString(r7)     // Catch:{ Exception -> 0x00c1 }
            boolean r9 = checkFileExist(r9)     // Catch:{ Exception -> 0x00c1 }
            r8 = r9
        L_0x009e:
            if (r0 < 0) goto L_0x00bb
            int r9 = r6.getInt(r0)     // Catch:{ Exception -> 0x00c1 }
            boolean r11 = com.baidu.searchbox.download.model.Downloads.isStatusCompleted(r9)     // Catch:{ Exception -> 0x00c1 }
            if (r11 == 0) goto L_0x00ba
            boolean r11 = com.baidu.searchbox.download.model.Downloads.isStatusSuccess(r9)     // Catch:{ Exception -> 0x00c1 }
            if (r11 != 0) goto L_0x00b6
            boolean r11 = com.baidu.searchbox.download.model.Downloads.isStatusError(r9)     // Catch:{ Exception -> 0x00c1 }
            if (r11 == 0) goto L_0x00ba
        L_0x00b6:
            if (r8 == 0) goto L_0x00ba
            r4 = 1
            goto L_0x00bb
        L_0x00ba:
            r4 = 0
        L_0x00bb:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r6)     // Catch:{ all -> 0x0171 }
        L_0x00be:
            goto L_0x00cd
        L_0x00bf:
            r0 = move-exception
            goto L_0x00c9
        L_0x00c1:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00bf }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r6)     // Catch:{ all -> 0x0171 }
            goto L_0x00be
        L_0x00c9:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r6)     // Catch:{ all -> 0x0171 }
            throw r0     // Catch:{ all -> 0x0171 }
        L_0x00cd:
            if (r4 != 0) goto L_0x016d
            java.lang.String r0 = "35"
            java.lang.String r6 = "predownloading"
            com.baidu.ubc.UBC.onEvent((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0171 }
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x0171 }
            int r0 = com.baidu.searchbox.update.UpdateUtils.getClientUpdateVcode(r0)     // Catch:{ all -> 0x0171 }
            r6 = r0
            int r0 = r17.getUpdateVersionCode()     // Catch:{ all -> 0x0171 }
            r7 = r0
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x0171 }
            long r8 = com.baidu.searchbox.update.UpdateUtils.getClientUpdateDownloadId(r0)     // Catch:{ all -> 0x0171 }
            if (r6 != r7) goto L_0x016b
            r10 = -1
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x016b
            r10 = 0
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x015f }
            android.net.Uri r12 = r0.getDownloadUri(r8)     // Catch:{ Exception -> 0x015f }
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x015f }
            android.content.ContentResolver r11 = r0.getContentResolver()     // Catch:{ Exception -> 0x015f }
            java.lang.String r0 = "_id"
            java.lang.String r13 = "_data"
            java.lang.String r14 = "uri"
            java.lang.String r15 = "status"
            java.lang.String[] r13 = new java.lang.String[]{r0, r13, r14, r15}     // Catch:{ Exception -> 0x015f }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r0 = r11.query(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x015f }
            r10 = r0
            if (r10 == 0) goto L_0x0159
            boolean r0 = r10.moveToFirst()     // Catch:{ Exception -> 0x015f }
            if (r0 == 0) goto L_0x0159
            r0 = 0
            java.lang.String r11 = "_data"
            int r11 = r10.getColumnIndex(r11)     // Catch:{ Exception -> 0x015f }
            if (r11 < 0) goto L_0x0137
            java.lang.String r13 = r10.getString(r11)     // Catch:{ Exception -> 0x015f }
            boolean r13 = checkFileExist(r13)     // Catch:{ Exception -> 0x015f }
            r0 = r13
        L_0x0137:
            java.lang.String r13 = "status"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x015f }
            if (r13 < 0) goto L_0x0159
            int r14 = r10.getInt(r13)     // Catch:{ Exception -> 0x015f }
            boolean r15 = com.baidu.searchbox.download.model.Downloads.isStatusCompleted(r14)     // Catch:{ Exception -> 0x015f }
            if (r15 == 0) goto L_0x0159
            boolean r15 = com.baidu.searchbox.download.model.Downloads.isStatusSuccess(r14)     // Catch:{ Exception -> 0x015f }
            if (r15 != 0) goto L_0x0156
            boolean r15 = com.baidu.searchbox.download.model.Downloads.isStatusError(r14)     // Catch:{ Exception -> 0x015f }
            if (r15 == 0) goto L_0x0159
        L_0x0156:
            if (r0 == 0) goto L_0x0159
            r4 = 1
        L_0x0159:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r10)     // Catch:{ all -> 0x0171 }
        L_0x015c:
            goto L_0x016b
        L_0x015d:
            r0 = move-exception
            goto L_0x0167
        L_0x015f:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x015d }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r10)     // Catch:{ all -> 0x0171 }
            goto L_0x015c
        L_0x0167:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r10)     // Catch:{ all -> 0x0171 }
            throw r0     // Catch:{ all -> 0x0171 }
        L_0x016b:
            monitor-exit(r1)
            return r4
        L_0x016d:
            monitor-exit(r1)
            return r4
        L_0x016f:
            monitor-exit(r1)
            return r4
        L_0x0171:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.UpdatePreDownloadUtils.checkCanShowUpdateDialog(com.baidu.searchbox.update.UpdateInfo):boolean");
    }

    private static boolean checkFileExist(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        return new File(filePath).exists();
    }

    public static boolean hasPreDownloadApk(UpdateInfo updateInfo) {
        if (updateInfo == null || TextUtils.isEmpty(updateInfo.getPreDownloadCon())) {
            return false;
        }
        UpdateDownloadInfo dwnInfo = checkUpdateDownloadInfo(updateInfo);
        if (!dwnInfo.mIsValid) {
            return false;
        }
        return hasPreDownloadApk(dwnInfo.mMd5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0218, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0219, code lost:
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01bb, code lost:
        r5 = r24;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        com.baidu.android.util.concurrent.UiThreadUtil.runOnUiThread(new com.baidu.searchbox.update.UpdatePreDownloadUtils.AnonymousClass4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c7, code lost:
        com.baidu.android.util.io.Closeables.closeSafely(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01cb, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:79:0x017f, B:86:0x01a4] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0218 A[ExcHandler: all (th java.lang.Throwable), PHI: r23 
      PHI: (r23v4 'cursor' android.database.Cursor) = (r23v5 'cursor' android.database.Cursor), (r23v5 'cursor' android.database.Cursor), (r23v5 'cursor' android.database.Cursor), (r23v6 'cursor' android.database.Cursor), (r23v6 'cursor' android.database.Cursor), (r23v9 'cursor' android.database.Cursor), (r23v9 'cursor' android.database.Cursor), (r23v9 'cursor' android.database.Cursor), (r23v9 'cursor' android.database.Cursor), (r23v9 'cursor' android.database.Cursor), (r23v9 'cursor' android.database.Cursor), (r23v11 'cursor' android.database.Cursor) binds: [B:107:0x01f2, B:115:0x0206, B:116:?, B:102:0x01e1, B:103:?, B:86:0x01a4, B:95:0x01bf, B:96:?, B:87:?, B:89:0x01aa, B:90:?, B:79:0x017f] A[DONT_GENERATE, DONT_INLINE], Splitter:B:79:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0183 A[Catch:{ Exception -> 0x021c, all -> 0x0218 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:102:0x01e1=Splitter:B:102:0x01e1, B:115:0x0206=Splitter:B:115:0x0206, B:79:0x017f=Splitter:B:79:0x017f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean hasPreDownloadApk(java.lang.String r31) {
        /*
            r1 = r31
            java.lang.String r0 = "status"
            java.lang.String r2 = "_data"
            android.content.Context r14 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            com.baidu.searchbox.update.UpdatePreDownloadUtils$UpdatePreDown r15 = getPreDownloadInfo()
            r13 = 0
            if (r15 != 0) goto L_0x0013
            return r13
        L_0x0013:
            r3 = 0
            com.baidu.searchbox.download.manager.DownloadManagerExt r4 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x0238 }
            long r5 = r15.mDownloadId     // Catch:{ Exception -> 0x0238 }
            android.net.Uri r17 = r4.getDownloadUri(r5)     // Catch:{ Exception -> 0x0238 }
            android.content.ContentResolver r16 = r14.getContentResolver()     // Catch:{ Exception -> 0x0238 }
            java.lang.String r4 = "_id"
            java.lang.String r5 = "uri"
            java.lang.String[] r18 = new java.lang.String[]{r4, r2, r5, r0}     // Catch:{ Exception -> 0x0238 }
            r19 = 0
            r20 = 0
            r21 = 0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0238 }
            r11 = r4
            if (r11 == 0) goto L_0x022d
            boolean r3 = r11.moveToFirst()     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            if (r3 == 0) goto L_0x022d
            java.lang.String r3 = ""
            int r2 = r11.getColumnIndex(r2)     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            if (r2 < 0) goto L_0x0056
            java.lang.String r4 = r11.getString(r2)     // Catch:{ Exception -> 0x0051, all -> 0x004d }
            r3 = r4
            r12 = r3
            goto L_0x0057
        L_0x004d:
            r0 = move-exception
            r3 = r11
            goto L_0x0242
        L_0x0051:
            r0 = move-exception
            r3 = r11
            r2 = r13
            goto L_0x023a
        L_0x0056:
            r12 = r3
        L_0x0057:
            int r0 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            r10 = r0
            r0 = 0
            if (r10 < 0) goto L_0x0067
            int r3 = r11.getInt(r10)     // Catch:{ Exception -> 0x0051, all -> 0x004d }
            r0 = r3
            r16 = r0
            goto L_0x0069
        L_0x0067:
            r16 = r0
        L_0x0069:
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusCompleted(r16)     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            r9 = 1
            if (r0 == 0) goto L_0x01e9
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusSuccess(r16)     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            if (r0 == 0) goto L_0x01e9
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            if (r0 != 0) goto L_0x01d9
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            r8 = r0
            boolean r0 = r8.exists()     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            if (r0 == 0) goto L_0x01cf
            boolean r0 = r15.mIsPatch     // Catch:{ Exception -> 0x0226, all -> 0x0220 }
            java.lang.String r18 = "predown"
            java.lang.String r7 = "34"
            if (r0 == 0) goto L_0x018a
            r19 = 0
            r20 = 0
            r21 = 0
            java.lang.String r0 = r8.getAbsolutePath()     // Catch:{ GenerateSaveFileError -> 0x0173 }
            r5 = 0
            r6 = 0
            r22 = 0
            r23 = 0
            java.lang.String r24 = "application/vnd.android.package-archive"
            r25 = 0
            r26 = 0
            r28 = 0
            r3 = r14
            r4 = r0
            r29 = r7
            r7 = r22
            r30 = r8
            r8 = r23
            r9 = r24
            r22 = r10
            r10 = r25
            r23 = r11
            r24 = r12
            r11 = r26
            r25 = r2
            r2 = r13
            r13 = r28
            java.lang.String r3 = com.baidu.searchbox.download.util.DownloadHelper.generateSaveFile(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13)     // Catch:{ GenerateSaveFileError -> 0x0171 }
            boolean r4 = DEBUG     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.String r5 = "UpdatePreDownloadUtils"
            if (r4 == 0) goto L_0x00e4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x016d }
            r6.<init>()     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.String r7 = "installApkFilePath: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.StringBuilder r6 = r6.append(r3)     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.String r6 = r6.toString()     // Catch:{ GenerateSaveFileError -> 0x016d }
            com.baidu.android.common.logging.Log.d(r5, r6)     // Catch:{ GenerateSaveFileError -> 0x016d }
        L_0x00e4:
            r6 = r0
            boolean r7 = com.baidu.android.util.io.FileUtils.isGzipFile(r0)     // Catch:{ GenerateSaveFileError -> 0x016d }
            if (r7 == 0) goto L_0x0110
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x016d }
            r7.<init>()     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.StringBuilder r7 = r7.append(r3)     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.String r8 = ".patch"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.String r7 = r7.toString()     // Catch:{ GenerateSaveFileError -> 0x016d }
            r6 = r7
            java.io.File r7 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x016d }
            r7.<init>(r0)     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.io.File r8 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x016d }
            r8.<init>(r6)     // Catch:{ GenerateSaveFileError -> 0x016d }
            boolean r7 = com.baidu.android.util.io.FileUtils.unGzipFile(r7, r8)     // Catch:{ GenerateSaveFileError -> 0x016d }
            if (r7 != 0) goto L_0x0110
            r6 = 0
        L_0x0110:
            if (r4 == 0) goto L_0x0129
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x016d }
            r4.<init>()     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.String r7 = "unGzipPatchFilePath: "
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ GenerateSaveFileError -> 0x016d }
            java.lang.String r4 = r4.toString()     // Catch:{ GenerateSaveFileError -> 0x016d }
            com.baidu.android.common.logging.Log.d(r5, r4)     // Catch:{ GenerateSaveFileError -> 0x016d }
        L_0x0129:
            java.io.File r4 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x016d }
            r4.<init>(r3)     // Catch:{ GenerateSaveFileError -> 0x016d }
            if (r6 == 0) goto L_0x014d
            java.io.File r5 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0147 }
            r5.<init>(r6)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            java.lang.String r7 = com.baidu.android.util.android.PkgUtils.getPackageSourcePath(r14)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            if (r7 == 0) goto L_0x014d
            java.io.File r8 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0147 }
            r8.<init>(r7)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            boolean r9 = com.baidu.searchbox.update.UpdateUtils.patchFile(r8, r5, r4)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            r21 = r9
            goto L_0x014d
        L_0x0147:
            r0 = move-exception
            r19 = r3
            r20 = r4
            goto L_0x017f
        L_0x014d:
            if (r21 == 0) goto L_0x016c
            java.lang.String r5 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((java.io.File) r4, (boolean) r2)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            boolean r7 = android.text.TextUtils.equals(r1, r5)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            if (r7 == 0) goto L_0x016c
            com.baidu.searchbox.update.UpdateUtils.installClientUpdateApk(r14, r3)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            java.lang.String r7 = "patch"
            r8 = r29
            com.baidu.ubc.UBC.onEvent((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            com.baidu.searchbox.update.UpdateUBCStatistic.doInstallStatistic(r18)     // Catch:{ GenerateSaveFileError -> 0x0147 }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r23)
            r7 = 1
            return r7
        L_0x016c:
            goto L_0x0186
        L_0x016d:
            r0 = move-exception
            r19 = r3
            goto L_0x017f
        L_0x0171:
            r0 = move-exception
            goto L_0x017f
        L_0x0173:
            r0 = move-exception
            r25 = r2
            r30 = r8
            r22 = r10
            r23 = r11
            r24 = r12
            r2 = r13
        L_0x017f:
            boolean r3 = DEBUG     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            if (r3 == 0) goto L_0x0186
            r0.printStackTrace()     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
        L_0x0186:
            r5 = r24
            goto L_0x01e1
        L_0x018a:
            r25 = r2
            r30 = r8
            r22 = r10
            r23 = r11
            r24 = r12
            r2 = r13
            r8 = r7
            r7 = r9
            r3 = r30
            java.lang.String r0 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((java.io.File) r3, (boolean) r2)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            r4 = r0
            boolean r0 = android.text.TextUtils.equals(r1, r4)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            if (r0 == 0) goto L_0x01cc
            android.net.Uri.parse(r24)     // Catch:{ Exception -> 0x01ba, all -> 0x0218 }
            r5 = r24
            com.baidu.searchbox.update.UpdateUtils.installClientUpdateApk(r14, r5)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            java.lang.String r0 = "full"
            com.baidu.ubc.UBC.onEvent((java.lang.String) r8, (java.lang.String) r0)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            com.baidu.searchbox.update.UpdateUBCStatistic.doInstallStatistic(r18)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r23)
            return r7
        L_0x01ba:
            r0 = move-exception
            r5 = r24
            r6 = r0
            r0 = r6
            com.baidu.searchbox.update.UpdatePreDownloadUtils$4 r6 = new com.baidu.searchbox.update.UpdatePreDownloadUtils$4     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            r6.<init>()     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            com.baidu.android.util.concurrent.UiThreadUtil.runOnUiThread(r6)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r23)
            return r2
        L_0x01cc:
            r5 = r24
            goto L_0x01e1
        L_0x01cf:
            r25 = r2
            r3 = r8
            r22 = r10
            r23 = r11
            r5 = r12
            r2 = r13
            goto L_0x01e1
        L_0x01d9:
            r25 = r2
            r22 = r10
            r23 = r11
            r5 = r12
            r2 = r13
        L_0x01e1:
            clearPreDownloadInfo()     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r23)
            return r2
        L_0x01e9:
            r25 = r2
            r7 = r9
            r22 = r10
            r23 = r11
            r5 = r12
            r2 = r13
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusCompleted(r16)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            if (r0 == 0) goto L_0x0206
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusError(r16)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            if (r0 == 0) goto L_0x0206
            clearPreDownloadInfo()     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r23)
            return r2
        L_0x0206:
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            long[] r3 = new long[r7]     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            long r6 = r15.mDownloadId     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            r3[r2] = r6     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            r0.pauseDownload((long[]) r3)     // Catch:{ Exception -> 0x021c, all -> 0x0218 }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r23)
            return r2
        L_0x0218:
            r0 = move-exception
            r3 = r23
            goto L_0x0242
        L_0x021c:
            r0 = move-exception
            r3 = r23
            goto L_0x023a
        L_0x0220:
            r0 = move-exception
            r23 = r11
            r3 = r23
            goto L_0x0242
        L_0x0226:
            r0 = move-exception
            r23 = r11
            r2 = r13
            r3 = r23
            goto L_0x023a
        L_0x022d:
            r23 = r11
            r2 = r13
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r23)
            r11 = r23
            goto L_0x0241
        L_0x0236:
            r0 = move-exception
            goto L_0x0242
        L_0x0238:
            r0 = move-exception
            r2 = r13
        L_0x023a:
            r0.printStackTrace()     // Catch:{ all -> 0x0236 }
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r3)
            r11 = r3
        L_0x0241:
            return r2
        L_0x0242:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.UpdatePreDownloadUtils.hasPreDownloadApk(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x01a2 A[Catch:{ Exception -> 0x01d2, all -> 0x01c6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean resumePreDownloadTask(long r34, boolean r36, java.lang.String r37) {
        /*
            r1 = r34
            r3 = r37
            android.content.Context r15 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.ContentResolver r22 = r15.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r23 = 0
            r8 = 0
            java.lang.String r0 = "_id"
            java.lang.String r9 = "_data"
            java.lang.String r10 = "uri"
            java.lang.String r11 = "status"
            java.lang.String[] r18 = new java.lang.String[]{r0, r9, r10, r11}
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x0323, all -> 0x031e }
            android.net.Uri r0 = r0.getDownloadUri(r1)     // Catch:{ Exception -> 0x0323, all -> 0x031e }
            r14 = r0
            r19 = 0
            r20 = 0
            r21 = 0
            r16 = r22
            r17 = r14
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x031a, all -> 0x0316 }
            r12 = r0
            if (r12 == 0) goto L_0x030c
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x0304, all -> 0x02fc }
            if (r0 == 0) goto L_0x030c
            int r0 = r12.getColumnIndex(r9)     // Catch:{ Exception -> 0x0304, all -> 0x02fc }
            r13 = r0
            if (r13 < 0) goto L_0x0059
            java.lang.String r0 = r12.getString(r13)     // Catch:{ Exception -> 0x0054, all -> 0x004f }
            r5 = r0
            r9 = r5
            goto L_0x005a
        L_0x004f:
            r0 = move-exception
            r4 = r12
            r8 = r14
            goto L_0x031f
        L_0x0054:
            r0 = move-exception
            r4 = r12
            r8 = r14
            goto L_0x0324
        L_0x0059:
            r9 = r5
        L_0x005a:
            int r0 = r12.getColumnIndex(r11)     // Catch:{ Exception -> 0x02f0, all -> 0x02e4 }
            r11 = r0
            if (r11 < 0) goto L_0x0074
            int r0 = r12.getInt(r11)     // Catch:{ Exception -> 0x006e, all -> 0x0068 }
            r7 = r0
            r8 = r7
            goto L_0x0075
        L_0x0068:
            r0 = move-exception
            r5 = r9
            r4 = r12
            r8 = r14
            goto L_0x031f
        L_0x006e:
            r0 = move-exception
            r5 = r9
            r4 = r12
            r8 = r14
            goto L_0x0324
        L_0x0074:
            r8 = r7
        L_0x0075:
            int r0 = r12.getColumnIndex(r10)     // Catch:{ Exception -> 0x02d7, all -> 0x02c9 }
            r10 = r0
            if (r10 < 0) goto L_0x0092
            java.lang.String r0 = r12.getString(r10)     // Catch:{ Exception -> 0x008b, all -> 0x0084 }
            r6 = r0
            r16 = r6
            goto L_0x0094
        L_0x0084:
            r0 = move-exception
            r7 = r8
            r5 = r9
            r4 = r12
            r8 = r14
            goto L_0x031f
        L_0x008b:
            r0 = move-exception
            r7 = r8
            r5 = r9
            r4 = r12
            r8 = r14
            goto L_0x0324
        L_0x0092:
            r16 = r6
        L_0x0094:
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusCompleted(r8)     // Catch:{ Exception -> 0x02b9, all -> 0x02a9 }
            r7 = 0
            if (r0 == 0) goto L_0x022f
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusSuccess(r8)     // Catch:{ Exception -> 0x021c, all -> 0x0209 }
            if (r0 == 0) goto L_0x022f
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x021c, all -> 0x0209 }
            if (r0 != 0) goto L_0x01f4
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x021c, all -> 0x0209 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x021c, all -> 0x0209 }
            r6 = r0
            boolean r0 = r6.exists()     // Catch:{ Exception -> 0x021c, all -> 0x0209 }
            if (r0 == 0) goto L_0x01de
            if (r36 == 0) goto L_0x01a6
            r17 = 0
            r19 = 0
            r20 = 0
            java.lang.String r0 = r6.getAbsolutePath()     // Catch:{ GenerateSaveFileError -> 0x018e }
            r21 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            java.lang.String r27 = "application/vnd.android.package-archive"
            r28 = 0
            r29 = 0
            r31 = 0
            r4 = r15
            r5 = r0
            r32 = r6
            r6 = r21
            r7 = r24
            r33 = r8
            r8 = r25
            r21 = r9
            r9 = r26
            r24 = r10
            r10 = r27
            r25 = r11
            r11 = r28
            r26 = r12
            r27 = r13
            r12 = r29
            r1 = r14
            r14 = r31
            java.lang.String r2 = com.baidu.searchbox.download.util.DownloadHelper.generateSaveFile(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14)     // Catch:{ GenerateSaveFileError -> 0x018c }
            boolean r4 = DEBUG     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.String r5 = "UpdatePreDownloadUtils"
            if (r4 == 0) goto L_0x0110
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0188 }
            r6.<init>()     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.String r7 = "install apk filepath: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.StringBuilder r6 = r6.append(r2)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.String r6 = r6.toString()     // Catch:{ GenerateSaveFileError -> 0x0188 }
            com.baidu.android.common.logging.Log.d(r5, r6)     // Catch:{ GenerateSaveFileError -> 0x0188 }
        L_0x0110:
            r6 = r0
            boolean r7 = com.baidu.android.util.io.FileUtils.isGzipFile(r0)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            if (r7 == 0) goto L_0x013c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0188 }
            r7.<init>()     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.StringBuilder r7 = r7.append(r2)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.String r8 = ".patch"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.String r7 = r7.toString()     // Catch:{ GenerateSaveFileError -> 0x0188 }
            r6 = r7
            java.io.File r7 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0188 }
            r7.<init>(r0)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.io.File r8 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0188 }
            r8.<init>(r6)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            boolean r7 = com.baidu.android.util.io.FileUtils.unGzipFile(r7, r8)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            if (r7 != 0) goto L_0x013c
            r6 = 0
        L_0x013c:
            if (r4 == 0) goto L_0x0154
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ GenerateSaveFileError -> 0x0188 }
            r4.<init>()     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.String r7 = "aunGzipPatchFilePath: "
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            java.lang.String r4 = r4.toString()     // Catch:{ GenerateSaveFileError -> 0x0188 }
            com.baidu.android.common.logging.Log.d(r5, r4)     // Catch:{ GenerateSaveFileError -> 0x0188 }
        L_0x0154:
            java.io.File r4 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0188 }
            r4.<init>(r2)     // Catch:{ GenerateSaveFileError -> 0x0188 }
            if (r6 == 0) goto L_0x0178
            java.io.File r5 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0172 }
            r5.<init>(r6)     // Catch:{ GenerateSaveFileError -> 0x0172 }
            java.lang.String r7 = com.baidu.android.util.android.PkgUtils.getPackageSourcePath(r15)     // Catch:{ GenerateSaveFileError -> 0x0172 }
            if (r7 == 0) goto L_0x0178
            java.io.File r8 = new java.io.File     // Catch:{ GenerateSaveFileError -> 0x0172 }
            r8.<init>(r7)     // Catch:{ GenerateSaveFileError -> 0x0172 }
            boolean r9 = com.baidu.searchbox.update.UpdateUtils.patchFile(r8, r5, r4)     // Catch:{ GenerateSaveFileError -> 0x0172 }
            r20 = r9
            goto L_0x0178
        L_0x0172:
            r0 = move-exception
            r17 = r2
            r19 = r4
            goto L_0x019e
        L_0x0178:
            if (r20 == 0) goto L_0x0187
            r5 = 0
            java.lang.String r5 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((java.io.File) r4, (boolean) r5)     // Catch:{ GenerateSaveFileError -> 0x0172 }
            boolean r7 = android.text.TextUtils.equals(r3, r5)     // Catch:{ GenerateSaveFileError -> 0x0172 }
            if (r7 == 0) goto L_0x0187
            r23 = 1
        L_0x0187:
            goto L_0x01a5
        L_0x0188:
            r0 = move-exception
            r17 = r2
            goto L_0x019e
        L_0x018c:
            r0 = move-exception
            goto L_0x019e
        L_0x018e:
            r0 = move-exception
            r32 = r6
            r33 = r8
            r21 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r1 = r14
        L_0x019e:
            boolean r2 = DEBUG     // Catch:{ Exception -> 0x01d2, all -> 0x01c6 }
            if (r2 == 0) goto L_0x01a5
            r0.printStackTrace()     // Catch:{ Exception -> 0x01d2, all -> 0x01c6 }
        L_0x01a5:
            goto L_0x01ec
        L_0x01a6:
            r32 = r6
            r5 = r7
            r33 = r8
            r21 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r1 = r14
            r2 = r32
            java.lang.String r0 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((java.io.File) r2, (boolean) r5)     // Catch:{ Exception -> 0x01d2, all -> 0x01c6 }
            boolean r4 = android.text.TextUtils.equals(r3, r0)     // Catch:{ Exception -> 0x01d2, all -> 0x01c6 }
            if (r4 == 0) goto L_0x01ec
            r4 = 1
            r23 = r4
            goto L_0x01ec
        L_0x01c6:
            r0 = move-exception
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            r7 = r33
            goto L_0x031f
        L_0x01d2:
            r0 = move-exception
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            r7 = r33
            goto L_0x0324
        L_0x01de:
            r2 = r6
            r33 = r8
            r21 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r1 = r14
        L_0x01ec:
            r6 = r16
            r5 = r21
            r7 = r33
            goto L_0x030f
        L_0x01f4:
            r33 = r8
            r21 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r1 = r14
            r6 = r16
            r5 = r21
            r7 = r33
            goto L_0x030f
        L_0x0209:
            r0 = move-exception
            r33 = r8
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            r7 = r33
            goto L_0x031f
        L_0x021c:
            r0 = move-exception
            r33 = r8
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            r7 = r33
            goto L_0x0324
        L_0x022f:
            r5 = r7
            r33 = r8
            r21 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r1 = r14
            r0 = 192(0xc0, float:2.69E-43)
            java.lang.String r2 = "33"
            r7 = r33
            if (r7 != r0) goto L_0x0273
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            com.baidu.searchbox.update.UpdatePreDownloadUtils$5 r4 = new com.baidu.searchbox.update.UpdatePreDownloadUtils$5     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r4.<init>()     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r0.registerObserver(r15, r1, r4)     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r23 = 1
            java.lang.String r0 = "running task"
            com.baidu.ubc.UBC.onEvent((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r6 = r16
            r5 = r21
            goto L_0x030f
        L_0x025f:
            r0 = move-exception
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            goto L_0x031f
        L_0x0269:
            r0 = move-exception
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            goto L_0x0324
        L_0x0273:
            if (r36 == 0) goto L_0x0283
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusError(r7)     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            if (r0 == 0) goto L_0x0283
            r23 = 0
            r6 = r16
            r5 = r21
            goto L_0x030f
        L_0x0283:
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            com.baidu.searchbox.update.UpdatePreDownloadUtils$6 r4 = new com.baidu.searchbox.update.UpdatePreDownloadUtils$6     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r4.<init>()     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r0.registerObserver(r15, r1, r4)     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r4 = 1
            long[] r4 = new long[r4]     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r4[r5] = r34     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r0.resumeDownload((long[]) r4)     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r23 = 1
            java.lang.String r0 = "resume task"
            com.baidu.ubc.UBC.onEvent((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0269, all -> 0x025f }
            r6 = r16
            r5 = r21
            goto L_0x030f
        L_0x02a9:
            r0 = move-exception
            r7 = r8
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            goto L_0x031f
        L_0x02b9:
            r0 = move-exception
            r7 = r8
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r6 = r16
            r5 = r21
            r4 = r26
            goto L_0x0324
        L_0x02c9:
            r0 = move-exception
            r7 = r8
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r5 = r21
            r4 = r26
            goto L_0x031f
        L_0x02d7:
            r0 = move-exception
            r7 = r8
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r5 = r21
            r4 = r26
            goto L_0x0324
        L_0x02e4:
            r0 = move-exception
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r5 = r21
            r4 = r26
            goto L_0x031f
        L_0x02f0:
            r0 = move-exception
            r21 = r9
            r26 = r12
            r1 = r14
            r8 = r1
            r5 = r21
            r4 = r26
            goto L_0x0324
        L_0x02fc:
            r0 = move-exception
            r26 = r12
            r1 = r14
            r8 = r1
            r4 = r26
            goto L_0x031f
        L_0x0304:
            r0 = move-exception
            r26 = r12
            r1 = r14
            r8 = r1
            r4 = r26
            goto L_0x0324
        L_0x030c:
            r26 = r12
            r1 = r14
        L_0x030f:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r26)
            r14 = r1
            r12 = r26
            goto L_0x032b
        L_0x0316:
            r0 = move-exception
            r1 = r14
            r8 = r1
            goto L_0x031f
        L_0x031a:
            r0 = move-exception
            r1 = r14
            r8 = r1
            goto L_0x0324
        L_0x031e:
            r0 = move-exception
        L_0x031f:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r4)
            throw r0
        L_0x0323:
            r0 = move-exception
        L_0x0324:
            r23 = 0
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r4)
            r12 = r4
            r14 = r8
        L_0x032b:
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.UpdatePreDownloadUtils.resumePreDownloadTask(long, boolean, java.lang.String):boolean");
    }
}
