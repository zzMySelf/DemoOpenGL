package com.baidu.wallet.paysdk.ui.widget.compliance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.datamodel.DxmAddress;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.a;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;

public class DxmShowDetailedAddressActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener {
    public static final int ADDRESS_REQUEST_CODE = 1;
    public static final String GET_ADDRESS_DATA = "getAddressData";
    public static a a;
    public static DxmAddress k;
    public View b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public LinearLayout h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f3635i;
    public EditText j;

    public static void startActivity(Context context, DxmAddress dxmAddress, a aVar) {
        a = aVar;
        k = dxmAddress;
        Intent intent = new Intent(context, DxmShowDetailedAddressActivity.class);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).startActivityWithoutAnim(intent);
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_detail_address_layout"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (inRangeOfView(this.j, motionEvent)) {
                GlobalUtils.showInputMethod(this, this.j);
                this.f.setVisibility(8);
                this.f3635i.setVisibility(8);
                this.c.setVisibility(8);
            } else {
                GlobalUtils.hideInputMethod(this, this.j);
                this.f.setVisibility(0);
                this.f3635i.setVisibility(0);
                this.c.setVisibility(0);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean inRangeOfView(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (motionEvent.getX() < ((float) i2) || motionEvent.getX() > ((float) (i2 + view.getWidth())) || motionEvent.getY() < ((float) i3) || motionEvent.getY() > ((float) (i3 + view.getHeight()))) {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Serializable serializableExtra;
        if (intent != null && i2 == 1 && (serializableExtra = intent.getSerializableExtra(GET_ADDRESS_DATA)) != null && (serializableExtra instanceof DxmAddress)) {
            k = (DxmAddress) serializableExtra;
            TextView textView = this.e;
            textView.setText(k.provinceName + k.cityName + k.countyName);
        }
    }

    public void onBackPressed() {
        StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_DETAIL_ADDRESS, "1");
        a aVar = a;
        if (aVar != null) {
            aVar.a(1, (DxmAddress) null);
        }
        finishWithoutAnim();
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.b) {
            if (TextUtils.isEmpty(this.e.getText())) {
                GlobalUtils.toast(this, ResUtils.getString(this, "dxm_choice_location"));
            } else if (TextUtils.isEmpty(this.j.getText()) || this.j.getText().length() <= 5) {
                a(true);
            } else {
                StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_DETAIL_ADDRESS, "0");
                if (!(a == null || k == null || this.j.getText() == null)) {
                    k.address = this.j.getText().toString();
                    a.a(0, k);
                }
                finishWithoutAnim();
            }
        } else if (view == this.h) {
            StatisticManager.onEvent(PayStatServiceEvent.CLICK_GET_ADDRESS);
            startActivityForResultWithoutAnim(new Intent(this, DxmShowAddressActivity.class), 1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void a() {
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setContentDescription("返回");
        this.mLeftImg.setImageResource(ResUtils.drawable(this, "dxm_wallet_base_actionbar_back_arrow"));
        this.b = findViewById(R.id.btn_detail_address_submit);
        this.d = (TextView) findViewById(R.id.tv_red_button_txt);
        this.f = (TextView) findViewById(R.id.tv_detail_address_tip);
        this.d.setText(ResUtils.getString(this, "bd_wallet_auth_cancel_auth"));
        this.f3635i = (LinearLayout) findViewById(R.id.lin_address_view);
        this.h = (LinearLayout) findViewById(R.id.lin_address);
        this.j = (EditText) findViewById(R.id.et_detail_address);
        this.e = (TextView) findViewById(R.id.tv_address);
        this.c = findViewById(R.id.view_line);
        this.g = (TextView) findViewById(R.id.tv_detail_address_err);
        a(false);
        this.mLeftImg.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.h.setOnClickListener(this);
        if (PayRequestCache.getInstance().isPaying()) {
            this.b.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
        } else if ("walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) || "walletapppro".equalsIgnoreCase(BeanConstants.CHANNEL_ID)) {
            this.b.setBackgroundResource(R.drawable.dxm_wallet_base_red_fa5050_btn);
        } else {
            this.b.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
        }
        this.j.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 5) {
                    DxmShowDetailedAddressActivity.this.a(false);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (k != null) {
            TextView textView = this.e;
            textView.setText(k.provinceName + k.cityName + k.countyName);
            this.j.setText(k.address);
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.j.setBackgroundResource(R.drawable.wallet_cashdesk_detail_address_err_bg);
            this.g.setVisibility(0);
            return;
        }
        this.j.setBackgroundResource(R.drawable.wallet_cashdesk_detail_address_bg);
        this.g.setVisibility(8);
    }
}
