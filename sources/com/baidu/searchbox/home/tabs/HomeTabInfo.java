package com.baidu.searchbox.home.tabs;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;

public class HomeTabInfo {
    private static final String TAG = "HomeTabInfo";
    private Bundle args;
    private boolean isMixStyle = false;
    private boolean mChecked = false;
    private int mCheckedColorId;
    private int mCheckedColorIdMix;
    private OnTabClickListener mExtTabClickListener;
    private Class<? extends Fragment> mFragmentClass;
    private int mNewCheckedColor;
    private int mNewCheckedNightColor;
    private int mNewNormalColor;
    private int mNewNormalNightColor;
    private Drawable mNewTabDefaultDayDrawable;
    private Drawable mNewTabDefaultNightDrawable;
    private Drawable mNewTabSelectedDayDrawable;
    private Drawable mNewTabSelectedNightDrawable;
    private boolean mNewTabbarStatus = false;
    private int mNormalColorId;
    private int mNormalColorIdMix;
    private boolean mOnlyIconStyle = false;
    private int mPureTextTabCheckedColorId;
    private int mPureTextTabCheckedColorIdMix;
    private int mPureTextTabNormalColorId;
    private int mPureTextTabNormalColorIdMix;
    private boolean mSupportBadge = true;
    private boolean mSupportLoading = false;
    private int mTabBackground;
    private OnTabChangeListener mTabChangeListener;
    private View.OnClickListener mTabClickListener;
    private int mTabDrawable;
    private int mTabDrawableMix;
    private TabItemViewLifeCycleListener mTabItemViewLifeCycleListener;
    private int mTabSelectedDrawable;
    private int mTabSelectedDrawableMix;
    private String mTabSource;
    private String mTag;
    private String mText;
    private ColorStateList mTextColorList;

    public interface OnTabChangeListener {
        void onTabChangeToThis();
    }

    public interface OnTabClickListener {
        TabClickResult onTabClick(BaseTabItemView baseTabItemView, String str);
    }

    public interface TabItemViewLifeCycleListener {
        void onAttachedToWindow(BaseTabItemView baseTabItemView);

        void onDetachedFromWindow(BaseTabItemView baseTabItemView);
    }

    public HomeTabInfo setText(String text) {
        this.mText = text;
        return this;
    }

    public HomeTabInfo setTextColor(int normal, int pressed, int selected, int focused) {
        int[][] states = {new int[]{16842908}, new int[]{16842919}, new int[]{16842913}, new int[0]};
        this.mTextColorList = new ColorStateList(states, new int[]{focused, pressed, selected, normal});
        return this;
    }

    public HomeTabInfo setTextColor(ColorStateList colorList) {
        this.mTextColorList = colorList;
        return this;
    }

    public HomeTabInfo setTabDrawable(int resId) {
        this.mTabDrawable = resId;
        return this;
    }

    public HomeTabInfo setTabSelectedDrawable(int resId) {
        this.mTabSelectedDrawable = resId;
        return this;
    }

    public HomeTabInfo setTabDrawableMix(int resId) {
        this.mTabDrawableMix = resId;
        return this;
    }

    public HomeTabInfo setTabSelectedDrawableMix(int resId) {
        this.mTabSelectedDrawableMix = resId;
        return this;
    }

    public HomeTabInfo setTabBackground(int drawable) {
        this.mTabBackground = drawable;
        return this;
    }

    public HomeTabInfo setTag(String tag) {
        this.mTag = tag;
        return this;
    }

    public HomeTabInfo setChecked(boolean checked) {
        this.mChecked = checked;
        return this;
    }

    public HomeTabInfo setSupportBadge(boolean supportBadge) {
        this.mSupportBadge = supportBadge;
        return this;
    }

    public boolean isSupportBadge() {
        return this.mSupportBadge;
    }

    public HomeTabInfo setSupportLoading(boolean supportLoading) {
        this.mSupportLoading = supportLoading;
        return this;
    }

