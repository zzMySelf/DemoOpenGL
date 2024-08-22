package com.baidu.searchbox.bigimage.stat.helper;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.bigimage.comp.page.image.tab.TabType;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.runtime.BigImageRuntime;
import com.baidu.searchbox.bigimage.utils.BigImageTcUtilsKt;
import com.google.android.material.appbar.AppBarLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0002\u0015\u0018\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001c\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/bigimage/stat/helper/PageHeightStatHelper;", "", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "recyclerViews", "", "Landroidx/recyclerview/widget/RecyclerView;", "(Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;Lcom/google/android/material/appbar/AppBarLayout;Landroidx/viewpager/widget/ViewPager;Ljava/util/List;)V", "currTab", "Lcom/baidu/searchbox/bigimage/comp/page/image/tab/TabType;", "getCurrTab", "()Lcom/baidu/searchbox/bigimage/comp/page/image/tab/TabType;", "setCurrTab", "(Lcom/baidu/searchbox/bigimage/comp/page/image/tab/TabType;)V", "onOffsetChangedListener", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "onPageChangeListener", "com/baidu/searchbox/bigimage/stat/helper/PageHeightStatHelper$onPageChangeListener$1", "Lcom/baidu/searchbox/bigimage/stat/helper/PageHeightStatHelper$onPageChangeListener$1;", "onScrollListener", "com/baidu/searchbox/bigimage/stat/helper/PageHeightStatHelper$onScrollListener$1", "Lcom/baidu/searchbox/bigimage/stat/helper/PageHeightStatHelper$onScrollListener$1;", "pageNumCache", "", "", "screenHeight", "getCurrPageNum", "onDestroy", "", "setCurrPageNum", "pageNum", "updateTabTypeByPos", "pos", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageHeightStatHelper.kt */
public final class PageHeightStatHelper {
    /* access modifiers changed from: private */
    public final AppBarLayout appBarLayout;
    private TabType currTab = TabType.ALL;
    private final AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private final PageHeightStatHelper$onPageChangeListener$1 onPageChangeListener;
    private final PageHeightStatHelper$onScrollListener$1 onScrollListener;
    private final Map<TabType, Integer> pageNumCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final ImagePageParams params;
    /* access modifiers changed from: private */
    public final int screenHeight = DeviceUtils.ScreenInfo.getRealScreenHeight(BigImageRuntime.getAppContext());

    public PageHeightStatHelper(ImagePageParams params2, AppBarLayout appBarLayout2, ViewPager viewPager, List<? extends RecyclerView> recyclerViews) {
        Intrinsics.checkNotNullParameter(params2, "params");
        Intrinsics.checkNotNullParameter(appBarLayout2, "appBarLayout");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(recyclerViews, "recyclerViews");
        this.params = params2;
        this.appBarLayout = appBarLayout2;
        PageHeightStatHelper$$ExternalSyntheticLambda1 pageHeightStatHelper$$ExternalSyntheticLambda1 = new PageHeightStatHelper$$ExternalSyntheticLambda1(this);
        this.onOffsetChangedListener = pageHeightStatHelper$$ExternalSyntheticLambda1;
        PageHeightStatHelper$onPageChangeListener$1 pageHeightStatHelper$onPageChangeListener$1 = new PageHeightStatHelper$onPageChangeListener$1(this);
        this.onPageChangeListener = pageHeightStatHelper$onPageChangeListener$1;
        this.onScrollListener = new PageHeightStatHelper$onScrollListener$1(this);
        appBarLayout2.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) pageHeightStatHelper$$ExternalSyntheticLambda1);
        PagerAdapter adapter = viewPager.getAdapter();
        if ((adapter != null ? adapter.getCount() : 0) > 1) {
            viewPager.addOnPageChangeListener(pageHeightStatHelper$onPageChangeListener$1);
        } else {
            this.currTab = null;
        }
        for (RecyclerView it : recyclerViews) {
            it.addOnScrollListener(this.onScrollListener);
        }
    }

    public final TabType getCurrTab() {
        return this.currTab;
    }

    public final void setCurrTab(TabType tabType) {
        this.currTab = tabType;
    }

    /* access modifiers changed from: private */
    /* renamed from: onOffsetChangedListener$lambda-0  reason: not valid java name */
    public static final void m16568onOffsetChangedListener$lambda0(PageHeightStatHelper this$0, AppBarLayout layout, int offset) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currTab == TabType.ALL || this$0.currTab == null) {
            int pageNum = this$0.getCurrPageNum();
            if (layout.getTotalScrollRange() > this$0.screenHeight && Math.abs(offset) > this$0.screenHeight * pageNum) {
                BigImageTcUtilsKt.bigImagePageHeightEvent(this$0.params.getExtraParams(), this$0.params.getImageInfo(), this$0.params.isFromRelated(), pageNum, this$0.currTab);
                this$0.setCurrPageNum(pageNum + 1);
            }
        }
    }

    /* access modifiers changed from: private */
    public final int getCurrPageNum() {
        int answer$iv;
        Map $this$getOrPut$iv = this.pageNumCache;
        Object key$iv = this.currTab;
        Object value$iv = $this$getOrPut$iv.get(key$iv);
        if (value$iv == null) {
            answer$iv = 1;
            $this$getOrPut$iv.put(key$iv, 1);
        } else {
            answer$iv = value$iv;
        }
        return ((Number) answer$iv).intValue();
    }

    /* access modifiers changed from: private */
    public final void setCurrPageNum(int pageNum) {
        this.pageNumCache.put(this.currTab, Integer.valueOf(pageNum));
    }

    /* access modifiers changed from: private */
    public final void updateTabTypeByPos(int pos) {
        TabType tabType;
        switch (pos) {
            case 0:
                tabType = TabType.ALL;
                break;
            case 1:
                tabType = TabType.GOODS;
                break;
            case 2:
                tabType = TabType.IMAGES;
                break;
            default:
                tabType = null;
                break;
        }
        this.currTab = tabType;
    }

    public final void onDestroy() {
        this.appBarLayout.post(new PageHeightStatHelper$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onDestroy$lambda-3  reason: not valid java name */
    public static final void m16567onDestroy$lambda3(PageHeightStatHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.appBarLayout.removeOnOffsetChangedListener(this$0.onOffsetChangedListener);
    }
}
