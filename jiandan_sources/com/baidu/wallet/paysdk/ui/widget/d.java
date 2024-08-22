package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;

public class d extends PopupWindow {
    public Context a;
    public View b;
    public ImageView c;
    public LinearLayout d;
    public a e;

    public interface a {
        void a(View view, GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, int i2);
    }

    public d(Context context) {
        super(context);
        if (context != null) {
            this.a = context;
            b();
        }
    }

    private void b() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.wallet_base_new_certificate_type_dialog, (ViewGroup) null);
        this.b = inflate;
        this.d = (LinearLayout) inflate.findViewById(R.id.lin_certificate_type_content);
        this.c = (ImageView) this.b.findViewById(R.id.iv_certificate_type_close);
        setTouchable(true);
        setFocusable(true);
        setOutsideTouchable(true);
        setWidth(((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getWidth());
        setBackgroundDrawable((Drawable) null);
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        setContentView(this.b);
    }

    public void a(final GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        this.d.removeAllViews();
        if (certificateTypeInfoArr != null && certificateTypeInfoArr.length > 0) {
            for (final int i2 = 0; i2 < certificateTypeInfoArr.length; i2++) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.wallet_base_new_certificate_type_item, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.view_certificate_type_line);
                ((TextView) inflate.findViewById(R.id.tv_certificate_type)).setText(certificateTypeInfoArr[i2].description);
                inflate.setContentDescription("证件类型选择，" + certificateTypeInfoArr[i2].description);
                AccessibilityUtils.changeRoleDescription(inflate, ResUtils.getString(this.a, "wallet_access_button"));
                if (i2 == certificateTypeInfoArr.length - 1) {
                    findViewById.setVisibility(8);
                }
                this.d.addView(inflate);
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (d.this.e != null) {
                            a a2 = d.this.e;
                            GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr = certificateTypeInfoArr;
                            int i2 = i2;
                            a2.a(view, certificateTypeInfoArr[i2], i2);
                        }
                        d.this.dismiss();
                    }
                });
            }
        }
    }

    public void a(View view) {
        showAtLocation(view, 81, 0, 0);
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a() {
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        this.a = null;
        this.e = null;
    }
}
