package com.baidu.searchbox.player.gesture.layer;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.event.VulcanGestureEvent;
import com.baidu.searchbox.player.gesture.VulcanGestureProcessor;
import com.baidu.searchbox.player.gesture.element.LoadingElement;
import com.baidu.searchbox.player.gesture.listener.VulcanGestureListener;
import com.baidu.searchbox.player.layer.ElementLayer;
import com.baidu.searchbox.player.layout.GestureLayoutManager;
import com.baidu.searchbox.player.utils.BdVolumeUtils;
import com.baidu.searchbox.player.utils.VibrateUtilKt;
import com.baidu.searchbox.player.utils.VulcanPlayerUtilKt;
import com.baidu.searchbox.player.utils.gesture.GestureDispatchType;
import com.baidu.searchbox.player.utils.gesture.GestureType;
import com.baidu.searchbox.player.utils.gesture.IVulcanGestureListener;
import com.baidu.searchbox.player.utils.gesture.InitGesture;
import com.baidu.searchbox.video.videoplayer.util.VideoPlayerBrightUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\u0017\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020$H\u0014¢\u0006\u0002\u0010'J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0002J\b\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\b\u00105\u001a\u00020\u0007H\u0016J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u0002H\u0014J\b\u00108\u001a\u000203H\u0016J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0016J\u0017\u0010<\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020$H\u0014¢\u0006\u0002\u0010'J\u0010\u0010=\u001a\u0002032\u0006\u0010#\u001a\u00020>H\u0016J\b\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u000203H\u0002J\b\u0010A\u001a\u000203H\u0016J\b\u0010B\u001a\u000203H\u0002J\b\u0010C\u001a\u000203H\u0002J\u0010\u0010D\u001a\u0002032\u0006\u0010#\u001a\u00020>H\u0016J\u001a\u0010E\u001a\u0002032\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010GH\u0016J\u0018\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u001cH\u0016J\u0018\u0010L\u001a\u0002032\u0006\u0010J\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u001cH\u0016J\u0012\u0010N\u001a\u0002032\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010#\u001a\u00020>H\u0016J\b\u0010R\u001a\u000203H\u0016J\u0010\u0010S\u001a\u0002032\u0006\u0010T\u001a\u00020;H\u0016J\u000e\u0010U\u001a\u0002032\u0006\u0010V\u001a\u00020WJ\u000e\u0010X\u001a\u0002032\u0006\u0010Y\u001a\u00020\u0007J\b\u0010Z\u001a\u000203H\u0014J\u000e\u0010[\u001a\u0002032\u0006\u0010\\\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/baidu/searchbox/player/gesture/layer/VulcanGestureLayer;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/player/element/AbsElement;", "Lcom/baidu/searchbox/player/utils/gesture/IVulcanGestureListener;", "()V", "dispatchTouchEventEnable", "", "getDispatchTouchEventEnable", "()Z", "setDispatchTouchEventEnable", "(Z)V", "gestureDetector", "Landroid/view/GestureDetector;", "gestureListener", "Lcom/baidu/searchbox/player/gesture/listener/VulcanGestureListener;", "getGestureListener", "()Lcom/baidu/searchbox/player/gesture/listener/VulcanGestureListener;", "setGestureListener", "(Lcom/baidu/searchbox/player/gesture/listener/VulcanGestureListener;)V", "gestureProcessor", "Lcom/baidu/searchbox/player/gesture/VulcanGestureProcessor;", "getGestureProcessor", "()Lcom/baidu/searchbox/player/gesture/VulcanGestureProcessor;", "setGestureProcessor", "(Lcom/baidu/searchbox/player/gesture/VulcanGestureProcessor;)V", "handleMultiPoint", "lastVolume", "", "Ljava/lang/Integer;", "layoutManager", "Lcom/baidu/searchbox/player/layout/GestureLayoutManager;", "loadingElement", "Lcom/baidu/searchbox/player/gesture/element/LoadingElement;", "allowHandleGesture", "event", "Landroid/view/MotionEvent;", "allowHandleLongPressEvent", "dispatchContainerTouchEvent", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "getBindActivity", "Landroid/app/Activity;", "getBindPlayer", "Lcom/baidu/searchbox/player/BaseVulcanVideoPlayer;", "getCurrentPosition", "getGestureDispatchType", "Lcom/baidu/searchbox/player/utils/gesture/GestureDispatchType;", "getPlayer", "handleGesture", "handleLongPress", "initContainer", "", "isNeedConsumeEvent", "isPlayerEnd", "layoutElement", "root", "onBrightComplete", "onBrightSlide", "seekPercent", "", "onContainerTouchEvent", "onControlEventNotify", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onGestureActionComplete", "onGestureActionStart", "onLayerRelease", "onMultiPointGestureComplete", "onMultiPointGestureStart", "onPlayerEventNotify", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "onSeek", "currentPos", "delta", "onSeekComplete", "seekDelta", "onSlideUp", "gesture", "Lcom/baidu/searchbox/player/utils/gesture/GestureType;", "onSystemEventNotify", "onVolumeComplete", "onVolumeSlide", "seekPos", "setLoadingStartDelayed", "delayMillis", "", "setNeedLoading", "isNeed", "setupElement", "startOrStopLoading", "isStart", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanGestureLayer.kt */
public class VulcanGestureLayer extends ElementLayer<FrameLayout, AbsElement> implements IVulcanGestureListener {
    private boolean dispatchTouchEventEnable;
    private GestureDetector gestureDetector;
    private VulcanGestureListener gestureListener;
    private VulcanGestureProcessor gestureProcessor;
    private boolean handleMultiPoint;
    private Integer lastVolume;
    private final GestureLayoutManager layoutManager = new GestureLayoutManager();
    private final LoadingElement loadingElement = new LoadingElement();

