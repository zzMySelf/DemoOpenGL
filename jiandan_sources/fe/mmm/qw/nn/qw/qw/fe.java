package fe.mmm.qw.nn.qw.qw;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tera.scan.network.network.interceptor.IFallbackInterceptor;
import fe.mmm.qw.j.i;
import fe.mmm.qw.nn.ad.qw.qw;
import fe.mmm.qw.nn.de.rg;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

public class fe implements IFallbackInterceptor {

    /* renamed from: de  reason: collision with root package name */
    public static AtomicInteger f8131de = new AtomicInteger(0);

    /* renamed from: fe  reason: collision with root package name */
    public static AtomicLong f8132fe = new AtomicLong(0);

    /* renamed from: ad  reason: collision with root package name */
    public th f8133ad = new th();
    public de qw = qw.qw.th();

    @NonNull
    public <T> T[] ad(@NonNull String str, @NonNull IFallbackInterceptor.Builder<T> builder) throws JSONException {
        String th2 = qw(str) ? "https://" : th();
        T[] qw2 = builder.qw(th2 == null ? 4 : 3);
        int length = qw2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!"https://".equals(th2)) {
                str = m993if(str, th2, i2);
            }
            qw2[i2] = builder.ad(str);
        }
        return qw2;
    }

    public void de(boolean z, boolean z2) {
        if (!z) {
            this.f8133ad.fe(z2);
            return;
        }
        if (f8131de.get() > 0) {
            f8131de.set(0);
            f8132fe.set(0);
            fe.mmm.qw.i.qw.ppp("FallbackManager", "HTTPS请求发送成功，清除全局回退");
        }
        this.f8133ad.rg(z2);
    }

    public boolean fe(@NonNull String str) {
        return str.toLowerCase().startsWith("https");
    }

    public boolean i() {
        return this.qw.f8127ad;
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public final String m993if(@NonNull String str, @Nullable String str2, @IntRange(from = 0, to = 4) int i2) {
        return (str2 != null || i2 >= 3) ? uk(str) : str;
    }

    public boolean o() {
        boolean z = true;
        if (!(f8131de.get() >= this.qw.f8128de || f8132fe.get() > 0)) {
            return false;
        }
        if (i.ad() - f8132fe.get() > this.qw.f8129fe * 1000) {
            z = false;
        }
        if (!z) {
            f8131de.set(0);
            f8132fe.set(0);
            fe.mmm.qw.i.qw.ppp("FallbackManager", "清除回退时间" + this.qw.f8129fe + "秒，恢复正常HTTPS");
        }
        return z;
    }

    public boolean pf() {
        return this.qw.qw;
    }

    public boolean qw(@NonNull String str) {
        return yj(str, o.qw) || yj(str, this.qw.f8130rg);
    }

    public void rg(boolean z) {
        if (pf() && i() && z) {
            if (f8131de.incrementAndGet() >= this.qw.f8128de) {
                f8132fe.compareAndSet(0, i.ad());
                this.f8133ad.th("https_fallback_global");
                fe.mmm.qw.i.qw.ppp("FallbackManager", "回退次数太多，开始全局回退：" + f8132fe);
            }
            this.f8133ad.yj("https_fallback", String.valueOf(new rg(fe.mmm.qw.ppp.qw.qw.qw()).ad()));
        }
        if ((!pf() || !i()) && f8131de.get() > 0) {
            f8131de.set(0);
            f8132fe.set(0);
        }
    }

    @Nullable
    public String th() {
        if (!pf()) {
            fe.mmm.qw.i.qw.ad("FallbackManager", "https开关关闭");
            if (f8131de.get() > 0) {
                f8131de.set(0);
                f8132fe.set(0);
            }
            return "http://";
        } else if (i()) {
            fe.mmm.qw.i.qw.ad("FallbackManager", "自动回退开关开启");
            if (!o()) {
                return null;
            }
            fe.mmm.qw.i.qw.ad("FallbackManager", "全局回退状态");
            return "http://";
        } else if (f8131de.get() <= 0) {
            return "https://";
        } else {
            f8131de.set(0);
            f8132fe.set(0);
            return "https://";
        }
    }

    @NonNull
    public String uk(@NonNull String str) {
        return str.replace("https://", "http://");
    }

    public final boolean yj(@NonNull String str, @Nullable String[] strArr) {
        if (!(strArr == null || str == null)) {
            for (String lowerCase : strArr) {
                if (str.toLowerCase().contains(lowerCase.toLowerCase())) {
                    fe.mmm.qw.i.qw.ad("FallbackManager", "命中白名单:" + str);
                    return true;
                }
            }
        }
        return false;
    }
}
