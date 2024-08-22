package com.baidu.searchbox.video.feedflow.detail.payment.subscribe;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00011B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0006\u0010(\u001a\u00020\u0013J\u0018\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0006\u0010+\u001a\u00020\u0013J\u001e\u0010,\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0013J\b\u0010/\u001a\u00020\u0013H\u0002J\u0018\u00100\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/subscribe/SubscribeLastFrameTimerView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currTime", "endTime", "isPause", "", "prefixHint", "", "timeRemain", "Lcom/baidu/searchbox/video/feedflow/detail/payment/subscribe/Time;", "timerCompleteListener", "Lkotlin/Function0;", "", "getTimerCompleteListener", "()Lkotlin/jvm/functions/Function0;", "setTimerCompleteListener", "(Lkotlin/jvm/functions/Function0;)V", "timerDayDivideView", "Landroid/widget/TextView;", "timerDayView", "timerHourDivideView", "timerHourView", "timerMinuteDivideView", "timerMinuteView", "timerPrefixView", "timerSecondView", "timingHandler", "Landroid/os/Handler;", "timingRunnable", "Lcom/baidu/searchbox/video/feedflow/detail/payment/subscribe/SubscribeLastFrameTimerView$TimingRunnable;", "digit2Time", "digit", "hideTimerView", "pauseDraw", "processTime", "startTime", "resumeDraw", "setData", "nowTime", "stopTiming", "ticking", "updateTime", "TimingRunnable", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubscribeLastFrameTimerView.kt */
public final class SubscribeLastFrameTimerView extends RelativeLayout {
    /* access modifiers changed from: private */
    public int currTime;
    /* access modifiers changed from: private */
    public int endTime;
    private boolean isPause;
    private String prefixHint;
    private Time timeRemain;
    private Function0<Unit> timerCompleteListener;
    private TextView timerDayDivideView;
    private TextView timerDayView;
    private TextView timerHourDivideView;
    private TextView timerHourView;
    private TextView timerMinuteDivideView;
    private TextView timerMinuteView;
    private TextView timerPrefixView;
    private TextView timerSecondView;
    private Handler timingHandler;
    private final TimingRunnable timingRunnable;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeLastFrameTimerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeLastFrameTimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscribeLastFrameTimerView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscribeLastFrameTimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefixHint = "";
        this.timeRemain = new Time();
        this.timingHandler = new Handler(Looper.getMainLooper());
        this.timingRunnable = new TimingRunnable();
        LayoutInflater.from(context).inflate(R.layout.video_flow_column_subscribe_last_frame_timer_layout, this);
        View findViewById = findViewById(R.id.subscribe_timer_prefix);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.subscribe_timer_prefix)");
        this.timerPrefixView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.subscribe_timer_second);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subscribe_timer_second)");
        this.timerSecondView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.subscribe_timer_minute);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.subscribe_timer_minute)");
        this.timerMinuteView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.subscribe_timer_hour);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.subscribe_timer_hour)");
        this.timerHourView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.subscribe_timer_day);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.subscribe_timer_day)");
        this.timerDayView = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.subscribe_timer_minute_divide);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.subscribe_timer_minute_divide)");
        this.timerMinuteDivideView = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.subscribe_timer_hour_divide);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.subscribe_timer_hour_divide)");
        this.timerHourDivideView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.subscribe_timer_day_divide);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.subscribe_timer_day_divide)");
        this.timerDayDivideView = (TextView) findViewById8;
    }

    public final Function0<Unit> getTimerCompleteListener() {
        return this.timerCompleteListener;
    }

    public final void setTimerCompleteListener(Function0<Unit> function0) {
        this.timerCompleteListener = function0;
    }

    public final void setData(String prefixHint2, int nowTime, int endTime2) {
        Intrinsics.checkNotNullParameter(prefixHint2, "prefixHint");
        this.prefixHint = prefixHint2;
        if (!StringsKt.isBlank(prefixHint2)) {
            this.timerPrefixView.setText(prefixHint2);
            this.timerPrefixView.setVisibility(0);
        } else {
            this.timerPrefixView.setVisibility(8);
        }
        if (nowTime <= 0 || endTime2 <= 0 || nowTime >= endTime2) {
            hideTimerView();
            return;
        }
        this.currTime = nowTime;
        this.endTime = endTime2;
        updateTime(nowTime, endTime2);
        ticking();
    }

    public final void pauseDraw() {
        this.isPause = true;
    }

    public final void resumeDraw() {
        this.isPause = false;
        updateTime(this.currTime, this.endTime);
    }

    public final void stopTiming() {
        Handler handler = this.timingHandler;
        if (handler != null) {
            handler.removeCallbacks(this.timingRunnable);
        }
        this.timingHandler = null;
    }

    /* access modifiers changed from: private */
    public final void updateTime(int nowTime, int endTime2) {
        if (!this.isPause) {
            Time processTime = processTime(nowTime, endTime2);
            this.timeRemain = processTime;
            if (processTime.isValid()) {
                if (!StringsKt.isBlank(this.prefixHint)) {
                    this.timerPrefixView.setText(this.prefixHint);
                    this.timerPrefixView.setVisibility(0);
                } else {
                    this.timerPrefixView.setVisibility(8);
                }
                if (this.timeRemain.getDay() >= 0) {
                    this.timerDayView.setText(String.valueOf(this.timeRemain.getDay()));
                    this.timerDayView.setVisibility(0);
                    this.timerDayDivideView.setVisibility(0);
                } else {
                    this.timerDayView.setVisibility(8);
                    this.timerDayDivideView.setVisibility(8);
                }
                if (this.timeRemain.getHour() >= 0) {
                    this.timerHourView.setText(digit2Time(this.timeRemain.getHour()));
                    this.timerHourView.setVisibility(0);
                    this.timerHourDivideView.setVisibility(0);
                } else {
                    this.timerHourView.setVisibility(8);
                    this.timerHourDivideView.setVisibility(8);
                }
                if (this.timeRemain.getMinute() >= 0) {
                    this.timerMinuteView.setText(digit2Time(this.timeRemain.getMinute()));
                    this.timerMinuteView.setVisibility(0);
                    this.timerMinuteDivideView.setVisibility(0);
                } else {
                    this.timerMinuteView.setVisibility(8);
                    this.timerMinuteDivideView.setVisibility(8);
                }
                if (this.timeRemain.getSecond() >= 0) {
                    this.timerSecondView.setText(digit2Time(this.timeRemain.getSecond()));
                    this.timerSecondView.setVisibility(0);
                    return;
                }
                this.timerSecondView.setVisibility(8);
            }
        }
    }

    private final void hideTimerView() {
        this.timerDayDivideView.setVisibility(8);
        this.timerHourDivideView.setVisibility(8);
        this.timerMinuteDivideView.setVisibility(8);
        this.timerDayView.setVisibility(8);
        this.timerHourView.setVisibility(8);
        this.timerMinuteView.setVisibility(8);
        this.timerSecondView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void ticking() {
        Handler handler = this.timingHandler;
        if (handler != null) {
            handler.removeCallbacks(this.timingRunnable);
        }
        Handler handler2 = this.timingHandler;
        if (handler2 != null) {
            handler2.postDelayed(this.timingRunnable, 1000);
        }
    }

    private final String digit2Time(int digit) {
        boolean z = false;
        if (digit >= 0 && digit < 10) {
            z = true;
        }
        if (z) {
            return new StringBuilder().append('0').append(digit).toString();
        }
        if (!z) {
            return String.valueOf(digit);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Time processTime(int startTime, int endTime2) {
        int timeInterval = endTime2 - startTime;
        Time time = new Time();
        if (timeInterval > 0) {
            time.setDay(timeInterval / 86400);
            time.setHour((timeInterval / 3600) - (time.getDay() * 24));
            time.setMinute(((timeInterval / 60) - ((time.getDay() * 24) * 60)) - (time.getHour() * 60));
            time.setSecond(((timeInterval - (time.getDay() * 86400)) - (time.getHour() * 3600)) - (time.getMinute() * 60));
        }
        return time;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/subscribe/SubscribeLastFrameTimerView$TimingRunnable;", "Ljava/lang/Runnable;", "(Lcom/baidu/searchbox/video/feedflow/detail/payment/subscribe/SubscribeLastFrameTimerView;)V", "run", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SubscribeLastFrameTimerView.kt */
    public final class TimingRunnable implements Runnable {
        public TimingRunnable() {
        }

        public void run() {
            SubscribeLastFrameTimerView subscribeLastFrameTimerView = SubscribeLastFrameTimerView.this;
            subscribeLastFrameTimerView.currTime = subscribeLastFrameTimerView.currTime + 1;
            if (SubscribeLastFrameTimerView.this.currTime < SubscribeLastFrameTimerView.this.endTime) {
                SubscribeLastFrameTimerView subscribeLastFrameTimerView2 = SubscribeLastFrameTimerView.this;
                subscribeLastFrameTimerView2.updateTime(subscribeLastFrameTimerView2.currTime, SubscribeLastFrameTimerView.this.endTime);
                SubscribeLastFrameTimerView.this.ticking();
                return;
            }
            Function0<Unit> timerCompleteListener = SubscribeLastFrameTimerView.this.getTimerCompleteListener();
            if (timerCompleteListener != null) {
                timerCompleteListener.invoke();
            }
        }
    }
}
