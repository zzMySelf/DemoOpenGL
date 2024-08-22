package com.baidu.searchbox.aps.center.callback;

import com.baidu.searchbox.aps.base.Plugin;
import com.baidu.searchbox.pms.bean.PackageInfo;
import java.util.List;

public interface PluginParseCallback {
    public static final String META_DATA_NAME = "aps.plugin.callback.parse";

    boolean needSaveToApsDb();

    List<Plugin> processPlugin(List<PackageInfo> list);
}
