package com.baidu.searchbox.noveladapter.feedcore;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.feed.tab.navigation.manager.TabNavDataManager;
import com.baidu.searchbox.feed.tab.navigation.manager.TabNavSchemeProcessor;
import org.json.JSONObject;

public class NovelFeedTabManagerWrapper implements NoProGuard {
    public static JSONObject processTabAction(JSONObject params) {
        return TabNavSchemeProcessor.getInstance().processTabAction(params.toString());
    }

    public static int getTabType(String tag) {
        return TabNavDataManager.getInstance().getTabType(tag);
    }
}
