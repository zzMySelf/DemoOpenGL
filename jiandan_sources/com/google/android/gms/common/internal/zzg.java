package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Map;

public final class zzg implements ServiceConnection {
    public ComponentName mComponentName;
    public int mState = 2;
    public IBinder zzdl;
    public final Map<ServiceConnection, ServiceConnection> zzep = new HashMap();
    public boolean zzeq;
    public final GmsClientSupervisor.zza zzer;
    public final /* synthetic */ zze zzes;

    public zzg(zze zze, GmsClientSupervisor.zza zza) {
        this.zzes = zze;
        this.zzer = zza;
    }

    public final IBinder getBinder() {
        return this.zzdl;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zzeq;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzes.zzee) {
            this.zzes.mHandler.removeMessages(1, this.zzer);
            this.zzdl = iBinder;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceConnected : this.zzep.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzes.zzee) {
            this.zzes.mHandler.removeMessages(1, this.zzer);
            this.zzdl = null;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzep.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zza(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        ConnectionTracker unused = this.zzes.zzeg;
        Context unused2 = this.zzes.zzef;
        this.zzer.zzb(this.zzes.zzef);
        this.zzep.put(serviceConnection, serviceConnection2);
    }

    public final void zzf(String str) {
        this.mState = 3;
        boolean zza = this.zzes.zzeg.zza(this.zzes.zzef, str, this.zzer.zzb(this.zzes.zzef), this, this.zzer.zzq());
        this.zzeq = zza;
        if (zza) {
            this.zzes.mHandler.sendMessageDelayed(this.zzes.mHandler.obtainMessage(1, this.zzer), this.zzes.zzei);
            return;
        }
        this.mState = 2;
        try {
            this.zzes.zzeg.unbindService(this.zzes.zzef, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zzg(String str) {
        this.zzes.mHandler.removeMessages(1, this.zzer);
        this.zzes.zzeg.unbindService(this.zzes.zzef, this);
        this.zzeq = false;
        this.mState = 2;
    }

    public final boolean zzs() {
        return this.zzep.isEmpty();
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        ConnectionTracker unused = this.zzes.zzeg;
        Context unused2 = this.zzes.zzef;
        this.zzep.remove(serviceConnection);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzep.containsKey(serviceConnection);
    }
}
