package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.a.a.b.c.k;
import b.a.a.a.c.q.a.a;
import com.baidu.bikenavi.R;
import com.baidu.platform.comapi.walknavi.h.c.C0325b;

/* compiled from: TopGuidanceInfoView */
public class i extends C0325b {

    /* renamed from: b  reason: collision with root package name */
    private Activity f16233b;

    /* renamed from: c  reason: collision with root package name */
    private k f16234c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f16235d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f16236e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f16237f;

    public i(Context context, k kVar, View view2) {
        this.f16233b = (Activity) context;
        this.f16234c = kVar;
        a(view2);
    }

    public void e() {
        if (this.f16237f.getVisibility() == 0) {
            Animation c2 = a.c(this.f16233b, R.anim.wsdk_anim_fadeaway);
            c2.setAnimationListener(new h(this));
            this.f16237f.startAnimation(c2);
        }
    }

    public void f() {
        if (this.f16237f.getVisibility() == 8) {
            this.f16237f.setVisibility(0);
            Animation c2 = a.c(this.f16233b, R.anim.wsdk_anim_comeout);
            this.f16237f.setAnimation(c2);
            c2.setAnimationListener(new g(this));
            c2.start();
        }
    }

    private void a(View view2) {
        this.f16235d = (ImageView) view2.findViewById(R.id.guidance_icon);
        this.f16236e = (TextView) view2.findViewById(R.id.guidance_tv);
        View findViewById = view2.findViewById(R.id.gps_weak_layout);
        this.f16237f = findViewById;
        findViewById.setVisibility(8);
    }

    public void a(int i2, String str) {
        if (i2 == R.drawable.bn_start_blue || i2 == R.drawable.bn_gps_blue) {
            this.f16236e.setVisibility(8);
        } else {
            this.f16236e.setVisibility(0);
        }
        if (b.a.a.a.b.a.a.f1211a) {
            this.f16235d.setImageDrawable(a.b().getDrawable(i2));
        } else {
            this.f16235d.setImageResource(i2);
        }
        this.f16236e.setText(str);
    }
}
