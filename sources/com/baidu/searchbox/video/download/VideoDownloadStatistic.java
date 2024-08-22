package com.baidu.searchbox.video.download;

import android.text.TextUtils;
import com.baidu.searchbox.video.runtime.VideoRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public final class VideoDownloadStatistic {
    public static final int DOWNLOAD_URI_IS_INVALID = 70000;
    public static final String ERROR_FIELD_HEADER = "header";
    public static final String ERROR_FIELD_HEADER_VALUE = "header does Not exist";
    public static final int GET_EPISODE_LIST_DATA_ERROR = 90000;
    public static final int GET_EPISODE_LIST_NETWORK_ERROR = 80000;
    public static final int GET_FAIL = 20000;
    public static final int GET_FAIL_HEADER_ERROR = 3;
    public static final int GET_FAIL_ILLEGAL_ARGUMENT = 1;
    public static final int GET_FAIL_NETWORK_ERROR = 2;
    public static final int GET_FAIL_PARAMS_ERROR = 4;
    public static final int GET_LOAD_PAGE_FAIL = 40000;
    public static final int GET_NETWORK_FAIL = 50000;
    public static final int GET_TOKEN_FAIL = 30000;
    public static final String JSON_IS_NULL = "json is null";
    private static final String JSON_KEY_CLIENT_ERROR_CODE = "cErrorCode";
    private static final String JSON_KEY_EPISODE_ID = "episode_id";
    private static final String JSON_KEY_ERROR_FIELD = "errorField";
    private static final String JSON_KEY_ERROR_MESSAGE = "errorMsg";
    private static final String JSON_KEY_ERROR_VALUE = "errorValue";
    private static final String JSON_KEY_FORMAT = "format";
    private static final String JSON_KEY_JSON_STRING = "jsonStr";
    private static final String JSON_KEY_REQUEST_URL = "requestUrl";
    private static final String JSON_KEY_SERVER_ERROR_CODE = "sErrorCode";
    public static final int PAGE_JS_CALLBACK_ERROR = 200000;
    public static final int PARSE_DOWNLOAD_URL_ERROR_BY_WEB_ADDRESS = 60000;
    public static final String TOKEN_IS_NULL = "token is null";
    public static final String URI_IS_INVALID = "uri is invalid";
    public static final String URL_IS_NULL = "url is null";
    public static final int VIDEO_DOWNLOADING_ERROR = 100000;

    private VideoDownloadStatistic() {
    }

    public static void sendVideoDownloadGMVMsg(VideoDownloadGMV videoDownloadGMV) {
        if (videoDownloadGMV != null) {
            JSONObject jObj = new JSONObject();
            try {
                if (!TextUtils.isEmpty(videoDownloadGMV.getRequestUrl())) {
                    jObj.put(JSON_KEY_REQUEST_URL, videoDownloadGMV.getRequestUrl());
                }
                if (!TextUtils.isEmpty(videoDownloadGMV.getErrorField())) {
                    jObj.put(JSON_KEY_ERROR_FIELD, videoDownloadGMV.getErrorField());
                }
                if (!TextUtils.isEmpty(videoDownloadGMV.getErrorValue())) {
                    jObj.put(JSON_KEY_ERROR_VALUE, videoDownloadGMV.getErrorValue());
                }
                if (videoDownloadGMV.getErrorCode() != null) {
                    jObj.put(JSON_KEY_CLIENT_ERROR_CODE, videoDownloadGMV.getErrorCode());
                }
                if (videoDownloadGMV.getsErrorCode() != null) {
                    jObj.put(JSON_KEY_SERVER_ERROR_CODE, videoDownloadGMV.getsErrorCode());
                }
                if (!TextUtils.isEmpty(videoDownloadGMV.getErrorMsg())) {
                    jObj.put("errorMsg", videoDownloadGMV.getErrorMsg());
                }
                if (!TextUtils.isEmpty(videoDownloadGMV.getJsonStr())) {
                    jObj.put(JSON_KEY_JSON_STRING, videoDownloadGMV.getJsonStr());
                }
                if (!TextUtils.isEmpty(videoDownloadGMV.getEpisodeId())) {
                    jObj.put(JSON_KEY_EPISODE_ID, videoDownloadGMV.getEpisodeId());
                }
                if (!TextUtils.isEmpty(videoDownloadGMV.getFormat())) {
                    jObj.put("format", videoDownloadGMV.getFormat());
                }
                VideoRuntime.getVideoContext().sendGMVLog(jObj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
