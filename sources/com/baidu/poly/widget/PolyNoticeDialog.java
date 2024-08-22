package com.baidu.poly.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.poly.R;

/* compiled from: SearchBox */
public class PolyNoticeDialog extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f17215a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17216b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f17217c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17218d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f17219e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17220f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17221g;

    /* renamed from: h  reason: collision with root package name */
    private a f17222h;

    /* compiled from: SearchBox */
    public interface a {
        void a();

        void a(int i2);

        void b();
    }

    public void a(String str) {
        this.f17218d.setVisibility(0);
        this.f17218d.setText(str);
        this.f17219e.setVisibility(8);
    }

    public void b(String str) {
        TextView textView = this.f17216b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void c(String str) {
        this.f17215a.setText(str);
    }

    public void onClick(View view2) {
        a aVar = this.f17222h;
        if (aVar != null) {
            aVar.a(view2.getId());
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.f17222h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.f17215a = (TextView) view2.findViewById(R.id.poly_notice_dialog_title);
        this.f17216b = (TextView) view2.findViewById(R.id.poly_notice_dialog_tips);
        this.f17217c = (ImageView) view2.findViewById(R.id.poly_notice_dialog_progress_view);
        this.f17218d = (TextView) view2.findViewById(R.id.poly_notice_dialog_single_btn);
        this.f17219e = (LinearLayout) view2.findViewById(R.id.poly_layout_action_of_btn);
        this.f17220f = (TextView) view2.findViewById(R.id.poly_notice_dialog_left_action_btn);
        this.f17221g = (TextView) view2.findViewById(R.id.poly_notice_dialog_right_action_btn);
        this.f17218d.setOnClickListener(this);
        this.f17220f.setOnClickListener(this);
        this.f17221g.setOnClickListener(this);
        a aVar = this.f17222h;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void c() {
        ImageView imageView = this.f17217c;
        if (imageView != null) {
            imageView.clearAnimation();
            this.f17217c.setVisibility(8);
        }
    }

    public void b() {
        this.f17217c.setVisibility(0);
        this.f17217c.startAnimation(AnimationUtils.loadAnimation(this.f17217c.getContext(), R.anim.loading_rotate));
    }

    public void a(String str, String str2) {
        this.f17218d.setVisibility(8);
        this.f17219e.setVisibility(0);
        this.f17220f.setText(str);
        this.f17221g.setText(str2);
    }

    public void a(boolean z) {
        TextView textView = this.f17221g;
        if (textView != null) {
            textView.setEnabled(z);
        }
    }

    public void a(a aVar) {
        this.f17222h = aVar;
    }

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.poly_notice_dialog_window;
    }
}
