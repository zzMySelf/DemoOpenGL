package com.baidu.wallet.paysdk.ui.widget.compliance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.s;
import com.baidu.wallet.paysdk.datamodel.DxmJob;
import com.baidu.wallet.paysdk.ui.widget.compliance.a.a;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.c;
import com.baidu.wallet.paysdk.ui.widget.compliance.view.LinkageWheelLayout;
import com.dlife.ctaccountapi.v;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.lollipop.json.JSONArray;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DxmShowJobActivity extends DxmCompliancePickerBaseActivity implements View.OnClickListener {
    public static c c;
    public ArrayList<a> a = new ArrayList<>();
    public Map<String, ArrayList<a>> b = new HashMap();
    public s d;
    public a e;
    public LinkageWheelLayout f;
    public int g;
    public int h;

    public static void startActivity(Context context, c cVar) {
        c = cVar;
        Intent intent = new Intent(context, DxmShowJobActivity.class);
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
        StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_JOB, "1");
        c cVar = c;
        if (cVar != null) {
            cVar.a(1, (DxmJob) null);
        }
        finishWithoutAnim();
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        if (obj != null && (obj instanceof String)) {
            try {
                JSONArray jSONArray = new JSONObject(obj.toString()).getJSONArray("content");
                if (jSONArray != null && jSONArray.length() > 0) {
                    if (jSONArray.optJSONObject(0) != null) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(0);
                        String optString = optJSONObject.optString("k");
                        String optString2 = optJSONObject.optString(v.d);
                        this.g = 0;
                        this.h = 0;
                        a aVar = new a();
                        this.e = aVar;
                        aVar.b(optString);
                        this.e.a(optString2);
                        JSONArray optJSONArray = optJSONObject.optJSONArray("lower");
                        if (!(optJSONArray == null || optJSONArray.length() <= 0 || optJSONArray.optJSONObject(0) == null)) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                            ArrayList arrayList = new ArrayList();
                            a aVar2 = new a();
                            aVar2.a(optJSONObject2.optString(v.d));
                            aVar2.b(optJSONObject2.optString("k"));
                            arrayList.add(aVar2);
                            this.b.put(optString, arrayList);
                        }
                    }
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject optJSONObject3 = jSONArray.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            a(optJSONObject3);
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onClick(View view) {
        a aVar;
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.mBtnSubmit) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_JOB, "0");
            if (this.e != null) {
                DxmJob dxmJob = new DxmJob();
                dxmJob.jobName = this.e.a();
                dxmJob.jobId = this.e.b();
                Map<String, ArrayList<a>> map = this.b;
                if (!(map == null || map.get(this.e.b()) == null || this.b.get(this.e.b()).size() <= this.h || (aVar = (a) this.b.get(this.e.b()).get(this.h)) == null)) {
                    dxmJob.lowerJobName = aVar.a();
                    dxmJob.lowerJobId = aVar.b();
                }
                c cVar = c;
                if (cVar != null) {
                    cVar.a(0, dxmJob);
                }
            }
            finishWithoutAnim();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTvTipTxt.setText(ResUtils.getString(this, "dxm_pickerview_job_tip"));
        a();
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f = null;
        Map<String, ArrayList<a>> map = this.b;
        if (map != null) {
            map.clear();
            this.b = null;
        }
        ArrayList<a> arrayList = this.a;
        if (arrayList != null) {
            arrayList.clear();
            this.a = null;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a aVar;
        if (this.f != null) {
            Map<String, ArrayList<a>> map = this.b;
            if (map == null || map.size() <= 0 || (aVar = this.e) == null || TextUtils.isEmpty(aVar.b())) {
                this.f.setFirstData(this.a);
                this.f.setSecondData((List<a>) null);
            } else {
                this.f.setFirstData(this.a);
                this.f.setSecondData(this.b.get(this.e.b()));
            }
            this.f.setThirdData((List<a>) null);
            this.f.setSelectValue(this.g, this.h, 0);
        }
    }

    private void b() {
        s sVar = new s(this);
        this.d = sVar;
        sVar.setResponseCallback(this);
        this.d.execBean();
    }

    private void a() {
        this.mLinDate.post(new Runnable() {
            public void run() {
                LinkageWheelLayout unused = DxmShowJobActivity.this.f = new LinkageWheelLayout(DxmShowJobActivity.this);
                DxmShowJobActivity dxmShowJobActivity = DxmShowJobActivity.this;
                dxmShowJobActivity.mLinDate.addView(dxmShowJobActivity.f);
                DxmShowJobActivity.this.f.setVisibleItemCount(DxmShowJobActivity.this.getVisibleItemCount());
                DxmShowJobActivity.this.f.setOnLinkageSelectedListener(new com.baidu.wallet.paysdk.ui.widget.compliance.c.c() {
                    public void a(int i2) {
                        int unused = DxmShowJobActivity.this.g = i2;
                        int unused2 = DxmShowJobActivity.this.h = 0;
                        DxmShowJobActivity dxmShowJobActivity = DxmShowJobActivity.this;
                        a unused3 = dxmShowJobActivity.e = (a) dxmShowJobActivity.a.get(i2);
                        if (DxmShowJobActivity.this.e != null && !TextUtils.isEmpty(DxmShowJobActivity.this.e.b())) {
                            DxmShowJobActivity.this.c();
                        }
                    }

                    public void b(int i2) {
                        int unused = DxmShowJobActivity.this.h = i2;
                    }

                    public void c(int i2) {
                    }
                });
            }
        });
    }

    private void a(final JSONObject jSONObject) {
        if (Build.VERSION.SDK_INT < 17 || (!isDestroyed() && !isFinishing())) {
            runOnUiThread(new Runnable() {
                public void run() {
                    if (jSONObject != null) {
                        a aVar = new a();
                        String optString = jSONObject.optString("k");
                        aVar.a(jSONObject.optString(v.d));
                        aVar.b(optString);
                        DxmShowJobActivity.this.a.add(aVar);
                        JSONArray optJSONArray = jSONObject.optJSONArray("lower");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                                if (optJSONObject != null) {
                                    a aVar2 = new a();
                                    aVar2.a(optJSONObject.optString(v.d));
                                    aVar2.b(optJSONObject.optString("k"));
                                    arrayList.add(aVar2);
                                    DxmShowJobActivity.this.b.put(optString, arrayList);
                                }
                            }
                        }
                        DxmShowJobActivity.this.c();
                    }
                }
            });
        }
    }
}
