package com.baidu.live.plugin.prepare;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreLoadData {
    public long duration;
    public String errMsg;
    public int errno;
    public String logId;
    public Map<String, List<String>> pluginPkgInfo;
    public boolean preDownloadSwitch;

    public void parserJson(JSONObject json) {
        if (json != null) {
            this.errno = json.optInt("errno");
            this.errMsg = json.optString("errmsg");
            this.logId = json.optString("logid");
            JSONObject data = json.optJSONObject("data");
            if (data != null) {
                this.duration = data.optLong("duration") * 1000;
                boolean z = true;
                if (data.optInt("predownload_switch") != 1) {
                    z = false;
                }
                this.preDownloadSwitch = z;
                this.pluginPkgInfo = toPkgInfo(data.optJSONArray("pkg_list"));
            }
        }
    }

    private Map<String, List<String>> toPkgInfo(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i2 = 0; i2 < jsonArray.length(); i2++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i2);
            if (jsonObject != null) {
                String first = jsonObject.optString("first");
                if (!TextUtils.isEmpty(first)) {
                    map.put(first, toModeList(jsonObject.optJSONArray("second")));
                }
            }
        }
        return map;
    }

    private List<String> toModeList(JSONArray arrayList) {
        if (arrayList == null) {
            return null;
        }
        List<String> pkgList = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.length(); i2++) {
            String pkg = arrayList.optString(i2);
            if (!TextUtils.isEmpty(pkg)) {
                pkgList.add(pkg);
            }
        }
        return pkgList;
    }

    private static Map<String, String> toRateLimitMap(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (int i2 = 0; i2 < jsonArray.length(); i2++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i2);
            if (jsonObject != null) {
                String cdnDomain = jsonObject.optString("cdn_domain");
                if (!TextUtils.isEmpty(cdnDomain)) {
                    map.put(cdnDomain, jsonObject.optString("ratelimit_args"));
                }
            }
        }
        return map;
    }
}
