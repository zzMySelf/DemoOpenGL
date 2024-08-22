package com.baidu.swan.apps.impl.media.video.event;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.view.container.util.SwanAppEventHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoStatusEventHelper {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String EVENT_BARRAGE_BTN_CHANGED = "danmubtnchange";
    public static final String EVENT_FALSE = "0";
    private static final String EVENT_NAME_VIDEO = "video";
    public static final String EVENT_TRUE = "1";
    public static final String EVENT_TYPE_END = "ended";
    public static final String EVENT_TYPE_ERROR = "error";
    public static final String EVENT_TYPE_FULLSCREEN = "fullscreenchange";
    public static final String EVENT_TYPE_PAUSE = "pause";
    public static final String EVENT_TYPE_PLAY = "play";
    public static final String EVENT_TYPE_UPDATE_PROGRESS = "timeupdate";
    public static final String EVENT_TYPE_WAITING = "waiting";
    public static final String KEY_EVENT_BARRAGE_BTN_CHANGED = "danmubtnenabled";
    private static final String KEY_EVENT_DATA = "data";
    public static final String KEY_EVENT_DIRECTION = "direction";
    public static final String KEY_EVENT_DURATION = "duration";
    public static final String KEY_EVENT_FULLSCREEN = "fullscreen";
    public static final String KEY_EVENT_HEIGHT = "height";
    public static final String KEY_EVENT_POSITION = "currentTime";
    private static final String KEY_EVENT_TYPE = "vtype";
    private static final String KEY_EVENT_VIDEO_ID = "videoId";
    public static final String KEY_EVENT_WIDTH = "width";
    private static final String KEY_EVENT_WVID = "wvID";
    private static final String TAG = "VideoStatusEventHelper";

    public static void dispatchEvent(String playerId, String slaveId, String type, JSONObject data) {
        if (!TextUtils.isEmpty(slaveId) && !TextUtils.isEmpty(playerId)) {
            JSONObject eventObj = new JSONObject();
            try {
                eventObj.put("wvID", slaveId);
                eventObj.put("vtype", type);
                data.putOpt(KEY_EVENT_VIDEO_ID, playerId);
                eventObj.put("data", data.toString());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            SwanAppLog.i(TAG, "Video dispatch Params : " + eventObj.toString());
            SwanAppEventHelper.sendEventToSlave(slaveId, playerId, "video", type, eventObj);
        } else if (DEBUG) {
            Log.e(TAG, "dispatchNetStatusEvent failed slaveId: " + slaveId + " ,videoId: " + playerId);
        }
    }
}
