package com.baidu.apollon.restnet;

import org.json.JSONObject;

public class a {
    public b a;

    /* renamed from: com.baidu.apollon.restnet.a$a  reason: collision with other inner class name */
    public static class C0029a {
        public static final a a = new a();
    }

    public interface b {
        void send(b bVar);

        void send(JSONObject jSONObject);
    }

    public static a a() {
        return C0029a.a;
    }

    public a() {
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(b bVar) {
        b bVar2 = this.a;
        if (bVar2 != null && bVar != null) {
            bVar2.send(bVar);
        }
    }

    public void a(JSONObject jSONObject) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.send(jSONObject);
        }
    }
}
