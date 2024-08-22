package fe.nn.qw;

import io.flutter.plugin.common.MethodCall;

public class ad {
    public static boolean ad(int i2) {
        return i2 >= 1;
    }

    public static boolean de(int i2) {
        return i2 >= 2;
    }

    public static Integer qw(MethodCall methodCall) {
        return (Integer) methodCall.argument("logLevel");
    }
}
