package com.baidu.searchbox.music.ext.album.recommendcollect.common.item.tip;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemComponent;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/recommendcollect/common/item/tip/TipsItemComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemComponent;", "Lcom/baidu/searchbox/music/ext/album/recommendcollect/common/item/tip/TipsItemModel;", "Lcom/baidu/searchbox/music/ext/album/recommendcollect/common/item/tip/TipsItemViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/widget/TextView;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/widget/TextView;)V", "onBindViewModel", "", "viewModel", "onCreateView", "Landroid/view/View;", "onCreateViewModel", "onNightModeChange", "isNight", "", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TipsItemAdapter.kt */
public final class TipsItemComp extends BaseExtItemComponent<TipsItemModel, TipsItemViewModel> {

    /* renamed from: view  reason: collision with root package name */
    private final TextView f2793view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipsItemComp(LifecycleOwner owner, TextView view2) {
        super(owner, view2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f2793view = view2;
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public TipsItemViewModel onCreateViewModel() {
        return new TipsItemViewModel();
    }

    public void onNightModeChange(boolean isNight) {
        ResWrapper.setTextColor(this.f2793view, R.color.GC1);
    }

    public void onBindViewModel(TipsItemViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        viewModel.getTips().observe(owner, new TipsItemComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewModel$lambda-0  reason: not valid java name */
    public static final void m881onBindViewModel$lambda0(TipsItemComp this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f2793view.setText(it);
    }
}
