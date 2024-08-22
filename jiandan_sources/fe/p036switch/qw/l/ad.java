package fe.p036switch.qw.l;

import android.app.Activity;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: fe.switch.qw.l.ad  reason: invalid package */
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final LinkedList<FlutterViewContainer> f8817ad;
    public final Map<String, FlutterViewContainer> qw;

    /* renamed from: fe.switch.qw.l.ad$ad  reason: collision with other inner class name */
    public static class C0304ad {
        public static final ad qw = new ad();
    }

    public static ad yj() {
        return C0304ad.qw;
    }

    public void ad(String str, FlutterViewContainer flutterViewContainer) {
        this.qw.put(str, flutterViewContainer);
    }

    public FlutterViewContainer de(String str) {
        if (this.qw.containsKey(str)) {
            return this.qw.get(str);
        }
        return null;
    }

    public int fe() {
        return this.qw.size();
    }

    public void o(String str) {
        if (str != null) {
            this.f8817ad.remove(this.qw.remove(str));
        }
    }

    public void qw(String str, FlutterViewContainer flutterViewContainer) {
        if (str != null && flutterViewContainer != null) {
            if (this.f8817ad.contains(flutterViewContainer)) {
                this.f8817ad.remove(flutterViewContainer);
            }
            this.f8817ad.add(flutterViewContainer);
        }
    }

    public FlutterViewContainer rg() {
        int size = this.f8817ad.size();
        if (size == 0) {
            return null;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            FlutterViewContainer flutterViewContainer = this.f8817ad.get(i2);
            if (flutterViewContainer instanceof Activity) {
                return flutterViewContainer;
            }
        }
        return null;
    }

    public FlutterViewContainer th() {
        if (this.f8817ad.size() > 0) {
            return this.f8817ad.getLast();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("activeContainers=" + this.f8817ad.size() + ", [");
        this.f8817ad.forEach(new qw(sb));
        sb.append("]");
        return sb.toString();
    }

    public boolean uk(FlutterViewContainer flutterViewContainer) {
        return this.f8817ad.contains(flutterViewContainer);
    }

    public ad() {
        this.qw = new HashMap();
        this.f8817ad = new LinkedList<>();
    }
}
