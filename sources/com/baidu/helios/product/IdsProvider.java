package com.baidu.helios.product;

import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.helios.ids.IdProviderFactory;
import com.baidu.helios.ids.aid.AidProvider;
import com.baidu.helios.ids.gaid.GaidProvider;
import com.baidu.helios.ids.iid.InstantIdProvider;
import com.baidu.helios.ids.oid.OaidProvider;
import com.baidu.helios.ids.ssaid.AndroidIdProvider;
import java.util.ArrayList;
import java.util.List;

public class IdsProvider implements IdProviderFactory.IdFactoryProvider {
    public List<BaseIdProvider> getAllInstalledIdProviders() {
        List<BaseIdProvider> ids = new ArrayList<>();
        ids.add(new AidProvider());
        ids.add(new OaidProvider());
        ids.add(new GaidProvider());
        ids.add(new AndroidIdProvider());
        ids.add(new InstantIdProvider());
        return ids;
    }
}
