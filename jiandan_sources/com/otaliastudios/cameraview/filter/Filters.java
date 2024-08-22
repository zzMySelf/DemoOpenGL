package com.otaliastudios.cameraview.filter;

import androidx.annotation.NonNull;
import fe.vvv.qw.i.Cif;
import fe.vvv.qw.i.Cswitch;
import fe.vvv.qw.i.ad;
import fe.vvv.qw.i.ddd;
import fe.vvv.qw.i.fe;
import fe.vvv.qw.i.ggg;
import fe.vvv.qw.i.i;
import fe.vvv.qw.i.mmm;
import fe.vvv.qw.i.nn;
import fe.vvv.qw.i.o;
import fe.vvv.qw.i.pf;
import fe.vvv.qw.i.ppp;
import fe.vvv.qw.i.qw;
import fe.vvv.qw.i.rg;
import fe.vvv.qw.i.th;
import fe.vvv.qw.i.uk;
import fe.vvv.qw.i.vvv;
import fe.vvv.qw.i.when;
import fe.vvv.qw.i.xxx;
import fe.vvv.qw.i.yj;
import fe.vvv.qw.uk.de;

public enum Filters {
    NONE(de.class),
    AUTO_FIX(qw.class),
    BLACK_AND_WHITE(ad.class),
    BRIGHTNESS(fe.vvv.qw.i.de.class),
    CONTRAST(fe.class),
    CROSS_PROCESS(rg.class),
    DOCUMENTARY(th.class),
    DUOTONE(yj.class),
    FILL_LIGHT(uk.class),
    GAMMA(i.class),
    GRAIN(o.class),
    GRAYSCALE(pf.class),
    HUE(Cif.class),
    INVERT_COLORS(Cswitch.class),
    LOMOISH(when.class),
    POSTERIZE(ppp.class),
    SATURATION(ggg.class),
    SEPIA(vvv.class),
    SHARPNESS(xxx.class),
    TEMPERATURE(ddd.class),
    TINT(nn.class),
    VIGNETTE(mmm.class);
    
    public Class<? extends Filter> filterClass;

    /* access modifiers changed from: public */
    Filters(@NonNull Class<? extends Filter> cls) {
        this.filterClass = cls;
    }

    @NonNull
    public Filter newInstance() {
        try {
            return (Filter) this.filterClass.newInstance();
        } catch (IllegalAccessException unused) {
            return new de();
        } catch (InstantiationException unused2) {
            return new de();
        }
    }
}
