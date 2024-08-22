package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdProviderFactory {
    public Map<String, BaseIdProvider> qw = new HashMap();

    public interface IdFactoryProvider {
        List<BaseIdProvider> qw();
    }

    public IdProviderFactory(IdFactoryProvider idFactoryProvider) {
        for (BaseIdProvider next : idFactoryProvider.qw()) {
            this.qw.put(next.rg(), next);
        }
    }

    public List<BaseIdProvider> ad() {
        return new ArrayList(this.qw.values());
    }

    public BaseIdProvider qw(String str) {
        return this.qw.get(str);
    }
}
