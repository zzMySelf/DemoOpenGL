package com.tera.scan.widget.swiperefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import fe.mmm.qw.d.de.de;
import fe.mmm.qw.j.o;

public class CircleImageWithTextView extends LinearLayout {
    public static final int CIRCLE_DIAMETER = 24;
    public RelativeLayout mBrandImageView;
    public CircleImageView mCircleImageView;
    public TextView mTextView;

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
        }
    }

    public CircleImageWithTextView(Context context, int i2, float f) {
        super(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mBrandImageView = relativeLayout;
        relativeLayout.setGravity(1);
        this.mBrandImageView.setBackground((Drawable) null);
        addView(this.mBrandImageView, new LinearLayout.LayoutParams(getScreenWidth(context), o.qw(48.0f)));
        this.mBrandImageView.setClickable(false);
        this.mBrandImageView.setOnClickListener(new qw());
        CircleImageView circleImageView = new CircleImageView(context, i2, f);
        this.mCircleImageView = circleImageView;
        circleImageView.setImageDrawable(getResources().getDrawable(R.drawable.loading_red));
        int qw2 = o.qw(24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(qw2, qw2);
        layoutParams.bottomMargin = o.qw(25.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.mBrandImageView.addView(this.mCircleImageView, layoutParams);
        TextView textView = new TextView(context);
        this.mTextView = textView;
        textView.setTextColor(getResources().getColor(R.color.ui_color_gc2));
        this.mTextView.setTextSize(1, 12.0f);
        this.mTextView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(12);
        layoutParams2.topMargin = o.qw(14.0f);
        layoutParams2.bottomMargin = o.qw(5.0f);
        layoutParams2.addRule(14);
        this.mBrandImageView.addView(this.mTextView, layoutParams2);
    }

    public static int getScreenWidth(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        this.mCircleImageView.onAnimationEnd();
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        this.mCircleImageView.onAnimationStart();
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mCircleImageView.setAnimationListener(animationListener);
    }

    public void setBackgroundColor(int i2) {
        if (getBackground() != null && (getBackground() instanceof ShapeDrawable)) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public void setBackgroundColorRes(int i2) {
        setBackgroundColor(getContext().getResources().getColor(i2));
    }

    @SuppressLint({"RestrictedApi"})
    public void setBrandImageBackground(int i2) {
        if (this.mBrandImageView != null) {
            if (getContext() != null) {
                this.mBrandImageView.setBackground(de.when().m965switch(i2));
                this.mBrandImageView.setVisibility(0);
                return;
            }
            this.mBrandImageView.setVisibility(8);
        }
    }

    public void setBrandViewClickbale() {
        this.mBrandImageView.setClickable(true);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTextView.setVisibility(8);
            return;
        }
        this.mTextView.setVisibility(0);
        this.mTextView.setText(str);
    }

    public void setViewHeigth(int i2) {
        RelativeLayout relativeLayout = this.mBrandImageView;
        if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
            this.mBrandImageView.getLayoutParams().height = o.qw((float) i2);
        }
    }

    public void start() {
        this.mCircleImageView.start();
    }

    public void stop() {
        this.mCircleImageView.stop();
    }
}
