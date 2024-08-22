package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tera.scan.main.importfile.ImportDocFilesActivity;
import java.util.Map;

public class ARouter$$Group$$files implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/files/import/activity", RouteMeta.build(RouteType.ACTIVITY, ImportDocFilesActivity.class, "/files/import/activity", "files", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
