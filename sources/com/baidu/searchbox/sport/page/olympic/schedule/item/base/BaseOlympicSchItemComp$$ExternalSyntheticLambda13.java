package com.baidu.searchbox.sport.page.olympic.schedule.item.base;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicScheduleTagInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseOlympicSchItemComp$$ExternalSyntheticLambda13 implements Observer {
    public final /* synthetic */ BaseOlympicSchItemComp f$0;

    public /* synthetic */ BaseOlympicSchItemComp$$ExternalSyntheticLambda13(BaseOlympicSchItemComp baseOlympicSchItemComp) {
        this.f$0 = baseOlympicSchItemComp;
    }

    public final void onChanged(Object obj) {
        BaseOlympicSchItemComp.m4048bindTagInfo$lambda13(this.f$0, (OlympicScheduleTagInfo) obj);
    }
}
