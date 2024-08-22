package com.baidu.searchbox.http;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.statistics.NetworkStat;
import fe.fe.ddd.p001switch.i.ad;
import fe.fe.ddd.p001switch.p002if.fe;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import org.json.JSONObject;

public interface IHttpContext {
    public static final IHttpContext qw = new qw();

    public class qw implements IHttpContext {
        public ad ad() {
            return null;
        }

        public IClientIPProvider de() {
            return null;
        }

        public fe.fe.ddd.p001switch.i.qw fe() {
            return null;
        }

        public boolean ggg(String str, int i2, Headers headers) {
            return false;
        }

        public CookieManager i(boolean z, boolean z2) {
            return CookieManager.qw;
        }

        /* renamed from: if  reason: not valid java name */
        public void m43if() {
        }

        public boolean o() {
            return false;
        }

        public int pf() {
            return 0;
        }

        public boolean ppp(fe feVar) {
            return false;
        }

        public NetworkStat<Request> qw() {
            return null;
        }

        public boolean rg() {
            return false;
        }

        /* renamed from: switch  reason: not valid java name */
        public IHttpDns m44switch(fe feVar) {
            return null;
        }

        public boolean th(String str) {
            return false;
        }

        public void uk(JSONObject jSONObject) {
        }

        public EventListener when() {
            return null;
        }

        public IHttpDns yj() {
            return null;
        }
    }

    ad ad();

    IClientIPProvider de();

    fe.fe.ddd.p001switch.i.qw fe();

    boolean ggg(String str, int i2, Headers headers);

    CookieManager i(boolean z, boolean z2);

    /* renamed from: if  reason: not valid java name */
    void m41if();

    boolean o();

    int pf();

    boolean ppp(fe feVar);

    NetworkStat<Request> qw();

    boolean rg();

    /* renamed from: switch  reason: not valid java name */
    IHttpDns m42switch(fe feVar);

    boolean th(String str);

    void uk(JSONObject jSONObject);

    EventListener when();

    IHttpDns yj();
}
