package fe.i.ad.qw.qw;

import android.content.Context;
import com.dxmpay.wallet.base.nopassauth.OtpTokenUtils;
import java.util.Calendar;
import java.util.TimeZone;

public class ad extends qw {

    /* renamed from: rg  reason: collision with root package name */
    public int f4451rg;

    public ad(String str, int i2, long j, int i3) {
        super(str, 0, i3);
        this.f4451rg = i2;
    }

    public String a(Context context) {
        super.qw(((Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis() / 1000) - OtpTokenUtils.getmSyncWithServerTime(context)) / ((long) this.f4451rg));
        return super.a(context);
    }
}
