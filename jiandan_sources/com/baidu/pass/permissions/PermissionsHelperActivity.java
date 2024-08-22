package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.pass.view.CommonDialog;

public class PermissionsHelperActivity extends Activity {
    public static final int e = 8000;
    public static final int f = 8001;
    public fe.fe.ppp.de.de a;
    public fe.fe.ppp.de.ad b;
    public StringBuilder c;
    public boolean d;

    public class ad implements View.OnClickListener {
        public ad() {
        }

        public void onClick(View view) {
            fe.fe.ppp.ad.de.de(PermissionsHelperActivity.this.c.toString(), Boolean.TRUE);
            PermissionsHelperActivity permissionsHelperActivity = PermissionsHelperActivity.this;
            permissionsHelperActivity.requestPermissions(permissionsHelperActivity.a.f2996th, PermissionsHelperActivity.f);
        }
    }

    public class de implements View.OnClickListener {
        public de() {
        }

        public void onClick(View view) {
            PermissionsHelperActivity.this.b.onFailure(-1);
            PermissionsHelperActivity.this.finish();
        }
    }

    public class fe implements View.OnClickListener {
        public fe() {
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", PermissionsHelperActivity.this.getPackageName(), (String) null));
            PermissionsHelperActivity.this.startActivityForResult(intent, PermissionsHelperActivity.e);
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            PermissionsHelperActivity.this.b.onFailure(-2);
            PermissionsHelperActivity.this.finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 8000) {
            if (fe.fe.ppp.de.qw.rg().de(fe.fe.ppp.de.qw.rg().yj().f2996th)) {
                this.b.onSuccess();
            } else {
                this.b.onFailure(-1);
            }
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = fe.fe.ppp.de.qw.rg().yj();
        fe.fe.ppp.de.ad th2 = fe.fe.ppp.de.qw.rg().th();
        this.b = th2;
        if (this.a == null) {
            if (th2 != null) {
                th2.onFailure(-1);
            }
            finish();
            return;
        }
        this.c = new StringBuilder();
        for (String append : this.a.f2996th) {
            this.c.append(append);
        }
        fe.fe.ppp.ad.de.ad(this);
        if (((Boolean) fe.fe.ppp.ad.de.qw(this.c.toString(), Boolean.FALSE)).booleanValue() || TextUtils.isEmpty(this.a.f2998yj)) {
            requestPermissions(this.a.f2996th, f);
            return;
        }
        CommonDialog.qw qwVar = new CommonDialog.qw(this);
        qwVar.uk(this.a.f2998yj);
        qwVar.rg(this.a.f2997uk);
        qwVar.fe(this.a.f2993i);
        qwVar.yj(this.a.f2994o, new ad());
        qwVar.th(this.a.f2995pf, new qw());
        qwVar.de().show();
        this.d = true;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 8001) {
            boolean z = false;
            boolean z2 = true;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (iArr[i3] == 0) {
                    fe.fe.ppp.ad.qw.rg("PassPermissions", "Permission check result is permission granted");
                } else if (TextUtils.isEmpty(this.a.f2997uk)) {
                    this.b.onFailure(-1);
                    finish();
                    return;
                } else {
                    if (!shouldShowRequestPermissionRationale(strArr[i3])) {
                        z = true;
                    }
                    z2 = false;
                }
            }
            if (z && !this.d && this.a.f91if) {
                CommonDialog.qw qwVar = new CommonDialog.qw(this);
                qwVar.uk(this.a.f2998yj);
                qwVar.rg(this.a.f2997uk);
                qwVar.yj(this.a.f2994o, new fe());
                qwVar.th(this.a.f2995pf, new de());
                qwVar.de().show();
            } else if (z2) {
                this.b.onSuccess();
                finish();
            } else {
                this.b.onFailure(-1);
                finish();
            }
        }
    }
}