    /* access modifiers changed from: protected */
    public final VulcanGestureProcessor getGestureProcessor() {
        return this.gestureProcessor;
    }

    /* access modifiers changed from: protected */
    public final void setGestureProcessor(VulcanGestureProcessor vulcanGestureProcessor) {
        this.gestureProcessor = vulcanGestureProcessor;
    }

    /* access modifiers changed from: protected */
    public final VulcanGestureListener getGestureListener() {
        return this.gestureListener;
    }

    /* access modifiers changed from: protected */
    public final void setGestureListener(VulcanGestureListener vulcanGestureListener) {
        this.gestureListener = vulcanGestureListener;
    }

    public final boolean getDispatchTouchEventEnable() {
        return this.dispatchTouchEventEnable;
    }

    public final void setDispatchTouchEventEnable(boolean z) {
        this.dispatchTouchEventEnable = z;
    }

    /* access modifiers changed from: protected */
    public void initContainer() {
        VulcanGestureProcessor $this$initContainer_u24lambda_u2d0 = new VulcanGestureProcessor(this);
        $this$initContainer_u24lambda_u2d0.setGestureDispatchType(getGestureDispatchType());
        this.gestureProcessor = $this$initContainer_u24lambda_u2d0;
        this.gestureListener = new VulcanGestureListener(this, this.gestureProcessor);
        Context context = this.mContext;
        VulcanGestureListener vulcanGestureListener = this.gestureListener;
        Intrinsics.checkNotNull(vulcanGestureListener);
        this.gestureDetector = new GestureDetector(context, vulcanGestureListener);
        this.mContainer = new VulcanGestureLayer$initContainer$2(this, this.mContext);
        ((FrameLayout) this.mContainer).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void setupElement() {
        addElement(this.loadingElement);
    }

    /* access modifiers changed from: protected */
    public void layoutElement(FrameLayout root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.layoutManager.layout(root, this.loadingElement);
    }

    public void onControlEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case 906917140:
                if (action.equals("control_event_resume")) {
                    ((FrameLayout) getContentView()).setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        Intrinsics.checkNotNullParameter(status, "status");
        super.onPlayerStatusChanged(status, old);
        if (status == PlayerStatus.PREPARING || status == PlayerStatus.PLAYING) {
            ((FrameLayout) this.mContainer).setVisibility(0);
        }
    }

    public void onPlayerEventNotify(VideoEvent event) {
        VulcanGestureListener vulcanGestureListener;
        Intrinsics.checkNotNullParameter(event, "event");
        super.onPlayerEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -1759675333:
                if (action.equals("player_event_go_back_or_foreground")) {
                    VulcanGestureListener vulcanGestureListener2 = this.gestureListener;
                    boolean z = true;
                    if (vulcanGestureListener2 == null || !vulcanGestureListener2.isLongPressing()) {
                        z = false;
                    }
                    if (z && (vulcanGestureListener = this.gestureListener) != null) {
                        vulcanGestureListener.onLongPressComplete();
                        return;
                    }
                    return;
                }
                return;
            case 154871702:
                if (action.equals("player_event_on_complete")) {
                    ((FrameLayout) this.mContainer).setVisibility(4);
                    VulcanGestureProcessor vulcanGestureProcessor = this.gestureProcessor;
                    if (vulcanGestureProcessor != null) {
                        vulcanGestureProcessor.onGestureEnd();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onSystemEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onSystemEventNotify(event);
        if (Intrinsics.areEqual((Object) event.getAction(), (Object) "system_event_volume_changed")) {
            int volume = event.getIntExtra(4);
            Integer num = this.lastVolume;
            if ((num == null || volume != num.intValue()) && getBindPlayer().isForeground()) {
                Activity activity = getBindPlayer().getActivity();
                VibrateUtilKt.checkSlideVibrateIfNeed(activity, (volume * 100) / BdVolumeUtils.getMaxVolume(this.mContext), 0, 100);
                VibrateUtilKt.resetVibrateStatus();
            }
            this.lastVolume = Integer.valueOf(volume);
        }
    }

    public void onLayerRelease() {
        super.onLayerRelease();
        GestureDetector gestureDetector2 = this.gestureDetector;
        if (gestureDetector2 != null) {
            gestureDetector2.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) null);
        }
    }

    public BaseVulcanVideoPlayer getBindPlayer() {
        BDVideoPlayer bindPlayer = super.getBindPlayer();
        if (bindPlayer != null) {
            return (BaseVulcanVideoPlayer) bindPlayer;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.player.BaseVulcanVideoPlayer");
    }

    public BaseVulcanVideoPlayer getPlayer() {
        return getBindPlayer();
    }

    public void onSeek(int currentPos, int delta) {
        VideoEvent event = LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_ADJUST_SEEK_BEGIN);
        Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(VulcanGestur…ACTION_ADJUST_SEEK_BEGIN)");
        event.putExtra(2, Integer.valueOf(currentPos));
        event.putExtra(3, Integer.valueOf(delta));
        sendEvent(event);
        VibrateUtilKt.checkSlideVibrateIfNeed(getBindPlayer().getActivity(), currentPos + delta, 0, getBindPlayer().getDuration());
        getBindPlayer().getPlayerCallbackManager().onSeekGesture(currentPos, delta);
    }

    public void onSeekComplete(int currentPos, int seekDelta) {
        if (seekDelta != 0) {
            getBindPlayer().seekTo(currentPos + seekDelta);
        }
        if (getBindPlayer().isPause()) {
            getBindPlayer().resume();
        }
        sendEvent(LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_ADJUST_SEEK_COMPLETE));
        VibrateUtilKt.resetVibrateStatus();
        getBindPlayer().getPlayerCallbackManager().onSeekGestureComplete(currentPos, seekDelta);
    }

