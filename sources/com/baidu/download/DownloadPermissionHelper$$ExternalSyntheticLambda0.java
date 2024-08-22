package com.baidu.download;

import com.baidu.download.DownloadPermissionHelper;
import com.baidu.searchbox.permission.DangerousPermissionManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadPermissionHelper$$ExternalSyntheticLambda0 implements DangerousPermissionManager.RequestSystemPermissionCallBack {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ DownloadPermissionHelper.DownloadPermissionCallBack f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ DownloadPermissionHelper$$ExternalSyntheticLambda0(int i2, DownloadPermissionHelper.DownloadPermissionCallBack downloadPermissionCallBack, String str) {
        this.f$0 = i2;
        this.f$1 = downloadPermissionCallBack;
        this.f$2 = str;
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        DownloadPermissionHelper.lambda$requestReadPermissionByType$0(this.f$0, this.f$1, this.f$2, i2, strArr, iArr);
    }
}
