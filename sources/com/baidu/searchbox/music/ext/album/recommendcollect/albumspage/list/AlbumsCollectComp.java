package com.baidu.searchbox.music.ext.album.recommendcollect.albumspage.list;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.list.comps.item.AlbumItemAdapter;
import com.baidu.searchbox.music.ext.album.list.comps.item.AlbumItemComp;
import com.baidu.searchbox.music.ext.album.list.comps.item.AlbumItemModel;
import com.baidu.searchbox.music.ext.album.list.comps.item.AlbumItemViewModel;
import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import com.baidu.searchbox.music.ext.album.recommendcollect.common.item.tip.TipsItemAdapter;
import com.baidu.searchbox.music.ext.album.recommendcollect.status.ReqStatus;
import com.baidu.searchbox.music.ext.utils.BottomBarUtils;
import com.baidu.searchbox.nacomp.extension.base.BaseExtRVComponent;
import com.baidu.searchbox.nacomp.extension.widget.ptr.PullToRefreshRecyclerView;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.recycler.delegate.DelegatorAdapter;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/recommendcollect/albumspage/list/AlbumsCollectComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtRVComponent;", "Lcom/baidu/searchbox/music/ext/album/recommendcollect/albumspage/list/AlbumsCollectViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "dst", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "invokeFrom", "", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;Ljava/lang/String;)V", "bottomBar", "Lcom/baidu/searchbox/unifiedtoolbar/templates/UnifiedBottomBar;", "getBottomBar", "()Lcom/baidu/searchbox/unifiedtoolbar/templates/UnifiedBottomBar;", "onReqStatusChange", "Lkotlin/Function1;", "Lcom/baidu/searchbox/music/ext/album/recommendcollect/status/ReqStatus;", "Lkotlin/ParameterName;", "name", "status", "", "getOnReqStatusChange", "()Lkotlin/jvm/functions/Function1;", "setOnReqStatusChange", "(Lkotlin/jvm/functions/Function1;)V", "bindHasMoreState", "viewModel", "bindLoadMoreState", "bindReqStatusChange", "vm", "onBindViewModel", "onCreateLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onCreateView", "onCreateViewModel", "onFindRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onRegisterDelegates", "delegator", "Lcom/baidu/searchbox/nacomp/recycler/delegate/DelegatorAdapter;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumsCollectComp.kt */
public final class AlbumsCollectComp extends BaseExtRVComponent<AlbumsCollectViewModel> {
    private final UnifiedBottomBar bottomBar;
    private final String invokeFrom;
    private Function1<? super ReqStatus, Unit> onReqStatusChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumsCollectComp(LifecycleOwner owner, View view2, MusicAlbum dst, String invokeFrom2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(invokeFrom2, "invokeFrom");
        this.invokeFrom = invokeFrom2;
        BottomBarUtils bottomBarUtils = BottomBarUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.bottomBar = bottomBarUtils.createBottomBar(context);
        AlbumsCollectViewModel $this$_init__u24lambda_u2d0 = (AlbumsCollectViewModel) getViewModel();
        $this$_init__u24lambda_u2d0.setInvokeFrom(invokeFrom2);
        $this$_init__u24lambda_u2d0.setModel(dst);
        setOnItemClickListener(new AlbumsCollectComp$$ExternalSyntheticLambda3(this));
    }

    public final Function1<ReqStatus, Unit> getOnReqStatusChange() {
        return this.onReqStatusChange;
    }

    public final void setOnReqStatusChange(Function1<? super ReqStatus, Unit> function1) {
        this.onReqStatusChange = function1;
    }

