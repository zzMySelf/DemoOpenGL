package com.baidu.searchbox.musicplayer;

import android.os.Looper;
import com.baidu.searchbox.musicplayer.TtsMusicPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer$ProgressHandler;", "Lcom/baidu/searchbox/musicplayer/TtsMusicPlayer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TtsMusicPlayer.kt */
final class TtsMusicPlayer$progressHandler$2 extends Lambda implements Function0<TtsMusicPlayer.ProgressHandler> {
    final /* synthetic */ TtsMusicPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TtsMusicPlayer$progressHandler$2(TtsMusicPlayer ttsMusicPlayer) {
        super(0);
        this.this$0 = ttsMusicPlayer;
    }

    public final TtsMusicPlayer.ProgressHandler invoke() {
        return new TtsMusicPlayer.ProgressHandler(Looper.getMainLooper());
    }
}
