package com.baidu.searchbox.feed.tab.managev2;

import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import java.util.List;
import org.json.JSONObject;

public interface MultiTabCityTabChangeListener {
    void addCityTab(List<MultiTabItemInfo> list);

    void deleteCityTab(List<String> list);

    JSONObject getAddedCityTab();
}
