package fe.fe.p004if.qw.rg;

import android.content.Context;
import com.baidu.lcp.sdk.request.HttpExecutor;

/* renamed from: fe.fe.if.qw.rg.qw  reason: invalid package */
public abstract class qw implements HttpExecutor.HttpRequest, HttpExecutor.ResponseHandler {
    public Context qw;

    public String getMethod() {
        return "POST";
    }
}
