package fe.when.ad.f;

import androidx.core.location.GpsStatusWrapper;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.util.devices.IDevices;
import com.baidu.apollon.a;
import com.baidu.apollon.restnet.rest.g;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.wallet.paysdk.b.j;
import com.cmic.sso.sdk.e.i;
import com.dlife.ctaccountapi.l;
import com.dlife.ctaccountapi.q;
import com.dlife.ctaccountapi.t;
import com.dlife.ctaccountapi.v;
import com.dlife.ctaccountapi.w;
import com.dlife.ctaccountapi.x;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.base.Ascii;
import com.google.common.math.DoubleMath;
import fe.when.ad.c.qw;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public final class d2 {
    public short aaa;

    /* renamed from: ad  reason: collision with root package name */
    public PrintWriter f9403ad;
    public int ddd;

    /* renamed from: de  reason: collision with root package name */
    public int f9404de;
    public boolean eee;

    /* renamed from: fe  reason: collision with root package name */
    public String f9405fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public byte f9406i;

    /* renamed from: if  reason: not valid java name */
    public int f411if;
    public short mmm;
    public short nn;

    /* renamed from: o  reason: collision with root package name */
    public short f9407o;

    /* renamed from: pf  reason: collision with root package name */
    public short f9408pf;
    public short ppp;
    public short qqq;
    public e2 qw;

    /* renamed from: rg  reason: collision with root package name */
    public short f9409rg;
    public int[] rrr = {0, 0, 0, 0, 197, 198, 199, 0, BindVerifyActivity.v, 0, BindVerifyActivity.y, BindVerifyActivity.z, 207, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 33, 34, 35, 36, 37, 38, 169, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, GpsStatusWrapper.QZSS_SVID_MIN, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 0, 184, IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE, 185, 188, IChannelPay.ID_BANK_CARD_PAY, 179, 195, 189, 0, 172, 234, 0, 0, 0, 0, 96, 0, DoubleMath.MAX_FACTORIAL, 186, IDevices.EM_AARCH64, 177, 208, 196, 0, 0, 173, 250, 0, 0, 0, 0, 161, 162, IChannelPay.ID_IPAY_PAY_RECHARGEABLE_CARD, a.e, IChannelPay.ID_IPAY_PAY_SMS, 0, 167, 200, 0, 227, 171, 0, 0, 0, 197, 0, 0, 0, 0, 194, 0, 182, 180, BindVerifyActivity.w, 0, 235, 187, 0, 0, 0, 191, 0, 0, 0, 0, 0, 0, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 233, 0, 0, 0, 0, 0, 0, 251, 0, 0, 0, 0, 0, 0, 241, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 249, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: switch  reason: not valid java name */
    public int f412switch;

    /* renamed from: th  reason: collision with root package name */
    public byte f9410th;
    public String[] tt = {"W00", "W01", "W02", "W03", "macron", "breve", "dotaccent", "W07", "ring", "W09", "W0a", "W0b", "W0c", "W0d", "W0e", "W0f", "hungarumlaut", "ogonek", "caron", "W13", "W14", "W15", "W16", "W17", "W18", "W19", "W1a", "W1b", "W1c", "W1d", "W1e", "W1f", "space", "exclam", "quotedbl", "numbersign", "dollar", SapiOptions.KEY_CACHE_PERCENT, "ampersand", "quotesingle", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "grave", "a", "b", "c", "d", "e", "f", g.a, "h", i.a, j.q, "k", l.a, "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", "p", q.a, "r", "s", t.a, "u", v.d, w.a, x.a, "y", "z", "braceleft", "bar", "braceright", "asciitilde", "W7f", "euro", "W81", "quotesinglbase", "florin", "quotedblbase", "ellipsis", "dagger", "daggerdbl", "circumflex", "perthousand", "Scaron", "guilsinglleft", "OE", "W8d", "Zcaron", "W8f", "W90", "quoteleft", "quoteright", "quotedblleft", "quotedblright", "bullet", "endash", "emdash", "tilde", "trademark", "scaron", "guilsinglright", "oe", "W9d", "zcaron", "Ydieresis", "reqspace", "exclamdown", "cent", "sterling", "currency", "yen", "brokenbar", "section", "dieresis", "copyright", "ordfeminine", "guillemotleft", "logicalnot", "syllable", "registered", "macron", "degree", "plusminus", "twosuperior", "threesuperior", "acute", "mu", "paragraph", "periodcentered", "cedilla", "onesuperior", "ordmasculine", "guillemotright", "onequarter", "onehalf", "threequarters", "questiondown", "Agrave", "Aacute", "Acircumflex", "Atilde", "Adieresis", "Aring", "AE", "Ccedilla", "Egrave", "Eacute", "Ecircumflex", "Edieresis", "Igrave", "Iacute", "Icircumflex", "Idieresis", "Eth", "Ntilde", "Ograve", "Oacute", "Ocircumflex", "Otilde", "Odieresis", "multiply", "Oslash", "Ugrave", "Uacute", "Ucircumflex", "Udieresis", "Yacute", "Thorn", "germandbls", "agrave", "aacute", "acircumflex", "atilde", "adieresis", "aring", "ae", "ccedilla", "egrave", "eacute", "ecircumflex", "edieresis", "igrave", "iacute", "icircumflex", "idieresis", "eth", "ntilde", "ograve", "oacute", "ocircumflex", "otilde", "odieresis", "divide", "oslash", "ugrave", "uacute", "ucircumflex", "udieresis", "yacute", "thorn", "ydieresis"};

    /* renamed from: uk  reason: collision with root package name */
    public byte f9411uk;
    public int vvv;
    public int when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public short f9412yj;

    public d2(e2 e2Var, OutputStream outputStream) throws IOException {
        this.qw = e2Var;
        this.f9403ad = new PrintWriter(new OutputStreamWriter(outputStream, "ISO-8859-1"));
    }

    public static void qw(e2 e2Var, OutputStream outputStream) throws IOException {
        d2 d2Var = new d2(e2Var, outputStream);
        d2Var.ad();
        d2Var.th();
        d2Var.rg();
        d2Var.yj();
        d2Var.uk();
        d2Var.f9403ad.flush();
    }

    public final void ad() throws IOException {
        int i2;
        this.qw.when(0);
        this.qw.i();
        this.f9404de = this.qw.yj();
        this.f9405fe = o(60);
        this.qw.i();
        this.qw.i();
        this.qw.i();
        this.qw.i();
        this.f9409rg = this.qw.i();
        this.qw.i();
        this.qw.i();
        this.f9410th = (byte) this.qw.read();
        this.qw.read();
        this.qw.read();
        this.f9412yj = this.qw.i();
        this.f9411uk = (byte) this.qw.read();
        this.qw.i();
        this.qw.i();
        this.f9406i = (byte) this.qw.read();
        this.f9407o = this.qw.i();
        this.f9408pf = this.qw.i();
        this.f411if = this.qw.read();
        this.f412switch = this.qw.read();
        this.qw.read();
        this.qw.read();
        this.qw.i();
        this.qw.yj();
        this.when = this.qw.yj();
        this.qw.yj();
        this.qw.yj();
        this.ppp = this.qw.i();
        this.ggg = this.qw.yj();
        this.vvv = this.qw.yj();
        this.qw.yj();
        this.xxx = this.qw.yj();
        this.qw.yj();
        this.ddd = this.qw.yj();
        if (((long) this.f9404de) != this.qw.ad() || this.ppp != 30 || (i2 = this.ddd) < 75 || i2 > 512) {
            throw new IOException(qw.ad("not.a.valid.pfm.file", new Object[0]));
        }
        this.qw.when((long) (this.ggg + 14));
        this.nn = this.qw.i();
        this.mmm = this.qw.i();
        this.aaa = this.qw.i();
        this.qqq = this.qw.i();
    }

    public final void de(int i2, int i3, String str) {
        this.f9403ad.print("C ");
        fe(i2);
        this.f9403ad.print(" ; WX ");
        fe(i3);
        if (str != null) {
            this.f9403ad.print(" ; N ");
            this.f9403ad.print(str);
        }
        this.f9403ad.print(" ;\n");
    }

    public final void fe(int i2) {
        this.f9403ad.print(Ascii.CASE_MASK);
        this.f9403ad.print(i2);
    }

    public final String i() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = this.qw.read();
            if (read <= 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) read);
        }
    }

    public final String o(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        this.qw.readFully(bArr);
        int i3 = 0;
        while (i3 < i2 && bArr[i3] != 0) {
            i3++;
        }
        return new String(bArr, 0, i3, "ISO-8859-1");
    }

    public final void rg() throws IOException {
        int i2 = (this.f412switch - this.f411if) + 1;
        int[] iArr = new int[i2];
        this.qw.when((long) this.vvv);
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = this.qw.m1078switch();
        }
        int[] iArr2 = new int[256];
        if (this.f9411uk == 0) {
            for (int i4 = this.f411if; i4 <= this.f412switch; i4++) {
                int[] iArr3 = this.rrr;
                if (iArr3[i4] != 0) {
                    iArr2[iArr3[i4]] = i4;
                }
            }
        }
        this.f9403ad.print("StartCharMetrics");
        fe(i2);
        this.f9403ad.print(10);
        if (this.f9411uk != 0) {
            for (int i5 = this.f411if; i5 <= this.f412switch; i5++) {
                int i6 = this.f411if;
                if (iArr[i5 - i6] != 0) {
                    de(i5, iArr[i5 - i6], (String) null);
                }
            }
        } else {
            for (int i7 = 0; i7 < 256; i7++) {
                int i8 = iArr2[i7];
                if (i8 != 0) {
                    de(i7, iArr[i8 - this.f411if], this.tt[i8]);
                    iArr[i8 - this.f411if] = 0;
                }
            }
            for (int i9 = this.f411if; i9 <= this.f412switch; i9++) {
                int i10 = this.f411if;
                if (iArr[i9 - i10] != 0) {
                    de(-1, iArr[i9 - i10], this.tt[i9]);
                }
            }
        }
        this.f9403ad.print("EndCharMetrics\n");
    }

    public final void th() throws IOException {
        this.f9403ad.print("StartFontMetrics 2.0\n");
        if (this.f9405fe.length() > 0) {
            PrintWriter printWriter = this.f9403ad;
            printWriter.print("Comment " + this.f9405fe + 10);
        }
        this.f9403ad.print("FontName ");
        this.qw.when((long) this.ddd);
        String i2 = i();
        this.f9403ad.print(i2);
        this.f9403ad.print("\nEncodingScheme ");
        if (this.f9411uk != 0) {
            this.f9403ad.print("FontSpecific\n");
        } else {
            this.f9403ad.print("AdobeStandardEncoding\n");
        }
        PrintWriter printWriter2 = this.f9403ad;
        printWriter2.print("FullName " + i2.replace('-', Ascii.CASE_MASK));
        int i3 = this.when;
        if (i3 != 0) {
            this.qw.when((long) i3);
            PrintWriter printWriter3 = this.f9403ad;
            printWriter3.print("\nFamilyName " + i());
        }
        this.f9403ad.print("\nWeight ");
        if (this.f9412yj > 475 || i2.toLowerCase().indexOf("bold") >= 0) {
            this.f9403ad.print("Bold");
        } else {
            short s = this.f9412yj;
            if ((s < 325 && s != 0) || i2.toLowerCase().indexOf("light") >= 0) {
                this.f9403ad.print("Light");
            } else if (i2.toLowerCase().indexOf("black") >= 0) {
                this.f9403ad.print("Black");
            } else {
                this.f9403ad.print("Medium");
            }
        }
        this.f9403ad.print("\nItalicAngle ");
        if (this.f9410th != 0 || i2.toLowerCase().indexOf("italic") >= 0) {
            this.f9403ad.print("-12.00");
        } else {
            this.f9403ad.print("0");
        }
        this.f9403ad.print("\nIsFixedPitch ");
        if ((this.f9406i & 1) == 0 || this.f9407o == this.f9408pf) {
            this.f9403ad.print("true");
            this.eee = true;
        } else {
            this.f9403ad.print("false");
            this.eee = false;
        }
        this.f9403ad.print("\nFontBBox");
        if (this.eee) {
            fe(-20);
        } else {
            fe(-100);
        }
        fe(-(this.qqq + 5));
        fe(this.f9408pf + 10);
        fe(this.f9409rg + 5);
        this.f9403ad.print("\nCapHeight");
        fe(this.nn);
        this.f9403ad.print("\nXHeight");
        fe(this.mmm);
        this.f9403ad.print("\nDescender");
        fe(-this.qqq);
        this.f9403ad.print("\nAscender");
        fe(this.aaa);
        this.f9403ad.print(10);
    }

    public final void uk() {
        this.f9403ad.print("EndFontMetrics\n");
    }

    public final void yj() throws IOException {
        int i2 = this.xxx;
        if (i2 != 0) {
            this.qw.when((long) i2);
            int i3 = this.qw.m1078switch() * 3;
            int[] iArr = new int[i3];
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                int i6 = i4 + 1;
                iArr[i4] = this.qw.read();
                int i7 = i6 + 1;
                iArr[i6] = this.qw.read();
                int i8 = i7 + 1;
                int i9 = this.qw.i();
                iArr[i7] = i9;
                if (i9 != 0) {
                    i5++;
                }
                i4 = i8;
            }
            if (i5 != 0) {
                this.f9403ad.print("StartKernData\nStartKernPairs");
                fe(i5);
                this.f9403ad.print(10);
                for (int i10 = 0; i10 < i3; i10 += 3) {
                    int i11 = i10 + 2;
                    if (iArr[i11] != 0) {
                        this.f9403ad.print("KPX ");
                        this.f9403ad.print(this.tt[iArr[i10]]);
                        this.f9403ad.print(Ascii.CASE_MASK);
                        this.f9403ad.print(this.tt[iArr[i10 + 1]]);
                        fe(iArr[i11]);
                        this.f9403ad.print(10);
                    }
                }
                this.f9403ad.print("EndKernPairs\nEndKernData\n");
            }
        }
    }
}
