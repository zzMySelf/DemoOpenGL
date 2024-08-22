package com.baidu.searchbox.imagesearch.host.invoke.impl;

import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceRegistry;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.imagesearch.common.common.ImageSearchABTestUtils;
import com.baidu.searchbox.imagesearch.common.common.ResizeUtils;
import com.baidu.searchbox.imagesearch.host.invoke.impl.callback.ImageSearchPluginInvokeCallback;
import com.baidu.searchbox.imagesearch.host.invoke.impl.manager.ImageSearchPluginDownloader;
import com.baidu.searchbox.imagesearch.plugin.IImageSearchPlugin;
import java.lang.ref.SoftReference;

public class ImageSearchPluginInvoker {
    private static final String IMAGE_SEARCH_IMPL_CLASS_NAME = "com.baidu.searchbox.godeye.ImageSearchPluginImpl";
    private static final String IMAGE_SEARCH_PKG_NAME = "com.baidu.searchbox.godeye";
    public static final int INVOKE_FAILED = -1;
    public static final int INVOKE_PLUGIN_NPS_FAILED_BASE = -10000;
    public static final int INVOKE_SUCCESS = 0;
    /* access modifiers changed from: private */
    public volatile boolean mAvailable;
    /* access modifiers changed from: private */
    public IImageSearchPlugin mImageSearchPlugin;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static ImageSearchPluginInvoker instance = new ImageSearchPluginInvoker();

        private SingletonHolder() {
        }
    }

    public static ImageSearchPluginInvoker getInstance() {
        return SingletonHolder.instance;
    }

    private ImageSearchPluginInvoker() {
        this.mAvailable = false;
    }

    public void invokeImageSearchPlugin(ImageSearchPluginInvokeCallback callback) {
        if (this.mAvailable) {
            callback.onResult(0);
            return;
        }
        final SoftReference<ImageSearchPluginInvokeCallback> callbackRef = new SoftReference<>(callback);
        loadGodEyePlugin(new IInvokeCallback() {
            public void onResult(int retCode, String retMsg, Object retObject) {
                if (retCode == 14) {
                    try {
                        ImageSearchPluginDownloader.preUpdatePlugin();
                        IImageSearchPlugin unused = ImageSearchPluginInvoker.this.mImageSearchPlugin = (IImageSearchPlugin) ((Class) retObject).newInstance();
                        ServiceRegistry.registerService(IImageSearchPlugin.SERVICE_REFERENCE, new ServiceFetcher<IImageSearchPlugin>() {
                            public IImageSearchPlugin getService() {
                                return ImageSearchPluginInvoker.this.mImageSearchPlugin;
                            }
                        });
                        boolean unused2 = ImageSearchPluginInvoker.this.mAvailable = true;
                        ImageSearchPluginInvokeCallback pluginCallback = (ImageSearchPluginInvokeCallback) callbackRef.get();
                        if (pluginCallback != null) {
                            pluginCallback.onResult(0);
                        }
                    } catch (Throwable e2) {
                        ImageSearchPluginInvokeCallback pluginCallback2 = (ImageSearchPluginInvokeCallback) callbackRef.get();
                        if (pluginCallback2 != null) {
                            pluginCallback2.onResult(-1);
                        }
                        e2.printStackTrace();
                    }
                } else {
                    ImageSearchPluginInvokeCallback pluginCallback3 = (ImageSearchPluginInvokeCallback) callbackRef.get();
                    if (pluginCallback3 != null) {
                        pluginCallback3.onResult(ImageSearchPluginInvoker.this.mapNpsRetToGraphStatus(retCode));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public int mapNpsRetToGraphStatus(int retCode) {
        return (retCode * -1) - 10000;
    }

    public boolean isAvailable() {
        return this.mAvailable;
    }

    /* access modifiers changed from: private */
    public boolean isPluginReady() {
        return NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.godeye") == 43;
    }

    private void loadGodEyePlugin(final IInvokeCallback callback) {
        if (isPluginReady()) {
            NPSManager.getInstance().loadClazz("com.baidu.searchbox.godeye", IMAGE_SEARCH_IMPL_CLASS_NAME, IImageSearchPlugin.class, callback);
        } else {
            NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.godeye", 6, (IInstallCallback) new IInstallCallback() {
                public void onResult(int retCode, String retMsg) {
                    if (retCode == 13) {
                        NPSManager.getInstance().loadClazz("com.baidu.searchbox.godeye", ImageSearchPluginInvoker.IMAGE_SEARCH_IMPL_CLASS_NAME, IImageSearchPlugin.class, callback);
                    } else if (retCode != 34) {
                        callback.onResult(retCode, retMsg, (Object) null);
                    }
                }

                public void onProgress(long l, long l1) {
                }
            });
        }
    }

    public void preparePluginBundle() {
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() {
            public void run() {
                if (!ImageSearchPluginInvoker.this.mAvailable && ImageSearchPluginInvoker.this.isPluginReady()) {
                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.godeye", ImageSearchPluginInvoker.IMAGE_SEARCH_IMPL_CLASS_NAME, IImageSearchPlugin.class, new IInvokeCallback() {
                        public void onResult(int retCode, String retMsg, Object retObject) {
                            if (retCode == 14) {
                                try {
                                    IImageSearchPlugin unused = ImageSearchPluginInvoker.this.mImageSearchPlugin = (IImageSearchPlugin) ((Class) retObject).newInstance();
                                    ServiceRegistry.registerService(IImageSearchPlugin.SERVICE_REFERENCE, new ServiceFetcher<IImageSearchPlugin>() {
                                        public IImageSearchPlugin getService() {
                                            return ImageSearchPluginInvoker.this.mImageSearchPlugin;
                                        }
                                    });
                                    boolean unused2 = ImageSearchPluginInvoker.this.mAvailable = true;
                                    if (ImageSearchABTestUtils.INSTANCE.getCameraLaunchOptimize() && ImageSearchPluginInvoker.this.mImageSearchPlugin != null) {
                                        ImageSearchPluginInvoker.this.mImageSearchPlugin.preloadPluginConfig();
                                    }
                                } catch (Throwable e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                    ExecutorUtilsExt.delayPostOnElastic(new Runnable() {
                        public void run() {
                            if (ImageSearchABTestUtils.INSTANCE.getSearchGraphInterceptLocalImage()) {
                                ResizeUtils.INSTANCE.deleteExpireFile(System.currentTimeMillis());
                            }
                        }
                    }, "nps-graph-search-delete-expire-file", 3, 30000);
                }
            }
        }, "nps-graph-search-preparebundle", 1, 500);
    }
}
