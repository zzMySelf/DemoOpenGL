package com.baidu.swan.apps.ioc.impl;

import com.baidu.swan.apps.guide.SwanAppGuideToast;
import com.baidu.swan.pms.node.common.ioc.ICommonNodeGuide;
import org.json.JSONObject;

public class CommonNodeGuideImpl implements ICommonNodeGuide {
    public String getGuideNodeKey() {
        return SwanAppGuideToast.getGuideNodeKey();
    }

    public void processGuide(JSONObject data) {
        SwanAppGuideToast.processGuide(data);
    }

    public String getLocalGuideVersion() {
        return SwanAppGuideToast.getLocalVersion();
    }
}
