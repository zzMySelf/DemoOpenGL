package fe.fe.nn.rg;

import com.baidu.sapi2.activity.LoginActivity;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public int f2309ad;

    /* renamed from: de  reason: collision with root package name */
    public int f2310de;

    /* renamed from: fe  reason: collision with root package name */
    public String f2311fe;
    public int qw = -1;

    public de(int i2, int i3, int i4, String str) {
        this.qw = i2;
        this.f2309ad = i3;
        this.f2310de = i4;
        this.f2311fe = str;
    }

    public static de qw() {
        return new de(3, LoginActivity.REQUEST_SHARE_V2_LOGIN, -1, "No Authorized User Privacy Agreement");
    }

    public String toString() {
        return "CallBackMsg{status=" + this.qw + ", subStatus=" + this.f2309ad + ", op='" + this.f2310de + ExtendedMessageFormat.QUOTE + ", data='" + this.f2311fe + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
