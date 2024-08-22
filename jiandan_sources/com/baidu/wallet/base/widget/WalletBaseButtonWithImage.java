package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;

public class WalletBaseButtonWithImage extends LinearLayout {
    public TextView a;

    public WalletBaseButtonWithImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_widget_button_with_image"), this);
        Drawable drawable = ResUtils.getDrawable(getContext(), "dxm_wallet_base_blue_397be6_btn");
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
        TextView textView = (TextView) findViewById(ResUtils.id(context, "wallet_base_btn_image"));
        this.a = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(getContext(), "wallet_access_button"));
        a();
    }

    private void a() {
        Drawable drawable = ResUtils.getDrawable(getContext(), "wallet_base_cashdesk_order_btn_img_selector");
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.a.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public TextView getNextBtn() {
        return this.a;
    }

    public void setDrawableLeftVisible(boolean z) {
        if (z) {
            a();
        } else {
            this.a.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setText(CharSequence charSequence) {
        this.a.setText(charSequence);
    }
}
