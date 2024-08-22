package fe.when.ad.f;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.restnet.rest.g;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.wallet.paysdk.b.j;
import com.dlife.ctaccountapi.l;
import com.dlife.ctaccountapi.q;
import com.dlife.ctaccountapi.t;
import com.dlife.ctaccountapi.v;
import com.dlife.ctaccountapi.w;
import com.dlife.ctaccountapi.x;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.base.Ascii;
import com.google.common.net.MediaType;
import com.itextpdf.text.ExceptionConverter;
import kotlin.text.Typography;

public class th {
    public static final String[] ppp = {".notdef", "space", "exclam", "quotedbl", "numbersign", "dollar", SapiOptions.KEY_CACHE_PERCENT, "ampersand", "quoteright", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "quoteleft", "a", "b", "c", "d", "e", "f", g.a, "h", com.cmic.sso.sdk.e.i.a, j.q, "k", l.a, "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", "p", q.a, "r", "s", t.a, "u", v.d, w.a, x.a, "y", "z", "braceleft", "bar", "braceright", "asciitilde", "exclamdown", "cent", "sterling", "fraction", "yen", "florin", "section", "currency", "quotesingle", "quotedblleft", "guillemotleft", "guilsinglleft", "guilsinglright", "fi", "fl", "endash", "dagger", "daggerdbl", "periodcentered", "paragraph", "bullet", "quotesinglbase", "quotedblbase", "quotedblright", "guillemotright", "ellipsis", "perthousand", "questiondown", "grave", "acute", "circumflex", "tilde", "macron", "breve", "dotaccent", "dieresis", "ring", "cedilla", "hungarumlaut", "ogonek", "caron", "emdash", "AE", "ordfeminine", "Lslash", "Oslash", "OE", "ordmasculine", "ae", "dotlessi", "lslash", "oslash", "oe", "germandbls", "onesuperior", "logicalnot", "mu", "trademark", "Eth", "onehalf", "plusminus", "Thorn", "onequarter", "divide", "brokenbar", "degree", "thorn", "threequarters", "twosuperior", "registered", "minus", "eth", "multiply", "threesuperior", "copyright", "Aacute", "Acircumflex", "Adieresis", "Agrave", "Aring", "Atilde", "Ccedilla", "Eacute", "Ecircumflex", "Edieresis", "Egrave", "Iacute", "Icircumflex", "Idieresis", "Igrave", "Ntilde", "Oacute", "Ocircumflex", "Odieresis", "Ograve", "Otilde", "Scaron", "Uacute", "Ucircumflex", "Udieresis", "Ugrave", "Yacute", "Ydieresis", "Zcaron", "aacute", "acircumflex", "adieresis", "agrave", "aring", "atilde", "ccedilla", "eacute", "ecircumflex", "edieresis", "egrave", "iacute", "icircumflex", "idieresis", "igrave", "ntilde", "oacute", "ocircumflex", "odieresis", "ograve", "otilde", "scaron", "uacute", "ucircumflex", "udieresis", "ugrave", "yacute", "ydieresis", "zcaron", "exclamsmall", "Hungarumlautsmall", "dollaroldstyle", "dollarsuperior", "ampersandsmall", "Acutesmall", "parenleftsuperior", "parenrightsuperior", "twodotenleader", "onedotenleader", "zerooldstyle", "oneoldstyle", "twooldstyle", "threeoldstyle", "fouroldstyle", "fiveoldstyle", "sixoldstyle", "sevenoldstyle", "eightoldstyle", "nineoldstyle", "commasuperior", "threequartersemdash", "periodsuperior", "questionsmall", "asuperior", "bsuperior", "centsuperior", "dsuperior", "esuperior", "isuperior", "lsuperior", "msuperior", "nsuperior", "osuperior", "rsuperior", "ssuperior", "tsuperior", "ff", "ffi", "ffl", "parenleftinferior", "parenrightinferior", "Circumflexsmall", "hyphensuperior", "Gravesmall", "Asmall", "Bsmall", "Csmall", "Dsmall", "Esmall", "Fsmall", "Gsmall", "Hsmall", "Ismall", "Jsmall", "Ksmall", "Lsmall", "Msmall", "Nsmall", "Osmall", "Psmall", "Qsmall", "Rsmall", "Ssmall", "Tsmall", "Usmall", "Vsmall", "Wsmall", "Xsmall", "Ysmall", "Zsmall", "colonmonetary", "onefitted", "rupiah", "Tildesmall", "exclamdownsmall", "centoldstyle", "Lslashsmall", "Scaronsmall", "Zcaronsmall", "Dieresissmall", "Brevesmall", "Caronsmall", "Dotaccentsmall", "Macronsmall", "figuredash", "hypheninferior", "Ogoneksmall", "Ringsmall", "Cedillasmall", "questiondownsmall", "oneeighth", "threeeighths", "fiveeighths", "seveneighths", "onethird", "twothirds", "zerosuperior", "foursuperior", "fivesuperior", "sixsuperior", "sevensuperior", "eightsuperior", "ninesuperior", "zeroinferior", "oneinferior", "twoinferior", "threeinferior", "fourinferior", "fiveinferior", "sixinferior", "seveninferior", "eightinferior", "nineinferior", "centinferior", "dollarinferior", "periodinferior", "commainferior", "Agravesmall", "Aacutesmall", "Acircumflexsmall", "Atildesmall", "Adieresissmall", "Aringsmall", "AEsmall", "Ccedillasmall", "Egravesmall", "Eacutesmall", "Ecircumflexsmall", "Edieresissmall", "Igravesmall", "Iacutesmall", "Icircumflexsmall", "Idieresissmall", "Ethsmall", "Ntildesmall", "Ogravesmall", "Oacutesmall", "Ocircumflexsmall", "Otildesmall", "Odieresissmall", "OEsmall", "Oslashsmall", "Ugravesmall", "Uacutesmall", "Ucircumflexsmall", "Udieresissmall", "Yacutesmall", "Thornsmall", "Ydieresissmall", "001.000", "001.001", "001.002", "001.003", "Black", "Bold", "Book", "Light", "Medium", "Regular", "Roman", "Semibold"};
    public static final String[] when = {"version", "Notice", "FullName", "FamilyName", "Weight", "FontBBox", "BlueValues", "OtherBlues", "FamilyBlues", "FamilyOtherBlues", "StdHW", "StdVW", "UNKNOWN_12", "UniqueID", "XUID", MediaType.CHARSET_ATTRIBUTE, "Encoding", "CharStrings", "Private", "Subrs", "defaultWidthX", "nominalWidthX", "UNKNOWN_22", "UNKNOWN_23", "UNKNOWN_24", "UNKNOWN_25", "UNKNOWN_26", "UNKNOWN_27", "UNKNOWN_28", "UNKNOWN_29", "UNKNOWN_30", "UNKNOWN_31", ExifInterface.TAG_COPYRIGHT, "isFixedPitch", "ItalicAngle", "UnderlinePosition", "UnderlineThickness", "PaintType", "CharstringType", "FontMatrix", "StrokeWidth", "BlueScale", "BlueShift", "BlueFuzz", "StemSnapH", "StemSnapV", "ForceBold", "UNKNOWN_12_15", "UNKNOWN_12_16", "LanguageGroup", "ExpansionFactor", "initialRandomSeed", "SyntheticBase", "PostScript", "BaseFontName", "BaseFontBlend", "UNKNOWN_12_24", "UNKNOWN_12_25", "UNKNOWN_12_26", "UNKNOWN_12_27", "UNKNOWN_12_28", "UNKNOWN_12_29", "ROS", "CIDFontVersion", "CIDFontRevision", "CIDFontType", "CIDCount", "UIDBase", "FDArray", "FDSelect", "FontName"};

