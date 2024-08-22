package com.baidu.searchbox.common.security;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.apollon.restnet.rest.g;
import com.baidu.ubc.UBCManager;
import com.cmic.sso.sdk.e.i;
import com.dlife.ctaccountapi.l;
import fe.fe.ddd.i.ad.ad;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0000\u001a\u001c\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0011H\u0000\u001a$\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0000\u001a&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001b"}, d2 = {"SyncJsonKeyMap", "Landroid/util/SparseArray;", "", "getSyncJsonKeyMap", "()Landroid/util/SparseArray;", "copyFixedInfo", "", "src", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "dst", "Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "deviceFlag", "", "crcSign", "source", "forEachDevice", "iteratorFun", "Lkotlin/Function1;", "isDeviceInfoSyncMapping", "", "cacheDeviceInfo", "newDeviceValue", "toJson", "Lorg/json/JSONObject;", "infoMap", "validInfoList", "", "lib-security-framework_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoUtilKt {
    @NotNull
    public static final SparseArray<String> qw;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(1, g.a);
        sparseArray.put(2, "h");
        sparseArray.put(4, "c");
        sparseArray.put(8, "d");
        sparseArray.put(16, "a");
        sparseArray.put(32, "b");
        sparseArray.put(64, i.a);
        sparseArray.put(128, "k");
        sparseArray.put(256, l.a);
        qw = sparseArray;
    }

    @NotNull
    public static final String ad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, UBCManager.CONTENT_KEY_SOURCE);
        CRC32 crc32 = new CRC32();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        crc32.update(bytes);
        return String.valueOf(crc32.getValue());
    }

    public static final void de(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "iteratorFun");
        for (int i2 = 0; i2 < 9; i2++) {
            function1.invoke(Integer.valueOf(1 << i2));
        }
    }

    @NotNull
    public static final SparseArray<String> fe() {
        return qw;
    }

    public static final void qw(@NotNull DeviceIdBagMap deviceIdBagMap, @NotNull ad adVar, int i2) {
        Intrinsics.checkNotNullParameter(deviceIdBagMap, "src");
        Intrinsics.checkNotNullParameter(adVar, "dst");
        de(new DeviceInfoUtilKt$copyFixedInfo$1(i2, adVar, deviceIdBagMap));
    }

    public static final boolean rg(@Nullable ad adVar, int i2, @Nullable String str) {
        if (adVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return adVar.qw(i2, str);
    }

    @NotNull
    public static final JSONObject th(@NotNull DeviceIdBagMap deviceIdBagMap, int i2, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(deviceIdBagMap, "infoMap");
        Intrinsics.checkNotNullParameter(list, "validInfoList");
        JSONObject jSONObject = new JSONObject();
        de(new DeviceInfoUtilKt$toJson$1(i2, deviceIdBagMap, list, jSONObject));
        return jSONObject;
    }
}
