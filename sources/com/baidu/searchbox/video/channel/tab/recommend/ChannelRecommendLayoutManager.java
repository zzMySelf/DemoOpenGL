package com.baidu.searchbox.video.channel.tab.recommend;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.channel.R;
import com.baidu.searchbox.video.channel.flow.flow.ChannelFlowLayoutManager;
import com.baidu.searchbox.video.channel.tab.lazy.features.ChannelRecommendFlowState;
import com.baidu.searchbox.video.channel.tab.recommend.ChannelRecommendLayoutManager$onAuthorWorkLayoutListener$2;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus;
import com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService;
import com.baidu.searchbox.video.feedflow.flow.bottom.service.IBarService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0014J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J&\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'H\u0014J\b\u0010*\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/recommend/ChannelRecommendLayoutManager;", "Lcom/baidu/searchbox/video/channel/flow/flow/ChannelFlowLayoutManager;", "()V", "authorWorksContainer", "Landroid/widget/FrameLayout;", "halfScreenTitleContainer", "onAuthorWorkLayoutListener", "com/baidu/searchbox/video/channel/tab/recommend/ChannelRecommendLayoutManager$onAuthorWorkLayoutListener$2$1", "getOnAuthorWorkLayoutListener", "()Lcom/baidu/searchbox/video/channel/tab/recommend/ChannelRecommendLayoutManager$onAuthorWorkLayoutListener$2$1;", "onAuthorWorkLayoutListener$delegate", "Lkotlin/Lazy;", "radius", "", "getRadius", "()I", "radius$delegate", "addView", "", "view", "Landroid/view/View;", "type", "changeHomeTabAlpha", "maxDistance", "curDistance", "extraDisallowOnInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "direction", "inflateByLazy", "initManager", "componentManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "context", "Landroid/content/Context;", "isRefreshEnable", "isAutoRefresh", "extend", "", "", "", "measureAuthorWorkLayout", "onViewResume", "subscriber", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelRecommendLayoutManager.kt */
public final class ChannelRecommendLayoutManager extends ChannelFlowLayoutManager {
    private FrameLayout authorWorksContainer;
    private FrameLayout halfScreenTitleContainer;
    private final Lazy onAuthorWorkLayoutListener$delegate = BdPlayerUtils.lazyNone(new ChannelRecommendLayoutManager$onAuthorWorkLayoutListener$2(this));
    private final Lazy radius$delegate = BdPlayerUtils.lazyNone(ChannelRecommendLayoutManager$radius$2.INSTANCE);

    /* access modifiers changed from: private */
    public final int getRadius() {
        return ((Number) this.radius$delegate.getValue()).intValue();
    }

