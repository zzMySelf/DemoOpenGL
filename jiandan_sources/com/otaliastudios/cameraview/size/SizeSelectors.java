package com.otaliastudios.cameraview.size;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SizeSelectors {

    public interface Filter {
        boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar);
    }

    public class ad implements Filter {
        public final /* synthetic */ int qw;

        public ad(int i2) {
            this.qw = i2;
        }

        public boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar) {
            return adVar.rg() >= this.qw;
        }
    }

    public class de implements Filter {
        public final /* synthetic */ int qw;

        public de(int i2) {
            this.qw = i2;
        }

        public boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar) {
            return adVar.fe() <= this.qw;
        }
    }

    public class fe implements Filter {
        public final /* synthetic */ int qw;

        public fe(int i2) {
            this.qw = i2;
        }

        public boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar) {
            return adVar.fe() >= this.qw;
        }
    }

    public class i implements Filter {
        public final /* synthetic */ int qw;

        public i(int i2) {
            this.qw = i2;
        }

        public boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar) {
            return adVar.fe() * adVar.rg() >= this.qw;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$if  reason: invalid class name */
    public static class Cif implements SizeSelector {
        public SizeSelector[] qw;

        public /* synthetic */ Cif(SizeSelector[] sizeSelectorArr, qw qwVar) {
            this(sizeSelectorArr);
        }

        @NonNull
        public List<fe.vvv.qw.xxx.ad> qw(@NonNull List<fe.vvv.qw.xxx.ad> list) {
            List<fe.vvv.qw.xxx.ad> list2 = null;
            for (SizeSelector qw2 : this.qw) {
                list2 = qw2.qw(list);
                if (!list2.isEmpty()) {
                    break;
                }
            }
            return list2 == null ? new ArrayList() : list2;
        }

        public Cif(@NonNull SizeSelector... sizeSelectorArr) {
            this.qw = sizeSelectorArr;
        }
    }

    public static class o implements SizeSelector {
        public SizeSelector[] qw;

        public /* synthetic */ o(SizeSelector[] sizeSelectorArr, qw qwVar) {
            this(sizeSelectorArr);
        }

        @NonNull
        public List<fe.vvv.qw.xxx.ad> qw(@NonNull List<fe.vvv.qw.xxx.ad> list) {
            for (SizeSelector qw2 : this.qw) {
                list = qw2.qw(list);
            }
            return list;
        }

        public o(@NonNull SizeSelector... sizeSelectorArr) {
            this.qw = sizeSelectorArr;
        }
    }

    public static class pf implements SizeSelector {
        public Filter qw;

        public /* synthetic */ pf(Filter filter, qw qwVar) {
            this(filter);
        }

        @NonNull
        public List<fe.vvv.qw.xxx.ad> qw(@NonNull List<fe.vvv.qw.xxx.ad> list) {
            ArrayList arrayList = new ArrayList();
            for (fe.vvv.qw.xxx.ad next : list) {
                if (this.qw.qw(next)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        public pf(@NonNull Filter filter) {
            this.qw = filter;
        }
    }

    public class qw implements Filter {
        public final /* synthetic */ int qw;

        public qw(int i2) {
            this.qw = i2;
        }

        public boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar) {
            return adVar.rg() <= this.qw;
        }
    }

    public class rg implements Filter {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f6781ad;
        public final /* synthetic */ float qw;

        public rg(float f, float f2) {
            this.qw = f;
            this.f6781ad = f2;
        }

        public boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar) {
            float o2 = fe.vvv.qw.xxx.qw.th(adVar.rg(), adVar.fe()).o();
            float f = this.qw;
            float f2 = this.f6781ad;
            return o2 >= f - f2 && o2 <= f + f2;
        }
    }

    public class th implements SizeSelector {
        @NonNull
        public List<fe.vvv.qw.xxx.ad> qw(@NonNull List<fe.vvv.qw.xxx.ad> list) {
            Collections.sort(list);
            Collections.reverse(list);
            return list;
        }
    }

    public class uk implements Filter {
        public final /* synthetic */ int qw;

        public uk(int i2) {
            this.qw = i2;
        }

        public boolean qw(@NonNull fe.vvv.qw.xxx.ad adVar) {
            return adVar.fe() * adVar.rg() <= this.qw;
        }
    }

    public class yj implements SizeSelector {
        @NonNull
        public List<fe.vvv.qw.xxx.ad> qw(@NonNull List<fe.vvv.qw.xxx.ad> list) {
            Collections.sort(list);
            return list;
        }
    }

    @NonNull
    public static SizeSelector ad(fe.vvv.qw.xxx.qw qwVar, float f) {
        return m718if(new rg(qwVar.o(), f));
    }

    @NonNull
    public static SizeSelector de() {
        return new th();
    }

    @NonNull
    public static SizeSelector fe(int i2) {
        return m718if(new uk(i2));
    }

    @NonNull
    public static SizeSelector i(int i2) {
        return m718if(new ad(i2));
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public static SizeSelector m718if(@NonNull Filter filter) {
        return new pf(filter, (qw) null);
    }

    @NonNull
    public static SizeSelector o(SizeSelector... sizeSelectorArr) {
        return new Cif(sizeSelectorArr, (qw) null);
    }

    @NonNull
    public static SizeSelector pf() {
        return new yj();
    }

    @NonNull
    public static SizeSelector qw(SizeSelector... sizeSelectorArr) {
        return new o(sizeSelectorArr, (qw) null);
    }

    @NonNull
    public static SizeSelector rg(int i2) {
        return m718if(new de(i2));
    }

    @NonNull
    public static SizeSelector th(int i2) {
        return m718if(new qw(i2));
    }

    @NonNull
    public static SizeSelector uk(int i2) {
        return m718if(new fe(i2));
    }

    @NonNull
    public static SizeSelector yj(int i2) {
        return m718if(new i(i2));
    }
}
