package com.baidu.searchbox.browserenhanceengine.container;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.browserenhanceengine.container.ContainerModel;
import com.baidu.searchbox.browserenhanceengine.container.animation.ContainerAnimationListener;
import com.baidu.searchbox.browserenhanceengine.utils.BeeAbTestUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;

public abstract class AnimationContainer<T extends ContainerModel> extends Container<T> {
    public static final long ANIM_ENTER_DURATION = 320;
    public static final long ANIM_EXIT_DURATION = 240;
    public static final long ANIM_START_DURATION = 0;
    protected static final int DEFAULT_MASK_COLOR = 671088640;
    public static final int SHADOW_WIDTH = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 8.0f);
    protected AnimatorSet mAnimatorSet;
    private Context mContext;
    protected int mCurrentX = 0;
    protected int mDisplayWidth = 0;
    /* access modifiers changed from: private */
    public boolean mIsFromGesture = false;
    /* access modifiers changed from: private */
    public View mMaskView;
    /* access modifiers changed from: private */
    public ImageView mShadowView;

    public abstract View moveView();

    public View maskView() {
        if (this.mMaskView == null && this.mContext != null) {
            View view2 = new View(this.mContext);
            this.mMaskView = view2;
            view2.setBackgroundColor(671088640);
            this.mMaskView.setAlpha(0.0f);
            this.mMaskView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        return this.mMaskView;
    }

    public ImageView shadowView() {
        if (this.mShadowView == null && this.mContext != null) {
            ImageView imageView = new ImageView(this.mContext);
            this.mShadowView = imageView;
            imageView.setImageResource(R.drawable.sliding_layout_shadow);
            this.mShadowView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mShadowView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        }
        return this.mShadowView;
    }

    public AnimationContainer(Context context, T struct) {
        super(struct);
        this.mDisplayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        this.mContext = context;
        if (this.mShadowView == null) {
            this.mShadowView = shadowView();
        }
        if (this.mMaskView == null) {
            this.mMaskView = maskView();
        }
    }

    private void addShadowView() {
        ImageView imageView;
        if (moveView() != null && (imageView = this.mShadowView) != null && imageView.getParent() == null) {
            ((ViewGroup) moveView()).addView(this.mShadowView);
            this.mShadowView.setTranslationX((float) (-SHADOW_WIDTH));
        }
    }

    private void addMaskView() {
        View view2;
        if (moveView() != null && (view2 = this.mMaskView) != null && view2.getParent() == null) {
            ((ViewGroup) moveView()).addView(this.mMaskView);
        }
    }

    public void resetShadowAndMask() {
        View view2 = this.mMaskView;
        if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mMaskView.getParent()).removeView(this.mMaskView);
        }
        ImageView imageView = this.mShadowView;
        if (imageView != null && (imageView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mShadowView.getParent()).removeView(this.mShadowView);
        }
    }

    public void scrollLeft(int dx) {
        if (moveView() != null && this.mShadowView != null && rootView() != null) {
            addShadowView();
            if (rootView().getVisibility() != 0) {
                rootView().setVisibility(0);
            }
            this.mCurrentX = this.mDisplayWidth - dx;
            moveView().setTranslationX((float) (this.mDisplayWidth - dx));
            moveView().invalidate();
            if (!this.mIsContainerVisible) {
                onContainerVisibleChanged(true);
            }
            if (!this.mIsFromGesture) {
                this.mIsFromGesture = true;
                onContainerAnimationStart(true, false, true);
            }
        }
    }

    public void scrollRight(int dx) {
        if (moveView() != null && this.mShadowView != null && rootView() != null) {
            addShadowView();
            if (rootView().getVisibility() != 0) {
                rootView().setVisibility(0);
            }
            this.mCurrentX = dx;
            moveView().setTranslationX((float) dx);
            moveView().invalidate();
            if (!this.mIsContainerVisible) {
                onContainerVisibleChanged(true);
            }
            if (!this.mIsFromGesture) {
                this.mIsFromGesture = true;
                onContainerAnimationStart(false, true, true);
            }
        }
    }

    public void scrollPreLeft(int dx) {
        if (this.mDisplayWidth == 0) {
            this.mDisplayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext);
        }
        if (moveView() != null && this.mMaskView != null && rootView() != null && this.mDisplayWidth != 0) {
            if (rootView().getVisibility() != 0) {
                rootView().setVisibility(0);
            }
            addMaskView();
            this.mCurrentX = (-dx) / 4;
            this.mMaskView.setBackgroundColor(671088640);
            this.mMaskView.setAlpha(((float) dx) / ((float) this.mDisplayWidth));
            this.mMaskView.invalidate();
            moveView().setTranslationX((float) ((-dx) / 4));
            moveView().invalidate();
            if (getContainerStatus() == 4118) {
                changeStatus(4115);
            }
            if (!this.mIsContainerVisible) {
                onContainerVisibleChanged(true);
            }
            if (!this.mIsFromGesture) {
                this.mIsFromGesture = true;
                onContainerAnimationStart(false, false, true);
            }
        }
    }

    public void scrollPreRight(int dx) {
        if (this.mDisplayWidth == 0) {
            this.mDisplayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext);
        }
        if (moveView() != null && this.mMaskView != null && rootView() != null && this.mDisplayWidth != 0) {
            if (rootView().getVisibility() != 0) {
                rootView().setVisibility(0);
            }
            addMaskView();
            this.mCurrentX = (-(this.mDisplayWidth - dx)) / 4;
            this.mMaskView.setBackgroundColor(671088640);
            this.mMaskView.setAlpha(1.0f - (((float) dx) / ((float) this.mDisplayWidth)));
            this.mMaskView.invalidate();
            moveView().setTranslationX((float) ((dx - this.mDisplayWidth) / 4));
            moveView().invalidate();
            if (dx == 0) {
                this.mMaskView.setAlpha(0.0f);
            }
            if (getContainerStatus() == 4118) {
                changeStatus(4115);
            }
            if (!this.mIsContainerVisible) {
                onContainerVisibleChanged(true);
            }
            if (!this.mIsFromGesture) {
                this.mIsFromGesture = true;
                onContainerAnimationStart(true, true, true);
            }
        }
    }

    public void startAnimation(final ContainerAnimationListener listener, long startDuration) {
        if (this.mDisplayWidth == 0) {
            this.mDisplayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext);
        }
        if (moveView() != null && this.mShadowView != null && rootView() != null && this.mDisplayWidth != 0) {
            AnimatorSet animatorSet = this.mAnimatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.mShadowView.setVisibility(0);
            if (this.mCurrentX <= 0) {
                this.mCurrentX = this.mDisplayWidth;
            }
            moveView().setTranslationX((float) this.mCurrentX);
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(moveView(), "translationX", new float[]{(float) this.mCurrentX, 0.0f});
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mAnimatorSet = animatorSet2;
            animatorSet2.playSequentially(new Animator[]{transXContainer});
            this.mAnimatorSet.setDuration((((long) this.mCurrentX) * 320) / ((long) this.mDisplayWidth));
            if (startDuration > 0) {
                this.mAnimatorSet.setStartDelay(startDuration);
            }
            this.mAnimatorSet.setInterpolator(startInterpolator());
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    if (AnimationContainer.this.rootView() != null) {
                        AnimationContainer.this.rootView().setVisibility(0);
                        ContainerAnimationListener containerAnimationListener = listener;
                        if (containerAnimationListener != null) {
                            containerAnimationListener.onAnimationStart((Animation) null);
                        }
                        if (!AnimationContainer.this.mIsFromGesture) {
                            AnimationContainer.this.onContainerAnimationStart(true, false, false);
                        }
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (UiThreadUtils.isOnUiThread()) {
                        AnimationContainer.this.containerAnimationEnd(listener);
                    } else {
                        UiThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                AnimationContainer.this.containerAnimationEnd(listener);
                            }
                        });
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    onAnimationEnd(animator);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            this.mAnimatorSet.start();
        }
    }

    /* access modifiers changed from: private */
    public void containerAnimationEnd(ContainerAnimationListener listener) {
        ImageView imageView = this.mShadowView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.mCurrentX = 0;
        if (listener != null) {
            listener.onAnimationEnd((Animation) null);
        }
        onContainerAnimationFinish(true, false, this.mIsFromGesture);
        this.mIsFromGesture = false;
    }

    public Long getAnimExitDurationMillis(long durationMillis, long delayMillis) {
        if (delayMillis <= 0 || !BeeAbTestUtils.isExitAnimDelayShortenDuration() || durationMillis <= delayMillis) {
            return Long.valueOf(durationMillis);
        }
        return Long.valueOf(durationMillis - delayMillis);
    }

    public Long getAnimExitDelayMillis(long delayMillis, long currentX) {
        if (currentX == 0) {
            return Long.valueOf(delayMillis);
        }
        return 0L;
    }

    public void startPreAnimation(ContainerAnimationListener listener) {
        startPreAnimation(listener, 0);
    }

    public void startPreAnimation(ContainerAnimationListener listener, long delayMillisConfig) {
        if (this.mDisplayWidth == 0) {
            this.mDisplayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext);
        }
        if (moveView() == null || this.mMaskView == null || rootView() == null) {
            ContainerAnimationListener containerAnimationListener = listener;
            long j2 = delayMillisConfig;
        } else if (this.mDisplayWidth == 0) {
            ContainerAnimationListener containerAnimationListener2 = listener;
            long j3 = delayMillisConfig;
        } else {
            AnimatorSet animatorSet = this.mAnimatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            final long delayDuration = getAnimExitDelayMillis(delayMillisConfig, (long) this.mCurrentX).longValue();
            if (this.mCurrentX >= 0) {
                this.mCurrentX = (-this.mDisplayWidth) / 3;
            }
            ObjectAnimator colorAnim = ObjectAnimator.ofFloat(this.mMaskView, "alpha", new float[]{((float) this.mCurrentX) / ((float) ((-this.mDisplayWidth) / 4)), 0.0f});
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(moveView(), "translationX", new float[]{(float) this.mCurrentX, 0.0f});
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mAnimatorSet = animatorSet2;
            animatorSet2.playTogether(new Animator[]{transXContainer, colorAnim});
            long duration = getAnimExitDurationMillis((((long) this.mCurrentX) * 240) / ((long) ((-this.mDisplayWidth) / 4)), delayDuration).longValue();
            this.mAnimatorSet.setDuration(duration > 0 ? duration : 0);
            this.mAnimatorSet.setInterpolator(closeInterpolator());
            if (delayDuration > 0) {
                this.mAnimatorSet.setStartDelay(delayDuration);
                if (!this.mIsFromGesture) {
                    onContainerAnimationStart(true, true, false);
                }
            }
            final ContainerAnimationListener containerAnimationListener3 = listener;
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    if (AnimationContainer.this.rootView() != null) {
                        AnimationContainer.this.rootView().setVisibility(0);
                        ContainerAnimationListener containerAnimationListener = containerAnimationListener3;
                        if (containerAnimationListener != null) {
                            containerAnimationListener.onAnimationStart((Animation) null);
                        }
                        if (delayDuration == 0 && !AnimationContainer.this.mIsFromGesture) {
                            AnimationContainer.this.onContainerAnimationStart(true, true, false);
                        }
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    AnimationContainer.this.mMaskView.setAlpha(0.0f);
                    AnimationContainer.this.mCurrentX = 0;
                    ContainerAnimationListener containerAnimationListener = containerAnimationListener3;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationEnd((Animation) null);
                    }
                    AnimationContainer animationContainer = AnimationContainer.this;
                    animationContainer.onContainerAnimationFinish(true, true, animationContainer.mIsFromGesture);
                    boolean unused = AnimationContainer.this.mIsFromGesture = false;
                }

                public void onAnimationCancel(Animator animator) {
                    onAnimationEnd(animator);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = containerAnimationListener3;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            this.mAnimatorSet.start();
        }
    }

    public void closeAnimation(ContainerAnimationListener listener) {
        closeAnimation(listener, 0);
    }

    public void closeAnimation(final ContainerAnimationListener listener, long delayMillisConfig) {
        if (this.mDisplayWidth == 0) {
            this.mDisplayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext);
        }
        if (moveView() != null && this.mShadowView != null && rootView() != null && this.mDisplayWidth != 0) {
            AnimatorSet animatorSet = this.mAnimatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (this.mCurrentX == this.mDisplayWidth) {
                this.mCurrentX = 0;
            }
            final long delayDuration = getAnimExitDelayMillis(delayMillisConfig, (long) this.mCurrentX).longValue();
            this.mShadowView.setVisibility(0);
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(moveView(), "translationX", new float[]{(float) this.mCurrentX, (float) this.mDisplayWidth});
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mAnimatorSet = animatorSet2;
            animatorSet2.playSequentially(new Animator[]{transXContainer});
            int i2 = this.mDisplayWidth;
            long duration = getAnimExitDurationMillis((((long) (i2 - this.mCurrentX)) * 240) / ((long) i2), delayDuration).longValue();
            this.mAnimatorSet.setDuration(duration > 0 ? duration : 0);
            if (delayDuration > 0) {
                this.mAnimatorSet.setStartDelay(delayDuration);
                if (!this.mIsFromGesture) {
                    onContainerAnimationStart(false, true, false);
                }
            }
            this.mAnimatorSet.setInterpolator(closeInterpolator());
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationStart((Animation) null);
                    }
                    if (delayDuration == 0 && !AnimationContainer.this.mIsFromGesture) {
                        AnimationContainer.this.onContainerAnimationStart(false, true, false);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    AnimationContainer.this.mShadowView.setVisibility(8);
                    AnimationContainer.this.mCurrentX = 0;
                    if (AnimationContainer.this.rootView() != null) {
                        AnimationContainer.this.rootView().setVisibility(8);
                        ContainerAnimationListener containerAnimationListener = listener;
                        if (containerAnimationListener != null) {
                            containerAnimationListener.onAnimationEnd((Animation) null);
                        }
                        AnimationContainer.this.changeStatus(4118);
                        AnimationContainer animationContainer = AnimationContainer.this;
                        animationContainer.onContainerAnimationFinish(false, true, animationContainer.mIsFromGesture);
                        boolean unused = AnimationContainer.this.mIsFromGesture = false;
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    AnimationContainer.this.rootView().setVisibility(8);
                    onAnimationEnd(animator);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            this.mAnimatorSet.start();
        }
    }

    public void closePreAnimation(final ContainerAnimationListener listener, long startDuration) {
        if (this.mDisplayWidth == 0) {
            this.mDisplayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext);
        }
        if (moveView() != null && this.mMaskView != null && rootView() != null && this.mDisplayWidth != 0) {
            AnimatorSet animatorSet = this.mAnimatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            ObjectAnimator colorAnim = ObjectAnimator.ofFloat(this.mMaskView, "alpha", new float[]{((float) this.mCurrentX) / ((float) ((-this.mDisplayWidth) / 4)), 1.0f});
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(moveView(), "translationX", new float[]{(float) this.mCurrentX, (float) ((-this.mDisplayWidth) / 4)});
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mAnimatorSet = animatorSet2;
            animatorSet2.playTogether(new Animator[]{transXContainer, colorAnim});
            int i2 = this.mDisplayWidth;
            long duration = (((long) (((-i2) / 4) - this.mCurrentX)) * 320) / ((long) ((-i2) / 4));
            this.mAnimatorSet.setDuration(duration > 0 ? duration : 0);
            if (startDuration > 0) {
                this.mAnimatorSet.setStartDelay(startDuration);
            }
            this.mAnimatorSet.setInterpolator(startInterpolator());
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationStart((Animation) null);
                    }
                    if (!AnimationContainer.this.mIsFromGesture) {
                        AnimationContainer.this.onContainerAnimationStart(false, false, false);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    AnimationContainer.this.mMaskView.setAlpha(0.0f);
                    AnimationContainer.this.mCurrentX = 0;
                    if (AnimationContainer.this.rootView() != null) {
                        AnimationContainer.this.rootView().setVisibility(8);
                        AnimationContainer.this.rootView().setTranslationX(0.0f);
                        ContainerAnimationListener containerAnimationListener = listener;
                        if (containerAnimationListener != null) {
                            containerAnimationListener.onAnimationEnd((Animation) null);
                        }
                        AnimationContainer.this.changeStatus(4118);
                        AnimationContainer animationContainer = AnimationContainer.this;
                        animationContainer.onContainerAnimationFinish(false, false, animationContainer.mIsFromGesture);
                        boolean unused = AnimationContainer.this.mIsFromGesture = false;
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    AnimationContainer.this.rootView().setVisibility(8);
                    onAnimationEnd(animator);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            this.mAnimatorSet.start();
        }
    }

    public static Interpolator startInterpolator() {
        return PathInterpolatorCompat.create(0.2f, 0.6f, 0.43f, 1.0f);
    }

    public static Interpolator closeInterpolator() {
        return PathInterpolatorCompat.create(0.3f, 0.9f, 0.1f, 1.0f);
    }

    public boolean isFromGesture() {
        return this.mIsFromGesture;
    }

    public void setIsFromGesture(boolean fromGesture) {
        this.mIsFromGesture = fromGesture;
    }

    public void preSlideBack() {
    }
}
