package com.baidu.searchbox.hotsearch.comp.item.phrase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.hissug.lib_hot_search.R;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/hotsearch/comp/item/phrase/PhraseStyleItemAdapter;", "Lcom/baidu/searchbox/nacomp/recycler/base/item/ItemAdapter;", "Lcom/baidu/searchbox/hotsearch/comp/item/phrase/PhraseStyleItemModel;", "Lcom/baidu/searchbox/hotsearch/comp/item/phrase/PhraseStyleItemComp;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "lib_hot_search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhraseStyleItemAdapter.kt */
public final class PhraseStyleItemAdapter extends ItemAdapter<PhraseStyleItemModel, PhraseStyleItemComp> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhraseStyleItemAdapter(LifecycleOwner owner) {
        super(owner);
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    public PhraseStyleItemComp onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_search_phrase_style_item_layout, parent, false);
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new PhraseStyleItemComp(lifecycleOwner, view2);
    }

    public UniqueId getType() {
        return PhraseStyleItemModel.Companion.getTYPE();
    }
}
