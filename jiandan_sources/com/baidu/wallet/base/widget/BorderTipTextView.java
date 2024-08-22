package com.baidu.wallet.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;

public class BorderTipTextView extends TextView {
    public int a = getPaddingLeft();
    public int b = getPaddingRight();
    public int c = getPaddingTop();
    public int d = getPaddingBottom();
    public ColorStateList e = getTextColors();
    public Drawable f = getBackground();

    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (z) {
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
            setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            setText(charSequence);
            setPadding(6, 0, 6, 2);
            return;
        }
        setBackgroundDrawable(this.f);
        setTextColor(this.e);
        setText(charSequence);
        setPadding(this.a, this.c, this.b, this.d);
    }
}
