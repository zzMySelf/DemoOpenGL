package com.alipay.sdk.m.d0;

import com.alipay.sdk.m.z.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

public class b implements Runnable {
    public final /* synthetic */ DataReportRequest a;
    public final /* synthetic */ c b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.b = cVar;
        this.a = dataReportRequest;
    }

    public void run() {
        try {
            DataReportResult unused = c.e = this.b.c.reportData(this.a);
        } catch (Throwable th2) {
            DataReportResult unused2 = c.e = new DataReportResult();
            c.e.success = false;
            DataReportResult a2 = c.e;
            a2.resultCode = "static data rpc upload error, " + a.a(th2);
            new StringBuilder("rpc failed:").append(a.a(th2));
        }
    }
}
