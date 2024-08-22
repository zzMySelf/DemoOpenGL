package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.wallet.paysdk.ui.widget.BankCardErrorMsgView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;

public abstract class a {
    public Context a;
    public ViewGroup b;
    public ImageView c;
    public TextView d;
    public SafeKeyBoardEditText e;
    public BankCardErrorMsgView f;
    public View g;

    public void a(Context context, int i2) {
        if (context != null) {
            this.a = context;
            this.b = (ViewGroup) LayoutInflater.from(context).inflate(ResUtils.layout(this.a, "wallet_cashdesk_bind_card_item"), (ViewGroup) null);
            this.d = (TextView) this.b.findViewById(ResUtils.id(this.a, "wallet_base_bindcard_item_title"));
            CharSequence d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                this.d.setText(d2);
            }
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.b.findViewById(ResUtils.id(this.a, "wallet_base_bindcard_item_value"));
            this.e = safeKeyBoardEditText;
            a(safeKeyBoardEditText);
            this.e.setCheckFunc(f());
            View findViewWithTag = this.b.findViewWithTag(ResUtils.getString(this.a, "wallet_base_string_bindcard_item_line_tag"));
            this.g = findViewWithTag;
            this.e.setTag(findViewWithTag);
            this.f = (BankCardErrorMsgView) this.b.findViewById(ResUtils.id(this.a, "wallet_bindcard_item_error"));
            ImageView imageView = (ImageView) this.b.findViewById(ResUtils.id(this.a, "wallet_base_bindcard_item_image"));
            this.c = imageView;
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (a.this.e.getEditableText().length() == 0) {
                        a.this.e();
                        return;
                    }
                    ((ImageView) view).setImageResource(ResUtils.drawable(a.this.a, "wallet_base_info_btn_selector"));
                    a.this.e.getEditableText().clear();
                    a.this.e.requestFocus();
                }
            });
            this.e.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    String str = TextUtils.isEmpty(editable.toString().trim()) ? "wallet_base_info_btn_selector" : "dxm_wallet_base_delete";
                    a aVar = a.this;
                    aVar.c.setImageResource(ResUtils.drawable(aVar.a, str));
                }

                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    a.this.a(true);
                }
            });
            this.e.setOnMyFocusChangeListener(new SafeKeyBoardEditText.OnMyFocusChangeListener() {
                public void onMyFocusChange(View view, boolean z) {
                    if (z) {
                        com.baidu.wallet.paysdk.ui.widget.a.a(a.this.e, false, true);
                    }
                }
            });
            return;
        }
        throw new NullPointerException("context null");
    }

    public abstract void a(SafeKeyBoardEditText safeKeyBoardEditText);

    public abstract CharSequence d();

    public abstract void e();

    public abstract SafeKeyBoardEditText.CheckFunc f();

    public void a(CharSequence charSequence) {
        this.f.showErrorLayout((CharSequence) null, charSequence);
        com.baidu.wallet.paysdk.ui.widget.a.a(this.b, true, false);
    }

    public void a(boolean z) {
        this.f.showErrorLayout((CharSequence) null, (CharSequence) null);
        com.baidu.wallet.paysdk.ui.widget.a.a(this.b, false, z);
    }
}
