package com.baidu.searchbox.sport.page.olympic.schedule.item.aggregation;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.sport.page.olympic.schedule.item.base.BaseOlympicSchItemVM;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicSchedule;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicScheduleAggregationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/item/aggregation/OlympicSchAggregationMatchViewModel;", "Lcom/baidu/searchbox/sport/page/olympic/schedule/item/base/BaseOlympicSchItemVM;", "Lcom/baidu/searchbox/sport/page/olympic/schedule/item/aggregation/OlympicScheduleAggregationMatchModel;", "()V", "aggregationNum", "Landroidx/lifecycle/MutableLiveData;", "", "getAggregationNum", "()Landroidx/lifecycle/MutableLiveData;", "matchTitle", "", "getMatchTitle", "setModel", "", "model", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicSchAggregationMatchViewModel.kt */
public final class OlympicSchAggregationMatchViewModel extends BaseOlympicSchItemVM<OlympicScheduleAggregationMatchModel> {
    private final MutableLiveData<Integer> aggregationNum = new MutableLiveData<>();
    private final MutableLiveData<String> matchTitle = new MutableLiveData<>();

    public final MutableLiveData<String> getMatchTitle() {
        return this.matchTitle;
    }

    public final MutableLiveData<Integer> getAggregationNum() {
        return this.aggregationNum;
    }

    public void setModel(OlympicScheduleAggregationMatchModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setModel(model);
        OlympicSchedule $this$setModel_u24lambda_u2d1 = model.getSchedule();
        if ($this$setModel_u24lambda_u2d1 != null) {
            this.matchTitle.setValue($this$setModel_u24lambda_u2d1.getEventTitle());
            OlympicScheduleAggregationInfo it = $this$setModel_u24lambda_u2d1.getAggregationInfo();
            if (it != null) {
                this.aggregationNum.setValue(Integer.valueOf(it.getSubMatchCount()));
            }
        }
    }
}
