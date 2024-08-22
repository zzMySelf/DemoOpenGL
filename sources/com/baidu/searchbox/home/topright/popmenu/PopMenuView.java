package com.baidu.searchbox.home.topright.popmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.home.top.R;
import com.baidu.searchbox.home.topright.HomeTopRightUtils;
import com.baidu.searchbox.home.topright.popmenu.PopMenuAdapter;
import com.baidu.searchbox.home.util.HomeViewUtilsKt;
import java.util.List;

public class PopMenuView {
    private static final float ALPHA_DISMISS = 0.0f;
    private static final String ALPHA_PROPERTY = "alpha";
    private static final float ALPHA_SHOW = 1.0f;
    private static final int ENTER_DURATION = 80;
    private static final int EXIT_DURATION = 200;
    private static final float SCALE_END = 0.75f;
    private static final float SCALE_START = 1.0f;
    private static final String SCALE_X_PROPERTY = "scaleX";
    private static final String SCALE_Y_PROPERTY = "scaleY";
    /* access modifiers changed from: private */
    public boolean hasFixedThePosition;
    /* access modifiers changed from: private */
    public View mAnchorView;
    private List<PopMenuItemModel> mData;
    private ObjectAnimator mEnterAnimator;
    private ObjectAnimator mExitAnimator;
    /* access modifiers changed from: private */
    public boolean mIsShowing = false;
    /* access modifiers changed from: private */
    public OnPopMenuEventListener mOnPopMenuEventListener;
    /* access modifiers changed from: private */
    public int mPivotXOffset;
    private PopMenuAdapter mPopMenuAdapter;
    private RecyclerView mPopMenuRecyclerView;
    /* access modifiers changed from: private */
    public View mPopMenuView;
    /* access modifiers changed from: private */
    public HomeHeaderPopupWindow mPopupWindow;
    /* access modifiers changed from: private */
    public ViewGroup mRootView;
    /* access modifiers changed from: private */
    public int[] menuOffset;

    public interface OnAboutDismissListener {
        void onAboutDismiss();
    }

    public interface OnPopMenuEventListener {
        void onMenuClick(int i2);

        void onMenuDismiss();

        void onMenuShow();
    }

    public void setData(List<PopMenuItemModel> data) {
        if (data != null) {
            this.mData = data;
        }
    }

    public void setAnchor(View anchor) {
        this.mAnchorView = anchor;
        this.mRootView = (ViewGroup) anchor.getRootView().findViewById(16908290);
    }

