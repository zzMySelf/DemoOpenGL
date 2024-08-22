package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.baidu.ubc.UBCManager;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$fileSelector implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/fileSelector/native/LocalImageSelectActivity", RouteMeta.build(RouteType.ACTIVITY, LocalImageSelectActivity.class, "/fileselector/native/localimageselectactivity", "fileselector", new HashMap<String, Integer>() {
            {
                put("forbidLiveP", 0);
                put("ubcSource", 8);
                put("minCount", 3);
                put("maxSize", 3);
                put(UBCManager.CONTENT_KEY_SOURCE, 8);
                put("title", 8);
                put("maxCount", 3);
                put("jumpRouter", 8);
                put("forbidGif", 0);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
