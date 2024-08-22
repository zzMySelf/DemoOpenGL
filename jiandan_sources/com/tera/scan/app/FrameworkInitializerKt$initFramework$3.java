package com.tera.scan.app;

import com.tera.scan.framework.framework.FrameworkDevice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/framework/framework/FrameworkDevice;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FrameworkInitializerKt$initFramework$3 extends Lambda implements Function0<FrameworkDevice> {
    public static final FrameworkInitializerKt$initFramework$3 INSTANCE = new FrameworkInitializerKt$initFramework$3();

    public static final class qw implements FrameworkDevice {
        public void ad(@NotNull String str, int i2) {
            Intrinsics.checkNotNullParameter(str, "key");
        }

        public int qw(@NotNull String str, int i2) {
            Intrinsics.checkNotNullParameter(str, "key");
            return i2;
        }
    }

    public FrameworkInitializerKt$initFramework$3() {
        super(0);
    }

    @NotNull
    public final FrameworkDevice invoke() {
        return new qw();
    }
}
