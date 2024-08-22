package com.baidu.searchbox.music.ext.album.detail.artist;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.collectionpanel.MusicCollectListener;
import com.baidu.searchbox.music.ext.album.collectionpanel.MusicCollectionPanelComp;
import com.baidu.searchbox.music.ext.album.collectionpanel.MusicCollectionPanelViewModel;
import com.baidu.searchbox.music.ext.album.detail.base.DetailComp;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.artist.ArtistSongListComp;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.base.SongListComp;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.base.SongListViewModel;
import com.baidu.searchbox.music.ext.album.model.SingerPageData;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import com.baidu.searchbox.nacomp.fsm.StateMachine;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\fH\u0014J\u001c\u0010\u000e\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u000fH\u0014J \u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001e\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0002H\u0014J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/detail/artist/ArtistDetailComp;", "Lcom/baidu/searchbox/music/ext/album/detail/base/DetailComp;", "Lcom/baidu/searchbox/music/ext/album/model/SingerPageData;", "Lcom/baidu/searchbox/music/ext/album/detail/artist/ArtistDetailViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "detailCompView", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "buildSongListComp", "Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/base/SongListComp;", "Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/base/SongListViewModel;", "buildStateMachine", "Lcom/baidu/searchbox/nacomp/fsm/StateMachine;", "collectAllSongs", "", "excludes", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "listener", "Lcom/baidu/searchbox/music/ext/album/collectionpanel/MusicCollectListener;", "collectSongList", "list", "getStatPage", "", "isSupportSongEdit", "", "onCollectSong", "model", "onCreateViewModel", "setDataProvider", "provider", "Lcom/baidu/searchbox/music/ext/album/detail/artist/IArtistProvider;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ArtistDetailComp.kt */
public final class ArtistDetailComp extends DetailComp<SingerPageData, ArtistDetailViewModel> {
    private final View detailCompView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArtistDetailComp(LifecycleOwner owner, View detailCompView2, UniqueId token) {
        super(owner, detailCompView2, token);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(detailCompView2, "detailCompView");
        Intrinsics.checkNotNullParameter(token, "token");
        this.detailCompView = detailCompView2;
    }

    public final void setDataProvider(IArtistProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        ((ArtistDetailViewModel) getViewModel()).setArtistProvider(provider);
    }

    public ArtistDetailViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(ArtistDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(ArtistDetailViewModel::class.java)");
        return (ArtistDetailViewModel) viewModel;
    }

    /* access modifiers changed from: protected */
    public StateMachine<? extends DetailComp<SingerPageData, ArtistDetailViewModel>> buildStateMachine() {
        return new StateMachine<>(this);
    }

    /* access modifiers changed from: protected */
    public SongListComp<SingerPageData, ? extends SongListViewModel<SingerPageData>> buildSongListComp() {
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        View findViewById = getView().findViewById(R.id.comp_song_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.comp_song_list");
        UniqueId token = getToken();
        Intrinsics.checkNotNullExpressionValue(token, "token");
        return new ArtistSongListComp(lifecycleOwner, findViewById, token);
    }

    public void collectSongList(List<ISong> list, MusicCollectListener listener) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MusicCollectionPanelComp $this$collectSongList_u24lambda_u2d1 = this.collectionPanelComp;
        if ($this$collectSongList_u24lambda_u2d1 != null) {
            MusicCollectionPanelViewModel musicCollectionPanelViewModel = (MusicCollectionPanelViewModel) $this$collectSongList_u24lambda_u2d1.getViewModel();
            if (musicCollectionPanelViewModel != null) {
                musicCollectionPanelViewModel.setCollectListener(listener);
            }
            IArtistProvider $this$collectSongList_u24lambda_u2d1_u24lambda_u2d0 = ((ArtistDetailViewModel) getViewModel()).getArtistProvider();
            if ($this$collectSongList_u24lambda_u2d1_u24lambda_u2d0 != null) {
                $this$collectSongList_u24lambda_u2d1.preCollectSingerSongList($this$collectSongList_u24lambda_u2d1_u24lambda_u2d0.getSinger(), list, this.detailCompView);
            }
        }
    }

    public void collectAllSongs(List<ISong> excludes, MusicCollectListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MusicCollectionPanelComp $this$collectAllSongs_u24lambda_u2d3 = this.collectionPanelComp;
        if ($this$collectAllSongs_u24lambda_u2d3 != null) {
            MusicCollectionPanelViewModel musicCollectionPanelViewModel = (MusicCollectionPanelViewModel) $this$collectAllSongs_u24lambda_u2d3.getViewModel();
            if (musicCollectionPanelViewModel != null) {
                musicCollectionPanelViewModel.setCollectListener(listener);
            }
            IArtistProvider $this$collectAllSongs_u24lambda_u2d3_u24lambda_u2d2 = ((ArtistDetailViewModel) getViewModel()).getArtistProvider();
            if ($this$collectAllSongs_u24lambda_u2d3_u24lambda_u2d2 != null) {
                $this$collectAllSongs_u24lambda_u2d3.preCollectSingerAllSongs($this$collectAllSongs_u24lambda_u2d3_u24lambda_u2d2.getSinger(), excludes, this.detailCompView);
            }
        }
    }

    public boolean isSupportSongEdit() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCollectSong(SingerPageData model) {
        Intrinsics.checkNotNullParameter(model, "model");
    }

    public String getStatPage() {
        return MusicExtStats.PAGE_SINGER_DETAIL;
    }
}
