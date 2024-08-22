package com.baidu.searchbox.sport.olympic.sport.sportspanel.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/item/SportsTitleAdapter;", "Lcom/baidu/searchbox/nacomp/recycler/base/item/ItemAdapter;", "Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/item/SportsTitleData;", "Lcom/baidu/searchbox/sport/olympic/sport/sportspanel/item/SportsTitleComp;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "onCreateViewHolder", "vg", "Landroid/view/ViewGroup;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportsTitleComp.kt */
public final class SportsTitleAdapter extends ItemAdapter<SportsTitleData, SportsTitleComp> {
    private final LifecycleOwner owner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SportsTitleAdapter(LifecycleOwner owner2) {
        super(owner2);
        Intrinsics.checkNotNullParameter(owner2, "owner");
        this.owner = owner2;
    }

    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    public SportsTitleComp onCreateViewHolder(ViewGroup vg) {
        Intrinsics.checkNotNullParameter(vg, "vg");
        LifecycleOwner lifecycleOwner = this.owner;
        View inflate = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.olymp_sports_panel_title_item, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(AppRuntime.getAppCo…_title_item, null, false)");
        return new SportsTitleComp(lifecycleOwner, inflate);
    }

    public UniqueId getType() {
        return SportsTitleData.Companion.getTYPE();
    }
}
