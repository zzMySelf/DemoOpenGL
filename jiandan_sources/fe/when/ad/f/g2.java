package fe.when.ad.f;

import com.baidu.android.common.others.lang.StringUtil;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public final class g2 implements SimpleXMLDocHandler {
    public static void th(x xVar, HashMap<String, Object> hashMap, c2 c2Var, boolean z) {
        String str;
        x xVar2 = xVar;
        HashMap<String, Object> hashMap2 = hashMap;
        c2 c2Var2 = c2Var;
        try {
            String str2 = (String) hashMap2.get("Action");
            if ("GoTo".equals(str2)) {
                String str3 = (String) hashMap2.get("Named");
                if (str3 == null) {
                    String str4 = (String) hashMap2.get("Page");
                    if (str4 != null) {
                        k kVar = new k();
                        StringTokenizer stringTokenizer = new StringTokenizer(str4);
                        kVar.qqq(c2Var2.K(Integer.parseInt(stringTokenizer.nextToken())));
                        if (!stringTokenizer.hasMoreTokens()) {
                            kVar.qqq(s0.y6);
                            kVar.eee(new float[]{0.0f, 10000.0f, 0.0f});
                        } else {
                            String nextToken = stringTokenizer.nextToken();
                            if (nextToken.startsWith("/")) {
                                nextToken = nextToken.substring(1);
                            }
                            kVar.qqq(new s0(nextToken));
                            for (int i2 = 0; i2 < 4 && stringTokenizer.hasMoreTokens(); i2++) {
                                String nextToken2 = stringTokenizer.nextToken();
                                if (nextToken2.equals(StringUtil.NULL_STRING)) {
                                    kVar.qqq(u0.f9819uk);
                                } else {
                                    kVar.qqq(new v0(nextToken2));
                                }
                            }
                        }
                        xVar2.h(s0.t0, kVar);
                    }
                } else if (z) {
                    xVar2.h(s0.t0, new s0(str3));
                } else {
                    xVar2.h(s0.t0, new w1(str3, (String) null));
                }
            } else if ("GoToR".equals(str2)) {
                x xVar3 = new x();
                String str5 = (String) hashMap2.get("Named");
                if (str5 != null) {
                    xVar3.h(s0.k0, new w1(str5, (String) null));
                } else {
                    String str6 = (String) hashMap2.get("NamedN");
                    if (str6 != null) {
                        xVar3.h(s0.k0, new s0(str6));
                    } else {
                        String str7 = (String) hashMap2.get("Page");
                        if (str7 != null) {
                            k kVar2 = new k();
                            StringTokenizer stringTokenizer2 = new StringTokenizer(str7);
                            kVar2.qqq(new v0(stringTokenizer2.nextToken()));
                            if (!stringTokenizer2.hasMoreTokens()) {
                                kVar2.qqq(s0.y6);
                                kVar2.eee(new float[]{0.0f, 10000.0f, 0.0f});
                            } else {
                                String nextToken3 = stringTokenizer2.nextToken();
                                if (nextToken3.startsWith("/")) {
                                    nextToken3 = nextToken3.substring(1);
                                }
                                kVar2.qqq(new s0(nextToken3));
                                for (int i3 = 0; i3 < 4 && stringTokenizer2.hasMoreTokens(); i3++) {
                                    String nextToken4 = stringTokenizer2.nextToken();
                                    if (nextToken4.equals(StringUtil.NULL_STRING)) {
                                        kVar2.qqq(u0.f9819uk);
                                    } else {
                                        kVar2.qqq(new v0(nextToken4));
                                    }
                                }
                            }
                            xVar3.h(s0.k0, kVar2);
                        }
                    }
                }
                String str8 = (String) hashMap2.get("File");
                if (xVar3.size() > 0 && str8 != null) {
                    xVar3.h(s0.D4, s0.E1);
                    xVar3.h(s0.a1, new w1(str8));
                    String str9 = (String) hashMap2.get("NewWindow");
                    if (str9 != null) {
                        if (str9.equals("true")) {
                            xVar3.h(s0.f3, l.f9519i);
                        } else if (str9.equals("false")) {
                            xVar3.h(s0.f3, l.f9520o);
                        }
                    }
                    xVar2.h(s0.f9757i, xVar3);
                }
            } else if ("URI".equals(str2)) {
                String str10 = (String) hashMap2.get("URI");
                if (str10 != null) {
                    x xVar4 = new x();
                    xVar4.h(s0.D4, s0.S5);
                    xVar4.h(s0.S5, new w1(str10));
                    xVar2.h(s0.f9757i, xVar4);
                }
            } else if ("JS".equals(str2)) {
                String str11 = (String) hashMap2.get("Code");
                if (str11 != null) {
                    xVar2.h(s0.f9757i, h.l(str11, c2Var2));
                }
            } else if ("Launch".equals(str2) && (str = (String) hashMap2.get("File")) != null) {
                x xVar5 = new x();
                xVar5.h(s0.D4, s0.B2);
                xVar5.h(s0.a1, new w1(str));
                xVar2.h(s0.f9757i, xVar5);
            }
        } catch (Exception unused) {
        }
    }

    public static Object[] yj(c2 c2Var, l0 l0Var, List<HashMap<String, Object>> list, boolean z) throws IOException {
        c2 c2Var2 = c2Var;
        boolean z2 = z;
        int size = list.size();
        l0[] l0VarArr = new l0[size];
        char c = 0;
        for (int i2 = 0; i2 < size; i2++) {
            l0VarArr[i2] = c2Var.M();
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        int i3 = 0;
        int i4 = 0;
        while (listIterator.hasNext()) {
            HashMap next = listIterator.next();
            Object[] objArr = null;
            List list2 = (List) next.get("Kids");
            if (list2 != null && !list2.isEmpty()) {
                objArr = yj(c2Var2, l0VarArr[i4], list2, z2);
            }
            x xVar = new x();
            i3++;
            if (objArr != null) {
                xVar.h(s0.f1, (l0) objArr[c]);
                xVar.h(s0.y2, (l0) objArr[1]);
                int intValue = ((Integer) objArr[2]).intValue();
                if ("false".equals(next.get("Open"))) {
                    xVar.h(s0.a0, new v0(-intValue));
                } else {
                    xVar.h(s0.a0, new v0(intValue));
                    i3 += intValue;
                }
            }
            xVar.h(s0.O3, l0Var);
            if (i4 > 0) {
                xVar.h(s0.X3, l0VarArr[i4 - 1]);
            }
            if (i4 < size - 1) {
                xVar.h(s0.g3, l0VarArr[i4 + 1]);
            }
            xVar.h(s0.y5, new w1((String) next.get("Title"), "UnicodeBig"));
            String str = (String) next.get("Color");
            if (str != null) {
                try {
                    k kVar = new k();
                    StringTokenizer stringTokenizer = new StringTokenizer(str);
                    for (int i5 = 0; i5 < 3; i5++) {
                        float parseFloat = Float.parseFloat(stringTokenizer.nextToken());
                        if (parseFloat < 0.0f) {
                            parseFloat = 0.0f;
                        }
                        if (parseFloat > 1.0f) {
                            parseFloat = 1.0f;
                        }
                        kVar.qqq(new v0(parseFloat));
                    }
                    xVar.h(s0.x, kVar);
                } catch (Exception unused) {
                }
            }
            String str2 = (String) next.get("Style");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase();
                int i6 = lowerCase.indexOf("italic") >= 0 ? 1 : 0;
                if (lowerCase.indexOf("bold") >= 0) {
                    i6 |= 2;
                }
                if (i6 != 0) {
                    xVar.h(s0.a1, new v0(i6));
                }
            }
            th(xVar, next, c2Var2, z2);
            c2Var2.tt(xVar, l0VarArr[i4]);
            i4++;
            c = 0;
        }
        return new Object[]{l0VarArr[0], l0VarArr[size - 1], Integer.valueOf(i3)};
    }
}
