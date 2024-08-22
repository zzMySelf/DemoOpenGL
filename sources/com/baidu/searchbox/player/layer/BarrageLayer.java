package com.baidu.searchbox.player.layer;

import android.view.View;
import com.baidu.searchbox.danmakulib.danmaku.model.BaseDanmaku;
import com.baidu.searchbox.danmakulib.danmaku.model.DanmakuContext;
import com.baidu.searchbox.danmakulib.widget.DanmakuPlaceholderEditView;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.BarrageLayerController;
import com.baidu.searchbox.player.interfaces.IUpdateBarrageView;
import com.baidu.searchbox.player.utils.HalfScreenBarrageUtils;
import com.baidu.searchbox.player.utils.VideoPlayerSpUtil;
import com.baidu.searchbox.video.videoplayer.constants.VideoPlayerConstants;
import com.baidu.searchbox.video.videoplayer.control.BarrageViewController;
import java.util.HashMap;
import java.util.List;

public class BarrageLayer extends BasePlayerLayer implements IUpdateBarrageView {
    private static final int HALF_MAX_SCROLL_LINE = 2;
    private static final int MAX_SCROLL_LINE = 3;
    private boolean isPrepared;
    private BarrageLayerController mController;

    public BarrageLayer(BaseVideoPlayer player) {
        this.mController = new BarrageLayerController(this.mContext, player);
        if (!VideoPlayerSpUtil.getInstance().getBoolean(VideoPlayerConstants.USER_CLICKED_BARRAGE_BTN, false)) {
            BarrageViewController.saveBarrageSwitchToSp(VideoPlayerSpUtil.getInstance().getBoolean(VideoPlayerSpUtil.BARRAGE_DEFAULT_STATE_SWITCH, true));
        }
        BarrageLayerController.setBarrageOn(BarrageViewController.getBarrageSwitchFromSp());
    }

    public View getContentView() {
        return this.mController.getDanmakuViewWrapper();
    }

