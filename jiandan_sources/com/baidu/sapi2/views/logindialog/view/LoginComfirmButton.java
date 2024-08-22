package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;

public class LoginComfirmButton extends TextView {
    public Context a;

    public LoginComfirmButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a() {
        setBackground(this.a.getResources().getDrawable(R.drawable.selector_pass_quick_login_dialog_btn_bg));
    }

    public LoginComfirmButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoginComfirmButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        a();
    }
}
