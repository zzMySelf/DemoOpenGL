package com.baidu.searchbox.search.switchs;

import com.baidu.searchbox.net.update.v2.SwitchListener;

public class ZeusSwitchListener extends SwitchListener {
    public static final String SEARCH_ZEUS_SWITCH_KEY = "search_zeus_switch";
    public static final String ZEUS_ACTION = "zeus";

    public String getKey(String module, String action) {
        return SEARCH_ZEUS_SWITCH_KEY;
    }
}
