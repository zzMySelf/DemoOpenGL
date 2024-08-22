package com.baidu.searchbox.weather.comps.daily;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import com.baidu.searchbox.nacomp.util.CollectionUtils;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.weather.events.OpenUrlEvent;
import com.baidu.searchbox.weather.model.DailyData;
import java.util.List;

public class DailyViewModel extends BaseExtItemViewModel<DailyModel> {
    final MutableLiveData<DailyChartData> chartData = new MutableLiveData<>();
    final MutableLiveData<String> fortyDayUrl = new MutableLiveData<>();
    private final DailyDetailItemAdapter mItemAdapter;
    final MutableLiveData<Boolean> needResetList = new MutableLiveData<>();
    final MutableLiveData<DailyData> selectedData = new MutableLiveData<>();
    final MutableLiveData<Integer> selectedPos = new MutableLiveData<>();

    public DailyViewModel(DailyDetailItemAdapter adapter) {
        this.mItemAdapter = adapter;
    }

    public void setModel(DailyModel model) {
        super.setModel(model);
        this.needResetList.setValue(Boolean.valueOf(model.needResetList()));
        this.selectedPos.setValue(Integer.valueOf(getSelectedPos(model.getSelectedData(), model.getDailyDataList())));
        this.selectedData.setValue(model.getSelectedData());
        this.mItemAdapter.setToken(model.getToken());
        this.mItemAdapter.setSelectedData(model.getSelectedData());
        DailyChartData dailyChartData = new DailyChartData(model.getDailyDataList(), model.getCurrentTime());
        this.mItemAdapter.setChartData(dailyChartData);
        this.chartData.setValue(dailyChartData);
        this.fortyDayUrl.setValue(model.getFortyDaysUrl());
    }

    public UniqueId getToken() {
        if (getModel() != null) {
            return ((DailyModel) getModel()).getToken();
        }
        return null;
    }

    public void jumpToFortyDay() {
        UniqueId token = getToken();
        if (token != null) {
            BdEventBus.Companion.getDefault().post(new OpenUrlEvent(token, this.fortyDayUrl.getValue()));
        }
    }

    private int getSelectedPos(DailyData selectedData2, List<DailyData> dailyDataList) {
        if (selectedData2 == null || CollectionUtils.isEmpty(dailyDataList)) {
            return -1;
        }
        return dailyDataList.indexOf(selectedData2);
    }
}
