package com.baidu.searchbox.hotsearch.comp.item.text;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.hissug.data.model.HisTagDataModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TextStyleItemComp$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ TextStyleItemComp f$0;

    public /* synthetic */ TextStyleItemComp$$ExternalSyntheticLambda1(TextStyleItemComp textStyleItemComp) {
        this.f$0 = textStyleItemComp;
    }

    public final void onChanged(Object obj) {
        TextStyleItemComp.m20373bindTag$lambda5(this.f$0, (HisTagDataModel) obj);
    }
}