    /* renamed from: ad  reason: collision with root package name */
    public Object[] f9781ad = new Object[48];

    /* renamed from: de  reason: collision with root package name */
    public int f9782de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public e2 f9783fe;

    /* renamed from: i  reason: collision with root package name */
    public int[] f9784i;

    /* renamed from: if  reason: not valid java name */
    public int[] f458if;

    /* renamed from: o  reason: collision with root package name */
    public int[] f9785o;

    /* renamed from: pf  reason: collision with root package name */
    public int[] f9786pf;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9787rg;

    /* renamed from: switch  reason: not valid java name */
    public de[] f459switch;

    /* renamed from: th  reason: collision with root package name */
    public int f9788th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9789uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f9790yj;

    public static final class ad extends i {

        /* renamed from: de  reason: collision with root package name */
        public final int f9791de = 5;

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + this.f9791de;
        }

        public void qw(byte[] bArr) {
            if (this.f9791de == 5) {
                int i2 = this.qw;
                bArr[i2] = Ascii.GS;
                int i3 = this.f9803ad;
                bArr[i2 + 1] = (byte) ((i3 >>> 24) & 255);
                bArr[i2 + 2] = (byte) ((i3 >>> 16) & 255);
                bArr[i2 + 3] = (byte) ((i3 >>> 8) & 255);
                bArr[i2 + 4] = (byte) ((i3 >>> 0) & 255);
            }
        }
    }

    public final class de {
        public int aaa;

        /* renamed from: ad  reason: collision with root package name */
        public String f9792ad;
        public int ddd;

        /* renamed from: de  reason: collision with root package name */
        public boolean f9793de = false;
        public int[] eee;

        /* renamed from: fe  reason: collision with root package name */
        public int f9794fe = -1;
        public int[] ggg;

        /* renamed from: i  reason: collision with root package name */
        public int f9795i = -1;

        /* renamed from: if  reason: not valid java name */
        public int[] f460if;
        public int mmm;
        public int nn = 2;

        /* renamed from: o  reason: collision with root package name */
        public int f9796o = -1;

        /* renamed from: pf  reason: collision with root package name */
        public int[] f9797pf;
        public int ppp;
        public int[] qqq;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public int f9798rg = -1;
        public int[][] rrr;

        /* renamed from: switch  reason: not valid java name */
        public int f461switch;

        /* renamed from: th  reason: collision with root package name */
        public int f9799th = -1;
        public int[] tt;

        /* renamed from: uk  reason: collision with root package name */
        public int f9800uk = -1;
        public int[] vvv;
        public int when;
        public int xxx;

        /* renamed from: yj  reason: collision with root package name */
        public int f9801yj = -1;

        public de(th thVar) {
        }
    }

    public static final class fe extends yj {
    }

    public static final class ggg extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public char f9802ad;

        public ggg(char c) {
            this.f9802ad = c;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + 1;
        }

        public void qw(byte[] bArr) {
            bArr[this.qw + 0] = (byte) ((this.f9802ad >>> 0) & 255);
        }
    }

    public static abstract class i extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public int f9803ad;

        public void fe(int i2) {
            this.f9803ad = i2;
        }
    }

    /* renamed from: fe.when.ad.f.th$if  reason: invalid class name */
    public static final class Cif extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public i f9804ad;

        /* renamed from: de  reason: collision with root package name */
        public fe f9805de;

        public Cif(i iVar, fe feVar) {
            this.f9804ad = iVar;
            this.f9805de = feVar;
        }

        public void de() {
            this.f9804ad.fe(this.qw - this.f9805de.qw);
        }
    }

    public static final class o extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public int f9806ad;

        /* renamed from: de  reason: collision with root package name */
        public int f9807de;

        /* renamed from: fe  reason: collision with root package name */
        public e2 f9808fe;

        public o(e2 e2Var, int i2, int i3) {
            this.f9806ad = i2;
            this.f9807de = i3;
            this.f9808fe = e2Var;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + this.f9807de;
        }

        public void qw(byte[] bArr) {
            try {
                this.f9808fe.when((long) this.f9806ad);
                for (int i2 = this.qw; i2 < this.qw + this.f9807de; i2++) {
                    bArr[i2] = this.f9808fe.readByte();
                }
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public static final class pf extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public String f9809ad;

        public pf(String str) {
            this.f9809ad = str;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + this.f9809ad.length();
        }

        public void qw(byte[] bArr) {
            for (int i2 = 0; i2 < this.f9809ad.length(); i2++) {
                bArr[this.qw + i2] = (byte) (this.f9809ad.charAt(i2) & 255);
            }
        }
    }

    public static final class ppp extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public int f9810ad;

        public ppp(int i2) {
            this.f9810ad = i2;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + 4;
        }

        public void qw(byte[] bArr) {
            int i2 = this.qw;
            int i3 = this.f9810ad;
            bArr[i2 + 0] = (byte) ((i3 >>> 24) & 255);
            bArr[i2 + 1] = (byte) ((i3 >>> 16) & 255);
            bArr[i2 + 2] = (byte) ((i3 >>> 8) & 255);
            bArr[i2 + 3] = (byte) ((i3 >>> 0) & 255);
        }
    }

    public static final class qw extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public final int f9811ad;

        /* renamed from: de  reason: collision with root package name */
        public int f9812de = 5;

        public qw(int i2) {
            this.f9811ad = i2;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + this.f9812de;
        }

        public void qw(byte[] bArr) {
            if (this.f9812de == 5) {
                int i2 = this.qw;
                bArr[i2] = Ascii.GS;
                int i3 = this.f9811ad;
                bArr[i2 + 1] = (byte) ((i3 >>> 24) & 255);
                bArr[i2 + 2] = (byte) ((i3 >>> 16) & 255);
                bArr[i2 + 3] = (byte) ((i3 >>> 8) & 255);
                bArr[i2 + 4] = (byte) ((i3 >>> 0) & 255);
            }
        }
    }

    public static final class rg extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public i f9813ad;

        /* renamed from: de  reason: collision with root package name */
        public fe f9814de;

        public rg(i iVar, fe feVar) {
            this.f9813ad = iVar;
            this.f9814de = feVar;
        }

        public void de() {
            this.f9813ad.fe((this.qw - this.f9814de.qw) + 1);
        }
    }

    /* renamed from: fe.when.ad.f.th$switch  reason: invalid class name */
    public static final class Cswitch extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public char f9815ad;

        public Cswitch(char c) {
            this.f9815ad = c;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + 2;
        }

        public void qw(byte[] bArr) {
            int i2 = this.qw;
            char c = this.f9815ad;
            bArr[i2 + 0] = (byte) ((c >>> 8) & 255);
            bArr[i2 + 1] = (byte) ((c >>> 0) & 255);
        }
    }

    /* renamed from: fe.when.ad.f.th$th  reason: collision with other inner class name */
    public static final class C0330th extends i {

        /* renamed from: de  reason: collision with root package name */
        public final int f9816de;

        public C0330th(int i2, int i3) {
            this.f9816de = i2;
            this.f9803ad = i3;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + this.f9816de;
        }

        public void qw(byte[] bArr) {
            int i2;
            int i3;
            int i4;
            int i5 = this.f9816de;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        i4 = 0;
                    } else if (i5 == 4) {
                        bArr[this.qw + 0] = (byte) ((this.f9803ad >>> 24) & 255);
                        i4 = 1;
                    } else {
                        return;
                    }
                    bArr[this.qw + i4] = (byte) ((this.f9803ad >>> 16) & 255);
                    i3 = i4 + 1;
                } else {
                    i3 = 0;
                }
                bArr[this.qw + i3] = (byte) ((this.f9803ad >>> 8) & 255);
                i2 = i3 + 1;
            } else {
                i2 = 0;
            }
            bArr[this.qw + i2] = (byte) ((this.f9803ad >>> 0) & 255);
        }

        public C0330th(int i2) {
            this.f9816de = i2;
        }
    }

    public static final class uk extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public i f9817ad;

        public uk(i iVar) {
            this.f9817ad = iVar;
        }

        public void de() {
            this.f9817ad.fe(this.qw);
        }
    }

    public static final class when extends yj {

        /* renamed from: ad  reason: collision with root package name */
        public int f9818ad;

        public when(int i2) {
            this.f9818ad = i2;
        }

        public void ad(int[] iArr) {
            super.ad(iArr);
            iArr[0] = iArr[0] + 3;
        }

        public void qw(byte[] bArr) {
            int i2 = this.qw;
            int i3 = this.f9818ad;
            bArr[i2 + 0] = (byte) ((i3 >>> 16) & 255);
            bArr[i2 + 1] = (byte) ((i3 >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((i3 >>> 0) & 255);
        }
    }

    public static abstract class yj {
        public int qw = -1;

        public void ad(int[] iArr) {
            this.qw = iArr[0];
        }

        public void de() {
        }

        public void qw(byte[] bArr) {
        }
    }

    public th(e2 e2Var) {
        int i2;
        int i3;
        int i4;
        this.f9783fe = e2Var;
        m1119if(0);
        ad();
        ad();
        char ad2 = ad();
        ad();
        this.f9787rg = ad2;
        int[] rg2 = rg(ad2);
        this.f9784i = rg2;
        int i5 = rg2[rg2.length - 1];
        this.f9788th = i5;
        int[] rg3 = rg(i5);
        this.f9785o = rg3;
        int i6 = rg3[rg3.length - 1];
        this.f9790yj = i6;
        int[] rg4 = rg(i6);
        this.f9786pf = rg4;
        int i7 = rg4[rg4.length - 1];
        this.f9789uk = i7;
        this.f458if = rg(i7);
        this.f459switch = new de[(this.f9784i.length - 1)];
        int i8 = 0;
        while (i8 < this.f9784i.length - 1) {
            this.f459switch[i8] = new de(this);
            m1119if(this.f9784i[i8]);
            this.f459switch[i8].qw = "";
            int i9 = this.f9784i[i8];
            while (true) {
                i4 = i8 + 1;
                if (i9 >= this.f9784i[i4]) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                de deVar = this.f459switch[i8];
                sb.append(deVar.qw);
                sb.append(ad());
                deVar.qw = sb.toString();
                i9++;
            }
            i8 = i4;
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f9785o;
            if (i10 < iArr.length - 1) {
                m1119if(iArr[i10]);
                while (true) {
                    i2 = i10 + 1;
                    if (i() >= this.f9785o[i2]) {
                        break;
                    }
                    de();
                    String str = this.qw;
                    if (str == "FullName") {
                        this.f459switch[i10].f9792ad = pf((char) ((Integer) this.f9781ad[0]).intValue());
                    } else if (str == "ROS") {
                        this.f459switch[i10].f9793de = true;
                    } else if (str == "Private") {
                        this.f459switch[i10].f9798rg = ((Integer) this.f9781ad[0]).intValue();
                        this.f459switch[i10].f9794fe = ((Integer) this.f9781ad[1]).intValue();
                    } else if (str == MediaType.CHARSET_ATTRIBUTE) {
                        this.f459switch[i10].f9800uk = ((Integer) this.f9781ad[0]).intValue();
                    } else if (str == "CharStrings") {
                        this.f459switch[i10].f9801yj = ((Integer) this.f9781ad[0]).intValue();
                        int i11 = i();
                        de[] deVarArr = this.f459switch;
                        deVarArr[i10].ggg = rg(deVarArr[i10].f9801yj);
                        m1119if(i11);
                    } else if (str == "FDArray") {
                        this.f459switch[i10].f9795i = ((Integer) this.f9781ad[0]).intValue();
                    } else if (str == "FDSelect") {
                        this.f459switch[i10].f9796o = ((Integer) this.f9781ad[0]).intValue();
                    } else if (str == "CharstringType") {
                        this.f459switch[i10].nn = ((Integer) this.f9781ad[0]).intValue();
                    }
                }
                de[] deVarArr2 = this.f459switch;
                if (deVarArr2[i10].f9794fe >= 0) {
                    m1119if(deVarArr2[i10].f9794fe);
                    while (true) {
                        int i12 = i();
                        de[] deVarArr3 = this.f459switch;
                        if (i12 >= deVarArr3[i10].f9794fe + deVarArr3[i10].f9798rg) {
                            break;
                        }
                        de();
                        if (this.qw == "Subrs") {
                            this.f459switch[i10].f9799th = ((Integer) this.f9781ad[0]).intValue() + this.f459switch[i10].f9794fe;
                        }
                    }
                }
                de[] deVarArr4 = this.f459switch;
                if (deVarArr4[i10].f9795i >= 0) {
                    int[] rg5 = rg(deVarArr4[i10].f9795i);
                    de[] deVarArr5 = this.f459switch;
                    deVarArr5[i10].f9797pf = new int[(rg5.length - 1)];
                    deVarArr5[i10].f460if = new int[(rg5.length - 1)];
                    int i13 = 0;
                    while (i13 < rg5.length - 1) {
                        m1119if(rg5[i13]);
                        while (true) {
                            i3 = i13 + 1;
                            if (i() >= rg5[i3]) {
                                break;
                            }
                            de();
                            if (this.qw == "Private") {
                                this.f459switch[i10].f460if[i13] = ((Integer) this.f9781ad[0]).intValue();
                                this.f459switch[i10].f9797pf[i13] = ((Integer) this.f9781ad[1]).intValue();
                            }
                        }
                        i13 = i3;
                    }
                }
                i10 = i2;
            } else {
                return;
            }
        }
    }

    public char ad() {
        try {
            return (char) (this.f9783fe.readByte() & 255);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void de() {
        for (int i2 = 0; i2 < this.f9782de; i2++) {
            this.f9781ad[i2] = null;
        }
        this.f9782de = 0;
        this.qw = null;
        boolean z = false;
        while (!z) {
            char ad2 = ad();
            if (ad2 == 29) {
                this.f9781ad[this.f9782de] = Integer.valueOf(th());
                this.f9782de++;
            } else if (ad2 == 28) {
                this.f9781ad[this.f9782de] = Integer.valueOf(o());
                this.f9782de++;
            } else if (ad2 >= ' ' && ad2 <= 246) {
                this.f9781ad[this.f9782de] = Integer.valueOf((byte) (ad2 - 139));
                this.f9782de++;
            } else if (ad2 >= 247 && ad2 <= 250) {
                this.f9781ad[this.f9782de] = Integer.valueOf((short) (((ad2 - 247) * 256) + ad() + 108));
                this.f9782de++;
            } else if (ad2 >= 251 && ad2 <= 254) {
                this.f9781ad[this.f9782de] = Integer.valueOf((short) ((((-(ad2 - 251)) * 256) - ad()) + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL));
                this.f9782de++;
            } else if (ad2 == 30) {
                StringBuilder sb = new StringBuilder("");
                boolean z2 = false;
                byte b = 0;
                char c = 0;
                int i3 = 0;
                while (!z2) {
                    if (b == 0) {
                        c = ad();
                        b = 2;
                    }
                    if (b == 1) {
                        i3 = c / 16;
                        b = (byte) (b - 1);
                    }
                    if (b == 2) {
                        i3 = c % 16;
                        b = (byte) (b - 1);
                    }
                    switch (i3) {
                        case 10:
                            sb.append(IStringUtil.CURRENT_PATH);
                            break;
                        case 11:
                            sb.append(ExifInterface.LONGITUDE_EAST);
                            break;
                        case 12:
                            sb.append("E-");
                            break;
                        case 14:
                            sb.append("-");
                            break;
                        case 15:
                            z2 = true;
                            break;
                        default:
                            if (i3 >= 0 && i3 <= 9) {
                                sb.append(String.valueOf(i3));
                                break;
                            } else {
                                sb.append("<NIBBLE ERROR: ");
                                sb.append(i3);
                                sb.append(Typography.greater);
                                z2 = true;
                                break;
                            }
                            break;
                    }
                }
                this.f9781ad[this.f9782de] = sb.toString();
                this.f9782de++;
            } else if (ad2 <= 21) {
                if (ad2 != 12) {
                    this.qw = when[ad2];
                } else {
                    this.qw = when[ad() + Ascii.CASE_MASK];
                }
                z = true;
            }
        }
    }

    public o fe(int i2) {
        m1119if(i2);
        char qw2 = qw();
        if (qw2 == 0) {
            return new o(this.f9783fe, i2, 2);
        }
        char ad2 = ad();
        m1119if(i2 + 2 + 1 + (qw2 * ad2));
        return new o(this.f9783fe, i2, ((qw2 + 1) * ad2) + 3 + (uk(ad2) - 1));
    }

    public int i() {
        try {
            return (int) this.f9783fe.qw();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m1119if(int i2) {
        try {
            this.f9783fe.when((long) i2);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public short o() {
        try {
            return this.f9783fe.readShort();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public String pf(char c) {
        String[] strArr = ppp;
        if (c < strArr.length) {
            return strArr[c];
        }
        if (c >= (strArr.length + this.f9786pf.length) - 1) {
            return null;
        }
        int length = c - strArr.length;
        int i2 = i();
        m1119if(this.f9786pf[length]);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = this.f9786pf[length]; i3 < this.f9786pf[length + 1]; i3++) {
            stringBuffer.append(ad());
        }
        m1119if(i2);
        return stringBuffer.toString();
    }

    public char qw() {
        try {
            return this.f9783fe.readChar();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public int[] rg(int i2) {
        m1119if(i2);
        char qw2 = qw();
        int i3 = qw2 + 1;
        int[] iArr = new int[i3];
        if (qw2 == 0) {
            iArr[0] = -1;
            return iArr;
        }
        char ad2 = ad();
        for (int i4 = 0; i4 <= qw2; i4++) {
            iArr[i4] = ((((i2 + 2) + 1) + (i3 * ad2)) - 1) + uk(ad2);
        }
        return iArr;
    }

    public int th() {
        try {
            return this.f9783fe.readInt();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public int uk(int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 256) + ad();
        }
        return i3;
    }

    public String[] yj() {
        String[] strArr = new String[this.f459switch.length];
        int i2 = 0;
        while (true) {
            de[] deVarArr = this.f459switch;
            if (i2 >= deVarArr.length) {
                return strArr;
            }
            strArr[i2] = deVarArr[i2].qw;
            i2++;
        }
    }
}
