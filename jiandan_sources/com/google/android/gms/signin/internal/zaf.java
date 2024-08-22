package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zad;

public abstract class zaf extends zaa implements zac {
    public zaf() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 3) {
            zaa((ConnectionResult) zad.zaa(parcel, ConnectionResult.CREATOR), (zab) zad.zaa(parcel, zab.CREATOR));
        } else if (i2 == 4) {
            zag((Status) zad.zaa(parcel, Status.CREATOR));
        } else if (i2 == 6) {
            zah((Status) zad.zaa(parcel, Status.CREATOR));
        } else if (i2 == 7) {
            zaa((Status) zad.zaa(parcel, Status.CREATOR), (GoogleSignInAccount) zad.zaa(parcel, GoogleSignInAccount.CREATOR));
        } else if (i2 != 8) {
            return false;
        } else {
            zab((zak) zad.zaa(parcel, zak.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
