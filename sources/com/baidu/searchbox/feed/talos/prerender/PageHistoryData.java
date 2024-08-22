package com.baidu.searchbox.feed.talos.prerender;

import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.talos.utils.FeedTalosExceptionUtilKt;
import java.util.Map;

public class PageHistoryData extends PageDataLRUList<String, Integer> {
    private static final String CLASS_NAME = PageHistoryData.class.getSimpleName();
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String TAG = "RNPageCacheHistoryData";

    public PageHistoryData(int cacheSize) {
        super(cacheSize);
    }

    public void readDataFromSp() {
        String[] split = this.mCacheSP.getString(RNPageCacheConst.HISTORY_LIST_KEY_NAME, "").split(",");
        if (split != null && split.length != 0) {
            for (String oneData : split) {
                String oneData2 = oneData.trim();
                if (!oneData2.isEmpty()) {
                    String[] splitOneData = oneData2.split("#");
                    if (splitOneData == null || splitOneData.length != 2) {
                        FeedTalosExceptionUtilKt.doThrow(new RuntimeException("data in sp is error!"), CLASS_NAME, false);
                    } else {
                        String key = updateKeyFromOld(splitOneData[0]);
                        if (key == null) {
                            FeedTalosExceptionUtilKt.doThrow(new RuntimeException("解析key失败"), CLASS_NAME, false);
                        } else {
                            try {
                                put(key, Integer.valueOf(splitOneData[1]));
                            } catch (NumberFormatException e2) {
                                if (DEBUG) {
                                    throw e2;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void saveDataToSp() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : entrySet()) {
            sb.append(entry.getKey());
            sb.append("#");
            sb.append(entry.getValue());
            sb.append(",");
        }
        String toSave = sb.toString();
        if (!toSave.isEmpty()) {
            this.mCacheSP.putString(RNPageCacheConst.HISTORY_LIST_KEY_NAME, toSave);
        }
    }
}
