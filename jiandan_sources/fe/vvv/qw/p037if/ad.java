package fe.vvv.qw.p037if;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import fe.vvv.qw.xxx.qw;

/* renamed from: fe.vvv.qw.if.ad  reason: invalid package */
public class ad {
    @NonNull
    public static Rect qw(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull qw qwVar) {
        int i2;
        int rg2 = adVar.rg();
        int fe2 = adVar.fe();
        int i3 = 0;
        if (qwVar.rg(adVar, 5.0E-4f)) {
            return new Rect(0, 0, rg2, fe2);
        }
        if (qw.th(rg2, fe2).o() > qwVar.o()) {
            int round = Math.round(((float) fe2) * qwVar.o());
            rg2 = round;
            i3 = Math.round(((float) (rg2 - round)) / 2.0f);
            i2 = 0;
        } else {
            int round2 = Math.round(((float) rg2) / qwVar.o());
            i2 = Math.round(((float) (fe2 - round2)) / 2.0f);
            fe2 = round2;
        }
        return new Rect(i3, i2, rg2 + i3, fe2 + i2);
    }
}
