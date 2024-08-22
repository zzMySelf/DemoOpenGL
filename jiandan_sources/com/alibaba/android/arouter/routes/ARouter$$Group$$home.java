package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tera.scan.main.MainActivity;
import java.util.Map;

public class ARouter$$Group$$home implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/home/main/activity", RouteMeta.build(RouteType.ACTIVITY, MainActivity.class, "/home/main/activity", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
