package fe.fe.pf.i.fe.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.helios.ids.oid.brand.g;
import com.heytap.openid.IOpenID;
import java.security.MessageDigest;

public class yj {

    public class qw implements ServiceConnection {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ g.a f2762ad;
        public final /* synthetic */ Context qw;

        public qw(Context context, g.a aVar) {
            this.qw = context;
            this.f2762ad = aVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Signature[] signatureArr;
            String str;
            Parcel obtain;
            Parcel obtain2;
            iBinder.queryLocalInterface(IOpenID.Stub.DESCRIPTOR);
            String packageName = this.qw.getPackageName();
            try {
                signatureArr = this.qw.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
                this.f2762ad.qw(false, (String) null);
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA1");
                    if (instance != null) {
                        byte[] digest = instance.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        str = sb.toString();
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                        obtain.writeString(packageName);
                        obtain.writeString(str);
                        obtain.writeString("OUID");
                        iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        obtain.recycle();
                        obtain2.recycle();
                        this.f2762ad.qw(true, readString);
                    }
                } catch (Exception e2) {
                    this.f2762ad.qw(false, (String) null);
                    e2.printStackTrace();
                }
            }
            str = null;
            obtain = Parcel.obtain();
            obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                obtain.writeString(packageName);
                obtain.writeString(str);
                obtain.writeString("OUID");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString2 = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                this.f2762ad.qw(true, readString2);
            } catch (Exception e3) {
                e3.printStackTrace();
                this.f2762ad.qw(false, (String) null);
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable th2) {
                obtain.recycle();
                obtain2.recycle();
                throw th2;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static void qw(Context context, g.a aVar) {
        if (context == null) {
            aVar.qw(false, (String) null);
            return;
        }
        try {
            qw qwVar = new qw(context, aVar);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            context.bindService(intent, qwVar, 1);
        } catch (Throwable unused) {
            aVar.qw(false, (String) null);
        }
    }
}
