package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.c.a;
import com.baidu.wallet.paysdk.ui.widget.c;

public class LicaiBalancePayLoading extends LinearLayout {
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public c e;
    public c f;

    public LicaiBalancePayLoading(Context context) {
        super(context);
    }

    public void destoryView() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.a();
        }
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    public void initView() {
        View view;
        if (!a.a().b()) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.wallet_cashdesk_licai_balance_pay_loading1, this);
            this.a = (ImageView) view.findViewById(R.id.iv_licai_balance_loading1);
            this.c = (ImageView) view.findViewById(R.id.iv_licai_balance_normal_loading1);
            this.d = (ImageView) view.findViewById(R.id.iv_licai_balance_normal_loading2);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.wallet_cashdesk_licai_balance_pay_loading2, this);
        }
        this.b = (ImageView) view.findViewById(R.id.iv_licai_balance_loading2);
        a();
    }

    public LicaiBalancePayLoading(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        if (!a.a().b()) {
            final AnimationDrawable animationDrawable = (AnimationDrawable) this.a.getDrawable();
            this.e = new c(animationDrawable);
            final AnimationDrawable animationDrawable2 = (AnimationDrawable) this.b.getDrawable();
            this.f = new c(animationDrawable2);
            this.a.setVisibility(0);
            this.c.setVisibility(8);
            this.b.setVisibility(8);
            this.d.setVisibility(0);
            this.e.a((c.a) new c.a() {
                public void a() {
                    LicaiBalancePayLoading.this.b.setVisibility(8);
                    LicaiBalancePayLoading.this.d.setVisibility(0);
                    animationDrawable2.stop();
                }

                public void b() {
                    LicaiBalancePayLoading.this.a.setVisibility(8);
                    LicaiBalancePayLoading.this.c.setVisibility(0);
                    LicaiBalancePayLoading.this.b.setVisibility(0);
                    LicaiBalancePayLoading.this.d.setVisibility(8);
                    animationDrawable.stop();
                    LicaiBalancePayLoading.this.f.start();
                }
            });
            this.e.start();
            this.f.a((c.a) new c.a() {
                public void a() {
                    LicaiBalancePayLoading.this.a.setVisibility(8);
                    LicaiBalancePayLoading.this.c.setVisibility(0);
                    animationDrawable.stop();
                }

                public void b() {
                    LicaiBalancePayLoading.this.a.setVisibility(0);
                    LicaiBalancePayLoading.this.c.setVisibility(8);
                    LicaiBalancePayLoading.this.b.setVisibility(8);
                    LicaiBalancePayLoading.this.d.setVisibility(0);
                    animationDrawable2.stop();
                    LicaiBalancePayLoading.this.e.start();
                }
            });
            return;
        }
        ((AnimationDrawable) this.b.getDrawable()).start();
    }

    public LicaiBalancePayLoading(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
