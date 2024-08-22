package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;

@TargetApi(11)
public class BindCardHeadView extends LinearLayout {
    public ImageView a;
    public TextView b;
    public TextView c;
    public View d;
    public View e;

    public BindCardHeadView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_head_view"), this);
        this.a = (ImageView) findViewById(ResUtils.id(getContext(), "bind_card_img"));
        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_title"));
        this.b = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(getContext(), "wallet_access_button"));
        this.c = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_subtitle"));
        this.d = findViewById(ResUtils.id(getContext(), "bind_card_line"));
        this.e = findViewById(ResUtils.id(getContext(), "bind_card_head_bottom_margin"));
    }

    public void deleteSpan() {
        if (this.b.getText() instanceof SpannableString) {
            SpannableString spannableString = (SpannableString) this.b.getText();
            for (ClickableSpan removeSpan : (ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class)) {
                spannableString.removeSpan(removeSpan);
            }
            this.b.setText(spannableString);
        }
    }

    public void setImageSrcId(int i2) {
        this.a.setImageResource(i2);
    }

    public void setLineVisiable(boolean z) {
        int i2 = 0;
        this.d.setVisibility(z ? 0 : 8);
        View view = this.e;
        if (z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    public void setSubTitle(CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    public void setSubTitleVisibility(int i2) {
        this.c.setVisibility(i2);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.setText(charSequence);
        if (charSequence instanceof Spannable) {
            if (TextUtils.equals(String.valueOf(charSequence), ResUtils.getString(getContext(), "wallet_base_string_safeguard_entry"))) {
                this.b.setContentDescription(ResUtils.getString(getContext(), "wallet_access_safeguard_details"));
            } else {
                this.b.setContentDescription(charSequence);
            }
            this.b.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void setTitleVisiable(boolean z) {
        int i2 = 0;
        this.b.setVisibility(z ? 0 : 8);
        TextView textView = this.c;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public BindCardHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BindCardHeadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
