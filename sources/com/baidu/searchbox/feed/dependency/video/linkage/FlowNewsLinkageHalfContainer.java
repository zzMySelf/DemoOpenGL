package com.baidu.searchbox.feed.dependency.video.linkage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.feed.config.NewsHelper;
import com.baidu.searchbox.feed.news.diverse.inner.IPushFlowAdapter;
import com.baidu.searchbox.feed.news.diverse.inner.PushFlowHalfNewsContainer;
import com.baidu.searchbox.feed.news.diverse.inner.VideoContainerFirstItemData;
import com.baidu.searchbox.feed.news.diverse.inner.half.HalfScreenNewsLayout;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserSuspensionBall;
import com.baidu.searchbox.video.linkageflow.container.BaseLinkageItemContainer;
import com.baidu.searchbox.video.linkageflow.container.LinkageContainerManager;
import com.baidu.searchbox.video.linkageflow.container.LinkageItemView;
import com.baidu.searchbox.video.linkageflow.container.event.LinkageEvent;
import com.baidu.searchbox.video.linkageflow.container.event.LinkageEventAction;
import com.baidu.searchbox.video.linkageflow.container.service.IVideoContainerService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020 H\u0016J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020 H\u0016J\b\u00105\u001a\u00020 H\u0016J\b\u00106\u001a\u00020 H\u0016J\b\u00107\u001a\u00020\u001aH\u0016J\u0012\u00108\u001a\u00020\u001a2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u001aH\u0016J\b\u0010?\u001a\u00020\u001aH\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020 H\u0016J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020 H\u0016J\b\u0010D\u001a\u00020\u001aH\u0016J\b\u0010E\u001a\u00020\u001aH\u0016J\u0010\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020 H\u0016J\b\u0010H\u001a\u00020\u001aH\u0016J\b\u0010I\u001a\u00020\u001aH\u0016J\b\u0010J\u001a\u00020\u001aH\u0016J\b\u0010K\u001a\u00020\u001aH\u0016J\b\u0010L\u001a\u00020\u001aH\u0016J\u0010\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020 H\u0002J\b\u0010P\u001a\u00020\u001aH\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/baidu/searchbox/feed/dependency/video/linkage/FlowNewsLinkageHalfContainer;", "Lcom/baidu/searchbox/video/linkageflow/container/BaseLinkageItemContainer;", "Lcom/baidu/searchbox/feed/news/diverse/inner/IPushFlowAdapter;", "ctx", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activity", "halfScreenNewsLayout", "Lcom/baidu/searchbox/feed/news/diverse/inner/half/HalfScreenNewsLayout;", "getHalfScreenNewsLayout", "()Lcom/baidu/searchbox/feed/news/diverse/inner/half/HalfScreenNewsLayout;", "halfScreenNewsLayout$delegate", "Lkotlin/Lazy;", "newsContainer", "Lcom/baidu/searchbox/feed/news/diverse/inner/PushFlowHalfNewsContainer;", "getNewsContainer", "()Lcom/baidu/searchbox/feed/news/diverse/inner/PushFlowHalfNewsContainer;", "newsContainer$delegate", "newsLayerView", "Lcom/baidu/searchbox/feed/dependency/video/linkage/FlowNewsLinkageHalfContainer$BottomRoundCornerFrameLayout;", "getNewsLayerView", "()Lcom/baidu/searchbox/feed/dependency/video/linkage/FlowNewsLinkageHalfContainer$BottomRoundCornerFrameLayout;", "newsLayerView$delegate", "processedIntent", "Landroid/content/Intent;", "addLeftSlideDrawerContent", "", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "canSlideDefaultFinish", "", "event", "Landroid/view/MotionEvent;", "canSlideDrawer", "canSlideFinish", "closeLeftSlideDrawer", "configHostWhenDrag", "enable", "configHostWithNewsStyle", "createView", "Lcom/baidu/searchbox/video/linkageflow/container/LinkageItemView;", "doFinish", "getActivity", "getFirstVideoData", "Lcom/baidu/searchbox/feed/news/diverse/inner/VideoContainerFirstItemData;", "getIntent", "handleSetContentView", "injectManager", "manager", "Lcom/baidu/searchbox/video/linkageflow/container/LinkageContainerManager;", "isCanScrollToNext", "isCanScrollToPrev", "isDrawerClosed", "notifyLinkageReachBottom", "onClickRecommendVideo", "params", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onDragScrollToNext", "isDragToNext", "onNightModeChanged", "isNightMode", "onPause", "onResume", "onSelected", "isUpOrLeft", "onStart", "onStop", "onUnSelected", "requestFirstVideoData", "requestScrollToNext", "setLeftSlideEnabled", "canSlide", "toggleRoundCorner", "tryShowSuspensionBallWhenResume", "BottomRoundCornerFrameLayout", "lib-feed-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowNewsLinkageHalfContainer.kt */
public final class FlowNewsLinkageHalfContainer extends BaseLinkageItemContainer implements IPushFlowAdapter {
    /* access modifiers changed from: private */
    public final Activity activity;
    private final Lazy halfScreenNewsLayout$delegate;
    private final Lazy newsContainer$delegate = LazyKt.lazy(new FlowNewsLinkageHalfContainer$newsContainer$2(this));
    private final Lazy newsLayerView$delegate;
    private Intent processedIntent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowNewsLinkageHalfContainer(Activity ctx) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.activity = ctx;
        this.halfScreenNewsLayout$delegate = LazyKt.lazy(new FlowNewsLinkageHalfContainer$halfScreenNewsLayout$2(ctx));
        this.newsLayerView$delegate = LazyKt.lazy(new FlowNewsLinkageHalfContainer$newsLayerView$2(this));
    }

    private final PushFlowHalfNewsContainer getNewsContainer() {
        return (PushFlowHalfNewsContainer) this.newsContainer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final HalfScreenNewsLayout getHalfScreenNewsLayout() {
        return (HalfScreenNewsLayout) this.halfScreenNewsLayout$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final BottomRoundCornerFrameLayout getNewsLayerView() {
        return (BottomRoundCornerFrameLayout) this.newsLayerView$delegate.getValue();
    }

    public LinkageItemView createView() {
        return new FlowNewsLinkageHalfContainer$createView$1(this, this.activity);
    }

    public void requestScrollToNext() {
        getManager().smoothScrollToNext();
    }

    public void notifyLinkageReachBottom() {
        getManager().sendEvent(new LinkageEvent("news_container_scroll_to_bottom", (Object) null, 2, (DefaultConstructorMarker) null), this);
    }

    public void onClickRecommendVideo(String params) {
        getManager().sendEvent(new LinkageEvent(LinkageEventAction.NEWS_CONTAINER_CLICK_RECOMMEND_VIDEO, params), this);
    }

    public void requestFirstVideoData() {
        getManager().sendEvent(new LinkageEvent(LinkageEventAction.NEWS_CONTAINER_SCROLL_TO_TWO_THIRDS, (Object) null, 2, (DefaultConstructorMarker) null), this);
    }

    public VideoContainerFirstItemData getFirstVideoData() {
        IVideoContainerService iVideoContainerService = (IVideoContainerService) getManager().getService(IVideoContainerService.class);
        String str = null;
        com.baidu.searchbox.video.linkageflow.container.service.VideoContainerFirstItemData rawData = iVideoContainerService != null ? iVideoContainerService.getFirstItemData() : null;
        String title = rawData != null ? rawData.getTitle() : null;
        String poster = rawData != null ? rawData.getPoster() : null;
        if (rawData != null) {
            str = rawData.getNid();
        }
        return new VideoContainerFirstItemData(title, poster, str);
    }

    public void addLeftSlideDrawerContent(View view2, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
    }

    public void closeLeftSlideDrawer() {
    }

    public void setLeftSlideEnabled(boolean canSlide) {
    }

    public boolean isDrawerClosed() {
        return getManager().isDrawerLayoutClosed();
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Intent getIntent() {
        if (this.processedIntent == null) {
            this.processedIntent = NewsHelper.obtainPushNewsIntentByHostIntent(getManager().getActivityIntent());
        }
        Intent intent = this.processedIntent;
        return intent == null ? new Intent() : intent;
    }

    public void onDragScrollToNext(boolean isDragToNext) {
        super.onDragScrollToNext(isDragToNext);
        getNewsContainer().changeSelfSelfElementWhenDrag();
    }

    public void injectManager(LinkageContainerManager manager) {
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
        super.injectManager(manager);
        manager.addLinkageContainerListener(new FlowNewsLinkageHalfContainer$injectManager$1(this));
    }

    public void doFinish() {
        this.activity.finish();
    }

    public boolean handleSetContentView() {
        return true;
    }

    private final void configHostWithNewsStyle() {
        getManager().setPushNewsStatusBar(0);
        getManager().resetNavigationBarDefaultColor();
        Window window = this.activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        getManager().forcePageTransparent(true);
        Activity activity2 = this.activity;
        BaseActivity baseActivity = activity2 instanceof BaseActivity ? (BaseActivity) activity2 : null;
        if (baseActivity != null) {
            baseActivity.setEnableSliding(false);
        }
    }

    /* access modifiers changed from: private */
    public final void configHostWhenDrag(boolean enable) {
        if (isSelected()) {
            if (enable) {
                getManager().setPushNewsStatusBar(-16777216);
            } else {
                getManager().setPushNewsStatusBar(0);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        getNewsContainer().onCreate();
    }

    public void onStart() {
        super.onStart();
        getNewsContainer().onStart();
    }

    public void onResume() {
        super.onResume();
        getNewsContainer().onResume();
        tryShowSuspensionBallWhenResume();
    }

    public void onPause() {
        super.onPause();
        getNewsContainer().onPause();
    }

    public void onStop() {
        super.onStop();
        getNewsContainer().onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        getNewsContainer().onDestroy();
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        getNewsContainer().onNightModeChanged(isNightMode);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (isSelected()) {
            getNewsContainer().onConfigurationChanged(newConfig);
        }
    }

    public void onUnSelected() {
        super.onUnSelected();
        getNewsContainer().markContainerUnSelected();
    }

    public void onSelected(boolean isUpOrLeft) {
        super.onSelected(isUpOrLeft);
        configHostWithNewsStyle();
        getNewsContainer().markContainerSelected();
    }

    public boolean isCanScrollToNext() {
        return getNewsContainer().notIntercept();
    }

    public boolean isCanScrollToPrev() {
        return false;
    }

    public boolean canSlideDefaultFinish(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    public boolean canSlideFinish(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return getNewsContainer().canSlide(event);
    }

    public boolean canSlideDrawer(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    private final void tryShowSuspensionBallWhenResume() {
        ILightBrowserSuspensionBall.Impl.get().tryShowAllSuspensionBall(this.activity);
    }

    /* access modifiers changed from: private */
    public final void toggleRoundCorner(boolean enable) {
        getNewsLayerView().setRadiusEnable(enable);
        getNewsLayerView().invalidate();
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/feed/dependency/video/linkage/FlowNewsLinkageHalfContainer$BottomRoundCornerFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "isRadiusEnable", "", "()Z", "setRadiusEnable", "(Z)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "lib-feed-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowNewsLinkageHalfContainer.kt */
    private static final class BottomRoundCornerFrameLayout extends FrameLayout {
        private float cornerRadius;
        private boolean isRadiusEnable;
        private final Path path;
        private final RectF rect;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public BottomRoundCornerFrameLayout(Context context) {
            this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public BottomRoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BottomRoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BottomRoundCornerFrameLayout(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            Intrinsics.checkNotNullParameter(context, "context");
            this.rect = new RectF();
            this.path = new Path();
            this.cornerRadius = getResources().getDimension(R.dimen.F_J_X02);
        }

        public final boolean isRadiusEnable() {
            return this.isRadiusEnable;
        }

        public final void setRadiusEnable(boolean z) {
            this.isRadiusEnable = z;
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final void setCornerRadius(float f2) {
            this.cornerRadius = f2;
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            float radius = this.isRadiusEnable ? this.cornerRadius : 0.0f;
            this.rect.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
            this.path.reset();
            this.path.addRoundRect(this.rect, new float[]{0.0f, 0.0f, 0.0f, 0.0f, radius, radius, radius, radius}, Path.Direction.CW);
            canvas.clipPath(this.path);
            super.dispatchDraw(canvas);
        }
    }
}
