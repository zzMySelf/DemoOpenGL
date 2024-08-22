package fe.fe.pf.th.qw;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;

public class fe implements yj {
    public String a(Context context) {
        if (context != null) {
            return DeviceId.getCUID(context);
        }
        throw new NullPointerException("context should not be null");
    }
}
