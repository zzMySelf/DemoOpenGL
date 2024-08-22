package fe.mmm.qw.xxx.o;

import android.app.Application;
import com.tera.scan.main.startup.task.UBCStartupTask;
import com.tera.scan.startup.OnProjectListener;
import fe.mmm.qw.c.qw;
import fe.mmm.qw.xxx.o.de.Cif;
import fe.mmm.qw.xxx.o.de.Cswitch;
import fe.mmm.qw.xxx.o.de.de;
import fe.mmm.qw.xxx.o.de.fe;
import fe.mmm.qw.xxx.o.de.i;
import fe.mmm.qw.xxx.o.de.o;
import fe.mmm.qw.xxx.o.de.pf;
import fe.mmm.qw.xxx.o.de.ppp;
import fe.mmm.qw.xxx.o.de.rg;
import fe.mmm.qw.xxx.o.de.th;
import fe.mmm.qw.xxx.o.de.uk;
import fe.mmm.qw.xxx.o.de.when;
import fe.mmm.qw.xxx.o.de.yj;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad extends qw {

    public static final class qw implements OnProjectListener {
        public void ad() {
            fe.mmm.qw.i.qw.ad("TeraScanApplication", "onProjectFinish()");
        }

        public void de() {
            fe.mmm.qw.i.qw.ad("TeraScanApplication", "onProjectStart()");
        }

        public void qw() {
            fe.mmm.qw.i.qw.ad("TeraScanApplication", "onStageFinish()");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "context");
    }

    public void ad() {
        qw.ad adVar = new qw.ad();
        adVar.yj(new th(qw()));
        adVar.yj(new fe(qw()));
        adVar.yj(new o(qw()));
        adVar.yj(new uk(qw()));
        adVar.yj(new UBCStartupTask(qw()));
        adVar.yj(new fe.mmm.qw.xxx.o.de.qw(qw()));
        adVar.yj(new i(qw()));
        adVar.yj(new ppp(qw()));
        adVar.yj(new Cswitch(qw()));
        adVar.yj(new Cif(qw()));
        adVar.yj(new pf(qw()));
        adVar.yj(new rg(qw()));
        adVar.yj(new yj(qw()));
        adVar.yj(new de(qw()));
        adVar.yj(new when(qw()));
        adVar.yj(new fe.mmm.qw.xxx.o.de.ad(qw()));
        adVar.i(new fe.mmm.qw.c.de());
        adVar.pf(fe.mmm.qw.c.fe.qw().ad());
        adVar.uk(new qw());
        fe.mmm.qw.c.qw o2 = adVar.o();
        o2.ggg();
        o2.o();
    }
}
