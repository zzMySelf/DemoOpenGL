package com.tera.scan.pdfedit.ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import fe.ad.qw.qw.ad.qw;

public class PdfToolboxSelectActivity$$ARouter$$Autowired implements ISyringe {
    public SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) qw.de().yj(SerializationService.class);
        PdfToolboxSelectActivity pdfToolboxSelectActivity = (PdfToolboxSelectActivity) obj;
        pdfToolboxSelectActivity.pdfMerge = pdfToolboxSelectActivity.getIntent().getBooleanExtra("pdfMerge", pdfToolboxSelectActivity.pdfMerge);
    }
}
