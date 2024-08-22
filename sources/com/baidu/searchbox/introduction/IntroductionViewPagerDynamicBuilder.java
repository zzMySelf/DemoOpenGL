package com.baidu.searchbox.introduction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.intro.R;
import com.baidu.searchbox.introduction.view.IntroductionScrollInterface;

public class IntroductionViewPagerDynamicBuilder extends LaunchIntroBaseBuilder implements ViewPager.PageTransformer {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final float MIN_SCALE = 0.6f;
    private static final int OFF_SCREENPAGE_LIMIT = 3;
    private static final String TAG = "IntroViewPagerBuilder";
    /* access modifiers changed from: private */
    public ViewGroup mDotsLayout;
    private View mIntroductionView;
    private WorkspaceStateListener mListener;
    private boolean mNeedDotsLayout = true;
    /* access modifiers changed from: private */
    public ViewPager mViewPager;

    private void initConfig() {
        if (this.mParamsList.size() > 0) {
            this.mListener = (WorkspaceStateListener) this.mParamsList.get(0);
        }
    }

    /* access modifiers changed from: package-private */
    public View buildView() {
        if (this.mInflater != null) {
            initConfig();
            View inflate = this.mInflater.inflate(R.layout.introduction, this.mRootView, false);
            this.mIntroductionView = inflate;
            inflate.findViewById(R.id.workspace).setVisibility(8);
            this.mViewPager = (ViewPager) this.mIntroductionView.findViewById(R.id.viewpager);
            ViewGroup viewGroup = (ViewGroup) this.mIntroductionView.findViewById(R.id.dots_layout);
            this.mDotsLayout = viewGroup;
            if (!this.mNeedDotsLayout) {
                viewGroup.setVisibility(8);
            }
        }
        buildIntroContent();
        return this.mIntroductionView;
    }

    private void preCheck() {
        if ((this.mDotsLayout == null || this.mViewPager == null || this.mInflater == null || this.mContext == null) && DEBUG) {
            Log.e(TAG, "preCheck failed please check param is null or not");
        }
    }

    private void buildIntroContent() {
        final Bundle state;
        preCheck();
        this.mViewPager.setAdapter(new IntroductionPagerAdapter(this.mInflater, this.mListener));
        if (4 > 1) {
            this.mDotsLayout.setVisibility(0);
            state = new Bundle();
            state.putInt(Workspace.KEY_POINT_MARGIN, this.mContext.getResources().getDimensionPixelSize(R.dimen.user_guider_dot_margin));
            state.putInt(Workspace.KEY_DOT_RES, R.drawable.dot);
            state.putInt(Workspace.KEY_DOT_CURRENT_RES, R.drawable.dot_current);
            Workspace.updateDots(this.mDotsLayout, 4, 0, state);
        } else {
            state = null;
        }
        this.mViewPager.setPageTransformer(false, this);
        this.mViewPager.setCurrentItem(0);
        this.mViewPager.setOffscreenPageLimit(3);
        this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int currentIndex) {
                if (!(currentIndex == 0 || currentIndex == 1 || currentIndex == 2 || currentIndex != 3)) {
                    IntroductionViewPagerDynamicBuilder.this.mViewPager.setBackgroundResource(17170445);
                }
                IntroductionViewPagerDynamicBuilder.this.invokeOnSwitchListener(currentIndex);
                IntroductionViewPagerDynamicBuilder.this.invokeOnSwitchIdleExitListener(currentIndex);
                Workspace.updateDots(IntroductionViewPagerDynamicBuilder.this.mDotsLayout, IntroductionViewPagerDynamicBuilder.this.mViewPager.getChildCount(), currentIndex, state);
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
                if (arg0 == 0) {
                    IntroductionViewPagerDynamicBuilder introductionViewPagerDynamicBuilder = IntroductionViewPagerDynamicBuilder.this;
                    introductionViewPagerDynamicBuilder.invokeOnSwitchIdleEnterListener(introductionViewPagerDynamicBuilder.mViewPager.getCurrentItem());
                }
            }
        });
    }

    public void transformPage(View view2, float position) {
        int pageWidth = view2.getWidth();
        if (position < -1.0f) {
            view2.setAlpha(0.0f);
        } else if (position <= 0.0f) {
            view2.setAlpha(1.0f);
            view2.setTranslationX(0.0f);
            view2.setScaleX(1.0f);
            view2.setScaleY(1.0f);
        } else if (position <= 1.0f) {
            view2.setAlpha(1.0f - position);
            view2.setTranslationX(((float) pageWidth) * (-position));
            float scaleFactor = ((1.0f - Math.abs(position)) * 0.39999998f) + 0.6f;
            view2.setScaleX(scaleFactor);
            view2.setScaleY(scaleFactor);
        } else {
            view2.setAlpha(0.0f);
        }
    }

    /* access modifiers changed from: private */
    public void invokeOnSwitchListener(int index) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null && viewPager.getCurrentItem() == index) {
            View child = this.mViewPager.getChildAt(index);
            if (child instanceof IntroductionScrollInterface.OnSwitchListener) {
                ((IntroductionScrollInterface.OnSwitchListener) child).onEnter((IntroductionScrollInterface.Direction) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void invokeOnSwitchIdleEnterListener(int index) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null && viewPager.getCurrentItem() == index) {
            View child = this.mViewPager.getChildAt(index);
            if (child instanceof IntroductionScrollInterface.OnSwitchIdleListener) {
                ((IntroductionScrollInterface.OnSwitchIdleListener) child).onEnterIdle((IntroductionScrollInterface.Direction) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void invokeOnSwitchIdleExitListener(int index) {
        int lastIndex = index - 1;
        int nextIndex = index + 1;
        if (lastIndex >= 0) {
            View child = this.mViewPager.getChildAt(lastIndex);
            if (child instanceof IntroductionScrollInterface.OnSwitchIdleListener) {
                ((IntroductionScrollInterface.OnSwitchIdleListener) child).onExitIdle((IntroductionScrollInterface.Direction) null);
            }
        }
        if (nextIndex <= this.mViewPager.getChildCount()) {
            View child2 = this.mViewPager.getChildAt(nextIndex);
            if (child2 instanceof IntroductionScrollInterface.OnSwitchIdleListener) {
                ((IntroductionScrollInterface.OnSwitchIdleListener) child2).onExitIdle((IntroductionScrollInterface.Direction) null);
            }
        }
    }

    public void setDotsLayoutVisible(boolean visible) {
        this.mNeedDotsLayout = visible;
    }

    public void release() {
        if (this.mRootView != null) {
            this.mRootView.removeView(this.mIntroductionView);
        }
    }
}