    public boolean isSupportLoading() {
        return this.mSupportLoading;
    }

    public String getText() {
        return this.mText;
    }

    public ColorStateList getTextColor() {
        return this.mTextColorList;
    }

    public int getTabDrawable() {
        return this.mTabDrawable;
    }

    public int getTabSelectedDrawable() {
        return this.mTabSelectedDrawable;
    }

    public int getTabDrawableMix() {
        return this.mTabDrawableMix;
    }

    public int getTabSelectedDrawableMix() {
        return this.mTabSelectedDrawableMix;
    }

    public int getTabBackground() {
        return this.mTabBackground;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getNormalColor() {
        return this.mNormalColorId;
    }

    public HomeTabInfo setNormalColor(int normalColor) {
        this.mNormalColorId = normalColor;
        return this;
    }

    public int getCheckedColor() {
        return this.mCheckedColorId;
    }

    public HomeTabInfo setCheckedColor(int pressColor) {
        this.mCheckedColorId = pressColor;
        return this;
    }

    public int getPureTextTabNormalColor() {
        return this.mPureTextTabNormalColorId;
    }

    public HomeTabInfo setPureTextTabNormalColor(int normalColor) {
        this.mPureTextTabNormalColorId = normalColor;
        return this;
    }

    public int getPureTextTabCheckedColor() {
        return this.mPureTextTabCheckedColorId;
    }

    public HomeTabInfo setPureTextTabCheckedColor(int pressColor) {
        this.mPureTextTabCheckedColorId = pressColor;
        return this;
    }

    public HomeTabInfo setPureTextTabNormalColorMix(int pressColor) {
        this.mPureTextTabNormalColorIdMix = pressColor;
        return this;
    }

    public int getPureTextTabNormalColorMix() {
        return this.mPureTextTabNormalColorIdMix;
    }

    public HomeTabInfo setPureTextTabCheckedColorMix(int pressColor) {
        this.mPureTextTabCheckedColorIdMix = pressColor;
        return this;
    }

    public int getPureTextTabCheckedColorMix() {
        return this.mPureTextTabCheckedColorIdMix;
    }

    public boolean isOnlyIconStyle() {
        return this.mOnlyIconStyle;
    }

    public HomeTabInfo setOnlyIconStyle(boolean onlyIconStyle) {
        this.mOnlyIconStyle = onlyIconStyle;
        return this;
    }

    public int getNormalColorMix() {
        return this.mNormalColorIdMix;
    }

    public HomeTabInfo setNormalColorMix(int mNormalColorIdMix2) {
        this.mNormalColorIdMix = mNormalColorIdMix2;
        return this;
    }

    public int getCheckedColorMix() {
        return this.mCheckedColorIdMix;
    }

    public HomeTabInfo setCheckedColorMix(int mCheckedColorIdMix2) {
        this.mCheckedColorIdMix = mCheckedColorIdMix2;
        return this;
    }

    public int getNewNormalColor() {
        return this.mNewNormalColor;
    }

    public HomeTabInfo setNewNormalColor(int newNormalColor) {
        this.mNewNormalColor = newNormalColor;
        return this;
    }

    public int getNewCheckedColor() {
        return this.mNewCheckedColor;
    }

    public HomeTabInfo setNewCheckedColor(int newCheckedColor) {
        this.mNewCheckedColor = newCheckedColor;
        return this;
    }

    public int getNewNormalNightColor() {
        return this.mNewNormalNightColor;
    }

    public HomeTabInfo setNewNormalNightColor(int newNormalNightColor) {
        this.mNewNormalNightColor = newNormalNightColor;
        return this;
    }

    public int getNewCheckedNightColor() {
        return this.mNewCheckedNightColor;
    }

    public HomeTabInfo setNewCheckedNightColor(int newCheckedNightColor) {
        this.mNewCheckedNightColor = newCheckedNightColor;
        return this;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public boolean getNewTabbarStatus() {
        if (isVideoTabSelected()) {
            return false;
        }
        return this.mNewTabbarStatus;
    }

    public boolean getRawNewTabbarStatus() {
        return this.mNewTabbarStatus;
    }

    public HomeTabInfo setNewTabbarStatus(boolean status) {
        this.mNewTabbarStatus = status;
        return this;
    }

    public Drawable getNewTabDefaultDayDrawable() {
        return this.mNewTabDefaultDayDrawable;
    }

    public HomeTabInfo setNewTabDefaultDayDrawable(Drawable newTabDefaultDayDrawable) {
        this.mNewTabDefaultDayDrawable = newTabDefaultDayDrawable;
        return this;
    }

    public Drawable getNewTabSelectedDayDrawable() {
        return this.mNewTabSelectedDayDrawable;
    }

    public HomeTabInfo setNewTabSelectedDayDrawable(Drawable newTabSelectedDayDrawable) {
        this.mNewTabSelectedDayDrawable = newTabSelectedDayDrawable;
        return this;
    }

    public Drawable getNewTabDefaultNightDrawable() {
        return this.mNewTabDefaultNightDrawable;
    }

    public HomeTabInfo setNewTabDefaultNightDrawable(Drawable newTabDefaultNightDrawable) {
        this.mNewTabDefaultNightDrawable = newTabDefaultNightDrawable;
        return this;
    }

    public Drawable getNewTabSelectedNightDrawable() {
        return this.mNewTabSelectedNightDrawable;
    }

    public HomeTabInfo setNewTabSelectedNightDrawable(Drawable newTabSelectedNightDrawable) {
        this.mNewTabSelectedNightDrawable = newTabSelectedNightDrawable;
        return this;
    }

    public HomeTabInfo setFragment(Class<? extends Fragment> fragmentClass) {
        this.mFragmentClass = fragmentClass;
        return this;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return this.mFragmentClass;
    }

    public void setTabClickListener(View.OnClickListener tabClickListener) {
        this.mTabClickListener = tabClickListener;
    }

    public View.OnClickListener getTabClickListener() {
        return this.mTabClickListener;
    }

    public String getTabSource() {
        return this.mTabSource;
    }

    public HomeTabInfo setTabSource(String mTabSource2) {
        this.mTabSource = mTabSource2;
        return this;
    }

    public OnTabChangeListener getTabChangeListener() {
        return this.mTabChangeListener;
    }

    public HomeTabInfo setTabChangeListener(OnTabChangeListener tabChangeListener) {
        this.mTabChangeListener = tabChangeListener;
        return this;
    }

    public OnTabClickListener getExtTabClickListener() {
        return this.mExtTabClickListener;
    }

    public HomeTabInfo setExtTabClickListener(OnTabClickListener onTabClickListener) {
        this.mExtTabClickListener = onTabClickListener;
        return this;
    }

    public TabItemViewLifeCycleListener getTabItemViewLifeCycleListener() {
        return this.mTabItemViewLifeCycleListener;
    }

    public HomeTabInfo setTabItemViewLifeCycleListener(TabItemViewLifeCycleListener tabItemViewLifeCycleListener) {
        this.mTabItemViewLifeCycleListener = tabItemViewLifeCycleListener;
        return this;
    }

    public boolean isMixStyle() {
        return this.isMixStyle;
    }

    public void setMixStyle(boolean mixStyle) {
        this.isMixStyle = mixStyle;
    }

    public Bundle getArgs() {
        return this.args;
    }

    public HomeTabInfo setArgs(Bundle args2) {
        this.args = args2;
        return this;
    }

    private boolean isVideoTabSelected() {
        return TextUtils.equals("Video", ((IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE)).getCurrentTabTagNew());
    }

    public static class TabClickResult {
        public final boolean doCommonProcess;
        public final String extraTag;

        public TabClickResult(boolean doCommonProcess2, String extraTag2) {
            this.doCommonProcess = doCommonProcess2;
            this.extraTag = extraTag2;
        }
    }
}
