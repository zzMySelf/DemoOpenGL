package com.vivo.push.b;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import com.vivo.push.a;
import com.vivo.push.o;
import com.vivo.push.util.u;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: ReporterCommand */
public final class x extends o {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f6324a;

    /* renamed from: b  reason: collision with root package name */
    private long f6325b;

    public x() {
        super(2012);
    }

    public x(long j2) {
        this();
        this.f6325b = j2;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f6324a = hashMap;
    }

    public final void c(a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", (Serializable) this.f6324a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f6325b);
    }

    public final void d(a aVar) {
        this.f6324a = (HashMap) aVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f6325b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f6325b);
    }

    public final String toString() {
        return "ReporterCommand（" + this.f6325b + ")";
    }

    public final void d() {
        if (this.f6324a == null) {
            u.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder append = new StringBuilder("report message reportType:").append(this.f6325b).append(",msgId:");
        String str = this.f6324a.get(IntentConstant.MESSAGE_ID);
        if (TextUtils.isEmpty(str)) {
            str = this.f6324a.get("message_id");
        }
        u.d("ReporterCommand", append.append(str).toString());
    }
}
