package com.baidu.searchbox.perfframe.ioc;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.searchbox.perfframe.ubc.UbcPerfFrameRegister;
import java.util.ArrayList;

public class IPerfFrameRegister_PerfFrameRuntime_ListProvider implements Provider {
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcPerfFrameRegister());
        return arrayList;
    }
}
