package com.baidu.searchbox.player.barrage;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku;
import com.baidu.searchbox.danmakulib.interfaces.IDanmakuUpdateBarrageView;
import com.baidu.searchbox.danmakulib.widget.DanmakuPlaceholderEditView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.barrage.BarrageOperation;
import com.baidu.searchbox.player.callback.BaseVulcanVideoPlayerCallbackManager;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.event.VulcanControlEvent;
import com.baidu.searchbox.player.event.VulcanGestureEvent;
import com.baidu.searchbox.player.layer.ElementLayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\rH\u0014J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\rH\u0016J\u0012\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0016J\u0006\u00100\u001a\u00020\rJ\u0012\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u000e\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0019J\u0012\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010;\u001a\u00020\r2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020\rH\u0014J\b\u0010?\u001a\u00020\rH\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u0016H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006B"}, d2 = {"Lcom/baidu/searchbox/player/barrage/VulcanBarrageLayer;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/player/element/AbsElement;", "Lcom/baidu/searchbox/danmakulib/interfaces/IDanmakuUpdateBarrageView;", "()V", "barrageController", "Lcom/baidu/searchbox/player/barrage/VulcanBarrageViewController;", "getBarrageController", "()Lcom/baidu/searchbox/player/barrage/VulcanBarrageViewController;", "setBarrageController", "(Lcom/baidu/searchbox/player/barrage/VulcanBarrageViewController;)V", "addBarrage", "", "danmaku", "Lcom/baidu/searchbox/danmakulib/danmaku/model/BaseDanmaku;", "configBarrage", "controlBarrage", "operation", "Lcom/baidu/searchbox/player/barrage/BarrageOperation;", "disableBarrageSend", "disable", "", "force", "getBarrageStatsFrom", "", "getBarrageStatsSubFrom", "getBindPlayer", "Lcom/baidu/searchbox/player/BaseVulcanVideoPlayer;", "getContentView", "getDanmakuPlaceholderEditView", "Lcom/baidu/searchbox/danmakulib/widget/DanmakuPlaceholderEditView;", "getSubscribeEvent", "", "getVideoDuration", "initContainer", "isBarrageEnable", "loadBarrage", "onBarrageLoadComplete", "onBarrageSendSuccess", "topicId", "", "onControlEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onLayerEventNotify", "onLayerRelease", "onPlayerEventNotify", "resetBarrageInfo", "sendBarragePraiseEvent", "barragePraise", "Lcom/baidu/searchbox/player/barrage/VulcanBarragePraise;", "setBarrageInfo", "barrageModel", "Lcom/baidu/searchbox/player/barrage/VulcanBarrageInfo;", "setBarrageSwitch", "barrageSwitch", "setDanmakuEditHint", "danmakuEditHint", "setHotDanmakuList", "hotDanmakuList", "", "setupElement", "updateBarrageBtnVisibility", "updateBarrageVisibility", "isOn", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanBarrageLayer.kt */
public class VulcanBarrageLayer extends ElementLayer<FrameLayout, AbsElement> implements IDanmakuUpdateBarrageView {
    public VulcanBarrageViewController barrageController;

