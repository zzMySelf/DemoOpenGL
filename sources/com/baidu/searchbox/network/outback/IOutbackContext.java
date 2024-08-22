package com.baidu.searchbox.network.outback;

import android.content.Context;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.model.MultipleConnectParams;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import java.util.HashMap;

public interface IOutbackContext {
    CallFactory.CallFactoryProducer getBackupCallFactoryProducer();

    IOutbackClientIPProvider getClientIPProvider();

    Context getContext();

    CookieManager getCookieManager(boolean z, boolean z2);

    CallFactory.CallFactoryProducer getDefaultCallFactoryProducer();

    IAdditionalRecord getIAdditionalRecord();

    MultipleConnectParams getMultipleConnectParams();

    HashMap<String, CallFactory.CallFactoryProducer> getOutbackEngines();

    boolean okHttpPreConnectEnabled();
}
