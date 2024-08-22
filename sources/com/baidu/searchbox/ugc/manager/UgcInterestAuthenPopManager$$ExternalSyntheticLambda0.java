package com.baidu.searchbox.ugc.manager;

import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.ugc.model.PublishModels;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UgcInterestAuthenPopManager$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ DefaultSharedPrefsWrapper f$0;

    public /* synthetic */ UgcInterestAuthenPopManager$$ExternalSyntheticLambda0(DefaultSharedPrefsWrapper defaultSharedPrefsWrapper) {
        this.f$0 = defaultSharedPrefsWrapper;
    }

    public final int compare(Object obj, Object obj2) {
        return UgcInterestAuthenPopManager.lambda$showDialog$0(this.f$0, (PublishModels.PopInfo) obj, (PublishModels.PopInfo) obj2);
    }
}
