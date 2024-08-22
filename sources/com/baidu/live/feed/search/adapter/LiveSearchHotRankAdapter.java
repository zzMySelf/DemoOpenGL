package com.baidu.live.feed.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.business.log.UbcEventLog;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.R;
import com.baidu.live.feed.search.holder.LiveSearchHotRankBottomViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchHotRankHeaderViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchHotRankItemViewHolder;
import com.baidu.searchbox.favor.data.FavorModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\u0016\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "callback", "Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "getCallback", "()Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "setCallback", "(Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;)V", "entities", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "release", "updateData", "data", "", "Callback", "ViewType", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveSearchHotRankAdapter.kt */
public final class LiveSearchHotRankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Callback callback;
    private List<LiveRoomEntity> entities;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$Callback;", "", "onItemClick", "", "cmd", "", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveSearchHotRankAdapter.kt */
    public interface Callback {
        void onItemClick(String str);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public final void updateData(List<? extends LiveRoomEntity> data) {
        if (this.entities == null) {
            this.entities = new ArrayList();
        }
        List<LiveRoomEntity> list = this.entities;
        if (list != null) {
            list.clear();
        }
        if (data != null) {
            List<? extends LiveRoomEntity> list2 = data;
            List<LiveRoomEntity> list3 = this.entities;
            if (list3 != null) {
                list3.addAll(list2);
            }
        }
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        switch (viewType) {
            case 0:
                return new LiveSearchHotRankHeaderViewHolder(new ImageView(parent.getContext()));
            case 2:
                return new LiveSearchHotRankBottomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.live_feed_search_hotrank_bottom, parent, false));
            default:
                return new LiveSearchHotRankItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.live_feed_search_hotrank_item, parent, false));
        }
    }

    public int getItemCount() {
        List<LiveRoomEntity> list;
        List<LiveRoomEntity> list2 = this.entities;
        if (list2 == null) {
            return 0;
        }
        boolean z = true;
        if (list2 == null || !(!list2.isEmpty())) {
            z = false;
        }
        if (!z || (list = this.entities) == null) {
            return 0;
        }
        return list.size() + 2;
    }

    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == getItemCount() - 1) {
            return 2;
        }
        return 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position < getItemCount()) {
            boolean z = true;
            if (holder.getItemViewType() == 1 && (holder instanceof LiveSearchHotRankItemViewHolder) && position - 1 >= 0) {
                List<LiveRoomEntity> list = this.entities;
                Context context = null;
                LiveRoomEntity entity = list != null ? list.get(position - 1) : null;
                ((LiveSearchHotRankItemViewHolder) holder).bind(entity);
                ((LiveSearchHotRankItemViewHolder) holder).itemView.setOnClickListener(new LiveSearchHotRankAdapter$$ExternalSyntheticLambda0(this, entity, holder, position));
                if (entity == null || !entity.needLogShow) {
                    z = false;
                }
                if (z) {
                    if (entity != null) {
                        entity.needLogShow = false;
                    }
                    Context context2 = ((LiveSearchHotRankItemViewHolder) holder).itemView.getContext();
                    if (context2 != null) {
                        context = context2.getApplicationContext();
                    }
                    UbcEventLog.searchHotRankItemShow(context, position, entity);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m13920onBindViewHolder$lambda1(LiveSearchHotRankAdapter this$0, LiveRoomEntity $entity, RecyclerView.ViewHolder $holder, int $position, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($holder, "$holder");
        Callback callback2 = this$0.callback;
        Context context = null;
        if (callback2 != null) {
            callback2.onItemClick($entity != null ? $entity.cmd : null);
        }
        Context context2 = ((LiveSearchHotRankItemViewHolder) $holder).itemView.getContext();
        if (context2 != null) {
            context = context2.getApplicationContext();
        }
        UbcEventLog.searchHotRankItemClick(context, $position, $entity);
    }

    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof LiveSearchHotRankItemViewHolder) {
            ((LiveSearchHotRankItemViewHolder) holder).recycle();
        }
    }

    public final void release() {
        this.callback = null;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHotRankAdapter$ViewType;", "", "()V", "BOTTOM", "", "HEADER", "ITEM", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveSearchHotRankAdapter.kt */
    public static final class ViewType {
        public static final int BOTTOM = 2;
        public static final int HEADER = 0;
        public static final ViewType INSTANCE = new ViewType();
        public static final int ITEM = 1;

        private ViewType() {
        }
    }
}
