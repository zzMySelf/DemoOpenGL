package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroupEx;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PraiseAnimElementBuilderEx implements IPraiseElementBuilder<Map<Integer, List<IAnimatedElement>>> {
    private static final int CACHEDATA_MAX_CONCURRENT_CNT = 2;
    private static String[] sPkgNightTag = {"night_l", "night_m", "night_r"};
    private static String[] sPkgTag = {"day_l", "day_m", "day_r"};
    private Map<String, List<CacheData>> mCacheMap;
    /* access modifiers changed from: private */
    public WeakReference<Drawable.Callback> mDrawableCallback;
    private int mLastCacheDataIndex;
    private ILayoutStrategy.ICallback mLayoutCallback;
    private IPraiseElementBuilder.PreBuildConfig mPreBuildCng;

    private static class CacheData {
        public Map<Integer, List<IAnimatedElement>> elementListMap;
        public Map<Integer, IAnimatedElement> elementSingleMap;

        private CacheData() {
            this.elementSingleMap = new LinkedHashMap();
            this.elementListMap = new LinkedHashMap();
        }
    }

    private PraiseAnimElementBuilderEx() {
        this.mCacheMap = new HashMap();
        this.mLastCacheDataIndex = 0;
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final PraiseAnimElementBuilderEx INSTANCE = new PraiseAnimElementBuilderEx();

        private Holder() {
        }
    }

    public static final PraiseAnimElementBuilderEx getInstance() {
        return Holder.INSTANCE;
    }

    public void preBuild(IPraiseElementBuilder.PreBuildConfig config) {
        this.mPreBuildCng = config;
        if (config != null && config.getResourceProvider() != null) {
            this.mLayoutCallback = new ILayoutStrategy.ICallback() {
                public void init(IAnimatedElement element, int x, int y, int width, int height, IResourceProvider provider, Object... otherParams) {
                    Object[] newArray;
                    Object[] objArr = otherParams;
                    if (element != null && PraiseAnimElementBuilderEx.this.mDrawableCallback != null && PraiseAnimElementBuilderEx.this.mDrawableCallback.get() != null) {
                        if (objArr == null) {
                            newArray = new Object[]{PraiseAnimElementBuilderEx.this.mDrawableCallback.get()};
                        } else {
                            Object[] newArray2 = new Object[(objArr.length + 1)];
                            System.arraycopy(objArr, 0, newArray2, 0, objArr.length);
                            newArray2[newArray2.length - 1] = PraiseAnimElementBuilderEx.this.mDrawableCallback.get();
                            newArray = newArray2;
                        }
                        element.init(x, y, width, height, provider, newArray);
                    }
                }
            };
            String[] targetPkgTag = NightModeHelper.getNightModeSwitcherState() ? sPkgNightTag : sPkgTag;
            this.mCacheMap.clear();
            for (String pkgTag : targetPkgTag) {
                IResourceProvider resourceProvider = this.mPreBuildCng.getResourceProvider();
                if (resourceProvider != null) {
                    resourceProvider.setCurrentPackage(pkgTag);
                }
                List<CacheData> cacheDataList = new ArrayList<>();
                for (int i2 = 0; i2 < 2; i2++) {
                    CacheData cacheData = new CacheData();
                    generateElement(0, cacheData);
                    generateElement(1, cacheData);
                    generateElement(2, cacheData);
                    generateElement(3, cacheData);
                    generateElement(4, cacheData);
                    cacheDataList.add(cacheData);
                }
                this.mCacheMap.put(pkgTag, cacheDataList);
            }
        }
    }

    public IPraiseElementBuilder.PreBuildConfig getPreBuildConfig() {
        return this.mPreBuildCng;
    }

    private void generateElement(int elementType, CacheData cacheData) {
        IAnimatedElement animatedElement;
        switch (elementType) {
            case 0:
                animatedElement = new WaveAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
                break;
            case 1:
                animatedElement = new ShakeAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
                break;
            case 2:
                animatedElement = new PraiseLevelAnimElementEx(BaseAnimatedElement.ScaleType.FIT_XY, this.mPreBuildCng.getResourceProvider());
                break;
            case 3:
                animatedElement = new PraiseNumberAnimElementEx();
                break;
            case 4:
                animatedElement = new EruptionAnimatedGroupEx(BaseAnimatedElement.ScaleType.FIT_XY);
                break;
            default:
                return;
        }
        cacheData.elementSingleMap.put(Integer.valueOf(elementType), animatedElement);
        addToElementListMap(elementType, cacheData);
    }

    private void addToElementListMap(int elementType, CacheData cacheData) {
        IPraiseElementBuilder.PreBuildConfig preBuildConfig = this.mPreBuildCng;
        Map<Integer, Integer> elementCntsMap = preBuildConfig == null ? null : preBuildConfig.getElementCntsMap();
        int counts = (elementCntsMap == null || elementCntsMap.isEmpty() || !elementCntsMap.containsKey(Integer.valueOf(elementType))) ? 0 : elementCntsMap.get(Integer.valueOf(elementType)).intValue();
        List<IAnimatedElement> outList = new ArrayList<>();
        IAnimatedElement animatedElement = cacheData.elementSingleMap.get(Integer.valueOf(elementType));
        if (animatedElement != null) {
            outList.add(animatedElement);
            if (counts <= 1) {
                cacheData.elementListMap.put(Integer.valueOf(elementType), outList);
                return;
            }
            int i2 = 0;
            while (i2 < counts - 1) {
                IAnimatedElement clone = animatedElement.cloneInstance();
                if (clone != null) {
                    outList.add(clone);
                    i2++;
                } else {
                    return;
                }
            }
            cacheData.elementListMap.put(Integer.valueOf(elementType), outList);
        }
    }

    public Map<Integer, List<IAnimatedElement>> getResult(IPraiseElementBuilder.FetchConfig config) {
        List<CacheData> cacheDataList;
        if (config == null || this.mPreBuildCng == null || this.mCacheMap.isEmpty() || (cacheDataList = this.mCacheMap.get(config.getPkgTag())) == null || cacheDataList.isEmpty()) {
            return null;
        }
        CacheData cacheData = cacheDataList.get(this.mLastCacheDataIndex);
        int i2 = this.mLastCacheDataIndex + 1;
        this.mLastCacheDataIndex = i2;
        if (i2 == 2) {
            this.mLastCacheDataIndex = 0;
        }
        this.mDrawableCallback = new WeakReference<>(config.getDrawableCallback());
        ILayoutStrategy layoutStrategy = ILayoutStrategy.Factory.getLayoutStrategy(config.getStrategy(), new Rect(config.getLeft(), config.getTop(), config.getLeft() + config.getWidth(), config.getTop() + config.getHeight()), config.getCanvasWidth(), config.getCanvasHeight(), this.mPreBuildCng.getResourceProvider());
        for (Map.Entry<Integer, List<IAnimatedElement>> entry : cacheData.elementListMap.entrySet()) {
            int elementType = entry.getKey().intValue();
            List<IAnimatedElement> list = entry.getValue();
            layoutStrategy.layout(elementType, cacheData.elementSingleMap, this.mLayoutCallback);
            if (list != null && list.size() > 1) {
                IAnimatedElement target = list.get(0);
                for (int i3 = 1; i3 < list.size(); i3++) {
                    list.get(i3).copyAttribute((BaseAnimatedElement) target);
                }
            }
        }
        return cacheData.elementListMap;
    }
}
