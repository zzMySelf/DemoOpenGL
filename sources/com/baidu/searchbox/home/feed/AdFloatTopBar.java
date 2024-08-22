package com.baidu.searchbox.home.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ad.feed.R;
import com.baidu.searchbox.ad.lightbrowser.AdLightBrowserWidgets;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.lightbrowser.LightBrowserActivity;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.ui.BdBaseImageView;
import java.util.concurrent.TimeUnit;

public class AdFloatTopBar implements AdLightBrowserWidgets.IAdFloatTopBar {
    private static final String CLOSE_BTN_LAYOUT_NAME = "left_second_view";
    private static final String TOP_BAR_TITLE_LAYOUT_NAME = "center_zones";
    private BdBaseImageView mBackIcon;
    private TextView mCloseBtn;
    private final Context mContext;
    private BdBaseImageView mGradientLayer;
    private boolean mIsHitBottomBack = false;
    private boolean mIsHitTopBack = false;
    private BdBaseImageView mMoreIcon;

    public AdFloatTopBar(Context context) {
        this.mContext = context;
    }

    public void initFloatActionBar(ViewGroup rootView, Intent intent, String nid, Object toBdActionBar, Object toWebViewContainer, Object toLightBrowserView) {
        if (rootView != null) {
            this.mIsHitBottomBack = AdUtil.needShowToolBarAndFloatMoreIcon(intent);
            boolean needShowTopBack = AdUtil.needShowTopBack(intent, nid);
            this.mIsHitTopBack = needShowTopBack;
            if (needShowTopBack && (this.mContext instanceof AdVideoDetailScrollActivity)) {
                initFloatActionBarForTopBack(rootView, toBdActionBar, toWebViewContainer, toLightBrowserView);
            } else if (this.mIsHitBottomBack) {
                initFloatActionBarMoreIcon(rootView);
            } else if ((this.mContext instanceof AdVideoDetailScrollActivity) && AdUtil.getLpBackStyleFromIntent(intent) != 4) {
                initFloatActionBarMoreIcon(rootView);
            }
            bringIconsToFront();
        }
    }

    private void initFloatActionBarForTopBack(ViewGroup rootView, Object toBdActionBar, Object toWebViewContainer, Object toLightBrowserView) {
        if ((toBdActionBar instanceof BdActionBar) && (toWebViewContainer instanceof WebViewContainer) && (toLightBrowserView instanceof LightBrowserView)) {
            BdActionBar actionBar = (BdActionBar) toBdActionBar;
            WebViewContainer container = (WebViewContainer) toWebViewContainer;
            LightBrowserView browserView = (LightBrowserView) toLightBrowserView;
            if (this.mMoreIcon == null) {
                initMoreIcon(rootView);
            }
            if (this.mBackIcon == null) {
                initBackIcon(rootView);
            }
            if (this.mGradientLayer == null) {
                initGradientLayer(rootView);
            }
            initActionBarToTop(actionBar, rootView, container, browserView);
        }
    }

    private void initFloatActionBarMoreIcon(ViewGroup rootView) {
        if (this.mMoreIcon == null) {
            initMoreIcon(rootView);
        }
    }

