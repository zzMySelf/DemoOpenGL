package fe.fe.mmm;

import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.ubc.IRemoteUBCService;
import com.baidu.ubc.UBCManager;
import fe.fe.vvv.ad.ad.ad;

@Deprecated
public class mmm {
    public static volatile IRemoteUBCService qw;

    static {
        tt.vvv();
    }

    public static void ad(String str, String str2, int i2) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.onEvent(str, str2, i2);
        }
    }

    public static final void onEvent(String str) {
        ad(str, "", 0);
    }

    public static IRemoteUBCService qw() throws RemoteException {
        if (qw == null) {
            synchronized (mmm.class) {
                if (qw == null) {
                    IBinder rg2 = tt.rg("remote_ubc_service");
                    if (rg2 == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    } else if (rg2 != null) {
                        qw = IRemoteUBCService.Stub.asInterface(rg2);
                    }
                }
            }
        }
        return qw;
    }
}
