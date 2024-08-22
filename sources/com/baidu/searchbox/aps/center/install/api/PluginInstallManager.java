package com.baidu.searchbox.aps.center.install.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.megapp.install.IInstallCallBack;
import com.baidu.megapp.pm.MAPackageManager;
import com.baidu.searchbox.aps.base.Plugin;
import com.baidu.searchbox.aps.base.db.PluginCache;
import com.baidu.searchbox.aps.base.manager.PluginGroupManager;
import com.baidu.searchbox.aps.base.manager.PluginStatisticManager;
import com.baidu.searchbox.aps.base.utils.BaseConfiger;
import com.baidu.searchbox.aps.center.db.manager.PluginDBManager;
import com.baidu.searchbox.aps.center.init.manager.PluginInitManager;
import com.baidu.searchbox.aps.center.init.manager.PluginSilentInstallManager;
import com.baidu.searchbox.aps.center.install.dependence.PluginStateChangeManager;
import com.baidu.searchbox.aps.center.install.install.InstallManager;
import com.baidu.searchbox.aps.center.install.manager.PluginInstallParams;
import com.baidu.searchbox.aps.center.install.manager.PluginInstallStateGroupManager;
import com.baidu.searchbox.aps.center.install.type.PluginCancelType;
import com.baidu.searchbox.aps.center.install.type.PluginInstallType;
import com.baidu.searchbox.aps.center.install.type.PluginPauseType;
import com.baidu.searchbox.aps.center.install.type.PluginResumeType;
import com.baidu.searchbox.aps.center.install.type.PluginUninstallType;
import java.io.File;
import java.util.Map;
import java.util.Set;

public final class PluginInstallManager {
    private static final String TAG = "PluginInstallManager";
    private static PluginInstallManager sInstance;
    /* access modifiers changed from: private */
    public Context mAppContext;

