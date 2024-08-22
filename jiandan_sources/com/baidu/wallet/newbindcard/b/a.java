package com.baidu.wallet.newbindcard.b;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.baidu.aiscan.R;
import com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity;
import com.baidu.wallet.paysdk.datamodel.DxmAddress;
import com.baidu.wallet.paysdk.datamodel.DxmJob;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.dxmpay.wallet.core.beans.BeanConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class a implements IBeanResponseCallback {
    public Handler a;
    public NewBindCardMainActivity b;

    public a(NewBindCardMainActivity newBindCardMainActivity) {
        this.b = newBindCardMainActivity;
    }

    private Handler r() {
        if (this.a == null) {
            this.a = new Handler(this.b.getMainLooper());
        }
        return this.a;
    }

    private int s() {
        String format = new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(format) && format.length() == 4) {
            try {
                return Integer.parseInt(format.substring(2, 4));
            } catch (Exception unused) {
            }
        }
        return 18;
    }

    public abstract void a();

    public abstract void a(int i2, int i3, String str);

    public abstract void a(int i2, Object obj, String str);

    public abstract void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public abstract void a(Bundle bundle);

    public void a(View view, int i2) {
        int color;
        float dimension;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i2 == 1) {
                color = ResUtils.getColor(this.b, "wallet_cashdesk_new_bind_card_2222");
                dimension = ResUtils.getDimension(this.b, "wallet_cashdesk_new_bind_card_hasfocus_line_size");
            } else if (i2 == 2) {
                color = ResUtils.getColor(this.b, "wallet_cashdesk_new_bind_card_5050");
                dimension = ResUtils.getDimension(this.b, "wallet_cashdesk_new_bind_card_line_error_size");
            } else {
                color = ResUtils.getColor(this.b, "wallet_cashdesk_new_bind_card_E0EA");
                dimension = ResUtils.getDimension(this.b, "wallet_cashdesk_new_bind_card_line_size");
            }
            int i3 = (int) dimension;
            view.setBackgroundColor(color);
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    public abstract void a(EventBus.Event event);

    public abstract void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, DxmAddress dxmAddress, DxmJob dxmJob);

    public abstract boolean a(Context context);

    public abstract void b();

    public abstract void b(Context context);

    public boolean b(View view, SafeKeyBoardEditText safeKeyBoardEditText) {
        if (view.getVisibility() != 0 || !safeKeyBoardEditText.isEnabled()) {
            return false;
        }
        if (TextUtils.isEmpty(safeKeyBoardEditText.getText())) {
            return true;
        }
        return !CheckUtils.isBandCardEndAvailable(safeKeyBoardEditText.getText().toString());
    }

    public abstract void c();

    public void c(SafeKeyBoardEditText safeKeyBoardEditText, ImageView imageView) {
        String str;
        if (safeKeyBoardEditText != null && imageView != null) {
            imageView.setImageResource(R.drawable.dxm_wallet_base_tip_icon);
            imageView.setOnClickListener(this.b);
            int id = imageView.getId();
            if (id == R.id.iv_new_bind_card_name_tip_icon) {
                str = ResUtils.getString(this.b, "ebpay_name_title");
            } else if (id == R.id.iv_new_bind_card_date_icon) {
                str = ResUtils.getString(this.b, "ebpay_date_tip_title");
            } else if (id == R.id.iv_new_bind_card_phone_icon) {
                str = ResUtils.getString(this.b, "wallet_access_reserve_phone_des");
            } else {
                str = id == R.id.iv_new_bind_card_cvv2_icon ? ResUtils.getString(this.b, "ebpay_cvv2_tip_title") : "";
            }
            imageView.setContentDescription(str);
        }
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract boolean j();

    public abstract boolean k();

    public abstract boolean l();

    public abstract boolean m();

    public abstract boolean n();

    public abstract boolean o();

    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        r().post(new Runnable() {
            public void run() {
                a.this.a(i2, i3, str);
            }
        });
    }

    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        r().post(new Runnable() {
            public void run() {
                a.this.a(i2, obj, str);
            }
        });
    }

    public void p() {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.a = null;
        }
        this.b = null;
    }

    public boolean q() {
        return "walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) || "walletapppro".equalsIgnoreCase(BeanConstants.CHANNEL_ID);
    }

    public void b(final SafeKeyBoardEditText safeKeyBoardEditText, ImageView imageView) {
        String str;
        if (safeKeyBoardEditText != null && imageView != null) {
            imageView.setImageResource(R.drawable.dxm_wallet_base_delete);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    safeKeyBoardEditText.setText("");
                }
            });
            if (imageView.getId() == R.id.iv_new_bind_card_phone_icon) {
                str = ResUtils.getString(this.b, "wallet_access_clean_phone");
            } else {
                str = ResUtils.getString(this.b, "wallet_access_clean");
            }
            imageView.setContentDescription(str);
        }
    }

    public void a(SafeKeyBoardEditText safeKeyBoardEditText, String str) {
        if (safeKeyBoardEditText != null) {
            if ("1".equals(str)) {
                List<IEditTextPasteFilter> editTextPasteFilters = safeKeyBoardEditText.getEditTextPasteFilters();
                if (editTextPasteFilters != null) {
                    editTextPasteFilters.clear();
                    editTextPasteFilters.add(new IDCardEditTextPasteFilter());
                }
                safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
                safeKeyBoardEditText.setUseSafeKeyBoard(true);
                safeKeyBoardEditText.setUseKeyX(true);
                return;
            }
            List<IEditTextPasteFilter> editTextPasteFilters2 = safeKeyBoardEditText.getEditTextPasteFilters();
            if (editTextPasteFilters2 != null) {
                editTextPasteFilters2.clear();
                editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
            }
            safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(40)});
            safeKeyBoardEditText.setUseSafeKeyBoard(false);
            safeKeyBoardEditText.setUseKeyX(false);
        }
    }

    public void a(EditText editText) {
        if (editText != null) {
            if (editText.getText() == null || editText.getText().length() <= 0) {
                editText.setTypeface(Typeface.defaultFromStyle(0));
            } else {
                editText.setTypeface(Typeface.defaultFromStyle(1));
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.View r5, com.dxmpay.wallet.base.widget.SafeKeyBoardEditText r6) {
        /*
            r4 = this;
            int r5 = r5.getVisibility()
            r0 = 0
            if (r5 != 0) goto L_0x0055
            boolean r5 = r6.isEnabled()
            if (r5 == 0) goto L_0x0055
            android.text.Editable r5 = r6.getText()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r1 = 1
            if (r5 == 0) goto L_0x0019
            return r1
        L_0x0019:
            android.text.Editable r5 = r6.getText()
            java.lang.String r5 = r5.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0054
            int r6 = r5.length()
            r2 = 5
            if (r6 == r2) goto L_0x002f
            goto L_0x0054
        L_0x002f:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0054 }
            if (r6 != 0) goto L_0x0045
            r6 = 2
            java.lang.String r6 = r5.substring(r0, r6)     // Catch:{ Exception -> 0x0054 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x0054 }
            if (r6 <= 0) goto L_0x0044
            r3 = 12
            if (r6 <= r3) goto L_0x0045
        L_0x0044:
            return r1
        L_0x0045:
            r6 = 3
            java.lang.String r5 = r5.substring(r6, r2)     // Catch:{  }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{  }
            int r6 = r4.s()     // Catch:{  }
            if (r5 >= r6) goto L_0x0055
        L_0x0054:
            return r1
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.newbindcard.b.a.a(android.view.View, com.dxmpay.wallet.base.widget.SafeKeyBoardEditText):boolean");
    }

    public boolean a(View view, DivisionEditText divisionEditText, boolean z) {
        return view.getVisibility() == 0 && divisionEditText.isEnabled() && !z && !CheckUtils.isMobileAvailable(divisionEditText.getRealText());
    }

    public boolean a(View view, SafeKeyBoardEditText safeKeyBoardEditText, GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, boolean z) {
        return view.getVisibility() == 0 && safeKeyBoardEditText.isEnabled() && certificateTypeInfo != null && !z && !certificateTypeInfo.getValidator().a(safeKeyBoardEditText.getText());
    }

    public void a(SafeKeyBoardEditText safeKeyBoardEditText, ImageView imageView) {
        if (safeKeyBoardEditText != null && imageView != null) {
            if (TextUtils.isEmpty(safeKeyBoardEditText.getText()) || !safeKeyBoardEditText.isEnabled() || !safeKeyBoardEditText.hasFocus()) {
                c(safeKeyBoardEditText, imageView);
            } else {
                b(safeKeyBoardEditText, imageView);
            }
        }
    }

    public boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (motionEvent.getX() < ((float) i2) || motionEvent.getX() > ((float) (i2 + view.getWidth())) || motionEvent.getY() < ((float) i3) || motionEvent.getY() > ((float) (i3 + view.getHeight()))) {
            return false;
        }
        return true;
    }
}
