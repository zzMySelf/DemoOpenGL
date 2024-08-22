package com.baidu.searchbox.music.comp.player.page.video.item.info;

import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.music.R;
import com.baidu.searchbox.music.comp.player.info.event.OpenLyricPageEvent;
import com.baidu.searchbox.music.comp.player.lyric.mini.MiniLyricComp;
import com.baidu.searchbox.music.ext.statistic.MusicExtStatService;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/music/comp/player/lyric/mini/MiniLyricComp;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoInfoComp.kt */
final class VideoInfoComp$lyricComp$2 extends Lambda implements Function0<MiniLyricComp> {
    final /* synthetic */ LifecycleOwner $owner;
    final /* synthetic */ UniqueId $token;
    final /* synthetic */ View $view;
    final /* synthetic */ VideoInfoComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoInfoComp$lyricComp$2(LifecycleOwner lifecycleOwner, View view2, UniqueId uniqueId, VideoInfoComp videoInfoComp) {
        super(0);
        this.$owner = lifecycleOwner;
        this.$view = view2;
        this.$token = uniqueId;
        this.this$0 = videoInfoComp;
    }

    public final MiniLyricComp invoke() {
        LifecycleOwner lifecycleOwner = this.$owner;
        FrameLayout frameLayout = (FrameLayout) this.$view.findViewById(R.id.player_info_lyric);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "view.player_info_lyric");
        MiniLyricComp miniLyricComp = new MiniLyricComp(lifecycleOwner, frameLayout, this.$token, this.this$0.song);
        VideoInfoComp videoInfoComp = this.this$0;
        UniqueId uniqueId = this.$token;
        MiniLyricComp $this$invoke_u24lambda_u2d1 = miniLyricComp;
        videoInfoComp.add($this$invoke_u24lambda_u2d1);
        $this$invoke_u24lambda_u2d1.getView().setOnClickListener(new VideoInfoComp$lyricComp$2$$ExternalSyntheticLambda0(uniqueId));
        return miniLyricComp;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m564invoke$lambda1$lambda0(UniqueId $token2, View it) {
        Intrinsics.checkNotNullParameter($token2, "$token");
        BdEventBus.Companion.getDefault().post(new OpenLyricPageEvent($token2));
        MusicExtStatService of = MusicExtStats.of($token2);
        if (of != null) {
            of.onMusicExtStatEvent("click", "homepage", "", MusicExtStats.VALUE_LYRIC_CLICK);
        }
    }
}
