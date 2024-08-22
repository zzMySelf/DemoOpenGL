package fe.mmm.qw.p024if.fe;

import android.app.Application;
import com.google.common.net.MediaType;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("ScanProcessingBackgroundChannel")
/* renamed from: fe.mmm.qw.if.fe.de  reason: invalid package */
public final class de extends ad {
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Application f7869uk;

    /* renamed from: fe.mmm.qw.if.fe.de$ad */
    public static final class ad implements MethodChannel.Result {
        public void error(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
            LoggerKt.d$default("任务移除错误, errorCode=" + str + "，errorMessage=" + str2, (Object) null, 1, (Object) null);
        }

        public void notImplemented() {
            LoggerKt.d$default("任务移除错误, 方法未实现", (Object) null, 1, (Object) null);
        }

        public void success(@Nullable Object obj) {
            LoggerKt.d$default("任务移除成功, result=" + obj, (Object) null, 1, (Object) null);
        }
    }

    /* renamed from: fe.mmm.qw.if.fe.de$qw */
    public static final class qw implements MethodChannel.Result {
        public void error(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
            LoggerKt.d$default("任务添加错误, errorCode=" + str + "，errorMessage=" + str2, (Object) null, 1, (Object) null);
        }

        public void notImplemented() {
            LoggerKt.d$default("任务添加错误, 方法未实现", (Object) null, 1, (Object) null);
        }

        public void success(@Nullable Object obj) {
            LoggerKt.d$default("任务添加成功, result=" + obj, (Object) null, 1, (Object) null);
        }
    }

    public de(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.f7869uk = application;
    }

    public final void fe(@NotNull List<? extends Map<String, ? extends Object>> list, int i2) {
        Intrinsics.checkNotNullParameter(list, "scanImage");
        de(this.f7869uk, "addProcessingTask", MapsKt__MapsKt.mapOf(TuplesKt.to(OCRRectifyActivity.EXTRA_AI_SCAN_IMAGES, list), TuplesKt.to(OCRRectifyActivity.EXTRA_CATEGORY, Integer.valueOf(i2))), new qw());
    }

    @NotNull
    public String qw() {
        return "com.baidu.netdisk/scan_processing_background_channel";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.getPlugins();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean rg() {
        /*
            r2 = this;
            com.idlefish.flutterboost.FlutterBoost r0 = com.idlefish.flutterboost.FlutterBoost.yj()
            io.flutter.embedding.engine.FlutterEngine r0 = r0.rg()
            if (r0 == 0) goto L_0x0017
            io.flutter.embedding.engine.plugins.PluginRegistry r0 = r0.getPlugins()
            if (r0 == 0) goto L_0x0017
            java.lang.Class<fe.mmm.qw.if.fe.de> r1 = fe.mmm.qw.p024if.fe.de.class
            io.flutter.embedding.engine.plugins.FlutterPlugin r0 = r0.get(r1)
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p024if.fe.de.rg():boolean");
    }

    public final void th(@NotNull List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "scanImage");
        if (rg()) {
            de(this.f7869uk, "removeProcessingTask", MapsKt__MapsJVMKt.mapOf(TuplesKt.to(OCRRectifyActivity.EXTRA_AI_SCAN_IMAGES, list)), new ad());
        }
    }
}
