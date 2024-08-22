package com.baidu.nadcore.mounttag;

import com.baidu.nadcore.mounttag.NadMountTagImgDoubleLineView;
import com.baidu.nadcore.utils.UniversalCountDownTimer;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/nadcore/mounttag/NadMountTagImgDoubleLineView$initCountDownTimer$1", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer$StatusListener;", "onFinish", "", "onTick", "millsUtilFinished", "", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadMountTagImgDoubleLineView.kt */
public final class NadMountTagImgDoubleLineView$initCountDownTimer$1 extends UniversalCountDownTimer.StatusListener {
    final /* synthetic */ String $title;
    final /* synthetic */ NadMountTagImgDoubleLineView this$0;

    NadMountTagImgDoubleLineView$initCountDownTimer$1(NadMountTagImgDoubleLineView $receiver, String $title2) {
        this.this$0 = $receiver;
        this.$title = $title2;
    }

    public void onTick(long millsUtilFinished) {
        this.this$0.getTvMountTagTitle().setText(StringsKt.replace$default(this.$title, "$countdown", String.valueOf((millsUtilFinished / ((long) 1000)) + 1), false, 4, (Object) null));
    }

    public void onFinish() {
        NadMountTagImgDoubleLineView.OnActionListener access$getMountTagViewListener$p = this.this$0.mountTagViewListener;
        if (access$getMountTagViewListener$p != null) {
            access$getMountTagViewListener$p.onCountDownEnd();
        }
    }
}
