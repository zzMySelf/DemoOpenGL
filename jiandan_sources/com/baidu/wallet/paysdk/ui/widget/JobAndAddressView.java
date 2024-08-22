package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.datamodel.DxmAddress;
import com.baidu.wallet.paysdk.datamodel.DxmJob;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.c;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.utils.StatHelper;

@SuppressLint({"NewApi"})
public class JobAndAddressView extends LinearLayout {
    public static final String JOB_RETIRE_ID = "10003";
    public static final String JOB_STUDENT_ID = "10002";
    public LinearLayout a;
    public View b;
    public TextView c;
    public TextView d;
    public DxmJob e;
    public DxmAddress f;
    public View mAddressArea;
    public View mJobArea;
    public LinearLayout mLinAddress;
    public LinearLayout mLinJob;

    public interface a {
        void a();
    }

    public JobAndAddressView(Context context) {
        super(context);
        a();
    }

    public DxmAddress getAddressTip() {
        if (this.mAddressArea.getVisibility() != 0 || TextUtils.isEmpty(this.d.getText())) {
            return null;
        }
        return this.f;
    }

    public DxmJob getJobTip() {
        if (this.mJobArea.getVisibility() != 0 || TextUtils.isEmpty(this.c.getText())) {
            return null;
        }
        return this.e;
    }

    public void hideAllComplianceView() {
        this.a.setVisibility(8);
        this.c.setText("");
        this.d.setText("");
        this.e = null;
        this.f = null;
    }

    public void setAddressStatus(final BaseActivity baseActivity, boolean z, boolean z2, final a aVar) {
        if (!z || !z2) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
        }
        if (z2) {
            this.a.setVisibility(0);
            this.mAddressArea.setVisibility(0);
            this.mLinAddress.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_ADDRESS);
                    com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a().a(baseActivity, JobAndAddressView.this.f, new com.baidu.wallet.paysdk.ui.widget.compliance.b.a() {
                        public void a(int i2, DxmAddress dxmAddress) {
                            if (i2 == 0 && dxmAddress != null) {
                                DxmAddress unused = JobAndAddressView.this.f = dxmAddress;
                                TextView c = JobAndAddressView.this.d;
                                c.setText(dxmAddress.provinceName + dxmAddress.cityName + dxmAddress.countyName + dxmAddress.address);
                            }
                            a aVar = aVar;
                            if (aVar != null) {
                                aVar.a();
                            }
                        }
                    });
                }
            });
            return;
        }
        this.mAddressArea.setVisibility(8);
    }

    public void setJobStatus(boolean z, boolean z2, final int i2, final a aVar) {
        if (!z || !z2) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
        }
        if (z) {
            this.a.setVisibility(0);
            this.mJobArea.setVisibility(0);
            this.mLinJob.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_JOB);
                    com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a().a(JobAndAddressView.this.getContext(), new c() {
                        public void a(int i2, DxmJob dxmJob) {
                            if (i2 == 0 && dxmJob != null) {
                                if ((i2 < 45 || !"10002".equals(dxmJob.lowerJobId)) && (i2 > 16 || !"10003".equals(dxmJob.lowerJobId))) {
                                    DxmJob unused = JobAndAddressView.this.e = dxmJob;
                                    if (!TextUtils.isEmpty(dxmJob.lowerJobName)) {
                                        JobAndAddressView.this.c.setText(dxmJob.lowerJobName);
                                    } else {
                                        JobAndAddressView.this.c.setText(dxmJob.jobName);
                                    }
                                } else {
                                    DxmJob unused2 = JobAndAddressView.this.e = null;
                                    JobAndAddressView.this.c.setText((CharSequence) null);
                                    GlobalUtils.toast(JobAndAddressView.this.getContext(), ResUtils.getString(JobAndAddressView.this.getContext(), "dxm_choice_job_err_tip"));
                                }
                            }
                            a aVar = aVar;
                            if (aVar != null) {
                                aVar.a();
                            }
                        }
                    });
                }
            });
            return;
        }
        this.mJobArea.setVisibility(8);
    }

    public JobAndAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_pay_bind_card_job_address_view"), this);
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getContext(), "lin_job_and_address"));
        this.a = linearLayout;
        linearLayout.setVisibility(0);
        this.mJobArea = findViewById(ResUtils.id(getContext(), "job_area"));
        this.mAddressArea = findViewById(ResUtils.id(getContext(), "address_area"));
        this.mLinJob = (LinearLayout) findViewById(ResUtils.id(getContext(), "lin_job"));
        this.mLinAddress = (LinearLayout) findViewById(ResUtils.id(getContext(), "lin_address"));
        this.c = (TextView) findViewById(ResUtils.id(getContext(), "tv_job"));
        this.d = (TextView) findViewById(ResUtils.id(getContext(), "tv_address"));
        this.b = findViewById(ResUtils.id(getContext(), "view_line"));
    }

    public JobAndAddressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
