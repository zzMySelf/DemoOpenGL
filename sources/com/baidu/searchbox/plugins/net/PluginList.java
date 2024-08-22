package com.baidu.searchbox.plugins.net;

import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.plugins.kernels.common.CommonPlugin;
import java.util.List;

public class PluginList {
    private static final String TAG = "PluginList";
    private List<CommonPlugin> mPluginList = null;
    private int mVersion;

    public PluginList(int version) {
        this.mVersion = version;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public List<CommonPlugin> getPluginList() {
        return this.mPluginList;
    }

    public void setPluginList(List<CommonPlugin> list) {
        this.mPluginList = list;
    }

    public String toString() {
        StringBuilder value = new StringBuilder();
        value.append("version=" + this.mVersion + ";");
        value.append(RhetoricalTagUtilKt.TAG_START_SYMBOL);
        List<CommonPlugin> list = this.mPluginList;
        if (list != null) {
            for (CommonPlugin plugin : list) {
                if (plugin != null) {
                    value.append(plugin.toString());
                }
            }
        }
        value.append("];");
        return value.toString();
    }
}
