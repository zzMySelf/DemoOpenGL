package fe.when.ad.f;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class t0 {
    public static x qw(HashMap<String, ? extends y0> hashMap, c2 c2Var) throws IOException {
        HashMap<String, ? extends y0> hashMap2 = hashMap;
        c2 c2Var2 = c2Var;
        if (hashMap.isEmpty()) {
            return null;
        }
        String[] strArr = (String[]) hashMap.keySet().toArray(new String[hashMap.size()]);
        Arrays.sort(strArr);
        int i2 = 64;
        if (strArr.length <= 64) {
            x xVar = new x();
            k kVar = new k();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                kVar.qqq(new w1(strArr[i3], (String) null));
                kVar.qqq((y0) hashMap2.get(strArr[i3]));
            }
            xVar.h(s0.e3, kVar);
            return xVar;
        }
        int length = ((strArr.length + 64) - 1) / 64;
        l0[] l0VarArr = new l0[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 64;
            int min = Math.min(i5 + 64, strArr.length);
            x xVar2 = new x();
            k kVar2 = new k();
            kVar2.qqq(new w1(strArr[i5], (String) null));
            kVar2.qqq(new w1(strArr[min - 1], (String) null));
            xVar2.h(s0.H2, kVar2);
            k kVar3 = new k();
            while (i5 < min) {
                kVar3.qqq(new w1(strArr[i5], (String) null));
                kVar3.qqq((y0) hashMap2.get(strArr[i5]));
                i5++;
            }
            xVar2.h(s0.e3, kVar3);
            l0VarArr[i4] = c2Var2.eee(xVar2).qw();
        }
        int i6 = 64;
        while (length > i2) {
            i6 *= 64;
            int length2 = ((strArr.length + i6) - 1) / i6;
            int i7 = 0;
            while (i7 < length2) {
                int i8 = i7 * 64;
                int min2 = Math.min(i8 + 64, length);
                x xVar3 = new x();
                k kVar4 = new k();
                kVar4.qqq(new w1(strArr[i7 * i6], (String) null));
                int i9 = i7 + 1;
                kVar4.qqq(new w1(strArr[Math.min(i9 * i6, strArr.length) - 1], (String) null));
                xVar3.h(s0.H2, kVar4);
                k kVar5 = new k();
                while (i8 < min2) {
                    kVar5.qqq(l0VarArr[i8]);
                    i8++;
                }
                xVar3.h(s0.u2, kVar5);
                l0VarArr[i7] = c2Var2.eee(xVar3).qw();
                i7 = i9;
                i2 = 64;
            }
            length = length2;
        }
        k kVar6 = new k();
        for (int i10 = 0; i10 < length; i10++) {
            kVar6.qqq(l0VarArr[i10]);
        }
        x xVar4 = new x();
        xVar4.h(s0.u2, kVar6);
        return xVar4;
    }
}
