package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import fe.ad.qw.qw.qw.ad;
import fe.ad.qw.qw.qw.qw;
import java.util.Map;

public class ARouter$$Providers$$arouterapi implements IProviderGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.alibaba.android.arouter.facade.service.AutowiredService", RouteMeta.build(RouteType.PROVIDER, qw.class, "/arouter/service/autowired", "arouter", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("com.alibaba.android.arouter.facade.service.InterceptorService", RouteMeta.build(RouteType.PROVIDER, ad.class, "/arouter/service/interceptor", "arouter", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
