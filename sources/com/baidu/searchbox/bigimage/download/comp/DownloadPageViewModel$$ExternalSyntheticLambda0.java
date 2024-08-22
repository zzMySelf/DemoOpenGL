package com.baidu.searchbox.bigimage.download.comp;

import android.content.Context;
import android.net.Uri;
import com.baidu.search.permission.StoragePermission;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadPageViewModel$$ExternalSyntheticLambda0 implements StoragePermission.ISearchPermissionsResult {
    public final /* synthetic */ Uri f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ DownloadPageViewModel$$ExternalSyntheticLambda0(Uri uri, Context context) {
        this.f$0 = uri;
        this.f$1 = context;
    }

    public final void onPermissionsResult(boolean z) {
        DownloadPageViewModel.m16498downloadImg$lambda3$lambda2$lambda1(this.f$0, this.f$1, z);
    }
}
