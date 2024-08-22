package com.yy.sdk.crashreportbaidu;

import android.content.Context;
import android.content.SharedPreferences;
import com.yy.sdk.crashreportbaidu.ReportInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportDB<T extends ReportInfo> {
    private static final int MAX_SIZE = 30;
    private static final String TAG = "ReportDB";
    private final SharedPreferences mSharedPref;

    public ReportDB(Context context, String name) {
        this.mSharedPref = context.getSharedPreferences(name, 0);
    }

    public String add(T reportInfo) {
        if (reportInfo == null) {
            return "anr info is null";
        }
        Log.i(TAG, "add info: " + reportInfo.crashId);
        try {
            List<T> infos = getAll();
            int currentSize = infos.size();
            SharedPreferences.Editor editor = this.mSharedPref.edit();
            for (int i2 = 0; i2 <= currentSize - 30; i2++) {
                ReportInfo info = (ReportInfo) infos.get(i2);
                info.clearFiles(info.fileList);
                editor.remove(info.crashId);
            }
            editor.putString(reportInfo.crashId, reportInfo.serialize()).commit();
            return null;
        } catch (IOException e2) {
            String errorMsg = ReportUtils.getStackTrace(e2);
            Log.e(TAG, errorMsg, e2);
            return errorMsg;
        }
    }

    public List<T> getAll() {
        List<T> ret = new ArrayList<>();
        Map<String, ?> all = this.mSharedPref.getAll();
        if (all == null || all.isEmpty()) {
            return ret;
        }
        for (Map.Entry<String, String> data : all.entrySet()) {
            try {
                ret.add((ReportInfo) ReportInfo.deserialize(data.getValue()));
                Log.i(TAG, String.format("read info:%s", new Object[]{data.getKey()}));
            } catch (Exception e2) {
                delete(data.getKey());
                Log.e(TAG, String.format("read info error:[%s] %s", new Object[]{data.getKey(), ReportUtils.getStackTrace(e2)}));
            }
        }
        Log.i(TAG, "get all size: " + ret.size());
        return ret;
    }

    public void delete(String crashId) {
        Log.i(TAG, "delete info: " + crashId);
        if (this.mSharedPref.contains(crashId)) {
            this.mSharedPref.edit().remove(crashId).commit();
        }
    }

    public void clear() {
        this.mSharedPref.edit().clear().commit();
    }
}
