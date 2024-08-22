package com.baidu.searchbox.browserenhanceengine.browserhistory;

import java.util.LinkedHashMap;

public class BrowserHistoryManagerNew {
    private LinkedHashMap<String, String> mHistoryList = new LinkedHashMap<>();

    public void addHistory(String containerId, String url) {
        this.mHistoryList.put(containerId, url);
    }

    public String getHistory(String containerId) {
        return this.mHistoryList.get(containerId);
    }
}
