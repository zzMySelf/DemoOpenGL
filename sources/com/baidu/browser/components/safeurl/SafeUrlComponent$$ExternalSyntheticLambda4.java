package com.baidu.browser.components.safeurl;

import android.content.Context;
import com.baidu.searchbox.ng.errorview.rec.model.RecResponseData;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SafeUrlComponent$$ExternalSyntheticLambda4 implements Action1 {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ SafeUrlComponent f$2;

    public /* synthetic */ SafeUrlComponent$$ExternalSyntheticLambda4(Context context, int i2, SafeUrlComponent safeUrlComponent) {
        this.f$0 = context;
        this.f$1 = i2;
        this.f$2 = safeUrlComponent;
    }

    public final void call(Object obj) {
        SafeUrlComponent.m12722setUrlSafeLevel$lambda8(this.f$0, this.f$1, this.f$2, (RecResponseData) obj);
    }
}
