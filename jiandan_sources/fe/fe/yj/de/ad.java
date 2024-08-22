package fe.fe.yj.de;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.apollon.restnet.http.b;
import com.baidu.common.param.ICommonParamContext;
import com.baidu.sapi2.SapiContext;
import com.baidu.util.Base64Encoder;
import fe.fe.yj.ad.qw;
import java.util.zip.CRC32;

public final class ad {

    /* renamed from: th  reason: collision with root package name */
    public static ad f3196th;

    /* renamed from: ad  reason: collision with root package name */
    public uk f3197ad;

    /* renamed from: de  reason: collision with root package name */
    public String f3198de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile String f3199fe = null;
    public fe qw;

    /* renamed from: rg  reason: collision with root package name */
    public de f3200rg;

    public ad() {
        yj();
    }

    public static String de(String str, String str2) {
        CRC32 crc32 = new CRC32();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ut");
            sb.append("=");
            sb.append(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(a.n);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("network");
            sb.append("=");
            sb.append(str2);
        }
        crc32.update(sb.toString().getBytes());
        return String.valueOf(crc32.getValue());
    }

    public static ad th() {
        if (f3196th == null) {
            synchronized (ad.class) {
                if (f3196th == null) {
                    f3196th = new ad();
                }
            }
        }
        return f3196th;
    }

    public String ad(String str, int i2) {
        if (qw.ad().uk()) {
            return pf(str, i2);
        }
        return uk(str);
    }

    public final String fe() {
        if (TextUtils.isEmpty(this.f3199fe)) {
            this.f3199fe = qw.qw().de();
        }
        return this.f3199fe;
    }

    public final String i(String str, String str2, String str3, String str4, String str5, int i2) {
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        boolean z;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        ICommonParamContext qw2 = qw.qw();
        String qw3 = this.f3197ad.qw();
        String qw4 = qw.ad().qw();
        String ad2 = qw2.ad();
        String th2 = qw2.th();
        th thVar = new th();
        thVar.yj(true);
        String str19 = null;
        if (i2 == 1) {
            boolean z2 = false;
            if (this.qw.o()) {
                str7 = this.qw.qw();
                str12 = null;
            } else {
                str7 = null;
                str12 = this.qw.th();
                z2 = true;
            }
            if (thVar.rg()) {
                str14 = thVar.de();
                str6 = null;
                z = z2;
                str13 = str14;
            } else {
                String valueOf = String.valueOf(thVar.fe());
                str14 = thVar.ad();
                str6 = valueOf;
                z = true;
                str13 = null;
            }
            if (z) {
                str16 = de(this.qw.qw(), str14);
                str15 = String.valueOf(i2);
            } else {
                str16 = null;
                str15 = null;
            }
            if (qw.ad().rg()) {
                if (this.f3200rg.ad()) {
                    str17 = null;
                    str18 = String.valueOf(i2);
                    String str20 = str17;
                    str10 = str16;
                    str11 = str18;
                    str19 = str12;
                    str8 = str13;
                    str9 = str20;
                } else {
                    str19 = this.f3200rg.qw();
                }
            }
            str17 = str19;
            str18 = str15;
            String str202 = str17;
            str10 = str16;
            str11 = str18;
            str19 = str12;
            str8 = str13;
            str9 = str202;
        } else {
            str7 = this.qw.qw();
            String de2 = thVar.de();
            if (qw.ad().rg()) {
                str10 = null;
                str6 = null;
                str8 = de2;
                str9 = this.f3200rg.qw();
                str11 = null;
            } else {
                str11 = null;
                str10 = null;
                str6 = null;
                str8 = de2;
                str9 = null;
            }
        }
        String rg2 = qw2.rg();
        String qw5 = qw2.qw();
        String fe2 = qw2.fe();
        ICommonParamContext iCommonParamContext = qw2;
        String de3 = qw.ad().de();
        String str21 = str9;
        String qw6 = qw.ad().qw();
        if (TextUtils.isEmpty(rg2)) {
            rg2 = fe.fe.yj.qw.qw.ad().qw();
        }
        if (TextUtils.isEmpty(qw5)) {
            qw5 = fe.fe.yj.qw.qw.ad().de();
        }
        String str22 = qw6;
        String qw7 = qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(qw(str5, "appname", qw4), SapiContext.KEY_SEARCH_BOX_SID, ad2), "ut", str7), "ua", qw3), "bdvc", th2), "zid", str2), "uid", str), "iid", str4), "cfrom", qw5), "from", rg2), b.c.h, fe2), "network", str8), "p_sv", str19), "mps", str10), "mpv", str11), "p_nw", str6), "c3_aid", str3), "matrixstyle", de3);
        if (!TextUtils.isEmpty(str22)) {
            qw7 = qw(qw7, "cmode", str22);
        }
        return iCommonParamContext.yj(qw(qw7, "bdos", str21), true);
    }

    public String o(String str) {
        return i((String) null, (String) null, (String) null, qw.ad().ad(), str, 0);
    }

    public final String pf(String str, int i2) {
        ICommonParamContext qw2 = qw.qw();
        rg ad2 = qw.ad();
        if (ad2.fe()) {
            return i(rg(), qw2.getZid(), fe(), (String) null, str, i2);
        }
        return i((String) null, (String) null, (String) null, ad2.ad(), str, i2);
    }

    public final String qw(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, i.qw(str3)) : str;
    }

    public final String rg() {
        if (TextUtils.isEmpty(this.f3198de)) {
            String deviceId = qw.qw().getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                this.f3198de = new String(Base64Encoder.qw(deviceId.getBytes()));
            }
        }
        return this.f3198de;
    }

    public String uk(String str) {
        return pf(str, 0);
    }

    public final void yj() {
        this.qw = new fe();
        this.f3197ad = new uk();
        this.f3200rg = new de();
    }
}
