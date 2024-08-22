package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;

@SuppressLint({"AppCompatCustomView"})
public class SwitchButton extends ImageButton {
    public boolean a;
    public boolean b = false;

    public interface a {
        void a(boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
        a();
    }

    public boolean isChanged() {
        return this.a == this.b;
    }

    public boolean isChecked() {
        return this.a;
    }

    public void resetChecked() {
        this.b = this.a;
    }

    public void setChecked(boolean z) {
        if (z) {
            setBackgroundResource(ResUtils.drawable(getContext(), "dxm_wallet_base_btn_pressed_on"));
        } else {
            setBackgroundResource(ResUtils.drawable(getContext(), "dxm_wallet_base_btn_default_off"));
        }
        this.a = z;
        AccessibilityUtils.setContentDescription(this, !z ? "开" : "关");
    }

    public void setOnCheckedListener(final a aVar) {
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(!SwitchButton.this.a);
                }
            }
        });
    }

    private void a() {
        setBackgroundResource(ResUtils.drawable(getContext(), "dxm_wallet_base_btn_default_off"));
        AccessibilityUtils.setContentDescription(this, !this.a ? "开" : "关");
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
