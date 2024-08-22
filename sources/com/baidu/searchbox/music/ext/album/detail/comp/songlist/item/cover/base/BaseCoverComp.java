package com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base.BaseCoverData;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base.BaseCoverViewModel;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemComponent;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverComp;", "M", "Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverData;", "VM", "Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverViewModel;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemComponent;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "itemView", "Landroid/view/View;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "bindCoverBg", "", "viewModel", "(Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverViewModel;)V", "onBgColorChanged", "bgColor", "", "onBindViewModel", "(Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "onCreateView", "view", "onNightModeChange", "isNightMode", "", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseCoverComp.kt */
public abstract class BaseCoverComp<M extends BaseCoverData<?>, VM extends BaseCoverViewModel<M>> extends BaseExtItemComponent<M, VM> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseCoverComp(LifecycleOwner owner, View itemView) {
        super(owner, itemView);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public void onNightModeChange(boolean isNightMode) {
    }

    public void onBindViewModel(VM viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel((BaseExtItemViewModel) viewModel, owner);
        bindCoverBg(viewModel);
    }

    private final void bindCoverBg(VM viewModel) {
        viewModel.getBgColor().observe(getLifecycleOwner(), new BaseCoverComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCoverBg$lambda-0  reason: not valid java name */
    public static final void m753bindCoverBg$lambda0(BaseCoverComp this$0, Integer bgColor) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bgColor != null) {
            this$0.getView().setBackgroundColor(bgColor.intValue());
            this$0.onBgColorChanged(bgColor.intValue());
        }
    }

    public void onBgColorChanged(int bgColor) {
    }
}
