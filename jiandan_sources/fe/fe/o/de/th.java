package fe.fe.o.de;

import androidx.core.view.PointerIconCompat;
import com.baidu.down.common.TaskObserverInterface;

public abstract class th implements TaskObserverInterface {
    public abstract void ad(String str, long j, long j2, long j3, String str2);

    public abstract void de(String str, long j, long j2, String str2, String str3, int i2, qw qwVar);

    public abstract void fe(String str, long j, long j2, long j3, String str2);

    public abstract void i(String str, long j, long j2, long j3, long j4, String str2);

    public abstract void o(String str, long j, long j2, long j3, qw qwVar);

    public void qw(Object obj) {
        rg rgVar = (rg) obj;
        switch (rgVar.qw) {
            case 1000:
                rg(rgVar.f2492ad, rgVar.f2493de, rgVar.f2494fe, rgVar.f2498rg);
                return;
            case 1001:
                th(rgVar.f2492ad, rgVar.f2493de, rgVar.f2498rg, rgVar.f2500uk, rgVar.f2499th, rgVar.f2496o, rgVar.f2497pf, rgVar.f73switch, rgVar.ppp);
                return;
            case 1002:
                i(rgVar.f2492ad, rgVar.f2493de, rgVar.f2494fe, rgVar.f2498rg, rgVar.f2495i, rgVar.f72if);
                return;
            case 1003:
                yj(rgVar.f2492ad, rgVar.f2493de, rgVar.f2498rg, rgVar.f2494fe, rgVar.f2499th, rgVar.f2495i);
                return;
            case 1004:
                ad(rgVar.f2492ad, rgVar.f2493de, rgVar.f2494fe, rgVar.f2498rg, rgVar.f2499th);
                return;
            case 1005:
                de(rgVar.f2492ad, rgVar.f2493de, rgVar.f2494fe, rgVar.f2499th, rgVar.f2501yj, rgVar.when, rgVar.ppp);
                return;
            case 1006:
                fe(rgVar.f2492ad, rgVar.f2493de, rgVar.f2494fe, rgVar.f2498rg, rgVar.f2499th);
                return;
            case PointerIconCompat.TYPE_TEXT:
                o(rgVar.f2492ad, rgVar.f2493de, rgVar.f2498rg, rgVar.f2495i, rgVar.ppp);
                return;
            case PointerIconCompat.TYPE_VERTICAL_TEXT:
                uk(rgVar.f2492ad, rgVar.f2493de);
                return;
            default:
                return;
        }
    }

    public abstract void rg(String str, long j, long j2, long j3);

    public abstract void th(String str, long j, long j2, String str2, String str3, String str4, String str5, boolean z, qw qwVar);

    public abstract void uk(String str, long j);

    public abstract void yj(String str, long j, long j2, long j3, String str2, long j4);
}
