package fe.qw.qw.p009switch;

/* renamed from: fe.qw.qw.switch.th  reason: invalid package */
public class th {

    /* renamed from: fe  reason: collision with root package name */
    public static String f3496fe = "\r";

    /* renamed from: ad  reason: collision with root package name */
    public final float f3497ad;

    /* renamed from: de  reason: collision with root package name */
    public final float f3498de;
    public final String qw;

    public th(String str, float f, float f2) {
        this.qw = str;
        this.f3498de = f2;
        this.f3497ad = f;
    }

    public boolean qw(String str) {
        if (this.qw.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.qw.endsWith(f3496fe)) {
            String str2 = this.qw;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
