package com.baidu.live.plugin.prepare;

import android.content.Context;
import com.baidu.live.plugin.log.LivePluginPreDownloadUbcLog;
import com.baidu.live.plugin.utils.LivePluginPreLoadSPUtils;
import com.baidu.nps.main.download.IDownloadCallback;
import com.baidu.nps.utils.NetWorkUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/live/plugin/prepare/PluginPreloadContext$downLoadSecond$1", "Lcom/baidu/nps/main/download/IDownloadCallback;", "onProgress", "", "p0", "", "p1", "onResult", "code", "", "msg", "", "lib-live-plugin-prepare_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PluginPreloadContext.kt */
public final class PluginPreloadContext$downLoadSecond$1 implements IDownloadCallback {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.BooleanRef $hasProcess;
    final /* synthetic */ boolean $isRetry;
    final /* synthetic */ int $preFailCode;
    final /* synthetic */ String $secondPkg;
    final /* synthetic */ long $secondVersion;
    final /* synthetic */ String $source;
    final /* synthetic */ long $start;

    PluginPreloadContext$downLoadSecond$1(String $secondPkg2, boolean $isRetry2, long $secondVersion2, String $source2, Context $context2, int $preFailCode2, Ref.BooleanRef $hasProcess2, long $start2) {
        this.$secondPkg = $secondPkg2;
        this.$isRetry = $isRetry2;
        this.$secondVersion = $secondVersion2;
        this.$source = $source2;
        this.$context = $context2;
        this.$preFailCode = $preFailCode2;
        this.$hasProcess = $hasProcess2;
        this.$start = $start2;
    }

    public void onResult(int code, String msg) {
        PluginPreloadContext.INSTANCE.log("Second Download onResult " + this.$secondPkg + ' ' + code + ' ' + msg + ", isRetry: " + this.$isRetry);
        if (2 == code) {
            LivePluginPreLoadSPUtils.putLong(this.$secondPkg, this.$secondVersion);
            LivePluginPreLoadSPUtils.putString(this.$secondPkg + "_source", this.$source);
        }
        boolean wifiNet = NetWorkUtils.isWifiConnected(this.$context);
        PluginPreloadContext.INSTANCE.log("Second Download onResult wifi: " + wifiNet);
        boolean z = this.$isRetry;
        if (z || (!(2201 == code || 2202 == code) || !wifiNet)) {
            LivePluginPreDownloadUbcLog.preDownloadNpsResult(this.$source, this.$secondPkg, this.$secondVersion, 2 != code, 0, code, msg == null ? "" : msg, wifiNet, z ? 1 : 0, this.$preFailCode);
            return;
        }
        PluginPreloadContext.INSTANCE.log("Second Download onResult 重试下载二级");
        PluginPreloadContext.downLoadSecond$default(PluginPreloadContext.INSTANCE, this.$context, this.$secondPkg, this.$secondVersion, this.$source, true, 0, 32, (Object) null);
    }

    public void onProgress(long p0, long p1) {
        PluginPreloadContext.INSTANCE.log("Second Download onProgress " + this.$secondPkg + ' ' + p0 + ' ' + p1);
        if (!this.$hasProcess.element) {
            this.$hasProcess.element = true;
            LivePluginPreDownloadUbcLog.preDownloadNpsProcess(this.$source, this.$secondPkg, this.$secondVersion, System.currentTimeMillis() - this.$start);
        }
    }
}
