package com.baidu.share.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.baidu.share.IScreenChangeListener;
import com.baidu.share.R;
import com.baidu.share.common.util.APIUtils;
import com.baidu.share.common.util.ShareCubicBezierInterpolator;
import com.baidu.share.core.bean.Theme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSocialMenu extends PopupWindow implements ISocialMenu, View.OnClickListener {
    public static final int SHARE_MENU_ANIM_DURATION = 240;
    public static final int SHARE_MENU_HIDE_DURATION = 160;
    public static final String TAG = BaseSocialMenu.class.getSimpleName();
    /* access modifiers changed from: private */
    public boolean isPopupDismissing;
    protected View mBackGroundView;
    protected View mBanner;
    private FrameLayout mBannerLayout;
    protected FrameLayout mContentLayout;
    private View mContentRoot;
    /* access modifiers changed from: protected */
    public Context mContext;
    public boolean mIsShareClicked;
    /* access modifiers changed from: protected */
    public List<MenuItemWrapper> mMenuItems;
    /* access modifiers changed from: private */
    public SharePanelRootView mMenuRoot;
    /* access modifiers changed from: protected */
    public OnChildItemClickListener mOnChildItemClickListener;
    /* access modifiers changed from: private */
    public OnLifeCycleListener mOnLifeCycleListener;
    protected Theme mTheme;

    public interface OnChildItemClickListener {
        boolean onClick(View view2, MenuActionMessage menuActionMessage);
    }

    public interface OnLifeCycleListener {
        void onDismiss();

        void onShow();
    }

    /* access modifiers changed from: protected */
    public abstract List<MenuItemWrapper> getMenuItems();

    public abstract View getSharePanel();

    /* access modifiers changed from: protected */
    public List<MenuItemWrapper> getMenuItems(String source) {
        return getMenuItems();
    }

    public BaseSocialMenu(Context context, Theme theme) {
        this(context, theme, (String) null);
    }

    public BaseSocialMenu(Context context, Theme theme, String source) {
        super(context);
        this.mIsShareClicked = false;
        this.isPopupDismissing = false;
        this.mTheme = theme;
        this.mContext = context;
        configPopup();
        List<MenuItemWrapper> menuItems = getMenuItems(source);
        this.mMenuItems = menuItems;
        if (menuItems == null) {
            this.mMenuItems = new ArrayList();
        }
        initBaseView();
    }

    /* access modifiers changed from: protected */
    public void updatePanelUI() {
    }

    private void initBaseView() {
        View inflate = View.inflate(this.mContext, R.layout.share_menu_base_layout, (ViewGroup) null);
        this.mContentRoot = inflate;
        this.mBackGroundView = inflate.findViewById(R.id.share_menu_bg_layout);
        this.mContentLayout = (FrameLayout) this.mContentRoot.findViewById(R.id.share_menu_content_layout);
        this.mBannerLayout = (FrameLayout) this.mContentRoot.findViewById(R.id.share_menu_banner_layout);
        SharePanelRootView sharePanelRootView = (SharePanelRootView) this.mContentRoot.findViewById(R.id.menu_root);
        this.mMenuRoot = sharePanelRootView;
        sharePanelRootView.setScreenChangeListener(new IScreenChangeListener() {
            public void screenChange() {
                if (BaseSocialMenu.this.isShowing()) {
                    BaseSocialMenu.this.updatePanelUI();
                }
            }
        });
        setUI();
        this.mBackGroundView.setOnClickListener(this);
        this.mBannerLayout.setOnClickListener(this);
    }

    private void setUI() {
        this.mBackGroundView.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC11));
    }

    public void dismiss() {
        dismissMenu(true);
    }

    private void configPopup() {
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setClippingEnabled(false);
        if (APIUtils.hasAndroid11()) {
            setLayoutInScreenEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public void popupEnterAnim() {
        this.mBackGroundView.setAlpha(0.0f);
        ObjectAnimator bgAnim = ObjectAnimator.ofFloat(this.mBackGroundView, "alpha", new float[]{1.0f});
        ObjectAnimator mainAnim = createMenuEnterAnim(this.mMenuRoot);
        List<Animator> animators = new ArrayList<>();
        animators.add(bgAnim);
        animators.add(mainAnim);
        final AnimatorSet showAnimator = new AnimatorSet();
        showAnimator.setDuration(240);
        showAnimator.setInterpolator(new ShareCubicBezierInterpolator(0.41f, 0.05f, 0.1f, 1.0f));
        showAnimator.playTogether(animators);
        this.mMenuRoot.post(new Runnable() {
            public void run() {
                AnimatorSet animatorSet = showAnimator;
                if (animatorSet != null) {
                    animatorSet.start();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public ObjectAnimator createMenuEnterAnim(View menuView) {
        SharePanelRootView sharePanelRootView = this.mMenuRoot;
        sharePanelRootView.setTranslationY((float) sharePanelRootView.getHeight());
        return ObjectAnimator.ofFloat(this.mMenuRoot, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{0.0f});
    }

    public void showMenu(View parent) {
        if (!isActivityDestroyed((Activity) this.mContext)) {
            this.mContentLayout.addView(getSharePanel());
            setBanner(this.mBanner);
            setContentView(this.mContentRoot);
            showAtLocation(parent, 81, 0, 0);
            if (this.mMenuRoot.getHeight() == 0) {
                this.mMenuRoot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        BaseSocialMenu.this.popupEnterAnim();
                        BaseSocialMenu.this.mMenuRoot.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                popupEnterAnim();
            }
            OnLifeCycleListener onLifeCycleListener = this.mOnLifeCycleListener;
            if (onLifeCycleListener != null) {
                onLifeCycleListener.onShow();
            }
        }
    }

    /* access modifiers changed from: private */
    public void dismissSuper() {
        this.mContext = null;
        super.dismiss();
    }

    public void dismissMenu(boolean animation) {
        if (!animation) {
            Context context = this.mContext;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && !ActivityUtils.isDestroyed((Activity) this.mContext)) {
                dismissSuper();
            }
            if (!this.mIsShareClicked && this.mOnChildItemClickListener != null) {
                MenuActionMessage message = new MenuActionMessage();
                message.actionId = MenuActionMessage.ACTION_CANCEL_CLICK;
                this.mOnChildItemClickListener.onClick((View) null, message);
            }
            OnLifeCycleListener onLifeCycleListener = this.mOnLifeCycleListener;
            if (onLifeCycleListener != null) {
                onLifeCycleListener.onDismiss();
            }
        } else if (!this.isPopupDismissing) {
            this.isPopupDismissing = true;
            ObjectAnimator bgAnim = ObjectAnimator.ofFloat(this.mBackGroundView, "alpha", new float[]{0.0f});
            bgAnim.setInterpolator(new LinearInterpolator());
            ObjectAnimator transAnim = createMenuExitAnim(this.mMenuRoot);
            AnimatorSet animSet = new AnimatorSet();
            animSet.playTogether(new Animator[]{bgAnim, transAnim});
            animSet.setDuration(160);
            animSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    if ((BaseSocialMenu.this.mContext instanceof Activity) && !((Activity) BaseSocialMenu.this.mContext).isFinishing() && !ActivityUtils.isDestroyed((Activity) BaseSocialMenu.this.mContext)) {
                        BaseSocialMenu.this.dismissSuper();
                    }
                    boolean unused = BaseSocialMenu.this.isPopupDismissing = false;
                    if (!BaseSocialMenu.this.mIsShareClicked && BaseSocialMenu.this.mOnChildItemClickListener != null) {
                        MenuActionMessage message = new MenuActionMessage();
                        message.actionId = MenuActionMessage.ACTION_CANCEL_CLICK;
                        BaseSocialMenu.this.mOnChildItemClickListener.onClick((View) null, message);
                    }
                    if (BaseSocialMenu.this.mOnLifeCycleListener != null) {
                        BaseSocialMenu.this.mOnLifeCycleListener.onDismiss();
                    }
                }
            });
            animSet.start();
        } else if (ShareRuntime.isDebug()) {
            Log.d(TAG, "pop up is dismissing, return");
        }
    }

    /* access modifiers changed from: protected */
    public ObjectAnimator createMenuExitAnim(View menuView) {
        SharePanelRootView sharePanelRootView = this.mMenuRoot;
        ObjectAnimator transAnim = ObjectAnimator.ofFloat(sharePanelRootView, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{(float) sharePanelRootView.getHeight()});
        transAnim.setInterpolator(new ShareCubicBezierInterpolator(0.41f, 0.05f, 0.1f, 1.0f));
        return transAnim;
    }

    public void setBanner(View banner) {
        if (banner != null) {
            this.mBannerLayout.removeAllViews();
            this.mBannerLayout.addView(banner);
            this.mBanner = banner;
            return;
        }
        this.mBannerLayout.removeAllViews();
        this.mBanner = null;
    }

    public View getBanner() {
        return this.mBanner;
    }

    public boolean canShowBanner() {
        return DeviceUtils.ScreenInfo.isScreenPortrait() || DeviceUtils.isTabletDevice();
    }

    public boolean isShowing() {
        return super.isShowing();
    }

    public void setOnLifeCycleListener(OnLifeCycleListener listener) {
        this.mOnLifeCycleListener = listener;
    }

    public void setOnChildItemClickListener(OnChildItemClickListener listener) {
        this.mOnChildItemClickListener = listener;
    }

    public List<MenuItemWrapper> getCurrentMenuItems() {
        return this.mMenuItems;
    }

    public void addMenuItem(int position, MenuItemWrapper item) {
        List<MenuItemWrapper> list = this.mMenuItems;
        if (list != null && position >= 0 && position <= list.size()) {
            this.mMenuItems.add(position, item);
        }
    }

    public void removeMenuItem(MenuItemWrapper menuItem) {
        if (this.mMenuItems != null && menuItem != null && menuItem.type != null) {
            MenuItemWrapper deleteItem = null;
            Iterator<MenuItemWrapper> it = this.mMenuItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MenuItemWrapper item = it.next();
                if (menuItem.type == MenuItem.CUSTOM) {
                    if (item.type == menuItem.type && TextUtils.equals(item.text, menuItem.text)) {
                        deleteItem = item;
                        break;
                    }
                } else if (item.type == menuItem.type) {
                    deleteItem = item;
                    break;
                }
            }
            if (deleteItem != null) {
                this.mMenuItems.remove(deleteItem);
            }
        }
    }

    public void updateAllMenuItems(List<MenuItemWrapper> menuItems) {
        if (menuItems != null && menuItems.size() > 0) {
            this.mMenuItems = menuItems;
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.share_menu_bg_layout) {
            dismissMenu(true);
        } else if (v.getId() == R.id.share_menu_banner_layout && this.mOnChildItemClickListener != null) {
            MenuActionMessage actionMessage = new MenuActionMessage();
            actionMessage.actionId = MenuActionMessage.ACTION_BANNER_CLICK;
            if (!this.mOnChildItemClickListener.onClick(v, actionMessage)) {
                dismissMenu(false);
            }
        }
    }

    private boolean isActivityDestroyed(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return false;
        }
        return true;
    }
}
