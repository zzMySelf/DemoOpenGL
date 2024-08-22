package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tera.scan.main.ui.AllToolActivity;
import java.util.Map;

public class ARouter$$Group$$tools implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/tools/all/activity", RouteMeta.build(RouteType.ACTIVITY, AllToolActivity.class, "/tools/all/activity", "tools", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
