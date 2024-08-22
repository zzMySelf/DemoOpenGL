package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzf;
import fe.de.qw.qw.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

public final class zzar extends zzf {
    public final WeakReference zza;
    public final ResultReceiver zzb;

    public /* synthetic */ zzar(WeakReference weakReference, ResultReceiver resultReceiver, c cVar) {
        this.zza = weakReference;
        this.zzb = resultReceiver;
    }

    public final void zza(Bundle bundle) throws RemoteException {
        ResultReceiver resultReceiver = this.zzb;
        if (resultReceiver == null) {
            zzb.zzo("BillingClient", "Unable to send result for in-app messaging");
        } else if (bundle == null) {
            resultReceiver.send(0, (Bundle) null);
        } else {
            Activity activity = (Activity) this.zza.get();
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("KEY_LAUNCH_INTENT");
            if (activity == null || pendingIntent == null) {
                this.zzb.send(0, (Bundle) null);
                zzb.zzo("BillingClient", "Unable to launch intent for in-app messaging");
                return;
            }
            try {
                Intent intent = new Intent(activity, ProxyBillingActivity.class);
                intent.putExtra(ProxyBillingActivity.KEY_IN_APP_MESSAGE_RESULT_RECEIVER, this.zzb);
                intent.putExtra("IN_APP_MESSAGE_INTENT", pendingIntent);
                activity.startActivity(intent);
            } catch (CancellationException e) {
                this.zzb.send(0, (Bundle) null);
                zzb.zzp("BillingClient", "Exception caught while launching intent for in-app messaging.", e);
            }
        }
    }
}
