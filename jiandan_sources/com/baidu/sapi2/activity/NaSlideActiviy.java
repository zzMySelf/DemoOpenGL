package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.sapi2.ActivityStackManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import fe.fe.ddd.rrr.ad;
import fe.fe.ddd.rrr.qw;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class NaSlideActiviy extends AppCompatActivity {
    public static final String g = "NaSlideActivity";
    public static final boolean h = true;
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getConfignation();
    public SlideInterceptor d;
    public SlidingPaneLayout.PanelSlideListener e;
    public WeakReference<Activity> f;
    public qw mSlideHelper;

    private void b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    public void finishActivityAfterSlideOver() {
        finish();
    }

    public void forceActivityTransparent(boolean z) {
        this.c = z;
    }

    public void onConfigurationChanged(Configuration configuration2) {
        super.onConfigurationChanged(configuration2);
        boolean z = true;
        Log.d(g, "onConfigurationChanged: ");
        qw qwVar = this.mSlideHelper;
        if (qwVar != null) {
            if (configuration2.orientation == 2) {
                z = false;
            }
            qwVar.rg(z);
        }
    }

    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            b();
        }
        super.onCreate(bundle);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration == null || !sapiConfiguration.supportGestureSlide) {
            this.a = false;
        } else {
            this.a = true;
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(g, "onPostCreate");
        a();
    }

    public void setCurrentActivityNoTransparent() {
        ad.de(this, new OnTranslucentListener() {
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void setEnableSliding(boolean z) {
        this.a = z;
    }

    public void setEnableTaskRootSlide(boolean z) {
        this.b = z;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.e = panelSlideListener;
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        this.a = z;
        this.d = slideInterceptor;
    }

    private void a() {
        if (this.a) {
            final int i2 = 0;
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.b && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e(g, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                i2 = displayMetrics.widthPixels;
            }
            qw qwVar = new qw();
            this.mSlideHelper = qwVar;
            qwVar.qw(this);
            this.mSlideHelper.rg(z);
            this.mSlideHelper.ad(this.c);
            this.mSlideHelper.yj(this.d);
            this.mSlideHelper.uk(new SlidingPaneLayout.PanelSlideListener() {
                public void onPanelClosed(View view) {
                    if (NaSlideActiviy.this.e != null) {
                        NaSlideActiviy.this.e.onPanelClosed(view);
                    }
                    NaSlideActiviy.this.a(0.0f);
                }

                public void onPanelOpened(View view) {
                    if (NaSlideActiviy.this.e != null) {
                        NaSlideActiviy.this.e.onPanelOpened(view);
                    }
                    NaSlideActiviy.this.a(0.0f);
                    NaSlideActiviy.this.mSlideHelper.th((Drawable) null);
                    NaSlideActiviy.this.finishActivityAfterSlideOver();
                    NaSlideActiviy.this.overridePendingTransition(0, 0);
                }

                public void onPanelSlide(View view, float f) {
                    View fe2 = NaSlideActiviy.this.mSlideHelper.fe();
                    if (fe2 != null) {
                        float f2 = 1.0f - f;
                        if (f2 < 0.0f) {
                            f2 = 0.0f;
                        }
                        fe2.setAlpha(f2);
                    }
                    if (NaSlideActiviy.this.e != null) {
                        NaSlideActiviy.this.e.onPanelSlide(view, f);
                    }
                    float f3 = (float) (i2 >> 2);
                    NaSlideActiviy.this.a((f * f3) - f3);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(float f2) {
        try {
            if (this.f == null || this.f.get() == null) {
                this.f = new WeakReference<>(ActivityStackManager.getInstance().getPenultimateActivity());
            }
            if (this.f.get() != null) {
                Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
                Activity activity = (Activity) this.f.get();
                if (realTopActivity == null || activity == null || !realTopActivity.getLocalClassName().equals(activity.getLocalClassName())) {
                    a(activity, f2);
                } else {
                    a(activity, 0.0f);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(Activity activity, float f2) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().getDecorView();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
            if (viewGroup != null) {
                viewGroup.setX(f2);
            }
        }
    }
}
