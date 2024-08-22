package com.baidu.searchbox.common.security;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "context", "Landroid/content/Context;", "scene", "", "purpose", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8 extends Lambda implements Function3<Context, String, String, DeviceIdBag> {
    public static final DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8 INSTANCE = new DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8();

    public DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8() {
        super(3);
    }

    @NotNull
    public final DeviceIdBag invoke(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        return DeviceInfoManager.qw.j(context, str, str2);
    }
}
