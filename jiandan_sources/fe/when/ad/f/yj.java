package fe.when.ad.f;

import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.google.common.net.MediaType;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import fe.when.ad.f.th;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class yj extends th {
    public static final String[] f = {"RESERVED_0", "hstem", "RESERVED_2", "vstem", "vmoveto", "rlineto", "hlineto", "vlineto", "rrcurveto", "RESERVED_9", "callsubr", "return", "escape", "RESERVED_13", "endchar", "RESERVED_15", "RESERVED_16", "RESERVED_17", "hstemhm", "hintmask", "cntrmask", "rmoveto", "hmoveto", "vstemhm", "rcurveline", "rlinecurve", "vvcurveto", "hhcurveto", "shortint", "callgsubr", "vhcurveto", "hvcurveto"};
    public static final String[] g = {"RESERVED_0", "RESERVED_1", "RESERVED_2", "and", "or", "not", "RESERVED_6", "RESERVED_7", "RESERVED_8", "abs", "add", "sub", "div", "RESERVED_13", "neg", "eq", "RESERVED_16", "RESERVED_17", "drop", "RESERVED_19", "put", "get", "ifelse", "random", "mul", "RESERVED_25", "sqrt", "dup", "exch", ShareCallPacking.StatModel.KEY_INDEX, "roll", "RESERVED_31", "RESERVED_32", "RESERVED_33", "hflex", "flex", "hflex1", "flex1", "RESERVED_REST"};
    public byte[] a;
    public ArrayList<Integer> aaa = new ArrayList<>();
    public byte[] b;
    public int c;
    public LinkedList<th.yj> d;
    public HashMap<Integer, int[]>[] ddd;
    public int e;
    public ArrayList<Integer> eee = new ArrayList<>();
    public HashMap<Integer, int[]> ggg;
    public HashMap<Integer, int[]> mmm = new HashMap<>();
    public ArrayList<Integer>[] nn;
    public HashMap<Integer, int[]> qqq = new HashMap<>();
    public byte[][] rrr;
    public byte[] tt;
    public ArrayList<Integer> vvv;
    public HashSet<Integer> xxx = new HashSet<>();

    public yj(e2 e2Var, HashMap<Integer, int[]> hashMap) {
        super(e2Var);
        int i2 = 0;
        this.c = 0;
        this.e = 0;
        this.ggg = hashMap;
        this.vvv = new ArrayList<>(hashMap.keySet());
        while (true) {
            th.de[] deVarArr = this.f459switch;
            if (i2 < deVarArr.length) {
                m1119if(deVarArr[i2].f9801yj);
                this.f459switch[i2].f461switch = qw();
                m1119if(this.f9790yj);
                this.f459switch[i2].when = qw() + th.ppp.length;
                th.de[] deVarArr2 = this.f459switch;
                deVarArr2[i2].ggg = rg(deVarArr2[i2].f9801yj);
                if (this.f459switch[i2].f9796o >= 0) {
                    y(i2);
                    when(i2);
                }
                if (this.f459switch[i2].f9793de) {
                    s(i2);
                }
                th.de[] deVarArr3 = this.f459switch;
                deVarArr3[i2].ppp = a(deVarArr3[i2].f9800uk, deVarArr3[i2].f461switch);
                i2++;
            } else {
                return;
            }
        }
    }

    public int a(int i2, int i3) {
        int i4;
        m1119if(i2);
        char ad2 = ad();
        if (ad2 == 0) {
            return (i3 * 2) + 1;
        }
        if (ad2 == 1) {
            i4 = b(i3, 1) * 3;
        } else if (ad2 != 2) {
            return 0;
        } else {
            i4 = b(i3, 2) * 4;
        }
        return i4 + 1;
    }

    public void aaa(int i2, int i3, int i4, int[] iArr, HashMap<Integer, int[]> hashMap, ArrayList<Integer> arrayList) {
        int i5 = i2;
        int i6 = i3;
        int[] iArr2 = iArr;
        int qqq2 = qqq(i4, i5);
        for (int i7 = 0; i7 < this.vvv.size(); i7++) {
            int intValue = this.vvv.get(i7).intValue();
            th.de[] deVarArr = this.f459switch;
            int i8 = deVarArr[i5].ggg[intValue];
            int i9 = deVarArr[i5].ggg[intValue + 1];
            if (i6 >= 0) {
                k();
                this.e = 0;
                if (this.f459switch[i5].vvv[intValue] == i6) {
                    q(i8, i9, this.c, qqq2, hashMap, arrayList, iArr);
                }
            } else {
                q(i8, i9, this.c, qqq2, hashMap, arrayList, iArr);
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            int intValue2 = arrayList.get(i10).intValue();
            if (intValue2 < iArr2.length - 1 && intValue2 >= 0) {
                q(iArr2[intValue2], iArr2[intValue2 + 1], this.c, qqq2, hashMap, arrayList, iArr);
            }
        }
    }

    public int b(int i2, int i3) {
        char c2;
        int i4 = 0;
        int i5 = 1;
        while (i5 < i2) {
            i4++;
            qw();
            if (i3 == 1) {
                c2 = ad();
            } else {
                c2 = qw();
            }
            i5 += c2 + 1;
        }
        return i4;
    }

    public void c(th.i iVar, int i2) {
        this.d.addLast(new th.uk(iVar));
        this.d.addLast(new th.ggg(2));
        this.d.addLast(new th.Cswitch(1));
        this.d.addLast(new th.Cswitch((char) (i2 - 1)));
    }

    public void d(th.i iVar, th.i iVar2, int i2) {
        this.d.addLast(new th.uk(iVar));
        vvv(1, 1, 1);
        th.C0330th thVar = new th.C0330th(1);
        this.d.addLast(thVar);
        th.fe feVar = new th.fe();
        this.d.addLast(feVar);
        th.de[] deVarArr = this.f459switch;
        int i3 = deVarArr[i2].f9798rg;
        int rrr2 = rrr(deVarArr[i2].f9794fe, deVarArr[i2].f9798rg);
        if (rrr2 != 0) {
            i3 += 5 - rrr2;
        }
        this.d.addLast(new th.qw(i3));
        this.d.addLast(iVar2);
        this.d.addLast(new th.ggg(18));
        this.d.addLast(new th.rg(thVar, feVar));
    }

    public byte[] ddd(int i2) {
        this.d = new LinkedList<>();
        tt();
        vvv(1, 1, 1);
        this.d.addLast(new th.ggg((char) (this.f459switch[i2].qw.length() + 1)));
        this.d.addLast(new th.pf(this.f459switch[i2].qw));
        vvv(1, 2, 1);
        th.C0330th thVar = new th.C0330th(2);
        this.d.addLast(thVar);
        th.fe feVar = new th.fe();
        this.d.addLast(feVar);
        th.ad adVar = new th.ad();
        th.ad adVar2 = new th.ad();
        th.ad adVar3 = new th.ad();
        th.ad adVar4 = new th.ad();
        th.ad adVar5 = new th.ad();
        th.de[] deVarArr = this.f459switch;
        if (!deVarArr[i2].f9793de) {
            this.d.addLast(new th.qw(deVarArr[i2].when));
            this.d.addLast(new th.qw(this.f459switch[i2].when + 1));
            this.d.addLast(new th.qw(0));
            this.d.addLast(new th.ggg(12));
            this.d.addLast(new th.ggg(DecodedBitStreamParser.RS));
            this.d.addLast(new th.qw(this.f459switch[i2].f461switch));
            this.d.addLast(new th.ggg(12));
            this.d.addLast(new th.ggg('\"'));
        }
        m1119if(this.f9785o[i2]);
        while (i() < this.f9785o[i2 + 1]) {
            int i3 = i();
            de();
            int i4 = i();
            String str = this.qw;
            if (!(str == "Encoding" || str == "Private" || str == "FDSelect" || str == "FDArray" || str == MediaType.CHARSET_ATTRIBUTE || str == "CharStrings")) {
                this.d.add(new th.o(this.f9783fe, i3, i4 - i3));
            }
        }
        f(adVar3, adVar4, adVar, adVar2);
        this.d.addLast(new th.rg(thVar, feVar));
        if (this.f459switch[i2].f9793de) {
            this.d.addLast(fe(this.f9790yj));
        } else {
            g(i2);
        }
        this.d.addLast(new th.o(new e2(this.a), 0, this.a.length));
        th.de[] deVarArr2 = this.f459switch;
        if (deVarArr2[i2].f9793de) {
            this.d.addLast(new th.uk(adVar4));
            th.de[] deVarArr3 = this.f459switch;
            if (deVarArr3[i2].f9796o >= 0) {
                this.d.addLast(new th.o(this.f9783fe, deVarArr3[i2].f9796o, deVarArr3[i2].xxx));
            } else {
                e(adVar4, deVarArr3[i2].f461switch);
            }
            this.d.addLast(new th.uk(adVar));
            LinkedList<th.yj> linkedList = this.d;
            e2 e2Var = this.f9783fe;
            th.de[] deVarArr4 = this.f459switch;
            linkedList.addLast(new th.o(e2Var, deVarArr4[i2].f9800uk, deVarArr4[i2].ppp));
            if (this.f459switch[i2].f9795i >= 0) {
                this.d.addLast(new th.uk(adVar3));
                t(i2);
            } else {
                d(adVar3, adVar5, i2);
            }
        } else {
            e(adVar4, deVarArr2[i2].f461switch);
            c(adVar, this.f459switch[i2].f461switch);
            d(adVar3, adVar5, i2);
        }
        if (this.f459switch[i2].f9794fe >= 0) {
            th.fe feVar2 = new th.fe();
            this.d.addLast(feVar2);
            this.d.addLast(new th.uk(adVar5));
            th.ad adVar6 = new th.ad();
            h(i2, adVar6);
            j(i2, feVar2, adVar6);
        }
        this.d.addLast(new th.uk(adVar2));
        this.d.addLast(new th.o(new e2(this.b), 0, this.b.length));
        int[] iArr = {0};
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((th.yj) it.next()).ad(iArr);
        }
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((th.yj) it2.next()).de();
        }
        byte[] bArr = new byte[iArr[0]];
        Iterator it3 = this.d.iterator();
        while (it3.hasNext()) {
            ((th.yj) it3.next()).qw(bArr);
        }
        return bArr;
    }

    public void e(th.i iVar, int i2) {
        this.d.addLast(new th.uk(iVar));
        this.d.addLast(new th.ggg(3));
        this.d.addLast(new th.Cswitch(1));
        this.d.addLast(new th.Cswitch(0));
        this.d.addLast(new th.ggg(0));
        this.d.addLast(new th.Cswitch((char) i2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int eee(int r9, int r10, int r11, int r12, int[] r13) {
        /*
            r8 = this;
            r8.m1119if(r9)
        L_0x0003:
            int r9 = r8.i()
            if (r9 >= r10) goto L_0x0097
            r8.r()
            int r9 = r8.i()
            r0 = 0
            int r1 = r8.f9782de
            if (r1 <= 0) goto L_0x001b
            java.lang.Object[] r0 = r8.f9781ad
            int r1 = r1 + -1
            r0 = r0[r1]
        L_0x001b:
            int r1 = r8.f9782de
            r8.l()
            java.lang.String r2 = r8.qw
            java.lang.String r3 = "callsubr"
            if (r2 != r3) goto L_0x0040
            if (r1 <= 0) goto L_0x0003
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r0 + r11
            r2 = r13[r0]
            int r0 = r0 + 1
            r3 = r13[r0]
            r1 = r8
            r4 = r11
            r5 = r12
            r6 = r13
            r1.eee(r2, r3, r4, r5, r6)
            r8.m1119if(r9)
            goto L_0x0003
        L_0x0040:
            java.lang.String r3 = "callgsubr"
            if (r2 != r3) goto L_0x0060
            if (r1 <= 0) goto L_0x0003
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r0 + r12
            int[] r1 = r8.f458if
            r3 = r1[r0]
            int r0 = r0 + 1
            r4 = r1[r0]
            r2 = r8
            r5 = r11
            r6 = r12
            r7 = r13
            r2.eee(r3, r4, r5, r6, r7)
            r8.m1119if(r9)
            goto L_0x0003
        L_0x0060:
            java.lang.String r9 = "hstem"
            if (r2 == r9) goto L_0x008e
            java.lang.String r9 = "vstem"
            if (r2 == r9) goto L_0x008e
            java.lang.String r9 = "hstemhm"
            if (r2 == r9) goto L_0x008e
            java.lang.String r9 = "vstemhm"
            if (r2 != r9) goto L_0x0071
            goto L_0x008e
        L_0x0071:
            java.lang.String r9 = "hintmask"
            if (r2 == r9) goto L_0x0079
            java.lang.String r9 = "cntrmask"
            if (r2 != r9) goto L_0x0003
        L_0x0079:
            int r9 = r8.e
            int r0 = r9 / 8
            int r9 = r9 % 8
            if (r9 != 0) goto L_0x0083
            if (r0 != 0) goto L_0x0085
        L_0x0083:
            int r0 = r0 + 1
        L_0x0085:
            r9 = 0
        L_0x0086:
            if (r9 >= r0) goto L_0x0003
            r8.ad()
            int r9 = r9 + 1
            goto L_0x0086
        L_0x008e:
            int r9 = r8.e
            int r1 = r1 / 2
            int r9 = r9 + r1
            r8.e = r9
            goto L_0x0003
        L_0x0097:
            int r9 = r8.e
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.yj.eee(int, int, int, int, int[]):int");
    }

    public void f(th.i iVar, th.i iVar2, th.i iVar3, th.i iVar4) {
        this.d.addLast(iVar);
        this.d.addLast(new th.ggg(12));
        this.d.addLast(new th.ggg('$'));
        this.d.addLast(iVar2);
        this.d.addLast(new th.ggg(12));
        this.d.addLast(new th.ggg('%'));
        this.d.addLast(iVar3);
        this.d.addLast(new th.ggg(15));
        this.d.addLast(iVar4);
        this.d.addLast(new th.ggg(17));
    }

    public void g(int i2) {
        int i3;
        String str = this.f459switch[i2].qw + "-OneRange";
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        String str2 = "AdobeIdentity" + str;
        int[] iArr = this.f9786pf;
        int i4 = iArr[iArr.length - 1] - iArr[0];
        int i5 = iArr[0] - 1;
        if (str2.length() + i4 <= 255) {
            i3 = 1;
        } else if (str2.length() + i4 <= 65535) {
            i3 = 2;
        } else {
            i3 = str2.length() + i4 <= 16777215 ? 3 : 4;
        }
        this.d.addLast(new th.Cswitch((char) ((this.f9786pf.length - 1) + 3)));
        this.d.addLast(new th.ggg((char) i3));
        for (int i6 : this.f9786pf) {
            this.d.addLast(new th.C0330th(i3, i6 - i5));
        }
        int[] iArr2 = this.f9786pf;
        int i7 = (iArr2[iArr2.length - 1] - i5) + 5;
        this.d.addLast(new th.C0330th(i3, i7));
        int i8 = i7 + 8;
        this.d.addLast(new th.C0330th(i3, i8));
        this.d.addLast(new th.C0330th(i3, i8 + str.length()));
        this.d.addLast(new th.o(this.f9783fe, this.f9786pf[0], i4));
        this.d.addLast(new th.pf(str2));
    }

    public void ggg(int i2) {
        int i3;
        int i4;
        th.de[] deVarArr = this.f459switch;
        if (deVarArr[i2].f9799th >= 0) {
            i4 = qqq(deVarArr[i2].f9799th, i2);
            i3 = this.eee.size();
        } else {
            i4 = 0;
            i3 = 0;
        }
        for (int i5 = 0; i5 < this.aaa.size(); i5++) {
            int intValue = this.aaa.get(i5).intValue();
            int[] iArr = this.f458if;
            if (intValue < iArr.length - 1 && intValue >= 0) {
                int i6 = iArr[intValue];
                int i7 = iArr[intValue + 1];
                th.de[] deVarArr2 = this.f459switch;
                if (deVarArr2[i2].f9793de) {
                    q(i6, i7, this.c, 0, this.mmm, this.aaa, (int[]) null);
                } else {
                    q(i6, i7, this.c, i4, this.qqq, this.eee, deVarArr2[i2].tt);
                    if (i3 < this.eee.size()) {
                        while (i3 < this.eee.size()) {
                            int intValue2 = this.eee.get(i3).intValue();
                            th.de[] deVarArr3 = this.f459switch;
                            if (intValue2 < deVarArr3[i2].tt.length - 1 && intValue2 >= 0) {
                                q(deVarArr3[i2].tt[intValue2], deVarArr3[i2].tt[intValue2 + 1], this.c, i4, this.qqq, this.eee, deVarArr3[i2].tt);
                            }
                            i3++;
                        }
                        i3 = this.eee.size();
                    }
                }
            }
        }
    }

    public void h(int i2, th.i iVar) {
        m1119if(this.f459switch[i2].f9794fe);
        while (true) {
            int i3 = i();
            th.de[] deVarArr = this.f459switch;
            if (i3 < deVarArr[i2].f9794fe + deVarArr[i2].f9798rg) {
                int i4 = i();
                de();
                int i5 = i();
                if (this.qw == "Subrs") {
                    this.d.addLast(iVar);
                    this.d.addLast(new th.ggg(19));
                } else {
                    this.d.addLast(new th.o(this.f9783fe, i4, i5 - i4));
                }
            } else {
                return;
            }
        }
    }

    public void j(int i2, th.fe feVar, th.i iVar) {
        this.d.addLast(new th.Cif(iVar, feVar));
        byte[] bArr = this.tt;
        if (bArr != null) {
            this.d.addLast(new th.o(new e2(bArr), 0, this.tt.length));
        }
    }

    public void k() {
        for (int i2 = 0; i2 < this.f9782de; i2++) {
            this.f9781ad[i2] = null;
        }
        this.f9782de = 0;
    }

    public void l() {
        int x = x();
        if (x >= 2) {
            k();
        } else if (x == 1) {
            p();
        } else {
            int i2 = x * -1;
            for (int i3 = 0; i3 < i2; i3++) {
                m();
            }
        }
    }

    public void m() {
        int i2 = this.f9782de;
        if (i2 > 0) {
            this.f9781ad[i2 - 1] = null;
            this.f9782de = i2 - 1;
        }
    }

    public void mmm(int i2) throws IOException {
        th.de[] deVarArr = this.f459switch;
        if (deVarArr[i2].f9793de) {
            this.ddd = new HashMap[deVarArr[i2].f9797pf.length];
            this.nn = new ArrayList[deVarArr[i2].f9797pf.length];
            this.rrr = new byte[deVarArr[i2].f9797pf.length][];
            deVarArr[i2].eee = new int[deVarArr[i2].f9797pf.length];
            deVarArr[i2].rrr = new int[deVarArr[i2].f9797pf.length][];
            ArrayList arrayList = new ArrayList(this.xxx);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                int intValue = ((Integer) arrayList.get(i3)).intValue();
                this.ddd[intValue] = new HashMap<>();
                this.nn[intValue] = new ArrayList<>();
                ppp(i2, intValue);
                th.de[] deVarArr2 = this.f459switch;
                if (deVarArr2[i2].eee[intValue] >= 0) {
                    aaa(i2, intValue, deVarArr2[i2].eee[intValue], deVarArr2[i2].rrr[intValue], this.ddd[intValue], this.nn[intValue]);
                    this.rrr[intValue] = nn(this.f459switch[i2].rrr[intValue], this.ddd[intValue], (byte) 11);
                }
            }
        } else if (deVarArr[i2].f9799th >= 0) {
            deVarArr[i2].tt = rg(deVarArr[i2].f9799th);
            th.de[] deVarArr3 = this.f459switch;
            aaa(i2, -1, deVarArr3[i2].f9799th, deVarArr3[i2].tt, this.qqq, this.eee);
        }
        ggg(i2);
        th.de[] deVarArr4 = this.f459switch;
        if (deVarArr4[i2].f9799th >= 0) {
            this.tt = nn(deVarArr4[i2].tt, this.qqq, (byte) 11);
        }
        this.a = nn(this.f458if, this.mmm, (byte) 11);
    }

    public byte[] n(String str) throws IOException {
        try {
            this.f9783fe.fe();
            int i2 = 0;
            while (true) {
                if (i2 >= this.f459switch.length) {
                    break;
                } else if (str.equals(this.f459switch[i2].qw)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == this.f459switch.length) {
                return null;
            }
            if (this.f9789uk >= 0) {
                this.c = qqq(this.f9789uk, i2);
            }
            xxx(i2);
            mmm(i2);
            byte[] ddd2 = ddd(i2);
            try {
                this.f9783fe.close();
            } catch (Exception unused) {
            }
            return ddd2;
        } finally {
            try {
                this.f9783fe.close();
            } catch (Exception unused2) {
            }
        }
    }

    public byte[] nn(int[] iArr, HashMap<Integer, int[]> hashMap, byte b2) throws IOException {
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iArr2[i5] = i3;
            if (hashMap.containsKey(Integer.valueOf(i5))) {
                i3 += iArr[i5 + 1] - iArr[i5];
            } else {
                i4++;
            }
        }
        byte[] bArr = new byte[(i3 + i4)];
        int i6 = 0;
        while (i2 < iArr.length - 1) {
            int i7 = iArr2[i2];
            int i8 = i2 + 1;
            int i9 = iArr2[i8];
            int i10 = i7 + i6;
            iArr2[i2] = i10;
            if (i7 != i9) {
                this.f9783fe.when((long) iArr[i2]);
                this.f9783fe.readFully(bArr, i10, i9 - i7);
            } else {
                bArr[i10] = b2;
                i6++;
            }
            i2 = i8;
        }
        int length = iArr.length - 1;
        iArr2[length] = iArr2[length] + i6;
        return m1126switch(iArr2, bArr);
    }

    public void p() {
        this.f9782de++;
    }

    public void ppp(int i2, int i3) {
        th.de[] deVarArr;
        th.de[] deVarArr2 = this.f459switch;
        deVarArr2[i2].eee[i3] = -1;
        m1119if(deVarArr2[i2].f9797pf[i3]);
        while (true) {
            int i4 = i();
            deVarArr = this.f459switch;
            if (i4 >= deVarArr[i2].f9797pf[i3] + deVarArr[i2].f460if[i3]) {
                break;
            }
            de();
            if (this.qw == "Subrs") {
                this.f459switch[i2].eee[i3] = ((Integer) this.f9781ad[0]).intValue() + this.f459switch[i2].f9797pf[i3];
            }
        }
        if (deVarArr[i2].eee[i3] >= 0) {
            deVarArr[i2].rrr[i3] = rg(deVarArr[i2].eee[i3]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(int r13, int r14, int r15, int r16, java.util.HashMap<java.lang.Integer, int[]> r17, java.util.ArrayList<java.lang.Integer> r18, int[] r19) {
        /*
            r12 = this;
            r6 = r12
            r7 = r17
            r12.k()
            r8 = 0
            r6.e = r8
            r12.m1119if(r13)
        L_0x000c:
            int r0 = r12.i()
            r9 = r14
            if (r0 >= r9) goto L_0x00eb
            r12.r()
            int r10 = r12.i()
            int r0 = r6.f9782de
            r1 = 0
            if (r0 <= 0) goto L_0x0026
            java.lang.Object[] r2 = r6.f9781ad
            int r0 = r0 + -1
            r0 = r2[r0]
            goto L_0x0027
        L_0x0026:
            r0 = r1
        L_0x0027:
            int r2 = r6.f9782de
            r12.l()
            java.lang.String r3 = r6.qw
            java.lang.String r4 = "callsubr"
            if (r3 != r4) goto L_0x006f
            if (r2 <= 0) goto L_0x006c
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r0 + r16
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r2 = r7.containsKey(r2)
            if (r2 != 0) goto L_0x0057
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.put(r2, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r11 = r18
            r11.add(r1)
            goto L_0x0059
        L_0x0057:
            r11 = r18
        L_0x0059:
            r1 = r19[r0]
            int r0 = r0 + 1
            r2 = r19[r0]
            r0 = r12
            r3 = r16
            r4 = r15
            r5 = r19
            r0.eee(r1, r2, r3, r4, r5)
            r12.m1119if(r10)
            goto L_0x000c
        L_0x006c:
            r11 = r18
            goto L_0x000c
        L_0x006f:
            r11 = r18
            java.lang.String r4 = "callgsubr"
            if (r3 != r4) goto L_0x00b4
            if (r2 <= 0) goto L_0x000c
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = r0 + r15
            java.util.HashMap<java.lang.Integer, int[]> r2 = r6.mmm
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L_0x009c
            java.util.HashMap<java.lang.Integer, int[]> r2 = r6.mmm
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r2.put(r3, r1)
            java.util.ArrayList<java.lang.Integer> r1 = r6.aaa
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r1.add(r2)
        L_0x009c:
            int[] r1 = r6.f458if
            r2 = r1[r0]
            int r0 = r0 + 1
            r3 = r1[r0]
            r0 = r12
            r1 = r2
            r2 = r3
            r3 = r16
            r4 = r15
            r5 = r19
            r0.eee(r1, r2, r3, r4, r5)
            r12.m1119if(r10)
            goto L_0x000c
        L_0x00b4:
            java.lang.String r0 = "hstem"
            if (r3 == r0) goto L_0x00e2
            java.lang.String r0 = "vstem"
            if (r3 == r0) goto L_0x00e2
            java.lang.String r0 = "hstemhm"
            if (r3 == r0) goto L_0x00e2
            java.lang.String r0 = "vstemhm"
            if (r3 != r0) goto L_0x00c5
            goto L_0x00e2
        L_0x00c5:
            java.lang.String r0 = "hintmask"
            if (r3 == r0) goto L_0x00cd
            java.lang.String r0 = "cntrmask"
            if (r3 != r0) goto L_0x000c
        L_0x00cd:
            int r0 = r6.e
            int r1 = r0 / 8
            int r0 = r0 % 8
            if (r0 != 0) goto L_0x00d7
            if (r1 != 0) goto L_0x00d9
        L_0x00d7:
            int r1 = r1 + 1
        L_0x00d9:
            r0 = 0
        L_0x00da:
            if (r0 >= r1) goto L_0x000c
            r12.ad()
            int r0 = r0 + 1
            goto L_0x00da
        L_0x00e2:
            int r0 = r6.e
            int r2 = r2 / 2
            int r0 = r0 + r2
            r6.e = r0
            goto L_0x000c
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.yj.q(int, int, int, int, java.util.HashMap, java.util.ArrayList, int[]):void");
    }

    public int qqq(int i2, int i3) {
        m1119if(i2);
        char qw = qw();
        if (this.f459switch[i3].nn == 1) {
            return 0;
        }
        if (qw < 1240) {
            return 107;
        }
        return qw < 33900 ? 1131 : 32768;
    }

    public void r() {
        this.qw = null;
        boolean z = false;
        while (!z) {
            char ad2 = ad();
            if (ad2 == 28) {
                this.f9781ad[this.f9782de] = Integer.valueOf((ad() << 8) | ad());
                this.f9782de++;
            } else if (ad2 >= ' ' && ad2 <= 246) {
                this.f9781ad[this.f9782de] = Integer.valueOf(ad2 - 139);
                this.f9782de++;
            } else if (ad2 >= 247 && ad2 <= 250) {
                this.f9781ad[this.f9782de] = Integer.valueOf(((ad2 - 247) * 256) + ad() + 108);
                this.f9782de++;
            } else if (ad2 >= 251 && ad2 <= 254) {
                this.f9781ad[this.f9782de] = Integer.valueOf((((-(ad2 - 251)) * 256) - ad()) + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL);
                this.f9782de++;
            } else if (ad2 == 255) {
                this.f9781ad[this.f9782de] = Integer.valueOf((ad() << 24) | (ad() << 16) | (ad() << 8) | ad());
                this.f9782de++;
            } else if (ad2 <= 31 && ad2 != 28) {
                if (ad2 == 12) {
                    int ad3 = ad();
                    String[] strArr = g;
                    if (ad3 > strArr.length - 1) {
                        ad3 = strArr.length - 1;
                    }
                    this.qw = g[ad3];
                } else {
                    this.qw = f[ad2];
                }
                z = true;
            }
        }
    }

    public int rrr(int i2, int i3) {
        m1119if(i2);
        int i4 = 0;
        while (i() < i2 + i3) {
            int i5 = i();
            de();
            int i6 = i();
            if (this.qw == "Subrs") {
                i4 = (i6 - i5) - 1;
            }
        }
        return i4;
    }

    public void s(int i2) {
        m1119if(this.f459switch[i2].f9795i);
        this.f459switch[i2].mmm = qw();
        this.f459switch[i2].aaa = ad();
        th.de[] deVarArr = this.f459switch;
        if (deVarArr[i2].aaa < 4) {
            deVarArr[i2].aaa++;
        }
        th.de[] deVarArr2 = this.f459switch;
        deVarArr2[i2].qqq = rg(deVarArr2[i2].f9795i);
    }

    /* renamed from: switch  reason: not valid java name */
    public byte[] m1126switch(int[] iArr, byte[] bArr) {
        int[] iArr2 = iArr;
        byte[] bArr2 = bArr;
        char length = (char) (iArr2.length - 1);
        int i2 = iArr2[iArr2.length - 1];
        byte b2 = i2 <= 255 ? 1 : i2 <= 65535 ? 2 : i2 <= 16777215 ? (byte) 3 : 4;
        byte[] bArr3 = new byte[(((length + 1) * b2) + 3 + bArr2.length)];
        int i3 = 0;
        bArr3[0] = (byte) ((length >>> 8) & 255);
        bArr3[1] = (byte) ((length >>> 0) & 255);
        bArr3[2] = b2;
        int i4 = 3;
        for (int i5 : iArr2) {
            int i6 = (i5 - iArr2[0]) + 1;
            if (b2 != 1) {
                if (b2 != 2) {
                    if (b2 != 3) {
                        if (b2 != 4) {
                        } else {
                            bArr3[i4] = (byte) ((i6 >>> 24) & 255);
                            i4++;
                        }
                    }
                    bArr3[i4] = (byte) ((i6 >>> 16) & 255);
                    i4++;
                }
                bArr3[i4] = (byte) ((i6 >>> 8) & 255);
                i4++;
            }
            bArr3[i4] = (byte) ((i6 >>> 0) & 255);
            i4++;
        }
        int length2 = bArr2.length;
        while (i3 < length2) {
            bArr3[i4] = bArr2[i3];
            i3++;
            i4++;
        }
        return bArr3;
    }

    public void t(int i2) {
        th.de[] deVarArr = this.f459switch;
        th.ad[] adVarArr = new th.ad[(deVarArr[i2].qqq.length - 1)];
        th.fe[] feVarArr = new th.fe[deVarArr[i2].f9797pf.length];
        th.ad[] adVarArr2 = new th.ad[deVarArr[i2].f9797pf.length];
        u(i2, adVarArr);
        v(i2, adVarArr, feVarArr, adVarArr2);
        w(i2, feVarArr, adVarArr2);
    }

    public void tt() {
        m1119if(0);
        ad();
        ad();
        char ad2 = ad();
        ad();
        this.d.addLast(new th.o(this.f9783fe, 0, ad2));
    }

    public void u(int i2, th.i[] iVarArr) {
        int i3;
        th.de[] deVarArr = this.f459switch;
        vvv(deVarArr[i2].mmm, deVarArr[i2].aaa, 1);
        th.C0330th[] thVarArr = new th.C0330th[(this.f459switch[i2].qqq.length - 1)];
        int i4 = 0;
        while (true) {
            th.de[] deVarArr2 = this.f459switch;
            if (i4 >= deVarArr2[i2].qqq.length - 1) {
                break;
            }
            thVarArr[i4] = new th.C0330th(deVarArr2[i2].aaa);
            this.d.addLast(thVarArr[i4]);
            i4++;
        }
        th.fe feVar = new th.fe();
        this.d.addLast(feVar);
        int i5 = 0;
        while (true) {
            th.de[] deVarArr3 = this.f459switch;
            if (i5 < deVarArr3[i2].qqq.length - 1) {
                m1119if(deVarArr3[i2].qqq[i5]);
                while (true) {
                    i3 = i5 + 1;
                    if (i() >= this.f459switch[i2].qqq[i3]) {
                        break;
                    }
                    int i6 = i();
                    de();
                    int i7 = i();
                    if (this.qw == "Private") {
                        int intValue = ((Integer) this.f9781ad[0]).intValue();
                        th.de[] deVarArr4 = this.f459switch;
                        int rrr2 = rrr(deVarArr4[i2].f9797pf[i5], deVarArr4[i2].f460if[i5]);
                        if (rrr2 != 0) {
                            intValue += 5 - rrr2;
                        }
                        this.d.addLast(new th.qw(intValue));
                        iVarArr[i5] = new th.ad();
                        this.d.addLast(iVarArr[i5]);
                        this.d.addLast(new th.ggg(18));
                        m1119if(i7);
                    } else {
                        this.d.addLast(new th.o(this.f9783fe, i6, i7 - i6));
                    }
                }
                this.d.addLast(new th.rg(thVarArr[i5], feVar));
                i5 = i3;
            } else {
                return;
            }
        }
    }

    public void v(int i2, th.i[] iVarArr, th.fe[] feVarArr, th.i[] iVarArr2) {
        for (int i3 = 0; i3 < this.f459switch[i2].f9797pf.length; i3++) {
            this.d.addLast(new th.uk(iVarArr[i3]));
            feVarArr[i3] = new th.fe();
            this.d.addLast(feVarArr[i3]);
            m1119if(this.f459switch[i2].f9797pf[i3]);
            while (true) {
                int i4 = i();
                th.de[] deVarArr = this.f459switch;
                if (i4 >= deVarArr[i2].f9797pf[i3] + deVarArr[i2].f460if[i3]) {
                    break;
                }
                int i5 = i();
                de();
                int i6 = i();
                if (this.qw == "Subrs") {
                    iVarArr2[i3] = new th.ad();
                    this.d.addLast(iVarArr2[i3]);
                    this.d.addLast(new th.ggg(19));
                } else {
                    this.d.addLast(new th.o(this.f9783fe, i5, i6 - i5));
                }
            }
        }
    }

    public void vvv(int i2, int i3, int i4) {
        this.d.addLast(new th.Cswitch((char) i2));
        this.d.addLast(new th.ggg((char) i3));
        if (i3 == 1) {
            this.d.addLast(new th.ggg((char) i4));
        } else if (i3 == 2) {
            this.d.addLast(new th.Cswitch((char) i4));
        } else if (i3 == 3) {
            this.d.addLast(new th.when((char) i4));
        } else if (i3 == 4) {
            this.d.addLast(new th.ppp((char) i4));
        }
    }

    public void w(int i2, th.fe[] feVarArr, th.i[] iVarArr) {
        int i3 = 0;
        while (true) {
            th.de[] deVarArr = this.f459switch;
            if (i3 < deVarArr[i2].f460if.length) {
                if (iVarArr[i3] != null && deVarArr[i2].eee[i3] >= 0) {
                    this.d.addLast(new th.Cif(iVarArr[i3], feVarArr[i3]));
                    byte[][] bArr = this.rrr;
                    if (bArr[i3] != null) {
                        this.d.addLast(new th.o(new e2(bArr[i3]), 0, this.rrr[i3].length));
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public void when(int i2) {
        int[] iArr = this.f459switch[i2].vvv;
        for (int i3 = 0; i3 < this.vvv.size(); i3++) {
            this.xxx.add(Integer.valueOf(iArr[this.vvv.get(i3).intValue()]));
        }
    }

    public int x() {
        String str = this.qw;
        if (str == "ifelse") {
            return -3;
        }
        if (str == "roll" || str == "put") {
            return -2;
        }
        if (str == "callsubr" || str == "callgsubr" || str == "add" || str == "sub" || str == "div" || str == "mul" || str == "drop" || str == "and" || str == "or" || str == "eq") {
            return -1;
        }
        if (str == "abs" || str == "neg" || str == "sqrt" || str == "exch" || str == ShareCallPacking.StatModel.KEY_INDEX || str == "get" || str == "not" || str == "return") {
            return 0;
        }
        return (str == "random" || str == "dup") ? 1 : 2;
    }

    public void xxx(int i2) throws IOException {
        this.b = nn(this.f459switch[i2].ggg, this.ggg, (byte) 14);
    }

    public void y(int i2) {
        th.de[] deVarArr = this.f459switch;
        int i3 = deVarArr[i2].f461switch;
        int[] iArr = new int[i3];
        m1119if(deVarArr[i2].f9796o);
        this.f459switch[i2].ddd = ad();
        int i4 = this.f459switch[i2].ddd;
        if (i4 == 0) {
            for (int i5 = 0; i5 < i3; i5++) {
                iArr[i5] = ad();
            }
            th.de[] deVarArr2 = this.f459switch;
            deVarArr2[i2].xxx = deVarArr2[i2].f461switch + 1;
        } else if (i4 == 3) {
            char qw = qw();
            char qw2 = qw();
            int i6 = 0;
            int i7 = 0;
            while (i6 < qw) {
                int ad2 = ad();
                char qw3 = qw();
                int i8 = qw3 - qw2;
                for (int i9 = 0; i9 < i8; i9++) {
                    iArr[i7] = ad2;
                    i7++;
                }
                i6++;
                qw2 = qw3;
            }
            this.f459switch[i2].xxx = (qw * 3) + 3 + 2;
        }
        this.f459switch[i2].vvv = iArr;
    }
}
