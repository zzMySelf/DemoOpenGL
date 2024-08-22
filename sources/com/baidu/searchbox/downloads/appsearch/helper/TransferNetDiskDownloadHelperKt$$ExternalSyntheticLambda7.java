package com.baidu.searchbox.downloads.appsearch.helper;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.searchbox.downloads.appsearch.model.DownloadActionItem;
import com.baidu.searchbox.downloads.appsearch.model.DownloadInfoItem;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransferNetDiskDownloadHelperKt$$ExternalSyntheticLambda7 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ DownloadInfoItem f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ DownloadActionItem f$3;

    public /* synthetic */ TransferNetDiskDownloadHelperKt$$ExternalSyntheticLambda7(DownloadInfoItem downloadInfoItem, String str, boolean z, DownloadActionItem downloadActionItem) {
        this.f$0 = downloadInfoItem;
        this.f$1 = str;
        this.f$2 = z;
        this.f$3 = downloadActionItem;
    }

    public final void onItemClick(AdapterView adapterView, View view2, int i2, long j2) {
        TransferNetDiskDownloadHelperKt.m17771addPlayButtonItem$lambda17$lambda16(this.f$0, this.f$1, this.f$2, this.f$3, adapterView, view2, i2, j2);
    }
}
