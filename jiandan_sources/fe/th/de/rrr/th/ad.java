package fe.th.de.rrr.th;

import com.google.common.net.HttpHeaders;
import fe.th.de.ddd;
import fe.th.de.mmm;
import fe.th.de.pf;
import fe.th.de.rrr.uk.de;
import fe.th.de.rrr.uk.fe;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final mmm f5450ad;
    public final ddd qw;

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final ddd f5451ad;

        /* renamed from: de  reason: collision with root package name */
        public final mmm f5452de;

        /* renamed from: fe  reason: collision with root package name */
        public Date f5453fe;

        /* renamed from: i  reason: collision with root package name */
        public long f5454i;

        /* renamed from: if  reason: not valid java name */
        public int f216if = -1;

        /* renamed from: o  reason: collision with root package name */
        public long f5455o;

        /* renamed from: pf  reason: collision with root package name */
        public String f5456pf;
        public final long qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f5457rg;

        /* renamed from: th  reason: collision with root package name */
        public Date f5458th;

        /* renamed from: uk  reason: collision with root package name */
        public Date f5459uk;

        /* renamed from: yj  reason: collision with root package name */
        public String f5460yj;

        public qw(long j, ddd ddd, mmm mmm) {
            this.qw = j;
            this.f5451ad = ddd;
            this.f5452de = mmm;
            if (mmm != null) {
                this.f5454i = mmm.mmm();
                this.f5455o = mmm.ddd();
                pf pf2 = mmm.pf();
                int yj2 = pf2.yj();
                for (int i2 = 0; i2 < yj2; i2++) {
                    String rg2 = pf2.rg(i2);
                    String uk2 = pf2.uk(i2);
                    if ("Date".equalsIgnoreCase(rg2)) {
                        this.f5453fe = de.ad(uk2);
                        this.f5457rg = uk2;
                    } else if ("Expires".equalsIgnoreCase(rg2)) {
                        this.f5459uk = de.ad(uk2);
                    } else if ("Last-Modified".equalsIgnoreCase(rg2)) {
                        this.f5458th = de.ad(uk2);
                        this.f5460yj = uk2;
                    } else if ("ETag".equalsIgnoreCase(rg2)) {
                        this.f5456pf = uk2;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(rg2)) {
                        this.f216if = fe.fe(uk2, -1);
                    }
                }
            }
        }

        public static boolean rg(ddd ddd) {
            return (ddd.de("If-Modified-Since") == null && ddd.de("If-None-Match") == null) ? false : true;
        }

        public final long ad() {
            long j;
            long j2;
            fe.th.de.de de2 = this.f5452de.de();
            if (de2.fe() != -1) {
                return TimeUnit.SECONDS.toMillis((long) de2.fe());
            }
            if (this.f5459uk != null) {
                Date date = this.f5453fe;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.f5455o;
                }
                long time = this.f5459uk.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f5458th == null || this.f5452de.nn().uk().eee() != null) {
                return 0;
            } else {
                Date date2 = this.f5453fe;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.f5454i;
                }
                long time2 = j - this.f5458th.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        public ad de() {
            ad fe2 = fe();
            return (fe2.qw == null || !this.f5451ad.ad().o()) ? fe2 : new ad((ddd) null, (mmm) null);
        }

        public final ad fe() {
            if (this.f5452de == null) {
                return new ad(this.f5451ad, (mmm) null);
            }
            if (this.f5451ad.rg() && this.f5452de.th() == null) {
                return new ad(this.f5451ad, (mmm) null);
            }
            if (!ad.qw(this.f5452de, this.f5451ad)) {
                return new ad(this.f5451ad, (mmm) null);
            }
            fe.th.de.de ad2 = this.f5451ad.ad();
            if (ad2.uk() || rg(this.f5451ad)) {
                return new ad(this.f5451ad, (mmm) null);
            }
            fe.th.de.de de2 = this.f5452de.de();
            long qw2 = qw();
            long ad3 = ad();
            if (ad2.fe() != -1) {
                ad3 = Math.min(ad3, TimeUnit.SECONDS.toMillis((long) ad2.fe()));
            }
            long j = 0;
            long millis = ad2.th() != -1 ? TimeUnit.SECONDS.toMillis((long) ad2.th()) : 0;
            if (!de2.yj() && ad2.rg() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) ad2.rg());
            }
            if (!de2.uk()) {
                long j2 = millis + qw2;
                if (j2 < j + ad3) {
                    mmm.qw ggg = this.f5452de.ggg();
                    if (j2 >= ad3) {
                        ggg.qw(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (qw2 > 86400000 && th()) {
                        ggg.qw(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new ad((ddd) null, ggg.de());
                }
            }
            String str = this.f5456pf;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f5458th != null) {
                str = this.f5460yj;
            } else if (this.f5453fe == null) {
                return new ad(this.f5451ad, (mmm) null);
            } else {
                str = this.f5457rg;
            }
            pf.qw th2 = this.f5451ad.fe().th();
            fe.th.de.rrr.qw.qw.ad(th2, str2, str);
            ddd.qw yj2 = this.f5451ad.yj();
            yj2.fe(th2.rg());
            return new ad(yj2.ad(), this.f5452de);
        }

        public final long qw() {
            Date date = this.f5453fe;
            long j = 0;
            if (date != null) {
                j = Math.max(0, this.f5455o - date.getTime());
            }
            int i2 = this.f216if;
            if (i2 != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) i2));
            }
            long j2 = this.f5455o;
            return j + (j2 - this.f5454i) + (this.qw - j2);
        }

        public final boolean th() {
            return this.f5452de.de().fe() == -1 && this.f5459uk == null;
        }
    }

    public ad(ddd ddd, mmm mmm) {
        this.qw = ddd;
        this.f5450ad = mmm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.de().ad() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean qw(fe.th.de.mmm r3, fe.th.de.ddd r4) {
        /*
            int r0 = r3.rg()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.yj(r0)
            if (r0 != 0) goto L_0x005a
            fe.th.de.de r0 = r3.de()
            int r0 = r0.fe()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            fe.th.de.de r0 = r3.de()
            boolean r0 = r0.de()
            if (r0 != 0) goto L_0x005a
            fe.th.de.de r0 = r3.de()
            boolean r0 = r0.ad()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            fe.th.de.de r3 = r3.de()
            boolean r3 = r3.i()
            if (r3 != 0) goto L_0x006f
            fe.th.de.de r3 = r4.ad()
            boolean r3 = r3.i()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.th.ad.qw(fe.th.de.mmm, fe.th.de.ddd):boolean");
    }
}
