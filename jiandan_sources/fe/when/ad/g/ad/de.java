package fe.when.ad.g.ad;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandlerComment;
import fe.when.ad.g.ad.fe.ad;
import fe.when.ad.g.ad.fe.qw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public int f9862ad = 0;
    public String ddd = null;

    /* renamed from: de  reason: collision with root package name */
    public int f9863de = -1;

    /* renamed from: fe  reason: collision with root package name */
    public int f9864fe = 1;
    public int ggg = 0;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f9865i;

    /* renamed from: if  reason: not valid java name */
    public String f471if = null;
    public NewLineHandler nn;

    /* renamed from: o  reason: collision with root package name */
    public final StringBuffer f9866o = new StringBuffer();

    /* renamed from: pf  reason: collision with root package name */
    public final StringBuffer f9867pf = new StringBuffer();
    public final SimpleXMLDocHandlerComment ppp;
    public final Stack<Integer> qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9868rg = 0;

    /* renamed from: switch  reason: not valid java name */
    public HashMap<String, String> f472switch = null;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9869th = false;

    /* renamed from: uk  reason: collision with root package name */
    public int f9870uk;
    public int vvv = 34;
    public final SimpleXMLDocHandler when;
    public String xxx = null;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9871yj = false;

    public de(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, boolean z) {
        this.when = simpleXMLDocHandler;
        this.ppp = simpleXMLDocHandlerComment;
        this.f9865i = z;
        if (z) {
            this.nn = new qw();
        } else {
            this.nn = new ad();
        }
        this.qw = new Stack<>();
        this.f9870uk = z ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String de(java.lang.String r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "encoding"
            int r1 = r5.indexOf(r1)
            if (r1 >= 0) goto L_0x000d
            return r0
        L_0x000d:
            r2 = 34
            int r3 = r5.indexOf(r2, r1)
            r4 = 39
            int r1 = r5.indexOf(r4, r1)
            if (r3 != r1) goto L_0x001c
            return r0
        L_0x001c:
            if (r3 >= 0) goto L_0x0020
            if (r1 > 0) goto L_0x0024
        L_0x0020:
            if (r1 <= 0) goto L_0x0032
            if (r1 >= r3) goto L_0x0032
        L_0x0024:
            int r1 = r1 + 1
            int r2 = r5.indexOf(r4, r1)
            if (r2 >= 0) goto L_0x002d
            return r0
        L_0x002d:
            java.lang.String r5 = r5.substring(r1, r2)
            return r5
        L_0x0032:
            if (r1 >= 0) goto L_0x0036
            if (r3 > 0) goto L_0x003a
        L_0x0036:
            if (r3 <= 0) goto L_0x0048
            if (r3 >= r1) goto L_0x0048
        L_0x003a:
            int r3 = r3 + 1
            int r1 = r5.indexOf(r2, r3)
            if (r1 >= 0) goto L_0x0043
            return r0
        L_0x0043:
            java.lang.String r5 = r5.substring(r3, r1)
            return r5
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.g.ad.de.de(java.lang.String):java.lang.String");
    }

    public static void th(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, Reader reader, boolean z) throws IOException {
        new de(simpleXMLDocHandler, simpleXMLDocHandlerComment, z).fe(reader);
    }

    public static void uk(SimpleXMLDocHandler simpleXMLDocHandler, Reader reader) throws IOException {
        th(simpleXMLDocHandler, (SimpleXMLDocHandlerComment) null, reader, false);
    }

    public static void yj(SimpleXMLDocHandler simpleXMLDocHandler, InputStream inputStream) throws IOException {
        String de2;
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) == 4) {
            String ad2 = fe.when.ad.g.qw.ad(bArr);
            String str = null;
            if (ad2.equals("UTF-8")) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = inputStream.read();
                    if (read == -1 || read == 62) {
                        str = stringBuffer.toString();
                    } else {
                        stringBuffer.append((char) read);
                    }
                }
                str = stringBuffer.toString();
            } else if (ad2.equals("CP037")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read2 = inputStream.read();
                    if (read2 == -1 || read2 == 110) {
                        str = new String(byteArrayOutputStream.toByteArray(), "CP037");
                    } else {
                        byteArrayOutputStream.write(read2);
                    }
                }
                str = new String(byteArrayOutputStream.toByteArray(), "CP037");
            }
            if (!(str == null || (de2 = de(str)) == null)) {
                ad2 = de2;
            }
            uk(simpleXMLDocHandler, new InputStreamReader(inputStream, ad.qw(ad2)));
            return;
        }
        throw new IOException(fe.when.ad.c.qw.ad("insufficient.length", new Object[0]));
    }

    public final void ad() {
        int i2 = this.f9870uk;
        if (i2 != 1) {
            if (i2 != 14) {
                if (i2 != 7) {
                    if (i2 == 8) {
                        SimpleXMLDocHandlerComment simpleXMLDocHandlerComment = this.ppp;
                        if (simpleXMLDocHandlerComment != null) {
                            simpleXMLDocHandlerComment.qw(this.f9866o.toString());
                        }
                    } else if (i2 != 11) {
                        if (i2 == 12) {
                            String stringBuffer = this.f9866o.toString();
                            this.xxx = stringBuffer;
                            if (this.f9865i) {
                                this.xxx = stringBuffer.toLowerCase();
                            }
                        }
                    }
                    this.f9866o.setLength(0);
                }
            }
            String stringBuffer2 = this.f9866o.toString();
            this.ddd = stringBuffer2;
            this.f472switch.put(this.xxx, stringBuffer2);
            this.f9866o.setLength(0);
        }
        if (this.f9866o.length() > 0) {
            this.when.de(this.f9866o.toString());
        }
        this.f9866o.setLength(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0016, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fe(java.io.Reader r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r1 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x000b
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0011
        L_0x000b:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r2.<init>(r1)
            r1 = r2
        L_0x0011:
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r2 = r0.when
            r2.qw()
        L_0x0016:
            int r2 = r0.f9863de
            r3 = -1
            if (r2 != r3) goto L_0x0022
            int r2 = r1.read()
            r0.f9862ad = r2
            goto L_0x0026
        L_0x0022:
            r0.f9862ad = r2
            r0.f9863de = r3
        L_0x0026:
            int r2 = r0.f9862ad
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 != r3) goto L_0x004c
            boolean r1 = r0.f9865i
            if (r1 == 0) goto L_0x0040
            if (r1 == 0) goto L_0x003a
            int r1 = r0.f9870uk
            if (r1 != r5) goto L_0x003a
            r16.ad()
        L_0x003a:
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r1 = r0.when
            r1.ad()
            return
        L_0x0040:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r2 = "missing.end.tag"
            java.lang.String r1 = fe.when.ad.c.qw.ad(r2, r1)
            r0.m1129if(r1)
            throw r4
        L_0x004c:
            r3 = 10
            if (r2 != r3) goto L_0x0057
            boolean r2 = r0.f9869th
            if (r2 == 0) goto L_0x0057
            r0.f9869th = r6
            goto L_0x0016
        L_0x0057:
            boolean r2 = r0.f9869th
            r7 = 13
            if (r2 == 0) goto L_0x0060
            r0.f9869th = r6
            goto L_0x007f
        L_0x0060:
            int r2 = r0.f9862ad
            if (r2 != r3) goto L_0x006c
            int r2 = r0.f9864fe
            int r2 = r2 + r5
            r0.f9864fe = r2
            r0.f9868rg = r6
            goto L_0x007f
        L_0x006c:
            if (r2 != r7) goto L_0x007a
            r0.f9869th = r5
            r0.f9862ad = r3
            int r2 = r0.f9864fe
            int r2 = r2 + r5
            r0.f9864fe = r2
            r0.f9868rg = r6
            goto L_0x007f
        L_0x007a:
            int r2 = r0.f9868rg
            int r2 = r2 + r5
            r0.f9868rg = r2
        L_0x007f:
            int r2 = r0.f9870uk
            java.lang.String r8 = "error.in.attribute.processing"
            r9 = 12
            r12 = 14
            r13 = 61
            r15 = 4
            r14 = 6
            r10 = 47
            r3 = 32
            r11 = 62
            switch(r2) {
                case 0: goto L_0x04a9;
                case 1: goto L_0x0436;
                case 2: goto L_0x0412;
                case 3: goto L_0x0389;
                case 4: goto L_0x035c;
                case 5: goto L_0x0330;
                case 6: goto L_0x02fa;
                case 7: goto L_0x02c8;
                case 8: goto L_0x0296;
                case 9: goto L_0x0286;
                case 10: goto L_0x01ff;
                case 11: goto L_0x017e;
                case 12: goto L_0x0140;
                case 13: goto L_0x00e8;
                case 14: goto L_0x0095;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x0016
        L_0x0095:
            int r2 = r0.f9862ad
            r7 = 34
            r9 = 11
            if (r2 == r7) goto L_0x00e0
            r7 = 39
            if (r2 != r7) goto L_0x00a2
            goto L_0x00e0
        L_0x00a2:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x00ab
            goto L_0x0016
        L_0x00ab:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x00c4
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x00c4
            r16.ad()
            r0.i(r5)
            r16.rg()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x00c4:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x00d6
            java.lang.StringBuffer r2 = r0.f9866o
            int r4 = r0.f9862ad
            char r4 = (char) r4
            r2.append(r4)
            r0.vvv = r3
            r0.f9870uk = r9
            goto L_0x0016
        L_0x00d6:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r1 = fe.when.ad.c.qw.ad(r8, r1)
            r0.m1129if(r1)
            throw r4
        L_0x00e0:
            int r2 = r0.f9862ad
            r0.vvv = r2
            r0.f9870uk = r9
            goto L_0x0016
        L_0x00e8:
            int r2 = r0.f9862ad
            if (r2 != r13) goto L_0x00f0
            r0.f9870uk = r12
            goto L_0x0016
        L_0x00f0:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x00f9
            goto L_0x0016
        L_0x00f9:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x0114
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x0114
            java.lang.StringBuffer r2 = r0.f9866o
            r2.setLength(r6)
            r0.i(r5)
            r16.rg()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x0114:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x0123
            int r2 = r0.f9862ad
            if (r2 != r10) goto L_0x0123
            r16.ad()
            r0.f9870uk = r14
            goto L_0x0016
        L_0x0123:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x0136
            r16.ad()
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            r0.f9870uk = r9
            goto L_0x0016
        L_0x0136:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r1 = fe.when.ad.c.qw.ad(r8, r1)
            r0.m1129if(r1)
            throw r4
        L_0x0140:
            int r2 = r0.f9862ad
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x0150
            r16.ad()
            r0.f9870uk = r7
            goto L_0x0016
        L_0x0150:
            int r2 = r0.f9862ad
            if (r2 != r13) goto L_0x015b
            r16.ad()
            r0.f9870uk = r12
            goto L_0x0016
        L_0x015b:
            boolean r3 = r0.f9865i
            if (r3 == 0) goto L_0x0174
            if (r2 != r11) goto L_0x0174
            java.lang.StringBuffer r2 = r0.f9866o
            r2.setLength(r6)
            r0.i(r5)
            r16.rg()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x0174:
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x017e:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x019b
            int r2 = r0.vvv
            if (r2 != r3) goto L_0x019b
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x019b
            r16.ad()
            r0.i(r5)
            r16.rg()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x019b:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x01b3
            int r2 = r0.vvv
            if (r2 != r3) goto L_0x01b3
            int r2 = r0.f9862ad
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x01b3
            r16.ad()
            r0.f9870uk = r15
            goto L_0x0016
        L_0x01b3:
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x01c5
            int r2 = r0.vvv
            if (r2 != r3) goto L_0x01c5
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x01c5:
            int r2 = r0.f9862ad
            int r4 = r0.vvv
            if (r2 != r4) goto L_0x01d2
            r16.ad()
            r0.f9870uk = r15
            goto L_0x0016
        L_0x01d2:
            java.lang.String r4 = " \r\n\t"
            int r2 = r4.indexOf(r2)
            if (r2 < 0) goto L_0x01e1
            java.lang.StringBuffer r2 = r0.f9866o
            r2.append(r3)
            goto L_0x0016
        L_0x01e1:
            int r2 = r0.f9862ad
            r3 = 38
            if (r2 != r3) goto L_0x01f7
            int r2 = r0.f9870uk
            r0.pf(r2)
            r2 = 10
            r0.f9870uk = r2
            java.lang.StringBuffer r2 = r0.f9867pf
            r2.setLength(r6)
            goto L_0x0016
        L_0x01f7:
            java.lang.StringBuffer r3 = r0.f9866o
            char r2 = (char) r2
            r3.append(r2)
            goto L_0x0016
        L_0x01ff:
            int r2 = r0.f9862ad
            r3 = 59
            if (r2 != r3) goto L_0x0232
            int r2 = r16.o()
            r0.f9870uk = r2
            java.lang.StringBuffer r2 = r0.f9867pf
            java.lang.String r2 = r2.toString()
            java.lang.StringBuffer r4 = r0.f9867pf
            r4.setLength(r6)
            char r4 = fe.when.ad.g.ad.qw.qw(r2)
            if (r4 != 0) goto L_0x022b
            java.lang.StringBuffer r4 = r0.f9866o
            r5 = 38
            r4.append(r5)
            r4.append(r2)
            r4.append(r3)
            goto L_0x0016
        L_0x022b:
            java.lang.StringBuffer r2 = r0.f9866o
            r2.append(r4)
            goto L_0x0016
        L_0x0232:
            r3 = 35
            if (r2 == r3) goto L_0x0252
            r3 = 48
            if (r2 < r3) goto L_0x023e
            r3 = 57
            if (r2 <= r3) goto L_0x0252
        L_0x023e:
            int r2 = r0.f9862ad
            r3 = 97
            if (r2 < r3) goto L_0x0248
            r3 = 122(0x7a, float:1.71E-43)
            if (r2 <= r3) goto L_0x0252
        L_0x0248:
            int r2 = r0.f9862ad
            r3 = 65
            if (r2 < r3) goto L_0x025b
            r3 = 90
            if (r2 > r3) goto L_0x025b
        L_0x0252:
            java.lang.StringBuffer r2 = r0.f9867pf
            int r2 = r2.length()
            r3 = 7
            if (r2 < r3) goto L_0x027c
        L_0x025b:
            int r2 = r16.o()
            r0.f9870uk = r2
            int r2 = r0.f9862ad
            r0.f9863de = r2
            java.lang.StringBuffer r2 = r0.f9866o
            r3 = 38
            r2.append(r3)
            java.lang.StringBuffer r3 = r0.f9867pf
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.StringBuffer r2 = r0.f9867pf
            r2.setLength(r6)
            goto L_0x0016
        L_0x027c:
            java.lang.StringBuffer r2 = r0.f9867pf
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x0286:
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x0016
            int r2 = r16.o()
            r0.f9870uk = r2
            if (r2 != r5) goto L_0x0016
            r0.f9870uk = r6
            goto L_0x0016
        L_0x0296:
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x02be
            java.lang.StringBuffer r2 = r0.f9866o
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "--"
            boolean r2 = r2.endsWith(r3)
            if (r2 == 0) goto L_0x02be
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r2.length()
            r4 = 2
            int r3 = r3 - r4
            r2.setLength(r3)
            r16.ad()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x02be:
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x02c8:
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x02f0
            java.lang.StringBuffer r2 = r0.f9866o
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "]]"
            boolean r2 = r2.endsWith(r3)
            if (r2 == 0) goto L_0x02f0
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r2.length()
            r4 = 2
            int r3 = r3 - r4
            r2.setLength(r3)
            r16.ad()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x02f0:
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x02fa:
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x0320
            r16.qw()
            r0.i(r5)
            r0.i(r6)
            r16.rg()
            boolean r2 = r0.f9865i
            if (r2 != 0) goto L_0x0318
            int r2 = r0.ggg
            if (r2 != 0) goto L_0x0318
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r1 = r0.when
            r1.ad()
            return
        L_0x0318:
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x0320:
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = r0.f471if
            r1[r6] = r2
            java.lang.String r2 = "expected.gt.for.tag.lt.1.gt"
            java.lang.String r1 = fe.when.ad.c.qw.ad(r2, r1)
            r0.m1129if(r1)
            throw r4
        L_0x0330:
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x034b
            r16.qw()
            r0.i(r6)
            boolean r2 = r0.f9865i
            if (r2 != 0) goto L_0x0343
            int r2 = r0.ggg
            if (r2 != 0) goto L_0x0343
            return
        L_0x0343:
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x034b:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 != 0) goto L_0x0016
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x035c:
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x036e
            r0.i(r5)
            r16.rg()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x036e:
            if (r2 != r10) goto L_0x0374
            r0.f9870uk = r14
            goto L_0x0016
        L_0x0374:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x037d
            goto L_0x0016
        L_0x037d:
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            r0.f9870uk = r9
            goto L_0x0016
        L_0x0389:
            int r2 = r0.f9862ad
            if (r2 != r11) goto L_0x039e
            r16.qw()
            r0.i(r5)
            r16.rg()
            int r2 = r16.o()
            r0.f9870uk = r2
            goto L_0x0016
        L_0x039e:
            if (r2 != r10) goto L_0x03a4
            r0.f9870uk = r14
            goto L_0x0016
        L_0x03a4:
            r3 = 45
            if (r2 != r3) goto L_0x03bf
            java.lang.StringBuffer r2 = r0.f9866o
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "!-"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03bf
            r16.ad()
            r2 = 8
            r0.f9870uk = r2
            goto L_0x0016
        L_0x03bf:
            int r2 = r0.f9862ad
            r3 = 91
            if (r2 != r3) goto L_0x03db
            java.lang.StringBuffer r2 = r0.f9866o
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "![CDATA"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03db
            r16.ad()
            r2 = 7
            r0.f9870uk = r2
            goto L_0x0016
        L_0x03db:
            int r2 = r0.f9862ad
            r3 = 69
            if (r2 != r3) goto L_0x03f8
            java.lang.StringBuffer r2 = r0.f9866o
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "!DOCTYP"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03f8
            r16.ad()
            r2 = 9
            r0.f9870uk = r2
            goto L_0x0016
        L_0x03f8:
            int r2 = r0.f9862ad
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x0408
            r16.qw()
            r0.f9870uk = r15
            goto L_0x0016
        L_0x0408:
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x0412:
            r16.rg()
            int r2 = r0.f9862ad
            if (r2 != r10) goto L_0x041e
            r2 = 5
            r0.f9870uk = r2
            goto L_0x0016
        L_0x041e:
            r3 = 63
            if (r2 != r3) goto L_0x042b
            r16.o()
            r2 = 9
            r0.f9870uk = r2
            goto L_0x0016
        L_0x042b:
            java.lang.StringBuffer r3 = r0.f9866o
            char r2 = (char) r2
            r3.append(r2)
            r2 = 3
            r0.f9870uk = r2
            goto L_0x0016
        L_0x0436:
            int r4 = r0.f9862ad
            r7 = 60
            if (r4 != r7) goto L_0x0449
            r16.ad()
            int r2 = r0.f9870uk
            r0.pf(r2)
            r2 = 2
            r0.f9870uk = r2
            goto L_0x0016
        L_0x0449:
            r7 = 38
            if (r4 != r7) goto L_0x045d
            r0.pf(r2)
            java.lang.StringBuffer r2 = r0.f9867pf
            r2.setLength(r6)
            r2 = 10
            r0.f9870uk = r2
            r0.f9871yj = r5
            goto L_0x0016
        L_0x045d:
            if (r4 != r3) goto L_0x0480
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x0470
            boolean r2 = r0.f9871yj
            if (r2 == 0) goto L_0x0470
            java.lang.StringBuffer r2 = r0.f9866o
            r2.append(r3)
            r0.f9871yj = r6
            goto L_0x0016
        L_0x0470:
            boolean r2 = r0.f9871yj
            if (r2 == 0) goto L_0x047c
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
        L_0x047c:
            r0.f9871yj = r6
            goto L_0x0016
        L_0x0480:
            char r2 = (char) r4
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x049d
            boolean r2 = r0.f9865i
            if (r2 == 0) goto L_0x048d
            goto L_0x0016
        L_0x048d:
            boolean r2 = r0.f9871yj
            if (r2 == 0) goto L_0x0499
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
        L_0x0499:
            r0.f9871yj = r6
            goto L_0x0016
        L_0x049d:
            java.lang.StringBuffer r2 = r0.f9866o
            int r3 = r0.f9862ad
            char r3 = (char) r3
            r2.append(r3)
            r0.f9871yj = r5
            goto L_0x0016
        L_0x04a9:
            int r2 = r0.f9862ad
            r3 = 60
            if (r2 != r3) goto L_0x0016
            r0.pf(r5)
            r2 = 2
            r0.f9870uk = r2
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.g.ad.de.fe(java.io.Reader):void");
    }

    public final void i(boolean z) {
        if (z) {
            this.ggg++;
            this.when.rg(this.f471if, this.f472switch);
            return;
        }
        if (this.nn.qw(this.f471if)) {
            this.f9871yj = false;
        }
        this.ggg--;
        this.when.fe(this.f471if);
    }

    /* renamed from: if  reason: not valid java name */
    public final void m1129if(String str) throws IOException {
        throw new IOException(fe.when.ad.c.qw.ad("1.near.line.2.column.3", str, String.valueOf(this.f9864fe), String.valueOf(this.f9868rg)));
    }

    public final int o() {
        if (!this.qw.empty()) {
            return this.qw.pop().intValue();
        }
        return 0;
    }

    public final void pf(int i2) {
        this.qw.push(Integer.valueOf(i2));
    }

    public final void qw() {
        if (this.f471if == null) {
            this.f471if = this.f9866o.toString();
        }
        if (this.f9865i) {
            this.f471if = this.f471if.toLowerCase();
        }
        this.f9866o.setLength(0);
    }

    public final void rg() {
        this.f471if = null;
        this.f472switch = new HashMap<>();
    }
}
