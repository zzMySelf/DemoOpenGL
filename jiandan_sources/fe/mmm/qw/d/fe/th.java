package fe.mmm.qw.d.fe;

import android.content.Context;
import android.content.SharedPreferences;

public class th {
    public static String ad(Context context, String str) {
        return de(context, str, (String) null);
    }

    public static String de(Context context, String str, String str2) {
        return context.getSharedPreferences("netdisk_skin_prefer", 0).getString(str, str2);
    }

    public static boolean fe(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("netdisk_skin_prefer", 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public static boolean qw(Context context, String str, boolean z) {
        return context.getSharedPreferences("netdisk_skin_prefer", 0).getBoolean(str, z);
    }
}
