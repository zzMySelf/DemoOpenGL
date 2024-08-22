package com.baidu.browser.explore.mutable.toprec.model;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TopRecRequestManager$requestData$1$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Function2 f$0;
    public final /* synthetic */ Ref.BooleanRef f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;

    public /* synthetic */ TopRecRequestManager$requestData$1$$ExternalSyntheticLambda2(Function2 function2, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef) {
        this.f$0 = function2;
        this.f$1 = booleanRef;
        this.f$2 = objectRef;
    }

    public final void run() {
        TopRecRequestManager$requestData$1.m12912onSuccess$lambda1(this.f$0, this.f$1, this.f$2);
    }
}
