package com.baidu.sofire.d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a extends IInterface {
    Bundle a(Bundle bundle) throws RemoteException;

    Bundle a(String str) throws RemoteException;

    Bundle b(Bundle bundle) throws RemoteException;

    /* renamed from: com.baidu.sofire.d.a$a  reason: collision with other inner class name */
    public static abstract class C0051a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        public C0051a() {
            attachInterface(this, "com.baidu.sofire.mutiprocess.IMutiProcessHandler");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0052a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                r2 = 1
                java.lang.String r3 = "com.baidu.sofire.mutiprocess.IMutiProcessHandler"
                if (r6 == r2) goto L_0x005f
                r4 = 2
                if (r6 == r4) goto L_0x0039
                r0 = 3
                if (r6 == r0) goto L_0x001b
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r6 == r0) goto L_0x0017
                boolean r6 = super.onTransact(r6, r7, r8, r9)
                return r6
            L_0x0017:
                r8.writeString(r3)
                return r2
            L_0x001b:
                r7.enforceInterface(r3)
                java.lang.String r6 = r7.readString()
                r7 = r5
                com.baidu.sofire.d.b$a r7 = (com.baidu.sofire.d.b.a) r7
                android.os.Bundle r6 = r7.a((java.lang.String) r6)
                r8.writeNoException()
                if (r6 == 0) goto L_0x0035
                r8.writeInt(r2)
                r6.writeToParcel(r8, r2)
                goto L_0x0038
            L_0x0035:
                r8.writeInt(r1)
            L_0x0038:
                return r2
            L_0x0039:
                r7.enforceInterface(r3)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x004b
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x004b:
                android.os.Bundle r6 = com.baidu.sofire.d.b.a((android.os.Bundle) r0)
                r8.writeNoException()
                if (r6 == 0) goto L_0x005b
                r8.writeInt(r2)
                r6.writeToParcel(r8, r2)
                goto L_0x005e
            L_0x005b:
                r8.writeInt(r1)
            L_0x005e:
                return r2
            L_0x005f:
                r7.enforceInterface(r3)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x0071
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0071:
                r6 = r5
                com.baidu.sofire.d.b$a r6 = (com.baidu.sofire.d.b.a) r6
                android.os.Bundle r6 = r6.a((android.os.Bundle) r0)
                r8.writeNoException()
                if (r6 == 0) goto L_0x0084
                r8.writeInt(r2)
                r6.writeToParcel(r8, r2)
                goto L_0x0087
            L_0x0084:
                r8.writeInt(r1)
            L_0x0087:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.d.a.C0051a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.baidu.sofire.d.a$a$a  reason: collision with other inner class name */
        public static class C0052a implements a {
            public IBinder a;

            public C0052a(IBinder iBinder) {
                this.a = iBinder;
            }

            public Bundle a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, obtain2, 0)) {
                        int i2 = C0051a.a;
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }

            public Bundle b(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                    if (!this.a.transact(2, obtain, obtain2, 0)) {
                        int i2 = C0051a.a;
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    obtain.writeString(str);
                    if (!this.a.transact(3, obtain, obtain2, 0)) {
                        int i2 = C0051a.a;
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
