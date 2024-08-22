package fe.nn.qw.th;

import com.alipay.sdk.m.p.e;
import com.baidu.sapi2.utils.SapiUtils;
import com.tekartik.sqflite.operation.OperationResult;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class de extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public final qw f8787ad = new qw(this);

    /* renamed from: de  reason: collision with root package name */
    public final boolean f8788de;
    public final Map<String, Object> qw;

    public class qw implements OperationResult {

        /* renamed from: ad  reason: collision with root package name */
        public String f8789ad;

        /* renamed from: de  reason: collision with root package name */
        public String f8790de;

        /* renamed from: fe  reason: collision with root package name */
        public Object f8791fe;
        public Object qw;

        public qw(de deVar) {
        }

        public void error(String str, String str2, Object obj) {
            this.f8789ad = str;
            this.f8790de = str2;
            this.f8791fe = obj;
        }

        public void success(Object obj) {
            this.qw = obj;
        }
    }

    public de(Map<String, Object> map, boolean z) {
        this.qw = map;
        this.f8788de = z;
    }

    public boolean fe() {
        return this.f8788de;
    }

    public OperationResult i() {
        return this.f8787ad;
    }

    /* renamed from: if  reason: not valid java name */
    public Map<String, Object> m1016if() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.f8787ad.qw);
        return hashMap;
    }

    public String o() {
        return (String) this.qw.get(e.s);
    }

    public Map<String, Object> pf() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", this.f8787ad.f8789ad);
        hashMap2.put("message", this.f8787ad.f8790de);
        hashMap2.put("data", this.f8787ad.f8791fe);
        hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, hashMap2);
        return hashMap;
    }

    public void ppp(List<Map<String, Object>> list) {
        if (!fe()) {
            list.add(m1016if());
        }
    }

    public <T> T qw(String str) {
        return this.qw.get(str);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1017switch(MethodChannel.Result result) {
        qw qwVar = this.f8787ad;
        result.error(qwVar.f8789ad, qwVar.f8790de, qwVar.f8791fe);
    }

    public void when(List<Map<String, Object>> list) {
        if (!fe()) {
            list.add(pf());
        }
    }
}
