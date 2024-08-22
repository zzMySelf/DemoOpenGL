package com.baidu.talos.core.container.pagecontainer;

import android.net.Uri;
import android.util.Log;
import com.baidu.talos.IPackageManager;
import com.baidu.talos.TalosManager;
import com.baidu.talos.bundlemgr.IPackageInstallCallback;
import com.baidu.talos.bundlemgr.module.ModuleInfo;
import com.baidu.talos.bundlemgr.module.PackageInfo;
import com.baidu.talos.bundlemgr.module.Status;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.container.pagecontainer.PackageProcessResult;
import com.baidu.talos.core.container.pagecontainer.inter.IPackageConsumer;
import com.baidu.talos.core.container.pagecontainer.inter.IPackageProcessor;
import com.baidu.talos.core.deploy.TLSDeployUtil;

public class LocalPackageProcesseor implements IPackageProcessor<PackageProcessResult>, IPackageInstallCallback {
    static final boolean DEBUG = Debug.isDebug();
    private static final String TAG = "TLS_PrLocalPackage";
    protected IPackageConsumer<PackageProcessResult> mConsumer;
    private String mMainBizName;
    protected IPackageProcessor<PackageProcessResult> mNextProcessor;
    private Uri mPackagePath;

    public LocalPackageProcesseor(String mainBiz, Uri packagePath) {
        this.mMainBizName = mainBiz;
        this.mPackagePath = packagePath;
    }

    public void process(IPackageConsumer consumer) {
        if (DEBUG) {
            Log.d(TAG, "check localPackage install mMainBizName=" + this.mMainBizName + " mPackagePath=" + this.mPackagePath);
        }
        this.mConsumer = consumer;
        if (this.mPackagePath == null) {
            nextProcessor();
            return;
        }
        IPackageManager packageManager = TalosManager.getPackageManager();
        if (packageManager == null) {
            nextProcessor();
        } else if (TLSDeployUtil.isLocalFileUri(this.mPackagePath)) {
            packageManager.installPackageFromFile(this.mMainBizName, this.mPackagePath, this);
        } else if (TLSDeployUtil.isLocalAssetUri(this.mPackagePath)) {
            packageManager.installPackageFromAssets(this.mMainBizName, this.mPackagePath, this);
        } else {
            nextProcessor();
        }
    }

    public void setNextProcessor(IPackageProcessor<PackageProcessResult> nextProcessor) {
        this.mNextProcessor = nextProcessor;
    }

    private void nextProcessor() {
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

    private void notifyFailure(int errorCode, String errMsg) {
        IPackageConsumer<PackageProcessResult> iPackageConsumer = this.mConsumer;
        if (iPackageConsumer != null) {
            iPackageConsumer.onFailure(this, errorCode, errMsg);
        }
    }

    public void onStartInstall(String packageName) {
        if (DEBUG) {
            Log.d(TAG, "onStartInstall packageName=" + packageName);
        }
    }

    public void onFinishInstall(boolean success, Status status) {
        if (DEBUG) {
            StringBuilder msg = new StringBuilder("onFinishInstall success=" + success);
            if (status != null) {
                msg.append(" status=" + status.toString());
            }
            Log.d(TAG, msg.toString());
        }
        nextProcessor();
    }

    public void onPackageInstallStart(PackageInfo pkgInfo) {
        if (DEBUG) {
            StringBuilder msg = new StringBuilder("onPackageInstallStart");
            if (pkgInfo != null) {
                msg.append(" packageName=" + pkgInfo.mPackageName);
            }
            Log.d(TAG, msg.toString());
        }
    }

    public void onPackageInstallEnd(PackageInfo pkgInfo, Status status) {
        if (DEBUG) {
            StringBuilder msg = new StringBuilder("onPackageInstallEnd");
            if (pkgInfo != null) {
                msg.append(" packageName=" + pkgInfo.mPackageName);
            }
            if (status != null) {
                msg.append(" packageName=" + status.toString());
            }
            Log.d(TAG, msg.toString());
        }
    }

    public void onModuleInstallStart(ModuleInfo moduleInfo) {
        if (DEBUG) {
            StringBuilder msg = new StringBuilder("onPackageInstallEnd");
            if (moduleInfo != null) {
                msg.append(" packageName=" + moduleInfo.mModuleName);
            }
            Log.d(TAG, msg.toString());
        }
    }

    public void onMoudleInstallEnd(ModuleInfo moduleInfo, Status status) {
        if (DEBUG) {
            StringBuilder msg = new StringBuilder("onPackageInstallEnd");
            if (moduleInfo != null) {
                msg.append(" packageName=" + moduleInfo.mModuleName);
            }
            if (status != null) {
                msg.append(" status=" + status.toString());
            }
            Log.d(TAG, msg.toString());
        }
    }
}
