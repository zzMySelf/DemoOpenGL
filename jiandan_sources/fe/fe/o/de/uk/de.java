package fe.fe.o.de.uk;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public String f2503ad = null;

    /* renamed from: de  reason: collision with root package name */
    public int f2504de = 200;

    /* renamed from: fe  reason: collision with root package name */
    public Map f2505fe = null;
    public String qw = null;

    /* renamed from: rg  reason: collision with root package name */
    public Map f2506rg = null;

    public de(String str, String str2, int i2) {
        this.qw = str;
        this.f2503ad = str2;
        this.f2504de = i2;
        this.f2505fe = new HashMap();
        this.f2506rg = new HashMap();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.qw + " " + this.f2504de + " " + this.f2503ad + StringUtils.LF);
        for (String str : this.f2505fe.keySet()) {
            sb.append(str);
            sb.append(":");
            sb.append((String) this.f2505fe.get(str));
            sb.append(StringUtils.LF);
        }
        sb.append("=== Response ===\n");
        for (String str2 : this.f2506rg.keySet()) {
            sb.append(str2);
            sb.append(":");
            sb.append((String) this.f2506rg.get(str2));
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }
}
