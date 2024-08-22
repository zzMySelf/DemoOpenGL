package fe.rg.qw.o.fe.mmm;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import fe.rg.qw.ggg.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
/* renamed from: fe.rg.qw.o.fe.mmm.if  reason: invalid class name */
public class Cif implements o {

    /* renamed from: fe  reason: collision with root package name */
    public static final Bitmap.Config[] f4811fe;

    /* renamed from: rg  reason: collision with root package name */
    public static final Bitmap.Config[] f4812rg;

    /* renamed from: th  reason: collision with root package name */
    public static final Bitmap.Config[] f4813th = {Bitmap.Config.RGB_565};

    /* renamed from: uk  reason: collision with root package name */
    public static final Bitmap.Config[] f4814uk = {Bitmap.Config.ALPHA_8};

    /* renamed from: yj  reason: collision with root package name */
    public static final Bitmap.Config[] f4815yj = {Bitmap.Config.ARGB_4444};

    /* renamed from: ad  reason: collision with root package name */
    public final th<ad, Bitmap> f4816ad = new th<>();

    /* renamed from: de  reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f4817de = new HashMap();
    public final de qw = new de();

    @VisibleForTesting
    /* renamed from: fe.rg.qw.o.fe.mmm.if$ad */
    public static final class ad implements pf {

        /* renamed from: ad  reason: collision with root package name */
        public int f4818ad;

        /* renamed from: de  reason: collision with root package name */
        public Bitmap.Config f4819de;
        public final de qw;

        public ad(de deVar) {
            this.qw = deVar;
        }

        public void ad(int i2, Bitmap.Config config) {
            this.f4818ad = i2;
            this.f4819de = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ad)) {
                return false;
            }
            ad adVar = (ad) obj;
            if (this.f4818ad != adVar.f4818ad || !i.de(this.f4819de, adVar.f4819de)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2 = this.f4818ad * 31;
            Bitmap.Config config = this.f4819de;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public void qw() {
            this.qw.de(this);
        }

        public String toString() {
            return Cif.uk(this.f4818ad, this.f4819de);
        }
    }

    @VisibleForTesting
    /* renamed from: fe.rg.qw.o.fe.mmm.if$de */
    public static class de extends de<ad> {
        /* renamed from: fe */
        public ad qw() {
            return new ad(this);
        }

        public ad rg(int i2, Bitmap.Config config) {
            ad adVar = (ad) ad();
            adVar.ad(i2, config);
            return adVar;
        }
    }

    /* renamed from: fe.rg.qw.o.fe.mmm.if$qw */
    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.o.fe.mmm.Cif.qw.<clinit>():void");
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f4811fe = configArr;
        f4812rg = configArr;
    }

    public static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f4812rg;
        }
        int i2 = qw.qw[config.ordinal()];
        if (i2 == 1) {
            return f4811fe;
        }
        if (i2 == 2) {
            return f4813th;
        }
        if (i2 == 3) {
            return f4815yj;
        }
        if (i2 == 4) {
            return f4814uk;
        }
        return new Bitmap.Config[]{config};
    }

    public static String uk(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    public String ad(int i2, int i3, Bitmap.Config config) {
        return uk(i.th(i2, i3, config), config);
    }

    public void de(Bitmap bitmap) {
        ad rg2 = this.qw.rg(i.yj(bitmap), bitmap.getConfig());
        this.f4816ad.fe(rg2, bitmap);
        NavigableMap<Integer, Integer> o2 = o(bitmap.getConfig());
        Integer num = (Integer) o2.get(Integer.valueOf(rg2.f4818ad));
        Integer valueOf = Integer.valueOf(rg2.f4818ad);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        o2.put(valueOf, Integer.valueOf(i2));
    }

    @Nullable
    public Bitmap fe(int i2, int i3, Bitmap.Config config) {
        ad yj2 = yj(i.th(i2, i3, config), config);
        Bitmap qw2 = this.f4816ad.qw(yj2);
        if (qw2 != null) {
            th(Integer.valueOf(yj2.f4818ad), qw2);
            qw2.reconfigure(i2, i3, qw2.getConfig() != null ? qw2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return qw2;
    }

    public final NavigableMap<Integer, Integer> o(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f4817de.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f4817de.put(config, treeMap);
        return treeMap;
    }

    public String qw(Bitmap bitmap) {
        return uk(i.yj(bitmap), bitmap.getConfig());
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap th2 = this.f4816ad.th();
        if (th2 != null) {
            th(Integer.valueOf(i.yj(th2)), th2);
        }
        return th2;
    }

    public int rg(Bitmap bitmap) {
        return i.yj(bitmap);
    }

    public final void th(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> o2 = o(bitmap.getConfig());
        Integer num2 = (Integer) o2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + qw(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            o2.remove(num);
        } else {
            o2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f4816ad);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f4817de.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f4817de.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    public final ad yj(int i2, Bitmap.Config config) {
        ad rg2 = this.qw.rg(i2, config);
        Bitmap.Config[] i3 = i(config);
        int length = i3.length;
        int i4 = 0;
        while (i4 < length) {
            Bitmap.Config config2 = i3[i4];
            Integer ceilingKey = o(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey == null || ceilingKey.intValue() > i2 * 8) {
                i4++;
            } else {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return rg2;
                        }
                    } else if (config2.equals(config)) {
                        return rg2;
                    }
                }
                this.qw.de(rg2);
                return this.qw.rg(ceilingKey.intValue(), config2);
            }
        }
        return rg2;
    }
}
