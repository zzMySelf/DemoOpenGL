package fe.mmm.qw.d.fe;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.aiscan.R;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import fe.mmm.qw.d.qw;

public class uk {
    public static void ad(Activity activity, boolean z, ViewGroup viewGroup) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    if (de()) {
                        ad.qw(StatusBarUtils.TAG, "ignore Samsung 7.0+ immerse status bar");
                        return;
                    }
                    Window window = activity.getWindow();
                    if (Build.VERSION.SDK_INT >= 23) {
                        window.clearFlags(67108864);
                        window.addFlags(Integer.MIN_VALUE);
                        window.getDecorView().setSystemUiVisibility((z ? 8192 : 0) | 256 | 1024);
                        window.setStatusBarColor(0);
                    } else {
                        window.addFlags(67108864);
                    }
                    if (viewGroup != null) {
                        viewGroup.setPadding(viewGroup.getPaddingLeft(), qw(activity), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
                    }
                }
            } catch (Exception e) {
                ad.qw(StatusBarUtils.TAG, e.getMessage());
            }
        }
    }

    public static boolean de() {
        int i2 = Build.VERSION.SDK_INT;
        return "Samsung".equalsIgnoreCase(Build.BRAND) && (i2 == 24 || i2 == 25);
    }

    public static void fe(Activity activity) {
        rg(activity, yj.ad());
        th(activity, qw.rg(activity));
    }

    public static void i(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 23 && activity != null && !activity.isFinishing()) {
            if (de()) {
                ad.qw(StatusBarUtils.TAG, "ignore Samsung 7.0+ set status bar icon dark");
                return;
            }
            try {
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                if (z) {
                    viewGroup.setSystemUiVisibility(8192);
                } else {
                    viewGroup.setSystemUiVisibility(0);
                }
            } catch (Exception e) {
                ad.qw(StatusBarUtils.TAG, e.getMessage());
            }
        }
    }

    public static int qw(Context context) {
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

    public static void rg(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 21 && activity != null && !activity.isFinishing()) {
            if (de()) {
                ad.qw(StatusBarUtils.TAG, "ignore Samsung 7.0+ set navigation bar");
                return;
            }
            try {
                Window window = activity.getWindow();
                window.clearFlags(134217728);
                window.addFlags(Integer.MIN_VALUE);
                window.setNavigationBarColor(i2);
            } catch (Exception e) {
                ad.qw(StatusBarUtils.TAG, e.getMessage());
            }
        }
    }

    public static void th(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 26 && activity != null && !activity.isFinishing()) {
            if (de()) {
                ad.qw(StatusBarUtils.TAG, "ignore Samsung 7.0+ set navigation bar icon dark");
                return;
            }
            try {
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                int systemUiVisibility = viewGroup.getSystemUiVisibility();
                if (z) {
                    viewGroup.setSystemUiVisibility(systemUiVisibility | 16);
                } else {
                    viewGroup.setSystemUiVisibility(systemUiVisibility & -17);
                }
            } catch (Exception e) {
                ad.qw(StatusBarUtils.TAG, e.getMessage());
            }
        }
    }

    public static void uk(Activity activity, int i2) {
        if (activity != null && activity.isChild()) {
            activity = activity.getParent();
        }
        if (activity != null && !activity.isFinishing()) {
            if (de()) {
                ad.qw(StatusBarUtils.TAG, "ignore Samsung 7.0+ set status bar color");
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Window window = activity.getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.clearFlags(67108864);
                    if (i2 == -1) {
                        window.setStatusBarColor(activity.getResources().getColor(R.color.bg_dn_home_page));
                    } else {
                        window.setStatusBarColor(i2);
                    }
                } catch (Exception e) {
                    ad.qw(StatusBarUtils.TAG, e.getMessage());
                }
            }
            i(activity, qw.rg(activity));
        }
    }

    public static void yj(Activity activity) {
        uk(activity, yj.ad());
    }
}
