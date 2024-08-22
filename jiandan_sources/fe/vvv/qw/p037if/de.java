package fe.vvv.qw.p037if;

import com.tera.scan.ui.widget.RotateProgress;

/* renamed from: fe.vvv.qw.if.de  reason: invalid package */
public class de {
    public static int ad(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int qw(int i2) {
        int i3 = (i2 + RotateProgress.FULL_DEGREE) % RotateProgress.FULL_DEGREE;
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 90) {
            return 6;
        }
        if (i3 == 180) {
            return 3;
        }
        if (i3 == 270) {
            return 8;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i2);
    }
}
