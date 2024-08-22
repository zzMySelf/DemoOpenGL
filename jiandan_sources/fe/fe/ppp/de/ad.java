package fe.fe.ppp.de;

import com.baidu.pass.a;

public abstract class ad implements a {
    public static final int ERROR_CANCLE = -2;
    public static final int ERROR_FORBID_FOREVER = -3;
    public static final int ERROR_NO_PERMISSION = -1;

    public abstract void onFailure(int i2);

    public abstract void onSuccess();
}
