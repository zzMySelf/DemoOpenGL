package com.baidu.searchbox.music.comp.playlist.playinglist;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.music.R;
import com.baidu.searchbox.music.comp.player.event.UserClickPlaySongEvent;
import com.baidu.searchbox.music.comp.playlist.item.PlaylistItemAdapter;
import com.baidu.searchbox.music.comp.playlist.panel.TabType;
import com.baidu.searchbox.music.comp.playlist.toolbar.PanelToolBarComp;
import com.baidu.searchbox.music.comp.playlist.toolbar.PanelToolBarViewModel;
import com.baidu.searchbox.music.comp.playlist.toolbar.ToolBarModel;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import com.baidu.searchbox.music.util.RecycleViewDivider;
import com.baidu.searchbox.nacomp.extension.base.BaseExtRVComponent;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.RecyclerViewHelper;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.recycler.delegate.DelegatorAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0014J\u0006\u0010.\u001a\u00020\u0012J\u0006\u0010/\u001a\u00020\u0012R=\u0010\u000b\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/searchbox/music/comp/playlist/playinglist/PlayingListComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtRVComponent;", "Lcom/baidu/searchbox/music/comp/playlist/playinglist/PlayingListViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "panelToken", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "listCollectCallback", "Lkotlin/Function1;", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "Lkotlin/ParameterName;", "name", "list", "", "getListCollectCallback", "()Lkotlin/jvm/functions/Function1;", "setListCollectCallback", "(Lkotlin/jvm/functions/Function1;)V", "listEmptyCallback", "Lkotlin/Function0;", "getListEmptyCallback", "()Lkotlin/jvm/functions/Function0;", "setListEmptyCallback", "(Lkotlin/jvm/functions/Function0;)V", "toolBarComp", "Lcom/baidu/searchbox/music/comp/playlist/toolbar/PanelToolBarComp;", "bindListAnchorPosition", "viewModel", "bindSongListCount", "onBindViewModel", "onCreateLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onCreateViewModel", "onFindRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onPlayModeChange", "mode", "", "onRegisterDelegates", "delegator", "Lcom/baidu/searchbox/nacomp/recycler/delegate/DelegatorAdapter;", "reset", "update", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayingListComp.kt */
public final class PlayingListComp extends BaseExtRVComponent<PlayingListViewModel> {
    private Function1<? super List<? extends ISong>, Unit> listCollectCallback;
    private Function0<Unit> listEmptyCallback;
    private final UniqueId token;
    private final PanelToolBarComp toolBarComp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayingListComp(LifecycleOwner owner, View view2, UniqueId token2, UniqueId panelToken) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(panelToken, "panelToken");
        this.token = token2;
        View findViewById = view2.findViewById(R.id.layoutTools);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.layoutTools");
        PanelToolBarComp panelToolBarComp = new PanelToolBarComp(token2, owner, findViewById, new ToolBarModel(0, TabType.PLAY_LIST));
        PanelToolBarComp $this$toolBarComp_u24lambda_u2d0 = panelToolBarComp;
        add($this$toolBarComp_u24lambda_u2d0);
        $this$toolBarComp_u24lambda_u2d0.setPlayerActionClick(new PlayingListComp$toolBarComp$1$1(this));
        $this$toolBarComp_u24lambda_u2d0.setMusicCollectClick(new PlayingListComp$toolBarComp$1$2(this));
        $this$toolBarComp_u24lambda_u2d0.setMusicClearClick(new PlayingListComp$toolBarComp$1$3(this));
        $this$toolBarComp_u24lambda_u2d0.setListEditStatusChange(new PlayingListComp$toolBarComp$1$4(this));
        this.toolBarComp = panelToolBarComp;
        setOnItemClickListener(new PlayingListComp$$ExternalSyntheticLambda1(this));
        ((PlayingListViewModel) getViewModel()).setParentToken(token2);
        ((PlayingListViewModel) getViewModel()).setPanelToken(panelToken);
        ((PlayingListViewModel) getViewModel()).loadData();
    }

    public final Function0<Unit> getListEmptyCallback() {
        return this.listEmptyCallback;
    }

    public final void setListEmptyCallback(Function0<Unit> function0) {
        this.listEmptyCallback = function0;
    }

    public final Function1<List<? extends ISong>, Unit> getListCollectCallback() {
        return this.listCollectCallback;
    }

    public final void setListCollectCallback(Function1<? super List<? extends ISong>, Unit> function1) {
        this.listCollectCallback = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m677_init_$lambda1(PlayingListComp this$0, RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BdEventBus.Companion.getDefault().post(new UserClickPlaySongEvent(true, this$0.token));
        ((PlayingListViewModel) this$0.getViewModel()).playSong(position);
        ((PlayingListViewModel) this$0.getViewModel()).onStatClick(MusicExtStats.VALUE_PLAY_PANEL_SONG_PLAY);
    }

    public PlayingListViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(PlayingListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(PlayingListViewModel::class.java)");
        return (PlayingListViewModel) viewModel;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new PlayListLayoutManager(context, 1, false);
    }

    /* access modifiers changed from: protected */
    public RecyclerView onFindRecyclerView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.rcyPlayingList);
        RecyclerView $this$onFindRecyclerView_u24lambda_u2d2 = recyclerView;
        $this$onFindRecyclerView_u24lambda_u2d2.setItemAnimator((RecyclerView.ItemAnimator) null);
        $this$onFindRecyclerView_u24lambda_u2d2.addItemDecoration(new RecycleViewDivider($this$onFindRecyclerView_u24lambda_u2d2.getContext(), 0, 1, ResWrapper.getColor($this$onFindRecyclerView_u24lambda_u2d2.getContext(), com.baidu.searchbox.bdmedia.interfaces.R.color.music_divider_color)));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "view.rcyPlayingList.appl…        )\n        )\n    }");
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public void onRegisterDelegates(DelegatorAdapter delegator) {
        Intrinsics.checkNotNullParameter(delegator, "delegator");
        super.onRegisterDelegates(delegator);
        delegator.put(new PlaylistItemAdapter(getLifecycleOwner()));
    }

    public void onBindViewModel(PlayingListViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindSongListCount(viewModel);
        bindListAnchorPosition(viewModel);
    }

    private final void bindSongListCount(PlayingListViewModel viewModel) {
        viewModel.getListCount().observe(getLifecycleOwner(), new PlayingListComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindSongListCount$lambda-4  reason: not valid java name */
    public static final void m679bindSongListCount$lambda4(PlayingListComp this$0, Integer count) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PanelToolBarViewModel $this$bindSongListCount_u24lambda_u2d4_u24lambda_u2d3 = (PanelToolBarViewModel) this$0.toolBarComp.getViewModel();
        Intrinsics.checkNotNullExpressionValue(count, "count");
        $this$bindSongListCount_u24lambda_u2d4_u24lambda_u2d3.setListTotalCount(count.intValue());
        $this$bindSongListCount_u24lambda_u2d4_u24lambda_u2d3.setSupportPlayCount(count.intValue());
    }

    private final void bindListAnchorPosition(PlayingListViewModel viewModel) {
        viewModel.getAnchorPosition().observe(getLifecycleOwner(), new PlayingListComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindListAnchorPosition$lambda-5  reason: not valid java name */
    public static final void m678bindListAnchorPosition$lambda5(PlayingListComp this$0, Integer position) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(position, "position");
        RecyclerViewHelper.smoothScrollToPosition(recyclerView, position.intValue());
    }

    public final void onPlayModeChange(int mode) {
        this.toolBarComp.onPlayModeChange(mode);
    }

    public final void update() {
        updateRecyclerViewData();
    }

    public final void reset() {
        ((PlayingListViewModel) getViewModel()).loadData();
        this.toolBarComp.reset();
    }
}
