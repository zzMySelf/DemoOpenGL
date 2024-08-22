package io.flutter.embedding.engine.plugins;

import android.content.Context;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.TextureRegistry;

public interface FlutterPlugin {

    public interface FlutterAssets {
        String getAssetFilePathByName(@NonNull String str);

        String getAssetFilePathByName(@NonNull String str, @NonNull String str2);

        String getAssetFilePathBySubpath(@NonNull String str);

        String getAssetFilePathBySubpath(@NonNull String str, @NonNull String str2);
    }

    public static class FlutterPluginBinding {
        public final Context applicationContext;
        public final BinaryMessenger binaryMessenger;
        public final FlutterAssets flutterAssets;
        public final FlutterEngine flutterEngine;
        public final PlatformViewRegistry platformViewRegistry;
        public final TextureRegistry textureRegistry;

        public FlutterPluginBinding(@NonNull Context context, @NonNull FlutterEngine flutterEngine2, @NonNull BinaryMessenger binaryMessenger2, @NonNull TextureRegistry textureRegistry2, @NonNull PlatformViewRegistry platformViewRegistry2, @NonNull FlutterAssets flutterAssets2) {
            this.applicationContext = context;
            this.flutterEngine = flutterEngine2;
            this.binaryMessenger = binaryMessenger2;
            this.textureRegistry = textureRegistry2;
            this.platformViewRegistry = platformViewRegistry2;
            this.flutterAssets = flutterAssets2;
        }

        @NonNull
        public Context getApplicationContext() {
            return this.applicationContext;
        }

        @NonNull
        public BinaryMessenger getBinaryMessenger() {
            return this.binaryMessenger;
        }

        @NonNull
        public FlutterAssets getFlutterAssets() {
            return this.flutterAssets;
        }

        @NonNull
        @Deprecated
        public FlutterEngine getFlutterEngine() {
            return this.flutterEngine;
        }

        @NonNull
        public PlatformViewRegistry getPlatformViewRegistry() {
            return this.platformViewRegistry;
        }

        @NonNull
        public TextureRegistry getTextureRegistry() {
            return this.textureRegistry;
        }
    }

    void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding);

    void onDetachedFromEngine(@NonNull FlutterPluginBinding flutterPluginBinding);
}
