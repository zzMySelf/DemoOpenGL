package fe.mmm.qw.th.qw.de;

import android.content.Context;
import com.tera.scan.config.IAccountChecker;
import com.tera.scan.config.IParameter;
import com.tera.scan.framework.kernel.BaseApplication;
import fe.mmm.qw.j.xxx.ad;
import fe.mmm.qw.yj.de;
import fe.mmm.qw.yj.th;
import fe.mmm.qw.yj.uk;
import fe.mmm.qw.yj.yj;

public class qw implements IAccountChecker, IParameter {
    public boolean ad() {
        return true;
    }

    public String de() {
        return ad.when(BaseApplication.getInstance().getApplicationInfo().dataDir, "shared_prefs");
    }

    public boolean fe() {
        return false;
    }

    public String qw() {
        return fe.mmm.qw.p030switch.rg.qw.qw().getUid() + "duboxdrive.ini";
    }

    public String rg() {
        return fe.mmm.qw.p030switch.rg.qw.qw().getUid() + "dubox.mmkv";
    }

    public void th(Context context) {
        fe.mmm.qw.i.qw.ad("NetDiskConfigInitHelper", "init all config ");
        de.ppp().ggg(context);
        yj.ppp().ggg(context);
        th.ppp().de();
        th.ppp().ggg(this, this);
        uk.ad().qw();
        uk.ad().rg(context, fe.mmm.qw.p030switch.rg.qw.qw().getUid(), this);
    }
}
