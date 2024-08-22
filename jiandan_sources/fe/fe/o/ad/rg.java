package fe.fe.o.ad;

import androidx.browser.trusted.sharing.ShareTarget;
import fe.fe.o.fe.qw.ad.ad;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class rg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ fe f2460ad;

    public rg(fe feVar) {
        this.f2460ad = feVar;
    }

    public void run() {
        try {
            ad adVar = new ad(this.f2460ad.qw, false);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            HttpURLConnection fe2 = adVar.fe(this.f2460ad.f2454de, hashMap, "POST", this.f2460ad.uk(this.f2460ad.f2455fe), false, false);
            fe2.connect();
            fe2.getResponseCode();
        } catch (Exception unused) {
        }
    }
}
