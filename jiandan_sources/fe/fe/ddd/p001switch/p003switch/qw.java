package fe.fe.ddd.p001switch.p003switch;

import java.io.IOException;

/* renamed from: fe.fe.ddd.switch.switch.qw  reason: invalid package */
public class qw {
    public static IOException qw(Exception exc) {
        return new IOException(" no network connected\n" + exc.toString(), exc);
    }
}
