package com.baidu.searchbox.music.ext.related;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.music.ext.album.playback.PlaylistCallback;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.related.event.PlayRelatedSongEvent;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/music/ext/related/RelatedTabViewModel$playSong$1$1$1$1$1", "Lcom/baidu/searchbox/music/ext/album/playback/PlaylistCallback;", "onSongsAllApplied", "", "onSongsApplyFailed", "throwable", "", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedTabViewModel.kt */
public final class RelatedTabViewModel$playSong$1$1$1$1$1 implements PlaylistCallback {
    final /* synthetic */ ISong $playSong;
    final /* synthetic */ RelatedTabViewModel this$0;

    RelatedTabViewModel$playSong$1$1$1$1$1(RelatedTabViewModel $receiver, ISong $playSong2) {
        this.this$0 = $receiver;
        this.$playSong = $playSong2;
    }

    public void onSongsPagingApplied(List<? extends ISong> pagingSongs) {
        PlaylistCallback.DefaultImpls.onSongsPagingApplied(this, pagingSongs);
    }

    public void onSongsAllApplied() {
        PlaylistCallback.DefaultImpls.onSongsAllApplied(this);
        UniqueId $this$onSongsAllApplied_u24lambda_u2d0 = this.this$0.getToken();
        if ($this$onSongsAllApplied_u24lambda_u2d0 != null) {
            BdEventBus.Companion.getDefault().post(new PlayRelatedSongEvent($this$onSongsAllApplied_u24lambda_u2d0));
        }
        this.this$0.getShowLoadingToast().setValue(false);
    }

    public void onSongsApplyFailed(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        PlaylistCallback.DefaultImpls.onSongsApplyFailed(this, throwable);
        this.this$0.playSongInH5(this.$playSong);
        this.this$0.getShowLoadingToast().setValue(false);
    }
}
