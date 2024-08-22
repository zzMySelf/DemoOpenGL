package fe.mmm.qw.th.qw.th;

import android.content.Context;
import android.widget.Toast;
import com.tera.scan.component.base.util.toast.SafeToast;
import com.tera.scan.framework.kernel.BaseApplication;
import fe.mmm.qw.i.qw;

public class o {
    public static Toast qw;

    public static void ad(String str) {
        Toast toast = qw;
        if (toast != null) {
            toast.cancel();
        }
        Context instance = BaseApplication.getInstance();
        if (instance != null) {
            qw = SafeToast.makeText(instance, (CharSequence) str, 0);
        }
        try {
            if (qw != null) {
                qw.setText(str);
            }
        } catch (Exception unused) {
        }
    }

    public static void de(Context context, int i2) {
        qw(i2);
        Toast toast = qw;
        if (toast != null) {
            toast.setDuration(1);
            qw.show();
        }
    }

    public static void fe(Context context, String str) {
        ad(str);
        Toast toast = qw;
        if (toast != null) {
            toast.setDuration(1);
            qw.show();
        }
    }

    public static void qw(int i2) {
        ad(BaseApplication.getInstance().getResources().getString(i2));
    }

    public static void rg(int i2) {
        de(BaseApplication.getInstance(), i2);
    }

    public static void th(Context context, int i2) {
        qw(i2);
        Toast toast = qw;
        if (toast != null) {
            toast.show();
        }
    }

    public static void uk(String str) {
        fe(BaseApplication.getInstance(), str);
    }

    public static void yj(Context context, String str) {
        ad(str);
        Toast toast = qw;
        if (toast != null) {
            try {
                toast.setGravity(17, 0, 0);
                qw.show();
            } catch (Exception e) {
                qw.th("ToastHelper", "", e);
            }
        }
    }
}
