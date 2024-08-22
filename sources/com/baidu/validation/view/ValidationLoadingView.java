package com.baidu.validation.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.passport.valudation.R;

public class ValidationLoadingView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f3802a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f3803b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f3804c;

    /* renamed from: d  reason: collision with root package name */
    private View f3805d;

    public ValidationLoadingView(Context context) {
        super(context);
        a();
    }

    public ValidationLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ValidationLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_view_loading_light, this, true);
        this.f3802a = inflate;
        this.f3803b = (ImageView) inflate.findViewById(R.id.validation_loading_logo);
        this.f3804c = (ImageView) this.f3802a.findViewById(R.id.validation_sweep_iv);
        this.f3805d = this.f3802a.findViewById(R.id.sapi_sdk_sweep_bg_view);
    }

    private void b() {
        this.f3804c.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_sweep_light_trans));
    }

    private void c() {
        ImageView imageView = this.f3804c;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void setDarkMode(boolean z) {
        View view2;
        String str;
        if (z) {
            this.f3803b.setImageResource(R.drawable.icon_sweep_light_logo_dark);
            this.f3804c.setImageResource(R.drawable.icon_sweep_light_dark);
            view2 = this.f3805d;
            str = "#222222";
        } else {
            this.f3803b.setImageResource(R.drawable.icon_sweep_light_logo);
            this.f3804c.setImageResource(R.drawable.icon_sweep_light);
            view2 = this.f3805d;
            str = "#E5E5E5";
        }
        view2.setBackgroundColor(Color.parseColor(str));
    }

    public void setVisibility(int i2) {
        if (i2 == 0) {
            b();
        } else {
            c();
        }
        super.setVisibility(i2);
    }
}
