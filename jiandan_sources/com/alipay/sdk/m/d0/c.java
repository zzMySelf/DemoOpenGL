package com.alipay.sdk.m.d0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.sdk.m.e0.a;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.baidu.sapi2.views.SmsLoginView;
import org.json.JSONObject;

public class c implements a {
    public static c d;
    public static DataReportResult e;
    public w a = null;
    public BugTrackMessageService b = null;
    public DataReportService c = null;

    public c(Context context, String str) {
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.a = hVar;
        this.b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.c = (DataReportService) this.a.a(DataReportService.class, aaVar);
    }

    public static synchronized c a(Context context, String str) {
        c cVar;
        synchronized (c.class) {
            if (d == null) {
                d = new c(context, str);
            }
            cVar = d;
        }
        return cVar;
    }

    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.c != null) {
            e = null;
            new Thread(new b(this, dataReportRequest)).start();
            int i2 = a.a;
            while (e == null && i2 >= 0) {
                Thread.sleep(50);
                i2 -= 50;
            }
        }
        return e;
    }

    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (com.alipay.sdk.m.z.a.a(str) || (bugTrackMessageService = this.b) == null) {
            return false;
        }
        String str2 = null;
        try {
            str2 = bugTrackMessageService.logCollect(com.alipay.sdk.m.z.a.f(str));
        } catch (Throwable unused) {
        }
        if (!com.alipay.sdk.m.z.a.a(str2)) {
            return ((Boolean) new JSONObject(str2).get(SmsLoginView.f.k)).booleanValue();
        }
        return false;
    }
}
