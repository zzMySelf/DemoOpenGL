package com.baidu.apsaras.scheduler;

import com.baidu.apsaras.scheduler.internal.ApsarasRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DEBUG", "", "TAG", "", "contextScope", "Lcom/baidu/apsaras/scheduler/ParticleScope;", "context", "Lcom/baidu/apsaras/scheduler/ParticleContext;", "lib-apsaras_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParticleScope.kt */
public final class ParticleScopeKt {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = ApsarasRuntime.INSTANCE.isDebug();
    private static final String TAG = "ParticleScope";

    public static final ParticleScope contextScope(ParticleContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ParticleContextScope(context);
    }
}
