package com.dxmpay.perm.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.utils.DisplayUtils;

public class MerVerticalTwoActionDialog extends Dialog implements View.OnClickListener, NoProguard {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public a e;
    public b f;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public MerVerticalTwoActionDialog(@NonNull Context context) {
        super(context, R.style.DXMMerShadeDialog);
        a();
    }

    private void a() {
        Window window = getWindow();
        window.requestFeature(1);
        setContentView(R.layout.dxm_dialog_vertical_two_action);
        window.setGravity(17);
        window.setBackgroundDrawableResource(17170445);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        b();
    }

    private void b() {
        this.a = (TextView) findViewById(R.id.tv_title);
        this.b = (TextView) findViewById(R.id.tv_content);
        this.c = (TextView) findViewById(R.id.tv_one_action);
        this.d = (TextView) findViewById(R.id.tv_two_action);
        if (getContext() != null) {
            findViewById(R.id.ll_content).setBackground(a(getContext(), -1, 5.0f));
            this.c.setBackground(a(getContext(), Color.parseColor("#FA5050"), 22.0f));
        }
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    public void onClick(View view) {
        b bVar;
        int id = view.getId();
        if (id == R.id.tv_one_action) {
            a aVar = this.e;
            if (aVar != null) {
                aVar.a();
            }
        } else if (id == R.id.tv_two_action && (bVar = this.f) != null) {
            bVar.a();
        }
    }

    public MerVerticalTwoActionDialog setActionOne(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setText(str);
        }
        this.e = aVar;
        return this;
    }

    public MerVerticalTwoActionDialog setActionTwo(String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            this.d.setText(str);
        }
        this.f = bVar;
        return this;
    }

    public MerVerticalTwoActionDialog setContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.setText(str);
        }
        return this;
    }

    public MerVerticalTwoActionDialog setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.setText(str);
        }
        return this;
    }

    public MerVerticalTwoActionDialog(@NonNull Context context, int i2) {
        super(context, i2);
        a();
    }

    public MerVerticalTwoActionDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }

    private GradientDrawable a(Context context, @ColorInt int i2, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((float) DisplayUtils.dip2px(context, f2));
        return gradientDrawable;
    }
}
