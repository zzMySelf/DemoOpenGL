package com.tera.scan.pdfedit.ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.ad.qw.qw.ad.qw;

public class PdfSplitActivity$$ARouter$$Autowired implements ISyringe {
    public SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) qw.de().yj(SerializationService.class);
        PdfSplitActivity pdfSplitActivity = (PdfSplitActivity) obj;
        pdfSplitActivity.recordFile = (ScanRecordExportFile) pdfSplitActivity.getIntent().getParcelableExtra("recordFile");
    }
}
