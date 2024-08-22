package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.apollon.utils.ResUtils;

public class BdHalfActionBar extends FrameLayout {
    public ImageView a;
    public ImageView b;

    public BdHalfActionBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_half_action_bar"), this);
        this.a = (ImageView) findViewById(ResUtils.id(getContext(), "iv_half_back"));
        this.b = (ImageView) findViewById(ResUtils.id(getContext(), "iv_half_close"));
    }

    public void setIconBack(View.OnClickListener onClickListener) {
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setIconClose(View.OnClickListener onClickListener) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public BdHalfActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BdHalfActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public BdHalfActionBar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a();
    }
}
