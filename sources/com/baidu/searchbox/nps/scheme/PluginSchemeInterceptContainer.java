package com.baidu.searchbox.nps.scheme;

import java.util.List;

public class PluginSchemeInterceptContainer {
    private static PluginSchemeInterceptComponent component = new PluginSchemeInterceptComponent();

    public static List<PluginSchemeInterceptProcessor> getProcessorList() {
        if (component.processorList != null) {
            return component.processorList.getList();
        }
        return null;
    }
}
