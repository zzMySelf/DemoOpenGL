package com.baidu.poly.controller;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.poly.model.b;
import com.baidu.poly.widget.c;
import com.baidu.swan.apps.pay.SwanAppPaymentManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: SearchBox */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private List<b> f16804a = new ArrayList();

    public void a(String str, boolean z, boolean z2) {
        a(b.a(str, z, z2));
    }

    public boolean b(String str) {
        b a2 = a(str);
        return a2 != null && a2.c();
    }

    private void a(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.a())) {
            if (this.f16804a.contains(bVar)) {
                this.f16804a.remove(bVar);
            }
            this.f16804a.add(bVar);
        }
    }

    public b a(String str) {
        if (!TextUtils.isEmpty(str) && this.f16804a.size() != 0) {
            for (b next : this.f16804a) {
                if (str.equalsIgnoreCase(next.a())) {
                    return next;
                }
            }
        }
        return null;
    }

    public void a(Bundle bundle, c cVar) {
        if (bundle != null && bundle.containsKey(SwanAppPaymentManager.KEY_AGREEMENT_GUIDE_INFO)) {
            String string = bundle.getString(SwanAppPaymentManager.KEY_AGREEMENT_GUIDE_INFO);
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            b a2 = b.a(jSONArray.optJSONObject(i2));
                            if (a2 != null) {
                                a(a2);
                                if (a2.a().equalsIgnoreCase(cVar.j())) {
                                    cVar.a(a2.b());
                                    cVar.b(a2.c());
                                }
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            bundle.remove(SwanAppPaymentManager.KEY_AGREEMENT_GUIDE_INFO);
        }
    }
}
