package fe.fe.pf.i.fe.ad;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.helios.ids.oid.brand.g;

public class i {
    public static void qw(Context context, g.a aVar) {
        String str;
        if (context == null) {
            aVar.qw(false, (String) null);
            return;
        }
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null) {
                str = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                query.close();
            } else {
                str = null;
            }
            aVar.qw(true, str);
        } catch (Throwable unused) {
            aVar.qw(false, (String) null);
        }
    }
}
