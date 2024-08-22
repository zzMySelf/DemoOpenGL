package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.jrai.flutter_keyboard_visibility.FlutterKeyboardVisibilityPlugin;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.tera.scan.flutter.document_tool.DocumentToolPlugin;
import com.tera.scan.flutter.file_operations.FileOperationsPlugin;
import com.tera.scan.flutter.file_transfer.FileTransferPlugin;
import com.tera.scan.flutter.file_viewer.FileViewerPlugin;
import com.tera.scan.flutter.netdisk_db_access.NetdiskDbAccessPlugin;
import com.tera.scan.flutter.netdisk_router.NetdiskRouterPlugin;
import com.tera.scan.flutter.netdisk_toast.NetdiskToastPlugin;
import com.tera.scan.flutter.share_channel.ShareChannelPlugin;
import com.tera.scan.flutter.statistics.StatisticsPlugin;
import fe.mmm.qw.p024if.de.qw;
import fe.p036switch.qw.e;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.connectivity.ConnectivityPlugin;
import io.flutter.plugins.deviceinfo.DeviceInfoPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.share.SharePlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import th.ad.qw.qw.qw.de;

@Keep
public final class GeneratedPluginRegistrant {
    public static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new qw());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin account_channel, com.tera.scan.flutter.account_channel.AccountChannelPlugin", e);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.o.qw.qw());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin bitmap, com.example.bitmap.BitmapPlugin", e2);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.mmm.qw.p024if.rg.qw());
        } catch (Exception e3) {
            Log.e(TAG, "Error registering plugin commerce_channel, com.tera.scan.flutter.commerce_channel.CommerceChannelPlugin", e3);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.mmm.qw.p024if.th.qw());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin config, com.tera.scan.flutter.config.ConfigPlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ConnectivityPlugin());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin connectivity, io.flutter.plugins.connectivity.ConnectivityPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DeviceInfoPlugin());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin device_info, io.flutter.plugins.deviceinfo.DeviceInfoPlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DocumentToolPlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin document_tool, com.tera.scan.flutter.document_tool.DocumentToolPlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FileOperationsPlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin file_operations, com.tera.scan.flutter.file_operations.FileOperationsPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FileTransferPlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin file_transfer, com.tera.scan.flutter.file_transfer.FileTransferPlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FileViewerPlugin());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin file_viewer, com.tera.scan.flutter.file_viewer.FileViewerPlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new e());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin flutter_boost, com.idlefish.flutterboost.FlutterBoostPlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new InAppWebViewFlutterPlugin());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin flutter_inappwebview, com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterKeyboardVisibilityPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin flutter_keyboard_visibility, com.jrai.flutter_keyboard_visibility.FlutterKeyboardVisibilityPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.o.ad.qw());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin flutter_native_image, com.example.flutternativeimage.FlutterNativeImagePlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterAndroidLifecyclePlugin());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new de());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin fluttertoast, io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.mmm.qw.p024if.i.qw());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin gpu_image, com.tera.scan.flutter.gpu_image.GPUImagePlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ImagePickerPlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin image_picker, io.flutter.plugins.imagepicker.ImagePickerPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.ppp.qw.qw());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin leak_detector, com.ljk.leak_detector.LeakDetectorPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new o.qw.de());
        } catch (Exception e20) {
            Log.e(TAG, "Error registering plugin native_filters, nd.nativefilters.NativeFiltersPlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.mmm.qw.p024if.o.qw());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin netdisk_basic_ability, com.tera.scan.flutter.netdisk_basic_ability.NetdiskBasicAbilityPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new NetdiskDbAccessPlugin());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin netdisk_db_access, com.tera.scan.flutter.netdisk_db_access.NetdiskDbAccessPlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new NetdiskRouterPlugin());
        } catch (Exception e23) {
            Log.e(TAG, "Error registering plugin netdisk_router, com.tera.scan.flutter.netdisk_router.NetdiskRouterPlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new NetdiskToastPlugin());
        } catch (Exception e24) {
            Log.e(TAG, "Error registering plugin netdisk_toast, com.tera.scan.flutter.netdisk_toast.NetdiskToastPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PathProviderPlugin());
        } catch (Exception e25) {
            Log.e(TAG, "Error registering plugin path_provider, io.flutter.plugins.pathprovider.PathProviderPlugin", e25);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SharePlugin());
        } catch (Exception e26) {
            Log.e(TAG, "Error registering plugin share, io.flutter.plugins.share.SharePlugin", e26);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ShareChannelPlugin());
        } catch (Exception e27) {
            Log.e(TAG, "Error registering plugin share_channel, com.tera.scan.flutter.share_channel.ShareChannelPlugin", e27);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new io.flutter.plugins.systemshare.SharePlugin());
        } catch (Exception e28) {
            Log.e(TAG, "Error registering plugin share_system, io.flutter.plugins.systemshare.SharePlugin", e28);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SharedPreferencesPlugin());
        } catch (Exception e29) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e29);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new fe.nn.qw.de());
        } catch (Exception e30) {
            Log.e(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e30);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new StatisticsPlugin());
        } catch (Exception e31) {
            Log.e(TAG, "Error registering plugin statistics, com.tera.scan.flutter.statistics.StatisticsPlugin", e31);
        }
    }
}