    public void onVolumeSlide(float seekPos) {
        float percent = seekPos / ((float) BdVolumeUtils.getMaxVolume(this.mContext));
        if (BdVolumeUtils.getVolume(this.mContext) == 0) {
            percent = 0.0f;
        }
        BdVolumeUtils.setVolume(BDPlayerConfig.getAppContext(), (int) seekPos);
        VideoEvent event = LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_ADJUST_VOLUME_BEGIN);
        Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(VulcanGestur…TION_ADJUST_VOLUME_BEGIN)");
        event.putExtra(20, Float.valueOf(percent));
        sendEvent(event);
    }

    public void onVolumeComplete() {
        sendEvent(LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_ADJUST_VOLUME_COMPLETE));
        getBindPlayer().getPlayerCallbackManager().onVolumeGesture();
    }

    public void onBrightSlide(float seekPercent) {
        VideoPlayerBrightUtilsKt.setActivityBrightness(getActivity(), seekPercent);
        VideoEvent event = LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_ADJUST_BRIGHT_BEGIN);
        Intrinsics.checkNotNullExpressionValue(event, "obtainEvent(VulcanGestur…TION_ADJUST_BRIGHT_BEGIN)");
        event.putExtra(2, Float.valueOf(seekPercent));
        sendEvent(event);
        VibrateUtilKt.checkSlideVibrateIfNeed(getBindPlayer().getActivity(), (int) (((float) 100) * seekPercent), 0, 100);
    }

    public void onBrightComplete() {
        sendEvent(LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_ADJUST_BRIGHT_COMPLETE));
        getBindPlayer().getPlayerCallbackManager().onBrightGesture();
        VibrateUtilKt.resetVibrateStatus();
    }

    public void onSlideUp(GestureType gesture) {
        if (Intrinsics.areEqual((Object) gesture, (Object) InitGesture.INSTANCE)) {
            getBindPlayer().getPlayerCallbackManager().onGestureActionStart();
            onGestureActionStart();
            return;
        }
        getBindPlayer().getPlayerCallbackManager().onGestureActionEnd();
        onGestureActionComplete();
    }

    public int getCurrentPosition() {
        return getBindPlayer().getPosition();
    }

    public boolean isPlayerEnd() {
        return getBindPlayer().isComplete();
    }

    public Activity getBindActivity() {
        return getActivity();
    }

    public boolean isNeedConsumeEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (handleMultiPoint(event)) {
            this.handleMultiPoint = true;
        }
        if (this.handleMultiPoint || handleLongPress(event) || handleGesture(event)) {
            return true;
        }
        return false;
    }

    private final boolean handleLongPress(MotionEvent event) {
        VulcanGestureListener vulcanGestureListener;
        VulcanGestureListener vulcanGestureListener2;
        VulcanGestureListener vulcanGestureListener3 = this.gestureListener;
        if (!(vulcanGestureListener3 != null && vulcanGestureListener3.isLongPressing())) {
            return false;
        }
        if ((event.getAction() == 1 || !getBindPlayer().isPlaying()) && (vulcanGestureListener2 = this.gestureListener) != null) {
            vulcanGestureListener2.onLongPressComplete();
        }
        if (event.getAction() == 2 && (vulcanGestureListener = this.gestureListener) != null) {
            vulcanGestureListener.handleMoveOnLongPressing(event);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r0 = r0.getContentView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean handleMultiPoint(android.view.MotionEvent r4) {
        /*
            r3 = this;
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r3.getBindPlayer()
            boolean r0 = r0.isOrientationLocked()
            r1 = 0
            if (r0 != 0) goto L_0x0039
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r3.getBindPlayer()
            boolean r0 = com.baidu.searchbox.player.utils.VulcanPlayerUtilKt.isFullStyle(r0)
            if (r0 == 0) goto L_0x0039
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r3.getBindPlayer()
            com.baidu.searchbox.player.layer.BaseKernelLayer r0 = r0.getPlayerKernelLayer()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            android.view.View r0 = r0.getContentView()
            if (r0 == 0) goto L_0x002e
            boolean r0 = r0.onTouchEvent(r4)
            if (r0 != r2) goto L_0x002e
            r0 = r2
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            if (r0 == 0) goto L_0x0039
            boolean r0 = r3.handleMultiPoint
            if (r0 != 0) goto L_0x0038
            r3.onMultiPointGestureStart()
        L_0x0038:
            return r2
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.gesture.layer.VulcanGestureLayer.handleMultiPoint(android.view.MotionEvent):boolean");
    }

    private final boolean handleGesture(MotionEvent event) {
        GestureDetector gestureDetector2 = this.gestureDetector;
        boolean z = false;
        if (gestureDetector2 != null && gestureDetector2.onTouchEvent(event)) {
            z = true;
        }
        if (z) {
            return true;
        }
        VulcanGestureProcessor vulcanGestureProcessor = this.gestureProcessor;
        if (vulcanGestureProcessor != null) {
            vulcanGestureProcessor.setContentViewWidth(((FrameLayout) this.mContainer).getWidth());
        }
        return allowHandleGesture(event);
    }

    public boolean allowHandleGesture(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!getBindPlayer().isOrientationLocked()) {
            if (!VulcanPlayerUtilKt.isFullStyle(getBindPlayer())) {
                return false;
            }
            VulcanGestureProcessor vulcanGestureProcessor = this.gestureProcessor;
            if (vulcanGestureProcessor != null ? vulcanGestureProcessor.onGestureEvent(event) : false) {
                return true;
            }
            return false;
        }
        return true;
    }

    private final void onGestureActionStart() {
        sendEvent(LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_GESTURE_ACTION_START));
    }

    private final void onGestureActionComplete() {
        sendEvent(LayerEvent.obtainEvent(VulcanGestureEvent.ACTION_GESTURE_ACTION_COMPLETE));
    }

    public boolean allowHandleLongPressEvent() {
        return !getBindPlayer().isOrientationLocked() && getBindPlayer().isFullMode();
    }

    public final void setNeedLoading(boolean isNeed) {
        this.loadingElement.setNeedLoading(isNeed);
    }

    public final void startOrStopLoading(boolean isStart) {
        this.loadingElement.startOrStopLoading(isStart);
    }

    public final void setLoadingStartDelayed(long delayMillis) {
        this.loadingElement.setLoadingStartDelayed(delayMillis);
    }

    /* access modifiers changed from: protected */
    public GestureDispatchType getGestureDispatchType() {
        return GestureDispatchType.GESTURE_THREE;
    }

    /* access modifiers changed from: protected */
    public Boolean dispatchContainerTouchEvent(MotionEvent event) {
        ViewParent parent;
        ViewParent parent2;
        ViewParent parent3;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.dispatchTouchEventEnable) {
            return null;
        }
        switch (event.getAction()) {
            case 0:
                FrameLayout frameLayout = (FrameLayout) this.mContainer;
                if (frameLayout == null || (parent = frameLayout.getParent()) == null) {
                    return null;
                }
                parent.requestDisallowInterceptTouchEvent(true);
                return null;
            case 2:
                if (isNeedConsumeEvent(event)) {
                    FrameLayout frameLayout2 = (FrameLayout) this.mContainer;
                    if (frameLayout2 == null || (parent3 = frameLayout2.getParent()) == null) {
                        return null;
                    }
                    parent3.requestDisallowInterceptTouchEvent(true);
                    return null;
                }
                FrameLayout frameLayout3 = (FrameLayout) this.mContainer;
                if (frameLayout3 == null || (parent2 = frameLayout3.getParent()) == null) {
                    return null;
                }
                parent2.requestDisallowInterceptTouchEvent(false);
                return null;
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public Boolean onContainerTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        switch (event.getAction()) {
            case 1:
            case 3:
                if (this.handleMultiPoint) {
                    onMultiPointGestureComplete();
                }
                this.handleMultiPoint = false;
                break;
        }
        if (isNeedConsumeEvent(event)) {
            return true;
        }
        return null;
    }

    private final void onMultiPointGestureStart() {
        onGestureActionComplete();
        VulcanGestureProcessor vulcanGestureProcessor = this.gestureProcessor;
        if (vulcanGestureProcessor != null) {
            vulcanGestureProcessor.onGestureEnd();
        }
    }

    private final void onMultiPointGestureComplete() {
    }
}