    private void initActionBarToTop(BdActionBar actionBar, ViewGroup rootView, WebViewContainer container, LightBrowserView browserView) {
        ViewParent barParent = actionBar.getParent();
        if (!(barParent instanceof ViewGroup)) {
            barParent = null;
        }
        ViewGroup parent = (ViewGroup) barParent;
        if (parent != null) {
            parent.removeView(actionBar);
        }
        rootView.addView(actionBar);
        actionBar.setVisibility(0);
        actionBar.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) actionBar.getLayoutParams();
        container.setMinTopMargin(layoutParams.height);
        browserView.setPadding(browserView.getPaddingLeft(), browserView.getPaddingTop(), browserView.getPaddingRight(), layoutParams.height);
        initCloseBtnTo(actionBar);
    }

    private void initCloseBtnTo(BdActionBar actionBar) {
        Context context = this.mContext;
        if (context instanceof AdVideoDetailScrollActivity) {
            final AdVideoDetailScrollActivity activity = (AdVideoDetailScrollActivity) context;
            int closeBtnId = context.getResources().getIdentifier(CLOSE_BTN_LAYOUT_NAME, "id", this.mContext.getPackageName());
            int titleId = this.mContext.getResources().getIdentifier(TOP_BAR_TITLE_LAYOUT_NAME, "id", this.mContext.getPackageName());
            View closeBtn = actionBar.findViewById(closeBtnId);
            View titleRl = actionBar.findViewById(titleId);
            if ((closeBtn instanceof TextView) && (titleRl instanceof RelativeLayout)) {
                ViewGroup.LayoutParams lp = titleRl.getLayoutParams();
                lp.width = 600;
                titleRl.setLayoutParams(lp);
                TextView textView = (TextView) closeBtn;
                this.mCloseBtn = textView;
                ViewGroup.LayoutParams btnLp = textView.getLayoutParams();
                btnLp.height = -2;
                this.mCloseBtn.setLayoutParams(btnLp);
                this.mCloseBtn.setVisibility(4);
                this.mCloseBtn.setText("");
                this.mCloseBtn.setBackgroundResource(R.drawable.ad_top_bar_close_btn);
                this.mCloseBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        activity.finish();
                    }
                });
            }
        }
    }

    private void initMoreIcon(ViewGroup rootView) {
        Context context = this.mContext;
        if ((context instanceof LightBrowserActivity) && rootView != null) {
            final LightBrowserActivity activity = (LightBrowserActivity) context;
            this.mMoreIcon = new BdBaseImageView(this.mContext);
            FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(-2, -2);
            imageParams.gravity = 8388661;
            if (this.mIsHitTopBack) {
                imageParams.topMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 9.4f);
                imageParams.rightMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 15.0f);
                this.mMoreIcon.setImageResource(R.drawable.ad_top_bar_menu_btn);
            } else {
                imageParams.topMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 15.0f);
                imageParams.rightMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 15.0f);
                this.mMoreIcon.setImageResource(R.drawable.ad_video_detail_more_selector);
            }
            this.mMoreIcon.setScaleType(ImageView.ScaleType.CENTER);
            this.mMoreIcon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    activity.showMenu();
                }
            });
            rootView.addView(this.mMoreIcon, imageParams);
        }
    }

    private void initBackIcon(ViewGroup rootView) {
        Context context = this.mContext;
        if ((context instanceof LightBrowserActivity) && rootView != null) {
            final LightBrowserActivity activity = (LightBrowserActivity) context;
            this.mBackIcon = new BdBaseImageView(this.mContext);
            FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(-2, -2);
            imageParams.gravity = 8388659;
            imageParams.topMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 8.6f);
            imageParams.leftMargin = DeviceUtil.ScreenInfo.dp2px(this.mContext, 12.4f);
            this.mBackIcon.setImageResource(R.drawable.ad_top_bar_back_btn);
            this.mBackIcon.setScaleType(ImageView.ScaleType.CENTER);
            this.mBackIcon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    activity.finish();
                }
            });
            rootView.addView(this.mBackIcon, imageParams);
        }
    }

    private void initGradientLayer(ViewGroup rootView) {
        if (rootView != null) {
            this.mGradientLayer = new BdBaseImageView(this.mContext);
            FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(-1, 210);
            imageParams.gravity = 49;
            this.mGradientLayer.setImageResource(R.drawable.ad_video_landing_page_top_bar_gradient_bg);
            this.mGradientLayer.setScaleType(ImageView.ScaleType.FIT_XY);
            rootView.addView(this.mGradientLayer, imageParams);
        }
    }

    private void bringIconsToFront() {
        TextView textView = this.mCloseBtn;
        if (textView != null) {
            textView.bringToFront();
        }
        BdBaseImageView bdBaseImageView = this.mBackIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.bringToFront();
        }
        BdBaseImageView bdBaseImageView2 = this.mMoreIcon;
        if (bdBaseImageView2 != null) {
            bdBaseImageView2.bringToFront();
        }
    }

    public void updateCloseBtnVisibility(boolean needShow) {
        TextView textView = this.mCloseBtn;
        if (textView != null) {
            textView.setVisibility(needShow ? 0 : 4);
        }
    }

    public void onPause(Object toWebViewContainer) {
        if (toWebViewContainer instanceof WebViewContainer) {
            WebViewContainer webViewContainer = (WebViewContainer) toWebViewContainer;
            BdBaseImageView bdBaseImageView = this.mMoreIcon;
            int i2 = 0;
            if (bdBaseImageView != null) {
                bdBaseImageView.setVisibility(webViewContainer.getTopMargin() > 0 ? filterVisibilityForMoreIcon(0) : filterVisibilityForMoreIcon(4));
            }
            BdBaseImageView bdBaseImageView2 = this.mBackIcon;
            if (bdBaseImageView2 != null) {
                if (webViewContainer.getTopMargin() <= 0) {
                    i2 = 4;
                }
                bdBaseImageView2.setVisibility(i2);
            }
        }
    }

    public void onShowTailView(boolean isVideoVisible) {
        if (isVideoVisible) {
            BdBaseImageView bdBaseImageView = this.mMoreIcon;
            if (bdBaseImageView != null) {
                bdBaseImageView.bringToFront();
                this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(0));
            }
            BdBaseImageView bdBaseImageView2 = this.mBackIcon;
            if (bdBaseImageView2 != null) {
                bdBaseImageView2.bringToFront();
                this.mBackIcon.setVisibility(0);
            }
        }
    }

    public void onPanelVisibilityChanged(Object toWebViewContainer, boolean isVisible) {
        if (toWebViewContainer instanceof WebViewContainer) {
            WebViewContainer webViewContainer = (WebViewContainer) toWebViewContainer;
            BdBaseImageView bdBaseImageView = this.mBackIcon;
            if (bdBaseImageView != null) {
                if (!isVisible) {
                    bdBaseImageView.setVisibility(4);
                } else if (webViewContainer == null || webViewContainer.getTopMargin() <= 0) {
                    this.mBackIcon.setVisibility(4);
                } else {
                    this.mBackIcon.setVisibility(0);
                }
            }
            BdBaseImageView bdBaseImageView2 = this.mMoreIcon;
            if (bdBaseImageView2 == null) {
                return;
            }
            if (!isVisible) {
                bdBaseImageView2.setVisibility(filterVisibilityForMoreIcon(4));
            } else if (webViewContainer == null || webViewContainer.getTopMargin() <= 0) {
                this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(4));
            } else {
                this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(0));
            }
        }
    }

    public void onPanelVisibilityChangedForTB(Object toWebViewContainer, boolean isVisible) {
        if ((toWebViewContainer instanceof WebViewContainer) && ((WebViewContainer) toWebViewContainer).getTopMargin() > 0) {
            BdBaseImageView bdBaseImageView = this.mBackIcon;
            if (bdBaseImageView != null) {
                bdBaseImageView.setVisibility(0);
            }
            BdBaseImageView bdBaseImageView2 = this.mMoreIcon;
            if (bdBaseImageView2 != null) {
                bdBaseImageView2.setVisibility(filterVisibilityForMoreIcon(0));
            }
        }
    }

    public void handlePlayModeChange(boolean isShowTailView) {
        if (isShowTailView) {
            BdBaseImageView bdBaseImageView = this.mMoreIcon;
            if (!(bdBaseImageView == null || bdBaseImageView.getVisibility() == 0)) {
                this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(0));
                this.mMoreIcon.bringToFront();
            }
            BdBaseImageView bdBaseImageView2 = this.mBackIcon;
            if (bdBaseImageView2 != null && bdBaseImageView2.getVisibility() != 0) {
                this.mBackIcon.setVisibility(0);
                this.mBackIcon.bringToFront();
            }
        }
    }

    public void onHideStatusBar() {
        Context context = this.mContext;
        if (context instanceof AdVideoDetailScrollActivity) {
            final AdVideoDetailScrollActivity activity = (AdVideoDetailScrollActivity) context;
            BdBaseImageView bdBaseImageView = this.mMoreIcon;
            if (bdBaseImageView != null) {
                bdBaseImageView.postDelayed(new Runnable() {
                    public void run() {
                        activity.hideStatusBar();
                    }
                }, TimeUnit.MILLISECONDS.toMillis(300));
            }
        }
    }

    public void onDestroyShortVideo(ViewGroup rootView) {
        if (rootView != null) {
            BdBaseImageView bdBaseImageView = this.mMoreIcon;
            if (bdBaseImageView != null) {
                bdBaseImageView.setVisibility(filterVisibilityForMoreIcon(8));
                rootView.removeView(this.mMoreIcon);
                this.mMoreIcon = null;
            }
            BdBaseImageView bdBaseImageView2 = this.mBackIcon;
            if (bdBaseImageView2 != null) {
                bdBaseImageView2.setVisibility(8);
                rootView.removeView(this.mBackIcon);
                this.mBackIcon = null;
            }
        }
    }

    public void invalidate() {
        BdBaseImageView bdBaseImageView = this.mMoreIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.invalidate();
        }
        BdBaseImageView bdBaseImageView2 = this.mBackIcon;
        if (bdBaseImageView2 != null) {
            bdBaseImageView2.invalidate();
        }
    }

    public void setVisibility(int visibility) {
        BdBaseImageView bdBaseImageView = this.mMoreIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.setVisibility(filterVisibilityForMoreIcon(visibility));
        }
        BdBaseImageView bdBaseImageView2 = this.mBackIcon;
        if (bdBaseImageView2 != null) {
            bdBaseImageView2.setVisibility(visibility);
        }
        BdBaseImageView bdBaseImageView3 = this.mGradientLayer;
        if (bdBaseImageView3 != null) {
            bdBaseImageView3.setVisibility(visibility);
        }
    }

    public void setAlpha(float alpha) {
        BdBaseImageView bdBaseImageView = this.mMoreIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.setAlpha(alpha);
        }
        BdBaseImageView bdBaseImageView2 = this.mBackIcon;
        if (bdBaseImageView2 != null) {
            bdBaseImageView2.setAlpha(alpha);
        }
        BdBaseImageView bdBaseImageView3 = this.mGradientLayer;
        if (bdBaseImageView3 != null) {
            bdBaseImageView3.setAlpha(alpha);
        }
    }

    public void updateActionBarAlpha(float dy, float videoHolderHeight, Object toBdActionBar) {
        if (!this.mIsHitTopBack || !(toBdActionBar instanceof BdActionBar) || ((BdActionBar) toBdActionBar).getVisibility() != 0) {
            setVisibility(4);
            return;
        }
        BdActionBar actionBar = (BdActionBar) toBdActionBar;
        float alpha = Math.abs(dy) / (videoHolderHeight - ((float) actionBar.getMeasuredHeight()));
        actionBar.bringToFront();
        actionBar.setAlpha(alpha);
        setAlpha(1.0f - alpha);
    }

    public void onUp(Object toWebViewContainer, boolean scrollToTopWithAnim) {
        if (toWebViewContainer instanceof WebViewContainer) {
            WebViewContainer webViewContainer = (WebViewContainer) toWebViewContainer;
            if (this.mMoreIcon != null) {
                if (webViewContainer.getTopMargin() > 0) {
                    this.mMoreIcon.bringToFront();
                    if (scrollToTopWithAnim) {
                        this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(4));
                    } else {
                        this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(0));
                    }
                } else {
                    this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(4));
                }
            }
            if (this.mBackIcon == null) {
                return;
            }
            if (webViewContainer.getTopMargin() > 0) {
                this.mBackIcon.bringToFront();
                if (scrollToTopWithAnim) {
                    this.mBackIcon.setVisibility(4);
                } else {
                    this.mBackIcon.setVisibility(0);
                }
            } else {
                this.mBackIcon.setVisibility(4);
            }
        }
    }

    public void onHandleScrollAnimateEnd() {
        BdBaseImageView bdBaseImageView = this.mMoreIcon;
        if (bdBaseImageView != null) {
            bdBaseImageView.bringToFront();
            this.mMoreIcon.setVisibility(filterVisibilityForMoreIcon(0));
        }
        BdBaseImageView bdBaseImageView2 = this.mBackIcon;
        if (bdBaseImageView2 != null) {
            bdBaseImageView2.bringToFront();
            this.mBackIcon.setVisibility(0);
        }
    }

    private int filterVisibilityForMoreIcon(int visibility) {
        if (this.mIsHitBottomBack) {
            return 0;
        }
        return visibility;
    }
}
