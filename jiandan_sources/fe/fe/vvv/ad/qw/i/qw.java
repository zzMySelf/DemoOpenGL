package fe.fe.vvv.ad.qw.i;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import fe.fe.vvv.ad.qw.ad;
import fe.fe.vvv.ad.qw.de;

public class qw extends fe.fe.vvv.ad.qw.uk.qw {
    public qw() {
        super(0, 100);
    }

    public Bundle fe(String str, String str2, Bundle bundle) {
        if ("_get_service_handler".equals(str)) {
            return ad.qw();
        }
        return null;
    }

    public String i(int i2, Uri uri) {
        return null;
    }

    public int nn(int i2, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public Uri o(int i2, Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean rg(String str, String str2, Bundle bundle) {
        return "_get_service_handler".equals(str);
    }

    public int th(int i2, Uri uri, String str, String[] strArr) {
        return 0;
    }

    public void uk(UriMatcher uriMatcher, String str) {
        uriMatcher.addURI(str, "ipc_manager/method/get_service_handler", 1);
    }

    public boolean when() {
        return false;
    }

    public Cursor xxx(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (i2 == 1) {
            return new de(ad.qw());
        }
        return null;
    }

    public void yj(Uri uri, int i2) {
        if (i2 != 3) {
            super.yj(uri, i2);
        }
    }
}
