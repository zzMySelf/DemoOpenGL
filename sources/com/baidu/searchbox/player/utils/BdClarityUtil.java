package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.model.ClaritySelectModel;
import com.baidu.searchbox.player.model.ClarityUrlList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class BdClarityUtil {
    public static final int sUnSelectedValue = -2;
    private static int sUserOptionClarity = -2;

    public static void setUserOptionClarity(int clarity) {
        sUserOptionClarity = clarity;
        VideoClarity.saveUserOptionClarityIfNeed(clarity);
    }

    public static int getUserOptionClarity() {
        int userOptionClarityIfNeed = VideoClarity.getUserOptionClarityIfNeed(sUserOptionClarity);
        sUserOptionClarity = userOptionClarityIfNeed;
        return userOptionClarityIfNeed;
    }

    public static void saveClarityAutoMode(boolean isClarityAutoMode) {
        VideoPlayerSpUtil.getInstance().putBoolean(VideoClaritySpUtil.KEY_CLARITY_AUTO_MODE_USER, isClarityAutoMode);
    }

    public static boolean isClarityAutoMode() {
        return VideoPlayerSpUtil.getInstance().getBoolean(VideoClaritySpUtil.KEY_CLARITY_AUTO_MODE_USER, false);
    }

    public static void saveUserClarity() {
        VideoPlayerSpUtil.getInstance().putBoolean(VideoClaritySpUtil.KEY_CLARITY_USER_ALREADY, true);
    }

    public static boolean isUserClarity() {
        return VideoPlayerSpUtil.getInstance().getBoolean(VideoClaritySpUtil.KEY_CLARITY_USER_ALREADY, false);
    }

    public static JSONObject getAdjustOptionClarity(JSONArray prefetchVideo) {
        ClarityUrlList list = new ClarityUrlList(prefetchVideo);
        clearAutoItem(list);
        if (list.size() == 0) {
            return null;
        }
        HashMap<String, JSONObject> tmpMap = new HashMap<>();
        for (int i2 = 0; i2 < prefetchVideo.length(); i2++) {
            JSONObject tmpObj = prefetchVideo.optJSONObject(i2);
            if (tmpObj != null) {
                tmpMap.put(tmpObj.optString("rank"), tmpObj);
            }
        }
        return tmpMap.get(String.valueOf(((ClarityUrlList.ClarityUrl) list.get(list.getDefaultClarity())).getOriginRank()));
    }

    public static ClaritySelectModel getShortVideoVideoClarityStrategy(ClarityUrlList list, double sdClarityScore, int preferredClarityRank) {
        clearAutoItem(list);
        int userOptionClarityIfNeed = VideoClarity.getUserOptionClarityIfNeed(sUserOptionClarity);
        sUserOptionClarity = userOptionClarityIfNeed;
        return MultiPlanSmartClarityStrategyKt.getShortVideoClarityByCloud(list, userOptionClarityIfNeed, sdClarityScore, preferredClarityRank);
    }

    private static void clearAutoItem(ClarityUrlList list) {
        ClarityUrlList.ClarityUrl autoClarity = null;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ClarityUrlList.ClarityUrl clarityUrl = (ClarityUrlList.ClarityUrl) it.next();
            if ("auto".equals(clarityUrl.getKey())) {
                autoClarity = clarityUrl;
                break;
            }
        }
        if (autoClarity != null) {
            list.remove(autoClarity);
        }
    }

    public static void clearUserOptionClarity() {
        sUserOptionClarity = -2;
    }
}
