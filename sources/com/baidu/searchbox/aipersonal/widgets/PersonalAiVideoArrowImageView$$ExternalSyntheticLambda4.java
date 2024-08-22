package com.baidu.searchbox.aipersonal.widgets;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersonalAiVideoArrowImageView$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ PersonalCenterTabModel f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ PersonalAiVideoArrowImageView f$2;
    public final /* synthetic */ PersonalAiFavorHisQueryCallBack f$3;

    public /* synthetic */ PersonalAiVideoArrowImageView$$ExternalSyntheticLambda4(PersonalCenterTabModel personalCenterTabModel, int i2, PersonalAiVideoArrowImageView personalAiVideoArrowImageView, PersonalAiFavorHisQueryCallBack personalAiFavorHisQueryCallBack) {
        this.f$0 = personalCenterTabModel;
        this.f$1 = i2;
        this.f$2 = personalAiVideoArrowImageView;
        this.f$3 = personalAiFavorHisQueryCallBack;
    }

    public final void run() {
        PersonalAiVideoArrowImageView.m15081getRecentVisitedOrFavoredWebDataFromDb$lambda3(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
