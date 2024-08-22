package com.baidu.wallet.paysdk.ui.widget.compliance;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanConstants;

public class DxmCompliancePickerBaseActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener {
    public View mBtnSubmit;
    public LinearLayout mLinDate;
    public TextView mTvSubmitTxt;
    public TextView mTvTipTxt;

    private void a() {
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setContentDescription("返回");
        this.mLeftImg.setImageResource(ResUtils.drawable(this, "dxm_wallet_base_actionbar_back_arrow"));
        this.mBtnSubmit = findViewById(R.id.btn_compliance_wheel_submit);
        this.mTvTipTxt = (TextView) findViewById(R.id.tv_compliance_wheel_tip);
        TextView textView = (TextView) findViewById(R.id.tv_red_button_txt);
        this.mTvSubmitTxt = textView;
        textView.setText(ResUtils.getString(this, "bd_wallet_auth_cancel_auth"));
        this.mLinDate = (LinearLayout) findViewById(R.id.lin_compliance_wheel);
        this.mLeftImg.setOnClickListener(this);
        this.mBtnSubmit.setOnClickListener(this);
        if (PayRequestCache.getInstance().isPaying()) {
            this.mBtnSubmit.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
        } else if ("walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) || "walletapppro".equalsIgnoreCase(BeanConstants.CHANNEL_ID)) {
            this.mBtnSubmit.setBackgroundResource(R.drawable.dxm_wallet_base_red_fa5050_btn);
        } else {
            this.mBtnSubmit.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
        }
        this.mLinDate.removeAllViews();
    }

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_compliance_wheel_layout"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public int getVisibleItemCount() {
        int height = this.mLinDate.getHeight();
        if (height < 500) {
            return 3;
        }
        if (height < 1000) {
            return 5;
        }
        if (height < 1300) {
            return 7;
        }
        if (height < 1800) {
            return 9;
        }
        return height < 2300 ? 11 : 13;
    }

    public void onBackPressed() {
        finishWithoutAnim();
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mLinDate.removeAllViews();
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }
}
