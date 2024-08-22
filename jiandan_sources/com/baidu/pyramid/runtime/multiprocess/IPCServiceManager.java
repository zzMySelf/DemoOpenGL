package com.baidu.pyramid.runtime.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.pyramid.runtime.multiprocess.components.ServerProvider;
import com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl;
import fe.fe.vvv.ad.qw.fe;
import fe.fe.vvv.ad.qw.rg;
import fe.fe.vvv.ad.qw.th;
import fe.fe.vvv.ad.qw.yj;
import org.json.JSONException;
import org.json.JSONObject;

public class IPCServiceManager {

    /* renamed from: ad  reason: collision with root package name */
    public static final ad f938ad = new ad((qw) null);

    /* renamed from: de  reason: collision with root package name */
    public static IPCServiceManagerAidlImpl f939de;

    /* renamed from: fe  reason: collision with root package name */
    public static ContentProviderClient f940fe;
    public static volatile IPCServiceManagerAidl qw;

    public static class IPCServiceManagerAidlImpl extends IPCServiceManagerAidl.Stub {
        public IPCServiceManagerAidlImpl() {
        }

        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
            yj.qw(str, iBinder, z);
        }

        public IBinder getService(String str) throws RemoteException {
            return yj.fe(str);
        }

        public boolean removeService(String str) throws RemoteException {
            return yj.rg(str);
        }

        public /* synthetic */ IPCServiceManagerAidlImpl(qw qwVar) {
            this();
        }
    }

    public static class ad extends rg {

        /* renamed from: fe  reason: collision with root package name */
        public static final Uri f941fe = Uri.parse("content://" + ServerProvider.getCoreProviderAuthority() + "/" + "ipc_manager/method/get_service_handler");

        public ad() {
        }

        public IBinder de() {
            ContentResolver contentResolver = fe.qw().getContentResolver();
            JSONObject jSONObject = new JSONObject();
            Bundle th2 = th(contentResolver, jSONObject);
            if (th2 == null) {
                th2 = i(contentResolver, jSONObject);
            }
            if (jSONObject.length() != 0) {
                th.de(jSONObject.toString());
            }
            if (th2 == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return th2.getBinder("service");
            }
            th2.setClassLoader(BindlerHolder.class.getClassLoader());
            BindlerHolder bindlerHolder = (BindlerHolder) th2.getParcelable("service");
            if (bindlerHolder != null) {
                return bindlerHolder.getBinder();
            }
            return null;
        }

        public final Bundle fe(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.call(uri, "_get_service_handler", (String) null, (Bundle) null);
            } catch (Exception e) {
                try {
                    jSONObject.put("useContentResolverCall", th.qw(e));
                } catch (JSONException unused) {
                }
                IPCServiceManager.uk("getServicerBinder", e);
                return null;
            }
        }

        public final Bundle i(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            for (int i2 = 0; i2 < 2; i2++) {
                bundle = fe(contentResolver, f941fe, jSONObject);
                if (bundle == null) {
                    bundle = rg(contentResolver, f941fe, jSONObject);
                }
                if (bundle != null) {
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException unused) {
                }
            }
            return bundle;
        }

        public final Bundle rg(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.query(uri, (String[]) null, (String) null, (String[]) null, (String) null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useContentResolverQuery", th.qw(e));
                } catch (JSONException unused) {
                }
                IPCServiceManager.uk("getServicerBinder", e);
                return null;
            }
        }

        public final Bundle th(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(ServerProvider.getCoreProviderAuthority());
                if (acquireUnstableContentProviderClient != null && (bundle = yj(acquireUnstableContentProviderClient, jSONObject)) == null) {
                    bundle = uk(acquireUnstableContentProviderClient, jSONObject);
                }
                if (bundle != null) {
                    IPCServiceManager.f940fe = acquireUnstableContentProviderClient;
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException unused) {
                }
                i2++;
            }
            return bundle;
        }

        public final Bundle uk(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                return contentProviderClient.query(f941fe, (String[]) null, (String) null, (String[]) null, (String) null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientQuery", th.qw(e));
                } catch (JSONException unused) {
                }
                IPCServiceManager.uk("getServicerBinder", e);
                return null;
            }
        }

        public final Bundle yj(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    return contentProviderClient.call("_get_service_handler", (String) null, (Bundle) null);
                }
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientCall", th.qw(e));
                } catch (JSONException unused) {
                }
                IPCServiceManager.uk("getServicerBinder", e);
            }
            return null;
        }

        public /* synthetic */ ad(qw qwVar) {
            this();
        }
    }

    public class qw extends rg {

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ String f942fe;

        public qw(String str) {
            this.f942fe = str;
        }

        public IBinder de() throws RemoteException {
            return IPCServiceManager.yj().getService(this.f942fe);
        }
    }

    public static void de(String str, IBinder iBinder, boolean z) {
        try {
            yj().addService(str, iBinder, z);
        } catch (RemoteException e) {
            uk("MultiProcess", e);
            th.ad(e);
        }
    }

    public static Bundle fe() {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("service", rg());
        } else {
            bundle.putParcelable("service", new BindlerHolder((IBinder) rg()));
        }
        return bundle;
    }

    public static IPCServiceManagerAidlImpl rg() {
        if (f939de == null) {
            f939de = new IPCServiceManagerAidlImpl((qw) null);
        }
        return f939de;
    }

    public static IBinder th(String str, boolean z) {
        if (z) {
            return new qw(str);
        }
        try {
            return yj().getService(str);
        } catch (RemoteException e) {
            uk("MultiProcess", e);
            th.ad(e);
            return null;
        }
    }

    public static void uk(String str, Exception exc) {
    }

    public static IPCServiceManagerAidl yj() {
        IPCServiceManagerAidl iPCServiceManagerAidl = qw;
        if (iPCServiceManagerAidl != null) {
            return iPCServiceManagerAidl;
        }
        IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(f938ad);
        qw = asInterface;
        return asInterface;
    }
}
