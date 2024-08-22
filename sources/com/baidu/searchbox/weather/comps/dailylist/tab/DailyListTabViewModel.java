package com.baidu.searchbox.weather.comps.dailylist.tab;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/weather/comps/dailylist/tab/DailyListTabViewModel;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemViewModel;", "Lcom/baidu/searchbox/weather/comps/dailylist/tab/DailyListTabModel;", "()V", "isTrends", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setModel", "", "model", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DailyListTabViewModel.kt */
public final class DailyListTabViewModel extends BaseExtItemViewModel<DailyListTabModel> {
    private final MutableLiveData<Boolean> isTrends = new MutableLiveData<>();
    private UniqueId token;

    public final MutableLiveData<Boolean> isTrends() {
        return this.isTrends;
    }

    public void setModel(DailyListTabModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setModel(model);
        this.token = model.getToken();
        this.isTrends.setValue(Boolean.valueOf(model.isTrends()));
    }
}
