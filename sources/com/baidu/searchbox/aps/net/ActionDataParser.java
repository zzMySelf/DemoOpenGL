package com.baidu.searchbox.aps.net;

import com.baidu.searchbox.aps.net.base.PluginJsonData;

public interface ActionDataParser<T> {
    T parseData(PluginJsonData pluginJsonData);
}
