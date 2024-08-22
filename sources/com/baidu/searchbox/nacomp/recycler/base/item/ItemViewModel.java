package com.baidu.searchbox.nacomp.recycler.base.item;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;

public class ItemViewModel<M> extends BaseViewModel {
    public ItemViewModel() {
        super(AppRuntime.getApplication());
    }

    public void setModel(M m) {
    }
}
