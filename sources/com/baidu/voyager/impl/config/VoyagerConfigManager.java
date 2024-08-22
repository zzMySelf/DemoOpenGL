package com.baidu.voyager.impl.config;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.voyager.impl.config.BizConfigData;
import com.baidu.voyager.impl.constant.VoyagerConstant;
import com.baidu.voyager.inter.VoyagerManager;
import com.baidu.voyager.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class VoyagerConfigManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_CLEAR = "c";
    private static final String KEY_ENABLE = "en";
    private static final String KEY_EXPIRED_TIME = "et";
    private static final String KEY_MAX_FILE_COUNT = "mfc";
    private static final String KEY_MAX_FILE_SIZE = "mfs";
    private static final String KEY_NETWORK_TYPE = "an";
    private static final String KEY_SET = "set";
    private static final String KEY_SINGLE_TASK_MAX_COUNT = "stmc";
    private static final String KEY_SINGLE_TASK_MAX_SIZE = "stms";
    private static final String KEY_UPLOAD_INTERVAL = "ui";
    private static final String KEY_UPLOAD_TASK_COUNT = "utc";
    private static final String TAG = "VoyagerConfig";
    private static volatile VoyagerConfigManager sInstance;
    private HashMap<String, BizConfigData> mBizConfigMapData;
    private boolean mClearLocal;
    private File mConfigDir;
    private File mConfigFile;
    private long mExpiredTime;
    private int mMaxFileCount;
    private long mMaxFileSize;
    private int mNetworkType;
    private int mSingleTaskMaxCount;
    private long mSingleTaskMaxSize;
    private long mUploadInterval;
    private int mUploadTaskCount;
    private boolean mVoyagerEnable;

    public static VoyagerConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (VoyagerConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new VoyagerConfigManager();
                }
            }
        }
        return sInstance;
    }

    private VoyagerConfigManager() {
        init();
    }

    public boolean updateConfig(JSONObject jsonObject) {
        if (jsonObject == null || jsonObject.length() == 0) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "update Config: " + jsonObject.toString());
        }
        if (!updateCloudConfig(jsonObject)) {
            return false;
        }
        boolean updateSuccess = updateLocalConfig();
        if (updateSuccess && !this.mVoyagerEnable && this.mClearLocal) {
            ((VoyagerManager) ServiceManager.getService(VoyagerManager.SERVICE_REFERENCE)).clearVoyager();
        }
        return updateSuccess;
    }

    public boolean isEnable() {
        return this.mVoyagerEnable;
    }

    public void setEnable(boolean enable) {
        this.mVoyagerEnable = enable;
    }

    public boolean getBizEnable(String bizType) {
        BizConfigData bizData;
        if (TextUtils.isEmpty(bizType)) {
            return this.mVoyagerEnable;
        }
        HashMap<String, BizConfigData> hashMap = this.mBizConfigMapData;
        if (hashMap == null || (bizData = hashMap.get(bizType)) == null) {
            return this.mVoyagerEnable;
        }
        return bizData.isEnable();
    }

    public boolean isClear() {
        return this.mClearLocal;
    }

    public void setClear(boolean clear) {
        this.mClearLocal = clear;
    }

    public long getUploadInterval() {
        return this.mUploadInterval;
    }

    public void setUploadInterval(long interval) {
        if (interval <= 0) {
            this.mUploadInterval = VoyagerConstant.UPLOAD_INTERVAL;
        } else {
            this.mUploadInterval = interval;
        }
    }

    public int getUploadTaskCount() {
        return this.mUploadTaskCount;
    }

    public void setUploadTaskCount(int taskCount) {
        if (taskCount <= 0 || taskCount > VoyagerConstant.TASK_MAX_UPLOAD_COUNT_LIMIT) {
            this.mUploadTaskCount = VoyagerConstant.TASK_MAX_UPLOAD_COUNT_LIMIT;
        } else {
            this.mUploadTaskCount = taskCount;
        }
    }

    public long getExpiredTime() {
        return this.mExpiredTime;
    }

    public void setExpiredTime(long expiredTime) {
        if (expiredTime <= 0) {
            this.mExpiredTime = VoyagerConstant.FILE_EXPIRED_TIME;
        } else {
            this.mExpiredTime = expiredTime;
        }
    }

    public long getBizExpiredTime(String bizType) {
        BizConfigData bizData;
        if (TextUtils.isEmpty(bizType)) {
            return this.mExpiredTime;
        }
        HashMap<String, BizConfigData> hashMap = this.mBizConfigMapData;
        if (hashMap == null || (bizData = hashMap.get(bizType)) == null) {
            return this.mExpiredTime;
        }
        return bizData.getExpiredTime();
    }

    public long getMaxFileSize() {
        return this.mMaxFileSize;
    }

    public void setMaxFileSize(long maxSize) {
        if (maxSize <= 0 || maxSize > VoyagerConstant.MAX_FILE_SIZE) {
            this.mMaxFileSize = VoyagerConstant.MAX_FILE_SIZE;
        } else {
            this.mMaxFileSize = maxSize;
        }
    }

    public int getMaxFileCount() {
        return this.mMaxFileCount;
    }

    public void setMaxFileCount(int maxCount) {
        if (maxCount <= 0 || maxCount > VoyagerConstant.MAX_FILE_COUNT) {
            this.mMaxFileCount = VoyagerConstant.MAX_FILE_COUNT;
        } else {
            this.mMaxFileCount = maxCount;
        }
    }

    public int getSingleTaskMaxCount() {
        return this.mSingleTaskMaxCount;
    }

    public void setSingleTaskMaxCount(int singleCount) {
        if (singleCount <= 0 || singleCount > VoyagerConstant.TASK_MAX_UPLOAD_COUNT) {
            this.mSingleTaskMaxCount = VoyagerConstant.TASK_MAX_UPLOAD_COUNT;
        } else {
            this.mSingleTaskMaxCount = singleCount;
        }
    }

    public int getBizSingleMaxCount(String bizType) {
        BizConfigData bizData;
        if (TextUtils.isEmpty(bizType)) {
            return this.mSingleTaskMaxCount;
        }
        HashMap<String, BizConfigData> hashMap = this.mBizConfigMapData;
        if (hashMap == null || (bizData = hashMap.get(bizType)) == null) {
            return this.mSingleTaskMaxCount;
        }
        return bizData.getSingleMaxCount();
    }

    public long getSingTaskMaxSize() {
        return this.mSingleTaskMaxSize;
    }

    public void setSingTaskMaxSize(long maxTaskSize) {
        if (maxTaskSize <= 0 || maxTaskSize > 20971520) {
            this.mSingleTaskMaxSize = 20971520;
        } else {
            this.mSingleTaskMaxSize = maxTaskSize;
        }
    }

    public long getBizSingTaskMaxSize(String bizType) {
        BizConfigData bizData;
        if (TextUtils.isEmpty(bizType)) {
            return this.mSingleTaskMaxSize;
        }
        HashMap<String, BizConfigData> hashMap = this.mBizConfigMapData;
        if (hashMap == null || (bizData = hashMap.get(bizType)) == null) {
            return this.mSingleTaskMaxSize;
        }
        return bizData.getSingleMaxSize();
    }

    public int getNetworkType() {
        return this.mNetworkType;
    }

    public void setNetworkType(int networkType) {
        if (networkType != VoyagerConstant.NET_ACCESS_WIFI) {
            this.mNetworkType = VoyagerConstant.NET_ACCESS_DEFAULT;
        } else {
            this.mNetworkType = networkType;
        }
    }

    public int getBizNetworkType(String bizType) {
        BizConfigData bizData;
        if (TextUtils.isEmpty(bizType)) {
            return this.mNetworkType;
        }
        HashMap<String, BizConfigData> hashMap = this.mBizConfigMapData;
        if (hashMap == null || (bizData = hashMap.get(bizType)) == null) {
            return this.mNetworkType;
        }
        return bizData.getNetworkType();
    }

    public boolean updateLocalConfig() {
        JSONObject configJson = new JSONObject();
        try {
            configJson.put("en", this.mVoyagerEnable);
            configJson.put("c", this.mClearLocal);
            configJson.put("ui", this.mUploadInterval);
            configJson.put(KEY_UPLOAD_TASK_COUNT, this.mUploadTaskCount);
            configJson.put("et", this.mExpiredTime);
            configJson.put(KEY_MAX_FILE_COUNT, this.mMaxFileCount);
            configJson.put(KEY_MAX_FILE_SIZE, this.mMaxFileSize);
            configJson.put("an", this.mNetworkType);
            configJson.put(KEY_SINGLE_TASK_MAX_COUNT, this.mSingleTaskMaxCount);
            configJson.put(KEY_SINGLE_TASK_MAX_SIZE, this.mSingleTaskMaxSize);
            HashMap<String, BizConfigData> hashMap = this.mBizConfigMapData;
            if (hashMap != null && hashMap.size() > 0) {
                JSONObject setJson = new JSONObject();
                for (String bizType : this.mBizConfigMapData.keySet()) {
                    if (!TextUtils.isEmpty(bizType)) {
                        BizConfigData bizData = this.mBizConfigMapData.get(bizType);
                        if (bizData != null) {
                            JSONObject bizValue = new JSONObject();
                            bizValue.put("en", bizData.isEnable() ? VoyagerConstant.CLOUD_VOYAGER_OPEN : VoyagerConstant.CLOUD_VOYAGER_CLOSE);
                            bizValue.put("et", bizData.getExpiredTime());
                            bizValue.put(KEY_SINGLE_TASK_MAX_COUNT, bizData.getSingleMaxCount());
                            bizValue.put(KEY_SINGLE_TASK_MAX_SIZE, bizData.getSingleMaxSize());
                            bizValue.put("an", bizData.getNetworkType());
                            setJson.put(bizType, bizValue);
                        }
                    }
                }
                if (setJson.length() > 0) {
                    configJson.put("set", setJson);
                }
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        if (!this.mConfigFile.exists()) {
            try {
                this.mConfigFile.createNewFile();
            } catch (IOException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
        return FileUtil.saveFile(configJson.toString(), this.mConfigFile);
    }

    private void init() {
        File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, VoyagerConstant.VOYAGER_CONFIG_PATH);
        this.mConfigDir = file;
        if (!file.exists()) {
            this.mConfigDir.mkdirs();
        }
        File file2 = new File(this.mConfigDir, VoyagerConstant.VOYAGER_CONFIG_FILE_PATH);
        this.mConfigFile = file2;
        if (file2.exists()) {
            readLocalConfig();
        } else {
            setDefaultConfig();
        }
    }

    private void setDefaultConfig() {
        this.mVoyagerEnable = VoyagerConstant.VOYAGER_ENABLE_DEFAULT;
        this.mClearLocal = VoyagerConstant.VOYAGER_NOT_CLEAR_DEFAULT;
        this.mUploadInterval = VoyagerConstant.UPLOAD_INTERVAL;
        this.mUploadTaskCount = VoyagerConstant.UPLOAD_MAX_COUNT;
        this.mExpiredTime = VoyagerConstant.FILE_EXPIRED_TIME;
        this.mMaxFileCount = VoyagerConstant.MAX_FILE_COUNT;
        this.mMaxFileSize = VoyagerConstant.MAX_FILE_SIZE;
        this.mSingleTaskMaxCount = VoyagerConstant.TASK_MAX_UPLOAD_COUNT;
        this.mSingleTaskMaxSize = VoyagerConstant.TASK_MAX_UPLOAD_SIZE;
        this.mNetworkType = VoyagerConstant.NET_ACCESS_DEFAULT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readLocalConfig() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "stms"
            java.lang.String r2 = "stmc"
            java.lang.String r3 = "an"
            java.lang.String r4 = "et"
            java.lang.String r5 = "en"
            java.io.File r6 = r1.mConfigFile
            java.lang.String r6 = com.baidu.voyager.util.FileUtil.readFile(r6)
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0031
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "read from local: "
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r6)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "VoyagerConfig"
            android.util.Log.d(r8, r7)
        L_0x0031:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x003b
            r24.setDefaultConfig()
            return
        L_0x003b:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01cb }
            r7.<init>(r6)     // Catch:{ JSONException -> 0x01cb }
            boolean r8 = com.baidu.voyager.impl.constant.VoyagerConstant.VOYAGER_ENABLE_DEFAULT     // Catch:{ JSONException -> 0x01cb }
            boolean r8 = r7.optBoolean(r5, r8)     // Catch:{ JSONException -> 0x01cb }
            r1.mVoyagerEnable = r8     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r8 = "c"
            boolean r9 = com.baidu.voyager.impl.constant.VoyagerConstant.VOYAGER_NOT_CLEAR_DEFAULT     // Catch:{ JSONException -> 0x01cb }
            boolean r8 = r7.optBoolean(r8, r9)     // Catch:{ JSONException -> 0x01cb }
            r1.mClearLocal = r8     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r8 = "ui"
            long r9 = com.baidu.voyager.impl.constant.VoyagerConstant.UPLOAD_INTERVAL     // Catch:{ JSONException -> 0x01cb }
            long r8 = r7.optLong(r8, r9)     // Catch:{ JSONException -> 0x01cb }
            r1.mUploadInterval = r8     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r8 = "utc"
            int r9 = com.baidu.voyager.impl.constant.VoyagerConstant.UPLOAD_MAX_COUNT     // Catch:{ JSONException -> 0x01cb }
            int r8 = r7.optInt(r8, r9)     // Catch:{ JSONException -> 0x01cb }
            r1.mUploadTaskCount = r8     // Catch:{ JSONException -> 0x01cb }
            long r8 = com.baidu.voyager.impl.constant.VoyagerConstant.FILE_EXPIRED_TIME     // Catch:{ JSONException -> 0x01cb }
            long r8 = r7.optLong(r4, r8)     // Catch:{ JSONException -> 0x01cb }
            r1.mExpiredTime = r8     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r8 = "mfc"
            int r9 = com.baidu.voyager.impl.constant.VoyagerConstant.MAX_FILE_COUNT     // Catch:{ JSONException -> 0x01cb }
            int r8 = r7.optInt(r8, r9)     // Catch:{ JSONException -> 0x01cb }
            r1.mMaxFileCount = r8     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r8 = "mfs"
            long r9 = com.baidu.voyager.impl.constant.VoyagerConstant.MAX_FILE_SIZE     // Catch:{ JSONException -> 0x01cb }
            long r8 = r7.optLong(r8, r9)     // Catch:{ JSONException -> 0x01cb }
            r1.mMaxFileSize = r8     // Catch:{ JSONException -> 0x01cb }
            int r8 = com.baidu.voyager.impl.constant.VoyagerConstant.NET_ACCESS_DEFAULT     // Catch:{ JSONException -> 0x01cb }
            int r8 = r7.optInt(r3, r8)     // Catch:{ JSONException -> 0x01cb }
            r1.mNetworkType = r8     // Catch:{ JSONException -> 0x01cb }
            int r8 = com.baidu.voyager.impl.constant.VoyagerConstant.TASK_MAX_UPLOAD_COUNT     // Catch:{ JSONException -> 0x01cb }
            int r8 = r7.optInt(r2, r8)     // Catch:{ JSONException -> 0x01cb }
            r1.mSingleTaskMaxCount = r8     // Catch:{ JSONException -> 0x01cb }
            long r8 = com.baidu.voyager.impl.constant.VoyagerConstant.TASK_MAX_UPLOAD_SIZE     // Catch:{ JSONException -> 0x01cb }
            long r8 = r7.optLong(r0, r8)     // Catch:{ JSONException -> 0x01cb }
            r1.mSingleTaskMaxSize = r8     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r8 = "set"
            org.json.JSONObject r8 = r7.optJSONObject(r8)     // Catch:{ JSONException -> 0x01cb }
            if (r8 == 0) goto L_0x01c6
            int r9 = r8.length()     // Catch:{ JSONException -> 0x01cb }
            if (r9 <= 0) goto L_0x01c6
            java.util.Iterator r9 = r8.keys()     // Catch:{ JSONException -> 0x01cb }
        L_0x00b1:
            boolean r10 = r9.hasNext()     // Catch:{ JSONException -> 0x01cb }
            if (r10 == 0) goto L_0x01c1
            java.lang.Object r10 = r9.next()     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ JSONException -> 0x01cb }
            org.json.JSONObject r11 = r8.optJSONObject(r10)     // Catch:{ JSONException -> 0x01cb }
            if (r11 == 0) goto L_0x01b3
            int r12 = r11.length()     // Catch:{ JSONException -> 0x01cb }
            if (r12 != 0) goto L_0x00ca
            goto L_0x00b1
        L_0x00ca:
            com.baidu.voyager.impl.config.BizConfigData$Builder r12 = new com.baidu.voyager.impl.config.BizConfigData$Builder     // Catch:{ JSONException -> 0x01cb }
            r12.<init>(r10)     // Catch:{ JSONException -> 0x01cb }
            com.baidu.voyager.impl.config.BizConfigData r12 = r12.build()     // Catch:{ JSONException -> 0x01cb }
            int r13 = r11.optInt(r5)     // Catch:{ JSONException -> 0x01cb }
            int r14 = com.baidu.voyager.impl.constant.VoyagerConstant.CLOUD_VOYAGER_CLOSE     // Catch:{ JSONException -> 0x01cb }
            if (r13 == r14) goto L_0x00e6
            boolean r14 = com.baidu.voyager.impl.constant.VoyagerConstant.VOYAGER_ENABLE_DEFAULT     // Catch:{ JSONException -> 0x00e1 }
            r12.setEnable(r14)     // Catch:{ JSONException -> 0x00e1 }
            goto L_0x00eb
        L_0x00e1:
            r0 = move-exception
            r19 = r6
            goto L_0x01ce
        L_0x00e6:
            boolean r14 = com.baidu.voyager.impl.constant.VoyagerConstant.VOYAGER_DISABLE     // Catch:{ JSONException -> 0x01cb }
            r12.setEnable(r14)     // Catch:{ JSONException -> 0x01cb }
        L_0x00eb:
            r14 = 0
            int r15 = r11.optInt(r4, r14)     // Catch:{ JSONException -> 0x01cb }
            long r14 = (long) r15
            r17 = r4
            r18 = r5
            r4 = 0
            int r19 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r19 <= 0) goto L_0x00ff
            r12.setExpiredTime(r14)     // Catch:{ JSONException -> 0x00e1 }
            goto L_0x0104
        L_0x00ff:
            long r4 = r1.mExpiredTime     // Catch:{ JSONException -> 0x01cb }
            r12.setExpiredTime(r4)     // Catch:{ JSONException -> 0x01cb }
        L_0x0104:
            r4 = 0
            int r4 = r11.optInt(r2, r4)     // Catch:{ JSONException -> 0x01cb }
            if (r4 <= 0) goto L_0x010f
            r12.setSingleMaxCount(r4)     // Catch:{ JSONException -> 0x00e1 }
            goto L_0x0114
        L_0x010f:
            int r5 = r1.mSingleTaskMaxCount     // Catch:{ JSONException -> 0x01cb }
            r12.setSingleMaxCount(r5)     // Catch:{ JSONException -> 0x01cb }
        L_0x0114:
            r16 = r4
            r4 = 0
            long r19 = r11.optLong(r0, r4)     // Catch:{ JSONException -> 0x01cb }
            r21 = r19
            r19 = r6
            r20 = r7
            r6 = r21
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x012c
            r12.setSingleMaxSize(r6)     // Catch:{ JSONException -> 0x01b1 }
            goto L_0x0131
        L_0x012c:
            long r4 = r1.mSingleTaskMaxSize     // Catch:{ JSONException -> 0x01b1 }
            r12.setSingleMaxSize(r4)     // Catch:{ JSONException -> 0x01b1 }
        L_0x0131:
            int r4 = r11.optInt(r3)     // Catch:{ JSONException -> 0x01b1 }
            int r5 = com.baidu.voyager.impl.constant.VoyagerConstant.NET_ACCESS_WIFI     // Catch:{ JSONException -> 0x01b1 }
            if (r4 == r5) goto L_0x013f
            int r5 = com.baidu.voyager.impl.constant.VoyagerConstant.NET_ACCESS_DEFAULT     // Catch:{ JSONException -> 0x01b1 }
            r12.setNetworkType(r5)     // Catch:{ JSONException -> 0x01b1 }
            goto L_0x0144
        L_0x013f:
            int r5 = com.baidu.voyager.impl.constant.VoyagerConstant.NET_ACCESS_WIFI     // Catch:{ JSONException -> 0x01b1 }
            r12.setNetworkType(r5)     // Catch:{ JSONException -> 0x01b1 }
        L_0x0144:
            boolean r5 = r12.isEnable()     // Catch:{ JSONException -> 0x01b1 }
            if (r5 == 0) goto L_0x018d
            long r21 = r12.getExpiredTime()     // Catch:{ JSONException -> 0x01b1 }
            r5 = r2
            r23 = r3
            long r2 = r1.mExpiredTime     // Catch:{ JSONException -> 0x01b1 }
            int r2 = (r21 > r2 ? 1 : (r21 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0188
            int r2 = r12.getSingleMaxCount()     // Catch:{ JSONException -> 0x01b1 }
            int r3 = r1.mSingleTaskMaxCount     // Catch:{ JSONException -> 0x01b1 }
            if (r2 != r3) goto L_0x0183
            long r2 = r12.getSingleMaxSize()     // Catch:{ JSONException -> 0x01b1 }
            r21 = r4
            r22 = r5
            long r4 = r1.mSingleTaskMaxSize     // Catch:{ JSONException -> 0x01b1 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0193
            int r2 = r12.getNetworkType()     // Catch:{ JSONException -> 0x01b1 }
            int r3 = r1.mNetworkType     // Catch:{ JSONException -> 0x01b1 }
            if (r2 != r3) goto L_0x0193
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r2 = r22
            r3 = r23
            goto L_0x00b1
        L_0x0183:
            r21 = r4
            r22 = r5
            goto L_0x0193
        L_0x0188:
            r21 = r4
            r22 = r5
            goto L_0x0193
        L_0x018d:
            r22 = r2
            r23 = r3
            r21 = r4
        L_0x0193:
            java.util.HashMap<java.lang.String, com.baidu.voyager.impl.config.BizConfigData> r2 = r1.mBizConfigMapData     // Catch:{ JSONException -> 0x01b1 }
            if (r2 != 0) goto L_0x019e
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ JSONException -> 0x01b1 }
            r2.<init>()     // Catch:{ JSONException -> 0x01b1 }
            r1.mBizConfigMapData = r2     // Catch:{ JSONException -> 0x01b1 }
        L_0x019e:
            java.util.HashMap<java.lang.String, com.baidu.voyager.impl.config.BizConfigData> r2 = r1.mBizConfigMapData     // Catch:{ JSONException -> 0x01b1 }
            r2.put(r10, r12)     // Catch:{ JSONException -> 0x01b1 }
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r2 = r22
            r3 = r23
            goto L_0x00b1
        L_0x01b1:
            r0 = move-exception
            goto L_0x01ce
        L_0x01b3:
            r22 = r2
            r23 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            goto L_0x00b1
        L_0x01c1:
            r19 = r6
            r20 = r7
            goto L_0x01ca
        L_0x01c6:
            r19 = r6
            r20 = r7
        L_0x01ca:
            goto L_0x01d5
        L_0x01cb:
            r0 = move-exception
            r19 = r6
        L_0x01ce:
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x01d5
            r0.printStackTrace()
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.voyager.impl.config.VoyagerConfigManager.readLocalConfig():void");
    }

    private boolean updateCloudConfig(JSONObject data) {
        int uploadTaskCount;
        int uploadInterval;
        JSONObject jSONObject = data;
        if (jSONObject == null || data.length() == 0) {
            return false;
        }
        String str = "switch";
        int enable = jSONObject.optInt(str);
        if (enable != VoyagerConstant.CLOUD_VOYAGER_CLOSE) {
            setEnable(VoyagerConstant.VOYAGER_ENABLE_DEFAULT);
        } else {
            setEnable(VoyagerConstant.VOYAGER_DISABLE);
        }
        int clear = jSONObject.optInt("clear");
        if (clear != VoyagerConstant.CLOUD_VOYAGER_CLEAR) {
            setClear(VoyagerConstant.VOYAGER_NOT_CLEAR_DEFAULT);
        } else {
            setClear(VoyagerConstant.VOYAGER_CLEAR);
        }
        int uploadInterval2 = jSONObject.optInt(VoyagerConstant.CLOUD_UPLOAD_INTERVAL);
        setUploadInterval(((long) (uploadInterval2 * 60)) * 1000);
        int uploadTaskCount2 = jSONObject.optInt(VoyagerConstant.CLOUD_MAX_COUNT_PER_ROUND);
        setUploadTaskCount(uploadTaskCount2);
        setExpiredTime(((long) (jSONObject.optInt("expired_time") * 24 * 60 * 60)) * 1000);
        setMaxFileCount(jSONObject.optInt(VoyagerConstant.CLOUD_TOTAL_MAX_COUNT));
        setMaxFileSize(((long) (jSONObject.optInt(VoyagerConstant.CLOUD_TOTAL_MAX_SIZE) * 1024)) * 1024);
        setSingleTaskMaxCount(jSONObject.optInt(VoyagerConstant.CLOUD_SINGLE_MAX_COUNT));
        int i2 = enable;
        int i3 = clear;
        setSingTaskMaxSize(((long) (jSONObject.optInt(VoyagerConstant.CLOUD_SINGLE_MAX_SIZE) * 1024)) * 1024);
        JSONObject setJson = jSONObject.optJSONObject("set");
        if (setJson == null || setJson.length() <= 0) {
            int i4 = uploadInterval2;
            int i5 = uploadTaskCount2;
            return true;
        }
        Iterator<String> it = setJson.keys();
        while (it.hasNext()) {
            String bizType = it.next();
            JSONObject bizValue = setJson.optJSONObject(bizType);
            if (bizValue == null) {
                String str2 = str;
                Iterator<String> it2 = it;
                int i6 = uploadInterval2;
                int i7 = uploadTaskCount2;
                JSONObject bizValue2 = data;
            } else if (bizValue.length() == 0) {
                JSONObject bizValue3 = data;
            } else {
                JSONObject setJson2 = setJson;
                BizConfigData bizData = new BizConfigData.Builder(bizType).build();
                Iterator<String> it3 = it;
                int bizEnable = bizValue.optInt(str);
                String str3 = str;
                if (bizEnable != VoyagerConstant.CLOUD_VOYAGER_CLOSE) {
                    bizData.setEnable(VoyagerConstant.VOYAGER_ENABLE_DEFAULT);
                } else {
                    bizData.setEnable(VoyagerConstant.VOYAGER_DISABLE);
                }
                int bizExpiredTime = bizValue.optInt("expired_time", 0);
                if (bizExpiredTime > 0) {
                    int i8 = bizEnable;
                    bizData.setExpiredTime(((long) (bizExpiredTime * 24 * 60 * 60)) * 1000);
                }
                int biz_max_count = bizValue.optInt(VoyagerConstant.CLOUD_SINGLE_MAX_COUNT, 0);
                if (biz_max_count > 0) {
                    bizData.setSingleMaxCount(biz_max_count);
                }
                int i9 = biz_max_count;
                int biz_max_size = bizValue.optInt(VoyagerConstant.CLOUD_SINGLE_MAX_SIZE, 0);
                if (biz_max_size > 0) {
                    int i10 = biz_max_size;
                    bizData.setSingleMaxSize(((long) (biz_max_size * 1024)) * 1024);
                }
                if (bizValue.has(VoyagerConstant.CLOUD_NET_TYPE)) {
                    bizData.setNetworkType(bizValue.optInt(VoyagerConstant.CLOUD_NET_TYPE));
                }
                if (bizData.isEnable() != 0) {
                    uploadInterval = uploadInterval2;
                    uploadTaskCount = uploadTaskCount2;
                    if (bizData.getExpiredTime() == this.mExpiredTime && bizData.getSingleMaxCount() == this.mSingleTaskMaxCount && bizData.getSingleMaxSize() == this.mSingleTaskMaxSize && bizData.getNetworkType() == this.mNetworkType) {
                        JSONObject bizValue4 = data;
                        setJson = setJson2;
                        it = it3;
                        str = str3;
                        uploadInterval2 = uploadInterval;
                        uploadTaskCount2 = uploadTaskCount;
                    }
                } else {
                    uploadInterval = uploadInterval2;
                    uploadTaskCount = uploadTaskCount2;
                }
                if (this.mBizConfigMapData == null) {
                    this.mBizConfigMapData = new HashMap<>();
                }
                this.mBizConfigMapData.put(bizType, bizData);
                JSONObject bizValue5 = data;
                setJson = setJson2;
                it = it3;
                str = str3;
                uploadInterval2 = uploadInterval;
                uploadTaskCount2 = uploadTaskCount;
            }
        }
        Iterator<String> it4 = it;
        int i11 = uploadInterval2;
        int i12 = uploadTaskCount2;
        return true;
    }
}
