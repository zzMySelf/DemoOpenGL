package com.baidu.searchbox.ad.download.manager;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ad.dazzle.view.DownloadButtonAttr;
import com.baidu.searchbox.ad.dazzle.view.LpDownloadButtonFactoryKt;
import com.baidu.searchbox.ad.download.IDownloadListener;
import com.baidu.searchbox.ad.download.IDownloadPresenter;
import com.baidu.searchbox.ad.download.IDownloadView;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.download.data.AdDownloadBean;
import com.baidu.searchbox.ad.download.data.AdDownloadExtra;
import com.baidu.searchbox.ad.download.ioc.IDownloadPresenterCreator;
import com.baidu.searchbox.ad.download.utils.AdDownloadUtils;
import com.baidu.searchbox.ad.view.AdLpEnhanceView;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.R;
import com.baidu.searchbox.feed.ad.model.AppInfoModel;
import com.baidu.searchbox.nadcore.uad.NadUadModelMapperKt;
import java.lang.ref.WeakReference;

public class AdEnhanceDownloadProxy {
    private final String mAdId;
    private final AppInfoModel mAppInfoModel;
    private final Context mContext;
    private final AdDownload mDownload;
    private final AdDownloadBean mDownloadBean;
    protected IDownloadPresenter<AdDownload> mDownloadPresenter;
    private AdLpEnhanceView mEnhanceView;
    private boolean mMaxPage = false;

    public AdEnhanceDownloadProxy(AdDownloadBean downloadBean, AdDownload adDownload, String adId, AppInfoModel adAppInfo) {
        this.mAdId = adId;
        this.mDownloadBean = downloadBean;
        this.mDownload = adDownload;
        this.mAppInfoModel = adAppInfo;
        this.mContext = AdRuntimeHolder.getAdRuntime().context().getApplicationContext();
    }

    public void update(RelativeLayout adView, boolean maxPage) {
        this.mMaxPage = maxPage;
        updateDownloadView(adView);
        configPresenter();
    }

    private void appendDownloadView(RelativeLayout container, IDownloadView<View> downloadView) {
        container.removeAllViews();
        AdLpEnhanceView adLpEnhanceView = new AdLpEnhanceView(this.mContext);
        this.mEnhanceView = adLpEnhanceView;
        adLpEnhanceView.setInfo(this.mAdId, this.mMaxPage, this.mAppInfoModel);
        if (hasStartDownload()) {
            this.mEnhanceView.updateView(AdLpEnhanceView.PROCESS_WITHOUT_ANIMATOR, container, downloadView, NadUadModelMapperKt.oldBean2NadBean(this.mDownloadBean));
        } else if (!this.mMaxPage) {
            this.mEnhanceView.updateView(AdLpEnhanceView.PROCESS_WITH_ANIMATOR, container, downloadView, NadUadModelMapperKt.oldBean2NadBean(this.mDownloadBean));
        } else if (container.getVisibility() == 0) {
            this.mEnhanceView.updateView(AdLpEnhanceView.PROCESS_WITH_ANIMATOR, container, downloadView, NadUadModelMapperKt.oldBean2NadBean(this.mDownloadBean));
        } else {
            this.mEnhanceView.updateView(AdLpEnhanceView.PROCESS_WITHOUT_ANIMATOR, container, downloadView, NadUadModelMapperKt.oldBean2NadBean(this.mDownloadBean));
        }
    }

    private void updateDownloadView(RelativeLayout adView) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mDownload != null && this.mDownloadBean != null && adView != null) {
            int bgColor = this.mContext.getResources().getColor(R.color.ad_lp_enhance_bg_color);
            int fgColor = this.mContext.getResources().getColor(R.color.ad_lp_enhance_fg_color);
            Resources resources = this.mContext.getResources();
            float buttonTextSize = AdUtil.getFloatValue(this.mContext, R.dimen.default_rect_text_size);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) adView.getLayoutParams();
            if (layoutParams2 == null) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                adView.setLayoutParams(layoutParams3);
                layoutParams = layoutParams3;
            } else {
                layoutParams = layoutParams2;
            }
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.dimens_17dp);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.dimens_17dp);
            layoutParams.rightMargin = dimensionPixelOffset;
            layoutParams.leftMargin = dimensionPixelOffset;
            configRoundProgressStyle(adView, bgColor, true, buttonTextSize, fgColor, 9.0f);
        }
    }

    private void configRoundProgressStyle(RelativeLayout view2, int color, boolean isRound, float buttonTextSize, int fgColor, float radius) {
        appendDownloadView(view2, LpDownloadButtonFactoryKt.createButton(this.mContext, new DownloadButtonAttr.Builder().setBgColor(color).setIsRound(isRound).setCornerRadius(radius).setTextSize(DeviceUtil.ScreenInfo.dp2pxf(view2.getContext(), buttonTextSize)).setIsShowProgress(true).setFgColor(fgColor).setTextColor(-1).setBtnText(this.mContext.getResources().getString(R.string.ad_button_download)).build(), this.mDownload));
    }

    private void configPresenter() {
        IDownloadPresenter<AdDownload> iDownloadPresenter = this.mDownloadPresenter;
        if (iDownloadPresenter != null) {
            iDownloadPresenter.unregisterAppStatusListener();
            this.mDownloadPresenter.unregisterDownloadListener();
        }
        this.mDownloadPresenter = IDownloadPresenterCreator.Impl.get().newInstance(IDownloadPresenterCreator.PresenterType.NormalPresenter, this.mEnhanceView, new AlsSender(), new DownloadListener(), this.mDownloadBean, this.mContext);
    }

    public AdDownloadBean getDownloadBean() {
        return this.mDownloadBean;
    }

    private boolean hasStartDownload() {
        AdDownload adDownload = this.mDownload;
        return adDownload == null || adDownload.extra.status != AdDownloadExtra.STATUS.STATUS_NONE;
    }

    public void reset() {
        IDownloadPresenter<AdDownload> iDownloadPresenter = this.mDownloadPresenter;
        if (iDownloadPresenter != null) {
            iDownloadPresenter.unregisterAppStatusListener();
            this.mDownloadPresenter.unregisterDownloadListener();
            this.mDownloadPresenter = null;
        }
    }

    private static class AlsSender implements IDownloadPresenter.IAlsSender {
        private final WeakReference<AdEnhanceDownloadProxy> mProxyRef;

        private AlsSender(AdEnhanceDownloadProxy proxy) {
            this.mProxyRef = new WeakReference<>(proxy);
        }

        public void sendALS(String actionType, String daArea, AdDownload download) {
            AdEnhanceDownloadProxy proxy = (AdEnhanceDownloadProxy) this.mProxyRef.get();
            if (proxy != null && download != null) {
                AdDownloadUtils.sendAls(actionType, Als.Area.LP_ENHANCE.value, proxy.getDownloadBean());
            }
        }
    }

    private static class DownloadListener implements IDownloadPresenter.IAdDownloadListener {
        public void onClicked(AdDownload download) {
        }

        public void onStart(Uri uri, int newProgress) {
        }

        public void onProgressChanged(Uri uri, int newProgress) {
        }

        public void onPause(Uri uri, int newProgress) {
        }

        public void onStopped(IDownloadListener.STATUS stopStatus) {
        }

        public void onSuccess(Uri uri) {
        }
    }
}
