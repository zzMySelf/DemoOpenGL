package com.baidu.searchbox.weather.comps.hourly.loading;

import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/weather/comps/hourly/loading/HourlyLoadingViewModel;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemViewModel;", "Lcom/baidu/searchbox/weather/comps/hourly/loading/HourlyLoadingModel;", "()V", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setToken", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "setModel", "", "model", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HourlyLoadingViewModel.kt */
public final class HourlyLoadingViewModel extends BaseExtItemViewModel<HourlyLoadingModel> {
    private UniqueId token;

    public final UniqueId getToken() {
        return this.token;
    }

    public final void setToken(UniqueId uniqueId) {
        this.token = uniqueId;
    }

    public void setModel(HourlyLoadingModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setModel(model);
        this.token = model.getToken();
    }
}
