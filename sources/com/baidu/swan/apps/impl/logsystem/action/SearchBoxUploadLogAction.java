package com.baidu.swan.apps.impl.logsystem.action;

import com.baidu.searchbox.feedback.log.ILogAction;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.logsystem.uploadlog.UploadLogFile;
import com.baidu.swan.apps.impl.logsystem.uploadlog.strategy.SearchBoxUploadStrategy;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchBoxUploadLogAction implements ILogAction {
    private static final String KEY_ID = "id";
    private static final String TAG = "SearchBoxUploadLogAction";

    public void dispatch(String json) {
        SwanAppLog.d(TAG, "dispatch: ", json);
        try {
            String logKey = new JSONObject(json).optString("id");
            UploadLogFile uploadLogFile = new UploadLogFile();
            uploadLogFile.setStrategy(new SearchBoxUploadStrategy());
            uploadLogFile.uploadLogFile(logKey);
        } catch (JSONException e2) {
            SwanAppLog.logToFile(TAG, "json fail", e2);
        }
    }

    public String getType() {
        return "12";
    }
}
