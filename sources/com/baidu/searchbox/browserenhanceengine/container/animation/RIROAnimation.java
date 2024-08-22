package com.baidu.searchbox.browserenhanceengine.container.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.browserenhanceengine.container.AnimationContainer;
import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.browsercontrol.BrowserControlContainer;

public class RIROAnimation implements ContainerAnimationInterceptor {
    private static final int MASKVIEW_END = 251658240;
    private static final int MASKVIEW_START = 0;

    public void startAnimation(final Container container, final ContainerAnimationListener listener) {
        if (container != null && (container instanceof BrowserControlContainer)) {
            BrowserControlContainer bcContainer = (BrowserControlContainer) container;
            final View shadowView = bcContainer.getShadowView();
            shadowView.setVisibility(0);
            ObjectAnimator transXShadow = ObjectAnimator.ofFloat(shadowView, "translationX", new float[]{(float) (DeviceUtil.ScreenInfo.getDisplayWidth(bcContainer.getContext()) - BrowserControlContainer.SHADOW_WIDTH), (float) (-BrowserControlContainer.SHADOW_WIDTH)});
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(bcContainer.getSlideView(), "translationX", new float[]{(float) DeviceUtil.ScreenInfo.getDisplayWidth(bcContainer.getContext()), 0.0f});
            AnimatorSet startContainer = new AnimatorSet();
            startContainer.playTogether(new Animator[]{transXShadow, transXContainer});
            startContainer.setDuration(320);
            startContainer.setInterpolator(AnimationContainer.startInterpolator());
            startContainer.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    if (!((BrowserControlContainer) container).isFromGesture()) {
                        container.onContainerAnimationStart(true, false, false);
                    }
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationStart((Animation) null);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    Container container = container;
                    container.onContainerAnimationFinish(true, false, ((BrowserControlContainer) container).isFromGesture());
                    ((BrowserControlContainer) container).setIsFromGesture(false);
                    shadowView.setVisibility(8);
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationEnd((Animation) null);
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    shadowView.setVisibility(8);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            startContainer.start();
        }
    }

    public void startPreAnimation(final Container container, final ContainerAnimationListener listener) {
        if (container != null && (container instanceof BrowserControlContainer)) {
            BrowserControlContainer bcContainer = (BrowserControlContainer) container;
            final View maskView = bcContainer.getMaskView();
            ObjectAnimator colorAnim = ObjectAnimator.ofInt(maskView, "backgroundColor", new int[]{251658240, 0});
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(bcContainer.getSlideView(), "translationX", new float[]{(float) ((-DeviceUtil.ScreenInfo.getDisplayWidth(bcContainer.getContext())) / 3), 0.0f});
            AnimatorSet startPreAnimation = new AnimatorSet();
            startPreAnimation.playTogether(new Animator[]{transXContainer, colorAnim});
            startPreAnimation.setDuration(320);
            startPreAnimation.setInterpolator(AnimationContainer.closeInterpolator());
            startPreAnimation.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    if (!((BrowserControlContainer) container).isFromGesture()) {
                        container.onContainerAnimationStart(true, true, false);
                    }
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationStart((Animation) null);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    Container container = container;
                    container.onContainerAnimationFinish(true, true, ((BrowserControlContainer) container).isFromGesture());
                    ((BrowserControlContainer) container).setIsFromGesture(false);
                    maskView.setBackgroundColor(0);
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationEnd((Animation) null);
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    maskView.setBackgroundColor(0);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            startPreAnimation.start();
        }
    }

    public void closeAnimation(final Container container, final ContainerAnimationListener listener) {
        if (container != null && (container instanceof BrowserControlContainer)) {
            BrowserControlContainer bcContainer = (BrowserControlContainer) container;
            final View shadowView = bcContainer.getShadowView();
            shadowView.setVisibility(0);
            ObjectAnimator transXShadow = ObjectAnimator.ofFloat(shadowView, "translationX", new float[]{(float) (bcContainer.getCurrentX() - BrowserControlContainer.SHADOW_WIDTH), (float) (DeviceUtil.ScreenInfo.getDisplayWidth(bcContainer.getContext()) - BrowserControlContainer.SHADOW_WIDTH)});
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(bcContainer.getSlideView(), "translationX", new float[]{(float) bcContainer.getCurrentX(), (float) DeviceUtil.ScreenInfo.getDisplayWidth(bcContainer.getContext())});
            AnimatorSet closeContainer = new AnimatorSet();
            closeContainer.playTogether(new Animator[]{transXShadow, transXContainer});
            long duration = 320;
            int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(bcContainer.getContext());
            if (displayWidth > 0) {
                duration = (((long) (displayWidth - bcContainer.getCurrentX())) * 320) / ((long) displayWidth);
            }
            closeContainer.setDuration(Math.abs(duration));
            closeContainer.setInterpolator(AnimationContainer.closeInterpolator());
            closeContainer.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    if (!((BrowserControlContainer) container).isFromGesture()) {
                        container.onContainerAnimationStart(false, true, false);
                    }
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationStart((Animation) null);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    Container container = container;
                    container.onContainerAnimationFinish(false, true, ((BrowserControlContainer) container).isFromGesture());
                    ((BrowserControlContainer) container).setIsFromGesture(false);
                    shadowView.setVisibility(8);
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationEnd((Animation) null);
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    shadowView.setVisibility(8);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            closeContainer.start();
        }
    }

    public void closePreAnimation(final Container container, final ContainerAnimationListener listener) {
        if (container != null && (container instanceof BrowserControlContainer)) {
            BrowserControlContainer bcContainer = (BrowserControlContainer) container;
            final View maskView = bcContainer.getMaskView();
            ObjectAnimator colorAnim = ObjectAnimator.ofInt(maskView, "backgroundColor", new int[]{251658240, 0});
            ObjectAnimator transXContainer = ObjectAnimator.ofFloat(bcContainer.getSlideView(), "translationX", new float[]{0.0f, (float) ((-DeviceUtil.ScreenInfo.getDisplayWidth(bcContainer.getContext())) / 3)});
            AnimatorSet closePreAnimation = new AnimatorSet();
            closePreAnimation.playTogether(new Animator[]{transXContainer, colorAnim});
            closePreAnimation.setDuration(320);
            closePreAnimation.setInterpolator(AnimationContainer.startInterpolator());
            closePreAnimation.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    if (!((BrowserControlContainer) container).isFromGesture()) {
                        container.onContainerAnimationStart(false, false, false);
                    }
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationStart((Animation) null);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    Container container = container;
                    container.onContainerAnimationFinish(false, false, ((BrowserControlContainer) container).isFromGesture());
                    ((BrowserControlContainer) container).setIsFromGesture(false);
                    maskView.setBackgroundColor(0);
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationEnd((Animation) null);
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    maskView.setBackgroundColor(0);
                }

                public void onAnimationRepeat(Animator animator) {
                    ContainerAnimationListener containerAnimationListener = listener;
                    if (containerAnimationListener != null) {
                        containerAnimationListener.onAnimationRepeat((Animation) null);
                    }
                }
            });
            closePreAnimation.start();
        }
    }
}
