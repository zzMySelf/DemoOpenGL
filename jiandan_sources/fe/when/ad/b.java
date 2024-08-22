package fe.when.ad;

public final class b {

    /* renamed from: rg  reason: collision with root package name */
    public static b f9311rg;

    /* renamed from: ad  reason: collision with root package name */
    public String f9312ad = "5.5.1";

    /* renamed from: de  reason: collision with root package name */
    public String f9313de = null;

    /* renamed from: fe  reason: collision with root package name */
    public String f9314fe = (this.qw + " " + this.f9312ad + " ©2000-2014 iText Group NV");
    public String qw = "iText®";

    public static b qw() {
        if (f9311rg == null) {
            f9311rg = new b();
            try {
                Class<?> cls = Class.forName("com.itextpdf.license.LicenseKey");
                String[] strArr = (String[]) cls.getMethod("getLicenseeInfo", new Class[0]).invoke(cls.newInstance(), new Object[0]);
                if (strArr[3] == null || strArr[3].trim().length() <= 0) {
                    f9311rg.f9313de = "Trial version ";
                    if (strArr[5] == null) {
                        StringBuilder sb = new StringBuilder();
                        b bVar = f9311rg;
                        sb.append(bVar.f9313de);
                        sb.append("unauthorised");
                        bVar.f9313de = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        b bVar2 = f9311rg;
                        sb2.append(bVar2.f9313de);
                        sb2.append(strArr[5]);
                        bVar2.f9313de = sb2.toString();
                    }
                } else {
                    f9311rg.f9313de = strArr[3];
                }
                if (strArr[4] == null || strArr[4].trim().length() <= 0) {
                    if (strArr[2] != null) {
                        if (strArr[2].trim().length() > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            b bVar3 = f9311rg;
                            sb3.append(bVar3.f9314fe);
                            sb3.append(" (");
                            sb3.append(strArr[2]);
                            bVar3.f9314fe = sb3.toString();
                            if (!f9311rg.f9313de.toLowerCase().startsWith("trial")) {
                                StringBuilder sb4 = new StringBuilder();
                                b bVar4 = f9311rg;
                                sb4.append(bVar4.f9314fe);
                                sb4.append("; licensed version)");
                                bVar4.f9314fe = sb4.toString();
                            } else {
                                StringBuilder sb5 = new StringBuilder();
                                b bVar5 = f9311rg;
                                sb5.append(bVar5.f9314fe);
                                sb5.append("; ");
                                sb5.append(f9311rg.f9313de);
                                sb5.append(")");
                                bVar5.f9314fe = sb5.toString();
                            }
                        }
                    }
                    if (strArr[0] == null || strArr[0].trim().length() <= 0) {
                        throw new Exception();
                    }
                    StringBuilder sb6 = new StringBuilder();
                    b bVar6 = f9311rg;
                    sb6.append(bVar6.f9314fe);
                    sb6.append(" (");
                    sb6.append(strArr[0]);
                    bVar6.f9314fe = sb6.toString();
                    if (!f9311rg.f9313de.toLowerCase().startsWith("trial")) {
                        StringBuilder sb7 = new StringBuilder();
                        b bVar7 = f9311rg;
                        sb7.append(bVar7.f9314fe);
                        sb7.append("; licensed version)");
                        bVar7.f9314fe = sb7.toString();
                    } else {
                        StringBuilder sb8 = new StringBuilder();
                        b bVar8 = f9311rg;
                        sb8.append(bVar8.f9314fe);
                        sb8.append("; ");
                        sb8.append(f9311rg.f9313de);
                        sb8.append(")");
                        bVar8.f9314fe = sb8.toString();
                    }
                } else {
                    f9311rg.f9314fe = strArr[4];
                }
            } catch (Exception unused) {
                StringBuilder sb9 = new StringBuilder();
                b bVar9 = f9311rg;
                sb9.append(bVar9.f9314fe);
                sb9.append(" (AGPL-version)");
                bVar9.f9314fe = sb9.toString();
            }
        }
        return f9311rg;
    }

    public String ad() {
        return this.f9313de;
    }

    public String de() {
        return this.f9312ad;
    }

    public String fe() {
        return this.f9314fe;
    }
}
