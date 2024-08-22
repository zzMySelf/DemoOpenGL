package com.baidu.searchbox.ui.indicatormenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.common.base.tab.R;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.bubble.ArrowView;
import com.baidu.searchbox.ui.indicatormenu.IndicatorMenuWindow;
import java.util.List;

public class BdIndicatorMenu implements OnIndicatorMenuItemClickListener {
    private static final float MENU_BETWEEN_PADDING = 2.0f;
    private static final float MENU_SCREEN_PADDING = 4.0f;
    private static final String TAG = "BdIndicatorMenu";
    private View mAnchorView;
    private View mArrow;
    private int mArrowColor;
    private ArrowView mArrowDown;
    private ArrowView mArrowUp;
    private float mBetweenPadding;
    private ObjectAnimator mBgAnimator;
    /* access modifiers changed from: private */
    public View mBgView;
    private int mBgViewColor;
    /* access modifiers changed from: private */
    public OnIndicatorMenuListener mIndicatorMenuListener;
    /* access modifiers changed from: private */
    public View mIndicatorMenuView;
    private boolean mIsShowing;
    /* access modifiers changed from: private */
    public ObjectAnimator mMenuAnimator;
    private List<IndicatorMenuItem> mMenuItems;
    /* access modifiers changed from: private */
    public IndicatorMenuPosition mMenuPosition;
    private IndicatorMenuView mMenuView;
    /* access modifiers changed from: private */
    public boolean mOutsideTouchDismiss;
    /* access modifiers changed from: private */
    public IndicatorMenuWindow mPopupWindow;
    /* access modifiers changed from: private */
    public ViewGroup mRootView;

    private BdIndicatorMenu() {
        this.mBetweenPadding = 2.0f;
        this.mMenuPosition = IndicatorMenuPosition.INVALID;
        this.mBgViewColor = 1275068416;
        this.mArrowColor = 16777215;
        this.mOutsideTouchDismiss = true;
    }

    public void showMenu() {
        if (isValidate() && !this.mIsShowing) {
            show();
            OnIndicatorMenuListener onIndicatorMenuListener = this.mIndicatorMenuListener;
            if (onIndicatorMenuListener != null) {
                onIndicatorMenuListener.onMenuShow();
            }
        }
    }

