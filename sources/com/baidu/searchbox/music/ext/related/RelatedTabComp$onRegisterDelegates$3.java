package com.baidu.searchbox.music.ext.related;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.music.ext.mymusic.comp.album.AlbumListAdapter;
import com.baidu.searchbox.music.ext.mymusic.comp.album.AlbumListComp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/music/ext/related/RelatedTabComp$onRegisterDelegates$3", "Lcom/baidu/searchbox/music/ext/mymusic/comp/album/AlbumListAdapter;", "onCreateViewHolder", "Lcom/baidu/searchbox/music/ext/mymusic/comp/album/AlbumListComp;", "parent", "Landroid/view/ViewGroup;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedTabComp.kt */
public final class RelatedTabComp$onRegisterDelegates$3 extends AlbumListAdapter {
    final /* synthetic */ RelatedTabComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RelatedTabComp$onRegisterDelegates$3(RelatedTabComp $receiver, LifecycleOwner $super_call_param$1) {
        super($super_call_param$1);
        this.this$0 = $receiver;
        Intrinsics.checkNotNullExpressionValue($super_call_param$1, "lifecycleOwner");
    }

    public AlbumListComp onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        AlbumListComp onCreateViewHolder = super.onCreateViewHolder(parent);
        RelatedTabComp relatedTabComp = this.this$0;
        AlbumListComp $this$onCreateViewHolder_u24lambda_u2d0 = onCreateViewHolder;
        $this$onCreateViewHolder_u24lambda_u2d0.setOnAlbumCoverClickListener(relatedTabComp.onAlbumCoverClickListener);
        $this$onCreateViewHolder_u24lambda_u2d0.setPage(relatedTabComp.getStatPage());
        return onCreateViewHolder;
    }
}
