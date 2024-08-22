package com.baidu.searchbox.video.feedflow.detail.player.player.plugin;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.export.IPlayerRouter;
import com.baidu.searchbox.layer.AirPlayExtPlugin;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.airplay.VulcanAirPlayLayer;
import com.baidu.searchbox.player.callback.BaseVulcanVideoPlayerCallbackManager;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcHelper;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.searchbox.video.feedflow.detail.player.player.layer.FlowVulcanAirPlayLayer;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/plugin/FlowVulcanAirPlayPlugin;", "Lcom/baidu/searchbox/layer/AirPlayExtPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "flow", "Lcom/baidu/ubc/Flow;", "sUbcService", "Lcom/baidu/ubc/UBCManager;", "kotlin.jvm.PlatformType", "uBCContent", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "appendWordHelpScheme", "", "createAirPlayLayer", "Lcom/baidu/searchbox/player/airplay/VulcanAirPlayLayer;", "getSubscribeEvent", "", "isAirPlayWorking", "", "onAirPlayIdle", "", "isClickExit", "onHelp", "onVideoEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "showAirPlayLayer", "startPlayByAirPlayPosition", "uploadFlow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVulcanAirPlayPlugin.kt */
public final class FlowVulcanAirPlayPlugin extends AirPlayExtPlugin {
    private Flow flow;
    private final UBCManager sUbcService = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE));
    private BDVideoPlayerUbcContent uBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowVulcanAirPlayPlugin(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean isAirPlayWorking() {
        return DIFactory.INSTANCE.getConfig().getAirPlayAbSwitch() && super.isAirPlayWorking();
    }

    private final String appendWordHelpScheme() {
        BdVideoSeries videoSeries;
        String $this$appendWordHelpScheme_u24lambda_u2d0;
        BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
        BaseVideoPlayer baseVideoPlayer = bindPlayer instanceof BaseVideoPlayer ? (BaseVideoPlayer) bindPlayer : null;
        if (baseVideoPlayer == null || (videoSeries = baseVideoPlayer.getVideoSeries()) == null || ($this$appendWordHelpScheme_u24lambda_u2d0 = videoSeries.getVid()) == null) {
            return "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fm.baidu.com%2Fvideo%2Fprojhelp%3Fpd%3Dvideo_page%26atn%3DscreenHelp%26word%3Ddefault%26top%3D%257B%2522sfhs%2522%253A1%252C%2522_hold%2522%253A2%257D";
        }
        return StringsKt.replace$default("baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fm.baidu.com%2Fvideo%2Fprojhelp%3Fpd%3Dvideo_page%26atn%3DscreenHelp%26word%3Ddefault%26top%3D%257B%2522sfhs%2522%253A1%252C%2522_hold%2522%253A2%257D", "default", $this$appendWordHelpScheme_u24lambda_u2d0, false, 4, (Object) null);
    }

    public int[] getSubscribeEvent() {
        return new int[]{4, 3, 6};
    }

    public void onVideoEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onVideoEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -2127352417:
                if (action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                    Object extra = event.getExtra(13);
                    if (!(extra instanceof BDVideoPlayerUbcContent)) {
                        extra = null;
                    }
                    this.uBCContent = (BDVideoPlayerUbcContent) extra;
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void showAirPlayLayer() {
        super.showAirPlayLayer();
        uploadFlow();
        this.flow = this.sUbcService.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING_DURATION);
    }

    /* access modifiers changed from: protected */
    public VulcanAirPlayLayer createAirPlayLayer() {
        FlowVulcanAirPlayLayer flowVulcanAirPlayLayer = new FlowVulcanAirPlayLayer();
        FlowVulcanAirPlayLayer $this$createAirPlayLayer_u24lambda_u2d1 = flowVulcanAirPlayLayer;
        $this$createAirPlayLayer_u24lambda_u2d1.setHelperListener(new FlowVulcanAirPlayPlugin$createAirPlayLayer$1$1(this));
        $this$createAirPlayLayer_u24lambda_u2d1.setRetryListener(new FlowVulcanAirPlayPlugin$createAirPlayLayer$1$2($this$createAirPlayLayer_u24lambda_u2d1, this));
        return flowVulcanAirPlayLayer;
    }

    /* access modifiers changed from: protected */
    public void onAirPlayIdle(boolean isClickExit) {
        super.onAirPlayIdle(isClickExit);
        uploadFlow();
    }

    private final void uploadFlow() {
        if (this.flow != null) {
            JSONObject businessObject = new JSONObject();
            businessObject.put("type", "miracast");
            String content = BDVideoPlayerUbcHelper.getUbcContent(this.uBCContent.getExtStatisticsLog(), this.uBCContent, businessObject);
            Intrinsics.checkNotNullExpressionValue(content, "getUbcContent(uBCContent…CContent, businessObject)");
            this.sUbcService.flowSetValueWithDuration(this.flow, content);
            this.sUbcService.flowEnd(this.flow);
            this.flow = null;
        }
    }

    public void onHelp() {
        super.onHelp();
        IPlayerRouter.Impl.get().invoke(getContext(), appendWordHelpScheme());
    }

    /* access modifiers changed from: protected */
    public void startPlayByAirPlayPosition() {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        super.startPlayByAirPlayPosition();
        BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null) {
            playerCallbackManager.onVideoPlayerStartByAirPlayPosition();
        }
    }
}
