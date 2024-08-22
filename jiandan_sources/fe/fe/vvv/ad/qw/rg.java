package fe.fe.vvv.ad.qw;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class rg implements IBinder, IBinder.DeathRecipient {

    /* renamed from: ad  reason: collision with root package name */
    public HashSet<IBinder.DeathRecipient> f3163ad = new HashSet<>();

    /* renamed from: de  reason: collision with root package name */
    public Object f3164de = new Object();
    public volatile IBinder qw;

    public static void ad(String str, Exception exc) {
    }

    public void binderDied() {
        synchronized (this.f3164de) {
            IBinder iBinder = this.qw;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.qw = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList<>();
            synchronized (this.f3163ad) {
                arrayList.addAll(this.f3163ad);
            }
            for (IBinder.DeathRecipient binderDied : arrayList) {
                binderDied.binderDied();
            }
        }
    }

    public abstract IBinder de() throws RemoteException;

    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        qw().dump(fileDescriptor, strArr);
    }

    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        qw().dumpAsync(fileDescriptor, strArr);
    }

    public String getInterfaceDescriptor() throws RemoteException {
        return qw().getInterfaceDescriptor();
    }

    public boolean isBinderAlive() {
        try {
            return qw().isBinderAlive();
        } catch (RemoteException e) {
            ad("MultiProcess", e);
            return false;
        }
    }

    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i2) throws RemoteException {
        synchronized (this.f3163ad) {
            this.f3163ad.add(deathRecipient);
        }
    }

    public boolean pingBinder() {
        try {
            return qw().pingBinder();
        } catch (RemoteException e) {
            ad("MultiProcess", e);
            return false;
        }
    }

    public IInterface queryLocalInterface(String str) {
        try {
            return qw().queryLocalInterface(str);
        } catch (RemoteException e) {
            ad("MultiProcess", e);
            return null;
        }
    }

    public final IBinder qw() throws RemoteException {
        synchronized (this.f3164de) {
            IBinder iBinder = this.qw;
            if (iBinder != null) {
                return iBinder;
            }
            IBinder de2 = de();
            this.qw = de2;
            if (de2 != null) {
                de2.linkToDeath(this, 0);
                return de2;
            }
            throw new RemoteException();
        }
    }

    public boolean transact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        return qw().transact(i2, parcel, parcel2, i3);
    }

    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i2) {
        synchronized (this.f3163ad) {
            this.f3163ad.remove(deathRecipient);
        }
        return this.qw != null;
    }
}
