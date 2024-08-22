package com.baidu.searchbox.hissug.data;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HotTopicDataManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Function3 f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;

    public /* synthetic */ HotTopicDataManager$$ExternalSyntheticLambda1(Function3 function3, Ref.ObjectRef objectRef) {
        this.f$0 = function3;
        this.f$1 = objectRef;
    }

    public final void run() {
        HotTopicDataManager.m19873getDataFromCache$lambda1(this.f$0, this.f$1);
    }
}
