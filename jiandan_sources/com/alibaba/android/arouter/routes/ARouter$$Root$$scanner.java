package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.tera.scan.scanner.ui.camera.CameraFragment;
import java.util.Map;

public class ARouter$$Root$$scanner implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put(CameraFragment.CONTENT_TYPE_OCR, ARouter$$Group$$ocr.class);
    }
}
