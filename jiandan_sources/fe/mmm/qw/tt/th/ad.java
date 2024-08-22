package fe.mmm.qw.tt.th;

import android.content.Intent;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static final Set<BarcodeFormat> f8506ad = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[]{BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED});

    /* renamed from: de  reason: collision with root package name */
    public static final Set<BarcodeFormat> f8507de = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);

    /* renamed from: fe  reason: collision with root package name */
    public static final Set<BarcodeFormat> f8508fe;

    /* renamed from: i  reason: collision with root package name */
    public static final Map<String, Set<BarcodeFormat>> f8509i;
    public static final Pattern qw = Pattern.compile(",");

    /* renamed from: rg  reason: collision with root package name */
    public static final Set<BarcodeFormat> f8510rg = EnumSet.of(BarcodeFormat.QR_CODE);

    /* renamed from: th  reason: collision with root package name */
    public static final Set<BarcodeFormat> f8511th = EnumSet.of(BarcodeFormat.DATA_MATRIX);

    /* renamed from: uk  reason: collision with root package name */
    public static final Set<BarcodeFormat> f8512uk = EnumSet.of(BarcodeFormat.PDF_417);

    /* renamed from: yj  reason: collision with root package name */
    public static final Set<BarcodeFormat> f8513yj = EnumSet.of(BarcodeFormat.AZTEC);

    static {
        EnumSet<BarcodeFormat> copyOf = EnumSet.copyOf(f8506ad);
        f8508fe = copyOf;
        copyOf.addAll(f8507de);
        HashMap hashMap = new HashMap();
        f8509i = hashMap;
        hashMap.put("ONE_D_MODE", f8508fe);
        f8509i.put("PRODUCT_MODE", f8506ad);
        f8509i.put("QR_CODE_MODE", f8510rg);
        f8509i.put("DATA_MATRIX_MODE", f8511th);
        f8509i.put("AZTEC_MODE", f8513yj);
        f8509i.put("PDF417_MODE", f8512uk);
    }

    public static Set<BarcodeFormat> ad(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                for (String valueOf : iterable) {
                    noneOf.add(BarcodeFormat.valueOf(valueOf));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f8509i.get(str);
        }
        return null;
    }

    public static Set<BarcodeFormat> qw(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return ad(stringExtra != null ? Arrays.asList(qw.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }
}
