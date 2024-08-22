package fe.mmm.qw.p030switch.fe.qw.qw;

import android.app.Service;
import com.tera.scan.framework.component.base.service.IComponentService;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: fe.mmm.qw.switch.fe.qw.qw.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static qw f8312ad;
    public ArrayList<IComponentService> qw = new ArrayList<>();

    public static synchronized qw qw() {
        qw qwVar;
        synchronized (qw.class) {
            if (f8312ad == null) {
                f8312ad = new qw();
            }
            qwVar = f8312ad;
        }
        return qwVar;
    }

    public void ad(Service service) {
        ArrayList<IComponentService> arrayList = this.qw;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<IComponentService> it = this.qw.iterator();
            while (it.hasNext()) {
                it.next().qw(service);
            }
        }
    }
}
