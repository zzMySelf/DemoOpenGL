package fe.p036switch.qw;

import com.baidu.android.common.others.lang.StringUtil;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;

/* renamed from: fe.switch.qw.g  reason: invalid package */
public class g {

    /* renamed from: ad  reason: collision with root package name */
    public final String f8811ad;

    /* renamed from: de  reason: collision with root package name */
    public final String[] f8812de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f8813fe;
    public final String qw;

    /* renamed from: fe.switch.qw.g$ad */
    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public String f8814ad = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;

        /* renamed from: de  reason: collision with root package name */
        public boolean f8815de = false;

        /* renamed from: fe  reason: collision with root package name */
        public String[] f8816fe;
        public String qw = "/";

        public g rg() {
            return new g(this);
        }
    }

    public static g qw() {
        return new ad().rg();
    }

    public String ad() {
        return this.f8811ad;
    }

    public String de() {
        return this.qw;
    }

    public String[] fe() {
        return this.f8812de;
    }

    public boolean rg() {
        return this.f8813fe;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        String[] strArr = this.f8812de;
        if (strArr == null || strArr.length == 0) {
            sb.append(']');
        } else {
            int i2 = 0;
            while (true) {
                sb.append(String.valueOf(this.f8812de[i2]));
                if (i2 == this.f8812de.length - 1) {
                    break;
                }
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                i2++;
            }
            sb.append(']');
        }
        return "initialRoute:" + this.qw + ", dartEntrypoint:" + this.f8811ad + ", shouldOverrideBackForegroundEvent:" + this.f8813fe + ", shellArgs:" + sb.toString();
    }

    public g(ad adVar) {
        this.qw = adVar.qw;
        this.f8811ad = adVar.f8814ad;
        this.f8812de = adVar.f8816fe;
        this.f8813fe = adVar.f8815de;
    }
}
