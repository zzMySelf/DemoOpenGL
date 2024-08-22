package com.baidu.searchbox.userassetsaggr.container.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.ext.widget.BdListPopupWindow;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.bdprecyclebin.face.IRecycleBinFace;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.utils.ResUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.searchbox.ui.viewpager.BdPagerTab;
import com.baidu.searchbox.ui.viewpager.BdPagerTabBar;
import com.baidu.searchbox.ui.viewpager.DrawablePageIndicator;
import com.baidu.searchbox.ui.viewpager.NoScrollViewPager;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.userassetsaggr.container.R;
import com.baidu.searchbox.userassetsaggr.container.UserAssetsAggrUtils;
import com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsAggrUbc;
import com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsRecycleBinUbc;
import java.util.ArrayList;
import java.util.List;

public class ActionBarPagerTabHost extends FrameLayout {
    public static boolean DEBUG = AppConfig.isDebug();
    private static final int MESSAGE_WHAT = "ActionBarPagerTabHost".hashCode();
    public static String TAG = "ActionBarPagerTabHost";
    private static FrameLayout mBadgeFrameLayout = null;
    private static BadgeView mBadgeView = null;
    /* access modifiers changed from: private */
    public boolean isMoving;
    private BdActionBar mActionBar;
    private boolean mCanViewPagerScroll = true;
    private Context mContext;
    private View mDeleteLayout;
    private View mDivider;
    /* access modifiers changed from: private */
    public OnEditLayoutClickListener mEditLayoutClickListener;
    private boolean mEnableIndicator = true;
    private boolean mHasMoveView;
    private boolean mHasRenameView;
    private boolean mIsEditable = false;
    /* access modifiers changed from: private */
    public boolean mIsEditableMode = false;
    /* access modifiers changed from: private */
    public OnTabHostChangeListener mListener;
    private View mMoveDivider;
    private View mMoveLayout;
    /* access modifiers changed from: private */
    public DrawablePageIndicator mPageIndicator;
    private BdPagerTabBar mPagerTabBar;
    /* access modifiers changed from: private */
    public BubbleBaseManager mRecycleBinBubble = null;
    /* access modifiers changed from: private */
    public IRecycleBinFace mRecycleBinFace = ((IRecycleBinFace) ServiceManager.getService(IRecycleBinFace.Companion.getSERVICE_REFERENCE()));
    private View mRenameDivider;
    private View mRenameLayout;
    /* access modifiers changed from: private */
    public BubbleBaseManager mRightMultipleBubble = null;
    /* access modifiers changed from: private */
    public OnTabClickListener mTabClickListener;
    private TextView mToolBarDeleteView;
    private View mToolBarHDivider;
    private TextView mToolBarMoveView;
    private TextView mToolBarRenameView;
    /* access modifiers changed from: private */
    public NoScrollViewPager mViewPager;
    public boolean notDispatchMove = false;
    /* access modifiers changed from: private */
    public int startX;
    /* access modifiers changed from: private */
    public int startY;

    public interface OnEditLayoutClickListener {
        String getCurrentTabUBCPage();

        boolean getLoginStatus();

        Boolean isClassifySelectAll();

        boolean isDeleteSelectAll();

        Boolean isFavorHisPage();

        Boolean isFavorPage();

        void onBackClicked(View view2);

        void onCancelClicked(View view2);

        void onDeleteClicked(View view2);

        void onEditClicked(View view2);

        void onEditableChanged(boolean z);

        void onMoveClicked(View view2);

        void onNewBuildClicked(View view2);

        void onRenameClicked(View view2);

        void onSearchClicked(View view2);

        void onSelectedAllClicked(View view2, boolean z);
    }

    public interface OnTabClickListener {
        void onClick(int i2);
    }

    public interface OnTabHostChangeListener {
        void onPageScrollStateChanged(int i2);

        void onPageSelected(int i2);
    }

    public ActionBarPagerTabHost(Context context, boolean canViewPagerScroll) {
        super(context);
        this.mCanViewPagerScroll = canViewPagerScroll;
        init(context);
    }

    public ActionBarPagerTabHost(Context context, boolean canViewPagerScroll, boolean enableIndicator) {
        super(context);
        this.mCanViewPagerScroll = canViewPagerScroll;
        this.mEnableIndicator = enableIndicator;
        init(context);
    }

    public ActionBarPagerTabHost(Context context) {
        super(context);
        init(context);
    }

    public ActionBarPagerTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ActionBarPagerTabHost(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View root = LayoutInflater.from(context).inflate(R.layout.actionbar_pager_tab_root, this);
        this.mViewPager = (NoScrollViewPager) root.findViewById(R.id.viewpager);
        setViewPagerScroll(this.mCanViewPagerScroll);
        this.mDivider = root.findViewById(R.id.tabhost_divider);
        this.mViewPager.setOffscreenPageLimit(3);
        setTabTextColor(getResources().getColorStateList(com.baidu.android.common.ui.style.R.color.tab_item_color));
        setTabTextSize((int) getResources().getDimension(com.baidu.android.common.ui.style.R.dimen.pager_tab_item_textsize));
        setPageResources();
    }

    private void setViewPagerScroll(boolean canScroll) {
        if (canScroll) {
            setNoScroll(false);
            setTabHostIsEditable(false);
            return;
        }
        setNoScroll(true);
        setTabHostIsEditable(true);
    }

