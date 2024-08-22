package com.baidu.bdtask.framework.ui.buoy;

import com.baidu.bdtask.framework.ui.buoy.BaseBuoyViewModel;
import com.baidu.bdtask.framework.ui.buoy.BuoyViewData;
import com.baidu.bdtask.framework.ui.buoy.IBuoyView;
import com.baidu.bdtask.framework.ui.mvvm.IView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;", "D", "Lcom/baidu/bdtask/framework/ui/buoy/BuoyViewData;", "VM", "Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyViewModel;", "Lcom/baidu/bdtask/framework/ui/mvvm/IView;", "Lcom/baidu/bdtask/framework/ui/buoy/IBuoyView;", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public abstract class BaseBuoyView<D extends BuoyViewData, VM extends BaseBuoyViewModel<D>> implements IBuoyView, IView<D, VM> {
    public IBuoyViewStrategy getBuoyViewStrategy() {
        return IBuoyView.DefaultImpls.getBuoyViewStrategy(this);
    }
}
