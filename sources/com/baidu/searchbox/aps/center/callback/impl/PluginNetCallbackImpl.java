package com.baidu.searchbox.aps.center.callback.impl;

import com.baidu.searchbox.aps.base.Plugin;
import com.baidu.searchbox.aps.center.callback.PluginParseCallback;
import com.baidu.searchbox.aps.center.net.manager.ResponseParseUtils;
import com.baidu.searchbox.pms.bean.PackageInfo;
import java.util.ArrayList;
import java.util.List;

public class PluginNetCallbackImpl implements PluginParseCallback {
    public List<Plugin> processPlugin(List<PackageInfo> infoList) {
        List<Plugin> resultList = new ArrayList<>();
        if (infoList == null) {
            return resultList;
        }
        for (PackageInfo packageInfo : infoList) {
            Plugin plugin = ResponseParseUtils.parsePlugin(packageInfo);
            if (plugin != null && plugin.errno == 0) {
                resultList.add(plugin);
            }
        }
        return resultList;
    }

    public boolean needSaveToApsDb() {
        return true;
    }
}
