package com.baidu.searchbox.music.ext.comment.comp.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.searchbox.comment.CommentModuleManager;
import com.baidu.searchbox.comment.definition.IBDCommentInputController;
import com.baidu.searchbox.comment.definition.ICommentPresenter;
import com.baidu.searchbox.comment.definition.ICommonRecyclerView;
import com.baidu.searchbox.comment.params.CommonAttrs;
import com.baidu.searchbox.music.bean.CommentInfo;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.comment.widget.MusicCommentRV;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.scheme.MusicPlayerSchemeKt;
import com.baidu.searchbox.music.ext.statistic.MusicExtStatService;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.searchbox.toolbar.CommonToolBar;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J0\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\u000e\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/music/ext/comment/comp/comment/CommentComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "invokeType", "", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;Ljava/lang/String;)V", "backCallback", "Lkotlin/Function0;", "", "getBackCallback", "()Lkotlin/jvm/functions/Function0;", "setBackCallback", "(Lkotlin/jvm/functions/Function0;)V", "commentInputController", "Lcom/baidu/searchbox/comment/definition/IBDCommentInputController;", "commentPresenter", "Lcom/baidu/searchbox/comment/definition/ICommentPresenter;", "toolbar", "Lcom/baidu/searchbox/toolbar/CommonToolBar;", "unSupportCommentTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "createCommentToolbar", "initCommentInput", "initCommentPresenter", "song", "Lcom/baidu/searchbox/music/ext/model/ISong;", "commentInfo", "Lcom/baidu/searchbox/music/bean/CommentInfo;", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "commentView", "Lcom/baidu/searchbox/comment/definition/ICommonRecyclerView;", "onBindViewModel", "viewModel", "onCreateViewModel", "onDestroy", "onNightModeChange", "isNightMode", "", "onPause", "onResume", "setMusicCommentSong", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentComp.kt */
public final class CommentComp extends BaseExtSlaveComponent<BaseViewModel> {
    private Function0<Unit> backCallback;
    private IBDCommentInputController commentInputController;
    private ICommentPresenter commentPresenter;
    private final String invokeType;
    private final UniqueId token;
    /* access modifiers changed from: private */
    public CommonToolBar toolbar = createCommentToolbar();
    private final TextView unSupportCommentTv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentComp(LifecycleOwner owner, View view2, UniqueId token2, String invokeType2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(invokeType2, "invokeType");
        this.token = token2;
        this.invokeType = invokeType2;
        this.unSupportCommentTv = (TextView) view2.findViewById(R.id.un_support_comment_tv);
    }

    public BaseViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("MusicCommentComp", BaseViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(\"MusicComme…aseViewModel::class.java)");
        return (BaseViewModel) viewModel;
    }

