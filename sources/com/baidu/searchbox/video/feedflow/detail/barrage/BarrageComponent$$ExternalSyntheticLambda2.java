package com.baidu.searchbox.video.feedflow.detail.barrage;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.player.barrage.VulcanBarrageInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BarrageComponent$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ BarrageState f$0;
    public final /* synthetic */ BarrageComponent f$1;

    public /* synthetic */ BarrageComponent$$ExternalSyntheticLambda2(BarrageState barrageState, BarrageComponent barrageComponent) {
        this.f$0 = barrageState;
        this.f$1 = barrageComponent;
    }

    public final void onChanged(Object obj) {
        BarrageComponent.m10790onAttachToManager$lambda23$lambda4(this.f$0, this.f$1, (VulcanBarrageInfo) obj);
    }
}
