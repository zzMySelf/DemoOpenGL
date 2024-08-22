package fe.fe.ddd.p001switch.p002if;

import com.baidubce.util.Mimetypes;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* renamed from: fe.fe.ddd.switch.if.i  reason: invalid package */
public class i extends fe<qw> {
    public static final MediaType j = MediaType.parse(Mimetypes.MIMETYPE_OCTET_STREAM);
    public File g;
    public MediaType h;

    /* renamed from: fe.fe.ddd.switch.if.i$qw */
    public static class qw extends rg<qw> {
        public MediaType a;
        public File tt;

        public qw(fe.fe.ddd.p001switch.qw qwVar) {
            super(qwVar);
        }

        /* renamed from: if  reason: not valid java name */
        public qw m82if(File file) {
            this.tt = file;
            return this;
        }

        /* renamed from: pf */
        public i ad() {
            return new i(this);
        }
    }

    public i(qw qwVar) {
        super(qwVar);
    }

    public Request ad(RequestBody requestBody) {
        return this.f33if.post(requestBody).build();
    }

    public RequestBody de() {
        File file = this.g;
        if (file != null) {
            return RequestBody.create(this.h, file);
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    /* renamed from: vvv */
    public void when(qw qwVar) {
        this.g = qwVar.tt;
        MediaType o2 = qwVar.a;
        this.h = o2;
        if (o2 == null) {
            this.h = j;
        }
    }
}
