package com.baidu.searchbox.widget.ioc;

public class AppWidgetProviderClassImpl_Factory {
    private static volatile AppWidgetProviderClassImpl instance;

    private AppWidgetProviderClassImpl_Factory() {
    }

    public static synchronized AppWidgetProviderClassImpl get() {
        AppWidgetProviderClassImpl appWidgetProviderClassImpl;
        synchronized (AppWidgetProviderClassImpl_Factory.class) {
            if (instance == null) {
                instance = new AppWidgetProviderClassImpl();
            }
            appWidgetProviderClassImpl = instance;
        }
        return appWidgetProviderClassImpl;
    }
}
