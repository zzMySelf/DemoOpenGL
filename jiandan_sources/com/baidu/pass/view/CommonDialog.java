package com.baidu.pass.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.pass.a;

public class CommonDialog extends Dialog implements a {

    public static class qw implements a {

        /* renamed from: ad  reason: collision with root package name */
        public Context f927ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f928i = false;

        /* renamed from: if  reason: not valid java name */
        public String f11if;

        /* renamed from: o  reason: collision with root package name */
        public String f929o;

        /* renamed from: pf  reason: collision with root package name */
        public View.OnClickListener f930pf;

        /* renamed from: switch  reason: not valid java name */
        public View.OnClickListener f12switch;

        /* renamed from: th  reason: collision with root package name */
        public CharSequence f931th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f932uk;
        public int when;

        /* renamed from: yj  reason: collision with root package name */
        public String f933yj;

        public class ad implements View.OnClickListener {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ CommonDialog f934ad;

            public ad(CommonDialog commonDialog) {
                this.f934ad = commonDialog;
            }

            public void onClick(View view) {
                qw.this.f930pf.onClick(view);
                this.f934ad.dismiss();
            }
        }

        /* renamed from: com.baidu.pass.view.CommonDialog$qw$qw  reason: collision with other inner class name */
        public class C0036qw implements View.OnClickListener {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ CommonDialog f936ad;

            public C0036qw(CommonDialog commonDialog) {
                this.f936ad = commonDialog;
            }

            public void onClick(View view) {
                qw.this.f12switch.onClick(view);
                this.f936ad.dismiss();
            }
        }

        public qw(Context context) {
            this.f927ad = context;
        }

        public CommonDialog de() {
            View inflate = LayoutInflater.from(this.f927ad).inflate(R.layout.pass_sdk_base_ui_common_dialog, (ViewGroup) null);
            CommonDialog commonDialog = new CommonDialog(this.f927ad, R.style.pass_base_ui_common_dialog_style);
            TextView textView = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_content);
            View findViewById = inflate.findViewById(R.id.pass_base_ui_dialog_horizontal_split_line);
            TextView textView3 = (TextView) inflate.findViewById(R.id.negative_btn);
            TextView textView4 = (TextView) inflate.findViewById(R.id.positive_btn);
            View findViewById2 = inflate.findViewById(R.id.pass_base_ui_dialog_vertical_split_line);
            textView.setText(this.f933yj);
            textView2.setText(TextUtils.isEmpty(this.f931th) ? "" : this.f931th);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setHighlightColor(0);
            int i2 = this.when;
            if (i2 > 0) {
                textView2.setGravity(i2);
            }
            textView3.setText(this.f11if);
            textView3.setOnClickListener(new C0036qw(commonDialog));
            textView4.setText(this.f929o);
            textView4.setOnClickListener(new ad(commonDialog));
            commonDialog.setContentView(inflate);
            commonDialog.setCancelable(this.f928i);
            commonDialog.setCanceledOnTouchOutside(this.f928i);
            Window window = commonDialog.getWindow();
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 30;
            attributes.y = 30;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            if (this.f932uk) {
                inflate.findViewById(R.id.pass_base_ui_dialog_root_view).setBackgroundResource(R.drawable.pass_base_ui_common_dialog_dark_bg);
                textView.setTextColor(this.f927ad.getResources().getColor(R.color.pass_base_ui_dialog_title_dark_text_color));
                textView2.setTextColor(this.f927ad.getResources().getColor(R.color.pass_base_ui_dialog_content_text_dark_color));
                findViewById.setBackgroundColor(this.f927ad.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
                textView3.setTextColor(this.f927ad.getResources().getColor(R.color.pass_base_ui_dialog_negative_btn_text_dark_color));
                textView4.setTextColor(this.f927ad.getResources().getColor(R.color.pass_base_ui_dialog_positive_btn_text_dark_color));
                findViewById2.setBackgroundColor(this.f927ad.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
            }
            Context context = this.f927ad;
            if (context instanceof Activity) {
                Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
                WindowManager.LayoutParams attributes2 = commonDialog.getWindow().getAttributes();
                attributes.width = defaultDisplay.getWidth();
                attributes.height = -2;
                commonDialog.getWindow().setAttributes(attributes2);
            }
            return commonDialog;
        }

        public qw fe(boolean z) {
            this.f932uk = z;
            return this;
        }

        public qw rg(CharSequence charSequence) {
            this.f931th = charSequence;
            return this;
        }

        public qw th(String str, View.OnClickListener onClickListener) {
            this.f11if = str;
            this.f12switch = onClickListener;
            return this;
        }

        public qw uk(String str) {
            this.f933yj = str;
            return this;
        }

        public qw yj(String str, View.OnClickListener onClickListener) {
            this.f929o = str;
            this.f930pf = onClickListener;
            return this;
        }
    }

    public CommonDialog(Context context, int i2) {
        super(context, i2);
    }
}
