package fe.fe.fe;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.apollon.heartbeat.a;
import com.baidu.cesium.c.d.d;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public List<rg> f1897ad;
    public d qw;

    public final class ad {
        public static final byte[] qw = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, ExifInterface.WEBP_VP8L_SIGNATURE};

        public static byte[] ad(byte[] bArr) {
            return de(bArr, bArr.length);
        }

        public static byte[] de(byte[] bArr, int i2) {
            byte b;
            int i3;
            int i4 = (i2 / 4) * 3;
            if (i4 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2;
            int i6 = 0;
            while (true) {
                byte b2 = bArr[i5 - 1];
                b = 10;
                if (!(b2 == 10 || b2 == 13 || b2 == 32 || b2 == 9)) {
                    if (b2 != 61) {
                        break;
                    }
                    i6++;
                }
                i5--;
            }
            int i7 = 0;
            byte b3 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i5) {
                byte b4 = bArr[i7];
                if (!(b4 == b || b4 == 13 || b4 == 32 || b4 == 9)) {
                    if (b4 >= 65 && b4 <= 90) {
                        i3 = b4 - 65;
                    } else if (b4 >= 97 && b4 <= 122) {
                        i3 = b4 - 71;
                    } else if (b4 >= 48 && b4 <= 57) {
                        i3 = b4 + 4;
                    } else if (b4 == 43) {
                        i3 = 62;
                    } else if (b4 != 47) {
                        return null;
                    } else {
                        i3 = 63;
                    }
                    b3 = ((byte) i3) | (b3 << 6);
                    if (i9 % 4 == 3) {
                        int i10 = i8 + 1;
                        bArr2[i8] = (byte) ((16711680 & b3) >> Ascii.DLE);
                        int i11 = i10 + 1;
                        bArr2[i10] = (byte) ((65280 & b3) >> 8);
                        bArr2[i11] = (byte) (b3 & 255);
                        i8 = i11 + 1;
                    }
                    i9++;
                }
                i7++;
                b = 10;
            }
            if (i6 > 0) {
                int i12 = b3 << (i6 * 6);
                int i13 = i8 + 1;
                bArr2[i8] = (byte) ((i12 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
                if (i6 == 1) {
                    i8 = i13 + 1;
                    bArr2[i13] = (byte) ((i12 & 65280) >> 8);
                } else {
                    i8 = i13;
                }
            }
            byte[] bArr3 = new byte[i8];
            System.arraycopy(bArr2, 0, bArr3, 0, i8);
            return bArr3;
        }

        public static String qw(byte[] bArr, String str) {
            int length = (bArr.length * 4) / 3;
            byte[] bArr2 = new byte[(length + (length / 76) + 3)];
            int length2 = bArr.length - (bArr.length % 3);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length2; i4 += 3) {
                int i5 = i2 + 1;
                byte[] bArr3 = qw;
                bArr2[i2] = bArr3[(bArr[i4] & 255) >> 2];
                int i6 = i5 + 1;
                int i7 = i4 + 1;
                bArr2[i5] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] & 255) >> 4)];
                int i8 = i6 + 1;
                int i9 = i4 + 2;
                bArr2[i6] = bArr3[((bArr[i7] & Ascii.SI) << 2) | ((bArr[i9] & 255) >> 6)];
                i2 = i8 + 1;
                bArr2[i8] = bArr3[bArr[i9] & 63];
                if ((i2 - i3) % 76 == 0 && i2 != 0) {
                    bArr2[i2] = 10;
                    i3++;
                    i2++;
                }
            }
            int length3 = bArr.length % 3;
            if (length3 == 1) {
                int i10 = i2 + 1;
                byte[] bArr4 = qw;
                bArr2[i2] = bArr4[(bArr[length2] & 255) >> 2];
                int i11 = i10 + 1;
                bArr2[i10] = bArr4[(bArr[length2] & 3) << 4];
                int i12 = i11 + 1;
                bArr2[i11] = 61;
                i2 = i12 + 1;
                bArr2[i12] = 61;
            } else if (length3 == 2) {
                int i13 = i2 + 1;
                byte[] bArr5 = qw;
                bArr2[i2] = bArr5[(bArr[length2] & 255) >> 2];
                int i14 = i13 + 1;
                int i15 = length2 + 1;
                bArr2[i13] = bArr5[((bArr[i15] & 255) >> 4) | ((bArr[length2] & 3) << 4)];
                int i16 = i14 + 1;
                bArr2[i14] = bArr5[(bArr[i15] & Ascii.SI) << 2];
                i2 = i16 + 1;
                bArr2[i16] = 61;
            }
            return new String(bArr2, 0, i2, str);
        }
    }

    public final class de {
        public static String ad(byte[] bArr, boolean z) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bArr);
                return qw(instance.digest(), "", z);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public static String qw(byte[] bArr, String str, boolean z) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
    }

    public final class fe {
        public static byte[] qw(byte[] bArr) {
            try {
                return MessageDigest.getInstance("SHA-1").digest(bArr);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class qw implements Comparator<rg> {
        public qw(th thVar) {
        }

        /* renamed from: qw */
        public int compare(rg rgVar, rg rgVar2) {
            int i2 = rgVar2.f1894ad - rgVar.f1894ad;
            if (i2 == 0) {
                if (rgVar.f1896fe && rgVar2.f1896fe) {
                    return 0;
                }
                if (rgVar.f1896fe) {
                    return -1;
                }
                if (rgVar2.f1896fe) {
                    return 1;
                }
            }
            return i2;
        }
    }

    public th() {
        de();
    }

    public static String qw(byte[] bArr) {
        StringBuilder sb;
        if (bArr != null) {
            String str = "";
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb = new StringBuilder();
                    sb.append(str);
                    str = "0";
                } else {
                    sb = new StringBuilder();
                }
                sb.append(str);
                sb.append(hexString);
                str = sb.toString();
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public static byte[] th(byte[] bArr, d dVar) {
        fe.fe.fe.fe.fe.qw qw2 = fe.fe.fe.fe.fe.qw.qw();
        qw2.ad(2, dVar);
        return qw2.de(bArr);
    }

    public List<rg> ad(Context context, Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo next : queryBroadcastReceivers) {
                ActivityInfo activityInfo = next.activityInfo;
                if (!(activityInfo == null || activityInfo.applicationInfo == null)) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(next.activityInfo.packageName, next.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] ad2 = ad.ad(string.getBytes(a.h));
                                JSONObject jSONObject = new JSONObject(new String(ad2));
                                rg rgVar = new rg();
                                rgVar.f1894ad = jSONObject.getInt("priority");
                                rgVar.qw = next.activityInfo.applicationInfo;
                                if (context.getPackageName().equals(next.activityInfo.applicationInfo.packageName)) {
                                    rgVar.f1896fe = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(next.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i2 = 0; i2 < length; i2++) {
                                            strArr[i2] = jSONArray.getString(i2);
                                        }
                                        if (rg(strArr, yj(packageInfo.signatures))) {
                                            byte[] th2 = th(ad.ad(string2.getBytes()), this.qw);
                                            if (th2 != null && Arrays.equals(th2, fe.qw(ad2))) {
                                                rgVar.f1895de = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(rgVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new qw(this));
        return arrayList;
    }

    public final void de() {
        this.qw = new fe.fe.fe.fe.fe.fe(uk.qw(), uk.ad());
    }

    public boolean fe(Context context) {
        List<rg> ad2 = ad(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
        if (ad2 == null || ad2.size() == 0) {
            for (int i2 = 0; i2 < 3; i2++) {
            }
            return false;
        }
        boolean z = ad2.get(0).f1895de;
        if (!z) {
            for (int i3 = 0; i3 < 3; i3++) {
            }
        }
        return z;
    }

    public final boolean rg(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String add : strArr) {
            hashSet.add(add);
        }
        HashSet hashSet2 = new HashSet();
        for (String add2 : strArr2) {
            hashSet2.add(add2);
        }
        return hashSet.equals(hashSet2);
    }

    public List<rg> uk(Context context) {
        List<rg> list = this.f1897ad;
        if (list != null) {
            return list;
        }
        fe(context);
        List<rg> ad2 = ad(context, new Intent("com.baidu.intent.action.GALAXY"), true);
        this.f1897ad = ad2;
        return ad2;
    }

    public final String[] yj(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = qw(fe.qw(signatureArr[i2].toByteArray()));
        }
        return strArr;
    }
}
