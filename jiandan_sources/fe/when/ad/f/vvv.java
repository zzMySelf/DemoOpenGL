package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.fonts.otf.Language;
import com.itextpdf.text.pdf.languages.GlyphRepositioner;
import fe.when.ad.a;
import fe.when.ad.f.t2.ad;
import fe.when.ad.f.t2.de;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class vvv {

    /* renamed from: ad  reason: collision with root package name */
    public s0 f9822ad;

    /* renamed from: de  reason: collision with root package name */
    public ad f9823de;

    /* renamed from: fe  reason: collision with root package name */
    public k2 f9824fe;

    /* renamed from: i  reason: collision with root package name */
    public int f9825i;

    /* renamed from: o  reason: collision with root package name */
    public boolean f9826o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f9827pf = true;
    public l0 qw;

    /* renamed from: rg  reason: collision with root package name */
    public uk f9828rg;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f9829th;

    /* renamed from: uk  reason: collision with root package name */
    public aaa f9830uk;

    /* renamed from: yj  reason: collision with root package name */
    public HashMap<Integer, int[]> f9831yj;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        static {
            int[] iArr = new int[Language.values().length];
            qw = iArr;
            try {
                iArr[Language.BENGALI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public vvv(s0 s0Var, l0 l0Var, ad adVar) {
        this.f9822ad = s0Var;
        this.qw = l0Var;
        this.f9823de = adVar;
        int when = adVar.when();
        this.f9825i = when;
        if (when == 0 || when == 1) {
            this.f9829th = new byte[256];
        } else if (when == 2) {
            this.f9830uk = new aaa();
            this.f9828rg = (uk) adVar;
        } else if (when == 3) {
            this.f9831yj = new HashMap<>();
            this.f9824fe = (k2) adVar;
            this.f9826o = adVar.b();
        }
    }

    public byte[] ad(String str) {
        int i2;
        int i3;
        int i4;
        int i5 = this.f9825i;
        if (i5 == 0 || i5 == 1) {
            byte[] ad2 = this.f9823de.ad(str);
            for (byte b : ad2) {
                this.f9829th[b & 255] = 1;
            }
            return ad2;
        } else if (i5 == 2) {
            int length = str.length();
            if (this.f9828rg.r()) {
                for (int i6 = 0; i6 < length; i6++) {
                    this.f9830uk.rg(str.charAt(i6), 0);
                }
            } else {
                int i7 = 0;
                while (i7 < length) {
                    if (a.yj(str, i7)) {
                        i2 = a.de(str, i7);
                        i7++;
                    } else {
                        i2 = str.charAt(i7);
                    }
                    this.f9830uk.rg(this.f9828rg.o(i2), 0);
                    i7++;
                }
            }
            return this.f9828rg.ad(str);
        } else if (i5 == 3) {
            try {
                int length2 = str.length();
                char[] cArr = new char[length2];
                if (this.f9826o) {
                    byte[] de2 = a0.de(str, "symboltt");
                    int length3 = de2.length;
                    i3 = 0;
                    for (int i8 = 0; i8 < length3; i8++) {
                        int[] s = this.f9824fe.s(de2[i8] & 255);
                        if (s != null) {
                            this.f9831yj.put(Integer.valueOf(s[0]), new int[]{s[0], s[1], this.f9824fe.ddd(de2[i8] & 255)});
                            cArr[i3] = (char) s[0];
                            i3++;
                        }
                    }
                } else if (qw()) {
                    return de(str);
                } else {
                    int i9 = 0;
                    i3 = 0;
                    while (i9 < length2) {
                        if (a.yj(str, i9)) {
                            i4 = a.de(str, i9);
                            i9++;
                        } else {
                            i4 = str.charAt(i9);
                        }
                        int[] s2 = this.f9824fe.s(i4);
                        if (s2 != null) {
                            int i10 = s2[0];
                            Integer valueOf = Integer.valueOf(i10);
                            if (!this.f9831yj.containsKey(valueOf)) {
                                this.f9831yj.put(valueOf, new int[]{i10, s2[1], i4});
                            }
                            cArr[i3] = (char) i10;
                            i3++;
                        }
                        i9++;
                    }
                }
                return new String(cArr, 0, i3).getBytes("UnicodeBigUnmarked");
            } catch (UnsupportedEncodingException e) {
                throw new ExceptionConverter(e);
            }
        } else if (i5 == 4) {
            return this.f9823de.ad(str);
        } else {
            if (i5 != 5) {
                return null;
            }
            return this.f9823de.ad(str);
        }
    }

    public final byte[] de(String str) throws UnsupportedEncodingException {
        if (qw()) {
            Map<String, xxx> L = this.f9824fe.L();
            TreeSet treeSet = new TreeSet(new de());
            treeSet.addAll(L.keySet());
            String[] ad2 = new qw((String[]) treeSet.toArray(new String[0])).ad(str);
            ArrayList arrayList = new ArrayList(50);
            for (String str2 : ad2) {
                xxx xxx = L.get(str2);
                if (xxx != null) {
                    arrayList.add(xxx);
                } else {
                    for (char c : str2.toCharArray()) {
                        int[] s = this.f9824fe.s(c);
                        arrayList.add(new xxx(s[0], s[1], String.valueOf(c)));
                    }
                }
            }
            GlyphRepositioner th2 = th();
            if (th2 != null) {
                th2.qw(arrayList);
            }
            char[] cArr = new char[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                xxx xxx2 = (xxx) arrayList.get(i2);
                int i3 = xxx2.qw;
                cArr[i2] = (char) i3;
                Integer valueOf = Integer.valueOf(i3);
                if (!this.f9831yj.containsKey(valueOf)) {
                    this.f9831yj.put(valueOf, new int[]{xxx2.qw, xxx2.f9840ad, xxx2.f9841de.charAt(0)});
                }
            }
            return new String(cArr).getBytes("UnicodeBigUnmarked");
        }
        throw new IllegalArgumentException("Make sure the font type if TTF Unicode and a valid GlyphSubstitutionTable exists!");
    }

    public ad fe() {
        return this.f9823de;
    }

    public void i(c2 c2Var) {
        try {
            int i2 = this.f9825i;
            if (i2 == 0 || i2 == 1) {
                int i3 = 0;
                while (true) {
                    if (i3 >= 256) {
                        break;
                    } else if (this.f9829th[i3] != 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
                int i4 = 255;
                int i5 = 255;
                while (true) {
                    if (i5 < i3) {
                        break;
                    } else if (this.f9829th[i5] != 0) {
                        break;
                    } else {
                        i5--;
                    }
                }
                if (i3 > 255) {
                    i3 = 255;
                } else {
                    i4 = i5;
                }
                this.f9823de.e(c2Var, this.qw, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), this.f9829th, Boolean.valueOf(this.f9827pf)});
            } else if (i2 == 2) {
                this.f9823de.e(c2Var, this.qw, new Object[]{this.f9830uk});
            } else if (i2 == 3) {
                this.f9823de.e(c2Var, this.qw, new Object[]{this.f9831yj, Boolean.valueOf(this.f9827pf)});
            } else if (i2 == 5) {
                this.f9823de.e(c2Var, this.qw, (Object[]) null);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public final boolean qw() {
        return this.f9825i == 3 && this.f9824fe.L() != null;
    }

    public s0 rg() {
        return this.f9822ad;
    }

    public final GlyphRepositioner th() {
        Language M = this.f9824fe.M();
        if (M == null) {
            throw new IllegalArgumentException("The supported language field cannot be null in " + this.f9824fe.getClass().getName());
        } else if (qw.qw[M.ordinal()] != 1) {
            return null;
        } else {
            return new ad(Collections.unmodifiableMap(this.f9824fe.s), this.f9824fe.L());
        }
    }

    public void uk(boolean z) {
        this.f9827pf = z;
    }

    public l0 yj() {
        return this.qw;
    }
}
