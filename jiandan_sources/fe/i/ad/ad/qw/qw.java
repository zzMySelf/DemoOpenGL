package fe.i.ad.ad.qw;

import android.content.Context;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.statistics.NetStepStatManager;

public class qw implements RestHttpRequestInterceptor {
    public SMManagerDelegate qw;

    public qw(SMManagerDelegate sMManagerDelegate) {
        this.qw = sMManagerDelegate;
    }

    public void qw(Context context, d dVar) {
        if (dVar == null || !(dVar instanceof RestUrlConnectionRequest)) {
            SMManagerDelegate sMManagerDelegate = this.qw;
            if (sMManagerDelegate != null) {
                sMManagerDelegate.closeSMCipher();
                return;
            }
            return;
        }
        RestUrlConnectionRequest restUrlConnectionRequest = (RestUrlConnectionRequest) dVar;
        if (this.qw != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.qw.reqeustParamsInterceptor(context, restUrlConnectionRequest);
            NetStepStatManager.getInstance().recordSMEncryptCost(dVar.h(), dVar.g(), System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
