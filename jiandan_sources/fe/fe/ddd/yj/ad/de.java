package fe.fe.ddd.yj.ad;

import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import java.util.HashMap;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public Object f1745ad;

    /* renamed from: de  reason: collision with root package name */
    public HashMap<String, String> f1746de;

    /* renamed from: fe  reason: collision with root package name */
    public Object f1747fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public Object f1748rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f1749th;

    /* renamed from: yj  reason: collision with root package name */
    public IProcessorDataInterceptor f1750yj;

    public de(String str, Object obj, HashMap<String, String> hashMap, Object obj2) {
        this.qw = str;
        this.f1745ad = obj;
        this.f1746de = hashMap;
        this.f1747fe = obj2;
    }

    public IProcessorDataInterceptor ad() {
        return this.f1750yj;
    }

    public Object de() {
        return this.f1748rg;
    }

    public Object fe() {
        return this.f1745ad;
    }

    public Object qw() {
        return this.f1747fe;
    }

    public HashMap<String, String> rg() {
        if (this.f1746de == null) {
            this.f1746de = new HashMap<>();
        }
        return this.f1746de;
    }

    public String th() {
        return this.qw;
    }

    public boolean yj() {
        return this.f1749th;
    }

    public de(String str, Object obj, HashMap<String, String> hashMap, Object obj2, Object obj3) {
        this.qw = str;
        this.f1745ad = obj;
        this.f1746de = hashMap;
        this.f1747fe = obj2;
        this.f1748rg = obj3;
    }
}
