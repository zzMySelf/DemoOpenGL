package com.baidu.searchbox.reactnative.views.pag;

import kotlin.Metadata;
import org.libpag.PAGFile;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/reactnative/views/pag/TalosPAGImageView$setPathAsync$1", "Lorg/libpag/PAGFile$LoadListener;", "onLoad", "", "pAGFile", "Lorg/libpag/PAGFile;", "lib-talos-searchbox-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosPAGImageView.kt */
public final class TalosPAGImageView$setPathAsync$1 implements PAGFile.LoadListener {
    final /* synthetic */ TalosPAGImageView this$0;

    TalosPAGImageView$setPathAsync$1(TalosPAGImageView $receiver) {
        this.this$0 = $receiver;
    }

    public void onLoad(PAGFile pAGFile) {
        if (pAGFile != null) {
            TalosPAGImageView talosPAGImageView = this.this$0;
            PAGFile pAGFile2 = pAGFile;
            talosPAGImageView.isOnLoad = true;
            if (talosPAGImageView.isAfterUpdateTransaction && talosPAGImageView.autoplay && !talosPAGImageView.isPlaying()) {
                talosPAGImageView.play();
            }
        }
    }
}
