package fe.when.ad.f;

import com.itextpdf.text.pdf.PRTokeniser;
import java.io.IOException;
import java.util.ArrayList;

public class r {
    public PRTokeniser qw;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.itextpdf.text.pdf.PRTokeniser$TokenType[] r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_DIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.OTHER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.r.qw.<clinit>():void");
        }
    }

    public r(PRTokeniser pRTokeniser) {
        this.qw = pRTokeniser;
    }

    public ArrayList<y0> ad(ArrayList<y0> arrayList) throws IOException {
        y0 rg2;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        do {
            rg2 = rg();
            if (rg2 == null) {
                break;
            }
            arrayList.add(rg2);
        } while (rg2.mmm() != 200);
        return arrayList;
    }

    public k de() throws IOException {
        k kVar = new k();
        while (true) {
            y0 rg2 = rg();
            int i2 = -rg2.mmm();
            if (i2 == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return kVar;
            }
            if (i2 != PRTokeniser.TokenType.END_DIC.ordinal()) {
                kVar.qqq(rg2);
            } else {
                throw new IOException(fe.when.ad.c.qw.ad("unexpected.gt.gt", new Object[0]));
            }
        }
    }

    public x fe() throws IOException {
        x xVar = new x();
        while (qw()) {
            if (this.qw.o() == PRTokeniser.TokenType.END_DIC) {
                return xVar;
            }
            if (this.qw.o() != PRTokeniser.TokenType.OTHER || !"def".equals(this.qw.i())) {
                if (this.qw.o() == PRTokeniser.TokenType.NAME) {
                    s0 s0Var = new s0(this.qw.i(), false);
                    y0 rg2 = rg();
                    int i2 = -rg2.mmm();
                    if (i2 == PRTokeniser.TokenType.END_DIC.ordinal()) {
                        throw new IOException(fe.when.ad.c.qw.ad("unexpected.gt.gt", new Object[0]));
                    } else if (i2 != PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                        xVar.h(s0Var, rg2);
                    } else {
                        throw new IOException(fe.when.ad.c.qw.ad("unexpected.close.bracket", new Object[0]));
                    }
                } else {
                    throw new IOException(fe.when.ad.c.qw.ad("dictionary.key.1.is.not.a.name", this.qw.i()));
                }
            }
        }
        throw new IOException(fe.when.ad.c.qw.ad("unexpected.end.of.file", new Object[0]));
    }

    public boolean qw() throws IOException {
        while (this.qw.ggg()) {
            if (this.qw.o() != PRTokeniser.TokenType.COMMENT) {
                return true;
            }
        }
        return false;
    }

    public y0 rg() throws IOException {
        if (!qw()) {
            return null;
        }
        PRTokeniser.TokenType o2 = this.qw.o();
        switch (qw.qw[o2.ordinal()]) {
            case 1:
                return fe();
            case 2:
                return de();
            case 3:
                w1 w1Var = new w1(this.qw.i(), (String) null);
                w1Var.eee(this.qw.m679if());
                return w1Var;
            case 4:
                return new s0(this.qw.i(), false);
            case 5:
                return new v0(this.qw.i());
            case 6:
                return new q0(200, this.qw.i());
            default:
                return new q0(-o2.ordinal(), this.qw.i());
        }
    }
}
