package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.boxdownload.IBoxDownloadDbOperator;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.webvideo.model.SearchVideoH5DownloadModel;
import com.baidu.searchbox.search.webvideo.model.SnifferVideoInfo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "showDownload", "", "showNetDisk", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5DetectUtls.kt */
final class SearchH5DetectUtlsKt$onDetectVideo$1$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ BdVideoSeries $videoSeries;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchH5DetectUtlsKt$onDetectVideo$1$1(String str, BdVideoSeries bdVideoSeries) {
        super(2);
        this.$pageUrl = str;
        this.$videoSeries = bdVideoSeries;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean showDownload, boolean showNetDisk) {
        if ((!showDownload && !showNetDisk) || !Intrinsics.areEqual((Object) SearchH5DetectUtlsKt.getCurrentUrl(), (Object) this.$pageUrl)) {
            return;
        }
        if (!SearchH5AbManager.INSTANCE.isSnifferShieldOpen() || SnifferPanelShieldManager.INSTANCE.canAutoShow()) {
            IBoxDownloadDbOperator downloadDbOperator = (IBoxDownloadDbOperator) ServiceManager.getService(IBoxDownloadDbOperator.Companion.getSERVICE_REFERENCE());
            boolean isShow = false;
            try {
                for (SnifferVideoInfo info : CollectionsKt.toList(SearchH5DetectUtlsKt.getSnifferVideoList())) {
                    String sourceUrl = info.getSourceUrl();
                    if (sourceUrl == null) {
                        sourceUrl = "";
                    }
                    if (downloadDbOperator.queryItem(1, sourceUrl) == null) {
                        isShow = true;
                    }
                }
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
            if (isShow) {
                final String str = this.$pageUrl;
                SearchH5DownloadUtilsKt.getVideoInfoList(new Function1<List<SearchVideoH5DownloadModel>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((List<SearchVideoH5DownloadModel>) (List) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<SearchVideoH5DownloadModel> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String str = str;
                        if (str == null) {
                            str = "";
                        }
                        SearchH5DetectUtlsKt.setLastDetectedPage(str);
                        if (Intrinsics.areEqual((Object) SearchH5DetectUtlsKt.getCurrentUrl(), (Object) str)) {
                            SearchH5VideoUbcUtils.updateSource();
                            SearchH5ToastUtilKt.setSnifferSource(true);
                            if (!SearchH5ToastUtilKt.isSnifferPanelShowing()) {
                                SearchH5ToastUtilKt.setAutoShowing(true);
                                SearchH5ToastUtilKt.showSnifferPanel(it, "2", SearchVideoSnifferPanelStyleExperimentKt.CLICK_FROM_FLOATING_BALL);
                                if (SearchH5AbManager.INSTANCE.isSnifferShieldOpen()) {
                                    SnifferPanelShieldManager.INSTANCE.onPanelAutoShow();
                                }
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        String str2 = this.$pageUrl;
        BdVideo selectedVideo = this.$videoSeries.getSelectedVideo();
        String str3 = null;
        String title = selectedVideo != null ? selectedVideo.getTitle() : null;
        BdVideo selectedVideo2 = this.$videoSeries.getSelectedVideo();
        if (selectedVideo2 != null) {
            str3 = selectedVideo2.getPlayUrl();
        }
        SearchH5VideoUbcUtils.ubcPanelFrequencyControl(str2, title, str3);
    }
}
