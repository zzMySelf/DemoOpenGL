package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.helios.bridge.BaseBridge;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.helios.bridge.multiprocess.f;
import fe.fe.pf.fe.ad.ad;
import fe.fe.pf.yj.fe.de.de;

public class g extends BaseBridge implements IBinder.DeathRecipient {

    /* renamed from: de  reason: collision with root package name */
    public ContentProviderClient f784de;

    /* renamed from: fe  reason: collision with root package name */
    public e f785fe;

    /* renamed from: rg  reason: collision with root package name */
    public ad f786rg;

    /* renamed from: th  reason: collision with root package name */
    public String f787th;

    public g(ad adVar, String str) {
        this.f786rg = adVar;
        this.f787th = str;
    }

    public static IBinder ggg(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder("bridge_binder");
        }
        try {
            bundle.setClassLoader(b.class.getClassLoader());
            return ((b) bundle.getParcelable("bridge_binder")).a();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static BaseBridge.de m14if(Bundle bundle) {
        return new BaseBridge.de(bundle.getInt("errcode"), bundle.getString("id"), (Exception) null);
    }

    public static Bundle pf(BaseBridge.de deVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("errcode", deVar.f778ad);
        bundle.putString("id", deVar.qw);
        return bundle;
    }

    public static void when(Bundle bundle, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("bridge_binder", iBinder);
        } else {
            bundle.putParcelable("bridge_binder", new b(iBinder));
        }
    }

    public void binderDied() {
        this.f786rg.pf();
    }

    public void fe() {
        try {
            if (this.f785fe != null) {
                this.f785fe.a();
            }
        } catch (RemoteException unused) {
        }
    }

    public final Bundle i(ContentProviderClient contentProviderClient, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return contentProviderClient.call(str, (String) null, (Bundle) null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final Bundle o(Context context, boolean z, Uri uri, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        Bundle bundle = null;
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            ContentProviderClient acquireContentProviderClient = z ? contentResolver.acquireContentProviderClient(uri) : contentResolver.acquireUnstableContentProviderClient(uri);
            if (acquireContentProviderClient != null && (bundle = i(acquireContentProviderClient, str)) == null) {
                bundle = uk(acquireContentProviderClient, uri);
            }
            if (bundle != null) {
                this.f784de = acquireContentProviderClient;
                break;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException unused) {
            }
            i2++;
        }
        return bundle;
    }

    public boolean ppp() {
        return this.f785fe != null;
    }

    public void qw(String str, Bundle bundle, final BaseBridge.OnGetResultCallback<String> onGetResultCallback) {
        try {
            this.f785fe.a(str, bundle, new f.b() {
                public void a(int i2, Bundle bundle) {
                    onGetResultCallback.qw(i2, (Exception) null, bundle);
                }

                public void a(String str, Bundle bundle) {
                    onGetResultCallback.onResult(str, bundle);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean rg(String str) {
        try {
            return this.f785fe.a(str);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final String m15switch(Context context) {
        return context.getPackageName() + this.f787th;
    }

    public void th(BaseBridge.ad adVar) {
        this.f785fe = vvv(this.qw.f781de);
    }

    public final Bundle uk(ContentProviderClient contentProviderClient, Uri uri) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = contentProviderClient.query(Uri.withAppendedPath(uri, BaseIPCProvider.a), (String[]) null, (String) null, (String[]) null, (String) null);
            try {
                Bundle extras = cursor.getExtras();
                de.qw(cursor);
                return extras;
            } catch (Exception unused) {
                de.qw(cursor);
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                de.qw(cursor2);
                throw th;
            }
        } catch (Exception unused2) {
            cursor = null;
            de.qw(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            de.qw(cursor2);
            throw th;
        }
    }

    public final e vvv(Context context) {
        IBinder ggg;
        Bundle o2 = o(context, false, Uri.parse("content://" + m15switch(context)), BaseIPCProvider.b);
        String str = "remote bridge bundle result is " + o2;
        if (o2 == null || (ggg = ggg(o2)) == null) {
            return null;
        }
        return e.b.a(ggg);
    }

    public BaseBridge.de yj(String str, Bundle bundle) {
        try {
            Bundle a = this.f785fe.a(str, bundle);
            if (a != null) {
                return m14if(a);
            }
        } catch (RemoteException unused) {
        }
        return BaseBridge.de.qw(-1, (Exception) null);
    }
}
