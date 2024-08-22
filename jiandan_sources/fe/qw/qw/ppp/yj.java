package fe.qw.qw.ppp;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alipay.sdk.m.s.a;

public class yj {
    public static JsonReader.qw qw = JsonReader.qw.qw(a.s, "d");

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        if (r2.equals("gs") != false) goto L_0x00c0;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.content.ContentModel qw(com.airbnb.lottie.parser.moshi.JsonReader r7, fe.qw.qw.de r8) throws java.io.IOException {
        /*
            r7.fe()
            r0 = 2
            r1 = 2
        L_0x0005:
            boolean r2 = r7.yj()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0028
            com.airbnb.lottie.parser.moshi.JsonReader$qw r2 = qw
            int r2 = r7.ddd(r2)
            if (r2 == 0) goto L_0x0023
            if (r2 == r3) goto L_0x001e
            r7.nn()
            r7.mmm()
            goto L_0x0005
        L_0x001e:
            int r1 = r7.m4switch()
            goto L_0x0005
        L_0x0023:
            java.lang.String r2 = r7.ppp()
            goto L_0x0029
        L_0x0028:
            r2 = r4
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            return r4
        L_0x002c:
            r5 = -1
            int r6 = r2.hashCode()
            switch(r6) {
                case 3239: goto L_0x00b5;
                case 3270: goto L_0x00ab;
                case 3295: goto L_0x00a1;
                case 3307: goto L_0x0097;
                case 3308: goto L_0x008e;
                case 3488: goto L_0x0083;
                case 3633: goto L_0x0078;
                case 3646: goto L_0x006d;
                case 3669: goto L_0x0063;
                case 3679: goto L_0x0058;
                case 3681: goto L_0x004d;
                case 3705: goto L_0x0041;
                case 3710: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x00bf
        L_0x0036:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 5
            goto L_0x00c0
        L_0x0041:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 9
            goto L_0x00c0
        L_0x004d:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 1
            goto L_0x00c0
        L_0x0058:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 10
            goto L_0x00c0
        L_0x0063:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 6
            goto L_0x00c0
        L_0x006d:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 12
            goto L_0x00c0
        L_0x0078:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 8
            goto L_0x00c0
        L_0x0083:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 11
            goto L_0x00c0
        L_0x008e:
            java.lang.String r3 = "gs"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00bf
            goto L_0x00c0
        L_0x0097:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 0
            goto L_0x00c0
        L_0x00a1:
            java.lang.String r0 = "gf"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 4
            goto L_0x00c0
        L_0x00ab:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 3
            goto L_0x00c0
        L_0x00b5:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 7
            goto L_0x00c0
        L_0x00bf:
            r0 = -1
        L_0x00c0:
            switch(r0) {
                case 0: goto L_0x0119;
                case 1: goto L_0x0114;
                case 2: goto L_0x010f;
                case 3: goto L_0x010a;
                case 4: goto L_0x0105;
                case 5: goto L_0x0100;
                case 6: goto L_0x00fb;
                case 7: goto L_0x00f6;
                case 8: goto L_0x00f1;
                case 9: goto L_0x00ec;
                case 10: goto L_0x00e7;
                case 11: goto L_0x00dd;
                case 12: goto L_0x00d8;
                default: goto L_0x00c3;
            }
        L_0x00c3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unknown shape type "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            fe.qw.qw.ggg.fe.de(r8)
            goto L_0x011d
        L_0x00d8:
            fe.qw.qw.switch.i.th r4 = fe.qw.qw.ppp.b.qw(r7, r8)
            goto L_0x011d
        L_0x00dd:
            com.airbnb.lottie.model.content.MergePaths r4 = fe.qw.qw.ppp.aaa.qw(r7)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r8.qw(r0)
            goto L_0x011d
        L_0x00e7:
            com.airbnb.lottie.model.content.PolystarShape r4 = fe.qw.qw.ppp.tt.qw(r7, r8)
            goto L_0x011d
        L_0x00ec:
            com.airbnb.lottie.model.content.ShapeTrimPath r4 = fe.qw.qw.ppp.j.qw(r7, r8)
            goto L_0x011d
        L_0x00f1:
            fe.qw.qw.switch.i.rg r4 = fe.qw.qw.ppp.a.qw(r7, r8)
            goto L_0x011d
        L_0x00f6:
            fe.qw.qw.switch.i.qw r4 = fe.qw.qw.ppp.rg.qw(r7, r8, r1)
            goto L_0x011d
        L_0x00fb:
            fe.qw.qw.switch.i.o r4 = fe.qw.qw.ppp.g.qw(r7, r8)
            goto L_0x011d
        L_0x0100:
            fe.qw.qw.switch.uk.if r4 = fe.qw.qw.ppp.de.yj(r7, r8)
            goto L_0x011d
        L_0x0105:
            fe.qw.qw.switch.i.de r4 = fe.qw.qw.ppp.Cswitch.qw(r7, r8)
            goto L_0x011d
        L_0x010a:
            fe.qw.qw.switch.i.uk r4 = fe.qw.qw.ppp.e.qw(r7, r8)
            goto L_0x011d
        L_0x010f:
            fe.qw.qw.switch.i.fe r4 = fe.qw.qw.ppp.when.qw(r7, r8)
            goto L_0x011d
        L_0x0114:
            com.airbnb.lottie.model.content.ShapeStroke r4 = fe.qw.qw.ppp.h.qw(r7, r8)
            goto L_0x011d
        L_0x0119:
            fe.qw.qw.switch.i.i r4 = fe.qw.qw.ppp.f.qw(r7, r8)
        L_0x011d:
            boolean r8 = r7.yj()
            if (r8 == 0) goto L_0x0127
            r7.mmm()
            goto L_0x011d
        L_0x0127:
            r7.th()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.ppp.yj.qw(com.airbnb.lottie.parser.moshi.JsonReader, fe.qw.qw.de):com.airbnb.lottie.model.content.ContentModel");
    }
}
