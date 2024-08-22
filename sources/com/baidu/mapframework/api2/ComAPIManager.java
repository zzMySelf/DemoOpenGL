package com.baidu.mapframework.api2;

import com.baidu.mapframework.api2imp.ComLocationApiImp;
import com.baidu.mapframework.api2imp.ComSearchBoxPlusApiImp;
import com.baidu.mapframework.api2imp.ComSystemApiImpl;
import com.baidu.mapframework.api2plus.ComSearchBoxPlusApi;

public final class ComAPIManager {
    private ComSearchBoxPlusApi comSearchBoxPlusApi;
    private ComLocationApi locationApi;
    private ComSystemApi systemApi;

    private ComAPIManager() {
    }

    /* synthetic */ ComAPIManager(ComAPIManager comAPIManager) {
        this();
    }

    static class Holder {
        static final ComAPIManager sInstance = new ComAPIManager((ComAPIManager) null);

        Holder() {
        }
    }

    public static ComAPIManager getComAPIManager() {
        return Holder.sInstance;
    }

    public ComSystemApi getSystemAPI() {
        if (this.systemApi == null) {
            this.systemApi = new ComSystemApiImpl();
        }
        return this.systemApi;
    }

    public ComLocationApi getLocationApi() {
        if (this.locationApi == null) {
            this.locationApi = new ComLocationApiImp();
        }
        return this.locationApi;
    }

    public ComSearchBoxPlusApi getSearchBoxPluginApi() {
        if (this.comSearchBoxPlusApi == null) {
            this.comSearchBoxPlusApi = new ComSearchBoxPlusApiImp();
        }
        return this.comSearchBoxPlusApi;
    }
}
