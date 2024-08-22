package com.baidu.searchbox.noveladapter.player.utils;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.player.utils.VideoPlayerParamsUtil;
import org.json.JSONObject;

public class NovelVideoPlayerParamsUtilWarpper implements NoProGuard {
    public static JSONObject getPlayerSimpleCommonValue() {
        return VideoPlayerParamsUtil.getPlayerSimpleCommonValue();
    }
}
