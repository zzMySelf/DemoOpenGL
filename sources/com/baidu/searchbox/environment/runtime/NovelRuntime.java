package com.baidu.searchbox.environment.runtime;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.discovery.novel.INovelContext;
import com.baidu.searchbox.environment.dinovel.NovelAbilityImpl;
import com.baidu.searchbox.environment.dinovel.pluginentrance.NovelBaseImpl;
import com.baidu.searchbox.novel.NovelContext_Factory;
import com.baidu.searchbox.novel.ioc.container.INovelAbility;
import com.baidu.searchbox.noveladapter.novelcore.IReaderManagerInterface;

public class NovelRuntime {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String INTENT_FRAGMENT_NAME_KEY = "invoke_fragment";
    public static final String PROTOCOL_NOVEL_NAME = "DiscoveryNovelHomeFragment";
    /* access modifiers changed from: private */
    public static String privateSDPath;
    private static INovelContext sNovelContext;

    static {
        initNovelPath();
    }

    public static void initNovelPath() {
        final NovelBaseImpl<IReaderManagerInterface> novelBase = new NovelBaseImpl<IReaderManagerInterface>() {
            /* access modifiers changed from: protected */
            public IReaderManagerInterface getCorePluginInterface() {
                return IReaderManagerInterface.Impl.get();
            }
        };
        if (!novelBase.isNovelPluginAvailable()) {
            novelBase.loadPluginWithLoading(new Runnable() {
                public void run() {
                    if (NovelBaseImpl.this.corePluginInterface != null) {
                        ((IReaderManagerInterface) NovelBaseImpl.this.corePluginInterface).initNovelPath(new IReaderManagerInterface.Impl.OnPathResult() {
                            public void onResult(String path) {
                                String unused = NovelRuntime.privateSDPath = path;
                            }
                        });
                    }
                }
            });
        } else if (novelBase.corePluginInterface != null) {
            ((IReaderManagerInterface) novelBase.corePluginInterface).initNovelPath(new IReaderManagerInterface.Impl.OnPathResult() {
                public void onResult(String path) {
                    String unused = NovelRuntime.privateSDPath = path;
                }
            });
        }
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static String getNovelSDPath() {
        if (privateSDPath == null) {
            try {
                privateSDPath = AppRuntime.getAppContext().getExternalFilesDir("com.baidu.searchbox.novel").getPath();
                initNovelPath();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return privateSDPath;
    }

    public static INovelContext getNovelContext() {
        return NovelContext_Factory.get();
    }

    public static INovelAbility getNovelAbility() {
        return new NovelAbilityImpl();
    }
}
