package com.baidu.wallet.base.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.ViewUtils;

public class BubbleForSubMenu extends FrameLayout {
    public static final int HAS_ANIMATION = 1;
    public static final int HEIDE_SHOW_ANIMATION = 2;
    public static final int NO_ANIMATION = 0;
    public static final String a = "BubbleForSubMenuTAG";
    public FrameLayout b;
    public TextView c;
    public NetImageView d;
    public CountDownTimer e;
    public ObjectAnimator f;
    public Animator.AnimatorListener g;
    public ObjectAnimator h;

    /* renamed from: i  reason: collision with root package name */
    public Animator.AnimatorListener f1141i;
    public float j;
    public float k;
    public boolean l;
    public int m;

    @RequiresApi(api = 11)
    public BubbleForSubMenu(Context context) {
        super(context);
        a();
        b();
    }

    /* access modifiers changed from: private */
    @RequiresApi(api = 11)
    public void setTransparent(boolean z) {
        if (z) {
            this.c.setAlpha(0.0f);
            this.c.setTextColor(ResUtils.getColor(getContext(), "wallet_base_transparent"));
            return;
        }
        this.c.setAlpha(1.0f);
        this.c.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
    }

    @RequiresApi(api = 11)
    public void addExitAnimation() {
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            this.b.clearAnimation();
            this.j = (float) this.b.getRight();
            this.k = (float) this.b.getLeft();
            LogUtil.d(a, "hide fromX = " + this.k + " ; toX = " + this.j);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, Key.TRANSLATION_X, new float[]{this.k, this.j});
            this.h = ofFloat;
            if (ofFloat != null && ofFloat.getListeners() == null) {
                this.h.addListener(this.f1141i);
            }
            this.h.setDuration(400).start();
        }
    }

    @RequiresApi(api = 11)
    public void hideBubble(boolean z) {
        LogUtil.d(a, "隐藏bubble，mAnimation：" + this.m);
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (z) {
            addExitAnimation();
            return;
        }
        this.b.setVisibility(8);
        setTransparent(true);
    }

    @RequiresApi(api = 11)
    public boolean isShowingBubble() {
        StringBuilder sb = new StringBuilder();
        sb.append("正在展示bubble = ");
        sb.append(this.b.getVisibility() == 0);
        LogUtil.d(a, sb.toString());
        if (this.b.getVisibility() == 0 && this.c.getAlpha() == 1.0f) {
            return true;
        }
        return false;
    }

    @RequiresApi(api = 11)
    public void onDetachedFromWindow() {
        LogUtil.d(a, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f.cancel();
            this.f.removeAllListeners();
            this.f = null;
        }
        ObjectAnimator objectAnimator2 = this.h;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.h.cancel();
            this.h.removeAllListeners();
            this.h = null;
        }
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void showBubble(String str, int i2, boolean z) {
        LogUtil.d(a, "showBubble,isImage:" + z + ",withAnimation:" + i2);
        this.l = z;
        this.m = i2;
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        c();
        if (z) {
            a(str, i2);
            return;
        }
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        showBubbleText(str, z2);
    }

    @RequiresApi(api = 11)
    @SuppressLint({"ObjectAnimatorBinding"})
    public void showBubbleText(String str, boolean z) {
        if (TextUtils.isEmpty(str) || (isShowingBubble() && TextUtils.equals(this.c.getText(), str))) {
            LogUtil.d(a, "正在展示bubble 直接return");
            return;
        }
        if (isShowingBubble()) {
            hideBubble(false);
        }
        setText(str);
        LogUtil.d(a, "展示bubble");
        this.b.setVisibility(0);
        if (z) {
            d();
        } else {
            setTransparent(false);
        }
        LogUtil.d(a, "展示bubble width = " + getWidth());
        if (this.e == null) {
            this.e = new CountDownTimer(CoroutineLiveDataKt.DEFAULT_TIMEOUT, 1000) {
                public void onFinish() {
                    LogUtil.d("bubble", "5s倒计时到点");
                    BubbleForSubMenu.this.b.post(new Runnable() {
                        public void run() {
                            BubbleForSubMenu.this.hideBubble(true);
                        }
                    });
                }

                public void onTick(long j) {
                }
            };
        }
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.e.start();
        }
    }

    private void c() {
        if (this.l) {
            ViewUtils.visibleView(this.d);
            ViewUtils.goneView(this.c);
            return;
        }
        ViewUtils.goneView(this.d);
        ViewUtils.visibleView(this.c);
    }

    /* access modifiers changed from: private */
    @RequiresApi(api = 11)
    @SuppressLint({"ObjectAnimatorBinding"})
    public void d() {
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f.cancel();
        }
        this.b.post(new Runnable() {
            public void run() {
                BubbleForSubMenu bubbleForSubMenu = BubbleForSubMenu.this;
                float unused = bubbleForSubMenu.j = (float) bubbleForSubMenu.b.getRight();
                BubbleForSubMenu bubbleForSubMenu2 = BubbleForSubMenu.this;
                float unused2 = bubbleForSubMenu2.k = (float) bubbleForSubMenu2.b.getLeft();
                LogUtil.d(BubbleForSubMenu.a, "show fromX = " + BubbleForSubMenu.this.j + " ; toX = " + BubbleForSubMenu.this.k);
                BubbleForSubMenu bubbleForSubMenu3 = BubbleForSubMenu.this;
                ObjectAnimator unused3 = bubbleForSubMenu3.f = ObjectAnimator.ofFloat(bubbleForSubMenu3.b, Key.TRANSLATION_X, new float[]{BubbleForSubMenu.this.j, BubbleForSubMenu.this.k});
                if (BubbleForSubMenu.this.f != null && BubbleForSubMenu.this.f.getListeners() == null) {
                    BubbleForSubMenu.this.f.addListener(BubbleForSubMenu.this.g);
                }
                BubbleForSubMenu.this.f.setDuration(400).start();
            }
        });
    }

    @RequiresApi(api = 11)
    private void b() {
        this.g = new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                LogUtil.d(BubbleForSubMenu.a, "进入动画：start");
                if (BubbleForSubMenu.this.l) {
                    BubbleForSubMenu.this.b.setVisibility(0);
                } else {
                    BubbleForSubMenu.this.setTransparent(false);
                }
            }
        };
        this.f1141i = new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                LogUtil.d(BubbleForSubMenu.a, "退出动画：end");
                BubbleForSubMenu.this.b.setVisibility(8);
                BubbleForSubMenu.this.setTransparent(true);
                if (BubbleForSubMenu.this.m == 2) {
                    LogUtil.d(BubbleForSubMenu.a, "退出动画，然后在展示----");
                    BubbleForSubMenu.this.d();
                    int unused = BubbleForSubMenu.this.m = 0;
                }
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        };
    }

    public BubbleForSubMenu(Context context, boolean z) {
        super(context);
        this.l = z;
        a();
        b();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_langbridge_sub_menu_bubble"), this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        layoutParams.rightMargin = DisplayUtils.dip2px(getContext(), 78.0f);
        setLayoutParams(layoutParams);
        this.b = (FrameLayout) findViewById(ResUtils.id(getContext(), "bubble"));
        this.c = (TextView) findViewById(ResUtils.id(getContext(), "bubble_text"));
        this.d = (NetImageView) findViewById(ResUtils.id(getContext(), "bubble_image"));
        c();
    }

    private void a(String str, final int i2) {
        LogUtil.d(a, "showBubbleImage,bubbleUrl:" + str + " ,withAnimation:" + i2);
        if (TextUtils.isEmpty(str)) {
            LogUtil.d(a, "正在展示图片bubble 直接return");
        } else {
            ImageLoader.getInstance(getContext()).getBitmap(str, new ImageLoader.OnGetBitmapListener() {
                public boolean needCancel(String str, Object obj) {
                    return false;
                }

                public void onError(String str, Object obj) {
                    LogUtil.d(BubbleForSubMenu.a, "onError:" + str);
                    if (BubbleForSubMenu.this.d != null) {
                        BubbleForSubMenu.this.d.post(new Runnable() {
                            public void run() {
                                BubbleForSubMenu.this.b.setVisibility(8);
                            }
                        });
                    }
                }

                public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                    BubbleForSubMenu.this.b.post(new Runnable() {
                        public void run() {
                            BubbleForSubMenu.this.d.setImageDrawable(new BitmapDrawable(bitmap));
                            ViewGroup.LayoutParams layoutParams = BubbleForSubMenu.this.d.getLayoutParams();
                            double height = (double) bitmap.getHeight();
                            double width = (double) bitmap.getWidth();
                            layoutParams.width = (int) Math.round(((double) layoutParams.height) * (width / height));
                            BubbleForSubMenu.this.d.setLayoutParams(layoutParams);
                            LogUtil.d(BubbleForSubMenu.a, "--展示图片气泡 getHeight:" + height + " ,getWidth:" + width);
                            BubbleForSubMenu.this.b.clearAnimation();
                            ViewUtils.visibleView(BubbleForSubMenu.this.d);
                            AnonymousClass4 r2 = AnonymousClass4.this;
                            int i2 = i2;
                            if (i2 == 1) {
                                ViewUtils.inVisibleView(BubbleForSubMenu.this.b);
                                LogUtil.d(BubbleForSubMenu.a, "--展示图片气泡 开始动画--");
                                BubbleForSubMenu.this.d();
                            } else if (i2 == 2) {
                                BubbleForSubMenu.this.addExitAnimation();
                            } else {
                                BubbleForSubMenu.this.b.setTranslationX(0.0f);
                                BubbleForSubMenu.this.b.setVisibility(0);
                                LogUtil.d(BubbleForSubMenu.a, "图片直接展示mBubbleImage:" + BubbleForSubMenu.this.d.getVisibility() + "，mBubbleLayout:" + BubbleForSubMenu.this.b.getVisibility() + ",线程：" + Thread.currentThread().getName());
                            }
                        }
                    });
                }
            }, "", MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
    }
}
