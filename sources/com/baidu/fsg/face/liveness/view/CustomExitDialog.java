package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.baidu.fsg.face.R;

public class CustomExitDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f12487a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f12488b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f12489c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f12490d;

    public CustomExitDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    public CustomExitDialog(Context context, int theme) {
        super(context, theme);
        a();
    }

    public CustomExitDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_exit);
        setCanceledOnTouchOutside(false);
        this.f12487a = (TextView) findViewById(R.id.exit_dialog_title);
        this.f12488b = (TextView) findViewById(R.id.exit_dialog_content);
        this.f12489c = (TextView) findViewById(R.id.exit_dialog_positive);
        this.f12490d = (TextView) findViewById(R.id.exit_dialog_negative);
    }

    public void setDialogTitle(String title) {
        this.f12487a.setText(title);
    }

    public void setDialogContext(String context) {
        this.f12488b.setVisibility(0);
        this.f12488b.setText(context);
    }

    public void setPositiveText(String btnText, View.OnClickListener onClickListener) {
        this.f12489c.setText(btnText);
        this.f12489c.setOnClickListener(onClickListener);
    }

    public void setNegativeText(String btnText, View.OnClickListener onClickListener) {
        this.f12490d.setText(btnText);
        this.f12490d.setOnClickListener(onClickListener);
    }
}
