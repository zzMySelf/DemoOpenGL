package com.baidu.searchbox.ioc;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.ad.download.IDownloadPresenter;
import com.baidu.searchbox.ad.download.IDownloadView;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.download.data.AdDownloadBean;
import com.baidu.searchbox.ad.download.ioc.IDownloadPresenterCreator;
import com.baidu.searchbox.ad.download.utils.AdDownloadUtils;
import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.suffix.SuffixCircularDownloadButon;
import com.baidu.searchbox.feed.ad.suffix.SuffixCircularDownloadPresenter;
import com.baidu.searchbox.feed.template.appdownload.AdAppDownloadPresenter;
import com.baidu.searchbox.feed.template.appdownload.AdDoubleBtnDownloadView;
import com.baidu.searchbox.feed.template.appdownload.CircularDownloadStateButton;
import com.baidu.searchbox.feed.template.appdownload.CommonAdAppDownloadPresenter;
import com.baidu.searchbox.feed.template.appdownload.CommonAdAppDownloadView;
import com.baidu.searchbox.feed.template.appdownload.DoubleBtnDownloadPresenter;
import com.baidu.searchbox.feed.template.appdownload.FeedCircularDownloadPresenter;
import com.baidu.searchbox.feed.template.appdownload.FeedSectorDownloadPresenter;
import com.baidu.searchbox.feed.template.appdownload.MiniVideoDetailAdDownloadView;
import com.baidu.searchbox.feed.template.appdownload.MiniVideoDetailAdPopViewDownloadPresenter;
import com.baidu.searchbox.feed.template.appdownload.NadRectDownloadBtnPresenter;
import com.baidu.searchbox.feed.template.appdownload.NadRectDownloadBtnView;
import com.baidu.searchbox.feed.template.appdownload.SectorDownloadView;
import com.baidu.searchbox.feed.template.appdownload.WithoutViewAppDownloadPresenter;
import com.baidu.searchbox.nadcore.uad.NadDownloadPresenterBase;
import com.baidu.searchbox.nadcore.uad.NadDownloadPresenterFlowTail;
import com.baidu.searchbox.nadcore.uad.NadUadModelMapperKt;
import com.baidu.searchbox.video.feedflow.ad.tailframe.FlowVideoAdDownloadPresenter;

public class DownloadPresenterCreator implements IDownloadPresenterCreator {
    public IDownloadPresenter<AdDownload> newInstance(IDownloadPresenterCreator.PresenterType type, IDownloadView downloadView, IDownloadPresenter.IAlsSender alsSender, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean) {
        return newInstance(type, downloadView, alsSender, listener, downloadBean, (Context) null);
    }

    public IDownloadPresenter<AdDownload> newInstance(IDownloadPresenterCreator.PresenterType type, IDownloadView downloadView, IDownloadPresenter.IAlsSender alsSender, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean, Context context) {
        if (globalSwallowUadSwitch(downloadBean)) {
            return nadPresenter(type, downloadView, listener, downloadBean);
        }
        return newInstanceWithoutExp(type, downloadView, alsSender, listener, downloadBean, context);
    }

    public IDownloadPresenter<AdDownload> newInstanceWithoutExp(IDownloadPresenterCreator.PresenterType type, IDownloadView downloadView, IDownloadPresenter.IAlsSender alsSender, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean, Context context) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ad$download$ioc$IDownloadPresenterCreator$PresenterType[type.ordinal()]) {
            case 1:
                return new AdAppDownloadPresenter(downloadView, alsSender, listener, downloadBean, context);
            case 2:
                return new WithoutViewAppDownloadPresenter(downloadView, alsSender, listener, downloadBean);
            case 3:
                if (downloadView instanceof MiniVideoDetailAdDownloadView) {
                    return new MiniVideoDetailAdPopViewDownloadPresenter((MiniVideoDetailAdDownloadView) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            case 4:
                if (downloadView instanceof NadRectDownloadBtnView) {
                    return new NadRectDownloadBtnPresenter((NadRectDownloadBtnView) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            case 5:
                if (downloadView instanceof AdDoubleBtnDownloadView) {
                    return new DoubleBtnDownloadPresenter((AdDoubleBtnDownloadView) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            case 6:
                if (downloadView instanceof MiniVideoDetailAdDownloadView) {
                    return new FlowVideoAdDownloadPresenter((MiniVideoDetailAdDownloadView) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            case 7:
                if (downloadView instanceof CommonAdAppDownloadView) {
                    return new CommonAdAppDownloadPresenter((CommonAdAppDownloadView) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            case 8:
                if (downloadView instanceof SectorDownloadView) {
                    return new FeedSectorDownloadPresenter((SectorDownloadView) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            case 9:
                if (downloadView instanceof CircularDownloadStateButton) {
                    return new FeedCircularDownloadPresenter((CircularDownloadStateButton) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            case 10:
                if (downloadView instanceof SuffixCircularDownloadButon) {
                    return new SuffixCircularDownloadPresenter((SuffixCircularDownloadButon) downloadView, alsSender, listener, downloadBean);
                }
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
            default:
                return generateDefaultPresenter(downloadView, alsSender, listener, downloadBean);
        }
    }

    private boolean globalSwallowUadSwitch(AdDownloadBean bean) {
        if (bean == null || !bean.isValid() || AdDownloadUtils.isInSwallowUadBlackList(bean.business) || ADConfigManager.instance().getGlobalConfInt("uad_sdk_global_switch", 1) != 1) {
            return false;
        }
        return true;
    }

    private IDownloadPresenter<AdDownload> nadPresenter(IDownloadPresenterCreator.PresenterType type, IDownloadView downloadView, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean) {
        com.baidu.nadcore.download.model.AdDownloadBean bean;
        if (downloadView == null || !(downloadView.getRealView() instanceof View)) {
            bean = NadUadModelMapperKt.oldBean2NadBean(downloadBean);
        } else {
            bean = NadUadModelMapperKt.oldBean2NadBean(downloadBean, ((View) downloadView.getRealView()).getContext());
        }
        switch (type) {
            case FlowTailBtnPresenter:
                return new NadDownloadPresenterFlowTail(downloadView, listener, downloadBean, bean);
            default:
                return new NadDownloadPresenterBase(downloadView, listener, downloadBean, bean);
        }
    }

    private IDownloadPresenter<AdDownload> generateDefaultPresenter(IDownloadView downloadView, IDownloadPresenter.IAlsSender alsSender, IDownloadPresenter.IAdDownloadListener listener, AdDownloadBean downloadBean) {
        if (!FeedRuntime.GLOBAL_DEBUG) {
            return new AdAppDownloadPresenter(downloadView, alsSender, listener, downloadBean);
        }
        throw new IllegalArgumentException("Invalid type found!");
    }
}
