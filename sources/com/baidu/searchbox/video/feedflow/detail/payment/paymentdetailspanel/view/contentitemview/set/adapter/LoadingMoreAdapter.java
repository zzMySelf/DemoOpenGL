package com.baidu.searchbox.video.feedflow.detail.payment.paymentdetailspanel.view.contentitemview.set.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.video.feedflow.detail.payment.paymentdetailspanel.view.contentitemview.set.loading.LoadingMoreView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002*\u0004\u0018\u00010\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004:\u0001;B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0015\u001a\u00020\u00162\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000fJ\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\tH\u0014J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\tH\u0002J \u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u0018\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u001d\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001bH&¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u001d\u00100\u001a\u00028\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001bH&¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u0016J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\tJ\u000e\u00105\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\tJ\u000e\u00106\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\tJ\u000e\u00107\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\tJ\u000e\u00108\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\tJ\u0018\u00109\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/paymentdetailspanel/view/contentitemview/set/adapter/LoadingMoreAdapter;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "headState", "Lcom/baidu/searchbox/video/feedflow/detail/payment/paymentdetailspanel/view/contentitemview/set/loading/LoadingMoreView$State;", "isLoadMore", "", "()Z", "setLoadMore", "(Z)V", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "state", "addList", "", "addStartList", "", "clear", "getItemCount", "", "getItemViewType", "position", "getListSize", "getLoadingMoreView", "Landroid/view/View;", "context", "Landroid/content/Context;", "isNeedRefresh", "notifyItemChanged", "isRefresh", "onBindLoadingMoreViewHolder", "view", "onBindViewHolder", "holder", "onBindViewsHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateViewsHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setLoadAll", "setLoadEnable", "enable", "setLoading", "setLoadingError", "setLoadingGone", "setLoadingMore", "setLoadingState", "isHeader", "LoadMoreHolder", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadingMoreAdapter.kt */
public abstract class LoadingMoreAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LoadingMoreView.State headState = LoadingMoreView.State.STATE_LOADING;
    private boolean isLoadMore = true;
    private ArrayList<T> list = new ArrayList<>();
    private LoadingMoreView.State state = LoadingMoreView.State.STATE_LOADING;

    public abstract View getLoadingMoreView(Context context);

    public abstract void onBindViewsHolder(VH vh, int i2);

    public abstract VH onCreateViewsHolder(ViewGroup viewGroup, int i2);

    /* access modifiers changed from: protected */
    public final boolean isLoadMore() {
        return this.isLoadMore;
    }

    /* access modifiers changed from: protected */
    public final void setLoadMore(boolean z) {
        this.isLoadMore = z;
    }

    /* access modifiers changed from: protected */
    public ArrayList<T> getList() {
        return this.list;
    }

    /* access modifiers changed from: protected */
    public void setList(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final void addList(ArrayList<T> list2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        getList().addAll(list2);
        this.state = LoadingMoreView.State.STATE_LOADING;
        notifyDataSetChanged();
    }

    public void addStartList(List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        getList().addAll(0, list2);
        this.headState = LoadingMoreView.State.STATE_LOADING;
        notifyDataSetChanged();
    }

    /* renamed from: getList  reason: collision with other method in class */
    public final List<T> m12012getList() {
        return getList();
    }

    public final int getListSize() {
        return getList().size();
    }

    public final void clear() {
        getList().clear();
        notifyDataSetChanged();
    }

    public final void setLoading(boolean isRefresh) {
        setLoadingState(LoadingMoreView.State.STATE_LOADING, isRefresh);
        setLoadEnable(true);
        notifyItemChanged(isRefresh);
    }

    public final void setLoadAll() {
        this.state = LoadingMoreView.State.STATE_LOAD_ALL;
        setLoadEnable(true);
        notifyItemChanged(false);
    }

    public final void setLoadingError(boolean isRefresh) {
        setLoadingState(LoadingMoreView.State.STATE_LOAD_ERROR, isRefresh);
        setLoadEnable(true);
        notifyItemChanged(isRefresh);
    }

    public final void setLoadingGone(boolean isRefresh) {
        setLoadingState(LoadingMoreView.State.STATE_DEFAULT, isRefresh);
        setLoadEnable(true);
        notifyItemChanged(isRefresh);
    }

    public final void setLoadingMore(boolean isRefresh) {
        setLoadingState(LoadingMoreView.State.STATE_LOAD_MORE, isRefresh);
        setLoadEnable(true);
        notifyItemChanged(isRefresh);
    }

    private final void notifyItemChanged(boolean isRefresh) {
        if (isRefresh) {
            notifyItemChanged(0, 1);
        } else {
            notifyItemChanged(getItemCount() - 1, 1);
        }
    }

    private final void setLoadingState(LoadingMoreView.State state2, boolean isHeader) {
        if (isHeader) {
            this.headState = state2;
        } else {
            this.state = state2;
        }
    }

    public final void setLoadEnable(boolean enable) {
        this.isLoadMore = enable;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        if (viewType != -1) {
            RecyclerView.ViewHolder onCreateViewsHolder = onCreateViewsHolder(parent, viewType);
            if (onCreateViewsHolder != null) {
                return onCreateViewsHolder;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
        }
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new LoadMoreHolder(this, getLoadingMoreView(context));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int index = position;
        if (getItemViewType(index) != -1) {
            if (isNeedRefresh() && index > 0) {
                index--;
            }
            onBindViewsHolder(holder, index);
        } else if (position == getItemCount() - 1) {
            ((LoadMoreHolder) holder).getLoadMoreLayout().setState(this.state);
            onBindLoadingMoreViewHolder(((LoadMoreHolder) holder).getLoadMoreLayout(), index, this.state);
        } else {
            ((LoadMoreHolder) holder).getLoadMoreLayout().setState(this.headState);
            onBindLoadingMoreViewHolder(((LoadMoreHolder) holder).getLoadMoreLayout(), index, this.headState);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/paymentdetailspanel/view/contentitemview/set/adapter/LoadingMoreAdapter$LoadMoreHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/baidu/searchbox/video/feedflow/detail/payment/paymentdetailspanel/view/contentitemview/set/adapter/LoadingMoreAdapter;Landroid/view/View;)V", "loadMoreLayout", "Lcom/baidu/searchbox/video/feedflow/detail/payment/paymentdetailspanel/view/contentitemview/set/loading/LoadingMoreView;", "getLoadMoreLayout", "()Lcom/baidu/searchbox/video/feedflow/detail/payment/paymentdetailspanel/view/contentitemview/set/loading/LoadingMoreView;", "setLoadMoreLayout", "(Lcom/baidu/searchbox/video/feedflow/detail/payment/paymentdetailspanel/view/contentitemview/set/loading/LoadingMoreView;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LoadingMoreAdapter.kt */
    private final class LoadMoreHolder extends RecyclerView.ViewHolder {
        private LoadingMoreView loadMoreLayout;
        final /* synthetic */ LoadingMoreAdapter<T, VH> this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadMoreHolder(LoadingMoreAdapter this$02, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = this$02;
            this.loadMoreLayout = (LoadingMoreView) itemView;
        }

        public final LoadingMoreView getLoadMoreLayout() {
            return this.loadMoreLayout;
        }

        public final void setLoadMoreLayout(LoadingMoreView loadingMoreView) {
            Intrinsics.checkNotNullParameter(loadingMoreView, "<set-?>");
            this.loadMoreLayout = loadingMoreView;
        }
    }

    public int getItemCount() {
        if (!this.isLoadMore) {
            return getList().size();
        }
        if (isNeedRefresh()) {
            return getList().size() + 2;
        }
        return getList().size() + 1;
    }

    public int getItemViewType(int position) {
        if (this.isLoadMore) {
            if (getItemCount() - 1 == position) {
                return -1;
            }
            if (position == 0 && isNeedRefresh()) {
                return -1;
            }
        }
        return super.getItemViewType(position);
    }

    /* access modifiers changed from: protected */
    public boolean isNeedRefresh() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onBindLoadingMoreViewHolder(View view2, int position, LoadingMoreView.State state2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(state2, "state");
    }
}
