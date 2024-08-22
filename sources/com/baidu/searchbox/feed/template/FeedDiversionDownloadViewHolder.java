package com.baidu.searchbox.feed.template;

import android.content.res.Resources;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ad.download.IDownloadPresenter;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.statistic.FeedUBCWrapper;
import com.baidu.searchbox.feed.template.appdownload.AdAppDownloadView;
import com.baidu.searchbox.feed.template.appdownload.FeedAppDownloadPresenter;
import java.util.HashMap;
import java.util.Map;

class FeedDiversionDownloadViewHolder implements View.OnClickListener {
    private static final String TAG = "FeedDiversionDownloadViewHolder";
    private IDownloadPresenter mAdAppDownloadPresenter;
    private final AdAppDownloadView mBtnDownload;
    private FeedAppDownloadPresenter mDownloadPresenter;
    private FeedBaseModel mFeedBaseModel;
    private Resources mResource;
    private View mRootView;

    FeedDiversionDownloadViewHolder(View view2) {
        this.mRootView = view2;
        this.mResource = view2.getResources();
        AdAppDownloadView adAppDownloadView = (AdAppDownloadView) this.mRootView.findViewById(R.id.feed_ad_operate_progress_button);
        this.mBtnDownload = adAppDownloadView;
        adAppDownloadView.setRadius(DeviceUtil.ScreenInfo.dp2px(view2.getContext(), 4.0f));
        this.mRootView.setOnClickListener(this);
        this.mDownloadPresenter = new FeedAppDownloadPresenter(adAppDownloadView.getContext(), adAppDownloadView);
        initSkin();
    }

    private void initSkin() {
        this.mRootView.setBackgroundColor(this.mResource.getColor(R.color.feed_ad_download_bar_bg));
        this.mBtnDownload.setForeground(this.mResource.getColor(R.color.feed_ad_download_button_fg));
        this.mBtnDownload.setTextColor(this.mResource.getColor(com.baidu.android.common.ui.style.R.color.GC68));
        this.mBtnDownload.setBackgroundDrawable(this.mResource.getDrawable(R.drawable.feed_ad_progress_button_bg));
    }

    /* access modifiers changed from: protected */
    public void update(FeedBaseModel model) {
        initSkin();
        this.mFeedBaseModel = model;
        this.mDownloadPresenter.update(model);
    }

    public void onClick(View v) {
        this.mDownloadPresenter.onDownloadBtnClick();
        HashMap<String, String> map = new HashMap<>(3);
        map.put("from", "feed");
        map.put("type", "click");
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        map.put("value", feedBaseModel != null ? feedBaseModel.runtimeStatus.channelId : "");
        FeedUBCWrapper.ubcOnEvent(FeedStatisticConstants.UBC_FEED_APP_DOWNLOAD, (Map<String, String>) map);
    }
}
