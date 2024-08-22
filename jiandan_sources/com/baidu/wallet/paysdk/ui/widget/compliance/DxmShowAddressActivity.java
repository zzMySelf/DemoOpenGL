package com.baidu.wallet.paysdk.ui.widget.compliance;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.q;
import com.baidu.wallet.paysdk.beans.r;
import com.baidu.wallet.paysdk.beans.u;
import com.baidu.wallet.paysdk.datamodel.DxmAddress;
import com.baidu.wallet.paysdk.ui.widget.compliance.a.a;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.c;
import com.baidu.wallet.paysdk.ui.widget.compliance.view.LinkageWheelLayout;
import com.dlife.ctaccountapi.v;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.lollipop.json.JSONArray;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DxmShowAddressActivity extends DxmCompliancePickerBaseActivity implements View.OnClickListener {
    public List<a> a = new ArrayList();
    public List<a> b = new ArrayList();
    public List<a> c = new ArrayList();
    public Map<String, List<a>> d = new HashMap();
    public Map<String, List<a>> e = new HashMap();
    public a f;
    public a g;
    public a h;

    /* renamed from: i  reason: collision with root package name */
    public int f3634i;
    public int j;
    public int k;
    public q l;
    public r m;
    public LinkageWheelLayout n;

    public void onBackPressed() {
        StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_ADDRESS, "1");
        finishWithoutAnim();
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        if (i2 == 26) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.f3634i = 0;
            this.j = 0;
            this.k = 0;
            this.f = null;
            this.g = null;
            this.h = null;
            c();
        } else if (b(i2)) {
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.j = 0;
            this.k = 0;
            this.g = null;
            this.h = null;
            c();
        } else if (c(i2)) {
            this.c = new ArrayList();
            this.k = 0;
            this.h = null;
            c();
        }
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        if (obj != null && (obj instanceof String)) {
            try {
                JSONArray optJSONArray = new JSONObject(obj.toString()).optJSONArray("content");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    if (optJSONArray.getJSONObject(0) != null) {
                        if (!TextUtils.isEmpty(optJSONArray.getJSONObject(0).optString("k"))) {
                            String optString = optJSONArray.getJSONObject(0).optString("k");
                            String optString2 = optJSONArray.getJSONObject(0).optString(v.d);
                            if (i2 == 26) {
                                this.a = new ArrayList();
                                this.b = new ArrayList();
                                this.c = new ArrayList();
                                this.f3634i = 0;
                                this.j = 0;
                                this.k = 0;
                                this.g = null;
                                this.h = null;
                                a aVar = new a();
                                this.f = aVar;
                                aVar.b(optString);
                                this.f.a(optString2);
                                a(optString);
                            } else if (b(i2)) {
                                this.b = new ArrayList();
                                this.c = new ArrayList();
                                this.j = 0;
                                this.k = 0;
                                this.h = null;
                                a aVar2 = new a();
                                this.g = aVar2;
                                aVar2.b(optString);
                                this.g.a(optString2);
                                b(optString);
                            } else if (c(i2)) {
                                this.c = new ArrayList();
                                this.k = 0;
                                a aVar3 = new a();
                                this.h = aVar3;
                                aVar3.b(optString);
                                this.h.a(optString2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        if (jSONObject != null) {
                            a aVar4 = new a();
                            aVar4.a(jSONObject.optString(v.d));
                            aVar4.b(jSONObject.optString("k"));
                            if (i2 == 26) {
                                this.a.add(aVar4);
                            } else if (b(i2)) {
                                this.b.add(aVar4);
                            } else if (c(i2)) {
                                this.c.add(aVar4);
                            }
                        }
                    }
                    if (this.b != null && this.b.size() > 0 && b(i2)) {
                        this.d.put(this.f.b(), this.b);
                    }
                    if (this.c != null && this.c.size() > 0 && c(i2)) {
                        this.e.put(this.g.b(), this.c);
                    }
                } else if (c(i2)) {
                    this.c = new ArrayList();
                    this.k = 0;
                    this.h = null;
                }
                c();
            } catch (JSONException e2) {
                LogUtil.errord(e2.toString());
            }
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.mBtnSubmit) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.CLICK_CHOICE_ADDRESS, "0");
            DxmAddress dxmAddress = new DxmAddress();
            a aVar = this.f;
            if (aVar != null) {
                dxmAddress.provinceId = aVar.b();
                dxmAddress.provinceName = this.f.a();
            }
            a aVar2 = this.g;
            if (aVar2 != null) {
                dxmAddress.cityId = aVar2.b();
                dxmAddress.cityName = this.g.a();
            }
            a aVar3 = this.h;
            if (aVar3 != null) {
                dxmAddress.countyId = aVar3.b();
                dxmAddress.countyName = this.h.a();
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable(DxmShowDetailedAddressActivity.GET_ADDRESS_DATA, dxmAddress);
            intent.putExtras(bundle);
            setResult(1, intent);
            finishWithoutAnim();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTvTipTxt.setText(ResUtils.getString(this, "dxm_pickerview_address_tip"));
        a();
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.n = null;
        List<a> list = this.a;
        if (list != null) {
            list.clear();
            this.a = null;
        }
        List<a> list2 = this.b;
        if (list2 != null) {
            list2.clear();
            this.b = null;
        }
        List<a> list3 = this.c;
        if (list3 != null) {
            list3.clear();
            this.c = null;
        }
        Map<String, List<a>> map = this.d;
        if (map != null) {
            map.clear();
            this.d = null;
        }
        Map<String, List<a>> map2 = this.e;
        if (map2 != null) {
            map2.clear();
            this.e = null;
        }
        List<a> list4 = this.c;
        if (list4 != null) {
            list4.clear();
            this.c = null;
        }
        this.f = null;
        this.g = null;
        this.h = null;
        this.l = null;
        this.m = null;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (Build.VERSION.SDK_INT < 17 || (!isDestroyed() && !isFinishing())) {
            runOnUiThread(new Runnable() {
                public void run() {
                    if (DxmShowAddressActivity.this.n != null) {
                        DxmShowAddressActivity.this.n.setFirstData(DxmShowAddressActivity.this.a);
                        DxmShowAddressActivity.this.n.setSecondData(DxmShowAddressActivity.this.b);
                        DxmShowAddressActivity.this.n.setThirdData(DxmShowAddressActivity.this.c);
                        DxmShowAddressActivity.this.n.setSelectValue(DxmShowAddressActivity.this.f3634i, DxmShowAddressActivity.this.j, DxmShowAddressActivity.this.k);
                    }
                }
            });
        }
    }

    private void b() {
        u uVar = new u(this);
        uVar.setResponseCallback(this);
        uVar.execBean();
    }

    private void a() {
        this.mLinDate.post(new Runnable() {
            public void run() {
                LinkageWheelLayout unused = DxmShowAddressActivity.this.n = new LinkageWheelLayout(DxmShowAddressActivity.this);
                DxmShowAddressActivity dxmShowAddressActivity = DxmShowAddressActivity.this;
                dxmShowAddressActivity.mLinDate.addView(dxmShowAddressActivity.n);
                DxmShowAddressActivity.this.n.setVisibleItemCount(DxmShowAddressActivity.this.getVisibleItemCount());
                DxmShowAddressActivity.this.n.setOnLinkageSelectedListener(new c() {
                    public void a(int i2) {
                        if (DxmShowAddressActivity.this.a != null && DxmShowAddressActivity.this.a.size() > 0) {
                            DxmShowAddressActivity dxmShowAddressActivity = DxmShowAddressActivity.this;
                            a unused = dxmShowAddressActivity.f = (a) dxmShowAddressActivity.a.get(i2);
                            int unused2 = DxmShowAddressActivity.this.f3634i = i2;
                            a unused3 = DxmShowAddressActivity.this.g = null;
                            a unused4 = DxmShowAddressActivity.this.h = null;
                            int unused5 = DxmShowAddressActivity.this.j = 0;
                            int unused6 = DxmShowAddressActivity.this.k = 0;
                            List unused7 = DxmShowAddressActivity.this.b = new ArrayList();
                            List unused8 = DxmShowAddressActivity.this.c = new ArrayList();
                            if (DxmShowAddressActivity.this.f != null) {
                                String b = DxmShowAddressActivity.this.f.b();
                                if (DxmShowAddressActivity.this.d == null || DxmShowAddressActivity.this.d.size() <= 0) {
                                    DxmShowAddressActivity.this.a(b);
                                    return;
                                }
                                List list = (List) DxmShowAddressActivity.this.d.get(b);
                                if (list == null || list.size() <= 0) {
                                    DxmShowAddressActivity.this.a(b);
                                    return;
                                }
                                List unused9 = DxmShowAddressActivity.this.b = list;
                                DxmShowAddressActivity dxmShowAddressActivity2 = DxmShowAddressActivity.this;
                                a unused10 = dxmShowAddressActivity2.g = (a) dxmShowAddressActivity2.b.get(0);
                                if (DxmShowAddressActivity.this.g == null || TextUtils.isEmpty(DxmShowAddressActivity.this.g.b()) || DxmShowAddressActivity.this.e == null || DxmShowAddressActivity.this.e.size() <= 0) {
                                    DxmShowAddressActivity.this.a(b);
                                    return;
                                }
                                String b2 = DxmShowAddressActivity.this.g.b();
                                List list2 = (List) DxmShowAddressActivity.this.e.get(b2);
                                if (list2 == null || list2.size() <= 0) {
                                    DxmShowAddressActivity.this.b(b2);
                                    return;
                                }
                                List unused11 = DxmShowAddressActivity.this.c = list2;
                                DxmShowAddressActivity dxmShowAddressActivity3 = DxmShowAddressActivity.this;
                                a unused12 = dxmShowAddressActivity3.h = (a) dxmShowAddressActivity3.c.get(0);
                                DxmShowAddressActivity.this.c();
                            }
                        }
                    }

                    public void b(int i2) {
                        if (DxmShowAddressActivity.this.b != null && DxmShowAddressActivity.this.b.size() > 0) {
                            DxmShowAddressActivity dxmShowAddressActivity = DxmShowAddressActivity.this;
                            a unused = dxmShowAddressActivity.g = (a) dxmShowAddressActivity.b.get(i2);
                            int unused2 = DxmShowAddressActivity.this.j = i2;
                            int unused3 = DxmShowAddressActivity.this.k = 0;
                            a unused4 = DxmShowAddressActivity.this.h = null;
                            List unused5 = DxmShowAddressActivity.this.c = new ArrayList();
                            if (DxmShowAddressActivity.this.g != null) {
                                String b = DxmShowAddressActivity.this.g.b();
                                if (DxmShowAddressActivity.this.e == null || DxmShowAddressActivity.this.e.size() <= 0) {
                                    DxmShowAddressActivity.this.b(b);
                                    return;
                                }
                                List list = (List) DxmShowAddressActivity.this.e.get(b);
                                if (list == null || list.size() <= 0) {
                                    DxmShowAddressActivity.this.b(b);
                                    return;
                                }
                                List unused6 = DxmShowAddressActivity.this.c = list;
                                DxmShowAddressActivity dxmShowAddressActivity2 = DxmShowAddressActivity.this;
                                a unused7 = dxmShowAddressActivity2.h = (a) dxmShowAddressActivity2.c.get(0);
                                DxmShowAddressActivity.this.c();
                            }
                        }
                    }

                    public void c(int i2) {
                        int unused = DxmShowAddressActivity.this.k = i2;
                        if (DxmShowAddressActivity.this.c != null && DxmShowAddressActivity.this.c.size() > i2) {
                            DxmShowAddressActivity dxmShowAddressActivity = DxmShowAddressActivity.this;
                            a unused2 = dxmShowAddressActivity.h = (a) dxmShowAddressActivity.c.get(i2);
                        }
                    }
                });
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r1.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(int r2) {
        /*
            r1 = this;
            r0 = 28
            if (r2 != r0) goto L_0x002a
            com.baidu.wallet.paysdk.beans.r r2 = r1.m
            if (r2 == 0) goto L_0x002a
            com.baidu.wallet.paysdk.ui.widget.compliance.a.a r0 = r1.g
            if (r0 == 0) goto L_0x002a
            java.lang.String r2 = r2.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x002a
            com.baidu.wallet.paysdk.beans.r r2 = r1.m
            java.lang.String r2 = r2.a()
            com.baidu.wallet.paysdk.ui.widget.compliance.a.a r0 = r1.g
            java.lang.String r0 = r0.b()
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x002a
            r2 = 1
            return r2
        L_0x002a:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowAddressActivity.c(int):boolean");
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        q qVar = new q(this);
        this.l = qVar;
        qVar.a(str);
        this.l.setResponseCallback(this);
        this.l.execBean();
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        r rVar = new r(this);
        this.m = rVar;
        rVar.a(str);
        this.m.setResponseCallback(this);
        this.m.execBean();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r1.l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(int r2) {
        /*
            r1 = this;
            r0 = 27
            if (r2 != r0) goto L_0x002a
            com.baidu.wallet.paysdk.beans.q r2 = r1.l
            if (r2 == 0) goto L_0x002a
            com.baidu.wallet.paysdk.ui.widget.compliance.a.a r0 = r1.f
            if (r0 == 0) goto L_0x002a
            java.lang.String r2 = r2.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x002a
            com.baidu.wallet.paysdk.beans.q r2 = r1.l
            java.lang.String r2 = r2.a()
            com.baidu.wallet.paysdk.ui.widget.compliance.a.a r0 = r1.f
            java.lang.String r0 = r0.b()
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x002a
            r2 = 1
            return r2
        L_0x002a:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowAddressActivity.b(int):boolean");
    }
}
