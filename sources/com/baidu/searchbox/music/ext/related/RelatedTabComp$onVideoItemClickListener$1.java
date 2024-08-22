package com.baidu.searchbox.music.ext.related;

import com.baidu.searchbox.music.ext.album.playback.PlaybackRepo;
import com.baidu.searchbox.music.ext.tpls.model.VideoModel;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "video", "Lcom/baidu/searchbox/music/ext/tpls/model/VideoModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedTabComp.kt */
final class RelatedTabComp$onVideoItemClickListener$1 extends Lambda implements Function1<VideoModel, Unit> {
    final /* synthetic */ RelatedTabComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RelatedTabComp$onVideoItemClickListener$1(RelatedTabComp relatedTabComp) {
        super(1);
        this.this$0 = relatedTabComp;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((VideoModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(VideoModel video) {
        Intrinsics.checkNotNullParameter(video, "video");
        this.this$0.isPlaying = PlaybackRepo.INSTANCE.isPlaying();
        if (this.this$0.isPlaying) {
            this.this$0.playOrPause();
        }
        SchemeRouter.invoke(this.this$0.getContext(), video.getScheme());
    }
}
