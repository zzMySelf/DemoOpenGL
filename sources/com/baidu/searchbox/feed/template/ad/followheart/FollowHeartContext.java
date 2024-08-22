package com.baidu.searchbox.feed.template.ad.followheart;

import android.graphics.Rect;
import java.util.HashSet;
import java.util.Set;

public class FollowHeartContext {
    private static Set<String> sFollowHeartAdSet = new HashSet();
    private static int[] sRecyclerViewLocation = null;

    public static Rect getFeedRecyclerViewRect() {
        int[] locations = sRecyclerViewLocation;
        if (locations == null || locations.length != 4) {
            return null;
        }
        return new Rect(locations[0], locations[1], locations[2], locations[3]);
    }

    public static void calculateViewRectOnScreen(Rect rect) {
        sRecyclerViewLocation = new int[]{0, 0, rect.width(), rect.height()};
    }

    public static boolean hasFollowHeartAd() {
        Set<String> set = sFollowHeartAdSet;
        return set != null && set.size() > 0;
    }

    public static void handleFollowHeartAd(boolean isAdd, String id) {
        Set<String> set = sFollowHeartAdSet;
        if (set == null) {
            return;
        }
        if (isAdd) {
            set.add(id);
        } else {
            set.remove(id);
        }
    }
}
