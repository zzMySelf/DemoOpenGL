package com.baidu.searchbox.ugc.manager;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.ugc.dialog.UgcInterestAuthenDialog;
import com.baidu.searchbox.ugc.listener.UgcInterestAuthenUpdateListener;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class UgcInterestAuthenPopManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final int HOUR = 3600000;
    public static final String KEY_UGC_POP_HAS_SHOWN_TIME_PREFIX = "ugc_pop_has_shown_time_";
    public static final String KEY_UGC_POP_LAST_SHOW_TIME_PREFIX = "ugc_pop_last_show_time_";
    public static final String KEY_UGC_POP_PRIORITY_PREFIX = "ugc_pop_priority_";
    private static final String TAG = UgcInterestAuthenPopManager.class.getSimpleName();

    public static boolean showDialog(PublishModels.PublishResultInfo info, String sourceFrom, String from) {
        if (info == null || info.data == null || info.data.subData == null || info.data.subData.popInfo == null) {
            if (DEBUG) {
                Log.d(TAG, "showDialog: the pop info is null");
            }
            return false;
        }
        DefaultSharedPrefsWrapper instance = DefaultSharedPrefsWrapper.getInstance();
        ArrayList<PublishModels.PopInfo> popInfoList = info.data.subData.popInfo;
        Collections.sort(popInfoList, new UgcInterestAuthenPopManager$$ExternalSyntheticLambda0(instance));
        Iterator<PublishModels.PopInfo> it = popInfoList.iterator();
        while (it.hasNext()) {
            PublishModels.PopInfo popInfo = it.next();
            if (!TextUtils.isEmpty(popInfo.key)) {
                if (!shouldShowDialog(popInfo.key)) {
                    if (DEBUG) {
                        Log.d(TAG, "showDialog: should not show dialog");
                    }
                } else if (UgcInterestAuthenDialog.showDialog(popInfo, sourceFrom, from)) {
                    int hasShownTimes = instance.getInt(KEY_UGC_POP_HAS_SHOWN_TIME_PREFIX + popInfo.key, 0);
                    instance.putLong(KEY_UGC_POP_LAST_SHOW_TIME_PREFIX + popInfo.key, System.currentTimeMillis());
                    instance.putInt(KEY_UGC_POP_HAS_SHOWN_TIME_PREFIX + popInfo.key, hasShownTimes + 1);
                    UgcUBCUtils.ubcInterestPopShow(popInfo.key, sourceFrom, from);
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ int lambda$showDialog$0(DefaultSharedPrefsWrapper instance, PublishModels.PopInfo o1, PublishModels.PopInfo o2) {
        if (!TextUtils.isEmpty(o1.key) && instance.getInt("ugc_pop_priority_" + o2.key, 0) >= instance.getInt("ugc_pop_priority_" + o1.key, 0)) {
            return -1;
        }
        return 1;
    }

    private static boolean shouldShowDialog(String type) {
        DefaultSharedPrefsWrapper instance = DefaultSharedPrefsWrapper.getInstance();
        int cycleTime = instance.getInt(UgcInterestAuthenUpdateListener.KEY_UGC_POP_CYCLE_HOUR_PREFIX + type, 0);
        int maxShowTimes = instance.getInt(UgcInterestAuthenUpdateListener.KEY_UGC_POP_MAX_SHOW_TIME_PREFIX + type, 0);
        int hasShownTimes = instance.getInt(KEY_UGC_POP_HAS_SHOWN_TIME_PREFIX + type, 0);
        long lastShowTime = instance.getLong(KEY_UGC_POP_LAST_SHOW_TIME_PREFIX + type, 0);
        long showTimeDiff = (System.currentTimeMillis() - lastShowTime) - ((long) (3600000 * cycleTime));
        if (DEBUG) {
            Log.d(TAG, "shouldShowDialog: cycleTime: " + cycleTime + " mHasShownTimes:" + hasShownTimes + " maxShowTimes:" + maxShowTimes + " lastShowTime:" + lastShowTime + " diff:" + showTimeDiff);
        }
        if (showTimeDiff <= 0 || hasShownTimes >= maxShowTimes) {
            return false;
        }
        return true;
    }
}
