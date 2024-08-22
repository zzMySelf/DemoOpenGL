package fe.fe.ddd.p001switch.p002if;

import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* renamed from: fe.fe.ddd.switch.if.o  reason: invalid package */
public class o extends de<qw> {

    /* renamed from: fe.fe.ddd.switch.if.o$qw */
    public static class qw extends th<qw> {
        public qw(fe.fe.ddd.p001switch.qw qwVar) {
            super(qwVar);
        }

        /* renamed from: o */
        public o ad() {
            return new o(this);
        }
    }

    public o(qw qwVar) {
        super(qwVar);
    }

    public Request ad(RequestBody requestBody) {
        return this.f33if.post(requestBody).build();
    }

    public RequestBody de() {
        LinkedHashMap<String, String> linkedHashMap = this.g;
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry next : this.g.entrySet()) {
            builder.add((String) next.getKey(), (String) next.getValue());
        }
        return builder.build();
    }
}