    private PluginInstallManager(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static synchronized PluginInstallManager getInstance(Context context) {
        PluginInstallManager pluginInstallManager;
        synchronized (PluginInstallManager.class) {
            if (sInstance == null) {
                sInstance = new PluginInstallManager(context);
            }
            pluginInstallManager = sInstance;
        }
        return pluginInstallManager;
    }

    public boolean startInstall(String packageName, PluginInstallCallback callback) {
        return startInstall(packageName, true, false, callback);
    }

    public void startInstallByLocal(File file, final Plugin plugin, final PluginInstallCallback callback) {
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "startInstallByLocal:  packageName=" + plugin.getPackageName());
        }
        if (!file.exists()) {
            if (BaseConfiger.isDebug()) {
                Log.d(TAG, "startInstallByLocal: no local apk, packageName=" + plugin.getPackageName());
            }
            PluginDBManager.getInstance(this.mAppContext).handlePreset(false, plugin);
            if (callback != null) {
                callback.onResult(plugin.getPackageName(), 2, (String) null);
                return;
            }
            return;
        }
        MAPackageManager.getInstance(this.mAppContext).installApkFile(plugin.getPackageName(), file.getAbsolutePath(), new IInstallCallBack() {
            public void onPackageInstallFail(String packageName, String srcPathWithScheme, String reason) {
                if (BaseConfiger.isDebug()) {
                    Log.d(PluginInstallManager.TAG, "startInstallByLocal onPackageInstallFail: packageName=" + packageName);
                }
                PluginDBManager.getInstance(PluginInstallManager.this.mAppContext).handlePreset(false, plugin);
                PluginInstallParams iParams = PluginInstallStateGroupManager.getInstance(PluginInstallManager.this.mAppContext).getInstallParams(packageName);
                if (iParams != null) {
                    String installExtroInfo = "";
                    if (PluginSilentInstallManager.getInstance(PluginInstallManager.this.mAppContext).hasCacheCleanupUninstall(packageName)) {
                        installExtroInfo = "Extro Info: cleanup count= " + PluginSilentInstallManager.getInstance(PluginInstallManager.this.mAppContext).getCacheCleanupCount(packageName) + " |";
                    }
                    PluginStatisticManager.getInstance(PluginInstallManager.this.mAppContext).addInstallStatistic(2, packageName, installExtroInfo + "Install Type: " + iParams.installType + " | " + reason);
                }
                callback.onResult(packageName, 2, (String) null);
            }

            public void onPacakgeInstalled(String packageName) {
                if (BaseConfiger.isDebug()) {
                    Log.d(PluginInstallManager.TAG, "startInstallByLocal onPacakgeInstalled: packageName=" + packageName);
                }
                PluginDBManager.getInstance(PluginInstallManager.this.mAppContext).handlePreset(true, plugin);
                PluginInstallParams iParams = PluginInstallStateGroupManager.getInstance(PluginInstallManager.this.mAppContext).getInstallParams(packageName);
                if (iParams != null) {
                    String installExtroInfo = "";
                    if (PluginSilentInstallManager.getInstance(PluginInstallManager.this.mAppContext).hasCacheCleanupUninstall(packageName)) {
                        installExtroInfo = "Extro Info: cleanup count= " + PluginSilentInstallManager.getInstance(PluginInstallManager.this.mAppContext).getCacheCleanupCount(packageName) + " |";
                    }
                    PluginStatisticManager.getInstance(PluginInstallManager.this.mAppContext).addInstallStatistic(1, packageName, installExtroInfo + "Install Type: " + iParams.installType);
                }
                PluginInstallCallback pluginInstallCallback = callback;
                if (pluginInstallCallback != null) {
                    pluginInstallCallback.onResult(packageName, 1, (String) null);
                }
            }
        });
    }

    public boolean startInstall(String packageName, boolean isManual, PluginInstallCallback callback) {
        return startInstall(packageName, isManual, false, callback);
    }

    public boolean startInstall(String packageName, boolean isManual, boolean isSilent, PluginInstallCallback callback) {
        PluginInstallOption option = new PluginInstallOption();
        if (isManual) {
            option.installType = PluginInstallType.FRONT_INSTALL_PLUGIN;
            option.resumeType = PluginResumeType.MANUAL_RESUME_PLUGIN;
        } else {
            option.installType = PluginInstallType.SILENT_INSTALL_PLUGIN;
            option.resumeType = PluginResumeType.AUTO_RESUME_PLUGIN;
        }
        option.isSilent = isSilent;
        return startInstall(packageName, option, callback);
    }

    private boolean startInstall(String packageName, PluginInstallOption option, PluginInstallCallback callback) {
        if (!TextUtils.isEmpty(packageName) && option != null) {
            return InstallManager.getInstance(this.mAppContext).startInstall(packageName, option, callback);
        }
        if (!BaseConfiger.isDebug()) {
            return false;
        }
        Log.d(TAG, "startInstall : parameters is empty or null.");
        return false;
    }

    public boolean resumeInstallToAllWithoutManual(boolean needRestart) {
        Set<String> keySet;
        PluginInstallStateGroupManager.InstallStateInfo info;
        Map<String, PluginGroupManager.PluginGroup> groupList = PluginGroupManager.getAllPluginGroup(this.mAppContext);
        if (groupList == null || (keySet = groupList.keySet()) == null) {
            return true;
        }
        for (String key : keySet) {
            if (!TextUtils.isEmpty(key) && (info = PluginInstallStateGroupManager.getInstance(this.mAppContext).getCacheInstallStateInfo(key)) != null) {
                if ((!needRestart || info.needRestart) && ((info.needRestart || info.autoPause) && !startInstall(key, false, (PluginInstallCallback) null))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean pauseInstallToAllWithoutManual() {
        Set<String> keySet;
        PluginInstallStateGroupManager.InstallStateInfo info;
        Map<String, PluginGroupManager.PluginGroup> groupList = PluginGroupManager.getAllPluginGroup(this.mAppContext);
        if (groupList == null || (keySet = groupList.keySet()) == null) {
            return true;
        }
        for (String key : keySet) {
            if (!TextUtils.isEmpty(key) && (info = PluginInstallStateGroupManager.getInstance(this.mAppContext).getCacheInstallStateInfo(key)) != null) {
                info.autoPause = true;
                PluginInstallStateGroupManager.getInstance(this.mAppContext).saveCacheInstallStateInfo(key, info);
                if (!pauseInstall(key, false)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean pauseInstall(String packageName) {
        return pauseInstall(packageName, true);
    }

    public boolean pauseInstall(String packageName, boolean isManual) {
        PluginInstallOption option = new PluginInstallOption();
        if (isManual) {
            option.pauseType = PluginPauseType.MANUAL_PAUSE_PLUGIN;
        } else {
            option.pauseType = PluginPauseType.AUTO_PAUSE_PLUGIN;
        }
        return pauseInstall(packageName, option);
    }

    private boolean pauseInstall(String packageName, PluginInstallOption option) {
        if (!TextUtils.isEmpty(packageName) && option != null) {
            return InstallManager.getInstance(this.mAppContext).pauseInstall(packageName, option);
        }
        if (!BaseConfiger.isDebug()) {
            return false;
        }
        Log.d(TAG, "pauseInstall : parameters is empty or null.");
        return false;
    }

    public boolean cancelInstall(String packageName) {
        return cancelInstall(packageName, true);
    }

    public boolean cancelInstall(String packageName, boolean isManual) {
        PluginInstallOption option = new PluginInstallOption();
        if (isManual) {
            option.cancelType = PluginCancelType.MANUAL_CANCEL_PLUGIN;
        } else {
            option.cancelType = PluginCancelType.AUTO_CANCEL_PLUGIN;
        }
        return cancelInstall(packageName, option);
    }

    private boolean cancelInstall(String packageName, PluginInstallOption option) {
        if (!TextUtils.isEmpty(packageName) && option != null) {
            return InstallManager.getInstance(this.mAppContext).cancelInstall(packageName, option);
        }
        if (!BaseConfiger.isDebug()) {
            return false;
        }
        Log.d(TAG, "cancelInstall : parameters is empty or null.");
        return false;
    }

    public boolean uninstall(String packageName, PluginUninstallType opType, PluginUninstallCallback callback) {
        PluginUninstallOption option = new PluginUninstallOption();
        option.uninstallType = opType;
        return uninstall(packageName, option, callback);
    }

    public boolean uninstall(String packageName, PluginUninstallCallback callback) {
        return uninstall(packageName, true, callback);
    }

    public boolean uninstall(String packageName, boolean isManual, PluginUninstallCallback callback) {
        PluginUninstallOption option = new PluginUninstallOption();
        if (isManual) {
            option.uninstallType = PluginUninstallType.MANUAL_UNINSTALL_PLUGIN;
        } else {
            option.uninstallType = PluginUninstallType.AUTO_UNINSTALL_PLUGIN;
        }
        return uninstall(packageName, option, callback);
    }

    private boolean uninstall(String packageName, PluginUninstallOption option, PluginUninstallCallback callback) {
        if (!TextUtils.isEmpty(packageName) && option != null) {
            return InstallManager.getInstance(this.mAppContext).uninstall(packageName, option, callback);
        }
        if (!BaseConfiger.isDebug()) {
            return false;
        }
        Log.d(TAG, "uninstallPlugin : parameters is empty or null.");
        return false;
    }

    public boolean addStateChangeListener(String packageName, PluginStateChangeListener listener) {
        if (TextUtils.isEmpty(packageName) || listener == null) {
            return false;
        }
        return InstallManager.getInstance(this.mAppContext).addStateChangeListener(packageName, listener);
    }

    public boolean removeStateChangeListener(String packageName, PluginStateChangeListener listener) {
        if (TextUtils.isEmpty(packageName) || listener == null) {
            return false;
        }
        return InstallManager.getInstance(this.mAppContext).removeStateChangeListener(packageName, listener);
    }

    public DownloadProgressData getDownloadProgressData(String packageName) {
        return PluginStateChangeManager.getInstance(this.mAppContext).getDownloadProgressData(packageName);
    }

    public static class DownloadProgressData {
        public int currentBytes;
        public String packageName;
        public int speed;
        public int totalBytes;

        public DownloadProgressData() {
        }

        public DownloadProgressData(DownloadProgressData progress) {
            this.packageName = progress.packageName;
            this.currentBytes = progress.currentBytes;
            this.totalBytes = progress.totalBytes;
            this.speed = progress.speed;
        }
    }

    public long getInstalledVersion(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return -1;
        }
        if (PluginInitManager.getInstance(this.mAppContext).hasInited(packageName)) {
            return PluginCache.getInstance(packageName).getInstallVersion(this.mAppContext);
        }
        if (PluginInitManager.getInstance(this.mAppContext).containsLocalApk(packageName)) {
            long versionDB = PluginCache.getInstance(packageName).getDBInstallVersion(this.mAppContext);
            long versionPreset = PluginInitManager.getInstance(this.mAppContext).getPresetPluginVersion(packageName);
            if (versionDB < versionPreset) {
                return versionPreset;
            }
        }
        return PluginCache.getInstance(packageName).getInstallVersion(this.mAppContext);
    }
}
