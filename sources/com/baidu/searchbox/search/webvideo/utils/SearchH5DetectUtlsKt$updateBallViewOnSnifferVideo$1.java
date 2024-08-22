package com.baidu.searchbox.search.webvideo.utils;

import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "showDownload", "", "showNetDisk", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5DetectUtls.kt */
final class SearchH5DetectUtlsKt$updateBallViewOnSnifferVideo$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ String $aExtension;
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ String $sourceUrl;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchH5DetectUtlsKt$updateBallViewOnSnifferVideo$1(String str, String str2, String str3, String str4) {
        super(2);
        this.$sourceUrl = str;
        this.$title = str2;
        this.$pageUrl = str3;
        this.$aExtension = str4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean showDownload, boolean showNetDisk) {
        String ubcType;
        if (AppConfig.isDebug()) {
            Log.e("gcj", "第一次进，嗅探到视频准备展示悬浮球");
        }
        if (showDownload || showNetDisk) {
            SearchH5DetectUtlsKt.mCanSniffer = true;
            if (SearchH5DetectUtlsKt.mCanSniffer) {
                SearchH5VideoUbcUtils.videoSnifferUserInfoEvent(this.$aExtension);
                SearchH5DetectUtlsKt.requestQueryTask(this.$sourceUrl, this.$title, this.$pageUrl);
            }
            UiThreadUtils.runOnUiThread(new SearchH5DetectUtlsKt$updateBallViewOnSnifferVideo$1$$ExternalSyntheticLambda0());
            if (SearchH5SnifferToastUtilsKt.isShowOnlyDownload()) {
                ubcType = "only_download";
            } else {
                ubcType = "sniffer";
            }
            SearchH5VideoUbcUtils.floatingBallStatistic("show", ubcType, SearchH5VideoUbcUtils.STEP_LCB_XFQ_BT_SHOW);
            SearchH5VideoUbcUtils.snifferSwitchStatus(SearchH5VideoUbcUtils.TYPE_ALREADY_OPEN);
            FloatingBallViewUtilsKt.updateTipsAmount(SearchH5DetectUtlsKt.getSnifferVideoList().size());
            return;
        }
        SearchH5DetectUtlsKt.mCanSniffer = false;
        FloatingBallViewUtilsKt.hideFloatingBallView();
        SearchH5VideoUbcUtils.ubcWebsiteCannotSniffer(this.$sourceUrl, this.$title, this.$pageUrl);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2977invoke$lambda0() {
        FloatingBallViewUtilsKt.showFloatingBall();
    }
}
