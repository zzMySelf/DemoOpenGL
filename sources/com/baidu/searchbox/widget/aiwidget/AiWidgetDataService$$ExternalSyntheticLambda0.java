package com.baidu.searchbox.widget.aiwidget;

import com.baidu.searchbox.widget.aiwidget.model.AiWidgetModel;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AiWidgetDataService$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ AiWidgetModel f$1;

    public /* synthetic */ AiWidgetDataService$$ExternalSyntheticLambda0(Function1 function1, AiWidgetModel aiWidgetModel) {
        this.f$0 = function1;
        this.f$1 = aiWidgetModel;
    }

    public final void run() {
        AiWidgetDataService.m7618updateLocalData$lambda1$lambda0(this.f$0, this.f$1);
    }
}
