package com.alipay.sdk.m.j;

import android.text.TextUtils;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.u.n;
import java.util.Collections;
import java.util.List;

public class a {
    public static String a = "";
    public static final a.b b = new a.b(n.b, 73, com.alipay.sdk.m.l.a.l);
    public static final a.b c = new a.b("hk.alipay.wallet", 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
    public static List<a.b> d = Collections.singletonList(b);

    public static void a(String str) {
        a = str;
        if (((str.hashCode() == 3331 && str.equals("hk")) ? (char) 0 : 65535) != 0) {
            d = Collections.singletonList(b);
        } else {
            d = Collections.singletonList(c);
        }
    }

    public static boolean b() {
        return TextUtils.isEmpty(a) || TextUtils.equals("cn", a);
    }

    public static String a() {
        return a;
    }
}
