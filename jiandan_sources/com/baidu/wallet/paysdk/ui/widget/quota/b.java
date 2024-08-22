package com.baidu.wallet.paysdk.ui.widget.quota;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.binding.BaseBinding;

public class b extends BaseBinding<c> {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f3640i;
    public final Button j;
    public final RelativeLayout k;
    public final LinearLayout l;

    public b(View view) {
        super(view);
        this.a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.b = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_left_tip_title"));
        this.c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_right_tip_title"));
        this.d = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_left_money_msg"));
        this.e = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_right_money_msg"));
        this.f = (TextView) view.findViewById(ResUtils.id(this.context, "tv_question"));
        this.g = (TextView) view.findViewById(ResUtils.id(this.context, "tv_answer"));
        this.j = (Button) view.findViewById(ResUtils.id(this.context, "btn_dialog_know"));
        this.h = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_one_tip_title"));
        this.f3640i = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_one_money_msg"));
        this.k = (RelativeLayout) view.findViewById(ResUtils.id(this.context, "relative_two_tip"));
        this.l = (LinearLayout) view.findViewById(ResUtils.id(this.context, "lin_one_tip"));
    }

    public void executeBindings() {
        if (!TextUtils.isEmpty(((c) this.viewModel).a)) {
            this.a.setText(((c) this.viewModel).a);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).b)) {
            this.b.setText(((c) this.viewModel).b);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).d)) {
            this.d.setText(((c) this.viewModel).d);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).c)) {
            this.c.setText(((c) this.viewModel).c);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).e)) {
            this.e.setText(((c) this.viewModel).e);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).f)) {
            this.f.setText(((c) this.viewModel).f);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).g)) {
            this.g.setText(((c) this.viewModel).g);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).b)) {
            this.h.setText(((c) this.viewModel).b);
        }
        if (!TextUtils.isEmpty(((c) this.viewModel).d)) {
            this.f3640i.setText(((c) this.viewModel).d);
        }
        if (((c) this.viewModel).h) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
        if (((c) this.viewModel).f3641i) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.j.setOnClickListener(((c) this.viewModel).j);
        T t = this.viewModel;
        if (((c) t).k != null) {
            this.j.setOnClickListener(((c) t).k);
        }
    }
}
