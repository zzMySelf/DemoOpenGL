package fe.fe.ddd.p001switch.p002if;

import com.baidubce.util.Mimetypes;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* renamed from: fe.fe.ddd.switch.if.uk  reason: invalid package */
public class uk extends fe<qw> {
    public static final MediaType j = MediaType.parse(Mimetypes.MIMETYPE_OCTET_STREAM);
    public byte[] g;
    public MediaType h;

    /* renamed from: fe.fe.ddd.switch.if.uk$qw */
    public static class qw extends rg<qw> {
        public MediaType a;
        public byte[] tt;

        public qw(fe.fe.ddd.p001switch.qw qwVar) {
            super(qwVar);
        }

        /* renamed from: if  reason: not valid java name */
        public qw m85if(byte[] bArr) {
            this.tt = bArr;
            return this;
        }

        /* renamed from: pf */
        public uk ad() {
            return new uk(this);
        }
    }

    public uk(qw qwVar) {
        super(qwVar);
    }

    public Request ad(RequestBody requestBody) {
        return this.f33if.post(requestBody).build();
    }

    public RequestBody de() {
        byte[] bArr = this.g;
        if (bArr == null || bArr.length <= 0) {
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return RequestBody.create(this.h, bArr);
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
