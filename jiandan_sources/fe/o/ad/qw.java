package fe.o.ad;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public class qw implements FlutterPlugin {

    /* renamed from: ad  reason: collision with root package name */
    public MethodChannel f4629ad;

    public final void ad() {
        this.f4629ad.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f4629ad = null;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        qw(flutterPluginBinding.getFlutterEngine().getDartExecutor(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        ad();
    }

    public final void qw(BinaryMessenger binaryMessenger, Context context) {
        this.f4629ad = new MethodChannel(binaryMessenger, "flutter_native_image");
        this.f4629ad.setMethodCallHandler(new ad(context));
    }
}
