package com.baidu.searchbox.music.ext.album.recommendcollect.common.item.tip;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/recommendcollect/common/item/tip/TipsItemViewModel;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemViewModel;", "Lcom/baidu/searchbox/music/ext/album/recommendcollect/common/item/tip/TipsItemModel;", "()V", "tips", "Landroidx/lifecycle/MutableLiveData;", "", "getTips", "()Landroidx/lifecycle/MutableLiveData;", "setModel", "", "model", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TipsItemAdapter.kt */
public final class TipsItemViewModel extends BaseExtItemViewModel<TipsItemModel> {
    private final MutableLiveData<String> tips = new MutableLiveData<>();

    public final MutableLiveData<String> getTips() {
        return this.tips;
    }

    public void setModel(TipsItemModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setModel(model);
        this.tips.setValue(model.getTips());
    }
}
