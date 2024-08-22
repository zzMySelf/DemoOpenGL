package com.baidu.searchbox.video.detail.plugin.component.banner;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.video.banner.VideoBannerFactory;
import com.baidu.searchbox.feed.video.banner.view.DownloadExactBannerView;
import com.baidu.searchbox.feed.video.model.DownloadExactBannerModel;
import com.baidu.searchbox.video.detail.component.BaseVideoBannerComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/banner/DownloadExactBannerComponent;", "Lcom/baidu/searchbox/video/detail/component/BaseVideoBannerComponent;", "()V", "bannerView", "Lcom/baidu/searchbox/feed/video/banner/view/DownloadExactBannerView;", "bindData", "", "data", "Lorg/json/JSONObject;", "getLayout", "", "getName", "getView", "Landroid/view/View;", "gone", "handleMessage", "message", "Landroid/os/Message;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onNightModeChanged", "isNightMode", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadExactBannerComponent.kt */
public final class DownloadExactBannerComponent extends BaseVideoBannerComponent {
    private DownloadExactBannerView bannerView;

    public View getView() {
        VideoBannerFactory videoBannerFactory = VideoBannerFactory.INSTANCE;
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        Object createBannerView = videoBannerFactory.createBannerView("download_exact_banner", context);
        DownloadExactBannerView $this$getView_u24lambda_u2d0 = (DownloadExactBannerView) createBannerView;
        this.bannerView = $this$getView_u24lambda_u2d0;
        $this$getView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(VideoBannerFactory.INSTANCE.getSuggestViewWidth("download_exact_banner"), VideoBannerFactory.INSTANCE.getSuggestViewHeight("download_exact_banner")));
        return (View) createBannerView;
    }

    public String getName() {
        return "videoBanner";
    }

    public String getLayout() {
        return "download_exact_banner";
    }

    public void bindData(JSONObject data) {
        if (data != null) {
            JSONObject jSONObject = data;
            DownloadExactBannerModel model = (DownloadExactBannerModel) VideoBannerFactory.INSTANCE.createBannerModel("download_exact_banner", data);
            DownloadExactBannerView downloadExactBannerView = this.bannerView;
            if (downloadExactBannerView != null) {
                downloadExactBannerView.bindData(model);
            }
            preloadSmartApp(model);
        }
    }

    public void handleMessage(Message message) {
        Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
        if (valueOf != null && valueOf.intValue() == 28416) {
            if (message.arg1 == 28418) {
                gone();
            }
        } else if (valueOf != null && valueOf.intValue() == 36608 && message.arg1 == 36609) {
            gone();
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        DownloadExactBannerView downloadExactBannerView = this.bannerView;
        if (downloadExactBannerView != null) {
            downloadExactBannerView.updateNightModeUI();
        }
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        gone();
    }

    public void gone() {
        DownloadExactBannerView downloadExactBannerView = this.bannerView;
        if (downloadExactBannerView != null) {
            downloadExactBannerView.setVisibility(8);
        }
    }

    public void onDestroy() {
        DownloadExactBannerView downloadExactBannerView = this.bannerView;
        if (downloadExactBannerView != null) {
            downloadExactBannerView.onDestroy();
        }
    }
}
