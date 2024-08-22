package fe.when.ad;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import fe.when.ad.e.ad;
import java.util.ArrayList;
import java.util.Hashtable;

public class uk implements FontProvider {

    /* renamed from: ad  reason: collision with root package name */
    public final Hashtable<String, ArrayList<String>> f9898ad = new Hashtable<>();
    public final Hashtable<String, String> qw = new Hashtable<>();

    static {
        ad.qw(uk.class);
    }

    public uk() {
        this.qw.put("Courier".toLowerCase(), "Courier");
        this.qw.put("Courier-Bold".toLowerCase(), "Courier-Bold");
        this.qw.put("Courier-Oblique".toLowerCase(), "Courier-Oblique");
        this.qw.put("Courier-BoldOblique".toLowerCase(), "Courier-BoldOblique");
        this.qw.put("Helvetica".toLowerCase(), "Helvetica");
        this.qw.put("Helvetica-Bold".toLowerCase(), "Helvetica-Bold");
        this.qw.put("Helvetica-Oblique".toLowerCase(), "Helvetica-Oblique");
        this.qw.put("Helvetica-BoldOblique".toLowerCase(), "Helvetica-BoldOblique");
        this.qw.put("Symbol".toLowerCase(), "Symbol");
        this.qw.put("Times-Roman".toLowerCase(), "Times-Roman");
        this.qw.put("Times-Bold".toLowerCase(), "Times-Bold");
        this.qw.put("Times-Italic".toLowerCase(), "Times-Italic");
        this.qw.put("Times-BoldItalic".toLowerCase(), "Times-BoldItalic");
        this.qw.put("ZapfDingbats".toLowerCase(), "ZapfDingbats");
        ArrayList arrayList = new ArrayList();
        arrayList.add("Courier");
        arrayList.add("Courier-Bold");
        arrayList.add("Courier-Oblique");
        arrayList.add("Courier-BoldOblique");
        this.f9898ad.put("Courier".toLowerCase(), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("Helvetica");
        arrayList2.add("Helvetica-Bold");
        arrayList2.add("Helvetica-Oblique");
        arrayList2.add("Helvetica-BoldOblique");
        this.f9898ad.put("Helvetica".toLowerCase(), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("Symbol");
        this.f9898ad.put("Symbol".toLowerCase(), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("Times-Roman");
        arrayList4.add("Times-Bold");
        arrayList4.add("Times-Italic");
        arrayList4.add("Times-BoldItalic");
        this.f9898ad.put("Times".toLowerCase(), arrayList4);
        this.f9898ad.put("Times-Roman".toLowerCase(), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("ZapfDingbats");
        this.f9898ad.put("ZapfDingbats".toLowerCase(), arrayList5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b4, code lost:
        return new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, r0, r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bc, code lost:
        return new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, r0, r4, r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[LOOP:0: B:13:0x002c->B:29:0x0063, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[ExcHandler: NullPointerException (unused java.lang.NullPointerException), SYNTHETIC, Splitter:B:41:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[ExcHandler: IOException (unused java.io.IOException), SYNTHETIC, Splitter:B:41:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0061 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Font ad(java.lang.String r15, java.lang.String r16, boolean r17, float r18, int r19, fe.when.ad.de r20, boolean r21) {
        /*
            r14 = this;
            r1 = r14
            r0 = r18
            r2 = r19
            r3 = r20
            if (r15 != 0) goto L_0x0011
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r4.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r2, (fe.when.ad.de) r3)
            return r4
        L_0x0011:
            java.lang.String r4 = r15.toLowerCase()
            java.util.Hashtable<java.lang.String, java.util.ArrayList<java.lang.String>> r5 = r1.f9898ad
            java.lang.Object r4 = r5.get(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 == 0) goto L_0x0074
            monitor-enter(r4)
            r5 = 0
            r6 = -1
            if (r2 != r6) goto L_0x0026
            r7 = 0
            goto L_0x0027
        L_0x0026:
            r7 = r2
        L_0x0027:
            java.util.Iterator r8 = r4.iterator()     // Catch:{ all -> 0x0071 }
            r9 = 0
        L_0x002c:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x0071 }
            r11 = 1
            if (r10 == 0) goto L_0x0065
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0071 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0071 }
            java.lang.String r10 = r9.toLowerCase()     // Catch:{ all -> 0x0071 }
            java.lang.String r12 = "bold"
            int r12 = r10.indexOf(r12)     // Catch:{ all -> 0x0071 }
            if (r12 == r6) goto L_0x0047
            r12 = 1
            goto L_0x0048
        L_0x0047:
            r12 = 0
        L_0x0048:
            java.lang.String r13 = "italic"
            int r13 = r10.indexOf(r13)     // Catch:{ all -> 0x0071 }
            if (r13 != r6) goto L_0x005b
            java.lang.String r13 = "oblique"
            int r10 = r10.indexOf(r13)     // Catch:{ all -> 0x0071 }
            if (r10 == r6) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r10 = r12
            goto L_0x005d
        L_0x005b:
            r10 = r12 | 2
        L_0x005d:
            r12 = r7 & 3
            if (r12 != r10) goto L_0x0063
            r5 = 1
            goto L_0x0067
        L_0x0063:
            r9 = r10
            goto L_0x002c
        L_0x0065:
            r10 = r9
            r9 = r15
        L_0x0067:
            if (r2 == r6) goto L_0x006d
            if (r5 == 0) goto L_0x006d
            int r5 = ~r10     // Catch:{ all -> 0x0071 }
            r2 = r2 & r5
        L_0x006d:
            monitor-exit(r4)     // Catch:{ all -> 0x0071 }
            r4 = r2
            r2 = r9
            goto L_0x0076
        L_0x0071:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0071 }
            throw r0
        L_0x0074:
            r4 = r2
            r2 = r15
        L_0x0076:
            r12 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            r5 = r2
            r6 = r16
            r7 = r17
            r8 = r21
            fe.when.ad.f.ad r12 = fe.when.ad.f.ad.th(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ DocumentException -> 0x0086, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            goto L_0x0087
        L_0x0086:
        L_0x0087:
            if (r12 != 0) goto L_0x00c4
            java.util.Hashtable<java.lang.String, java.lang.String> r5 = r1.qw     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            java.lang.Object r2 = r5.get(r2)     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            if (r5 != 0) goto L_0x00a0
            com.itextpdf.text.Font r2 = new com.itextpdf.text.Font     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            r2.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r4, (fe.when.ad.de) r3)     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            return r2
        L_0x00a0:
            r9 = 0
            r10 = 0
            r6 = r16
            r7 = r17
            r8 = r21
            fe.when.ad.f.ad r12 = fe.when.ad.f.ad.rg(r5, r6, r7, r8, r9, r10)     // Catch:{ DocumentException -> 0x00bd, IOException -> 0x00b5, NullPointerException -> 0x00ad }
            goto L_0x00c4
        L_0x00ad:
            com.itextpdf.text.Font r2 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r2.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r4, (fe.when.ad.de) r3)
            return r2
        L_0x00b5:
            com.itextpdf.text.Font r2 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r2.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r4, (fe.when.ad.de) r3)
            return r2
        L_0x00bd:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r2 = new com.itextpdf.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x00c4:
            com.itextpdf.text.Font r2 = new com.itextpdf.text.Font
            r2.<init>((fe.when.ad.f.ad) r12, (float) r0, (int) r4, (fe.when.ad.de) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.uk.ad(java.lang.String, java.lang.String, boolean, float, int, fe.when.ad.de, boolean):com.itextpdf.text.Font");
    }

    public Font qw(String str, String str2, boolean z, float f, int i2, de deVar) {
        return ad(str, str2, z, f, i2, deVar, true);
    }
}