    public void setOnPopMenuEventListener(OnPopMenuEventListener listener) {
        this.mOnPopMenuEventListener = listener;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void show() {
        List<PopMenuItemModel> list;
        View view2;
        if (this.mRootView != null && this.mAnchorView != null && (list = this.mData) != null && list.size() != 0 && !this.mIsShowing) {
            if (this.mPopMenuView == null) {
                View inflate = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.home_header_pop_menu_view, this.mRootView, false);
                this.mPopMenuView = inflate;
                this.mPopMenuRecyclerView = (RecyclerView) inflate.findViewById(R.id.pop_menu_view);
                PopMenuAdapter popMenuAdapter = new PopMenuAdapter(AppRuntime.getAppContext());
                this.mPopMenuAdapter = popMenuAdapter;
                this.mPopMenuRecyclerView.setAdapter(popMenuAdapter);
                this.mPopMenuRecyclerView.setLayoutManager(new LinearLayoutManager(AppRuntime.getAppContext()));
                this.mPopMenuRecyclerView.setBackground(ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.home_header_pop_menu_background));
            }
            this.mPopMenuAdapter.setData(this.mData);
            this.mPopMenuAdapter.setOnItemClickListener(new PopMenuAdapter.OnItemClickListener() {
                public void onItemClick(int position) {
                    if (PopMenuView.this.mOnPopMenuEventListener != null) {
                        PopMenuView.this.mOnPopMenuEventListener.onMenuClick(position);
                    }
                    PopMenuView.this.dismiss();
                }
            });
            if (!this.hasFixedThePosition) {
                transformPosition();
                return;
            }
            this.mPopMenuView.setScaleX(1.0f);
            this.mPopMenuView.setScaleY(1.0f);
            HomeHeaderPopupWindow homeHeaderPopupWindow = this.mPopupWindow;
            if (homeHeaderPopupWindow != null && (view2 = this.mAnchorView) != null) {
                int[] iArr = this.menuOffset;
                homeHeaderPopupWindow.showAsDropDown(view2, iArr[0], iArr[1]);
                enterAnimation();
            }
        }
    }

    private void transformPosition() {
        this.mAnchorView.post(new Runnable() {
            public void run() {
                if (PopMenuView.this.mAnchorView != null) {
                    int menuBgTopEndDisPx = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.home_header_pop_menu_bg_top_end_dis);
                    int menuWidthPx = PopMenuView.getMenuItemWidth();
                    int[] unused = PopMenuView.this.menuOffset = new int[2];
                    PopMenuView.this.menuOffset[0] = -((menuWidthPx - menuBgTopEndDisPx) - (PopMenuView.this.mAnchorView.getMeasuredWidth() / 2));
                    if (HomeTopRightUtils.INSTANCE.isNewHome()) {
                        PopMenuView.this.menuOffset[1] = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.home_header_pop_menu_padding_top_new_home);
                    } else {
                        PopMenuView.this.menuOffset[1] = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.home_header_pop_menu_padding_top);
                    }
                    PopMenuView popMenuView = PopMenuView.this;
                    int unused2 = popMenuView.mPivotXOffset = (popMenuView.mAnchorView.getMeasuredWidth() / 2) - (PopMenuView.this.menuOffset[0] + (menuWidthPx / 2));
                    if (PopMenuView.this.mPopupWindow == null) {
                        PopMenuView popMenuView2 = PopMenuView.this;
                        PopMenuView popMenuView3 = PopMenuView.this;
                        HomeHeaderPopupWindow unused3 = popMenuView2.mPopupWindow = new HomeHeaderPopupWindow(popMenuView3.mPopMenuView, -2, -2);
                        PopMenuView.this.mPopupWindow.setOutsideTouchable(true);
                        PopMenuView.this.mPopupWindow.setFocusable(true);
                        PopMenuView.this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
                        PopMenuView.this.mPopupWindow.setAnimationStyle(0);
                        PopMenuView.this.mPopupWindow.setOnAboutDismissListener(new OnAboutDismissListener() {
                            public void onAboutDismiss() {
                                PopMenuView.this.dismiss();
                            }
                        });
                    }
                    try {
                        PopMenuView.this.mPopupWindow.showAsDropDown(PopMenuView.this.mAnchorView, PopMenuView.this.menuOffset[0], PopMenuView.this.menuOffset[1], GravityCompat.START);
                        boolean unused4 = PopMenuView.this.hasFixedThePosition = true;
                        PopMenuView.this.enterAnimation();
                    } catch (Exception e2) {
                        if (AppConfig.isDebug()) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void enterAnimation() {
        ObjectAnimator objectAnimator = this.mEnterAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mEnterAnimator.cancel();
        }
        if (this.mEnterAnimator == null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mPopMenuView, "alpha", new float[]{0.0f, 1.0f}).setDuration(80);
            this.mEnterAnimator = duration;
            duration.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animation) {
                    boolean unused = PopMenuView.this.mIsShowing = true;
                    if (PopMenuView.this.mOnPopMenuEventListener != null) {
                        PopMenuView.this.mOnPopMenuEventListener.onMenuShow();
                    }
                }
            });
        }
        this.mEnterAnimator.start();
    }

    private void exitAnimation() {
        ObjectAnimator objectAnimator = this.mExitAnimator;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            if (this.mExitAnimator == null) {
                PropertyValuesHolder pvhAlpha = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
                PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.75f});
                PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.75f});
                this.mExitAnimator = ObjectAnimator.ofPropertyValuesHolder(this.mPopMenuView, new PropertyValuesHolder[]{pvhAlpha, pvhScaleX, pvhScaleY}).setDuration(200);
                this.mPopMenuView.setPivotX((float) (this.mPivotXOffset + (getMenuItemWidth() / 2)));
                this.mPopMenuView.setPivotY(0.0f);
                this.mExitAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animation) {
                        if (PopMenuView.this.mRootView != null && PopMenuView.this.mPopMenuView != null && PopMenuView.this.mPopupWindow != null) {
                            if (PopMenuView.this.mOnPopMenuEventListener != null) {
                                PopMenuView.this.mOnPopMenuEventListener.onMenuDismiss();
                            }
                            PopMenuView.this.mPopupWindow.close();
                            boolean unused = PopMenuView.this.mIsShowing = false;
                        }
                    }
                });
            }
            this.mExitAnimator.start();
        }
    }

    private void exitNoAnimation() {
        if (this.mRootView != null && this.mPopMenuView != null && this.mPopupWindow != null) {
            OnPopMenuEventListener onPopMenuEventListener = this.mOnPopMenuEventListener;
            if (onPopMenuEventListener != null) {
                onPopMenuEventListener.onMenuDismiss();
            }
            this.mPopupWindow.close();
            this.mIsShowing = false;
        }
    }

    public void dismiss() {
        if (this.mIsShowing && this.mPopMenuView != null) {
            exitAnimation();
        }
    }

    public void dismissNoAnimation() {
        if (this.mIsShowing && this.mPopMenuView != null) {
            exitNoAnimation();
        }
    }

    public void onNightModeChanged() {
        PopMenuAdapter popMenuAdapter = this.mPopMenuAdapter;
        if (popMenuAdapter != null) {
            popMenuAdapter.notifyDataSetChanged();
        }
        RecyclerView recyclerView = this.mPopMenuRecyclerView;
        if (recyclerView != null) {
            recyclerView.setBackground(ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.home_header_pop_menu_background));
        }
    }

    public void onFontSizeChanged() {
        this.hasFixedThePosition = false;
        View view2 = this.mPopMenuView;
        if (view2 != null) {
            view2.setScaleX(1.0f);
            this.mPopMenuView.setScaleY(1.0f);
        }
        PopMenuAdapter popMenuAdapter = this.mPopMenuAdapter;
        if (popMenuAdapter != null) {
            popMenuAdapter.notifyDataSetChanged();
        }
    }

    public void release() {
        this.mPopMenuView = null;
        this.mRootView = null;
        this.mAnchorView = null;
        this.mPopMenuRecyclerView = null;
        this.mPopMenuAdapter = null;
        this.mData = null;
        this.mOnPopMenuEventListener = null;
        this.mEnterAnimator = null;
        this.mExitAnimator = null;
        this.mPopupWindow = null;
    }

    public static int getMenuItemWidth() {
        return AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_header_pop_menu_item_width_no_scaled) + HomeViewUtilsKt.scaleToInt(R.dimen.home_header_pop_menu_item_width_scaled);
    }

    public static int getMenuItemHeight() {
        return AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_header_pop_menu_item_height_no_scaled) + HomeViewUtilsKt.scaleToInt(R.dimen.home_header_pop_menu_item_height_scaled);
    }

    public class HomeHeaderPopupWindow extends PopupWindow {
        private OnAboutDismissListener onAboutDismissListener;

        public HomeHeaderPopupWindow(View contentView, int width, int height) {
            super(contentView, width, height);
        }

        public void setOnAboutDismissListener(OnAboutDismissListener listener) {
            this.onAboutDismissListener = listener;
        }

        public void dismiss() {
            OnAboutDismissListener onAboutDismissListener2 = this.onAboutDismissListener;
            if (onAboutDismissListener2 != null) {
                onAboutDismissListener2.onAboutDismiss();
            }
        }

        public void close() {
            super.dismiss();
        }
    }
}
