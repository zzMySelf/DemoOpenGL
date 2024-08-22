package com.baidu.swan.pms.node.common;

import android.text.TextUtils;
import com.baidu.swan.pms.node.INodeManager;
import com.baidu.swan.pms.utils.AbsPMSLog;
import com.baidu.swan.utils.SwanDefaultSharedPrefsImpl;
import org.json.JSONObject;

public final class ExceptionUploadSampleManager implements INodeManager {
    private static final AbsPMSLog LOG = AbsPMSLog.getPMSNodeLog();
    private static final String TAG = "ExceptionUploadSampleManager";
    private static volatile ExceptionUploadSampleManager sInstance = new ExceptionUploadSampleManager();
    private final ExceptionUploadPrefs mPrefs = new ExceptionUploadPrefs();

    private ExceptionUploadSampleManager() {
    }

    public static ExceptionUploadSampleManager getInstance() {
        ExceptionUploadSampleManager nonNullResult = sInstance;
        if (nonNullResult == null) {
            synchronized (ExceptionUploadSampleManager.class) {
                nonNullResult = sInstance;
                if (nonNullResult == null) {
                    sInstance = new ExceptionUploadSampleManager();
                    nonNullResult = sInstance;
                }
            }
        }
        return nonNullResult;
    }

    public static synchronized void release() {
        synchronized (ExceptionUploadSampleManager.class) {
            sInstance = null;
        }
    }

    public void process(JSONObject nodeJo) {
        if (nodeJo == null) {
            LOG.logInfo(TAG, "#process nodeJo=null");
            return;
        }
        String version = nodeJo.optString("version");
        if (TextUtils.isEmpty(version)) {
            LOG.logInfo(TAG, "#process 'version' is empty");
            return;
        }
        String data = nodeJo.optString("data");
        if (TextUtils.isEmpty(data)) {
            LOG.logInfo(TAG, "#process 'data' is empty");
        } else {
            this.mPrefs.edit().putString("version", version).putString("data", data).apply();
        }
    }

    public String getVersion() {
        return this.mPrefs.getString("version", "0");
    }

    public String getData() {
        return this.mPrefs.getString("data", "");
    }

    public static class ExceptionUploadPrefs extends SwanDefaultSharedPrefsImpl {
        public static final String PREF_NAME = "exception_upload";

        ExceptionUploadPrefs() {
            super(PREF_NAME);
        }
    }
}
