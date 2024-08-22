package com.baidu.searchbox.download.scheme;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.Contract;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.download.DownloadCallBack;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.center.ioc.IDownloadCenterApp;
import com.baidu.searchbox.download.center.ui.DownloadInfoUtil;
import com.baidu.searchbox.download.constants.AdStatEvent;
import com.baidu.searchbox.download.constants.DownloadStat;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadModel;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.download.util.ApkInstallCallBack;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.feed.ad.util.InterceptCallback;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UnitedSchemeDownloadApkDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String BUSINESS = "business";
    public static final String CALLBACK = "callback";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String DOWNLOAD_DONE = "3";
    public static final String DOWNLOAD_ERROR = "4";
    public static final String DOWNLOAD_ING = "1";
    public static final String DOWNLOAD_NOT_START = "0";
    public static final String DOWNLOAD_PAUSED = "2";
    public static final String DOWNLOAD_PENDING = "5";
    public static final String EXT_INFO = "ext_info";
    public static final String FULL_PROGRESS = "100";
    public static final int FULL_PROGRESS_INT = 100;
    public static final String INVOKEFROM = "invokeFrom";
    public static final String MODULE_DOWNLOAD_APP = "app";
    public static final String NO_PROGRESS = "0";
    public static final String PACKAGENAME = "packageName";
    public static final String PARAMS = "params";
    public static final String QUERY = "query";
    public static final String QUERY_ARRAY = "query_array";
    public static final String RESULT = "result";
    /* access modifiers changed from: private */
    public static final String TAG = UnitedSchemeDownloadApkDispatcher.class.getSimpleName();
    public static final String TYPE_BATCHGETDOWNLOADSTATUS = "batchgetdownloadstatus";
    public static final String TYPE_CANCELDOWNLOAD = "canceldownload";
    public static final String TYPE_INSTALLAPK = "installapk";
    public static final String TYPE_OPENAPK = "openapk";
    public static final String TYPE_PAUSEDOWNLOAD = "pausedownload";
    public static final String TYPE_RESUMEDOWNLOAD = "resumedownload";
    public static final String TYPE_STARTDOWNLOAD = "startdownload";
    public static final String URI = "uri";
    public static final String URL = "url";
    public static final String VERSION = "version";

    public static class ItemQueryModel {
        public DownloadModel bean;
        public String business;
        public String extInfo;
        public String fileId;
        public String url;
    }

    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    public boolean invoke(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        return handleAppType(context, entity, handler);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        if (r3.equals(TYPE_BATCHGETDOWNLOADSTATUS) != false) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleAppType(android.content.Context r10, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r11, com.baidu.searchbox.unitedscheme.CallbackHandler r12) {
        /*
            r9 = this;
            java.lang.String r0 = "params"
            java.lang.String r0 = r11.getParam(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000f
            return r2
        L_0x000f:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "****** paramsJson="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r1, r3)
        L_0x002b:
            r1 = 0
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004a }
            r5.<init>(r0)     // Catch:{ JSONException -> 0x004a }
            r1 = r5
            java.lang.String r5 = "type"
            java.lang.String r6 = ""
            java.lang.String r5 = r1.optString(r5, r6)     // Catch:{ JSONException -> 0x004a }
            r3 = r5
            android.net.Uri r5 = r11.getUri()     // Catch:{ JSONException -> 0x004a }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x004a }
            r4 = r5
            goto L_0x0052
        L_0x004a:
            r5 = move-exception
            boolean r6 = DEBUG
            if (r6 == 0) goto L_0x0052
            r5.printStackTrace()
        L_0x0052:
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x00f2
            if (r1 != 0) goto L_0x005c
            goto L_0x00f2
        L_0x005c:
            boolean r5 = r11.isOnlyVerify()
            r6 = 1
            if (r5 == 0) goto L_0x0064
            return r6
        L_0x0064:
            r5 = 0
            r7 = -1
            int r8 = r3.hashCode()
            switch(r8) {
                case -1263192174: goto L_0x00ad;
                case -568075006: goto L_0x00a3;
                case -515860354: goto L_0x0098;
                case 120066997: goto L_0x008d;
                case 636901206: goto L_0x0084;
                case 900442785: goto L_0x0079;
                case 1490291434: goto L_0x006e;
                default: goto L_0x006d;
            }
        L_0x006d:
            goto L_0x00b8
        L_0x006e:
            java.lang.String r2 = "startdownload"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x006d
            r2 = r6
            goto L_0x00b9
        L_0x0079:
            java.lang.String r2 = "installapk"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x006d
            r2 = 5
            goto L_0x00b9
        L_0x0084:
            java.lang.String r6 = "batchgetdownloadstatus"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x006d
            goto L_0x00b9
        L_0x008d:
            java.lang.String r2 = "resumedownload"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x006d
            r2 = 3
            goto L_0x00b9
        L_0x0098:
            java.lang.String r2 = "pausedownload"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x006d
            r2 = 2
            goto L_0x00b9
        L_0x00a3:
            java.lang.String r2 = "canceldownload"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x006d
            r2 = 4
            goto L_0x00b9
        L_0x00ad:
            java.lang.String r2 = "openapk"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x006d
            r2 = 6
            goto L_0x00b9
        L_0x00b8:
            r2 = r7
        L_0x00b9:
            switch(r2) {
                case 0: goto L_0x00db;
                case 1: goto L_0x00d6;
                case 2: goto L_0x00d1;
                case 3: goto L_0x00cc;
                case 4: goto L_0x00c7;
                case 5: goto L_0x00c2;
                case 6: goto L_0x00bd;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            goto L_0x00e0
        L_0x00bd:
            boolean r5 = r9.handleOpenApk(r10, r4, r1, r12)
            goto L_0x00e0
        L_0x00c2:
            boolean r5 = r9.handleInstallApk(r10, r1, r12)
            goto L_0x00e0
        L_0x00c7:
            boolean r5 = r9.handleCancelDownload(r1, r12)
            goto L_0x00e0
        L_0x00cc:
            boolean r5 = r9.handleResumeDownload(r1, r12)
            goto L_0x00e0
        L_0x00d1:
            boolean r5 = r9.handlePauseDownload(r1, r12)
            goto L_0x00e0
        L_0x00d6:
            boolean r5 = r9.handleStartDownload(r1, r12)
            goto L_0x00e0
        L_0x00db:
            boolean r5 = r9.handleBatchGetDownloadStatus(r1, r12)
        L_0x00e0:
            boolean r2 = r11.isOnlyVerify()
            if (r2 != 0) goto L_0x00f1
            java.lang.String r2 = r11.getSource()
            android.net.Uri r6 = r11.getUri()
            com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(r2, r6)
        L_0x00f1:
            return r5
        L_0x00f2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.scheme.UnitedSchemeDownloadApkDispatcher.handleAppType(android.content.Context, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler):boolean");
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String path) {
        return null;
    }

    private boolean handleBatchGetDownloadStatus(JSONObject paramsJsonObject, CallbackHandler handler) {
        if (paramsJsonObject == null || handler == null) {
            return false;
        }
        String callback = paramsJsonObject.optString("callback", "");
        JSONArray queryArray = paramsJsonObject.optJSONArray("query");
        if (queryArray == null) {
            queryArray = paramsJsonObject.optJSONArray(QUERY_ARRAY);
        }
        String business = paramsJsonObject.optString("business", "");
        if (TextUtils.isEmpty(business) || queryArray == null || queryArray.length() <= 0) {
            if (DEBUG) {
                Log.e(TAG, "handleBatchGetDownloadStatus 参数没有通过:" + paramsJsonObject.toString());
            }
            if (!TextUtils.isEmpty(callback)) {
                handler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
            }
            return true;
        }
        ArrayList<ItemQueryModel> batchQueryModelList = new ArrayList<>();
        for (int i2 = 0; i2 < queryArray.length(); i2++) {
            JSONObject job = queryArray.optJSONObject(i2);
            if (job == null || TextUtils.isEmpty(job.optString("url", "")) || TextUtils.isEmpty(job.optString("file_id", ""))) {
                batchQueryModelList.add(i2, new ItemQueryModel());
            } else {
                ItemQueryModel itemQueryModel = new ItemQueryModel();
                itemQueryModel.url = job.optString("url", "");
                itemQueryModel.fileId = job.optString("file_id", "");
                itemQueryModel.extInfo = job.optString("ext_info", "");
                itemQueryModel.bean = queryBean(business, itemQueryModel.fileId, itemQueryModel.extInfo);
                batchQueryModelList.add(i2, itemQueryModel);
            }
        }
        if (queryArray.length() != batchQueryModelList.size()) {
            handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 0).toString());
            return true;
        } else if (processBatchDownloadStatusCallback(handler, callback, batchQueryModelList)) {
            return true;
        } else {
            handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 0).toString());
            return true;
        }
    }

    private String combExtraInfo(String business, String fileId, String extInfo) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", DownloadInfoUtil.H5_SEARCH_DOWNLOAD);
            jsonObject.put("file_id", fileId);
            jsonObject.put("business", business);
            if (!TextUtils.isEmpty(extInfo)) {
                jsonObject.put("ext_info", extInfo);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return jsonObject.toString();
    }

    private boolean processBatchDownloadStatusCallback(CallbackHandler handler, String callback, ArrayList<ItemQueryModel> queryModels) {
        if (queryModels == null || queryModels.size() <= 0) {
            return false;
        }
        JSONArray jsonArray = new JSONArray();
        Iterator<ItemQueryModel> it = queryModels.iterator();
        while (it.hasNext()) {
            ItemQueryModel itemQueryModel = it.next();
            if (!TextUtils.isEmpty(itemQueryModel.url) && !TextUtils.isEmpty(itemQueryModel.fileId) && itemQueryModel.bean != null && itemQueryModel.bean.mDownloadId != -1 && itemQueryModel.bean.mStatus >= 0 && itemQueryModel.bean.mTotalBytes >= 0 && itemQueryModel.bean.mCurrentBytes != 0 && !TextUtils.isEmpty(itemQueryModel.bean.mDownloadPath)) {
                if (new File(itemQueryModel.bean.mDownloadPath).exists()) {
                    switch (itemQueryModel.bean.mStatus) {
                        case 190:
                            jsonArray.put(getStatusCallbackJob(itemQueryModel.fileId, "5", itemQueryModel.bean));
                            break;
                        case 192:
                            jsonArray.put(getStatusCallbackJob(itemQueryModel.fileId, "1", itemQueryModel.bean));
                            break;
                        case 193:
                            jsonArray.put(getStatusCallbackJob(itemQueryModel.fileId, "2", itemQueryModel.bean));
                            break;
                        case 200:
                            jsonArray.put(getStatusCallbackJob(itemQueryModel.fileId, "3", itemQueryModel.bean));
                            break;
                        default:
                            jsonArray.put(getStatusCallbackJob(itemQueryModel.fileId, "0", itemQueryModel.bean));
                            DownloadManagerExt.getInstance().cancelDownload(itemQueryModel.bean.mDownloadId);
                            break;
                    }
                } else {
                    jsonArray.put(getStatusCallbackJob(itemQueryModel.fileId, "0", itemQueryModel.bean));
                    DownloadManagerExt.getInstance().cancelDownload(itemQueryModel.bean.mDownloadId);
                }
            } else {
                jsonArray.put(getStatusCallbackJob(itemQueryModel.fileId, "0", itemQueryModel.bean));
            }
        }
        if (jsonArray.length() != queryModels.size()) {
            return false;
        }
        JSONObject data = new JSONObject();
        try {
            data.put("result", jsonArray);
            String params = UnitedSchemeUtility.wrapCallbackParams(data, 0).toString();
            if (handler != null) {
                handler.handleSchemeDispatchCallback(callback, params);
            }
            if (!DEBUG) {
                return true;
            }
            Log.e(TAG, "批量查询 callback params=" + params);
            return true;
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject getStatusCallbackJob(java.lang.String r12, java.lang.String r13, com.baidu.searchbox.download.model.DownloadModel r14) {
        /*
            r11 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = -1
            int r2 = r13.hashCode()     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r3 = "5"
            java.lang.String r4 = "3"
            java.lang.String r5 = "2"
            java.lang.String r6 = "1"
            java.lang.String r7 = "0"
            switch(r2) {
                case 48: goto L_0x0038;
                case 49: goto L_0x0030;
                case 50: goto L_0x0028;
                case 51: goto L_0x0020;
                case 52: goto L_0x0017;
                case 53: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x003f
        L_0x0018:
            boolean r2 = r13.equals(r3)     // Catch:{ JSONException -> 0x00f4 }
            if (r2 == 0) goto L_0x0017
            r1 = 3
            goto L_0x003f
        L_0x0020:
            boolean r2 = r13.equals(r4)     // Catch:{ JSONException -> 0x00f4 }
            if (r2 == 0) goto L_0x0017
            r1 = 0
            goto L_0x003f
        L_0x0028:
            boolean r2 = r13.equals(r5)     // Catch:{ JSONException -> 0x00f4 }
            if (r2 == 0) goto L_0x0017
            r1 = 2
            goto L_0x003f
        L_0x0030:
            boolean r2 = r13.equals(r6)     // Catch:{ JSONException -> 0x00f4 }
            if (r2 == 0) goto L_0x0017
            r1 = 1
            goto L_0x003f
        L_0x0038:
            boolean r2 = r13.equals(r7)     // Catch:{ JSONException -> 0x00f4 }
            if (r2 == 0) goto L_0x0017
            r1 = 4
        L_0x003f:
            java.lang.String r2 = "file_id"
            java.lang.String r8 = "uri"
            java.lang.String r9 = "process"
            java.lang.String r10 = "downStatus"
            switch(r1) {
                case 0: goto L_0x00ad;
                case 1: goto L_0x0088;
                case 2: goto L_0x006b;
                case 3: goto L_0x004e;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x00c4
        L_0x004e:
            r0.put(r10, r3)     // Catch:{ JSONException -> 0x00f4 }
            long r3 = r14.mCurrentBytes     // Catch:{ JSONException -> 0x00f4 }
            long r5 = r14.mTotalBytes     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r1 = com.baidu.searchbox.download.center.ui.DownloadInfoUtil.getDownloadProgress(r3, r5)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r9, r1)     // Catch:{ JSONException -> 0x00f4 }
            android.net.Uri r1 = com.baidu.searchbox.download.model.Downloads.Impl.CONTENT_URI     // Catch:{ JSONException -> 0x00f4 }
            long r3 = r14.mDownloadId     // Catch:{ JSONException -> 0x00f4 }
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r1, r3)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r8, r1)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r2, r12)     // Catch:{ JSONException -> 0x00f4 }
            goto L_0x00d2
        L_0x006b:
            r0.put(r10, r5)     // Catch:{ JSONException -> 0x00f4 }
            long r3 = r14.mCurrentBytes     // Catch:{ JSONException -> 0x00f4 }
            long r5 = r14.mTotalBytes     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r1 = com.baidu.searchbox.download.center.ui.DownloadInfoUtil.getDownloadProgress(r3, r5)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r9, r1)     // Catch:{ JSONException -> 0x00f4 }
            android.net.Uri r1 = com.baidu.searchbox.download.model.Downloads.Impl.CONTENT_URI     // Catch:{ JSONException -> 0x00f4 }
            long r3 = r14.mDownloadId     // Catch:{ JSONException -> 0x00f4 }
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r1, r3)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r8, r1)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r2, r12)     // Catch:{ JSONException -> 0x00f4 }
            goto L_0x00d2
        L_0x0088:
            android.net.Uri r1 = com.baidu.searchbox.download.model.Downloads.Impl.CONTENT_URI     // Catch:{ JSONException -> 0x00f4 }
            long r3 = r14.mDownloadId     // Catch:{ JSONException -> 0x00f4 }
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r1, r3)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r10, r6)     // Catch:{ JSONException -> 0x00f4 }
            long r3 = r14.mCurrentBytes     // Catch:{ JSONException -> 0x00f4 }
            long r5 = r14.mTotalBytes     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r3 = com.baidu.searchbox.download.center.ui.DownloadInfoUtil.getDownloadProgress(r3, r5)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r9, r3)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r8, r1)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r2, r12)     // Catch:{ JSONException -> 0x00f4 }
            com.baidu.searchbox.download.scheme.UnitedSchemeDownloadApkDispatcher$ApkDownloadListener r2 = new com.baidu.searchbox.download.scheme.UnitedSchemeDownloadApkDispatcher$ApkDownloadListener     // Catch:{ JSONException -> 0x00f4 }
            r2.<init>(r12)     // Catch:{ JSONException -> 0x00f4 }
            com.baidu.searchbox.download.FileDownloader.resumeDownload(r1, r2)     // Catch:{ JSONException -> 0x00f4 }
            goto L_0x00d2
        L_0x00ad:
            r0.put(r10, r4)     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r1 = "100"
            r0.put(r9, r1)     // Catch:{ JSONException -> 0x00f4 }
            android.net.Uri r1 = com.baidu.searchbox.download.model.Downloads.Impl.CONTENT_URI     // Catch:{ JSONException -> 0x00f4 }
            long r3 = r14.mDownloadId     // Catch:{ JSONException -> 0x00f4 }
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r1, r3)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r8, r1)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r2, r12)     // Catch:{ JSONException -> 0x00f4 }
            goto L_0x00d2
        L_0x00c4:
            r0.put(r10, r7)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r9, r7)     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r1 = ""
            r0.put(r8, r1)     // Catch:{ JSONException -> 0x00f4 }
            r0.put(r2, r12)     // Catch:{ JSONException -> 0x00f4 }
        L_0x00d2:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x00f3
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getStatusCallbackJob json="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
        L_0x00f3:
            return r0
        L_0x00f4:
            r1 = move-exception
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x00fc
            r1.printStackTrace()
        L_0x00fc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.scheme.UnitedSchemeDownloadApkDispatcher.getStatusCallbackJob(java.lang.String, java.lang.String, com.baidu.searchbox.download.model.DownloadModel):org.json.JSONObject");
    }

    private boolean handleStartDownload(JSONObject paramsJsonObject, CallbackHandler handler) {
        String fileId;
        JSONObject jSONObject = paramsJsonObject;
        CallbackHandler callbackHandler = handler;
        if (jSONObject == null || callbackHandler == null) {
            return false;
        }
        String url = jSONObject.optString("url", "");
        String callback = jSONObject.optString("callback", "");
        String fileId2 = jSONObject.optString("file_id", "");
        String uri = jSONObject.optString("uri", "");
        String business = jSONObject.optString("business", "");
        String extInfo = jSONObject.optString("ext_info", "");
        String pkgName = jSONObject.optString("packageName", "");
        if (TextUtils.isEmpty(business)) {
            String str = uri;
            String fileId3 = pkgName;
        } else if (TextUtils.isEmpty(url)) {
            String str2 = uri;
            String fileId4 = pkgName;
        } else if (TextUtils.isEmpty(fileId2)) {
            String str3 = fileId2;
            String str4 = uri;
            String fileId5 = pkgName;
        } else {
            if (hasInsertDownload(uri, fileId2)) {
                if (DEBUG) {
                    Log.e(TAG, "hasInsertDownload return true 已经下载过,恢复下载");
                }
                DownloadModel bean = queryBean(business, fileId2, extInfo);
                if (bean == null || bean.mTotalBytes < 0) {
                    callbackHandler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
                    return false;
                }
                if (bean.mCurrentBytes == bean.mTotalBytes) {
                    callbackHandler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getDownloadProcessStatusJson("3", "100", uri, fileId2));
                } else {
                    callbackHandler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getDownloadProcessStatusJson("1", DownloadInfoUtil.getDownloadProgress(bean.mCurrentBytes, bean.mTotalBytes), uri, fileId2));
                }
                FileDownloader.resumeDownload(Uri.parse(uri));
                String str5 = fileId2;
                String str6 = uri;
                fileId = pkgName;
            } else {
                if (DEBUG) {
                    Log.e(TAG, "hasInsertDownload return false 没有下载过,需要新插入一条下载任务");
                }
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("type", DownloadInfoUtil.H5_SEARCH_DOWNLOAD);
                    jsonObject.put("file_id", fileId2);
                    jsonObject.put("business", business);
                    if (!TextUtils.isEmpty(extInfo)) {
                        jsonObject.put("ext_info", extInfo);
                    }
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                ContentValues cv = new ContentValues();
                cv.put("extra_info", jsonObject.toString());
                AnonymousClass1 r8 = r1;
                final String str7 = uri;
                String str8 = uri;
                ApkDownloadListener apkDownloadListener = new ApkDownloadListener(fileId2);
                final String str9 = fileId2;
                JSONObject jSONObject2 = jsonObject;
                final CallbackHandler callbackHandler2 = handler;
                String str10 = fileId2;
                fileId = pkgName;
                final String pkgName2 = callback;
                AnonymousClass1 r1 = new DownloadCallBack() {
                    public void onResult(Uri newUri) {
                        callbackHandler2.handleSchemeDispatchCallback(pkgName2, DownloadInfoUtil.getDownloadProcessStatusJson("0", "0", newUri != null ? newUri.toString() : str7, str9));
                    }
                };
                FileDownloader.startDownload(url, cv, apkDownloadListener, r8);
            }
            broadcastStatus(DownloadStat.START, extInfo, fileId);
            return true;
        }
        if (DEBUG) {
            Log.e(TAG, "handleStartDownload 参数没有通过:" + paramsJsonObject.toString());
        }
        if (!TextUtils.isEmpty(callback)) {
            callbackHandler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
        }
        return true;
    }

    private boolean handlePauseDownload(JSONObject paramsJsonObject, CallbackHandler handler) {
        if (paramsJsonObject == null || handler == null) {
            return false;
        }
        String uri = paramsJsonObject.optString("uri", "");
        String callback = paramsJsonObject.optString("callback", "");
        String fileId = paramsJsonObject.optString("file_id", "");
        if (TextUtils.isEmpty(paramsJsonObject.optString("business", "")) || TextUtils.isEmpty(fileId) || TextUtils.isEmpty(uri)) {
            if (DEBUG) {
                Log.e(TAG, "handlePauseDownload 参数没有通过:" + paramsJsonObject.toString());
            }
            if (!TextUtils.isEmpty(callback)) {
                handler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
            }
            return true;
        }
        FileDownloader.pauseDownload(Uri.parse(uri));
        JSONObject data = new JSONObject();
        try {
            data.put("uri", uri);
            data.put("file_id", fileId);
            data.put("downStatus", "2");
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams(data, 0).toString());
        return true;
    }

    private boolean handleResumeDownload(JSONObject paramsJsonObject, CallbackHandler handler) {
        if (paramsJsonObject == null || handler == null) {
            return false;
        }
        String uri = paramsJsonObject.optString("uri", "");
        String callback = paramsJsonObject.optString("callback", "");
        String fileId = paramsJsonObject.optString("file_id", "");
        if (TextUtils.isEmpty(paramsJsonObject.optString("business", "")) || TextUtils.isEmpty(fileId) || TextUtils.isEmpty(uri)) {
            if (DEBUG) {
                Log.e(TAG, "handleResumeDownload 参数没有通过:" + paramsJsonObject.toString());
            }
            if (!TextUtils.isEmpty(callback)) {
                handler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
            }
            return true;
        }
        FileDownloader.resumeDownload(Uri.parse(uri));
        JSONObject data = new JSONObject();
        try {
            data.put("uri", uri);
            data.put("file_id", fileId);
            data.put("downStatus", "1");
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams(data, 0).toString());
        return true;
    }

    private boolean handleCancelDownload(JSONObject paramsJsonObject, CallbackHandler handler) {
        if (paramsJsonObject == null || handler == null) {
            return false;
        }
        String uri = paramsJsonObject.optString("uri", "");
        String callback = paramsJsonObject.optString("callback", "");
        String fileId = paramsJsonObject.optString("file_id", "");
        String business = paramsJsonObject.optString("business", "");
        String extInfo = paramsJsonObject.optString("ext_info", "");
        if (TextUtils.isEmpty(business) || TextUtils.isEmpty(fileId) || TextUtils.isEmpty(uri)) {
            if (DEBUG) {
                Log.e(TAG, "handleCancelDownload 参数没有通过:" + paramsJsonObject.toString());
            }
            if (!TextUtils.isEmpty(callback)) {
                handler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
            }
            return true;
        }
        FileUtils.deleteFile(queryBean(business, fileId, extInfo).mDownloadPath);
        FileDownloader.cancelDownload(Uri.parse(uri));
        JSONObject data = new JSONObject();
        try {
            data.put("uri", uri);
            data.put("file_id", fileId);
            data.put("downStatus", "0");
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams(data, 0).toString());
        return true;
    }

    private boolean handleInstallApk(Context context, JSONObject paramsJsonObject, final CallbackHandler handler) {
        if (paramsJsonObject == null || handler == null) {
            return false;
        }
        String packageName = paramsJsonObject.optString("packageName", "");
        String uri = paramsJsonObject.optString("uri", "");
        final String callback = paramsJsonObject.optString("callback", "");
        String extInfo = paramsJsonObject.optString("ext_info", "");
        if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(uri)) {
            if (DEBUG && paramsJsonObject != null) {
                Log.e(TAG, "handleInstallApk 参数没有通过:" + paramsJsonObject.toString());
            }
            if (!TextUtils.isEmpty(callback)) {
                handler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
            }
            return false;
        }
        ApkUtil.installApk(context, packageName, Uri.parse(uri), ApkUtil.ifHideInstallComplete(extInfo), (ApkInstallCallBack) new ApkInstallCallBack() {
            public void onResult(boolean actionInstall) {
                int i2;
                if (!TextUtils.isEmpty(callback)) {
                    if (actionInstall) {
                        i2 = 0;
                    } else {
                        i2 = 202;
                    }
                    handler.handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, i2).toString());
                }
            }
        });
        broadcastStatus(DownloadStat.INSTALL, extInfo, packageName);
        return true;
    }

    private boolean handleOpenApk(Context context, String scheme, JSONObject paramsJsonObject, CallbackHandler handler) {
        JSONObject jSONObject = paramsJsonObject;
        final CallbackHandler callbackHandler = handler;
        if (jSONObject == null) {
            Context context2 = context;
            String str = scheme;
        } else if (callbackHandler == null) {
            Context context3 = context;
            String str2 = scheme;
        } else {
            String invokeFrom = jSONObject.optString("invokeFrom", "");
            String url = jSONObject.optString("url", "");
            String packageName = jSONObject.optString("packageName", "");
            final String callback = jSONObject.optString("callback", "");
            SchemeForbidStatisticUtils.ubcWhetherInstallApk(context, packageName, scheme);
            if (TextUtils.isEmpty(packageName)) {
                if (DEBUG) {
                    Log.e(TAG, "handleOpenApk 参数没有通过:" + paramsJsonObject.toString());
                }
                if (!TextUtils.isEmpty(callback)) {
                    callbackHandler.handleSchemeDispatchCallback(callback, DownloadInfoUtil.getCommonErrorStatusJson());
                }
                return false;
            }
            InterceptCallback ic = new InterceptCallback() {
                public void onResult(boolean result) {
                    int i2;
                    if (!TextUtils.isEmpty(callback)) {
                        CallbackHandler callbackHandler = callbackHandler;
                        String str = callback;
                        if (result) {
                            i2 = 0;
                        } else {
                            i2 = 202;
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, i2).toString());
                    }
                }
            };
            ApkUtil.openApp(context, scheme, packageName, invokeFrom, handler.getClass().getSimpleName(), url, ic);
            return true;
        }
        return false;
    }

    private static final class ApkDownloadListener implements IDownloadListener {
        private static final int SPACE_TIME = 2000;
        private final String mFileId;
        private long mLastTime = 0;

        public boolean showProgress(boolean show) {
            if (show) {
                this.mLastTime = 0;
                return true;
            }
            long currentTime = System.currentTimeMillis();
            if (currentTime - this.mLastTime <= 2000) {
                return false;
            }
            this.mLastTime = currentTime;
            return true;
        }

        public ApkDownloadListener(String fileId) {
            this.mFileId = fileId;
        }

        public void onProgressChanged(Uri uri, int newProgress) {
            if (newProgress == 100 || showProgress(false)) {
                if (UnitedSchemeDownloadApkDispatcher.DEBUG) {
                    Log.e(UnitedSchemeDownloadApkDispatcher.TAG, "没有拦截 newProgress=" + newProgress);
                    Log.e(UnitedSchemeDownloadApkDispatcher.TAG, "onProgressChanged() ==>>> uri=" + uri + " onProgressChanged  newProgress=" + newProgress);
                }
                sendBroadcast("1", String.valueOf(newProgress), uri.toString(), this.mFileId);
            } else if (UnitedSchemeDownloadApkDispatcher.DEBUG) {
                Log.e(UnitedSchemeDownloadApkDispatcher.TAG, "被拦截 newProgress=" + newProgress);
            }
        }

        public void onStopped(StopStatus stopStatus) {
            if (UnitedSchemeDownloadApkDispatcher.DEBUG) {
                Log.e(UnitedSchemeDownloadApkDispatcher.TAG, "onStopped() ==>>> stopStatus=" + stopStatus.toString());
            }
            sendBroadcast("4", "0", "", this.mFileId);
        }

        public void onPause(Uri uri, int newProgress) {
            if (UnitedSchemeDownloadApkDispatcher.DEBUG) {
                Log.e(UnitedSchemeDownloadApkDispatcher.TAG, "onPause() ==>>>  uri=" + uri + "onPause  newProgress=" + newProgress);
            }
            sendBroadcast("2", String.valueOf(newProgress), uri.toString(), this.mFileId);
        }

        public void onSuccess(Uri uri) {
            if (UnitedSchemeDownloadApkDispatcher.DEBUG) {
                Log.e(UnitedSchemeDownloadApkDispatcher.TAG, "onSuccess() ===>>> uri=" + uri + "onSuccess");
            }
            sendBroadcast("3", "100", uri.toString(), this.mFileId);
        }

        public void onProgress(Uri uri, long currentSize, long totalSize) {
        }

        public void sendBroadcast(String downloadStatus, String downloadProgress, String downloadUri, String downloadFileId) {
            String json = DownloadInfoUtil.getDownloadProcessStatusJson(downloadStatus, downloadProgress, downloadUri, downloadFileId);
            if (UnitedSchemeDownloadApkDispatcher.DEBUG) {
                Log.e(UnitedSchemeDownloadApkDispatcher.TAG, "sendBroadcast() ===>>>json = " + json);
            }
            if (TextUtils.isEmpty(json)) {
                Sender.sendBroadcast(AppRuntime.getAppContext(), Contract.ALADDIN_DOWNLOADAPK_ACTION, DownloadInfoUtil.getCommonErrorStatusJson());
            }
            Sender.sendBroadcast(AppRuntime.getAppContext(), Contract.ALADDIN_DOWNLOADAPK_ACTION, json);
        }
    }

    private boolean hasInsertDownload(String uri, String fileId) {
        if (TextUtils.isEmpty(uri)) {
            return false;
        }
        String extraInfoJson = IDownloadCenterApp.Impl.get().queryExtraInfoByDownloadID(String.valueOf(ContentUris.parseId(Uri.parse(uri))));
        if (TextUtils.isEmpty(extraInfoJson)) {
            return false;
        }
        try {
            JSONObject jsonObject = new JSONObject(extraInfoJson);
            String type = jsonObject.optString("type", "");
            String parseFileId = jsonObject.optString("file_id", "");
            if (TextUtils.isEmpty(type) || !type.equals(DownloadInfoUtil.H5_SEARCH_DOWNLOAD) || TextUtils.isEmpty(parseFileId) || !parseFileId.equals(fileId)) {
                return false;
            }
            return true;
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    private DownloadModel queryBean(String business, String fileId, String extInfo) {
        if (TextUtils.isEmpty(business) || TextUtils.isEmpty(fileId)) {
            return DownloadModel.buildErrorBean();
        }
        return DownloadManagerExt.getInstance().queryDownloadBeanByExtraInfo(combExtraInfo(business, fileId, extInfo));
    }

    private void broadcastStatus(DownloadStat status, String data, String pkgName) {
        AdStatEvent event = new AdStatEvent();
        event.data = data;
        event.status = status;
        event.pkgName = pkgName;
        BdEventBus.Companion.getDefault().post(event);
    }
}
