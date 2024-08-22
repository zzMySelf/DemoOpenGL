package fe.when.ad.f;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class w0 {
    public static <O extends y0> x qw(HashMap<Integer, O> hashMap, c2 c2Var) throws IOException {
        HashMap<Integer, O> hashMap2 = hashMap;
        c2 c2Var2 = c2Var;
        if (hashMap.isEmpty()) {
            return null;
        }
        Integer[] numArr = (Integer[]) hashMap.keySet().toArray(new Integer[hashMap.size()]);
        Arrays.sort(numArr);
        if (numArr.length <= 64) {
            x xVar = new x();
            k kVar = new k();
            for (int i2 = 0; i2 < numArr.length; i2++) {
                kVar.qqq(new v0(numArr[i2].intValue()));
                kVar.qqq((y0) hashMap2.get(numArr[i2]));
            }
            xVar.h(s0.n3, kVar);
            return xVar;
        }
        int length = ((numArr.length + 64) - 1) / 64;
        l0[] l0VarArr = new l0[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 64;
            int min = Math.min(i4 + 64, numArr.length);
            x xVar2 = new x();
            k kVar2 = new k();
            kVar2.qqq(new v0(numArr[i4].intValue()));
            kVar2.qqq(new v0(numArr[min - 1].intValue()));
            xVar2.h(s0.H2, kVar2);
            k kVar3 = new k();
            while (i4 < min) {
                kVar3.qqq(new v0(numArr[i4].intValue()));
                kVar3.qqq((y0) hashMap2.get(numArr[i4]));
                i4++;
            }
            xVar2.h(s0.n3, kVar3);
            l0VarArr[i3] = c2Var2.eee(xVar2).qw();
        }
        int i5 = 64;
        while (length > 64) {
            i5 *= 64;
            int length2 = ((numArr.length + i5) - 1) / i5;
            int i6 = 0;
            while (i6 < length2) {
                int i7 = i6 * 64;
                int min2 = Math.min(i7 + 64, length);
                x xVar3 = new x();
                k kVar4 = new k();
                kVar4.qqq(new v0(numArr[i6 * i5].intValue()));
                int i8 = i6 + 1;
                kVar4.qqq(new v0(numArr[Math.min(i8 * i5, numArr.length) - 1].intValue()));
                xVar3.h(s0.H2, kVar4);
                k kVar5 = new k();
                while (i7 < min2) {
                    kVar5.qqq(l0VarArr[i7]);
                    i7++;
                }
                xVar3.h(s0.u2, kVar5);
                l0VarArr[i6] = c2Var2.eee(xVar3).qw();
                i6 = i8;
            }
            length = length2;
        }
        k kVar6 = new k();
        for (int i9 = 0; i9 < length; i9++) {
            kVar6.qqq(l0VarArr[i9]);
        }
        x xVar4 = new x();
        xVar4.h(s0.u2, kVar6);
        return xVar4;
    }
}
