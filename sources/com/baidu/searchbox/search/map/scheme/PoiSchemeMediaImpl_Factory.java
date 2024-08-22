package com.baidu.searchbox.search.map.scheme;

public class PoiSchemeMediaImpl_Factory {
    private static volatile PoiSchemeMediaImpl instance;

    private PoiSchemeMediaImpl_Factory() {
    }

    public static synchronized PoiSchemeMediaImpl get() {
        PoiSchemeMediaImpl poiSchemeMediaImpl;
        synchronized (PoiSchemeMediaImpl_Factory.class) {
            if (instance == null) {
                instance = new PoiSchemeMediaImpl();
            }
            poiSchemeMediaImpl = instance;
        }
        return poiSchemeMediaImpl;
    }
}
