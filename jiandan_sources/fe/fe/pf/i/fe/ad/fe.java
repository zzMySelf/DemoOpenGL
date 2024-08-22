package fe.fe.pf.i.fe.ad;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.helios.ids.oid.brand.g;

public class fe {
    public static void qw(Context context, g.a aVar) {
        String str;
        if (context == null) {
            aVar.qw(false, (String) null);
            return;
        }
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"oaid"}, (String) null);
            if (query != null) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("value");
                str = columnIndex > 0 ? query.getString(columnIndex) : null;
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
