package fe.fe.ddd.de.ad;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.anr.ioc.IANRContext;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import fe.fe.ddd.mmm.qw.uk;

public class qw {
    public static final IANRContext qw = new C0075qw();

    /* renamed from: fe.fe.ddd.de.ad.qw$qw  reason: collision with other inner class name */
    public static class C0075qw implements IANRContext {
        public void qw(Context context, ad adVar) {
            boolean rg2 = AppConfig.rg();
            ListHolder<IANRRegister> ad2 = rg.de().ad();
            if (ad2 != null && ad2.qw() != null && adVar != null) {
                if (AppConfig.rg()) {
                    "ANRInfo = " + adVar.rg();
                }
                uk rg3 = Track.fe().rg();
                if (rg3 != null) {
                    if (!TextUtils.isEmpty(rg3.fe())) {
                        adVar.o(rg3.fe());
                    } else if (!TextUtils.isEmpty(rg3.qw())) {
                        adVar.o(rg3.qw());
                    }
                }
                adVar.m60if(Track.fe().de());
                adVar.pf(CommonUtils.yj());
                for (IANRRegister qw : ad2.qw()) {
                    qw.qw(context, adVar);
                }
            }
        }
    }

    public static IANRContext qw() {
        return qw;
    }
}
