package com.baidu.searchbox.mvp.aggcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.mvp.entity.CardList;
import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005H\u0016J \u0010#\u001a\u00020\u00102\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010%2\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u000e¢\u0006\u0002\n\u0000RN\u0010\n\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/mvp/aggcard/AggCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/mvp/aggcard/AggCardHolder;", "()V", "TYPE_COMMON", "", "TYPE_SMALL_CARD", "aggCardList", "", "Lcom/baidu/searchbox/mvp/entity/CardList;", "itemClkListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "data", "", "getItemClkListener", "()Lkotlin/jvm/functions/Function2;", "setItemClkListener", "(Lkotlin/jvm/functions/Function2;)V", "parentHeight", "getParentHeight", "()I", "setParentHeight", "(I)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAggCardList", "list", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AggCardView.kt */
public final class AggCardAdapter extends RecyclerView.Adapter<AggCardHolder> {
    private final int TYPE_COMMON;
    private final int TYPE_SMALL_CARD = 1;
    private List<CardList> aggCardList = new ArrayList();
    private Function2<? super Integer, ? super CardList, Unit> itemClkListener;
    private int parentHeight = -1;

    public final Function2<Integer, CardList, Unit> getItemClkListener() {
        return this.itemClkListener;
    }

    public final void setItemClkListener(Function2<? super Integer, ? super CardList, Unit> function2) {
        this.itemClkListener = function2;
    }

    public final int getParentHeight() {
        return this.parentHeight;
    }

    public final void setParentHeight(int i2) {
        this.parentHeight = i2;
    }

    public AggCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        if (viewType == this.TYPE_SMALL_CARD) {
            layoutId = R.layout.mvp_rec_agg_card_item_mystery;
        } else {
            layoutId = R.layout.mvp_rec_agg_card_item_common;
        }
        View view2 = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new AggCardHolder(view2);
    }

    public void onBindViewHolder(AggCardHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List $this$getByIndex$iv = this.aggCardList;
        CardList cardList = null;
        if ($this$getByIndex$iv != null && position >= 0 && position < $this$getByIndex$iv.size()) {
            cardList = $this$getByIndex$iv.get(position);
        }
        holder.renderItemView(cardList, this.parentHeight);
        holder.itemView.setOnClickListener(new AggCardAdapter$$ExternalSyntheticLambda0(this, position));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m1352onBindViewHolder$lambda0(AggCardAdapter this$0, int $position, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<? super Integer, ? super CardList, Unit> function2 = this$0.itemClkListener;
        if (function2 != null) {
            Integer valueOf = Integer.valueOf($position);
            List $this$getByIndex$iv = this$0.aggCardList;
            CardList cardList = null;
            if ($this$getByIndex$iv != null && $position >= 0 && $position < $this$getByIndex$iv.size()) {
                cardList = $this$getByIndex$iv.get($position);
            }
            function2.invoke(valueOf, cardList);
        }
    }

    public int getItemCount() {
        return this.aggCardList.size();
    }

    public int getItemViewType(int position) {
        boolean z;
        CardList cardList = this.aggCardList.get(position);
        String type = cardList != null ? cardList.getType() : null;
        if (Intrinsics.areEqual((Object) type, (Object) UgcConstant.UGC_MYSTERY_CARD)) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) type, (Object) "tags");
        }
        if (z) {
            return this.TYPE_SMALL_CARD;
        }
        return this.TYPE_COMMON;
    }

    public final void setAggCardList(List<CardList> list, int parentHeight2) {
        this.parentHeight = parentHeight2;
        if (list != null) {
            this.aggCardList.clear();
            this.aggCardList.addAll(list);
        }
    }
}
