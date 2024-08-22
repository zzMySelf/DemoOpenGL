package com.baidu.searchbox.rewardsystem.repo;

import com.baidu.searchbox.rewardsystem.newtimer.data.NewTimerTaskModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RewardTaskRepo$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ NewTimerTaskModel.Data f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ RewardTaskRepo$$ExternalSyntheticLambda0(NewTimerTaskModel.Data data, boolean z, String str) {
        this.f$0 = data;
        this.f$1 = z;
        this.f$2 = str;
    }

    public final void run() {
        RewardTaskRepo.m2687handleTaskInfoData$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
