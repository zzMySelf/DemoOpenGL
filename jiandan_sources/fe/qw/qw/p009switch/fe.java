package fe.qw.qw.p009switch;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.KeyPathElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.qw.qw.switch.fe  reason: invalid package */
public class fe {

    /* renamed from: de  reason: collision with root package name */
    public static final fe f3438de = new fe("COMPOSITION");
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public KeyPathElement f3439ad;
    public final List<String> qw;

    public fe(String... strArr) {
        this.qw = Arrays.asList(strArr);
    }

    public final boolean ad() {
        List<String> list = this.qw;
        return list.get(list.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean de(String str, int i2) {
        if (i2 >= this.qw.size()) {
            return false;
        }
        boolean z = i2 == this.qw.size() - 1;
        String str2 = this.qw.get(i2);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if ((z || (i2 == this.qw.size() - 2 && ad())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.qw.get(i2 + 1).equals(str)) {
            if (i2 == this.qw.size() - 2 || (i2 == this.qw.size() - 3 && ad())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i3 = i2 + 1;
            if (i3 < this.qw.size() - 1) {
                return false;
            }
            return this.qw.get(i3).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement fe() {
        return this.f3439ad;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public fe i(KeyPathElement keyPathElement) {
        fe feVar = new fe(this);
        feVar.f3439ad = keyPathElement;
        return feVar;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public fe qw(String str) {
        fe feVar = new fe(this);
        feVar.qw.add(str);
        return feVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int rg(String str, int i2) {
        if (th(str)) {
            return 0;
        }
        if (!this.qw.get(i2).equals("**")) {
            return 1;
        }
        if (i2 != this.qw.size() - 1 && this.qw.get(i2 + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public final boolean th(String str) {
        return "__container".equals(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.qw);
        sb.append(",resolved=");
        sb.append(this.f3439ad != null);
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean uk(String str, int i2) {
        if (!"__container".equals(str) && i2 >= this.qw.size() - 1 && !this.qw.get(i2).equals("**")) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean yj(String str, int i2) {
        if (th(str)) {
            return true;
        }
        if (i2 >= this.qw.size()) {
            return false;
        }
        if (this.qw.get(i2).equals(str) || this.qw.get(i2).equals("**") || this.qw.get(i2).equals("*")) {
            return true;
        }
        return false;
    }

    public fe(fe feVar) {
        this.qw = new ArrayList(feVar.qw);
        this.f3439ad = feVar.f3439ad;
    }
}
