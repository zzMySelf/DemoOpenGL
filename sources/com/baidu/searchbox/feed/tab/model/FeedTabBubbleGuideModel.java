package com.baidu.searchbox.feed.tab.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedTabBubbleGuideModel {
    private static final String BUBBLE_TAG = "BuBBle";
    public static final int INT_FALLBACK = -1;
    private static final String KEY_COMEBACK_TIMES = "comeBackTimes";
    private static final String KEY_END_TIME = "end";
    private static final String KEY_INTERVAL_DAYS = "intervalDays";
    private static final String KEY_IS_CEILING_SHOW = "isCeilingShow";
    private static final String KEY_IS_CONTROL_BY_SERVICE = "isControlByService";
    private static final String KEY_MAX_TIMES = "maxTimes";
    private static final String KEY_MAX_TIMES_ONE_DAY = "maxTimesOneDay";
    private static final String KEY_NO_CLICK_TIMES_EXIT = "noClickTimesExit";
    private static final String KEY_SCROLL_SHOW_TAB = "scrollShowTab";
    private static final String KEY_START_TIME = "start";
    private static final String KEY_TEXT = "text";
    private static final String KEY_VERSION = "version";
    public static final String ONE_DEFAULT = "1";
    public static final String PLUS_ID = "plus";
    public int comeBackTimes;
    public long endTime;
    public int intervalDays;
    public boolean isCeilingShow;
    public boolean isControlByService;
    public int maxTimes;
    public int maxTimesOneDay;
    public int noClickTimesExit;
    public String scrollShowTab;
    public long startTime;
    public String tabId = "";
    public String text;
    public String version;

    public static JSONObject toJson(FeedTabBubbleGuideModel guideModel) {
        if (guideModel == null) {
            return null;
        }
        JSONObject guideModelJson = new JSONObject();
        try {
            guideModelJson.put("text", guideModel.text);
            guideModelJson.put(KEY_SCROLL_SHOW_TAB, guideModel.scrollShowTab);
            guideModelJson.put("version", guideModel.version);
            guideModelJson.put("start", guideModel.startTime);
            guideModelJson.put("end", guideModel.endTime);
            guideModelJson.put(KEY_MAX_TIMES, guideModel.maxTimes);
            guideModelJson.put("intervalDays", guideModel.intervalDays);
            String str = "1";
            guideModelJson.put(KEY_IS_CEILING_SHOW, guideModel.isCeilingShow ? str : "0");
            guideModelJson.put(KEY_MAX_TIMES_ONE_DAY, guideModel.maxTimesOneDay);
            guideModelJson.put(KEY_NO_CLICK_TIMES_EXIT, guideModel.noClickTimesExit);
            guideModelJson.put(KEY_COMEBACK_TIMES, guideModel.comeBackTimes);
            if (!guideModel.isControlByService) {
                str = "0";
            }
            guideModelJson.put(KEY_IS_CONTROL_BY_SERVICE, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return guideModelJson;
    }

    public static FeedTabBubbleGuideModel parseFromJson(JSONObject guideModelJson) {
        if (guideModelJson == null) {
            return null;
        }
        FeedTabBubbleGuideModel guideModel = new FeedTabBubbleGuideModel();
        guideModel.text = guideModelJson.optString("text");
        guideModel.scrollShowTab = guideModelJson.optString(KEY_SCROLL_SHOW_TAB);
        guideModel.version = guideModelJson.optString("version", "");
        guideModel.startTime = guideModelJson.optLong("start", -1);
        guideModel.endTime = guideModelJson.optLong("end", -1);
        guideModel.maxTimes = guideModelJson.optInt(KEY_MAX_TIMES, 0);
        guideModel.intervalDays = Math.max(guideModelJson.optInt("intervalDays", 0), 0);
        guideModel.isCeilingShow = "1".equals(guideModelJson.optString(KEY_IS_CEILING_SHOW, "1"));
        guideModel.maxTimesOneDay = guideModelJson.optInt(KEY_MAX_TIMES_ONE_DAY, -1);
        guideModel.noClickTimesExit = guideModelJson.optInt(KEY_NO_CLICK_TIMES_EXIT, -1);
        guideModel.comeBackTimes = guideModelJson.optInt(KEY_COMEBACK_TIMES, -1);
        guideModel.isControlByService = TextUtils.equals(guideModelJson.optString(KEY_IS_CONTROL_BY_SERVICE, "0"), "1");
        return guideModel;
    }

    public boolean isValidate() {
        boolean timeValidate;
        long currentTime = System.currentTimeMillis() / 1000;
        long j2 = this.startTime;
        if (j2 > 0) {
            long j3 = this.endTime;
            if (j3 > 0 && currentTime >= j2 && currentTime <= j3) {
                timeValidate = true;
                if (!TextUtils.isEmpty(this.text) || !TextUtils.isEmpty(this.version) || !timeValidate) {
                    return false;
                }
                return true;
            }
        }
        timeValidate = false;
        if (!TextUtils.isEmpty(this.text) && !TextUtils.isEmpty(this.version)) {
        }
        return false;
    }
}
