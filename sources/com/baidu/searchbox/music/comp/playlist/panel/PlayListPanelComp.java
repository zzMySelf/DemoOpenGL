package com.baidu.searchbox.music.comp.playlist.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.music.MusicManager;
import com.baidu.searchbox.music.MusicPlayCallback;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.PlaylistCallback;
import com.baidu.searchbox.music.R;
import com.baidu.searchbox.music.adapter.HisPlayDataManager;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.music.comp.playlist.favorlist.FavorListComp;
import com.baidu.searchbox.music.comp.playlist.favorlist.FavorListViewModel;
import com.baidu.searchbox.music.comp.playlist.hislist.HisListComp;
import com.baidu.searchbox.music.comp.playlist.hislist.HisListViewModel;
import com.baidu.searchbox.music.comp.playlist.playinglist.PlayingListComp;
import com.baidu.searchbox.music.db.MusicPlayHistoryDBControl;
import com.baidu.searchbox.music.ext.album.collectionpanel.MusicCollectionPanelComp;
import com.baidu.searchbox.music.ext.favor.PersonalCenterFavorNavComp;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import com.baidu.searchbox.music.ext.statistic.StatExtKt;
import com.baidu.searchbox.music.utils.MusicAnimationUtils;
import com.baidu.searchbox.music.utils.MusicLoginUtils;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.viewpager.DrawablePageIndicator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u001e\u0010*\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010-\u001a\u00020(2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010/H\u0002J\u0016\u00100\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020(0/H\u0003J\b\u00101\u001a\u00020(H\u0003J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u00020(H\u0002J\u0018\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020(H\u0016J\b\u0010<\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u000206H\u0002J\u0010\u0010I\u001a\u00020(2\u0006\u0010J\u001a\u00020CH\u0002J\u0010\u0010K\u001a\u00020(2\u0006\u00107\u001a\u000204H\u0002J\u0012\u0010L\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u000104H\u0002J\u0010\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020(H\u0002J\b\u0010Q\u001a\u00020(H\u0002J\b\u0010R\u001a\u00020(H\u0002J\b\u0010S\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u001c*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010&0&0%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/baidu/searchbox/music/comp/playlist/panel/PlayListPanelComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/music/comp/playlist/panel/PlayListPanelViewModel;", "Lcom/baidu/searchbox/music/MusicPlayCallback;", "Lcom/baidu/searchbox/music/PlaylistCallback;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "anchorView", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "collectPanel", "Lcom/baidu/searchbox/music/ext/album/collectionpanel/MusicCollectionPanelComp;", "getCollectPanel", "()Lcom/baidu/searchbox/music/ext/album/collectionpanel/MusicCollectionPanelComp;", "collectPanel$delegate", "Lkotlin/Lazy;", "favorComp", "Lcom/baidu/searchbox/music/comp/playlist/favorlist/FavorListComp;", "favorNavComp", "Lcom/baidu/searchbox/music/ext/favor/PersonalCenterFavorNavComp;", "hisComp", "Lcom/baidu/searchbox/music/comp/playlist/hislist/HisListComp;", "panelEnterAni", "Landroid/animation/AnimatorSet;", "panelExitAni", "panelToken", "kotlin.jvm.PlatformType", "playingComp", "Lcom/baidu/searchbox/music/comp/playlist/playinglist/PlayingListComp;", "popupWindow", "Lcom/baidu/android/ext/widget/PopupWindow;", "getPopupWindow", "()Lcom/baidu/android/ext/widget/PopupWindow;", "popupWindow$delegate", "tabViewList", "", "Landroid/widget/TextView;", "bindPanelAnchorTab", "", "viewModel", "collectSongList", "songList", "Lcom/baidu/searchbox/music/ext/model/ISong;", "dismissPanel", "finishCallback", "Lkotlin/Function0;", "doCloseAnimation", "doEnterAnimation", "doPageSwitch", "type", "Lcom/baidu/searchbox/music/comp/playlist/panel/TabType;", "getStatSourceBy", "", "tabType", "initVP", "onBindViewModel", "vm", "onCreate", "onCreateViewModel", "onDestroy", "onNightModeChange", "isNightMode", "", "onPlayModeChange", "mode", "", "onPlayStateChange", "state", "Lcom/baidu/searchbox/music/MusicPlayState;", "onStatClick", "value", "onStatPageShow", "pageIndex", "onStatPanelListClickShow", "onStatPanelListScrollShow", "onTabClick", "tag", "", "refreshPanelListData", "resetPanelAnchor", "showOrDismiss", "showPanel", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayListPanelComp.kt */
public final class PlayListPanelComp extends BaseExtSlaveComponent<PlayListPanelViewModel> implements MusicPlayCallback, PlaylistCallback {
    /* access modifiers changed from: private */
    public final View anchorView;
    private final Lazy collectPanel$delegate;
    private final FavorListComp favorComp;
    private final PersonalCenterFavorNavComp favorNavComp;
    /* access modifiers changed from: private */
    public final HisListComp hisComp;
    private AnimatorSet panelEnterAni;
    private AnimatorSet panelExitAni;
    private final UniqueId panelToken;
    private final PlayingListComp playingComp;
    private final Lazy popupWindow$delegate = LazyKt.lazy(new PlayListPanelComp$popupWindow$2(this));
    private final List<TextView> tabViewList;
    /* access modifiers changed from: private */
    public final UniqueId token;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlayListPanelComp.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TabType.values().length];
            iArr[TabType.HIS_LIST.ordinal()] = 1;
            iArr[TabType.FAVOR_LIST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onBufferingUpdate(int percent) {
        MusicPlayCallback.DefaultImpls.onBufferingUpdate(this, percent);
    }

    public void onExit() {
        MusicPlayCallback.DefaultImpls.onExit(this);
    }

    public void onNext() {
        MusicPlayCallback.DefaultImpls.onNext(this);
    }

    public void onPlayError(int code) {
        MusicPlayCallback.DefaultImpls.onPlayError(this, code);
    }

    public void onPlayProgressChange(int percent, long progress) {
        MusicPlayCallback.DefaultImpls.onPlayProgressChange(this, percent, progress);
    }

    public void onPlaySongChange(Song song) {
        MusicPlayCallback.DefaultImpls.onPlaySongChange(this, song);
    }

    public void onPlaylistChange(List<? extends Song> songList) {
        PlaylistCallback.DefaultImpls.onPlaylistChange(this, songList);
    }

    public void onPlaylistSourceChange(int source) {
        PlaylistCallback.DefaultImpls.onPlaylistSourceChange(this, source);
    }

    public void onPrevious() {
        MusicPlayCallback.DefaultImpls.onPrevious(this);
    }

    public void onSeekComplete() {
        MusicPlayCallback.DefaultImpls.onSeekComplete(this);
    }

    public void onSeekStart() {
        MusicPlayCallback.DefaultImpls.onSeekStart(this);
    }

    public void onSongDurationUpdate(long duration) {
        MusicPlayCallback.DefaultImpls.onSongDurationUpdate(this, duration);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayListPanelComp(LifecycleOwner owner, View anchorView2, UniqueId token2) {
        super(owner, LayoutInflater.from(anchorView2.getContext()).inflate(R.layout.play_list_panel_layout, (ViewGroup) null), true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(anchorView2, "anchorView");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.anchorView = anchorView2;
        this.token = token2;
        UniqueId gen = UniqueId.gen("PlayListPanelComp");
        this.panelToken = gen;
        TextView textView = (TextView) getView().findViewById(R.id.tvHisList);
        TextView $this$tabViewList_u24lambda_u2d1 = textView;
        Intrinsics.checkNotNullExpressionValue($this$tabViewList_u24lambda_u2d1, "");
        TextView unused = PlayListPanelCompKt.bindTag($this$tabViewList_u24lambda_u2d1, TabType.HIS_LIST);
        $this$tabViewList_u24lambda_u2d1.setOnClickListener(new PlayListPanelComp$$ExternalSyntheticLambda1(this, $this$tabViewList_u24lambda_u2d1));
        Unit unit = Unit.INSTANCE;
        TextView textView2 = (TextView) getView().findViewById(R.id.tvPlayList);
        TextView $this$tabViewList_u24lambda_u2d3 = textView2;
        Intrinsics.checkNotNullExpressionValue($this$tabViewList_u24lambda_u2d3, "");
        TextView unused2 = PlayListPanelCompKt.bindTag($this$tabViewList_u24lambda_u2d3, TabType.PLAY_LIST);
        $this$tabViewList_u24lambda_u2d3.setOnClickListener(new PlayListPanelComp$$ExternalSyntheticLambda2(this, $this$tabViewList_u24lambda_u2d3));
        Unit unit2 = Unit.INSTANCE;
        TextView textView3 = (TextView) getView().findViewById(R.id.tvFavorList);
        TextView $this$tabViewList_u24lambda_u2d5 = textView3;
        Intrinsics.checkNotNullExpressionValue($this$tabViewList_u24lambda_u2d5, "");
        TextView unused3 = PlayListPanelCompKt.bindTag($this$tabViewList_u24lambda_u2d5, TabType.FAVOR_LIST);
        $this$tabViewList_u24lambda_u2d5.setOnClickListener(new PlayListPanelComp$$ExternalSyntheticLambda3(this, $this$tabViewList_u24lambda_u2d5));
        Unit unit3 = Unit.INSTANCE;
        this.tabViewList = CollectionsKt.listOf(textView, textView2, textView3);
        this.collectPanel$delegate = LazyKt.lazy(new PlayListPanelComp$collectPanel$2(owner, this));
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.search_music_playlist_rv, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…_music_playlist_rv, null)");
        HisListComp hisListComp = new HisListComp(owner, inflate, token2);
        HisListComp $this$hisComp_u24lambda_u2d6 = hisListComp;
        add($this$hisComp_u24lambda_u2d6);
        $this$hisComp_u24lambda_u2d6.setListEmptyCallback(new PlayListPanelComp$hisComp$1$1(this));
        $this$hisComp_u24lambda_u2d6.setPlayCallback(new PlayListPanelComp$hisComp$1$2(this));
        MusicPlayHistoryDBControl.getInstance().updateTable();
        this.hisComp = hisListComp;
        FavorListComp favorListComp = new FavorListComp(owner, LayoutInflater.from(getContext()).inflate(R.layout.music_playlist_favor_list, (ViewGroup) null), token2);
        FavorListComp $this$favorComp_u24lambda_u2d7 = favorListComp;
        add($this$favorComp_u24lambda_u2d7);
        $this$favorComp_u24lambda_u2d7.setPlayByClickListener(new PlayListPanelComp$favorComp$1$1(this));
        this.favorComp = favorListComp;
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.music_playpanel_playing_list, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(context).inflate(R.…panel_playing_list, null)");
        Intrinsics.checkNotNullExpressionValue(gen, "panelToken");
        PlayingListComp playingListComp = new PlayingListComp(owner, inflate2, token2, gen);
        PlayingListComp $this$playingComp_u24lambda_u2d8 = playingListComp;
        add($this$playingComp_u24lambda_u2d8);
        $this$playingComp_u24lambda_u2d8.setListEmptyCallback(new PlayListPanelComp$playingComp$1$1(this));
        $this$playingComp_u24lambda_u2d8.setListCollectCallback(new PlayListPanelComp$playingComp$1$2(this));
        this.playingComp = playingListComp;
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        ViewStub viewStub = (ViewStub) getView().findViewById(R.id.search_music_favor_nav);
        Intrinsics.checkNotNullExpressionValue(viewStub, "view.search_music_favor_nav");
        Intrinsics.checkNotNullExpressionValue(gen, "panelToken");
        PersonalCenterFavorNavComp $this$favorNavComp_u24lambda_u2d9 = new PersonalCenterFavorNavComp(lifecycleOwner, viewStub, gen);
        add($this$favorNavComp_u24lambda_u2d9);
        this.favorNavComp = $this$favorNavComp_u24lambda_u2d9;
        initVP();
        ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) getView().findViewById(R.id.panelLayout)).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) (((float) DeviceUtils.ScreenInfo.getDisplayHeight(getContext())) * 0.7f);
        }
        anchorView2.setOnClickListener(new PlayListPanelComp$$ExternalSyntheticLambda4(this));
        getView().findViewById(R.id.viewBgMask).setOnClickListener(new PlayListPanelComp$$ExternalSyntheticLambda5(this));
        ((TextView) getView().findViewById(R.id.tvClose)).setOnClickListener(new PlayListPanelComp$$ExternalSyntheticLambda6(this));
        onNightModeChange(NightModeHelper.getNightModeSwitcherState());
        ((PlayListPanelViewModel) getViewModel()).setToken(token2);
        HisPlayDataManager.INSTANCE.setHisDataUpdateListener(new Function0<Unit>(this) {
            final /* synthetic */ PlayListPanelComp this$0;

            {
                this.this$0 = r2;
            }

            public final void invoke() {
                ViewModel viewModel = this.this$0.hisComp.getViewModel();
                Intrinsics.checkNotNullExpressionValue(viewModel, "hisComp.viewModel");
                HisListViewModel.loadData$default((HisListViewModel) viewModel, false, 1, (Object) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: tabViewList$lambda-1$lambda-0  reason: not valid java name */
    public static final void m669tabViewList$lambda1$lambda0(PlayListPanelComp this$0, TextView $this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = $this_apply.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "tag");
        this$0.onTabClick(tag);
    }

    /* access modifiers changed from: private */
    /* renamed from: tabViewList$lambda-3$lambda-2  reason: not valid java name */
    public static final void m670tabViewList$lambda3$lambda2(PlayListPanelComp this$0, TextView $this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = $this_apply.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "tag");
        this$0.onTabClick(tag);
    }

    /* access modifiers changed from: private */
    /* renamed from: tabViewList$lambda-5$lambda-4  reason: not valid java name */
    public static final void m671tabViewList$lambda5$lambda4(PlayListPanelComp this$0, TextView $this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = $this_apply.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "tag");
        this$0.onTabClick(tag);
    }

    /* access modifiers changed from: private */
    public final PopupWindow getPopupWindow() {
        return (PopupWindow) this.popupWindow$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MusicCollectionPanelComp getCollectPanel() {
        return (MusicCollectionPanelComp) this.collectPanel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-10  reason: not valid java name */
    public static final void m665_init_$lambda10(PlayListPanelComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showOrDismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-11  reason: not valid java name */
    public static final void m666_init_$lambda11(PlayListPanelComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dismissPanel$default(this$0, (Function0) null, 1, (Object) null);
        this$0.onStatClick(MusicExtStats.VALUE_PLAY_PANEL_CLOSE_OTHER);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-12  reason: not valid java name */
    public static final void m667_init_$lambda12(PlayListPanelComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dismissPanel$default(this$0, (Function0) null, 1, (Object) null);
        this$0.onStatClick("close_button");
    }

    private final void initVP() {
        ((ViewPager) getView().findViewById(R.id.vpPlayListPanel)).setAdapter(new PanelPagerAdapter(CollectionsKt.listOf(this.hisComp.getView(), this.playingComp.getView(), this.favorComp.getView())));
        DrawablePageIndicator $this$initVP_u24lambda_u2d13 = new DrawablePageIndicator(getContext());
        $this$initVP_u24lambda_u2d13.setViewPager((ViewPager) getView().findViewById(R.id.vpPlayListPanel));
        $this$initVP_u24lambda_u2d13.setUseStandardStyle(false);
        $this$initVP_u24lambda_u2d13.setIndicatorDrawable(ResWrapper.getDrawable($this$initVP_u24lambda_u2d13.getContext(), R.drawable.play_panel_indicator_bg));
        $this$initVP_u24lambda_u2d13.setIndicatorWidth(0.15f);
        $this$initVP_u24lambda_u2d13.setIndicatorHeight(ViewExKt.getDpF(4.0f));
        ((FrameLayout) getView().findViewById(R.id.flIndicatorContainer)).addView($this$initVP_u24lambda_u2d13, new FrameLayout.LayoutParams(-1, -1));
        ((ViewPager) getView().findViewById(R.id.vpPlayListPanel)).addOnPageChangeListener(new PlayListPanelComp$initVP$2(this));
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        ResWrapper.setBackgroundColor((FrameLayout) getView().findViewById(R.id.flIndicatorContainer), com.baidu.android.common.ui.style.R.color.GC10);
        ResWrapper.setBackgroundColor(getView().findViewById(R.id.viewIndicatorDivider), com.baidu.android.common.ui.style.R.color.GC37);
        ResWrapper.setBackgroundColor(getView().findViewById(R.id.viewCloseDivider), com.baidu.android.common.ui.style.R.color.GC37);
        ResWrapper.setBackground((ConstraintLayout) getView().findViewById(R.id.panelLayout), R.drawable.music_play_list_panel_bg);
        ResWrapper.setTextColor((TextView) getView().findViewById(R.id.tvClose), com.baidu.android.common.ui.style.R.color.GC1);
        ResWrapper.setBackgroundColor(getView().findViewById(R.id.viewBgMask), R.color.GC11);
    }

    public void onPlayModeChange(int mode) {
        this.playingComp.onPlayModeChange(mode);
    }

    public void onPlayStateChange(MusicPlayState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        MusicPlayCallback.DefaultImpls.onPlayStateChange(this, state);
        this.playingComp.update();
    }

    public void onCreate() {
        super.onCreate();
        MusicManager $this$onCreate_u24lambda_u2d14 = MusicManager.Companion.get();
        onPlayStateChange($this$onCreate_u24lambda_u2d14.getPlayStatus());
        onPlayModeChange($this$onCreate_u24lambda_u2d14.getPlaylistController().getPlayMode());
        $this$onCreate_u24lambda_u2d14.getPlaylistController().addPlaylistCallback(this);
        $this$onCreate_u24lambda_u2d14.addPlayCallback(this);
        getView().setAlpha(1.0f);
    }

    public PlayListPanelViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(PlayListPanelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(PlayListPanelViewModel::class.java)");
        return (PlayListPanelViewModel) viewModel;
    }

    public void onBindViewModel(PlayListPanelViewModel vm, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(owner, "owner");
        bindPanelAnchorTab(vm);
    }

    private final void bindPanelAnchorTab(PlayListPanelViewModel viewModel) {
        viewModel.getAnchorTab().observe(getLifecycleOwner(), new PlayListPanelComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindPanelAnchorTab$lambda-15  reason: not valid java name */
    public static final void m668bindPanelAnchorTab$lambda15(PlayListPanelComp this$0, TabType type) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(type, "type");
        this$0.doPageSwitch(type);
    }

    private final void onTabClick(Object tag) {
        TabType $this$onTabClick_u24lambda_u2d16 = tag instanceof TabType ? (TabType) tag : null;
        if ($this$onTabClick_u24lambda_u2d16 != null) {
            doPageSwitch($this$onTabClick_u24lambda_u2d16);
            onStatPanelListClickShow($this$onTabClick_u24lambda_u2d16);
        }
    }

    private final void doPageSwitch(TabType type) {
        TabType $this$doPageSwitch_u24lambda_u2d18 = type;
        for (TextView tv : this.tabViewList) {
            Object tag = tv.getTag();
            boolean isSel = (tag instanceof TabType ? (TabType) tag : null) == $this$doPageSwitch_u24lambda_u2d18;
            ResWrapper.setTextColor(tv, isSel ? com.baidu.android.common.ui.style.R.color.GC1 : com.baidu.android.common.ui.style.R.color.GC4);
            tv.setTypeface(isSel ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        }
        ((ViewPager) getView().findViewById(R.id.vpPlayListPanel)).setCurrentItem($this$doPageSwitch_u24lambda_u2d18.getPosition());
    }

    private final void showOrDismiss() {
        if (getPopupWindow().isShowing()) {
            dismissPanel$default(this, (Function0) null, 1, (Object) null);
            return;
        }
        showPanel();
        refreshPanelListData();
        resetPanelAnchor();
    }

    private final void refreshPanelListData() {
        this.playingComp.reset();
        this.hisComp.reset();
        this.favorComp.reset();
    }

    private final void resetPanelAnchor() {
        doPageSwitch(TabType.PLAY_LIST);
        StatExtKt.onShowEvent(this.token, MusicExtStats.PAGE_PLAY_PANEL, "pageshow", "playlist");
    }

    private final void onStatPanelListClickShow(TabType tabType) {
        StatExtKt.onShowEvent(this.token, MusicExtStats.PAGE_PLAY_PANEL, MusicExtStats.VALUE_PLAY_PANEL_CLICK_SHOW, getStatSourceBy(tabType));
    }

    /* access modifiers changed from: private */
    public final void onStatPanelListScrollShow(TabType tabType) {
        if (tabType != null) {
            StatExtKt.onShowEvent(this.token, MusicExtStats.PAGE_PLAY_PANEL, MusicExtStats.VALUE_PLAY_PANEL_SWITCH_SHOW, getStatSourceBy(tabType));
        }
    }

    /* access modifiers changed from: private */
    public final void onStatPageShow(int pageIndex) {
        boolean z = true;
        ((HisListViewModel) this.hisComp.getViewModel()).onPageShow(TabType.HIS_LIST.getPosition() == pageIndex);
        FavorListViewModel favorListViewModel = (FavorListViewModel) this.favorComp.getViewModel();
        if (TabType.FAVOR_LIST.getPosition() != pageIndex) {
            z = false;
        }
        favorListViewModel.onPageShow(z);
    }

    static /* synthetic */ void dismissPanel$default(PlayListPanelComp playListPanelComp, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function0 = null;
        }
        playListPanelComp.dismissPanel(function0);
    }

    /* access modifiers changed from: private */
    public final void dismissPanel(Function0<Unit> finishCallback) {
        AnimatorSet animatorSet = this.panelEnterAni;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        doCloseAnimation(new PlayListPanelComp$dismissPanel$1(this, finishCallback));
    }

    private final void showPanel() {
        AnimatorSet animatorSet = this.panelExitAni;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        doEnterAnimation();
        getPopupWindow().showAtLocation(this.anchorView, 80, 0, 0);
    }

    private final void doCloseAnimation(Function0<Unit> finishCallback) {
        ObjectAnimator panelAni = MusicAnimationUtils.getPlaylistPanelOutTanslateAnimation((ConstraintLayout) getView().findViewById(R.id.panelLayout));
        ObjectAnimator bgAlphaAni = MusicAnimationUtils.getPlaylistBgOutAlphaAnimation(getView().findViewById(R.id.viewBgMask));
        panelAni.addListener(new PlayListPanelComp$doCloseAnimation$1(finishCallback));
        AnimatorSet animatorSet = this.panelExitAni;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        AnimatorSet $this$doCloseAnimation_u24lambda_u2d19 = animatorSet2;
        $this$doCloseAnimation_u24lambda_u2d19.playTogether(new Animator[]{panelAni, bgAlphaAni});
        $this$doCloseAnimation_u24lambda_u2d19.start();
        this.panelExitAni = animatorSet2;
    }

    private final void doEnterAnimation() {
        AnimatorSet animatorSet = this.panelEnterAni;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ObjectAnimator alphaAni = MusicAnimationUtils.getPlaylistBgEnterAlphaAnimation(getView().findViewById(R.id.viewBgMask));
        ObjectAnimator panelAni = MusicAnimationUtils.getPlaylistPanelEnterTanslateAnimation((ConstraintLayout) getView().findViewById(R.id.panelLayout));
        AnimatorSet animatorSet2 = new AnimatorSet();
        AnimatorSet $this$doEnterAnimation_u24lambda_u2d20 = animatorSet2;
        $this$doEnterAnimation_u24lambda_u2d20.playTogether(new Animator[]{alphaAni, panelAni});
        $this$doEnterAnimation_u24lambda_u2d20.start();
        this.panelEnterAni = animatorSet2;
    }

    /* access modifiers changed from: private */
    public final void collectSongList(List<? extends ISong> songList, View anchorView2) {
        MusicLoginUtils.funcWithLogin(getContext(), new PlayListPanelComp$collectSongList$1(this, songList, anchorView2));
    }

    private final void onStatClick(String value) {
        TabType tabType = ((PlayListPanelViewModel) getViewModel()).getAnchorTab().getValue();
        if (tabType != null) {
            StatExtKt.onClickEvent(this.token, MusicExtStats.PAGE_PLAY_PANEL, value, getStatSourceBy(tabType));
        }
    }

    private final String getStatSourceBy(TabType tabType) {
        switch (WhenMappings.$EnumSwitchMapping$0[tabType.ordinal()]) {
            case 1:
                return "historylist";
            case 2:
                return "likelist";
            default:
                return "playlist";
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AnimatorSet animatorSet = this.panelEnterAni;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.panelExitAni;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        getPopupWindow().dismiss();
        HisPlayDataManager.INSTANCE.setHisDataUpdateListener((Function0<Unit>) null);
        MusicManager $this$onDestroy_u24lambda_u2d21 = MusicManager.Companion.get();
        $this$onDestroy_u24lambda_u2d21.removePlayCallback(this);
        $this$onDestroy_u24lambda_u2d21.getPlaylistController().removePlaylistCallback(this);
    }
}
