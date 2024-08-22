package com.baidu.searchbox.search.hottopic.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.search.hottopic.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/search/hottopic/view/HotListView;", "Lcom/baidu/searchbox/search/hottopic/view/BaseHotListView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getBackgroundRes", "Landroid/graphics/drawable/Drawable;", "getInflateResId", "getLookMorePaddingBottom", "getLookMorePaddingTop", "getTitleSizeResId", "getType", "lib_hot_topic_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotListView.kt */
public final class HotListView extends BaseHotListView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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
    public HotListView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getType() {
        return 1;
    }

    public int getInflateResId() {
        return R.layout.searchbox_hottopic_hot_list_layout;
    }

    public int getTitleSizeResId() {
        return R.dimen.searchbox_hottopic_title_size;
    }

    public Drawable getBackgroundRes() {
        return getResources().getDrawable(R.drawable.search_hottopic_card_bg);
    }

    public int getLookMorePaddingBottom() {
        return AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.searchbox_hottopic_lookmore_bottom_padding);
    }

    public int getLookMorePaddingTop() {
        return AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.searchbox_hottopic_lookmore_top_padding);
    }
}
