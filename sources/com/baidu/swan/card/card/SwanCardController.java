package com.baidu.swan.card.card;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.card.card.core.SwanCardCoreRuntime;
import com.baidu.swan.card.card.core.SwanCardEnv;
import com.baidu.swan.card.card.core.SwanCardGroup;
import com.baidu.swan.card.card.page.SwanCardPage;
import com.baidu.swan.card.card.page.SwanCardPagesRoute;
import com.baidu.swan.card.card.preload.SwanCardLocalService;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.launch.callback.BaseLoadInfo;
import com.baidu.swan.card.launch.callback.BundleLoadCallback;
import com.baidu.swan.card.launch.dispatcher.SwanCardEventDispatcher;
import com.baidu.swan.card.launch.model.SwanCardLaunchInfo;
import com.baidu.swan.card.launch.model.SwanCardPageParam;
import com.baidu.swan.card.launch.model.SwanCardParam;
import com.baidu.swan.card.launch.model.SwanCoreVersion;
import com.baidu.swan.card.pkg.SwanCardBundleHelper;
import com.baidu.swan.card.pkg.config.CardWindowConfig;
import com.baidu.swan.card.pkg.config.SwanCardConfigData;
import com.baidu.swan.card.pkg.config.SwanCardPageAlias;
import com.baidu.swan.card.pkg.model.ErrCode;
import com.baidu.swan.card.pkg.model.SwanEvent;
import com.baidu.swan.card.render.engine.event.msg.SwanAppNativeMessage;
import com.baidu.swan.card.render.engine.event.msg.SwanAppWebMessage;
import com.baidu.swan.card.render.engine.event.msg.SwanCardBaseMessage;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppWebView;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppWebViewManager;
import com.baidu.swan.card.ubc.SwanAppPerformanceUBC;
import com.baidu.swan.card.utils.SwanAppApsUtils;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanAppUrlUtils;
import com.baidu.swan.card.utils.SwanCardLog;
import com.baidu.swan.card.utils.SwanCardUtil;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class SwanCardController {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final Lock INSTANCE_LOCK = new ReentrantLock();
    private static final String TAG = "SwanCardController";
    private static volatile SwanCardController sInstance;

    private SwanCardController() {
    }

    public static SwanCardController getInstance() {
        Lock lock = INSTANCE_LOCK;
        lock.lock();
        try {
            if (sInstance == null) {
                sInstance = new SwanCardController();
            }
            SwanCardController swanCardController = sInstance;
            lock.unlock();
            return swanCardController;
        } catch (Throwable th2) {
            INSTANCE_LOCK.unlock();
            throw th2;
        }
    }

    public void asyncLoadSwanApp(final String cardId, final SwanCardLaunchInfo swanCardLaunchInfo) {
        if (DEBUG) {
            Log.d(TAG, "asyncLoadSwanApp swanCoreVersion: " + swanCardLaunchInfo.getSwanCoreVersion());
        }
        SwanCardBundleHelper.asyncLoadSwanApp(cardId, swanCardLaunchInfo, new BundleLoadCallback() {
            public void onLoaded(int resultCode, BaseLoadInfo loadInfo, ErrCode errCode) {
                final SwanCardBundleHelper.SwanAppLoadInfo loadedInfo = (SwanCardBundleHelper.SwanAppLoadInfo) loadInfo;
                if (SwanCardPagesRoute.needPreLoadSubPackage(swanCardLaunchInfo, loadedInfo)) {
                    if (SwanCardManager.get().getCardOrNull(cardId) == null || TextUtils.isEmpty(loadedInfo.mAppBundlePath)) {
                        SwanCardLog.w(SwanCardController.TAG, "subpackage is invalid");
                    } else {
                        String page = SwanAppUrlUtils.delAllParamsFromUrl(swanCardLaunchInfo.getPage());
                        if (!TextUtils.isEmpty(page) && page.startsWith(File.separator)) {
                            page = page.substring(1);
                        }
                        String pkgName = loadedInfo.mConfigData.mSubPackageList.mSubPackagesPagesMap.get(SwanCardPageAlias.checkRoutesPath(cardId, page));
                        SwanCardPagesRoute.downloadSubPackage(swanCardLaunchInfo.getAppId(), swanCardLaunchInfo.getVersion(), "3", pkgName, loadedInfo.mConfigData.mSubPackagesPath.mSubPackagesPathMap.get(pkgName), cardId, new SwanCardPagesRoute.CheckPagesCallback() {
                            public void preDownload() {
                                SwanCardEventDispatcher.dispatchEvent(cardId, new SwanEvent.Impl("event_pkg_download_start"));
                            }

                            public void success(String cardId) {
                                SwanAppPerformanceUBC.requireSession(cardId, "startup").putValue("type", "0");
                                SwanCardLog.i(SwanCardController.TAG, "download subpackage success cardId: " + cardId);
                                SwanCardController.this.checkInfoAndLoad(cardId, 0, swanCardLaunchInfo, loadedInfo, (ErrCode) null);
                            }

                            public void failed(int errorCode, ErrCode pmsDetailError) {
                                SwanCardLog.w(SwanCardController.TAG, "download subpackage fail: " + errorCode);
                                SwanCardController.this.checkInfoAndLoad(cardId, 1, swanCardLaunchInfo, loadedInfo, new ErrCode().feature(5).error(38).causeBy(pmsDetailError).detail("download subpackage fail, cardId: " + cardId + "; code:" + errorCode));
                            }
                        });
                        return;
                    }
                }
                SwanCardController.this.checkInfoAndLoad(cardId, resultCode, swanCardLaunchInfo, loadedInfo, errCode);
            }
        });
        SwanCardCoreRuntime runtime = getCardRuntime(cardId);
        runtime.syncSwanCore(swanCardLaunchInfo);
        runtime.prepareRuntime((SwanCardCoreRuntime.PrepareStatusCallback) null);
    }

    /* access modifiers changed from: private */
    public void checkInfoAndLoad(final String cardId, int resultCode, final SwanCardLaunchInfo launchInfo, final SwanCardBundleHelper.SwanAppLoadInfo loadedInfo, ErrCode errCode) {
        if (resultCode != 0 || launchInfo == null || loadedInfo == null) {
            SwanCardManager.get().resetCardView(cardId, errCode);
            return;
        }
        SwanCard swanCard = SwanCardManager.get().getCard(cardId);
        SwanCardUtil.removeFromUiThread(swanCard.getLoadResultRunnable());
        Runnable loadResultRunnable = new Runnable() {
            public void run() {
                SwanCardController.this.handleLoadSwanApp(cardId, launchInfo, loadedInfo);
            }
        };
        swanCard.setLoadResultRunnable(loadResultRunnable);
        SwanCardUtil.runOnUiThreadAtOnce(loadResultRunnable);
    }

    public void syncLoadSwanApp(String cardId, final SwanCardLaunchInfo swanCardLaunchInfo) {
        if (DEBUG) {
            Log.d(TAG, "syncLoadSwanApp swanCoreVersion: " + swanCardLaunchInfo.getSwanCoreVersion());
        }
        SwanCardCoreRuntime runtime = getCardRuntime(cardId);
        runtime.syncSwanCore(swanCardLaunchInfo);
        runtime.prepareRuntime((SwanCardCoreRuntime.PrepareStatusCallback) null);
        SwanCardConfigData configData = getConfigData(cardId);
        if (configData != null) {
            SwanCardBundleHelper.SwanAppLoadInfo info = new SwanCardBundleHelper.SwanAppLoadInfo();
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    SwanCardRuntime.getSwanCardContext().deleteLowerVersionFolder(swanCardLaunchInfo.getAppId(), swanCardLaunchInfo.getVersion());
                }
            }, "deleteLowerVersionFolder", 2);
            info.mConfigData = configData;
            info.cardId = cardId;
            info.mAppBundlePath = SwanCardBundleHelper.ReleaseBundleHelper.getUnzipFolder(swanCardLaunchInfo.getAppId(), swanCardLaunchInfo.getVersion()).getPath() + File.separator;
            handleLoadSwanApp(cardId, swanCardLaunchInfo, info);
        }
    }

    /* access modifiers changed from: private */
    public void handleLoadSwanApp(String cardId, SwanCardLaunchInfo launchInfo, SwanCardBundleHelper.SwanAppLoadInfo loadedInfo) {
        if (DEBUG) {
            Log.d(TAG, "#handleLoadSwanApp loadedInfo=" + loadedInfo);
        }
        if (SwanCardManager.get().getCard(cardId).isDestroyed()) {
            SwanCardManager.get().resetCardView(cardId, new ErrCode().feature(5).error(59).detail("card is destroyed"));
            return;
        }
        getCardRuntime(cardId).startFirstPage(cardId, launchInfo, loadedInfo);
    }

    public void preloadSwanAppRuntime(Intent intent) {
        SwanCardEnv.get();
        ExecutorUtilsExt.postOnSerial(new Runnable() {
            public void run() {
                if (SwanCardController.DEBUG) {
                    Log.d(SwanCardController.TAG, "loadV8So start");
                }
                SwanCardLocalService.SoLoadHolder.get();
                if (SwanCardController.DEBUG) {
                    Log.d(SwanCardController.TAG, "loadV8So end");
                }
                SwanCardUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        SwanCardGroup.get().preloadCoreRuntime();
                    }
                });
            }
        }, "preload_swan");
    }

    public SwanCoreVersion getCoreVersion(String cardId) {
        return getCardRuntime(cardId).getSwanCoreVersion();
    }

    public SwanCardConfigData getConfigData(String cardId) {
        SwanCard swanCard = SwanCardManager.get().getCard(cardId);
        if (swanCard.hasAppOccupied()) {
            return swanCard.getConfig();
        }
        return null;
    }

    public CardWindowConfig getPageWindowConfig(String cardId, String page) {
        return SwanCardManager.get().getCard(cardId).getPageWindowConfig(page);
    }

    public CardWindowConfig getPageWindowConfig(String cardId, String page, SwanCardConfigData configData, String bundlePath) {
        return SwanCardManager.get().getCard(cardId).getPageWindowConfig(page, configData, bundlePath);
    }

    public CardWindowConfig obtainNewWindowConfig(String cardId, String page) {
        return SwanCardManager.get().getCard(cardId).obtainNewWindowConfig(page);
    }

    public String getBaseUrl(String cardId) {
        return SwanCardManager.get().getCard(cardId).getBaseUrl();
    }

    public String getLaunchUrl(String cardId) {
        return SwanCardManager.get().getCard(cardId).getLaunchUrl();
    }

    public String getFirstPageUrl(String cardId) {
        SwanCardConfigData configData = getConfigData(cardId);
        return configData == null ? "" : configData.getFirstPageUrl();
    }

    public boolean isSupportDebug(String cardId) {
        SwanCard swanCard = SwanCardManager.get().getCardOrNull(cardId);
        if (swanCard == null) {
            return false;
        }
        SwanCardLaunchInfo launchInfo = swanCard.getInfo();
        if ((!DEBUG || !launchInfo.isDebug()) && !SwanAppApsUtils.isTrialPackage(launchInfo) && !SwanAppApsUtils.isDevPackage(launchInfo)) {
            return false;
        }
        return true;
    }

    public ISwanAppWebViewManager getWebViewManager(String id) {
        return SwanCardGroup.get().getWebViewManager(id);
    }

    public View getBdWebViewBySlaveId(String slaveId) {
        ISwanAppWebView ngWebView;
        ISwanAppWebViewManager manager = getWebViewManager(slaveId);
        if (manager == null || (ngWebView = manager.getWebView()) == null) {
            return null;
        }
        return ngWebView.getCurrentWebView();
    }

    public void handleNativeMessage(SwanAppNativeMessage message, boolean encode) {
        if (message != null) {
            SwanAppWebMessage webMessage = new SwanAppWebMessage();
            webMessage.mData = message.mData;
            webMessage.mNeedEncode = encode;
            if (DEBUG) {
                Log.d(TAG, "handleNativeMessage data: " + message.mData + " ; needEncode = " + encode);
            }
            sendJSMessage(message.mWebViewId, webMessage);
        }
    }

    public void sendJSMessage(String webviewId, SwanCardBaseMessage message) {
        SwanCardGroup.get().sendJSMessage(webviewId, message);
    }

    public String getAppId(String cardId) {
        return SwanCardManager.get().getCard(cardId).getAppId();
    }

    public String getAppKey(String cardId) {
        return SwanCardManager.get().getCard(cardId).getAppKey();
    }

    public SwanCardImpl getCardImpl(String cardId) {
        return SwanCardManager.get().getCard(cardId).getSwanCardImpl();
    }

    public SwanCardCoreRuntime getCardRuntime(String cardId) {
        return SwanCardManager.get().getCard(cardId).getCoreRuntime();
    }

    public void onLaunchError(final String cardId, final ErrCode errorInfo) {
        SwanCardUtil.runOnUiThread(new Runnable() {
            public void run() {
                SwanCardManager.get().resetCardView(cardId, errorInfo);
            }
        });
    }

    public void addCardPage(String cardId, SwanCardPageParam params) {
        if (!TextUtils.isEmpty(cardId) && params != null) {
            SwanCardManager.get().getCard(cardId).addPage(SwanCardPage.newInstance(new SwanCardParam.Builder().setCardId(cardId).setPage(params.mPage).setParams(params.mParams).setBaseUrl(params.mBaseUrl).setIsFirstPage(true).setRouteType(params.mRouteType).setRouteId(params.mRouteId).setScene(params.mScene).setCoreReady(params.mCoreReady).build()));
        }
    }
}
