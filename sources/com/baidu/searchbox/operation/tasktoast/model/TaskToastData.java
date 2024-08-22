package com.baidu.searchbox.operation.tasktoast.model;

import java.io.Serializable;
import org.json.JSONObject;

public class TaskToastData implements Serializable {
    private static final int DEFAULT_TOAST_DURATION = 7;
    private static final String PARAM_BTN_TEXT = "btnText";
    private static final String PARAM_DOWNLOAD_PAGE = "downloadPage";
    private static final String PARAM_DURATION = "toastDuration";
    private static final String PARAM_MESSAGE = "message";
    private static final String PARAM_SCHEMA = "schema";
    public String btnText;
    public String downloadPage;
    public String message;
    public String scheme;
    public int toastDuration;

    public TaskToastData(JSONObject jsonObject) {
        this.message = jsonObject.optString("message");
        this.btnText = jsonObject.optString("btnText");
        this.toastDuration = jsonObject.optInt(PARAM_DURATION, 7);
        this.scheme = jsonObject.optString("schema");
        this.downloadPage = jsonObject.optString(PARAM_DOWNLOAD_PAGE);
    }
}
