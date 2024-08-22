package fe.fe.ddd.i.ad;

import android.text.TextUtils;
import com.baidu.searchbox.common.security.DeviceInfoUtilKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class ad {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public String f1446ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public String f1447de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public String f1448fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public String f1449i;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public String f1450o;
    @Nullable
    public String qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public String f1451rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public String f1452th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public String f1453uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public String f1454yj;

    public final void ad(@Nullable String str, int i2) {
        if (i2 == 1) {
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                str = DeviceInfoUtilKt.ad(str);
            }
            this.qw = str;
        } else if (i2 == 2) {
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                str = DeviceInfoUtilKt.ad(str);
            }
            this.f1446ad = str;
        } else if (i2 == 4) {
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                str = DeviceInfoUtilKt.ad(str);
            }
            this.f1447de = str;
        } else if (i2 == 8) {
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                str = DeviceInfoUtilKt.ad(str);
            }
            this.f1448fe = str;
        } else if (i2 == 16) {
            this.f1451rg = str;
        } else if (i2 == 32) {
            this.f1452th = str;
        } else if (i2 == 64) {
            this.f1454yj = str;
        } else if (i2 == 128) {
            this.f1453uk = str;
        } else if (i2 == 256) {
            this.f1449i = str;
        }
    }

    public final void de(@Nullable String str) {
        this.f1450o = str;
    }

    public final boolean qw(int i2, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 == 1) {
            String str2 = this.qw;
            Intrinsics.checkNotNull(str);
            return TextUtils.equals(str2, DeviceInfoUtilKt.ad(str));
        } else if (i2 == 2) {
            String str3 = this.f1446ad;
            Intrinsics.checkNotNull(str);
            return TextUtils.equals(str3, DeviceInfoUtilKt.ad(str));
        } else if (i2 == 4) {
            String str4 = this.f1447de;
            Intrinsics.checkNotNull(str);
            return TextUtils.equals(str4, DeviceInfoUtilKt.ad(str));
        } else if (i2 == 8) {
            String str5 = this.f1448fe;
            Intrinsics.checkNotNull(str);
            return TextUtils.equals(str5, DeviceInfoUtilKt.ad(str));
        } else if (i2 == 16) {
            return TextUtils.equals(this.f1451rg, str);
        } else {
            if (i2 == 32) {
                return TextUtils.equals(this.f1452th, str);
            }
            if (i2 == 64) {
                return TextUtils.equals(this.f1454yj, str);
            }
            if (i2 == 128) {
                return TextUtils.equals(this.f1453uk, str);
            }
            if (i2 != 256) {
                return false;
            }
            return TextUtils.equals(this.f1449i, str);
        }
    }

    @NotNull
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ma", this.qw);
        jSONObject.put("im", this.f1446ad);
        jSONObject.put("ai", this.f1447de);
        jSONObject.put("oa", this.f1448fe);
        jSONObject.put("mo", this.f1451rg);
        jSONObject.put("ov", this.f1452th);
        jSONObject.put("op", this.f1454yj);
        jSONObject.put("hv", this.f1453uk);
        jSONObject.put("mn", this.f1449i);
        jSONObject.put("u", this.f1450o);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }
}
