package com.baidu.talos.core.container.pagecontainer;

import android.util.Log;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.container.pagecontainer.PackageProcessResult;
import com.baidu.talos.core.container.pagecontainer.inter.IPackageConsumer;
import com.baidu.talos.core.container.pagecontainer.inter.IPackageProcessor;
import com.baidu.talos.monitor.PageError;
import com.baidu.talos.so.V8LoadStatusListener;
import com.baidu.talos.tracelog.LogParams;
import com.baidu.talos.tracelog.TalosYaLogger;

public class ZeusSoProcessor implements IPackageProcessor<PackageProcessResult> {
    static final boolean DEBUG = Debug.isDebug();
    private static final int MAX_DOWNLOAD_ZEUS_SO_RETRY_COUNT = 2;
    private static final String TAG = "TLS_ProcessorZeusSo";
    protected IPackageConsumer<PackageProcessResult> mConsumer;
    protected IPackageProcessor<PackageProcessResult> mNextProcessor;
    private int zeusSoRetryCount = 0;

    public void setNextProcessor(IPackageProcessor<PackageProcessResult> nextProcessor) {
        this.mNextProcessor = nextProcessor;
    }

    public void process(IPackageConsumer<PackageProcessResult> consumer) {
        if (DEBUG) {
            Log.d(TAG, "check ZeusSo install");
        }
        this.mConsumer = consumer;
        if (!TalosAdapterManager.getV8Adapter().isV8Preset()) {
            TalosYaLogger.yaLogD(LogParams.TAG_LOADZEUSSO, "V8统一: 在page中 start tryToDownloadAndLoadV8So ");
            TalosAdapterManager.getV8Adapter().tryToDownloadAndLoadV8So(getClass().getClassLoader(), TalosAppRuntimeInit.getAppContext(), new V8LoadStatusListener() {
                public void onloadV8Success() {
                    TalosYaLogger.yaLogD(LogParams.TAG_LOADZEUSSO, "V8统一: 在page中 V8统一加载成功");
                    ZeusSoProcessor.this.nextProcessor();
                }

                public void onLoadV8Fail(String msg) {
                    StringBuilder errMsg = new StringBuilder(PageError.DG_OEM_INIT_FAIL_EMSG);
                    errMsg.append(" e.getMsg=" + msg);
                    Log.e(ZeusSoProcessor.TAG, "onDownLoadError errMsg=" + errMsg.toString());
                    ZeusSoProcessor.this.notifyFailure(5021, errMsg.toString());
                    TalosYaLogger.yaLogE(LogParams.TAG_LOADZEUSSO, "V8统一 在page中 加载失败 onLoadV8Fail" + errMsg);
                }
            });
            return;
        }
        nextProcessor();
    }

    /* access modifiers changed from: private */
    public void nextProcessor() {
        IPackageProcessor<PackageProcessResult> iPackageProcessor = this.mNextProcessor;
        if (iPackageProcessor != null) {
            iPackageProcessor.process(this.mConsumer);
        } else {
            notifySuccess("");
        }
    }

    private void notifySuccess(String version) {
        if (this.mConsumer != null) {
            this.mConsumer.onSuccess(new PackageProcessResult.Builder().packageVersion(version).build());
        }
    }

    /* access modifiers changed from: private */
    public void notifyFailure(int errorCode, String errMsg) {
        IPackageConsumer<PackageProcessResult> iPackageConsumer = this.mConsumer;
        if (iPackageConsumer != null) {
            iPackageConsumer.onFailure(this, errorCode, errMsg);
        }
    }
}
