package com.baidu.searchbox.pms.statistic;

import org.json.JSONObject;

public class StatisticCallbackImpl implements StatisticCallback {
    public boolean addFetchStatistic2InHost(int errCode, String errMsg, String channelIds, JSONObject degradeData) {
        return false;
    }

    public boolean addDownloadStatistic2(int errCode, String errMsg, String channelId, String packageName, long version, String url, String ipAddress, int networkType, int retryCount) {
        return false;
    }
}
