package com.tera.scan.file.selector.ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.baidu.ubc.UBCManager;
import fe.ad.qw.qw.ad.qw;

public class LocalImageSelectActivity$$ARouter$$Autowired implements ISyringe {
    public SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) qw.de().yj(SerializationService.class);
        LocalImageSelectActivity localImageSelectActivity = (LocalImageSelectActivity) obj;
        localImageSelectActivity.maxCount = localImageSelectActivity.getIntent().getIntExtra("maxCount", localImageSelectActivity.maxCount);
        localImageSelectActivity.minCount = localImageSelectActivity.getIntent().getIntExtra("minCount", localImageSelectActivity.minCount);
        localImageSelectActivity.forbidLiveP = localImageSelectActivity.getIntent().getBooleanExtra("forbidLiveP", localImageSelectActivity.forbidLiveP);
        localImageSelectActivity.forbidGif = localImageSelectActivity.getIntent().getBooleanExtra("forbidGif", localImageSelectActivity.forbidGif);
        localImageSelectActivity.maxSize = localImageSelectActivity.getIntent().getIntExtra("maxSize", localImageSelectActivity.maxSize);
        localImageSelectActivity.source = localImageSelectActivity.getIntent().getExtras() == null ? localImageSelectActivity.source : localImageSelectActivity.getIntent().getExtras().getString(UBCManager.CONTENT_KEY_SOURCE, localImageSelectActivity.source);
        localImageSelectActivity.jumpRouter = localImageSelectActivity.getIntent().getExtras() == null ? localImageSelectActivity.jumpRouter : localImageSelectActivity.getIntent().getExtras().getString("jumpRouter", localImageSelectActivity.jumpRouter);
        localImageSelectActivity.title = localImageSelectActivity.getIntent().getExtras() == null ? localImageSelectActivity.title : localImageSelectActivity.getIntent().getExtras().getString("title", localImageSelectActivity.title);
        localImageSelectActivity.ubcSource = localImageSelectActivity.getIntent().getExtras() == null ? localImageSelectActivity.ubcSource : localImageSelectActivity.getIntent().getExtras().getString("ubcSource", localImageSelectActivity.ubcSource);
    }
}