    public void dismissMenu() {
        if (this.mIsShowing && this.mRootView != null && this.mIndicatorMenuView != null) {
            ObjectAnimator objectAnimator = this.mMenuAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.mMenuAnimator.cancel();
            }
            this.mIsShowing = false;
            showAnimation(false);
            this.mMenuAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    if (BdIndicatorMenu.this.mPopupWindow != null && BdIndicatorMenu.this.mPopupWindow.isShowing()) {
                        BdIndicatorMenu.this.mPopupWindow.superDismiss();
                    }
                    if (BdIndicatorMenu.this.mBgView != null) {
                        BdIndicatorMenu.this.mRootView.removeView(BdIndicatorMenu.this.mBgView);
                    }
                    BdIndicatorMenu.this.mRootView.removeView(BdIndicatorMenu.this.mIndicatorMenuView);
                    if (BdIndicatorMenu.this.mIndicatorMenuListener != null) {
                        BdIndicatorMenu.this.mIndicatorMenuListener.onMenuDismiss();
                    }
                    BdIndicatorMenu.this.mMenuAnimator.removeListener(this);
                    BdIndicatorMenu.this.releaseAll();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void releaseAll() {
        this.mRootView = null;
        this.mIndicatorMenuView = null;
        this.mArrow = null;
        this.mArrowUp = null;
        this.mArrowDown = null;
        this.mAnchorView = null;
        this.mIndicatorMenuListener = null;
        this.mMenuItems = null;
        this.mMenuAnimator = null;
        this.mBgAnimator = null;
    }

    private boolean isValidate() {
        List<IndicatorMenuItem> list = this.mMenuItems;
        return (list == null || list.size() <= 0 || this.mAnchorView == null || this.mRootView == null) ? false : true;
    }

    private void show() {
        initViewIfNeed();
        View view2 = this.mBgView;
        if (view2 != null) {
            removeViewFromParent(view2);
            this.mRootView.addView(this.mBgView);
            this.mBgView.setVisibility(4);
        }
        removeViewFromParent(this.mIndicatorMenuView);
        this.mRootView.addView(this.mIndicatorMenuView);
        this.mIndicatorMenuView.setVisibility(4);
        this.mMenuView.setMenuData(this.mMenuItems);
        this.mAnchorView.post(new Runnable() {
            public void run() {
                BdIndicatorMenu bdIndicatorMenu = BdIndicatorMenu.this;
                IndicatorMenuPosition unused = bdIndicatorMenu.mMenuPosition = bdIndicatorMenu.detectShowPosition(bdIndicatorMenu.mMenuPosition);
                if (BdIndicatorMenu.this.mMenuPosition == IndicatorMenuPosition.INVALID) {
                    BdIndicatorMenu.this.demotionDisplay();
                    return;
                }
                BdIndicatorMenu bdIndicatorMenu2 = BdIndicatorMenu.this;
                bdIndicatorMenu2.showMenuView(bdIndicatorMenu2.mMenuPosition);
            }
        });
    }

    /* access modifiers changed from: private */
    public IndicatorMenuPosition detectShowPosition(IndicatorMenuPosition position) {
        if (isDisplayableAtPosition(position)) {
            return position;
        }
        return IndicatorMenuPosition.INVALID;
    }

    /* renamed from: com.baidu.searchbox.ui.indicatormenu.BdIndicatorMenu$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$indicatormenu$IndicatorMenuPosition;

        static {
            int[] iArr = new int[IndicatorMenuPosition.values().length];
            $SwitchMap$com$baidu$searchbox$ui$indicatormenu$IndicatorMenuPosition = iArr;
            try {
                iArr[IndicatorMenuPosition.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$indicatormenu$IndicatorMenuPosition[IndicatorMenuPosition.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private boolean isDisplayableAtPosition(IndicatorMenuPosition position) {
        switch (AnonymousClass5.$SwitchMap$com$baidu$searchbox$ui$indicatormenu$IndicatorMenuPosition[position.ordinal()]) {
            case 1:
                return isDisplayableAtUp();
            case 2:
                return isDisplayableAtDown();
            default:
                return false;
        }
    }

    private boolean isDisplayableAtUp() {
        if (this.mIndicatorMenuView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding) > getAnchorInRoot()[1] || !isVerticalArrowShowAbleThreshold()) {
            return false;
        }
        return true;
    }

    private boolean isDisplayableAtDown() {
        if (this.mIndicatorMenuView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding) > (this.mRootView.getMeasuredHeight() - this.mAnchorView.getMeasuredHeight()) - getAnchorInRoot()[1] || !isVerticalArrowShowAbleThreshold()) {
            return false;
        }
        return true;
    }

    private boolean isVerticalArrowShowAbleThreshold() {
        Context context = this.mAnchorView.getContext();
        int arrowShowAbleValue = DeviceUtil.ScreenInfo.dp2px(context, 4.0f) + (context.getResources().getDimensionPixelSize(R.dimen.indicator_menu_radius) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.indicator_menu_vertical_arrow_view_width) / 2);
        return arrowShowAbleValue <= getAnchorCenterLeftMargin() && arrowShowAbleValue <= getAnchorCenterRightMargin();
    }

    private int getAnchorCenterLeftMargin() {
        return getAnchorInRoot()[0] + (this.mAnchorView.getMeasuredWidth() / 2);
    }

    private int getAnchorCenterRightMargin() {
        return (this.mRootView.getMeasuredWidth() - getAnchorInRoot()[0]) - (this.mAnchorView.getMeasuredWidth() / 2);
    }

    private int[] getAnchorInRoot() {
        int[] anchorInScreen = new int[2];
        this.mAnchorView.getLocationOnScreen(anchorInScreen);
        int[] rootInScreen = new int[2];
        this.mRootView.getLocationOnScreen(rootInScreen);
        return new int[]{anchorInScreen[0] - rootInScreen[0], anchorInScreen[1] - rootInScreen[1]};
    }

    /* access modifiers changed from: private */
    public void demotionDisplay() {
        dismissAllArrowView();
        this.mIndicatorMenuView.setVisibility(0);
        this.mBgView.setVisibility(0);
        removeViewFromParent(this.mIndicatorMenuView);
        this.mPopupWindow.setContentView(this.mIndicatorMenuView);
        this.mPopupWindow.showAtLocation(this.mAnchorView, 17, 0, 0);
        showAnimation(true);
        this.mIsShowing = true;
    }

    /* access modifiers changed from: private */
    public void showMenuView(IndicatorMenuPosition menuPosition) {
        int yOffset;
        showArrowView(menuPosition);
        int[] menuPos = getShowPosition(menuPosition);
        this.mIndicatorMenuView.setVisibility(0);
        this.mBgView.setVisibility(0);
        removeViewFromParent(this.mIndicatorMenuView);
        this.mPopupWindow.setContentView(this.mIndicatorMenuView);
        int xOffset = menuPos[0] - getAnchorInRoot()[0];
        if (menuPosition == IndicatorMenuPosition.UP) {
            yOffset = (this.mAnchorView.getMeasuredHeight() + this.mIndicatorMenuView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding)) * -1;
        } else if (menuPosition == IndicatorMenuPosition.DOWN) {
            yOffset = DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding);
        } else {
            demotionDisplay();
            return;
        }
        this.mPopupWindow.showAsDropDown(this.mAnchorView, xOffset, yOffset, 3);
        showAnimation(true);
        this.mIsShowing = true;
    }

    private void showAnimation(boolean show) {
        long animTime;
        float scaleYEnd;
        float scaleYStart;
        float scaleXEnd;
        float scaleXStart;
        float alphaEnd;
        float alphaStart;
        float pivotY;
        float pivotX;
        ObjectAnimator objectAnimator = this.mMenuAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mMenuAnimator.cancel();
        }
        if (show) {
            alphaStart = 0.0f;
            alphaEnd = 1.0f;
            scaleXStart = 0.0f;
            scaleXEnd = 1.0f;
            scaleYStart = 0.0f;
            scaleYEnd = 1.0f;
            animTime = 200;
        } else {
            alphaStart = 1.0f;
            alphaEnd = 0.0f;
            scaleXStart = 1.0f;
            scaleXEnd = 0.0f;
            scaleYStart = 1.0f;
            scaleYEnd = 0.0f;
            animTime = 200;
        }
        if (this.mMenuPosition == IndicatorMenuPosition.UP) {
            pivotX = this.mArrow.getX() + (((float) this.mArrow.getMeasuredWidth()) / 2.0f);
            pivotY = (float) this.mIndicatorMenuView.getMeasuredHeight();
        } else if (this.mMenuPosition == IndicatorMenuPosition.DOWN) {
            pivotX = this.mArrow.getX() + (((float) this.mArrow.getMeasuredWidth()) / 2.0f);
            pivotY = 0.0f;
        } else {
            pivotX = ((float) this.mIndicatorMenuView.getMeasuredWidth()) / 2.0f;
            pivotY = ((float) this.mIndicatorMenuView.getMeasuredHeight()) / 2.0f;
        }
        PropertyValuesHolder pvhAlpha = PropertyValuesHolder.ofFloat("alpha", new float[]{alphaStart, alphaEnd});
        PropertyValuesHolder pvhTranX = PropertyValuesHolder.ofFloat("scaleX", new float[]{scaleXStart, scaleXEnd});
        PropertyValuesHolder pvhPivotX = PropertyValuesHolder.ofFloat("pivotX", new float[]{pivotX, pivotX});
        PropertyValuesHolder pvhTranY = PropertyValuesHolder.ofFloat("scaleY", new float[]{scaleYStart, scaleYEnd});
        float f2 = alphaStart;
        PropertyValuesHolder pvhPivotY = PropertyValuesHolder.ofFloat("pivotY", new float[]{pivotY, pivotY});
        float f3 = alphaEnd;
        float f4 = scaleXStart;
        this.mBgAnimator = ObjectAnimator.ofPropertyValuesHolder(this.mBgView, new PropertyValuesHolder[]{pvhAlpha}).setDuration(animTime);
        this.mMenuAnimator = ObjectAnimator.ofPropertyValuesHolder(this.mIndicatorMenuView, new PropertyValuesHolder[]{pvhAlpha, pvhTranX, pvhPivotX, pvhTranY, pvhPivotY}).setDuration(animTime);
        this.mBgAnimator.start();
        this.mMenuAnimator.start();
    }

    private void showArrowView(IndicatorMenuPosition position) {
        dismissAllArrowView();
        switch (AnonymousClass5.$SwitchMap$com$baidu$searchbox$ui$indicatormenu$IndicatorMenuPosition[position.ordinal()]) {
            case 1:
                this.mArrowDown.setVisibility(0);
                this.mArrowDown.setDirection(4);
                this.mArrow = this.mArrowDown;
                return;
            case 2:
                this.mArrowUp.setVisibility(0);
                this.mArrowUp.setDirection(2);
                this.mArrow = this.mArrowUp;
                return;
            default:
                return;
        }
    }

    private void dismissAllArrowView() {
        this.mArrowUp.setVisibility(8);
        this.mArrowDown.setVisibility(8);
    }

    private void initViewIfNeed() {
        if (this.mIndicatorMenuView == null) {
            View inflate = LayoutInflater.from(this.mAnchorView.getContext()).inflate(R.layout.indicator_menu_view, this.mRootView, false);
            this.mIndicatorMenuView = inflate;
            this.mMenuView = (IndicatorMenuView) inflate.findViewById(R.id.menu_view);
            this.mArrowUp = (ArrowView) this.mIndicatorMenuView.findViewById(R.id.menu_arrow_up);
            this.mArrowDown = (ArrowView) this.mIndicatorMenuView.findViewById(R.id.menu_arrow_down);
            int color = this.mAnchorView.getContext().getResources().getColor(R.color.indicator_menu_bg_color);
            this.mArrowColor = color;
            this.mArrowUp.setArrowViewColor(color);
            this.mArrowDown.setArrowViewColor(this.mArrowColor);
            this.mMenuView.setMenuItemClickListener(this);
            View view2 = new View(this.mAnchorView.getContext());
            this.mBgView = view2;
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mBgView.setBackgroundColor(this.mBgViewColor);
            this.mBgView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (BdIndicatorMenu.this.mOutsideTouchDismiss) {
                        BdIndicatorMenu.this.dismissMenu();
                    }
                }
            });
            IndicatorMenuWindow indicatorMenuWindow = new IndicatorMenuWindow(this.mAnchorView, -2, -2);
            this.mPopupWindow = indicatorMenuWindow;
            indicatorMenuWindow.setBackgroundDrawable(new BitmapDrawable());
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setOnPreDismissListener(new IndicatorMenuWindow.OnPreDismissListener() {
                public void onPreDismiss() {
                    BdIndicatorMenu.this.dismissMenu();
                }
            });
        }
    }

    private int[] getShowPosition(IndicatorMenuPosition position) {
        int[] anchorPos = new int[2];
        this.mAnchorView.getLocationOnScreen(anchorPos);
        int[] rootPos = new int[2];
        this.mRootView.getLocationOnScreen(rootPos);
        int[] arrowPos = new int[2];
        if (position == IndicatorMenuPosition.UP) {
            arrowPos[0] = (anchorPos[0] - rootPos[0]) + (this.mAnchorView.getMeasuredWidth() / 2);
            arrowPos[1] = (anchorPos[1] - rootPos[1]) - DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding);
        } else if (position == IndicatorMenuPosition.DOWN) {
            arrowPos[0] = (anchorPos[0] - rootPos[0]) + (this.mAnchorView.getMeasuredWidth() / 2);
            arrowPos[1] = (anchorPos[1] - rootPos[1]) + this.mAnchorView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding);
        }
        int[] menuPos = adjustPosition(arrowPos, position);
        this.mArrow.setX((float) (((arrowPos[0] - menuPos[0]) - Math.max(this.mArrowDown.getMeasuredWidth() / 2, this.mArrowUp.getMeasuredWidth() / 2)) + ((this.mAnchorView.getPaddingLeft() - this.mAnchorView.getPaddingRight()) / 2)));
        return menuPos;
    }

    private int[] adjustPosition(int[] arrowPos, IndicatorMenuPosition position) {
        if (position == IndicatorMenuPosition.INVALID) {
            return arrowPos;
        }
        int xPos = arrowPos[0];
        int[] ret = new int[2];
        int menuViewWidth = this.mIndicatorMenuView.getMeasuredWidth();
        int rootViewWidth = this.mRootView.getMeasuredWidth();
        if (menuViewWidth / 2 >= xPos) {
            ret[0] = DeviceUtil.ScreenInfo.dp2px(this.mRootView.getContext(), 4.0f);
        } else if (menuViewWidth / 2 >= rootViewWidth - xPos) {
            ret[0] = (rootViewWidth - menuViewWidth) - DeviceUtil.ScreenInfo.dp2px(this.mRootView.getContext(), 4.0f);
        } else {
            ret[0] = arrowPos[0] - (this.mIndicatorMenuView.getMeasuredWidth() / 2);
        }
        if (position == IndicatorMenuPosition.UP) {
            ret[1] = arrowPos[1] - this.mIndicatorMenuView.getMeasuredHeight();
        } else {
            ret[1] = arrowPos[1];
        }
        return ret;
    }

    private void removeViewFromParent(View view2) {
        if (view2 != null && view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    /* access modifiers changed from: private */
    public void setAnchor(View anchorView) {
        this.mAnchorView = anchorView;
        if (anchorView != null) {
            this.mRootView = (ViewGroup) anchorView.getRootView().findViewById(16908290);
        }
    }

    /* access modifiers changed from: private */
    public void setMenuItems(List<IndicatorMenuItem> menuItems) {
        this.mMenuItems = menuItems;
    }

    /* access modifiers changed from: private */
    public void setMenuPosition(IndicatorMenuPosition menuPosition) {
        this.mMenuPosition = menuPosition;
    }

    /* access modifiers changed from: private */
    public void setIndicatorMenuListener(OnIndicatorMenuListener indicatorMenuListener) {
        this.mIndicatorMenuListener = indicatorMenuListener;
    }

    /* access modifiers changed from: private */
    public void setBetweenPadding(float betweenPadding) {
        this.mBetweenPadding = betweenPadding;
    }

    public void onMenuItemClick(IndicatorMenuItem indicatorMenuItem, View view2) {
        OnIndicatorMenuListener onIndicatorMenuListener = this.mIndicatorMenuListener;
        if (onIndicatorMenuListener != null) {
            onIndicatorMenuListener.onMenuItemClick(indicatorMenuItem, view2);
        }
        dismissMenu();
    }

    public static class Builder {
        private BdIndicatorMenu mIndicatorMenu = new BdIndicatorMenu();

        public BdIndicatorMenu build() {
            return this.mIndicatorMenu;
        }

        public Builder setAnchorView(View anchorView) {
            this.mIndicatorMenu.setAnchor(anchorView);
            return this;
        }

        public Builder setMenuItems(List<IndicatorMenuItem> menuItems) {
            this.mIndicatorMenu.setMenuItems(menuItems);
            return this;
        }

        public Builder setMenuPosition(IndicatorMenuPosition menuPosition) {
            this.mIndicatorMenu.setMenuPosition(menuPosition);
            return this;
        }

        public Builder setIndicatorMenuListener(OnIndicatorMenuListener indicatorMenuListener) {
            this.mIndicatorMenu.setIndicatorMenuListener(indicatorMenuListener);
            return this;
        }

        public Builder setBetweenPadding(float betweenPadding) {
            this.mIndicatorMenu.setBetweenPadding(betweenPadding);
            return this;
        }
    }
}
