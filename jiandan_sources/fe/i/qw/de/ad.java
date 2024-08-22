package fe.i.qw.de;

import com.dxmpay.apollon.a.a;
import com.dxmpay.apollon.heartbeat.HeartBeatManager;
import com.dxmpay.apollon.utils.LogUtil;
import java.util.Calendar;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static final String f4478ad = "ad";
    public a qw = null;

    /* renamed from: fe.i.qw.de.ad$ad  reason: collision with other inner class name */
    public class C0194ad implements a.C0180a {
        public C0194ad(ad adVar) {
        }

        public void a() {
            String qw = ad.f4478ad;
            LogUtil.i(qw, ad.f4478ad + " Active ---> Idle.");
            HeartBeatManager.getInstance().stopHeartBeat();
        }
    }

    public class de implements a.C0180a {
        public de(ad adVar) {
        }

        public void a() {
            String qw = ad.f4478ad;
            LogUtil.i(qw, ad.f4478ad + " Active ---> HalfActive.");
            HeartBeatManager.getInstance().de(Calendar.getInstance().getTimeInMillis() / 1000);
        }
    }

    public class fe implements a.C0180a {
        public fe(ad adVar) {
        }

        public void a() {
            String qw = ad.f4478ad;
            LogUtil.i(qw, ad.f4478ad + " HalfActive ---> Active.");
            HeartBeatManager.getInstance().de(0);
            HeartBeatManager.getInstance().startHeartBeat();
        }
    }

    public class qw implements a.C0180a {
        public qw(ad adVar) {
        }

        public void a() {
            String qw = ad.f4478ad;
            LogUtil.i(qw, ad.f4478ad + " Idle ---> Active.");
            HeartBeatManager.getInstance().de(0);
            HeartBeatManager.getInstance().startHeartBeat();
        }
    }

    public class rg implements a.C0180a {
        public rg(ad adVar) {
        }

        public void a() {
            String qw = ad.f4478ad;
            LogUtil.i(qw, ad.f4478ad + " HalfActive ---> Idle.");
            HeartBeatManager.getInstance().stopHeartBeat();
        }
    }

    public ad() {
        de();
    }

    public void ad(int i2) {
        if (i2 < 1 || i2 > 4) {
            throw new IllegalArgumentException(f4478ad + " invalid params eventId:" + i2);
        }
        a aVar = this.qw;
        if (aVar != null) {
            aVar.qw(i2);
            return;
        }
        throw new RuntimeException(f4478ad + " sendEvent but the mStateMachine is null.");
    }

    public final void de() {
        a aVar = new a(1);
        this.qw = aVar;
        aVar.getClass();
        aVar.ad(new a.qw(aVar, 1, 3, 1, new qw(this)));
        a aVar2 = this.qw;
        aVar2.getClass();
        aVar2.ad(new a.qw(aVar2, 3, 1, 2, new C0194ad(this)));
        a aVar3 = this.qw;
        aVar3.getClass();
        aVar3.ad(new a.qw(aVar3, 3, 2, 3, new de(this)));
        a aVar4 = this.qw;
        aVar4.getClass();
        aVar4.ad(new a.qw(aVar4, 2, 3, 4, new fe(this)));
        a aVar5 = this.qw;
        aVar5.getClass();
        aVar5.ad(new a.qw(aVar5, 2, 1, 2, new rg(this)));
    }
}
