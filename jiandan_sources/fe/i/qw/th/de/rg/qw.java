package fe.i.qw.th.de.rg;

import android.content.Context;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.http.HttpDefines$HttpMethod;
import com.dxmpay.apollon.restnet.rest.RestHttpNetwork;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnection;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import java.util.List;

public class qw {
    public static qw qw;

    public static synchronized qw ad() {
        qw qwVar;
        synchronized (qw.class) {
            if (qw == null) {
                qw = new qw();
            }
            qwVar = qw;
        }
        return qwVar;
    }

    public d qw(Context context, String str, String str2, String str3, HttpDefines$HttpMethod httpDefines$HttpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str4, boolean z) {
        Context context2 = context;
        String str5 = str2;
        return new RestUrlConnectionRequest(new RestHttpNetwork(new RestUrlConnection(context, str2, z)), str3, httpDefines$HttpMethod, list, restMultipartEntity, str4);
    }
}
