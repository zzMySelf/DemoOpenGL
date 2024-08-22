package com.baidu.searchbox.music.comp.playlist.panel;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/music/comp/playlist/panel/PanelPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "viewList", "", "Landroid/view/View;", "(Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PanelPagerAdapter.kt */
public final class PanelPagerAdapter extends PagerAdapter {
    private final List<View> viewList;

    public PanelPagerAdapter(List<? extends View> viewList2) {
        Intrinsics.checkNotNullParameter(viewList2, "viewList");
        this.viewList = viewList2;
    }

    public int getCount() {
        return this.viewList.size();
    }

    public boolean isViewFromObject(View view2, Object object) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual((Object) object instanceof View ? (View) object : null, (Object) view2);
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        View $this$instantiateItem_u24lambda_u2d0 = (View) CollectionsKt.getOrNull(this.viewList, position);
        if ($this$instantiateItem_u24lambda_u2d0 == null) {
            return new Object();
        }
        container.addView($this$instantiateItem_u24lambda_u2d0);
        return $this$instantiateItem_u24lambda_u2d0;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        View $this$destroyItem_u24lambda_u2d1 = object instanceof View ? (View) object : null;
        if ($this$destroyItem_u24lambda_u2d1 != null) {
            container.removeView($this$destroyItem_u24lambda_u2d1);
        }
    }
}
