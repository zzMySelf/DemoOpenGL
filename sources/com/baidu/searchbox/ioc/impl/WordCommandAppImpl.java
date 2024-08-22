package com.baidu.searchbox.ioc.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.SearchboxApplication;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.exclusion.popup.ShowStatus;
import com.baidu.searchbox.exclusion.popup.ShowStatusCallback;
import com.baidu.searchbox.imagesearch.host.entry.IImageSearchInvokePlugin;
import com.baidu.searchbox.imagesearch.host.entry.base.ImageSearchBaseResult;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchBaseCallback;
import com.baidu.searchbox.imagesearch.host.entry.direct.ImageSearchRealDirect;
import com.baidu.searchbox.imagesearch.host.entry.params.WordCommandInvokeParams;
import com.baidu.searchbox.imagesearch.host.entry.status.ImageSearchRealStatus;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.util.UtilityCanBeProguard;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.searchbox.wordscommand.data.CommandContent;
import com.baidu.searchbox.wordscommand.listener.PictureCommandInvokeCallBack;
import com.baidu.searchbox.wordscommand.runtime.IWordCommandApp;
import com.baidu.searchbox.wordscommand.util.WordCommandUbcKt;
import com.baidu.swan.api.SwanAppApi;

public class WordCommandAppImpl implements IWordCommandApp {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "WordCommandAppImpl";
    /* access modifiers changed from: private */
    public DialogInterface mCommandDialog = null;

    public void getPictureCommandContent(String imagePath, final PictureCommandInvokeCallBack callBack) {
        Uri pathUri = UtilityCanBeProguard.getUri(imagePath);
        if (pathUri != null) {
            WordCommandInvokeParams params = new WordCommandInvokeParams();
            params.pathUri = pathUri;
            params.from = "26";
            ((IImageSearchInvokePlugin) ServiceManager.getService(IImageSearchInvokePlugin.SERVICE_REFERENCE)).decodeBarCodeForWordCommand(params, new IImageSearchBaseCallback() {
                public void onResult(int resultCode, ImageSearchBaseResult result) {
                    if (resultCode == 0) {
                        callBack.onResult(result.getBarcodeResult());
                    }
                }

                public void onStatusChanged(ImageSearchRealStatus status) {
                }

                public void onDirect(ImageSearchRealDirect direct) {
                }
            });
        }
    }

    public void handlePreloadSwanApp() {
        if (SwanAppApi.getPreloadRuntime() != null) {
            SwanAppApi.getPreloadRuntime().handlePreloadSwanApp();
        }
    }

    public boolean canPreloadSwanApp(String wordCommand) {
        if (TextUtils.isEmpty(wordCommand)) {
            return false;
        }
        return wordCommand.contains("type=smartProgram");
    }

    public boolean isNewInstall() {
        return SpeedStats.getInstance().getLaunchType() == 2;
    }

    public void doOnShowParseCommandDialogWithPopupExclusion(Context context, CommandContent commandContent) {
        WordCommandUbcKt.ubcWordCommandNormal(WordCommandUbcKt.UBC_PAGE_ADD_ALERT_QUEUE);
        final Context context2 = context;
        final CommandContent commandContent2 = commandContent;
        PopupExclusionManagerMap.getInstance().display("scene_home", new PopupExclusionManagerMap.Operation(ExclusionType.HOME_WORD_CMD, 1.2f, true, true) {
            public void onShow(ShowStatusCallback callback) {
                WordCommandUbcKt.ubcWordCommandNormal(WordCommandUbcKt.UBC_PAGE_ALERT_SUCCESS);
                WordCommandManager.getInstance().doOnShowParseCommandDialog(context2, commandContent2, new WordCommandAppImpl$2$$ExternalSyntheticLambda0(this), new WordCommandAppImpl$2$$ExternalSyntheticLambda1(this));
                callback.callback(ShowStatus.REAL_SHOW);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$onShow$0$com-baidu-searchbox-ioc-impl-WordCommandAppImpl$2  reason: not valid java name */
            public /* synthetic */ void m20587lambda$onShow$0$combaidusearchboxiocimplWordCommandAppImpl$2(DialogInterface dialog) {
                if (!isBreak()) {
                    PopupExclusionManagerMap.getInstance().unDisplay("scene_home", ExclusionType.HOME_WORD_CMD);
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$onShow$1$com-baidu-searchbox-ioc-impl-WordCommandAppImpl$2  reason: not valid java name */
            public /* synthetic */ void m20588lambda$onShow$1$combaidusearchboxiocimplWordCommandAppImpl$2(DialogInterface dialog) {
                DialogInterface unused = WordCommandAppImpl.this.mCommandDialog = dialog;
            }

            public void onBreaked() {
                if (WordCommandAppImpl.this.mCommandDialog != null) {
                    WordCommandAppImpl.this.mCommandDialog.dismiss();
                    DialogInterface unused = WordCommandAppImpl.this.mCommandDialog = null;
                }
            }
        });
    }

    public void schemeInvoke(String scheme) {
        BaseRouter.invoke(AppRuntime.getAppContext(), scheme);
    }

    public boolean isMainProcess() {
        return SearchboxApplication.isMainProcess();
    }
}
