package com.baidu.talos.devtools;

import com.baidu.talos.core.runtime.Runtime;
import java.util.ArrayList;
import java.util.function.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DevRuntimeManagerActivity$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ ArrayList f$0;

    public /* synthetic */ DevRuntimeManagerActivity$$ExternalSyntheticLambda0(ArrayList arrayList) {
        this.f$0 = arrayList;
    }

    public final void accept(Object obj) {
        this.f$0.add(((Runtime) obj).getRuntimeKey());
    }
}
