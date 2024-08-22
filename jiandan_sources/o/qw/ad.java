package o.qw;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.List;

public class ad implements MethodChannel.MethodCallHandler {

    /* renamed from: ad  reason: collision with root package name */
    public final MethodChannel f6481ad;

    /* renamed from: th  reason: collision with root package name */
    public final List<qw> f6482th = new ArrayList();

    /* renamed from: uk  reason: collision with root package name */
    public FlutterPlugin.FlutterPluginBinding f6483uk;
    @Deprecated

    /* renamed from: yj  reason: collision with root package name */
    public PluginRegistry.Registrar f6484yj;

    public ad(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f6483uk = flutterPluginBinding;
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "FilterFactory");
        this.f6481ad = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("create")) {
            int size = this.f6482th.size();
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f6483uk;
            qw qwVar = flutterPluginBinding != null ? new qw(flutterPluginBinding, size) : null;
            PluginRegistry.Registrar registrar = this.f6484yj;
            if (registrar != null) {
                qwVar = new qw(registrar, size);
            }
            if (qwVar == null) {
                result.error("Engine not initialized", (String) null, (Object) null);
                return;
            }
            this.f6482th.add(qwVar);
            result.success(Integer.valueOf(size));
        } else if (methodCall.method.equals("dispose")) {
            Object obj = methodCall.arguments;
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                if (intValue >= this.f6482th.size() || intValue < 0) {
                    result.error("Invalid range", (String) null, (Object) null);
                    return;
                }
                this.f6482th.remove(intValue).m671switch();
                result.success((Object) null);
                return;
            }
            result.error("Invalid argument", (String) null, (Object) null);
        } else {
            result.notImplemented();
        }
    }
}
