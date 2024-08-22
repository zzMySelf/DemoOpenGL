package com.google.android.gms.tasks;

public final class zzd implements Runnable {
    public final /* synthetic */ Task zzg;
    public final /* synthetic */ zzc zzh;

    public zzd(zzc zzc, Task task) {
        this.zzh = zzc;
        this.zzg = task;
    }

    public final void run() {
        if (this.zzg.isCanceled()) {
            this.zzh.zzf.zza();
            return;
        }
        try {
            this.zzh.zzf.setResult(this.zzh.zze.then(this.zzg));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzh.zzf.setException((Exception) e.getCause());
            } else {
                this.zzh.zzf.setException(e);
            }
        } catch (Exception e2) {
            this.zzh.zzf.setException(e2);
        }
    }
}