    public final VulcanBarrageViewController getBarrageController() {
        VulcanBarrageViewController vulcanBarrageViewController = this.barrageController;
        if (vulcanBarrageViewController != null) {
            return vulcanBarrageViewController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("barrageController");
        return null;
    }

    public final void setBarrageController(VulcanBarrageViewController vulcanBarrageViewController) {
        Intrinsics.checkNotNullParameter(vulcanBarrageViewController, "<set-?>");
        this.barrageController = vulcanBarrageViewController;
    }

    /* access modifiers changed from: protected */
    public void initContainer() {
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        setBarrageController(new VulcanBarrageViewController(context, getBarrageStatsFrom(), getBarrageStatsSubFrom(), this, new VulcanBarrageLayer$initContainer$1(this), new VulcanBarrageLayer$initContainer$2(this), new VulcanBarrageLayer$initContainer$3(this)));
    }

    public FrameLayout getContentView() {
        return getBarrageController().getBarrageViewWrapper();
    }

    /* access modifiers changed from: protected */
    public void setupElement() {
    }

    public void onControlEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case 723345051:
                if (action.equals("control_event_start")) {
                    controlBarrage(BarrageOperation.Clear.INSTANCE);
                    return;
                }
                return;
            case 906917140:
                if (action.equals("control_event_resume")) {
                    controlBarrage(BarrageOperation.Resume.INSTANCE);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onLayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case -860267087:
                if (action.equals(LayerEvent.ACTION_CLICK_REPLAY_BUTTON)) {
                    VulcanBarrageViewController.loadBarrageData$default(getBarrageController(), 0, 60, (VulcanBarrageInfo) null, 4, (Object) null);
                    return;
                }
                return;
            case -849541738:
                if (action.equals(LayerEvent.ACTION_BARRAGE_CLICK)) {
                    if (event.getBooleanExtra(11)) {
                        setBarrageSwitch(1);
                        VulcanBarrageUtilsKt.barrageUBC("switch_open", getBarrageController().getBarrageInfo());
                        VulcanBarrageUtilsKt.barrageUBC("show", getBarrageController().getBarrageInfo());
                        return;
                    }
                    setBarrageSwitch(0);
                    VulcanBarrageUtilsKt.barrageUBC("switch_close", getBarrageController().getBarrageInfo());
                    return;
                }
                return;
            case -664353452:
                if (action.equals(VulcanGestureEvent.ACTION_ADJUST_SEEK_COMPLETE)) {
                    loadBarrage();
                    return;
                }
                return;
            case -552621273:
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    configBarrage();
                    return;
                }
                return;
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    controlBarrage(new BarrageOperation.Switch(false));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPlayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case -1244137507:
                if (action.equals("player_event_seek_complete")) {
                    loadBarrage();
                    return;
                }
                return;
            case -882902390:
                if (action.equals("player_event_set_data")) {
                    getBarrageController().registerBarrageEvent();
                    getContentView().setVisibility(0);
                    controlBarrage(BarrageOperation.Stop.INSTANCE);
                    configBarrage();
                    return;
                }
                return;
            case 154871702:
                if (action.equals("player_event_on_complete")) {
                    controlBarrage(new BarrageOperation.Switch(false));
                    return;
                }
                return;
            case 1370689931:
                if (action.equals("player_event_on_info") && event.getIntExtra(1) == 904) {
                    controlBarrage(new BarrageOperation.Start(0));
                    VulcanBarrageViewController.loadBarrageData$default(getBarrageController(), 0, 60, (VulcanBarrageInfo) null, 4, (Object) null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setBarrageInfo(VulcanBarrageInfo barrageModel) {
        getBarrageController().setBarrageInfo(barrageModel);
        if (barrageModel != null) {
            VulcanBarrageInfo barrage = barrageModel;
            BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
            if (bindPlayer != null) {
                BaseVulcanVideoPlayer baseVulcanVideoPlayer = bindPlayer;
                boolean z = true;
                if (!(barrage.getTopicId().length() > 0)) {
                    if (!(barrage.getSourceType().length() > 0)) {
                        z = false;
                    }
                }
                if (!z) {
                    bindPlayer = null;
                }
                if (bindPlayer != null) {
                    VulcanBarrageViewController $this$setBarrageInfo_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = getBarrageController();
                    $this$setBarrageInfo_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.loadBarrageData(0, 60, barrage);
                    $this$setBarrageInfo_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.resetLastLoadBarrageInterval();
                    setBarrageSwitch($this$setBarrageInfo_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.getBarrageSwitch());
                }
            }
        }
    }

    public final void resetBarrageInfo() {
        getBarrageController().setBarrageInfo((VulcanBarrageInfo) null);
        getBarrageController().unRegisterEvent();
    }

    /* access modifiers changed from: protected */
    public void configBarrage() {
        if (isBarrageEnable()) {
            controlBarrage(new BarrageOperation.Switch(true));
        } else {
            controlBarrage(new BarrageOperation.Switch(false));
        }
    }

    private final void loadBarrage() {
        BaseVulcanVideoPlayer $this$loadBarrage_u24lambda_u2d5 = getBindPlayer();
        if ($this$loadBarrage_u24lambda_u2d5 != null) {
            BaseVulcanVideoPlayer baseVulcanVideoPlayer = $this$loadBarrage_u24lambda_u2d5;
            if (!(isBarrageEnable() && getBarrageController().validateBarrageInterval())) {
                $this$loadBarrage_u24lambda_u2d5 = null;
            }
            if ($this$loadBarrage_u24lambda_u2d5 != null) {
                int barrageStartTime = $this$loadBarrage_u24lambda_u2d5.getPosition();
                VulcanBarrageViewController.loadBarrageData$default(getBarrageController(), barrageStartTime, barrageStartTime + 60, (VulcanBarrageInfo) null, 4, (Object) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void controlBarrage(BarrageOperation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        getBarrageController().controlBarrage(operation);
    }

    public boolean isBarrageEnable() {
        BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
        return (bindPlayer != null && bindPlayer.isFullMode()) && getBarrageController().hasBarrage();
    }

    public void setDanmakuEditHint(String danmakuEditHint) {
        if (danmakuEditHint != null) {
            String str = danmakuEditHint;
            String hint = getBarrageController().hasBarrage() ? danmakuEditHint : null;
            if (hint != null) {
                VideoEvent event = LayerEvent.obtainEvent(LayerEvent.ACTION_SET_BARRAGE_HINT);
                Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(LayerEvent.ACTION_SET_BARRAGE_HINT)");
                event.putExtra(4, hint);
                sendEvent(event);
            }
        }
    }

    public void setHotDanmakuList(List<String> hotDanmakuList) {
        if (hotDanmakuList != null) {
            List<String> list = hotDanmakuList;
            List list2 = getBarrageController().hasBarrage() ? hotDanmakuList : null;
            if (list2 != null) {
                VideoEvent event = LayerEvent.obtainEvent(LayerEvent.ACTION_SET_BARRAGE_HOT_LIST);
                Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(LayerEvent.A…ION_SET_BARRAGE_HOT_LIST)");
                event.putExtra(5, list2);
                sendEvent(event);
            }
        }
    }

    public void addBarrage(BaseDanmaku danmaku) {
        if (danmaku != null) {
            controlBarrage(new BarrageOperation.Add(danmaku));
        }
    }

    public int getVideoDuration() {
        return 0;
    }

    public void onBarrageLoadComplete() {
        configBarrage();
    }

    public void disableBarrageSend(boolean disable, boolean force) {
        boolean forceDisable = disable;
        boolean z = true;
        if (disable) {
            controlBarrage(new BarrageOperation.Switch(false));
        } else if (isBarrageEnable()) {
            controlBarrage(new BarrageOperation.Switch(true));
        } else {
            forceDisable = true;
        }
        BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer == null || !bindPlayer.isFullMode()) {
            z = false;
        }
        if (z) {
            VideoEvent event = LayerEvent.obtainEvent(LayerEvent.ACTION_BARRAGE_DISABLE);
            Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(LayerEvent.ACTION_BARRAGE_DISABLE)");
            event.putExtra(12, Boolean.valueOf(forceDisable));
            event.putExtra(14, Boolean.valueOf(force));
            sendEvent(event);
        }
    }

    public DanmakuPlaceholderEditView getDanmakuPlaceholderEditView() {
        return null;
    }

    public void updateBarrageBtnVisibility() {
    }

    public void updateBarrageVisibility(boolean isOn) {
    }

    public int[] getSubscribeEvent() {
        return new int[]{2, 4, 3};
    }

    public BaseVulcanVideoPlayer getBindPlayer() {
        BDVideoPlayer bindPlayer = super.getBindPlayer();
        if (bindPlayer instanceof BaseVulcanVideoPlayer) {
            return (BaseVulcanVideoPlayer) bindPlayer;
        }
        return null;
    }

    public void onLayerRelease() {
        super.onLayerRelease();
        getBarrageController().release();
    }

    public final void setBarrageSwitch(int barrageSwitch) {
        VulcanBarrageViewController barrageController2 = getBarrageController();
        VulcanBarrageInfo barrageInfo = getBarrageController().getBarrageInfo();
        barrageController2.setBarrageSwitch(barrageInfo != null && !barrageInfo.getEnable() ? -1 : barrageSwitch);
        if (barrageSwitch != 1 || !isBarrageEnable()) {
            controlBarrage(new BarrageOperation.Switch(false));
        } else {
            controlBarrage(new BarrageOperation.Switch(true));
        }
    }

    /* access modifiers changed from: private */
    public final void sendBarragePraiseEvent(VulcanBarragePraise barragePraise) {
        if (barragePraise != null) {
            VulcanBarragePraise $this$sendBarragePraiseEvent_u24lambda_u2d11 = barragePraise;
            VideoEvent event = LayerEvent.obtainEvent(VulcanControlEvent.ACTION_VULCAN_BARRAGE_PRAISE);
            Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(VulcanContro…ON_VULCAN_BARRAGE_PRAISE)");
            event.putExtra(11, new VulcanBarragePraise($this$sendBarragePraiseEvent_u24lambda_u2d11.getTopicId(), $this$sendBarragePraiseEvent_u24lambda_u2d11.getReplyId(), false));
            sendEvent(event);
        }
    }

    /* access modifiers changed from: private */
    public final void onBarrageSendSuccess(String topicId) {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null) {
            playerCallbackManager.onBarrageSendSuccess(topicId);
        }
    }

    public int getBarrageStatsFrom() {
        return 0;
    }

    public int getBarrageStatsSubFrom() {
        return 0;
    }
}