    public void onControlEventNotify(VideoEvent event) {
        if ("control_event_start".equals(event.getAction())) {
            this.mController.controlBarrage(BarrageViewController.BarrageOperation.CLEAR);
            VideoEvent videoEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_BARRAGE_VIEW);
            videoEvent.putExtra(15, this.mController.getDanmakuViewWrapper());
            sendEvent(videoEvent);
        } else if ("control_event_resume".equals(event.getAction())) {
            this.mController.controlBarrage(BarrageViewController.BarrageOperation.RESUME);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPlayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getAction()
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 0
            switch(r1) {
                case -1043170264: goto L_0x0045;
                case -971135626: goto L_0x003a;
                case -882902390: goto L_0x002f;
                case -525235558: goto L_0x0024;
                case 154871702: goto L_0x0019;
                case 1370689931: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0050
        L_0x000e:
            java.lang.String r1 = "player_event_on_info"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 5
            goto L_0x0051
        L_0x0019:
            java.lang.String r1 = "player_event_on_complete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 4
            goto L_0x0051
        L_0x0024:
            java.lang.String r1 = "player_event_on_prepared"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r3
            goto L_0x0051
        L_0x002f:
            java.lang.String r1 = "player_event_set_data"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = r2
            goto L_0x0051
        L_0x003a:
            java.lang.String r1 = "player_event_detach"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 3
            goto L_0x0051
        L_0x0045:
            java.lang.String r1 = "player_event_attach"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 2
            goto L_0x0051
        L_0x0050:
            r0 = -1
        L_0x0051:
            switch(r0) {
                case 0: goto L_0x00ae;
                case 1: goto L_0x00a1;
                case 2: goto L_0x0099;
                case 3: goto L_0x0091;
                case 4: goto L_0x0085;
                case 5: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x00b1
        L_0x0055:
            int r0 = r5.getIntExtra(r2)
            r1 = 904(0x388, float:1.267E-42)
            if (r0 != r1) goto L_0x00b1
            boolean r1 = r4.isPrepared
            if (r1 == 0) goto L_0x00b1
            r4.isPrepared = r3
            com.baidu.searchbox.player.helper.BarrageLayerController r1 = r4.mController
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController$BarrageOperation r2 = com.baidu.searchbox.video.videoplayer.control.BarrageViewController.BarrageOperation.RESUME
            r1.controlBarrage(r2)
            com.baidu.searchbox.player.helper.BarrageLayerController r1 = r4.mController
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController$BarrageOperation r2 = com.baidu.searchbox.video.videoplayer.control.BarrageViewController.BarrageOperation.START
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.controlBarrage(r2, r3)
            com.baidu.searchbox.bdeventbus.BdEventBus$Companion r1 = com.baidu.searchbox.bdeventbus.BdEventBus.Companion
            com.baidu.searchbox.bdeventbus.BdEventBus r1 = r1.getDefault()
            com.baidu.searchbox.danmakulib.event.DanmakuSendEvent r2 = new com.baidu.searchbox.danmakulib.event.DanmakuSendEvent
            r3 = 7
            r2.<init>(r3)
            r1.post(r2)
            goto L_0x00b1
        L_0x0085:
            com.baidu.searchbox.player.helper.BarrageLayerController r0 = r4.mController
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController$BarrageOperation r1 = com.baidu.searchbox.video.videoplayer.control.BarrageViewController.BarrageOperation.SWITCH
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            r0.controlBarrage(r1, r2)
            goto L_0x00b1
        L_0x0091:
            com.baidu.searchbox.player.helper.BarrageLayerController r0 = r4.mController
            if (r0 == 0) goto L_0x00b1
            r0.unRegisterEvent()
            goto L_0x00b1
        L_0x0099:
            com.baidu.searchbox.player.helper.BarrageLayerController r0 = r4.mController
            if (r0 == 0) goto L_0x00b1
            r0.registerEvent()
            goto L_0x00b1
        L_0x00a1:
            r4.isPrepared = r3
            com.baidu.searchbox.player.helper.BarrageLayerController r0 = r4.mController
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController$BarrageOperation r1 = com.baidu.searchbox.video.videoplayer.control.BarrageViewController.BarrageOperation.STOP
            r0.controlBarrage(r1)
            r4.configBarrage()
            goto L_0x00b1
        L_0x00ae:
            r4.isPrepared = r2
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.BarrageLayer.onPlayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getAction()
            int r1 = r0.hashCode()
            r2 = 0
            java.lang.String r3 = "layer_event_switch_full"
            switch(r1) {
                case -849541738: goto L_0x0021;
                case -552621273: goto L_0x0019;
                case -552580917: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x002b
        L_0x000f:
            java.lang.String r1 = "layer_event_switch_half"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = 2
            goto L_0x002c
        L_0x0019:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x002c
        L_0x0021:
            java.lang.String r1 = "layer_event_barrage_click"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = r2
            goto L_0x002c
        L_0x002b:
            r0 = -1
        L_0x002c:
            switch(r0) {
                case 0: goto L_0x007e;
                case 1: goto L_0x0030;
                case 2: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0090
        L_0x0030:
            java.lang.String r0 = r6.getAction()
            boolean r0 = r3.equals(r0)
            boolean r0 = r5.isBarrageEnable(r0)
            boolean r1 = com.baidu.searchbox.player.helper.BarrageLayerController.hasBarrage()
            if (r1 == 0) goto L_0x0072
            boolean r1 = com.baidu.searchbox.player.helper.BarrageLayerController.isBarrageOn()
            if (r1 == 0) goto L_0x0072
            com.baidu.searchbox.player.helper.BarrageLayerController r1 = r5.mController
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController$BarrageOperation r2 = com.baidu.searchbox.video.videoplayer.control.BarrageViewController.BarrageOperation.SWITCH
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            r1.controlBarrage(r2, r4)
            r5.changeMaxScrollLines()
            if (r0 == 0) goto L_0x0090
            java.lang.String r1 = r6.getAction()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0090
            com.baidu.searchbox.bdeventbus.BdEventBus$Companion r1 = com.baidu.searchbox.bdeventbus.BdEventBus.Companion
            com.baidu.searchbox.bdeventbus.BdEventBus r1 = r1.getDefault()
            com.baidu.searchbox.danmakulib.event.DanmakuSendEvent r2 = new com.baidu.searchbox.danmakulib.event.DanmakuSendEvent
            r3 = 7
            r2.<init>(r3)
            r1.post(r2)
            goto L_0x0090
        L_0x0072:
            com.baidu.searchbox.player.helper.BarrageLayerController r1 = r5.mController
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController$BarrageOperation r3 = com.baidu.searchbox.video.videoplayer.control.BarrageViewController.BarrageOperation.SWITCH
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.controlBarrage(r3, r2)
            goto L_0x0090
        L_0x007e:
            r0 = 11
            boolean r0 = r6.getBooleanExtra(r0)
            com.baidu.searchbox.player.helper.BarrageLayerController r1 = r5.mController
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController$BarrageOperation r2 = com.baidu.searchbox.video.videoplayer.control.BarrageViewController.BarrageOperation.SWITCH
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            r1.controlBarrage(r2, r3)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.BarrageLayer.onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public int[] getSubscribeEvent() {
        return new int[]{2, 4, 3};
    }

    public void disableBarrageSend(boolean disable, boolean force) {
        if (disable) {
            this.mController.controlBarrage(BarrageViewController.BarrageOperation.SWITCH, false);
        } else if (isBarrageEnable() && BarrageViewController.hasBarrage() && BarrageViewController.isBarrageOn()) {
            this.mController.controlBarrage(BarrageViewController.BarrageOperation.SWITCH, true);
        }
        VideoEvent event = LayerEvent.obtainEvent(LayerEvent.ACTION_BARRAGE_DISABLE);
        event.putExtra(12, Boolean.valueOf(disable));
        event.putExtra(13, this.mController);
        event.putExtra(14, Boolean.valueOf(force));
        sendEvent(event);
    }

    public void updateBarrageVisibility(boolean isOn) {
    }

    public void updateBarrageBtnVisibility() {
        this.mController.controlBarrage(BarrageViewController.BarrageOperation.SWITCH, Boolean.valueOf(BarrageViewController.getBarrageSwitchFromSp()));
    }

    public void setHotDanmakuList(List<String> hotDanmakuList) {
        if (BarrageLayerController.hasBarrage() && hotDanmakuList != null) {
            VideoEvent event = LayerEvent.obtainEvent(LayerEvent.ACTION_SET_BARRAGE_HOT_LIST);
            event.putExtra(5, hotDanmakuList);
            sendEvent(event);
        }
    }

    public void setDanmakuEditHint(String danmakuEditHint) {
        if (BarrageLayerController.hasBarrage()) {
            VideoEvent event = LayerEvent.obtainEvent(LayerEvent.ACTION_SET_BARRAGE_HINT);
            event.putExtra(4, danmakuEditHint);
            sendEvent(event);
        }
    }

    public DanmakuPlaceholderEditView getDanmakuPlaceholderEditView() {
        return null;
    }

    public void onBarrageLoadComplete() {
        configBarrage();
    }

    public void addBarrage(BaseDanmaku danmaku) {
        this.mController.controlBarrage(BarrageViewController.BarrageOperation.ADD, danmaku);
    }

    public int getVideoDuration() {
        return 0;
    }

    private void configBarrage() {
        if (!BarrageLayerController.hasBarrage() || !BarrageLayerController.isBarrageOn() || !isBarrageEnable()) {
            this.mController.controlBarrage(BarrageViewController.BarrageOperation.SWITCH, false);
            return;
        }
        this.mController.controlBarrage(BarrageViewController.BarrageOperation.SWITCH, true);
        changeMaxScrollLines();
    }

    private void changeMaxScrollLines() {
        HashMap<Integer, Integer> maxLinesPair = new HashMap<>();
        float scale = 1.0f;
        if (!getBindPlayer().isFullMode()) {
            maxLinesPair.put(1, 2);
            scale = 0.875f;
        } else {
            maxLinesPair.put(1, 3);
            this.mController.getDanmakuViewWrapper().setAlpha(1.0f);
        }
        DanmakuContext danmakuContext = this.mController.getDanmakuManager().getDanmakuConfig();
        if (danmakuContext != null) {
            danmakuContext.setMaximumLines(maxLinesPair).setScaleTextSize(scale);
        }
    }

    private boolean isBarrageEnable() {
        return isBarrageEnable(getBindPlayer().isFullMode());
    }

    /* access modifiers changed from: protected */
    public boolean isBarrageEnable(boolean isFullMode) {
        if (getBindPlayer().getVideoSeries() == null) {
            return false;
        }
        String page = getBindPlayer().getVideoSeries().getPage();
        if (isFullMode || HalfScreenBarrageUtils.isHalfScreenBarrageEnable(page)) {
            return true;
        }
        return false;
    }

    public BarrageViewController getBarrageViewController() {
        return this.mController;
    }

    public void onLayerRelease() {
        super.onLayerRelease();
        this.mController.unRegisterEvent();
        this.mController.detachDamakuManager();
    }

    public void onContainerDetach() {
        super.onContainerDetach();
        BarrageLayerController barrageLayerController = this.mController;
        if (barrageLayerController != null) {
            barrageLayerController.unRegisterEvent();
        }
    }
}
