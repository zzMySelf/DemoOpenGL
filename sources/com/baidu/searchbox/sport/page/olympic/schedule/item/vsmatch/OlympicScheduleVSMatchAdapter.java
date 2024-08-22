package com.baidu.searchbox.sport.page.olympic.schedule.item.vsmatch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/item/vsmatch/OlympicScheduleVSMatchAdapter;", "Lcom/baidu/searchbox/nacomp/recycler/base/item/ItemAdapter;", "Lcom/baidu/searchbox/sport/page/olympic/schedule/item/vsmatch/OlympicScheduleVSMatchModel;", "Lcom/baidu/searchbox/sport/page/olympic/schedule/item/vsmatch/OlympicScheduleVSMatchComp;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicScheduleVSMatchAdapter.kt */
public final class OlympicScheduleVSMatchAdapter extends ItemAdapter<OlympicScheduleVSMatchModel, OlympicScheduleVSMatchComp> {
    private final LifecycleOwner owner;

    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OlympicScheduleVSMatchAdapter(LifecycleOwner owner2) {
        super(owner2);
        Intrinsics.checkNotNullParameter(owner2, "owner");
        this.owner = owner2;
    }

    public OlympicScheduleVSMatchComp onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        LifecycleOwner lifecycleOwner = this.owner;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.olymp_sch_match_comp, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…atch_comp, parent, false)");
        return new OlympicScheduleVSMatchComp(lifecycleOwner, inflate);
    }

    public UniqueId getType() {
        return OlympicScheduleVSMatchModel.Companion.getTYPE();
    }
}
