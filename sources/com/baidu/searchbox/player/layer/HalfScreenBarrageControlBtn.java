package com.baidu.searchbox.player.layer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.baidu.searchbox.danmakulib.event.DanmakuSendEvent;
import com.baidu.searchbox.danmakulib.widget.DanmakuEditDialog;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.ShortVideoPlayer;
import com.baidu.searchbox.player.element.ControlLayerElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.ui.LottieAnimationBetterView;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.export.IVideoAbTestManager;
import com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper;
import com.baidu.searchbox.video.detail.export.IVideoPlayerSPUtils;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.constants.VideoPlayerConstants;
import com.baidu.searchbox.video.videoplayer.control.BarrageViewController;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0017J\b\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0002J\u0012\u0010(\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/player/layer/HalfScreenBarrageControlBtn;", "Lcom/baidu/searchbox/player/element/ControlLayerElement;", "Landroid/view/View$OnClickListener;", "()V", "closeJsonName", "", "closeLottieComposition", "Lcom/airbnb/lottie/LottieComposition;", "contentView", "Landroid/view/View;", "draft", "", "editView", "hotDanmakuList", "", "getHotDanmakuList", "()Ljava/util/List;", "setHotDanmakuList", "(Ljava/util/List;)V", "lottieView", "Lcom/baidu/searchbox/player/ui/LottieAnimationBetterView;", "openJsonName", "openLottieComposition", "closeToOpen", "", "isAnim", "", "doBarrageSwitch", "getContentView", "hide0rShowBarrage", "isVisible", "initElement", "isBarrageOpen", "onClick", "v", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onLayerRelease", "openEdieDialog", "openToClose", "togglePanelVisible", "isBubbleShow", "updateLottieView", "updateMarginTop", "updateViewStatus", "Companion", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HalfScreenBarrageControlBtn.kt */
public final class HalfScreenBarrageControlBtn extends ControlLayerElement implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String feedVideoChannelPage = "feedTab";
    public static final String fragmentTag = "DanmakuDialog";
    private final String closeJsonName = "barrage_switch_close.json";
    private LottieComposition closeLottieComposition;
    private View contentView;
    private CharSequence draft = "";
    private View editView;
    private List<String> hotDanmakuList;
    private LottieAnimationBetterView lottieView;
    private final String openJsonName = "barrage_switch_open.json";
    private LottieComposition openLottieComposition;

    public final List<String> getHotDanmakuList() {
        return this.hotDanmakuList;
    }

    public final void setHotDanmakuList(List<String> list) {
        this.hotDanmakuList = list;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/player/layer/HalfScreenBarrageControlBtn$Companion;", "", "()V", "feedVideoChannelPage", "", "fragmentTag", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HalfScreenBarrageControlBtn.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public View getContentView() {
        View view2 = this.contentView;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    public void initElement() {
        LottieAnimationBetterView lottieAnimationBetterView = null;
        View inflate = View.inflate(getContext(), R.layout.videoplayer_half_screen_barrage_control_layout, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…age_control_layout, null)");
        this.contentView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.lottieView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.lottieView)");
        this.lottieView = (LottieAnimationBetterView) findViewById;
        View view2 = this.contentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.editView);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.editView)");
        this.editView = findViewById2;
        LottieAnimationBetterView lottieAnimationBetterView2 = this.lottieView;
        if (lottieAnimationBetterView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationBetterView2 = null;
        }
        lottieAnimationBetterView2.setOnClickListener(this);
        LottieAnimationBetterView lottieAnimationBetterView3 = this.lottieView;
        if (lottieAnimationBetterView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationBetterView3 = null;
        }
        lottieAnimationBetterView3.setImageAssetsFolder("images");
        View view3 = this.editView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
            view3 = null;
        }
        view3.setOnClickListener(this);
        View view4 = this.contentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view4 = null;
        }
        view4.setVisibility(8);
        LottieCompositionFactory.fromAsset(getContext(), this.openJsonName).addListener(new HalfScreenBarrageControlBtn$$ExternalSyntheticLambda0(this));
        LottieCompositionFactory.fromAsset(getContext(), this.closeJsonName).addListener(new HalfScreenBarrageControlBtn$$ExternalSyntheticLambda1(this));
        LottieAnimationBetterView lottieAnimationBetterView4 = this.lottieView;
        if (lottieAnimationBetterView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
        } else {
            lottieAnimationBetterView = lottieAnimationBetterView4;
        }
        lottieAnimationBetterView.addAnimatorListener(new HalfScreenBarrageControlBtn$initElement$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initElement$lambda-0  reason: not valid java name */
    public static final void m2348initElement$lambda0(HalfScreenBarrageControlBtn this$0, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openLottieComposition = lottieComposition;
        this$0.updateLottieView();
    }

    /* access modifiers changed from: private */
    /* renamed from: initElement$lambda-1  reason: not valid java name */
    public static final void m2349initElement$lambda1(HalfScreenBarrageControlBtn this$0, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeLottieComposition = lottieComposition;
        this$0.updateLottieView();
    }

    /* access modifiers changed from: private */
    public final void updateLottieView() {
        if (isBarrageOpen()) {
            openToClose(false);
        } else {
            closeToOpen(false);
        }
    }

    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == R.id.lottieView) {
            LottieAnimationBetterView lottieAnimationBetterView = this.lottieView;
            View view2 = null;
            if (lottieAnimationBetterView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationBetterView = null;
            }
            if (!lottieAnimationBetterView.isAnimating()) {
                if (BarrageViewController.isBarrageOn()) {
                    openToClose$default(this, false, 1, (Object) null);
                } else {
                    closeToOpen$default(this, false, 1, (Object) null);
                }
                doBarrageSwitch();
                View view3 = this.editView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editView");
                } else {
                    view2 = view3;
                }
                view2.setEnabled(isBarrageOpen());
                IVideoPlayerSPUtils.Impl.get().putBoolean(VideoPlayerConstants.USER_CLICKED_BARRAGE_BTN, true);
            }
        } else if (id == R.id.editView) {
            openEdieDialog();
        }
    }

    private final void openEdieDialog() {
        ViewGroup attachedContainer = getVideoPlayer().getAttachedContainer();
        FragmentActivity fragmentActivity = null;
        Context context = attachedContainer != null ? attachedContainer.getContext() : null;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        }
        if (fragmentActivity != null) {
            FragmentActivity $this$openEdieDialog_u24lambda_u2d4 = fragmentActivity;
            if (!$this$openEdieDialog_u24lambda_u2d4.isFinishing()) {
                FragmentManager fragmentManager = $this$openEdieDialog_u24lambda_u2d4.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(fragmentManager, "supportFragmentManager");
                Fragment $this$openEdieDialog_u24lambda_u2d4_u24lambda_u2d2 = fragmentManager.findFragmentByTag(fragmentTag);
                if ($this$openEdieDialog_u24lambda_u2d4_u24lambda_u2d2 != null) {
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(ft, "fragmentManager.beginTransaction()");
                    ft.remove($this$openEdieDialog_u24lambda_u2d4_u24lambda_u2d2);
                    ft.commitAllowingStateLoss();
                }
                boolean z = true;
                DanmakuEditDialog editDialog = DanmakuEditDialog.newInstance(true);
                editDialog.setCloseListerner(new HalfScreenBarrageControlBtn$$ExternalSyntheticLambda2(this, editDialog, $this$openEdieDialog_u24lambda_u2d4));
                editDialog.setDraft(this.draft);
                editDialog.setHotDanmakuList(this.hotDanmakuList);
                editDialog.show(fragmentManager, fragmentTag);
                IVideoEventBusWrapper.Impl.get().post(new DanmakuSendEvent(0).setClazzOfInvoker($this$openEdieDialog_u24lambda_u2d4.getClass()));
                Collection collection = this.hotDanmakuList;
                if (collection == null || !(!collection.isEmpty())) {
                    z = false;
                }
                if (z) {
                    IVideoEventBusWrapper.Impl.get().post(new DanmakuSendEvent(3).setClazzOfInvoker($this$openEdieDialog_u24lambda_u2d4.getClass()));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: openEdieDialog$lambda-4$lambda-3  reason: not valid java name */
    public static final void m2350openEdieDialog$lambda4$lambda3(HalfScreenBarrageControlBtn this$0, DanmakuEditDialog $editDialog, FragmentActivity $this_run) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        this$0.draft = $editDialog.getDraft().toString();
        IVideoEventBusWrapper.Impl.get().post(new DanmakuSendEvent(2).setClazzOfInvoker($this_run.getClass()).setEditDialogPopupFlow($editDialog.getEditDialogPopupFlow()));
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [com.baidu.searchbox.player.BaseVideoPlayer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void doBarrageSwitch() {
        /*
            r3 = this;
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r3.getVideoPlayer()
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r0 = r0.getVideoSeries()
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getPage()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            java.lang.String r2 = "videoChannel"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0036
            com.baidu.searchbox.player.BaseVideoPlayer r0 = r3.getVideoPlayer()
            boolean r2 = r0 instanceof com.baidu.searchbox.player.ShortVideoPlayer
            if (r2 == 0) goto L_0x0025
            r1 = r0
            com.baidu.searchbox.player.ShortVideoPlayer r1 = (com.baidu.searchbox.player.ShortVideoPlayer) r1
        L_0x0025:
            if (r1 == 0) goto L_0x0036
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController r0 = r1.getBarrageController()
            if (r0 == 0) goto L_0x0036
            boolean r1 = r3.isBarrageOpen()
            r1 = r1 ^ 1
            r0.switchBarrage(r1)
        L_0x0036:
            com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper r0 = com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper.Impl.get()
            com.baidu.searchbox.video.videoplayer.event.DanmakuSwitchEvent r1 = new com.baidu.searchbox.video.videoplayer.event.DanmakuSwitchEvent
            boolean r2 = r3.isBarrageOpen()
            r2 = r2 ^ 1
            r1.<init>(r2)
            r0.post(r1)
            boolean r0 = r3.isBarrageOpen()
            r0 = r0 ^ 1
            com.baidu.searchbox.video.videoplayer.control.BarrageViewController.setBarrageOn(r0)
            com.baidu.searchbox.video.detail.export.IVideoPlayerSPUtils r0 = com.baidu.searchbox.video.detail.export.IVideoPlayerSPUtils.Impl.get()
            boolean r1 = r3.isBarrageOpen()
            r1 = r1 ^ 1
            java.lang.String r2 = "barrage_switch_key"
            r0.putBoolean(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.layer.HalfScreenBarrageControlBtn.doBarrageSwitch():void");
    }

    private final boolean isBarrageOpen() {
        return IVideoPlayerSPUtils.Impl.get().getBoolean("barrage_switch_key", true);
    }

    private final void updateViewStatus() {
        BarrageViewController barrageController;
        boolean barrageEnable = IVideoAbTestManager.Impl.get().getSwitch("barrage_video", true);
        BaseVideoPlayer videoPlayer = getVideoPlayer();
        View view2 = null;
        ShortVideoPlayer shortVideoPlayer = videoPlayer instanceof ShortVideoPlayer ? (ShortVideoPlayer) videoPlayer : null;
        boolean isSupportBarrage = (shortVideoPlayer == null || (barrageController = shortVideoPlayer.getBarrageController()) == null) ? false : barrageController.isSupportBarrage();
        BdVideoSeries videoSeries = getVideoPlayer().getVideoSeries();
        boolean isFeedVideoChannel = Intrinsics.areEqual((Object) feedVideoChannelPage, (Object) videoSeries != null ? videoSeries.getPage() : null);
        View view3 = this.contentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view3 = null;
        }
        view3.setVisibility((!barrageEnable || !isSupportBarrage || isFeedVideoChannel) ? 8 : 0);
        if (barrageEnable) {
            View view4 = this.editView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editView");
            } else {
                view2 = view4;
            }
            view2.setEnabled(isBarrageOpen());
            if (isBarrageOpen()) {
                openToClose(false);
            } else {
                closeToOpen(false);
            }
        }
    }

    private final void updateMarginTop() {
        String it;
        BdVideoSeries videoSeries = getVideoPlayer().getVideoSeries();
        if (videoSeries != null && (it = videoSeries.getPage()) != null && Intrinsics.areEqual((Object) "searchspeed_na", (Object) it)) {
            LottieAnimationBetterView lottieAnimationBetterView = this.lottieView;
            View view2 = null;
            if (lottieAnimationBetterView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationBetterView = null;
            }
            ViewGroup.LayoutParams layoutParams = lottieAnimationBetterView.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams lottieParams = (RelativeLayout.LayoutParams) layoutParams;
                lottieParams.topMargin = 0;
                lottieParams.addRule(15);
                LottieAnimationBetterView lottieAnimationBetterView2 = this.lottieView;
                if (lottieAnimationBetterView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                    lottieAnimationBetterView2 = null;
                }
                lottieAnimationBetterView2.setLayoutParams(lottieParams);
                View view3 = this.editView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editView");
                    view3 = null;
                }
                ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                if (layoutParams2 != null) {
                    RelativeLayout.LayoutParams editParams = (RelativeLayout.LayoutParams) layoutParams2;
                    editParams.topMargin = 0;
                    editParams.addRule(15);
                    View view4 = this.editView;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editView");
                    } else {
                        view2 = view4;
                    }
                    view2.setLayoutParams(editParams);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    private static final void togglePanelVisible$setVisible(HalfScreenBarrageControlBtn this$0, boolean isVisible) {
        View view2 = this$0.contentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        view2.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            this$0.updateViewStatus();
        }
        this$0.hide0rShowBarrage(isVisible);
    }

    public void togglePanelVisible(boolean isVisible, boolean isBubbleShow) {
        boolean z = false;
        if (getVideoPlayer().isFullMode()) {
            togglePanelVisible$setVisible(this, false);
            return;
        }
        if (isVisible && !isBubbleShow) {
            z = true;
        }
        togglePanelVisible$setVisible(this, z);
    }

    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        boolean z = true;
        switch (action.hashCode()) {
            case -1532215489:
                if (action.equals(LayerEvent.ACTION_SET_BARRAGE_HOT_LIST)) {
                    Object extra = event.getExtra(5);
                    if (!(extra instanceof List)) {
                        extra = null;
                    }
                    this.hotDanmakuList = (List) extra;
                    return;
                }
                return;
            case -552621273:
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    LayerContainer layerContainer = this.mParent.getLayerContainer();
                    if (layerContainer == null || !layerContainer.isShown()) {
                        z = false;
                    }
                    if (z) {
                        togglePanelVisible(false, false);
                        return;
                    }
                    return;
                }
                return;
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    LayerContainer layerContainer2 = this.mParent.getLayerContainer();
                    if (layerContainer2 != null && layerContainer2.isShown()) {
                        togglePanelVisible(true, false);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void hide0rShowBarrage(boolean isVisible) {
        BarrageViewController $this$hide0rShowBarrage_u24lambda_u2d6;
        BaseVideoPlayer videoPlayer = getVideoPlayer();
        String str = null;
        ShortVideoPlayer shortVideoPlayer = videoPlayer instanceof ShortVideoPlayer ? (ShortVideoPlayer) videoPlayer : null;
        if (shortVideoPlayer != null && ($this$hide0rShowBarrage_u24lambda_u2d6 = shortVideoPlayer.getBarrageController()) != null) {
            BdVideoSeries videoSeries = getVideoPlayer().getVideoSeries();
            if (videoSeries != null) {
                str = videoSeries.getPage();
            }
            if (Intrinsics.areEqual((Object) "videoChannel", (Object) str)) {
                $this$hide0rShowBarrage_u24lambda_u2d6.switchBarrage(!isVisible && isBarrageOpen());
            } else {
                $this$hide0rShowBarrage_u24lambda_u2d6.getDanmakuViewWrapper().setAlpha(isVisible ? 0.3f : 1.0f);
            }
        }
    }

    static /* synthetic */ void openToClose$default(HalfScreenBarrageControlBtn halfScreenBarrageControlBtn, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        halfScreenBarrageControlBtn.openToClose(z);
    }

    private final void openToClose(boolean isAnim) {
        if (this.closeLottieComposition != null) {
            View view2 = this.editView;
            LottieAnimationBetterView lottieAnimationBetterView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editView");
                view2 = null;
            }
            view2.setVisibility(0);
            LottieAnimationBetterView lottieAnimationBetterView2 = this.lottieView;
            if (lottieAnimationBetterView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationBetterView = lottieAnimationBetterView2;
            }
            LottieAnimationBetterView $this$openToClose_u24lambda_u2d7 = lottieAnimationBetterView;
            if (isAnim) {
                $this$openToClose_u24lambda_u2d7.setLoadSuccess(true);
                $this$openToClose_u24lambda_u2d7.playAnimation();
                return;
            }
            $this$openToClose_u24lambda_u2d7.cancelAnimation();
            LottieComposition lottieComposition = this.closeLottieComposition;
            Intrinsics.checkNotNull(lottieComposition);
            $this$openToClose_u24lambda_u2d7.setComposition(lottieComposition);
            $this$openToClose_u24lambda_u2d7.setProgress(0.0f);
        }
    }

    static /* synthetic */ void closeToOpen$default(HalfScreenBarrageControlBtn halfScreenBarrageControlBtn, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        halfScreenBarrageControlBtn.closeToOpen(z);
    }

    private final void closeToOpen(boolean isAnim) {
        if (this.openLottieComposition != null) {
            View view2 = this.editView;
            LottieAnimationBetterView lottieAnimationBetterView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editView");
                view2 = null;
            }
            view2.setVisibility(8);
            LottieAnimationBetterView lottieAnimationBetterView2 = this.lottieView;
            if (lottieAnimationBetterView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationBetterView = lottieAnimationBetterView2;
            }
            LottieAnimationBetterView $this$closeToOpen_u24lambda_u2d8 = lottieAnimationBetterView;
            if (isAnim) {
                $this$closeToOpen_u24lambda_u2d8.setLoadSuccess(true);
                $this$closeToOpen_u24lambda_u2d8.playAnimation();
                return;
            }
            $this$closeToOpen_u24lambda_u2d8.cancelAnimation();
            LottieComposition lottieComposition = this.openLottieComposition;
            Intrinsics.checkNotNull(lottieComposition);
            $this$closeToOpen_u24lambda_u2d8.setComposition(lottieComposition);
            $this$closeToOpen_u24lambda_u2d8.setProgress(0.0f);
        }
    }

    public void onLayerRelease() {
        LottieAnimationBetterView lottieAnimationBetterView = this.lottieView;
        if (lottieAnimationBetterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationBetterView = null;
        }
        lottieAnimationBetterView.cancelAnimation();
    }
}
