package fe.when.ad.f.t2;

import com.itextpdf.text.pdf.languages.LanguageProcessor;
import fe.when.ad.f.fe;
import java.util.HashMap;

public class qw implements LanguageProcessor {

    /* renamed from: ad  reason: collision with root package name */
    public static final char[][] f9776ad;
    public static HashMap<Character, char[]> qw = new HashMap<>();

    /* renamed from: fe.when.ad.f.t2.qw$qw  reason: collision with other inner class name */
    public static class C0329qw {

        /* renamed from: ad  reason: collision with root package name */
        public char f9777ad;

        /* renamed from: de  reason: collision with root package name */
        public char f9778de;

        /* renamed from: fe  reason: collision with root package name */
        public int f9779fe;
        public char qw;

        /* renamed from: rg  reason: collision with root package name */
        public int f9780rg = 1;
    }

    static {
        char[][] cArr = {new char[]{1569, 65152}, new char[]{1570, 65153, 65154}, new char[]{1571, 65155, 65156}, new char[]{1572, 65157, 65158}, new char[]{1573, 65159, 65160}, new char[]{1574, 65161, 65162, 65163, 65164}, new char[]{1575, 65165, 65166}, new char[]{1576, 65167, 65168, 65169, 65170}, new char[]{1577, 65171, 65172}, new char[]{1578, 65173, 65174, 65175, 65176}, new char[]{1579, 65177, 65178, 65179, 65180}, new char[]{1580, 65181, 65182, 65183, 65184}, new char[]{1581, 65185, 65186, 65187, 65188}, new char[]{1582, 65189, 65190, 65191, 65192}, new char[]{1583, 65193, 65194}, new char[]{1584, 65195, 65196}, new char[]{1585, 65197, 65198}, new char[]{1586, 65199, 65200}, new char[]{1587, 65201, 65202, 65203, 65204}, new char[]{1588, 65205, 65206, 65207, 65208}, new char[]{1589, 65209, 65210, 65211, 65212}, new char[]{1590, 65213, 65214, 65215, 65216}, new char[]{1591, 65217, 65218, 65219, 65220}, new char[]{1592, 65221, 65222, 65223, 65224}, new char[]{1593, 65225, 65226, 65227, 65228}, new char[]{1594, 65229, 65230, 65231, 65232}, new char[]{1600, 1600, 1600, 1600, 1600}, new char[]{1601, 65233, 65234, 65235, 65236}, new char[]{1602, 65237, 65238, 65239, 65240}, new char[]{1603, 65241, 65242, 65243, 65244}, new char[]{1604, 65245, 65246, 65247, 65248}, new char[]{1605, 65249, 65250, 65251, 65252}, new char[]{1606, 65253, 65254, 65255, 65256}, new char[]{1607, 65257, 65258, 65259, 65260}, new char[]{1608, 65261, 65262}, new char[]{1609, 65263, 65264, 64488, 64489}, new char[]{1610, 65265, 65266, 65267, 65268}, new char[]{1649, 64336, 64337}, new char[]{1657, 64358, 64359, 64360, 64361}, new char[]{1658, 64350, 64351, 64352, 64353}, new char[]{1659, 64338, 64339, 64340, 64341}, new char[]{1662, 64342, 64343, 64344, 64345}, new char[]{1663, 64354, 64355, 64356, 64357}, new char[]{1664, 64346, 64347, 64348, 64349}, new char[]{1667, 64374, 64375, 64376, 64377}, new char[]{1668, 64370, 64371, 64372, 64373}, new char[]{1670, 64378, 64379, 64380, 64381}, new char[]{1671, 64382, 64383, 64384, 64385}, new char[]{1672, 64392, 64393}, new char[]{1676, 64388, 64389}, new char[]{1677, 64386, 64387}, new char[]{1678, 64390, 64391}, new char[]{1681, 64396, 64397}, new char[]{1688, 64394, 64395}, new char[]{1700, 64362, 64363, 64364, 64365}, new char[]{1702, 64366, 64367, 64368, 64369}, new char[]{1705, 64398, 64399, 64400, 64401}, new char[]{1709, 64467, 64468, 64469, 64470}, new char[]{1711, 64402, 64403, 64404, 64405}, new char[]{1713, 64410, 64411, 64412, 64413}, new char[]{1715, 64406, 64407, 64408, 64409}, new char[]{1722, 64414, 64415}, new char[]{1723, 64416, 64417, 64418, 64419}, new char[]{1726, 64426, 64427, 64428, 64429}, new char[]{1728, 64420, 64421}, new char[]{1729, 64422, 64423, 64424, 64425}, new char[]{1733, 64480, 64481}, new char[]{1734, 64473, 64474}, new char[]{1735, 64471, 64472}, new char[]{1736, 64475, 64476}, new char[]{1737, 64482, 64483}, new char[]{1739, 64478, 64479}, new char[]{1740, 64508, 64509, 64510, 64511}, new char[]{1744, 64484, 64485, 64486, 64487}, new char[]{1746, 64430, 64431}, new char[]{1747, 64432, 64433}};
        f9776ad = cArr;
        for (char[] cArr2 : cArr) {
            qw.put(Character.valueOf(cArr2[0]), cArr2);
        }
    }

