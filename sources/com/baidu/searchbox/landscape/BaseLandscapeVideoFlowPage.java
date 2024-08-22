package com.baidu.searchbox.landscape;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.ITemplateStatistic;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.ui.common.IViewLifecycle;
import com.baidu.searchbox.video.R;
import com.baidu.searchbox.video.flow.PagerLayoutManager;
import com.baidu.searchbox.video.page.PagerRecyclerView;
import com.baidu.searchbox.video.player.landscape.ILandscapeVideoPlayer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00108\u001a\u000204H\u0014J\n\u00109\u001a\u0004\u0018\u00010 H\u0014J\b\u0010:\u001a\u00020;H\u0014J\b\u0010<\u001a\u00020\u001aH\u0002J\b\u0010=\u001a\u00020\u001cH\u0002J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020?H\u0014J\u0012\u0010A\u001a\u00020?2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u00020?2\b\u0010E\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010F\u001a\u00020?2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010G\u001a\u00020?2\u0006\u0010E\u001a\u00020CH\u0014J(\u0010H\u001a\u00020?2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020JH\u0016J\"\u0010N\u001a\u00020?2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020;2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020 H\u0014J\u0010\u0010Q\u001a\u00020?2\u0006\u0010R\u001a\u00020;H\u0016J\u001a\u0010S\u001a\u00020?2\b\u0010T\u001a\u0004\u0018\u00010\u000e2\u0006\u0010U\u001a\u00020;H\u0014J&\u0010V\u001a\u00020?2\b\u0010W\u001a\u0004\u0018\u00010\u001f2\b\u0010X\u001a\u0004\u0018\u00010\u001f2\b\u0010Y\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010Z\u001a\u00020?H\u0016J\b\u0010[\u001a\u00020?H\u0016J\b\u0010\\\u001a\u00020?H\u0016J\b\u0010]\u001a\u00020?H\u0016J\b\u0010^\u001a\u00020?H\u0016J\b\u0010_\u001a\u00020?H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148DX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0002048DX\u0002¢\u0006\f\n\u0004\b7\u0010\u0018\u001a\u0004\b5\u00106¨\u0006`"}, d2 = {"Lcom/baidu/searchbox/landscape/BaseLandscapeVideoFlowPage;", "Lcom/baidu/searchbox/ui/common/IViewLifecycle;", "Lcom/baidu/searchbox/video/flow/PagerLayoutManager$PagerListener;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "playerCallback", "Lcom/baidu/searchbox/landscape/ILandscapeOperatePlayerCallback;", "(Landroid/app/Activity;Lcom/baidu/searchbox/landscape/ILandscapeOperatePlayerCallback;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "getCurrentModel", "()Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "setCurrentModel", "(Lcom/baidu/searchbox/feed/model/FeedBaseModel;)V", "layoutManager", "Lcom/baidu/searchbox/video/flow/PagerLayoutManager;", "getLayoutManager", "()Lcom/baidu/searchbox/video/flow/PagerLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "onFeedTemplateChildClickListener", "Lcom/baidu/searchbox/feed/base/FeedTemplate$OnChildViewClickListener;", "onTemplateStatistic", "Lcom/baidu/searchbox/feed/base/ITemplateStatistic;", "playerCache", "", "", "Lcom/baidu/searchbox/video/player/landscape/ILandscapeVideoPlayer;", "getPlayerCache", "()Ljava/util/Map;", "getPlayerCallback", "()Lcom/baidu/searchbox/landscape/ILandscapeOperatePlayerCallback;", "setPlayerCallback", "(Lcom/baidu/searchbox/landscape/ILandscapeOperatePlayerCallback;)V", "recyclerView", "Lcom/baidu/searchbox/video/page/PagerRecyclerView;", "getRecyclerView", "()Lcom/baidu/searchbox/video/page/PagerRecyclerView;", "setRecyclerView", "(Lcom/baidu/searchbox/video/page/PagerRecyclerView;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "videoFullAdapter", "Lcom/baidu/searchbox/landscape/LandscapeVideoFlowPageAdapter;", "getVideoFullAdapter", "()Lcom/baidu/searchbox/landscape/LandscapeVideoFlowPageAdapter;", "videoFullAdapter$delegate", "generateFullAdapter", "getCurrentPlayer", "getLayoutId", "", "getTemplateChildViewClickListener", "getTemplateStatistic", "initRecyclerView", "", "initView", "onAttachedToWindow", "view", "Landroid/view/View;", "onClick", "v", "onDetachedToWindow", "onFeedTemplateChildClick", "onPageScrolled", "isUp", "", "position", "isScrollAway", "isAutoScroll", "onPageSelected", "onPlayerCreated", "shortVideoPlayer", "onScrollStateChanged", "state", "onTemplateClickItem", "feedModel", "pos", "onTemplateReportUserAction", "type", "value", "feedBaseModel", "onViewCreate", "onViewDestroy", "onViewPause", "onViewResume", "onViewStart", "onViewStop", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseLandscapeVideoFlowPage.kt */
public class BaseLandscapeVideoFlowPage implements IViewLifecycle, PagerLayoutManager.PagerListener, View.OnClickListener {
    private Activity activity;
    private FeedBaseModel currentModel;
    private final Lazy layoutManager$delegate = LazyKt.lazy(new BaseLandscapeVideoFlowPage$layoutManager$2(this));
    private final FeedTemplate.OnChildViewClickListener onFeedTemplateChildClickListener = getTemplateChildViewClickListener();
    private final ITemplateStatistic onTemplateStatistic = getTemplateStatistic();
    private final Map<String, ILandscapeVideoPlayer> playerCache = new HashMap();
    private ILandscapeOperatePlayerCallback playerCallback;
    private PagerRecyclerView recyclerView;
    private ViewGroup rootView;
    private final Lazy videoFullAdapter$delegate = LazyKt.lazy(new BaseLandscapeVideoFlowPage$videoFullAdapter$2(this));

    public BaseLandscapeVideoFlowPage(Activity activity2, ILandscapeOperatePlayerCallback playerCallback2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(playerCallback2, "playerCallback");
        this.activity = activity2;
        this.playerCallback = playerCallback2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "<set-?>");
        this.activity = activity2;
    }

    public final ILandscapeOperatePlayerCallback getPlayerCallback() {
        return this.playerCallback;
    }

    public final void setPlayerCallback(ILandscapeOperatePlayerCallback iLandscapeOperatePlayerCallback) {
        Intrinsics.checkNotNullParameter(iLandscapeOperatePlayerCallback, "<set-?>");
        this.playerCallback = iLandscapeOperatePlayerCallback;
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final void setRootView(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final PagerRecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    /* access modifiers changed from: protected */
    public final void setRecyclerView(PagerRecyclerView pagerRecyclerView) {
        this.recyclerView = pagerRecyclerView;
    }

    /* access modifiers changed from: protected */
    public final PagerLayoutManager getLayoutManager() {
        return (PagerLayoutManager) this.layoutManager$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final LandscapeVideoFlowPageAdapter getVideoFullAdapter() {
        return (LandscapeVideoFlowPageAdapter) this.videoFullAdapter$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final Map<String, ILandscapeVideoPlayer> getPlayerCache() {
        return this.playerCache;
    }

    /* access modifiers changed from: protected */
    public final FeedBaseModel getCurrentModel() {
        return this.currentModel;
    }

    /* access modifiers changed from: protected */
    public final void setCurrentModel(FeedBaseModel feedBaseModel) {
        this.currentModel = feedBaseModel;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        View inflate = View.inflate(this.activity, getLayoutId(), (ViewGroup) null);
        if (inflate != null) {
            this.rootView = (ViewGroup) inflate;
            initRecyclerView();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private final void initRecyclerView() {
        ViewGroup viewGroup = this.rootView;
        this.recyclerView = viewGroup != null ? (PagerRecyclerView) viewGroup.findViewById(R.id.landscape_recycler_view) : null;
        getLayoutManager().setOnPagerListener(this);
        PagerRecyclerView pagerRecyclerView = this.recyclerView;
        if (pagerRecyclerView != null) {
            pagerRecyclerView.setLayoutManager(getLayoutManager());
        }
        getVideoFullAdapter().setOnChildClickListener(this.onFeedTemplateChildClickListener);
        getVideoFullAdapter().bindTemplateStatistic(this.onTemplateStatistic);
        PagerRecyclerView pagerRecyclerView2 = this.recyclerView;
        if (pagerRecyclerView2 != null) {
            pagerRecyclerView2.setAdapter(getVideoFullAdapter());
        }
    }

    /* access modifiers changed from: protected */
    public ILandscapeVideoPlayer getCurrentPlayer() {
        FeedBaseModel model = this.currentModel;
        if (model == null) {
            return null;
        }
        String layout = model.layout;
        Intrinsics.checkNotNullExpressionValue(layout, "model.layout");
        if (TextUtils.isEmpty(layout)) {
            return null;
        }
        ILandscapeVideoPlayer player = this.playerCache.get(layout);
        if (player != null) {
            return player;
        }
        ILandscapeOperatePlayerCallback iLandscapeOperatePlayerCallback = this.playerCallback;
        String str = model.layout;
        Intrinsics.checkNotNullExpressionValue(str, "model.layout");
        String str2 = model.id;
        Intrinsics.checkNotNullExpressionValue(str2, "model.id");
        ILandscapeVideoPlayer player2 = iLandscapeOperatePlayerCallback.getPlayer(str, str2);
        onPlayerCreated(player2);
        this.playerCache.put(layout, player2);
        return player2;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.video_page_landscape_video_flow;
    }

    /* access modifiers changed from: protected */
    public LandscapeVideoFlowPageAdapter generateFullAdapter() {
        return new LandscapeVideoFlowPageAdapter(this.activity);
    }

    public void onViewCreate() {
        initView();
    }

    public void onViewStart() {
    }

    public void onViewResume() {
    }

    public void onViewPause() {
    }

    public void onViewStop() {
    }

    public void onViewDestroy() {
    }

    public void onDetachedToWindow(View view2) {
    }

    public void onAttachedToWindow(View view2) {
    }

    public void onPageSelected(boolean isUp, int position, View view2) {
    }

    public void onPageScrolled(boolean isUp, int position, boolean isScrollAway, boolean isAutoScroll) {
    }

    public void onScrollStateChanged(int state) {
    }

    public void onClick(View v) {
    }

    /* access modifiers changed from: protected */
    public void onPlayerCreated(ILandscapeVideoPlayer shortVideoPlayer) {
        Intrinsics.checkNotNullParameter(shortVideoPlayer, "shortVideoPlayer");
    }

    /* access modifiers changed from: protected */
    public void onFeedTemplateChildClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
    }

    /* access modifiers changed from: protected */
    public void onTemplateReportUserAction(String type, String value, FeedBaseModel feedBaseModel) {
    }

    /* access modifiers changed from: protected */
    public void onTemplateClickItem(FeedBaseModel feedModel, int pos) {
    }

    private final ITemplateStatistic getTemplateStatistic() {
        return new BaseLandscapeVideoFlowPage$getTemplateStatistic$1(this);
    }

    private final FeedTemplate.OnChildViewClickListener getTemplateChildViewClickListener() {
        return new BaseLandscapeVideoFlowPage$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: getTemplateChildViewClickListener$lambda-1  reason: not valid java name */
    public static final void m20672getTemplateChildViewClickListener$lambda1(BaseLandscapeVideoFlowPage this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v, "v");
        this$0.onFeedTemplateChildClick(v);
    }
}
