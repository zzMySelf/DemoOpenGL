package fe.qw.qw.ppp;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.dlife.ctaccountapi.v;
import com.dlife.ctaccountapi.w;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

public class h {

    /* renamed from: ad  reason: collision with root package name */
    public static final JsonReader.qw f3395ad = JsonReader.qw.qw(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, v.d);
    public static JsonReader.qw qw = JsonReader.qw.qw(SearchView.IME_OPTION_NO_MICROPHONE, "c", w.a, "o", "lc", "lj", "ml", "hd", "d");

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.content.ShapeStroke qw(com.airbnb.lottie.parser.moshi.JsonReader r17, fe.qw.qw.de r18) throws java.io.IOException {
        /*
            r0 = r17
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0011:
            boolean r13 = r17.yj()
            r14 = 100
            if (r13 == 0) goto L_0x0118
            com.airbnb.lottie.parser.moshi.JsonReader$qw r13 = qw
            int r13 = r0.ddd(r13)
            r15 = 1
            switch(r13) {
                case 0: goto L_0x010f;
                case 1: goto L_0x0106;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00f4;
                case 4: goto L_0x00e3;
                case 5: goto L_0x00d2;
                case 6: goto L_0x00c8;
                case 7: goto L_0x00bf;
                case 8: goto L_0x002a;
                default: goto L_0x0023;
            }
        L_0x0023:
            r1 = r18
            r2 = 0
            r17.mmm()
            goto L_0x0011
        L_0x002a:
            r17.de()
        L_0x002d:
            boolean r13 = r17.yj()
            if (r13 == 0) goto L_0x00a6
            r17.fe()
            r2 = 0
            r13 = 0
        L_0x0038:
            boolean r16 = r17.yj()
            if (r16 == 0) goto L_0x0059
            com.airbnb.lottie.parser.moshi.JsonReader$qw r1 = f3395ad
            int r1 = r0.ddd(r1)
            if (r1 == 0) goto L_0x0054
            if (r1 == r15) goto L_0x004f
            r17.nn()
            r17.mmm()
            goto L_0x0038
        L_0x004f:
            fe.qw.qw.switch.uk.ad r2 = fe.qw.qw.ppp.fe.rg(r17, r18)
            goto L_0x0038
        L_0x0054:
            java.lang.String r13 = r17.ppp()
            goto L_0x0038
        L_0x0059:
            r17.th()
            int r1 = r13.hashCode()
            r15 = 2
            if (r1 == r14) goto L_0x0080
            r14 = 103(0x67, float:1.44E-43)
            if (r1 == r14) goto L_0x0076
            r14 = 111(0x6f, float:1.56E-43)
            if (r1 == r14) goto L_0x006c
            goto L_0x008a
        L_0x006c:
            java.lang.String r1 = "o"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x008a
            r1 = 0
            goto L_0x008b
        L_0x0076:
            java.lang.String r1 = "g"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x008a
            r1 = 2
            goto L_0x008b
        L_0x0080:
            java.lang.String r1 = "d"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x008a
            r1 = 1
            goto L_0x008b
        L_0x008a:
            r1 = -1
        L_0x008b:
            if (r1 == 0) goto L_0x009e
            r13 = 1
            if (r1 == r13) goto L_0x0095
            if (r1 == r15) goto L_0x0095
            r1 = r18
            goto L_0x00a2
        L_0x0095:
            r1 = r18
            r1.nn(r13)
            r3.add(r2)
            goto L_0x00a2
        L_0x009e:
            r1 = r18
            r13 = 1
            r5 = r2
        L_0x00a2:
            r14 = 100
            r15 = 1
            goto L_0x002d
        L_0x00a6:
            r1 = r18
            r13 = 1
            r17.rg()
            int r2 = r3.size()
            if (r2 != r13) goto L_0x00bc
            r2 = 0
            java.lang.Object r13 = r3.get(r2)
            r3.add(r13)
            goto L_0x0011
        L_0x00bc:
            r2 = 0
            goto L_0x0011
        L_0x00bf:
            r1 = r18
            r2 = 0
            boolean r11 = r17.uk()
            goto L_0x0011
        L_0x00c8:
            r1 = r18
            r2 = 0
            double r13 = r17.pf()
            float r10 = (float) r13
            goto L_0x0011
        L_0x00d2:
            r1 = r18
            r2 = 0
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r9 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r13 = r17.m4switch()
            r14 = 1
            int r13 = r13 - r14
            r9 = r9[r13]
            goto L_0x0011
        L_0x00e3:
            r1 = r18
            r2 = 0
            r14 = 1
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r8 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r13 = r17.m4switch()
            int r13 = r13 - r14
            r8 = r8[r13]
            goto L_0x0011
        L_0x00f4:
            r1 = r18
            r2 = 0
            fe.qw.qw.switch.uk.fe r12 = fe.qw.qw.ppp.fe.uk(r17, r18)
            goto L_0x0011
        L_0x00fd:
            r1 = r18
            r2 = 0
            fe.qw.qw.switch.uk.ad r7 = fe.qw.qw.ppp.fe.rg(r17, r18)
            goto L_0x0011
        L_0x0106:
            r1 = r18
            r2 = 0
            fe.qw.qw.switch.uk.qw r6 = fe.qw.qw.ppp.fe.de(r17, r18)
            goto L_0x0011
        L_0x010f:
            r1 = r18
            r2 = 0
            java.lang.String r4 = r17.ppp()
            goto L_0x0011
        L_0x0118:
            if (r12 != 0) goto L_0x012f
            fe.qw.qw.switch.uk.fe r0 = new fe.qw.qw.switch.uk.fe
            fe.qw.qw.vvv.qw r1 = new fe.qw.qw.vvv.qw
            r2 = 100
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.<init>(r2)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r0.<init>(r1)
            r12 = r0
        L_0x012f:
            com.airbnb.lottie.model.content.ShapeStroke r13 = new com.airbnb.lottie.model.content.ShapeStroke
            r0 = r13
            r1 = r4
            r2 = r5
            r4 = r6
            r5 = r12
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.ppp.h.qw(com.airbnb.lottie.parser.moshi.JsonReader, fe.qw.qw.de):com.airbnb.lottie.model.content.ShapeStroke");
    }
}