    public final UnifiedBottomBar getBottomBar() {
        return this.bottomBar;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m848_init_$lambda3(AlbumsCollectComp this$0, RecyclerView.ViewHolder vh, int i2) {
        AlbumItemModel albumItemModel;
        MusicAlbum $this$lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlbumItemComp comp = vh instanceof AlbumItemComp ? (AlbumItemComp) vh : null;
        if (comp != null && (albumItemModel = (AlbumItemModel) ((AlbumItemViewModel) comp.getViewModel()).getModel()) != null && ($this$lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = albumItemModel.getMusicAlbum()) != null) {
            Intrinsics.checkNotNullExpressionValue($this$lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1, "this");
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ((AlbumsCollectViewModel) this$0.getViewModel()).jumpToAlbumDetail$lib_music_ext_release($this$lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1, context);
        }
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onCreateView(view2);
        ((PullToRefreshRecyclerView) view2.findViewById(R.id.rcyAlbumList)).setDelAdapter(getAdapter());
        ((FrameLayout) view2.findViewById(R.id.bottomBarFl)).addView(this.bottomBar);
    }

    public AlbumsCollectViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(AlbumsCollectViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(AlbumsCollectViewModel::class.java)");
        return (AlbumsCollectViewModel) viewModel;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    /* access modifiers changed from: protected */
    public RecyclerView onFindRecyclerView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view2.findViewById(R.id.rcyAlbumList);
        PullToRefreshRecyclerView $this$onFindRecyclerView_u24lambda_u2d5 = pullToRefreshRecyclerView;
        $this$onFindRecyclerView_u24lambda_u2d5.setAttachFooterWithNoMoreUpdate(false);
        $this$onFindRecyclerView_u24lambda_u2d5.setOnRefreshListener(new AlbumsCollectComp$$ExternalSyntheticLambda0(this));
        $this$onFindRecyclerView_u24lambda_u2d5.setThresholdToTrigPreload(5);
        RecyclerView recyclerView = pullToRefreshRecyclerView.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "view.rcyAlbumList.apply …ELOAD)\n    }.recyclerView");
        return recyclerView;
    }

    /* access modifiers changed from: private */
    /* renamed from: onFindRecyclerView$lambda-5$lambda-4  reason: not valid java name */
    public static final void m852onFindRecyclerView$lambda5$lambda4(AlbumsCollectComp this$0, PullToRefreshRecyclerView it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((AlbumsCollectViewModel) this$0.getViewModel()).loadMore();
    }

    /* access modifiers changed from: protected */
    public void onRegisterDelegates(DelegatorAdapter delegator) {
        Intrinsics.checkNotNullParameter(delegator, "delegator");
        super.onRegisterDelegates(delegator);
        delegator.put(new AlbumItemAdapter(getLifecycleOwner()));
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        delegator.put(new TipsItemAdapter(lifecycleOwner));
    }

    public void onBindViewModel(AlbumsCollectViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindHasMoreState(viewModel);
        bindLoadMoreState(viewModel);
        bindReqStatusChange(viewModel);
    }

    private final void bindHasMoreState(AlbumsCollectViewModel viewModel) {
        viewModel.getHasMore().observe(getLifecycleOwner(), new AlbumsCollectComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindHasMoreState$lambda-6  reason: not valid java name */
    public static final void m849bindHasMoreState$lambda6(AlbumsCollectComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((PullToRefreshRecyclerView) this$0.getView().findViewById(R.id.rcyAlbumList)).setHasMore(Intrinsics.areEqual((Object) it, (Object) true));
    }

    private final void bindLoadMoreState(AlbumsCollectViewModel viewModel) {
        viewModel.getLoadMoreError().observe(getLifecycleOwner(), new AlbumsCollectComp$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindLoadMoreState$lambda-7  reason: not valid java name */
    public static final void m850bindLoadMoreState$lambda7(AlbumsCollectComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((PullToRefreshRecyclerView) this$0.getView().findViewById(R.id.rcyAlbumList)).onLoadMoreError();
    }

    private final void bindReqStatusChange(AlbumsCollectViewModel vm) {
        vm.getReqStatus().observe(getLifecycleOwner(), new AlbumsCollectComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindReqStatusChange$lambda-8  reason: not valid java name */
    public static final void m851bindReqStatusChange$lambda8(AlbumsCollectComp this$0, ReqStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super ReqStatus, Unit> function1 = this$0.onReqStatusChange;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function1.invoke(it);
        }
    }
}
