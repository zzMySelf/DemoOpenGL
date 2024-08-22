package com.baidu.nadcore.mounttag;

import com.baidu.nadcore.mounttag.NadMountTagImgDoubleLineView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/nadcore/mounttag/NadMountTagContainerView$mountTagViewListener$1", "Lcom/baidu/nadcore/mounttag/NadMountTagImgDoubleLineView$OnActionListener;", "onCountDownEnd", "", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadMountTagContainerView.kt */
public final class NadMountTagContainerView$mountTagViewListener$1 implements NadMountTagImgDoubleLineView.OnActionListener {
    final /* synthetic */ NadMountTagContainerView this$0;

    NadMountTagContainerView$mountTagViewListener$1(NadMountTagContainerView $receiver) {
        this.this$0 = $receiver;
    }

    public void onCountDownEnd() {
        this.this$0.startExitAnim();
    }
}
