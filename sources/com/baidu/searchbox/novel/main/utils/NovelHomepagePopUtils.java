package com.baidu.searchbox.novel.main.utils;

import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;

public class NovelHomepagePopUtils {
    public static void removePopExclusion(ExclusionType type) {
        PopupExclusionManagerMap.getInstance().unDisplay("scene_home", type);
    }
}
