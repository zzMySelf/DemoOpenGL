package com.baidu.searchbox.download.center.clearcache.view.funison.fileScan;

import com.baidu.searchbox.download.center.clearcache.view.funison.local.AbsClearCachePhoneActivity;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DiskScanManager$$ExternalSyntheticLambda2 implements DownloadMediaHelper.CallBack {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ AbsClearCachePhoneActivity.DeleteFileCallBack f$2;
    public final /* synthetic */ HashMap f$3;

    public /* synthetic */ DiskScanManager$$ExternalSyntheticLambda2(List list, List list2, AbsClearCachePhoneActivity.DeleteFileCallBack deleteFileCallBack, HashMap hashMap) {
        this.f$0 = list;
        this.f$1 = list2;
        this.f$2 = deleteFileCallBack;
        this.f$3 = hashMap;
    }

    public final void callback(Object obj) {
        DiskScanManager.m17281deleteCommonFile$lambda17$lambda14(this.f$0, this.f$1, this.f$2, this.f$3, (ArrayList) obj);
    }
}