    private final ChannelRecommendLayoutManager$onAuthorWorkLayoutListener$2.AnonymousClass1 getOnAuthorWorkLayoutListener() {
        return (ChannelRecommendLayoutManager$onAuthorWorkLayoutListener$2.AnonymousClass1) this.onAuthorWorkLayoutListener$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void changeHomeTabAlpha(int maxDistance, int curDistance) {
        float resultAlpha = 2.0f * ((((float) curDistance) * 1.0f) / ((float) maxDistance));
        if (resultAlpha >= 1.0f) {
            resultAlpha = 1.0f;
        }
        IHomeTabFun iHomeTabFun = (IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE);
        if (iHomeTabFun != null) {
            iHomeTabFun.setBottomTabContentAlpha(((float) 1) - resultAlpha);
        }
    }

    public void subscriber() {
        ChannelRecommendFlowState $this$subscriber_u24lambda_u2d1;
        super.subscriber();
        Store store = getManager().getStore();
        if (store != null && ($this$subscriber_u24lambda_u2d1 = (ChannelRecommendFlowState) store.subscribe(ChannelRecommendFlowState.class)) != null) {
            $this$subscriber_u24lambda_u2d1.getAttachAuthorWork().observe(this, new ChannelRecommendLayoutManager$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-1$lambda-0  reason: not valid java name */
    public static final void m4988subscriber$lambda1$lambda0(ChannelRecommendLayoutManager this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.measureAuthorWorkLayout();
    }

    public void initManager(ComponentArchManager componentManager, Context context) {
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        Intrinsics.checkNotNullParameter(context, "context");
        super.initManager(componentManager, context);
        View findViewById = getParentContainer().findViewById(R.id.author_works_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parentContainer.findView…d.author_works_container)");
        this.authorWorksContainer = (FrameLayout) findViewById;
        View findViewById2 = getParentContainer().findViewById(R.id.half_screen_title_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "parentContainer.findView…f_screen_title_container)");
        this.halfScreenTitleContainer = (FrameLayout) findViewById2;
    }

    public void addView(View view2, int type) {
        Intrinsics.checkNotNullParameter(view2, "view");
        FrameLayout frameLayout = null;
        if (type == com.baidu.searchbox.video.feedflow.component.R.id.video_flow_cmp_author_works) {
            FrameLayout frameLayout2 = this.authorWorksContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorWorksContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.addView(view2);
        } else if (type == com.baidu.searchbox.video.feedflow.component.R.id.video_flow_channel_half_screen_next_title) {
            FrameLayout frameLayout3 = this.halfScreenTitleContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("halfScreenTitleContainer");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.addView(view2);
        } else {
            super.addView(view2, type);
        }
    }

    public void onViewResume() {
        super.onViewResume();
        IAuthorWorksService iAuthorWorksService = (IAuthorWorksService) getManager().getService(IAuthorWorksService.class);
        if (iAuthorWorksService != null) {
            iAuthorWorksService.addDraggingListener(getOnAuthorWorkLayoutListener());
        }
    }

    /* access modifiers changed from: protected */
    public boolean isRefreshEnable(boolean isAutoRefresh, Map<String, ? extends Object> extend) {
        IAuthorWorksService iAuthorWorksService = (IAuthorWorksService) getManager().getService(IAuthorWorksService.class);
        AuthorWorkStatus status = iAuthorWorksService != null ? iAuthorWorksService.getAuthorWorkStatus() : null;
        return super.isRefreshEnable(isAutoRefresh, extend) && (status == null || Intrinsics.areEqual((Object) status, (Object) AuthorWorkStatus.Close.INSTANCE));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean extraDisallowOnInterceptTouchEvent(android.view.MotionEvent r11, int r12) {
        /*
            r10 = this;
            boolean r0 = super.extraDisallowOnInterceptTouchEvent(r11, r12)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1 = r10.getManager()
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService> r3 = com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r1 = r1.getService(r3)
            com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService r1 = (com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService) r1
            r2 = 0
            if (r1 == 0) goto L_0x001d
            boolean r1 = r1.isAuthorWorksOpen()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            boolean r1 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r1)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r3 = r10.getManager()
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService> r5 = com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r3 = r3.getService(r5)
            com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService r3 = (com.baidu.searchbox.video.feedflow.flow.authorworks.IAuthorWorksService) r3
            if (r3 == 0) goto L_0x003a
            boolean r3 = r3.canScrollVertically(r11, r12)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x003b
        L_0x003a:
            r3 = r2
        L_0x003b:
            boolean r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r10.getManager()
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r6 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r4 = r4.getService(r6)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r4 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r4
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0059
            boolean r4 = r4.canScrollVertically(r12)
            r4 = r4 ^ r6
            if (r4 != r6) goto L_0x0059
            r4 = r6
            goto L_0x005a
        L_0x0059:
            r4 = r5
        L_0x005a:
            if (r4 == 0) goto L_0x008c
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r10.getManager()
            com.baidu.searchbox.feed.detail.frame.Store r4 = r4.getStore()
            if (r4 == 0) goto L_0x0087
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r4.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x0072
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x0073
        L_0x0072:
            r8 = r2
        L_0x0073:
            if (r8 == 0) goto L_0x007b
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.FlowLayoutState> r2 = com.baidu.searchbox.video.feedflow.flow.FlowLayoutState.class
            java.lang.Object r2 = r8.select(r2)
        L_0x007b:
            com.baidu.searchbox.video.feedflow.flow.FlowLayoutState r2 = (com.baidu.searchbox.video.feedflow.flow.FlowLayoutState) r2
            if (r2 == 0) goto L_0x0087
            boolean r2 = r2.getAllowInterceptScroll()
            if (r2 != r6) goto L_0x0087
            r2 = r6
            goto L_0x0088
        L_0x0087:
            r2 = r5
        L_0x0088:
            if (r2 == 0) goto L_0x008c
            r2 = r6
            goto L_0x008d
        L_0x008c:
            r2 = r5
        L_0x008d:
            if (r0 != 0) goto L_0x0096
            if (r1 == 0) goto L_0x0097
            if (r3 != 0) goto L_0x0096
            if (r2 != 0) goto L_0x0097
        L_0x0096:
            r5 = r6
        L_0x0097:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.recommend.ChannelRecommendLayoutManager.extraDisallowOnInterceptTouchEvent(android.view.MotionEvent, int):boolean");
    }

    /* access modifiers changed from: protected */
    public void inflateByLazy() {
        super.inflateByLazy();
        getLazyInflateHelper().lazyInflateAuthorWorks();
        measureAuthorWorkLayout();
        getLazyInflateHelper().lazyInflateHalfScreenNextTitle();
    }

    private final void measureAuthorWorkLayout() {
        IAuthorWorksService $this$measureAuthorWorkLayout_u24lambda_u2d3 = (IAuthorWorksService) getManager().getService(IAuthorWorksService.class);
        if ($this$measureAuthorWorkLayout_u24lambda_u2d3 != null) {
            getParentContainer().post(new ChannelRecommendLayoutManager$$ExternalSyntheticLambda1(this, $this$measureAuthorWorkLayout_u24lambda_u2d3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: measureAuthorWorkLayout$lambda-3$lambda-2  reason: not valid java name */
    public static final void m4987measureAuthorWorkLayout$lambda3$lambda2(ChannelRecommendLayoutManager this$0, IAuthorWorksService $this_apply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        int expandValidWidth = this$0.getParentContainer().getMeasuredWidth();
        int expandWidth = (expandValidWidth - $this_apply.getLayoutWidth()) - DIFactory.INSTANCE.dp2px(6.0f);
        int measuredHeight = this$0.getParentContainer().getMeasuredHeight();
        IBarService iBarService = (IBarService) this$0.getManager().getService(IBarService.class);
        int expandValidHeight = measuredHeight - BdPlayerUtils.orZero(iBarService != null ? Integer.valueOf(iBarService.getBottomBarHeight()) : null);
        if (expandValidWidth != 0 && expandWidth != 0 && expandValidHeight != 0) {
            $this_apply.setLayoutHeight((int) (((float) expandWidth) * ((((float) expandValidHeight) * 1.0f) / ((float) expandValidWidth))));
        }
    }
}
