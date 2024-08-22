package fe.vvv.qw.yj.th;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static final Map<Facing, Integer> f9263ad = new HashMap();

    /* renamed from: de  reason: collision with root package name */
    public static final Map<WhiteBalance, Integer> f9264de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public static final Map<Hdr, Integer> f9265fe = new HashMap();
    public static ad qw;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.otaliastudios.cameraview.controls.Flash[] r0 = com.otaliastudios.cameraview.controls.Flash.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.otaliastudios.cameraview.controls.Flash r1 = com.otaliastudios.cameraview.controls.Flash.ON     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.controls.Flash r1 = com.otaliastudios.cameraview.controls.Flash.AUTO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.otaliastudios.cameraview.controls.Flash r1 = com.otaliastudios.cameraview.controls.Flash.OFF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.otaliastudios.cameraview.controls.Flash r1 = com.otaliastudios.cameraview.controls.Flash.TORCH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.yj.th.ad.qw.<clinit>():void");
        }
    }

    static {
        f9263ad.put(Facing.BACK, 1);
        f9263ad.put(Facing.FRONT, 0);
        f9264de.put(WhiteBalance.AUTO, 1);
        f9264de.put(WhiteBalance.CLOUDY, 6);
        f9264de.put(WhiteBalance.DAYLIGHT, 5);
        f9264de.put(WhiteBalance.FLUORESCENT, 3);
        f9264de.put(WhiteBalance.INCANDESCENT, 2);
        f9265fe.put(Hdr.OFF, 0);
        f9265fe.put(Hdr.ON, 18);
    }

    public static ad qw() {
        if (qw == null) {
            qw = new ad();
        }
        return qw;
    }

    public int ad(@NonNull Facing facing) {
        return f9263ad.get(facing).intValue();
    }

    @NonNull
    public List<Pair<Integer, Integer>> de(@NonNull Flash flash) {
        ArrayList arrayList = new ArrayList();
        int i2 = qw.qw[flash.ordinal()];
        if (i2 == 1) {
            arrayList.add(new Pair(3, 0));
        } else if (i2 == 2) {
            arrayList.add(new Pair(2, 0));
            arrayList.add(new Pair(4, 0));
        } else if (i2 == 3) {
            arrayList.add(new Pair(1, 0));
            arrayList.add(new Pair(0, 0));
        } else if (i2 == 4) {
            arrayList.add(new Pair(1, 2));
            arrayList.add(new Pair(0, 2));
        }
        return arrayList;
    }

    public int fe(@NonNull Hdr hdr) {
        return f9265fe.get(hdr).intValue();
    }

    @Nullable
    public Hdr i(int i2) {
        return (Hdr) th(f9265fe, Integer.valueOf(i2));
    }

    @Nullable
    public WhiteBalance o(int i2) {
        return (WhiteBalance) th(f9264de, Integer.valueOf(i2));
    }

    public int rg(@NonNull WhiteBalance whiteBalance) {
        return f9264de.get(whiteBalance).intValue();
    }

    @Nullable
    public final <C extends Control, T> C th(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r3 != 4) goto L_0x002a;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<com.otaliastudios.cameraview.controls.Flash> uk(int r3) {
        /*
            r2 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r3 == 0) goto L_0x0020
            r1 = 1
            if (r3 == r1) goto L_0x0020
            r1 = 2
            if (r3 == r1) goto L_0x001a
            r1 = 3
            if (r3 == r1) goto L_0x0014
            r1 = 4
            if (r3 == r1) goto L_0x001a
            goto L_0x002a
        L_0x0014:
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.ON
            r0.add(r3)
            goto L_0x002a
        L_0x001a:
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.AUTO
            r0.add(r3)
            goto L_0x002a
        L_0x0020:
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.OFF
            r0.add(r3)
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.TORCH
            r0.add(r3)
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.yj.th.ad.uk(int):java.util.Set");
    }

    @Nullable
    public Facing yj(int i2) {
        return (Facing) th(f9263ad, Integer.valueOf(i2));
    }
}
