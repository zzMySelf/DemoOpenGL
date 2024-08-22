package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.titan.sandbox.TitanUbcConfig;
import com.baidu.yalog.cloud.observer.YaLogIdConfigObserver;
import java.util.ArrayList;

public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TitanUbcConfig());
        arrayList.add(new YaLogIdConfigObserver());
        return arrayList;
    }
}
