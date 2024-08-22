package com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base;

import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base.BaseCoverComp;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base.BaseCoverData;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\u0010\b\u0001\u0010\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverAdapter;", "M", "Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverData;", "VH", "Lcom/baidu/searchbox/music/ext/album/detail/comp/songlist/item/cover/base/BaseCoverComp;", "Lcom/baidu/searchbox/nacomp/recycler/base/item/ItemAdapter;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseCoverAdapter.kt */
public abstract class BaseCoverAdapter<M extends BaseCoverData<?>, VH extends BaseCoverComp<?, ?>> extends ItemAdapter<M, VH> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseCoverAdapter(LifecycleOwner owner) {
        super(owner);
        Intrinsics.checkNotNullParameter(owner, "owner");
    }
}
