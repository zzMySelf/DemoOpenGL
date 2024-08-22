package com.baidu.searchbox.video.channel.tab.countdownmute;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/channel/tab/countdownmute/ChannelCountDownMuteComponent$beginCountDown$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelCountDownMuteComponent.kt */
public final class ChannelCountDownMuteComponent$beginCountDown$1 extends CountDownTimer {
    final /* synthetic */ ChannelCountDownMuteComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelCountDownMuteComponent$beginCountDown$1(ChannelCountDownMuteComponent $receiver, long $super_call_param$1) {
        super($super_call_param$1, 1000);
        this.this$0 = $receiver;
    }

    public void onTick(long millisUntilFinished) {
        this.this$0.getRootView().setText(this.this$0.getCountDownText((int) (millisUntilFinished / 1000)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r6.needChangeMuteState() == true) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFinish() {
        /*
            r7 = this;
            com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteComponent r0 = r7.this$0
            r1 = 0
            r0.countDownIsShow = r1
            com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteComponent r0 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r2 = 1
            if (r0 == 0) goto L_0x0030
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x001c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001d
        L_0x001c:
            r4 = r6
        L_0x001d:
            if (r4 == 0) goto L_0x0025
            java.lang.Class<com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteState> r5 = com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x0025:
            com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteState r6 = (com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteState) r6
            if (r6 == 0) goto L_0x0030
            boolean r0 = r6.needChangeMuteState()
            if (r0 != r2) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r2 = r1
        L_0x0031:
            r0 = r2
            com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteComponent r2 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r2.getStore()
            if (r2 == 0) goto L_0x0044
            com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteAction$OnViewVisibleChange r3 = new com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteAction$OnViewVisibleChange
            r3.<init>(r1, r0)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r2.dispatch(r3)
        L_0x0044:
            com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteComponent r1 = r7.this$0
            android.widget.TextView r1 = r1.getRootView()
            r2 = 8
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.countdownmute.ChannelCountDownMuteComponent$beginCountDown$1.onFinish():void");
    }
}
