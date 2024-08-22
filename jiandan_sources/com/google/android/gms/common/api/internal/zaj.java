package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zaj {
    public final ArrayMap<ApiKey<?>, ConnectionResult> zaba = new ArrayMap<>();
    public final ArrayMap<ApiKey<?>, String> zacz = new ArrayMap<>();
    public final TaskCompletionSource<Map<ApiKey<?>, String>> zada = new TaskCompletionSource<>();
    public int zadb;
    public boolean zadc = false;

    public zaj(Iterable<? extends HasApiKey<?>> iterable) {
        for (HasApiKey apiKey : iterable) {
            this.zaba.put(apiKey.getApiKey(), null);
        }
        this.zadb = this.zaba.keySet().size();
    }

    public final Task<Map<ApiKey<?>, String>> getTask() {
        return this.zada.getTask();
    }

    public final void zaa(ApiKey<?> apiKey, ConnectionResult connectionResult, @Nullable String str) {
        this.zaba.put(apiKey, connectionResult);
        this.zacz.put(apiKey, str);
        this.zadb--;
        if (!connectionResult.isSuccess()) {
            this.zadc = true;
        }
        if (this.zadb != 0) {
            return;
        }
        if (this.zadc) {
            this.zada.setException(new AvailabilityException(this.zaba));
            return;
        }
        this.zada.setResult(this.zacz);
    }

    public final Set<ApiKey<?>> zan() {
        return this.zaba.keySet();
    }
}
