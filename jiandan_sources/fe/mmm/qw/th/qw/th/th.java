package fe.mmm.qw.th.qw.th;

import android.content.Context;
import android.util.TypedValue;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;

public class th {
    public static int ad(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
        int i2 = 0;
        if (identifier > 0) {
            try {
                i2 = context.getResources().getDimensionPixelSize(identifier);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? (int) (context.getResources().getDisplayMetrics().density * 25.0f) : i2;
    }

    public static int qw(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
