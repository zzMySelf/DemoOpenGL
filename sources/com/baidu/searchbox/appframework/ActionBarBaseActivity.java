package com.baidu.searchbox.appframework;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.android.ext.widget.LoadingView;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.appframework.actionbar.R;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.ui.BdActionBar;
import java.util.List;

@Deprecated
public abstract class ActionBarBaseActivity extends BaseActivity {
    public static final String ACTION_BAR_STYLE_DARK = "dark";
    public static final String ACTION_BAR_STYLE_LIGHT = "light";
    private static final int BDACTION_BAR_BABKGROUND_TYPE_COLOR = 1;
    private static final int BDACTION_BAR_BACKGROUND_TYPE_DRAWABLE = 0;
    public static final String EXTRA_ACTIONBAR_BACKGROUND_COLOR = "extra_actionbar_color_id";
    public static final String EXTRA_ACTIONBAR_BACKGROUND_COLOR_STRING = "extra_actionbar_color_str";
    public static final String EXTRA_ACTIONBAR_BACK_BTN_STYLE = "extra_actionbar_back_btn_style";
    public static final String EXTRA_ACTIONBAR_LEFT_TITLE = "extra_actionbar_left_title";
    public static final String SCHEME_ACTIONBAR_COLOR_KEY = "barcolor";
    protected boolean isUseActionBar = true;
    private FrameLayout mActionBarContainer;
    private ActionBarMode mActionBarMode = ActionBarMode.TOP;
    private View mActionBarShadow;
    private BdActionBar.ActionbarTemplate mActionBarTemplate;
    private boolean mActionBarVisible = true;
    /* access modifiers changed from: private */
    public BdActionBar mBdActionBar;
    private int mBdActionBarType = 0;
    private int mBdActionBardDrawableId = -1;
    /* access modifiers changed from: private */
    public View mContextActionBar;
    /* access modifiers changed from: private */
    public int mCurWindowHeight = -1;
    /* access modifiers changed from: private */
    public Rect mLayoutRect = null;
    private LoadingView mLoadingView;
    private ProgressBar mProgressBar;
    private boolean mWatchKeyboardStatus = false;

    public enum ActionBarMode {
        TOP,
        HOVER
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        SecurityUtils.checkActivityRefuseServiceAndFinish(this);
    }

    public void setContentView(int layoutResID) {
        setContentView(getLayoutInflater().inflate(layoutResID, (ViewGroup) null));
        CharSequence title = getTitle();
        if (title != null) {
            setActionBarTitle(title.toString());
        }
    }