    private void initActionBar() {
        BdActionBar bdActionBar = this.mActionBar;
        if (bdActionBar != null) {
            bdActionBar.showRightTxtZone1ImgVisible();
            this.mActionBar.setRightTxtZone1OnClickListener(new ActionBarPagerTabHost$$ExternalSyntheticLambda2(this));
            updateRightImg1Drawable();
            tryShowRecycleBinNewTip();
            this.mActionBar.setRightImgZone2Visibility(0);
            this.mActionBar.setRightImgZone2OnClickListener(new ActionBarPagerTabHost$$ExternalSyntheticLambda3(this));
            updateRightImg2Drawable();
            if (!UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
                this.mActionBar.setRightImgZone1Visibility(0);
                this.mActionBar.setRightImgZone1OnClickListener(new ActionBarPagerTabHost$$ExternalSyntheticLambda4(this));
                updateRightImg3Drawable();
            }
        } else if (DEBUG) {
            Log.e(TAG, "——> initActionBar: has a null actionBar!!!");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initActionBar$0$com-baidu-searchbox-userassetsaggr-container-ui-ActionBarPagerTabHost  reason: not valid java name */
    public /* synthetic */ void m4667lambda$initActionBar$0$combaidusearchboxuserassetsaggrcontaineruiActionBarPagerTabHost(View v) {
        showMenuPopupWindow(v);
        BubbleBaseManager bubbleBaseManager = this.mRecycleBinBubble;
        if (bubbleBaseManager != null) {
            bubbleBaseManager.dismissBubble();
        }
        BubbleBaseManager bubbleBaseManager2 = this.mRightMultipleBubble;
        if (bubbleBaseManager2 != null) {
            bubbleBaseManager2.dismissBubble();
        }
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        if (onEditLayoutClickListener != null && onEditLayoutClickListener.isFavorHisPage().booleanValue()) {
            UserAssetsAggrUbc.event("click", this.mEditLayoutClickListener.isFavorPage().booleanValue() ? "tab_fav" : "tab_his", UserAssetsAggrUbc.SOURCE_MENU_RIGHT_TOP, "");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initActionBar$1$com-baidu-searchbox-userassetsaggr-container-ui-ActionBarPagerTabHost  reason: not valid java name */
    public /* synthetic */ void m4668lambda$initActionBar$1$combaidusearchboxuserassetsaggrcontaineruiActionBarPagerTabHost(View v) {
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        if (onEditLayoutClickListener != null) {
            onEditLayoutClickListener.onSearchClicked(v);
            if (this.mEditLayoutClickListener.isFavorHisPage().booleanValue()) {
                UserAssetsAggrUbc.event("click", this.mEditLayoutClickListener.isFavorPage().booleanValue() ? "tab_fav" : "tab_his", "search_btn", "");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initActionBar$2$com-baidu-searchbox-userassetsaggr-container-ui-ActionBarPagerTabHost  reason: not valid java name */
    public /* synthetic */ void m4669lambda$initActionBar$2$combaidusearchboxuserassetsaggrcontaineruiActionBarPagerTabHost(View v) {
        OnEditLayoutClickListener onEditLayoutClickListener;
        if (v != null && v.isEnabled() && (onEditLayoutClickListener = this.mEditLayoutClickListener) != null) {
            onEditLayoutClickListener.onEditClicked(v);
            if (this.mEditLayoutClickListener.isFavorHisPage().booleanValue()) {
                UserAssetsAggrUbc.event("click", this.mEditLayoutClickListener.isFavorPage().booleanValue() ? "tab_fav" : "tab_his", UserAssetsAggrUbc.SOURCE_EDIT_LEFT_TOP, "");
            }
        }
    }

    private boolean isActivityRun(Context context) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return false;
        }
        return true;
    }

    private void showMenuPopupWindow(View anchorView) {
        if (isActivityRun(anchorView.getContext())) {
            List<BdListPopupWindow.ListItemData> datas = new ArrayList<>();
            if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
                BdListPopupWindow.ListItemData editData = new BdListPopupWindow.ListItemData(R.string.usr_assets_activity_edit, R.drawable.user_assets_action_bar_edit_icon);
                editData.setItemClickListener(new ActionBarPagerTabHost$$ExternalSyntheticLambda6(this, anchorView));
                boolean editIsEnabled = false;
                BdActionBar bdActionBar = this.mActionBar;
                if (!(bdActionBar == null || bdActionBar.getRightImgZone1() == null)) {
                    editIsEnabled = this.mActionBar.getRightImgZone1().isEnabled();
                }
                editData.setEnable(isUserLogin() && editIsEnabled);
                datas.add(editData);
            }
            if (isFavorFragment() && isClassifySelectAll() && isUserLogin()) {
                BdListPopupWindow.ListItemData newBuildData = new BdListPopupWindow.ListItemData(R.string.usr_assets_activity_new_build_bin, R.drawable.user_assets_action_bar_new_build_icon);
                newBuildData.setItemClickListener(new ActionBarPagerTabHost$$ExternalSyntheticLambda7(this, anchorView));
                datas.add(newBuildData);
            }
            BdListPopupWindow.ListItemData recycleData = new BdListPopupWindow.ListItemData(R.string.usr_assets_activity_recycle_bin, R.drawable.user_assets_action_bar_recycle_icon);
            recycleData.setItemClickListener(new ActionBarPagerTabHost$$ExternalSyntheticLambda8(this, recycleData));
            IRecycleBinFace iRecycleBinFace = this.mRecycleBinFace;
            if (iRecycleBinFace != null) {
                recycleData.setShowDot(iRecycleBinFace.shouldShowOperationType(0));
            }
            datas.add(recycleData);
            new BdListPopupWindow(anchorView.getContext(), datas).showAtAnchorView(anchorView);
            doRecycleBinEntryUbc("show");
            if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
                UserAssetsAggrUbc.event("show", this.mEditLayoutClickListener.getCurrentTabUBCPage(), UserAssetsAggrUbc.SOURCE_EDIT_RIGHT_MENU, "");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$showMenuPopupWindow$3$com-baidu-searchbox-userassetsaggr-container-ui-ActionBarPagerTabHost  reason: not valid java name */
    public /* synthetic */ void m4671lambda$showMenuPopupWindow$3$combaidusearchboxuserassetsaggrcontaineruiActionBarPagerTabHost(View anchorView, int position) {
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        if (onEditLayoutClickListener != null) {
            onEditLayoutClickListener.onEditClicked(anchorView);
            UserAssetsAggrUbc.event("click", this.mEditLayoutClickListener.getCurrentTabUBCPage(), UserAssetsAggrUbc.SOURCE_EDIT_RIGHT_MENU, "");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$showMenuPopupWindow$4$com-baidu-searchbox-userassetsaggr-container-ui-ActionBarPagerTabHost  reason: not valid java name */
    public /* synthetic */ void m4672lambda$showMenuPopupWindow$4$combaidusearchboxuserassetsaggrcontaineruiActionBarPagerTabHost(View anchorView, int position) {
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        if (onEditLayoutClickListener != null) {
            onEditLayoutClickListener.onNewBuildClicked(anchorView);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$showMenuPopupWindow$5$com-baidu-searchbox-userassetsaggr-container-ui-ActionBarPagerTabHost  reason: not valid java name */
    public /* synthetic */ void m4673lambda$showMenuPopupWindow$5$combaidusearchboxuserassetsaggrcontaineruiActionBarPagerTabHost(BdListPopupWindow.ListItemData recycleData, int position) {
        BadgeView badgeView;
        FrameLayout frameLayout = mBadgeFrameLayout;
        if (!(frameLayout == null || (badgeView = mBadgeView) == null)) {
            frameLayout.removeView(badgeView);
            mBadgeView = null;
        }
        if (this.mRecycleBinFace != null && recycleData.isShowDot()) {
            this.mRecycleBinFace.recordOperation(0);
        }
        doRecycleBinEntryUbc("click");
        Router.invoke(this.mContext, "baiduboxapp://recycleBin/openRecycleBinPage?pageType=" + getRecycleBinEntryPageType());
    }

    private boolean isFavorFragment() {
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        return onEditLayoutClickListener != null && onEditLayoutClickListener.isFavorPage().booleanValue();
    }

    private boolean isClassifySelectAll() {
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        return onEditLayoutClickListener != null && onEditLayoutClickListener.isClassifySelectAll().booleanValue();
    }

    private boolean isUserLogin() {
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        return onEditLayoutClickListener != null && onEditLayoutClickListener.getLoginStatus();
    }

    private void doRecycleBinEntryUbc(String type) {
        String ubcPage = "";
        NoScrollViewPager viewPager = this.mViewPager;
        if (viewPager != null && viewPager.getCurrentItem() == 0) {
            ubcPage = "tab_fav";
        } else if (viewPager != null && 1 == viewPager.getCurrentItem()) {
            ubcPage = "tab_his";
        }
        UserAssetsRecycleBinUbc.INSTANCE.doRecycleBinEntryUbc(type, UserAssetsRecycleBinUbc.VALUE_SOURCE_FAVORHIS, ubcPage);
    }

    private String getRecycleBinEntryPageType() {
        NoScrollViewPager viewPager = this.mViewPager;
        if ((viewPager == null || viewPager.getCurrentItem() != 0) && viewPager != null && 1 == viewPager.getCurrentItem()) {
            return "1";
        }
        return "0";
    }

    public void updateRightImg1Drawable() {
        BdActionBar bdActionBar = this.mActionBar;
        if (bdActionBar != null && (bdActionBar.getRightTxtZone1Img() instanceof BdBaseImageView)) {
            BdBaseImageView imageView = (BdBaseImageView) this.mActionBar.getRightTxtZone1Img();
            imageView.setSupportDark(false);
            updateIconScaleSize(imageView, R.dimen.user_assets_tool_bar_icon_width, R.dimen.user_assets_tool_bar_icon_height);
            Drawable drawable = ResUtil.getDrawableByResId(R.drawable.user_assets_action_bar_more_icon);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageDrawable(drawable);
        }
    }

    private void updateRightImg2Drawable() {
        BdActionBar bdActionBar = this.mActionBar;
        if (bdActionBar != null && (bdActionBar.getRightImgZone2Image() instanceof BdBaseImageView)) {
            BdBaseImageView imageView = (BdBaseImageView) this.mActionBar.getRightImgZone2Image();
            imageView.setSupportDark(false);
            updateIconScaleSize(imageView, R.dimen.user_assets_tool_bar_icon_width, R.dimen.user_assets_tool_bar_icon_height);
            this.mActionBar.setRightImgZone2ImageSrc(ResUtil.getDrawableByResId(R.drawable.user_assets_action_bar_search_icon));
        }
    }

    private void updateRightImg3Drawable() {
        BdActionBar bdActionBar = this.mActionBar;
        if (bdActionBar != null && (bdActionBar.getRightImgZone1Image() instanceof BdBaseImageView)) {
            BdBaseImageView imageView = (BdBaseImageView) this.mActionBar.getRightImgZone1Image();
            imageView.setSupportDark(false);
            updateIconScaleSize(imageView, R.dimen.user_assets_tool_bar_icon_width, R.dimen.user_assets_tool_bar_icon_height);
            this.mActionBar.setRightImgZone1ImageSrc(ResUtil.getDrawableByResId(R.drawable.user_assets_action_bar_edit_icon));
        }
    }

    private void updateIconScaleSize(View view2, int widthResId, int heightResId) {
        Context context = this.mContext;
        if (context != null && context.getResources() != null && view2 != null && view2.getLayoutParams() != null) {
            ViewGroup.LayoutParams params = view2.getLayoutParams();
            params.width = (int) FontSizeHelper.getScaledSize(0, ResUtil.getDimenByResId(widthResId));
            params.height = (int) FontSizeHelper.getScaledSize(0, ResUtil.getDimenByResId(heightResId));
            view2.setLayoutParams(params);
        }
    }

    public void tryShowRecycleBinNewTip() {
        IRecycleBinFace iRecycleBinFace;
        ImageView rightTextImg;
        if (this.mActionBar != null && (iRecycleBinFace = this.mRecycleBinFace) != null && iRecycleBinFace.shouldShowOperationType(0) && (rightTextImg = this.mActionBar.getRightTxtZone1Img()) != null) {
            ViewParent parentView = rightTextImg.getParent();
            if ((parentView instanceof FrameLayout) && mBadgeView == null) {
                mBadgeFrameLayout = (FrameLayout) parentView;
                BadgeView badgeView = new BadgeView(this.mContext);
                mBadgeView = badgeView;
                badgeView.setType(BadgeView.Type.DOT);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 53;
                layoutParams.topMargin = this.mActionBar.getResources().getDimensionPixelOffset(R.dimen.user_assets_right_dot_top_margin);
                layoutParams.leftMargin = this.mActionBar.getResources().getDimensionPixelOffset(R.dimen.user_assets_right_dot_left_margin);
                mBadgeFrameLayout.addView(mBadgeView, layoutParams);
            }
        }
    }

    public void tryShowRecycleBinGuide() {
        IRecycleBinFace iRecycleBinFace;
        ImageView rightTextImg;
        if (this.mActionBar != null && this.mRecycleBinBubble == null && (iRecycleBinFace = this.mRecycleBinFace) != null && iRecycleBinFace.shouldShowOperationType(1) && (rightTextImg = this.mActionBar.getRightTxtZone1Img()) != null) {
            BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(getResources().getString(R.string.recycle_bin_guide_bubble_text)).setFontSize(1, 12.0f).setAnchorView((View) rightTextImg).setAutoDismiss(true).setAutoDismissInterval(3000).enableAnimation(true).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new BubbleManager.OnBubbleEventListener() {
                public void onBubbleDismiss() {
                }

                public void onBubbleShow() {
                    ActionBarPagerTabHost.this.mRecycleBinFace.recordOperation(1);
                }

                public void onBubbleClick() {
                    if (ActionBarPagerTabHost.this.mRecycleBinBubble != null) {
                        ActionBarPagerTabHost.this.mRecycleBinBubble.dismissBubble();
                    }
                }
            }).build();
            this.mRecycleBinBubble = build;
            if (build != null) {
                build.showBubble();
            }
        }
    }

    /* access modifiers changed from: private */
    public void showMultipleButtonGuide() {
        ImageView rightTextImg;
        int guideTextResId;
        if (isActivityRun(getContext()) && this.mActionBar != null && this.mRightMultipleBubble == null) {
            final boolean showNewBuild = false;
            final boolean showEditGuide = UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment() && !RightEditButtonBubbleMgr.INSTANCE.isGuideShowed();
            if (!RightEditButtonBubbleMgr.INSTANCE.isNewBuildShowed() && isFavorFragment() && isClassifySelectAll() && isUserLogin()) {
                showNewBuild = true;
            }
            if ((showEditGuide || showNewBuild) && (rightTextImg = this.mActionBar.getRightTxtZone1Img()) != null) {
                if (showEditGuide && showNewBuild) {
                    guideTextResId = R.string.right_multiple_bubble_text;
                } else if (showEditGuide) {
                    guideTextResId = R.string.right_edit_bubble_text;
                } else {
                    guideTextResId = R.string.right_new_build_bubble_text;
                }
                BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setText(getResources().getString(guideTextResId)).setFontSize(1, 12.0f).setAnchorView((View) rightTextImg).setAutoDismiss(true).setAutoDismissInterval(5000).enableAnimation(true).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new BubbleManager.OnBubbleEventListener() {
                    public void onBubbleDismiss() {
                    }

                    public void onBubbleShow() {
                        boolean z = showEditGuide;
                        String page = "tab_fav";
                        if (z && showNewBuild) {
                            RightEditButtonBubbleMgr.INSTANCE.setGuideShowed();
                            RightEditButtonBubbleMgr.INSTANCE.setNewBuildShowed();
                            if (ActionBarPagerTabHost.this.mEditLayoutClickListener != null && ActionBarPagerTabHost.this.mEditLayoutClickListener.isFavorHisPage().booleanValue()) {
                                if (!ActionBarPagerTabHost.this.mEditLayoutClickListener.isFavorPage().booleanValue()) {
                                    page = "tab_his";
                                }
                                String page2 = page;
                                UserAssetsAggrUbc.event("show", page2, UserAssetsAggrUbc.SOURCE_MENU_EDIT_TIPS, "");
                                UserAssetsAggrUbc.event("show", page2, UserAssetsAggrUbc.SOURCE_MENU_NEW_BUILD_TIPS, "");
                            }
                        } else if (z) {
                            RightEditButtonBubbleMgr.INSTANCE.setGuideShowed();
                            if (ActionBarPagerTabHost.this.mEditLayoutClickListener != null && ActionBarPagerTabHost.this.mEditLayoutClickListener.isFavorHisPage().booleanValue()) {
                                if (!ActionBarPagerTabHost.this.mEditLayoutClickListener.isFavorPage().booleanValue()) {
                                    page = "tab_his";
                                }
                                UserAssetsAggrUbc.event("show", page, UserAssetsAggrUbc.SOURCE_MENU_EDIT_TIPS, "");
                            }
                        } else {
                            RightEditButtonBubbleMgr.INSTANCE.setNewBuildShowed();
                            if (ActionBarPagerTabHost.this.mEditLayoutClickListener != null && ActionBarPagerTabHost.this.mEditLayoutClickListener.isFavorHisPage().booleanValue()) {
                                if (!ActionBarPagerTabHost.this.mEditLayoutClickListener.isFavorPage().booleanValue()) {
                                    page = "tab_his";
                                }
                                UserAssetsAggrUbc.event("show", page, UserAssetsAggrUbc.SOURCE_MENU_NEW_BUILD_TIPS, "");
                            }
                        }
                    }

                    public void onBubbleClick() {
                        if (ActionBarPagerTabHost.this.mRightMultipleBubble != null) {
                            ActionBarPagerTabHost.this.mRightMultipleBubble.dismissBubble();
                        }
                    }
                }).build();
                this.mRightMultipleBubble = build;
                if (build != null) {
                    build.showBubble();
                }
            }
        }
    }

    public void tryShowRecycleBinGuideDelay() {
        Handler handler = UiThreadUtils.getMainHandler();
        Message message = Message.obtain(handler, new ActionBarPagerTabHost$$ExternalSyntheticLambda1(this));
        message.what = MESSAGE_WHAT;
        handler.sendMessageDelayed(message, 3000);
    }

    public void tryShowMultipleButtonGuide() {
        UiThreadUtils.runOnUiThread(new ActionBarPagerTabHost$$ExternalSyntheticLambda0(this), 1000);
    }

    private void initToolBar() {
        this.mMoveDivider = this.mDeleteLayout.findViewById(R.id.move_divider);
        this.mRenameDivider = this.mDeleteLayout.findViewById(R.id.rename_divider);
        this.mMoveLayout = this.mDeleteLayout.findViewById(R.id.editable_move_layout);
        this.mRenameLayout = this.mDeleteLayout.findViewById(R.id.editable_rename_layout);
        this.mToolBarMoveView = (TextView) this.mDeleteLayout.findViewById(R.id.editable_move_view);
        this.mToolBarRenameView = (TextView) this.mDeleteLayout.findViewById(R.id.editable_rename_view);
        this.mToolBarDeleteView = (TextView) this.mDeleteLayout.findViewById(R.id.editable_delete_view);
        this.mToolBarHDivider = this.mDeleteLayout.findViewById(R.id.tool_bar_divider);
        this.mToolBarMoveView.setOnTouchListener(new TouchStateListener());
        this.mToolBarRenameView.setOnTouchListener(new TouchStateListener());
        this.mToolBarDeleteView.setOnTouchListener(new TouchStateListener());
        this.mToolBarDeleteView.setOnClickListener(new ActionBarPagerTabHost$$ExternalSyntheticLambda5(this));
        this.mToolBarMoveView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ActionBarPagerTabHost.this.mEditLayoutClickListener != null) {
                    ActionBarPagerTabHost.this.mEditLayoutClickListener.onMoveClicked(v);
                }
            }
        });
        this.mToolBarRenameView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ActionBarPagerTabHost.this.mEditLayoutClickListener != null) {
                    ActionBarPagerTabHost.this.mEditLayoutClickListener.onRenameClicked(v);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initToolBar$6$com-baidu-searchbox-userassetsaggr-container-ui-ActionBarPagerTabHost  reason: not valid java name */
    public /* synthetic */ void m4670lambda$initToolBar$6$combaidusearchboxuserassetsaggrcontaineruiActionBarPagerTabHost(View v) {
        OnEditLayoutClickListener onEditLayoutClickListener = this.mEditLayoutClickListener;
        if (onEditLayoutClickListener != null) {
            onEditLayoutClickListener.onDeleteClicked(v);
            if (this.mEditLayoutClickListener.isFavorHisPage().booleanValue() && this.mEditLayoutClickListener.isDeleteSelectAll()) {
                UserAssetsAggrUbc.event("click", this.mEditLayoutClickListener.isFavorPage().booleanValue() ? "tab_fav" : "tab_his", UserAssetsAggrUbc.SOURCE_DELETE_RIGHT_BOTTOM, "");
            }
        }
    }

    public void setSelectedCount(int count) {
        if (this.mToolBarDeleteView == null) {
            return;
        }
        if (count > 0) {
            setDeleteEnabled(true);
            this.mToolBarDeleteView.setText(getResources().getString(R.string.delete_number, new Object[]{Integer.valueOf(count)}).trim());
            return;
        }
        setDeleteEnabled(false);
        this.mToolBarDeleteView.setText(getResources().getString(R.string.delete));
    }

    public void setEditableListener(OnEditLayoutClickListener listener) {
        this.mEditLayoutClickListener = listener;
    }

    public BdPagerTabBar getPagerTabBar() {
        return this.mPagerTabBar;
    }

    public void setPageIndicatorDrawable(int resId) {
        DrawablePageIndicator drawablePageIndicator = this.mPageIndicator;
        if (drawablePageIndicator != null) {
            drawablePageIndicator.setIndicatorDrawable(getResources().getDrawable(resId));
        }
    }

    public void setIndicatorColor(int color, float lenPrecent, float height) {
        DrawablePageIndicator drawablePageIndicator = this.mPageIndicator;
        if (drawablePageIndicator != null) {
            drawablePageIndicator.setIndicatorColor(color, lenPrecent, height);
        }
    }

    public void setIndicatorColor(int color, float height) {
        DrawablePageIndicator drawablePageIndicator = this.mPageIndicator;
        if (drawablePageIndicator != null) {
            drawablePageIndicator.setIndicatorColor(color, height);
        }
    }

    public void setOffscreenPageLimit(int limit) {
        this.mViewPager.setOffscreenPageLimit(limit);
    }

    public void setTabTextColor(ColorStateList colorStateList) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setTabTextColor(colorStateList);
        }
    }

    public void setTabTextColor(int textColor, int selTextColor) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setTabTextColor(textColor, selTextColor);
        }
    }

    public void setBoldWhenSelect(boolean isBold) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBoldWhenSelect(isBold);
        }
    }

    public void setTabTextSize(int textSize) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setTabTextSize(textSize);
        }
    }

    public void setTabNightModeRes(int backgroundColor, int pageIndicatorDrawable, int textColor, int selTextColor, int tabBarBackgroundDrawable) {
        Context context = this.mContext;
        if (context != null) {
            setBackground(context.getResources().getDrawable(backgroundColor));
            setPageIndicatorDrawable(pageIndicatorDrawable);
            setTabTextColor(textColor, selTextColor);
            setTabBarBackgroundDrawable(tabBarBackgroundDrawable);
        }
    }

    public void setTabBarHeight(int height) {
        ViewGroup.LayoutParams params;
        View container = findViewById(com.baidu.android.common.ui.R.id.pager_tab_bar_container);
        if (container != null && (params = container.getLayoutParams()) != null) {
            params.height = height;
            container.setLayoutParams(params);
            requestLayout();
        }
    }

    public void selectTab(int index) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.selectTab(index);
        }
    }

    public void selectTabAndScroll(int index) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.selectTab(index);
            NoScrollViewPager noScrollViewPager = this.mViewPager;
            if (noScrollViewPager != null) {
                noScrollViewPager.setCurrentItem(index);
            }
        }
    }

    public void setPagerAdapter(PagerAdapter adapter, int initPosition) {
        NoScrollViewPager noScrollViewPager = this.mViewPager;
        if (noScrollViewPager != null) {
            noScrollViewPager.setAdapter(adapter);
            this.mPageIndicator.setViewPager(this.mViewPager, initPosition);
            this.mPageIndicator.setPagerTabBar(this.mPagerTabBar);
        }
        selectTab(initPosition);
    }

    public void setTabAdapter(Adapter adapter) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setAdapter(adapter);
        }
    }

    public ActionBarPagerTabHost addTab(BdPagerTab tab) {
        this.mPagerTabBar.addTab(tab);
        return this;
    }

    public int getTabCount() {
        return this.mPagerTabBar.getTabCount();
    }

    public void showOrHideDivider(boolean show) {
        View view2 = this.mDivider;
        if (view2 != null) {
            view2.setVisibility(show ? 0 : 8);
        }
    }

    public void setDividerBackground(int color) {
        View view2 = this.mDivider;
        if (view2 != null) {
            view2.setBackgroundColor(color);
        }
    }

    public void setDividerHeight(int height) {
        View view2 = this.mDivider;
        if (view2 != null) {
            ViewGroup.LayoutParams lp = view2.getLayoutParams();
            lp.height = height;
            this.mDivider.setLayoutParams(lp);
        }
    }

    public int getCurrentItem() {
        return this.mViewPager.getCurrentItem();
    }

    public void layoutTabs() {
        this.mPagerTabBar.updateTabs();
    }

    public void layoutTabs(boolean post) {
        this.mPagerTabBar.updateTabs(post);
    }

    public void invalidatePageIndicator() {
        this.mPageIndicator.setTabTextWidthArrayNull();
        this.mPageIndicator.invalidate();
    }

    public void setTabBarBackground(int resid) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBackground(getResources().getDrawable(resid));
        }
    }

    public void setTabBarBackgroundDrawable(int resid) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBackground(getResources().getDrawable(resid));
        }
    }

    public void setTabBarBackgroundColor(int color) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBackgroundColor(color);
        }
    }

    public void setTabChangeListener(OnTabHostChangeListener listener) {
        this.mListener = listener;
    }

    public void setTabClickListener(OnTabClickListener listener) {
        this.mTabClickListener = listener;
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public void setNoScroll(boolean noScroll) {
        NoScrollViewPager noScrollViewPager = this.mViewPager;
        if (noScrollViewPager != null) {
            noScrollViewPager.setNoScroll(noScroll);
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        setPageResources();
    }

    public void setTabHostIsEditable(boolean isEditableMode) {
        this.mIsEditableMode = isEditableMode;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
            public void onNightModeChanged(boolean isNightMode) {
                ActionBarPagerTabHost.this.setPageResources();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        return (this.notDispatchMove && 2 == ev.getAction()) || super.dispatchTouchEvent(ev);
    }

    public void setPageResources() {
        View view2 = this.mDivider;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC35));
        }
        View view3 = this.mMoveDivider;
        if (view3 != null) {
            view3.setBackgroundColor(getResources().getColor(R.color.usr_assets_divider_color));
        }
        View view4 = this.mRenameDivider;
        if (view4 != null) {
            view4.setBackgroundColor(getResources().getColor(R.color.usr_assets_divider_color));
        }
        View view5 = this.mToolBarHDivider;
        if (view5 != null) {
            view5.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC35));
        }
        setTabBarBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
        setIcons();
        updateRightImg1Drawable();
        updateRightImg2Drawable();
        updateRightImg3Drawable();
    }

    private void setIcons() {
        setImageSrc(this.mToolBarMoveView, R.drawable.usr_assets_tool_bar_move, R.color.usr_assets_tool_bar_rename_color);
        setImageSrc(this.mToolBarDeleteView, R.drawable.usr_assets_tool_bar_delete, R.color.usr_assets_tool_bar_delete_color);
        setImageSrc(this.mToolBarRenameView, R.drawable.usr_assets_tool_bar_rename, R.color.usr_assets_tool_bar_rename_color);
    }

    public void setIcon(ImageView icon, int resId) {
        if (icon != null && resId != 0) {
            icon.setImageDrawable(getResources().getDrawable(resId));
            icon.setVisibility(0);
        }
    }

    public void setImageSrc(TextView view2, int resId, int txtColorId) {
        UserAssetsAggrUtils.setImageSrc(this.mContext, view2, resId, txtColorId);
    }

    public void setImageSrc(TextView view2, int resId, ColorStateList colorStateList) {
        UserAssetsAggrUtils.setImageSrc(this.mContext, view2, resId, colorStateList);
    }

    public void setToolbarView(boolean hasMoveView, boolean hasRenameView) {
        this.mHasMoveView = hasMoveView;
        this.mHasRenameView = hasRenameView;
    }

    public void setRightImg3Enable(boolean enable) {
        BdActionBar bdActionBar = this.mActionBar;
        if (bdActionBar != null) {
            UserAssetsAggrUtils.setViewEnable(bdActionBar.getRightImgZone1(), enable);
        }
    }

    public void onEditableChanged(boolean isEditable) {
        if (DEBUG) {
            Log.d("ActionBarPagerTabHost", "——> onEditableChanged: " + isEditable);
        }
        if (this.mCanViewPagerScroll) {
            setViewPagerScroll(!isEditable);
        }
        if (isEditable) {
            int i2 = 8;
            this.mMoveLayout.setVisibility(this.mHasMoveView ? 0 : 8);
            View view2 = this.mRenameLayout;
            if (this.mHasRenameView) {
                i2 = 0;
            }
            view2.setVisibility(i2);
            this.mDeleteLayout.setVisibility(0);
        }
        setSelectedCount(0);
        setMoveToEnabled(false);
        setRenameEnabled(false);
        setDeleteEnabled(false);
    }

    public void setActionBar(BdActionBar actionBar) {
        if (actionBar != null) {
            this.mActionBar = actionBar;
            initActionBar();
        } else if (DEBUG) {
            Log.e(TAG, "——> setActionBar: null actionBar set!!!");
        }
    }

    public void initParamsComponent(BdActionBar actionBar, View tabContent) {
        if (actionBar != null && tabContent != null) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.user_assets_tab_width), getResources().getDimensionPixelSize(R.dimen.user_assets_tab_height));
            params.addRule(15);
            if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
                View customView = actionBar.getLeftCustomLayout();
                if (!(customView == null || customView.getLayoutParams() == null)) {
                    ViewGroup.LayoutParams cusParams = customView.getLayoutParams();
                    cusParams.width = -2;
                    cusParams.height = -1;
                    customView.setLayoutParams(cusParams);
                    params.addRule(1, customView.getId());
                }
            } else {
                params.leftMargin = getResources().getDimensionPixelSize(R.dimen.user_assets_tab_margin);
            }
            tabContent.setLayoutParams(params);
        }
    }

    public void setEditToolBar(View editToolBar) {
        if (editToolBar != null) {
            this.mDeleteLayout = editToolBar;
            initToolBar();
        } else if (DEBUG) {
            Log.e(TAG, "——> setEditToolBar: null editToolBar set!!!!");
        }
    }

    public void onDestroy() {
        BadgeView badgeView;
        FrameLayout frameLayout = mBadgeFrameLayout;
        if (!(frameLayout == null || (badgeView = mBadgeView) == null)) {
            frameLayout.removeView(badgeView);
            mBadgeView = null;
        }
        BubbleBaseManager bubbleBaseManager = this.mRecycleBinBubble;
        if (bubbleBaseManager != null) {
            bubbleBaseManager.dismissBubble();
        }
        UiThreadUtils.getMainHandler().removeMessages(MESSAGE_WHAT);
    }

    public void setPagerTabContent(View pagerTabContent) {
        if (pagerTabContent != null) {
            this.mPagerTabBar = (BdPagerTabBar) pagerTabContent.findViewById(R.id.pager_tab_bar);
            this.mPageIndicator = (DrawablePageIndicator) pagerTabContent.findViewById(R.id.indicator);
            initPagerTab();
        } else if (DEBUG) {
            Log.e(TAG, "——> setPagerTabBar: null PagerTabContent set!!!");
        }
    }

    private void initPagerTab() {
        if (this.mPagerTabBar != null && this.mPageIndicator != null) {
            if (!isInEditMode()) {
                this.mPagerTabBar.setOnTabSelectedListener(new BdPagerTabBar.OnTabSelectedListener() {
                    public void onTabSelected(BdPagerTabBar pagerBar, int index) {
                        if (ActionBarPagerTabHost.this.mViewPager != null) {
                            ActionBarPagerTabHost.this.mViewPager.setCurrentItem(index);
                        }
                    }
                });
            }
            if (!this.mEnableIndicator) {
                this.mPageIndicator.setVisibility(8);
                BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
                if (bdPagerTabBar != null) {
                    bdPagerTabBar.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case 0:
                                    int unused = ActionBarPagerTabHost.this.startX = (int) event.getX();
                                    int unused2 = ActionBarPagerTabHost.this.startY = (int) event.getY();
                                    break;
                                case 1:
                                    if (!ActionBarPagerTabHost.this.isMoving) {
                                        int downPage = (int) (event.getX() / ((float) (ActionBarPagerTabHost.this.getWidth() / ActionBarPagerTabHost.this.mViewPager.getAdapter().getCount())));
                                        if (downPage != ActionBarPagerTabHost.this.mViewPager.getCurrentItem()) {
                                            ActionBarPagerTabHost.this.mViewPager.setCurrentItem(downPage);
                                            if (ActionBarPagerTabHost.this.mTabClickListener != null) {
                                                ActionBarPagerTabHost.this.mTabClickListener.onClick(downPage);
                                            }
                                            return true;
                                        }
                                    }
                                    boolean unused3 = ActionBarPagerTabHost.this.isMoving = false;
                                    break;
                                case 2:
                                    int slop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(ActionBarPagerTabHost.this.getContext()));
                                    int dX = (int) (event.getX() - ((float) ActionBarPagerTabHost.this.startX));
                                    if (Math.abs(dX) > Math.abs((int) (event.getY() - ((float) ActionBarPagerTabHost.this.startY))) && Math.abs(dX) > slop) {
                                        boolean unused4 = ActionBarPagerTabHost.this.isMoving = true;
                                        break;
                                    }
                            }
                            return false;
                        }
                    });
                }
            }
            this.mPageIndicator.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    if (ActionBarPagerTabHost.this.mIsEditableMode) {
                        return true;
                    }
                    if (event.getAction() != 0) {
                        return false;
                    }
                    ActionBarPagerTabHost.this.mPageIndicator.setTabClickListener(new DrawablePageIndicator.OnTabClickListener() {
                        public void onClick(int position) {
                            if (ActionBarPagerTabHost.this.mTabClickListener != null) {
                                ActionBarPagerTabHost.this.mTabClickListener.onClick(position);
                            }
                        }
                    });
                    return false;
                }
            });
            this.mPageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int state) {
                    if (!ActionBarPagerTabHost.this.mIsEditableMode && ActionBarPagerTabHost.this.mListener != null) {
                        ActionBarPagerTabHost.this.mListener.onPageScrollStateChanged(state);
                    }
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    boolean unused = ActionBarPagerTabHost.this.mIsEditableMode;
                }

                public void onPageSelected(int position) {
                    if (!ActionBarPagerTabHost.this.mIsEditableMode) {
                        ActionBarPagerTabHost.this.selectTab(position);
                        if (ActionBarPagerTabHost.this.mListener != null) {
                            ActionBarPagerTabHost.this.mListener.onPageSelected(position);
                        }
                    }
                }
            });
        } else if (DEBUG) {
            Log.e(TAG, "——> initPagerTab: mPagerTabBar or mPageIndicator is null!!!!");
        }
    }

    public boolean isEditable() {
        return this.mIsEditable;
    }

    public void setDeleteEnabled(boolean enabled) {
        UserAssetsAggrUtils.setViewEnable(this.mToolBarDeleteView, enabled);
    }

    public void setMoveToEnabled(boolean enabled) {
        UserAssetsAggrUtils.setViewEnable(this.mToolBarMoveView, enabled);
    }

    public void setRenameEnabled(boolean enabled) {
        UserAssetsAggrUtils.setViewEnable(this.mToolBarRenameView, enabled);
    }

    public void setViewVisiblity(View view2, int visiblity) {
        if (view2 == null) {
            return;
        }
        if (visiblity == 0 || visiblity == 4 || visiblity == 8) {
            view2.setVisibility(visiblity);
        }
    }

    public void updateFontSize() {
        int textSize = FontSizeHelper.getScaledSize(0, ResUtil.getDimenByResId(com.baidu.android.common.ui.style.R.dimen.dimen_ui_15), 2);
        int indicatorHeight = FontSizeHelper.getScaledSize(0, ResUtil.getDimenByResId(com.baidu.android.common.ui.style.R.dimen.dimen_ui_3), 2);
        setTabTextSize(textSize);
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setUIStandard(false, true);
            this.mPagerTabBar.updateTabs();
        }
        DrawablePageIndicator drawablePageIndicator = this.mPageIndicator;
        if (drawablePageIndicator != null) {
            drawablePageIndicator.setUseStandardStyle(false);
            this.mPageIndicator.setIndicatorHeight((float) indicatorHeight);
            this.mPageIndicator.setIndicatorWidth(FontSizeHelper.getScaledSize(0, 0.3f));
            this.mPageIndicator.notifyDataSetChanged();
        }
        updateRightImg1Drawable();
        updateRightImg2Drawable();
        updateRightImg3Drawable();
        TextView textView = this.mToolBarDeleteView;
        if (textView != null) {
            textView.setTextSize(0, FontSizeHelper.getScaledSizeRes(0, R.dimen.user_assets_tool_bar_icon_text_size));
        }
        TextView textView2 = this.mToolBarRenameView;
        if (textView2 != null) {
            textView2.setTextSize(0, FontSizeHelper.getScaledSizeRes(0, R.dimen.user_assets_tool_bar_icon_text_size));
        }
        TextView textView3 = this.mToolBarMoveView;
        if (textView3 != null) {
            textView3.setTextSize(0, FontSizeHelper.getScaledSizeRes(0, R.dimen.user_assets_tool_bar_icon_text_size));
        }
        setIcons();
    }
}
