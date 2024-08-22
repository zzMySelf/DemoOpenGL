package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.helios.bridge.BaseBridge;
import com.baidu.helios.bridge.multiprocess.e;
import fe.fe.pf.fe.ad.de;
import fe.fe.pf.fe.ad.fe;

public abstract class BaseIPCProvider extends ContentProvider {
    public static final String a = "ipc/method/get_bridge";
    public static final String b = "_method_get_bridge";
    public static final String c = "Helios";
    public static final int f = 0;
    public e d;
    public UriMatcher e = new UriMatcher(-1);

    private String a(String str) {
        return str + getAuthoritySuffix();
    }

    private synchronized void a() {
        if (this.d == null) {
            this.d = new e.b() {
                public fe f = new fe(BaseIPCProvider.this.getContext().getApplicationContext());

                /* renamed from: com.baidu.helios.bridge.multiprocess.BaseIPCProvider$1$qw */
                public class qw implements BaseBridge.OnGetResultCallback<String> {
                    public final /* synthetic */ f qw;

                    public qw(AnonymousClass1 r1, f fVar) {
                        this.qw = fVar;
                    }

                    /* renamed from: ad */
                    public void onResult(String str, Bundle bundle) {
                        try {
                            this.qw.a(str, bundle);
                        } catch (RemoteException unused) {
                        }
                    }

                    public void qw(int i2, Exception exc, Bundle bundle) {
                        try {
                            this.qw.a(i2, bundle);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public Bundle a(String str, Bundle bundle) {
                    BaseBridge.de yj2 = this.f.qw().yj(str, bundle);
                    if (yj2 == null) {
                        return null;
                    }
                    return g.pf(yj2);
                }

                public void a() {
                    this.f.qw().fe();
                }

                public void a(String str, Bundle bundle, f fVar) {
                    this.f.qw().qw(str, bundle, new qw(this, fVar));
                }

                public boolean a(String str) {
                    return this.f.qw().rg(str);
                }
            };
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        char c2 = 65535;
        if (str.hashCode() == -1722610639 && str.equals(b)) {
            c2 = 0;
        }
        if (c2 != 0) {
            return null;
        }
        a();
        g.when(bundle2, this.d.asBinder());
        return bundle2;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public abstract String getAuthoritySuffix();

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.e.addURI(a(getContext().getPackageName()), a, 0);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.e.match(uri);
        "provider query, code = " + match;
        if (match != 0) {
            return null;
        }
        a();
        Bundle bundle = new Bundle();
        g.when(bundle, this.d.asBinder());
        return new de(bundle);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
