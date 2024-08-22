package com.baidu.wallet.paysdk.ui.widget.compliance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.b;
import com.baidu.wallet.paysdk.ui.widget.compliance.e.a;
import com.baidu.wallet.paysdk.ui.widget.compliance.entity.DateEntity;
import com.baidu.wallet.paysdk.ui.widget.compliance.view.DateWheelLayout;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Calendar;

public class DxmShowDateActivity extends DxmCompliancePickerBaseActivity implements View.OnClickListener {
    public static final int START_DAY = 1;
    public static final int START_MONTH = 0;
    public static final int START_YEAR = 1970;
    public static Calendar a;
    public static Calendar b;
    public static b c;
    public DateWheelLayout d;

    private void c() {
        this.mLinDate.post(new Runnable() {
            public void run() {
                DateWheelLayout unused = DxmShowDateActivity.this.d = new DateWheelLayout(DxmShowDateActivity.this);
                DxmShowDateActivity dxmShowDateActivity = DxmShowDateActivity.this;
                dxmShowDateActivity.mLinDate.addView(dxmShowDateActivity.d);
                DxmShowDateActivity.this.d.setRange(DateEntity.target(DxmShowDateActivity.a), DateEntity.target(DxmShowDateActivity.b), DateEntity.today());
                DxmShowDateActivity.this.d.setDateMode(0);
                DxmShowDateActivity.this.d.setDateFormatter(new a());
                DxmShowDateActivity.this.d.setVisibleItemCount(DxmShowDateActivity.this.getVisibleItemCount());
            }
        });
    }

    public static void startActivity(Context context, Calendar calendar, Calendar calendar2, b bVar) {
        a = calendar;
        b = calendar2;
        c = bVar;
        Intent intent = new Intent(context, DxmShowDateActivity.class);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).startActivityWithoutAnim(intent);
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void onBackPressed() {
        StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_DATE, "1");
        b bVar = c;
        if (bVar != null) {
            bVar.a(1, (String) null);
        }
        finishWithoutAnim();
    }

    public void onClick(View view) {
        String str;
        String str2;
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.mBtnSubmit) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_DATE, "0");
            if (this.d.getSelectedMonth() < 10) {
                str = "0" + this.d.getSelectedMonth();
            } else {
                str = this.d.getSelectedMonth() + "";
            }
            if (this.d.getSelectedDay() < 10) {
                str2 = "0" + this.d.getSelectedDay();
            } else {
                str2 = this.d.getSelectedDay() + "";
            }
            String str3 = this.d.getSelectedYear() + "-" + str + "-" + str2;
            b bVar = c;
            if (bVar != null) {
                bVar.a(0, str3);
            }
            finishWithoutAnim();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTvTipTxt.setText(ResUtils.getString(this, "dxm_pickerview_date_tip"));
        c();
    }

    public void onDestroy() {
        super.onDestroy();
        this.d = null;
    }
}
