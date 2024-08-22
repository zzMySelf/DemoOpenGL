package com.baidu.searchbox.ugc.hottopic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.model.TopicItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ$\u0010\u0012\u001a\u00020\u00102\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014J\u001e\u0010\u0015\u001a\u00020\u00102\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/ugc/hottopic/HotTopicRecommendView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "data", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/TopicItem;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "removeSelectedHotTopic", "", "selectedHotTopic", "setOnItemClickListener", "listener", "Lkotlin/Function2;", "showHotTopic", "hotTopics", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotTopicRecommendView.kt */
public final class HotTopicRecommendView extends RecyclerView {
    public Map<Integer, View> _$_findViewCache;
    private final ArrayList<TopicItem> data;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HotTopicRecommendView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HotTopicRecommendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

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
    public HotTopicRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        ArrayList<TopicItem> arrayList = new ArrayList<>();
        this.data = arrayList;
        setAdapter(new HotTopicRecommendAdapter(context, arrayList));
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        addItemDecoration(new HotTopicItemDecoration(context.getResources().getDimensionPixelSize(R.dimen.ugc_dimens_7dp)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotTopicRecommendView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final ArrayList<TopicItem> getData() {
        return this.data;
    }

    public final void setOnItemClickListener(Function2<? super Integer, ? super TopicItem, Unit> listener) {
        RecyclerView.Adapter adapter = getAdapter();
        HotTopicRecommendAdapter hotTopicRecommendAdapter = adapter instanceof HotTopicRecommendAdapter ? (HotTopicRecommendAdapter) adapter : null;
        if (hotTopicRecommendAdapter != null) {
            hotTopicRecommendAdapter.setOnItemClickListener(listener);
        }
    }

    public final void showHotTopic(ArrayList<TopicItem> hotTopics) {
        Intrinsics.checkNotNullParameter(hotTopics, "hotTopics");
        setVisibility(0);
        this.data.clear();
        this.data.addAll(hotTopics);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public static /* synthetic */ void removeSelectedHotTopic$default(HotTopicRecommendView hotTopicRecommendView, TopicItem topicItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            topicItem = null;
        }
        hotTopicRecommendView.removeSelectedHotTopic(topicItem);
    }

    public final void removeSelectedHotTopic(TopicItem selectedHotTopic) {
        if (selectedHotTopic != null) {
            this.data.remove(selectedHotTopic);
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
