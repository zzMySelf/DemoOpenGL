package com.baidu.searchbox.sport.page.match.model;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.container.creator.PageParams;
import com.baidu.searchbox.nacomp.util.CollectionUtils;
import com.baidu.searchbox.sport.model.CommonModelFactory;
import com.baidu.searchbox.sport.model.MatchInfo;
import com.baidu.searchbox.sport.model.ShareInfo;
import com.baidu.searchbox.sport.model.SubscribeInfo;
import com.baidu.searchbox.sport.model.TabInfo;
import java.util.List;
import org.json.JSONObject;
import rx.functions.Func1;

public class MatchModelFactory {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final int DEFAULT_BACKGROUND = -13421773;
    public static final long DEFAULT_REFRESH_INTERVAL = 10000;
    public static final Func1<JSONObject, MatchPageModel> GET_MATCH_HEAD = new Func1<JSONObject, MatchPageModel>() {
        public MatchPageModel call(JSONObject json) {
            if (json == null) {
                return null;
            }
            MatchInfo matchInfo = CommonModelFactory.PARSE_MATCH_INFO.call(json.optJSONObject("matchInfo"));
            List<TabInfo> tabList = CommonModelFactory.PARSE_TABS.call(json.optJSONArray(PageParams.KEY_TAB_INFO));
            if (matchInfo == null || CollectionUtils.isEmpty(tabList)) {
                return null;
            }
            MatchPageModel model = new MatchPageModel();
            model.matchInfo = matchInfo;
            model.tabList = tabList;
            model.extInfo = CommonModelFactory.PARSE_MATCH_EXT_MODEL.call(json.optJSONObject("extInfo"));
            model.liveModel = CommonModelFactory.PARSE_LIVE_MODEL.call(json.optJSONObject("liveInfo"));
            model.subscribeInfo = SubscribeInfo.Companion.parseSubInfo(json.optJSONObject("subscribeInfo"));
            model.shareInfo = ShareInfo.Companion.parseShareInfo(json.optJSONObject("shareInfo"));
            return model;
        }
    };
}
