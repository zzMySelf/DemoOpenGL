package fe.fe.ddd.p001switch;

import android.content.Context;

/* renamed from: fe.fe.ddd.switch.de  reason: invalid package */
public class de extends qw {

    /* renamed from: switch  reason: not valid java name */
    public static volatile de f32switch;

    static {
        new ad();
    }

    public de(Context context) {
        super(context);
    }

    public static de mmm(Context context) {
        if (f32switch == null) {
            synchronized (de.class) {
                if (f32switch == null) {
                    f32switch = new de(context);
                    f32switch.nn(fe.qw().qw());
                }
            }
        }
        return f32switch;
    }
}
