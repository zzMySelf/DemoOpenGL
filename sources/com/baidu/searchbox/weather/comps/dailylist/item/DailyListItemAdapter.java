package com.baidu.searchbox.weather.comps.dailylist.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.weather.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/weather/comps/dailylist/item/DailyListItemAdapter;", "Lcom/baidu/searchbox/nacomp/recycler/base/item/ItemAdapter;", "Lcom/baidu/searchbox/weather/comps/dailylist/item/DailyListItemModel;", "Lcom/baidu/searchbox/weather/comps/dailylist/item/DailyListItemComp;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DailyListItemAdapter.kt */
public final class DailyListItemAdapter extends ItemAdapter<DailyListItemModel, DailyListItemComp> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DailyListItemAdapter(LifecycleOwner owner) {
        super(owner);
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    public DailyListItemComp onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View it = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_daily_list_item, parent, false);
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return new DailyListItemComp(lifecycleOwner, it);
    }

    public UniqueId getType() {
        return DailyListItemModel.Companion.getTYPE();
    }
}
