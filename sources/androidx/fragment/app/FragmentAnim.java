package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;
import androidx.fragment.app.FragmentTransition;

class FragmentAnim {
    private FragmentAnim() {
    }

    static AnimationOrAnimator loadAnimation(Context context, FragmentContainer fragmentContainer, Fragment fragment, boolean enter) {
        int animResourceId;
        int transit = fragment.getNextTransition();
        int nextAnim = fragment.getNextAnim();
        fragment.setNextAnim(0);
        View container = fragmentContainer.onFindViewById(fragment.mContainerId);
        if (!(container == null || container.getTag(R.id.visible_removing_fragment_view_tag) == null)) {
            container.setTag(R.id.visible_removing_fragment_view_tag, (Object) null);
        }
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation animation = fragment.onCreateAnimation(transit, enter, nextAnim);
        if (animation != null) {
            return new AnimationOrAnimator(animation);
        }
        Animator animator = fragment.onCreateAnimator(transit, enter, nextAnim);
        if (animator != null) {
            return new AnimationOrAnimator(animator);
        }
        if (nextAnim != 0) {
            boolean isAnim = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            boolean successfulLoad = false;
            if (isAnim) {
                try {
                    Animation animation2 = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animation2 != null) {
                        return new AnimationOrAnimator(animation2);
                    }
                    successfulLoad = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException e3) {
                }
            }
            if (!successfulLoad) {
                try {
                    Animator animator2 = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (animator2 != null) {
                        return new AnimationOrAnimator(animator2);
                    }
                } catch (RuntimeException e4) {
                    if (!isAnim) {
                        Animation animation3 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (animation3 != null) {
                            return new AnimationOrAnimator(animation3);
                        }
                    } else {
                        throw e4;
                    }
                }
            }
        }
        if (transit != 0 && (animResourceId = transitToAnimResourceId(transit, enter)) >= 0) {
            return new AnimationOrAnimator(AnimationUtils.loadAnimation(context, animResourceId));
        }
        return null;
    }

    static void animateRemoveFragment(final Fragment fragment, AnimationOrAnimator anim, final FragmentTransition.Callback callback) {
        View viewToAnimate = fragment.mView;
        final ViewGroup container = fragment.mContainer;
        container.startViewTransition(viewToAnimate);
        final CancellationSignal signal = new CancellationSignal();
        signal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            public void onCancel() {
                if (fragment.getAnimatingAway() != null) {
                    View v = fragment.getAnimatingAway();
                    fragment.setAnimatingAway((View) null);
                    v.clearAnimation();
                }
                fragment.setAnimator((Animator) null);
            }
        });
        callback.onStart(fragment, signal);
        if (anim.animation != null) {
            Animation animation = new EndViewTransitionAnimation(anim.animation, container, viewToAnimate);
            fragment.setAnimatingAway(fragment.mView);
            animation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    container.post(new Runnable() {
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway((View) null);
                                callback.onComplete(fragment, signal);
                            }
                        }
                    });
                }

                public void onAnimationRepeat(Animation animation) {
                }
            });
            fragment.mView.startAnimation(animation);
            return;
        }
        Animator animator = anim.animator;
        fragment.setAnimator(anim.animator);
        final ViewGroup viewGroup = container;
        final View view2 = viewToAnimate;
        final Fragment fragment2 = fragment;
        final FragmentTransition.Callback callback2 = callback;
        final CancellationSignal cancellationSignal = signal;
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                viewGroup.endViewTransition(view2);
                Animator animator = fragment2.getAnimator();
                fragment2.setAnimator((Animator) null);
                if (animator != null && viewGroup.indexOfChild(view2) < 0) {
                    callback2.onComplete(fragment2, cancellationSignal);
                }
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int transitToAnimResourceId(int transit, boolean enter) {
        switch (transit) {
            case 4097:
                return enter ? R.anim.fragment_open_enter : R.anim.fragment_open_exit;
            case 4099:
                return enter ? R.anim.fragment_fade_enter : R.anim.fragment_fade_exit;
            case 8194:
                return enter ? R.anim.fragment_close_enter : R.anim.fragment_close_exit;
            default:
                return -1;
        }
    }

    static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animation animation2) {
            this.animation = animation2;
            this.animator = null;
            if (animation2 == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator2) {
            this.animation = null;
            this.animator = animator2;
            if (animator2 == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    private static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating = true;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(Animation animation, ViewGroup parent, View child) {
            super(false);
            this.mParent = parent;
            this.mChild = child;
            addAnimation(animation);
            parent.post(this);
        }

        public boolean getTransformation(long currentTime, Transformation t) {
            this.mAnimating = true;
            if (this.mEnded) {
                return true ^ this.mTransitionEnded;
            }
            if (!super.getTransformation(currentTime, t)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        public boolean getTransformation(long currentTime, Transformation outTransformation, float scale) {
            this.mAnimating = true;
            if (this.mEnded) {
                return true ^ this.mTransitionEnded;
            }
            if (!super.getTransformation(currentTime, outTransformation, scale)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
                return;
            }
            this.mAnimating = false;
            this.mParent.post(this);
        }
    }
}
