package io.flutter.plugins.deviceinfo;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMethodCodec;

public class DeviceInfoPlugin implements FlutterPlugin {
    public static final String TAG = "DeviceInfoPlugin";
    public MethodChannel channel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new DeviceInfoPlugin().setupMethodChannel(registrar.messenger(), registrar.context());
    }

    private void setupMethodChannel(BinaryMessenger binaryMessenger, Context context) {
        try {
            Class<?> cls = Class.forName("io.flutter.plugin.common.MethodChannel");
            Class<?> cls2 = Class.forName("io.flutter.plugin.common.BinaryMessenger$TaskQueue");
            Object invoke = binaryMessenger.getClass().getMethod("makeBackgroundTaskQueue", new Class[0]).invoke(binaryMessenger, new Object[0]);
            this.channel = (MethodChannel) cls.getConstructor(new Class[]{BinaryMessenger.class, String.class, MethodCodec.class, cls2}).newInstance(new Object[]{binaryMessenger, "plugins.flutter.io/device_info", StandardMethodCodec.INSTANCE, invoke});
        } catch (Exception unused) {
            this.channel = new MethodChannel(binaryMessenger, "plugins.flutter.io/device_info");
        }
        this.channel.setMethodCallHandler(new MethodCallHandlerImpl(context.getContentResolver(), context.getPackageManager()));
    }

    private void tearDownChannel() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setupMethodChannel(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        tearDownChannel();
    }
}
