package com.baidu.poly.widget.duvip;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.poly.util.Logger;
import com.baidu.poly.util.o;
import com.baidu.talos.core.render.animation.AnimConstants;
import java.text.DecimalFormat;

/* compiled from: SearchBox */
public class RunTextView extends TextView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ValueAnimator f17472a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public DecimalFormat f17473b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f17474c = "RunTextVIew";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f17475d;

    /* compiled from: SearchBox */
    class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17476a;

        a(String str) {
            this.f17476a = str;
        }

        public void onAnimationCancel(Animator animator) {
            Logger.d(RunTextView.this.f17474c, AnimConstants.ON_ANIMATION_CANCEL + (System.currentTimeMillis() - RunTextView.this.f17475d));
            RunTextView.this.setText(this.f17476a);
            RunTextView.this.f17472a.removeAllUpdateListeners();
        }

        public void onAnimationEnd(Animator animator) {
            Logger.d(RunTextView.this.f17474c, "onAnimationEnd:" + (System.currentTimeMillis() - RunTextView.this.f17475d));
            RunTextView.this.setText(this.f17476a);
            RunTextView.this.f17472a.removeAllUpdateListeners();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            long unused = RunTextView.this.f17475d = System.currentTimeMillis();
        }
    }

    /* compiled from: SearchBox */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RunTextView runTextView = RunTextView.this;
            runTextView.setText(runTextView.f17473b.format((double) floatValue));
        }
    }

    public RunTextView(Context context) {
        super(context);
        b();
    }

    public void setShowPrice(long j2) {
        a();
        String charSequence = getText().toString();
        String a2 = o.a(j2);
        long a3 = a(charSequence);
        if (j2 == a3) {
            setText(o.a(j2));
            return;
        }
        long abs = Math.abs(j2 - a3);
        try {
            a(abs > 750 ? 1500 : abs * 2, charSequence, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.d(this.f17474c, e2.getMessage());
            setText(a2);
        }
    }

    private void b() {
        this.f17473b = new DecimalFormat("0.00");
    }

    private void a() {
        ValueAnimator valueAnimator = this.f17472a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f17472a.end();
        }
    }

    private void a(long j2, String str, String str2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{Float.valueOf(str).floatValue(), Float.valueOf(str2).floatValue()});
        this.f17472a = ofFloat;
        ofFloat.setDuration(j2);
        this.f17472a.addListener(new a(str2));
        this.f17472a.addUpdateListener(new b());
        this.f17472a.start();
    }

    public RunTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public RunTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return o.b(str).longValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
