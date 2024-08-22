package fe.fe.nn.ddd;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sso.p.a;
import com.baidu.sso.p.b;

public class de implements a {

    /* renamed from: ad  reason: collision with root package name */
    public String f2234ad;

    /* renamed from: de  reason: collision with root package name */
    public qw f2235de;
    public ad qw;

    public String a() {
        if (TextUtils.isEmpty(this.f2234ad)) {
            this.f2234ad = this.qw.qw(0, (String) null);
        }
        return this.f2234ad;
    }

    public boolean ad() {
        String str;
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            str = (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{"persist.sys.identifierid.supported", "0"});
        } catch (Throwable unused) {
            str = null;
        }
        return "1".equals(str);
    }

    public void qw(Context context, b bVar) {
        this.qw = new ad(context);
        if (ad()) {
            this.f2235de = new qw(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f2235de);
        }
        if (bVar != null) {
            bVar.a();
        }
    }
}
