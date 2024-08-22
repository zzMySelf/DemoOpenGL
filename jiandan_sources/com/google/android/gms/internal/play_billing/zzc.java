package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzc extends zzh implements zze {
    public zzc(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    public final int zza(int i2, String str, String str2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        Parcel zzp = zzp(5, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }

    public final int zzc(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i2);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(10, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }

    public final Bundle zzd(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(902, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zze(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(12, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzf(int i2, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzo.writeString((String) null);
        Parcel zzp = zzp(3, zzo);
        Bundle bundle = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle;
    }

    public final Bundle zzg(int i2, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i2);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzo.writeString((String) null);
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(8, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzh(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(6);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(9, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzi(int i2, String str, String str2, String str3) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        Parcel zzp = zzp(4, zzo);
        Bundle bundle = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle;
    }

    public final Bundle zzj(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(11, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzk(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(2, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzl(int i2, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i2);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzc(zzo, bundle);
        zzj.zzc(zzo, bundle2);
        Parcel zzp = zzp(901, zzo);
        Bundle bundle3 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle3;
    }

    public final Bundle zzm(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(8);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString("subs");
        zzj.zzc(zzo, bundle);
        Parcel zzp = zzp(801, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final void zzn(int i2, String str, Bundle bundle, zzg zzg) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(12);
        zzo.writeString(str);
        zzj.zzc(zzo, bundle);
        zzj.zzd(zzo, zzg);
        zzq(1201, zzo);
    }

    public final int zzr(int i2, String str, String str2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i2);
        zzo.writeString(str);
        zzo.writeString(str2);
        Parcel zzp = zzp(1, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }
}
