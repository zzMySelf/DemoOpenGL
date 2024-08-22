package com.tera.scan.main.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import com.tera.scan.vip.VipInfoManager;
import fe.mmm.qw.k.de;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MainActivityViewModel$rightOffInfoLiveData$1$updateValue$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MediatorLiveData<Pair<String, Boolean>> $this_apply;
    public final /* synthetic */ MainActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivityViewModel$rightOffInfoLiveData$1$updateValue$1(MediatorLiveData<Pair<String, Boolean>> mediatorLiveData, MainActivityViewModel mainActivityViewModel) {
        super(0);
        this.$this_apply = mediatorLiveData;
        this.this$0 = mainActivityViewModel;
    }

    public final void invoke() {
        de value = VipInfoManager.qw.th().getValue();
        Integer value2 = VipInfoManager.qw.fe().getValue();
        int i2 = 0;
        if ((value == null || value2 == null) ? false : true) {
            MediatorLiveData<Pair<String, Boolean>> mediatorLiveData = this.$this_apply;
            MainActivityViewModel mainActivityViewModel = this.this$0;
            if (value2 != null) {
                i2 = value2.intValue();
            }
            mediatorLiveData.setValue(new Pair(mainActivityViewModel.getUpperRightCornerVipCopyWriting(i2), Boolean.valueOf(!Intrinsics.areEqual((Object) value, (Object) de.qw.qw))));
        }
    }
}
