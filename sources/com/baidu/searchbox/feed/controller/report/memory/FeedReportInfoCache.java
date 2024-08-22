package com.baidu.searchbox.feed.controller.report.memory;

import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.controller.report.interfaces.IReportInfoCache;
import com.baidu.searchbox.feed.model.ReportInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FeedReportInfoCache implements IReportInfoCache {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String TAG = "FeedReportInfoCache";
    private ConcurrentHashMap<String, ReportInfo> mReportInfos = new ConcurrentHashMap<>();

    public void clear(long lastRefreshTime) {
        Iterator<Map.Entry<String, ReportInfo>> it = this.mReportInfos.entrySet().iterator();
        while (it.hasNext()) {
            ReportInfo cache = it.next().getValue();
            if (cache.displayTime < lastRefreshTime && cache.clickTime < lastRefreshTime) {
                it.remove();
            }
        }
    }

    public void put(String nid, ReportInfo info) {
        this.mReportInfos.put(nid, info);
    }

    public ReportInfo get(String nid) {
        return this.mReportInfos.get(nid);
    }

    public Collection<ReportInfo> getReportInfos() {
        return this.mReportInfos.values();
    }

    public int getSize() {
        return this.mReportInfos.size();
    }
}
