package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.baidu.ubc.UBCManager;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$flutternetdisk implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/flutternetdisk/native/OCRRectifyActivity", RouteMeta.build(RouteType.ACTIVITY, OCRRectifyActivity.class, "/flutternetdisk/native/ocrrectifyactivity", "flutternetdisk", new HashMap<String, Integer>() {
            {
                put("images", 9);
                put("cloudFiles", 9);
                put("savePath", 8);
                put("dataList", 9);
                put("docResourceFrom", 8);
                put("scanMode", 3);
                put("scanFilterIndex", 3);
                put("ubcSource", 8);
                put("from", 8);
                put(UBCManager.CONTENT_KEY_SOURCE, 3);
                put("category", 3);
                put("aiScanImages", 9);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
