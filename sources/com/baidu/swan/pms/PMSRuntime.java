package com.baidu.swan.pms;

import com.baidu.swan.apps.ioc.impl.CommonNodeGuideImpl_Factory;
import com.baidu.swan.apps.ioc.impl.PMSImpl_Factory;
import com.baidu.swan.apps.ioc.impl.PmsStorageImpl_Factory;
import com.baidu.swan.pms.ioc.IStorageContext;
import com.baidu.swan.pms.node.common.ioc.ICommonNodeGuide;

public class PMSRuntime {
    public static final boolean DEBUG = false;

    public static IPMS getPMSContext() {
        return PMSImpl_Factory.get();
    }

    public static ICommonNodeGuide getCommonNodeGuide() {
        return CommonNodeGuideImpl_Factory.get();
    }

    public static IStorageContext getUtilContext() {
        return PmsStorageImpl_Factory.get();
    }
}
