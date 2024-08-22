package com.baidu.searchbox.search.webvideo.player;

import android.view.View;
import com.baidu.searchbox.floating.listener.SimpleFloatListener;
import com.baidu.searchbox.search.webvideo.player.SearchH5FloatingPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/search/webvideo/player/SearchH5FloatingPlayer$onCreate$2", "Lcom/baidu/searchbox/floating/listener/SimpleFloatListener;", "onClick", "", "view", "Landroid/view/View;", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5FloatingPlayer.kt */
public final class SearchH5FloatingPlayer$onCreate$2 extends SimpleFloatListener {
    final /* synthetic */ SearchH5FloatingPlayer this$0;

    SearchH5FloatingPlayer$onCreate$2(SearchH5FloatingPlayer $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        SearchH5FloatingPlayer.SearchH5FloatingCallback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.onFloatingViewClick();
        }
    }
}
