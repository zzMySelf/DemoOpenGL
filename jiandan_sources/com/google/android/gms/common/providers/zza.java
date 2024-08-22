package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.internal.common.zze;
import com.google.android.gms.internal.common.zzj;
import java.util.concurrent.ScheduledExecutorService;

public final class zza implements PooledExecutorsProvider.PooledExecutorFactory {
    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return zze.zzal().zza(1, zzj.zzjn);
    }
}
