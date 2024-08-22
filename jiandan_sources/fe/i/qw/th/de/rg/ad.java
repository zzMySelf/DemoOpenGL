package fe.i.qw.th.de.rg;

import android.text.TextUtils;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.wallet.core.utils.LogUtil;
import fe.i.qw.th.ad.qw;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class ad implements e {

    /* renamed from: ad  reason: collision with root package name */
    public int f4498ad;

    /* renamed from: de  reason: collision with root package name */
    public String f4499de;

    /* renamed from: fe  reason: collision with root package name */
    public Map<String, List<String>> f4500fe;
    public InputStream qw;

    /* renamed from: rg  reason: collision with root package name */
    public qw f4501rg;

    /* renamed from: th  reason: collision with root package name */
    public InputStream f4502th;

    public ad(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
        this.qw = inputStream;
        this.f4498ad = i2;
        this.f4499de = str;
        this.f4500fe = map;
    }

    public String a() throws IOException {
        return this.f4499de;
    }

    public int ad() throws IOException {
        return this.f4498ad;
    }

    public InputStream b() throws IOException {
        if (de()) {
            return qw(this.qw);
        }
        return this.qw;
    }

    public qw c() {
        if (this.f4501rg == null) {
            this.f4501rg = new qw(this.f4500fe, false);
        }
        return this.f4501rg;
    }

    public HttpStatus d() throws Exception {
        return HttpStatus.valueOf(ad());
    }

    public final boolean de() {
        String qw2 = c().qw();
        return !TextUtils.isEmpty(qw2) && qw2.contains("gzip");
    }

    public void e() {
        InputStream inputStream = this.f4502th;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                LogUtil.e("RestUrlConnectionResponse", e.getMessage(), e);
            }
        }
        InputStream inputStream2 = this.qw;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e2) {
                LogUtil.e("RestUrlConnectionResponse", e2.getMessage(), e2);
            }
        }
    }

    public final InputStream qw(InputStream inputStream) throws IOException {
        if (this.f4502th == null) {
            this.f4502th = new GZIPInputStream(inputStream);
        }
        return this.f4502th;
    }
}
