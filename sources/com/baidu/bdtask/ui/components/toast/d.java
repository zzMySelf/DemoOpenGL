package com.baidu.bdtask.ui.components.toast;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.bdtask.framework.ui.toast.ToastLayoutParams;
import com.baidu.bdtask.ui.R;
import com.baidu.bdtask.ui.components.toast.UniversalToast;
import com.baidu.bdtask.ui.components.toast.a;

class d extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static View f11092a;

    /* renamed from: b  reason: collision with root package name */
    private static Runnable f11093b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static View f11094c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static boolean f11095d = false;

    static View a(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* access modifiers changed from: private */
    public static void b(View view2, View view3, int i2, FrameLayout.LayoutParams layoutParams, int i3) {
        if (view2 != null && view3 != null) {
            a(view2, view3, i2, layoutParams, AnimationUtils.loadAnimation(view2.getContext(), i3));
        }
    }

    private static void a(View view2, View view3, int i2, FrameLayout.LayoutParams layoutParams, Animation animation) {
        if (view2 != null && view3 != null) {
            final Context context = view2.getContext();
            if (view3.getParent() instanceof ViewGroup) {
                ((ViewGroup) view3.getParent()).removeView(view3);
            }
            view3.setClickable(true);
            if (view2 instanceof ViewGroup) {
                final View view4 = view2;
                final View view5 = view3;
                final FrameLayout.LayoutParams layoutParams2 = layoutParams;
                final Animation animation2 = animation;
                view2.post(new Runnable() {
                    public void run() {
                        if (d.f11095d && view4 != null) {
                            if (d.f11094c != null && (d.f11094c.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) d.f11094c.getParent()).removeView(d.f11094c);
                            }
                            Context context = context;
                            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                                FrameLayout frameLayout = new FrameLayout(context);
                                frameLayout.setClickable(true);
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                layoutParams.topMargin = UniversalToast.c(context);
                                View view2 = view4;
                                if (view2 instanceof ViewGroup) {
                                    ((ViewGroup) view2).addView(frameLayout, layoutParams);
                                    View unused = d.f11094c = frameLayout;
                                }
                            } else {
                                return;
                            }
                        }
                        if (d.f11092a != null && (d.f11092a.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) d.f11092a.getParent()).removeView(d.f11092a);
                        }
                        Context context2 = context;
                        if (!(context2 instanceof Activity) || !((Activity) context2).isFinishing()) {
                            ((ViewGroup) view4).addView(view5, layoutParams2);
                            view5.startAnimation(animation2);
                            View unused2 = d.f11092a = view5;
                        }
                    }
                });
                if (f11093b == null) {
                    f11093b = new Runnable() {
                        public void run() {
                            d.a();
                        }
                    };
                }
                view2.postDelayed(f11093b, (long) (i2 * 1000));
            }
        }
    }

    static void a(Activity activity, CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, String str, String str2, String str3, String str4, String str5, String str6, UniversalToast.ToastCallback toastCallback, ToastLayoutParams toastLayoutParams) {
        final View a2 = a(activity);
        if (a2 != null) {
            activity.getResources();
            Context context = a2.getContext();
            final int dimension = (int) context.getResources().getDimension(R.dimen.sdk_toast_view_margin_bottom);
            if (toastLayoutParams != null) {
                dimension = toastLayoutParams.getBottomMargin();
            }
            final int i5 = i4;
            AnonymousClass3 r12 = new a.C0206a() {
                public void a(ViewGroup viewGroup) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 81;
                    layoutParams.bottomMargin = dimension;
                    d.b(a2, viewGroup, i5, layoutParams, R.anim.sdk_toast_enter);
                }
            };
            final UniversalToast.ToastCallback toastCallback2 = toastCallback;
            a(context, charSequence, i2, charSequence2, i3, str, str2, str3, str4, str5, str6, r12, new UniversalToast.ToastCallback() {
                public void onToastClick() {
                    UniversalToast.ToastCallback toastCallback = UniversalToast.ToastCallback.this;
                    if (toastCallback != null) {
                        toastCallback.onToastClick();
                    }
                    d.a();
                }
            });
        }
    }

    public static synchronized void a() {
        synchronized (d.class) {
            final View view2 = f11092a;
            if (view2 != null) {
                final View view3 = f11094c;
                view2.post(new Runnable() {
                    public void run() {
                        Animation loadAnimation = AnimationUtils.loadAnimation(view2.getContext(), R.anim.sdk_toast_exit);
                        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                            public void onAnimationStart(Animation animation) {
                            }

                            public void onAnimationEnd(Animation animation) {
                                if (view2.getParent() instanceof ViewGroup) {
                                    view2.post(new Runnable() {
                                        public void run() {
                                            if (view2.getParent() != null) {
                                                ((ViewGroup) view2.getParent()).removeView(view2);
                                            }
                                        }
                                    });
                                }
                                if (view3 != null) {
                                    view3.post(new Runnable() {
                                        public void run() {
                                            if (view3 != null && view3.getParent() != null && (view3.getParent() instanceof ViewGroup)) {
                                                ((ViewGroup) view3.getParent()).removeView(view3);
                                            }
                                        }
                                    });
                                }
                            }

                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                        view2.startAnimation(loadAnimation);
                    }
                });
                f11092a.removeCallbacks(f11093b);
                f11092a = null;
                f11093b = null;
                f11094c = null;
            }
        }
    }
}