    public static char ad(char c, int i2) {
        if (c < 1569 || c > 1747) {
            return (c < 65269 || c > 65275) ? c : (char) (c + i2);
        }
        char[] cArr = qw.get(Character.valueOf(c));
        return cArr != null ? cArr[i2 + 1] : c;
    }

    public static boolean de(C0329qw qwVar) {
        return qwVar.f9780rg > 2;
    }

    public static void fe(StringBuffer stringBuffer, C0329qw qwVar, int i2) {
        char c = qwVar.qw;
        if (c != 0) {
            stringBuffer.append(c);
            int i3 = qwVar.f9779fe - 1;
            qwVar.f9779fe = i3;
            char c2 = qwVar.f9777ad;
            if (c2 != 0) {
                if ((i2 & 1) == 0) {
                    stringBuffer.append(c2);
                    qwVar.f9779fe--;
                } else {
                    qwVar.f9779fe = i3 - 1;
                }
            }
            char c3 = qwVar.f9778de;
            if (c3 == 0) {
                return;
            }
            if ((i2 & 1) == 0) {
                stringBuffer.append(c3);
                qwVar.f9779fe--;
                return;
            }
            qwVar.f9779fe--;
        }
    }

    public static void i(char[] cArr, StringBuffer stringBuffer, int i2) {
        C0329qw qwVar = new C0329qw();
        C0329qw qwVar2 = new C0329qw();
        int i3 = 0;
        while (i3 < cArr.length) {
            int i4 = i3 + 1;
            char c = cArr[i3];
            if (yj(c, qwVar2) == 0) {
                int pf2 = pf(c);
                int i5 = pf2 == 1 ? 0 : 2;
                if (de(qwVar)) {
                    i5++;
                }
                qwVar2.qw = ad(qwVar2.qw, i5 % qwVar2.f9780rg);
                fe(stringBuffer, qwVar, i2);
                C0329qw qwVar3 = new C0329qw();
                qwVar3.qw = c;
                qwVar3.f9780rg = pf2;
                qwVar3.f9779fe++;
                i3 = i4;
                C0329qw qwVar4 = qwVar2;
                qwVar2 = qwVar3;
                qwVar = qwVar4;
            } else {
                i3 = i4;
            }
        }
        qwVar2.qw = ad(qwVar2.qw, (de(qwVar) ? 1 : 0) % qwVar2.f9780rg);
        fe(stringBuffer, qwVar, i2);
        fe(stringBuffer, qwVar2, i2);
    }

    public static void o(char[] cArr, int i2, int i3, char c, boolean z) {
        char c2 = (char) (c - '0');
        int i4 = i3 + i2;
        while (i2 < i4) {
            char c3 = cArr[i2];
            byte fe2 = fe.fe(c3);
            if (fe2 != 0) {
                if (fe2 != 8) {
                    if (fe2 != 3) {
                        if (fe2 == 4) {
                            z = true;
                        }
                    }
                } else if (z && c3 <= '9') {
                    cArr[i2] = (char) (c3 + c2);
                }
                i2++;
            }
            z = false;
            i2++;
        }
    }

    public static int pf(char c) {
        if (c >= 1569 && c <= 1747 && !th(c)) {
            char[] cArr = qw.get(Character.valueOf(c));
            if (cArr != null) {
                return cArr.length - 1;
            }
        } else if (c == 8205) {
            return 4;
        }
        return 1;
    }

