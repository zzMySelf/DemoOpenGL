package fe.mmm.qw.ggg.ad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tera.scan.libanalytics.activation.model.ReportUserResponse;
import com.tera.scan.network.network.exception.RemoteException;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.a.yj.qw.qw;
import fe.mmm.qw.j.when;
import fe.mmm.qw.yj.th;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import org.json.JSONException;

public class rg extends qw {
    public final Intent ddd;
    public final ResultReceiver ggg;
    public final String vvv;
    public final String xxx;

    public rg(Context context, Intent intent, ResultReceiver resultReceiver, String str, String str2) {
        super("SendActiveJob");
        this.ddd = intent;
        this.ggg = resultReceiver;
        this.vvv = str;
        this.xxx = str2;
    }

    public void ppp() {
        String str;
        Intent intent = this.ddd;
        if (intent != null && intent.hasExtra("com.dubox.drive.extra.ACTIVE_ACTION_TYPE")) {
            String stringExtra = this.ddd.getStringExtra("com.dubox.drive.extra.ACTIVE_ACTION_TYPE");
            String fe2 = RequestCommonParams.fe();
            String str2 = null;
            if (th.ppp().i("bind_uid")) {
                str2 = th.ppp().yj("bind_uid");
            }
            String str3 = str2;
            long longExtra = this.ddd.getLongExtra("com.dubox.drive.extra.EXTRA_REPORT_TIMESTAMP", -1);
            if (longExtra == -1) {
                longExtra = System.currentTimeMillis();
            }
            long j = longExtra;
            String qw = when.qw(j);
            String yj2 = th.ppp().yj(stringExtra);
            fe.mmm.qw.i.qw.ad("SendActiveJob", "day::" + qw + ":" + stringExtra + ":" + yj2);
            if (TextUtils.isEmpty(fe2) || TextUtils.isEmpty(str3) || !qw.equals(yj2)) {
                ReportUserResponse vvv2 = vvv(this.vvv, this.xxx, stringExtra, fe2, str3, j);
                if (vvv2 == null) {
                    str = "";
                } else {
                    str = vvv2.uinfo;
                }
                if (!TextUtils.isEmpty(str)) {
                    th.ppp().m1013switch("net_param_sk", str);
                    if (th.ppp().i("key_report_user_source_url")) {
                        th.ppp().when("key_report_user_source_url");
                    }
                    th.ppp().ad();
                }
                ResultReceiver resultReceiver = this.ggg;
                if (resultReceiver != null) {
                    resultReceiver.send(TextUtils.isEmpty(str) ? 2 : 1, Bundle.EMPTY);
                    return;
                }
                return;
            }
            fe.mmm.qw.i.qw.ad("SendActiveJob", "isActivited:: 已发送过日活，取消发送");
        }
    }

    public ReportUserResponse vvv(String str, String str2, String str3, String str4, String str5, long j) {
        try {
            return new qw(str, str2).i(str3, str4, str5, j);
        } catch (IOException e) {
            fe.mmm.qw.i.qw.th("SendActiveJob", "", e);
            return null;
        } catch (RemoteException e2) {
            fe.mmm.qw.i.qw.th("SendActiveJob", "", e2);
            return null;
        } catch (KeyManagementException e3) {
            fe.mmm.qw.i.qw.th("SendActiveJob", "", e3);
            return null;
        } catch (UnrecoverableKeyException e4) {
            fe.mmm.qw.i.qw.th("SendActiveJob", "", e4);
            return null;
        } catch (NoSuchAlgorithmException e5) {
            fe.mmm.qw.i.qw.th("SendActiveJob", "", e5);
            return null;
        } catch (KeyStoreException e6) {
            fe.mmm.qw.i.qw.th("SendActiveJob", "", e6);
            return null;
        } catch (JSONException e7) {
            fe.mmm.qw.i.qw.th("SendActiveJob", "", e7);
            return null;
        }
    }
}
