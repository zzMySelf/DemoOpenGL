package fe.mmm.qw.th.qw.th.when;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import com.tera.scan.component.base.util.toast.BadTokenListener;

public final class qw extends ContextWrapper {

    /* renamed from: ad  reason: collision with root package name */
    public BadTokenListener f8365ad;
    public Toast qw;

    public final class ad extends ContextWrapper {
        public Object getSystemService(String str) {
            if ("window".equals(str)) {
                return new de((WindowManager) getBaseContext().getSystemService(str));
            }
            return super.getSystemService(str);
        }

        public ad(Context context) {
            super(context);
        }
    }

    public final class de implements WindowManager {

        /* renamed from: ad  reason: collision with root package name */
        public final WindowManager f8366ad;

        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                this.f8366ad.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException e) {
                e.getMessage();
                if (qw.this.f8365ad != null) {
                    qw.this.f8365ad.qw(qw.this.qw);
                }
            } catch (Throwable unused) {
            }
        }

        public Display getDefaultDisplay() {
            return this.f8366ad.getDefaultDisplay();
        }

        public void removeView(View view) {
            this.f8366ad.removeView(view);
        }

        public void removeViewImmediate(View view) {
            this.f8366ad.removeViewImmediate(view);
        }

        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.f8366ad.updateViewLayout(view, layoutParams);
        }

        public de(WindowManager windowManager) {
            this.f8366ad = windowManager;
        }
    }

    public qw(Context context, Toast toast) {
        super(context);
        this.qw = toast;
    }

    public void de(BadTokenListener badTokenListener) {
        this.f8365ad = badTokenListener;
    }

    public Context getApplicationContext() {
        return new ad(getBaseContext().getApplicationContext());
    }
}
