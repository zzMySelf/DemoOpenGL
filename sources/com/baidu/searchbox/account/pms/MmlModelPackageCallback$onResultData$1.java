package com.baidu.searchbox.account.pms;

import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.searchbox.ai.inference.impl.AIModelInstallManager;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/account/pms/MmlModelPackageCallback$onResultData$1", "Lcom/baidu/searchbox/pms/callback/DefaultDownloadCallback;", "onDownloadError", "", "info", "Lcom/baidu/searchbox/pms/bean/PackageInfo;", "errorInfo", "Lcom/baidu/searchbox/pms/bean/ErrorInfo;", "onDownloadSuccess", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MmlModelChannel.kt */
public final class MmlModelPackageCallback$onResultData$1 extends DefaultDownloadCallback {
    final /* synthetic */ MmlModelPackageCallback this$0;

    MmlModelPackageCallback$onResultData$1(MmlModelPackageCallback $receiver) {
        this.this$0 = $receiver;
    }

    public void onDownloadSuccess(PackageInfo info, ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(info, "info");
        AIModelInstallManager.get().install(info, new MmlModelPackageCallback$onResultData$1$onDownloadSuccess$1(this.this$0));
    }

    public void onDownloadError(PackageInfo info, ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        LogUtils.d("download package failed: " + errorInfo);
        this.this$0.callbackResult(errorInfo);
    }
}
