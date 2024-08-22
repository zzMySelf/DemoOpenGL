package com.baidu.searchbox.update;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import com.android.support.appcompat.PendingIntentCompatKt;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.R;
import com.baidu.searchbox.download.callback.DownloadListener;
import com.baidu.searchbox.download.constants.MigrateStatisticConstants;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.searchbox.silence.SilenceUtil;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.searchbox.update.UpdateCallBack;
import com.baidu.searchbox.update.upgrade.UpgradeCheckParser;
import java.util.Locale;
import org.json.JSONObject;

public final class SilentUpgrade {
    public static final String ACTION_SILENT_UPGRADE = "com.baidu.searchbox.action.common.S_UPGRADE";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String SILENT_NOTIFICATION_URI_KEY = "uri";
    public static final String SILENT_UPGRADE_INFO_KEY = "silent_upgrade_info_key";
    public static final String TAG = "SilentUpgrade";
    public static Uri backgroundInstallUri = null;
    /* access modifiers changed from: private */
    public Context mAppContext;
    /* access modifiers changed from: private */
    public BroadcastReceiver mSilentReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!TextUtils.equals(intent.getAction(), "com.baidu.searchbox.action.common.S_UPGRADE")) {
                return;
            }
            if (!intent.hasExtra("uri")) {
                Log.d(SilentUpgrade.TAG, "No URI param, cancel silent install");
                return;
            }
            if (SilentUpgrade.DEBUG) {
                Log.d(SilentUpgrade.TAG, "unregisterReceiver mSilentReceiver & doInstallPacakge");
            }
            SilentUpgrade.this.mAppContext.unregisterReceiver(SilentUpgrade.this.mSilentReceiver);
            MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_NOTIFICATION_INSTALL_TYPE, MigrateStatisticUtils.build(""));
            UpdateUBCStatistic.doInstallStatistic("silent");
            SilenceUtil.doInstallPacakge(SilentUpgrade.this.mAppContext, (Uri) intent.getParcelableExtra("uri"), UpdateUtils.INSTALLER_PACKAGE_NAME);
        }
    };
    /* access modifiers changed from: private */
    public UpdateInfo mUpdateInfo;
    /* access modifiers changed from: private */
    public BroadcastReceiver netChangedReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), PreloadConstantsKt.CONNECTIVITY_ACTION)) {
                SilentUpgrade silentUpgrade = SilentUpgrade.this;
                if (silentUpgrade.isCurNetMatchDownloadCond(silentUpgrade.mUpdateInfo.getDownloadConditon())) {
                    if (SilentUpgrade.DEBUG) {
                        Log.d(SilentUpgrade.TAG, "unregisterReceiver netChangedReceiver & downloadSilentApk");
                    }
                    SilentUpgrade.this.mAppContext.unregisterReceiver(SilentUpgrade.this.netChangedReceiver);
                    SilentUpgrade.this.downloadSilentApk();
                }
            }
        }
    };
    private UpdateCallBack.ResponseCallback silentUpgradeCallback = new UpdateCallBack.ResponseCallback() {
        public void handleNetException() {
            if (SilentUpgrade.DEBUG) {
                Log.d(SilentUpgrade.TAG, "silentUpgradeCallback, handleNetException");
            }
            MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_NET_ERROR_TYPE, MigrateStatisticUtils.build(""));
        }

        public void handleNoResponse() {
            if (SilentUpgrade.DEBUG) {
                Log.d(SilentUpgrade.TAG, "silentUpgradeCallback, handleNoResponse");
            }
            MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_NO_HIGH_VERSION_TYPE, MigrateStatisticUtils.build(""));
        }

        public void handleResponse(Context context, JSONObject response, String rn) {
            UpdateInfo info;
            if (SilentUpgrade.DEBUG) {
                Log.d(SilentUpgrade.TAG, "handleResponse, response: " + response);
            }
            if (response != null && (info = new UpgradeCheckParser(rn).parseJson(response)) != null) {
                if (info.getSigCheckMatched()) {
                    UpdateInfo unused = SilentUpgrade.this.mUpdateInfo = info;
                    if (SilentUpgrade.DEBUG) {
                        Log.d(SilentUpgrade.TAG, "——> handleResponse: mUpdateInfo " + SilentUpgrade.this.mUpdateInfo.toString());
                    }
                    if (SilentUpgrade.this.isCurNetMatchDownloadCond(info.getDownloadConditon())) {
                        if (SilentUpgrade.DEBUG) {
                            Log.d(SilentUpgrade.TAG, "handleResponse, updateImmediately. url: " + info.getUrl());
                        }
                        SilentUpgrade.this.downloadSilentApk();
                        return;
                    }
                    if (SilentUpgrade.DEBUG) {
                        Log.d(SilentUpgrade.TAG, "regist netChangedReceiver");
                    }
                    MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_NETNOTMATCH_TYPE, MigrateStatisticUtils.build(""));
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
                    SilentUpgrade.this.mAppContext.registerReceiver(SilentUpgrade.this.netChangedReceiver, intentFilter);
                } else if (SilentUpgrade.DEBUG) {
                    Log.e(SilentUpgrade.TAG, "SilentUpgradeInfo is not valide, cancel silent download");
                }
            }
        }
    };

    public SilentUpgrade(Context context) {
        this.mAppContext = context;
    }

    public UpdateCallBack.ResponseCallback getUpdateResponseCallback() {
        return this.silentUpgradeCallback;
    }

    /* access modifiers changed from: private */
    public void downloadSilentApk() {
        if (DEBUG) {
            Log.d(TAG, "downloadSilentApk");
        }
        MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_NETMATCH_DOWNLOAD_TYPE, MigrateStatisticUtils.build(""));
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                SilentUpgrade.this.download();
            }
        }, "downloadSilentApk", 3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x021b A[Catch:{ all -> 0x0226 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void download() {
        /*
            r25 = this;
            r1 = r25
            com.baidu.android.util.sp.SharedPrefsWrapper r0 = new com.baidu.android.util.sp.SharedPrefsWrapper
            java.lang.String r2 = ""
            r0.<init>((java.lang.String) r2)
            java.lang.String r3 = "silent_upgrade_info_key"
            java.lang.String r4 = r0.getString(r3, r2)
            com.baidu.searchbox.update.SilentUpgradeInfo r0 = new com.baidu.searchbox.update.SilentUpgradeInfo
            r0.<init>(r4)
            r5 = r0
            r6 = 1
            r7 = 0
            int r0 = r5.mVersionCode
            com.baidu.searchbox.update.UpdateInfo r8 = r1.mUpdateInfo
            int r8 = r8.getUpdateVersionCode()
            java.lang.String r11 = "SilentUpgrade"
            if (r0 != r8) goto L_0x0230
            java.lang.String r0 = r5.mMD5
            com.baidu.searchbox.update.UpdateInfo r8 = r1.mUpdateInfo
            java.lang.String r8 = r8.getSilentMD5()
            boolean r0 = android.text.TextUtils.equals(r0, r8)
            if (r0 == 0) goto L_0x022b
            android.content.Context r8 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.ContentResolver r18 = r8.getContentResolver()
            r19 = 0
            r20 = 0
            r21 = 0
            java.lang.String r0 = "_id"
            java.lang.String r15 = "_data"
            java.lang.String r12 = "uri"
            java.lang.String r13 = "status"
            java.lang.String[] r14 = new java.lang.String[]{r0, r15, r12, r13}
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x0212, all -> 0x020c }
            long r9 = r5.mDownloadId     // Catch:{ Exception -> 0x0212, all -> 0x020c }
            android.net.Uri r0 = r0.getDownloadUri(r9)     // Catch:{ Exception -> 0x0212, all -> 0x020c }
            r7 = r0
            r0 = 0
            r16 = 0
            r17 = 0
            r12 = r18
            r9 = r13
            r13 = r7
            r10 = r15
            r15 = r0
            android.database.Cursor r0 = r12.query(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0205, all -> 0x01fe }
            r12 = r0
            if (r12 == 0) goto L_0x01f2
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x01e9, all -> 0x01e0 }
            if (r0 == 0) goto L_0x01f2
            int r0 = r12.getColumnIndex(r10)     // Catch:{ Exception -> 0x01e9, all -> 0x01e0 }
            if (r0 < 0) goto L_0x008c
            java.lang.String r10 = r12.getString(r0)     // Catch:{ Exception -> 0x0085, all -> 0x007e }
            r20 = r10
            goto L_0x008e
        L_0x007e:
            r0 = move-exception
            r17 = r4
            r19 = r12
            goto L_0x0227
        L_0x0085:
            r0 = move-exception
            r17 = r4
            r19 = r12
            goto L_0x0217
        L_0x008c:
            r10 = r20
        L_0x008e:
            int r9 = r12.getColumnIndex(r9)     // Catch:{ Exception -> 0x01d5, all -> 0x01c9 }
            if (r9 < 0) goto L_0x00ad
            int r13 = r12.getInt(r9)     // Catch:{ Exception -> 0x00a4, all -> 0x009b }
            r21 = r13
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            r17 = r4
            r20 = r10
            r19 = r12
            goto L_0x0227
        L_0x00a4:
            r0 = move-exception
            r17 = r4
            r20 = r10
            r19 = r12
            goto L_0x0217
        L_0x00ad:
            r13 = r21
        L_0x00af:
            boolean r15 = DEBUG     // Catch:{ Exception -> 0x01bb, all -> 0x01ad }
            if (r15 == 0) goto L_0x00ec
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r15.<init>()     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r16 = r0
            java.lang.String r0 = "filePath="
            java.lang.StringBuilder r0 = r15.append(r0)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            java.lang.String r15 = ", statue="
            java.lang.StringBuilder r0 = r0.append(r15)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            java.lang.StringBuilder r0 = r0.append(r13)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            com.baidu.android.common.logging.Log.e((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            goto L_0x00ee
        L_0x00d6:
            r0 = move-exception
            r17 = r4
            r20 = r10
            r19 = r12
            r21 = r13
            goto L_0x0227
        L_0x00e1:
            r0 = move-exception
            r17 = r4
            r20 = r10
            r19 = r12
            r21 = r13
            goto L_0x0217
        L_0x00ec:
            r16 = r0
        L_0x00ee:
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusCompleted(r13)     // Catch:{ Exception -> 0x01bb, all -> 0x01ad }
            if (r0 == 0) goto L_0x0139
            boolean r0 = com.baidu.searchbox.download.model.Downloads.isStatusSuccess(r13)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            if (r0 == 0) goto L_0x0139
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            if (r0 != 0) goto L_0x0130
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            boolean r15 = r0.exists()     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            if (r15 == 0) goto L_0x0125
            r15 = 0
            java.lang.String r17 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((java.io.File) r0, (boolean) r15)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r15 = r17
            r17 = r0
            java.lang.String r0 = r5.mMD5     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            boolean r0 = android.text.TextUtils.equals(r0, r15)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            if (r0 == 0) goto L_0x0127
            r6 = 0
            android.net.Uri r0 = android.net.Uri.parse(r10)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r1.handleNotifyType(r0)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            goto L_0x0127
        L_0x0125:
            r17 = r0
        L_0x0127:
            r17 = r4
            r15 = r7
            r20 = r10
            r21 = r13
            goto L_0x01f9
        L_0x0130:
            r17 = r4
            r15 = r7
            r20 = r10
            r21 = r13
            goto L_0x01f9
        L_0x0139:
            r0 = 192(0xc0, float:2.69E-43)
            if (r13 != r0) goto L_0x0154
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            com.baidu.searchbox.update.SilentUpgrade$SilentDownloadListener r15 = new com.baidu.searchbox.update.SilentUpgrade$SilentDownloadListener     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r15.<init>()     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r0.registerObserver(r8, r7, r15)     // Catch:{ Exception -> 0x00e1, all -> 0x00d6 }
            r0 = 0
            r6 = r0
            r17 = r4
            r15 = r7
            r20 = r10
            r21 = r13
            goto L_0x01f9
        L_0x0154:
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x01bb, all -> 0x01ad }
            com.baidu.searchbox.update.SilentUpgrade$SilentDownloadListener r15 = new com.baidu.searchbox.update.SilentUpgrade$SilentDownloadListener     // Catch:{ Exception -> 0x01bb, all -> 0x01ad }
            r15.<init>()     // Catch:{ Exception -> 0x01bb, all -> 0x01ad }
            r0.registerObserver(r8, r7, r15)     // Catch:{ Exception -> 0x01bb, all -> 0x01ad }
            com.baidu.searchbox.download.manager.DownloadManagerExt r0 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x01bb, all -> 0x01ad }
            r17 = r4
            r15 = 1
            long[] r4 = new long[r15]     // Catch:{ Exception -> 0x01a1, all -> 0x0195 }
            r24 = r6
            r15 = r7
            long r6 = r5.mDownloadId     // Catch:{ Exception -> 0x0189, all -> 0x017d }
            r19 = 0
            r4[r19] = r6     // Catch:{ Exception -> 0x0189, all -> 0x017d }
            r0.resumeDownload((long[]) r4)     // Catch:{ Exception -> 0x0189, all -> 0x017d }
            r0 = 0
            r6 = r0
            r20 = r10
            r21 = r13
            goto L_0x01f9
        L_0x017d:
            r0 = move-exception
            r20 = r10
            r19 = r12
            r21 = r13
            r7 = r15
            r6 = r24
            goto L_0x0227
        L_0x0189:
            r0 = move-exception
            r20 = r10
            r19 = r12
            r21 = r13
            r7 = r15
            r6 = r24
            goto L_0x0217
        L_0x0195:
            r0 = move-exception
            r24 = r6
            r15 = r7
            r20 = r10
            r19 = r12
            r21 = r13
            goto L_0x0227
        L_0x01a1:
            r0 = move-exception
            r24 = r6
            r15 = r7
            r20 = r10
            r19 = r12
            r21 = r13
            goto L_0x0217
        L_0x01ad:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            r20 = r10
            r19 = r12
            r21 = r13
            goto L_0x0227
        L_0x01bb:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            r20 = r10
            r19 = r12
            r21 = r13
            goto L_0x0217
        L_0x01c9:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            r20 = r10
            r19 = r12
            goto L_0x0227
        L_0x01d5:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            r20 = r10
            r19 = r12
            goto L_0x0217
        L_0x01e0:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            r19 = r12
            goto L_0x0227
        L_0x01e9:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            r19 = r12
            goto L_0x0217
        L_0x01f2:
            r17 = r4
            r24 = r6
            r15 = r7
            r6 = r24
        L_0x01f9:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r12)
            r7 = r15
            goto L_0x0236
        L_0x01fe:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            goto L_0x0227
        L_0x0205:
            r0 = move-exception
            r17 = r4
            r24 = r6
            r15 = r7
            goto L_0x0217
        L_0x020c:
            r0 = move-exception
            r17 = r4
            r24 = r6
            goto L_0x0227
        L_0x0212:
            r0 = move-exception
            r17 = r4
            r24 = r6
        L_0x0217:
            boolean r4 = DEBUG     // Catch:{ all -> 0x0226 }
            if (r4 == 0) goto L_0x0222
            java.lang.String r4 = com.baidu.android.common.logging.Log.getStackTraceString(r0)     // Catch:{ all -> 0x0226 }
            com.baidu.android.common.logging.Log.e((java.lang.String) r11, (java.lang.String) r4)     // Catch:{ all -> 0x0226 }
        L_0x0222:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r19)
            goto L_0x0236
        L_0x0226:
            r0 = move-exception
        L_0x0227:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r19)
            throw r0
        L_0x022b:
            r17 = r4
            r24 = r6
            goto L_0x0234
        L_0x0230:
            r17 = r4
            r24 = r6
        L_0x0234:
            r6 = r24
        L_0x0236:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0251
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "shouldRedownload="
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.baidu.android.common.logging.Log.d(r11, r4)
        L_0x0251:
            if (r6 == 0) goto L_0x02a8
            com.baidu.searchbox.download.manager.DownloadManagerExt r4 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()
            r8 = 1
            long[] r9 = new long[r8]
            long r12 = r5.mDownloadId
            r10 = 0
            r9[r10] = r12
            r4.deleteDownload(r8, r9)
            com.baidu.android.util.sp.SharedPrefsWrapper r4 = new com.baidu.android.util.sp.SharedPrefsWrapper
            r4.<init>((java.lang.String) r2)
            r4.putString(r3, r2)
            long r8 = r25.doDownload()
            com.baidu.searchbox.update.SilentUpgradeInfo r2 = new com.baidu.searchbox.update.SilentUpgradeInfo
            com.baidu.searchbox.update.UpdateInfo r10 = r1.mUpdateInfo
            int r19 = r10.getUpdateVersionCode()
            com.baidu.searchbox.update.UpdateInfo r10 = r1.mUpdateInfo
            java.lang.String r20 = r10.getUrl()
            com.baidu.searchbox.update.UpdateInfo r10 = r1.mUpdateInfo
            java.lang.String r21 = r10.getSilentMD5()
            r18 = r2
            r22 = r8
            r18.<init>(r19, r20, r21, r22)
            java.lang.String r10 = r2.toJSONString()
            r4.putString(r3, r10)
            if (r0 == 0) goto L_0x02a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Start New Download: download id = "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.baidu.android.common.logging.Log.d(r11, r0)
        L_0x02a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.update.SilentUpgrade.download():void");
    }

    private long doDownload() {
        return ContentUris.parseId(UpdatePackageDownloader.getInstance(this.mAppContext).updateSilent(this.mUpdateInfo.getUrl(), new SilentDownloadListener()));
    }

    /* access modifiers changed from: private */
    public void handleNotifyType(Uri uri) {
        String type = this.mUpdateInfo.getNotifyType();
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "notify type: " + type);
        }
        if (TextUtils.equals(type, "0")) {
            installSilentApk(uri);
        } else if (TextUtils.equals(type, "1")) {
            if (Build.VERSION.SDK_INT < 33 || this.mAppContext.getApplicationInfo().targetSdkVersion < 33) {
                showSilentNotification(uri);
            } else if (ActivityCompat.checkSelfPermission(this.mAppContext, "android.permission.POST_NOTIFICATIONS") == 0) {
                showSilentNotification(uri);
            } else {
                installSilentApk(uri);
            }
        } else if (TextUtils.equals(type, "2")) {
            showSilentDialog(uri);
        } else if (z) {
            Log.d(TAG, "server data error, unknow notify_type");
        }
    }

    private void showSilentNotification(Uri uri) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "showSilentNotification");
        }
        String notifyInfo = this.mUpdateInfo.getNotifyInfo();
        if (!TextUtils.isEmpty(notifyInfo)) {
            MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_SHOW_NOTIFICATION_TYPE, MigrateStatisticUtils.build(""));
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.searchbox.action.common.S_UPGRADE");
            this.mAppContext.registerReceiver(this.mSilentReceiver, intentFilter);
            Intent intent = new Intent().setAction("com.baidu.searchbox.action.common.S_UPGRADE");
            intent.putExtra("uri", uri);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mAppContext).setTicker(this.mAppContext.getString(R.string.notification_download_complete)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(this.mAppContext.getString(com.baidu.searchbox.settings.R.string.app_name)).setContentText(notifyInfo).setContentIntent(PendingIntentCompatKt.getImmutablePendingIntentFromBroadcast(this.mAppContext, 0, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
            if (DeviceUtil.OSInfo.hasLollipop()) {
                builder.setSmallIcon(com.baidu.searchbox.notification.res.R.drawable.notification_icon_m);
            } else {
                builder.setSmallIcon(com.baidu.searchbox.notification.res.R.drawable.icon_statusbar);
            }
            ((NotificationManager) this.mAppContext.getSystemService("notification")).notify(com.baidu.searchbox.lightbrowser.base.R.id.silent_upgrade_notification_id, builder.build());
        } else if (z) {
            Log.d(TAG, "NOTIFICATION_NOTIFY_TYPE, server rtn data error, no notifyinfo");
        }
    }

    private void showSilentDialog(Uri uri) {
        if (DEBUG) {
            Log.d(TAG, "showSilentDialog");
        }
        String notifyInfo = this.mUpdateInfo.getNotifyInfo();
        Intent launchIntent = new Intent(this.mAppContext, UpdatePackageReadyActivity.class);
        launchIntent.putExtra("path", uri.toString());
        launchIntent.putExtra(UpdatePackageReadyActivity.EXTRA_CONTENT, notifyInfo);
        launchIntent.putExtra(UpdatePackageReadyActivity.EXTRA_SILENT_INSTALL, true);
        launchIntent.setFlags(268435456);
        this.mAppContext.startActivity(launchIntent);
    }

    private void installSilentApk(Uri uri) {
        if (!BdBoxActivityManager.isForeground()) {
            backgroundInstallUri = null;
            UpdateUBCStatistic.doInstallStatistic("silent");
            SilenceUtil.doInstallPacakge(this.mAppContext, uri, UpdateUtils.INSTALLER_PACKAGE_NAME);
            return;
        }
        backgroundInstallUri = uri;
    }

    public static void installSilentApkBackgroundIfNeed(Context context) {
        if (!BdBoxActivityManager.isForeground() && backgroundInstallUri != null) {
            Uri uri = backgroundInstallUri;
            backgroundInstallUri = null;
            UpdateUBCStatistic.doInstallStatistic("silent");
            SilenceUtil.doInstallPacakge(context, uri, UpdateUtils.INSTALLER_PACKAGE_NAME);
        }
    }

    public static void cancelSilentApkBackgroundInstall() {
        if (DEBUG) {
            Log.d(TAG, "cancel silent apk background install");
        }
        backgroundInstallUri = null;
    }

    /* access modifiers changed from: private */
    public boolean isCurNetMatchDownloadCond(String downloadCondition) {
        if (TextUtils.isEmpty(downloadCondition)) {
            return true;
        }
        for (String s : downloadCondition.toLowerCase(Locale.getDefault()).split(",")) {
            if (TextUtils.equals(s, "all")) {
                return true;
            }
            String netType = new ConnectManager(this.mAppContext).getNetType();
            if (netType != null && netType.toLowerCase(Locale.getDefault()).contains(s)) {
                return true;
            }
        }
        return false;
    }

    class SilentDownloadListener implements DownloadListener {
        SilentDownloadListener() {
        }

        public void onChanged(DownloadBean pdb) {
            int dataColumnIndex;
            DownloadState state = pdb.getDownloadState();
            if (state == DownloadState.DOWNLOADED) {
                if (SilentUpgrade.DEBUG) {
                    Log.d(SilentUpgrade.TAG, "downloadSilentApk, complete.");
                }
                MigrateStatisticUtils.invoke(MigrateStatisticConstants.UB_UPDATE_DOWNLOAD_COMPLETE_TYPE, MigrateStatisticUtils.build(""));
                UpdateUBCStatistic.doDownloadedStatistic("silent");
                Cursor cursor = null;
                Uri fileUri = null;
                try {
                    cursor = SilentUpgrade.this.mAppContext.getContentResolver().query(pdb.getUri(), new String[]{"_id", "_data"}, (String) null, (String[]) null, (String) null);
                    if (cursor != null && cursor.moveToFirst() && (dataColumnIndex = cursor.getColumnIndex("_data")) >= 0) {
                        fileUri = Uri.parse(cursor.getString(dataColumnIndex));
                    }
                } catch (SQLiteFullException e2) {
                    if (SilentUpgrade.DEBUG) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Closeables.closeSafely((Cursor) null);
                    throw th2;
                }
                Closeables.closeSafely(cursor);
                SilentUpgrade.this.handleNotifyType(fileUri);
            }
            if ((state == DownloadState.DOWNLOADED || state == DownloadState.DOWNLOAD_FAILED) && Looper.myLooper() != Looper.getMainLooper()) {
                Looper.myLooper().quit();
            }
        }
    }
}
