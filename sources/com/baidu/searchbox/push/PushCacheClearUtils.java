package com.baidu.searchbox.push;

import android.util.Log;
import com.baidu.searchbox.bridge.PushRuntime;
import java.io.File;

public class PushCacheClearUtils {
    private static final String KEY_CLEARED_PUSH_TRACK_DB = "key_cleared_push_track_db";
    private static final String PUSH_TRACK_DB_NAME = "push_track.db";
    private static final String TAG = "PushCacheClearUtils";

    public static void clearPushCache() {
        clearPushTrackDb();
    }

    private static void clearPushTrackDb() {
        if (PushRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "clearPushTrackDb");
        }
        if (!PushSharedPrefsWrapper.getInstance().getBoolean(KEY_CLEARED_PUSH_TRACK_DB, false)) {
            try {
                File trackDb = PushRuntime.getAppContext().getDatabasePath(PUSH_TRACK_DB_NAME);
                if (trackDb == null) {
                    if (PushRuntime.GLOBAL_DEBUG) {
                        Log.d(TAG, "clearPushTrackDb file is null");
                    }
                } else if (!trackDb.exists()) {
                    if (PushRuntime.GLOBAL_DEBUG) {
                        Log.d(TAG, "clearPushTrackDb file is not exists");
                    }
                    PushSharedPrefsWrapper.getInstance().putBoolean(KEY_CLEARED_PUSH_TRACK_DB, true);
                } else if (trackDb.isFile()) {
                    boolean deleteResult = trackDb.delete();
                    PushSharedPrefsWrapper.getInstance().putBoolean(KEY_CLEARED_PUSH_TRACK_DB, deleteResult);
                    if (PushRuntime.GLOBAL_DEBUG) {
                        Log.d(TAG, "clearPushTrackDb deleteResult = " + deleteResult);
                    }
                } else {
                    PushSharedPrefsWrapper.getInstance().putBoolean(KEY_CLEARED_PUSH_TRACK_DB, true);
                }
            } catch (Exception e2) {
                if (PushRuntime.GLOBAL_DEBUG) {
                    Log.e(TAG, "clearPushTrackDb exception ", e2);
                }
            }
        } else if (PushRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "clearPushTrackDb already deleted, return");
        }
    }
}
