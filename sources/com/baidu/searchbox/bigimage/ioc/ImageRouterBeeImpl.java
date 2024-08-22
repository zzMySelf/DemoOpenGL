package com.baidu.searchbox.bigimage.ioc;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.root.ImageInvokeParams;
import com.baidu.searchbox.bigimage.container.BigImageContainerModel;
import com.baidu.searchbox.bigimage.container.SDMContainerModel;
import com.baidu.searchbox.bigimage.download.model.DownloadPageContainerModel;
import com.baidu.searchbox.bigimage.download.model.DownloadPageModel;
import com.baidu.searchbox.bigimage.ioc.IImageRouter;
import com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter;
import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.IContainerManager;
import com.baidu.searchbox.browserenhanceengine.utils.BeeRenderMonitor;
import com.baidu.searchbox.search.pyramid.SearchBrowserInterface;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/bigimage/ioc/ImageRouterBeeImpl;", "Lcom/baidu/searchbox/bigimage/ioc/IImageRouter;", "()V", "getCurrentContainer", "Lcom/baidu/searchbox/browserenhanceengine/container/Container;", "openUrl", "", "context", "Landroid/content/Context;", "params", "Lcom/baidu/searchbox/bigimage/ioc/IImageRouter$OpenUrlParams;", "startEditResultPage", "", "base64", "", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "statParams", "", "startImageLandingPage", "Lcom/baidu/searchbox/bigimage/comp/root/ImageInvokeParams;", "startSDMImageLandingPage", "", "", "lib-bigimage-bee-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageRouterBeeImpl.kt */
public final class ImageRouterBeeImpl implements IImageRouter {
    public boolean openUrl(Context context, String url) {
        return IImageRouter.DefaultImpls.openUrl(this, context, url);
    }

    public boolean startImageLandingPage(ImageInvokeParams params) {
        IContainerManager cm;
        Container newContainer;
        Intrinsics.checkNotNullParameter(params, "params");
        Container container = getCurrentContainer();
        if (container == null || (cm = container.getContainerManager()) == null) {
            return false;
        }
        CharSequence managerId = cm.getManagerId();
        if (managerId == null || managerId.length() == 0) {
            return false;
        }
        SearchBrowserInterface searchBrowserInterface = (SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE);
        if (searchBrowserInterface != null) {
            searchBrowserInterface.setContainerUseWebViewPauseOpt(false);
        }
        boolean success = cm.openContainer(new BigImageContainerModel(params), (Map<String, Object>) null, true);
        if (success && (newContainer = cm.getCurrentContainer()) != null) {
            newContainer.setOriginContainerId(container.getContainerId());
        }
        return success;
    }

    public boolean startSDMImageLandingPage(Map<String, Object> params) {
        IContainerManager cm;
        Container newContainer;
        Container container = getCurrentContainer();
        if (container == null || (cm = container.getContainerManager()) == null) {
            return false;
        }
        CharSequence managerId = cm.getManagerId();
        if (managerId == null || managerId.length() == 0) {
            return false;
        }
        boolean success = cm.openContainer(new SDMContainerModel(params), (Map<String, Object>) null, true);
        if (success && (newContainer = cm.getCurrentContainer()) != null) {
            newContainer.setOriginContainerId(container.getContainerId());
        }
        return success;
    }

    private final Container<?> getCurrentContainer() {
        IContainerManager containerManager = BeeSchemeRouter.getContainerManager();
        if (containerManager != null) {
            return containerManager.getCurrentContainer();
        }
        return null;
    }

    public void startEditResultPage(String base64, ImagePageParams params, Map<String, String> statParams) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        Intrinsics.checkNotNullParameter(params, "params");
        IContainerManager manager = BeeSchemeRouter.getContainerManager();
        if (manager != null) {
            BeeRenderMonitor.getInstance().setStartTime("bigImageDownload", BeeRenderMonitor.getTime());
            DownloadPageModel model = new DownloadPageModel();
            DownloadPageModel $this$startEditResultPage_u24lambda_u2d3_u24lambda_u2d2 = model;
            $this$startEditResultPage_u24lambda_u2d3_u24lambda_u2d2.setEditResult(base64);
            $this$startEditResultPage_u24lambda_u2d3_u24lambda_u2d2.setExtraParams(params.getExtraParams());
            $this$startEditResultPage_u24lambda_u2d3_u24lambda_u2d2.setImageInfo(params.getImageInfo());
            $this$startEditResultPage_u24lambda_u2d3_u24lambda_u2d2.setFromRelation(params.isFromRelated());
            $this$startEditResultPage_u24lambda_u2d3_u24lambda_u2d2.setUbcParams(statParams);
            $this$startEditResultPage_u24lambda_u2d3_u24lambda_u2d2.setRefer(params.getRefer());
            manager.openContainer(new DownloadPageContainerModel(model), (Map<String, Object>) null, false);
        }
    }

    public boolean openUrl(Context context, IImageRouter.OpenUrlParams params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        IImageRouter.OpenUrlParams $this$openUrl_u24lambda_u2d5 = params;
        try {
            boolean z = true;
            if (!StringsKt.startsWith$default($this$openUrl_u24lambda_u2d5.getUrl(), "https://", false, 2, (Object) null)) {
                if (!StringsKt.startsWith$default($this$openUrl_u24lambda_u2d5.getUrl(), "http://", false, 2, (Object) null)) {
                    if ($this$openUrl_u24lambda_u2d5.getUrl().length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        return SchemeRouter.invoke(context, $this$openUrl_u24lambda_u2d5.getUrl());
                    }
                    return false;
                }
            }
            IContainerManager $this$openUrl_u24lambda_u2d5_u24lambda_u2d4 = BeeSchemeRouter.getContainerManager();
            if ($this$openUrl_u24lambda_u2d5_u24lambda_u2d4 != null) {
                Intrinsics.checkNotNullExpressionValue($this$openUrl_u24lambda_u2d5_u24lambda_u2d4, "getContainerManager()");
                $this$openUrl_u24lambda_u2d5_u24lambda_u2d4.openContainerWithUrl($this$openUrl_u24lambda_u2d5.getUrl(), $this$openUrl_u24lambda_u2d5.getHeader(), (Object) null, true);
                return true;
            }
            return false;
        } catch (Throwable t) {
            if (ImageRouterBeeImplKt.DEBUG) {
                t.printStackTrace();
                Log.w("ImageRouterBeeImpl", "打开URL失败, url: " + $this$openUrl_u24lambda_u2d5.getUrl() + ", msg: " + t.getMessage());
            }
            return false;
        }
    }
}
