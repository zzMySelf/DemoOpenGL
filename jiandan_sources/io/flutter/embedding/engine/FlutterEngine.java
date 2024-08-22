package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashSet;
import java.util.Set;

public class FlutterEngine {
    public static final String TAG = "FlutterEngine";
    @NonNull
    public final AccessibilityChannel accessibilityChannel;
    @NonNull
    public final DartExecutor dartExecutor;
    @NonNull
    public final DeferredComponentChannel deferredComponentChannel;
    @NonNull
    public final EngineLifecycleListener engineLifecycleListener;
    @NonNull
    public final Set<EngineLifecycleListener> engineLifecycleListeners;
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    public final KeyEventChannel keyEventChannel;
    @NonNull
    public final LifecycleChannel lifecycleChannel;
    @NonNull
    public final LocalizationChannel localizationChannel;
    @NonNull
    public final LocalizationPlugin localizationPlugin;
    @NonNull
    public final MouseCursorChannel mouseCursorChannel;
    @NonNull
    public final NavigationChannel navigationChannel;
    @NonNull
    public final PlatformChannel platformChannel;
    @NonNull
    public final PlatformViewsController platformViewsController;
    @NonNull
    public final FlutterEngineConnectionRegistry pluginRegistry;
    @NonNull
    public final FlutterRenderer renderer;
    @NonNull
    public final RestorationChannel restorationChannel;
    @NonNull
    public final SettingsChannel settingsChannel;
    @NonNull
    public final SystemChannel systemChannel;
    @NonNull
    public final TextInputChannel textInputChannel;

    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    public FlutterEngine(@NonNull Context context) {
        this(context, (String[]) null);
    }

    private void attachToJni() {
        Log.v(TAG, "Attaching to JNI.");
        this.flutterJNI.attachToNative();
        if (!isAttachedToJni()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean isAttachedToJni() {
        return this.flutterJNI.isAttached();
    }

    public void addEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener2) {
        this.engineLifecycleListeners.add(engineLifecycleListener2);
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        for (EngineLifecycleListener onEngineWillDestroy : this.engineLifecycleListeners) {
            onEngineWillDestroy.onEngineWillDestroy();
        }
        this.pluginRegistry.destroy();
        this.platformViewsController.onDetachedFromJNI();
        this.dartExecutor.onDetachedFromJNI();
        this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
        this.flutterJNI.setDeferredComponentManager((DeferredComponentManager) null);
        this.flutterJNI.detachFromNativeAndReleaseResources();
        if (FlutterInjector.instance().deferredComponentManager() != null) {
            FlutterInjector.instance().deferredComponentManager().destroy();
            this.deferredComponentChannel.setDeferredComponentManager((DeferredComponentManager) null);
        }
    }

    @NonNull
    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    @NonNull
    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    @NonNull
    public DeferredComponentChannel getDeferredComponentChannel() {
        return this.deferredComponentChannel;
    }

    @NonNull
    public KeyEventChannel getKeyEventChannel() {
        return this.keyEventChannel;
    }

    @NonNull
    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    @NonNull
    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    @NonNull
    public LocalizationPlugin getLocalizationPlugin() {
        return this.localizationPlugin;
    }

    @NonNull
    public MouseCursorChannel getMouseCursorChannel() {
        return this.mouseCursorChannel;
    }

    @NonNull
    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    @NonNull
    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    @NonNull
    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    @NonNull
    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    @NonNull
    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    @NonNull
    public RestorationChannel getRestorationChannel() {
        return this.restorationChannel;
    }

    @NonNull
    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    @NonNull
    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    @NonNull
    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    public void removeEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener2) {
        this.engineLifecycleListeners.remove(engineLifecycleListener2);
    }

    @NonNull
    public FlutterEngine spawn(@NonNull Context context, @NonNull DartExecutor.DartEntrypoint dartEntrypoint, @Nullable String str) {
        if (isAttachedToJni()) {
            return new FlutterEngine(context, (FlutterLoader) null, this.flutterJNI.spawn(dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, str));
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, true);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, z);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z, boolean z2) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, new PlatformViewsController(), strArr, z, z2);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2) {
        this(context, flutterLoader, flutterJNI2, (String[]) null, true);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI2, new PlatformViewsController(), strArr, z);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2, @NonNull PlatformViewsController platformViewsController2, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI2, platformViewsController2, strArr, z, false);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI2, @NonNull PlatformViewsController platformViewsController2, @Nullable String[] strArr, boolean z, boolean z2) {
        AssetManager assetManager;
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener() {
            public void onEngineWillDestroy() {
            }

            public void onPreEngineRestart() {
                Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                for (EngineLifecycleListener onPreEngineRestart : FlutterEngine.this.engineLifecycleListeners) {
                    onPreEngineRestart.onPreEngineRestart();
                }
                FlutterEngine.this.platformViewsController.onPreEngineRestart();
                FlutterEngine.this.restorationChannel.clearData();
            }
        };
        try {
            assetManager = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assetManager = context.getAssets();
        }
        FlutterInjector instance = FlutterInjector.instance();
        flutterJNI2 = flutterJNI2 == null ? instance.getFlutterJNIFactory().provideFlutterJNI() : flutterJNI2;
        this.flutterJNI = flutterJNI2;
        DartExecutor dartExecutor2 = new DartExecutor(flutterJNI2, assetManager);
        this.dartExecutor = dartExecutor2;
        dartExecutor2.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.accessibilityChannel = new AccessibilityChannel(this.dartExecutor, flutterJNI2);
        this.deferredComponentChannel = new DeferredComponentChannel(this.dartExecutor);
        this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
        this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
        this.localizationChannel = new LocalizationChannel(this.dartExecutor);
        this.mouseCursorChannel = new MouseCursorChannel(this.dartExecutor);
        this.navigationChannel = new NavigationChannel(this.dartExecutor);
        this.platformChannel = new PlatformChannel(this.dartExecutor);
        this.restorationChannel = new RestorationChannel(this.dartExecutor, z2);
        this.settingsChannel = new SettingsChannel(this.dartExecutor);
        this.systemChannel = new SystemChannel(this.dartExecutor);
        this.textInputChannel = new TextInputChannel(this.dartExecutor);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(this.deferredComponentChannel);
        }
        this.localizationPlugin = new LocalizationPlugin(context, this.localizationChannel);
        flutterLoader = flutterLoader == null ? instance.flutterLoader() : flutterLoader;
        if (!flutterJNI2.isAttached()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context, strArr);
        }
        flutterJNI2.addEngineLifecycleListener(this.engineLifecycleListener);
        flutterJNI2.setPlatformViewsController(platformViewsController2);
        flutterJNI2.setLocalizationPlugin(this.localizationPlugin);
        flutterJNI2.setDeferredComponentManager(instance.deferredComponentManager());
        if (!flutterJNI2.isAttached()) {
            attachToJni();
        }
        this.renderer = new FlutterRenderer(flutterJNI2);
        this.platformViewsController = platformViewsController2;
        platformViewsController2.onAttachedToJNI();
        this.pluginRegistry = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader);
        if (z && flutterLoader.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
    }
}
