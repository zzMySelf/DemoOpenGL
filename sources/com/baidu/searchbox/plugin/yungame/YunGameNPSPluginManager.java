package com.baidu.searchbox.plugin.yungame;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nps.scheme.InvokeCallbackProxy;
import com.baidu.searchbox.plugin.yungame.manage.R;

public class YunGameNPSPluginManager {
    private static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.yunapp.searchbox.PluginInvoker";
    private static final String NPS_PLUGIN_PKG_NAME = "com.baidu.yunapp.searchbox";
    /* access modifiers changed from: private */
    public IYunPluginInvoker iYunPluginInvoker;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static YunGameNPSPluginManager instance = new YunGameNPSPluginManager();

        private SingletonHolder() {
        }
    }

    private YunGameNPSPluginManager() {
    }

    public static YunGameNPSPluginManager getInstance() {
        return SingletonHolder.instance;
    }

    public void invokeYunGame(final String entry, final String params, final InvokeCallbackProxy callbackProxy) {
        IYunPluginInvoker iYunPluginInvoker2 = this.iYunPluginInvoker;
        if (iYunPluginInvoker2 == null) {
            loadNPSPluginImpl(true, new IInvokeCallback() {
                public void onResult(int retCode, String retMsg, Object retObject) {
                    if (retCode == 14) {
                        try {
                            IYunPluginInvoker unused = YunGameNPSPluginManager.this.iYunPluginInvoker = (IYunPluginInvoker) ((Class) retObject).newInstance();
                            YunGameNPSPluginManager.this.iYunPluginInvoker.invoke(AppRuntime.getAppContext(), entry, params);
                            callbackProxy.onResult(0, (String) null);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            callbackProxy.onResult(1001, (String) null);
                        }
                    } else {
                        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.yungame_install_failure).showToast();
                        callbackProxy.onResult(1001, (String) null);
                    }
                }
            });
            return;
        }
        iYunPluginInvoker2.invoke(AppRuntime.getAppContext(), entry, params);
        callbackProxy.onResult(0, (String) null);
    }

    public boolean isAvailable() {
        return NPSPackageManager.getInstance().getBundleStatus(NPS_PLUGIN_PKG_NAME) == 43;
    }

    private void loadNPSPluginImpl(final boolean showLoading, final IInvokeCallback callback) {
        if (isAvailable()) {
            NPSManager.getInstance().loadClazz(NPS_PLUGIN_PKG_NAME, NPS_PLUGIN_IMPL_CLASS_NAME, IYunPluginInvoker.class, callback);
            return;
        }
        if (showLoading) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.yungame_plugin_installing).setDuration(6).showHighLoadingToast();
        }
        NPSPackageManager.getInstance().installBundle(NPS_PLUGIN_PKG_NAME, new IInstallCallback() {
            public void onResult(int retCode, String retMsg) {
                if (showLoading) {
                    UniversalToast.cancelToast();
                }
                if (retCode == 13) {
                    NPSManager.getInstance().loadClazz(YunGameNPSPluginManager.NPS_PLUGIN_PKG_NAME, YunGameNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, IYunPluginInvoker.class, callback);
                } else if (retCode == 34) {
                    if (showLoading) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.yungame_plugin_installing).showToast();
                    }
                } else if (showLoading) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.yungame_install_failure).showToast();
                }
            }

            public void onProgress(long l, long l1) {
            }
        });
    }
}
