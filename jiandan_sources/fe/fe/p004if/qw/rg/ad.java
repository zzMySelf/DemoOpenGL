package fe.fe.p004if.qw.rg;

import android.content.Context;
import android.util.ArrayMap;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.lcp.sdk.connect.DNSUrlProvider;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import fe.fe.p004if.qw.yj.fe;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: fe.fe.if.qw.rg.ad  reason: invalid package */
public class ad extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public DNSUrlProvider.IGetUrlAsyncListener f1982ad = null;

    public ad(Context context) {
        this.qw = context;
    }

    public String ad() {
        return "https://180.76.76.112/v6/0025";
    }

    public void de(byte[] bArr) {
        int i2;
        int i3;
        String str = new String(bArr);
        fe.qw("LCPHttpDnsUrlRequest", "onSuccess----ip of " + fe.fe.p004if.qw.de.fe.v(this.qw).qqq + " is " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(fe.fe.p004if.qw.de.fe.v(this.qw).qqq);
            JSONArray optJSONArray = jSONObject.optJSONArray("ip");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
            if (optJSONArray2 == null) {
                i2 = 0;
            } else {
                i2 = optJSONArray2.length();
            }
            if (optJSONArray == null) {
                i3 = 0;
            } else {
                i3 = optJSONArray.length();
            }
            if (i3 + i2 > 0) {
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null && i3 > 0) {
                    arrayList.add(optJSONArray.getString(0));
                }
                if (optJSONArray2 != null && i2 > 0) {
                    arrayList.add(optJSONArray2.getString(0));
                }
                DNSUrlProvider.pf(arrayList);
                if (this.f1982ad != null && DNSUrlProvider.f871de.size() > 0) {
                    this.f1982ad.qw(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, DNSUrlProvider.f871de.get(0));
                    if (DNSUrlProvider.f871de.size() > 1) {
                        DNSUrlProvider.f872fe++;
                        return;
                    }
                    return;
                }
                return;
            }
            fe.ad("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
            DNSUrlProvider.yj(true);
            DNSUrlProvider.fe(this.qw).ad(fe.fe.p004if.qw.de.fe.v(this.qw).qqq, this.f1982ad);
        } catch (Exception e) {
            fe.ad("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e.getMessage());
            DNSUrlProvider.yj(true);
            DNSUrlProvider.fe(this.qw).ad(fe.fe.p004if.qw.de.fe.v(this.qw).qqq, this.f1982ad);
        }
    }

    public byte[] fe() {
        return ("type=ipv4,ipv6&dn=" + fe.fe.p004if.qw.de.fe.v(this.qw).qqq).getBytes();
    }

    public String getMediaType() {
        return ShareTarget.ENCODING_TYPE_URL_ENCODED;
    }

    public String getMethod() {
        return ShareTarget.METHOD_GET;
    }

    public void onFailure(int i2, String str) {
        fe.ad("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i2 + ",errormsg:" + str);
        DNSUrlProvider.yj(true);
        DNSUrlProvider.fe(this.qw).ad(fe.fe.p004if.qw.de.fe.v(this.qw).qqq, this.f1982ad);
    }

    public Map<String, String> qw() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("Host", "https://httpsdns.baidu.com/");
        return arrayMap;
    }

    public void rg(DNSUrlProvider.IGetUrlAsyncListener iGetUrlAsyncListener) {
        this.f1982ad = iGetUrlAsyncListener;
    }
}
