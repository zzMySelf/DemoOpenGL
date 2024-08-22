package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.ResUtils;

public class DxmNoNetView extends RelativeLayout implements View.OnClickListener {
    public Animation a;
    public Animation b;
    public String c = "";
    public a d;
    public TextView e;
    public TextView f;
    public Button g;

    public interface a {
        void a();

        void a(String str);
    }

    public DxmNoNetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        b();
    }

    private void a() {
        this.a = ResUtils.getAnimation(getContext(), "wallet_base_slide_from_right");
        this.b = ResUtils.getAnimation(getContext(), "wallet_base_slide_to_right");
        this.a.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                DxmNoNetView.this.setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                DxmNoNetView.this.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "dxm_wallet_base_no_net_error_layout"), this);
        findViewById(ResUtils.id(getContext(), "reload_btn")).setOnClickListener(this);
        this.e = (TextView) findViewById(ResUtils.id(getContext(), "failure_cause"));
        Button button = (Button) findViewById(ResUtils.id(getContext(), "btn_continue_load"));
        this.g = button;
        button.setOnClickListener(this);
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_text_no_net"));
    }

    public void hide() {
        this.c = "";
        setVisibility(8);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public void notifyUrlFinish() {
        if (isShowing()) {
            setVisibility(4);
        }
    }

    public void onClick(View view) {
        a aVar;
        if (!CheckUtils.isFastDoubleClick()) {
            if (view.getId() == ResUtils.id(getContext(), "reload_btn")) {
                a aVar2 = this.d;
                if (aVar2 != null) {
                    aVar2.a(this.c);
                }
            } else if (view.getId() == ResUtils.id(getContext(), "btn_continue_load") && (aVar = this.d) != null) {
                aVar.a();
            }
        }
    }

    public void show(String str, boolean z, a aVar) {
        this.c = str;
        this.d = aVar;
        setVisibility(0);
        if (z) {
            this.g.setVisibility(0);
            this.f.setText(ResUtils.getString(getContext(), "dxm_wallet_base_ssl_err_title"));
            this.e.setText(ResUtils.getString(getContext(), "dxm_wallet_base_ssl_err_msg"));
            return;
        }
        this.g.setVisibility(8);
        this.f.setText(ResUtils.getString(getContext(), "dxm_ebpay_no_network"));
        this.e.setText(ResUtils.getString(getContext(), "wallet_base_no_network_reason"));
    }
}
