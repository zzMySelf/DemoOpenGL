package com.baidu.searchbox.feed.template;

import java.util.HashSet;
import java.util.Set;

public class GuardianTemplateContext {
    private static Set<String> sGuardianTempSet = new HashSet();

    public static boolean hasGuardianTempAd() {
        Set<String> set = sGuardianTempSet;
        return set != null && set.size() > 0;
    }

    public static void handleGuardianTempAd(boolean isAdd, String id) {
        Set<String> set = sGuardianTempSet;
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
