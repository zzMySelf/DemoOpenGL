package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.util.Map;

public class ARouter$$Root$$appmain implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("files", ARouter$$Group$$files.class);
        map.put("home", ARouter$$Group$$home.class);
        map.put("tools", ARouter$$Group$$tools.class);
    }
}
