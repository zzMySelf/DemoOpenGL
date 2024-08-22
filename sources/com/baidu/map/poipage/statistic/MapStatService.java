package com.baidu.map.poipage.statistic;

import android.text.TextUtils;
import com.baidu.map.poipage.utils.MLog;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.duration.pyramid.ISearchDuration;
import com.baidu.search.duration.pyramid.ISearchDurationStat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MapStatService {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "MapStatService";
    private JSONObject extra843;
    private String page = "";
    private ISearchDurationStat searchDurationStat;
    private final UBCManager ubcManager = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE));

    public MapStatService(String page2) {
        this.page = page2;
    }

    public void onMapStatEvent(String type, String source, String value, JSONObject extra) {
        onMapStatEvent(MapStats.MAP_STAT_ID, "search", type, this.page, source, value, extra);
    }

    public void onMapStatEvent(String id, String from, String type, String page2, String source, String value, Object ext) {
        JSONObject params = new JSONObject();
        try {
            params.put("from", from);
            params.put("type", type);
            if (!TextUtils.isEmpty(page2)) {
                params.put("page", page2);
            }
            if (!TextUtils.isEmpty(source)) {
                params.put("source", source);
            }
            if (!TextUtils.isEmpty(value)) {
                params.put("value", value);
            }
            if (ext != null) {
                params.put("ext", ext);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        this.ubcManager.onEvent(id, params);
    }

    public void add843ExtraInfo(Map<String, Object> extra) {
        if (this.extra843 == null) {
            this.extra843 = new JSONObject();
        }
        if (extra != null && !extra.isEmpty()) {
            for (Map.Entry<String, Object> entry : extra.entrySet()) {
                try {
                    this.extra843.put(entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void add843ExtraInfo(String key, Object value) {
        if (this.extra843 == null) {
            this.extra843 = new JSONObject();
        }
        try {
            this.extra843.put(key, value);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void onPageStart() {
        ISearchDuration iSearchDuration = (ISearchDuration) ServiceManager.getService(ISearchDuration.Companion.getSERVICE_REFERENCE());
        ISearchDuration searchDuration = iSearchDuration;
        if (iSearchDuration != null) {
            this.searchDurationStat = searchDuration.getSearchNoH5StatInstance((String) null).startLogDuration();
        }
    }

    public void onPageEnd(String source, String value) {
        ISearchDurationStat iSearchDurationStat = this.searchDurationStat;
        if (iSearchDurationStat != null) {
            iSearchDurationStat.setSource(source).setExtraValue(this.extra843).setValue(value).endLogDuration();
        }
    }

    public static class ErrorMapStatService extends MapStatService {
        public ErrorMapStatService(String page) {
            super(page);
        }

        public void onMapStatEvent(String id, String from, String type, String page, String source, String value, Object ext) {
            if (MapStatService.DEBUG) {
                MLog.e(MapStatService.TAG, "onShowEvent, page = " + page + ", source = " + source);
                throw new IllegalStateException("Need to register MapStatService!");
            }
        }
    }
}
