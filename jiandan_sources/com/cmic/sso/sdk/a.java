package com.cmic.sso.sdk;

import com.cmic.sso.sdk.a.a;
import com.cmic.sso.sdk.e.c;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    public ConcurrentHashMap<String, Object> a;

    public a(int i2) {
        this.a = new ConcurrentHashMap<>(i2);
    }

    public void a(String str, byte[] bArr) {
        if (str != null && bArr != null) {
            this.a.put(str, bArr);
        }
    }

    public String b(String str) {
        return b(str, "");
    }

    public int c(String str) {
        return b(str, 0);
    }

    public byte[] a(String str) {
        if (str != null) {
            return (byte[]) this.a.get(str);
        }
        return null;
    }

    public String b(String str, String str2) {
        return (str == null || !this.a.containsKey(str)) ? str2 : (String) this.a.get(str);
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }

    public void a(String str, boolean z) {
        if (str != null) {
            this.a.put(str, Boolean.valueOf(z));
        }
    }

    public boolean b(String str, boolean z) {
        return (str == null || !this.a.containsKey(str)) ? z : ((Boolean) this.a.get(str)).booleanValue();
    }

    public void a(String str, int i2) {
        if (str != null) {
            this.a.put(str, Integer.valueOf(i2));
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            this.a.put(str, Long.valueOf(j));
        }
    }

    public int b(String str, int i2) {
        return (str == null || !this.a.containsKey(str)) ? i2 : ((Integer) this.a.get(str)).intValue();
    }

    public void a(com.cmic.sso.sdk.d.a aVar) {
        if (aVar != null) {
            this.a.put("logBean", aVar);
        }
    }

    public com.cmic.sso.sdk.d.a a() {
        com.cmic.sso.sdk.d.a aVar = (com.cmic.sso.sdk.d.a) this.a.get("logBean");
        if (aVar != null) {
            return aVar;
        }
        return new com.cmic.sso.sdk.d.a();
    }

    public long b(String str, long j) {
        return (str == null || !this.a.containsKey(str)) ? j : ((Long) this.a.get(str)).longValue();
    }

    public void a(com.cmic.sso.sdk.a.a aVar) {
        if (aVar != null) {
            this.a.put("current_config", aVar);
        }
    }

    public com.cmic.sso.sdk.a.a b() {
        com.cmic.sso.sdk.a.a aVar = (com.cmic.sso.sdk.a.a) this.a.get("current_config");
        if (aVar != null) {
            return aVar;
        }
        c.a("UmcConfigBean为空", "请核查");
        return new a.C0177a().a();
    }
}