    public void showProgressBar(boolean show) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar == null) {
            return;
        }
        if (show) {
            progressBar.setVisibility(0);
        } else {
            progressBar.setVisibility(8);
        }
    }

    public void setContentView(View view2) {
        FrameLayout viewRoot;
        LayoutInflater inflater = getLayoutInflater();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        if (this.isUseActionBar) {
            viewRoot = (FrameLayout) inflater.inflate(R.layout.actionbar_activity_layout, (ViewGroup) null);
            RelativeLayout container = (RelativeLayout) viewRoot.findViewById(R.id.root_container);
            container.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
            this.mProgressBar = (ProgressBar) viewRoot.findViewById(R.id.root_progress_bar);
            if (this.mActionBarMode == ActionBarMode.TOP) {
                params.addRule(3, R.id.title_bar_container);
                container.addView(view2, 1, params);
            } else if (this.mActionBarMode == ActionBarMode.HOVER) {
                container.addView(view2, 0, params);
            }
            initActionBar(container);
            initContextActionBar();
            initActionBarData();
        } else {
            viewRoot = (FrameLayout) inflater.inflate(R.layout.no_actionbar_activity_layout, (ViewGroup) null);
            RelativeLayout container2 = (RelativeLayout) viewRoot.findViewById(R.id.root_container);
            container2.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
            container2.addView(view2, params);
        }
        super.setContentView(viewRoot);
        addOnGlobalLayoutListener();
    }

    public void setActionBarMode(ActionBarMode mode) {
        this.mActionBarMode = mode;
    }

    private void addOnGlobalLayoutListener() {
        if (this.mWatchKeyboardStatus) {
            final View rootView = getWindow().getDecorView();
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (ActionBarBaseActivity.this.mLayoutRect == null) {
                        Rect unused = ActionBarBaseActivity.this.mLayoutRect = new Rect();
                    }
                    rootView.getWindowVisibleDisplayFrame(ActionBarBaseActivity.this.mLayoutRect);
                    int height = ActionBarBaseActivity.this.mLayoutRect.height();
                    if (ActionBarBaseActivity.this.mCurWindowHeight > 0 && height != ActionBarBaseActivity.this.mCurWindowHeight) {
                        if (height > ActionBarBaseActivity.this.mCurWindowHeight && height - ActionBarBaseActivity.this.mCurWindowHeight > DeviceUtil.ScreenInfo.getStatusBarHeight()) {
                            ActionBarBaseActivity.this.onKeyboardPopup(false);
                        } else if (height < ActionBarBaseActivity.this.mCurWindowHeight && ActionBarBaseActivity.this.mCurWindowHeight - height > DeviceUtil.ScreenInfo.getStatusBarHeight()) {
                            ActionBarBaseActivity.this.onKeyboardPopup(true);
                        }
                    }
                    int unused2 = ActionBarBaseActivity.this.mCurWindowHeight = height;
                }
            });
        }
    }

    private void initActionBarData() {
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            if (getIntent().hasExtra("barcolor")) {
                String colorStr = getIntent().getStringExtra("barcolor");
                int color = 0;
                if (!TextUtils.isEmpty(colorStr)) {
                    try {
                        color = Integer.parseInt(colorStr);
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                setActionBarBackgroundColor(color);
            } else if (getIntent().hasExtra("extra_actionbar_color_id")) {
                setActionBarBackgroundColor(getIntent().getIntExtra("extra_actionbar_color_id", 0));
            } else if (getIntent().hasExtra("extra_actionbar_color_str")) {
                String colorStr2 = getIntent().getStringExtra("extra_actionbar_color_str");
                if (!TextUtils.isEmpty(colorStr2)) {
                    try {
                        setActionBarBackgroundColor(Color.parseColor(colorStr2));
                    } catch (IllegalArgumentException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            if (getIntent().hasExtra("extra_actionbar_left_title")) {
                String title = getIntent().getStringExtra("extra_actionbar_left_title");
                if (!TextUtils.isEmpty(title)) {
                    this.mBdActionBar.setLeftTitle(title);
                }
            }
            if (getIntent().hasExtra("extra_actionbar_back_btn_style")) {
                String backBtnStyle = getIntent().getStringExtra("extra_actionbar_back_btn_style");
                if (TextUtils.equals(backBtnStyle, "light")) {
                    this.mBdActionBar.setLeftZoneImageSrc(R.drawable.action_bar_menu_light_selector);
                } else if (TextUtils.equals(backBtnStyle, "dark")) {
                    this.mBdActionBar.setLeftZoneImageSrc(com.baidu.android.common.ui.style.R.drawable.action_bar_back_normal);
                }
            }
        }
    }

    public void setWatchKeyboardStatusFlag(boolean flag) {
        this.mWatchKeyboardStatus = flag;
    }

    public void setActionBarBackgroundColor(int color, BdActionBar.ActionbarTemplate template) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            this.mActionBarTemplate = template;
            this.mBdActionBarType = 1;
            bdActionBar.setBackgroundColor(color);
            FrameLayout frameLayout = this.mActionBarContainer;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(color);
            }
            this.mBdActionBar.setTemplate(template);
        }
    }

    public void setActionBarBackgroundColor(int color) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setBackgroundColor(color);
            FrameLayout frameLayout = this.mActionBarContainer;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(color);
            }
            this.mBdActionBarType = 1;
            setShadowBackgroundColor(R.color.setting_item_divider_color);
            if (color != 0 && color != -1) {
                this.mBdActionBar.setTitleColor(com.baidu.android.common.ui.style.R.color.white_text);
                this.mBdActionBar.setRightMenuImageSrc(com.baidu.android.common.ui.style.R.drawable.action_bar_menu_normal_selector);
            }
        }
    }

    public BdActionBar getBdActionBar() {
        return this.mBdActionBar;
    }

    public void showActionBar(boolean show) {
        this.mActionBarVisible = show;
        FrameLayout frameLayout = this.mActionBarContainer;
        int i2 = 0;
        if (frameLayout != null) {
            frameLayout.setVisibility(show ? 0 : 8);
        }
        View view2 = this.mActionBarShadow;
        if (view2 != null) {
            if (!show) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public void showActionBarShadow(boolean show) {
        View view2 = this.mActionBarShadow;
        if (view2 != null) {
            view2.setVisibility(show ? 0 : 8);
        }
    }

    public void setShadowBackgroundColor(int color) {
        View view2 = this.mActionBarShadow;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(color));
        }
    }

    public void openContextActionBar() {
        openContextActionBar(true);
    }

    public void openContextActionBar(boolean doAnim) {
        if (this.mContextActionBar != null) {
            if (!doAnim) {
                this.mBdActionBar.setVisibility(8);
                this.mContextActionBar.setVisibility(0);
                onContextActionBarVisibleChanged(true);
                return;
            }
            int duration = getResources().getInteger(17694720);
            Animation animActionBar = AnimationUtils.loadAnimation(this, 17432577);
            animActionBar.setInterpolator(new AccelerateInterpolator());
            animActionBar.setDuration((long) duration);
            animActionBar.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    ActionBarBaseActivity.this.mBdActionBar.setVisibility(8);
                }
            });
            this.mBdActionBar.startAnimation(animActionBar);
            Animation animContextActionBar = AnimationUtils.loadAnimation(this, R.anim.video_top_appear);
            animContextActionBar.setDuration((long) duration);
            this.mContextActionBar.setVisibility(0);
            this.mContextActionBar.startAnimation(animContextActionBar);
            onContextActionBarVisibleChanged(true);
        }
    }

    public void closeContextActionBar() {
        closeContextActionBar(true);
    }

    public void closeContextActionBar(boolean doAnim) {
        if (this.mContextActionBar != null) {
            if (!doAnim) {
                this.mBdActionBar.setVisibility(0);
                this.mContextActionBar.setVisibility(8);
                onContextActionBarVisibleChanged(false);
                return;
            }
            int duration = getResources().getInteger(17694720);
            Animation animActionBar = AnimationUtils.loadAnimation(this, 17432576);
            animActionBar.setInterpolator(new AccelerateInterpolator());
            animActionBar.setDuration((long) duration);
            this.mBdActionBar.setVisibility(0);
            this.mBdActionBar.startAnimation(animActionBar);
            Animation animContextActionBar = AnimationUtils.loadAnimation(this, R.anim.video_top_disappear);
            animContextActionBar.setDuration((long) duration);
            animContextActionBar.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    ActionBarBaseActivity.this.mContextActionBar.setVisibility(8);
                }
            });
            this.mContextActionBar.startAnimation(animContextActionBar);
            onContextActionBarVisibleChanged(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onContextActionBarVisibleChanged(boolean visible) {
    }

    /* access modifiers changed from: protected */
    public void setActionBarTitle(String title) {
        this.mBdActionBar.setTitle(title);
    }

    /* access modifiers changed from: protected */
    public void setActionBarTitle(int resid) {
        this.mBdActionBar.setTitle(resid);
    }

    /* access modifiers changed from: protected */
    public void setActionBarSubTitle(String subtitle) {
        this.mBdActionBar.setSubTitle(subtitle);
    }

    /* access modifiers changed from: protected */
    public void setActionBarSubTitle(int resid) {
        this.mBdActionBar.setSubTitle(resid);
    }

    /* access modifiers changed from: protected */
    public void setActionBarBackground(int resid, BdActionBar.ActionbarTemplate template) {
        if (this.mBdActionBar != null) {
            setActionBarBackground(resid);
            this.mBdActionBar.setTemplate(template);
        }
    }

    private void setActionBarBackground(int resid) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            this.mBdActionBardDrawableId = resid;
            bdActionBar.setBackground(getResources().getDrawable(resid));
            FrameLayout frameLayout = this.mActionBarContainer;
            if (frameLayout != null) {
                frameLayout.setBackground(getResources().getDrawable(resid));
            }
            this.mBdActionBarType = 0;
            setShadowBackgroundColor(R.color.setting_item_divider_color);
        }
    }

    /* access modifiers changed from: protected */
    public void onActionBarBackPressed() {
        finish();
    }

    /* access modifiers changed from: protected */
    public View onCreateContextActionBar() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreateOptionsMenuItems(BdActionBar actionBar) {
    }

    /* access modifiers changed from: protected */
    public void onUpdateOptionsMenuItems(List<BdMenuItem> list) {
    }

    /* access modifiers changed from: protected */
    public void onOptionsMenuItemSelected(BdMenuItem item) {
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 82) {
            BdActionBar bdActionBar = this.mBdActionBar;
            if (bdActionBar != null ? bdActionBar.toggleMenu() : false) {
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    private void initActionBar(View parent) {
        this.mActionBarShadow = parent.findViewById(R.id.title_shadow);
        this.mActionBarContainer = (FrameLayout) parent.findViewById(R.id.title_bar_container);
        BdActionBar bdActionBar = (BdActionBar) parent.findViewById(R.id.common_title_bar);
        this.mBdActionBar = bdActionBar;
        bdActionBar.setLeftTitleInvalidate(true);
        this.mBdActionBar.setRightTxtZone1Visibility(8);
        this.mBdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ActionBarBaseActivity.this.onActionBarBackPressed();
            }
        });
        this.mBdActionBar.setOnMenuItemClickListener(new BdMenuItem.OnItemClickListener() {
            public void onClick(BdMenuItem item) {
                ActionBarBaseActivity.this.onOptionsMenuItemSelected(item);
            }
        });
        this.mBdActionBar.setOnDoubleClickListener(new BdActionBar.OnDoubleClickListener() {
            public void onDoubleClick(View v) {
                ActionBarBaseActivity.this.onActionBarDoubleClick();
            }
        });
        this.mBdActionBar.setOnMenuItemsUpdateListener(new BdMenu.OnMenuItemsUpdateListener() {
            public void onMenuItemUpdated(List<BdMenuItem> inItems) {
                ActionBarBaseActivity.this.onUpdateOptionsMenuItems(inItems);
            }
        });
        setActionBarBackground(com.baidu.android.common.ui.style.R.drawable.action_bar_bg, BdActionBar.ActionbarTemplate.BALCK_TITLE_TEMPLATE);
        onCreateOptionsMenuItems(this.mBdActionBar);
        showActionBar(this.mActionBarVisible);
    }

    /* access modifiers changed from: protected */
    public void setActionBarParentHeight(int height) {
        ViewGroup.LayoutParams params;
        FrameLayout frameLayout = this.mActionBarContainer;
        if (frameLayout != null && (params = frameLayout.getLayoutParams()) != null) {
            params.height = height;
            this.mActionBarContainer.setLayoutParams(params);
        }
    }

    /* access modifiers changed from: protected */
    public void setActionBarGravity(int gravity) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bdActionBar.getLayoutParams();
            if (gravity != layoutParams.gravity) {
                layoutParams.gravity = gravity;
                this.mBdActionBar.setLayoutParams(layoutParams);
            }
        }
    }

    private void initContextActionBar() {
        View onCreateContextActionBar = onCreateContextActionBar();
        this.mContextActionBar = onCreateContextActionBar;
        if (onCreateContextActionBar != null) {
            this.mActionBarContainer.addView(onCreateContextActionBar, new FrameLayout.LayoutParams(-1, -1));
            this.mContextActionBar.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.dismissMenu();
        }
    }

    /* access modifiers changed from: protected */
    public void setBdActionBarImgZoneBackgroundResource(int resId) {
        this.mBdActionBar.setImgZoneBackgroundResource(resId);
    }

    public void setBdActionBarTitleColorResource(int resId) {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitleColor(resId);
        }
    }

    public void setBdActionBarLeftZoneImageSrc(int resId) {
        this.mBdActionBar.setLeftZoneImageSrc(resId);
    }

    public void setBdActionBarRightMenuImageSrc(int resId) {
        this.mBdActionBar.setRightMenuImageSrc(resId);
    }

    /* access modifiers changed from: protected */
    public void onKeyboardPopup(boolean shown) {
    }

    /* access modifiers changed from: protected */
    public void onActionBarDoubleClick() {
    }

    public void showLoadingTextView(int msgRes) {
        if (!isFinishing()) {
            if (this.mLoadingView == null) {
                if (getBaseRootView() != null) {
                    this.mLoadingView = new LoadingView(this);
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
                    params.gravity = 17;
                    ViewGroup parent = (ViewGroup) this.mLoadingView.getParent();
                    if (parent != null) {
                        parent.removeView(this.mLoadingView);
                    }
                    getBaseRootView().addView(this.mLoadingView, params);
                } else {
                    return;
                }
            }
            this.mLoadingView.setMsg(msgRes);
            this.mLoadingView.show();
        }
    }

    public void hideLoadingTextView() {
        LoadingView loadingView;
        if (!isFinishing() && (loadingView = this.mLoadingView) != null) {
            loadingView.dismiss();
        }
    }

    public ViewGroup getBaseRootView() {
        return (ViewGroup) findViewById(16908290);
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        updateActionBarUI();
    }

    private void updateActionBarUI() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null && this.mBdActionBarType == 0) {
            bdActionBar.setBackground(getResources().getDrawable(this.mBdActionBardDrawableId));
            setShadowBackgroundColor(R.color.setting_item_divider_color);
            if (this.mBdActionBar.isRightMeuVisible()) {
                BdActionBar bdActionBar2 = this.mBdActionBar;
                bdActionBar2.setRightMenuImageSrc(bdActionBar2.getRightMenuImageViewSrcId());
            }
            if (this.mBdActionBar.isRightZone2Visible()) {
                BdActionBar bdActionBar3 = this.mBdActionBar;
                bdActionBar3.setRightImgZone2Src(bdActionBar3.getRightImgZone2ImageSrcId());
            }
            if (this.mBdActionBar.isRightImgZone1Visible()) {
                BdActionBar bdActionBar4 = this.mBdActionBar;
                bdActionBar4.setRightImgZone1ImageSrc(bdActionBar4.getRightImgZone1ImageSrcId());
            }
            BdActionBar.ActionbarTemplate actionbarTemplate = this.mActionBarTemplate;
            if (actionbarTemplate == null) {
                BdActionBar bdActionBar5 = this.mBdActionBar;
                bdActionBar5.setTitleColor(bdActionBar5.getTitleColorId());
                return;
            }
            this.mBdActionBar.setTemplate(actionbarTemplate);
        }
    }
}
