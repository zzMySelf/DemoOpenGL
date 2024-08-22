package fe.fe.nn.qw;

import android.content.Context;
import android.content.SharedPreferences;
import fe.fe.nn.ppp.de;

public class fe {
    public SharedPreferences qw;

    public fe(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.qw = sharedPreferences;
            sharedPreferences.edit();
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }

    public String qw() {
        return this.qw.getString("xyus", "");
    }
}
