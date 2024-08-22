package fe.mmm.qw.p030switch.de.qw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tera.scan.framework.framework.FrameworkAccount;
import com.tera.scan.framework.kernel.service.INotifiable;
import com.tera.scan.framework.kernel.service.ISchedulerService;
import fe.mmm.qw.a.yj.qw.de;

/* renamed from: fe.mmm.qw.switch.de.qw.qw  reason: invalid package */
public abstract class qw implements ISchedulerService {
    public final de qw;

    public qw(de deVar) {
        this(deVar, (INotifiable) null);
    }

    public abstract void ad(Intent intent, String str, String str2, String str3, ResultReceiver resultReceiver, Context context);

    public abstract boolean de(String str);

    public void qw(Intent intent, Context context) {
        String stringExtra = intent.getStringExtra("com.mars.extra.BDUSS");
        String action = intent.getAction();
        FrameworkAccount qw2 = fe.mmm.qw.p030switch.rg.qw.qw();
        boolean z = !TextUtils.isEmpty(stringExtra) && !stringExtra.equals(qw2.getBduss());
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("com.mars.extra.RESULT_RECEIVER");
        if (z || (!qw2.isLogin() && !de(action))) {
            fe.mmm.qw.i.qw.ad("BaseScheduledService", action + " cancel");
            if (resultReceiver != null) {
                resultReceiver.send(2, Bundle.EMPTY);
                return;
            }
            return;
        }
        fe.mmm.qw.i.qw.ad("BaseScheduledService", "trace onHandleIntent:" + action);
        ad(intent, stringExtra, intent.getStringExtra("com.mars.extra.UID"), action, resultReceiver, context);
    }

    public qw(de deVar, @Nullable INotifiable iNotifiable) {
        this.qw = deVar;
    }
}
