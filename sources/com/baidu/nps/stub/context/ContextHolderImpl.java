package com.baidu.nps.stub.context;

import android.app.Application;

public class ContextHolderImpl extends ContextHolder {
    private static Application sApplication = null;
    private static ContextHolderImpl sInstance = new ContextHolderImpl();

    private ContextHolderImpl() {
    }

    private static ContextHolderImpl getInstance() {
        return sInstance;
    }

    public static synchronized Application getApplicationContext() {
        Application application;
        synchronized (ContextHolderImpl.class) {
            if (sApplication == null) {
                sApplication = getInstance().getContextInternal();
            }
            application = sApplication;
        }
        return application;
    }

    /* access modifiers changed from: protected */
    public String getPackageName() {
        return null;
    }
}
