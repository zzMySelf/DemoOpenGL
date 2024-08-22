package com.baidu.searchbox.player.guide.element;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.event.VulcanGestureEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.VulcanPlayerConfigExtKt;
import com.baidu.searchbox.player.widget.LightVolumeView;
import com.baidu.searchbox.player.widget.LightVolumeViewKt;
import com.baidu.searchbox.player.widget.LongPressSpeedMenuGuideView;
import com.baidu.searchbox.player.widget.ProgressBubbleView;
import com.baidu.searchbox.videoplayer.vulcan.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J\u0006\u0010&\u001a\u00020\"J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0014J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\bJ\b\u0010+\u001a\u00020\"H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0006\u0010-\u001a\u00020\"J\b\u0010.\u001a\u00020\u000eH\u0002J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0014H\u0002J\b\u00102\u001a\u00020\u0019H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8DX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148DX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001b¨\u00063"}, d2 = {"Lcom/baidu/searchbox/player/guide/element/FeedBackGuideTopTipElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "hideRunnable", "Ljava/lang/Runnable;", "getHideRunnable", "()Ljava/lang/Runnable;", "isHideProgressBubbleView", "", "isVolumeSlideInProgress", "()Z", "setVolumeSlideInProgress", "(Z)V", "lightAndVolumeContainerView", "Lcom/baidu/searchbox/player/widget/LightVolumeView;", "getLightAndVolumeContainerView", "()Lcom/baidu/searchbox/player/widget/LightVolumeView;", "lightAndVolumeContainerView$delegate", "Lkotlin/Lazy;", "progressBubbleView", "Lcom/baidu/searchbox/player/widget/ProgressBubbleView;", "getProgressBubbleView", "()Lcom/baidu/searchbox/player/widget/ProgressBubbleView;", "progressBubbleView$delegate", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "rootView$delegate", "getContentView", "Landroid/view/View;", "getVideoPlayer", "Lcom/baidu/searchbox/player/BaseVulcanVideoPlayer;", "handProgressData", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "handleVolumeChanged", "hideGuideViews", "hideOtherGuideView", "currentGuideView", "hideProgressBubbleView", "hide", "initElement", "onEventNotify", "setFontAndPictureSize", "setupLightVolumeView", "setupLongPressMenuTipView", "Lcom/baidu/searchbox/player/widget/LongPressSpeedMenuGuideView;", "setupProgressBubbleView", "setupRootView", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBackGuideTopTipElement.kt */
public class FeedBackGuideTopTipElement extends AbsElement {
    private final Runnable hideRunnable = new FeedBackGuideTopTipElement$$ExternalSyntheticLambda0(this);
    private boolean isHideProgressBubbleView;
    private boolean isVolumeSlideInProgress;
    private final Lazy lightAndVolumeContainerView$delegate = BdPlayerUtils.lazyNone(new FeedBackGuideTopTipElement$lightAndVolumeContainerView$2(this));
    private final Lazy progressBubbleView$delegate = BdPlayerUtils.lazyNone(new FeedBackGuideTopTipElement$progressBubbleView$2(this));
    private final Lazy rootView$delegate = BdPlayerUtils.lazyNone(new FeedBackGuideTopTipElement$rootView$2(this));

    private final ViewGroup getRootView() {
        return (ViewGroup) this.rootView$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final LightVolumeView getLightAndVolumeContainerView() {
        return (LightVolumeView) this.lightAndVolumeContainerView$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final ProgressBubbleView getProgressBubbleView() {
        return (ProgressBubbleView) this.progressBubbleView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: hideRunnable$lambda-0  reason: not valid java name */
    public static final void m2324hideRunnable$lambda0(FeedBackGuideTopTipElement this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideOtherGuideView((View) null);
    }

    /* access modifiers changed from: protected */
    public final Runnable getHideRunnable() {
        return this.hideRunnable;
    }

    /* access modifiers changed from: protected */
    public final boolean isVolumeSlideInProgress() {
        return this.isVolumeSlideInProgress;
    }

    /* access modifiers changed from: protected */
    public final void setVolumeSlideInProgress(boolean z) {
        this.isVolumeSlideInProgress = z;
    }

    public void initElement() {
    }

    /* access modifiers changed from: private */
    public final ViewGroup setupRootView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout $this$setupRootView_u24lambda_u2d1 = frameLayout;
        $this$setupRootView_u24lambda_u2d1.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams = $this$setupRootView_u24lambda_u2d1.getLayoutParams();
        if (layoutParams != null) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
            return frameLayout;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    private final LongPressSpeedMenuGuideView setupLongPressMenuTipView() {
        LongPressSpeedMenuGuideView longPressSpeedMenuGuideView = new LongPressSpeedMenuGuideView(getContext());
        LongPressSpeedMenuGuideView $this$setupLongPressMenuTipView_u24lambda_u2d3 = longPressSpeedMenuGuideView;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 1;
        $this$setupLongPressMenuTipView_u24lambda_u2d3.setLayoutParams(params);
        if (VulcanPlayerConfigExtKt.isLongPressSpeedMenuEnable(getVideoPlayer().getConfig())) {
            getRootView().addView($this$setupLongPressMenuTipView_u24lambda_u2d3);
        }
        return longPressSpeedMenuGuideView;
    }

    /* access modifiers changed from: private */
    public final LightVolumeView setupLightVolumeView() {
        LightVolumeView lightVolumeView = new LightVolumeView(getContext());
        LightVolumeView $this$setupLightVolumeView_u24lambda_u2d4 = lightVolumeView;
        $this$setupLightVolumeView_u24lambda_u2d4.setLayoutParams(new FrameLayout.LayoutParams($this$setupLightVolumeView_u24lambda_u2d4.getResources().getDimensionPixelSize(R.dimen.videoplayer_vulcan_dp_174), $this$setupLightVolumeView_u24lambda_u2d4.getResources().getDimensionPixelSize(R.dimen.videoplayer_vulcan_dp_35)));
        ViewGroup.LayoutParams layoutParams = $this$setupLightVolumeView_u24lambda_u2d4.getLayoutParams();
        if (layoutParams != null) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
            getRootView().addView($this$setupLightVolumeView_u24lambda_u2d4);
            return lightVolumeView;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* access modifiers changed from: private */
    public final ProgressBubbleView setupProgressBubbleView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProgressBubbleView $this$setupProgressBubbleView_u24lambda_u2d5 = new ProgressBubbleView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$setupProgressBubbleView_u24lambda_u2d5.setLayoutParams(new FrameLayout.LayoutParams(-2, $this$setupProgressBubbleView_u24lambda_u2d5.getResources().getDimensionPixelSize(R.dimen.videoplayer_vulcan_dp_35)));
        getRootView().addView($this$setupProgressBubbleView_u24lambda_u2d5);
        return $this$setupProgressBubbleView_u24lambda_u2d5;
    }

    public View getContentView() {
        return getRootView();
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -1934328898:
                if (action.equals(VulcanGestureEvent.ACTION_GESTURE_ACTION_COMPLETE)) {
                    hideOtherGuideView((View) null);
                    return;
                }
                return;
            case -1926822256:
                if (action.equals(VulcanGestureEvent.ACTION_ADJUST_VOLUME_BEGIN)) {
                    this.isVolumeSlideInProgress = true;
                    getLightAndVolumeContainerView().show(event.getFloatExtra(20), LightVolumeViewKt.VOLUME_LOTTIE_FILE);
                    hideOtherGuideView(getLightAndVolumeContainerView());
                    return;
                }
                return;
            case -1812691470:
                if (action.equals(VulcanGestureEvent.ACTION_ADJUST_VOLUME_COMPLETE)) {
                    this.isVolumeSlideInProgress = false;
                    hideGuideViews();
                    return;
                }
                return;
            case -1709568003:
                if (action.equals(VulcanGestureEvent.ACTION_GESTURE_ACTION_START)) {
                    hideGuideViews();
                    return;
                }
                return;
            case -1638530599:
                if (action.equals(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED) && event.getBooleanExtra(9)) {
                    hideGuideViews();
                    return;
                }
                return;
            case -881760656:
                if (action.equals(VulcanGestureEvent.ACTION_ADJUST_BRIGHT_BEGIN)) {
                    getLightAndVolumeContainerView().show(event.getFloatExtra(2), LightVolumeViewKt.BRIGHT_UP_LOTTIE_FILE_PAG);
                    hideOtherGuideView(getLightAndVolumeContainerView());
                    return;
                }
                return;
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    hideOtherGuideView((View) null);
                    return;
                }
                return;
            case 723636846:
                if (action.equals(VulcanGestureEvent.ACTION_ADJUST_SEEK_BEGIN) && !this.isHideProgressBubbleView) {
                    handProgressData(event);
                    return;
                }
                return;
            case 1147160494:
                if (action.equals(LayerEvent.ACTION_UPDATE_FONT_SIZE)) {
                    setFontAndPictureSize();
                    return;
                }
                return;
            case 1822725860:
                if (action.equals("system_event_volume_changed")) {
                    handleVolumeChanged(event);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setFontAndPictureSize() {
        getLightAndVolumeContainerView().setFontAndPictureSize();
        getProgressBubbleView().setFontAndPictureSize();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: com.baidu.searchbox.player.layer.AbsLayer} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013d, code lost:
        r1 = (android.widget.FrameLayout) r3.getContentView();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleVolumeChanged(com.baidu.searchbox.player.event.VideoEvent r12) {
        /*
            r11 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r11.getVideoPlayer()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.player.control.layer.VulcanControlSlotLayer> r2 = com.baidu.searchbox.player.control.layer.VulcanControlSlotLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r3 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r3)
            r3 = 0
            if (r2 == 0) goto L_0x0029
            com.baidu.searchbox.player.slot.Control r2 = com.baidu.searchbox.player.slot.Control.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r3 = r2
        L_0x0023:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x0029:
            java.lang.Class<com.baidu.searchbox.player.gesture.layer.VulcanGestureLayer> r2 = com.baidu.searchbox.player.gesture.layer.VulcanGestureLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r4 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x0047
            com.baidu.searchbox.player.slot.Gesture r2 = com.baidu.searchbox.player.slot.Gesture.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r3 = r2
        L_0x0041:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x0047:
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r2 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r4 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x0065
            com.baidu.searchbox.player.slot.Menu r2 = com.baidu.searchbox.player.slot.Menu.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r3 = r2
        L_0x005f:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x0065:
            java.lang.Class<com.baidu.searchbox.player.distribute.layer.VulcanDistributeLayer> r2 = com.baidu.searchbox.player.distribute.layer.VulcanDistributeLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r4 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x0083
            com.baidu.searchbox.player.slot.Distribute r2 = com.baidu.searchbox.player.slot.Distribute.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r3 = r2
        L_0x007d:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x0083:
            java.lang.Class<com.baidu.searchbox.player.guide.layer.VulcanBeginnerGuideLayer> r2 = com.baidu.searchbox.player.guide.layer.VulcanBeginnerGuideLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r4 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x00a1
            com.baidu.searchbox.player.slot.BeginnerGuide r2 = com.baidu.searchbox.player.slot.BeginnerGuide.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r3 = r2
        L_0x009b:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x00a1:
            java.lang.Class<com.baidu.searchbox.player.guide.layer.VulcanFeedBackGuideLayer> r2 = com.baidu.searchbox.player.guide.layer.VulcanFeedBackGuideLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r4 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x00bf
            com.baidu.searchbox.player.slot.FeedBackGuide r2 = com.baidu.searchbox.player.slot.FeedBackGuide.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r3 = r2
        L_0x00b9:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x00bf:
            java.lang.Class<com.baidu.searchbox.player.barrage.VulcanBarrageLayer> r2 = com.baidu.searchbox.player.barrage.VulcanBarrageLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r4 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x00dc
            com.baidu.searchbox.player.slot.Barrage r2 = com.baidu.searchbox.player.slot.Barrage.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r3 = r2
        L_0x00d7:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x00dc:
            java.lang.Class<com.baidu.searchbox.player.airplay.VulcanAirPlayLayer> r2 = com.baidu.searchbox.player.airplay.VulcanAirPlayLayer.class
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r4 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x00f9
            com.baidu.searchbox.player.slot.AirPlay r2 = com.baidu.searchbox.player.slot.AirPlay.INSTANCE
            com.baidu.searchbox.player.slot.ISlot r2 = (com.baidu.searchbox.player.slot.ISlot) r2
            com.baidu.searchbox.player.layer.ElementLayer r2 = r0.getVulcanLayer(r2)
            boolean r4 = r2 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r4 != 0) goto L_0x00f3
            goto L_0x00f4
        L_0x00f3:
            r3 = r2
        L_0x00f4:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x00f9:
            com.baidu.searchbox.player.layer.LayerContainer r2 = r0.getLayerContainer()
            java.util.ArrayList r2 = r2.getLayerList()
            if (r2 == 0) goto L_0x0137
            java.lang.String r4 = "layerList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r4 = 0
            java.util.Iterator r5 = r2.iterator()
        L_0x010f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0136
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.baidu.searchbox.player.layer.AbsLayer r7 = (com.baidu.searchbox.player.layer.AbsLayer) r7
            r8 = 0
            java.lang.Class r9 = r7.getClass()
            java.lang.Class<com.baidu.searchbox.player.menu.layer.VulcanMenuLayer> r10 = com.baidu.searchbox.player.menu.layer.VulcanMenuLayer.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0134
            boolean r5 = r7 instanceof com.baidu.searchbox.player.menu.layer.VulcanMenuLayer
            if (r5 != 0) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            r3 = r7
        L_0x012f:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            com.baidu.searchbox.player.layer.AbsLayer r3 = (com.baidu.searchbox.player.layer.AbsLayer) r3
            goto L_0x0138
        L_0x0134:
            goto L_0x010f
        L_0x0136:
        L_0x0137:
        L_0x0138:
            com.baidu.searchbox.player.menu.layer.VulcanMenuLayer r3 = (com.baidu.searchbox.player.menu.layer.VulcanMenuLayer) r3
            r0 = 0
            if (r3 == 0) goto L_0x014a
            android.view.ViewGroup r1 = r3.getContentView()
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            if (r1 == 0) goto L_0x014a
            boolean r1 = r1.isShown()
            goto L_0x014b
        L_0x014a:
            r1 = r0
        L_0x014b:
            boolean r2 = r11.isVolumeSlideInProgress
            if (r2 != 0) goto L_0x01bf
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r2 = r11.getVideoPlayer()
            boolean r2 = r2.isFullMode()
            if (r2 == 0) goto L_0x01bf
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r2 = r11.getVideoPlayer()
            boolean r2 = r2.isForeground()
            if (r2 == 0) goto L_0x01bf
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r2 = r11.getVideoPlayer()
            android.app.Activity r2 = r2.getActivity()
            r3 = 1
            if (r2 == 0) goto L_0x0175
            boolean r2 = r2.hasWindowFocus()
            if (r2 != r3) goto L_0x0175
            r0 = r3
        L_0x0175:
            if (r0 == 0) goto L_0x01bf
            if (r1 == 0) goto L_0x017a
            goto L_0x01bf
        L_0x017a:
            android.content.Context r0 = r11.getContext()
            int r0 = com.baidu.searchbox.player.utils.BdVolumeUtils.getMaxVolume(r0)
            android.content.Context r2 = r11.getContext()
            int r2 = com.baidu.searchbox.player.utils.BdVolumeUtils.getVolume(r2)
            float r3 = (float) r2
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 * r4
            float r4 = (float) r0
            float r3 = r3 / r4
            com.baidu.searchbox.player.widget.LightVolumeView r4 = r11.getLightAndVolumeContainerView()
            java.lang.String r5 = "assets://pag/videoplayer_vulcan_volume_up.pag"
            r4.show(r3, r5)
            com.baidu.searchbox.player.widget.LightVolumeView r4 = r11.getLightAndVolumeContainerView()
            android.view.View r4 = (android.view.View) r4
            r11.hideOtherGuideView(r4)
            com.baidu.searchbox.player.layer.ElementLayer r4 = r11.getParent()
            android.os.Handler r4 = r4.getHandlerInnerLayer()
            java.lang.Runnable r5 = r11.hideRunnable
            r4.removeCallbacks(r5)
            com.baidu.searchbox.player.layer.ElementLayer r4 = r11.getParent()
            android.os.Handler r4 = r4.getHandlerInnerLayer()
            java.lang.Runnable r5 = r11.hideRunnable
            r6 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r6)
            return
        L_0x01bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.guide.element.FeedBackGuideTopTipElement.handleVolumeChanged(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    /* access modifiers changed from: protected */
    public void handProgressData(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        getProgressBubbleView().show(event.getIntExtra(2) + event.getIntExtra(3), getVideoPlayer().getDuration());
        hideOtherGuideView(getProgressBubbleView());
    }

    /* access modifiers changed from: protected */
    public void hideOtherGuideView(View currentGuideView) {
        if (!Intrinsics.areEqual((Object) currentGuideView, (Object) getLightAndVolumeContainerView())) {
            getLightAndVolumeContainerView().hide();
        }
        if (!Intrinsics.areEqual((Object) currentGuideView, (Object) getProgressBubbleView())) {
            getProgressBubbleView().hide();
        }
    }

    public final void hideGuideViews() {
        getLightAndVolumeContainerView().hide();
        getProgressBubbleView().hide();
        getParent().getHandlerInnerLayer().removeCallbacks(this.hideRunnable);
    }

    public BaseVulcanVideoPlayer getVideoPlayer() {
        BDVideoPlayer videoPlayer = super.getVideoPlayer();
        if (videoPlayer != null) {
            return (BaseVulcanVideoPlayer) videoPlayer;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.player.BaseVulcanVideoPlayer");
    }

    public final void hideProgressBubbleView(boolean hide) {
        this.isHideProgressBubbleView = hide;
    }
}
