package com.baidu.bdtask.ui.time;

import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class TimerOpData {
    private static final String DEFAULT_AWARD_COLOR = "#EC0E66";
    private static final String DEFAULT_AWARD_NIGHT_COLOR = "#33EC0E660";
    private static final String DEFAULT_PROGRESS_COLOR = "#FFC800";
    private static final String DEFAULT_PROGRESS_NIGHT_COLOR = "#33FFC800";
    private static final String KEY_ALL_FINISH_TIP = "finishToastTip";
    private static final String KEY_FEEDBACK_IMAGE_URL = "feedbackImageURL";
    private static final String KEY_PROGRESS_COLOR = "progressColor";
    private static final String KEY_PROGRESS_FILE_NAME = "progressFileName";
    private static final String KEY_PROGRESS_IMAGE_URL = "progressImageURL";
    private static final String KEY_PROGRESS_MD5 = "progressMd5";
    private static final String KEY_PROGRESS_NIGHT_COLOR = "progressNightColor";
    private static final String KEY_PROGRESS_PLACE_HOLDER_IMAGE_URL = "progressPlaceHolderImageURL";
    private static final String KEY_PROGRESS_URL = "progressURL";
    private static final String KEY_RECEIVED_AWARD_FILE_NAME = "receivedAwardFileName";
    private static final String KEY_RECEIVED_AWARD_MD5 = "receivedAwardMd5";
    private static final String KEY_RECEIVED_AWARD_PLACE_HOLDER_IMAGE_URL = "receivedAwardPlaceHolderImageURL";
    private static final String KEY_RECEIVED_AWARD_TIP = "receivedAwardTip";
    private static final String KEY_RECEIVED_AWARD_TIP_COLOR = "receivedAwardTipColor";
    private static final String KEY_RECEIVED_AWARD_TIP_LEFT_COLOR = "receivedAwardTipLeftColor";
    private static final String KEY_RECEIVED_AWARD_TIP_LEFT_NIGHT_COLOR = "receivedAwardTipLeftNightColor";
    private static final String KEY_RECEIVED_AWARD_TIP_NIGHT_COLOR = "receivedAwardTipNightColor";
    private static final String KEY_RECEIVED_AWARD_TIP_RIGHT_COLOR = "receivedAwardTipRightColor";
    private static final String KEY_RECEIVED_AWARD_TIP_RIGHT_NIGHT_COLOR = "receivedAwardTipRightNightColor";
    private static final String KEY_RECEIVED_AWARD_URL = "receivedAwardURL";
    private static final String KEY_RECEIVED_IMAGE_URL = "receivedAwardImageURL";
    private static final String KEY_SCHEME = "scheme";
    private static final String KEY_TASK_ID = "taskId";
    public String feedbackImageUrl = "";
    public String finishToastTip = "";
    public String hasReceivedImageUrl = "";
    public File progressAFXFile = null;
    public String progressColor = "";
    public String progressFileName = "";
    public String progressImageUrl = "";
    public String progressMaskTip = "";
    public String progressMd5 = "";
    public String progressNightColor = "";
    public String progressPlaceImageUrl = "";
    public String progressUrl = "";
    public File receivedAwardAFXFile = null;
    public String receivedAwardFileName = "";
    public String receivedAwardMD5 = "";
    public String receivedAwardPlaceImageUrl = "";
    public String receivedAwardTip = "";
    public String receivedAwardTipColor = "";
    public String receivedAwardTipLeftColor = "#FF5859";
    public String receivedAwardTipLeftNightColor = "#FF5859";
    public String receivedAwardTipNightColor = "";
    public String receivedAwardTipRightColor = "#FF7058";
    public String receivedAwardTipRightNightColor = "#FF7058";
    public String receivedAwardUrl = "";
    public String scheme = "";
    public String taskId = "";

    public TimerOpData(String jsonStr) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonStr);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        parseJson(jsonObject);
    }

    /* access modifiers changed from: protected */
    public void parseJson(JSONObject jsonObject) {
        if (jsonObject != null) {
            this.taskId = jsonObject.optString("taskId");
            this.scheme = jsonObject.optString("scheme");
            this.progressImageUrl = jsonObject.optString(KEY_PROGRESS_IMAGE_URL);
            this.feedbackImageUrl = jsonObject.optString(KEY_FEEDBACK_IMAGE_URL);
            this.hasReceivedImageUrl = jsonObject.optString(KEY_RECEIVED_IMAGE_URL);
            this.progressColor = jsonObject.optString(KEY_PROGRESS_COLOR, DEFAULT_PROGRESS_COLOR);
            this.progressNightColor = jsonObject.optString(KEY_PROGRESS_NIGHT_COLOR, DEFAULT_PROGRESS_NIGHT_COLOR);
            this.receivedAwardTipColor = jsonObject.optString(KEY_RECEIVED_AWARD_TIP_COLOR, DEFAULT_AWARD_COLOR);
            this.receivedAwardTipNightColor = jsonObject.optString(KEY_RECEIVED_AWARD_TIP_NIGHT_COLOR, DEFAULT_AWARD_NIGHT_COLOR);
            this.receivedAwardTip = jsonObject.optString(KEY_RECEIVED_AWARD_TIP);
            this.finishToastTip = jsonObject.optString(KEY_ALL_FINISH_TIP);
            this.receivedAwardPlaceImageUrl = jsonObject.optString(KEY_RECEIVED_AWARD_PLACE_HOLDER_IMAGE_URL);
            this.receivedAwardUrl = jsonObject.optString(KEY_RECEIVED_AWARD_URL);
            this.receivedAwardMD5 = jsonObject.optString(KEY_RECEIVED_AWARD_MD5);
            this.receivedAwardFileName = jsonObject.optString(KEY_RECEIVED_AWARD_FILE_NAME);
            this.progressPlaceImageUrl = jsonObject.optString(KEY_PROGRESS_PLACE_HOLDER_IMAGE_URL);
            this.progressUrl = jsonObject.optString(KEY_PROGRESS_URL);
            this.progressMd5 = jsonObject.optString(KEY_PROGRESS_MD5);
            this.progressFileName = jsonObject.optString(KEY_PROGRESS_FILE_NAME);
            this.receivedAwardTipLeftColor = jsonObject.optString(KEY_RECEIVED_AWARD_TIP_LEFT_COLOR);
            this.receivedAwardTipRightColor = jsonObject.optString(KEY_RECEIVED_AWARD_TIP_RIGHT_COLOR);
            this.receivedAwardTipLeftNightColor = jsonObject.optString(KEY_RECEIVED_AWARD_TIP_LEFT_NIGHT_COLOR);
            this.receivedAwardTipRightNightColor = jsonObject.optString(KEY_RECEIVED_AWARD_TIP_RIGHT_NIGHT_COLOR);
        }
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        try {
            object.put("taskId", this.taskId);
            object.put("scheme", this.scheme);
            object.put(KEY_PROGRESS_IMAGE_URL, this.progressImageUrl);
            object.put(KEY_FEEDBACK_IMAGE_URL, this.feedbackImageUrl);
            object.put(KEY_RECEIVED_IMAGE_URL, this.hasReceivedImageUrl);
            object.put(KEY_PROGRESS_COLOR, this.progressColor);
            object.put(KEY_PROGRESS_NIGHT_COLOR, this.progressNightColor);
            object.put(KEY_RECEIVED_AWARD_TIP_COLOR, this.receivedAwardTipColor);
            object.put(KEY_RECEIVED_AWARD_TIP_NIGHT_COLOR, this.receivedAwardTipNightColor);
            object.put(KEY_RECEIVED_AWARD_TIP, this.receivedAwardTip);
            object.put(KEY_ALL_FINISH_TIP, this.finishToastTip);
            object.put(KEY_RECEIVED_AWARD_PLACE_HOLDER_IMAGE_URL, this.receivedAwardPlaceImageUrl);
            object.put(KEY_RECEIVED_AWARD_URL, this.receivedAwardUrl);
            object.put(KEY_RECEIVED_AWARD_MD5, this.receivedAwardMD5);
            object.put(KEY_RECEIVED_AWARD_FILE_NAME, this.receivedAwardFileName);
            object.put(KEY_PROGRESS_PLACE_HOLDER_IMAGE_URL, this.progressPlaceImageUrl);
            object.put(KEY_PROGRESS_URL, this.progressUrl);
            object.put(KEY_PROGRESS_MD5, this.progressMd5);
            object.put(KEY_PROGRESS_FILE_NAME, this.progressFileName);
            object.put(KEY_RECEIVED_AWARD_TIP_LEFT_COLOR, this.receivedAwardTipLeftColor);
            object.put(KEY_RECEIVED_AWARD_TIP_RIGHT_COLOR, this.receivedAwardTipRightColor);
            object.put(KEY_RECEIVED_AWARD_TIP_LEFT_NIGHT_COLOR, this.receivedAwardTipLeftNightColor);
            object.put(KEY_RECEIVED_AWARD_TIP_RIGHT_NIGHT_COLOR, this.receivedAwardTipRightNightColor);
            return object;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean isValidate() {
        return !TextUtils.isEmpty(this.receivedAwardPlaceImageUrl) && !TextUtils.isEmpty(this.receivedAwardUrl) && !TextUtils.isEmpty(this.progressPlaceImageUrl) && !TextUtils.isEmpty(this.progressUrl);
    }
}
