package com.baidu.sso.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.openid.IOpenID;

public interface a extends IInterface {

    /* renamed from: com.baidu.sso.r.a$a  reason: collision with other inner class name */
    public static abstract class C0059a extends Binder implements a {

        /* renamed from: com.baidu.sso.r.a$a$a  reason: collision with other inner class name */
        public static class C0060a implements a {
            public static a b;
            public IBinder a;

            public C0060a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.a.transact(1, obtain, obtain2, 0) || C0059a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C0060a) C0059a.a()).a(str, str2, str3);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a a() {
            return C0060a.b;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOpenID.Stub.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0060a(iBinder) : (a) queryLocalInterface;
        }
    }
}
