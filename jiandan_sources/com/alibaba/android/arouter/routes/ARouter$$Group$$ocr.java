package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import com.tera.scan.scanner.ui.camera.CameraFragment;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$ocr implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/ocr/native/OCRTakePhotoActivity", RouteMeta.build(RouteType.ACTIVITY, OCRTakePhotoActivity.class, "/ocr/native/ocrtakephotoactivity", CameraFragment.CONTENT_TYPE_OCR, new HashMap<String, Integer>() {
            {
                put(OCRTakePhotoActivity.ROUTER_INIT_TAB, 8);
                put("ubcSource", 8);
                put("from", 3);
                put(OCRTakePhotoActivity.ROUTER_INIT_CATEGORY, 3);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
