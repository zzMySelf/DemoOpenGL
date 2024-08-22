package fe.mmm.qw.th.qw.th;

import android.content.Context;
import android.content.SharedPreferences;

public class rg {
    public static void ad(Context context, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("SharedGlobalConfig", 0).edit();
            edit.putBoolean("privacy_agreement_dialog_agree_btn_clicked", z);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean qw(Context context) {
        try {
            return context.getSharedPreferences("SharedGlobalConfig", 0).getBoolean("privacy_agreement_dialog_agree_btn_clicked", false);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
