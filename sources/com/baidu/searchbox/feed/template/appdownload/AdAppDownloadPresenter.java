package com.baidu.searchbox.feed.template.appdownload;

import android.content.Context;
import com.baidu.searchbox.ad.download.IDownloadPresenter;
import com.baidu.searchbox.ad.download.IDownloadView;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.download.data.AdDownloadBean;
import com.baidu.searchbox.ad.download.data.AdDownloadExtra;

public class AdAppDownloadPresenter extends BaseAdAppDownloadNewPresenter<IDownloadView, AdDownload> {
    public AdAppDownloadPresenter(IDownloadView downloadView, IDownloadPresenter.IAlsSender alsSender, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean) {
        super(downloadView, alsSender, listener, downloadBean);
    }

    public AdAppDownloadPresenter(IDownloadView downloadView, IDownloadPresenter.IAlsSender alsSender, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean, Context context) {
        super(downloadView, alsSender, listener, downloadBean, context);
    }

    public void updateUIStatus(AdDownload download) {
        if (download.extra.status == AdDownloadExtra.STATUS.STATUS_DOWNLOADING) {
            this.mDownloadView.setProgress(download.extra.getPercent());
            return;
        }
        String text = getButtonText(download);
        if (download.extra.status == AdDownloadExtra.STATUS.STATUS_SUCCESS) {
            this.mDownloadView.setProgress(100);
        }
        if (download.extra.status == AdDownloadExtra.STATUS.STATUS_PAUSED) {
            this.mDownloadView.setProgress(download.extra.getPercent());
        }
        this.mDownloadView.setText(text);
    }
}
