package fe.mmm.qw.ggg.ad;

import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.ubc.UBCManager;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.libanalytics.activation.model.ReportUserResponse;
import com.tera.scan.network.network.exception.RemoteException;
import fe.mmm.qw.ggg.ad.yj.de;
import fe.mmm.qw.j.when;
import fe.mmm.qw.nn.de.ad;
import fe.mmm.qw.nn.qw.qw.fe;
import fe.mmm.qw.nn.qw.qw.uk;
import fe.mmm.qw.yj.th;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import org.json.JSONException;

public class qw extends ad {
    public qw(String str, String str2) {
        super(str, str2, new fe());
        yj(fe.mmm.qw.nn.rg.ad.qw(str));
    }

    public ReportUserResponse i(String str, String str2, String str3, long j) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, JSONException, RemoteException {
        String str4;
        String str5 = fe.mmm.qw.rg.ad.ad.ad() + "report/user";
        fe.mmm.qw.nn.de.o.ad adVar = new fe.mmm.qw.nn.de.o.ad();
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        adVar.ad("timestamp", String.valueOf(j));
        adVar.ad("action", str);
        String str6 = "";
        if (str2 != null && !str6.equals(str2)) {
            adVar.ad("channel_id", str2);
        }
        if (str3 != null && !str6.equals(str3)) {
            adVar.ad("bind_uid", str3);
        }
        if (!th.ppp().fe("key_is_old_user", false)) {
            adVar.ad("needrookie", "1");
        }
        String uk2 = th.ppp().uk("fcm_token_key", "fcm_error_0");
        if (!TextUtils.isEmpty(uk2)) {
            adVar.ad("fcm_token", uk2);
        }
        String str7 = null;
        if ("ANDROID_ACTIVE_FRONTDESK".equals(str)) {
            str7 = th.ppp().uk("key_report_user_source_url", (String) null);
        }
        if (!TextUtils.isEmpty(str7)) {
            adVar.ad(UBCManager.CONTENT_KEY_SOURCE, str7);
        }
        String yj2 = th.ppp().yj("key_report_user_start_source");
        if (TextUtils.isEmpty(yj2)) {
            yj2 = de.ad();
        }
        adVar.ad("start_source", yj2);
        NotificationManager notificationManager = (NotificationManager) BaseApplication.getInstance().getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (Build.VERSION.SDK_INT < 24 || notificationManager.areNotificationsEnabled()) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        adVar.ad("push_on", str4);
        adVar.ad(b.D0, "1");
        StringBuilder sb = new StringBuilder();
        sb.append("url:");
        sb.append(str5);
        sb.append("&timestamp=");
        sb.append(j);
        sb.append("&action=");
        sb.append(str);
        if (!TextUtils.isEmpty(str7)) {
            str6 = "&source=" + str7;
        }
        sb.append(str6);
        sb.append("&push_on=");
        sb.append(str4);
        sb.append("&backup_on \n start_source ");
        sb.append(yj2);
        sb.append(" \n fcm_token ");
        sb.append(uk2);
        fe.mmm.qw.i.qw.ad("ActivationApi", sb.toString());
        ReportUserResponse reportUserResponse = (ReportUserResponse) new uk().qw(ad(str5, adVar), new fe.mmm.qw.nn.qw.qw.pf.qw(ReportUserResponse.class));
        if (reportUserResponse != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String qw = when.qw(j);
            String qw2 = when.qw(currentTimeMillis);
            if (!TextUtils.isEmpty(str) && qw.equals(qw2) && !"ANDROID_ACTIVE_LOGOUT".equals(str)) {
                th.ppp().m1013switch(str, qw2);
                th.ppp().ad();
            }
            int i2 = reportUserResponse.isnew;
            if (i2 == 0) {
                th.ppp().o("key_is_old_user", true);
                th.ppp().ad();
            } else if (i2 == 1) {
                th.ppp().o("key_is_old_user", false);
                th.ppp().ad();
            }
        }
        return reportUserResponse;
    }
}
