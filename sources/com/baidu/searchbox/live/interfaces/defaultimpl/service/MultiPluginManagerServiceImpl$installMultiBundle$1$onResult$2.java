package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import com.baidu.nps.pm.BundleInfo;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginInstallCallback;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginDownloadCallback;", "onProgress", "", "pkgName", "", "downloadedSize", "", "totalSize", "onResult", "isSuc", "", "msg", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MultiPluginManagerServiceImpl.kt */
public final class MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2 implements MultiPluginManagerServiceImpl.PluginDownloadCallback {
    final /* synthetic */ BundleInfo $bkBundle;
    final /* synthetic */ File $cacheDir;
    final /* synthetic */ String $cacheFileName;
    final /* synthetic */ String $completedFileName;
    final /* synthetic */ MultiPluginManagerServiceImpl$installMultiBundle$1 this$0;

    MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2(MultiPluginManagerServiceImpl$installMultiBundle$1 $outer, File $captured_local_variable$1, String $captured_local_variable$2, String $captured_local_variable$3, BundleInfo $captured_local_variable$4) {
        this.this$0 = $outer;
        this.$cacheDir = $captured_local_variable$1;
        this.$cacheFileName = $captured_local_variable$2;
        this.$completedFileName = $captured_local_variable$3;
        this.$bkBundle = $captured_local_variable$4;
    }

    public void onResult(String pkgName, boolean isSuc, String msg) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        if (isSuc) {
            File cacheFile = new File(this.$cacheDir, this.$cacheFileName);
            File apkFile = new File(this.$cacheDir, this.$completedFileName);
            if (cacheFile.exists()) {
                cacheFile.renameTo(apkFile);
            }
            this.this$0.this$0.installLocalMultiBundle(this.$bkBundle, apkFile, new MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2$onResult$1(this));
            return;
        }
        this.this$0.$installCallback.onResult(pkgName, false, MultiPluginManagerServiceImpl.INSTALL_ERR_BK_FILE_DOWNLOAD_FAIL, msg);
    }

    public void onProgress(String pkgName, long downloadedSize, long totalSize) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        MultiPluginInstallCallback multiPluginInstallCallback = this.this$0.$installCallback;
        if (multiPluginInstallCallback != null) {
            multiPluginInstallCallback.onProgress(pkgName, downloadedSize, totalSize);
        }
    }
}
