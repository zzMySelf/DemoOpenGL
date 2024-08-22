package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.sapi2.ActivityStackManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import fe.fe.ddd.rrr.ad;
import fe.fe.ddd.rrr.qw;
import java.lang.ref.WeakReference;

public class SlideActiviy extends BaseActivity {
    public static final String ACCOUNT_CENTER_PAGE_NAME = "accountCenter";
    public static final String ADDRESS_PAGE_NAME = "address";
    public static final String D = "SlideActivity";
    public static final boolean E = true;
    public static final String EXTRAS_ACTION = "action";
    public static final String EXTRA_PARAMS_SLIDE_PAGE = "slidePage";
    public static final String INVOICE_PAGE_NAME = "invoice";
    public static final String SLIDE_ACTION_QUIT = "quit";
    public SlidingPaneLayout.PanelSlideListener A;
    public boolean B = true;
    public WeakReference<Activity> C;
    public qw mSlideHelper;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public SlideInterceptor z;

    public class PassSlideInterceptor implements SlideInterceptor {
        public PassSlideInterceptor() {
        }

        public boolean isSlidable(MotionEvent motionEvent) {
            return SlideActiviy.this.B;
        }
    }

    public void finishActivityAfterSlideOver() {
        finish();
    }

    public void forceActivityTransparent(boolean z2) {
        this.y = z2;
    }

    public void loadSlideWebview(String str, String str2, String str3) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z2 = true;
        Log.d(D, "onConfigurationChanged: ");
        qw qwVar = this.mSlideHelper;
        if (qwVar != null) {
            if (configuration.orientation == 2) {
                z2 = false;
            }
            qwVar.rg(z2);
        }
    }

    public void onCreate(Bundle bundle) {
        ViewUtility.setOrientationToUndefined(this);
        super.onCreate(bundle);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration == null || !sapiConfiguration.supportGestureSlide) {
            this.w = false;
        } else {
            this.w = true;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(D, "onDetachedFromWindow: ");
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(D, "onPostCreate");
        c();
    }

    public void onPostResume() {
        super.onPostResume();
        Log.d(D, "onPostResume: ");
    }

    public void onResume() {
        super.onResume();
        Log.d(D, "onResume: ");
    }

    public void onStart() {
        super.onStart();
        Log.d(D, "onStart: ");
    }

    public void setCurrentActivityNoTransparent() {
        ad.de(this, new OnTranslucentListener() {
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void setEnableSliding(boolean z2) {
        this.w = z2;
    }

    public void setEnableTaskRootSlide(boolean z2) {
        this.x = z2;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.A = panelSlideListener;
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setLoadSlideWebViewCallback(new SapiWebView.LoadSlideWebViewCallback() {
            public void loadSlideWebview(SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult) {
                Log.d(SlideActiviy.D, "loadSlideWebview: " + loadSlideWebViewResult.url);
                SlideActiviy.this.loadSlideWebview(loadSlideWebViewResult.page, loadSlideWebViewResult.url, loadSlideWebViewResult.adapter);
            }
        });
        this.sapiWebView.setStopSlideWebviewCallback(new SapiJsCallBacks.StopSlideWebviewCallback() {
            public void onStopSlide(boolean z) {
                if (z) {
                    Log.d(SlideActiviy.D, "Slide should be opened now");
                    boolean unused = SlideActiviy.this.B = false;
                } else {
                    Log.d(SlideActiviy.D, "Slide should be closed now");
                    boolean unused2 = SlideActiviy.this.B = true;
                }
                SlideActiviy slideActiviy = SlideActiviy.this;
                SlideInterceptor unused3 = slideActiviy.z = new PassSlideInterceptor();
                SlideActiviy slideActiviy2 = SlideActiviy.this;
                slideActiviy2.mSlideHelper.yj(slideActiviy2.z);
            }
        });
    }

    private void c() {
        if (this.w) {
            final int i2 = 0;
            boolean z2 = getResources().getConfiguration().orientation != 2;
            if (!this.x && isTaskRoot()) {
                z2 = false;
            }
            if ((getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e(D, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                i2 = displayMetrics.widthPixels;
            }
            qw qwVar = new qw();
            this.mSlideHelper = qwVar;
            qwVar.qw(this);
            this.mSlideHelper.rg(z2);
            this.mSlideHelper.ad(this.y);
            this.mSlideHelper.yj(this.z);
            this.mSlideHelper.uk(new SlidingPaneLayout.PanelSlideListener() {
                public void onPanelClosed(View view) {
                    if (SlideActiviy.this.A != null) {
                        SlideActiviy.this.A.onPanelClosed(view);
                    }
                    SlideActiviy.this.a(0.0f);
                }

                public void onPanelOpened(View view) {
                    if (SlideActiviy.this.A != null) {
                        SlideActiviy.this.A.onPanelOpened(view);
                    }
                    SlideActiviy.this.a(0.0f);
                    SlideActiviy.this.mSlideHelper.th((Drawable) null);
                    SlideActiviy.this.finishActivityAfterSlideOver();
                    SlideActiviy.this.overridePendingTransition(0, 0);
                }

                public void onPanelSlide(View view, float f) {
                    View fe2 = SlideActiviy.this.mSlideHelper.fe();
                    if (fe2 != null) {
                        float f2 = 1.0f - f;
                        if (f2 < 0.0f) {
                            f2 = 0.0f;
                        }
                        fe2.setAlpha(f2);
                    }
                    if (SlideActiviy.this.A != null) {
                        SlideActiviy.this.A.onPanelSlide(view, f);
                    }
                    float f3 = (float) (i2 >> 2);
                    SlideActiviy.this.a((f * f3) - f3);
                }
            });
        }
    }

    public void setEnableSliding(boolean z2, SlideInterceptor slideInterceptor) {
        this.w = z2;
        this.z = slideInterceptor;
    }

    /* access modifiers changed from: private */
    public void a(float f) {
        try {
            if (this.C == null || this.C.get() == null) {
                this.C = new WeakReference<>(ActivityStackManager.getInstance().getPenultimateActivity());
            }
            if (this.C.get() != null) {
                Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
                Activity activity = (Activity) this.C.get();
                if (realTopActivity == null || activity == null || !realTopActivity.getLocalClassName().equals(activity.getLocalClassName())) {
                    a(activity, f);
                } else {
                    a(activity, 0.0f);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(Activity activity, float f) {
        ViewGroup viewGroup;
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null && (viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)) != null) {
            viewGroup.setX(f);
        }
    }
}
