package com.baidu.searchbox.music.ext.mymusic.comp.album;

import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import com.baidu.searchbox.music.ext.mymusic.IClear;
import com.baidu.searchbox.music.ext.mymusic.comp.album.adapter.AlbumStartPagerSnapHelper;
import com.baidu.searchbox.music.ext.mymusic.comp.album.adapter.AlbumsAdapter;
import com.baidu.searchbox.music.ext.mymusic.comp.album.model.AlbumListModel;
import com.baidu.searchbox.music.ext.mymusic.comp.header.HeaderComp;
import com.baidu.searchbox.music.ext.mymusic.comp.header.HeaderModel;
import com.baidu.searchbox.music.ext.mymusic.style.AlbumListTplStyle;
import com.baidu.searchbox.music.ext.mymusic.view.ISlideExtStatCallback;
import com.baidu.searchbox.music.ext.tpls.comps.base.TplBaseComp;
import com.baidu.searchbox.music.ext.tpls.model.LoadSchemeAction;
import com.baidu.searchbox.music.ext.tpls.model.TplAction;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H\u0002J\u0018\u00105\u001a\u00020!2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H\u0002J\u0018\u00106\u001a\u00020!2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H\u0002J\u0018\u00107\u001a\u00020!2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H\u0002J\b\u00108\u001a\u00020!H\u0016J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010<\u001a\u00020!2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H\u0016J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\u0003H\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020BH\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR)\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!0\u001cX\u0004¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020!\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020!0(X\u0004¢\u0006\u0002\n\u0000R)\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n ,*\u0004\u0018\u00010+0+X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u000f\u001a\u0004\b/\u00100¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/album/AlbumListComp;", "Lcom/baidu/searchbox/music/ext/tpls/comps/base/TplBaseComp;", "Lcom/baidu/searchbox/music/ext/mymusic/comp/album/model/AlbumListModel;", "Lcom/baidu/searchbox/music/ext/mymusic/comp/album/AlbumListViewModel;", "Lcom/baidu/searchbox/music/ext/mymusic/IClear;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "itemView", "Landroid/view/View;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "albumsAdapter", "Lcom/baidu/searchbox/music/ext/mymusic/comp/album/adapter/AlbumsAdapter;", "getAlbumsAdapter", "()Lcom/baidu/searchbox/music/ext/mymusic/comp/album/adapter/AlbumsAdapter;", "albumsAdapter$delegate", "Lkotlin/Lazy;", "cardWrapper", "getCardWrapper", "()Landroid/view/View;", "setCardWrapper", "(Landroid/view/View;)V", "headerComp", "Lcom/baidu/searchbox/music/ext/mymusic/comp/header/HeaderComp;", "getHeaderComp", "()Lcom/baidu/searchbox/music/ext/mymusic/comp/header/HeaderComp;", "setHeaderComp", "(Lcom/baidu/searchbox/music/ext/mymusic/comp/header/HeaderComp;)V", "onAlbumCoverClick", "Lkotlin/Function1;", "Lcom/baidu/searchbox/music/ext/album/model/MusicAlbum;", "Lkotlin/ParameterName;", "name", "album", "", "onAlbumCoverClickListener", "getOnAlbumCoverClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnAlbumCoverClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onCreateAlbumClick", "Lkotlin/Function0;", "onItemClick", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "slideExtStatCallback", "Lcom/baidu/searchbox/music/ext/mymusic/view/ISlideExtStatCallback;", "getSlideExtStatCallback", "()Lcom/baidu/searchbox/music/ext/mymusic/view/ISlideExtStatCallback;", "slideExtStatCallback$delegate", "bindData", "viewModel", "owner", "bindHisAlbumClick", "bindInitRV", "bindStyle", "clear", "initRecyclerView", "style", "Lcom/baidu/searchbox/music/ext/mymusic/style/AlbumListTplStyle;", "onBindViewModel", "onCreateView", "view", "onCreateViewModel", "onNightModeChange", "isNightMode", "", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumListComp.kt */
public final class AlbumListComp extends TplBaseComp<AlbumListModel, AlbumListViewModel> implements IClear {
    private final Lazy albumsAdapter$delegate;
    private View cardWrapper;
    private HeaderComp headerComp;
    /* access modifiers changed from: private */
    public final Function1<MusicAlbum, Unit> onAlbumCoverClick = new AlbumListComp$onAlbumCoverClick$1(this);
    private Function1<? super MusicAlbum, Unit> onAlbumCoverClickListener;
    /* access modifiers changed from: private */
    public final Function0<Unit> onCreateAlbumClick = new AlbumListComp$onCreateAlbumClick$1(this);
    /* access modifiers changed from: private */
    public final Function1<MusicAlbum, Unit> onItemClick = new AlbumListComp$onItemClick$1(this);
    /* access modifiers changed from: private */
    public final RecyclerView recyclerView;
    private final Lazy slideExtStatCallback$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumListComp(LifecycleOwner lifecycleOwner, View itemView) {
        super(lifecycleOwner, itemView);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = getView().findViewById(R.id.search_music_header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.search_music_header");
        this.headerComp = new HeaderComp(lifecycleOwner, findViewById);
        LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.search_music_card_wrapper);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "view.search_music_card_wrapper");
        this.cardWrapper = linearLayout;
        this.recyclerView = (RecyclerView) getView().findViewById(R.id.search_music_rv);
        this.albumsAdapter$delegate = LazyKt.lazy(new AlbumListComp$albumsAdapter$2(this));
        this.slideExtStatCallback$delegate = LazyKt.lazy(new AlbumListComp$slideExtStatCallback$2(this));
    }

    public final Function1<MusicAlbum, Unit> getOnAlbumCoverClickListener() {
        return this.onAlbumCoverClickListener;
    }

    public final void setOnAlbumCoverClickListener(Function1<? super MusicAlbum, Unit> function1) {
        this.onAlbumCoverClickListener = function1;
    }

    public HeaderComp getHeaderComp() {
        return this.headerComp;
    }

    public void setHeaderComp(HeaderComp headerComp2) {
        this.headerComp = headerComp2;
    }

    public View getCardWrapper() {
        return this.cardWrapper;
    }

    public void setCardWrapper(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.cardWrapper = view2;
    }

    private final AlbumsAdapter getAlbumsAdapter() {
        return (AlbumsAdapter) this.albumsAdapter$delegate.getValue();
    }

    private final ISlideExtStatCallback getSlideExtStatCallback() {
        return (ISlideExtStatCallback) this.slideExtStatCallback$delegate.getValue();
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        getAlbumsAdapter().setNightMode(isNightMode);
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public AlbumListViewModel onCreateViewModel() {
        return new AlbumListViewModel();
    }

    public void onBindViewModel(AlbumListViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindInitRV(viewModel, owner);
        bindData(viewModel, owner);
        bindHisAlbumClick(viewModel, owner);
        bindStyle(viewModel, owner);
    }

    private final void bindInitRV(AlbumListViewModel viewModel, LifecycleOwner owner) {
        viewModel.getNeedInitRv().observe(owner, new AlbumListComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindInitRV$lambda-1  reason: not valid java name */
    public static final void m1091bindInitRV$lambda1(AlbumListComp this$0, Pair initRv) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (initRv != null) {
            Pair $this$bindInitRV_u24lambda_u2d1_u24lambda_u2d0 = initRv;
            if (((Boolean) $this$bindInitRV_u24lambda_u2d1_u24lambda_u2d0.getFirst()).booleanValue()) {
                this$0.initRecyclerView((AlbumListTplStyle) $this$bindInitRV_u24lambda_u2d1_u24lambda_u2d0.getSecond());
            }
        }
    }

    private final void bindData(AlbumListViewModel viewModel, LifecycleOwner owner) {
        viewModel.getData().observe(owner, new AlbumListComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-3  reason: not valid java name */
    public static final void m1089bindData$lambda3(AlbumListComp this$0, List data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (data != null) {
            this$0.getAlbumsAdapter().setData(data);
        }
    }

    private final void bindHisAlbumClick(AlbumListViewModel viewModel, LifecycleOwner owner) {
        viewModel.getHeader().observe(owner, new AlbumListComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindHisAlbumClick$lambda-5  reason: not valid java name */
    public static final void m1090bindHisAlbumClick$lambda5(AlbumListComp this$0, HeaderModel it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (TplAction action : it.getHead().getActions()) {
            if (action instanceof LoadSchemeAction) {
                AlbumsAdapter albumsAdapter = this$0.getAlbumsAdapter();
                HeaderComp headerComp2 = this$0.getHeaderComp();
                albumsAdapter.setActionHandler(headerComp2 != null ? headerComp2.getActionHandler() : null);
                this$0.getAlbumsAdapter().setAction((LoadSchemeAction) action);
            }
        }
    }

    private final void bindStyle(AlbumListViewModel viewModel, LifecycleOwner owner) {
        viewModel.getStyle().observe(owner, new AlbumListComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindStyle$lambda-7  reason: not valid java name */
    public static final void m1092bindStyle$lambda7(AlbumListComp this$0, AlbumListTplStyle style) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (style != null) {
            this$0.getAlbumsAdapter().setStyle(style);
        }
    }

    private final void initRecyclerView(AlbumListTplStyle style) {
        RecyclerView.LayoutManager layoutManager;
        int paddingEnd = 0;
        RecyclerView recyclerView2 = this.recyclerView;
        if (!style.getSupportHorizontalSlip() || style.getParams().getColumn() > 0) {
            if (style.getSupportHorizontalSlip()) {
                paddingEnd = (int) (((float) (DeviceUtils.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext()) - (ViewExKt.getDp(9.0f) * 2))) * 0.042f);
            }
            layoutManager = new GridLayoutManager(getContext(), Math.max(Math.min(style.getParams().getColumn(), 2), 1), 1, false);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
            LinearLayoutManager $this$initRecyclerView_u24lambda_u2d9 = linearLayoutManager;
            if (this.recyclerView.getOnFlingListener() == null) {
                AlbumStartPagerSnapHelper $this$initRecyclerView_u24lambda_u2d9_u24lambda_u2d8 = new AlbumStartPagerSnapHelper($this$initRecyclerView_u24lambda_u2d9);
                $this$initRecyclerView_u24lambda_u2d9_u24lambda_u2d8.setSlideExtStateCallback(getSlideExtStatCallback());
                $this$initRecyclerView_u24lambda_u2d9_u24lambda_u2d8.attachToRecyclerView(this.recyclerView);
            }
            layoutManager = linearLayoutManager;
        }
        recyclerView2.setLayoutManager(layoutManager);
        this.recyclerView.setPaddingRelative(0, 0, paddingEnd, 0);
    }

    public void clear() {
        getAlbumsAdapter().clear();
        this.onAlbumCoverClickListener = null;
    }
}
