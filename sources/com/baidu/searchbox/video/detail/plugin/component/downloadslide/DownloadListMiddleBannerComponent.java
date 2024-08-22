package com.baidu.searchbox.video.detail.plugin.component.downloadslide;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.video.banner.VideoBannerFactory;
import com.baidu.searchbox.feed.video.banner.VideoBannerManifest;
import com.baidu.searchbox.feed.video.banner.model.DownloadListBannerModel;
import com.baidu.searchbox.feed.video.banner.view.DownloadListBannerView;
import com.baidu.searchbox.video.detail.core.plugin.ComponentAdapter;
import com.baidu.searchbox.video.detail.message.MessageUtils;
import com.baidu.searchbox.video.detail.protocol.Component;
import com.baidu.searchbox.video.detail.service.IDividerService;
import org.json.JSONObject;

public class DownloadListMiddleBannerComponent extends ComponentAdapter {
    private DownloadListBannerModel mModel;
    private DownloadListStatisticsCallBack mStatisticsCallBack;
    protected DownloadListBannerView mView;

    public View getView() {
        this.mView = (DownloadListBannerView) VideoBannerFactory.INSTANCE.createBannerView(VideoBannerManifest.BANNER_TPL_NAME_DOWNLOAD_LIST, this.mContext);
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(VideoBannerFactory.INSTANCE.getSuggestViewWidth(VideoBannerManifest.BANNER_TPL_NAME_DOWNLOAD_LIST), VideoBannerFactory.INSTANCE.getSuggestViewHeight(VideoBannerManifest.BANNER_TPL_NAME_DOWNLOAD_LIST)));
        this.mView.hideTopView();
        this.mView.setVisibility(8);
        this.mStatisticsCallBack = new DownloadListStatisticsCallBack("middle", this.mComponentManager);
        return this.mView;
    }

    public void bindData(JSONObject data) {
        this.mView.onRelease();
        if (data != null) {
            this.mModel = (DownloadListBannerModel) VideoBannerFactory.INSTANCE.createBannerModel(VideoBannerManifest.BANNER_TPL_NAME_DOWNLOAD_LIST, data);
        } else {
            this.mModel = null;
        }
        DownloadListBannerModel downloadListBannerModel = this.mModel;
        if (downloadListBannerModel == null || !downloadListBannerModel.checkDownloadListsValidate()) {
            this.mView.setVisibility(8);
            return;
        }
        this.mView.bindData(this.mModel);
        showDownloadListBanner();
        uploadDownloadSlideUbc();
    }

    public void gone() {
        if (isNonNull(this.mView)) {
            this.mView.setVisibility(8);
        }
    }

    public void handleMessage(Message message) {
        if (MessageUtils.needResetData(message)) {
            DownloadListBannerView downloadListBannerView = this.mView;
            if (downloadListBannerView != null) {
                downloadListBannerView.setVisibility(8);
                this.mView.onRelease();
            }
            this.mModel = null;
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        DownloadListBannerView downloadListBannerView = this.mView;
        if (downloadListBannerView != null) {
            downloadListBannerView.setNightModeSwitched(true);
            this.mView.updateModeUi();
        }
    }

    /* access modifiers changed from: protected */
    public void showDownloadListBanner() {
        if (isNonNull(this.mModel)) {
            this.mView.setVisibility(0);
            this.mView.updateModeUi();
            IDividerService service = (IDividerService) this.mComponentManager.getService(IDividerService.class);
            if (service != null) {
                service.controlVisibilityStatus(true);
            }
        }
    }

    private void uploadDownloadSlideUbc() {
        if (!isNull(this.mModel)) {
            this.mStatisticsCallBack.update(this.mModel.mLists);
            this.mView.setOnDownloadSlideListener(this.mStatisticsCallBack);
        }
    }

    public void onPause() {
        DownloadListBannerModel downloadListBannerModel;
        super.onPause();
        if (this.mStatisticsCallBack != null && (downloadListBannerModel = this.mModel) != null && downloadListBannerModel.checkDownloadListsValidate()) {
            this.mStatisticsCallBack.showChildItemStatistics();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (isNonNull(this.mView)) {
            this.mView.onRelease();
            this.mView.removeOnDownloadSlideListener();
        }
    }

    public String getName() {
        return Component.DownloadListSlideMiddle.NAME;
    }

    public String getLayout() {
        return Component.DownloadListSlideMiddle.FEED_DOWNLOAD_LIST_MIDDLE_LAYOUT;
    }
}
