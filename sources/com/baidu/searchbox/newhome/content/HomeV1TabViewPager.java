package com.baidu.searchbox.newhome.content;

import android.content.Context;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.kmm.home.abtest.HomeABTestMgr;
import com.baidu.searchbox.launch.restore.ioc.SystemKillManagerRuntime;
import com.baidu.searchbox.newhome.content.fragment.HomeContentItemFragment;
import com.baidu.searchbox.newhome.content.fragment.inter.HomeFeedContentFragment;
import com.baidu.searchbox.newhome.content.tips.HomeViewToolsKt;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/newhome/content/HomeV1TabViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mState", "", "<set-?>", "Lcom/baidu/searchbox/newhome/content/PageRestoreState;", "pageRestoreState", "getPageRestoreState", "()Lcom/baidu/searchbox/newhome/content/PageRestoreState;", "isAllowSwipe", "", "isScrollStateTop", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onRestoreInstanceState", "", "state", "Landroid/os/Parcelable;", "onTouchEvent", "ev", "setState", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeV1TabViewPager.kt */
public final class HomeV1TabViewPager extends ViewPager {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int mState;
    private PageRestoreState pageRestoreState;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeV1TabViewPager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final PageRestoreState getPageRestoreState() {
        return this.pageRestoreState;
    }

    private final boolean isAllowSwipe() {
        return HomeABTestMgr.isLv1TabSlidable();
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!isAllowSwipe() || !isScrollStateTop()) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(event);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (!isAllowSwipe() || !isScrollStateTop()) {
            return false;
        }
        try {
            return super.onTouchEvent(ev);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void setState(int state) {
        this.mState = state;
    }

    private final boolean isScrollStateTop() {
        if (this.mState != 0) {
            return true;
        }
        INewHomeApi mNewHomeApi = HomeViewToolsKt.getMNewHomeApi();
        boolean z = false;
        if (mNewHomeApi != null && mNewHomeApi.getNewHomeScrollState() == 1) {
            z = true;
        }
        return !z;
    }

    public void onRestoreInstanceState(Parcelable state) {
        int currentItemTemp = getCurrentItem();
        boolean isColdRestore = SystemKillManagerRuntime.INSTANCE.getSystemKillManager().shouldResetNewHomeViewPager();
        this.pageRestoreState = new PageRestoreState(1, isColdRestore ? 2 : 0);
        super.onRestoreInstanceState(state);
        if (isColdRestore) {
            int restoreItemTemp = getCurrentItem();
            if (restoreItemTemp != currentItemTemp && (getAdapter() instanceof HomeV1TabVPAdapter)) {
                PagerAdapter adapter = getAdapter();
                if (adapter != null) {
                    Fragment it = ((HomeV1TabVPAdapter) adapter).getFragmentByPosition(restoreItemTemp);
                    if (it != null && (it instanceof HomeContentItemFragment)) {
                        ((HomeContentItemFragment) it).superSetUserVisibleHint(true);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.newhome.content.HomeV1TabVPAdapter");
                }
            }
            if (getAdapter() instanceof HomeV1TabVPAdapter) {
                PagerAdapter adapter2 = getAdapter();
                if (adapter2 != null) {
                    Fragment fragment = ((HomeV1TabVPAdapter) adapter2).getFragmentByPosition(currentItemTemp);
                    if (fragment instanceof HomeFeedContentFragment) {
                        int defaultIndex = TabController.INSTANCE.getDefaultTabPos();
                        ViewPager feedViewPager = ((HomeFeedContentFragment) fragment).getFeedViewPager();
                        if (feedViewPager != null) {
                            feedViewPager.setCurrentItem(defaultIndex, false);
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.newhome.content.HomeV1TabVPAdapter");
                }
            }
            this.pageRestoreState = new PageRestoreState(2, 0);
            setCurrentItem(currentItemTemp, false);
        }
        this.pageRestoreState = null;
    }
}
