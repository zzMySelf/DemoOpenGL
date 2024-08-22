package com.cmic.sso.sdk.c.b;

import com.cmic.sso.sdk.e.d;
import org.json.JSONObject;

public abstract class g {
    public abstract String a();

    public abstract String a_(String str);

    public abstract JSONObject b();

    public String v(String str) {
        return d.a(a_(str)).toLowerCase();
    }
}
