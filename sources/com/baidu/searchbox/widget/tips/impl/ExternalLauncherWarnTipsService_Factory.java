package com.baidu.searchbox.widget.tips.impl;

public class ExternalLauncherWarnTipsService_Factory {
    private static volatile ExternalLauncherWarnTipsService instance;

    private ExternalLauncherWarnTipsService_Factory() {
    }

    public static synchronized ExternalLauncherWarnTipsService get() {
        ExternalLauncherWarnTipsService externalLauncherWarnTipsService;
        synchronized (ExternalLauncherWarnTipsService_Factory.class) {
            if (instance == null) {
                instance = new ExternalLauncherWarnTipsService();
            }
            externalLauncherWarnTipsService = instance;
        }
        return externalLauncherWarnTipsService;
    }
}
