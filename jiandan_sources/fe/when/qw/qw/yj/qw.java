package fe.when.qw.qw.yj;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.PathIterator;
import com.itextpdf.awt.geom.Shape;

public class qw {

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public double f9931ad;

        /* renamed from: de  reason: collision with root package name */
        public double f9932de;

        /* renamed from: fe  reason: collision with root package name */
        public double f9933fe;
        public double qw;

        /* renamed from: rg  reason: collision with root package name */
        public double f9934rg;

        /* renamed from: th  reason: collision with root package name */
        public double f9935th;

        /* renamed from: uk  reason: collision with root package name */
        public double f9936uk;

        /* renamed from: yj  reason: collision with root package name */
        public double f9937yj;

        public ad(double d, double d2, double d3, double d4, double d5, double d6) {
            double d7 = d5 - d;
            this.qw = d7;
            double d8 = d6 - d2;
            this.f9931ad = d8;
            double d9 = d3 - d;
            this.f9932de = d9;
            double d10 = d4 - d2;
            this.f9933fe = d10;
            double d11 = d9 + d9;
            this.f9937yj = d11;
            this.f9934rg = d7 - d11;
            double d12 = d10 + d10;
            this.f9936uk = d12;
            this.f9935th = d8 - d12;
        }

        public int ad(double[] dArr, int i2, double d, double d2) {
            int i3 = i2;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                double d3 = dArr[i5];
                if (d3 >= -1.0E-5d && d3 <= 1.00001d) {
                    if (d3 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d4 = this.f9932de;
                            if (d4 == 0.0d) {
                                d4 = this.qw - d4;
                            }
                            if (d4 < 0.0d) {
                                i4--;
                            }
                        }
                    } else if (d3 > 0.99999d) {
                        if (d < this.f9931ad) {
                            double d5 = this.qw;
                            double d6 = this.f9932de;
                            if (d5 != d6) {
                                d6 = d5 - d6;
                            }
                            if (d6 > 0.0d) {
                                i4++;
                            }
                        }
                    } else if (((this.f9935th * d3) + this.f9936uk) * d3 > d2) {
                        double d7 = (d3 * this.f9934rg) + this.f9932de;
                        if (d7 <= -1.0E-5d || d7 >= 1.0E-5d) {
                            i4 += d7 > 0.0d ? 1 : -1;
                        }
                    }
                }
            }
            return i4;
        }

        public int de(double[] dArr) {
            double d = this.f9934rg;
            int i2 = 0;
            if (d != 0.0d) {
                dArr[0] = (-this.f9937yj) / (d + d);
                i2 = 1;
            }
            double d2 = this.f9935th;
            if (d2 == 0.0d) {
                return i2;
            }
            dArr[i2] = (-this.f9936uk) / (d2 + d2);
            return i2 + 1;
        }

        public int fe(double[] dArr, double d) {
            return qw.vvv(new double[]{-d, this.f9937yj, this.f9934rg}, dArr);
        }

        public int qw(double[] dArr, int i2, double[] dArr2, int i3, double d, double d2, boolean z, int i4) {
            int i5 = i2;
            int i6 = i3;
            int i7 = i4;
            for (int i8 = 0; i8 < i6; i8++) {
                double d3 = dArr2[i8];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((this.f9934rg * d3) + this.f9937yj) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i9 = i5 + 1;
                        dArr[i5] = d3;
                        int i10 = i9 + 1;
                        dArr[i9] = d4;
                        int i11 = i10 + 1;
                        dArr[i10] = d3 * ((this.f9935th * d3) + this.f9936uk);
                        i5 = i11 + 1;
                        dArr[i11] = (double) i7;
                        if (z) {
                            i7++;
                        }
                    }
                }
            }
            return i5;
        }
    }

    /* renamed from: fe.when.qw.qw.yj.qw$qw  reason: collision with other inner class name */
    public static class C0331qw {

        /* renamed from: ad  reason: collision with root package name */
        public double f9938ad;

        /* renamed from: de  reason: collision with root package name */
        public double f9939de;

        /* renamed from: fe  reason: collision with root package name */
        public double f9940fe;

        /* renamed from: i  reason: collision with root package name */
        public double f9941i;

        /* renamed from: if  reason: not valid java name */
        public double f477if;

        /* renamed from: o  reason: collision with root package name */
        public double f9942o;

        /* renamed from: pf  reason: collision with root package name */
        public double f9943pf;
        public double qw;

        /* renamed from: rg  reason: collision with root package name */
        public double f9944rg;

        /* renamed from: switch  reason: not valid java name */
        public double f478switch;

        /* renamed from: th  reason: collision with root package name */
        public double f9945th;

        /* renamed from: uk  reason: collision with root package name */
        public double f9946uk;
        public double when;

        /* renamed from: yj  reason: collision with root package name */
        public double f9947yj;

        public C0331qw(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            double d9 = d7 - d;
            this.qw = d9;
            double d10 = d8 - d2;
            this.f9938ad = d10;
            double d11 = d3 - d;
            this.f9939de = d11;
            double d12 = d4 - d2;
            this.f9940fe = d12;
            double d13 = d5 - d;
            this.f9944rg = d13;
            double d14 = d6 - d2;
            this.f9945th = d14;
            double d15 = d11 + d11 + d11;
            this.f9943pf = d15;
            double d16 = (((d13 + d13) + d13) - d15) - d15;
            this.f9941i = d16;
            double d17 = (d9 - d16) - d15;
            this.f9947yj = d17;
            double d18 = d12 + d12 + d12;
            this.f477if = d18;
            double d19 = (((d14 + d14) + d14) - d18) - d18;
            this.f9942o = d19;
            this.f9946uk = (d10 - d19) - d18;
            this.f478switch = d17 + d17 + d17;
            this.when = d16 + d16;
        }

        public int ad(double[] dArr, int i2, double d, double d2) {
            double d3;
            int i3 = i2;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                double d4 = dArr[i5];
                if (d4 >= -1.0E-5d && d4 <= 1.00001d) {
                    if (d4 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d5 = this.f9939de;
                            if (d5 == 0.0d) {
                                double d6 = this.f9944rg;
                                d5 = d6 != d5 ? d6 - d5 : this.qw - d6;
                            }
                            if (d5 < 0.0d) {
                                i4--;
                            }
                        }
                    } else if (d4 > 0.99999d) {
                        if (d < this.f9938ad) {
                            double d7 = this.qw;
                            double d8 = this.f9944rg;
                            if (d7 != d8) {
                                d3 = d7 - d8;
                            } else {
                                d3 = this.f9939de;
                                if (d8 != d3) {
                                    d3 = d8 - d3;
                                }
                            }
                            if (d3 > 0.0d) {
                                i4++;
                            }
                        }
                    } else if (((((this.f9946uk * d4) + this.f9942o) * d4) + this.f477if) * d4 > d2) {
                        double d9 = this.f478switch;
                        double d10 = this.when;
                        double d11 = (((d4 * d9) + d10) * d4) + this.f9943pf;
                        if (d11 > -1.0E-5d && d11 < 1.0E-5d) {
                            double d12 = (d4 * (d9 + d9)) + d10;
                            if (d12 >= -1.0E-5d && d12 <= 1.0E-5d) {
                                d11 = this.qw;
                            }
                        }
                        i4 += d11 > 0.0d ? 1 : -1;
                    }
                }
            }
            return i4;
        }

        public int de(double[] dArr) {
            return qw.vvv(new double[]{this.f9943pf, this.when, this.f478switch}, dArr);
        }

        public int fe(double[] dArr) {
            double d = this.f9942o;
            double d2 = this.f9946uk;
            return qw.vvv(new double[]{this.f477if, d + d, d2 + d2 + d2}, dArr);
        }

        public int qw(double[] dArr, int i2, double[] dArr2, int i3, double d, double d2, boolean z, int i4) {
            int i5 = i2;
            int i6 = i3;
            int i7 = i4;
            for (int i8 = 0; i8 < i6; i8++) {
                double d3 = dArr2[i8];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((((this.f9947yj * d3) + this.f9941i) * d3) + this.f9943pf) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i9 = i5 + 1;
                        dArr[i5] = d3;
                        int i10 = i9 + 1;
                        dArr[i9] = d4;
                        int i11 = i10 + 1;
                        dArr[i10] = d3 * ((((this.f9946uk * d3) + this.f9942o) * d3) + this.f477if);
                        i5 = i11 + 1;
                        dArr[i11] = (double) i7;
                        if (z) {
                            i7++;
                        }
                    }
                }
            }
            return i5;
        }

        public int rg(double[] dArr, double d) {
            return qw.ggg(new double[]{-d, this.f9943pf, this.f9941i, this.f9947yj}, dArr);
        }
    }

    public static int ad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        int i2;
        int i3 = (d9 > d ? 1 : (d9 == d ? 0 : -1));
        if ((i3 < 0 && d9 < d3 && d9 < d5 && d9 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || ((d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8) || (d == d3 && d3 == d5 && d5 == d7)))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && d10 < d8 && i2 != 0 && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || i3 >= 0) ? 0 : -1;
        }
        C0331qw qwVar = r0;
        C0331qw qwVar2 = new C0331qw(d, d2, d3, d4, d5, d6, d7, d8);
        double d11 = d10 - d2;
        double[] dArr = new double[3];
        C0331qw qwVar3 = qwVar;
        return qwVar3.ad(dArr, qwVar3.rg(dArr, d9 - d), d11, d11);
    }

    public static int de(double d, double d2, double d3, double d4, double d5, double d6) {
        int i2;
        if ((d5 < d && d5 < d3) || ((d5 > d && d5 > d3) || ((d6 > d2 && d6 > d4) || d == d3))) {
            return 0;
        }
        if ((d6 >= d2 || d6 >= d4) && ((d4 - d2) * (d5 - d)) / (d3 - d) <= d6 - d2) {
            return 0;
        }
        return i2 == 0 ? d < d3 ? 0 : -1 : d5 == d3 ? d < d3 ? 1 : 0 : d < d3 ? 1 : -1;
    }

    public static int fe(PathIterator pathIterator, double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        char c;
        double[] dArr = new double[6];
        int i2 = 0;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i3 = 0;
        while (true) {
            if (pathIterator.isDone()) {
                d3 = d7;
                d4 = d8;
                d5 = d9;
                d6 = d10;
                i2 = i3;
                break;
            }
            int ad2 = pathIterator.ad(dArr);
            if (ad2 == 0) {
                if (d8 == d7 && d9 == d10) {
                    c = 1;
                } else {
                    c = 1;
                    i3 += de(d8, d9, d7, d10, d, d2);
                }
                double d11 = dArr[0];
                d10 = dArr[c];
                d9 = d10;
                d8 = d11;
                d7 = d8;
            } else if (ad2 == 1) {
                double d12 = dArr[0];
                double d13 = dArr[1];
                i3 += de(d8, d9, d12, d13, d, d2);
                d8 = d12;
                d9 = d13;
            } else if (ad2 == 2) {
                double d14 = dArr[0];
                double d15 = dArr[1];
                double d16 = dArr[2];
                double d17 = dArr[3];
                i3 += rg(d8, d9, d14, d15, d16, d17, d, d2);
                d8 = d16;
                d9 = d17;
            } else if (ad2 == 3) {
                double d18 = dArr[3];
                double d19 = dArr[4];
                double d20 = dArr[5];
                i3 += ad(d8, d9, dArr[0], dArr[1], dArr[2], d18, d19, d20, d, d2);
                d8 = d19;
                d9 = d20;
            } else if (ad2 == 4 && !(d9 == d10 && d8 == d7)) {
                i3 += de(d8, d9, d7, d10, d, d2);
                d8 = d7;
                d9 = d10;
            }
            if (d == d8 && d2 == d9) {
                d3 = d7;
                d4 = d8;
                d5 = d10;
                d6 = d5;
                break;
            }
            pathIterator.next();
        }
        return d5 != d6 ? i2 + de(d4, d5, d3, d6, d, d2) : i2;
    }

    public static int ggg(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        int i2 = 3;
        double d = dArr[3];
        if (d == 0.0d) {
            return vvv(dArr, dArr2);
        }
        double d2 = dArr[2] / d;
        double d3 = dArr[1] / d;
        double d4 = dArr[0] / d;
        double d5 = ((d2 * d2) - (d3 * 3.0d)) / 9.0d;
        double d6 = (((((d2 * 2.0d) * d2) * d2) - ((9.0d * d2) * d3)) + (d4 * 27.0d)) / 54.0d;
        double d7 = d5 * d5 * d5;
        double d8 = d6 * d6;
        double d9 = (-d2) / 3.0d;
        if (d8 < d7) {
            double acos = Math.acos(d6 / Math.sqrt(d7)) / 3.0d;
            double sqrt = Math.sqrt(d5) * -2.0d;
            dArr3[0] = (Math.cos(acos) * sqrt) + d9;
            dArr3[1] = (Math.cos(acos + 2.0943951023931953d) * sqrt) + d9;
            dArr3[2] = (sqrt * Math.cos(acos - 2.0943951023931953d)) + d9;
        } else {
            double d10 = d8 - d7;
            double sqrt2 = Math.sqrt(d10) + Math.abs(d6);
            double d11 = d9;
            double pow = Math.pow(sqrt2, 0.3333333333333333d);
            if (d6 > 0.0d) {
                pow = -pow;
            }
            if (-1.0E-10d >= pow || pow >= 1.0E-10d) {
                double d12 = pow + (d5 / pow);
                dArr3[0] = d12 + d11;
                if (-1.0E-10d < d10 && d10 < 1.0E-10d) {
                    dArr3[1] = ((-d12) / 2.0d) + d11;
                    i2 = 2;
                }
            } else {
                dArr3[0] = d11;
            }
            i2 = 1;
        }
        return yj(dArr3, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int i(double r11, double r13, double r15, double r17, double r19, double r21, double r23, double r25) {
        /*
            r0 = 0
            int r1 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0009
            int r1 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x0019
        L_0x0009:
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0011
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x0019
        L_0x0011:
            int r2 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
            int r2 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            int r2 = (r25 > r13 ? 1 : (r25 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0023
            int r2 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x0023
            goto L_0x006a
        L_0x0023:
            r2 = 255(0xff, float:3.57E-43)
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x002a
            return r2
        L_0x002a:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x003f
            int r3 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0035
            r3 = r19
            goto L_0x0036
        L_0x0035:
            r3 = r11
        L_0x0036:
            int r5 = (r15 > r23 ? 1 : (r15 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003c
            r5 = r15
            goto L_0x004c
        L_0x003c:
            r5 = r23
            goto L_0x004c
        L_0x003f:
            int r3 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0046
            r3 = r19
            goto L_0x0047
        L_0x0046:
            r3 = r15
        L_0x0047:
            int r5 = (r11 > r23 ? 1 : (r11 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003c
            r5 = r11
        L_0x004c:
            double r7 = r17 - r13
            double r9 = r15 - r11
            double r7 = r7 / r9
            double r3 = r3 - r11
            double r3 = r3 * r7
            double r3 = r3 + r13
            double r5 = r5 - r11
            double r7 = r7 * r5
            double r7 = r7 + r13
            int r5 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0062
            int r5 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0062
            return r0
        L_0x0062:
            int r5 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r5 <= 0) goto L_0x009c
            int r3 = (r7 > r25 ? 1 : (r7 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x009c
        L_0x006a:
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x006f
            return r0
        L_0x006f:
            r2 = -1
            if (r1 != 0) goto L_0x0079
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r0 = -1
        L_0x0078:
            return r0
        L_0x0079:
            r1 = 1
            int r3 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x0084
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0083
            r0 = 1
        L_0x0083:
            return r0
        L_0x0084:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0092
            int r2 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            r0 = 1
        L_0x0091:
            return r0
        L_0x0092:
            int r1 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            r0 = -1
        L_0x009b:
            return r0
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.qw.qw.yj.qw.i(double, double, double, double, double, double, double, double):int");
    }

    /* renamed from: if  reason: not valid java name */
    public static int m1136if(Shape shape, double d, double d2, double d3, double d4) {
        if (!shape.getBounds2D().intersects(d, d2, d3, d4)) {
            return 0;
        }
        Shape shape2 = shape;
        return o(shape.getPathIterator((AffineTransform) null), d, d2, d3, d4);
    }

    public static int o(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        double d5;
        int i2;
        char c;
        int i3;
        double[] dArr = new double[6];
        double d6 = d + d3;
        double d7 = d2 + d4;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i4 = 0;
        while (true) {
            int i5 = 255;
            if (!pathIterator.isDone()) {
                int ad2 = pathIterator.ad(dArr);
                if (ad2 == 0) {
                    if (d8 == d10 && d9 == d11) {
                        i3 = 0;
                        c = 1;
                    } else {
                        c = 1;
                        i3 = i(d8, d9, d10, d11, d, d2, d6, d7);
                    }
                    d10 = dArr[0];
                    d11 = dArr[c];
                    i5 = 255;
                    d9 = d11;
                    d5 = d10;
                } else if (ad2 == 1) {
                    double d12 = dArr[0];
                    double d13 = dArr[1];
                    i2 = i(d8, d9, d12, d13, d, d2, d6, d7);
                    d9 = d13;
                    d5 = d10;
                    i5 = 255;
                    d10 = d12;
                } else if (ad2 != 2) {
                    if (ad2 == 3) {
                        double d14 = dArr[4];
                        double d15 = dArr[5];
                        i2 = uk(d8, d9, dArr[0], dArr[1], dArr[2], dArr[3], d14, d15, d, d2, d6, d7);
                        d5 = d10;
                        d10 = d14;
                        d9 = d15;
                    } else if (ad2 != 4) {
                        d5 = d10;
                        d10 = d8;
                        i2 = 0;
                    } else {
                        if (d9 == d11 && d8 == d10) {
                            i2 = 0;
                        } else {
                            i2 = i(d8, d9, d10, d11, d, d2, d6, d7);
                        }
                        d5 = d10;
                        d9 = d11;
                    }
                    i5 = 255;
                } else {
                    double d16 = dArr[0];
                    double d17 = dArr[1];
                    double d18 = dArr[2];
                    double d19 = dArr[3];
                    i2 = pf(d8, d9, d16, d17, d18, d19, d, d2, d6, d7);
                    d9 = d19;
                    d5 = d10;
                    i5 = 255;
                    d10 = d18;
                }
                if (i2 == i5) {
                    return i5;
                }
                i4 += i2;
                pathIterator.next();
                d8 = d10;
                d10 = d5;
            } else if (d9 == d11) {
                return i4;
            } else {
                int i6 = i(d8, d9, d10, d11, d, d2, d6, d7);
                if (i6 == 255) {
                    return 255;
                }
                return i4 + i6;
            }
        }
    }

    public static int pf(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        int i2;
        if ((d9 < d && d9 < d3 && d9 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || (d8 > d2 && d8 > d4 && d8 > d6))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && i2 != 0 && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || d7 >= d) ? 0 : -1;
        }
        ad adVar = new ad(d, d2, d3, d4, d5, d6);
        double d11 = d7 - d;
        double d12 = d8 - d2;
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int fe2 = adVar.fe(dArr, d11);
        int fe3 = adVar.fe(dArr2, d13);
        if (fe2 == 0 && fe3 == 0) {
            return 0;
        }
        double d15 = d11 - 1.0E-5d;
        double[] dArr3 = new double[28];
        ad adVar2 = adVar;
        double[] dArr4 = dArr3;
        double d16 = d15;
        double d17 = d13 + 1.0E-5d;
        double[] dArr5 = dArr;
        double[] dArr6 = dArr2;
        int qw = adVar2.qw(dArr4, adVar2.qw(dArr4, adVar2.qw(dArr4, 0, dArr, fe2, d16, d17, false, 0), dArr6, fe3, d16, d17, false, 1), dArr6, adVar.de(dArr6), d16, d17, true, 2);
        if (d7 < d && d < d9) {
            int i3 = qw + 1;
            dArr3[qw] = 0.0d;
            int i4 = i3 + 1;
            dArr3[i3] = 0.0d;
            int i5 = i4 + 1;
            dArr3[i4] = 0.0d;
            qw = i5 + 1;
            dArr3[i5] = 4.0d;
        }
        if (d7 < d5 && d5 < d9) {
            int i6 = qw + 1;
            dArr3[qw] = 1.0d;
            int i7 = i6 + 1;
            dArr3[i6] = adVar.qw;
            int i8 = i7 + 1;
            dArr3[i7] = adVar.f9931ad;
            qw = i8 + 1;
            dArr3[i8] = 5.0d;
        }
        int qw2 = qw(dArr3, qw, d12, d14);
        if (qw2 != 254) {
            return qw2;
        }
        return adVar.ad(dArr5, fe2, d12, d14);
    }

    public static boolean ppp(double d) {
        return -1.0E-5d < d && d < 1.0E-5d;
    }

    public static int qw(double[] dArr, int i2, double d, double d2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 2; i5 < i2; i5 += 4) {
            if (dArr[i5] < d) {
                i4++;
            } else if (dArr[i5] <= d2) {
                return 255;
            } else {
                i3++;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        if (i4 == 0) {
            return 254;
        }
        xxx(dArr, i2);
        boolean z = dArr[2] > d2;
        int i6 = 6;
        while (i6 < i2) {
            boolean z2 = dArr[i6] > d2;
            if (z != z2 && dArr[i6 + 1] != dArr[i6 - 3]) {
                return 255;
            }
            i6 += 4;
            z = z2;
        }
        return 254;
    }

    public static int rg(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        int i2;
        int i3 = (d7 > d ? 1 : (d7 == d ? 0 : -1));
        if ((i3 < 0 && d7 < d3 && d7 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || ((d8 > d2 && d8 > d4 && d8 > d6) || (d == d3 && d3 == d5)))) {
            return 0;
        }
        if (d8 < d2 && d8 < d4 && d8 < d6 && i2 != 0 && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || i3 >= 0) ? 0 : -1;
        }
        ad adVar = new ad(d, d2, d3, d4, d5, d6);
        double d9 = d8 - d2;
        double[] dArr = new double[3];
        return adVar.ad(dArr, adVar.fe(dArr, d7 - d), d9, d9);
    }

    /* renamed from: switch  reason: not valid java name */
    public static boolean m1137switch(int i2) {
        return (i2 & 1) != 0;
    }

    public static int th(Shape shape, double d, double d2) {
        if (!shape.getBounds2D().contains(d, d2)) {
            return 0;
        }
        return fe(shape.getPathIterator((AffineTransform) null), d, d2);
    }

    public static int uk(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        int i2;
        if ((d11 < d && d11 < d3 && d11 < d5 && d11 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || (d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8))) {
            return 0;
        }
        if (d12 < d2 && d12 < d4 && d12 < d6 && d12 < d8 && i2 != 0 && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || d9 >= d) ? 0 : -1;
        }
        C0331qw qwVar = r0;
        C0331qw qwVar2 = new C0331qw(d, d2, d3, d4, d5, d6, d7, d8);
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double d15 = d11 - d;
        double d16 = d12 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        C0331qw qwVar3 = qwVar;
        int rg2 = qwVar3.rg(dArr, d13);
        int rg3 = qwVar3.rg(dArr2, d15);
        if (rg2 == 0 && rg3 == 0) {
            return 0;
        }
        double[] dArr3 = new double[40];
        double d17 = d13 - 1.0E-5d;
        double[] dArr4 = dArr3;
        double d18 = d15 + 1.0E-5d;
        C0331qw qwVar4 = qwVar3;
        double[] dArr5 = dArr2;
        int qw = qwVar3.qw(dArr3, 0, dArr, rg2, d17, d18, false, 0);
        double[] dArr6 = dArr4;
        double[] dArr7 = dArr5;
        C0331qw qwVar5 = qwVar4;
        double[] dArr8 = dArr;
        double[] dArr9 = dArr7;
        double d19 = d16;
        C0331qw qwVar6 = qwVar5;
        int qw2 = qwVar6.qw(dArr6, qwVar5.qw(dArr6, qwVar4.qw(dArr6, qw, dArr5, rg3, d17, d18, false, 1), dArr7, qwVar5.de(dArr7), d17, d18, true, 2), dArr9, qwVar6.fe(dArr9), d17, d18, true, 4);
        if (d9 < d && d < d11) {
            int i3 = qw2 + 1;
            dArr4[qw2] = 0.0d;
            int i4 = i3 + 1;
            dArr4[i3] = 0.0d;
            int i5 = i4 + 1;
            dArr4[i4] = 0.0d;
            qw2 = i5 + 1;
            dArr4[i5] = 6.0d;
        }
        if (d9 < d7 && d7 < d11) {
            int i6 = qw2 + 1;
            dArr4[qw2] = 1.0d;
            int i7 = i6 + 1;
            dArr4[i6] = qwVar6.qw;
            int i8 = i7 + 1;
            dArr4[i7] = qwVar6.f9938ad;
            qw2 = i8 + 1;
            dArr4[i8] = 7.0d;
        }
        int qw3 = qw(dArr4, qw2, d14, d19);
        if (qw3 != 254) {
            return qw3;
        }
        return qwVar6.ad(dArr8, rg2, d14, d19);
    }

    public static int vvv(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        int i2 = 2;
        double d = dArr[2];
        double d2 = dArr[1];
        double d3 = dArr[0];
        if (d != 0.0d) {
            double d4 = (d2 * d2) - ((4.0d * d) * d3);
            if (d4 < 0.0d) {
                return 0;
            }
            double sqrt = Math.sqrt(d4);
            double d5 = -d2;
            double d6 = d * 2.0d;
            dArr3[0] = (d5 + sqrt) / d6;
            if (sqrt != 0.0d) {
                dArr3[1] = (d5 - sqrt) / d6;
                return yj(dArr3, i2);
            }
        } else if (d2 == 0.0d) {
            return -1;
        } else {
            dArr3[0] = (-d3) / d2;
        }
        i2 = 1;
        return yj(dArr3, i2);
    }

    public static boolean when(int i2) {
        return i2 != 0;
    }

    public static void xxx(double[] dArr, int i2) {
        int i3 = 0;
        while (i3 < i2 - 4) {
            int i4 = i3 + 4;
            int i5 = i3;
            for (int i6 = i4; i6 < i2; i6 += 4) {
                if (dArr[i5] > dArr[i6]) {
                    i5 = i6;
                }
            }
            if (i5 != i3) {
                double d = dArr[i3];
                dArr[i3] = dArr[i5];
                dArr[i5] = d;
                int i7 = i3 + 1;
                double d2 = dArr[i7];
                int i8 = i5 + 1;
                dArr[i7] = dArr[i8];
                dArr[i8] = d2;
                int i9 = i3 + 2;
                double d3 = dArr[i9];
                int i10 = i5 + 2;
                dArr[i9] = dArr[i10];
                dArr[i10] = d3;
                int i11 = i3 + 3;
                double d4 = dArr[i11];
                int i12 = i5 + 3;
                dArr[i11] = dArr[i12];
                dArr[i12] = d4;
            }
            i3 = i4;
        }
    }

    public static int yj(double[] dArr, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i3 + 1;
            int i6 = i5;
            while (true) {
                if (i6 >= i2) {
                    dArr[i4] = dArr[i3];
                    i4++;
                    break;
                } else if (ppp(dArr[i3] - dArr[i6])) {
                    break;
                } else {
                    i6++;
                }
            }
            i3 = i5;
        }
        return i4;
    }
}
