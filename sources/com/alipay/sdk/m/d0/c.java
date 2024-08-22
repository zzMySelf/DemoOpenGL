package com.alipay.sdk.m.d0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.sdk.m.z.a;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

public class c implements a {

    /* renamed from: d  reason: collision with root package name */
    public static c f2134d;

    /* renamed from: e  reason: collision with root package name */
    public static DataReportResult f2135e;

    /* renamed from: a  reason: collision with root package name */
    public w f2136a = null;

    /* renamed from: b  reason: collision with root package name */
    public BugTrackMessageService f2137b = null;

    /* renamed from: c  reason: collision with root package name */
    public DataReportService f2138c = null;

    public c(Context context, String str) {
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f2136a = hVar;
        this.f2137b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f2138c = (DataReportService) this.f2136a.a(DataReportService.class, aaVar);
    }

    public static synchronized c a(Context context, String str) {
        c cVar;
        synchronized (c.class) {
            if (f2134d == null) {
                f2134d = new c(context, str);
            }
            cVar = f2134d;
        }
        return cVar;
    }

    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f2138c != null) {
            f2135e = null;
            new Thread(new b(this, dataReportRequest)).start();
            int i2 = 300000;
            while (f2135e == null && i2 >= 0) {
                Thread.sleep(50);
                i2 -= 50;
            }
        }
        return f2135e;
    }

    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (a.a(str) || (bugTrackMessageService = this.f2137b) == null) {
            return false;
        }
        String str2 = null;
        try {
            str2 = bugTrackMessageService.logCollect(a.f(str));
        } catch (Throwable th2) {
        }
        if (!a.a(str2)) {
            return ((Boolean) new JSONObject(str2).get("success")).booleanValue();
        }
        return false;
    }
}
