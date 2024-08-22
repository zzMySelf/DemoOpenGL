package fe.mmm.qw.p030switch.fe.qw.qw;

import android.content.Context;
import android.content.Intent;
import com.tera.scan.framework.component.base.service.BaseCompRouter;
import com.tera.scan.framework.kernel.service.ISchedulerService;
import fe.mmm.qw.a.yj.qw.de;

/* renamed from: fe.mmm.qw.switch.fe.qw.qw.ad  reason: invalid package */
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public de f8311ad;
    public BaseCompRouter qw = null;

    public ad(de deVar, Context context) {
        this.f8311ad = deVar;
        this.qw = new BaseCompRouter();
    }

    public ISchedulerService qw(Intent intent) {
        BaseCompRouter baseCompRouter = this.qw;
        if (baseCompRouter != null) {
            return baseCompRouter.getSchedulerService(intent, this.f8311ad);
        }
        return null;
    }
}
