package com.baidu.searchbox.download.center.ui.fusion.util;

import android.content.Context;
import android.view.View;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.statistics.DownloadWinStaConstants;
import com.baidu.searchbox.statistics.DownloadWindownUBC;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/download/center/ui/fusion/util/FileManagerRecentDataControlUtil$guideClearOtherInstallPackage$2", "Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileManagerRecentDataControlUtil.kt */
public final class FileManagerRecentDataControlUtil$guideClearOtherInstallPackage$2 implements BdDialog.OnItemClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ CategoryInfoData $data;

    FileManagerRecentDataControlUtil$guideClearOtherInstallPackage$2(Context $context2, CategoryInfoData $data2) {
        this.$context = $context2;
        this.$data = $data2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        FileManagerRecentDataControlUtil.INSTANCE.startActivity(this.$context, this.$data);
        DownloadWindownUBC.invokeDownload("invalid", "click", "download", DownloadWinStaConstants.ANOTHER, "", this.$data.mSize);
    }
}
