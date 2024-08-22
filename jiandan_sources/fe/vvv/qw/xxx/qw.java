package fe.vvv.qw.xxx;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;

public class qw implements Comparable<qw> {
    @VisibleForTesting

    /* renamed from: yj  reason: collision with root package name */
    public static final HashMap<String, qw> f9131yj = new HashMap<>(16);

    /* renamed from: ad  reason: collision with root package name */
    public final int f9132ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f9133th;

    public qw(int i2, int i3) {
        this.f9132ad = i2;
        this.f9133th = i3;
    }

    public static int fe(int i2, int i3) {
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 == 0) {
                return i5;
            }
            i3 = i5 % i2;
        }
    }

    @NonNull
    public static qw i(@NonNull String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            return th(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    @NonNull
    public static qw th(int i2, int i3) {
        int fe2 = fe(i2, i3);
        if (fe2 > 0) {
            i2 /= fe2;
        }
        if (fe2 > 0) {
            i3 /= fe2;
        }
        String str = i2 + ":" + i3;
        qw qwVar = f9131yj.get(str);
        if (qwVar != null) {
            return qwVar;
        }
        qw qwVar2 = new qw(i2, i3);
        f9131yj.put(str, qwVar2);
        return qwVar2;
    }

    @NonNull
    public static qw uk(@NonNull ad adVar) {
        return th(adVar.rg(), adVar.fe());
    }

    @NonNull
    public qw ad() {
        return th(this.f9133th, this.f9132ad);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw) || o() != ((qw) obj).o()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Float.floatToIntBits(o());
    }

    public float o() {
        return ((float) this.f9132ad) / ((float) this.f9133th);
    }

    /* renamed from: qw */
    public int compareTo(@NonNull qw qwVar) {
        return Float.compare(o(), qwVar.o());
    }

    public boolean rg(@NonNull ad adVar, float f) {
        return Math.abs(o() - uk(adVar).o()) <= f;
    }

    @NonNull
    public String toString() {
        return this.f9132ad + ":" + this.f9133th;
    }
}
