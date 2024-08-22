package com.baidu.searchbox.nacomp.extension.base;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemViewModel;
import com.baidu.searchbox.skin.NightModeHelper;

public abstract class BaseExtItemViewModel<M> extends ItemViewModel<M> {
    final MutableLiveData<FontSizeInfo> fontSizeInfo = new MutableLiveData<>();
    final MutableLiveData<Boolean> isNightModeChange = new MutableLiveData<>();
    private M model;

    public void setModel(M model2) {
        super.setModel(model2);
        this.model = model2;
        boolean isNightMode = NightModeHelper.getNightModeSwitcherState();
        if (this.isNightModeChange.getValue() == null || isNightMode != this.isNightModeChange.getValue().booleanValue()) {
            this.isNightModeChange.setValue(Boolean.valueOf(isNightMode));
        }
        this.fontSizeInfo.setValue(FontSizeInfo.Companion.getInfo());
    }

    public M getModel() {
        return this.model;
    }
}
