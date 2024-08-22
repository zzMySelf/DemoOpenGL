package fe.mmm.qw.p030switch.th.de.qw;

import com.baidu.android.common.others.lang.StringUtil;
import com.tera.scan.framework.kernel.architecture.component.IBaseActivityCallback;

/* renamed from: fe.mmm.qw.switch.th.de.qw.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static qw f8323ad;
    public IBaseActivityCallback qw;

    public static synchronized qw ad() {
        qw qwVar;
        synchronized (qw.class) {
            if (f8323ad == null) {
                f8323ad = new qw();
            }
            qwVar = f8323ad;
        }
        return qwVar;
    }

    public IBaseActivityCallback qw() {
        StringBuilder sb = new StringBuilder();
        sb.append("getBaseActivityCallback = ");
        sb.append(this.qw == null ? StringUtil.NULL_STRING : "not null");
        fe.mmm.qw.i.qw.ad("BaseComponentManager", sb.toString());
        return this.qw;
    }
}
