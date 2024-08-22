package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tera.scan.pdfedit.ui.PdfSplitActivity;
import com.tera.scan.pdfedit.ui.PdfToolboxSelectActivity;
import com.tera.scan.pdfedit.ui.PdfWatermarkCreateActivity;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$pdf_edit implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/pdf_edit/native/PdfSplitActivity", RouteMeta.build(RouteType.ACTIVITY, PdfSplitActivity.class, "/pdf_edit/native/pdfsplitactivity", "pdf_edit", new HashMap<String, Integer>() {
            {
                put("recordFile", 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/pdf_edit/native/PdfToolboxSelectActivity", RouteMeta.build(RouteType.ACTIVITY, PdfToolboxSelectActivity.class, "/pdf_edit/native/pdftoolboxselectactivity", "pdf_edit", new HashMap<String, Integer>() {
            {
                put("pdfMerge", 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/pdf_edit/watermark_create/activity", RouteMeta.build(RouteType.ACTIVITY, PdfWatermarkCreateActivity.class, "/pdf_edit/watermark_create/activity", "pdf_edit", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
