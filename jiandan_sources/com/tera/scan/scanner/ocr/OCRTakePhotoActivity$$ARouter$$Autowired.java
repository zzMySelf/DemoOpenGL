package com.tera.scan.scanner.ocr;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import fe.ad.qw.qw.ad.qw;

public class OCRTakePhotoActivity$$ARouter$$Autowired implements ISyringe {
    public SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) qw.de().yj(SerializationService.class);
        OCRTakePhotoActivity oCRTakePhotoActivity = (OCRTakePhotoActivity) obj;
        oCRTakePhotoActivity.initTab = oCRTakePhotoActivity.getIntent().getExtras() == null ? oCRTakePhotoActivity.initTab : oCRTakePhotoActivity.getIntent().getExtras().getString(OCRTakePhotoActivity.ROUTER_INIT_TAB, oCRTakePhotoActivity.initTab);
        oCRTakePhotoActivity.from = oCRTakePhotoActivity.getIntent().getIntExtra("from", oCRTakePhotoActivity.from);
        oCRTakePhotoActivity.ubcSource = oCRTakePhotoActivity.getIntent().getExtras() == null ? oCRTakePhotoActivity.ubcSource : oCRTakePhotoActivity.getIntent().getExtras().getString("ubcSource", oCRTakePhotoActivity.ubcSource);
        oCRTakePhotoActivity.category = oCRTakePhotoActivity.getIntent().getIntExtra(OCRTakePhotoActivity.ROUTER_INIT_CATEGORY, oCRTakePhotoActivity.category);
    }
}
