package fe.mmm.qw.ggg.ad;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import fe.mmm.qw.p030switch.de.qw.qw;

public class de extends qw {
    public de(fe.mmm.qw.a.yj.qw.de deVar) {
        super(deVar);
    }

    public void ad(Intent intent, String str, String str2, String str3, ResultReceiver resultReceiver, Context context) {
        if ("com.dubox.drive.ACTION_SEND_ACTIVE".equals(str3)) {
            this.qw.ad(new rg(context, intent, resultReceiver, str, str2));
            return;
        }
        throw new IllegalArgumentException(str3 + " unhandled");
    }

    public boolean de(String str) {
        return "com.dubox.drive.ACTION_SEND_APP_ACTIVATE".equals(str) || "com.dubox.drive.ACTION_SEND_ACTIVE".equals(str);
    }
}
