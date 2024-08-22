package com.tera.scan.flutter.documentscan;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.baidu.ubc.UBCManager;
import fe.ad.qw.qw.ad.qw;
import java.util.ArrayList;
import java.util.HashMap;

public class OCRRectifyActivity$$ARouter$$Autowired implements ISyringe {
    public SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) qw.de().yj(SerializationService.class);
        OCRRectifyActivity oCRRectifyActivity = (OCRRectifyActivity) obj;
        oCRRectifyActivity.images = (ArrayList) oCRRectifyActivity.getIntent().getSerializableExtra("images");
        oCRRectifyActivity.source = oCRRectifyActivity.getIntent().getIntExtra(UBCManager.CONTENT_KEY_SOURCE, oCRRectifyActivity.source);
        oCRRectifyActivity.category = oCRRectifyActivity.getIntent().getIntExtra("category", oCRRectifyActivity.category);
        oCRRectifyActivity.dataList = (ArrayList) oCRRectifyActivity.getIntent().getSerializableExtra("dataList");
        oCRRectifyActivity.scanMode = oCRRectifyActivity.getIntent().getIntExtra("scanMode", oCRRectifyActivity.scanMode);
        oCRRectifyActivity.docScanFilterIndex = oCRRectifyActivity.getIntent().getIntExtra("scanFilterIndex", oCRRectifyActivity.docScanFilterIndex);
        oCRRectifyActivity.cloudFiles = (HashMap) oCRRectifyActivity.getIntent().getSerializableExtra("cloudFiles");
        oCRRectifyActivity.from = oCRRectifyActivity.getIntent().getExtras() == null ? oCRRectifyActivity.from : oCRRectifyActivity.getIntent().getExtras().getString("from", oCRRectifyActivity.from);
        oCRRectifyActivity.aiScanImages = (ArrayList) oCRRectifyActivity.getIntent().getSerializableExtra("aiScanImages");
        oCRRectifyActivity.savePath = oCRRectifyActivity.getIntent().getExtras() == null ? oCRRectifyActivity.savePath : oCRRectifyActivity.getIntent().getExtras().getString("savePath", oCRRectifyActivity.savePath);
        oCRRectifyActivity.docResourceFrom = oCRRectifyActivity.getIntent().getExtras() == null ? oCRRectifyActivity.docResourceFrom : oCRRectifyActivity.getIntent().getExtras().getString("docResourceFrom", oCRRectifyActivity.docResourceFrom);
        oCRRectifyActivity.ubcSource = oCRRectifyActivity.getIntent().getExtras() == null ? oCRRectifyActivity.ubcSource : oCRRectifyActivity.getIntent().getExtras().getString("ubcSource", oCRRectifyActivity.ubcSource);
    }
}
