package com.baidu.helios.bridge.multiprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface e extends IInterface {

    public static class a implements e {
        public Bundle a(String str, Bundle bundle) {
            return null;
        }

        public void a() {
        }

        public void a(String str, Bundle bundle, f fVar) {
        }

        public boolean a(String str) {
            return false;
        }

        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements e {
        public static final String a = "com.baidu.helios.bridge.multiprocess.IMultiProcessBridge";
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;

        public static class a implements e {
            public static e a;
            public IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            public Bundle a(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(2, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a(str, bundle);
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (this.b.transact(1, obtain, obtain2, 0) || b.b() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    b.b().a();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, Bundle bundle, f fVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    if (this.b.transact(3, obtain, obtain2, 0) || b.b() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    b.b().a(str, bundle, fVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.b.transact(4, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.b;
            }

            public String b() {
                return b.a;
            }
        }

        public b() {
            attachInterface(this, a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new a(iBinder) : (e) queryLocalInterface;
        }

        public static boolean a(e eVar) {
            if (a.a != null || eVar == null) {
                return false;
            }
            a.a = eVar;
            return true;
        }

        public static e b() {
            return a.a;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) {
            /*
                r4 = this;
                r0 = 1
                java.lang.String r1 = "com.baidu.helios.bridge.multiprocess.IMultiProcessBridge"
                if (r5 == r0) goto L_0x007f
                r2 = 2
                r3 = 0
                if (r5 == r2) goto L_0x0054
                r2 = 3
                if (r5 == r2) goto L_0x002f
                r2 = 4
                if (r5 == r2) goto L_0x001d
                r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r5 == r2) goto L_0x0019
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0019:
                r7.writeString(r1)
                return r0
            L_0x001d:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                boolean r5 = r4.a(r5)
                r7.writeNoException()
                r7.writeInt(r5)
                return r0
            L_0x002f:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0045
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r8 = r8.createFromParcel(r6)
                r3 = r8
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0045:
                android.os.IBinder r6 = r6.readStrongBinder()
                com.baidu.helios.bridge.multiprocess.f r6 = com.baidu.helios.bridge.multiprocess.f.b.a((android.os.IBinder) r6)
                r4.a(r5, r3, r6)
            L_0x0050:
                r7.writeNoException()
                return r0
            L_0x0054:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x006a
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x006a:
                android.os.Bundle r5 = r4.a(r5, r3)
                r7.writeNoException()
                if (r5 == 0) goto L_0x007a
                r7.writeInt(r0)
                r5.writeToParcel(r7, r0)
                goto L_0x007e
            L_0x007a:
                r5 = 0
                r7.writeInt(r5)
            L_0x007e:
                return r0
            L_0x007f:
                r6.enforceInterface(r1)
                r4.a()
                goto L_0x0050
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.helios.bridge.multiprocess.e.b.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    Bundle a(String str, Bundle bundle);

    void a();

    void a(String str, Bundle bundle, f fVar);

    boolean a(String str);
}
