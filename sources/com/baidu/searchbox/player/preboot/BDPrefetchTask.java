package com.baidu.searchbox.player.preboot;

import com.baidu.cyberplayer.sdk.remote.DuMediaPrefetchOptions;
import com.baidu.searchbox.export.ISettingActivityUtils;
import com.baidu.searchbox.player.interfaces.IPreRequestVideoFlowDetailData;
import com.baidu.searchbox.player.layer.BaseKernelLayerKt;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.plugin.utils.MPDEncoder;
import com.baidu.searchbox.player.preboot.env.PrebootInfo;
import com.baidu.searchbox.player.preboot.env.PrebootRuntimeKt;
import com.baidu.searchbox.player.preboot.task.PreFetchTask;
import com.baidu.searchbox.player.preboot.utils.PrebootSeriesExtKt;
import com.baidu.searchbox.player.utils.BdCyberInstallUtils;
import com.baidu.searchbox.player.utils.ExtLogUtil;
import com.baidu.searchbox.player.utils.SimpleCyberInstallListener;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeriesEx;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/player/preboot/BDPrefetchTask;", "Lcom/baidu/searchbox/player/preboot/task/PreFetchTask;", "prebootInfo", "Lcom/baidu/searchbox/player/preboot/env/PrebootInfo;", "(Lcom/baidu/searchbox/player/preboot/env/PrebootInfo;)V", "getPrefetchOptions", "Lcom/baidu/cyberplayer/sdk/remote/DuMediaPrefetchOptions;", "bps", "", "moovSize", "scene", "", "getUA", "installDumedia", "", "listener", "Lcom/baidu/searchbox/player/utils/SimpleCyberInstallListener;", "isFreeCard", "tryPrefetchDetailData", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BDPrefetchTask.kt */
public class BDPrefetchTask extends PreFetchTask {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BDPrefetchTask(PrebootInfo prebootInfo) {
        super(prebootInfo);
        Intrinsics.checkNotNullParameter(prebootInfo, "prebootInfo");
    }

    public void installDumedia(SimpleCyberInstallListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BdCyberInstallUtils.installCyber$default(listener, 0, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public DuMediaPrefetchOptions getPrefetchOptions(int bps, int moovSize, String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (bps == -1 || moovSize == -1) {
            return new DuMediaPrefetchOptions();
        }
        DuMediaPrefetchOptions duMediaPrefetchOptions = new DuMediaPrefetchOptions();
        DuMediaPrefetchOptions $this$getPrefetchOptions_u24lambda_u2d0 = duMediaPrefetchOptions;
        $this$getPrefetchOptions_u24lambda_u2d0.setOption("video-bps", bps);
        $this$getPrefetchOptions_u24lambda_u2d0.setOption("video-moov-size", moovSize);
        Boolean isWifi4GDualEnable = ISettingActivityUtils.Impl.get().isWifi4GDualEnable();
        Intrinsics.checkNotNullExpressionValue(isWifi4GDualEnable, "get().isWifi4GDualEnable");
        if (isWifi4GDualEnable.booleanValue()) {
            $this$getPrefetchOptions_u24lambda_u2d0.setOption("video_bind_4g", "1");
        }
        $this$getPrefetchOptions_u24lambda_u2d0.setOption("scenex", scene);
        int prefetchBuffer = PrebootRuntimeKt.getPrefetchBuffer(getPrebootInfo(), PrebootSeriesExtKt.getGRPlayTimeQ(getSeries()));
        if (prefetchBuffer > 0) {
            $this$getPrefetchOptions_u24lambda_u2d0.setOption("prefetch_duration", prefetchBuffer);
            PrebootSeriesExtKt.setPrefetchBuffer(getSeries(), prefetchBuffer);
        }
        float predictConsumeTime = PrebootSeriesExtKt.getPredictConsumeTimeMs(getSeries());
        if (predictConsumeTime > 0.0f) {
            $this$getPrefetchOptions_u24lambda_u2d0.setOption(BDPrefetchTaskKt.OPT_PREDICT_CONSUME_TIME, String.valueOf(predictConsumeTime));
        }
        return duMediaPrefetchOptions;
    }

    /* access modifiers changed from: protected */
    public String getUA() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String isFreeCard() {
        return BaseKernelLayerKt.toOption(MPDEncoder.isDaShengCard());
    }

    private final void tryPrefetchDetailData() {
        IPreRequestVideoFlowDetailData iPreRequestVideoFlowDetailData = IPreRequestVideoFlowDetailData.Impl.INSTANCE.get();
        BasicVideoSeries series = getSeries();
        String str = null;
        String from = series != null ? series.getFrom() : null;
        BasicVideoSeries series2 = getSeries();
        String source = series2 != null ? series2.getSource() : null;
        BasicVideoSeries series3 = getSeries();
        if (series3 != null) {
            str = series3.getPage();
        }
        if (iPreRequestVideoFlowDetailData.isFirstJumpVideo(from, str, source)) {
            IPreRequestVideoFlowDetailData.Impl.INSTANCE.get().preRequestVideoFlowDetailData(BdVideoSeriesEx.getCmdParams(getSeries()), ExtLogUtil.getCtr(getSeries()));
        }
    }
}
