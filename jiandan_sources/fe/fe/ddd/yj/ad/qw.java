package fe.fe.ddd.yj.ad;

import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import java.util.HashMap;
import org.json.JSONObject;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public JSONObject f1754ad;

    /* renamed from: de  reason: collision with root package name */
    public HashMap<String, Object> f1755de;

    /* renamed from: fe  reason: collision with root package name */
    public ad f1756fe;
    public JSONObject qw;

    /* renamed from: rg  reason: collision with root package name */
    public HashMap<String, Boolean> f1757rg;

    /* renamed from: th  reason: collision with root package name */
    public rg f1758th;

    /* renamed from: yj  reason: collision with root package name */
    public HashMap<String, IProcessorDataInterceptor> f1759yj;

    public qw(JSONObject jSONObject) {
        this.qw = jSONObject;
    }

    public ad ad() {
        return this.f1756fe;
    }

    public rg de() {
        if (this.f1758th == null) {
            this.f1758th = new rg();
        }
        return this.f1758th;
    }

    public HashMap<String, IProcessorDataInterceptor> fe() {
        HashMap<String, IProcessorDataInterceptor> hashMap = this.f1759yj;
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    public void i(ad adVar) {
        this.f1756fe = adVar;
    }

    /* renamed from: if  reason: not valid java name */
    public void m94if(HashMap<String, Boolean> hashMap) {
        this.f1757rg = hashMap;
    }

    public void o(rg rgVar) {
        this.f1758th = rgVar;
    }

    public void pf(HashMap<String, IProcessorDataInterceptor> hashMap) {
        this.f1759yj = hashMap;
    }

    public HashMap<String, Object> qw() {
        if (this.f1755de == null) {
            this.f1755de = new HashMap<>();
        }
        return this.f1755de;
    }

    public HashMap<String, Boolean> rg() {
        if (this.f1757rg == null) {
            this.f1757rg = new HashMap<>();
        }
        return this.f1757rg;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m95switch(JSONObject jSONObject) {
        this.f1754ad = jSONObject;
    }

    public JSONObject th() {
        return this.f1754ad;
    }

    public void uk(HashMap<String, Object> hashMap) {
        this.f1755de = hashMap;
    }

    public JSONObject yj() {
        return this.qw;
    }

    public qw() {
    }
}
