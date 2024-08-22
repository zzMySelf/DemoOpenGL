package com.baidu.searchbox.video.feedflow.detail.graphicgenre;

import android.content.Context;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.AbsLayoutManager;
import com.baidu.searchbox.feed.detail.arch.api.ILayoutManager;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.VideoNotchUtils;
import com.baidu.searchbox.video.detail.utils.VideoImmersionUtils;
import com.baidu.searchbox.video.feedflow.common.PanelSizeConfig;
import com.baidu.searchbox.video.feedflow.common.config.BottomInteractAreaConfigHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.VideoItemLayoutState;
import com.baidu.searchbox.video.feedflow.detail.graphicgenre.GraphicGenreItemLayoutManager$videoUpListener$2;
import com.baidu.searchbox.video.feedflow.detail.graphicgenre.pic.service.IGraphicPicService;
import com.baidu.searchbox.video.feedflow.detail.moveup.IPanelMoveUpService;
import com.baidu.searchbox.video.feedflow.detail.moveup.MoveUpAnimationPluginKt;
import com.baidu.searchbox.video.feedflow.detail.moveup.PlayerCompressUpdateConfig;
import com.baidu.searchbox.video.feedflow.detail.moveup.PlayerMoveUpInfo;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.service.IFeedFlowLayoutService;
import com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.ITopEntranceService;
import com.baidu.searchbox.video.feedflow.tab.ITabComponentService;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import com.baidu.searchbox.video.service.PageContainerService;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\"\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u0002002\u0006\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u000207H\u0016J\u0006\u00108\u001a\u00020\u000fJ\r\u00109\u001a\u0004\u0018\u000103¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u000203J\u0006\u0010<\u001a\u000203J\b\u0010=\u001a\u000200H\u0016J\b\u0010>\u001a\u000200H\u0002J\b\u0010?\u001a\u000200H\u0002J\b\u0010@\u001a\u000200H\u0002J\b\u0010A\u001a\u000200H\u0002J\b\u0010B\u001a\u000200H\u0002J\b\u0010C\u001a\u000200H\u0002J\b\u0010D\u001a\u000200H\u0002J\b\u0010E\u001a\u000200H\u0002J\b\u0010F\u001a\u000200H\u0002J\b\u0010G\u001a\u000200H\u0002J\b\u0010H\u001a\u000200H\u0002J\b\u0010I\u001a\u000200H\u0002J\b\u0010J\u001a\u000200H\u0002J\b\u0010K\u001a\u000200H\u0002J\b\u0010L\u001a\u000200H\u0002J\u0018\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0003J\u0006\u0010S\u001a\u00020TJ\b\u0010U\u001a\u000200H\u0002J\b\u0010V\u001a\u000200H\u0007J\b\u0010W\u001a\u000200H\u0007J\u0010\u0010X\u001a\u0002002\u0006\u0010Y\u001a\u00020TH\u0002J\u0010\u0010Z\u001a\u0002002\u0006\u0010[\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b-\u0010*¨\u0006\\"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/GraphicGenreItemLayoutManager;", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsLayoutManager;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "authorContainer", "bgmTitleContainer", "bottomContainer", "favorBottomToastContainer", "graphicView", "Landroid/view/View;", "notchHeight", "", "pageContainerPortrait", "Landroid/widget/RelativeLayout;", "playerMoveUpInfo", "Lcom/baidu/searchbox/video/feedflow/detail/moveup/PlayerMoveUpInfo;", "progressBarContainer", "readMoreContainer", "rightAuthorContainer", "rightCommentContainer", "rightContainer", "Landroid/widget/LinearLayout;", "rightFavorContainer", "rightPraiseContainer", "rightShareContainer", "splitContainer", "summaryContainer", "summaryParentContainer", "titleContainer", "topContainer", "Landroid/view/ViewGroup;", "videoUpListener", "com/baidu/searchbox/video/feedflow/detail/graphicgenre/GraphicGenreItemLayoutManager$videoUpListener$2$1", "getVideoUpListener", "()Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/GraphicGenreItemLayoutManager$videoUpListener$2$1;", "videoUpListener$delegate", "Lkotlin/Lazy;", "weakAlphaHideAnim", "Landroid/view/animation/AlphaAnimation;", "getWeakAlphaHideAnim", "()Landroid/view/animation/AlphaAnimation;", "weakAlphaHideAnim$delegate", "weakAlphaShowAnim", "getWeakAlphaShowAnim", "weakAlphaShowAnim$delegate", "addView", "", "view", "type", "", "clearWeakAlphaAnim", "root", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getPageContainerPortrait", "getPortraitAvailablePanelHeight", "()Ljava/lang/Integer;", "getRightContainerWidth", "getTitleContainerMaxHeight", "inflate", "inflateAuthor", "inflateBgmTitle", "inflateCarouselProgressBar", "inflateDefaultComboPraise", "inflateError", "inflateFavorBottomToast", "inflateMask", "inflateOffline", "inflatePic", "inflatePlayBtn", "inflateReadMore", "inflateRight", "inflateSplitLine", "inflateSummary", "inflateTitle", "initManager", "componentManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "context", "Landroid/content/Context;", "initPageContainerPortrait", "isRightContainerVisible", "", "onTransitionToTopStart", "onViewDestroy", "onViewResume", "switchAlpha", "isScroll", "updatePercentTransitionToTop", "percent", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicGenreItemLayoutManager.kt */
public final class GraphicGenreItemLayoutManager extends AbsLayoutManager<FrameLayout> implements LifecycleOwner, LifecycleObserver {
    private FrameLayout authorContainer;
    private FrameLayout bgmTitleContainer;
    private FrameLayout bottomContainer;
    private FrameLayout favorBottomToastContainer;
    private View graphicView;
    private float notchHeight;
    private RelativeLayout pageContainerPortrait;
    private PlayerMoveUpInfo playerMoveUpInfo;
    private FrameLayout progressBarContainer;
    private FrameLayout readMoreContainer;
    private FrameLayout rightAuthorContainer;
    private FrameLayout rightCommentContainer;
    private LinearLayout rightContainer;
    private FrameLayout rightFavorContainer;
    private FrameLayout rightPraiseContainer;
    private FrameLayout rightShareContainer;
    private FrameLayout splitContainer;
    private FrameLayout summaryContainer;
    private LinearLayout summaryParentContainer;
    private FrameLayout titleContainer;
    private ViewGroup topContainer;
    private final Lazy videoUpListener$delegate = BdPlayerUtils.lazyNone(new GraphicGenreItemLayoutManager$videoUpListener$2(this));
    private final Lazy weakAlphaHideAnim$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new GraphicGenreItemLayoutManager$weakAlphaHideAnim$2(this));
    private final Lazy weakAlphaShowAnim$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new GraphicGenreItemLayoutManager$weakAlphaShowAnim$2(this));

    private final AlphaAnimation getWeakAlphaShowAnim() {
        return (AlphaAnimation) this.weakAlphaShowAnim$delegate.getValue();
    }

    private final AlphaAnimation getWeakAlphaHideAnim() {
        return (AlphaAnimation) this.weakAlphaHideAnim$delegate.getValue();
    }

    private final GraphicGenreItemLayoutManager$videoUpListener$2.AnonymousClass1 getVideoUpListener() {
        return (GraphicGenreItemLayoutManager$videoUpListener$2.AnonymousClass1) this.videoUpListener$delegate.getValue();
    }

    public void initManager(ComponentArchManager componentManager, Context context) {
        VideoItemLayoutState $this$initManager_u24lambda_u2d3;
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
        this.notchHeight = (float) VideoNotchUtils.getNotchHeight(context);
        Store store = componentManager.getStore();
        if (!(store == null || ($this$initManager_u24lambda_u2d3 = (VideoItemLayoutState) store.subscribe(VideoItemLayoutState.class)) == null)) {
            $this$initManager_u24lambda_u2d3.getWeakAnimShow().observe(this, new GraphicGenreItemLayoutManager$$ExternalSyntheticLambda0(this));
            $this$initManager_u24lambda_u2d3.getUpdateBottomBarLayout().observe(this, new GraphicGenreItemLayoutManager$$ExternalSyntheticLambda1(this));
        }
        getManager().registerServices(PageContainerService.class, new GraphicGenreItemPageContainerServiceImpl(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initManager$lambda-3$lambda-1  reason: not valid java name */
    public static final void m11422initManager$lambda3$lambda1(GraphicGenreItemLayoutManager this$0, Boolean isShow) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isShow, "isShow");
        this$0.switchAlpha(isShow.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: initManager$lambda-3$lambda-2  reason: not valid java name */
    public static final void m11423initManager$lambda3$lambda2(GraphicGenreItemLayoutManager this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.bottomContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
            frameLayout = null;
        }
        VideoFlowUtilsKt.updateBottomBarHeightForFont(frameLayout, this$0.getManager());
    }

    private final void initPageContainerPortrait(Context context) {
        RelativeLayout relativeLayout = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_flow_page_graphic_genre_layout, (ViewGroup) null);
        if (inflate != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) inflate;
            this.pageContainerPortrait = relativeLayout2;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout2 = null;
            }
            View findViewById = relativeLayout2.findViewById(com.baidu.searchbox.video.feedflow.R.id.top_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "pageContainerPortrait.fi…wById(R.id.top_container)");
            ViewGroup viewGroup = (ViewGroup) findViewById;
            this.topContainer = viewGroup;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                viewGroup = null;
            }
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams $this$initPageContainerPortrait_u24lambda_u2d4 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if ($this$initPageContainerPortrait_u24lambda_u2d4 != null) {
                $this$initPageContainerPortrait_u24lambda_u2d4.topMargin += VideoImmersionUtils.getStatusBarHeight();
            }
            RelativeLayout relativeLayout3 = this.pageContainerPortrait;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout3 = null;
            }
            View findViewById2 = relativeLayout3.findViewById(R.id.summary_parent_container);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "pageContainerPortrait.fi…summary_parent_container)");
            this.summaryParentContainer = (LinearLayout) findViewById2;
            RelativeLayout relativeLayout4 = this.pageContainerPortrait;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout4 = null;
            }
            View findViewById3 = relativeLayout4.findViewById(R.id.author_container);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "pageContainerPortrait.fi…entR.id.author_container)");
            this.authorContainer = (FrameLayout) findViewById3;
            RelativeLayout relativeLayout5 = this.pageContainerPortrait;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout5 = null;
            }
            View findViewById4 = relativeLayout5.findViewById(R.id.summary_container);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "pageContainerPortrait.fi…ntR.id.summary_container)");
            this.summaryContainer = (FrameLayout) findViewById4;
            RelativeLayout relativeLayout6 = this.pageContainerPortrait;
            if (relativeLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout6 = null;
            }
            View findViewById5 = relativeLayout6.findViewById(R.id.top_title_container);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "pageContainerPortrait.fi…R.id.top_title_container)");
            this.titleContainer = (FrameLayout) findViewById5;
            RelativeLayout relativeLayout7 = this.pageContainerPortrait;
            if (relativeLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout7 = null;
            }
            View findViewById6 = relativeLayout7.findViewById(com.baidu.searchbox.video.feedflow.R.id.bottom_container);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "pageContainerPortrait.fi…Id(R.id.bottom_container)");
            FrameLayout frameLayout = (FrameLayout) findViewById6;
            this.bottomContainer = frameLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
                frameLayout = null;
            }
            VideoFlowUtilsKt.updateBottomBarHeightForFont(frameLayout, getManager());
            RelativeLayout relativeLayout8 = this.pageContainerPortrait;
            if (relativeLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout8 = null;
            }
            View findViewById7 = relativeLayout8.findViewById(R.id.right_container);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "pageContainerPortrait.fi…nentR.id.right_container)");
            this.rightContainer = (LinearLayout) findViewById7;
            Store store = getManager().getStore();
            boolean z = true;
            if (store == null || !BottomInteractAreaConfigHelperKt.isBottomInteractAreaStyle(store)) {
                z = false;
            }
            if (z) {
                LinearLayout linearLayout = this.rightContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightContainer");
                    linearLayout = null;
                }
                linearLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout9 = this.pageContainerPortrait;
            if (relativeLayout9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout9 = null;
            }
            View findViewById8 = relativeLayout9.findViewById(R.id.right_author_container);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "pageContainerPortrait.fi…d.right_author_container)");
            this.rightAuthorContainer = (FrameLayout) findViewById8;
            RelativeLayout relativeLayout10 = this.pageContainerPortrait;
            if (relativeLayout10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout10 = null;
            }
            View findViewById9 = relativeLayout10.findViewById(R.id.right_praise_container);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "pageContainerPortrait.fi…d.right_praise_container)");
            this.rightPraiseContainer = (FrameLayout) findViewById9;
            RelativeLayout relativeLayout11 = this.pageContainerPortrait;
            if (relativeLayout11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout11 = null;
            }
            View findViewById10 = relativeLayout11.findViewById(R.id.right_comment_container);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "pageContainerPortrait.fi….right_comment_container)");
            this.rightCommentContainer = (FrameLayout) findViewById10;
            RelativeLayout relativeLayout12 = this.pageContainerPortrait;
            if (relativeLayout12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout12 = null;
            }
            View findViewById11 = relativeLayout12.findViewById(R.id.right_favor_container);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "pageContainerPortrait.fi…id.right_favor_container)");
            this.rightFavorContainer = (FrameLayout) findViewById11;
            RelativeLayout relativeLayout13 = this.pageContainerPortrait;
            if (relativeLayout13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout13 = null;
            }
            View findViewById12 = relativeLayout13.findViewById(R.id.right_share_container);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "pageContainerPortrait.fi…id.right_share_container)");
            this.rightShareContainer = (FrameLayout) findViewById12;
            RelativeLayout relativeLayout14 = this.pageContainerPortrait;
            if (relativeLayout14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout14 = null;
            }
            View findViewById13 = relativeLayout14.findViewById(R.id.bgm_title_container);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "pageContainerPortrait.fi…R.id.bgm_title_container)");
            this.bgmTitleContainer = (FrameLayout) findViewById13;
            RelativeLayout relativeLayout15 = this.pageContainerPortrait;
            if (relativeLayout15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout15 = null;
            }
            View findViewById14 = relativeLayout15.findViewById(R.id.progress_bar_container);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "pageContainerPortrait.fi…d.progress_bar_container)");
            this.progressBarContainer = (FrameLayout) findViewById14;
            RelativeLayout relativeLayout16 = this.pageContainerPortrait;
            if (relativeLayout16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout16 = null;
            }
            View findViewById15 = relativeLayout16.findViewById(R.id.favor_bottom_toast_container);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "pageContainerPortrait.fi…r_bottom_toast_container)");
            this.favorBottomToastContainer = (FrameLayout) findViewById15;
            RelativeLayout relativeLayout17 = this.pageContainerPortrait;
            if (relativeLayout17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout17 = null;
            }
            View findViewById16 = relativeLayout17.findViewById(R.id.split_line_container);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "pageContainerPortrait.fi….id.split_line_container)");
            this.splitContainer = (FrameLayout) findViewById16;
            RelativeLayout relativeLayout18 = this.pageContainerPortrait;
            if (relativeLayout18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            } else {
                relativeLayout = relativeLayout18;
            }
            View findViewById17 = relativeLayout.findViewById(R.id.read_more_container);
            Intrinsics.checkNotNullExpressionValue(findViewById17, "pageContainerPortrait.fi…R.id.read_more_container)");
            this.readMoreContainer = (FrameLayout) findViewById17;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public void addView(View view2, int type) {
        Intrinsics.checkNotNullParameter(view2, "view");
        FrameLayout frameLayout = null;
        if (type == R.id.video_flow_cmp_author) {
            FrameLayout frameLayout2 = this.rightAuthorContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightAuthorContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_like) {
            FrameLayout frameLayout3 = this.rightPraiseContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightPraiseContainer");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_comment) {
            FrameLayout frameLayout4 = this.rightCommentContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightCommentContainer");
            } else {
                frameLayout = frameLayout4;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_favor) {
            FrameLayout frameLayout5 = this.rightFavorContainer;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightFavorContainer");
            } else {
                frameLayout = frameLayout5;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_share) {
            FrameLayout frameLayout6 = this.rightShareContainer;
            if (frameLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightShareContainer");
            } else {
                frameLayout = frameLayout6;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_top_title) {
            FrameLayout frameLayout7 = this.titleContainer;
            if (frameLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            } else {
                frameLayout = frameLayout7;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_author_info) {
            FrameLayout frameLayout8 = this.authorContainer;
            if (frameLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorContainer");
            } else {
                frameLayout = frameLayout8;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_summary) {
            FrameLayout frameLayout9 = this.summaryContainer;
            if (frameLayout9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryContainer");
            } else {
                frameLayout = frameLayout9;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_dynamic_carousel_progress_bar) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            FrameLayout frameLayout10 = this.progressBarContainer;
            if (frameLayout10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBarContainer");
            } else {
                frameLayout = frameLayout10;
            }
            frameLayout.addView(view2, layoutParams);
        } else if (type == R.id.video_flow_cmp_bgm_title) {
            FrameLayout frameLayout11 = this.bgmTitleContainer;
            if (frameLayout11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgmTitleContainer");
            } else {
                frameLayout = frameLayout11;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_favor_bottom_toast_cmp) {
            FrameLayout frameLayout12 = this.favorBottomToastContainer;
            if (frameLayout12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favorBottomToastContainer");
            } else {
                frameLayout = frameLayout12;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_graphic_genre_pic) {
            ViewGroup.MarginLayoutParams layoutParams2 = new ViewGroup.MarginLayoutParams(-1, -1);
            this.graphicView = view2;
            ((FrameLayout) getContainer()).addView(view2, layoutParams2);
        } else if (type == R.id.video_flow_cmp_play_btn) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            ((FrameLayout) getContainer()).addView(view2, layoutParams3);
        } else if (type == R.id.video_flow_cmp_graphic_genre_split_line) {
            FrameLayout frameLayout13 = this.splitContainer;
            if (frameLayout13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splitContainer");
            } else {
                frameLayout = frameLayout13;
            }
            frameLayout.addView(view2);
        } else if (type == R.id.video_flow_cmp_graphic_genre_read_more) {
            FrameLayout frameLayout14 = this.readMoreContainer;
            if (frameLayout14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("readMoreContainer");
            } else {
                frameLayout = frameLayout14;
            }
            frameLayout.addView(view2);
        } else {
            ((FrameLayout) getContainer()).addView(view2);
        }
    }

    public void inflate() {
        inflatePic();
        inflateDefaultComboPraise();
        inflateError();
        inflateOffline();
        inflateMask();
        ILayoutManager iLayoutManager = this;
        RelativeLayout relativeLayout = this.pageContainerPortrait;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            relativeLayout = null;
        }
        ILayoutManager.DefaultImpls.addView$default(iLayoutManager, relativeLayout, 0, 2, (Object) null);
        inflateSplitLine();
        inflateTitle();
        inflateAuthor();
        inflateReadMore();
        inflateSummary();
        inflateRight();
        inflateBgmTitle();
        inflateFavorBottomToast();
        inflateCarouselProgressBar();
        inflatePlayBtn();
    }

    private final void inflateSplitLine() {
        inflateComponentView("flow_graphic_genre_item_split_line_component", R.id.video_flow_cmp_graphic_genre_split_line);
    }

    private final void inflateReadMore() {
        inflateComponentView("flow_graphic_genre_item_read_more_component", R.id.video_flow_cmp_graphic_genre_read_more);
    }

    private final void inflatePlayBtn() {
        inflateComponentView("flow_video_play_btn_component", R.id.video_flow_cmp_play_btn);
    }

    private final void inflateBgmTitle() {
        inflateComponentView("flow_video_dynamic_bgm_title", R.id.video_flow_cmp_bgm_title);
    }

    private final void inflatePic() {
        inflateComponentView("flow_graphic_genre_item_pic_component", R.id.video_flow_cmp_graphic_genre_pic);
    }

    private final void inflateDefaultComboPraise() {
        inflateComponentView("flow_video_default_combo_praise", R.id.video_flow_cmp_default_combo_praise);
    }

    private final void inflateError() {
        inflateComponentView("video_flow_net_error", R.id.video_flow_cmp_net_error);
    }

    private final void inflateOffline() {
        inflateComponentView("flow_video_offline", R.id.video_flow_cmp_offline);
    }

    private final void inflateMask() {
        inflateComponentView("video_flow_cmp_mask", R.id.video_flow_cmp_mask);
    }

    private final void inflateTitle() {
        inflateComponentView("video_flow_cmp_top_title", R.id.video_flow_cmp_top_title);
    }

    private final void inflateAuthor() {
        inflateComponentView("video_flow_cmp_author_info", R.id.video_flow_cmp_author_info);
    }

    private final void inflateSummary() {
        inflateComponentView("video_flow_cmp_summary", R.id.video_flow_cmp_summary);
    }

    private final void inflateFavorBottomToast() {
        inflateComponentView("flow_video_favor_bottom_toast_component", R.id.video_flow_favor_bottom_toast_cmp);
    }

    private final void inflateCarouselProgressBar() {
        inflateComponentView("flow_dynamic_item_carousel_progress_bar_component", R.id.video_flow_cmp_dynamic_carousel_progress_bar);
    }

    private final void inflateRight() {
        inflateComponentView("video_flow_cmp_author", R.id.video_flow_cmp_author);
        inflateComponentView("video_flow_cmp_like", R.id.video_flow_cmp_like);
        inflateComponentView("video_flow_cmp_comment", R.id.video_flow_cmp_comment);
        inflateComponentView("video_flow_cmp_favor", R.id.video_flow_cmp_favor);
        inflateComponentView("video_flow_cmp_share", R.id.video_flow_cmp_share);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onViewResume() {
        IPanelMoveUpService iPanelMoveUpService = (IPanelMoveUpService) getManager().getService(IPanelMoveUpService.class);
        if (iPanelMoveUpService != null) {
            iPanelMoveUpService.addMoveUplListener(getVideoUpListener());
        }
    }

    /* access modifiers changed from: private */
    public final void onTransitionToTopStart() {
        RectF safeContentPercentRectF = VideoFlowUtilsKt.getVideoPropertyContentRect(getManager());
        PlayerCompressUpdateConfig playerCompressUpdateConfig = DIFactory.INSTANCE.getConfig().getPlayerCompressUpdateConfig();
        boolean sandwichVideoSwitch = playerCompressUpdateConfig != null ? playerCompressUpdateConfig.getSandwichVideoSwitch() : false;
        PlayerCompressUpdateConfig playerCompressUpdateConfig2 = DIFactory.INSTANCE.getConfig().getPlayerCompressUpdateConfig();
        RelativeLayout relativeLayout = null;
        Pair<Integer, Integer> miniWHSize = playerCompressUpdateConfig2 != null ? playerCompressUpdateConfig2.getMiniWHSize() : null;
        Context context = ((FrameLayout) getContainer()).getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        IGraphicPicService iGraphicPicService = (IGraphicPicService) getManager().getService(IGraphicPicService.class);
        View graphicPicImageRegion = iGraphicPicService != null ? iGraphicPicService.getGraphicPicImageRegion() : null;
        RelativeLayout relativeLayout2 = this.pageContainerPortrait;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            relativeLayout2 = null;
        }
        Integer valueOf = Integer.valueOf(relativeLayout2.getWidth());
        RelativeLayout relativeLayout3 = this.pageContainerPortrait;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
        } else {
            relativeLayout = relativeLayout3;
        }
        this.playerMoveUpInfo = MoveUpAnimationPluginKt.generatePlayerMoveUpResult$default(safeContentPercentRectF, sandwichVideoSwitch, miniWHSize, context, graphicPicImageRegion, new Pair(valueOf, Integer.valueOf(relativeLayout.getHeight())), 0, 0, VideoFlowUtilsKt.getVideoSizeConfigRatio(getManager()), 128, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updatePercentTransitionToTop(float percent) {
        PlayerMoveUpInfo moveUpInfo = this.playerMoveUpInfo;
        if (moveUpInfo != null) {
            float height = ((float) moveUpInfo.getOriginHeight()) - (((float) (moveUpInfo.getOriginHeight() - moveUpInfo.getTargetHeight())) * percent);
            IGraphicPicService iGraphicPicService = (IGraphicPicService) getManager().getService(IGraphicPicService.class);
            if (iGraphicPicService != null) {
                iGraphicPicService.onPanelMoveUpProgressChanged(percent, height);
            }
            IFeedFlowLayoutService iFeedFlowLayoutService = (IFeedFlowLayoutService) getManager().getService(IFeedFlowLayoutService.class);
            FrameLayout frameLayout = null;
            ViewGroup topBarContainer = iFeedFlowLayoutService != null ? iFeedFlowLayoutService.getTopBarContainer() : null;
            if (topBarContainer != null) {
                topBarContainer.setAlpha(((float) 1) - percent);
            }
            ITabComponentService iTabComponentService = (ITabComponentService) getManager().getService(ITabComponentService.class);
            ViewGroup tabView = iTabComponentService != null ? iTabComponentService.getTabView() : null;
            if (tabView != null) {
                tabView.setAlpha(((float) 1) - percent);
            }
            ITabComponentService iTabComponentService2 = (ITabComponentService) getManager().getService(ITabComponentService.class);
            View topCover = iTabComponentService2 != null ? iTabComponentService2.getTopCover() : null;
            if (topCover != null) {
                topCover.setAlpha(((float) 1) - percent);
            }
            ITopEntranceService iTopEntranceService = (ITopEntranceService) getManager().getService(ITopEntranceService.class);
            View topEntranceView = iTopEntranceService != null ? iTopEntranceService.getTopEntranceView() : null;
            if (topEntranceView != null) {
                topEntranceView.setAlpha(((float) 1) - percent);
            }
            FrameLayout frameLayout2 = this.titleContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                frameLayout2 = null;
            }
            float f2 = (float) 1;
            frameLayout2.setAlpha(f2 - percent);
            LinearLayout linearLayout = this.rightContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightContainer");
                linearLayout = null;
            }
            linearLayout.setAlpha(f2 - percent);
            FrameLayout frameLayout3 = this.splitContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splitContainer");
                frameLayout3 = null;
            }
            frameLayout3.setAlpha(f2 - percent);
            FrameLayout frameLayout4 = this.summaryContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryContainer");
                frameLayout4 = null;
            }
            frameLayout4.setAlpha(f2 - percent);
            FrameLayout frameLayout5 = this.authorContainer;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorContainer");
                frameLayout5 = null;
            }
            frameLayout5.setAlpha(f2 - percent);
            FrameLayout frameLayout6 = this.readMoreContainer;
            if (frameLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("readMoreContainer");
            } else {
                frameLayout = frameLayout6;
            }
            frameLayout.setAlpha(f2 - percent);
        }
    }

    public final RelativeLayout getPageContainerPortrait() {
        RelativeLayout relativeLayout = this.pageContainerPortrait;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
        return null;
    }

    public final int getRightContainerWidth() {
        LinearLayout linearLayout = this.rightContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightContainer");
            linearLayout = null;
        }
        return linearLayout.getMeasuredWidth();
    }

    public Lifecycle getLifecycle() {
        return getManager().getLifecycle();
    }

    public final Integer getPortraitAvailablePanelHeight() {
        RelativeLayout relativeLayout = this.pageContainerPortrait;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            relativeLayout = null;
        }
        if (relativeLayout.getVisibility() != 0) {
            return null;
        }
        RelativeLayout relativeLayout2 = this.pageContainerPortrait;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            relativeLayout2 = null;
        }
        if (relativeLayout2.getHeight() != 0) {
            RelativeLayout relativeLayout3 = this.pageContainerPortrait;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
                relativeLayout3 = null;
            }
            if (relativeLayout3.getWidth() != 0) {
                PanelSizeConfig panelSizeConfig = PanelSizeConfig.INSTANCE;
                Context context = ((FrameLayout) getContainer()).getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                return Integer.valueOf(PanelSizeConfig.getPanelHeightVideoMoveUp$default(panelSizeConfig, context, (Float) null, 2, (Object) null));
            }
        }
        return null;
    }

    public final int getTitleContainerMaxHeight() {
        FrameLayout frameLayout = this.titleContainer;
        ViewGroup viewGroup = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            frameLayout = null;
        }
        int bottom = frameLayout.getBottom();
        ViewGroup viewGroup2 = this.topContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
        } else {
            viewGroup = viewGroup2;
        }
        return bottom - viewGroup.getBottom();
    }

    private final void switchAlpha(boolean isScroll) {
        RelativeLayout relativeLayout = this.pageContainerPortrait;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            relativeLayout = null;
        }
        ShowAndHideAnimHelperKt.switchPortraitAlpha$default(relativeLayout, isScroll, getWeakAlphaHideAnim(), getWeakAlphaShowAnim(), (Set) null, 16, (Object) null);
    }

    private final void clearWeakAlphaAnim(ViewGroup root) {
        ShowAndHideAnimHelperKt.destroyPortraitAlphaAnimation$default(root, (Set) null, 2, (Object) null);
        getWeakAlphaHideAnim().cancel();
        getWeakAlphaShowAnim().cancel();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onViewDestroy() {
        RelativeLayout relativeLayout = this.pageContainerPortrait;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            relativeLayout = null;
        }
        clearWeakAlphaAnim(relativeLayout);
    }

    public final boolean isRightContainerVisible() {
        LinearLayout linearLayout = this.rightContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightContainer");
            linearLayout = null;
        }
        return linearLayout.getVisibility() == 0;
    }
}
