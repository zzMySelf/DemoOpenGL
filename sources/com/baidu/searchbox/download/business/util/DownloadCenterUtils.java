package com.baidu.searchbox.download.business.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.CancellationSignal;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.android.support.appcompat.storage.RequestCallback;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.media.ImageScanner;
import com.baidu.download.DownloadPermissionHelper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.boxdownload.IBoxDownloadDbOperator;
import com.baidu.searchbox.boxdownload.ICyberInvoker;
import com.baidu.searchbox.boxdownload.INetDiskP2pInvoker;
import com.baidu.searchbox.boxdownload.model.DownloadDbItem;
import com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo;
import com.baidu.searchbox.boxdownload.model.VideoDownloadInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.callback.AppDownloadListener;
import com.baidu.searchbox.download.callback.DownloadListener;
import com.baidu.searchbox.download.callback.IAppDownloadListener;
import com.baidu.searchbox.download.component.DownloadProvider;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DocClassifyHelper;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.download.util.LocalDataScanHelper;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadCenterUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int DEFAULT_DELETE_COUNT = 20;
    public static final int DEFAULT_DELETE_DURATION = 150;
    public static final int DEFAULT_DELETE_TOAST_DURATION = 2;
    public static final String DOWNLOAD_COLD_OP_1 = "download_cold_1";
    public static final String DOWNLOAD_COLD_OP_2 = "download_cold_2";
    public static final String DOWNLOAD_COLD_OP_3 = "download_cold_3";
    public static final String DOWNLOAD_CUSTOM_UA = "download_custom_ua";
    public static final String HAS_PATCH_ALL_LOCAL_VIDEO_DURATION = "has_patch_all_local_video_duration";
    public static final String INSTALL_APP_ICON = "install_app_icon";
    public static final String INSTALL_APP_NAME = "install_app_name";
    public static final String INSTALL_APP_PATH = "install_app_path";
    public static final String[] PROJECTIONS_FILTER_BY_TYPE = {"_id", "title", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "_data", "extra_info", "uri", "deleted", "business_type", "business_id", Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, "source", Downloads.Impl.COLUMN_OPEN_TIME, Downloads.Impl.COLUMN_OPEN_READ, "progress"};
    public static final String SHOW_APK_CHECK_REQUEST_INTERVAL = "show_app_check_request_interval";
    public static final String SHOW_APK_INSTALL_GUIDE = "show_app_install_guide";
    public static final String SHOW_APK_INSTALL_GUIDE_INTERVAL = "show_app_install_guide_interval";
    public static final String SHOW_APK_INSTALL_GUIDE_MAX_NUM = "show_app_install_guide_max_num";
    public static final String SHOW_APK_INSTALL_GUIDE_NUM = "show_app_install_guide_num";
    public static final String SHOW_APK_INSTALL_GUIDE_TIME = "show_app_install_guide_time";
    private static final String[] SMART_MENU_COLUMNS = {"_id", "title", "mimetype", "total_bytes", "extra_info", "_data", "lastmod", "uri", "progress", Downloads.Impl.COLUMN_OPEN_TIME};
    private static int mOtherDataCount;

    public static int queryDownloadingDataCount(boolean hasPermission) {
        Cursor cursor = null;
        try {
            DownloadManager.Query baseQuery = new DownloadManager.Query();
            DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
            baseQuery.setOnlyDownloading(true).orderBy(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP, 2).setOnlyIncludeVisibleInDownloadsUi(true);
            if (!hasPermission) {
                baseQuery.setFilterBySelection(getFilterPrivateFileSql());
            }
            cursor = downloadManager.query(baseQuery);
            if (cursor != null) {
                int count = cursor.getCount();
                Closeables.closeSafely(cursor);
                return count;
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                throw new DebugException("DownloadCenterUtils.queryDownloading()", e2);
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f8 A[Catch:{ Exception -> 0x0180, Exception -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x022b A[LOOP:0: B:16:0x00d0->B:69:0x022b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0264 A[SYNTHETIC, Splitter:B:81:0x0264] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x025f A[EDGE_INSN: B:88:0x025f->B:79:0x025f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.baidu.searchbox.download.model.CategoryInfoData> queryDownloading(android.content.Context r29, boolean r30, int r31, int r32) {
        /*
            java.lang.String r1 = "DownloadCenterUtils.queryDownloading()"
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = r0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query
            r0.<init>()
            r3 = r0
            r4 = 0
            com.baidu.searchbox.download.manager.DownloadManager r0 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            android.content.ContentResolver r5 = r29.getContentResolver()     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            java.lang.String r6 = r29.getPackageName()     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r0.<init>(r5, r6)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r5 = r0
            r6 = 1
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r3.setOnlyDownloading(r6)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setOnlyIncludeVisibleInDownloadsUi(r6)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r7 = r31
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setOffset(r7)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r8 = r32
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setLimit(r8)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            java.lang.String r9 = "last_modified_timestamp"
            r10 = 2
            r0.orderBy(r9, r10)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            if (r30 != 0) goto L_0x004d
            java.lang.String r0 = getFilterPrivateFileSql()     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            r3.setFilterBySelection(r0)     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            goto L_0x004d
        L_0x0043:
            r0 = move-exception
            r27 = r3
            goto L_0x026b
        L_0x0048:
            r0 = move-exception
            r27 = r3
            goto L_0x0259
        L_0x004d:
            android.database.Cursor r0 = r5.query(r3)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r4 = r0
            if (r4 == 0) goto L_0x024d
            int r0 = r4.getCount()     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            if (r0 <= 0) goto L_0x024d
            java.lang.String r0 = "_id"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r9 = r0
            java.lang.String r0 = "title"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r11 = r0
            java.lang.String r0 = "status"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r12 = r0
            java.lang.String r0 = "bytes_so_far"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r13 = r0
            java.lang.String r0 = "total_bytes"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r14 = r0
            java.lang.String r0 = "media_type"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r15 = r0
            java.lang.String r0 = "reason"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r16 = r0
            java.lang.String r0 = "uri"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r17 = r0
            java.lang.String r0 = "lastmod"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r18 = r0
            java.lang.String r0 = "_data"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r19 = r0
            java.lang.String r0 = "business_type"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r20 = r0
            java.lang.String r0 = "progress"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r21 = r0
            java.lang.String r0 = "extra_info"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r22 = r0
            java.lang.String r0 = "source"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r23 = r0
            r4.moveToFirst()     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
        L_0x00d0:
            java.lang.String r0 = r4.getString(r15)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r24 = r0
            java.lang.String r0 = r4.getString(r11)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r25 = r0
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r25)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r10 = r24
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r10)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r24 = r0
            com.baidu.searchbox.download.model.CategoryInfoData r0 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r0.<init>()     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r26 = r0
            long r6 = r4.getLong(r9)     // Catch:{ Exception -> 0x0256, all -> 0x0252 }
            r27 = r3
            r3 = r26
            r3.mId = r6     // Catch:{ Exception -> 0x024b }
            r3.mMimeType = r10     // Catch:{ Exception -> 0x024b }
            r6 = r24
            long r7 = (long) r6     // Catch:{ Exception -> 0x024b }
            r3.mType = r7     // Catch:{ Exception -> 0x024b }
            r7 = r21
            int r0 = r4.getInt(r7)     // Catch:{ Exception -> 0x024b }
            r3.progress = r0     // Catch:{ Exception -> 0x024b }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch:{ Exception -> 0x024b }
            r0.<init>()     // Catch:{ Exception -> 0x024b }
            r3.mDownloadingInfo = r0     // Catch:{ Exception -> 0x024b }
            r8 = r19
            java.lang.String r0 = r4.getString(r8)     // Catch:{ Exception -> 0x024b }
            r3.mDownloadPath = r0     // Catch:{ Exception -> 0x024b }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r3.mDownloadingInfo     // Catch:{ Exception -> 0x024b }
            r19 = r7
            r21 = r8
            long r7 = r4.getLong(r13)     // Catch:{ Exception -> 0x024b }
            r0.mCurrentSize = r7     // Catch:{ Exception -> 0x024b }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r3.mDownloadingInfo     // Catch:{ Exception -> 0x024b }
            int r7 = r4.getInt(r12)     // Catch:{ Exception -> 0x024b }
            r0.mStatus = r7     // Catch:{ Exception -> 0x024b }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r3.mDownloadingInfo     // Catch:{ Exception -> 0x024b }
            r7 = r16
            int r8 = r4.getInt(r7)     // Catch:{ Exception -> 0x024b }
            r0.mReason = r8     // Catch:{ Exception -> 0x024b }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r3.mDownloadingInfo     // Catch:{ Exception -> 0x024b }
            r16 = r5
            r8 = r17
            java.lang.String r5 = r4.getString(r8)     // Catch:{ Exception -> 0x024b }
            r0.mUrl = r5     // Catch:{ Exception -> 0x024b }
            r5 = r20
            int r0 = r4.getInt(r5)     // Catch:{ Exception -> 0x024b }
            r3.mBusinessType = r0     // Catch:{ Exception -> 0x024b }
            r17 = r5
            r5 = r22
            java.lang.String r0 = r4.getString(r5)     // Catch:{ Exception -> 0x024b }
            r3.mExtraInfo = r0     // Catch:{ Exception -> 0x024b }
            r0 = 3
            r20 = r7
            java.lang.String r7 = ""
            if (r0 != r6) goto L_0x0190
            r24 = r8
            r22 = r9
            long r8 = r3.mId     // Catch:{ Exception -> 0x024b }
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x024b }
            r8 = r29
            java.lang.String r0 = com.baidu.searchbox.download.FileDownloader.queryExtraInfoByDownloadID(r8, r0)     // Catch:{ Exception -> 0x024b }
            r9 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x024b }
            if (r0 != 0) goto L_0x018e
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0180 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0180 }
            java.lang.String r8 = "icon"
            java.lang.String r7 = r0.optString(r8, r7)     // Catch:{ Exception -> 0x0180 }
            r3.mAppIcon = r7     // Catch:{ Exception -> 0x0180 }
            goto L_0x0185
        L_0x0180:
            r0 = move-exception
            boolean r7 = DEBUG     // Catch:{ Exception -> 0x024b }
            if (r7 != 0) goto L_0x0188
        L_0x0185:
            r3.mExtraInfo = r9     // Catch:{ Exception -> 0x024b }
            goto L_0x018e
        L_0x0188:
            com.baidu.searchbox.developer.DebugException r7 = new com.baidu.searchbox.developer.DebugException     // Catch:{ Exception -> 0x024b }
            r7.<init>(r1, r0)     // Catch:{ Exception -> 0x024b }
            throw r7     // Catch:{ Exception -> 0x024b }
        L_0x018e:
            r7 = 2
            goto L_0x01f4
        L_0x0190:
            r24 = r8
            r22 = r9
            java.lang.String r0 = "m3u8"
            java.lang.String r8 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r25)     // Catch:{ Exception -> 0x024b }
            boolean r0 = r0.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x024b }
            if (r0 == 0) goto L_0x01e1
            r8 = 1
            r3.mIsM3U8 = r8     // Catch:{ Exception -> 0x024b }
            java.lang.String r0 = r4.getString(r5)     // Catch:{ Exception -> 0x024b }
            r9 = r0
            r3.mExtraInfo = r9     // Catch:{ Exception -> 0x024b }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x024b }
            if (r0 != 0) goto L_0x01dd
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x01cf }
            r0.<init>(r9)     // Catch:{ Exception -> 0x01cf }
            java.lang.String r8 = "poster"
            java.lang.String r7 = r0.optString(r8, r7)     // Catch:{ Exception -> 0x01cf }
            r3.mPoster = r7     // Catch:{ Exception -> 0x01cf }
            java.lang.String r7 = "play_progress"
            r26 = r9
            r8 = 0
            double r7 = r0.optDouble(r7, r8)     // Catch:{ Exception -> 0x01cd }
            r3.mPlayProgress = r7     // Catch:{ Exception -> 0x01cd }
            goto L_0x01df
        L_0x01cd:
            r0 = move-exception
            goto L_0x01d2
        L_0x01cf:
            r0 = move-exception
            r26 = r9
        L_0x01d2:
            boolean r7 = DEBUG     // Catch:{ Exception -> 0x024b }
            if (r7 != 0) goto L_0x01d7
            goto L_0x01df
        L_0x01d7:
            com.baidu.searchbox.developer.DebugException r7 = new com.baidu.searchbox.developer.DebugException     // Catch:{ Exception -> 0x024b }
            r7.<init>(r1, r0)     // Catch:{ Exception -> 0x024b }
            throw r7     // Catch:{ Exception -> 0x024b }
        L_0x01dd:
            r26 = r9
        L_0x01df:
            r7 = 2
            goto L_0x01f4
        L_0x01e1:
            if (r6 == 0) goto L_0x01e7
            r7 = 2
            if (r7 != r6) goto L_0x01f4
            goto L_0x01e8
        L_0x01e7:
            r7 = 2
        L_0x01e8:
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r3.mDownloadingInfo     // Catch:{ Exception -> 0x024b }
            int r0 = r0.mStatus     // Catch:{ Exception -> 0x024b }
            r8 = 8
            if (r0 != r8) goto L_0x01f4
            java.lang.String r0 = r3.mDownloadPath     // Catch:{ Exception -> 0x024b }
            r3.mAppIcon = r0     // Catch:{ Exception -> 0x024b }
        L_0x01f4:
            int r0 = r3.mBusinessType     // Catch:{ Exception -> 0x024b }
            if (r0 == 0) goto L_0x0204
            java.lang.String r0 = "business_id"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x024b }
            java.lang.String r8 = r4.getString(r0)     // Catch:{ Exception -> 0x024b }
            r3.businessId = r8     // Catch:{ Exception -> 0x024b }
        L_0x0204:
            long r8 = r4.getLong(r14)     // Catch:{ Exception -> 0x024b }
            r3.mSize = r8     // Catch:{ Exception -> 0x024b }
            r8 = r25
            r3.mFileName = r8     // Catch:{ Exception -> 0x024b }
            r9 = r18
            r18 = r8
            long r7 = r4.getLong(r9)     // Catch:{ Exception -> 0x024b }
            r3.mCompletionTime = r7     // Catch:{ Exception -> 0x024b }
            r7 = r23
            java.lang.String r0 = r4.getString(r7)     // Catch:{ Exception -> 0x024b }
            r3.mSource = r0     // Catch:{ Exception -> 0x024b }
            r2.add(r3)     // Catch:{ Exception -> 0x024b }
            boolean r0 = r4.moveToNext()     // Catch:{ Exception -> 0x024b }
            if (r0 != 0) goto L_0x022b
            goto L_0x025f
        L_0x022b:
            r8 = r32
            r23 = r7
            r18 = r9
            r9 = r22
            r3 = r27
            r6 = 1
            r10 = 2
            r7 = r31
            r22 = r5
            r5 = r16
            r16 = r20
            r20 = r17
            r17 = r24
            r28 = r21
            r21 = r19
            r19 = r28
            goto L_0x00d0
        L_0x024b:
            r0 = move-exception
            goto L_0x0259
        L_0x024d:
            r27 = r3
            r16 = r5
            goto L_0x025f
        L_0x0252:
            r0 = move-exception
            r27 = r3
            goto L_0x026b
        L_0x0256:
            r0 = move-exception
            r27 = r3
        L_0x0259:
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x026a }
            if (r3 != 0) goto L_0x0264
        L_0x025f:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r4)
            return r2
        L_0x0264:
            com.baidu.searchbox.developer.DebugException r3 = new com.baidu.searchbox.developer.DebugException     // Catch:{ all -> 0x026a }
            r3.<init>(r1, r0)     // Catch:{ all -> 0x026a }
            throw r3     // Catch:{ all -> 0x026a }
        L_0x026a:
            r0 = move-exception
        L_0x026b:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloading(android.content.Context, boolean, int, int):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c4 A[SYNTHETIC, Splitter:B:41:0x00c4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] queryDownloadInfoByDownloadID(android.content.Context r18, java.lang.String r19) {
        /*
            java.lang.String r0 = "business_type"
            java.lang.String r1 = "title"
            java.lang.String r2 = "DownloadCenterUtils.queryDownloadInfoByDownloadID()"
            java.lang.String r3 = "mimetype"
            java.lang.String r4 = "extra_info"
            java.lang.String r11 = "_id= ?"
            r12 = 1
            java.lang.String[] r9 = new java.lang.String[r12]
            r13 = 0
            r9[r13] = r19
            r14 = 0
            r15 = 3
            java.lang.String[] r10 = new java.lang.String[r15]
            android.content.ContentResolver r5 = r18.getContentResolver()     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            android.net.Uri r6 = com.baidu.searchbox.download.model.Downloads.Impl.CONTENT_URI     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.String[] r7 = new java.lang.String[]{r3, r1, r0, r4}     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            r16 = 0
            r8 = r11
            r17 = r10
            r10 = r16
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00b2 }
            r14 = r5
            if (r14 == 0) goto L_0x00bf
            boolean r5 = r14.moveToFirst()     // Catch:{ Exception -> 0x00b2 }
            if (r5 == 0) goto L_0x00bf
            int r3 = r14.getColumnIndex(r3)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r3 = r14.getString(r3)     // Catch:{ Exception -> 0x00b2 }
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00b2 }
            int r0 = r14.getColumnIndex(r0)     // Catch:{ Exception -> 0x00b2 }
            int r0 = r14.getInt(r0)     // Catch:{ Exception -> 0x00b2 }
            r5 = r0
            r17[r13] = r3     // Catch:{ Exception -> 0x00b2 }
            r17[r12] = r1     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r1)     // Catch:{ Exception -> 0x00b2 }
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r3)     // Catch:{ Exception -> 0x00b2 }
            r6 = r0
            r0 = 2
            if (r6 != r15) goto L_0x0084
            int r4 = r14.getColumnIndex(r4)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r4 = r14.getString(r4)     // Catch:{ Exception -> 0x00b2 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0078 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r8 = "icon"
            java.lang.String r10 = ""
            java.lang.String r8 = r7.optString(r8, r10)     // Catch:{ Exception -> 0x0078 }
            r17[r0] = r8     // Catch:{ Exception -> 0x0078 }
            goto L_0x00b1
        L_0x0078:
            r0 = move-exception
            boolean r7 = DEBUG     // Catch:{ Exception -> 0x00b2 }
            if (r7 != 0) goto L_0x007e
            goto L_0x00b1
        L_0x007e:
            com.baidu.searchbox.developer.DebugException r7 = new com.baidu.searchbox.developer.DebugException     // Catch:{ Exception -> 0x00b2 }
            r7.<init>(r2, r0)     // Catch:{ Exception -> 0x00b2 }
            throw r7     // Catch:{ Exception -> 0x00b2 }
        L_0x0084:
            if (r5 != r12) goto L_0x00b1
            int r4 = r14.getColumnIndex(r4)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r4 = r14.getString(r4)     // Catch:{ Exception -> 0x00b2 }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00b2 }
            if (r7 != 0) goto L_0x00bf
            com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x00a8 }
            r7.<init>()     // Catch:{ JsonSyntaxException -> 0x00a8 }
            java.lang.Class<com.baidu.searchbox.boxdownload.model.VideoDownloadInfo> r8 = com.baidu.searchbox.boxdownload.model.VideoDownloadInfo.class
            java.lang.Object r7 = r7.fromJson((java.lang.String) r4, r8)     // Catch:{ JsonSyntaxException -> 0x00a8 }
            com.baidu.searchbox.boxdownload.model.VideoDownloadInfo r7 = (com.baidu.searchbox.boxdownload.model.VideoDownloadInfo) r7     // Catch:{ JsonSyntaxException -> 0x00a8 }
            java.lang.String r8 = r7.getPoster()     // Catch:{ JsonSyntaxException -> 0x00a8 }
            r17[r0] = r8     // Catch:{ JsonSyntaxException -> 0x00a8 }
            goto L_0x00bf
        L_0x00a8:
            r0 = move-exception
            boolean r7 = DEBUG     // Catch:{ Exception -> 0x00b2 }
            if (r7 == 0) goto L_0x00bf
            r0.printStackTrace()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00bf
        L_0x00b1:
            goto L_0x00bf
        L_0x00b2:
            r0 = move-exception
            goto L_0x00bb
        L_0x00b4:
            r0 = move-exception
            r17 = r10
            goto L_0x00cb
        L_0x00b8:
            r0 = move-exception
            r17 = r10
        L_0x00bb:
            boolean r1 = DEBUG     // Catch:{ all -> 0x00ca }
            if (r1 != 0) goto L_0x00c4
        L_0x00bf:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r14)
            return r17
        L_0x00c4:
            com.baidu.searchbox.developer.DebugException r1 = new com.baidu.searchbox.developer.DebugException     // Catch:{ all -> 0x00ca }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x00ca }
            throw r1     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r0 = move-exception
        L_0x00cb:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloadInfoByDownloadID(android.content.Context, java.lang.String):java.lang.String[]");
    }

    public static int getErrorMessage(long downloadId) {
        Cursor cur = null;
        int result = 0;
        try {
            cur = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName()).query(new DownloadManager.Query().setFilterById(downloadId));
            if (cur != null && cur.moveToFirst()) {
                result = cur.getInt(cur.getColumnIndex("reason"));
            }
        } catch (Exception e2) {
            if (DEBUG) {
                throw new DebugException("DownloadCenterUtils.getErrorMessage()", e2);
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
        return result;
    }

    public static String getFilterPrivateFileSql() {
        return " AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR " + "_data" + " like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR " + "_data" + " IS NULL)";
    }

    public static int queryAllDownloadedCount(boolean hasStoragePermission) {
        String selection = " AND uri not like '%content://%'";
        if (!hasStoragePermission) {
            selection = selection + getFilterPrivateFileSql();
        }
        Cursor cur = null;
        try {
            DownloadManager.Query baseQuery = new DownloadManager.Query();
            DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
            baseQuery.setOnlyIncludeVisibleInDownloadsUi(true).setOnlyDownloading(false).setFilterByStatus(8).setFilterBySelection(selection);
            cur = downloadManager.query(baseQuery, new String[]{"_id"});
            if (cur != null && cur.getCount() > 0) {
                int count = cur.getCount();
                Closeables.closeSafely(cur);
                return count;
            }
        } catch (Exception e2) {
            if (DEBUG) {
                throw new DebugException("queryAllCategory", e2);
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
        return 0;
    }

    public static ArrayList<CategoryInfoData> queryDownloaded(boolean hasStoragePermission, long id, long time, int limit) {
        return queryDownloaded(hasStoragePermission, id, time, limit, false, false);
    }

    public static ArrayList<CategoryInfoData> queryDownloaded(boolean hasStoragePermission, long id, long time, int limit, boolean down, boolean showDeleted, boolean showLocal) {
        return queryDownloaded(hasStoragePermission, id, time, limit, down, showDeleted, showLocal, (List<String>) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0309, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0398 A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03c8 A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03ca A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03db A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03dd A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0420 A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0435 A[LOOP:0: B:36:0x01cb->B:131:0x0435, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0481 A[Catch:{ all -> 0x0489 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0484 A[EDGE_INSN: B:151:0x0484->B:146:0x0484 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00de A[Catch:{ Exception -> 0x0478, all -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f5 A[Catch:{ Exception -> 0x0478, all -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0137 A[SYNTHETIC, Splitter:B:28:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x013b A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x014d A[Catch:{ Exception -> 0x0468 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02f9 A[Catch:{ all -> 0x0309 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.baidu.searchbox.download.model.CategoryInfoData> queryDownloaded(boolean r33, long r34, long r36, int r38, boolean r39, boolean r40, boolean r41, java.util.List<java.lang.String> r42) {
        /*
            r1 = r36
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3 = r0
            r4 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r5 = " AND _id != "
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r5 = r34
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r7 = "lastmod"
            java.lang.String r8 = ")"
            if (r39 == 0) goto L_0x0056
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r9.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r10 = " AND (lastmod < "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r10 = " OR "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r7)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r10 = " = "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r8 = r9.append(r8)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0 = r8
            goto L_0x0072
        L_0x0056:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r9.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r10 = " AND (lastmod > "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r8 = r9.append(r8)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0 = r8
        L_0x0072:
            if (r41 != 0) goto L_0x0088
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r8.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r9 = " AND uri not like '%content://%' AND uri not like '%copy://%'"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0 = r8
        L_0x0088:
            if (r42 == 0) goto L_0x00c8
            boolean r8 = r42.isEmpty()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            if (r8 == 0) goto L_0x0091
            goto L_0x00c8
        L_0x0091:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r8.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r9 = " AND (is_visible_in_downloads_ui != '0'"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0 = r8
            java.lang.String r8 = joinString(r42)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r9.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r10 = " OR source IN ("
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r9 = r9.append(r8)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r10 = "))"
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0 = r9
            goto L_0x00dc
        L_0x00c8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r8.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r9 = " AND is_visible_in_downloads_ui != '0'"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0 = r8
        L_0x00dc:
            if (r33 != 0) goto L_0x00f5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r8.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r9 = getFilterPrivateFileSql()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0 = r8
            goto L_0x00f6
        L_0x00f5:
            r8 = r0
        L_0x00f6:
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0.<init>()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r9 = r0
            com.baidu.searchbox.download.manager.DownloadManager r0 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            android.content.Context r10 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            android.content.Context r11 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r0.<init>(r10, r11)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r10 = r0
            r11 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r9.setOnlyIncludeVisibleInDownloadsUi(r11)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setOnlyDownloading(r11)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r12 = 8
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setFilterByStatus(r12)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setFilterBySelection(r8)     // Catch:{ Exception -> 0x0478, all -> 0x0472 }
            r13 = r40
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.showDeleted(r13)     // Catch:{ Exception -> 0x046e, all -> 0x046a }
            r14 = r38
            r0.setLimit(r14)     // Catch:{ Exception -> 0x0468 }
            r15 = 2
            java.lang.String r0 = "last_modified_timestamp"
            r11 = 1
            if (r39 == 0) goto L_0x013b
            r9.orderBy(r0, r15)     // Catch:{ Exception -> 0x0468 }
            goto L_0x013e
        L_0x013b:
            r9.orderBy(r0, r11)     // Catch:{ Exception -> 0x0468 }
        L_0x013e:
            java.lang.String[] r0 = PROJECTIONS_FILTER_BY_TYPE     // Catch:{ Exception -> 0x0468 }
            android.database.Cursor r0 = r10.query(r9, r0)     // Catch:{ Exception -> 0x0468 }
            r4 = r0
            if (r4 == 0) goto L_0x0461
            int r0 = r4.getCount()     // Catch:{ Exception -> 0x0468 }
            if (r0 <= 0) goto L_0x0461
            java.lang.String r0 = "_id"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0468 }
            r16 = r0
            java.lang.String r0 = "status"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            r17 = r0
            java.lang.String r0 = "mimetype"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0468 }
            r18 = r0
            java.lang.String r0 = "total_bytes"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0468 }
            r19 = r0
            java.lang.String r0 = "bytes_so_far"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            r20 = r0
            java.lang.String r0 = "_data"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0468 }
            r21 = r0
            java.lang.String r0 = "title"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0468 }
            r22 = r0
            int r0 = r4.getColumnIndex(r7)     // Catch:{ Exception -> 0x0468 }
            r7 = r0
            java.lang.String r0 = "extra_info"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0468 }
            r23 = r0
            java.lang.String r0 = "uri"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            r24 = r0
            java.lang.String r0 = "deleted"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            r25 = r0
            java.lang.String r0 = "business_type"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            r26 = r0
            java.lang.String r0 = "netdisk_upload_info"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            r27 = r0
            java.lang.String r0 = "source"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            r28 = r0
            r4.moveToFirst()     // Catch:{ Exception -> 0x0468 }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0468 }
            r0.<init>()     // Catch:{ Exception -> 0x0468 }
            r29 = r0
        L_0x01cb:
            r12 = r18
            java.lang.String r0 = r4.getString(r12)     // Catch:{ Exception -> 0x0468 }
            r18 = r0
            r15 = r22
            java.lang.String r0 = r4.getString(r15)     // Catch:{ Exception -> 0x0468 }
            r22 = r0
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r22)     // Catch:{ Exception -> 0x0468 }
            r11 = r18
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r11)     // Catch:{ Exception -> 0x0468 }
            r18 = r0
            com.baidu.searchbox.download.model.CategoryInfoData r0 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch:{ Exception -> 0x0468 }
            r0.<init>()     // Catch:{ Exception -> 0x0468 }
            r30 = r0
            r1 = r16
            long r5 = r4.getLong(r1)     // Catch:{ Exception -> 0x0468 }
            r2 = r30
            r2.mId = r5     // Catch:{ Exception -> 0x0468 }
            r2.mMimeType = r11     // Catch:{ Exception -> 0x0468 }
            r6 = r1
            r5 = r18
            long r0 = (long) r5     // Catch:{ Exception -> 0x0468 }
            r2.mType = r0     // Catch:{ Exception -> 0x0468 }
            r1 = r26
            int r0 = r4.getInt(r1)     // Catch:{ Exception -> 0x0468 }
            r2.mBusinessType = r0     // Catch:{ Exception -> 0x0468 }
            r16 = r1
            r1 = r21
            java.lang.String r0 = r4.getString(r1)     // Catch:{ Exception -> 0x0468 }
            r2.mDownloadPath = r0     // Catch:{ Exception -> 0x0468 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch:{ Exception -> 0x0468 }
            r0.<init>()     // Catch:{ Exception -> 0x0468 }
            r2.mDownloadingInfo = r0     // Catch:{ Exception -> 0x0468 }
            r18 = r1
            r1 = r24
            java.lang.String r0 = r4.getString(r1)     // Catch:{ Exception -> 0x0468 }
            r21 = r0
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch:{ Exception -> 0x0468 }
            r24 = r1
            r1 = r21
            r0.mUrl = r1     // Catch:{ Exception -> 0x0468 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch:{ Exception -> 0x0468 }
            r21 = r1
            r26 = r9
            r1 = r20
            r20 = r8
            long r8 = r4.getLong(r1)     // Catch:{ Exception -> 0x0468 }
            r0.mCurrentSize = r8     // Catch:{ Exception -> 0x0468 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch:{ Exception -> 0x0468 }
            r8 = r17
            int r9 = r4.getInt(r8)     // Catch:{ Exception -> 0x0468 }
            r0.mStatus = r9     // Catch:{ Exception -> 0x0468 }
            r0 = 6
            java.lang.String r9 = ""
            if (r0 != r5) goto L_0x030f
            r17 = 0
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x02ef, all -> 0x02e8 }
            r30 = r10
            r31 = r11
            long r10 = r2.mId     // Catch:{ Exception -> 0x02e5, all -> 0x02e2 }
            android.database.Cursor r0 = r0.getSearchboxDownloadCursor(r10)     // Catch:{ Exception -> 0x02e5, all -> 0x02e2 }
            r10 = r0
            if (r10 == 0) goto L_0x02cf
            boolean r0 = r10.moveToFirst()     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            if (r0 == 0) goto L_0x02cf
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewprogress     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            float r0 = r10.getFloat(r0)     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            r2.mStoryViewProgress = r0     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewposition     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            r2.mStoryPosition = r0     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.gid     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x02ca, all -> 0x02c5 }
            r11 = r1
            long r0 = r10.getLong(r0)     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            r2.mGid = r0     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booksrc     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            r2.mBookDirectoryUrl = r0     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booktype     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            int r0 = r10.getInt(r0)     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            r2.mBookType = r0     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.bookfree     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            r2.mFree = r0     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            goto L_0x02d6
        L_0x02c5:
            r0 = move-exception
            r11 = r1
            r17 = r10
            goto L_0x030a
        L_0x02ca:
            r0 = move-exception
            r11 = r1
            r17 = r10
            goto L_0x02f5
        L_0x02cf:
            r11 = r1
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2.mStoryViewProgress = r0     // Catch:{ Exception -> 0x02de, all -> 0x02da }
            r2.mStoryPosition = r9     // Catch:{ Exception -> 0x02de, all -> 0x02da }
        L_0x02d6:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r10)     // Catch:{ Exception -> 0x0468 }
            goto L_0x0300
        L_0x02da:
            r0 = move-exception
            r17 = r10
            goto L_0x030a
        L_0x02de:
            r0 = move-exception
            r17 = r10
            goto L_0x02f5
        L_0x02e2:
            r0 = move-exception
            r11 = r1
            goto L_0x030a
        L_0x02e5:
            r0 = move-exception
            r11 = r1
            goto L_0x02f5
        L_0x02e8:
            r0 = move-exception
            r30 = r10
            r31 = r11
            r11 = r1
            goto L_0x030a
        L_0x02ef:
            r0 = move-exception
            r30 = r10
            r31 = r11
            r11 = r1
        L_0x02f5:
            boolean r1 = DEBUG     // Catch:{ all -> 0x0309 }
            if (r1 == 0) goto L_0x02fc
            r0.printStackTrace()     // Catch:{ all -> 0x0309 }
        L_0x02fc:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r17)     // Catch:{ Exception -> 0x0468 }
        L_0x0300:
            r1 = r23
            r9 = 8
            r23 = r8
            r8 = 2
            goto L_0x0394
        L_0x0309:
            r0 = move-exception
        L_0x030a:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r17)     // Catch:{ Exception -> 0x0468 }
            throw r0     // Catch:{ Exception -> 0x0468 }
        L_0x030f:
            r30 = r10
            r31 = r11
            r11 = r1
            r0 = 3
            if (r5 != r0) goto L_0x033c
            r1 = r23
            java.lang.String r0 = r4.getString(r1)     // Catch:{ Exception -> 0x0468 }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0468 }
            if (r10 != 0) goto L_0x0334
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0468 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x0468 }
            r17 = r0
            java.lang.String r0 = "icon"
            java.lang.String r0 = r10.optString(r0, r9)     // Catch:{ Exception -> 0x0468 }
            r2.mAppIcon = r0     // Catch:{ Exception -> 0x0468 }
            goto L_0x0336
        L_0x0334:
            r17 = r0
        L_0x0336:
            r23 = r8
            r8 = 2
            r9 = 8
            goto L_0x0394
        L_0x033c:
            r1 = r23
            java.lang.String r0 = "m3u8"
            java.lang.String r10 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r22)     // Catch:{ Exception -> 0x0468 }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0468 }
            if (r0 == 0) goto L_0x037c
            r10 = 1
            r2.mIsM3U8 = r10     // Catch:{ Exception -> 0x0468 }
            java.lang.String r0 = r4.getString(r1)     // Catch:{ Exception -> 0x0468 }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0468 }
            if (r10 != 0) goto L_0x0376
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0468 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x0468 }
            r17 = r0
            java.lang.String r0 = "poster"
            java.lang.String r0 = r10.optString(r0, r9)     // Catch:{ Exception -> 0x0468 }
            r2.mPoster = r0     // Catch:{ Exception -> 0x0468 }
            java.lang.String r0 = "play_progress"
            r23 = r8
            r8 = 0
            double r8 = r10.optDouble(r0, r8)     // Catch:{ Exception -> 0x0468 }
            r2.mPlayProgress = r8     // Catch:{ Exception -> 0x0468 }
            goto L_0x037a
        L_0x0376:
            r17 = r0
            r23 = r8
        L_0x037a:
            r8 = 2
            goto L_0x0384
        L_0x037c:
            r23 = r8
            if (r5 == 0) goto L_0x0387
            r8 = 2
            if (r8 != r5) goto L_0x0384
            goto L_0x0388
        L_0x0384:
            r9 = 8
            goto L_0x0394
        L_0x0387:
            r8 = 2
        L_0x0388:
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch:{ Exception -> 0x0468 }
            int r0 = r0.mStatus     // Catch:{ Exception -> 0x0468 }
            r9 = 8
            if (r0 != r9) goto L_0x0394
            java.lang.String r0 = r2.mDownloadPath     // Catch:{ Exception -> 0x0468 }
            r2.mAppIcon = r0     // Catch:{ Exception -> 0x0468 }
        L_0x0394:
            int r0 = r2.mBusinessType     // Catch:{ Exception -> 0x0468 }
            if (r0 == 0) goto L_0x03a4
            java.lang.String r0 = "business_id"
            int r0 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0468 }
            java.lang.String r10 = r4.getString(r0)     // Catch:{ Exception -> 0x0468 }
            r2.businessId = r10     // Catch:{ Exception -> 0x0468 }
        L_0x03a4:
            r10 = r19
            long r8 = r4.getLong(r10)     // Catch:{ Exception -> 0x0468 }
            r2.mSize = r8     // Catch:{ Exception -> 0x0468 }
            r8 = r22
            r2.mFileName = r8     // Catch:{ Exception -> 0x0468 }
            r9 = r5
            r17 = r6
            long r5 = r4.getLong(r7)     // Catch:{ Exception -> 0x0468 }
            r2.mCompletionTime = r5     // Catch:{ Exception -> 0x0468 }
            java.lang.String r0 = r4.getString(r1)     // Catch:{ Exception -> 0x0468 }
            r2.mExtraInfo = r0     // Catch:{ Exception -> 0x0468 }
            r5 = r25
            int r0 = r4.getInt(r5)     // Catch:{ Exception -> 0x0468 }
            r6 = 1
            if (r0 != r6) goto L_0x03ca
            r0 = r6
            goto L_0x03cb
        L_0x03ca:
            r0 = 0
        L_0x03cb:
            r2.mIsDeleted = r0     // Catch:{ Exception -> 0x0468 }
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x0468 }
            r19 = r7
            long r6 = r2.mId     // Catch:{ Exception -> 0x0468 }
            boolean r0 = r0.isRead(r6)     // Catch:{ Exception -> 0x0468 }
            if (r0 != 0) goto L_0x03dd
            r0 = 1
            goto L_0x03de
        L_0x03dd:
            r0 = 0
        L_0x03de:
            r2.newFlag = r0     // Catch:{ Exception -> 0x0468 }
            r6 = r28
            java.lang.String r0 = r4.getString(r6)     // Catch:{ Exception -> 0x0468 }
            r2.mSource = r0     // Catch:{ Exception -> 0x0468 }
            r7 = r27
            java.lang.String r0 = r4.getString(r7)     // Catch:{ Exception -> 0x0468 }
            r22 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x0468 }
            if (r0 != 0) goto L_0x0420
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r0 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r25 = r1
            r1 = r29
            r32 = r22
            r22 = r5
            r5 = r32
            java.lang.Object r0 = r1.fromJson((java.lang.String) r5, r0)     // Catch:{ JsonSyntaxException -> 0x040b }
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch:{ JsonSyntaxException -> 0x040b }
            r2.mNetdiskUploadInfo = r0     // Catch:{ JsonSyntaxException -> 0x040b }
            goto L_0x042a
        L_0x040b:
            r0 = move-exception
            goto L_0x0418
        L_0x040d:
            r0 = move-exception
            r25 = r1
            r1 = r29
            r32 = r22
            r22 = r5
            r5 = r32
        L_0x0418:
            boolean r27 = DEBUG     // Catch:{ Exception -> 0x0468 }
            if (r27 == 0) goto L_0x042a
            r0.printStackTrace()     // Catch:{ Exception -> 0x0468 }
            goto L_0x042a
        L_0x0420:
            r25 = r1
            r1 = r29
            r32 = r22
            r22 = r5
            r5 = r32
        L_0x042a:
            r3.add(r2)     // Catch:{ Exception -> 0x0468 }
            boolean r0 = r4.moveToNext()     // Catch:{ Exception -> 0x0468 }
            if (r0 != 0) goto L_0x0435
            goto L_0x0484
        L_0x0435:
            r29 = r1
            r28 = r6
            r27 = r7
            r21 = r18
            r7 = r19
            r8 = r20
            r9 = r26
            r5 = r34
            r1 = r36
            r19 = r10
            r20 = r11
            r18 = r12
            r26 = r16
            r16 = r17
            r17 = r23
            r23 = r25
            r10 = r30
            r11 = 1
            r12 = 8
            r25 = r22
            r22 = r15
            r15 = 2
            goto L_0x01cb
        L_0x0461:
            r20 = r8
            r26 = r9
            r30 = r10
            goto L_0x0484
        L_0x0468:
            r0 = move-exception
            goto L_0x047d
        L_0x046a:
            r0 = move-exception
            r14 = r38
            goto L_0x048a
        L_0x046e:
            r0 = move-exception
            r14 = r38
            goto L_0x047d
        L_0x0472:
            r0 = move-exception
            r14 = r38
            r13 = r40
            goto L_0x048a
        L_0x0478:
            r0 = move-exception
            r14 = r38
            r13 = r40
        L_0x047d:
            boolean r1 = DEBUG     // Catch:{ all -> 0x0489 }
            if (r1 == 0) goto L_0x0484
            r0.printStackTrace()     // Catch:{ all -> 0x0489 }
        L_0x0484:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r4)
            return r3
        L_0x0489:
            r0 = move-exception
        L_0x048a:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloaded(boolean, long, long, int, boolean, boolean, boolean, java.util.List):java.util.ArrayList");
    }

    public static ArrayList<CategoryInfoData> queryDownloaded(boolean hasStoragePermission, long id, long time, int limit, boolean showDeleted, boolean showLocal) {
        return queryDownloaded(hasStoragePermission, id, time, limit, true, showDeleted, showLocal);
    }

    public static AppDownloadListener registerAppDownloadListener(Uri uri, IAppDownloadListener downloadListener) {
        AppDownloadListener listener = new AppDownloadListener(AppRuntime.getAppContext(), uri, downloadListener);
        DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), uri, listener);
        return listener;
    }

    public static void unregisterAppDownloadListener(Uri uri, DownloadListener downloadListener) {
        if (downloadListener != null) {
            DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri, downloadListener);
        }
    }

    public static int queryDownloadDocDataCountByCategory(DocClassifyHelper.DocCategroy category) {
        return queryDownloadDocDataCountByCategory(category, (List<String>) null);
    }

    public static int queryDownloadDocDataCountByCategory(DocClassifyHelper.DocCategroy category, List<String> querySources) {
        String selection;
        ArrayList<String> mimeTypes = DocClassifyHelper.getMimeTypesByType(category);
        if (mimeTypes.size() == 0) {
            return 0;
        }
        if (querySources == null || querySources.isEmpty()) {
            selection = "status= ? AND " + "is_visible_in_downloads_ui" + " = ? AND ";
        } else {
            selection = ("status= ? AND " + FileViewerActivity.LEFT_BRACKET + "is_visible_in_downloads_ui" + " = ? OR ") + "source" + " IN (" + joinString(querySources) + ")) AND ";
        }
        String selection2 = (selection + "deleted" + "!= ? AND ") + "mimetype" + " IN (";
        StringBuilder mimeTypesBuilder = new StringBuilder();
        Iterator<String> it = mimeTypes.iterator();
        while (it.hasNext()) {
            mimeTypesBuilder.append("'").append(it.next()).append("',");
        }
        String selection3 = selection2 + mimeTypesBuilder.substring(0, mimeTypesBuilder.length() - 1) + ")";
        if (!DownloadPermissionHelper.hasSelfDownloadedFileReadPermission()) {
            selection3 = selection3 + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR " + "_data" + " like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR " + "_data" + " IS NULL)");
        }
        String[] selectionArgs = {String.valueOf(200), String.valueOf(1), String.valueOf(1)};
        Cursor cur = null;
        int count = 0;
        try {
            if (category == DocClassifyHelper.DocCategroy.RECENT) {
                cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info", "_data"}, selection3, selectionArgs, "");
                if (cur != null && cur.getCount() > 0) {
                    int extraInfoColumnIndex = cur.getColumnIndex("extra_info");
                    int pathColumnIndex = cur.getColumnIndex("_data");
                    cur.moveToFirst();
                    do {
                        if (checkFileAvailable(cur.getString(pathColumnIndex))) {
                            String extraInfo = cur.getString(extraInfoColumnIndex);
                            if (!TextUtils.isEmpty(extraInfo) && new JSONObject(extraInfo).optLong("open_time", -1) > 0) {
                                count++;
                            }
                        }
                    } while (cur.moveToNext());
                }
            } else {
                cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, selection3, selectionArgs, "");
                if (cur != null) {
                    int pathColumnIndex2 = cur.getColumnIndex("_data");
                    cur.moveToFirst();
                    do {
                        if (checkFileAvailable(cur.getString(pathColumnIndex2))) {
                            count++;
                        }
                    } while (cur.moveToNext());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
        return count;
    }

    public static String joinString(List<String> strList) {
        ArrayList<String> convertedStrList = new ArrayList<>();
        for (String querySource : strList) {
            convertedStrList.add("'" + querySource + "'");
        }
        return TextUtils.join(",", convertedStrList);
    }

    public static int queryDownloadDataCountByCategory(int category) {
        if (category == 5) {
            return mOtherDataCount;
        }
        String selection = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? " + FileClassifyHelper.getSQliteSelectionByCategory(category, (List<String>) null);
        if (!DownloadPermissionHelper.hasSelfDownloadedFileReadPermission()) {
            selection = selection + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR " + "_data" + " like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR " + "_data" + " IS NULL)");
        }
        Cursor cur = null;
        try {
            cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data", "mimetype"}, selection, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, "");
            if (cur != null) {
                int mimeTypeColumnIndex = cur.getColumnIndex("mimetype");
                int downloadPathColumnIndex = cur.getColumnIndex("_data");
                int count = cur.getCount();
                cur.moveToFirst();
                do {
                    if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(cur.getString(downloadPathColumnIndex)), cur.getString(mimeTypeColumnIndex)) != category) {
                        count--;
                    }
                } while (cur.moveToNext());
                Closeables.closeSafely(cur);
                return count;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
        return 0;
    }

    public static ArrayList<CategoryInfoData> queryDownloadedCountInfo(int category) {
        int filenameColumnIndex;
        String selection;
        int mimeTypeColumnIndex;
        ArrayList<CategoryInfoData> retList = new ArrayList<>();
        ArrayList<String> mimeTypes = FileClassifyHelper.getMimeTypesByType(category);
        if (mimeTypes.size() == 0) {
            return retList;
        }
        StringBuilder mimeTypesBuilder = new StringBuilder();
        Iterator<String> it = mimeTypes.iterator();
        while (it.hasNext()) {
            mimeTypesBuilder.append("'").append(it.next()).append("',");
        }
        String selection2 = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND mimetype IN (" + mimeTypesBuilder.substring(0, mimeTypesBuilder.length() - 1) + ")";
        if (!DownloadPermissionHelper.hasSelfDownloadedFileReadPermission()) {
            selection2 = selection2 + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR " + "_data" + " like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR " + "_data" + " IS NOT NULL)");
        }
        Cursor cur = null;
        try {
            cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id", "title", "_data", "mimetype"}, selection2, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1)}, (String) null);
            if (cur == null || cur.getCount() <= 0) {
                int i2 = category;
                String str = selection2;
                Closeables.closeSafely(cur);
                return retList;
            }
            int idColumnIndex = cur.getColumnIndex("_id");
            int mimeTypeColumnIndex2 = cur.getColumnIndex("mimetype");
            int filenameColumnIndex2 = cur.getColumnIndex("title");
            int filePathColumnIndex = cur.getColumnIndex("_data");
            cur.moveToFirst();
            while (true) {
                String mimeType = cur.getString(mimeTypeColumnIndex2);
                String path = cur.getString(filePathColumnIndex);
                if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(path), mimeType) != category) {
                    filenameColumnIndex = filenameColumnIndex2;
                    selection = selection2;
                    mimeTypeColumnIndex = mimeTypeColumnIndex2;
                } else {
                    try {
                        CategoryInfoData categoryInfoData = new CategoryInfoData();
                        String filename = cur.getString(filenameColumnIndex2);
                        selection = selection2;
                        try {
                            categoryInfoData.mId = cur.getLong(idColumnIndex);
                            categoryInfoData.mMimeType = mimeType;
                            categoryInfoData.mType = (long) FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(filename), categoryInfoData.mMimeType);
                            categoryInfoData.mDownloadPath = path;
                            mimeTypeColumnIndex = mimeTypeColumnIndex2;
                            filenameColumnIndex = filenameColumnIndex2;
                            categoryInfoData.newFlag = !IDownloadApp.Impl.get().isRead(categoryInfoData.mId);
                            retList.add(categoryInfoData);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                Closeables.closeSafely(cur);
                                return retList;
                            } catch (Throwable th2) {
                                th = th2;
                                Closeables.closeSafely(cur);
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        String str2 = selection2;
                        e.printStackTrace();
                        Closeables.closeSafely(cur);
                        return retList;
                    } catch (Throwable th3) {
                        th = th3;
                        String str3 = selection2;
                        Closeables.closeSafely(cur);
                        throw th;
                    }
                }
                if (!cur.moveToNext()) {
                    break;
                }
                mimeTypeColumnIndex2 = mimeTypeColumnIndex;
                selection2 = selection;
                filenameColumnIndex2 = filenameColumnIndex;
            }
            Closeables.closeSafely(cur);
            return retList;
        } catch (Exception e4) {
            e = e4;
            int i3 = category;
            String str22 = selection2;
            e.printStackTrace();
            Closeables.closeSafely(cur);
            return retList;
        } catch (Throwable th4) {
            th = th4;
            int i4 = category;
            String str32 = selection2;
            Closeables.closeSafely(cur);
            throw th;
        }
    }

    public static List<String> queryDownloadedM3u8Path(int limitCount) {
        ArrayList<String> m3u8PathList = new ArrayList<>();
        Cursor cur = null;
        String selection = "status= ? AND is_visible_in_downloads_ui= ? AND deleted!= ? AND lower(mimetype)= ?";
        try {
            if (!DownloadPermissionHelper.hasSelfDownloadedFileReadPermission()) {
                selection = selection + (" AND (_data like '%" + DownloadHelper.getDownloadDirectory(AppRuntime.getAppContext()).getParentFile().getParent() + "%' OR " + "_data" + " like '%" + AppRuntime.getAppContext().getFilesDir().getParent() + "%' OR " + "_data" + " IS NULL)");
            }
            cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, selection, new String[]{String.valueOf(200), String.valueOf(1), String.valueOf(1), "application/vnd.apple.mpegurl"}, "status asc LIMIT 0," + limitCount);
            if (cur != null) {
                int downloadPathColumnIndex = cur.getColumnIndex("_data");
                cur.moveToFirst();
                do {
                    String path = cur.getString(downloadPathColumnIndex);
                    if (!TextUtils.isEmpty(path)) {
                        m3u8PathList.add(path);
                    }
                } while (cur.moveToNext());
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
        return m3u8PathList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ae A[Catch:{ all -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean updateM3u8Info(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18) {
        /*
            java.lang.String r0 = "_id"
            boolean r1 = android.text.TextUtils.isEmpty(r15)
            r2 = 0
            if (r1 != 0) goto L_0x00c9
            boolean r1 = android.text.TextUtils.isEmpty(r16)
            if (r1 != 0) goto L_0x00c2
            boolean r1 = android.text.TextUtils.isEmpty(r17)
            if (r1 != 0) goto L_0x00bb
            boolean r1 = android.text.TextUtils.isEmpty(r18)
            if (r1 == 0) goto L_0x0023
            r7 = r16
            r9 = r17
            r10 = r18
            goto L_0x00cf
        L_0x0023:
            r1 = 0
            r3 = 0
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            java.lang.String r8 = "_data = ?"
            android.net.Uri r6 = com.baidu.searchbox.download.model.Downloads.CONTENT_URI     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            r12 = 1
            java.lang.String[] r9 = new java.lang.String[r12]     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            r9[r2] = r15     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            r10 = 0
            r11 = 0
            r5 = r4
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            r3 = r5
            if (r3 == 0) goto L_0x0092
            boolean r5 = r3.moveToFirst()     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            if (r5 == 0) goto L_0x008b
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            r5.<init>()     // Catch:{ Exception -> 0x00a1, all -> 0x0099 }
            java.lang.String r6 = "_data"
            r7 = r16
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            java.lang.String r6 = "title"
            r9 = r17
            r5.put(r6, r9)     // Catch:{ Exception -> 0x0085, all -> 0x0083 }
            java.lang.String r6 = "mimetype"
            r10 = r18
            r5.put(r6, r10)     // Catch:{ Exception -> 0x0081 }
            com.baidu.searchbox.download.manager.DownloadManagerExt r6 = com.baidu.searchbox.download.manager.DownloadManagerExt.getInstance()     // Catch:{ Exception -> 0x0081 }
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0081 }
            long r13 = r3.getLong(r0)     // Catch:{ Exception -> 0x0081 }
            android.net.Uri r0 = r6.getDownloadUri(r13)     // Catch:{ Exception -> 0x0081 }
            r6 = 0
            int r0 = r4.update(r0, r5, r6, r6)     // Catch:{ Exception -> 0x0081 }
            if (r0 < r12) goto L_0x007f
            r2 = r12
        L_0x007f:
            r1 = r2
            goto L_0x00b1
        L_0x0081:
            r0 = move-exception
            goto L_0x00a8
        L_0x0083:
            r0 = move-exception
            goto L_0x009e
        L_0x0085:
            r0 = move-exception
            goto L_0x00a6
        L_0x0087:
            r0 = move-exception
            goto L_0x009c
        L_0x0089:
            r0 = move-exception
            goto L_0x00a4
        L_0x008b:
            r7 = r16
            r9 = r17
            r10 = r18
            goto L_0x00b1
        L_0x0092:
            r7 = r16
            r9 = r17
            r10 = r18
            goto L_0x00b1
        L_0x0099:
            r0 = move-exception
            r7 = r16
        L_0x009c:
            r9 = r17
        L_0x009e:
            r10 = r18
            goto L_0x00b7
        L_0x00a1:
            r0 = move-exception
            r7 = r16
        L_0x00a4:
            r9 = r17
        L_0x00a6:
            r10 = r18
        L_0x00a8:
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x00b1
            r0.printStackTrace()     // Catch:{ all -> 0x00b6 }
        L_0x00b1:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r3)
            return r1
        L_0x00b6:
            r0 = move-exception
        L_0x00b7:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r3)
            throw r0
        L_0x00bb:
            r7 = r16
            r9 = r17
            r10 = r18
            goto L_0x00cf
        L_0x00c2:
            r7 = r16
            r9 = r17
            r10 = r18
            goto L_0x00cf
        L_0x00c9:
            r7 = r16
            r9 = r17
            r10 = r18
        L_0x00cf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.updateM3u8Info(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean isHasFileInDownloadDbByPath(String filePath) {
        boolean z = false;
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        boolean hasM3u8FileInDownload = false;
        Cursor cursor = null;
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.CONTENT_URI, new String[]{"_id"}, "_data = ?", new String[]{filePath}, (String) null, (CancellationSignal) null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    z = true;
                }
                hasM3u8FileInDownload = z;
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return hasM3u8FileInDownload;
    }

    public static void updateDownloadTitle(String oldPath, CategoryInfoData info, RequestCallback callback) {
        if (info.mIsLocal) {
            updateLocalDataTitle(oldPath, info, callback);
            long id = queryDownloadDataByPath(oldPath);
            if (id > -1) {
                IDownloadApp.Impl.get().updateDownloadTitle(info.mFileName, info.mDownloadPath, id);
                return;
            }
            return;
        }
        IDownloadApp.Impl.get().updateDownloadTitle(info.mFileName, info.mDownloadPath, info.mId);
        if (DownloadHelper.getFileTypeString(info.mDownloadPath, info.mMimeType).equals("image") || FileClassifyHelper.getCategory(info.mDownloadPath, info.mMimeType) == 4) {
            updateLocalDataTitle(oldPath, info, callback);
        } else if (callback != null) {
            callback.onPermitted(1);
        }
    }

    private static void updateLocalDataTitle(String oldPath, CategoryInfoData info, RequestCallback callback) {
        Uri uri;
        ContentValues contentValues = new ContentValues();
        String title = info.mFileName;
        contentValues.put("title", title.substring(0, title.lastIndexOf(".")));
        contentValues.put("_data", info.mDownloadPath);
        if (DownloadMediaHelper.isOpenScopedStorage()) {
            uri = DownloadMediaHelper.queryMediaFileUri(AppRuntime.getAppContext(), info.mDownloadPath, info.mMimeType);
        } else {
            uri = MediaStore.Files.getContentUri("external");
        }
        try {
            MediaFileProcessor.update(AppRuntime.getAppContext(), uri, contentValues, "_data = ?", new String[]{oldPath}, callback);
        } catch (SecurityException e2) {
            SecurityException securityException = e2;
            if (AppConfig.isDebug()) {
                securityException.printStackTrace();
            }
            MediaFileProcessor.update(AppRuntime.getAppContext(), uri, contentValues, (String) null, (String[]) null, callback);
        }
        if (callback != null) {
            callback.onPermitted(1);
        }
    }

    public static void deleteDownloadInfo(Set<CategoryInfoData> downloadSet) {
        deleteDownloadInfo(downloadSet, (DownloadMediaHelper.CallBack<ArrayList<Long>>) null);
    }

    public static void deleteDownloadInfo(Set<CategoryInfoData> downloadSet, DownloadMediaHelper.CallBack<ArrayList<Long>> mDeleteMap) {
        final DownloadMediaHelper.CallBack<ArrayList<Long>> callBack = mDeleteMap;
        ArrayList<CategoryInfoData> selfList = new ArrayList<>();
        ArrayList<CategoryInfoData> localList = new ArrayList<>();
        String[] needToDeleteDataPath = new String[downloadSet.size()];
        int index = 0;
        for (CategoryInfoData item : downloadSet) {
            if (item != null) {
                if (item.mIsLocal) {
                    localList.add(item);
                } else {
                    selfList.add(item);
                }
                if (!TextUtils.isEmpty(item.mDownloadPath)) {
                    needToDeleteDataPath[index] = item.mDownloadPath;
                    index++;
                }
            }
        }
        final List<String> pathList = new ArrayList<>();
        List<Uri> uriList = new ArrayList<>();
        final HashMap<Uri, String> mUriPathMap = new HashMap<>();
        if (localList.size() > 0) {
            Iterator<CategoryInfoData> it = localList.iterator();
            while (it.hasNext()) {
                CategoryInfoData item2 = it.next();
                if (DownloadMediaHelper.isOpenScopedStorage()) {
                    pathList.add(item2.mDownloadPath);
                    Uri uri = DownloadMediaHelper.queryMediaFileUri(AppRuntime.getAppContext(), item2.mDownloadPath, item2.mMimeType);
                    uriList.add(uri);
                    mUriPathMap.put(uri, item2.mDownloadPath);
                } else {
                    DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), item2.mDownloadPath, item2.mMimeType);
                }
                String type = DownloadHelper.getFileTypeString(item2.mDownloadPath, item2.mMimeType);
                LocalDataScanHelper.getInstance().refreshLocalDataCount(type, false);
                LocalDataScanHelper.getInstance().refreshLocalDataType(item2.mDownloadPath, type, false);
            }
            if (!DownloadMediaHelper.isOpenScopedStorage() || selfList.size() != 0) {
                Set<CategoryInfoData> set = downloadSet;
            } else {
                final Set<CategoryInfoData> set2 = downloadSet;
                DownloadMediaHelper.deleteByUriList(AppRuntime.getAppContext(), uriList, new DownloadMediaHelper.CallBack<ArrayList<Uri>>() {
                    public void callback(ArrayList<Uri> deleteUriList) {
                        DownloadCenterUtils.delDeleUriIdCallback(set2, callBack, mUriPathMap, deleteUriList);
                    }
                });
            }
        } else {
            Set<CategoryInfoData> set3 = downloadSet;
        }
        if (selfList.size() > 0) {
            long[] selfIds = new long[selfList.size()];
            int count = 0;
            Iterator<CategoryInfoData> it2 = selfList.iterator();
            while (it2.hasNext()) {
                CategoryInfoData item3 = it2.next();
                selfIds[count] = item3.mId;
                count++;
                if (item3.mType == 5) {
                    mOtherDataCount--;
                }
            }
            DownloadManagerExt.getInstance().deleteDownloadFile(false, new DownloadMediaHelper.CallBack<ArrayList<String>>() {
                public void callback(ArrayList<String> filePathList) {
                    List list = pathList;
                    if (list != null && !list.isEmpty() && filePathList != null) {
                        filePathList.addAll(pathList);
                    }
                }
            }, new DownloadMediaHelper.CallBack<ArrayList<Long>>() {
                public void callback(ArrayList<Long> deleteUriList) {
                    DownloadMediaHelper.CallBack callBack = DownloadMediaHelper.CallBack.this;
                    if (callBack != null) {
                        callBack.callback(deleteUriList);
                    }
                }
            }, selfIds);
        }
        ImageScanner.scanFile(AppRuntime.getAppContext(), needToDeleteDataPath, (String[]) null, (ImageScanner.OnScanCompletedListener) null);
    }

    /* access modifiers changed from: private */
    public static void delDeleUriIdCallback(Set<CategoryInfoData> downloadSet, DownloadMediaHelper.CallBack<ArrayList<Long>> mDeleteMap, HashMap<Uri, String> mUriPathMap, ArrayList<Uri> deleteUriList) {
        if (mDeleteMap != null && downloadSet != null && !downloadSet.isEmpty() && deleteUriList != null && mUriPathMap != null) {
            ArrayList<Long> mDeleteIds = new ArrayList<>();
            for (CategoryInfoData item : downloadSet) {
                if (item != null) {
                    Iterator<Uri> it = deleteUriList.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(item.mDownloadPath, mUriPathMap.get(it.next()))) {
                            mDeleteIds.add(Long.valueOf(item.mId));
                        }
                    }
                }
            }
            mDeleteMap.callback(mDeleteIds);
        }
    }

    public static void deleteDownloadInfo(CategoryInfoData infoData, RequestCallback callback) {
        if (infoData.mIsLocal) {
            DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), infoData.mDownloadPath, infoData.mMimeType, callback);
            return;
        }
        DownloadManagerExt.getInstance().deleteDownloadFile(infoData.mId);
        if (callback != null) {
            callback.onPermitted(1);
        }
    }

    public static long queryDownloadDataByPath(String path) {
        Cursor cur = null;
        long result = -1;
        try {
            cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "_data= ?", new String[]{path}, (String) null);
            if (cur != null && cur.moveToFirst()) {
                result = cur.getLong(cur.getColumnIndex("_id"));
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
        return result;
    }

    public static void updateDocRecent(CategoryInfoData info) {
        JSONObject extraJson;
        boolean needToUpdateSelf = false;
        long id = info.mId;
        if (info.mIsLocal) {
            id = queryDownloadDataByPath(info.mDownloadPath);
            if (id > -1) {
                needToUpdateSelf = true;
            } else {
                insertLocalData(info);
            }
        } else {
            needToUpdateSelf = true;
        }
        if (needToUpdateSelf) {
            try {
                if (TextUtils.isEmpty(info.mExtraInfo)) {
                    extraJson = new JSONObject();
                } else {
                    extraJson = new JSONObject(info.mExtraInfo);
                }
                extraJson.put("open_time", String.valueOf(System.currentTimeMillis()));
                updateExtralInfo(id, extraJson.toString());
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void updateVideoTotalDuration(String path, int duration) {
        Cursor cur = null;
        try {
            cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info"}, "_data= ?", new String[]{path}, (String) null);
            if (cur != null && cur.moveToFirst()) {
                String ext = cur.getString(cur.getColumnIndex("extra_info"));
                JSONObject jo = TextUtils.isEmpty(ext) ? new JSONObject() : new JSONObject(ext);
                jo.putOpt("duration", Integer.valueOf(duration));
                ContentValues values = new ContentValues();
                values.put("extra_info", jo.toString());
                AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, values, "_data= ? ", new String[]{String.valueOf(path)});
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
    }

    public static void updatePlayProgress(String path, double progress) {
        Cursor cur = null;
        try {
            cur = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"extra_info"}, "_data= ?", new String[]{path}, (String) null);
            if (cur != null && cur.moveToFirst()) {
                String ext = cur.getString(cur.getColumnIndex("extra_info"));
                JSONObject jo = TextUtils.isEmpty(ext) ? new JSONObject() : new JSONObject(ext);
                jo.putOpt(LocalDataScanHelper.EXT_KEY_PLAY_PROGRESS, Double.valueOf(progress));
                ContentValues values = new ContentValues();
                values.put("extra_info", jo.toString());
                AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, values, "_data= ? ", new String[]{String.valueOf(path)});
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cur);
    }

    public static int queryVideoCount() {
        DownloadManager.Query baseQuery = new DownloadManager.Query();
        DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
        String extraSelection = FileClassifyHelper.getSQliteSelectionByCategory(0, (List<String>) null);
        baseQuery.setFilterByStatus(8);
        baseQuery.setOnlyIncludeVisibleInDownloadsUi(true);
        try {
            Cursor downloadCursor = downloadManager.queryDownload(baseQuery.setFilterBySelection(extraSelection).orderBy(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP, 2));
            if (downloadCursor != null) {
                if (!downloadCursor.isClosed()) {
                    int count = 0;
                    int downloadPathColumnIndex = downloadCursor.getColumnIndex("_data");
                    downloadCursor.moveToFirst();
                    do {
                        if (checkFileAvailable(downloadCursor.getString(downloadPathColumnIndex))) {
                            count++;
                        }
                    } while (downloadCursor.moveToNext());
                    return count;
                }
            }
            return 0;
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            if (!DEBUG) {
                return 0;
            }
            throw ex;
        }
    }

    public static void updateOpenTime(CategoryInfoData info, long openTime, boolean openRead) {
        long id = info.mId;
        if (info.mIsLocal) {
            id = queryDownloadDataByPath(info.mDownloadPath);
            if (id == -1) {
                id = insertLocalDataToDownloadTable(info);
            }
        }
        if (id != -1) {
            ContentValues values = new ContentValues();
            values.put(Downloads.Impl.COLUMN_OPEN_TIME, Long.valueOf(openTime));
            values.put(Downloads.Impl.COLUMN_OPEN_READ, Boolean.valueOf(openRead));
            AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, values, "_id= ? ", new String[]{String.valueOf(id)});
        }
    }

    public static void updateExtralInfo(long id, String extraJson) {
        ContentValues values = new ContentValues();
        values.put("extra_info", extraJson);
        AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, values, "_id= ? ", new String[]{String.valueOf(id)});
    }

    private static long insertLocalData(CategoryInfoData info) {
        CategoryInfoData categoryInfoData = info;
        long id = -1;
        ContentValues values = new ContentValues();
        JSONObject extraJson = new JSONObject();
        try {
            extraJson.put("open_time", String.valueOf(System.currentTimeMillis()));
            values.put("uri", "content:/" + categoryInfoData.mDownloadPath);
            values.put("mimetype", categoryInfoData.mMimeType);
            values.put("_data", categoryInfoData.mDownloadPath);
            values.put("status", 200);
            values.put("total_bytes", Long.valueOf(categoryInfoData.mSize));
            values.put("hint", categoryInfoData.mFileName);
            values.put("title", categoryInfoData.mFileName);
            values.put("lastmod", Long.valueOf(categoryInfoData.mCompletionTime));
            values.put("destination", 0);
            values.put("no_integrity", true);
            SQLiteDatabase db = null;
            try {
                db = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
                SQLiteStatement stat = db.compileStatement("insert into downloads(uri,mimetype,_data,status,total_bytes,hint,title,lastmod,destination,no_integrity,visibility,deleted,is_visible_in_downloads_ui,uid,scanned,extra_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                db.beginTransaction();
                stat.bindString(1, "content:/" + categoryInfoData.mDownloadPath);
                stat.bindString(2, categoryInfoData.mMimeType);
                stat.bindString(3, categoryInfoData.mDownloadPath);
                stat.bindLong(4, 200);
                stat.bindLong(5, categoryInfoData.mSize);
                stat.bindString(6, categoryInfoData.mFileName);
                stat.bindString(7, categoryInfoData.mFileName);
                stat.bindLong(8, categoryInfoData.mCompletionTime);
                stat.bindLong(9, 0);
                stat.bindLong(10, 1);
                stat.bindLong(11, 2);
                stat.bindLong(12, 0);
                stat.bindLong(13, 1);
                stat.bindLong(14, (long) Binder.getCallingUid());
                stat.bindLong(15, 1);
                stat.bindString(16, extraJson.toString());
                id = stat.executeInsert();
                db.setTransactionSuccessful();
                if (db != null) {
                    db.endTransaction();
                }
            } catch (Throwable th2) {
            }
            return id;
        } catch (JSONException e2) {
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ba, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bc, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d6, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x00d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long insertLocalDataToDownloadTable(com.baidu.searchbox.download.model.CategoryInfoData r14) {
        /*
            r0 = -1
            r2 = 0
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x00c1 }
            com.baidu.searchbox.download.component.DownloadProvider$DatabaseHelper r3 = com.baidu.searchbox.download.component.DownloadProvider.DatabaseHelper.getInstance(r3)     // Catch:{ all -> 0x00c1 }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ all -> 0x00c1 }
            r2 = r3
            java.lang.String r3 = "insert into downloads(uri,mimetype,_data,status,total_bytes,hint,title,lastmod,destination,no_integrity,visibility,deleted,is_visible_in_downloads_ui,uid,scanned,extra_info,current_bytes) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            android.database.sqlite.SQLiteStatement r4 = r2.compileStatement(r3)     // Catch:{ all -> 0x00c1 }
            r2.beginTransaction()     // Catch:{ all -> 0x00c1 }
            r5 = 1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            r6.<init>()     // Catch:{ all -> 0x00c1 }
            java.lang.String r7 = "content:/"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00c1 }
            java.lang.String r7 = r14.mDownloadPath     // Catch:{ all -> 0x00c1 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c1 }
            r4.bindString(r5, r6)     // Catch:{ all -> 0x00c1 }
            r5 = 2
            java.lang.String r6 = r14.mMimeType     // Catch:{ all -> 0x00c1 }
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x003c
            r6 = r7
            goto L_0x003e
        L_0x003c:
            java.lang.String r6 = r14.mMimeType     // Catch:{ all -> 0x00c1 }
        L_0x003e:
            r4.bindString(r5, r6)     // Catch:{ all -> 0x00c1 }
            r5 = 3
            java.lang.String r6 = r14.mDownloadPath     // Catch:{ all -> 0x00c1 }
            r4.bindString(r5, r6)     // Catch:{ all -> 0x00c1 }
            r5 = 4
            r8 = 200(0xc8, double:9.9E-322)
            r4.bindLong(r5, r8)     // Catch:{ all -> 0x00c1 }
            r5 = 5
            long r8 = r14.mSize     // Catch:{ all -> 0x00c1 }
            r4.bindLong(r5, r8)     // Catch:{ all -> 0x00c1 }
            r5 = 6
            java.lang.String r6 = r14.mFileName     // Catch:{ all -> 0x00c1 }
            r4.bindString(r5, r6)     // Catch:{ all -> 0x00c1 }
            r5 = 7
            java.lang.String r6 = r14.mFileName     // Catch:{ all -> 0x00c1 }
            r4.bindString(r5, r6)     // Catch:{ all -> 0x00c1 }
            r5 = 8
            long r8 = r14.mCompletionTime     // Catch:{ all -> 0x00c1 }
            r4.bindLong(r5, r8)     // Catch:{ all -> 0x00c1 }
            r5 = 9
            r8 = 0
            r4.bindLong(r5, r8)     // Catch:{ all -> 0x00c1 }
            r5 = 10
            r10 = 1
            r4.bindLong(r5, r10)     // Catch:{ all -> 0x00c1 }
            r5 = 11
            r12 = 2
            r4.bindLong(r5, r12)     // Catch:{ all -> 0x00c1 }
            r5 = 12
            r4.bindLong(r5, r8)     // Catch:{ all -> 0x00c1 }
            r5 = 13
            r4.bindLong(r5, r10)     // Catch:{ all -> 0x00c1 }
            r5 = 14
            int r6 = android.os.Binder.getCallingUid()     // Catch:{ all -> 0x00c1 }
            long r8 = (long) r6     // Catch:{ all -> 0x00c1 }
            r4.bindLong(r5, r8)     // Catch:{ all -> 0x00c1 }
            r5 = 15
            r4.bindLong(r5, r10)     // Catch:{ all -> 0x00c1 }
            r5 = 16
            java.lang.String r6 = r14.mExtraInfo     // Catch:{ all -> 0x00c1 }
            if (r6 != 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            java.lang.String r7 = r14.mExtraInfo     // Catch:{ all -> 0x00c1 }
        L_0x009d:
            r4.bindString(r5, r7)     // Catch:{ all -> 0x00c1 }
            r5 = 17
            long r6 = r14.mSize     // Catch:{ all -> 0x00c1 }
            r4.bindLong(r5, r6)     // Catch:{ all -> 0x00c1 }
            long r5 = r4.executeInsert()     // Catch:{ all -> 0x00c1 }
            r0 = r5
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x00c1 }
            if (r2 == 0) goto L_0x00c0
            r2.endTransaction()     // Catch:{ all -> 0x00b5 }
            goto L_0x00c0
        L_0x00b5:
            r3 = move-exception
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L_0x00bf
        L_0x00bc:
            r3.printStackTrace()
        L_0x00bf:
            goto L_0x00d9
        L_0x00c0:
            goto L_0x00d9
        L_0x00c1:
            r3 = move-exception
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x00da }
            if (r4 == 0) goto L_0x00cb
            r3.printStackTrace()     // Catch:{ all -> 0x00da }
        L_0x00cb:
            if (r2 == 0) goto L_0x00c0
            r2.endTransaction()     // Catch:{ all -> 0x00d1 }
            goto L_0x00c0
        L_0x00d1:
            r3 = move-exception
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L_0x00bf
            goto L_0x00bc
        L_0x00d9:
            return r0
        L_0x00da:
            r3 = move-exception
            if (r2 == 0) goto L_0x00ec
            r2.endTransaction()     // Catch:{ all -> 0x00e1 }
            goto L_0x00ec
        L_0x00e1:
            r4 = move-exception
            boolean r5 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r5 == 0) goto L_0x00ed
            r4.printStackTrace()
            goto L_0x00ed
        L_0x00ec:
        L_0x00ed:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.insertLocalDataToDownloadTable(com.baidu.searchbox.download.model.CategoryInfoData):long");
    }

    public static void updateNetdiskUploadInfo(long id, NetdiskUploadInfo uploadInfo) {
        ContentValues values = new ContentValues();
        if (uploadInfo == null) {
            values.putNull(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO);
        } else {
            values.put(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, new Gson().toJson((Object) uploadInfo));
        }
        AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, values, "_id= ? ", new String[]{String.valueOf(id)});
    }

    public static void clearNetdiskUploadInfo() {
        ContentValues cv = new ContentValues();
        cv.putNull(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO);
        AppRuntime.getAppContext().getContentResolver().update(Downloads.CONTENT_URI, cv, (String) null, (String[]) null);
    }

    public static VideoDownloadInfo getVideoDownloadInfo(CategoryInfoData data) {
        if (data == null) {
            return null;
        }
        try {
            return (VideoDownloadInfo) new Gson().fromJson(data.mExtraInfo, VideoDownloadInfo.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean getIllegal(CategoryInfoData data) {
        if (data == null) {
            return true;
        }
        if (data.mNetdiskUploadInfo == null) {
            return false;
        }
        return data.mNetdiskUploadInfo.getIllegal();
    }

    public static int markRowDeleted(long... ids) {
        return DownloadManagerExt.getInstance().markRowDeleted(ids);
    }

    public static boolean checkFileAvailable(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        try {
            File file = new File(filePath);
            if (!file.exists() || !file.canRead()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (!DEBUG) {
                return false;
            }
            throw new DebugException("DownloadCenterUtils.checkFileAvailable(String path) : path = " + DownloadHelper.getDisplayString(filePath), e2);
        }
    }

    public static boolean checkFileDirNormal(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        if (Environment.getExternalStorageDirectory() != null && filePath.startsWith(Environment.getExternalStorageDirectory().toString())) {
            return true;
        }
        if (AppRuntime.getApplication().getFilesDir() == null || !filePath.startsWith(AppRuntime.getApplication().getFilesDir().getParent())) {
            return false;
        }
        return true;
    }

    public static void setOtherDataCount(int count) {
        mOtherDataCount = count;
    }

    public static int getOtherDataCount() {
        return mOtherDataCount;
    }

    public static void setTouchDelegate(final View view2, final int expandTouchWidth) {
        final View parentView = (View) view2.getParent();
        parentView.post(new Runnable() {
            public void run() {
                Rect rect = new Rect();
                view2.getHitRect(rect);
                rect.top -= expandTouchWidth;
                rect.bottom += expandTouchWidth;
                rect.left -= expandTouchWidth;
                rect.right += expandTouchWidth;
                parentView.setTouchDelegate(new TouchDelegate(rect, view2));
            }
        });
    }

    public static long[] filterCyberDownloadOperate(ICyberInvoker invoker, long... downloadIds) {
        ArrayList<Long> filterCyberDownloadIds = new ArrayList<>();
        for (long id : downloadIds) {
            DownloadDbItem downloadDbItem = ((IBoxDownloadDbOperator) ServiceManager.getService(IBoxDownloadDbOperator.Companion.getSERVICE_REFERENCE())).queryItem(id);
            if (downloadDbItem == null || downloadDbItem.getBusinessType() != 1 || TextUtils.isEmpty(downloadDbItem.getBusinessId())) {
                filterCyberDownloadIds.add(Long.valueOf(id));
            } else if (invoker != null) {
                invoker.invoke(downloadDbItem);
            }
        }
        if (filterCyberDownloadIds.size() <= 0) {
            return null;
        }
        long[] finalIds = new long[filterCyberDownloadIds.size()];
        for (int i2 = 0; i2 < filterCyberDownloadIds.size(); i2++) {
            finalIds[i2] = filterCyberDownloadIds.get(i2).longValue();
        }
        return finalIds;
    }

    public static long[] filterP2pDownloadOperate(INetDiskP2pInvoker invoker, long... downloadIds) {
        ArrayList<Long> filterP2pDownloadIds = new ArrayList<>();
        for (long id : downloadIds) {
            DownloadDbItem downloadDbItem = ((IBoxDownloadDbOperator) ServiceManager.getService(IBoxDownloadDbOperator.Companion.getSERVICE_REFERENCE())).queryItem(id);
            if (downloadDbItem == null || downloadDbItem.getBusinessType() != 2 || TextUtils.isEmpty(downloadDbItem.getBusinessId())) {
                filterP2pDownloadIds.add(Long.valueOf(id));
            } else if (invoker != null) {
                invoker.invoke(downloadDbItem);
            }
        }
        if (filterP2pDownloadIds.size() <= 0) {
            return null;
        }
        long[] finalIds = new long[filterP2pDownloadIds.size()];
        for (int i2 = 0; i2 < filterP2pDownloadIds.size(); i2++) {
            finalIds[i2] = filterP2pDownloadIds.get(i2).longValue();
        }
        return finalIds;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0310 A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x034f A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0362 A[LOOP:0: B:17:0x010c->B:114:0x0362, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0399 A[Catch:{ all -> 0x03a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x039c A[EDGE_INSN: B:130:0x039c->B:125:0x039c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x023e A[Catch:{ all -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02c7 A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02ee A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02ef A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02fb A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02fd A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x030e A[Catch:{ Exception -> 0x0385 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.baidu.searchbox.download.model.CategoryInfoData> queryDownloadingAndDownloaded(boolean r34, int r35, boolean r36) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r0
            java.lang.String r2 = " AND uri not like '%content://%' AND uri not like '%copy://%'"
            r3 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r0.<init>()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r4 = r0
            com.baidu.searchbox.download.manager.DownloadManager r0 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r0.<init>(r5, r6)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r5 = r0
            r6 = 1
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r4.setOnlyIncludeVisibleInDownloadsUi(r6)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r7 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setOnlyDownloading(r7)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setFilterBySelection(r2)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r8 = r36
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.showDeleted(r8)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r9 = r35
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setLimit(r9)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r10 = "create_time"
            r11 = 2
            r0.orderBy(r10, r11)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r0 = "uri"
            if (r34 != 0) goto L_0x0085
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            r10.<init>()     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.String r12 = getFilterPrivateFileSql()     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.String r12 = " AND "
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.String r12 = " not like '%"
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.String r12 = "copy://"
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.String r12 = "%'"
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            r4.setFilterBySelection(r10)     // Catch:{ Exception -> 0x0080, all -> 0x007b }
            goto L_0x0085
        L_0x007b:
            r0 = move-exception
            r27 = r2
            goto L_0x03a2
        L_0x0080:
            r0 = move-exception
            r27 = r2
            goto L_0x0395
        L_0x0085:
            java.lang.String[] r10 = PROJECTIONS_FILTER_BY_TYPE     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            android.database.Cursor r10 = r5.query(r4, r10)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r3 = r10
            if (r3 == 0) goto L_0x0387
            int r10 = r3.getCount()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            if (r10 <= 0) goto L_0x0387
            java.lang.String r10 = "_id"
            int r10 = r3.getColumnIndex(r10)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r12 = "status"
            int r12 = r3.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r13 = "mimetype"
            int r13 = r3.getColumnIndex(r13)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r14 = "total_bytes"
            int r14 = r3.getColumnIndex(r14)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r15 = "_data"
            int r15 = r3.getColumnIndex(r15)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r7 = "title"
            int r7 = r3.getColumnIndex(r7)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r11 = "lastmod"
            int r11 = r3.getColumnIndex(r11)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            java.lang.String r6 = "extra_info"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r17 = r0
            java.lang.String r0 = "deleted"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r18 = r0
            java.lang.String r0 = "business_type"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r19 = r0
            java.lang.String r0 = "netdisk_upload_info"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r20 = r0
            java.lang.String r0 = "bytes_so_far"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r21 = r0
            java.lang.String r0 = "source"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r22 = r0
            java.lang.String r0 = "progress"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r23 = r0
            r3.moveToFirst()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r0.<init>()     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r24 = r0
        L_0x010c:
            java.lang.String r0 = r3.getString(r13)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r25 = r0
            java.lang.String r0 = r3.getString(r7)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r26 = r0
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r26)     // Catch:{ Exception -> 0x0392, all -> 0x038e }
            r27 = r2
            r2 = r25
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r2)     // Catch:{ Exception -> 0x0385 }
            r25 = r0
            com.baidu.searchbox.download.model.CategoryInfoData r0 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch:{ Exception -> 0x0385 }
            r0.<init>()     // Catch:{ Exception -> 0x0385 }
            r28 = r0
            r29 = r4
            r30 = r5
            long r4 = r3.getLong(r10)     // Catch:{ Exception -> 0x0385 }
            r31 = r7
            r7 = r28
            r7.mId = r4     // Catch:{ Exception -> 0x0385 }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0385 }
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0145
            r0 = r4
            goto L_0x0146
        L_0x0145:
            r0 = r2
        L_0x0146:
            r7.mMimeType = r0     // Catch:{ Exception -> 0x0385 }
            r5 = r25
            long r8 = (long) r5     // Catch:{ Exception -> 0x0385 }
            r7.mType = r8     // Catch:{ Exception -> 0x0385 }
            r8 = r19
            int r0 = r3.getInt(r8)     // Catch:{ Exception -> 0x0385 }
            r7.mBusinessType = r0     // Catch:{ Exception -> 0x0385 }
            java.lang.String r0 = r3.getString(r15)     // Catch:{ Exception -> 0x0385 }
            r7.mDownloadPath = r0     // Catch:{ Exception -> 0x0385 }
            r9 = r23
            int r0 = r3.getInt(r9)     // Catch:{ Exception -> 0x0385 }
            r7.progress = r0     // Catch:{ Exception -> 0x0385 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch:{ Exception -> 0x0385 }
            r0.<init>()     // Catch:{ Exception -> 0x0385 }
            r7.mDownloadingInfo = r0     // Catch:{ Exception -> 0x0385 }
            r19 = r2
            r2 = r17
            java.lang.String r0 = r3.getString(r2)     // Catch:{ Exception -> 0x0385 }
            r17 = r0
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r7.mDownloadingInfo     // Catch:{ Exception -> 0x0385 }
            r23 = r2
            r2 = r17
            r0.mUrl = r2     // Catch:{ Exception -> 0x0385 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r7.mDownloadingInfo     // Catch:{ Exception -> 0x0385 }
            r17 = r2
            int r2 = r3.getInt(r12)     // Catch:{ Exception -> 0x0385 }
            r0.mStatus = r2     // Catch:{ Exception -> 0x0385 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r7.mDownloadingInfo     // Catch:{ Exception -> 0x0385 }
            r25 = r9
            r2 = r21
            r21 = r8
            long r8 = r3.getLong(r2)     // Catch:{ Exception -> 0x0385 }
            r0.mCurrentSize = r8     // Catch:{ Exception -> 0x0385 }
            r0 = 6
            if (r0 != r5) goto L_0x0251
            r8 = 0
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x0235, all -> 0x022f }
            r28 = r8
            long r8 = r7.mId     // Catch:{ Exception -> 0x0229, all -> 0x0223 }
            android.database.Cursor r0 = r0.getSearchboxDownloadCursor(r8)     // Catch:{ Exception -> 0x0229, all -> 0x0223 }
            r8 = r0
            if (r8 == 0) goto L_0x0218
            boolean r0 = r8.moveToFirst()     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            if (r0 == 0) goto L_0x0218
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewprogress     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            float r0 = r8.getFloat(r0)     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            r7.mStoryViewProgress = r0     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewposition     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            r7.mStoryPosition = r0     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.gid     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0214, all -> 0x0210 }
            r32 = r10
            long r9 = r8.getLong(r0)     // Catch:{ Exception -> 0x0221 }
            r7.mGid = r9     // Catch:{ Exception -> 0x0221 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booksrc     // Catch:{ Exception -> 0x0221 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0221 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0221 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0221 }
            r7.mBookDirectoryUrl = r0     // Catch:{ Exception -> 0x0221 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booktype     // Catch:{ Exception -> 0x0221 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0221 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0221 }
            int r0 = r8.getInt(r0)     // Catch:{ Exception -> 0x0221 }
            r7.mBookType = r0     // Catch:{ Exception -> 0x0221 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.bookfree     // Catch:{ Exception -> 0x0221 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0221 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0221 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0221 }
            r7.mFree = r0     // Catch:{ Exception -> 0x0221 }
            goto L_0x0241
        L_0x0210:
            r0 = move-exception
            r32 = r10
            goto L_0x024c
        L_0x0214:
            r0 = move-exception
            r32 = r10
            goto L_0x023a
        L_0x0218:
            r32 = r10
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7.mStoryViewProgress = r0     // Catch:{ Exception -> 0x0221 }
            r7.mStoryPosition = r4     // Catch:{ Exception -> 0x0221 }
            goto L_0x0241
        L_0x0221:
            r0 = move-exception
            goto L_0x023a
        L_0x0223:
            r0 = move-exception
            r32 = r10
            r8 = r28
            goto L_0x024c
        L_0x0229:
            r0 = move-exception
            r32 = r10
            r8 = r28
            goto L_0x023a
        L_0x022f:
            r0 = move-exception
            r28 = r8
            r32 = r10
            goto L_0x024c
        L_0x0235:
            r0 = move-exception
            r28 = r8
            r32 = r10
        L_0x023a:
            boolean r9 = DEBUG     // Catch:{ all -> 0x024b }
            if (r9 == 0) goto L_0x0241
            r0.printStackTrace()     // Catch:{ all -> 0x024b }
        L_0x0241:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r8)     // Catch:{ Exception -> 0x0385 }
            r10 = r12
            r28 = r13
            r8 = 2
            goto L_0x02c3
        L_0x024b:
            r0 = move-exception
        L_0x024c:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r8)     // Catch:{ Exception -> 0x0385 }
            throw r0     // Catch:{ Exception -> 0x0385 }
        L_0x0251:
            r32 = r10
            r0 = 3
            if (r5 != r0) goto L_0x0273
            java.lang.String r0 = r3.getString(r6)     // Catch:{ Exception -> 0x0385 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0385 }
            if (r8 != 0) goto L_0x026e
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0385 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x0385 }
            java.lang.String r9 = "icon"
            java.lang.String r9 = r8.optString(r9, r4)     // Catch:{ Exception -> 0x0385 }
            r7.mAppIcon = r9     // Catch:{ Exception -> 0x0385 }
        L_0x026e:
            r10 = r12
            r28 = r13
            r8 = 2
            goto L_0x02c3
        L_0x0273:
            java.lang.String r0 = "m3u8"
            java.lang.String r8 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r26)     // Catch:{ Exception -> 0x0385 }
            boolean r0 = r0.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0385 }
            if (r0 == 0) goto L_0x02af
            r8 = 1
            r7.mIsM3U8 = r8     // Catch:{ Exception -> 0x0385 }
            java.lang.String r0 = r3.getString(r6)     // Catch:{ Exception -> 0x0385 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0385 }
            if (r8 != 0) goto L_0x02aa
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0385 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x0385 }
            java.lang.String r9 = "poster"
            java.lang.String r9 = r8.optString(r9, r4)     // Catch:{ Exception -> 0x0385 }
            r7.mPoster = r9     // Catch:{ Exception -> 0x0385 }
            java.lang.String r9 = "play_progress"
            r10 = r12
            r28 = r13
            r12 = 0
            double r12 = r8.optDouble(r9, r12)     // Catch:{ Exception -> 0x0385 }
            r7.mPlayProgress = r12     // Catch:{ Exception -> 0x0385 }
            goto L_0x02ad
        L_0x02aa:
            r10 = r12
            r28 = r13
        L_0x02ad:
            r8 = 2
            goto L_0x02c3
        L_0x02af:
            r10 = r12
            r28 = r13
            r8 = 2
            if (r5 == r8) goto L_0x02b7
            if (r5 != 0) goto L_0x02c3
        L_0x02b7:
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r7.mDownloadingInfo     // Catch:{ Exception -> 0x0385 }
            int r0 = r0.mStatus     // Catch:{ Exception -> 0x0385 }
            r9 = 8
            if (r0 != r9) goto L_0x02c3
            java.lang.String r0 = r7.mDownloadPath     // Catch:{ Exception -> 0x0385 }
            r7.mAppIcon = r0     // Catch:{ Exception -> 0x0385 }
        L_0x02c3:
            int r0 = r7.mBusinessType     // Catch:{ Exception -> 0x0385 }
            if (r0 == 0) goto L_0x02d3
            java.lang.String r0 = "business_id"
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0385 }
            java.lang.String r9 = r3.getString(r0)     // Catch:{ Exception -> 0x0385 }
            r7.businessId = r9     // Catch:{ Exception -> 0x0385 }
        L_0x02d3:
            long r12 = r3.getLong(r14)     // Catch:{ Exception -> 0x0385 }
            r7.mSize = r12     // Catch:{ Exception -> 0x0385 }
            r9 = r26
            r7.mFileName = r9     // Catch:{ Exception -> 0x0385 }
            long r12 = r3.getLong(r11)     // Catch:{ Exception -> 0x0385 }
            r7.mCompletionTime = r12     // Catch:{ Exception -> 0x0385 }
            java.lang.String r0 = r3.getString(r6)     // Catch:{ Exception -> 0x0385 }
            r12 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0385 }
            if (r0 == 0) goto L_0x02ef
            goto L_0x02f0
        L_0x02ef:
            r4 = r12
        L_0x02f0:
            r7.mExtraInfo = r4     // Catch:{ Exception -> 0x0385 }
            r4 = r18
            int r0 = r3.getInt(r4)     // Catch:{ Exception -> 0x0385 }
            r13 = 1
            if (r0 != r13) goto L_0x02fd
            r0 = r13
            goto L_0x02fe
        L_0x02fd:
            r0 = 0
        L_0x02fe:
            r7.mIsDeleted = r0     // Catch:{ Exception -> 0x0385 }
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x0385 }
            r16 = r9
            long r8 = r7.mId     // Catch:{ Exception -> 0x0385 }
            boolean r0 = r0.isRead(r8)     // Catch:{ Exception -> 0x0385 }
            if (r0 != 0) goto L_0x0310
            r8 = r13
            goto L_0x0311
        L_0x0310:
            r8 = 0
        L_0x0311:
            r7.newFlag = r8     // Catch:{ Exception -> 0x0385 }
            r8 = r22
            java.lang.String r0 = r3.getString(r8)     // Catch:{ Exception -> 0x0385 }
            r7.mSource = r0     // Catch:{ Exception -> 0x0385 }
            r9 = r20
            java.lang.String r0 = r3.getString(r9)     // Catch:{ Exception -> 0x0385 }
            r18 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x0385 }
            if (r0 != 0) goto L_0x034f
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r0 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r13 = r24
            r33 = r18
            r18 = r2
            r2 = r33
            java.lang.Object r0 = r13.fromJson((java.lang.String) r2, r0)     // Catch:{ JsonSyntaxException -> 0x033c }
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch:{ JsonSyntaxException -> 0x033c }
            r7.mNetdiskUploadInfo = r0     // Catch:{ JsonSyntaxException -> 0x033c }
            goto L_0x0357
        L_0x033c:
            r0 = move-exception
            goto L_0x0347
        L_0x033e:
            r0 = move-exception
            r13 = r24
            r33 = r18
            r18 = r2
            r2 = r33
        L_0x0347:
            boolean r22 = DEBUG     // Catch:{ Exception -> 0x0385 }
            if (r22 == 0) goto L_0x0357
            r0.printStackTrace()     // Catch:{ Exception -> 0x0385 }
            goto L_0x0357
        L_0x034f:
            r13 = r24
            r33 = r18
            r18 = r2
            r2 = r33
        L_0x0357:
            r1.add(r7)     // Catch:{ Exception -> 0x0385 }
            boolean r0 = r3.moveToNext()     // Catch:{ Exception -> 0x0385 }
            if (r0 != 0) goto L_0x0362
            goto L_0x039c
        L_0x0362:
            r22 = r8
            r20 = r9
            r12 = r10
            r24 = r13
            r19 = r21
            r17 = r23
            r23 = r25
            r2 = r27
            r13 = r28
            r5 = r30
            r7 = r31
            r10 = r32
            r9 = r35
            r8 = r36
            r21 = r18
            r18 = r4
            r4 = r29
            goto L_0x010c
        L_0x0385:
            r0 = move-exception
            goto L_0x0395
        L_0x0387:
            r27 = r2
            r29 = r4
            r30 = r5
            goto L_0x039c
        L_0x038e:
            r0 = move-exception
            r27 = r2
            goto L_0x03a2
        L_0x0392:
            r0 = move-exception
            r27 = r2
        L_0x0395:
            boolean r2 = DEBUG     // Catch:{ all -> 0x03a1 }
            if (r2 == 0) goto L_0x039c
            r0.printStackTrace()     // Catch:{ all -> 0x03a1 }
        L_0x039c:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r3)
            return r1
        L_0x03a1:
            r0 = move-exception
        L_0x03a2:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloadingAndDownloaded(boolean, int, boolean):java.util.List");
    }

    public static List<Long> queryDownloadingIds() {
        int idColumnIndex;
        ArrayList<Long> downloadingIds = new ArrayList<>();
        Cursor cursor = null;
        try {
            DownloadManager.Query baseQuery = new DownloadManager.Query();
            DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
            baseQuery.setFilterBySelection(" AND status IN ('190', '192', '193', '194', '195', '196')");
            cursor = downloadManager.query(baseQuery, new String[]{"_id"});
            if (cursor != null && cursor.getCount() > 0 && (idColumnIndex = cursor.getColumnIndex("_id")) > -1) {
                cursor.moveToFirst();
                do {
                    downloadingIds.add(Long.valueOf(cursor.getLong(idColumnIndex)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return downloadingIds;
    }

    public static CategoryInfoData queryDownloadItem(long id) {
        return queryDownloadItem(id, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0192 A[Catch:{ all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01c2 A[Catch:{ Exception -> 0x026a, all -> 0x0268 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x021b A[Catch:{ Exception -> 0x026a, all -> 0x0268 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x021d A[Catch:{ Exception -> 0x026a, all -> 0x0268 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x022e A[Catch:{ Exception -> 0x026a, all -> 0x0268 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0230 A[Catch:{ Exception -> 0x026a, all -> 0x0268 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x025e  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0195=Splitter:B:40:0x0195, B:26:0x017b=Splitter:B:26:0x017b, B:36:0x018e=Splitter:B:36:0x018e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.searchbox.download.model.CategoryInfoData queryDownloadItem(long r27, boolean r29) {
        /*
            r1 = 0
            r2 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch:{ Exception -> 0x026a }
            r0.<init>()     // Catch:{ Exception -> 0x026a }
            r3 = r0
            com.baidu.searchbox.download.manager.DownloadManager r0 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x026a }
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x026a }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x026a }
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x026a }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x026a }
            r0.<init>(r4, r5)     // Catch:{ Exception -> 0x026a }
            r4 = r0
            r5 = r29
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r3.setOnlyIncludeVisibleInDownloadsUi(r5)     // Catch:{ Exception -> 0x026a }
            r6 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setOnlyDownloading(r6)     // Catch:{ Exception -> 0x026a }
            r7 = 1
            long[] r8 = new long[r7]     // Catch:{ Exception -> 0x026a }
            r8[r6] = r27     // Catch:{ Exception -> 0x026a }
            r0.setFilterById(r8)     // Catch:{ Exception -> 0x026a }
            java.lang.String[] r0 = PROJECTIONS_FILTER_BY_TYPE     // Catch:{ Exception -> 0x026a }
            android.database.Cursor r0 = r4.query(r3, r0)     // Catch:{ Exception -> 0x026a }
            r1 = r0
            if (r1 == 0) goto L_0x0263
            int r0 = r1.getCount()     // Catch:{ Exception -> 0x026a }
            if (r0 <= 0) goto L_0x0263
            com.baidu.searchbox.download.model.CategoryInfoData r0 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch:{ Exception -> 0x026a }
            r0.<init>()     // Catch:{ Exception -> 0x026a }
            r2 = r0
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x026a }
            r8 = r0
            java.lang.String r0 = "status"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x026a }
            r9 = r0
            java.lang.String r0 = "mimetype"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x026a }
            r10 = r0
            java.lang.String r0 = "total_bytes"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x026a }
            r11 = r0
            java.lang.String r0 = "_data"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x026a }
            r12 = r0
            java.lang.String r0 = "title"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x026a }
            r13 = r0
            java.lang.String r0 = "lastmod"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x026a }
            r14 = r0
            java.lang.String r0 = "extra_info"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x026a }
            r15 = r0
            java.lang.String r0 = "uri"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x026a }
            r16 = r0
            java.lang.String r0 = "deleted"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x026a }
            r17 = r0
            java.lang.String r0 = "business_type"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x026a }
            r18 = r0
            java.lang.String r0 = "netdisk_upload_info"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x026a }
            r19 = r0
            java.lang.String r0 = "bytes_so_far"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x026a }
            r20 = r0
            r1.moveToFirst()     // Catch:{ Exception -> 0x026a }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x026a }
            r0.<init>()     // Catch:{ Exception -> 0x026a }
            r21 = r0
            java.lang.String r0 = r1.getString(r10)     // Catch:{ Exception -> 0x026a }
            r22 = r0
            java.lang.String r0 = r1.getString(r13)     // Catch:{ Exception -> 0x026a }
            r23 = r0
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r23)     // Catch:{ Exception -> 0x026a }
            r6 = r22
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r6)     // Catch:{ Exception -> 0x026a }
            r22 = r0
            r24 = r3
            r25 = r4
            long r3 = r1.getLong(r8)     // Catch:{ Exception -> 0x026a }
            r2.mId = r3     // Catch:{ Exception -> 0x026a }
            r2.mMimeType = r6     // Catch:{ Exception -> 0x026a }
            r3 = r22
            r22 = r8
            long r7 = (long) r3     // Catch:{ Exception -> 0x026a }
            r2.mType = r7     // Catch:{ Exception -> 0x026a }
            r7 = r18
            int r0 = r1.getInt(r7)     // Catch:{ Exception -> 0x026a }
            r2.mBusinessType = r0     // Catch:{ Exception -> 0x026a }
            r0 = 6
            java.lang.String r8 = ""
            if (r0 != r3) goto L_0x019f
            r18 = 0
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x018b, all -> 0x0187 }
            long r4 = r2.mId     // Catch:{ Exception -> 0x018b, all -> 0x0187 }
            android.database.Cursor r0 = r0.getSearchboxDownloadCursor(r4)     // Catch:{ Exception -> 0x018b, all -> 0x0187 }
            r4 = r0
            if (r4 == 0) goto L_0x0173
            boolean r0 = r4.moveToFirst()     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            if (r0 == 0) goto L_0x0173
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewprogress     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            float r0 = r4.getFloat(r0)     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            r2.mStoryViewProgress = r0     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewposition     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            r2.mStoryPosition = r0     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.gid     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x016d, all -> 0x0167 }
            r26 = r6
            long r5 = r4.getLong(r0)     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            r2.mGid = r5     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booksrc     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            r2.mBookDirectoryUrl = r0     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booktype     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            int r0 = r4.getInt(r0)     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            r2.mBookType = r0     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.bookfree     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            int r0 = r4.getColumnIndex(r0)     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            r2.mFree = r0     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            goto L_0x017b
        L_0x0167:
            r0 = move-exception
            r26 = r6
            r18 = r4
            goto L_0x019a
        L_0x016d:
            r0 = move-exception
            r26 = r6
            r18 = r4
            goto L_0x018e
        L_0x0173:
            r26 = r6
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2.mStoryViewProgress = r0     // Catch:{ Exception -> 0x0183, all -> 0x017f }
            r2.mStoryPosition = r8     // Catch:{ Exception -> 0x0183, all -> 0x017f }
        L_0x017b:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r4)     // Catch:{ Exception -> 0x026a }
            goto L_0x01bd
        L_0x017f:
            r0 = move-exception
            r18 = r4
            goto L_0x019a
        L_0x0183:
            r0 = move-exception
            r18 = r4
            goto L_0x018e
        L_0x0187:
            r0 = move-exception
            r26 = r6
            goto L_0x019a
        L_0x018b:
            r0 = move-exception
            r26 = r6
        L_0x018e:
            boolean r4 = DEBUG     // Catch:{ all -> 0x0199 }
            if (r4 == 0) goto L_0x0195
            r0.printStackTrace()     // Catch:{ all -> 0x0199 }
        L_0x0195:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r18)     // Catch:{ Exception -> 0x026a }
            goto L_0x01bd
        L_0x0199:
            r0 = move-exception
        L_0x019a:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r18)     // Catch:{ Exception -> 0x026a }
            throw r0     // Catch:{ Exception -> 0x026a }
        L_0x019f:
            r26 = r6
            r0 = 3
            if (r3 != r0) goto L_0x01bd
            java.lang.String r0 = r1.getString(r15)     // Catch:{ Exception -> 0x026a }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x026a }
            if (r4 != 0) goto L_0x01be
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x026a }
            r4.<init>(r0)     // Catch:{ Exception -> 0x026a }
            java.lang.String r5 = "icon"
            java.lang.String r5 = r4.optString(r5, r8)     // Catch:{ Exception -> 0x026a }
            r2.mAppIcon = r5     // Catch:{ Exception -> 0x026a }
            goto L_0x01be
        L_0x01bd:
        L_0x01be:
            int r0 = r2.mBusinessType     // Catch:{ Exception -> 0x026a }
            if (r0 == 0) goto L_0x01ce
            java.lang.String r0 = "business_id"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x026a }
            java.lang.String r4 = r1.getString(r0)     // Catch:{ Exception -> 0x026a }
            r2.businessId = r4     // Catch:{ Exception -> 0x026a }
        L_0x01ce:
            long r4 = r1.getLong(r11)     // Catch:{ Exception -> 0x026a }
            r2.mSize = r4     // Catch:{ Exception -> 0x026a }
            java.lang.String r0 = r1.getString(r12)     // Catch:{ Exception -> 0x026a }
            r2.mDownloadPath = r0     // Catch:{ Exception -> 0x026a }
            r4 = r23
            r2.mFileName = r4     // Catch:{ Exception -> 0x026a }
            long r5 = r1.getLong(r14)     // Catch:{ Exception -> 0x026a }
            r2.mCompletionTime = r5     // Catch:{ Exception -> 0x026a }
            java.lang.String r0 = r1.getString(r15)     // Catch:{ Exception -> 0x026a }
            r2.mExtraInfo = r0     // Catch:{ Exception -> 0x026a }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch:{ Exception -> 0x026a }
            r0.<init>()     // Catch:{ Exception -> 0x026a }
            r2.mDownloadingInfo = r0     // Catch:{ Exception -> 0x026a }
            r5 = r16
            java.lang.String r0 = r1.getString(r5)     // Catch:{ Exception -> 0x026a }
            r6 = r0
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch:{ Exception -> 0x026a }
            r0.mUrl = r6     // Catch:{ Exception -> 0x026a }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch:{ Exception -> 0x026a }
            int r8 = r1.getInt(r9)     // Catch:{ Exception -> 0x026a }
            r0.mStatus = r8     // Catch:{ Exception -> 0x026a }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r2.mDownloadingInfo     // Catch:{ Exception -> 0x026a }
            r16 = r3
            r18 = r4
            r8 = r20
            long r3 = r1.getLong(r8)     // Catch:{ Exception -> 0x026a }
            r0.mCurrentSize = r3     // Catch:{ Exception -> 0x026a }
            r3 = r17
            int r0 = r1.getInt(r3)     // Catch:{ Exception -> 0x026a }
            r4 = 1
            if (r0 != r4) goto L_0x021d
            r0 = r4
            goto L_0x021e
        L_0x021d:
            r0 = 0
        L_0x021e:
            r2.mIsDeleted = r0     // Catch:{ Exception -> 0x026a }
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x026a }
            r17 = r5
            long r4 = r2.mId     // Catch:{ Exception -> 0x026a }
            boolean r0 = r0.isRead(r4)     // Catch:{ Exception -> 0x026a }
            if (r0 != 0) goto L_0x0230
            r0 = 1
            goto L_0x0231
        L_0x0230:
            r0 = 0
        L_0x0231:
            r2.newFlag = r0     // Catch:{ Exception -> 0x026a }
            r4 = r19
            java.lang.String r0 = r1.getString(r4)     // Catch:{ Exception -> 0x026a }
            r5 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x026a }
            if (r0 != 0) goto L_0x025e
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r0 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r19 = r3
            r3 = r21
            java.lang.Object r0 = r3.fromJson((java.lang.String) r5, r0)     // Catch:{ JsonSyntaxException -> 0x024f }
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch:{ JsonSyntaxException -> 0x024f }
            r2.mNetdiskUploadInfo = r0     // Catch:{ JsonSyntaxException -> 0x024f }
            goto L_0x0272
        L_0x024f:
            r0 = move-exception
            goto L_0x0256
        L_0x0251:
            r0 = move-exception
            r19 = r3
            r3 = r21
        L_0x0256:
            boolean r20 = DEBUG     // Catch:{ Exception -> 0x026a }
            if (r20 == 0) goto L_0x0272
            r0.printStackTrace()     // Catch:{ Exception -> 0x026a }
            goto L_0x0272
        L_0x025e:
            r19 = r3
            r3 = r21
            goto L_0x0272
        L_0x0263:
            r24 = r3
            r25 = r4
            goto L_0x0272
        L_0x0268:
            r0 = move-exception
            goto L_0x0277
        L_0x026a:
            r0 = move-exception
            boolean r3 = DEBUG     // Catch:{ all -> 0x0268 }
            if (r3 == 0) goto L_0x0272
            r0.printStackTrace()     // Catch:{ all -> 0x0268 }
        L_0x0272:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r1)
            return r2
        L_0x0277:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloadItem(long, boolean):com.baidu.searchbox.download.model.CategoryInfoData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a2 A[Catch:{ all -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01d5 A[Catch:{ Exception -> 0x02a8, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0234 A[Catch:{ Exception -> 0x02a8, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0236 A[Catch:{ Exception -> 0x02a8, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0247 A[Catch:{ Exception -> 0x02a8, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0249 A[Catch:{ Exception -> 0x02a8, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0277 A[Catch:{ Exception -> 0x02a8, all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0286 A[LOOP:0: B:7:0x00b3->B:82:0x0286, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02b0 A[EDGE_INSN: B:94:0x02b0->B:90:0x02b0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.baidu.searchbox.download.model.CategoryInfoData> queryDownloadItemListByIds(long[] r27, boolean r28) {
        /*
            r1 = 0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = r0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch:{ Exception -> 0x02a8 }
            r0.<init>()     // Catch:{ Exception -> 0x02a8 }
            r3 = r0
            com.baidu.searchbox.download.manager.DownloadManager r0 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x02a8 }
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x02a8 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x02a8 }
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x02a8 }
            r0.<init>(r4, r5)     // Catch:{ Exception -> 0x02a8 }
            r4 = r0
            r5 = r28
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r3.setOnlyIncludeVisibleInDownloadsUi(r5)     // Catch:{ Exception -> 0x02a8 }
            r6 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = r0.setOnlyDownloading(r6)     // Catch:{ Exception -> 0x02a8 }
            r7 = r27
            r0.setFilterById(r7)     // Catch:{ Exception -> 0x02a8 }
            java.lang.String[] r0 = PROJECTIONS_FILTER_BY_TYPE     // Catch:{ Exception -> 0x02a8 }
            android.database.Cursor r0 = r4.query(r3, r0)     // Catch:{ Exception -> 0x02a8 }
            r1 = r0
            if (r1 == 0) goto L_0x02a1
            int r0 = r1.getCount()     // Catch:{ Exception -> 0x02a8 }
            if (r0 <= 0) goto L_0x02a1
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x02a8 }
            r8 = r0
            java.lang.String r0 = "status"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x02a8 }
            r9 = r0
            java.lang.String r0 = "mimetype"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x02a8 }
            r10 = r0
            java.lang.String r0 = "total_bytes"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x02a8 }
            r11 = r0
            java.lang.String r0 = "_data"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x02a8 }
            r12 = r0
            java.lang.String r0 = "title"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x02a8 }
            r13 = r0
            java.lang.String r0 = "lastmod"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x02a8 }
            r14 = r0
            java.lang.String r0 = "extra_info"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x02a8 }
            r15 = r0
            java.lang.String r0 = "uri"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x02a8 }
            r16 = r0
            java.lang.String r0 = "deleted"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x02a8 }
            r17 = r0
            java.lang.String r0 = "business_type"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x02a8 }
            r18 = r0
            java.lang.String r0 = "netdisk_upload_info"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x02a8 }
            r19 = r0
            java.lang.String r0 = "bytes_so_far"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x02a8 }
            r20 = r0
            r1.moveToFirst()     // Catch:{ Exception -> 0x02a8 }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x02a8 }
            r0.<init>()     // Catch:{ Exception -> 0x02a8 }
            r21 = r0
        L_0x00b3:
            com.baidu.searchbox.download.model.CategoryInfoData r0 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch:{ Exception -> 0x02a8 }
            r0.<init>()     // Catch:{ Exception -> 0x02a8 }
            r22 = r0
            java.lang.String r0 = r1.getString(r10)     // Catch:{ Exception -> 0x02a8 }
            r23 = r0
            java.lang.String r0 = r1.getString(r13)     // Catch:{ Exception -> 0x02a8 }
            r24 = r0
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r24)     // Catch:{ Exception -> 0x02a8 }
            r6 = r23
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r6)     // Catch:{ Exception -> 0x02a8 }
            r23 = r0
            r25 = r3
            r26 = r4
            long r3 = r1.getLong(r8)     // Catch:{ Exception -> 0x02a8 }
            r5 = r22
            r5.mId = r3     // Catch:{ Exception -> 0x02a8 }
            r5.mMimeType = r6     // Catch:{ Exception -> 0x02a8 }
            r4 = r6
            r3 = r23
            long r6 = (long) r3     // Catch:{ Exception -> 0x02a8 }
            r5.mType = r6     // Catch:{ Exception -> 0x02a8 }
            r6 = r18
            int r0 = r1.getInt(r6)     // Catch:{ Exception -> 0x02a8 }
            r5.mBusinessType = r0     // Catch:{ Exception -> 0x02a8 }
            r0 = 6
            java.lang.String r7 = ""
            if (r0 != r3) goto L_0x01af
            r18 = 0
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x0198, all -> 0x0191 }
            r22 = r8
            r23 = r9
            long r8 = r5.mId     // Catch:{ Exception -> 0x018e, all -> 0x018b }
            android.database.Cursor r0 = r0.getSearchboxDownloadCursor(r8)     // Catch:{ Exception -> 0x018e, all -> 0x018b }
            r8 = r0
            if (r8 == 0) goto L_0x0178
            boolean r0 = r8.moveToFirst()     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            if (r0 == 0) goto L_0x0178
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewprogress     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            float r0 = r8.getFloat(r0)     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            r5.mStoryViewProgress = r0     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.viewposition     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            r5.mStoryPosition = r0     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.gid     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0173, all -> 0x016e }
            r9 = r6
            long r6 = r8.getLong(r0)     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            r5.mGid = r6     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booksrc     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            r5.mBookDirectoryUrl = r0     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.booktype     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            int r0 = r8.getInt(r0)     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            r5.mBookType = r0     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            com.baidu.searchbox.download.table.SearchBoxDownloadTable r0 = com.baidu.searchbox.download.table.SearchBoxDownloadTable.bookfree     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            r5.mFree = r0     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            goto L_0x017f
        L_0x016e:
            r0 = move-exception
            r9 = r6
            r18 = r8
            goto L_0x01aa
        L_0x0173:
            r0 = move-exception
            r9 = r6
            r18 = r8
            goto L_0x019e
        L_0x0178:
            r9 = r6
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5.mStoryViewProgress = r0     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
            r5.mStoryPosition = r7     // Catch:{ Exception -> 0x0187, all -> 0x0183 }
        L_0x017f:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r8)     // Catch:{ Exception -> 0x02a8 }
            goto L_0x01d0
        L_0x0183:
            r0 = move-exception
            r18 = r8
            goto L_0x01aa
        L_0x0187:
            r0 = move-exception
            r18 = r8
            goto L_0x019e
        L_0x018b:
            r0 = move-exception
            r9 = r6
            goto L_0x01aa
        L_0x018e:
            r0 = move-exception
            r9 = r6
            goto L_0x019e
        L_0x0191:
            r0 = move-exception
            r22 = r8
            r23 = r9
            r9 = r6
            goto L_0x01aa
        L_0x0198:
            r0 = move-exception
            r22 = r8
            r23 = r9
            r9 = r6
        L_0x019e:
            boolean r6 = DEBUG     // Catch:{ all -> 0x01a9 }
            if (r6 == 0) goto L_0x01a5
            r0.printStackTrace()     // Catch:{ all -> 0x01a9 }
        L_0x01a5:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r18)     // Catch:{ Exception -> 0x02a8 }
            goto L_0x01d0
        L_0x01a9:
            r0 = move-exception
        L_0x01aa:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r18)     // Catch:{ Exception -> 0x02a8 }
            throw r0     // Catch:{ Exception -> 0x02a8 }
        L_0x01af:
            r22 = r8
            r23 = r9
            r9 = r6
            r0 = 3
            if (r3 != r0) goto L_0x01d0
            java.lang.String r0 = r1.getString(r15)     // Catch:{ Exception -> 0x02a8 }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02a8 }
            if (r6 != 0) goto L_0x01d1
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x02a8 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r8 = "icon"
            java.lang.String r7 = r6.optString(r8, r7)     // Catch:{ Exception -> 0x02a8 }
            r5.mAppIcon = r7     // Catch:{ Exception -> 0x02a8 }
            goto L_0x01d1
        L_0x01d0:
        L_0x01d1:
            int r0 = r5.mBusinessType     // Catch:{ Exception -> 0x02a8 }
            if (r0 == 0) goto L_0x01e1
            java.lang.String r0 = "business_id"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r6 = r1.getString(r0)     // Catch:{ Exception -> 0x02a8 }
            r5.businessId = r6     // Catch:{ Exception -> 0x02a8 }
        L_0x01e1:
            long r6 = r1.getLong(r11)     // Catch:{ Exception -> 0x02a8 }
            r5.mSize = r6     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r0 = r1.getString(r12)     // Catch:{ Exception -> 0x02a8 }
            r5.mDownloadPath = r0     // Catch:{ Exception -> 0x02a8 }
            r6 = r24
            r5.mFileName = r6     // Catch:{ Exception -> 0x02a8 }
            long r7 = r1.getLong(r14)     // Catch:{ Exception -> 0x02a8 }
            r5.mCompletionTime = r7     // Catch:{ Exception -> 0x02a8 }
            java.lang.String r0 = r1.getString(r15)     // Catch:{ Exception -> 0x02a8 }
            r5.mExtraInfo = r0     // Catch:{ Exception -> 0x02a8 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch:{ Exception -> 0x02a8 }
            r0.<init>()     // Catch:{ Exception -> 0x02a8 }
            r5.mDownloadingInfo = r0     // Catch:{ Exception -> 0x02a8 }
            r7 = r16
            java.lang.String r0 = r1.getString(r7)     // Catch:{ Exception -> 0x02a8 }
            r8 = r0
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r5.mDownloadingInfo     // Catch:{ Exception -> 0x02a8 }
            r0.mUrl = r8     // Catch:{ Exception -> 0x02a8 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r5.mDownloadingInfo     // Catch:{ Exception -> 0x02a8 }
            r16 = r3
            r18 = r4
            r3 = r23
            int r4 = r1.getInt(r3)     // Catch:{ Exception -> 0x02a8 }
            r0.mStatus = r4     // Catch:{ Exception -> 0x02a8 }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r5.mDownloadingInfo     // Catch:{ Exception -> 0x02a8 }
            r23 = r7
            r4 = r20
            r20 = r6
            long r6 = r1.getLong(r4)     // Catch:{ Exception -> 0x02a8 }
            r0.mCurrentSize = r6     // Catch:{ Exception -> 0x02a8 }
            r6 = r17
            int r0 = r1.getInt(r6)     // Catch:{ Exception -> 0x02a8 }
            r7 = 1
            if (r0 != r7) goto L_0x0236
            r0 = r7
            goto L_0x0237
        L_0x0236:
            r0 = 0
        L_0x0237:
            r5.mIsDeleted = r0     // Catch:{ Exception -> 0x02a8 }
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x02a8 }
            r17 = r8
            long r7 = r5.mId     // Catch:{ Exception -> 0x02a8 }
            boolean r0 = r0.isRead(r7)     // Catch:{ Exception -> 0x02a8 }
            if (r0 != 0) goto L_0x0249
            r7 = 1
            goto L_0x024a
        L_0x0249:
            r7 = 0
        L_0x024a:
            r5.newFlag = r7     // Catch:{ Exception -> 0x02a8 }
            r7 = r19
            java.lang.String r0 = r1.getString(r7)     // Catch:{ Exception -> 0x02a8 }
            r8 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x02a8 }
            if (r0 != 0) goto L_0x0277
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r0 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r19 = r3
            r3 = r21
            java.lang.Object r0 = r3.fromJson((java.lang.String) r8, r0)     // Catch:{ JsonSyntaxException -> 0x0268 }
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch:{ JsonSyntaxException -> 0x0268 }
            r5.mNetdiskUploadInfo = r0     // Catch:{ JsonSyntaxException -> 0x0268 }
            goto L_0x027b
        L_0x0268:
            r0 = move-exception
            goto L_0x026f
        L_0x026a:
            r0 = move-exception
            r19 = r3
            r3 = r21
        L_0x026f:
            boolean r21 = DEBUG     // Catch:{ Exception -> 0x02a8 }
            if (r21 == 0) goto L_0x027b
            r0.printStackTrace()     // Catch:{ Exception -> 0x02a8 }
            goto L_0x027b
        L_0x0277:
            r19 = r3
            r3 = r21
        L_0x027b:
            r2.add(r5)     // Catch:{ Exception -> 0x02a8 }
            boolean r0 = r1.moveToNext()     // Catch:{ Exception -> 0x02a8 }
            if (r0 != 0) goto L_0x0286
            goto L_0x02b0
        L_0x0286:
            r5 = r28
            r21 = r3
            r20 = r4
            r17 = r6
            r18 = r9
            r9 = r19
            r8 = r22
            r16 = r23
            r3 = r25
            r4 = r26
            r6 = 0
            r19 = r7
            r7 = r27
            goto L_0x00b3
        L_0x02a1:
            r25 = r3
            r26 = r4
            goto L_0x02b0
        L_0x02a6:
            r0 = move-exception
            goto L_0x02b5
        L_0x02a8:
            r0 = move-exception
            boolean r3 = DEBUG     // Catch:{ all -> 0x02a6 }
            if (r3 == 0) goto L_0x02b0
            r0.printStackTrace()     // Catch:{ all -> 0x02a6 }
        L_0x02b0:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r1)
            return r2
        L_0x02b5:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloadItemListByIds(long[], boolean):java.util.List");
    }

    public static List<CategoryInfoData> queryHasOpenDatas(boolean hasStoragePermission, int limit) {
        return queryHasOpenDatas(hasStoragePermission, limit, (ArrayList<String>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x036a A[Catch:{ all -> 0x0372 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.baidu.searchbox.download.model.CategoryInfoData> queryHasOpenDatas(boolean r39, int r40, java.util.ArrayList<java.lang.String> r41) {
        /*
            java.lang.String r0 = "time_open"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 1
            java.lang.String r3 = " AND time_open > 0"
            r4 = 0
            r5 = 1
            if (r41 == 0) goto L_0x0074
            boolean r6 = r41.isEmpty()
            if (r6 != 0) goto L_0x0074
            r2 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.util.Iterator r7 = r41.iterator()
        L_0x001f:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x003b
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = "'"
            java.lang.StringBuilder r9 = r6.append(r9)
            java.lang.StringBuilder r9 = r9.append(r8)
            java.lang.String r10 = "',"
            r9.append(r10)
            goto L_0x001f
        L_0x003b:
            int r7 = r6.length()
            int r7 = r7 - r5
            java.lang.String r7 = r6.substring(r4, r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r8 = r8.append(r3)
            java.lang.String r9 = " AND ( is_visible_in_downloads_ui != '0' "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r3 = r8.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r8 = r8.append(r3)
            java.lang.String r9 = " OR source IN ("
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r7)
            java.lang.String r9 = "))"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r3 = r8.toString()
        L_0x0074:
            if (r39 != 0) goto L_0x008b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r3)
            java.lang.String r7 = getFilterPrivateFileSql()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r3 = r6.toString()
        L_0x008b:
            r6 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r7 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            r7.<init>()     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            com.baidu.searchbox.download.manager.DownloadManager r8 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            android.content.Context r9 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            android.content.Context r10 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            r8.<init>(r9, r10)     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            com.baidu.searchbox.download.manager.DownloadManager$Query r9 = r7.setOnlyIncludeVisibleInDownloadsUi(r2)     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            com.baidu.searchbox.download.manager.DownloadManager$Query r9 = r9.setOnlyDownloading(r4)     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            r10 = 8
            com.baidu.searchbox.download.manager.DownloadManager$Query r9 = r9.setFilterByStatus(r10)     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            com.baidu.searchbox.download.manager.DownloadManager$Query r9 = r9.setFilterBySelection(r3)     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            com.baidu.searchbox.download.manager.DownloadManager$Query r9 = r9.showDeleted(r5)     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            r10 = 2
            com.baidu.searchbox.download.manager.DownloadManager$Query r9 = r9.orderBy(r0, r10)     // Catch:{ Exception -> 0x035c, all -> 0x0353 }
            r11 = r40
            r9.setLimit(r11)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String[] r9 = PROJECTIONS_FILTER_BY_TYPE     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            android.database.Cursor r9 = r8.query(r7, r9)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            r6 = r9
            if (r6 == 0) goto L_0x0345
            int r9 = r6.getCount()     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            if (r9 <= 0) goto L_0x0345
            java.lang.String r9 = "_id"
            int r9 = r6.getColumnIndex(r9)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String r12 = "status"
            int r12 = r6.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String r13 = "mimetype"
            int r13 = r6.getColumnIndex(r13)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String r14 = "total_bytes"
            int r14 = r6.getColumnIndex(r14)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String r15 = "_data"
            int r15 = r6.getColumnIndex(r15)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String r4 = "title"
            int r4 = r6.getColumnIndex(r4)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String r10 = "lastmod"
            int r10 = r6.getColumnIndex(r10)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            java.lang.String r5 = "extra_info"
            int r5 = r6.getColumnIndex(r5)     // Catch:{ Exception -> 0x0351, all -> 0x034f }
            r16 = r2
            java.lang.String r2 = "uri"
            int r2 = r6.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x0340, all -> 0x033b }
            r17 = r3
            java.lang.String r3 = "deleted"
            int r3 = r6.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            int r0 = r6.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r18 = r0
            java.lang.String r0 = "netdisk_upload_info"
            int r0 = r6.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r19 = r0
            java.lang.String r0 = "open_read"
            int r0 = r6.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r20 = r0
            java.lang.String r0 = "bytes_so_far"
            int r0 = r6.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r21 = r0
            java.lang.String r0 = "source"
            int r0 = r6.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r22 = r0
            java.lang.String r0 = "business_type"
            int r0 = r6.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r23 = r0
            r6.moveToFirst()     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r0.<init>()     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r24 = r0
        L_0x0156:
            java.lang.String r0 = r6.getString(r13)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r25 = r0
            java.lang.String r0 = r6.getString(r4)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r26 = r0
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r26)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r27 = r4
            r4 = r25
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r4)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r25 = r0
            com.baidu.searchbox.download.model.CategoryInfoData r0 = new com.baidu.searchbox.download.model.CategoryInfoData     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r0.<init>()     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r28 = r0
            r29 = r7
            r30 = r8
            long r7 = r6.getLong(r9)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r31 = r9
            r9 = r28
            r9.mId = r7     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            java.lang.String r7 = ""
            if (r0 == 0) goto L_0x018f
            r0 = r7
            goto L_0x0190
        L_0x018f:
            r0 = r4
        L_0x0190:
            r9.mMimeType = r0     // Catch:{ Exception -> 0x0338, all -> 0x0335 }
            r8 = r25
            r25 = r1
            long r0 = (long) r8
            r9.mType = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            long r0 = r6.getLong(r14)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mSize = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            java.lang.String r0 = r6.getString(r15)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mDownloadPath = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r1 = r26
            r9.mFileName = r1     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r26 = r13
            r28 = r14
            long r13 = r6.getLong(r10)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mCompletionTime = r13     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            java.lang.String r0 = r6.getString(r5)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r13 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            if (r0 == 0) goto L_0x01c0
            r0 = r7
            goto L_0x01c1
        L_0x01c0:
            r0 = r13
        L_0x01c1:
            r9.mExtraInfo = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = new com.baidu.searchbox.download.model.DownloadingInfo     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r0.<init>()     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mDownloadingInfo = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            java.lang.String r0 = r6.getString(r2)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r14 = r0
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r9.mDownloadingInfo     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r0.mUrl = r14     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r32 = r2
            r2 = r21
            long r33 = r6.getLong(r2)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r35 = r33
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r9.mDownloadingInfo     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r33 = r4
            r21 = r5
            r4 = r35
            r0.mCurrentSize = r4     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            com.baidu.searchbox.download.model.DownloadingInfo r0 = r9.mDownloadingInfo     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r34 = r2
            int r2 = r6.getInt(r12)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r0.mStatus = r2     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            int r0 = r6.getInt(r3)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r2 = 1
            if (r0 != r2) goto L_0x01fa
            r0 = 1
            goto L_0x01fb
        L_0x01fa:
            r0 = 0
        L_0x01fb:
            r9.mIsDeleted = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            com.baidu.searchbox.download.ioc.IDownloadApp r0 = com.baidu.searchbox.download.ioc.IDownloadApp.Impl.get()     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r35 = r3
            long r2 = r9.mId     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            boolean r0 = r0.isRead(r2)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            if (r0 != 0) goto L_0x020d
            r0 = 1
            goto L_0x020e
        L_0x020d:
            r0 = 0
        L_0x020e:
            r9.newFlag = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r36 = r4
            r2 = r18
            long r3 = r6.getLong(r2)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mOpenTime = r3     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r3 = r20
            int r0 = r6.getInt(r3)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r4 = 1
            if (r0 != r4) goto L_0x0225
            r0 = 1
            goto L_0x0226
        L_0x0225:
            r0 = 0
        L_0x0226:
            r9.mOpenRead = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r4 = r22
            java.lang.String r0 = r6.getString(r4)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mSource = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r5 = r23
            int r0 = r6.getInt(r5)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mBusinessType = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r18 = r2
            r2 = r19
            java.lang.String r0 = r6.getString(r2)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r19 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            if (r0 != 0) goto L_0x027c
            java.lang.Class<com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo> r0 = com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo.class
            r20 = r2
            r2 = r24
            r38 = r19
            r19 = r3
            r3 = r38
            java.lang.Object r0 = r2.fromJson((java.lang.String) r3, r0)     // Catch:{ JsonSyntaxException -> 0x025d }
            com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo r0 = (com.baidu.searchbox.boxdownload.model.NetdiskUploadInfo) r0     // Catch:{ JsonSyntaxException -> 0x025d }
            r9.mNetdiskUploadInfo = r0     // Catch:{ JsonSyntaxException -> 0x025d }
            goto L_0x0286
        L_0x025d:
            r0 = move-exception
            goto L_0x0274
        L_0x025f:
            r0 = move-exception
            r3 = r25
            goto L_0x0373
        L_0x0264:
            r0 = move-exception
            r3 = r25
            goto L_0x0364
        L_0x0269:
            r0 = move-exception
            r20 = r2
            r2 = r24
            r38 = r19
            r19 = r3
            r3 = r38
        L_0x0274:
            boolean r22 = DEBUG     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            if (r22 == 0) goto L_0x0286
            r0.printStackTrace()     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            goto L_0x0286
        L_0x027c:
            r20 = r2
            r2 = r24
            r38 = r19
            r19 = r3
            r3 = r38
        L_0x0286:
            r0 = 3
            if (r8 != r0) goto L_0x02af
            java.lang.String r0 = r9.mExtraInfo     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            if (r0 != 0) goto L_0x02a8
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r22 = r2
            java.lang.String r2 = r9.mExtraInfo     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r2 = "icon"
            java.lang.String r2 = r0.optString(r2, r7)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r9.mAppIcon = r2     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r23 = r3
            r7 = r4
            r2 = 2
            goto L_0x02fa
        L_0x02a8:
            r22 = r2
            r23 = r3
            r7 = r4
            r2 = 2
            goto L_0x02fa
        L_0x02af:
            r22 = r2
            java.lang.String r0 = "m3u8"
            java.lang.String r2 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r1)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            if (r0 == 0) goto L_0x02ee
            r2 = 1
            r9.mIsM3U8 = r2     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r0 = r9.mExtraInfo     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            if (r0 != 0) goto L_0x02e9
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r2 = r9.mExtraInfo     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r2 = "poster"
            java.lang.String r2 = r0.optString(r2, r7)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r9.mPoster = r2     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            java.lang.String r2 = "play_progress"
            r23 = r3
            r7 = r4
            r3 = 0
            double r2 = r0.optDouble(r2, r3)     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r9.mPlayProgress = r2     // Catch:{ Exception -> 0x0264, all -> 0x025f }
            r2 = 2
            goto L_0x02fa
        L_0x02e9:
            r23 = r3
            r7 = r4
            r2 = 2
            goto L_0x02fa
        L_0x02ee:
            r23 = r3
            r7 = r4
            r2 = 2
            if (r8 == r2) goto L_0x02f6
            if (r8 != 0) goto L_0x02fa
        L_0x02f6:
            java.lang.String r0 = r9.mDownloadPath     // Catch:{ Exception -> 0x0331, all -> 0x032d }
            r9.mAppIcon = r0     // Catch:{ Exception -> 0x0331, all -> 0x032d }
        L_0x02fa:
            r3 = r25
            r3.add(r9)     // Catch:{ Exception -> 0x032b }
            boolean r0 = r6.moveToNext()     // Catch:{ Exception -> 0x032b }
            if (r0 != 0) goto L_0x0308
            goto L_0x036d
        L_0x0308:
            r1 = r3
            r23 = r5
            r5 = r21
            r24 = r22
            r13 = r26
            r4 = r27
            r14 = r28
            r8 = r30
            r9 = r31
            r2 = r32
            r21 = r34
            r3 = r35
            r22 = r7
            r7 = r29
            r38 = r20
            r20 = r19
            r19 = r38
            goto L_0x0156
        L_0x032b:
            r0 = move-exception
            goto L_0x0364
        L_0x032d:
            r0 = move-exception
            r3 = r25
            goto L_0x0373
        L_0x0331:
            r0 = move-exception
            r3 = r25
            goto L_0x0364
        L_0x0335:
            r0 = move-exception
            r3 = r1
            goto L_0x0373
        L_0x0338:
            r0 = move-exception
            r3 = r1
            goto L_0x0364
        L_0x033b:
            r0 = move-exception
            r17 = r3
            r3 = r1
            goto L_0x0373
        L_0x0340:
            r0 = move-exception
            r17 = r3
            r3 = r1
            goto L_0x0364
        L_0x0345:
            r16 = r2
            r17 = r3
            r29 = r7
            r30 = r8
            r3 = r1
            goto L_0x036d
        L_0x034f:
            r0 = move-exception
            goto L_0x0356
        L_0x0351:
            r0 = move-exception
            goto L_0x035f
        L_0x0353:
            r0 = move-exception
            r11 = r40
        L_0x0356:
            r16 = r2
            r17 = r3
            r3 = r1
            goto L_0x0373
        L_0x035c:
            r0 = move-exception
            r11 = r40
        L_0x035f:
            r16 = r2
            r17 = r3
            r3 = r1
        L_0x0364:
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x0372 }
            if (r1 == 0) goto L_0x036d
            r0.printStackTrace()     // Catch:{ all -> 0x0372 }
        L_0x036d:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r6)
            return r3
        L_0x0372:
            r0 = move-exception
        L_0x0373:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryHasOpenDatas(boolean, int, java.util.ArrayList):java.util.List");
    }

    public static long getFileOpenTime(CategoryInfoData item, long defaultTime) {
        if (item == null) {
            return defaultTime;
        }
        String dataExtra = item.mExtraInfo;
        if (TextUtils.isEmpty(dataExtra)) {
            return defaultTime;
        }
        try {
            return new JSONObject(dataExtra).optLong("open_time", defaultTime);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return defaultTime;
        }
    }

    public static void moveDocRecentData(SQLiteDatabase db) {
        String selection;
        ArrayList arrayList = new ArrayList();
        ArrayList<String> mimeTypes = DocClassifyHelper.getMimeTypesByType(DocClassifyHelper.DocCategroy.RECENT);
        StringBuilder mimeTypesBuilder = new StringBuilder();
        Iterator<String> it = mimeTypes.iterator();
        while (it.hasNext()) {
            mimeTypesBuilder.append("'").append(it.next()).append("',");
        }
        String selection2 = ((("mimetype IN (" + mimeTypesBuilder.substring(0, mimeTypesBuilder.length() - 1) + ")") + " AND extra_info IS NOT NULL") + " AND is_visible_in_downloads_ui != '0'") + " AND status = '200'";
        if (!DownloadPermissionHelper.hasSelfDownloadedFileReadPermission()) {
            selection = selection2 + getFilterPrivateFileSql();
        } else {
            selection = selection2;
        }
        String str = "extra_info";
        Cursor cursor = db.query("downloads", new String[]{"_id", "extra_info"}, selection, (String[]) null, (String) null, (String) null, (String) null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    long id = cursor.getLong(cursor.getColumnIndex("_id"));
                    String str2 = str;
                    long openTime = new JSONObject(cursor.getString(cursor.getColumnIndex(str))).optLong("open_time", -1);
                    if (openTime != -1) {
                        CategoryInfoData categoryInfoData = new CategoryInfoData();
                        categoryInfoData.mId = id;
                        categoryInfoData.mOpenTime = openTime;
                        arrayList.add(categoryInfoData);
                    }
                    str = str2;
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Closeables.closeSafely(cursor);
                    throw th2;
                }
            }
        }
        Closeables.closeSafely(cursor);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CategoryInfoData data = (CategoryInfoData) it2.next();
            ContentValues cv = new ContentValues();
            cv.put(Downloads.Impl.COLUMN_OPEN_TIME, Long.valueOf(data.mOpenTime));
            cv.put(Downloads.Impl.COLUMN_OPEN_READ, true);
            db.update("downloads", cv, "_id =  ? ", new String[]{String.valueOf(data.mId)});
        }
        SQLiteDatabase sQLiteDatabase = db;
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x01df A[Catch:{ all -> 0x01e7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem> queryDataForSmartMenu(int r26, int r27) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r0
            java.lang.String r0 = " AND time_open is NULL"
            long r2 = java.lang.System.currentTimeMillis()
            int r4 = r26 * 24
            int r4 = r4 * 60
            int r4 = r4 * 60
            long r4 = (long) r4
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            long r2 = r2 - r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = " AND lastmod >= "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = " AND uri not like '%content://%' AND uri not like '%copy://%'"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r0 = r4.toString()
            boolean r4 = com.baidu.download.DownloadPermissionHelper.hasSelfDownloadedFileReadPermission()
            if (r4 != 0) goto L_0x005e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = getFilterPrivateFileSql()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r0 = r4.toString()
            r4 = r0
            goto L_0x005f
        L_0x005e:
            r4 = r0
        L_0x005f:
            r5 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            r0.<init>()     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            android.content.Context r7 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            com.baidu.searchbox.download.manager.DownloadManager r8 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            r8.<init>(r6, r7)     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            r9 = 1
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r0.setOnlyIncludeVisibleInDownloadsUi(r9)     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            r11 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.setOnlyDownloading(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            r12 = 8
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.setFilterByStatus(r12)     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.setFilterBySelection(r4)     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.showDeleted(r11)     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            java.lang.String r11 = "last_modified_timestamp"
            r13 = 2
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.orderBy(r11, r13)     // Catch:{ Exception -> 0x01d2, all -> 0x01ca }
            r11 = r27
            r10.setLimit(r11)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            java.lang.String[] r10 = SMART_MENU_COLUMNS     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            android.database.Cursor r10 = r8.query(r0, r10)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            r5 = r10
            if (r5 == 0) goto L_0x01b9
            int r10 = r5.getCount()     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            if (r10 <= 0) goto L_0x01b9
            java.lang.String r10 = "_id"
            int r10 = r5.getColumnIndex(r10)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            java.lang.String r14 = "mimetype"
            int r14 = r5.getColumnIndex(r14)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            java.lang.String r15 = "total_bytes"
            int r15 = r5.getColumnIndex(r15)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            java.lang.String r13 = "_data"
            int r13 = r5.getColumnIndex(r13)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            java.lang.String r9 = "title"
            int r9 = r5.getColumnIndex(r9)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            java.lang.String r12 = "lastmod"
            int r12 = r5.getColumnIndex(r12)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            r16 = r0
            java.lang.String r0 = "extra_info"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            r5.moveToFirst()     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
        L_0x00e1:
            java.lang.String r17 = r5.getString(r14)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            r18 = r17
            java.lang.String r17 = r5.getString(r9)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            r19 = r17
            java.lang.String r17 = r5.getString(r13)     // Catch:{ Exception -> 0x01c8, all -> 0x01c6 }
            r20 = r17
            r21 = r2
            java.lang.String r2 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r19)     // Catch:{ Exception -> 0x01b5, all -> 0x01b1 }
            r3 = r18
            int r2 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r2, r3)     // Catch:{ Exception -> 0x01b5, all -> 0x01b1 }
            r17 = r4
            if (r2 == 0) goto L_0x011f
            r4 = 4
            if (r2 == r4) goto L_0x011f
            r4 = 8
            if (r2 == r4) goto L_0x011f
            r4 = 1
            if (r2 == r4) goto L_0x011f
            r4 = 3
            if (r2 == r4) goto L_0x011f
            r4 = 11
            if (r2 == r4) goto L_0x011f
            r25 = r0
            r23 = r6
            r24 = r7
            r20 = r8
            r0 = 2
            goto L_0x019a
        L_0x011f:
            com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem r4 = new com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem     // Catch:{ Exception -> 0x01af }
            r4.<init>()     // Catch:{ Exception -> 0x01af }
            r23 = r6
            r24 = r7
            long r6 = r5.getLong(r10)     // Catch:{ Exception -> 0x01af }
            r4.setId(r6)     // Catch:{ Exception -> 0x01af }
            r4.setType(r2)     // Catch:{ Exception -> 0x01af }
            long r6 = r5.getLong(r15)     // Catch:{ Exception -> 0x01af }
            r4.setSize(r6)     // Catch:{ Exception -> 0x01af }
            r6 = r20
            r4.setPath(r6)     // Catch:{ Exception -> 0x01af }
            r7 = 12
            r20 = r8
            r8 = r19
            java.lang.String r7 = com.baidu.searchbox.download.util.DownloadHelper.getVariableLengthTitleCutOffWithSuffix(r8, r6, r7)     // Catch:{ Exception -> 0x01af }
            r4.setFileName(r7)     // Catch:{ Exception -> 0x01af }
            r19 = r6
            long r6 = r5.getLong(r12)     // Catch:{ Exception -> 0x01af }
            r4.setDownloadTime(r6)     // Catch:{ Exception -> 0x01af }
            java.lang.String r6 = r5.getString(r0)     // Catch:{ Exception -> 0x01af }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01af }
            r25 = r0
            java.lang.String r0 = ""
            if (r7 == 0) goto L_0x0164
            r7 = r0
            goto L_0x0165
        L_0x0164:
            r7 = r6
        L_0x0165:
            r6 = r7
            com.baidu.searchbox.download.util.DownloadHelper.getIconId(r8, r3)     // Catch:{ Exception -> 0x01af }
            r7 = 3
            if (r2 != r7) goto L_0x0189
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01af }
            if (r7 != 0) goto L_0x0185
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x01af }
            r7.<init>(r6)     // Catch:{ Exception -> 0x01af }
            r18 = r3
            java.lang.String r3 = "icon"
            java.lang.String r0 = r7.optString(r3, r0)     // Catch:{ Exception -> 0x01af }
            r4.setIcon(r0)     // Catch:{ Exception -> 0x01af }
            r0 = 2
            goto L_0x0197
        L_0x0185:
            r18 = r3
            r0 = 2
            goto L_0x0197
        L_0x0189:
            r18 = r3
            r0 = 2
            if (r2 == r0) goto L_0x0190
            if (r2 != 0) goto L_0x0197
        L_0x0190:
            java.lang.String r3 = r4.getPath()     // Catch:{ Exception -> 0x01af }
            r4.setIcon(r3)     // Catch:{ Exception -> 0x01af }
        L_0x0197:
            r1.add(r4)     // Catch:{ Exception -> 0x01af }
        L_0x019a:
            boolean r2 = r5.moveToNext()     // Catch:{ Exception -> 0x01af }
            if (r2 != 0) goto L_0x01a1
            goto L_0x01e2
        L_0x01a1:
            r4 = r17
            r8 = r20
            r2 = r21
            r6 = r23
            r7 = r24
            r0 = r25
            goto L_0x00e1
        L_0x01af:
            r0 = move-exception
            goto L_0x01d9
        L_0x01b1:
            r0 = move-exception
            r17 = r4
            goto L_0x01e8
        L_0x01b5:
            r0 = move-exception
            r17 = r4
            goto L_0x01d9
        L_0x01b9:
            r16 = r0
            r21 = r2
            r17 = r4
            r23 = r6
            r24 = r7
            r20 = r8
            goto L_0x01e2
        L_0x01c6:
            r0 = move-exception
            goto L_0x01cd
        L_0x01c8:
            r0 = move-exception
            goto L_0x01d5
        L_0x01ca:
            r0 = move-exception
            r11 = r27
        L_0x01cd:
            r21 = r2
            r17 = r4
            goto L_0x01e8
        L_0x01d2:
            r0 = move-exception
            r11 = r27
        L_0x01d5:
            r21 = r2
            r17 = r4
        L_0x01d9:
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x01e7 }
            if (r2 == 0) goto L_0x01e2
            r0.printStackTrace()     // Catch:{ all -> 0x01e7 }
        L_0x01e2:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r5)
            return r1
        L_0x01e7:
            r0 = move-exception
        L_0x01e8:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDataForSmartMenu(int, int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ff A[Catch:{ all -> 0x0207 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem> queryDownloadedVideoDataForSmartMenu(int r33, int r34) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r0
            long r2 = java.lang.System.currentTimeMillis()
            int r0 = r33 * 24
            int r0 = r0 * 60
            int r0 = r0 * 60
            long r4 = (long) r0
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            long r2 = r2 - r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = " AND lastmod >= "
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = " AND uri not like '%content://%' AND uri not like '%copy://%'"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            r5 = 0
            r6 = 0
            java.lang.String r6 = com.baidu.searchbox.download.util.FileClassifyHelper.getSQliteSelectionByCategory(r5, r6)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r0 = r4.toString()
            boolean r4 = com.baidu.download.DownloadPermissionHelper.hasSelfDownloadedFileReadPermission()
            if (r4 != 0) goto L_0x006f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r6 = getFilterPrivateFileSql()
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r0 = r4.toString()
            r4 = r0
            goto L_0x0070
        L_0x006f:
            r4 = r0
        L_0x0070:
            r6 = 0
            com.baidu.searchbox.download.manager.DownloadManager$Query r0 = new com.baidu.searchbox.download.manager.DownloadManager$Query     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            r0.<init>()     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            android.content.Context r7 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            android.content.Context r8 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            com.baidu.searchbox.download.manager.DownloadManager r9 = new com.baidu.searchbox.download.manager.DownloadManager     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            r9.<init>(r7, r8)     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            r10 = 1
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r0.setOnlyIncludeVisibleInDownloadsUi(r10)     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.setOnlyDownloading(r5)     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            r11 = 8
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.setFilterByStatus(r11)     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            com.baidu.searchbox.download.manager.DownloadManager$Query r10 = r10.setFilterBySelection(r4)     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            com.baidu.searchbox.download.manager.DownloadManager$Query r5 = r10.showDeleted(r5)     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            java.lang.String r10 = "last_modified_timestamp"
            r11 = 2
            com.baidu.searchbox.download.manager.DownloadManager$Query r5 = r5.orderBy(r10, r11)     // Catch:{ Exception -> 0x01f2, all -> 0x01ea }
            r10 = r34
            r5.setLimit(r10)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            java.lang.String[] r5 = SMART_MENU_COLUMNS     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            android.database.Cursor r5 = r9.query(r0, r5)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            r6 = r5
            if (r6 == 0) goto L_0x01db
            int r5 = r6.getCount()     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            if (r5 <= 0) goto L_0x01db
            java.lang.String r5 = "_id"
            int r5 = r6.getColumnIndex(r5)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            java.lang.String r11 = "mimetype"
            int r11 = r6.getColumnIndex(r11)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            java.lang.String r12 = "total_bytes"
            int r12 = r6.getColumnIndex(r12)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            java.lang.String r13 = "_data"
            int r13 = r6.getColumnIndex(r13)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            java.lang.String r14 = "title"
            int r14 = r6.getColumnIndex(r14)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            java.lang.String r15 = "lastmod"
            int r15 = r6.getColumnIndex(r15)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            r16 = r0
            java.lang.String r0 = "extra_info"
            int r0 = r6.getColumnIndex(r0)     // Catch:{ Exception -> 0x01e8, all -> 0x01e6 }
            r17 = r2
            java.lang.String r2 = "progress"
            int r2 = r6.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            java.lang.String r3 = "uri"
            int r3 = r6.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r19 = r2
            java.lang.String r2 = "time_open"
            int r2 = r6.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r6.moveToFirst()     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
        L_0x010a:
            java.lang.String r20 = r6.getString(r11)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r21 = r20
            java.lang.String r20 = r6.getString(r14)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r22 = r20
            java.lang.String r20 = r6.getString(r13)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r23 = r20
            r20 = r4
            java.lang.String r4 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r22)     // Catch:{ Exception -> 0x01d1 }
            r24 = r7
            r7 = r21
            int r4 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r4, r7)     // Catch:{ Exception -> 0x01d1 }
            com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem r21 = new com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem     // Catch:{ Exception -> 0x01d1 }
            r21.<init>()     // Catch:{ Exception -> 0x01d1 }
            r25 = r21
            r26 = r7
            r21 = r8
            long r7 = r6.getLong(r5)     // Catch:{ Exception -> 0x01d1 }
            r27 = r5
            r5 = r25
            r5.setId(r7)     // Catch:{ Exception -> 0x01d1 }
            r5.setType(r4)     // Catch:{ Exception -> 0x01d1 }
            long r7 = r6.getLong(r12)     // Catch:{ Exception -> 0x01d1 }
            r5.setSize(r7)     // Catch:{ Exception -> 0x01d1 }
            r7 = r23
            r5.setPath(r7)     // Catch:{ Exception -> 0x01d1 }
            r8 = 12
            r23 = r4
            r4 = r22
            java.lang.String r8 = com.baidu.searchbox.download.util.DownloadHelper.getVariableLengthTitleCutOffWithSuffix(r4, r7, r8)     // Catch:{ Exception -> 0x01d1 }
            r5.setFileName(r8)     // Catch:{ Exception -> 0x01d1 }
            r22 = r7
            long r7 = r6.getLong(r15)     // Catch:{ Exception -> 0x01d1 }
            r5.setDownloadTime(r7)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r7 = r6.getString(r3)     // Catch:{ Exception -> 0x01d1 }
            r5.setOrginalUrl(r7)     // Catch:{ Exception -> 0x01d1 }
            long r7 = r6.getLong(r2)     // Catch:{ Exception -> 0x01d1 }
            r5.setOpenTime(r7)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r7 = r6.getString(r0)     // Catch:{ Exception -> 0x01d1 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d1 }
            if (r8 == 0) goto L_0x0180
            java.lang.String r8 = ""
            goto L_0x0181
        L_0x0180:
            r8 = r7
        L_0x0181:
            r7 = r8
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d1 }
            if (r8 != 0) goto L_0x01a8
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x01d1 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x01d1 }
            r25 = r0
            java.lang.String r0 = "play_progress"
            r29 = r2
            r28 = r3
            r2 = 0
            double r2 = r8.optDouble(r0, r2)     // Catch:{ Exception -> 0x01d1 }
            r30 = 4636737291354636288(0x4059000000000000, double:100.0)
            r0 = r7
            r32 = r8
            double r7 = r2 * r30
            int r7 = (int) r7     // Catch:{ Exception -> 0x01d1 }
            r5.setProgress(r7)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x01af
        L_0x01a8:
            r25 = r0
            r29 = r2
            r28 = r3
            r0 = r7
        L_0x01af:
            java.lang.String r2 = r5.getPath()     // Catch:{ Exception -> 0x01d1 }
            r5.setIcon(r2)     // Catch:{ Exception -> 0x01d1 }
            r1.add(r5)     // Catch:{ Exception -> 0x01d1 }
            boolean r0 = r6.moveToNext()     // Catch:{ Exception -> 0x01d1 }
            if (r0 != 0) goto L_0x01c1
            goto L_0x0202
        L_0x01c1:
            r4 = r20
            r8 = r21
            r7 = r24
            r0 = r25
            r5 = r27
            r3 = r28
            r2 = r29
            goto L_0x010a
        L_0x01d1:
            r0 = move-exception
            goto L_0x01f9
        L_0x01d3:
            r0 = move-exception
            r20 = r4
            goto L_0x0208
        L_0x01d7:
            r0 = move-exception
            r20 = r4
            goto L_0x01f9
        L_0x01db:
            r16 = r0
            r17 = r2
            r20 = r4
            r24 = r7
            r21 = r8
            goto L_0x0202
        L_0x01e6:
            r0 = move-exception
            goto L_0x01ed
        L_0x01e8:
            r0 = move-exception
            goto L_0x01f5
        L_0x01ea:
            r0 = move-exception
            r10 = r34
        L_0x01ed:
            r17 = r2
            r20 = r4
            goto L_0x0208
        L_0x01f2:
            r0 = move-exception
            r10 = r34
        L_0x01f5:
            r17 = r2
            r20 = r4
        L_0x01f9:
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x0207 }
            if (r2 == 0) goto L_0x0202
            r0.printStackTrace()     // Catch:{ all -> 0x0207 }
        L_0x0202:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r6)
            return r1
        L_0x0207:
            r0 = move-exception
        L_0x0208:
            com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.DownloadCenterUtils.queryDownloadedVideoDataForSmartMenu(int, int):java.util.List");
    }
}
