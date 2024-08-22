package com.tera.scan.widget.customrecyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

public class WrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int FOOTER = 2147483646;
    public static final int HEADER = -2147483647;
    public static final int LOAD_MORE_FOOTER = Integer.MAX_VALUE;
    public static final int REFRESH_HEADER = Integer.MIN_VALUE;

    /* renamed from: ad  reason: collision with root package name */
    public final RefreshHeaderLayout f7513ad;

    /* renamed from: de  reason: collision with root package name */
    public final FrameLayout f7514de;

    /* renamed from: fe  reason: collision with root package name */
    public final LinearLayout f7515fe;
    public final RecyclerView.Adapter qw;

    /* renamed from: rg  reason: collision with root package name */
    public final LinearLayout f7516rg;

    /* renamed from: th  reason: collision with root package name */
    public int f7517th = -1;

    /* renamed from: uk  reason: collision with root package name */
    public final RecyclerView.AdapterDataObserver f7518uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f7519yj = true;

    public class ad extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager.SpanSizeLookup f7520ad;
        public final /* synthetic */ GridLayoutManager qw;

        public ad(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.qw = gridLayoutManager;
            this.f7520ad = spanSizeLookup;
        }

        public int getSpanIndex(int i2, int i3) {
            if (WrapperAdapter.this.de(i2)) {
                return 0;
            }
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f7520ad;
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanIndex(i2 - 2, i3);
            }
            return super.getSpanIndex(i2, i3);
        }

        public int getSpanSize(int i2) {
            if (!WrapperAdapter.this.de(i2)) {
                GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f7520ad;
                if (spanSizeLookup != null) {
                    return spanSizeLookup.getSpanSize(i2 - 2);
                }
                return 1;
            } else if (WrapperAdapter.this.f7517th != -1) {
                return WrapperAdapter.this.f7517th;
            } else {
                return this.qw.getSpanCount();
            }
        }
    }

    public static class de extends RecyclerView.ViewHolder {
        public de(View view) {
            super(view);
        }
    }

    public static class fe extends RecyclerView.ViewHolder {
        public fe(View view) {
            super(view);
        }
    }

    public static class rg extends RecyclerView.ViewHolder {
        public rg(View view) {
            super(view);
        }
    }

    public static class th extends RecyclerView.ViewHolder {
        public th(View view) {
            super(view);
        }
    }

    public WrapperAdapter(RecyclerView.Adapter adapter, RefreshHeaderLayout refreshHeaderLayout, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, boolean z) {
        qw qwVar = new qw();
        this.f7518uk = qwVar;
        this.qw = adapter;
        this.f7513ad = refreshHeaderLayout;
        this.f7515fe = linearLayout;
        this.f7516rg = linearLayout2;
        this.f7514de = frameLayout;
        this.f7519yj = z;
        adapter.registerAdapterDataObserver(qwVar);
    }

    public final boolean de(int i2) {
        int itemCount = this.qw.getItemCount();
        return i2 == 0 || i2 == 1 || i2 == itemCount + 2 || i2 == itemCount + 3;
    }

    public RecyclerView.Adapter getAdapter() {
        return this.qw;
    }

    public int getItemCount() {
        return this.f7519yj ? this.qw.getItemCount() + 4 : this.qw.getItemCount();
    }

    public int getItemViewType(int i2) {
        if (!this.f7519yj) {
            return this.qw.getItemViewType(i2);
        }
        if (i2 == 0) {
            return Integer.MIN_VALUE;
        }
        if (i2 == 1) {
            return HEADER;
        }
        if (1 < i2 && i2 < this.qw.getItemCount() + 2) {
            return this.qw.getItemViewType(i2 - 2);
        }
        if (i2 == this.qw.getItemCount() + 2) {
            return FOOTER;
        }
        if (i2 == this.qw.getItemCount() + 3) {
            return Integer.MAX_VALUE;
        }
        throw new IllegalArgumentException("Wrong type! Position = " + i2);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            ad adVar = new ad(gridLayoutManager, spanSizeLookup);
            adVar.setSpanIndexCacheEnabled(spanSizeLookup.isSpanIndexCacheEnabled());
            gridLayoutManager.setSpanSizeLookup(adVar);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (!this.f7519yj || (1 < i2 && i2 < this.qw.getItemCount() + 2)) {
            RecyclerView.Adapter adapter = this.qw;
            if (this.f7519yj) {
                i2 -= 2;
            }
            adapter.onBindViewHolder(viewHolder, i2);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == Integer.MIN_VALUE) {
            return new th(this.f7513ad);
        }
        if (i2 == -2147483647) {
            return new fe(this.f7515fe);
        }
        if (i2 == 2147483646) {
            return new de(this.f7516rg);
        }
        if (i2 == Integer.MAX_VALUE) {
            return new rg(this.f7514de);
        }
        return this.qw.onCreateViewHolder(viewGroup, i2);
    }

    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        RecyclerView.Adapter adapter = this.qw;
        if (adapter == null || (this.f7519yj && (1 >= adapterPosition || adapterPosition >= adapter.getItemCount() + 2))) {
            return super.onFailedToRecycleView(viewHolder);
        }
        return this.qw.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        int adapterPosition = viewHolder.getAdapterPosition();
        if (de(adapterPosition)) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
        RecyclerView.Adapter adapter = this.qw;
        if (adapter == null) {
            return;
        }
        if (!this.f7519yj || (1 < adapterPosition && adapterPosition < adapter.getItemCount() + 2)) {
            this.qw.onViewAttachedToWindow(viewHolder);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        int adapterPosition = viewHolder.getAdapterPosition();
        RecyclerView.Adapter adapter = this.qw;
        if (adapter == null) {
            return;
        }
        if (!this.f7519yj || (1 < adapterPosition && adapterPosition < adapter.getItemCount() + 2)) {
            this.qw.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        int adapterPosition = viewHolder.getAdapterPosition();
        RecyclerView.Adapter adapter = this.qw;
        if (adapter == null) {
            return;
        }
        if (!this.f7519yj || (1 < adapterPosition && adapterPosition < adapter.getItemCount() + 2)) {
            this.qw.onViewRecycled(viewHolder);
        }
    }

    public void setFullSpanCount(int i2) {
        this.f7517th = i2;
    }

    public class qw extends RecyclerView.AdapterDataObserver {
        public qw() {
        }

        public void onChanged() {
            try {
                WrapperAdapter.this.notifyDataSetChanged();
            } catch (Exception unused) {
                fe.mmm.qw.i.qw.rg("WrapperAdapter", "notifyDataSetChanged() error");
            }
        }

        public void onItemRangeChanged(int i2, int i3) {
            try {
                WrapperAdapter.this.notifyItemRangeChanged(i2 + 2, i3);
            } catch (Exception unused) {
                fe.mmm.qw.i.qw.rg("WrapperAdapter", "onItemRangeChanged() error");
            }
        }

        public void onItemRangeInserted(int i2, int i3) {
            try {
                WrapperAdapter.this.notifyItemRangeInserted(i2 + 2, i3);
            } catch (Exception unused) {
                fe.mmm.qw.i.qw.rg("WrapperAdapter", "onItemRangeInserted() error");
            }
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
            try {
                WrapperAdapter.this.notifyDataSetChanged();
            } catch (Exception unused) {
                fe.mmm.qw.i.qw.rg("WrapperAdapter", "onItemRangeMoved() error");
            }
        }

        public void onItemRangeRemoved(int i2, int i3) {
            try {
                WrapperAdapter.this.notifyItemRangeRemoved(i2 + 2, i3);
            } catch (Exception unused) {
                fe.mmm.qw.i.qw.rg("WrapperAdapter", "onItemRangeRemoved() error");
            }
        }

        public void onItemRangeChanged(int i2, int i3, Object obj) {
            try {
                WrapperAdapter.this.notifyItemRangeChanged(i2 + 2, i3, obj);
            } catch (Exception unused) {
                fe.mmm.qw.i.qw.rg("WrapperAdapter", "onItemRangeChanged() error");
            }
        }
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2, @NonNull List<Object> list) {
        if (!this.f7519yj || (1 < i2 && i2 < this.qw.getItemCount() + 2)) {
            RecyclerView.Adapter adapter = this.qw;
            if (this.f7519yj) {
                i2 -= 2;
            }
            adapter.onBindViewHolder(viewHolder, i2, list);
        }
    }
}
