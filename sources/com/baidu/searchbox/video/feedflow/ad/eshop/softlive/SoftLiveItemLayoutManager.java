package com.baidu.searchbox.video.feedflow.ad.eshop.softlive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.AbsLayoutManager;
import com.baidu.searchbox.feed.detail.arch.api.ILayoutManager;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.ad.AdComponentManifest;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.ad.live.NadLiveItemLayoutState;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.livelayout.ILiveItemLayoutService;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import com.baidu.searchbox.video.feedflow.utils.SummaryAnimator;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020)H\u0016J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0+J\b\u0010,\u001a\u00020 H\u0016J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020 H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0002J\b\u00108\u001a\u00020 H\u0002J\b\u00109\u001a\u00020 H\u0002J\b\u0010:\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020 H\u0002J\u0018\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020 2\u0006\u0010?\u001a\u00020@H\u0003J\b\u0010B\u001a\u00020CH\u0016J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020$0EH\u0002J\u0010\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020 H\u0007J\b\u0010J\u001a\u00020 H\u0002J\b\u0010K\u001a\u00020 H\u0002J\u0010\u0010L\u001a\u00020 2\u0006\u0010M\u001a\u00020CH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001d\u0010\u001a¨\u0006N"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/eshop/softlive/SoftLiveItemLayoutManager;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsLayoutManager;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "bannerContainer", "bottomContainer", "goodsBigBannerContainer", "liveEntranceContainer", "liveExtendTagContainer", "liveHighlight", "liveTagContainer", "pageContainer", "Landroid/widget/RelativeLayout;", "summaryAnim", "Lcom/baidu/searchbox/video/feedflow/utils/SummaryAnimator;", "getSummaryAnim", "()Lcom/baidu/searchbox/video/feedflow/utils/SummaryAnimator;", "summaryAnim$delegate", "Lkotlin/Lazy;", "summaryContainer", "summaryParentContainer", "weakAlphaHideAnim", "Landroid/view/animation/AlphaAnimation;", "getWeakAlphaHideAnim", "()Landroid/view/animation/AlphaAnimation;", "weakAlphaHideAnim$delegate", "weakAlphaShowAnim", "getWeakAlphaShowAnim", "weakAlphaShowAnim$delegate", "addView", "", "view", "Landroid/view/View;", "type", "", "clearWeakAlphaAnim", "root", "Landroid/view/ViewGroup;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getLiveRoomJumpHideElement", "", "inflate", "inflateBanner", "inflateError", "inflateGesture", "inflateGoodsBigBanner", "inflateLiveEntrance", "inflateLiveException", "inflateLiveExtendTag", "inflateLiveHighLight", "inflateLiveRoomExit", "inflateLiveTag", "inflateMask", "inflateOffline", "inflatePlayer", "inflatePoster", "inflateSummary", "initManager", "componentManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "context", "Landroid/content/Context;", "initPageContainerPortrait", "needBottomContainer", "", "notWeakView", "", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "onViewDestroy", "onViewDetach", "processHideBottomBar", "switchAlpha", "isScroll", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SoftLiveItemLayoutManager.kt */
public class SoftLiveItemLayoutManager extends AbsLayoutManager<FrameLayout> implements LifecycleOwner, LifecycleObserver {
    private FrameLayout bannerContainer;
    private FrameLayout bottomContainer;
    private FrameLayout goodsBigBannerContainer;
    private FrameLayout liveEntranceContainer;
    private FrameLayout liveExtendTagContainer;
    private FrameLayout liveHighlight;
    private FrameLayout liveTagContainer;
    private RelativeLayout pageContainer;
    private final Lazy summaryAnim$delegate = BdPlayerUtils.lazyNone(SoftLiveItemLayoutManager$summaryAnim$2.INSTANCE);
    private FrameLayout summaryContainer;
    private RelativeLayout summaryParentContainer;
    private final Lazy weakAlphaHideAnim$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SoftLiveItemLayoutManager$weakAlphaHideAnim$2(this));
    private final Lazy weakAlphaShowAnim$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SoftLiveItemLayoutManager$weakAlphaShowAnim$2(this));

    private final AlphaAnimation getWeakAlphaShowAnim() {
        return (AlphaAnimation) this.weakAlphaShowAnim$delegate.getValue();
    }

    private final AlphaAnimation getWeakAlphaHideAnim() {
        return (AlphaAnimation) this.weakAlphaHideAnim$delegate.getValue();
    }

    private final SummaryAnimator getSummaryAnim() {
        return (SummaryAnimator) this.summaryAnim$delegate.getValue();
    }

    public void initManager(ComponentArchManager componentManager, Context context) {
        NadLiveItemLayoutState $this$initManager_u24lambda_u2d8;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        Intrinsics.checkNotNullParameter(context, "context");
        super.initManager(componentManager, context);
        getLifecycle().addObserver(this);
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout $this$initManager_u24lambda_u2d0 = frameLayout;
        $this$initManager_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$initManager_u24lambda_u2d0.setFocusable(true);
        $this$initManager_u24lambda_u2d0.setFocusableInTouchMode(true);
        setContainer(frameLayout);
        initPageContainerPortrait(context);
        Store store = componentManager.getStore();
        if (!(store == null || (coreState = (CoreState) store.subscribe(CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new SoftLiveItemLayoutManager$$ExternalSyntheticLambda0(this));
        }
        if (!(store == null || ($this$initManager_u24lambda_u2d8 = (NadLiveItemLayoutState) store.subscribe(NadLiveItemLayoutState.class)) == null)) {
            $this$initManager_u24lambda_u2d8.getWeakAnimShow().observe(this, new SoftLiveItemLayoutManager$$ExternalSyntheticLambda1(this));
            $this$initManager_u24lambda_u2d8.getUpdateBottomBarLayout().observe(this, new SoftLiveItemLayoutManager$$ExternalSyntheticLambda2(this));
            $this$initManager_u24lambda_u2d8.getShowSummaryParentAnim().observe(this, new SoftLiveItemLayoutManager$$ExternalSyntheticLambda3(this));
        }
        if (AdReduxExpManager.INSTANCE.isLiveSeamlessJump()) {
            componentManager.registerServices(ILiveItemLayoutService.class, new SoftLiveItemLayoutServiceImpl(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initManager$lambda-2  reason: not valid java name */
    public static final void m5557initManager$lambda2(SoftLiveItemLayoutManager this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nestedAction != null) {
            this$0.onNestedAction(nestedAction);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initManager$lambda-8$lambda-3  reason: not valid java name */
    public static final void m5558initManager$lambda8$lambda3(SoftLiveItemLayoutManager this$0, Boolean isShow) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isShow, "isShow");
        this$0.switchAlpha(isShow.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: initManager$lambda-8$lambda-5  reason: not valid java name */
    public static final void m5559initManager$lambda8$lambda5(SoftLiveItemLayoutManager this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout it2 = this$0.bottomContainer;
        if (it2 != null) {
            VideoFlowUtilsKt.updateBottomBarHeightForFont(it2, this$0.getManager());
        }
        this$0.processHideBottomBar();
    }

    /* access modifiers changed from: private */
    /* renamed from: initManager$lambda-8$lambda-7  reason: not valid java name */
    public static final void m5560initManager$lambda8$lambda7(SoftLiveItemLayoutManager this$0, Boolean isShow) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout summaryContainer2 = this$0.summaryParentContainer;
        if (summaryContainer2 != null) {
            Intrinsics.checkNotNullExpressionValue(isShow, "isShow");
            this$0.getSummaryAnim().switchAlphaAnim(summaryContainer2, isShow.booleanValue());
        }
    }

    public void addView(View view2, int type) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (type == R.id.video_flow_cmp_live_entrance) {
            FrameLayout frameLayout = this.liveEntranceContainer;
            if (frameLayout != null) {
                frameLayout.addView(view2);
            }
        } else if (type == R.id.video_flow_cmp_live_tag) {
            FrameLayout frameLayout2 = this.liveTagContainer;
            if (frameLayout2 != null) {
                frameLayout2.addView(view2);
            }
        } else if (type == R.id.video_flow_cmp_live_extend_tag) {
            FrameLayout frameLayout3 = this.liveExtendTagContainer;
            if (frameLayout3 != null) {
                frameLayout3.addView(view2);
            }
        } else if (type == R.id.video_flow_cmp_summary) {
            FrameLayout frameLayout4 = this.summaryContainer;
            if (frameLayout4 != null) {
                frameLayout4.addView(view2);
            }
        } else if (type == R.id.video_flow_cmp_live_highlight) {
            FrameLayout frameLayout5 = this.liveHighlight;
            if (frameLayout5 != null) {
                frameLayout5.addView(view2);
            }
        } else if (type == R.id.video_flow_cmp_banner) {
            FrameLayout frameLayout6 = this.bannerContainer;
            if (frameLayout6 != null) {
                frameLayout6.addView(view2);
            }
        } else if (type == R.id.video_flow_cmp_goods_big_banner) {
            FrameLayout frameLayout7 = this.goodsBigBannerContainer;
            if (frameLayout7 != null) {
                frameLayout7.addView(view2);
            }
        } else {
            ((FrameLayout) getContainer()).addView(view2);
        }
    }

    public void inflate() {
        inflateGesture();
        inflatePoster();
        inflatePlayer();
        inflateError();
        inflateOffline();
        inflateLiveException();
        inflateMask();
        RelativeLayout it = this.pageContainer;
        if (it != null) {
            ILayoutManager.DefaultImpls.addView$default(this, it, 0, 2, (Object) null);
        }
        inflateLiveEntrance();
        inflateLiveHighLight();
        inflateLiveTag();
        inflateLiveExtendTag();
        inflateSummary();
        inflateBanner();
        inflateGoodsBigBanner();
        if (AdReduxExpManager.INSTANCE.isLiveSeamlessJump()) {
            inflateLiveRoomExit();
        }
    }

    private final void inflateGesture() {
        inflateComponentView(AdComponentManifest.FLOW_VIDEO_AD_GESTURE, com.baidu.searchbox.video.feedflow.ad.R.id.video_flow_ad_cmp_gesture);
    }

    private final void inflatePoster() {
        inflateComponentView("video_flow_cmp_poster", R.id.video_flow_cmp_poster);
    }

    private final void inflatePlayer() {
        inflateComponentView("flow_live_item_player_component", R.id.video_flow_cmp_live_player);
    }

    private final void inflateError() {
        inflateComponentView("video_flow_net_error", R.id.video_flow_cmp_net_error);
    }

    private final void inflateOffline() {
        inflateComponentView("flow_video_offline", R.id.video_flow_cmp_offline);
    }

    private final void inflateLiveException() {
        inflateComponentView("flow_live_item_exception_component", R.id.video_flow_cmp_live_exception);
    }

    private final void inflateMask() {
        inflateComponentView("video_flow_cmp_mask", R.id.video_flow_cmp_mask);
    }

    private final void inflateSummary() {
        inflateComponentView("video_flow_cmp_summary", R.id.video_flow_cmp_summary);
    }

    private final void inflateLiveTag() {
        inflateComponentView("flow_live_item_tag_component", R.id.video_flow_cmp_live_tag);
    }

    private final void inflateLiveExtendTag() {
        inflateComponentView("flow_live_item_extend_tag_component", R.id.video_flow_cmp_live_extend_tag);
    }

    private final void inflateLiveEntrance() {
        inflateComponentView("flow_live_item_entrance_component", R.id.video_flow_cmp_live_entrance);
    }

    private final void inflateLiveHighLight() {
        inflateComponentView("flow_live_item_highlight_component", R.id.video_flow_cmp_live_highlight);
    }

    private final void inflateBanner() {
        inflateComponentView("flow_video_single_line_banner", R.id.video_flow_cmp_banner);
    }

    private final void inflateGoodsBigBanner() {
        inflateComponentView("flow_video_goods_big_banner", R.id.video_flow_cmp_goods_big_banner);
    }

    private final void inflateLiveRoomExit() {
        inflateComponentView("flow_live_room_component", R.id.video_flow_cmp_live_exit);
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.widget.FrameLayout] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.view.ViewGroup$MarginLayoutParams] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initPageContainerPortrait(android.content.Context r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r8)
            int r1 = com.baidu.searchbox.video.feedflow.component.R.layout.video_flow_page_live_layout
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            if (r0 == 0) goto L_0x00e0
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r7.pageContainer = r0
            if (r0 == 0) goto L_0x001e
            int r1 = com.baidu.searchbox.video.feedflow.component.R.id.live_entrance_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x001f
        L_0x001e:
            r0 = r2
        L_0x001f:
            r7.liveEntranceContainer = r0
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x002f
            int r1 = com.baidu.searchbox.video.feedflow.component.R.id.live_tag_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x0030
        L_0x002f:
            r0 = r2
        L_0x0030:
            r7.liveTagContainer = r0
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x0040
            int r1 = com.baidu.searchbox.video.feedflow.component.R.id.live_extend_tag_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x0041
        L_0x0040:
            r0 = r2
        L_0x0041:
            r7.liveExtendTagContainer = r0
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x0050
            int r1 = com.baidu.searchbox.video.feedflow.ad.R.id.summary_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x0051
        L_0x0050:
            r0 = r2
        L_0x0051:
            r7.summaryContainer = r0
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x0060
            int r1 = com.baidu.searchbox.video.feedflow.ad.R.id.bottom_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x0061
        L_0x0060:
            r0 = r2
        L_0x0061:
            r7.bottomContainer = r0
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x0070
            int r1 = com.baidu.searchbox.video.feedflow.ad.R.id.banner_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x0071
        L_0x0070:
            r0 = r2
        L_0x0071:
            r7.bannerContainer = r0
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x0080
            int r1 = com.baidu.searchbox.video.feedflow.ad.R.id.goods_big_banner_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x0081
        L_0x0080:
            r0 = r2
        L_0x0081:
            r7.goodsBigBannerContainer = r0
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x0091
            int r1 = com.baidu.searchbox.video.feedflow.component.R.id.summary_parent_container
            android.view.View r0 = r0.findViewById(r1)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            goto L_0x0092
        L_0x0091:
            r0 = r2
        L_0x0092:
            r7.summaryParentContainer = r0
            android.widget.FrameLayout r0 = r7.bottomContainer
            if (r0 == 0) goto L_0x00a0
            r1 = 0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r3 = r7.getManager()
            com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.updateBottomBarHeightForFont(r0, r3)
        L_0x00a0:
            r7.processHideBottomBar()
            android.widget.RelativeLayout r0 = r7.pageContainer
            if (r0 == 0) goto L_0x00b1
            int r1 = com.baidu.searchbox.video.feedflow.component.R.id.live_highlight
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x00b2
        L_0x00b1:
            r0 = r2
        L_0x00b2:
            boolean r1 = r0 instanceof android.widget.FrameLayout
            if (r1 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r0 = r2
        L_0x00b8:
            if (r0 == 0) goto L_0x00dd
            r1 = r0
            r3 = 0
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            boolean r5 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r5 == 0) goto L_0x00c7
            r2 = r4
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
        L_0x00c7:
            if (r2 == 0) goto L_0x00db
            r4 = 0
            int r5 = r2.topMargin
            int r6 = com.baidu.searchbox.video.detail.utils.VideoImmersionUtils.getStatusBarHeight()
            int r5 = r5 + r6
            r2.topMargin = r5
            r5 = r2
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r1.setLayoutParams(r5)
        L_0x00db:
            r2 = r0
        L_0x00dd:
            r7.liveHighlight = r2
            return
        L_0x00e0:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.RelativeLayout"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.eshop.softlive.SoftLiveItemLayoutManager.initPageContainerPortrait(android.content.Context):void");
    }

    private final void processHideBottomBar() {
        if (!needBottomContainer()) {
            FrameLayout frameLayout = this.bottomContainer;
            RelativeLayout.LayoutParams layoutParams = null;
            ViewGroup.LayoutParams layoutParams2 = frameLayout != null ? frameLayout.getLayoutParams() : null;
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            }
            if (layoutParams != null) {
                RelativeLayout.LayoutParams it = layoutParams;
                it.height = 0;
                FrameLayout frameLayout2 = this.bottomContainer;
                if (frameLayout2 != null) {
                    frameLayout2.setLayoutParams(it);
                }
            }
            FrameLayout frameLayout3 = this.bottomContainer;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(4);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onViewDestroy() {
        RelativeLayout it = this.pageContainer;
        if (it != null) {
            clearWeakAlphaAnim(it);
        }
        getSummaryAnim().release();
    }

    private final void switchAlpha(boolean isScroll) {
        RelativeLayout it = this.pageContainer;
        if (it != null) {
            ShowAndHideAnimHelperKt.switchPortraitAlpha(it, isScroll, getWeakAlphaHideAnim(), getWeakAlphaShowAnim(), notWeakView());
        }
    }

    private final Set<Integer> notWeakView() {
        return SetsKt.emptySet();
    }

    private final void clearWeakAlphaAnim(ViewGroup root) {
        ShowAndHideAnimHelperKt.destroyPortraitAlphaAnimation(root, notWeakView());
        getWeakAlphaHideAnim().cancel();
        getWeakAlphaShowAnim().cancel();
    }

    private final void onNestedAction(NestedAction nestedAction) {
        if (nestedAction instanceof NestedAction.OnDetachFromScreen) {
            onViewDetach();
        }
    }

    private final void onViewDetach() {
        RelativeLayout it = this.summaryParentContainer;
        if (it != null) {
            getSummaryAnim().cancelAnim(it, new SoftLiveItemLayoutManager$onViewDetach$1$1(this));
        }
    }

    public Lifecycle getLifecycle() {
        return getManager().getLifecycle();
    }

    public boolean needBottomContainer() {
        return true;
    }

    public final List<View> getLiveRoomJumpHideElement() {
        RelativeLayout it = this.pageContainer;
        if (it == null) {
            return new ArrayList<>();
        }
        return CollectionsKt.mutableListOf(it);
    }
}
