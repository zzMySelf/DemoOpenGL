package com.baidu.poly.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.poly.R;
import com.baidu.poly.wallet.calculate.CalculatePriceCallBack;
import com.baidu.poly.widget.coupon.CouponEntity;
import com.baidu.poly.widget.coupon.CouponListView;
import java.util.List;

/* compiled from: SearchBox */
public class CouponListDialog extends Dialog {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CouponListView f17157a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f17158b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f17159c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public OnChooseCouponListener f17160d;

    /* compiled from: SearchBox */
    public interface OnChooseCouponListener {
        void onSelectedResult(boolean z, CouponEntity.CouponItem couponItem);
    }

    /* compiled from: SearchBox */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view2) {
            if (!(CouponListDialog.this.f17157a == null || CouponListDialog.this.f17160d == null)) {
                CouponListDialog.this.f17160d.onSelectedResult(false, CouponListDialog.this.f17157a.getSelectedItem());
            }
            CouponListDialog.this.dismiss();
        }
    }

    /* compiled from: SearchBox */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (CouponListDialog.this.f17157a != null && CouponListDialog.this.f17160d != null) {
                CouponListDialog.this.f17160d.onSelectedResult(false, CouponListDialog.this.f17157a.getSelectedItem());
            }
        }
    }

    public CouponListDialog(Context context) {
        this(context, R.style.CashierSDK_CommonDialog);
    }

    public void setListener(OnChooseCouponListener onChooseCouponListener) {
        this.f17160d = onChooseCouponListener;
    }

    public void update(List<CouponEntity.CouponItem> list) {
        CouponListView couponListView = this.f17157a;
        if (couponListView != null) {
            couponListView.a(list, (com.baidu.poly.widget.duvip.b) null);
            this.f17157a.setListener(new c());
        }
    }

    private CouponListDialog(Context context, int i2) {
        super(context, i2);
        a();
    }

    private void a() {
        setContentView(R.layout.dialog_couponlist_cashiersdk);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setWindowAnimations(R.style.cashier_coupon_dialog_anim);
            window.setLayout(-1, -2);
        }
        this.f17157a = (CouponListView) findViewById(R.id.cashier_couponlist_view);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.cashier_fl_title_content);
        this.f17159c = frameLayout;
        frameLayout.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f17158b = imageView;
        imageView.setOnClickListener(new a());
        setOnCancelListener(new b());
    }

    /* compiled from: SearchBox */
    class c implements CouponListView.g {
        c() {
        }

        public void a() {
        }

        public void a(boolean z, CouponEntity.CouponItem couponItem) {
            CouponListDialog.this.dismiss();
            if (CouponListDialog.this.f17160d != null) {
                CouponListDialog.this.f17160d.onSelectedResult(z, couponItem);
            }
        }

        public void b() {
        }

        public void a(boolean z, CouponEntity.CouponItem couponItem, CalculatePriceCallBack calculatePriceCallBack) {
            CalculatePriceCallBack.Data data = new CalculatePriceCallBack.Data();
            data.statusCode = 0;
            calculatePriceCallBack.onResult(data);
        }
    }
}
