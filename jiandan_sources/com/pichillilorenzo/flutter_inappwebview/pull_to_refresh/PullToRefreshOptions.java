package com.pichillilorenzo.flutter_inappwebview.pull_to_refresh;

import androidx.annotation.Nullable;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiOptions;
import com.pichillilorenzo.flutter_inappwebview.Options;
import java.util.HashMap;
import java.util.Map;

public class PullToRefreshOptions implements Options<PullToRefreshLayout> {
    public static final String LOG_TAG = "PullToRefreshOptions";
    @Nullable
    public String backgroundColor;
    @Nullable
    public String color;
    @Nullable
    public Integer distanceToTriggerSync;
    public Boolean enabled = Boolean.TRUE;
    @Nullable
    public Integer size;
    @Nullable
    public Integer slingshotDistance;

    public Map<String, Object> getRealOptions(PullToRefreshLayout pullToRefreshLayout) {
        return toMap();
    }

    public PullToRefreshOptions parse(Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value != null) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -1878912765:
                        if (str.equals("distanceToTriggerSync")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1609594047:
                        if (str.equals(SapiOptions.KEY_CACHE_ENABLED)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3530753:
                        if (str.equals("size")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 94842723:
                        if (str.equals(ResUtils.f)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1287124693:
                        if (str.equals("backgroundColor")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1719097976:
                        if (str.equals("slingshotDistance")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    this.enabled = (Boolean) value;
                } else if (c == 1) {
                    this.color = (String) value;
                } else if (c == 2) {
                    this.backgroundColor = (String) value;
                } else if (c == 3) {
                    this.distanceToTriggerSync = (Integer) value;
                } else if (c == 4) {
                    this.slingshotDistance = (Integer) value;
                } else if (c == 5) {
                    this.size = (Integer) value;
                }
            }
        }
        return this;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(SapiOptions.KEY_CACHE_ENABLED, this.enabled);
        hashMap.put(ResUtils.f, this.color);
        hashMap.put("backgroundColor", this.backgroundColor);
        hashMap.put("distanceToTriggerSync", this.distanceToTriggerSync);
        hashMap.put("slingshotDistance", this.slingshotDistance);
        hashMap.put("size", this.size);
        return hashMap;
    }
}
