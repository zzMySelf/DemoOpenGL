package com.baidu.searchbox.nacomp.extension.base;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.fontsize.IFontSize;
import com.baidu.searchbox.nacomp.extension.nightmode.INightMode;
import com.baidu.searchbox.nacomp.mvvm.IComponent;
import com.baidu.searchbox.nacomp.recycler.base.RVComponent;
import com.baidu.searchbox.nacomp.recycler.base.RVViewModel;

public abstract class BaseExtRVComponent<VM extends RVViewModel> extends RVComponent<VM> implements INightMode, IFontSize {
    public BaseExtRVComponent(LifecycleOwner owner, View view2) {
        super(owner, view2);
    }

    public BaseExtRVComponent(LifecycleOwner owner, View view2, boolean preloadViewModel) {
        super(owner, view2, preloadViewModel);
    }

    public void onNightModeChange(boolean isNightMode) {
        for (IComponent comp : getChildren()) {
            if (comp instanceof INightMode) {
                ((INightMode) comp).onNightModeChange(isNightMode);
            }
        }
        updateRecyclerViewData();
    }

    public void onFontSizeChange(FontSizeInfo info) {
        for (IComponent comp : getChildren()) {
            if (comp instanceof IFontSize) {
                ((IFontSize) comp).onFontSizeChange(info);
            }
        }
        updateRecyclerViewData();
    }

    /* access modifiers changed from: protected */
    public void updateRecyclerViewData() {
        if (getRecyclerView() != null && getRecyclerView().getAdapter() != null) {
            getRecyclerView().getAdapter().notifyDataSetChanged();
        }
    }
}
