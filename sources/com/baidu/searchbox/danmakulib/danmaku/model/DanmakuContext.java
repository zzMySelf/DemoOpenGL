package com.baidu.searchbox.danmakulib.danmaku.model;

import android.graphics.Typeface;
import com.baidu.searchbox.danmakulib.R;
import com.baidu.searchbox.danmakulib.controller.DanmakuFilters;
import com.baidu.searchbox.danmakulib.danmaku.model.BaseCacheStuffer;
import com.baidu.searchbox.danmakulib.danmaku.model.IDanmakus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DanmakuContext implements Cloneable {
    public static int barrageSettingFontSizeGear = 1;
    private static boolean isDanmakuFontStrokeAndBold = false;
    public static boolean isResponsedSysFontsizeLinkage = true;
    public float baseBarrageSettingAlpha = 1.0f;
    public int currSpeedGear = -1;
    private int mBarrageType = 0;
    private IDanmakus.BaseComparator mBaseComparator;
    private boolean mBlockGuestDanmaku = false;
    private BaseCacheStuffer mCacheStuffer;
    public CachingPolicy mCachingPolicy = CachingPolicy.POLICY_DEFAULT;
    private List<WeakReference<ConfigChangedCallback>> mCallbackList;
    List<Integer> mColorValueWhiteList = new ArrayList();
    public DanmakuFactory mDanmakuFactory = DanmakuFactory.create();
    public DanmakuFilters mDanmakuFilters = new DanmakuFilters();
    public AbsDanmakuSync mDanmakuSync;
    public AbsDisplayer mDisplayer = new AndroidDisplayer();
    private boolean mDuplicateMergingEnable = false;
    public boolean mFBDanmakuVisibility = true;
    public boolean mFTDanmakuVisibility = true;
    List<Integer> mFilterTypes = new ArrayList();
    public Typeface mFont = null;
    public GlobalFlagValues mGlobalFlagValues = new GlobalFlagValues();
    private boolean mIsAlignBottom = false;
    private boolean mIsMaxLinesLimited;
    private boolean mIsPreventOverlappingEnabled;
    public boolean mL2RDanmakuVisibility = true;
    public int mMargin = 0;
    public int mMaximumNumsInScreen = -1;
    public boolean mR2LDanmakuVisibility = true;
    public float mScaleTextSize = 1.0f;
    public float mScrollSpeedFactor = 1.0f;
    public float mScrollSpeedLineFactor = 1.0f;
    public boolean mSpecialDanmakuVisibility = true;
    public int mTransparency = AlphaValue.MAX;
    public byte mUpdateMethod = 2;
    List<String> mUserHashBlackList = new ArrayList();
    List<Integer> mUserIdBlackList = new ArrayList();

    public interface ConfigChangedCallback {
        boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    public static DanmakuContext create() {
        return new DanmakuContext();
    }

    public enum DanmakuConfigTag {
        FT_DANMAKU_VISIBILITY,
        FB_DANMAKU_VISIBILITY,
        L2R_DANMAKU_VISIBILITY,
        R2L_DANMAKU_VISIBILIY,
        SPECIAL_DANMAKU_VISIBILITY,
        TYPEFACE,
        TRANSPARENCY,
        SCALE_TEXTSIZE,
        MAXIMUM_NUMS_IN_SCREEN,
        DANMAKU_STYLE,
        DANMAKU_BOLD,
        COLOR_VALUE_WHITE_LIST,
        USER_ID_BLACK_LIST,
        USER_HASH_BLACK_LIST,
        SCROLL_SPEED_FACTOR,
        BLOCK_GUEST_DANMAKU,
        DUPLICATE_MERGING_ENABLED,
        MAXIMUN_LINES,
        OVERLAPPING_ENABLE,
        ALIGN_BOTTOM,
        DANMAKU_MARGIN,
        DANMAKU_SYNC;

        public boolean isVisibilityRelatedTag() {
            return equals(FT_DANMAKU_VISIBILITY) || equals(FB_DANMAKU_VISIBILITY) || equals(L2R_DANMAKU_VISIBILITY) || equals(R2L_DANMAKU_VISIBILIY) || equals(SPECIAL_DANMAKU_VISIBILITY) || equals(COLOR_VALUE_WHITE_LIST) || equals(USER_ID_BLACK_LIST);
        }
    }

    public IDanmakus.BaseComparator getBaseComparator() {
        return this.mBaseComparator;
    }

    public void setBaseComparator(IDanmakus.BaseComparator baseComparator) {
        this.mBaseComparator = baseComparator;
    }

    public AbsDisplayer getDisplayer() {
        return this.mDisplayer;
    }

    public void setDanmakuType(int barrageType) {
        this.mBarrageType = barrageType;
    }

    public DanmakuContext setTypeface(Typeface font) {
        if (this.mFont != font) {
            this.mFont = font;
            this.mDisplayer.clearTextHeightCache();
            this.mDisplayer.setTypeFace(font);
            notifyConfigureChanged(DanmakuConfigTag.TYPEFACE, new Object[0]);
        }
        return this;
    }

    public DanmakuContext setDanmakuTransparency(float p) {
        int newTransparency = (int) (((float) AlphaValue.MAX) * p);
        if (newTransparency != this.mTransparency) {
            this.mTransparency = newTransparency;
            this.mDisplayer.setTransparency(newTransparency);
            notifyConfigureChanged(DanmakuConfigTag.TRANSPARENCY, Float.valueOf(p));
        }
        return this;
    }

    public DanmakuContext updateFontSize(int fontSizeGear, float radio) {
        isResponsedSysFontsizeLinkage = false;
        barrageSettingFontSizeGear = fontSizeGear;
        this.mDisplayer.clearTextHeightCache();
        this.mGlobalFlagValues.updateMeasureFlag();
        this.mGlobalFlagValues.updateVisibleFlag();
        notifyConfigureChanged(DanmakuConfigTag.SCALE_TEXTSIZE, Float.valueOf(radio));
        return this;
    }

    public DanmakuContext setScaleTextSize(float p) {
        if (this.mScaleTextSize != p) {
            this.mScaleTextSize = p;
            this.mDisplayer.clearTextHeightCache();
            this.mDisplayer.setScaleTextSizeFactor(p);
            this.mGlobalFlagValues.updateMeasureFlag();
            this.mGlobalFlagValues.updateVisibleFlag();
            notifyConfigureChanged(DanmakuConfigTag.SCALE_TEXTSIZE, Float.valueOf(p));
        }
        return this;
    }

    public DanmakuContext setDanmakuMargin(int m) {
        if (this.mMargin != m) {
            this.mMargin = m;
            this.mDisplayer.setMargin(m);
            this.mGlobalFlagValues.updateFilterFlag();
            this.mGlobalFlagValues.updateVisibleFlag();
            notifyConfigureChanged(DanmakuConfigTag.DANMAKU_MARGIN, Integer.valueOf(m));
        }
        return this;
    }

    public DanmakuContext setMarginTop(int m) {
        this.mDisplayer.setAllMarginTop(m);
        return this;
    }

    public boolean getFTDanmakuVisibility() {
        return this.mFTDanmakuVisibility;
    }

    public DanmakuContext setFTDanmakuVisibility(boolean visible) {
        setDanmakuVisible(visible, 5);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.mFTDanmakuVisibility != visible) {
            this.mFTDanmakuVisibility = visible;
            notifyConfigureChanged(DanmakuConfigTag.FT_DANMAKU_VISIBILITY, Boolean.valueOf(visible));
        }
        return this;
    }

    private <T> void setFilterData(String tag, T data) {
        setFilterData(tag, data, true);
    }

    private <T> void setFilterData(String tag, T data, boolean primary) {
        this.mDanmakuFilters.get(tag, primary).setData(data);
    }

    private void setDanmakuVisible(boolean visible, int type) {
        if (visible) {
            this.mFilterTypes.remove(Integer.valueOf(type));
        } else if (!this.mFilterTypes.contains(Integer.valueOf(type))) {
            this.mFilterTypes.add(Integer.valueOf(type));
        }
    }

    public boolean getFBDanmakuVisibility() {
        return this.mFBDanmakuVisibility;
    }

    public DanmakuContext setFBDanmakuVisibility(boolean visible) {
        setDanmakuVisible(visible, 4);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.mFBDanmakuVisibility != visible) {
            this.mFBDanmakuVisibility = visible;
            notifyConfigureChanged(DanmakuConfigTag.FB_DANMAKU_VISIBILITY, Boolean.valueOf(visible));
        }
        return this;
    }

    public boolean getL2RDanmakuVisibility() {
        return this.mL2RDanmakuVisibility;
    }

    public DanmakuContext setL2RDanmakuVisibility(boolean visible) {
        setDanmakuVisible(visible, 6);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.mL2RDanmakuVisibility != visible) {
            this.mL2RDanmakuVisibility = visible;
            notifyConfigureChanged(DanmakuConfigTag.L2R_DANMAKU_VISIBILITY, Boolean.valueOf(visible));
        }
        return this;
    }

    public boolean getR2LDanmakuVisibility() {
        return this.mR2LDanmakuVisibility;
    }

    public DanmakuContext setR2LDanmakuVisibility(boolean visible) {
        setDanmakuVisible(visible, 1);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.mR2LDanmakuVisibility != visible) {
            this.mR2LDanmakuVisibility = visible;
            notifyConfigureChanged(DanmakuConfigTag.R2L_DANMAKU_VISIBILIY, Boolean.valueOf(visible));
        }
        return this;
    }

    public boolean getSpecialDanmakuVisibility() {
        return this.mSpecialDanmakuVisibility;
    }

    public DanmakuContext setSpecialDanmakuVisibility(boolean visible) {
        setDanmakuVisible(visible, 7);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.mSpecialDanmakuVisibility != visible) {
            this.mSpecialDanmakuVisibility = visible;
            notifyConfigureChanged(DanmakuConfigTag.SPECIAL_DANMAKU_VISIBILITY, Boolean.valueOf(visible));
        }
        return this;
    }

    public DanmakuContext setMaximumVisibleSizeInScreen(int maxSize) {
        this.mMaximumNumsInScreen = maxSize;
        if (maxSize == 0) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_QUANTITY_DANMAKU_FILTER);
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_ELAPSED_TIME_FILTER);
            notifyConfigureChanged(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(maxSize));
            return this;
        } else if (maxSize == -1) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_QUANTITY_DANMAKU_FILTER);
            this.mDanmakuFilters.registerFilter(DanmakuFilters.TAG_ELAPSED_TIME_FILTER);
            notifyConfigureChanged(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(maxSize));
            return this;
        } else {
            setFilterData(DanmakuFilters.TAG_QUANTITY_DANMAKU_FILTER, Integer.valueOf(maxSize));
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(maxSize));
            return this;
        }
    }

    public DanmakuContext setDanmakuStyle(int style, float... values) {
        this.mDisplayer.setDanmakuStyle(style, values);
        notifyConfigureChanged(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(style), values);
        return this;
    }

    public DanmakuContext setDanmakuBold(boolean bold) {
        this.mDisplayer.setFakeBoldText(bold);
        notifyConfigureChanged(DanmakuConfigTag.DANMAKU_BOLD, Boolean.valueOf(bold));
        return this;
    }

    public DanmakuContext setColorValueWhiteList(Integer... colors) {
        this.mColorValueWhiteList.clear();
        if (colors == null || colors.length == 0) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_TEXT_COLOR_DANMAKU_FILTER);
        } else {
            Collections.addAll(this.mColorValueWhiteList, colors);
            setFilterData(DanmakuFilters.TAG_TEXT_COLOR_DANMAKU_FILTER, this.mColorValueWhiteList);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.COLOR_VALUE_WHITE_LIST, this.mColorValueWhiteList);
        return this;
    }

    public List<Integer> getColorValueWhiteList() {
        return this.mColorValueWhiteList;
    }

    public DanmakuContext setUserHashBlackList(String... hashes) {
        this.mUserHashBlackList.clear();
        if (hashes == null || hashes.length == 0) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_USER_HASH_FILTER);
        } else {
            Collections.addAll(this.mUserHashBlackList, hashes);
            setFilterData(DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        return this;
    }

    public DanmakuContext removeUserHashBlackList(String... hashes) {
        if (hashes == null || hashes.length == 0) {
            return this;
        }
        for (String hash : hashes) {
            this.mUserHashBlackList.remove(hash);
        }
        setFilterData(DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        return this;
    }

    public DanmakuContext addUserHashBlackList(String... hashes) {
        if (hashes == null || hashes.length == 0) {
            return this;
        }
        Collections.addAll(this.mUserHashBlackList, hashes);
        setFilterData(DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        return this;
    }

    public List<String> getUserHashBlackList() {
        return this.mUserHashBlackList;
    }

    public DanmakuContext setUserIdBlackList(Integer... ids) {
        this.mUserIdBlackList.clear();
        if (ids == null || ids.length == 0) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_USER_ID_FILTER);
        } else {
            Collections.addAll(this.mUserIdBlackList, ids);
            setFilterData(DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        return this;
    }

    public DanmakuContext removeUserIdBlackList(Integer... ids) {
        if (ids == null || ids.length == 0) {
            return this;
        }
        for (Integer id : ids) {
            this.mUserIdBlackList.remove(id);
        }
        setFilterData(DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        return this;
    }

    public DanmakuContext addUserIdBlackList(Integer... ids) {
        if (ids == null || ids.length == 0) {
            return this;
        }
        Collections.addAll(this.mUserIdBlackList, ids);
        setFilterData(DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        return this;
    }

    public List<Integer> getUserIdBlackList() {
        return this.mUserIdBlackList;
    }

    public DanmakuContext blockGuestDanmaku(boolean block) {
        if (this.mBlockGuestDanmaku != block) {
            this.mBlockGuestDanmaku = block;
            if (block) {
                setFilterData(DanmakuFilters.TAG_GUEST_FILTER, Boolean.valueOf(block));
            } else {
                this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_GUEST_FILTER);
            }
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.BLOCK_GUEST_DANMAKU, Boolean.valueOf(block));
        }
        return this;
    }

    public DanmakuContext setScrollSpeedFactor(float p) {
        if (this.mScrollSpeedFactor != p) {
            this.mScrollSpeedFactor = p;
            this.mDanmakuFactory.updateDurationFactor(p);
            this.mGlobalFlagValues.updateMeasureFlag();
            this.mGlobalFlagValues.updateVisibleFlag();
            notifyConfigureChanged(DanmakuConfigTag.SCROLL_SPEED_FACTOR, Float.valueOf(p));
        }
        return this;
    }

    public DanmakuContext setScrollSpeedLineFactor(float p) {
        if (this.mScrollSpeedLineFactor != p) {
            this.mScrollSpeedLineFactor = p;
            this.mDanmakuFactory.updateLineFactor(p);
            this.mGlobalFlagValues.updateMeasureFlag();
            this.mGlobalFlagValues.updateVisibleFlag();
            notifyConfigureChanged(DanmakuConfigTag.SCROLL_SPEED_FACTOR, Float.valueOf(p));
        }
        return this;
    }

    public DanmakuContext setDuplicateMergingEnabled(boolean enable) {
        if (this.mDuplicateMergingEnable != enable) {
            this.mDuplicateMergingEnable = enable;
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(enable));
        }
        return this;
    }

    public boolean isDuplicateMergingEnabled() {
        return this.mDuplicateMergingEnable;
    }

    public DanmakuContext alignBottom(boolean enable) {
        if (this.mIsAlignBottom != enable) {
            this.mIsAlignBottom = enable;
            notifyConfigureChanged(DanmakuConfigTag.ALIGN_BOTTOM, Boolean.valueOf(enable));
            this.mGlobalFlagValues.updateVisibleFlag();
        }
        return this;
    }

    public boolean isAlignBottom() {
        return this.mIsAlignBottom;
    }

    public DanmakuContext setMaximumLines(Map<Integer, Integer> pairs) {
        this.mIsMaxLinesLimited = pairs != null;
        if (pairs == null) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_MAXIMUN_LINES_FILTER, false);
        } else {
            setFilterData(DanmakuFilters.TAG_MAXIMUN_LINES_FILTER, pairs, false);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.MAXIMUN_LINES, pairs);
        return this;
    }

    @Deprecated
    public DanmakuContext setOverlapping(Map<Integer, Boolean> pairs) {
        return preventOverlapping(pairs);
    }

    public DanmakuContext preventOverlapping(Map<Integer, Boolean> pairs) {
        this.mIsPreventOverlappingEnabled = pairs != null;
        if (pairs == null) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_OVERLAPPING_FILTER, false);
        } else {
            setFilterData(DanmakuFilters.TAG_OVERLAPPING_FILTER, pairs, false);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.OVERLAPPING_ENABLE, pairs);
        return this;
    }

    public boolean isMaxLinesLimited() {
        return this.mIsMaxLinesLimited;
    }

    public boolean isPreventOverlappingEnabled() {
        return this.mIsPreventOverlappingEnabled;
    }

    public DanmakuContext setCacheStuffer(BaseCacheStuffer cacheStuffer, BaseCacheStuffer.Proxy cacheStufferAdapter) {
        this.mCacheStuffer = cacheStuffer;
        if (cacheStuffer != null) {
            cacheStuffer.setProxy(cacheStufferAdapter);
            this.mDisplayer.setCacheStuffer(this.mCacheStuffer);
        }
        return this;
    }

    public BaseCacheStuffer getCacheStuffer() {
        return this.mDisplayer.getCacheStuffer();
    }

    public DanmakuContext setDanmakuSync(AbsDanmakuSync danmakuSync) {
        this.mDanmakuSync = danmakuSync;
        return this;
    }

    public DanmakuContext setCachingPolicy(CachingPolicy cachingPolicy) {
        this.mCachingPolicy = cachingPolicy;
        return this;
    }

    public static boolean isFontStrokeAndBold() {
        return isDanmakuFontStrokeAndBold;
    }

    public static void setFontStrokeAndBold(boolean isFontStrokeAndBold) {
        isDanmakuFontStrokeAndBold = isFontStrokeAndBold;
    }

    public static int getPraisedDrawableRes() {
        return R.drawable.bd_danmaku_search_praised_stroke;
    }

    public static int getUnpraisedDrawableRes() {
        return R.drawable.bd_danmaku_search_unpraised_stroke;
    }

    public void registerConfigChangedCallback(ConfigChangedCallback listener) {
        if (listener != null) {
            if (this.mCallbackList == null) {
                this.mCallbackList = Collections.synchronizedList(new ArrayList());
            }
            for (WeakReference<ConfigChangedCallback> configReferer : this.mCallbackList) {
                if (listener.equals(configReferer.get())) {
                    return;
                }
            }
            List<WeakReference<ConfigChangedCallback>> list = this.mCallbackList;
            if (list != null) {
                list.add(new WeakReference(listener));
            }
        }
    }

    public void unregisterConfigChangedCallback(ConfigChangedCallback listener) {
        List<WeakReference<ConfigChangedCallback>> list;
        if (listener != null && (list = this.mCallbackList) != null) {
            for (WeakReference<ConfigChangedCallback> configReferer : list) {
                if (listener.equals(configReferer.get())) {
                    this.mCallbackList.remove(configReferer);
                    return;
                }
            }
        }
    }

    public void unregisterAllConfigChangedCallbacks() {
        List<WeakReference<ConfigChangedCallback>> list = this.mCallbackList;
        if (list != null) {
            list.clear();
            this.mCallbackList = null;
        }
    }

    private void notifyConfigureChanged(DanmakuConfigTag tag, Object... values) {
        List<WeakReference<ConfigChangedCallback>> list = this.mCallbackList;
        if (list != null) {
            for (WeakReference<ConfigChangedCallback> configReferer : list) {
                ConfigChangedCallback cb = (ConfigChangedCallback) configReferer.get();
                if (cb != null) {
                    cb.onDanmakuConfigChanged(this, tag, values);
                }
            }
        }
    }

    public DanmakuContext registerFilter(DanmakuFilters.BaseDanmakuFilter filter) {
        this.mDanmakuFilters.registerFilter(filter);
        this.mGlobalFlagValues.updateFilterFlag();
        return this;
    }

    public DanmakuContext unregisterFilter(DanmakuFilters.BaseDanmakuFilter filter) {
        this.mDanmakuFilters.unregisterFilter(filter);
        this.mGlobalFlagValues.updateFilterFlag();
        return this;
    }

    public DanmakuContext resetContext() {
        this.mDisplayer = new AndroidDisplayer();
        this.mGlobalFlagValues = new GlobalFlagValues();
        this.mDanmakuFilters.clear();
        this.mDanmakuFactory = DanmakuFactory.create();
        return this;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
