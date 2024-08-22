package fe.fe.ddd.when.qw.yj.i;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.apollon.heartbeat.a;
import com.baidu.apollon.restnet.http.b;
import com.baidu.sapi2.SapiContext;
import com.baidu.searchbox.logsystem.basic.upload.identity.ILokiIdentityContext;
import com.baidu.util.Base64Encoder;
import fe.fe.ddd.i.qw.qw;
import fe.fe.ddd.when.qw.yj.th;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class de {

    /* renamed from: o  reason: collision with root package name */
    public static volatile de f1714o;

    /* renamed from: ad  reason: collision with root package name */
    public fe f1715ad;

    /* renamed from: de  reason: collision with root package name */
    public rg f1716de;

    /* renamed from: fe  reason: collision with root package name */
    public String f1717fe;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1718i = true;
    public ad qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f1719rg;

    /* renamed from: th  reason: collision with root package name */
    public String f1720th;

    /* renamed from: uk  reason: collision with root package name */
    public volatile String f1721uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public Context f1722yj;

    public de() {
        fe();
    }

    public static String ad(String str) {
        try {
            return URLEncoder.encode(str, a.h);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static de de() {
        if (f1714o == null) {
            synchronized (de.class) {
                if (f1714o == null) {
                    f1714o = new de();
                }
            }
        }
        return f1714o;
    }

    public final void fe() {
        this.f1722yj = qw.qw();
        this.f1715ad = new fe();
        this.qw = new ad();
        this.f1716de = new rg();
        boolean i2 = th.qw().i();
        this.f1718i = i2;
        if (i2) {
            String cuid = DeviceId.getCUID(this.f1722yj);
            this.f1717fe = cuid;
            if (!TextUtils.isEmpty(cuid)) {
                this.f1719rg = new String(Base64Encoder.qw(this.f1717fe.getBytes()));
                return;
            }
            return;
        }
        this.f1720th = th.qw().yj();
    }

    public final String qw(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, ad(str3)) : str;
    }

    public String rg(String str) {
        String str2;
        String qw2 = qw(qw(this.f1715ad.qw(str, true), "ut", this.qw.qw()), "ua", this.f1716de.qw());
        if (this.f1718i) {
            str2 = qw(qw2, "uid", this.f1719rg);
        } else {
            str2 = qw(qw2, "iid", this.f1720th);
        }
        String qw3 = qw(str2, "appname", th.ad().getAppName());
        ILokiIdentityContext qw4 = th.qw();
        String ad2 = qw4.ad();
        String rg2 = qw4.rg();
        String qw5 = qw4.qw();
        String fe2 = qw4.fe();
        if (TextUtils.isEmpty(rg2)) {
            rg2 = qw.ad().qw();
        }
        if (TextUtils.isEmpty(qw5)) {
            qw5 = qw.ad().de();
        }
        String qw6 = qw(qw(qw(qw(qw(qw3, "bdvc", qw4.th()), SapiContext.KEY_SEARCH_BOX_SID, ad2), "cfrom", qw5), "from", rg2), b.c.h, fe2);
        if (this.f1718i) {
            qw6 = qw(qw6, "zid", qw4.getZid());
        }
        if (this.f1718i && TextUtils.isEmpty(this.f1721uk)) {
            this.f1721uk = qw4.de();
        }
        return (!this.f1718i || TextUtils.isEmpty(this.f1721uk)) ? qw6 : qw(qw6, "c3_aid", this.f1721uk);
    }
}
