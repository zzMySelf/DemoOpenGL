package com.baidu.searchbox.secondfloor.home.guide;

import android.os.CountDownTimer;
import com.baidu.searchbox.secondfloor.home.guide.SecondFloorWeakGuideView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/secondfloor/home/guide/SecondFloorWeakGuideView$initCountDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "lib-secondfloor-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondFloorWeakGuideView.kt */
public final class SecondFloorWeakGuideView$initCountDownTimer$1 extends CountDownTimer {
    final /* synthetic */ SecondFloorWeakGuideView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondFloorWeakGuideView$initCountDownTimer$1(long $duration, SecondFloorWeakGuideView $receiver) {
        super($duration, 1000);
        this.this$0 = $receiver;
    }

    public void onTick(long millisUntilFinished) {
    }

    public void onFinish() {
        SecondFloorWeakGuideView.GuideCallBack access$getCallBack$p;
        if (this.this$0.callBack != null && (access$getCallBack$p = this.this$0.callBack) != null) {
            access$getCallBack$p.exitGuide();
        }
    }
}
