package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;

public class WalletBaseEmptyView extends LinearLayout {
    public ImageView a;
    public TextView b;
    public TextView c;
    public Button d;
    public View e;
    public View f;
    public EmptyBtnClickListener g;
    public boolean h;

    public interface EmptyBtnClickListener {
        void onBtnClick();
    }

    public WalletBaseEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setRetryBtnVisiablity(int i2) {
        this.d.setVisibility(i2);
    }

    public void setShowLoading(boolean z) {
        this.h = z;
    }

    public void setonEmptyListener(EmptyBtnClickListener emptyBtnClickListener) {
        this.g = emptyBtnClickListener;
    }

    public void showLoadingPage(boolean z) {
        if (z) {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        this.f.setVisibility(0);
    }

    public void showOnlyTip1(int i2, CharSequence charSequence) {
        showLoadingPage(false);
        this.a.setBackgroundResource(i2);
        this.b.setText(charSequence);
        this.c.setVisibility(4);
        this.d.setVisibility(8);
    }

    public void showTip1_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, EmptyBtnClickListener emptyBtnClickListener) {
        showLoadingPage(false);
        this.a.setBackgroundResource(i2);
        this.b.setText(charSequence);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.d.setText(charSequence2);
        this.g = emptyBtnClickListener;
    }

    public void showTip1_Tip2(int i2, CharSequence charSequence, CharSequence charSequence2) {
        showLoadingPage(false);
        this.a.setBackgroundResource(i2);
        this.b.setText(charSequence);
        this.c.setVisibility(0);
        this.c.setText(charSequence2);
        this.d.setVisibility(8);
    }

    public void showTip1_Tip2_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, EmptyBtnClickListener emptyBtnClickListener) {
        showLoadingPage(false);
        this.a.setBackgroundResource(i2);
        this.b.setText(charSequence);
        this.c.setVisibility(0);
        this.c.setText(charSequence2);
        this.d.setVisibility(0);
        this.d.setText(charSequence3);
        this.g = emptyBtnClickListener;
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_empty_layout"), this);
        this.a = (ImageView) findViewById(ResUtils.id(context, "empty_image"));
        this.b = (TextView) findViewById(ResUtils.id(context, "empty_tip_1"));
        this.c = (TextView) findViewById(ResUtils.id(context, "empty_tip_2"));
        this.d = (Button) findViewById(ResUtils.id(context, "reload_btn"));
        this.e = findViewById(ResUtils.id(context, "progress_layout"));
        this.f = findViewById(ResUtils.id(context, "reload_layout"));
        this.d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (WalletBaseEmptyView.this.g != null) {
                    if (WalletBaseEmptyView.this.h) {
                        WalletBaseEmptyView.this.showLoadingPage(true);
                    }
                    WalletBaseEmptyView.this.g.onBtnClick();
                }
            }
        });
    }

    public WalletBaseEmptyView(Context context) {
        super(context);
        a(context);
    }
}
