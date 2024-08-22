package com.baidu.searchbox.feed.template.appdownload;

import com.baidu.searchbox.ad.download.IDownloadPresenter;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.download.data.AdDownloadBean;
import com.baidu.searchbox.ad.download.data.AdDownloadExtra;
import com.baidu.searchbox.feed.core.R;

public class FeedCircularDownloadPresenter extends BaseAdAppDownloadNewPresenter<CircularDownloadStateButton, AdDownload> {
    public FeedCircularDownloadPresenter(CircularDownloadStateButton downloadView, IDownloadPresenter.IAlsSender alsSender, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean) {
        super(downloadView, alsSender, listener, downloadBean);
    }

    public void updateUIStatus(AdDownload download) {
        if (download != null && download.extra != null && download.extra.status != null) {
            ((CircularDownloadStateButton) this.mDownloadView).initSkin();
            ((CircularDownloadStateButton) this.mDownloadView).setText(getButtonText(download));
            switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS[download.extra.status.ordinal()]) {
                case 1:
                    if (this.mDownloadView instanceof TitleMoveDownCircularDownloadStateButton) {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(R.drawable.download_state_begin_title_move_down);
                        return;
                    } else {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(com.baidu.searchbox.feed.template.R.drawable.download_state_begin);
                        return;
                    }
                case 2:
                    ((CircularDownloadStateButton) this.mDownloadView).setProgress(download.extra.getPercent());
                    return;
                case 3:
                    if (this.mDownloadView instanceof TitleMoveDownCircularDownloadStateButton) {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(R.drawable.download_state_pause_title_move_down);
                        return;
                    } else {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(com.baidu.searchbox.feed.template.R.drawable.download_state_pause);
                        return;
                    }
                case 4:
                    if (this.mDownloadView instanceof TitleMoveDownCircularDownloadStateButton) {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(R.drawable.download_state_finish_title_move_down);
                        return;
                    } else {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(com.baidu.searchbox.feed.template.R.drawable.download_state_finish);
                        return;
                    }
                case 5:
                    if (this.mDownloadView instanceof TitleMoveDownCircularDownloadStateButton) {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(R.drawable.download_state_open_title_move_down);
                        return;
                    } else {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(com.baidu.searchbox.feed.template.R.drawable.download_state_open);
                        return;
                    }
                case 6:
                    if (this.mDownloadView instanceof TitleMoveDownCircularDownloadStateButton) {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(R.drawable.download_state_begin_title_move_down);
                        return;
                    } else {
                        ((CircularDownloadStateButton) this.mDownloadView).setStateImageRes(com.baidu.searchbox.feed.template.R.drawable.download_state_begin);
                        return;
                    }
                default:
                    return;
            }
        } else if (DEBUG) {
            throw new IllegalArgumentException("Invalid download data!");
        }
    }

    /* renamed from: com.baidu.searchbox.feed.template.appdownload.FeedCircularDownloadPresenter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS;

        static {
            int[] iArr = new int[AdDownloadExtra.STATUS.values().length];
            $SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS = iArr;
            try {
                iArr[AdDownloadExtra.STATUS.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS[AdDownloadExtra.STATUS.STATUS_DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS[AdDownloadExtra.STATUS.STATUS_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS[AdDownloadExtra.STATUS.STATUS_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS[AdDownloadExtra.STATUS.STATUS_INSTALL_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS[AdDownloadExtra.STATUS.STATUS_FAILED_RETRY.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public int resourceMap(AdDownloadExtra.STATUS status) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ad$download$data$AdDownloadExtra$STATUS[status.ordinal()]) {
            case 1:
                return R.string.feed_ad_button_download;
            case 2:
                return R.string.feed_ad_button_pause_download;
            case 3:
                return R.string.feed_ad_button_continue;
            case 4:
                return R.string.feed_ad_button_install;
            case 5:
                return R.string.feed_ad_button_open;
            case 6:
                return R.string.feed_ad_button_failed_retry;
            default:
                return R.string.feed_ad_button_download;
        }
    }
}
