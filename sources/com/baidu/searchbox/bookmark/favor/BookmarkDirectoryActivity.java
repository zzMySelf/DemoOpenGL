package com.baidu.searchbox.bookmark.favor;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.appframework.ext.ActionBottomBarExtKt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.bookmark.BookmarkUBC;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.favor.FavorConstants;
import com.baidu.searchbox.favor.R;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.ui.viewpager.BdPagerTab;
import com.baidu.searchbox.ui.viewpager.BdPagerTabHost;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFloatingBack;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.userassetsaggr.container.AbsListFragment;
import com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer;
import com.baidu.searchbox.userassetsaggr.container.UserAssetsAggrUtils;
import com.baidu.searchbox.userassetsaggr.container.UserAssetsEditableActivity;
import com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsAggrUbc;
import java.util.ArrayList;
import org.json.JSONObject;

public class BookmarkDirectoryActivity extends UserAssetsEditableActivity implements IUserAssetsContainer {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "BookmarkDirectoryActivity";
    private String mCurrentDir = Bookmarks.DEFAULT_DIRECTORY;
    /* access modifiers changed from: private */
    public FavorDirFragment mFavorDirFragment;
    private FragmentPagerAdapter mFragmentAdapter;
    private FavorModel mOptDir = new FavorModel();
    /* access modifiers changed from: private */
    public ArrayList<AbsListFragment> mPageList = new ArrayList<>();
    /* access modifiers changed from: private */
    public BdPagerTabHost mTabHostView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        Object dir = getIntent().getParcelableExtra(FavorController.EDIT_DIR_KEY);
        String source = getIntent().getStringExtra("source");
        if (dir != null && (dir instanceof FavorModel)) {
            FavorModel favorModel = (FavorModel) dir;
            this.mOptDir = favorModel;
            this.mCurrentDir = favorModel.title;
        }
        if (TextUtils.isEmpty(this.mCurrentDir)) {
            finish();
        }
        initView();
        setEnableSliding(true);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(UserAssetsAggrUbc.EXT_KEY_FOLD_NAME, this.mCurrentDir);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        UserAssetsAggrUbc.event("tool", "show", "tab_fav", source, UserAssetsAggrUbc.VALUE_FAV_READ_FOLDER, jsonObject.toString());
    }

    private void initView() {
        BdPagerTabHost bdPagerTabHost = new BdPagerTabHost(this);
        this.mTabHostView = bdPagerTabHost;
        setContentView(bdPagerTabHost);
        initTitleBar();
        initTab();
        setPageResources();
    }

    public void setContentView(View view2) {
        super.setContentView(view2);
        View rootContainer = findViewById(R.id.root_container);
        if (rootContainer != null) {
            rootContainer.setBackground((Drawable) null);
        }
        initEditableTitleBar();
    }

    /* access modifiers changed from: protected */
    public void initEditableTitleBar() {
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            bdActionBar.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
            ActionBarExtKt.showActionBarShadow(this, false);
            bdActionBar.setLeftZonesVisibility(8);
            bdActionBar.setLeftFirstViewVisibility(8);
            bdActionBar.setLeftSecondViewVisibility(8);
            bdActionBar.setLeftZoneImageSrc(0);
            bdActionBar.setRightTxtZone1Visibility(0);
            UserAssetsAggrUtils.setImageSrc(this, (TextView) bdActionBar.getRightTxtView(), com.baidu.searchbox.userassetsaggr.container.R.drawable.user_assets_action_bar_edit_icon);
            bdActionBar.getRightTxtView().setOnTouchListener(new TouchStateListener());
            bdActionBar.setRightTxtZone1OnClickListener((View.OnClickListener) null);
            bdActionBar.setRightTxt1OnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    BookmarkDirectoryActivity.this.beginEdit(true);
                }
            });
            bdActionBar.getRightTxtView().setContentDescription(getString(R.string.edit));
            bdActionBar.setLeftFirstViewSelector(getResources().getColorStateList(com.baidu.android.common.ui.style.R.color.action_bar_edit_txt_selector));
            bdActionBar.setLeftFirstViewSelector(getResources().getColorStateList(com.baidu.android.common.ui.style.R.color.action_bar_edit_txt_selector));
            bdActionBar.setRightTxtZone1TextSelector(getResources().getColorStateList(com.baidu.android.common.ui.style.R.color.action_bar_edit_txt_selector));
            enableEditState();
            ActionBottomBarExtKt.removeBottomBarBackListener(this);
            bdActionBar.setLeftZoneImageSrc(com.baidu.searchbox.userassetsaggr.container.R.drawable.user_assets_item_select_selector);
        }
    }

    private void initTab() {
        this.mTabHostView.addTab(new BdPagerTab().setTitle(getString(R.string.favor_dir_fragment_title)));
        this.mTabHostView.selectTab(0);
        this.mTabHostView.layoutTabs(true);
        this.mTabHostView.getPagerTabBarContainer().setVisibility(8);
        this.mFragmentAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            public int getCount() {
                return BookmarkDirectoryActivity.this.mTabHostView.getTabCount();
            }

            public Fragment getItem(int flag) {
                if (BookmarkDirectoryActivity.this.mFavorDirFragment == null) {
                    FavorDirFragment unused = BookmarkDirectoryActivity.this.mFavorDirFragment = new FavorDirFragment();
                    BookmarkDirectoryActivity.this.mFavorDirFragment.setArguments(BookmarkDirectoryActivity.this.getBundle());
                }
                BookmarkDirectoryActivity.this.mPageList.add(BookmarkDirectoryActivity.this.mFavorDirFragment);
                return BookmarkDirectoryActivity.this.mFavorDirFragment;
            }
        };
        this.mTabHostView.setDividerBackground(getResources().getColor(R.color.bookmark_history_group_pressed));
        if (this.mTabHostView.getPagerTabBar() != null) {
            this.mTabHostView.getPagerTabBar().setBackground((Drawable) null);
        }
        if (this.mTabHostView.getViewPager() != null) {
            this.mTabHostView.getViewPager().setBackground((Drawable) null);
        }
        this.mTabHostView.showOrHideDivider(true);
        this.mTabHostView.setPagerAdapter(this.mFragmentAdapter, 0);
    }

    /* access modifiers changed from: private */
    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(FavorConstants.BUNDLE_KEY_DIR, this.mCurrentDir);
        bundle.putString(FavorConstants.BUNDLE_KEY_DIR_UKEY, this.mOptDir.uKey);
        return bundle;
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        setPageResources();
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            View rightTextView = bdActionBar.getRightTxtView();
            if (rightTextView instanceof TextView) {
                UserAssetsAggrUtils.setImageSrc(this, (TextView) rightTextView, com.baidu.searchbox.userassetsaggr.container.R.drawable.user_assets_action_bar_edit_icon);
            }
        }
    }

    public void setPageResources() {
        super.setPageResources();
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            bdActionBar.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
            View rightTextView = bdActionBar.getRightTxtView();
            if (rightTextView instanceof TextView) {
                UserAssetsAggrUtils.setImageSrc(this, (TextView) rightTextView, com.baidu.searchbox.userassetsaggr.container.R.drawable.user_assets_action_bar_edit_icon);
            }
        }
        if (getEditBdActionBar() != null) {
            getEditBdActionBar().setLeftFirstViewSelector(getResources().getColorStateList(com.baidu.android.common.ui.style.R.color.action_bar_edit_txt_selector));
            getEditBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(com.baidu.android.common.ui.style.R.color.action_bar_edit_txt_selector));
            getEditBdActionBar().setLeftZoneImageSrc(com.baidu.searchbox.userassetsaggr.container.R.drawable.user_assets_item_select_selector);
        }
        if (bdActionBar != null) {
            TextView centerTitle = (TextView) bdActionBar.findViewById(com.baidu.android.common.ui.R.id.title_text_center);
            if (centerTitle != null) {
                centerTitle.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.title_text_color));
            }
            ActionBarExtKt.setShadowBackgroundColor(this, R.color.setting_item_divider_color);
            ActionBarExtKt.setActionBarBackgroundColor(this, getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
        }
        BdPagerTabHost bdPagerTabHost = this.mTabHostView;
        if (bdPagerTabHost != null) {
            bdPagerTabHost.post(new Runnable() {
                public void run() {
                    if (BookmarkDirectoryActivity.this.mTabHostView.getPagerTabBar() != null) {
                        BookmarkDirectoryActivity.this.mTabHostView.getPagerTabBar().setBackground((Drawable) null);
                    }
                    if (BookmarkDirectoryActivity.this.mTabHostView.getViewPager() != null) {
                        BookmarkDirectoryActivity.this.mTabHostView.getViewPager().setBackground((Drawable) null);
                    }
                }
            });
            this.mTabHostView.setDividerBackground(getResources().getColor(com.baidu.searchbox.userassetsaggr.container.R.color.usr_assets_divider_color));
        }
    }

    private void initTitleBar() {
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            bdActionBar.setTitle(this.mCurrentDir);
        }
    }

    public View onCreateContextActionBar() {
        BdActionBar bar = (BdActionBar) super.onCreateContextActionBar();
        bar.setRightTxtZone1OnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BookmarkDirectoryActivity.this.endEdit(false);
                if (!TextUtils.isEmpty(BookmarkDirectoryActivity.this.getFrom())) {
                    BookmarkUBC.buttonClick(BookmarkDirectoryActivity.this.getFrom(), "cancel", BookmarkDirectoryActivity.this.getTabType());
                }
            }
        });
        return bar;
    }

    public AbsListFragment getCurFragment() {
        int pos = this.mTabHostView.getCurrentItem();
        ArrayList<AbsListFragment> arrayList = this.mPageList;
        if (arrayList == null || pos < 0 || pos >= arrayList.size() || this.mPageList.get(pos) == null) {
            return null;
        }
        return this.mPageList.get(pos);
    }

    public void onRenameClicked(View v) {
        AbsListFragment fragment = getCurFragment();
        if (fragment != null) {
            fragment.onRenameClicked();
        }
    }

    public void endEditMode() {
        AbsListFragment fragment = getCurFragment();
        if (fragment != null) {
            fragment.onSelectAll(false);
            endEdit();
            enableEditState();
        }
    }

    public void onMoveClicked(View v) {
        super.onMoveClicked(v);
        AbsListFragment fragment = getCurFragment();
        if (fragment != null) {
            fragment.onMoveClicked();
        }
    }

    public void onSelectedAllClicked(boolean selectedAll) {
        doSelectedAll(selectedAll);
    }

    public void onEditableChanged(boolean isEditable) {
        super.onEditableChanged(isEditable);
        setSelectedCount(0);
        setMoveToEnabled(false);
        setRenameEnabled(false);
        setDeleteEnabled(false);
        AbsListFragment fragment = getCurFragment();
        if (fragment != null) {
            fragment.setEditMode(isEditable);
            setBottomBarVisible(!isEditable);
            if (!TextUtils.isEmpty(getFrom()) && isEditable) {
                BookmarkUBC.buttonClick(getFrom(), "multi_edit", getTabType());
            }
        }
    }

    public void doSelectedAll(boolean selectedAll) {
        AbsListFragment fragment = getCurFragment();
        if (fragment != null) {
            fragment.onSelectAll(selectedAll);
        }
    }

    public void onDeleteClicked(View v) {
        AbsListFragment fragment = getCurFragment();
        if (fragment != null) {
            fragment.onDeletedClicked();
        }
    }

    public void exitActivity() {
        finish();
    }

    public void setPendingAnimation() {
        setNextPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, com.baidu.android.common.ui.style.R.anim.slide_in_from_left, com.baidu.android.common.ui.style.R.anim.slide_out_to_right);
    }

    public void updateAllSelectedBtnState(boolean enable) {
        if (getCurFragment() != null) {
            setAllSelectedBtnState(enable);
        }
    }

    public void updateDeleteBtnState(boolean enable, int count) {
        if (getCurFragment() != null) {
            setDeleteEnabled(enable);
            setSelectedCount(count);
        }
    }

    public void updateRenameBtnState(boolean enable) {
        setRenameEnabled(enable);
    }

    public void updateMoveBtnState(boolean enable) {
        setMoveToEnabled(enable);
    }

    public void updateEditBtnState() {
        enableEditState();
    }

    public void setEditBtnVisibility(boolean enable) {
    }

    public void enterEditMode() {
        beginEdit();
    }

    public void setEditToolBarView() {
    }

    public void setBottomBarVisible(boolean visible) {
        if (!visible) {
            UnifiedBottomBarExtKt.dismissBottomBar(this);
        } else {
            UnifiedBottomBarExtKt.showBottomBar(this);
        }
    }

    public void onBackToTopClick() {
    }

    public void setBackToTopVisible(boolean visible) {
    }

    public boolean isCurrentFragmentVisible(Fragment fragment) {
        return false;
    }

    public void tryShowNewTips() {
    }

    public void enableEditState() {
        BdActionBar bdActionBar;
        View view2;
        AbsListFragment fragment = getCurFragment();
        if (fragment != null && (bdActionBar = ActionBarExtKt.getBdActionBar(this)) != null && (view2 = bdActionBar.getRightTxtView()) != null) {
            UserAssetsAggrUtils.setViewEnable(view2, fragment.getCountExceptSection() > 0);
        }
    }

    public void endEdit() {
        super.endEdit(true);
        enableEditState();
    }

    public String getFrom() {
        return "";
    }

    public String getTabType() {
        return "";
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        BottomBarOptionFloatingBack barOption = new BottomBarOptionFloatingBack();
        barOption.setHideBackWithTopBackExperiment(true);
        return barOption;
    }
}
