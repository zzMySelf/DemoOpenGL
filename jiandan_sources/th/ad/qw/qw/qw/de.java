package th.ad.qw.qw.qw;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de implements FlutterPlugin {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public MethodChannel f10456ad;

    public final void ad() {
        MethodChannel methodChannel = this.f10456ad;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f10456ad = null;
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "binding.binaryMessenger");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "binding.applicationContext");
        qw(binaryMessenger, applicationContext);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "p0");
        ad();
    }

    public final void qw(@NotNull BinaryMessenger binaryMessenger, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "messenger");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10456ad = new MethodChannel(binaryMessenger, "PonnamKarthik/fluttertoast");
        fe feVar = new fe(context);
        MethodChannel methodChannel = this.f10456ad;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(feVar);
        }
    }
}