    public void onBindViewModel(BaseViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    public final Function0<Unit> getBackCallback() {
        return this.backCallback;
    }

    public final void setBackCallback(Function0<Unit> function0) {
        this.backCallback = function0;
    }

    public final void setMusicCommentSong(ISong song) {
        Intrinsics.checkNotNullParameter(song, "song");
        CommentInfo $this$setMusicCommentSong_u24lambda_u2d0 = song.getComment();
        if ($this$setMusicCommentSong_u24lambda_u2d0 == null || $this$setMusicCommentSong_u24lambda_u2d0.noComment()) {
            TextView textView = this.unSupportCommentTv;
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MusicCommentRV musicCommentRV = (MusicCommentRV) getView().findViewById(R.id.music_comment_rv);
        Intrinsics.checkNotNullExpressionValue(musicCommentRV, "view.music_comment_rv");
        MusicCommentRV musicCommentRV2 = (MusicCommentRV) getView().findViewById(R.id.music_comment_rv);
        Intrinsics.checkNotNullExpressionValue(musicCommentRV2, "view\n                        .music_comment_rv");
        initCommentPresenter(song, $this$setMusicCommentSong_u24lambda_u2d0, context, musicCommentRV, musicCommentRV2);
        TextView textView2 = this.unSupportCommentTv;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    public void onPause() {
        super.onPause();
        ICommentPresenter iCommentPresenter = this.commentPresenter;
        if (iCommentPresenter != null) {
            iCommentPresenter.onPause((String) null);
        }
    }

    public void onResume() {
        super.onResume();
        ICommentPresenter iCommentPresenter = this.commentPresenter;
        if (iCommentPresenter != null) {
            iCommentPresenter.onResume();
        }
    }

    public void onDestroy() {
        ICommentPresenter iCommentPresenter = this.commentPresenter;
        if (iCommentPresenter != null) {
            iCommentPresenter.onDestroy();
        }
        IBDCommentInputController iBDCommentInputController = this.commentInputController;
        if (iBDCommentInputController != null) {
            iBDCommentInputController.release();
        }
        super.onDestroy();
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        ICommentPresenter iCommentPresenter = this.commentPresenter;
        if (iCommentPresenter != null) {
            iCommentPresenter.onNightModeChanged();
        }
        this.toolbar.updateUI();
        TextView $this$onNightModeChange_u24lambda_u2d1 = this.unSupportCommentTv;
        if ($this$onNightModeChange_u24lambda_u2d1 != null) {
            $this$onNightModeChange_u24lambda_u2d1.setBackgroundColor($this$onNightModeChange_u24lambda_u2d1.getResources().getColor(R.color.search_music_bg_a));
            $this$onNightModeChange_u24lambda_u2d1.setTextColor($this$onNightModeChange_u24lambda_u2d1.getResources().getColor(R.color.search_music_font_c));
        }
    }

    private final void initCommentPresenter(ISong song, CommentInfo commentInfo, Context context, ViewGroup rootView, ICommonRecyclerView commentView) {
        String str;
        String str2;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, 1, false);
        CommonAttrs $this$initCommentPresenter_u24lambda_u2d3 = new CommonAttrs();
        if (Intrinsics.areEqual((Object) this.invokeType, (Object) "full")) {
            str = "music_player_full";
        } else {
            StringBuilder append = new StringBuilder().append("music_");
            MusicExtStatService of = MusicExtStats.of(this.token);
            if (of == null || (str2 = of.getChannelSource()) == null) {
                str2 = "other";
            }
            str = append.append(str2).toString();
        }
        $this$initCommentPresenter_u24lambda_u2d3.source = str;
        $this$initCommentPresenter_u24lambda_u2d3.nid = commentInfo.getNid();
        $this$initCommentPresenter_u24lambda_u2d3.topicId = commentInfo.getTopicId();
        $this$initCommentPresenter_u24lambda_u2d3.topicTitle = song.getName();
        $this$initCommentPresenter_u24lambda_u2d3.iconUrl = song.getAlbumInfo().getCover();
        ICommentPresenter $this$initCommentPresenter_u24lambda_u2d3_u24lambda_u2d2 = CommentModuleManager.getCommentModule().initRecyclerCommentPresenter(context, $this$initCommentPresenter_u24lambda_u2d3, layoutManager, rootView, commentView);
        $this$initCommentPresenter_u24lambda_u2d3_u24lambda_u2d2.setCommentCallback(new CommentComp$initCommentPresenter$1$1$1(song));
        this.commentPresenter = $this$initCommentPresenter_u24lambda_u2d3_u24lambda_u2d2;
        initCommentInput();
        ICommentPresenter iCommentPresenter = this.commentPresenter;
        if (iCommentPresenter != null) {
            iCommentPresenter.onNightModeChanged();
        }
    }

    private final void initCommentInput() {
        IBDCommentInputController commentInputController2 = CommentModuleManager.getCommentModule().getCommentInputController();
        if (commentInputController2 != null) {
            IBDCommentInputController $this$initCommentInput_u24lambda_u2d4 = commentInputController2;
            ICommentPresenter iCommentPresenter = this.commentPresenter;
            if (iCommentPresenter != null) {
                iCommentPresenter.setCommentInputController($this$initCommentInput_u24lambda_u2d4);
            }
        } else {
            commentInputController2 = null;
        }
        this.commentInputController = commentInputController2;
        ICommentPresenter iCommentPresenter2 = this.commentPresenter;
        if (iCommentPresenter2 != null) {
            iCommentPresenter2.setCommentBarProxy(new CommentComp$initCommentInput$2(this));
        }
    }

    private final CommonToolBar createCommentToolbar() {
        ArrayList itemList = new ArrayList();
        ArrayList $this$createCommentToolbar_u24lambda_u2d5 = itemList;
        $this$createCommentToolbar_u24lambda_u2d5.add(new BaseToolBarItem(1));
        $this$createCommentToolbar_u24lambda_u2d5.add(new BaseToolBarItem(10));
        CommonToolBar commonToolBar = new CommonToolBar(getContext(), itemList, CommonToolBar.ToolbarMode.NORMAL);
        CommonToolBar $this$createCommentToolbar_u24lambda_u2d7 = commonToolBar;
        $this$createCommentToolbar_u24lambda_u2d7.setStatisticSource(MusicPlayerSchemeKt.MODULE_NAME);
        FrameLayout frameLayout = (FrameLayout) getView().findViewById(R.id.music_comment_toolbar_root);
        if (frameLayout != null) {
            frameLayout.addView($this$createCommentToolbar_u24lambda_u2d7);
        }
        $this$createCommentToolbar_u24lambda_u2d7.setItemClickListener(new CommentComp$$ExternalSyntheticLambda0(this));
        return commonToolBar;
    }

    /* access modifiers changed from: private */
    /* renamed from: createCommentToolbar$lambda-7$lambda-6  reason: not valid java name */
    public static final boolean m1001createCommentToolbar$lambda7$lambda6(CommentComp this$0, View view2, BaseToolBarItem item) {
        ICommentPresenter iCommentPresenter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer valueOf = item != null ? Integer.valueOf(item.getItemId()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            Function0<Unit> function0 = this$0.backCallback;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (!(valueOf == null || valueOf.intValue() != 10 || (iCommentPresenter = this$0.commentPresenter) == null)) {
            iCommentPresenter.showCommentInput();
        }
        return true;
    }
}