    public static int qw(char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5, int i6) {
        char[] cArr3 = new char[i3];
        for (int i7 = (i3 + i2) - 1; i7 >= i2; i7--) {
            cArr3[i7 - i2] = cArr[i7];
        }
        StringBuffer stringBuffer = new StringBuffer(i3);
        i(cArr3, stringBuffer, i6);
        if ((i6 & 12) != 0) {
            rg(stringBuffer, i6);
        }
        System.arraycopy(stringBuffer.toString().toCharArray(), 0, cArr2, i4, stringBuffer.length());
        return stringBuffer.length();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r6 = 64609;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r6 = 64608;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void rg(java.lang.StringBuffer r10, int r11) {
        /*
            int r0 = r10.length()
            r1 = 0
            r2 = 1
            r3 = r0
            r4 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x013b
            r5 = r11 & 4
            r6 = 64610(0xfc62, float:9.0538E-41)
            r7 = 64609(0xfc61, float:9.0536E-41)
            r8 = 64608(0xfc60, float:9.0535E-41)
            if (r5 == 0) goto L_0x0052
            char r5 = r10.charAt(r4)
            r9 = 1617(0x651, float:2.266E-42)
            switch(r5) {
                case 1614: goto L_0x0048;
                case 1615: goto L_0x003e;
                case 1616: goto L_0x0037;
                case 1617: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0052
        L_0x0021:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 1612: goto L_0x0030;
                case 1613: goto L_0x0029;
                case 1614: goto L_0x004e;
                case 1615: goto L_0x0044;
                case 1616: goto L_0x0053;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0052
        L_0x0029:
            r5 = 64607(0xfc5f, float:9.0534E-41)
            r6 = 64607(0xfc5f, float:9.0534E-41)
            goto L_0x0053
        L_0x0030:
            r5 = 64606(0xfc5e, float:9.0532E-41)
            r6 = 64606(0xfc5e, float:9.0532E-41)
            goto L_0x0053
        L_0x0037:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0052
            goto L_0x0053
        L_0x003e:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0052
        L_0x0044:
            r6 = 64609(0xfc61, float:9.0536E-41)
            goto L_0x0053
        L_0x0048:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0052
        L_0x004e:
            r6 = 64608(0xfc60, float:9.0535E-41)
            goto L_0x0053
        L_0x0052:
            r6 = 0
        L_0x0053:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x0126
            char r5 = r10.charAt(r4)
            r7 = 65192(0xfea8, float:9.1353E-41)
            r8 = 65188(0xfea4, float:9.1348E-41)
            r9 = 65184(0xfea0, float:9.1342E-41)
            switch(r5) {
                case 65169: goto L_0x0110;
                case 65175: goto L_0x00f9;
                case 65235: goto L_0x00eb;
                case 65247: goto L_0x00c1;
                case 65251: goto L_0x00a4;
                case 65255: goto L_0x0089;
                case 65256: goto L_0x0069;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0126
        L_0x0069:
            char r5 = r10.charAt(r2)
            r7 = 65198(0xfeae, float:9.1362E-41)
            if (r5 == r7) goto L_0x0081
            r7 = 65200(0xfeb0, float:9.1365E-41)
            if (r5 == r7) goto L_0x0079
            goto L_0x0126
        L_0x0079:
            r5 = 64651(0xfc8b, float:9.0595E-41)
            r6 = 64651(0xfc8b, float:9.0595E-41)
            goto L_0x0126
        L_0x0081:
            r5 = 64650(0xfc8a, float:9.0594E-41)
            r6 = 64650(0xfc8a, float:9.0594E-41)
            goto L_0x0126
        L_0x0089:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x009f
            if (r5 == r8) goto L_0x009a
            if (r5 == r7) goto L_0x0095
            goto L_0x0126
        L_0x0095:
            r6 = 64724(0xfcd4, float:9.0698E-41)
            goto L_0x0126
        L_0x009a:
            r6 = 64723(0xfcd3, float:9.0696E-41)
            goto L_0x0126
        L_0x009f:
            r6 = 64722(0xfcd2, float:9.0695E-41)
            goto L_0x0126
        L_0x00a4:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 65184: goto L_0x00bc;
                case 65188: goto L_0x00b7;
                case 65192: goto L_0x00b2;
                case 65252: goto L_0x00ad;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            goto L_0x0126
        L_0x00ad:
            r6 = 64721(0xfcd1, float:9.0693E-41)
            goto L_0x0126
        L_0x00b2:
            r6 = 64720(0xfcd0, float:9.0692E-41)
            goto L_0x0126
        L_0x00b7:
            r6 = 64719(0xfccf, float:9.069E-41)
            goto L_0x0126
        L_0x00bc:
            r6 = 64718(0xfcce, float:9.0689E-41)
            goto L_0x0126
        L_0x00c1:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 65182: goto L_0x00e7;
                case 65184: goto L_0x00e3;
                case 65186: goto L_0x00df;
                case 65188: goto L_0x00db;
                case 65190: goto L_0x00d7;
                case 65192: goto L_0x00d3;
                case 65250: goto L_0x00cf;
                case 65252: goto L_0x00ca;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            goto L_0x0126
        L_0x00ca:
            r6 = 64716(0xfccc, float:9.0686E-41)
            goto L_0x0126
        L_0x00cf:
            r6 = 64578(0xfc42, float:9.0493E-41)
            goto L_0x0126
        L_0x00d3:
            r6 = 64715(0xfccb, float:9.0685E-41)
            goto L_0x0126
        L_0x00d7:
            r6 = 64577(0xfc41, float:9.0492E-41)
            goto L_0x0126
        L_0x00db:
            r6 = 64714(0xfcca, float:9.0684E-41)
            goto L_0x0126
        L_0x00df:
            r6 = 64576(0xfc40, float:9.049E-41)
            goto L_0x0126
        L_0x00e3:
            r6 = 64713(0xfcc9, float:9.0682E-41)
            goto L_0x0126
        L_0x00e7:
            r6 = 64575(0xfc3f, float:9.0489E-41)
            goto L_0x0126
        L_0x00eb:
            char r5 = r10.charAt(r2)
            r7 = 65266(0xfef2, float:9.1457E-41)
            if (r5 == r7) goto L_0x00f5
            goto L_0x0126
        L_0x00f5:
            r6 = 64562(0xfc32, float:9.047E-41)
            goto L_0x0126
        L_0x00f9:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x010c
            if (r5 == r8) goto L_0x0108
            if (r5 == r7) goto L_0x0104
            goto L_0x0126
        L_0x0104:
            r6 = 64675(0xfca3, float:9.0629E-41)
            goto L_0x0126
        L_0x0108:
            r6 = 64674(0xfca2, float:9.0628E-41)
            goto L_0x0126
        L_0x010c:
            r6 = 64673(0xfca1, float:9.0626E-41)
            goto L_0x0126
        L_0x0110:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x0123
            if (r5 == r8) goto L_0x011f
            if (r5 == r7) goto L_0x011b
            goto L_0x0126
        L_0x011b:
            r6 = 64670(0xfc9e, float:9.0622E-41)
            goto L_0x0126
        L_0x011f:
            r6 = 64669(0xfc9d, float:9.062E-41)
            goto L_0x0126
        L_0x0123:
            r6 = 64668(0xfc9c, float:9.0619E-41)
        L_0x0126:
            if (r6 == 0) goto L_0x012e
            r10.setCharAt(r4, r6)
            int r3 = r3 + -1
            goto L_0x0137
        L_0x012e:
            int r4 = r4 + 1
            char r5 = r10.charAt(r2)
            r10.setCharAt(r4, r5)
        L_0x0137:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x013b:
            r10.setLength(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.t2.qw.rg(java.lang.StringBuffer, int):void");
    }

    public static boolean th(char c) {
        return (c >= 1611 && c <= 1621) || c == 1648;
    }

    public static void uk(char[] cArr, int i2, int i3, int i4) {
        int i5 = i2 + i3;
        int i6 = i4 & 224;
        if (i6 != 0) {
            int i7 = i4 & 256;
            char c = i7 != 0 ? i7 != 256 ? '0' : 1776 : 1632;
            if (i6 == 32) {
                int i8 = c - '0';
                while (i2 < i5) {
                    char c2 = cArr[i2];
                    if (c2 <= '9' && c2 >= '0') {
                        cArr[i2] = (char) (cArr[i2] + i8);
                    }
                    i2++;
                }
            } else if (i6 == 64) {
                char c3 = (char) (c + 9);
                int i9 = '0' - c;
                while (i2 < i5) {
                    char c4 = cArr[i2];
                    if (c4 <= c3 && c4 >= c) {
                        cArr[i2] = (char) (cArr[i2] + i9);
                    }
                    i2++;
                }
            } else if (i6 == 96) {
                o(cArr, 0, i3, c, false);
            } else if (i6 == 128) {
                o(cArr, 0, i3, c, true);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int yj(char r12, fe.when.ad.f.t2.qw.C0329qw r13) {
        /*
            char r0 = r13.qw
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = th(r12)
            r2 = 65273(0xfef9, float:9.1467E-41)
            r3 = 65271(0xfef7, float:9.1464E-41)
            r4 = 1573(0x625, float:2.204E-42)
            r5 = 1571(0x623, float:2.201E-42)
            r6 = 1570(0x622, float:2.2E-42)
            r7 = 65275(0xfefb, float:9.147E-41)
            r8 = 1575(0x627, float:2.207E-42)
            r9 = 1
            r10 = 2
            if (r0 == 0) goto L_0x007c
            char r0 = r13.f9778de
            r11 = 1617(0x651, float:2.266E-42)
            if (r0 == 0) goto L_0x0029
            if (r12 == r11) goto L_0x0029
            r0 = 2
            goto L_0x002a
        L_0x0029:
            r0 = 1
        L_0x002a:
            switch(r12) {
                case 1617: goto L_0x006b;
                case 1618: goto L_0x002d;
                case 1619: goto L_0x0063;
                case 1620: goto L_0x0041;
                case 1621: goto L_0x0030;
                default: goto L_0x002d;
            }
        L_0x002d:
            r13.f9778de = r12
            goto L_0x0073
        L_0x0030:
            char r12 = r13.qw
            if (r12 == r8) goto L_0x003e
            if (r12 == r7) goto L_0x003b
            r12 = 1621(0x655, float:2.272E-42)
            r13.f9777ad = r12
            goto L_0x0073
        L_0x003b:
            r13.qw = r2
            goto L_0x0074
        L_0x003e:
            r13.qw = r4
            goto L_0x0074
        L_0x0041:
            char r12 = r13.qw
            if (r12 == r8) goto L_0x0060
            r1 = 1740(0x6cc, float:2.438E-42)
            if (r12 == r1) goto L_0x005b
            if (r12 == r7) goto L_0x0058
            switch(r12) {
                case 1608: goto L_0x0053;
                case 1609: goto L_0x005b;
                case 1610: goto L_0x005b;
                default: goto L_0x004e;
            }
        L_0x004e:
            r12 = 1620(0x654, float:2.27E-42)
            r13.f9777ad = r12
            goto L_0x0073
        L_0x0053:
            r12 = 1572(0x624, float:2.203E-42)
            r13.qw = r12
            goto L_0x0074
        L_0x0058:
            r13.qw = r3
            goto L_0x0074
        L_0x005b:
            r12 = 1574(0x626, float:2.206E-42)
            r13.qw = r12
            goto L_0x0074
        L_0x0060:
            r13.qw = r5
            goto L_0x0074
        L_0x0063:
            char r12 = r13.qw
            if (r12 == r8) goto L_0x0068
            goto L_0x0073
        L_0x0068:
            r13.qw = r6
            goto L_0x0074
        L_0x006b:
            char r12 = r13.f9777ad
            if (r12 != 0) goto L_0x0072
            r13.f9777ad = r11
            goto L_0x0073
        L_0x0072:
            return r1
        L_0x0073:
            r10 = r0
        L_0x0074:
            if (r10 != r9) goto L_0x007b
            int r12 = r13.f9779fe
            int r12 = r12 + r9
            r13.f9779fe = r12
        L_0x007b:
            return r10
        L_0x007c:
            char r0 = r13.f9778de
            if (r0 == 0) goto L_0x0081
            return r1
        L_0x0081:
            char r0 = r13.qw
            if (r0 == 0) goto L_0x00ac
            r9 = 1604(0x644, float:2.248E-42)
            if (r0 == r9) goto L_0x008a
            goto L_0x00b5
        L_0x008a:
            r0 = 3
            if (r12 == r6) goto L_0x00a3
            if (r12 == r5) goto L_0x009e
            if (r12 == r4) goto L_0x0099
            if (r12 == r8) goto L_0x0094
            goto L_0x00b5
        L_0x0094:
            r13.qw = r7
            r13.f9780rg = r10
            goto L_0x00aa
        L_0x0099:
            r13.qw = r2
            r13.f9780rg = r10
            goto L_0x00aa
        L_0x009e:
            r13.qw = r3
            r13.f9780rg = r10
            goto L_0x00aa
        L_0x00a3:
            r12 = 65269(0xfef5, float:9.1461E-41)
            r13.qw = r12
            r13.f9780rg = r10
        L_0x00aa:
            r1 = 3
            goto L_0x00b5
        L_0x00ac:
            r13.qw = r12
            int r12 = pf(r12)
            r13.f9780rg = r12
            r1 = 1
        L_0x00b5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.t2.qw.yj(char, fe.when.ad.f.t2.qw$qw):int");
    }
}
